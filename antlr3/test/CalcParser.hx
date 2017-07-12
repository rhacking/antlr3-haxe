// $ANTLR 3.5.3-SNAPSHOT Calc.g 2017-07-12 23:01:38
package;
import org.antlr.runtime.*;
import org.antlr.runtime.BaseRecognizer.*;

import org.antlr.runtime.tree.*;


class CalcParser extends Parser {

    public static var EOF(default, never):Int=-1;
    public static var T__6(default, never):Int=6;
    public static var T__7(default, never):Int=7;
    public static var T__8(default, never):Int=8;
    public static var T__9(default, never):Int=9;
    public static var T__10(default, never):Int=10;
    public static var T__11(default, never):Int=11;
    public static var Number(default, never):Int=4;
    public static var WS(default, never):Int=5;

    // delegates
    // delegators

    public function new(input:TokenStream, state:RecognizerSharedState = null) {
        super(input, state);
        this.tokenNames = [
            "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Number", "WS", "'('", "')'", "'*'", "'+'", "'-'", "'/'"
        ];
    }

protected var adaptor:TreeAdaptor = new CommonTreeAdaptor();

override public function set treeAdaptor(adaptor:TreeAdaptor):void {
    this.adaptor = adaptor;
}
override public function get treeAdaptor():TreeAdaptor {
    return adaptor;
}
    public override function get_tokenNames():Array<String> { return tokenNames; }
    public override function get_grammarFileName():String { return "Calc.g"; }


    // $ANTLR start eval
    // Calc.g:10:1: eval : additionExp ;
    public function eval():
    ParserRuleReturnScope
     {
        var retval:
        ParserRuleReturnScope
         = new 
        ParserRuleReturnScope
        ();
        retval.start = input.LT(1);


        var root_0:CommonTree = null;

        var additionExp1:
        ParserRuleReturnScope
         = null;



        try {
            // Calc.g:11:5: ( additionExp )
            // Calc.g:11:10: additionExp
            {
            root_0 = cast(adaptor.nil(), CommonTree);


            pushFollow(FOLLOW_additionExp_in_eval52);
            additionExp1=additionExp();

            state._fsp = state._fsp - 1;

            adaptor.addChild(root_0, additionExp1.tree);

            }

            retval.stop = input.LT(-1);


            retval.tree = CommonTree(adaptor.rulePostProcessing(root_0));
            adaptor.setTokenBoundaries(retval.tree, Token(retval.start), Token(retval.stop));

        }
        catch (re:RecognitionException) {
            reportError(re);
            recoverStream(input,re);
            retval.tree = CommonTree(adaptor.errorNode(input, Token(retval.start), input.LT(-1), re));

        }

        return retval;
    }
    // $ANTLR end eval


    // $ANTLR start additionExp
    // Calc.g:15:1: additionExp : multiplyExp ( '+' ^ multiplyExp | '-' ^ multiplyExp )* ;
    public function additionExp():
    ParserRuleReturnScope
     {
        var retval:
        ParserRuleReturnScope
         = new 
        ParserRuleReturnScope
        ();
        retval.start = input.LT(1);


        var root_0:CommonTree = null;

        var char_literal3:Token=null;
        var char_literal5:Token=null;
        var multiplyExp2:
        ParserRuleReturnScope
         = null;

        var multiplyExp4:
        ParserRuleReturnScope
         = null;

        var multiplyExp6:
        ParserRuleReturnScope
         = null;


        var char_literal3_tree:CommonTree=null;
        var char_literal5_tree:CommonTree=null;

        try {
            // Calc.g:16:5: ( multiplyExp ( '+' ^ multiplyExp | '-' ^ multiplyExp )* )
            // Calc.g:16:10: multiplyExp ( '+' ^ multiplyExp | '-' ^ multiplyExp )*
            {
            root_0 = cast(adaptor.nil(), CommonTree);


            pushFollow(FOLLOW_multiplyExp_in_additionExp75);
            multiplyExp2=multiplyExp();

            state._fsp = state._fsp - 1;

            adaptor.addChild(root_0, multiplyExp2.tree);

            // Calc.g:17:10: ( '+' ^ multiplyExp | '-' ^ multiplyExp )*
            do {
                var alt1:Int=3;
                var LA1_0:Int = input.LA(1);

                if ( (LA1_0==9) ) {
                    alt1=1;
                }
                else if ( (LA1_0==10) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // Calc.g:17:12: '+' ^ multiplyExp
            	    {
            	    char_literal3=Token(matchStream(input,9,FOLLOW_9_in_additionExp89)); 
            	    char_literal3_tree = 
            	    CommonTree(adaptor.create(char_literal3))
            	    ;
            	    root_0 = CommonTree(adaptor.becomeRoot(char_literal3_tree, root_0));


            	    pushFollow(FOLLOW_multiplyExp_in_additionExp92);
            	    multiplyExp4=multiplyExp();

            	    state._fsp = state._fsp - 1;

            	    adaptor.addChild(root_0, multiplyExp4.tree);

            	    };
            	case 2 :
            	    // Calc.g:18:12: '-' ^ multiplyExp
            	    {
            	    char_literal5=Token(matchStream(input,10,FOLLOW_10_in_additionExp106)); 
            	    char_literal5_tree = 
            	    CommonTree(adaptor.create(char_literal5))
            	    ;
            	    root_0 = CommonTree(adaptor.becomeRoot(char_literal5_tree, root_0));


            	    pushFollow(FOLLOW_multiplyExp_in_additionExp109);
            	    multiplyExp6=multiplyExp();

            	    state._fsp = state._fsp - 1;

            	    adaptor.addChild(root_0, multiplyExp6.tree);

            	    };

            	default :
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = CommonTree(adaptor.rulePostProcessing(root_0));
            adaptor.setTokenBoundaries(retval.tree, Token(retval.start), Token(retval.stop));

        }
        catch (re:RecognitionException) {
            reportError(re);
            recoverStream(input,re);
            retval.tree = CommonTree(adaptor.errorNode(input, Token(retval.start), input.LT(-1), re));

        }

        return retval;
    }
    // $ANTLR end additionExp


    // $ANTLR start multiplyExp
    // Calc.g:23:1: multiplyExp : atomExp ( '*' ^ atomExp | '/' ^ atomExp )* ;
    public function multiplyExp():
    ParserRuleReturnScope
     {
        var retval:
        ParserRuleReturnScope
         = new 
        ParserRuleReturnScope
        ();
        retval.start = input.LT(1);


        var root_0:CommonTree = null;

        var char_literal8:Token=null;
        var char_literal10:Token=null;
        var atomExp7:
        ParserRuleReturnScope
         = null;

        var atomExp9:
        ParserRuleReturnScope
         = null;

        var atomExp11:
        ParserRuleReturnScope
         = null;


        var char_literal8_tree:CommonTree=null;
        var char_literal10_tree:CommonTree=null;

        try {
            // Calc.g:24:5: ( atomExp ( '*' ^ atomExp | '/' ^ atomExp )* )
            // Calc.g:24:10: atomExp ( '*' ^ atomExp | '/' ^ atomExp )*
            {
            root_0 = cast(adaptor.nil(), CommonTree);


            pushFollow(FOLLOW_atomExp_in_multiplyExp144);
            atomExp7=atomExp();

            state._fsp = state._fsp - 1;

            adaptor.addChild(root_0, atomExp7.tree);

            // Calc.g:25:10: ( '*' ^ atomExp | '/' ^ atomExp )*
            do {
                var alt2:Int=3;
                var LA2_0:Int = input.LA(1);

                if ( (LA2_0==8) ) {
                    alt2=1;
                }
                else if ( (LA2_0==11) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // Calc.g:25:12: '*' ^ atomExp
            	    {
            	    char_literal8=Token(matchStream(input,8,FOLLOW_8_in_multiplyExp157)); 
            	    char_literal8_tree = 
            	    CommonTree(adaptor.create(char_literal8))
            	    ;
            	    root_0 = CommonTree(adaptor.becomeRoot(char_literal8_tree, root_0));


            	    pushFollow(FOLLOW_atomExp_in_multiplyExp160);
            	    atomExp9=atomExp();

            	    state._fsp = state._fsp - 1;

            	    adaptor.addChild(root_0, atomExp9.tree);

            	    };
            	case 2 :
            	    // Calc.g:26:12: '/' ^ atomExp
            	    {
            	    char_literal10=Token(matchStream(input,11,FOLLOW_11_in_multiplyExp174)); 
            	    char_literal10_tree = 
            	    CommonTree(adaptor.create(char_literal10))
            	    ;
            	    root_0 = CommonTree(adaptor.becomeRoot(char_literal10_tree, root_0));


            	    pushFollow(FOLLOW_atomExp_in_multiplyExp177);
            	    atomExp11=atomExp();

            	    state._fsp = state._fsp - 1;

            	    adaptor.addChild(root_0, atomExp11.tree);

            	    };

            	default :
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = CommonTree(adaptor.rulePostProcessing(root_0));
            adaptor.setTokenBoundaries(retval.tree, Token(retval.start), Token(retval.stop));

        }
        catch (re:RecognitionException) {
            reportError(re);
            recoverStream(input,re);
            retval.tree = CommonTree(adaptor.errorNode(input, Token(retval.start), input.LT(-1), re));

        }

        return retval;
    }
    // $ANTLR end multiplyExp


    // $ANTLR start atomExp
    // Calc.g:33:1: atomExp : ( Number | '(' additionExp ')' );
    public function atomExp():
    ParserRuleReturnScope
     {
        var retval:
        ParserRuleReturnScope
         = new 
        ParserRuleReturnScope
        ();
        retval.start = input.LT(1);


        var root_0:CommonTree = null;

        var Number12:Token=null;
        var char_literal13:Token=null;
        var char_literal15:Token=null;
        var additionExp14:
        ParserRuleReturnScope
         = null;


        var Number12_tree:CommonTree=null;
        var char_literal13_tree:CommonTree=null;
        var char_literal15_tree:CommonTree=null;

        try {
            // Calc.g:34:5: ( Number | '(' additionExp ')' )
            var alt3:Int=2;
            var LA3_0:Int = input.LA(1);

            if ( (LA3_0==4) ) {
                alt3=1;
            }
            else if ( (LA3_0==6) ) {
                alt3=2;
            }
            else {
                throw new NoViableAltException("", 3, 0, input);

            }
            switch (alt3) {
                case 1 :
                    // Calc.g:34:10: Number
                    {
                    root_0 = cast(adaptor.nil(), CommonTree);


                    Number12=Token(matchStream(input,Number,FOLLOW_Number_in_atomExp212)); 
                    Number12_tree = 
                    CommonTree(adaptor.create(Number12))
                    ;
                    adaptor.addChild(root_0, Number12_tree);


                    };
                case 2 :
                    // Calc.g:35:10: '(' additionExp ')'
                    {
                    root_0 = cast(adaptor.nil(), CommonTree);


                    char_literal13=Token(matchStream(input,6,FOLLOW_6_in_atomExp223)); 
                    char_literal13_tree = 
                    CommonTree(adaptor.create(char_literal13))
                    ;
                    adaptor.addChild(root_0, char_literal13_tree);


                    pushFollow(FOLLOW_additionExp_in_atomExp225);
                    additionExp14=additionExp();

                    state._fsp = state._fsp - 1;

                    adaptor.addChild(root_0, additionExp14.tree);

                    char_literal15=Token(matchStream(input,7,FOLLOW_7_in_atomExp227)); 
                    char_literal15_tree = 
                    CommonTree(adaptor.create(char_literal15))
                    ;
                    adaptor.addChild(root_0, char_literal15_tree);


                    };

            }
            retval.stop = input.LT(-1);


            retval.tree = CommonTree(adaptor.rulePostProcessing(root_0));
            adaptor.setTokenBoundaries(retval.tree, Token(retval.start), Token(retval.stop));

        }
        catch (re:RecognitionException) {
            reportError(re);
            recoverStream(input,re);
            retval.tree = CommonTree(adaptor.errorNode(input, Token(retval.start), input.LT(-1), re));

        }

        return retval;
    }
    // $ANTLR end atomExp

       // Delegated rules


 

    public static var FOLLOW_additionExp_in_eval52(default, never):BitSet = new BitSet([0x0000000000000002]);
    public static var FOLLOW_multiplyExp_in_additionExp75(default, never):BitSet = new BitSet([0x0000000000000602]);
    public static var FOLLOW_9_in_additionExp89(default, never):BitSet = new BitSet([0x0000000000000050]);
    public static var FOLLOW_multiplyExp_in_additionExp92(default, never):BitSet = new BitSet([0x0000000000000602]);
    public static var FOLLOW_10_in_additionExp106(default, never):BitSet = new BitSet([0x0000000000000050]);
    public static var FOLLOW_multiplyExp_in_additionExp109(default, never):BitSet = new BitSet([0x0000000000000602]);
    public static var FOLLOW_atomExp_in_multiplyExp144(default, never):BitSet = new BitSet([0x0000000000000902]);
    public static var FOLLOW_8_in_multiplyExp157(default, never):BitSet = new BitSet([0x0000000000000050]);
    public static var FOLLOW_atomExp_in_multiplyExp160(default, never):BitSet = new BitSet([0x0000000000000902]);
    public static var FOLLOW_11_in_multiplyExp174(default, never):BitSet = new BitSet([0x0000000000000050]);
    public static var FOLLOW_atomExp_in_multiplyExp177(default, never):BitSet = new BitSet([0x0000000000000902]);
    public static var FOLLOW_Number_in_atomExp212(default, never):BitSet = new BitSet([0x0000000000000002]);
    public static var FOLLOW_6_in_atomExp223(default, never):BitSet = new BitSet([0x0000000000000050]);
    public static var FOLLOW_additionExp_in_atomExp225(default, never):BitSet = new BitSet([0x0000000000000080]);
    public static var FOLLOW_7_in_atomExp227(default, never):BitSet = new BitSet([0x0000000000000002]);

}
}