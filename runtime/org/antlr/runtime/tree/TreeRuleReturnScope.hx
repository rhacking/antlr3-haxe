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

import org.antlr.runtime.RuleReturnScope;

/** This is identical to the ParserRuleReturnScope except that
	 *  the start property is a tree nodes not Token object
	 *  when you are parsing trees.  To be generic the tree node types
	 *  have to be Object.
	 */
class TreeRuleReturnScope extends RuleReturnScope
{
    public var tree(never, set) : Dynamic;
    public var values(get, never) : Dynamic;
    public var start(never, set) : Dynamic;

    
    /** First node or root node of tree matched for this rule. */
    private var _start : Dynamic;
    private var _tree : Dynamic;  // if output=AST this contains the tree  
    private var _values : Dynamic = {};  // contains the return values  
    
    /** Has a value potentially if output=AST; */
    override private function get_tree() : Dynamic
    {
        return _tree;
    }
    
    private function set_tree(tree : Dynamic) : Dynamic
    {
        _tree = tree;
        return tree;
    }
    
    private function get_values() : Dynamic
    {
        return _values;
    }
    
    override private function get_start() : Dynamic
    {
        return _start;
    }
    
    private function set_start(value : Dynamic) : Dynamic
    {
        _start = value;
        return value;
    }

    public function new()
    {
        super();
    }
}
