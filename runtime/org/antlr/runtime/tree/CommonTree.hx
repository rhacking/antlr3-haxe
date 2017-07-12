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

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenConstants;

/** A tree node that is wrapper for a Token object.  After 3.0 release
	 *  while building tree rewrite stuff, it became clear that computing
	 *  parent and child index is very difficult and cumbersome.  Better to
	 *  spend the space in every tree node.  If you don't want these extra
	 *  fields, it's easy to cut them out in your own BaseTree subclass.
	 */
class CommonTree extends BaseTree
{
    public var token(get, never) : Token;

    /** A single token is the payload */
    private var _token : Token;
    
    /** What token indexes bracket all tokens associated with this node
		 *  and below?
		 */
    public var startIndex : Int = -1;public var stopIndex : Int = -1;
    
    /** Who is the parent node of this node; if null, implies node is root */
    private var _parent : CommonTree;
    
    /** What index is this node in the child list? Range: 0..n-1 */
    private var _childIndex : Int = -1;
    
    public function new(node : CommonTree = null)
    {
        super();
        if (node != null)
        {
            super(node);
            this._token = node._token;
            this.startIndex = node.startIndex;
            this.stopIndex = node.stopIndex;
        }
    }
    
    public static function createFromToken(t : Token) : CommonTree
    {
        var ct : CommonTree = new CommonTree();
        ct._token = t;
        return ct;
    }
    
    private function get_token() : Token
    {
        return _token;
    }
    
    override public function dupNode() : Tree
    {
        return new CommonTree(this);
    }
    
    override private function get_isNil() : Bool
    {
        return _token == null;
    }
    
    override private function get_type() : Int
    {
        if (_token == null)
        {
            return TokenConstants.INVALID_TOKEN_TYPE;
        }
        return _token.type;
    }
    
    override private function get_text() : String
    {
        if (_token == null)
        {
            return null;
        }
        return _token.text;
    }
    
    override private function get_line() : Int
    {
        if (_token == null || _token.line == 0)
        {
            if (childCount > 0)
            {
                return getChild(0).line;
            }
            return 0;
        }
        return _token.line;
    }
    
    override private function get_charPositionInLine() : Int
    {
        if (_token == null || _token.charPositionInLine == -1)
        {
            if (childCount > 0)
            {
                return getChild(0).charPositionInLine;
            }
            return 0;
        }
        return _token.charPositionInLine;
    }
    
    override private function get_tokenStartIndex() : Int
    {
        if (startIndex == -1 && _token != null)
        {
            return _token.tokenIndex;
        }
        return startIndex;
    }
    
    override private function set_tokenStartIndex(index : Int) : Int
    {
        startIndex = index;
        return index;
    }
    
    override private function get_tokenStopIndex() : Int
    {
        if (stopIndex == -1 && _token != null)
        {
            return _token.tokenIndex;
        }
        return stopIndex;
    }
    
    override private function set_tokenStopIndex(index : Int) : Int
    {
        stopIndex = index;
        return index;
    }
    
    override private function get_childIndex() : Int
    {
        return _childIndex;
    }
    
    override private function get_parent() : Tree
    {
        return _parent;
    }
    
    override private function set_parent(t : Tree) : Tree
    {
        if (t == null) return t;
        this._parent = cast((t), CommonTree);
        return t;
    }
    
    override private function set_childIndex(index : Int) : Int
    {
        this._childIndex = index;
        return index;
    }
    
    public function toString() : String
    {
        if (isNil)
        {
            return "nil";
        }
        if (type == TokenConstants.INVALID_TOKEN_TYPE)
        {
            return "<errornode>";
        }
        if (token == null)
        {
            return null;
        }
        return _token.text;
    }
}


