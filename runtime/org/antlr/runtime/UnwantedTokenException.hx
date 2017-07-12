package org.antlr.runtime;


class UnwantedTokenException extends MismatchedTokenException
{
    public var unexpectedToken(get, never) : Token;

    public function new(expecting : Int, input : IntStream)
    {
        super(expecting, input);
    }
    
    private function get_unexpectedToken() : Token
    {
        return token;
    }
    
    override public function toString() : String
    {
        var exp : String = ", expected " + expecting;
        if (expecting == TokenConstants.INVALID_TOKEN_TYPE)
        {
            exp = "";
        }
        if (token == null)
        {
            return "UnwantedTokenException(found=" + null + exp + ")";
        }
        return "UnwantedTokenException(found=" + token.text + exp + ")";
    }
}
