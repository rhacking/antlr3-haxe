
package org.antlr.runtime.tree;

import flash.errors.Error;

/** Queues up nodes matched on left side of -> in a tree parser. This is
 *  the analog of RewriteRuleTokenStream for normal parsers. 
 */
class RewriteRuleNodeStream extends RewriteRuleElementStream
{
    
    public function new(adaptor : TreeAdaptor, elementDescription : String, element : Dynamic = null)
    {
        super(adaptor, elementDescription, element);
    }
    
    public function nextNode() : Dynamic
    {
        return _next();
    }
    
    override private function toTree(el : Dynamic) : Dynamic
    {
        return adaptor.dupNode(el);
    }
    
    override private function dup(el : Dynamic) : Dynamic
    {
        // we dup every node, so don't have to worry about calling dup; short-
        // circuited next() so it doesn't call.
        throw ("dup can't be called for a node stream.");
    }
}
