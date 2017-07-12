package org.antlr.runtime.tree;

import org.antlr.runtime.*;

class CommonErrorNode extends CommonTree
{
    
    public var input : IntStream;
    public var start : Token;
    public var stop : Token;
    public var trappedException : RecognitionException;
    
    public function new(input : TokenStream, start : Token, stop : Token,
            e : RecognitionException)
    {
        super();
        //System.out.println("start: "+start+", stop: "+stop);
        if (stop == null ||
            (stop.tokenIndex < start.tokenIndex &&
            stop.type != TokenConstants.EOF))
        {
            // sometimes resync does not consume a token (when LT(1) is
            // in follow set.  So, stop will be 1 to left to start. adjust.
            // Also handle case where start is the first token and no token
            // is consumed during recovery; LT(-1) will return null.
            stop = start;
        }
        this.input = input;
        this.start = start;
        this.stop = stop;
        this.trappedException = e;
    }
    
    override private function get_isNil() : Bool
    {
        return false;
    }
    
    public function getType() : Int
    {
        return TokenConstants.INVALID_TOKEN_TYPE;
    }
    
    public function getText() : String
    {
        var badText : String = null;
        if (Std.is(start, Token))
        {
            var i : Int = cast((start), Token).tokenIndex;
            var j : Int = cast((stop), Token).tokenIndex;
            if (cast((stop), Token).type == TokenConstants.EOF)
            {
                j = cast((input), TokenStream).size;
            }
            badText = cast((input), TokenStream).toStringWithRange(i, j);
        }
        else
        {
            if (Std.is(start, Tree))
            {
                badText = cast((input), TreeNodeStream).toStringWithRange(start, stop);
            }
            else
            {
                // people should subclass if they alter the tree type so this
                // next one is for sure correct.
                badText = "<unknown>";
            }
        }
        return badText;
    }
    
    override public function toString() : String
    {
        if (Std.is(trappedException, MissingTokenException))
        {
            return "<missing type: " +
            cast((trappedException), MissingTokenException).missingType +
            ">";
        }
        else
        {
            if (Std.is(trappedException, UnwantedTokenException))
            {
                return "<extraneous: " +
                cast((trappedException), UnwantedTokenException).unexpectedToken +
                ", resync=" + getText() + ">";
            }
            else
            {
                if (Std.is(trappedException, MismatchedTokenException))
                {
                    return "<mismatched token: " + trappedException.token + ", resync=" + getText() + ">";
                }
                else
                {
                    if (Std.is(trappedException, NoViableAltException))
                    {
                        return "<unexpected: " + trappedException.token +
                        ", resync=" + getText() + ">";
                    }
                }
            }
        }
        return "<error: " + getText() + ">";
    }
}
