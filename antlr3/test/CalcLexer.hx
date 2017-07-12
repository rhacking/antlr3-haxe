// $ANTLR 3.5.3-SNAPSHOT Calc.g 2017-07-12 23:01:38
package;
import org.antlr.runtime.*;
import org.antlr.runtime.BaseRecognizer.*;

class CalcLexer extends Lexer {
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

    public function new(input:CharStream = null, state:RecognizerSharedState = null) {
        super(input, state);
    }
    public override function get_grammarFileName():String { return "Calc.g"; }

    // $ANTLR start T__6
    public function mT__6():Void {
        try {
            var _type:Int = T__6;
            var _channel:Int = DEFAULT_TOKEN_CHANNEL;
            // Calc.g:7:6: ( '(' )
            // Calc.g:7:8: '('
            {
            match('('.charCodeAt(0)); 

            }

            this.state.type = _type;
            this.state.channel = _channel;
        }
    }
    // $ANTLR end T__6

    // $ANTLR start T__7
    public function mT__7():Void {
        try {
            var _type:Int = T__7;
            var _channel:Int = DEFAULT_TOKEN_CHANNEL;
            // Calc.g:8:6: ( ')' )
            // Calc.g:8:8: ')'
            {
            match(')'.charCodeAt(0)); 

            }

            this.state.type = _type;
            this.state.channel = _channel;
        }
    }
    // $ANTLR end T__7

    // $ANTLR start T__8
    public function mT__8():Void {
        try {
            var _type:Int = T__8;
            var _channel:Int = DEFAULT_TOKEN_CHANNEL;
            // Calc.g:9:6: ( '*' )
            // Calc.g:9:8: '*'
            {
            match('*'.charCodeAt(0)); 

            }

            this.state.type = _type;
            this.state.channel = _channel;
        }
    }
    // $ANTLR end T__8

    // $ANTLR start T__9
    public function mT__9():Void {
        try {
            var _type:Int = T__9;
            var _channel:Int = DEFAULT_TOKEN_CHANNEL;
            // Calc.g:10:6: ( '+' )
            // Calc.g:10:8: '+'
            {
            match('+'.charCodeAt(0)); 

            }

            this.state.type = _type;
            this.state.channel = _channel;
        }
    }
    // $ANTLR end T__9

    // $ANTLR start T__10
    public function mT__10():Void {
        try {
            var _type:Int = T__10;
            var _channel:Int = DEFAULT_TOKEN_CHANNEL;
            // Calc.g:11:7: ( '-' )
            // Calc.g:11:9: '-'
            {
            match('-'.charCodeAt(0)); 

            }

            this.state.type = _type;
            this.state.channel = _channel;
        }
    }
    // $ANTLR end T__10

    // $ANTLR start T__11
    public function mT__11():Void {
        try {
            var _type:Int = T__11;
            var _channel:Int = DEFAULT_TOKEN_CHANNEL;
            // Calc.g:12:7: ( '/' )
            // Calc.g:12:9: '/'
            {
            match('/'.charCodeAt(0)); 

            }

            this.state.type = _type;
            this.state.channel = _channel;
        }
    }
    // $ANTLR end T__11

    // $ANTLR start Number
    public function mNumber():Void {
        try {
            var _type:Int = Number;
            var _channel:Int = DEFAULT_TOKEN_CHANNEL;
            // Calc.g:40:5: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // Calc.g:40:10: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // Calc.g:40:10: ( '0' .. '9' )+
            var cnt1:Int=0;
            do {
                var alt1:Int=2;
                var LA1_0:Int = input.LA(1);

                if ( ((LA1_0 >= 48 && LA1_0 <= 57)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Calc.g:
            	    {
            	    if ( (input.LA(1) >= 48 && input.LA(1) <= 57) ) {
            	        input.consume();
            	    }
            	    else {
            	        throw recover(new MismatchedSetException(null,input));

            	    }


            	    };

            	default :
            	    if ( cnt1 >= 1 ) break;
                    throw new EarlyExitException(1, input);
                }
                cnt1++;
            } while (true);


            // Calc.g:40:22: ( '.' ( '0' .. '9' )+ )?
            var alt3:Int=2;
            var LA3_0:Int = input.LA(1);

            if ( (LA3_0==46) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Calc.g:40:23: '.' ( '0' .. '9' )+
                    {
                    match('.'.charCodeAt(0)); 

                    // Calc.g:40:27: ( '0' .. '9' )+
                    var cnt2:Int=0;
                    do {
                        var alt2:Int=2;
                        var LA2_0:Int = input.LA(1);

                        if ( ((LA2_0 >= 48 && LA2_0 <= 57)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Calc.g:
                    	    {
                    	    if ( (input.LA(1) >= 48 && input.LA(1) <= 57) ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        throw recover(new MismatchedSetException(null,input));

                    	    }


                    	    };

                    	default :
                    	    if ( cnt2 >= 1 ) break;
                            throw new EarlyExitException(2, input);
                        }
                        cnt2++;
                    } while (true);


                    };

            }


            }

            this.state.type = _type;
            this.state.channel = _channel;
        }
    }
    // $ANTLR end Number

    // $ANTLR start WS
    public function mWS():Void {
        try {
            var _type:Int = WS;
            var _channel:Int = DEFAULT_TOKEN_CHANNEL;
            // Calc.g:45:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // Calc.g:45:9: ( ' ' | '\\t' | '\\r' | '\\n' )
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
    }
    // $ANTLR end WS

    public override function mTokens():Void {
        // Calc.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | Number | WS )
        var alt4:Int=8;
        var utf = new haxe.Utf8();
        utf.addChar(input.LA(1));
        switch ( utf.toString() ) {
        case '(':
            {
            alt4=1;
            }
        case ')':
            {
            alt4=2;
            }
        case '*':
            {
            alt4=3;
            }
        case '+':
            {
            alt4=4;
            }
        case '-':
            {
            alt4=5;
            }
        case '/':
            {
            alt4=6;
            }
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
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt4=8;
            }
        default:
            throw new NoViableAltException("", 4, 0, input);

        }

        switch (alt4) {
            case 1 :
                // Calc.g:1:10: T__6
                {
                mT__6(); 


                };
            case 2 :
                // Calc.g:1:15: T__7
                {
                mT__7(); 


                };
            case 3 :
                // Calc.g:1:20: T__8
                {
                mT__8(); 


                };
            case 4 :
                // Calc.g:1:25: T__9
                {
                mT__9(); 


                };
            case 5 :
                // Calc.g:1:30: T__10
                {
                mT__10(); 


                };
            case 6 :
                // Calc.g:1:36: T__11
                {
                mT__11(); 


                };
            case 7 :
                // Calc.g:1:42: Number
                {
                mNumber(); 


                };
            case 8 :
                // Calc.g:1:49: WS
                {
                mWS(); 


                };

        }

    }


 

}
}