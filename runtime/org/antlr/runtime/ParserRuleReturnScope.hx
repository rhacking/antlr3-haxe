package org.antlr.runtime;


/** Rules that return more than a single value must return an object
	 *  containing all the values.  Besides the properties defined in
	 *  RuleLabelScope.predefinedRulePropertiesScope there may be user-defined
	 *  return values.  This class simply defines the minimum properties that
	 *  are always defined and methods to access the others that might be
	 *  available depending on output option such as template and tree.
	 *
	 *  Note text is not an actual property of the return value, it is computed
	 *  from start and stop using the input stream's toString() method.  I
	 *  could add a ctor to this so that we can pass in and store the input
	 *  stream, but I'm not sure we want to do that.  It would seem to be undefined
	 *  to get the .text property anyway if the rule matches tokens from multiple
	 *  input streams.
	 *
	 *  I do not use getters for fields of objects that are used simply to
	 *  group values such as this aggregate.
	 */
class ParserRuleReturnScope extends RuleReturnScope
{
    public var values(get, never) : Dynamic;

    private var _startToken : Token;
    private var _stopToken : Token;
    private var _tree : Dynamic;  // if output=AST this contains the tree  
    private var _values : Dynamic = {};  // contains the return values  
    
    override private function get_start() : Dynamic
    {
        return _startToken;
    }
    
    override private function set_start(token : Dynamic) : Dynamic
    {
        _startToken = cast((token), Token);
        return token;
    }
    
    override private function get_stop() : Dynamic
    {
        return _stopToken;
    }
    
    override private function set_stop(token : Dynamic) : Dynamic
    {
        _stopToken = cast((token), Token);
        return token;
    }
    
    /** Has a value potentially if output=AST; */
    override private function get_tree() : org.antlr.runtime.tree.CommonTree
    {
        return _tree;
    }
    
    override private function set_tree(tree : org.antlr.runtime.tree.CommonTree) : org.antlr.runtime.tree.CommonTree
    {
        _tree = tree;
        return tree;
    }
    
    private function get_values() : Dynamic
    {
        return _values;
    }

    public function new()
    {
        super();
    }
}
