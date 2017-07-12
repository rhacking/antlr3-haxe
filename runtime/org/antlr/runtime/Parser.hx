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
package org.antlr.runtime;

import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.BaseRecognizer.*;

/** A parser for TokenStreams.  "parser grammars" result in a subclass
	 *  of this.
	 */
class Parser extends BaseRecognizer
{
    public var tokenStream(get, set) : TokenStream;
    public var treeAdaptor(get, set) : TreeAdaptor;

    private var input : TokenStream;
    
    public function new(input : TokenStream, state : RecognizerSharedState = null)
    {
        super(state);
        tokenStream = input;
    }
    
    override public function reset() : Void
    {
        super.reset();  // reset all recognizer state variables  
        if (input != null)
        {
            input.seek(0);
        }
    }
    
    override private function getCurrentInputSymbol(input : IntStream) : Dynamic
    {
        return cast((input), TokenStream).LT(1);
    }
    
    override private function getMissingSymbol(input : IntStream,
            e : RecognitionException,
            expectedTokenType : Int,
            follow : BitSet) : Dynamic
    {
        var tokenText : String = null;
        if (expectedTokenType == TokenConstants.EOF)
        {
            tokenText = "<missing EOF>";
        }
        else
        {
            tokenText = "<missing " + tokenNames[expectedTokenType] + ">";
        }
        var t : CommonToken = new CommonToken(expectedTokenType, tokenText);
        var current : Token = cast((input), TokenStream).LT(1);
        if (current.type == TokenConstants.EOF)
        {
            current = cast((input), TokenStream).LT(-1);
        }
        t.line = current.line;
        t.charPositionInLine = current.charPositionInLine;
        t.channel = DEFAULT_TOKEN_CHANNEL;
        return t;
    }
    
    /** Set the token stream and reset the parser */
    private function set_tokenStream(input : TokenStream) : TokenStream
    {
        this.input = null;
        reset();
        this.input = input;
        return input;
    }
    
    private function get_tokenStream() : TokenStream
    {
        return input;
    }
    
    override private function get_sourceName() : String
    {
        return input.sourceName;
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

