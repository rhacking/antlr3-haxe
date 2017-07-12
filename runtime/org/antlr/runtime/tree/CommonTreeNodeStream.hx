/*
[The "BSD licence"]
Copyright (c) 2005-2006 Terence Parr
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in the
documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.runtime.tree;

import org.antlr.runtime.TokenConstants;
import org.antlr.runtime.TokenStream;

/** A buffered stream of tree nodes.  Nodes can be from a tree of ANY kind.
	 *
	 *  This node stream sucks all nodes out of the tree specified in
	 *  the constructor during construction and makes pointers into
	 *  the tree using an array of Object pointers. The stream necessarily
	 *  includes pointers to DOWN and UP and EOF nodes.
	 *
	 *  This stream knows how to mark/release for backtracking.
	 *
	 *  This stream is most suitable for tree interpreters that need to
	 *  jump around a lot or for tree parsers requiring speed (at cost of memory).
	 *  There is some duplicated functionality here with UnBufferedTreeNodeStream
	 *  but just in bookkeeping, not tree walking etc...
	 *
	 *  @see UnBufferedTreeNodeStream
	 */
class CommonTreeNodeStream implements TreeNodeStream
{
    public var currentSymbol(get, never) : Dynamic;
    public var treeSource(get, never) : Dynamic;
    public var sourceName(get, never) : String;
    public var tokenStream(get, set) : TokenStream;
    public var treeAdaptor(get, set) : TreeAdaptor;
    public var hasUniqueNavigationNodes(get, set) : Bool;
    public var index(get, never) : Int;
    public var size(get, never) : Int;

    public static inline var DEFAULT_INITIAL_BUFFER_SIZE : Int = 100;
    public static inline var INITIAL_CALL_STACK_SIZE : Int = 10;
    
    // all these navigation nodes are shared and hence they
    // cannot contain any line/column info
    
    private var down : Dynamic;
    private var up : Dynamic;
    private var eof : Dynamic;
    
    /** The complete mapping from stream index to tree node.
		 *  This buffer includes pointers to DOWN, UP, and EOF nodes.
		 *  It is built upon ctor invocation.  The elements are type
		 *  Object as we don't what the trees look like.
		 *
		 *  Load upon first need of the buffer so we can set token types
		 *  of interest for reverseIndexing.  Slows us down a wee bit to
		 *  do all of the if p==-1 testing everywhere though.
		 */
    private var nodes : Array<Dynamic>;
    
    /** Pull nodes from which tree? */
    private var root : Dynamic;
    
    /** IF this tree (root) was created from a token stream, track it. */
    private var tokens : TokenStream;
    
    /** What tree adaptor was used to build these trees */
    @:allow(org.antlr.runtime.tree)
    private var adaptor : TreeAdaptor;
    
    /** Reuse same DOWN, UP navigation nodes unless this is true */
    private var uniqueNavigationNodes : Bool = false;
    
    /** The index into the nodes list of the current node (next node
		 *  to consume).  If -1, nodes array not filled yet.
		 */
    private var p : Int = -1;
    
    /** Track the last mark() call result value for use in rewind(). */
    private var lastMarker : Int;
    
    /** Stack of indexes used for push/pop calls */
    private var calls : Array<Dynamic>;
    
    public function new(tree : Dynamic, adaptor : TreeAdaptor = null, initialBufferSize : Int = DEFAULT_INITIAL_BUFFER_SIZE)
    {
        if (tree == null)
        {
            // return uninitalized for static resuse function
            return;
        }
        this.root = tree;
        this.adaptor = (adaptor == null) ? new CommonTreeAdaptor() : adaptor;
        
        nodes = new Array<Dynamic>();
        down = this.adaptor.createFromType(TokenConstants.DOWN, "DOWN");
        up = this.adaptor.createFromType(TokenConstants.UP, "UP");
        eof = this.adaptor.createFromType(TokenConstants.EOF, "EOF");
    }
    
    /** Reuse an existing node stream's buffer of nodes.  Do not point at a
     *  node stream that can change.  Must have static node list.  start/stop
     *  are indexes into the parent.nodes stream.  We avoid making a new
     *  list of nodes like this.
     */
    public static function reuse(parent : CommonTreeNodeStream, start : Int, stop : Int) : CommonTreeNodeStream
    {
        var stream : CommonTreeNodeStream = new CommonTreeNodeStream(null);
        stream.root = parent.root;
        stream.adaptor = parent.adaptor;
        stream.nodes = parent.nodes.slice(start, stop);
        stream.down = parent.down;
        stream.up = parent.up;
        stream.eof = parent.eof;
        return stream;
    }
    
    /** Walk tree with depth-first-search and fill nodes buffer.
		 *  Don't do DOWN, UP nodes if its a list (t is isNil).
		 */
    private function fillBuffer() : Void
    {
        fillBufferTo(root);
        //System.out.println("revIndex="+tokenTypeToStreamIndexesMap);
        p = 0;
    }
    
    public function fillBufferTo(t : Dynamic) : Void
    {
        var nil : Bool = adaptor.isNil(t);
        if (!nil)
        {
            nodes.push(t);
        }
        // add DOWN node if t has children
        var n : Int = adaptor.getChildCount(t);
        if (!nil && n > 0)
        {
            addNavigationNode(TokenConstants.DOWN);
        }
        // and now add all its children
        for (c in 0...n)
        {
            var child : Dynamic = adaptor.getChild(t, c);
            fillBufferTo(child);
        }
        // add UP node if t has children
        if (!nil && n > 0)
        {
            addNavigationNode(TokenConstants.UP);
        }
    }
    
    /** What is the stream index for node? 0..n-1
		 *  Return -1 if node not found.
		 */
    private function getNodeIndex(node : Dynamic) : Int
    {
        if (p == -1)
        {
            fillBuffer();
        }
        for (i in 0...nodes.length)
        {
            var t : Dynamic = nodes[i];
            if (t == node)
            {
                return i;
            }
        }
        return -1;
    }
    
    /** As we flatten the tree, we use UP, DOWN nodes to represent
		 *  the tree structure.  When debugging we need unique nodes
		 *  so instantiate new ones when uniqueNavigationNodes is true.
		 */
    private function addNavigationNode(ttype : Int) : Void
    {
        var navNode : Dynamic = null;
        if (ttype == TokenConstants.DOWN)
        {
            if (hasUniqueNavigationNodes)
            {
                navNode = adaptor.createFromType(TokenConstants.DOWN, "DOWN");
            }
            else
            {
                navNode = down;
            }
        }
        else
        {
            if (hasUniqueNavigationNodes)
            {
                navNode = adaptor.createFromType(TokenConstants.UP, "UP");
            }
            else
            {
                navNode = up;
            }
        }
        nodes.push(navNode);
    }
    
    public function getNode(i : Int) : Dynamic
    {
        if (p == -1)
        {
            fillBuffer();
        }
        return nodes[i];
    }
    
    public function LT(k : Int) : Dynamic
    {
        if (p == -1)
        {
            fillBuffer();
        }
        if (k == 0)
        {
            return null;
        }
        if (k < 0)
        {
            return cast((-k), LB);
        }
        //System.out.print("LT(p="+p+","+k+")=");
        if ((p + k - 1) >= nodes.length)
        {
            return eof;
        }
        return nodes[p + k - 1];
    }
    
    private function get_currentSymbol() : Dynamic
    {
        return cast((1), LT);
    }
    
    /** Look backwards k nodes */
    private function LB(k : Int) : Dynamic
    {
        if (k == 0)
        {
            return null;
        }
        if ((p - k) < 0)
        {
            return null;
        }
        return nodes[p - k];
    }
    
    private function get_treeSource() : Dynamic
    {
        return root;
    }
    
    private function get_sourceName() : String
    {
        return tokenStream.sourceName;
    }
    
    private function get_tokenStream() : TokenStream
    {
        return tokens;
    }
    
    private function set_tokenStream(tokens : TokenStream) : TokenStream
    {
        this.tokens = tokens;
        return tokens;
    }
    
    private function get_treeAdaptor() : TreeAdaptor
    {
        return adaptor;
    }
    
    private function set_treeAdaptor(adaptor : TreeAdaptor) : TreeAdaptor
    {
        this.adaptor = adaptor;
        return adaptor;
    }
    
    private function get_hasUniqueNavigationNodes() : Bool
    {
        return uniqueNavigationNodes;
    }
    
    private function set_hasUniqueNavigationNodes(uniqueNavigationNodes : Bool) : Bool
    {
        this.uniqueNavigationNodes = uniqueNavigationNodes;
        return uniqueNavigationNodes;
    }
    
    public function consume() : Void
    {
        if (p == -1)
        {
            fillBuffer();
        }
        p++;
    }
    
    public function LA(i : Int) : Int
    {
        return adaptor.getType(cast((i), LT));
    }
    
    public function mark() : Int
    {
        if (p == -1)
        {
            fillBuffer();
        }
        lastMarker = index;
        return lastMarker;
    }
    
    public function release(marker : Int) : Void
    {  // no resources to release  
        
    }
    
    private function get_index() : Int
    {
        return p;
    }
    
    public function rewindTo(marker : Int) : Void
    {
        seek(marker);
    }
    
    public function rewind() : Void
    {
        seek(lastMarker);
    }
    
    public function seek(index : Int) : Void
    {
        if (p == -1)
        {
            fillBuffer();
        }
        p = index;
    }
    
    /** Make stream jump to a new location, saving old location.
		 *  Switch back with pop().
		 */
    public function push(index : Int) : Void
    {
        if (calls == null)
        {
            calls = new Array<Dynamic>();
        }
        calls.push(p);  // save current index  
        seek(index);
    }
    
    /** Seek back to previous index saved during last push() call.
		 *  Return top of stack (return index).
		 */
    public function pop() : Int
    {
        var ret : Int = calls.pop();
        seek(ret);
        return ret;
    }
    
    public function reset() : Void
    {
        p = 0;
        lastMarker = 0;
        if (calls != null)
        {
            calls = new Array<Dynamic>();
        }
    }
    
    private function get_size() : Int
    {
        if (p == -1)
        {
            fillBuffer();
        }
        return nodes.length;
    }
    
    // TREE REWRITE INTERFACE
    public function replaceChildren(parent : Dynamic, startChildIndex : Int, stopChildIndex : Int, t : Dynamic) : Void
    {
        if (parent != null)
        {
            adaptor.replaceChildren(parent, startChildIndex, stopChildIndex, t);
        }
    }
    
    /** Used for testing, just return the token type stream */
    public function toString() : String
    {
        if (p == -1)
        {
            fillBuffer();
        }
        var buf : String = "";
        for (i in 0...nodes.length)
        {
            var t : Dynamic = nodes[i];
            buf += " ";
            buf += (adaptor.getType(t));
        }
        return Std.string(buf);
    }
    
    /** Debugging */
    public function toTokenString(start : Int, stop : Int) : String
    {
        if (p == -1)
        {
            fillBuffer();
        }
        var buf : String = "";
        var i : Int = start;
        while (i < nodes.length && i <= stop)
        {
            var t : Dynamic = nodes[i];
            buf += " ";
            buf += adaptor.getToken(t);
            i++;
        }
        return buf;
    }
    
    public function toStringWithRange(start : Dynamic, stop : Dynamic) : String
    {
        if (start == null || stop == null)
        {
            return null;
        }
        if (p == -1)
        {
            fillBuffer();
        }
        trace("stop: " + stop);
        if (Std.is(start, CommonTree))
        {
            trace("toString: " + cast((start), CommonTree).token + ", ");
        }
        else
        {
            trace(start);
        }
        if (Std.is(stop, CommonTree))
        {
            trace(cast((stop), CommonTree).token);
        }
        else
        {
            trace(stop);
        }
        // if we have the token stream, use that to dump text in order
        if (tokens != null)
        {
            var beginTokenIndex : Int = adaptor.getTokenStartIndex(start);
            var endTokenIndex : Int = adaptor.getTokenStopIndex(stop);
            // if it's a tree, use start/stop index from start node
            // else use token range from start/stop nodes
            if (adaptor.getType(stop) == TokenConstants.UP)
            {
                endTokenIndex = adaptor.getTokenStopIndex(start);
            }
            else
            {
                if (adaptor.getType(stop) == TokenConstants.EOF)
                {
                    endTokenIndex = as3hx.Compat.parseInt(size - 2);
                }
            }
            return tokens.toStringWithRange(beginTokenIndex, endTokenIndex);
        }
        // walk nodes looking for start
        var t : Dynamic = null;
        var i : Int = 0;
                while (i < nodes.length)
        {
            t = nodes[i];
            if (t == start)
            {
                break;
            }
            i++;
        }
        // now walk until we see stop, filling string buffer with text
        var buf : String = "";
        t = nodes[i];
        while (t != stop)
        {
            var text : String = adaptor.getText(t);
            if (text == null)
            {
                text = " " + adaptor.getType(t);
            }
            buf += text;
            i++;
            t = nodes[i];
        }
        // include stop node too
        text = adaptor.getText(stop);
        if (text == null)
        {
            text = " " + adaptor.getType(stop);
        }
        buf += text;
        return Std.string(buf);
    }
}

