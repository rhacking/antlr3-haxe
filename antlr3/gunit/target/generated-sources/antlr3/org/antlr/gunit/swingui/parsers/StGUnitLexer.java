// $ANTLR 3.5.3-SNAPSHOT org/antlr/gunit/swingui/parsers/StGUnit.g 2017-06-11 18:43:44
package org.antlr.gunit.swingui.parsers;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class StGUnitLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int ACTION=4;
	public static final int AST=5;
	public static final int CHAR_LITERAL=6;
	public static final int DOC_COMMENT=7;
	public static final int ESC=8;
	public static final int EXT=9;
	public static final int FAIL=10;
	public static final int ML_COMMENT=11;
	public static final int ML_STRING=12;
	public static final int NESTED_ACTION=13;
	public static final int NESTED_AST=14;
	public static final int NESTED_RETVAL=15;
	public static final int OK=16;
	public static final int RETVAL=17;
	public static final int RULE_REF=18;
	public static final int SL_COMMENT=19;
	public static final int STRING=20;
	public static final int STRING_LITERAL=21;
	public static final int TOKEN_REF=22;
	public static final int WS=23;
	public static final int XDIGIT=24;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public StGUnitLexer() {} 
	public StGUnitLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public StGUnitLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "org/antlr/gunit/swingui/parsers/StGUnit.g"; }

	// $ANTLR start "FAIL"
	public final void mFAIL() throws RecognitionException {
		try {
			int _type = FAIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:9:6: ( 'FAIL' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:9:8: 'FAIL'
			{
			match("FAIL"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FAIL"

	// $ANTLR start "OK"
	public final void mOK() throws RecognitionException {
		try {
			int _type = OK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:10:4: ( 'OK' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:10:6: 'OK'
			{
			match("OK"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OK"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:11:7: ( '->' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:11:9: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:12:7: ( ':' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:12:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:13:7: ( ';' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:13:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:14:7: ( '@header' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:14:9: '@header'
			{
			match("@header"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:15:7: ( 'gunit' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:15:9: 'gunit'
			{
			match("gunit"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:16:7: ( 'returns' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:16:9: 'returns'
			{
			match("returns"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:17:7: ( 'walks' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:17:9: 'walks'
			{
			match("walks"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			int _type = SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:109:3: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:109:5: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// org/antlr/gunit/swingui/parsers/StGUnit.g:109:10: (~ ( '\\r' | '\\n' ) )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			// org/antlr/gunit/swingui/parsers/StGUnit.g:109:24: ( '\\r' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:109:24: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT"

	// $ANTLR start "ML_COMMENT"
	public final void mML_COMMENT() throws RecognitionException {
		try {
			int _type = ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:113:2: ( '/*' ( . )* '*/' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:113:4: '/*' ( . )* '*/'
			{
			match("/*"); 

			_channel=HIDDEN;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:113:28: ( . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='*') ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1=='/') ) {
						alt3=2;
					}
					else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
						alt3=1;
					}

				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:113:28: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
				}
			}

			match("*/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_COMMENT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:117:2: ( '\"' ( ESC |~ ( '\\\\' | '\"' ) )* '\"' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:117:4: '\"' ( ESC |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:117:8: ( ESC |~ ( '\\\\' | '\"' ) )*
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\\') ) {
					alt4=1;
				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:117:10: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:117:16: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "ML_STRING"
	public final void mML_STRING() throws RecognitionException {
		try {
			int _type = ML_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:121:2: ( '<<' ( . )* '>>' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:121:4: '<<' ( . )* '>>'
			{
			match("<<"); 

			// org/antlr/gunit/swingui/parsers/StGUnit.g:121:9: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='>') ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1=='>') ) {
						alt5=2;
					}
					else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '=')||(LA5_1 >= '?' && LA5_1 <= '\uFFFF')) ) {
						alt5=1;
					}

				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '=')||(LA5_0 >= '?' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:121:9: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match(">>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_STRING"

	// $ANTLR start "TOKEN_REF"
	public final void mTOKEN_REF() throws RecognitionException {
		try {
			int _type = TOKEN_REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:125:2: ( 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:125:4: 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
			matchRange('A','Z'); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:125:13: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop6;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TOKEN_REF"

	// $ANTLR start "RULE_REF"
	public final void mRULE_REF() throws RecognitionException {
		try {
			int _type = RULE_REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:129:2: ( 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:129:4: 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
			matchRange('a','z'); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:129:13: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop7;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_REF"

	// $ANTLR start "EXT"
	public final void mEXT() throws RecognitionException {
		try {
			int _type = EXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:132:5: ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:132:7: '.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			{
			match('.'); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:132:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXT"

	// $ANTLR start "RETVAL"
	public final void mRETVAL() throws RecognitionException {
		try {
			int _type = RETVAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:134:8: ( NESTED_RETVAL )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:134:10: NESTED_RETVAL
			{
			mNESTED_RETVAL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETVAL"

	// $ANTLR start "NESTED_RETVAL"
	public final void mNESTED_RETVAL() throws RecognitionException {
		try {
			// org/antlr/gunit/swingui/parsers/StGUnit.g:139:15: ( '[' ( options {greedy=false; } : NESTED_RETVAL | . )* ']' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:140:2: '[' ( options {greedy=false; } : NESTED_RETVAL | . )* ']'
			{
			match('['); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:141:2: ( options {greedy=false; } : NESTED_RETVAL | . )*
			loop9:
			while (true) {
				int alt9=3;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==']') ) {
					alt9=3;
				}
				else if ( (LA9_0=='[') ) {
					alt9=1;
				}
				else if ( ((LA9_0 >= '\u0000' && LA9_0 <= 'Z')||LA9_0=='\\'||(LA9_0 >= '^' && LA9_0 <= '\uFFFF')) ) {
					alt9=2;
				}

				switch (alt9) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:142:4: NESTED_RETVAL
					{
					mNESTED_RETVAL(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:143:4: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop9;
				}
			}

			match(']'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NESTED_RETVAL"

	// $ANTLR start "AST"
	public final void mAST() throws RecognitionException {
		try {
			int _type = AST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:147:5: ( NESTED_AST ( ( ' ' )? NESTED_AST )* )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:147:7: NESTED_AST ( ( ' ' )? NESTED_AST )*
			{
			mNESTED_AST(); 

			// org/antlr/gunit/swingui/parsers/StGUnit.g:147:18: ( ( ' ' )? NESTED_AST )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==' '||LA11_0=='(') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:147:19: ( ' ' )? NESTED_AST
					{
					// org/antlr/gunit/swingui/parsers/StGUnit.g:147:19: ( ' ' )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==' ') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// org/antlr/gunit/swingui/parsers/StGUnit.g:147:19: ' '
							{
							match(' '); 
							}
							break;

					}

					mNESTED_AST(); 

					}
					break;

				default :
					break loop11;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AST"

	// $ANTLR start "NESTED_AST"
	public final void mNESTED_AST() throws RecognitionException {
		try {
			// org/antlr/gunit/swingui/parsers/StGUnit.g:151:12: ( '(' ( options {greedy=false; } : NESTED_AST | . )* ')' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:152:2: '(' ( options {greedy=false; } : NESTED_AST | . )* ')'
			{
			match('('); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:153:2: ( options {greedy=false; } : NESTED_AST | . )*
			loop12:
			while (true) {
				int alt12=3;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==')') ) {
					alt12=3;
				}
				else if ( (LA12_0=='(') ) {
					alt12=1;
				}
				else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\'')||(LA12_0 >= '*' && LA12_0 <= '\uFFFF')) ) {
					alt12=2;
				}

				switch (alt12) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:154:4: NESTED_AST
					{
					mNESTED_AST(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:155:4: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop12;
				}
			}

			match(')'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NESTED_AST"

	// $ANTLR start "ACTION"
	public final void mACTION() throws RecognitionException {
		try {
			int _type = ACTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:160:2: ( NESTED_ACTION )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:160:4: NESTED_ACTION
			{
			mNESTED_ACTION(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTION"

	// $ANTLR start "NESTED_ACTION"
	public final void mNESTED_ACTION() throws RecognitionException {
		try {
			// org/antlr/gunit/swingui/parsers/StGUnit.g:165:15: ( '{' ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )* '}' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:166:2: '{' ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )* '}'
			{
			match('{'); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:167:2: ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )*
			loop13:
			while (true) {
				int alt13=5;
				alt13 = dfa13.predict(input);
				switch (alt13) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:168:4: NESTED_ACTION
					{
					mNESTED_ACTION(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:169:4: STRING_LITERAL
					{
					mSTRING_LITERAL(); 

					}
					break;
				case 3 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:170:4: CHAR_LITERAL
					{
					mCHAR_LITERAL(); 

					}
					break;
				case 4 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:171:4: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop13;
				}
			}

			match('}'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NESTED_ACTION"

	// $ANTLR start "CHAR_LITERAL"
	public final void mCHAR_LITERAL() throws RecognitionException {
		try {
			// org/antlr/gunit/swingui/parsers/StGUnit.g:178:2: ( '\\'' ( ESC |~ ( '\\'' | '\\\\' ) ) '\\'' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:178:4: '\\'' ( ESC |~ ( '\\'' | '\\\\' ) ) '\\''
			{
			match('\''); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:178:9: ( ESC |~ ( '\\'' | '\\\\' ) )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='\\') ) {
				alt14=1;
			}
			else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '&')||(LA14_0 >= '(' && LA14_0 <= '[')||(LA14_0 >= ']' && LA14_0 <= '\uFFFF')) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:178:11: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:178:17: ~ ( '\\'' | '\\\\' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			match('\''); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR_LITERAL"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			// org/antlr/gunit/swingui/parsers/StGUnit.g:183:2: ( '\"' ( ESC |~ ( '\\\\' | '\"' ) )* '\"' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:183:4: '\"' ( ESC |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:183:8: ( ESC |~ ( '\\\\' | '\"' ) )*
			loop15:
			while (true) {
				int alt15=3;
				int LA15_0 = input.LA(1);
				if ( (LA15_0=='\\') ) {
					alt15=1;
				}
				else if ( ((LA15_0 >= '\u0000' && LA15_0 <= '!')||(LA15_0 >= '#' && LA15_0 <= '[')||(LA15_0 >= ']' && LA15_0 <= '\uFFFF')) ) {
					alt15=2;
				}

				switch (alt15) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:183:10: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:183:16: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop15;
				}
			}

			match('\"'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "ESC"
	public final void mESC() throws RecognitionException {
		try {
			// org/antlr/gunit/swingui/parsers/StGUnit.g:187:5: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . ) )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:187:7: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
			{
			match('\\'); 
			// org/antlr/gunit/swingui/parsers/StGUnit.g:188:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
			int alt16=11;
			int LA16_0 = input.LA(1);
			if ( (LA16_0=='n') ) {
				alt16=1;
			}
			else if ( (LA16_0=='r') ) {
				alt16=2;
			}
			else if ( (LA16_0=='t') ) {
				alt16=3;
			}
			else if ( (LA16_0=='b') ) {
				alt16=4;
			}
			else if ( (LA16_0=='f') ) {
				alt16=5;
			}
			else if ( (LA16_0=='\"') ) {
				alt16=6;
			}
			else if ( (LA16_0=='\'') ) {
				alt16=7;
			}
			else if ( (LA16_0=='\\') ) {
				alt16=8;
			}
			else if ( (LA16_0=='>') ) {
				alt16=9;
			}
			else if ( (LA16_0=='u') ) {
				int LA16_10 = input.LA(2);
				if ( ((LA16_10 >= '0' && LA16_10 <= '9')||(LA16_10 >= 'A' && LA16_10 <= 'F')||(LA16_10 >= 'a' && LA16_10 <= 'f')) ) {
					alt16=10;
				}

				else {
					alt16=11;
				}

			}
			else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '!')||(LA16_0 >= '#' && LA16_0 <= '&')||(LA16_0 >= '(' && LA16_0 <= '=')||(LA16_0 >= '?' && LA16_0 <= '[')||(LA16_0 >= ']' && LA16_0 <= 'a')||(LA16_0 >= 'c' && LA16_0 <= 'e')||(LA16_0 >= 'g' && LA16_0 <= 'm')||(LA16_0 >= 'o' && LA16_0 <= 'q')||LA16_0=='s'||(LA16_0 >= 'v' && LA16_0 <= '\uFFFF')) ) {
				alt16=11;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:188:5: 'n'
					{
					match('n'); 
					}
					break;
				case 2 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:189:5: 'r'
					{
					match('r'); 
					}
					break;
				case 3 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:190:5: 't'
					{
					match('t'); 
					}
					break;
				case 4 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:191:5: 'b'
					{
					match('b'); 
					}
					break;
				case 5 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:192:5: 'f'
					{
					match('f'); 
					}
					break;
				case 6 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:193:5: '\"'
					{
					match('\"'); 
					}
					break;
				case 7 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:194:5: '\\''
					{
					match('\''); 
					}
					break;
				case 8 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:195:5: '\\\\'
					{
					match('\\'); 
					}
					break;
				case 9 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:196:5: '>'
					{
					match('>'); 
					}
					break;
				case 10 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:197:5: 'u' XDIGIT XDIGIT XDIGIT XDIGIT
					{
					match('u'); 
					mXDIGIT(); 

					mXDIGIT(); 

					mXDIGIT(); 

					mXDIGIT(); 

					}
					break;
				case 11 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:198:5: .
					{
					matchAny(); 
					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC"

	// $ANTLR start "XDIGIT"
	public final void mXDIGIT() throws RecognitionException {
		try {
			// org/antlr/gunit/swingui/parsers/StGUnit.g:203:8: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "XDIGIT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/swingui/parsers/StGUnit.g:208:4: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' )+ )
			// org/antlr/gunit/swingui/parsers/StGUnit.g:208:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
			{
			// org/antlr/gunit/swingui/parsers/StGUnit.g:208:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=4;
				switch ( input.LA(1) ) {
				case ' ':
					{
					alt18=1;
					}
					break;
				case '\t':
					{
					alt18=2;
					}
					break;
				case '\n':
				case '\r':
					{
					alt18=3;
					}
					break;
				}
				switch (alt18) {
				case 1 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:208:8: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:209:5: '\\t'
					{
					match('\t'); 
					}
					break;
				case 3 :
					// org/antlr/gunit/swingui/parsers/StGUnit.g:210:5: ( '\\r' )? '\\n'
					{
					// org/antlr/gunit/swingui/parsers/StGUnit.g:210:5: ( '\\r' )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0=='\r') ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// org/antlr/gunit/swingui/parsers/StGUnit.g:210:5: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// org/antlr/gunit/swingui/parsers/StGUnit.g:1:8: ( FAIL | OK | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | SL_COMMENT | ML_COMMENT | STRING | ML_STRING | TOKEN_REF | RULE_REF | EXT | RETVAL | AST | ACTION | WS )
		int alt19=20;
		switch ( input.LA(1) ) {
		case 'F':
			{
			int LA19_1 = input.LA(2);
			if ( (LA19_1=='A') ) {
				int LA19_20 = input.LA(3);
				if ( (LA19_20=='I') ) {
					int LA19_27 = input.LA(4);
					if ( (LA19_27=='L') ) {
						int LA19_32 = input.LA(5);
						if ( ((LA19_32 >= '0' && LA19_32 <= '9')||(LA19_32 >= 'A' && LA19_32 <= 'Z')||LA19_32=='_'||(LA19_32 >= 'a' && LA19_32 <= 'z')) ) {
							alt19=14;
						}

						else {
							alt19=1;
						}

					}

					else {
						alt19=14;
					}

				}

				else {
					alt19=14;
				}

			}

			else {
				alt19=14;
			}

			}
			break;
		case 'O':
			{
			int LA19_2 = input.LA(2);
			if ( (LA19_2=='K') ) {
				int LA19_21 = input.LA(3);
				if ( ((LA19_21 >= '0' && LA19_21 <= '9')||(LA19_21 >= 'A' && LA19_21 <= 'Z')||LA19_21=='_'||(LA19_21 >= 'a' && LA19_21 <= 'z')) ) {
					alt19=14;
				}

				else {
					alt19=2;
				}

			}

			else {
				alt19=14;
			}

			}
			break;
		case '-':
			{
			alt19=3;
			}
			break;
		case ':':
			{
			alt19=4;
			}
			break;
		case ';':
			{
			alt19=5;
			}
			break;
		case '@':
			{
			alt19=6;
			}
			break;
		case 'g':
			{
			int LA19_7 = input.LA(2);
			if ( (LA19_7=='u') ) {
				int LA19_22 = input.LA(3);
				if ( (LA19_22=='n') ) {
					int LA19_29 = input.LA(4);
					if ( (LA19_29=='i') ) {
						int LA19_33 = input.LA(5);
						if ( (LA19_33=='t') ) {
							int LA19_37 = input.LA(6);
							if ( ((LA19_37 >= '0' && LA19_37 <= '9')||(LA19_37 >= 'A' && LA19_37 <= 'Z')||LA19_37=='_'||(LA19_37 >= 'a' && LA19_37 <= 'z')) ) {
								alt19=15;
							}

							else {
								alt19=7;
							}

						}

						else {
							alt19=15;
						}

					}

					else {
						alt19=15;
					}

				}

				else {
					alt19=15;
				}

			}

			else {
				alt19=15;
			}

			}
			break;
		case 'r':
			{
			int LA19_8 = input.LA(2);
			if ( (LA19_8=='e') ) {
				int LA19_23 = input.LA(3);
				if ( (LA19_23=='t') ) {
					int LA19_30 = input.LA(4);
					if ( (LA19_30=='u') ) {
						int LA19_34 = input.LA(5);
						if ( (LA19_34=='r') ) {
							int LA19_38 = input.LA(6);
							if ( (LA19_38=='n') ) {
								int LA19_41 = input.LA(7);
								if ( (LA19_41=='s') ) {
									int LA19_43 = input.LA(8);
									if ( ((LA19_43 >= '0' && LA19_43 <= '9')||(LA19_43 >= 'A' && LA19_43 <= 'Z')||LA19_43=='_'||(LA19_43 >= 'a' && LA19_43 <= 'z')) ) {
										alt19=15;
									}

									else {
										alt19=8;
									}

								}

								else {
									alt19=15;
								}

							}

							else {
								alt19=15;
							}

						}

						else {
							alt19=15;
						}

					}

					else {
						alt19=15;
					}

				}

				else {
					alt19=15;
				}

			}

			else {
				alt19=15;
			}

			}
			break;
		case 'w':
			{
			int LA19_9 = input.LA(2);
			if ( (LA19_9=='a') ) {
				int LA19_24 = input.LA(3);
				if ( (LA19_24=='l') ) {
					int LA19_31 = input.LA(4);
					if ( (LA19_31=='k') ) {
						int LA19_35 = input.LA(5);
						if ( (LA19_35=='s') ) {
							int LA19_39 = input.LA(6);
							if ( ((LA19_39 >= '0' && LA19_39 <= '9')||(LA19_39 >= 'A' && LA19_39 <= 'Z')||LA19_39=='_'||(LA19_39 >= 'a' && LA19_39 <= 'z')) ) {
								alt19=15;
							}

							else {
								alt19=9;
							}

						}

						else {
							alt19=15;
						}

					}

					else {
						alt19=15;
					}

				}

				else {
					alt19=15;
				}

			}

			else {
				alt19=15;
			}

			}
			break;
		case '/':
			{
			int LA19_10 = input.LA(2);
			if ( (LA19_10=='/') ) {
				alt19=10;
			}
			else if ( (LA19_10=='*') ) {
				alt19=11;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 19, 10, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case '\"':
			{
			alt19=12;
			}
			break;
		case '<':
			{
			alt19=13;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			{
			alt19=14;
			}
			break;
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'x':
		case 'y':
		case 'z':
			{
			alt19=15;
			}
			break;
		case '.':
			{
			alt19=16;
			}
			break;
		case '[':
			{
			alt19=17;
			}
			break;
		case '(':
			{
			alt19=18;
			}
			break;
		case '{':
			{
			alt19=19;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt19=20;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 19, 0, input);
			throw nvae;
		}
		switch (alt19) {
			case 1 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:10: FAIL
				{
				mFAIL(); 

				}
				break;
			case 2 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:15: OK
				{
				mOK(); 

				}
				break;
			case 3 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:18: T__25
				{
				mT__25(); 

				}
				break;
			case 4 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:24: T__26
				{
				mT__26(); 

				}
				break;
			case 5 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:30: T__27
				{
				mT__27(); 

				}
				break;
			case 6 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:36: T__28
				{
				mT__28(); 

				}
				break;
			case 7 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:42: T__29
				{
				mT__29(); 

				}
				break;
			case 8 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:48: T__30
				{
				mT__30(); 

				}
				break;
			case 9 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:54: T__31
				{
				mT__31(); 

				}
				break;
			case 10 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:60: SL_COMMENT
				{
				mSL_COMMENT(); 

				}
				break;
			case 11 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:71: ML_COMMENT
				{
				mML_COMMENT(); 

				}
				break;
			case 12 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:82: STRING
				{
				mSTRING(); 

				}
				break;
			case 13 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:89: ML_STRING
				{
				mML_STRING(); 

				}
				break;
			case 14 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:99: TOKEN_REF
				{
				mTOKEN_REF(); 

				}
				break;
			case 15 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:109: RULE_REF
				{
				mRULE_REF(); 

				}
				break;
			case 16 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:118: EXT
				{
				mEXT(); 

				}
				break;
			case 17 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:122: RETVAL
				{
				mRETVAL(); 

				}
				break;
			case 18 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:129: AST
				{
				mAST(); 

				}
				break;
			case 19 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:133: ACTION
				{
				mACTION(); 

				}
				break;
			case 20 :
				// org/antlr/gunit/swingui/parsers/StGUnit.g:1:140: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA13_eotS =
		"\116\uffff";
	static final String DFA13_eofS =
		"\116\uffff";
	static final String DFA13_minS =
		"\1\0\2\uffff\2\0\1\uffff\1\0\2\uffff\4\0\1\uffff\3\0\75\uffff";
	static final String DFA13_maxS =
		"\1\uffff\2\uffff\2\uffff\1\uffff\1\uffff\2\uffff\4\uffff\1\uffff\3\uffff"+
		"\75\uffff";
	static final String DFA13_acceptS =
		"\1\uffff\1\5\1\1\2\uffff\1\4\1\uffff\1\4\1\2\4\uffff\1\4\4\uffff\37\2"+
		"\16\3\4\uffff\1\3\5\uffff\1\3\4\uffff";
	static final String DFA13_specialS =
		"\1\0\2\uffff\1\1\1\2\1\uffff\1\3\2\uffff\1\4\1\5\1\6\1\7\1\uffff\1\10"+
		"\1\11\1\12\75\uffff}>";
	static final String[] DFA13_transitionS = {
			"\42\5\1\3\4\5\1\4\123\5\1\2\1\5\1\1\uff82\5",
			"",
			"",
			"\42\13\1\10\4\13\1\12\64\13\1\6\36\13\1\11\1\13\1\7\uff82\13",
			"\42\20\1\17\4\20\1\5\64\20\1\14\36\20\1\16\1\20\1\15\uff82\20",
			"",
			"\42\36\1\27\4\36\1\30\26\36\1\32\35\36\1\31\5\36\1\25\3\36\1\26\7\36"+
			"\1\22\3\36\1\23\1\36\1\24\1\33\5\36\1\35\1\36\1\34\uff82\36",
			"",
			"",
			"\42\44\1\37\4\44\1\42\64\44\1\40\36\44\1\41\1\44\1\43\uff82\44",
			"\42\52\1\45\4\52\1\50\64\52\1\46\36\52\1\51\1\52\1\47\uff82\52",
			"\42\60\1\53\4\60\1\57\64\60\1\54\36\60\1\56\1\60\1\55\uff82\60",
			"\42\75\1\66\4\75\1\67\26\75\1\71\35\75\1\70\5\75\1\64\3\75\1\65\7\75"+
			"\1\61\3\75\1\62\1\75\1\63\1\72\5\75\1\74\1\75\1\73\uff82\75",
			"",
			"\47\5\1\76\uffd8\5",
			"\47\5\1\103\uffd8\5",
			"\47\5\1\111\uffd8\5",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 167:2: ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA13_0 = input.LA(1);
						s = -1;
						if ( (LA13_0=='}') ) {s = 1;}
						else if ( (LA13_0=='{') ) {s = 2;}
						else if ( (LA13_0=='\"') ) {s = 3;}
						else if ( (LA13_0=='\'') ) {s = 4;}
						else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '!')||(LA13_0 >= '#' && LA13_0 <= '&')||(LA13_0 >= '(' && LA13_0 <= 'z')||LA13_0=='|'||(LA13_0 >= '~' && LA13_0 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA13_3 = input.LA(1);
						s = -1;
						if ( (LA13_3=='\\') ) {s = 6;}
						else if ( (LA13_3=='}') ) {s = 7;}
						else if ( (LA13_3=='\"') ) {s = 8;}
						else if ( (LA13_3=='{') ) {s = 9;}
						else if ( (LA13_3=='\'') ) {s = 10;}
						else if ( ((LA13_3 >= '\u0000' && LA13_3 <= '!')||(LA13_3 >= '#' && LA13_3 <= '&')||(LA13_3 >= '(' && LA13_3 <= '[')||(LA13_3 >= ']' && LA13_3 <= 'z')||LA13_3=='|'||(LA13_3 >= '~' && LA13_3 <= '\uFFFF')) ) {s = 11;}
						if ( s>=0 ) return s;
						break;
					case 2 : 
						int LA13_4 = input.LA(1);
						s = -1;
						if ( (LA13_4=='\\') ) {s = 12;}
						else if ( (LA13_4=='}') ) {s = 13;}
						else if ( (LA13_4=='{') ) {s = 14;}
						else if ( (LA13_4=='\"') ) {s = 15;}
						else if ( ((LA13_4 >= '\u0000' && LA13_4 <= '!')||(LA13_4 >= '#' && LA13_4 <= '&')||(LA13_4 >= '(' && LA13_4 <= '[')||(LA13_4 >= ']' && LA13_4 <= 'z')||LA13_4=='|'||(LA13_4 >= '~' && LA13_4 <= '\uFFFF')) ) {s = 16;}
						else if ( (LA13_4=='\'') ) {s = 5;}
						if ( s>=0 ) return s;
						break;
					case 3 : 
						int LA13_6 = input.LA(1);
						s = -1;
						if ( (LA13_6=='n') ) {s = 18;}
						else if ( (LA13_6=='r') ) {s = 19;}
						else if ( (LA13_6=='t') ) {s = 20;}
						else if ( (LA13_6=='b') ) {s = 21;}
						else if ( (LA13_6=='f') ) {s = 22;}
						else if ( (LA13_6=='\"') ) {s = 23;}
						else if ( (LA13_6=='\'') ) {s = 24;}
						else if ( (LA13_6=='\\') ) {s = 25;}
						else if ( (LA13_6=='>') ) {s = 26;}
						else if ( (LA13_6=='u') ) {s = 27;}
						else if ( (LA13_6=='}') ) {s = 28;}
						else if ( (LA13_6=='{') ) {s = 29;}
						else if ( ((LA13_6 >= '\u0000' && LA13_6 <= '!')||(LA13_6 >= '#' && LA13_6 <= '&')||(LA13_6 >= '(' && LA13_6 <= '=')||(LA13_6 >= '?' && LA13_6 <= '[')||(LA13_6 >= ']' && LA13_6 <= 'a')||(LA13_6 >= 'c' && LA13_6 <= 'e')||(LA13_6 >= 'g' && LA13_6 <= 'm')||(LA13_6 >= 'o' && LA13_6 <= 'q')||LA13_6=='s'||(LA13_6 >= 'v' && LA13_6 <= 'z')||LA13_6=='|'||(LA13_6 >= '~' && LA13_6 <= '\uFFFF')) ) {s = 30;}
						if ( s>=0 ) return s;
						break;
					case 4 : 
						int LA13_9 = input.LA(1);
						s = -1;
						if ( (LA13_9=='\"') ) {s = 31;}
						else if ( (LA13_9=='\\') ) {s = 32;}
						else if ( (LA13_9=='{') ) {s = 33;}
						else if ( (LA13_9=='\'') ) {s = 34;}
						else if ( (LA13_9=='}') ) {s = 35;}
						else if ( ((LA13_9 >= '\u0000' && LA13_9 <= '!')||(LA13_9 >= '#' && LA13_9 <= '&')||(LA13_9 >= '(' && LA13_9 <= '[')||(LA13_9 >= ']' && LA13_9 <= 'z')||LA13_9=='|'||(LA13_9 >= '~' && LA13_9 <= '\uFFFF')) ) {s = 36;}
						if ( s>=0 ) return s;
						break;
					case 5 : 
						int LA13_10 = input.LA(1);
						s = -1;
						if ( (LA13_10=='\"') ) {s = 37;}
						else if ( (LA13_10=='\\') ) {s = 38;}
						else if ( (LA13_10=='}') ) {s = 39;}
						else if ( (LA13_10=='\'') ) {s = 40;}
						else if ( (LA13_10=='{') ) {s = 41;}
						else if ( ((LA13_10 >= '\u0000' && LA13_10 <= '!')||(LA13_10 >= '#' && LA13_10 <= '&')||(LA13_10 >= '(' && LA13_10 <= '[')||(LA13_10 >= ']' && LA13_10 <= 'z')||LA13_10=='|'||(LA13_10 >= '~' && LA13_10 <= '\uFFFF')) ) {s = 42;}
						if ( s>=0 ) return s;
						break;
					case 6 : 
						int LA13_11 = input.LA(1);
						s = -1;
						if ( (LA13_11=='\"') ) {s = 43;}
						else if ( (LA13_11=='\\') ) {s = 44;}
						else if ( (LA13_11=='}') ) {s = 45;}
						else if ( (LA13_11=='{') ) {s = 46;}
						else if ( (LA13_11=='\'') ) {s = 47;}
						else if ( ((LA13_11 >= '\u0000' && LA13_11 <= '!')||(LA13_11 >= '#' && LA13_11 <= '&')||(LA13_11 >= '(' && LA13_11 <= '[')||(LA13_11 >= ']' && LA13_11 <= 'z')||LA13_11=='|'||(LA13_11 >= '~' && LA13_11 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;
					case 7 : 
						int LA13_12 = input.LA(1);
						s = -1;
						if ( (LA13_12=='n') ) {s = 49;}
						else if ( (LA13_12=='r') ) {s = 50;}
						else if ( (LA13_12=='t') ) {s = 51;}
						else if ( (LA13_12=='b') ) {s = 52;}
						else if ( (LA13_12=='f') ) {s = 53;}
						else if ( (LA13_12=='\"') ) {s = 54;}
						else if ( (LA13_12=='\'') ) {s = 55;}
						else if ( (LA13_12=='\\') ) {s = 56;}
						else if ( (LA13_12=='>') ) {s = 57;}
						else if ( (LA13_12=='u') ) {s = 58;}
						else if ( (LA13_12=='}') ) {s = 59;}
						else if ( (LA13_12=='{') ) {s = 60;}
						else if ( ((LA13_12 >= '\u0000' && LA13_12 <= '!')||(LA13_12 >= '#' && LA13_12 <= '&')||(LA13_12 >= '(' && LA13_12 <= '=')||(LA13_12 >= '?' && LA13_12 <= '[')||(LA13_12 >= ']' && LA13_12 <= 'a')||(LA13_12 >= 'c' && LA13_12 <= 'e')||(LA13_12 >= 'g' && LA13_12 <= 'm')||(LA13_12 >= 'o' && LA13_12 <= 'q')||LA13_12=='s'||(LA13_12 >= 'v' && LA13_12 <= 'z')||LA13_12=='|'||(LA13_12 >= '~' && LA13_12 <= '\uFFFF')) ) {s = 61;}
						if ( s>=0 ) return s;
						break;
					case 8 : 
						int LA13_14 = input.LA(1);
						s = -1;
						if ( (LA13_14=='\'') ) {s = 62;}
						else if ( ((LA13_14 >= '\u0000' && LA13_14 <= '&')||(LA13_14 >= '(' && LA13_14 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
					case 9 : 
						int LA13_15 = input.LA(1);
						s = -1;
						if ( (LA13_15=='\'') ) {s = 67;}
						else if ( ((LA13_15 >= '\u0000' && LA13_15 <= '&')||(LA13_15 >= '(' && LA13_15 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
					case 10 : 
						int LA13_16 = input.LA(1);
						s = -1;
						if ( (LA13_16=='\'') ) {s = 73;}
						else if ( ((LA13_16 >= '\u0000' && LA13_16 <= '&')||(LA13_16 >= '(' && LA13_16 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 13, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
