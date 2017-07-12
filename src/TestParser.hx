// $ANTLR 3.5 /Users/Roel/test.g 2017-06-10 22:58:53
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class TestParser extends Parser
{
    
    public static var EOF : Int = -1;
    public static inline var T__6 : Int = 6;
    public static inline var T__7 : Int = 7;
    public static inline var T__8 : Int = 8;
    public static inline var T__9 : Int = 9;
    public static inline var T__10 : Int = 10;
    public static inline var T__11 : Int = 11;
    public static inline var Float : Int = 4;
    public static inline var WS : Int = 5;
    
    // delegates
    // delegators
    
    public function new(input : TokenStream, state : RecognizerSharedState = null)
    {
        super(input, state);
        this.tokenNames = [
            "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Number", "WS", "'('", "')'", "'*'", "'+'", "'-'", "'/'"
        ];
    }
    
    private var adaptor : TreeAdaptor = new CommonTreeAdaptor();
    
    override private function set_treeAdaptor(adaptor : TreeAdaptor) : TreeAdaptor
    {
        this.adaptor = adaptor;
        return adaptor;
    }
    override private function get_treeAdaptor() : TreeAdaptor
    {
        return adaptor;
    }
    override private function get_tokenNames() : Array<Dynamic>
    {
        return this.tokenNames;
    }
    override private function get_grammarFileName() : String
    {
        return "/Users/Roel/test.g";
    }
    
    
    // $ANTLR start eval
    // /Users/Roel/test.g:10:1: eval : additionExp ;
    @:final public function eval() : ParserRuleReturnScope
    {
        var retval : ParserRuleReturnScope = new ParserRuleReturnScope();
        retval.start = input.LT(1);
        
        
        var root_0 : CommonTree = null;
        
        var additionExp1 : ParserRuleReturnScope = null;
        
        
        
        try
        {
            // /Users/Roel/test.g:11:5: ( additionExp )
            // /Users/Roel/test.g:11:10: additionExp
            {
                root_0 = cast((adaptor.nil()), CommonTree);
                
                
                pushFollow(FOLLOW_additionExp_in_eval52);
                additionExp1 = additionExp();
                
                state._fsp = state._fsp - 1;
                
                adaptor.addChild(root_0, additionExp1.tree);
            }
            
            retval.stop = input.LT(-1);
            
            
            retval.tree = cast((adaptor.rulePostProcessing(root_0)), CommonTree);
            adaptor.setTokenBoundaries(retval.tree, cast((retval.start), Token), cast((retval.stop), Token));
        }
        catch (re : RecognitionException)
        {
            reportError(re);
            recoverStream(input, re);
            retval.tree = cast((adaptor.errorNode(input, cast((retval.start), Token), input.LT(-1), re)), CommonTree);
        }
        return retval;
    }
    // $ANTLR end eval
    
    
    // $ANTLR start additionExp
    // /Users/Roel/test.g:15:1: additionExp : multiplyExp ( '+' multiplyExp | '-' multiplyExp )* ;
    @:final public function additionExp() : ParserRuleReturnScope
    {
        var retval : ParserRuleReturnScope = new ParserRuleReturnScope();
        retval.start = input.LT(1);
        
        
        var root_0 : CommonTree = null;
        
        var char_literal3 : Token = null;
        var char_literal5 : Token = null;
        var multiplyExp2 : ParserRuleReturnScope = null;
        
        var multiplyExp4 : ParserRuleReturnScope = null;
        
        var multiplyExp6 : ParserRuleReturnScope = null;
        
        
        var char_literal3_tree : CommonTree = null;
        var char_literal5_tree : CommonTree = null;
        
        try
        {
            // /Users/Roel/test.g:16:5: ( multiplyExp ( '+' multiplyExp | '-' multiplyExp )* )
            // /Users/Roel/test.g:16:10: multiplyExp ( '+' multiplyExp | '-' multiplyExp )*
            {
                root_0 = cast((adaptor.nil()), CommonTree);
                
                
                pushFollow(FOLLOW_multiplyExp_in_additionExp75);
                multiplyExp2 = multiplyExp();
                
                state._fsp = state._fsp - 1;
                
                adaptor.addChild(root_0, multiplyExp2.tree);
                
                // /Users/Roel/test.g:17:10: ( '+' multiplyExp | '-' multiplyExp )*
                do
                {
                    var alt1 : Int = 3;
                    var LA1_0 : Int = input.LA(1);
                    
                    if ((LA1_0 == 9))
                    {
                        alt1 = 1;
                    }
                    else
                    {
                        if ((LA1_0 == 10))
                        {
                            alt1 = 2;
                        }
                    }
                    
                    var breaking = false;
                    switch (alt1)
                    {
                        case 1:
                        // /Users/Roel/test.g:17:12: '+' multiplyExp
                        {
                            char_literal3 = cast((matchStream(input, 9, FOLLOW_9_in_additionExp89)), Token);
                            char_literal3_tree =
                                    cast((adaptor.create([char_literal3])), CommonTree);
                            adaptor.addChild(root_0, char_literal3_tree);
                            
                            
                            pushFollow(FOLLOW_multiplyExp_in_additionExp91);
                            multiplyExp4 = multiplyExp();
                            
                            state._fsp = state._fsp - 1;
                            
                            adaptor.addChild(root_0, multiplyExp4.tree);
                        }
                        case 2:
                        // /Users/Roel/test.g:18:12: '-' multiplyExp
                        {
                            char_literal5 = cast((matchStream(input, 10, FOLLOW_10_in_additionExp105)), Token);
                            char_literal5_tree =
                                    cast((adaptor.create([char_literal5])), CommonTree);
                            adaptor.addChild(root_0, char_literal5_tree);
                            
                            
                            pushFollow(FOLLOW_multiplyExp_in_additionExp107);
                            multiplyExp6 = multiplyExp();
                            
                            state._fsp = state._fsp - 1;
                            
                            adaptor.addChild(root_0, multiplyExp6.tree);
                        }
                        
                        default:
                            breaking = true;
                    }
                    if (breaking)
                    {
                        break;
                    }
                }
                while ((true));
            }
            
            retval.stop = input.LT(-1);
            
            
            retval.tree = cast((adaptor.rulePostProcessing(root_0)), CommonTree);
            adaptor.setTokenBoundaries(retval.tree, cast((retval.start), Token), cast((retval.stop), Token));
        }
        catch (re : RecognitionException)
        {
            reportError(re);
            recoverStream(input, re);
            retval.tree = cast((adaptor.errorNode(input, cast((retval.start), Token), input.LT(-1), re)), CommonTree);
        }
        return retval;
    }
    // $ANTLR end additionExp
    
    
    // $ANTLR start multiplyExp
    // /Users/Roel/test.g:23:1: multiplyExp : atomExp ( '*' atomExp | '/' atomExp )* ;
    @:final public function multiplyExp() : ParserRuleReturnScope
    {
        var retval : ParserRuleReturnScope = new ParserRuleReturnScope();
        retval.start = input.LT(1);
        
        
        var root_0 : CommonTree = null;
        
        var char_literal8 : Token = null;
        var char_literal10 : Token = null;
        var atomExp7 : ParserRuleReturnScope = null;
        
        var atomExp9 : ParserRuleReturnScope = null;
        
        var atomExp11 : ParserRuleReturnScope = null;
        
        
        var char_literal8_tree : CommonTree = null;
        var char_literal10_tree : CommonTree = null;
        
        try
        {
            // /Users/Roel/test.g:24:5: ( atomExp ( '*' atomExp | '/' atomExp )* )
            // /Users/Roel/test.g:24:10: atomExp ( '*' atomExp | '/' atomExp )*
            {
                root_0 = cast((adaptor.nil()), CommonTree);
                
                
                pushFollow(FOLLOW_atomExp_in_multiplyExp142);
                atomExp7 = atomExp();
                
                state._fsp = state._fsp - 1;
                
                adaptor.addChild(root_0, atomExp7.tree);
                
                // /Users/Roel/test.g:25:10: ( '*' atomExp | '/' atomExp )*
                do
                {
                    var alt2 : Int = 3;
                    var LA2_0 : Int = input.LA(1);
                    
                    if ((LA2_0 == 8))
                    {
                        alt2 = 1;
                    }
                    else
                    {
                        if ((LA2_0 == 11))
                        {
                            alt2 = 2;
                        }
                    }
                    
                    var breaking = false;
                    switch (alt2)
                    {
                        case 1:
                        // /Users/Roel/test.g:25:12: '*' atomExp
                        {
                            char_literal8 = cast((matchStream(input, 8, FOLLOW_8_in_multiplyExp155)), Token);
                            char_literal8_tree =
                                    cast((adaptor.create([char_literal8])), CommonTree);
                            adaptor.addChild(root_0, char_literal8_tree);
                            
                            
                            pushFollow(FOLLOW_atomExp_in_multiplyExp157);
                            atomExp9 = atomExp();
                            
                            state._fsp = state._fsp - 1;
                            
                            adaptor.addChild(root_0, atomExp9.tree);
                        }
                        case 2:
                        // /Users/Roel/test.g:26:12: '/' atomExp
                        {
                            char_literal10 = cast((matchStream(input, 11, FOLLOW_11_in_multiplyExp171)), Token);
                            char_literal10_tree =
                                    cast((adaptor.create([char_literal10])), CommonTree);
                            adaptor.addChild(root_0, char_literal10_tree);
                            
                            
                            pushFollow(FOLLOW_atomExp_in_multiplyExp173);
                            atomExp11 = atomExp();
                            
                            state._fsp = state._fsp - 1;
                            
                            adaptor.addChild(root_0, atomExp11.tree);
                        }
                        
                        default:
                            breaking = true;
                    }
                    if (breaking)
                    {
                        break;
                    }
                }
                while ((true));
            }
            
            retval.stop = input.LT(-1);
            
            
            retval.tree = cast((adaptor.rulePostProcessing(root_0)), CommonTree);
            adaptor.setTokenBoundaries(retval.tree, cast((retval.start), Token), cast((retval.stop), Token));
        }
        catch (re : RecognitionException)
        {
            reportError(re);
            recoverStream(input, re);
            retval.tree = cast((adaptor.errorNode(input, cast((retval.start), Token), input.LT(-1), re)), CommonTree);
        }
        return retval;
    }
    // $ANTLR end multiplyExp
    
    
    // $ANTLR start atomExp
    // /Users/Roel/test.g:33:1: atomExp : ( Number | '(' additionExp ')' );
    @:final public function atomExp() : ParserRuleReturnScope
    {
        var retval : ParserRuleReturnScope = new ParserRuleReturnScope();
        retval.start = input.LT(1);
        
        
        var root_0 : CommonTree = null;
        
        var Number12 : Token = null;
        var char_literal13 : Token = null;
        var char_literal15 : Token = null;
        var additionExp14 : ParserRuleReturnScope = null;
        
        
        var Number12_tree : CommonTree = null;
        var char_literal13_tree : CommonTree = null;
        var char_literal15_tree : CommonTree = null;
        
        try
        {
            // /Users/Roel/test.g:34:5: ( Number | '(' additionExp ')' )
            var alt3 : Int = 2;
            var LA3_0 : Int = input.LA(1);
            
            if ((LA3_0 == 4))
            {
                alt3 = 1;
            }
            else
            {
                if ((LA3_0 == 6))
                {
                    alt3 = 2;
                }
                else
                {
                    throw new NoViableAltException("", 3, 0, input);
                }
            }
            switch (alt3)
            {
                case 1:
                // /Users/Roel/test.g:34:10: Number
                {
                    root_0 = cast((adaptor.nil()), CommonTree);
                    
                    
                    Number12 = cast((matchStream(input, Float, FOLLOW_Number_in_atomExp208)), Token);
                    Number12_tree =
                            cast((adaptor.create([Number12])), CommonTree);
                    adaptor.addChild(root_0, Number12_tree);
                }
                case 2:
                // /Users/Roel/test.g:35:10: '(' additionExp ')'
                {
                    root_0 = cast((adaptor.nil()), CommonTree);
                    
                    
                    char_literal13 = cast((matchStream(input, 6, FOLLOW_6_in_atomExp219)), Token);
                    char_literal13_tree =
                            cast((adaptor.create([char_literal13])), CommonTree);
                    adaptor.addChild(root_0, char_literal13_tree);
                    
                    
                    pushFollow(FOLLOW_additionExp_in_atomExp221);
                    additionExp14 = additionExp();
                    
                    state._fsp = state._fsp - 1;
                    
                    adaptor.addChild(root_0, additionExp14.tree);
                    
                    char_literal15 = cast((matchStream(input, 7, FOLLOW_7_in_atomExp223)), Token);
                    char_literal15_tree =
                            cast((adaptor.create([char_literal15])), CommonTree);
                    adaptor.addChild(root_0, char_literal15_tree);
                }
            }
            retval.stop = input.LT(-1);
            
            
            retval.tree = cast((adaptor.rulePostProcessing(root_0)), CommonTree);
            adaptor.setTokenBoundaries(retval.tree, cast((retval.start), Token), cast((retval.stop), Token));
        }
        catch (re : RecognitionException)
        {
            reportError(re);
            recoverStream(input, re);
            retval.tree;
            retval.tree = cast((adaptor.errorNode(input, cast((retval.start), Token), input.LT(-1), re)), CommonTree);
        }
        return retval;
    }
    // $ANTLR end atomExp
    
    // Delegated rules
    
    
    
    
    public static var FOLLOW_additionExp_in_eval52 : BitSet = new BitSet([0x0000002]);
    public static var FOLLOW_multiplyExp_in_additionExp75 : BitSet = new BitSet([0x0000602]);
    public static var FOLLOW_9_in_additionExp89 : BitSet = new BitSet([0x000050]);
    public static var FOLLOW_multiplyExp_in_additionExp91 : BitSet = new BitSet([0x00000602]);
    public static var FOLLOW_10_in_additionExp105 : BitSet = new BitSet([0x0000050]);
    public static var FOLLOW_multiplyExp_in_additionExp107 : BitSet = new BitSet([0x0000602]);
    public static var FOLLOW_atomExp_in_multiplyExp142 : BitSet = new BitSet([0x00000902]);
    public static var FOLLOW_8_in_multiplyExp155 : BitSet = new BitSet([0x0000050]);
    public static var FOLLOW_atomExp_in_multiplyExp157 : BitSet = new BitSet([0x00000902]);
    public static var FOLLOW_11_in_multiplyExp171 : BitSet = new BitSet([0x00000050]);
    public static var FOLLOW_atomExp_in_multiplyExp173 : BitSet = new BitSet([0x000902]);
    public static var FOLLOW_Number_in_atomExp208 : BitSet = new BitSet([0x000002]);
    public static var FOLLOW_6_in_atomExp219 : BitSet = new BitSet([0x000050]);
    public static var FOLLOW_additionExp_in_atomExp221 : BitSet = new BitSet([0x0000080]);
    public static var FOLLOW_7_in_atomExp223 : BitSet = new BitSet([0x000002]);
}

