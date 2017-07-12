package org.antlr.runtime;

import org.antlr.runtime.tree.TreeNodeStream;

class MismatchedTreeNodeException extends RecognitionException
{
    public var expecting : Int;
    
    public function new(expecting : Int, input : TreeNodeStream)
    {
        super(input);
        this.expecting = expecting;
    }
    
    public function toString() : String
    {
        return "MismatchedTreeNodeException(" + unexpectedType + "!=" + expecting + ")";
    }
}
