package org.antlr.runtime;


/** Rules can return start/stop info as well as possible trees and templates */
class RuleReturnScope
{
    public var start(get, set) : Dynamic;
    function set_start(tree):Dynamic { return null; }
    public var stop(get, set) : Dynamic;
    function set_stop(tree):Dynamic { return null; }
    public var tree(get, set) : org.antlr.runtime.tree.CommonTree;
    function set_tree(tree) { return null; }

    /** Return the start token or tree */
    private function get_start() : Dynamic
    {
        return null;
    }
    /** Return the stop token or tree */
    private function get_stop() : Dynamic
    {
        return null;
    }
    /** Has a value potentially if output=AST; */
    private function get_tree() : Dynamic
    {
        return null;
    }

    public function new()
    {
    }
}

