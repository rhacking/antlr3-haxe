// $ANTLR 3.5 /Users/Roel/test.g 2017-06-10 22:58:53
import org.antlr.runtime.*;
import org.antlr.runtime.BaseRecognizer.*;

class TestLexer extends Lexer
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
    
    public function new(input : CharStream = null, state : RecognizerSharedState = null)
    {
        super(input, state);
    }
    override private function get_grammarFileName() : String
    {
        return "/Users/Roel/test.g";
    }
    
    // $ANTLR start T__6
    @:final public function mT__6() : Void
    {
        try
        {
            var _type : Int = T__6;
            var _channel : Int = DEFAULT_TOKEN_CHANNEL;
            // /Users/Roel/test.g:7:6: ( '(' )
            // /Users/Roel/test.g:7:8: '('
            {
                match("(".charCodeAt(0));
            }
            
            this.state.type = _type;
            this.state.channel = _channel;
        };
    }
    // $ANTLR end T__6
    
    // $ANTLR start T__7
    @:final public function mT__7() : Void
    {
        try
        {
            var _type : Int = T__7;
            var _channel : Int = DEFAULT_TOKEN_CHANNEL;
            // /Users/Roel/test.g:8:6: ( ')' )
            // /Users/Roel/test.g:8:8: ')'
            {
                match(")".charCodeAt(0));
            }
            
            this.state.type = _type;
            this.state.channel = _channel;
        };
    }
    // $ANTLR end T__7
    
    // $ANTLR start T__8
    @:final public function mT__8() : Void
    {
        try
        {
            var _type : Int = T__8;
            var _channel : Int = DEFAULT_TOKEN_CHANNEL;
            // /Users/Roel/test.g:9:6: ( '*' )
            // /Users/Roel/test.g:9:8: '*'
            {
                match("*".charCodeAt(0));
            }
            
            this.state.type = _type;
            this.state.channel = _channel;
        };
    }
    // $ANTLR end T__8
    
    // $ANTLR start T__9
    @:final public function mT__9() : Void
    {
        try
        {
            var _type : Int = T__9;
            var _channel : Int = DEFAULT_TOKEN_CHANNEL;
            // /Users/Roel/test.g:10:6: ( '+' )
            // /Users/Roel/test.g:10:8: '+'
            {
                match("+".charCodeAt(0));
            }
            
            this.state.type = _type;
            this.state.channel = _channel;
        };
    }
    // $ANTLR end T__9
    
    // $ANTLR start T__10
    @:final public function mT__10() : Void
    {
        try
        {
            var _type : Int = T__10;
            var _channel : Int = DEFAULT_TOKEN_CHANNEL;
            // /Users/Roel/test.g:11:7: ( '-' )
            // /Users/Roel/test.g:11:9: '-'
            {
                match("-".charCodeAt(0));
            }
            
            this.state.type = _type;
            this.state.channel = _channel;
        };
    }
    // $ANTLR end T__10
    
    // $ANTLR start T__11
    @:final public function mT__11() : Void
    {
        try
        {
            var _type : Int = T__11;
            var _channel : Int = DEFAULT_TOKEN_CHANNEL;
            // /Users/Roel/test.g:12:7: ( '/' )
            // /Users/Roel/test.g:12:9: '/'
            {
                match("/".charCodeAt(0));
            }
            
            this.state.type = _type;
            this.state.channel = _channel;
        };
    }
    // $ANTLR end T__11
    
    // $ANTLR start Number
    @:final public function mNumber() : Void
    {
        try
        {
            var _type : Int = Float;
            var _channel : Int = DEFAULT_TOKEN_CHANNEL;
            // /Users/Roel/test.g:40:5: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // /Users/Roel/test.g:40:10: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
                // /Users/Roel/test.g:40:10: ( '0' .. '9' )+
                var cnt1 : Int = 0;
                do
                {
                    var alt1 : Int = 2;
                    var LA1_0 : Int = input.LA(1);
                    
                    if (LA1_0 >= 48 && LA1_0 <= 57)
                    {
                        alt1 = 1;
                    }
                    
                    var breaking = false;
                    switch (alt1)
                    {
                        case 1:
                        // /Users/Roel/test.g:
                        {
                            if (input.LA(1) >= 48 && input.LA(1) <= 57)
                            {
                                input.consume();
                            }
                            else
                            {
                                throw recover(new MismatchedSetException(null, input));
                            }
                        }
                        
                        default:
                            if (cnt1 >= 1)
                            {
                                breaking = true;
                                break;
                            }
                            throw new EarlyExitException(1, input);
                    }
                    if (breaking)
                    {
                        break;
                    }
                    cnt1++;
                }
                while ((true));
                
                
                // /Users/Roel/test.g:40:22: ( '.' ( '0' .. '9' )+ )?
                var alt3 : Int = 2;
                var LA3_0 : Int = input.LA(1);
                
                if ((LA3_0 == 46))
                {
                    alt3 = 1;
                }
                switch (alt3)
                {
                    case 1:
                    // /Users/Roel/test.g:40:23: '.' ( '0' .. '9' )+
                    {
                        match(".".charCodeAt(0));
                        
                        // /Users/Roel/test.g:40:27: ( '0' .. '9' )+
                        var cnt2 : Int = 0;
                        do
                        {
                            var alt2 : Int = 2;
                            var LA2_0 : Int = input.LA(1);
                            
                            if (LA2_0 >= 48 && LA2_0 <= 57)
                            {
                                alt2 = 1;
                            }
                            
                            var breaking = false;
                            switch (alt2)
                            {
                                case 1:
                                // /Users/Roel/test.g:
                                {
                                    if (input.LA(1) >= 48 && input.LA(1) <= 57)
                                    {
                                        input.consume();
                                    }
                                    else
                                    {
                                        throw recover(new MismatchedSetException(null, input));
                                    }
                                }
                                
                                default:
                                    if (cnt2 >= 1)
                                    {
                                        breaking = true;
                                        break;
                                    }
                                    throw new EarlyExitException(2, input);
                            }
                            if (breaking)
                            {
                                break;
                            }
                            cnt2++;
                        }
                        while ((true));
                    }
                }
            }
            
            this.state.type = _type;
            this.state.channel = _channel;
        };
    }
    // $ANTLR end Number
    
    // $ANTLR start WS
    @:final public function mWS() : Void
    {
        try
        {
            var _type : Int = WS;
            var _channel : Int = DEFAULT_TOKEN_CHANNEL;
            // /Users/Roel/test.g:45:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/Roel/test.g:45:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
                if ((input.LA(1) >= 9 && input.LA(1) <= 10) || input.LA(1) == 13 || input.LA(1) == 32)
                {
                    input.consume();
                }
                else
                {
                    throw recover(new MismatchedSetException(null, input));
                }
                
                
                _channel = HIDDEN;
            }
            
            this.state.type = _type;
            this.state.channel = _channel;
        };
    }
    // $ANTLR end WS
    
    override public function mTokens() : Void
    {
        // /Users/Roel/test.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | Number | WS )
        var alt4 : Int = 8;
        var utf = new haxe.Utf8();
        utf.addChar(input.LA(1));
        switch (utf.toString())
        {
            case "(":
            {
                alt4 = 1;
            }
            case ")":
            {
                alt4 = 2;
            }
            case "*":
            {
                alt4 = 3;
            }
            case "+":
            {
                alt4 = 4;
            }
            case "-":
            {
                alt4 = 5;
            }
            case "/":
            {
                alt4 = 6;
            }
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9":
            {
                alt4 = 7;
            }
            case "\t", "\n", "\r", " ":
            {
                alt4 = 8;
            }
            default:
                throw new NoViableAltException("", 4, 0, input);
        }
        
        switch (alt4)
        {
            case 1:
            // /Users/Roel/test.g:1:10: T__6
            {
                mT__6();
            }
            case 2:
            // /Users/Roel/test.g:1:15: T__7
            {
                mT__7();
            }
            case 3:
            // /Users/Roel/test.g:1:20: T__8
            {
                mT__8();
            }
            case 4:
            // /Users/Roel/test.g:1:25: T__9
            {
                mT__9();
            }
            case 5:
            // /Users/Roel/test.g:1:30: T__10
            {
                mT__10();
            }
            case 6:
            // /Users/Roel/test.g:1:36: T__11
            {
                mT__11();
            }
            case 7:
            // /Users/Roel/test.g:1:42: Number
            {
                mNumber();
            }
            case 8:
            // /Users/Roel/test.g:1:49: WS
            {
                mWS();
            }
        }
    }
}

