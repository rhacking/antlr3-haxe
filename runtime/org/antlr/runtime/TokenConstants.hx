package org.antlr.runtime;


class TokenConstants
{
    public static inline var EOR_TOKEN_TYPE : Int = 1;
    
    /** imaginary tree navigation type; traverse "get child" link */
    public static inline var DOWN : Int = 2;
    /** imaginary tree navigation type; finish with a child list */
    public static inline var UP : Int = 3;
    
    public static var MIN_TOKEN_TYPE : Int = UP + 1;
    
    public static var EOF : Int = CharStreamConstants.EOF;
    public static var EOF_TOKEN : Token = new CommonToken(EOF);
    
    public static inline var INVALID_TOKEN_TYPE : Int = 0;
    public static var INVALID_TOKEN : Token = new CommonToken(INVALID_TOKEN_TYPE);
    
    /** In an action, a lexer rule can set token to this SKIP_TOKEN and ANTLR
		 *  will avoid creating a token for this symbol and try to fetch another.
		 */
    public static var SKIP_TOKEN : Token = new CommonToken(INVALID_TOKEN_TYPE);
    
    /** All tokens go to the parser (unless skip() is called in that rule)
		 *  on a particular "channel".  The parser tunes to a particular channel
		 *  so that whitespace etc... can go to the parser on a "hidden" channel.
		 */
    public static inline var DEFAULT_CHANNEL : Int = 0;
    
    /** Anything on different channel than DEFAULT_CHANNEL is not parsed
		 *  by parser.
		 */
    public static inline var HIDDEN_CHANNEL : Int = 99;

    public function new()
    {
    }
}
