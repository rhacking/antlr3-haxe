package org.antlr.runtime;


class MissingTokenException extends MismatchedTokenException
{
    public var missingType(get, never) : Int;

    
    public var inserted : Dynamic;
    
    public function new(expecting : Int, input : IntStream, inserted : Dynamic)
    {
        super(expecting, input);
        this.inserted = inserted;
    }
    
    private function get_missingType() : Int
    {
        return expecting;
    }
    
    override public function toString() : String
    {
        if (inserted != null && token != null)
        {
            return "MissingTokenException(inserted " + inserted + " at " + token.text + ")";
        }
        if (token != null)
        {
            return "MissingTokenException(at " + token.text + ")";
        }
        return "MissingTokenException";
    }
}

