class Main {
    static function main() {
        var lexer = new TestLexer(new org.antlr.runtime.ANTLRStringStream("4 + 3 * 2"));
        var parser = new TestParser(new org.antlr.runtime.CommonTokenStream(lexer));
        var res = parser.eval();
        trace(res.tree.getChild(1).childCount);
    }
}
