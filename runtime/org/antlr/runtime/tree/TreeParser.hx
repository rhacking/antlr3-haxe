/*
 [The "BSD licence"]
 Copyright (c) 2005-2007 Terence Parr
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

import org.antlr.runtime.*;

/** A parser for a stream of tree nodes.  "tree grammars" result in a subclass
	 *  of this.  All the error reporting and recovery is shared with Parser via
	 *  the BaseRecognizer superclass.
	*/
class TreeParser extends BaseRecognizer
{
    public var treeNodeStream(get, set) : TreeNodeStream;
    public var treeAdaptor(get, set) : TreeAdaptor;

    public static var DOWN : Int = TokenConstants.DOWN;
    public static var UP : Int = TokenConstants.UP;
    
    private var input : TreeNodeStream;
    
    public function new(input : TreeNodeStream, state : RecognizerSharedState = null)
    {
        super(state);
        treeNodeStream = input;
    }
    
    override public function reset() : Void
    {
        super.reset();  // reset all recognizer state variables  
        if (input != null)
        {
            input.seek(0);
        }
    }
    
    /** Set the input stream */
    private function set_treeNodeStream(input : TreeNodeStream) : TreeNodeStream
    {
        this.input = input;
        return input;
    }
    
    private function get_treeNodeStream() : TreeNodeStream
    {
        return input;
    }
    
    override private function get_sourceName() : String
    {
        return input.sourceName;
    }
    
    override private function getCurrentInputSymbol(input : IntStream) : Dynamic
    {
        return cast((input), TreeNodeStream).LT(1);
    }
    
    override private function getMissingSymbol(input : IntStream,
            e : RecognitionException,
            expectedTokenType : Int,
            follow : BitSet) : Dynamic
    {
        var tokenText : String = 
        "<missing " + tokenNames[expectedTokenType] + ">";
        return CommonTree.createFromToken(new CommonToken(expectedTokenType, tokenText));
    }
    
    /** Match '.' in tree parser has special meaning.  Skip node or
		 *  entire tree if node has children.  If children, scan until
		 *  corresponding UP node.
		 */
    public function matchAny(ignore : IntStream) : Void
    {
        // ignore stream, copy of this.input
        state.errorRecovery = false;
        state.failed = false;
        var look : Dynamic = input.LT(1);
        if (input.treeAdaptor.getChildCount(look) == 0)
        {
            input.consume();  // not subtree, consume 1 node and return  
            return;
        }
        // current node is a subtree, skip to corresponding UP.
        // must count nesting level to get right UP
        var level : Int = 0;
        var tokenType : Int = input.treeAdaptor.getType(look);
        while (tokenType != TokenConstants.EOF && !(tokenType == UP && level == 0))
        {
            input.consume();
            look = input.LT(1);
            tokenType = input.treeAdaptor.getType(look);
            if (tokenType == DOWN)
            {
                level++;
            }
            else
            {
                if (tokenType == UP)
                {
                    level--;
                }
            }
        }
        input.consume();
    }
    
    /** We have DOWN/UP nodes in the stream that have no line info; override.
		 *  plus we want to alter the exception type. Don't try to recover
	 	 *  from tree parser errors inline...
		 */
    override private function mismatch(input : IntStream, ttype : Int, follow : BitSet) : Void
    {
        throw new MismatchedTreeNodeException(ttype, cast((input), TreeNodeStream));
    }
    
    /** Prefix error message with the grammar name because message is
		 *  always intended for the programmer because the parser built
		 *  the input tree not the user.
		 */
    override public function getErrorHeader(e : RecognitionException) : String
    {
        return grammarFileName + ": node from " +
        ((e.approximateLineInfo) ? "after " : "") + "line " + e.line + ":" + e.charPositionInLine;
    }
    
    /** Tree parsers parse nodes they usually have a token object as
		 *  payload. Set the exception token and do the default behavior.
		 */
    override public function getErrorMessage(e : RecognitionException, tokenNames : Array<Dynamic>) : String
    {
        if (Std.is(this, TreeParser))
        {
            var adaptor : TreeAdaptor = cast((e.input), TreeNodeStream).treeAdaptor;
            e.token = adaptor.getToken(e.node);
            if (e.token == null)
            {
                // could be an UP/DOWN node
                e.token = new CommonToken(adaptor.getType(e.node), 
                        adaptor.getText(e.node));
            }
        }
        return super.getErrorMessage(e, tokenNames);
    }
    
    private function set_treeAdaptor(adaptor : TreeAdaptor) : TreeAdaptor
    {  // do nothing, implemented in generated code  
        
        return adaptor;
    }
    
    private function get_treeAdaptor() : TreeAdaptor
    {
        // implementation provided in generated code
        return null;
    }
    
    public function traceIn(ruleName : String, ruleIndex : Int) : Void
    {
        super.traceInSymbol(ruleName, ruleIndex, input.LT(1));
    }
    
    public function traceOut(ruleName : String, ruleIndex : Int) : Void
    {
        super.traceOutSymbol(ruleName, ruleIndex, input.LT(1));
    }
}

