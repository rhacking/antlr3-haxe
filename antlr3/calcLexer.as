// $ANTLR 3.5.3-SNAPSHOT calc.g 2017-07-12 20:18:16
package {
import org.antlr.runtime.*;

    public class calcLexer extends Lexer {
        public static const EOF:Int=-1;
        public static const T__6:Int=6;
        public static const T__7:Int=7;
        public static const T__8:Int=8;
        public static const T__9:Int=9;
        public static const T__10:Int=10;
        public static const T__11:Int=11;
        public static const Number:Int=4;
        public static const WS:Int=5;

        // delegates
        // delegators

        public function calcLexer(input:CharStream = null, state:RecognizerSharedState = null) {
            super(input, state);
        }
        public override function get grammarFileName():String { return "calc.g"; }

        // $ANTLR start T__6
        public final function mT__6():void {
            try {
                var _type:Int = T__6;
                var _channel:Int = DEFAULT_TOKEN_CHANNEL;
                // calc.g:7:6: ( '(' )
                // calc.g:7:8: '('
                {
                match('('); 

                }

                this.state.type = _type;
                this.state.channel = _channel;
            }
            finally {
            }
        }
        // $ANTLR end T__6

        // $ANTLR start T__7
        public final function mT__7():void {
            try {
                var _type:Int = T__7;
                var _channel:Int = DEFAULT_TOKEN_CHANNEL;
                // calc.g:8:6: ( ')' )
                // calc.g:8:8: ')'
                {
                match(')'); 

                }

                this.state.type = _type;
                this.state.channel = _channel;
            }
            finally {
            }
        }
        // $ANTLR end T__7

        // $ANTLR start T__8
        public final function mT__8():void {
            try {
                var _type:Int = T__8;
                var _channel:Int = DEFAULT_TOKEN_CHANNEL;
                // calc.g:9:6: ( '*' )
                // calc.g:9:8: '*'
                {
                match('*'); 

                }

                this.state.type = _type;
                this.state.channel = _channel;
            }
            finally {
            }
        }
        // $ANTLR end T__8

        // $ANTLR start T__9
        public final function mT__9():void {
            try {
                var _type:Int = T__9;
                var _channel:Int = DEFAULT_TOKEN_CHANNEL;
                // calc.g:10:6: ( '+' )
                // calc.g:10:8: '+'
                {
                match('+'); 

                }

                this.state.type = _type;
                this.state.channel = _channel;
            }
            finally {
            }
        }
        // $ANTLR end T__9

        // $ANTLR start T__10
        public final function mT__10():void {
            try {
                var _type:Int = T__10;
                var _channel:Int = DEFAULT_TOKEN_CHANNEL;
                // calc.g:11:7: ( '-' )
                // calc.g:11:9: '-'
                {
                match('-'); 

                }

                this.state.type = _type;
                this.state.channel = _channel;
            }
            finally {
            }
        }
        // $ANTLR end T__10

        // $ANTLR start T__11
        public final function mT__11():void {
            try {
                var _type:Int = T__11;
                var _channel:Int = DEFAULT_TOKEN_CHANNEL;
                // calc.g:12:7: ( '/' )
                // calc.g:12:9: '/'
                {
                match('/'); 

                }

                this.state.type = _type;
                this.state.channel = _channel;
            }
            finally {
            }
        }
        // $ANTLR end T__11

        // $ANTLR start Number
        public final function mNumber():void {
            try {
                var _type:Int = Number;
                var _channel:Int = DEFAULT_TOKEN_CHANNEL;
                // calc.g:40:5: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
                // calc.g:40:10: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
                {
                // calc.g:40:10: ( '0' .. '9' )+
                var cnt1:Int=0;
                loop1:
                do {
                    var alt1:Int=2;
                    var LA1_0:Int = input.LA(1);

                    if ( ((LA1_0 >= 48 && LA1_0 <= 57)) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // calc.g:
                	    {
                	    if ( (input.LA(1) >= 48 && input.LA(1) <= 57) ) {
                	        input.consume();
                	    }
                	    else {
                	        throw recover(new MismatchedSetException(null,input));

                	    }


                	    }
                	    break;

                	default :
                	    if ( cnt1 >= 1 ) break loop1;
                            throw new EarlyExitException(1, input);
                    }
                    cnt1++;
                } while (true);


                // calc.g:40:22: ( '.' ( '0' .. '9' )+ )?
                var alt3:Int=2;
                var LA3_0:Int = input.LA(1);

                if ( (LA3_0==46) ) {
                    alt3=1;
                }
                switch (alt3) {
                    case 1 :
                        // calc.g:40:23: '.' ( '0' .. '9' )+
                        {
                        match('.'); 

                        // calc.g:40:27: ( '0' .. '9' )+
                        var cnt2:Int=0;
                        loop2:
                        do {
                            var alt2:Int=2;
                            var LA2_0:Int = input.LA(1);

                            if ( ((LA2_0 >= 48 && LA2_0 <= 57)) ) {
                                alt2=1;
                            }


                            switch (alt2) {
                        	case 1 :
                        	    // calc.g:
                        	    {
                        	    if ( (input.LA(1) >= 48 && input.LA(1) <= 57) ) {
                        	        input.consume();
                        	    }
                        	    else {
                        	        throw recover(new MismatchedSetException(null,input));

                        	    }


                        	    }
                        	    break;

                        	default :
                        	    if ( cnt2 >= 1 ) break loop2;
                                    throw new EarlyExitException(2, input);
                            }
                            cnt2++;
                        } while (true);


                        }
                        break;

                }


                }

                this.state.type = _type;
                this.state.channel = _channel;
            }
            finally {
            }
        }
        // $ANTLR end Number

        // $ANTLR start WS
        public final function mWS():void {
            try {
                var _type:Int = WS;
                var _channel:Int = DEFAULT_TOKEN_CHANNEL;
                // calc.g:45:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
                // calc.g:45:9: ( ' ' | '\\t' | '\\r' | '\\n' )
                {
                if ( (input.LA(1) >= 9 && input.LA(1) <= 10)||input.LA(1)==13||input.LA(1)==32 ) {
                    input.consume();
                }
                else {
                    throw recover(new MismatchedSetException(null,input));

                }


                _channel=HIDDEN;


                }

                this.state.type = _type;
                this.state.channel = _channel;
            }
            finally {
            }
        }
        // $ANTLR end WS

        public override function mTokens():void {
            // calc.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | Number | WS )
            var alt4:Int=8;
            switch ( input.LA(1) ) {
            case '(':
                {
                alt4=1;
                }
                break;
            case ')':
                {
                alt4=2;
                }
                break;
            case '*':
                {
                alt4=3;
                }
                break;
            case '+':
                {
                alt4=4;
                }
                break;
            case '-':
                {
                alt4=5;
                }
                break;
            case '/':
                {
                alt4=6;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt4=7;
                }
                break;
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                {
                alt4=8;
                }
                break;
            default:
                throw new NoViableAltException("", 4, 0, input);

            }

            switch (alt4) {
                case 1 :
                    // calc.g:1:10: T__6
                    {
                    mT__6(); 


                    }
                    break;
                case 2 :
                    // calc.g:1:15: T__7
                    {
                    mT__7(); 


                    }
                    break;
                case 3 :
                    // calc.g:1:20: T__8
                    {
                    mT__8(); 


                    }
                    break;
                case 4 :
                    // calc.g:1:25: T__9
                    {
                    mT__9(); 


                    }
                    break;
                case 5 :
                    // calc.g:1:30: T__10
                    {
                    mT__10(); 


                    }
                    break;
                case 6 :
                    // calc.g:1:36: T__11
                    {
                    mT__11(); 


                    }
                    break;
                case 7 :
                    // calc.g:1:42: Number
                    {
                    mNumber(); 


                    }
                    break;
                case 8 :
                    // calc.g:1:49: WS
                    {
                    mWS(); 


                    }
                    break;

            }

        }


     

    }
}