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

import flash.errors.Error;
import org.antlr.runtime.Token;

class RewriteRuleTokenStream extends RewriteRuleElementStream
{
    
    public function new(adaptor : TreeAdaptor, elementDescription : String, element : Dynamic = null)
    {
        super(adaptor, elementDescription, element);
    }
    
    /** Get next token from stream and make a node for it */
    public function nextNode() : Dynamic
    {
        var t : Token = cast((_next()), Token);
        return adaptor.createWithPayload(t);
    }
    
    public function nextToken() : Token
    {
        return cast((_next()), Token);
    }
    
    /** Don't convert to a tree unless they explicitly call nextTree.
    	 *  This way we can do hetero tree nodes in rewrite.
    	 */
    override private function toTree(el : Dynamic) : Dynamic
    {
        return el;
    }
    
    override private function dup(el : Dynamic) : Dynamic
    {
        throw ("dup can't be called for a token stream.");
    }
}
