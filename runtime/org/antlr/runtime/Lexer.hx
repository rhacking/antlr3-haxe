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

/** A lexer is recognizer that draws input symbols from a character stream.
	 *  lexer grammars result in a subclass of this object. A Lexer object
	 *  uses simplified match() and error recovery mechanisms in the interest
	 *  of speed.
	 */
class Lexer extends BaseRecognizer implements TokenSource
{
    public var charStream(get, set) : CharStream;
    public var line(get, never) : Int;
    public var charPositionInLine(get, never) : Int;
    public var charIndex(get, never) : Int;
    public var text(get, set) : String;

    /** Where is the lexer drawing characters from? */
    private var input : CharStream;
    
    public function new(input : CharStream = null, state : RecognizerSharedState = null)
    {
        super(state);
        this.input = input;
    }
    
    override public function reset() : Void
    {
        super.reset();  // reset all recognizer state variables  
        // wack Lexer state variables
        if (input != null)
        {
            input.seek(0);
        }
        if (state == null)
        {
            return;
        }
        state.token = null;
        state.type = TokenConstants.INVALID_TOKEN_TYPE;
        state.channel = TokenConstants.DEFAULT_CHANNEL;
        state.tokenStartCharIndex = -1;
        state.tokenStartCharPositionInLine = -1;
        state.tokenStartLine = -1;
        state.text = null;
    }
    
    /** Return a token from this source; i.e., match a token on the char
		 *  stream.
		 */
    public function nextToken() : Token
    {
        while (true)
        {
            state.token = null;
            state.channel = TokenConstants.DEFAULT_CHANNEL;
            state.tokenStartCharIndex = input.index;
            state.tokenStartCharPositionInLine = input.charPositionInLine;
            state.tokenStartLine = input.line;
            state.text = null;
            if (input.LA(1) == CharStreamConstants.EOF)
            {
                return TokenConstants.EOF_TOKEN;
            }
            try
            {
                mTokens();
                if (state.token == null)
                {
                    emit();
                }
                else
                {
                    if (state.token == TokenConstants.SKIP_TOKEN)
                    {
                        continue;
                    }
                }
                return state.token;
            }
            catch (nva : NoViableAltException)
            {
                reportError(nva);
                recover(nva);
            }
            catch (re : RecognitionException)
            {
                reportError(re);
            }
        }
        // Can't happen, but will quiet complier error
        return null;
    }
    
    /** Instruct the lexer to skip creating a token for current lexer rule
		 *  and look for another token.  nextToken() knows to keep looking when
		 *  a lexer rule finishes with token set to SKIP_TOKEN.  Recall that
		 *  if token==null at end of any token rule, it creates one for you
		 *  and emits it.
		 */
    public function skip() : Void
    {
        state.token = TokenConstants.SKIP_TOKEN;
    }
    
    /** This is the lexer entry point that sets instance var 'token' */
    public function mTokens() : Void
    {
        // abstract function
        throw ("Not implemented");
    }
    
    /** Set the char stream and reset the lexer */
    private function set_charStream(input : CharStream) : CharStream
    {
        this.input = null;
        reset();
        this.input = input;
        return input;
    }
    
    private function get_charStream() : CharStream
    {
        return input;
    }
    
    override private function get_sourceName() : String
    {
        return input.sourceName;
    }
    
    /** Currently does not support multiple emits per nextToken invocation
		 *  for efficiency reasons.  Subclass and override this method and
		 *  nextToken (to push tokens into a list and pull from that list rather
		 *  than a single variable as this implementation does).
		 */
    public function emitToken(token : Token) : Void
    {
        state.token = token;
    }
    
    /** The standard method called to automatically emit a token at the
		 *  outermost lexical rule.  The token object should point into the
		 *  char buffer start..stop.  If there is a text override in 'text',
		 *  use that to set the token's text.  Override this method to emit
		 *  custom Token objects.
		 */
    public function emit() : Token
    {
        var t : Token = CommonToken.createFromStream(input, state.type, state.channel, state.tokenStartCharIndex, charIndex - 1);
        t.line = state.tokenStartLine;
        t.text = state.text;
        t.charPositionInLine = state.tokenStartCharPositionInLine;
        emitToken(t);
        return t;
    }
    
    public function matchString(s : String) : Void
    {
        var i : Int = 0;
        while (i < s.length)
        {
            if (input.LA(1) != s.charCodeAt(i))
            {
                if (state.backtracking > 0)
                {
                    state.failed = true;
                    return;
                }
                var mte : MismatchedTokenException = 
                new MismatchedTokenException(s.charCodeAt(i), input);
                recover(mte);
                throw mte;
            }
            i++;
            input.consume();
            state.failed = false;
        }
    }
    
    public function matchAny() : Void
    {
        input.consume();
    }
    
    public function match(c : Int) : Void
    {
        if (input.LA(1) != c)
        {
            if (state.backtracking > 0)
            {
                state.failed = true;
                return;
            }
            var mte : MismatchedTokenException = 
            new MismatchedTokenException(c, input);
            recover(mte);  // don't really recover; just consume in lexer  
            throw mte;
        }
        input.consume();
        state.failed = false;
    }
    
    public function matchRange(a : Int, b : Int) : Void
    {
        if (input.LA(1) < a || input.LA(1) > b)
        {
            if (state.backtracking > 0)
            {
                state.failed = true;
                return;
            }
            var mre : MismatchedRangeException = 
            new MismatchedRangeException(a, b, input);
            recover(mre);
            throw mre;
        }
        input.consume();
        state.failed = false;
    }
    
    private function get_line() : Int
    {
        return input.line;
    }
    
    private function get_charPositionInLine() : Int
    {
        return input.charPositionInLine;
    }
    
    /** What is the index of the current character of lookahead? */
    private function get_charIndex() : Int
    {
        return input.index;
    }
    
    /** Return the text matched so far for the current token or any
		 *  text override.
		 */
    private function get_text() : String
    {
        if (state.text != null)
        {
            return state.text;
        }
        return input.substring(state.tokenStartCharIndex, charIndex - 1);
    }
    
    /** Set the complete text of this token; it wipes any previous
		 *  changes to the text.
		 */
    private function set_text(text : String) : String
    {
        state.text = text;
        return text;
    }
    
    override public function reportError(e : RecognitionException) : Void
    {
        displayRecognitionError(this.tokenNames, e);
    }
    
    override public function getErrorMessage(e : RecognitionException, tokenNames : Array<Dynamic>) : String
    {
        var msg : String = null;
        if (Std.is(e, MismatchedTokenException))
        {
            var mte : MismatchedTokenException = cast((e), MismatchedTokenException);
            msg = "mismatched character " + getCharErrorDisplay(e.c) + " expecting " + getCharErrorDisplay(mte.expecting);
        }
        else
        {
            if (Std.is(e, NoViableAltException))
            {
                var nvae : NoViableAltException = cast((e), NoViableAltException);
                // for development, can add "decision=<<"+nvae.grammarDecisionDescription+">>"
                // and "(decision="+nvae.decisionNumber+") and
                // "state "+nvae.stateNumber
                msg = "no viable alternative at character " + getCharErrorDisplay(e.c);
            }
            else
            {
                if (Std.is(e, EarlyExitException))
                {
                    var eee : EarlyExitException = cast((e), EarlyExitException);
                    // for development, can add "(decision="+eee.decisionNumber+")"
                    msg = "required (...)+ loop did not match anything at character " + getCharErrorDisplay(e.c);
                }
                else
                {
                    if (Std.is(e, MismatchedNotSetException))
                    {
                        var mnse : MismatchedNotSetException = cast((e), MismatchedNotSetException);
                        msg = "mismatched character " + getCharErrorDisplay(e.c) + " expecting set " + mnse.expecting;
                    }
                    else
                    {
                        if (Std.is(e, MismatchedSetException))
                        {
                            var mse : MismatchedSetException = cast((e), MismatchedSetException);
                            msg = "mismatched character " + getCharErrorDisplay(e.c) + " expecting set " + mse.expecting;
                        }
                        else
                        {
                            if (Std.is(e, MismatchedRangeException))
                            {
                                var mre : MismatchedRangeException = cast((e), MismatchedRangeException);
                                msg = "mismatched character " + getCharErrorDisplay(e.c) + " expecting set " +
                                        getCharErrorDisplay(mre.a) + ".." + getCharErrorDisplay(mre.b);
                            }
                            else
                            {
                                msg = super.getErrorMessage(e, tokenNames);
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }
    
    public function getCharErrorDisplay(c : Int) : String
    {
        var s : String = String.fromCharCode(c);
        if (c == TokenConstants.EOF) return "'" + "<EOF>" + "'";
        var utf = new haxe.Utf8();
        utf.addChar(c);
        switch (utf.toString())
        {
            case "\n":
                s = "\\n";
            case "\t":
                s = "\\t";
            case "\r":
                s = "\\r";
        }
        return "'" + s + "'";
    }
    
    /** Lexers can normally match any char in it's vocabulary after matching
		 *  a token, so do the easy thing and just kill a character and hope
		 *  it all works out.  You can instead use the rule invocation stack
		 *  to do sophisticated error recovery if you are in a fragment rule.
		 * 
		 *  @return This method should return the exception it was provided as an
		 *  argument.  This differs from the Java runtime so that an exception variable
		 *  does not need to be declared in the generated code, thus reducing a large
		 *  number of compiler warnings in generated code.
		 */
    public function recover(re : RecognitionException) : RecognitionException
    {
        input.consume();
        return re;
    }
    
    public function traceIn(ruleName : String, ruleIndex : Int) : Void
    {
        var inputSymbol : String = String.fromCharCode(input.LT(1)) + " line=" + line + ":" + charPositionInLine;
        super.traceInSymbol(ruleName, ruleIndex, inputSymbol);
    }
    
    public function traceOut(ruleName : String, ruleIndex : Int) : Void
    {
        var inputSymbol : String = String.fromCharCode(input.LT(1)) + " line=" + line + ":" + charPositionInLine;
        super.traceOutSymbol(ruleName, ruleIndex, inputSymbol);
    }
}
