// $ANTLR 3.5.3-SNAPSHOT org/antlr/gunit/gUnit.g 2017-06-11 18:43:43

package org.antlr.gunit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class gUnitLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
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
	public static final int OPTIONS=17;
	public static final int RETVAL=18;
	public static final int RULE_REF=19;
	public static final int SL_COMMENT=20;
	public static final int STRING=21;
	public static final int STRING_LITERAL=22;
	public static final int TOKEN_REF=23;
	public static final int WS=24;
	public static final int XDIGIT=25;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public gUnitLexer() {} 
	public gUnitLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public gUnitLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "org/antlr/gunit/gUnit.g"; }

	// $ANTLR start "FAIL"
	public final void mFAIL() throws RecognitionException {
		try {
			int _type = FAIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:14:6: ( 'FAIL' )
			// org/antlr/gunit/gUnit.g:14:8: 'FAIL'
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
			// org/antlr/gunit/gUnit.g:15:4: ( 'OK' )
			// org/antlr/gunit/gUnit.g:15:6: 'OK'
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

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:16:7: ( '->' )
			// org/antlr/gunit/gUnit.g:16:9: '->'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:17:7: ( ':' )
			// org/antlr/gunit/gUnit.g:17:9: ':'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:18:7: ( ';' )
			// org/antlr/gunit/gUnit.g:18:9: ';'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:19:7: ( '=' )
			// org/antlr/gunit/gUnit.g:19:9: '='
			{
			match('='); 
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
			// org/antlr/gunit/gUnit.g:20:7: ( '@header' )
			// org/antlr/gunit/gUnit.g:20:9: '@header'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:21:7: ( 'gunit' )
			// org/antlr/gunit/gUnit.g:21:9: 'gunit'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:22:7: ( 'returns' )
			// org/antlr/gunit/gUnit.g:22:9: 'returns'
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:23:7: ( 'walks' )
			// org/antlr/gunit/gUnit.g:23:9: 'walks'
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
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:24:7: ( '}' )
			// org/antlr/gunit/gUnit.g:24:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			int _type = SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:183:3: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n' )
			// org/antlr/gunit/gUnit.g:183:5: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// org/antlr/gunit/gUnit.g:183:10: (~ ( '\\r' | '\\n' ) )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// org/antlr/gunit/gUnit.g:
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

			// org/antlr/gunit/gUnit.g:183:24: ( '\\r' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/gunit/gUnit.g:183:24: '\\r'
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
			// org/antlr/gunit/gUnit.g:187:2: ( '/*' ( . )* '*/' )
			// org/antlr/gunit/gUnit.g:187:4: '/*' ( . )* '*/'
			{
			match("/*"); 

			_channel=HIDDEN;
			// org/antlr/gunit/gUnit.g:187:28: ( . )*
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
					// org/antlr/gunit/gUnit.g:187:28: .
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
			// org/antlr/gunit/gUnit.g:190:8: ( '\"' ( ESC |~ ( '\\\\' | '\"' ) )* '\"' )
			// org/antlr/gunit/gUnit.g:190:10: '\"' ( ESC |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// org/antlr/gunit/gUnit.g:190:14: ( ESC |~ ( '\\\\' | '\"' ) )*
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
					// org/antlr/gunit/gUnit.g:190:16: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:190:22: ~ ( '\\\\' | '\"' )
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
			setText(getText().substring(1, getText().length()-1));
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
			// org/antlr/gunit/gUnit.g:194:2: ( '<<' ( . )* '>>' )
			// org/antlr/gunit/gUnit.g:194:4: '<<' ( . )* '>>'
			{
			// we need to determine the number of spaces or tabs (indentation) for multi-line input
					StringBuffer buf = new StringBuffer();
					int i = -1;
					int c = input.LA(-1);
					while ( c==' ' || c=='\t' ) {
						buf.append((char)c);
						c = input.LA(--i);
					}
					String indentation = buf.reverse().toString();
					
			match("<<"); 

			// org/antlr/gunit/gUnit.g:204:8: ( . )*
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
					// org/antlr/gunit/gUnit.g:204:8: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match(">>"); 

			// also determine the appropriate newline separator and get info of the first and last 2 characters (exclude '<<' and '>>')
					String newline = System.getProperty("line.separator");
					String front, end;
					int oldFrontIndex = 2;
					int oldEndIndex = getText().length()-2;
					int newFrontIndex, newEndIndex;
					if ( newline.length()==1 ) {
						front = getText().substring(2, 3);
						end = getText().substring(getText().length()-3, getText().length()-2);
						newFrontIndex = 3;
						newEndIndex = getText().length()-3;
					}
					else {// must be 2, e.g. Windows System which uses \r\n as a line separator
						front = getText().substring(2, 4);
						end = getText().substring(getText().length()-4, getText().length()-2);
						newFrontIndex = 4;
						newEndIndex = getText().length()-4;
					}
					// strip unwanted characters, e.g. '<<' (including a newline after it) or '>>'  (including a newline before it)
					String temp = null;
					if ( front.equals(newline) && end.equals(newline) ) {
						// need to handle the special case: <<\n>> or <<\r\n>>
						if ( newline.length()==1 && getText().length()==5 ) temp = "";
						else if ( newline.length()==2 && getText().length()==6 ) temp = "";
						else temp = getText().substring(newFrontIndex, newEndIndex);
					}
					else if ( front.equals(newline) ) {
						temp = getText().substring(newFrontIndex, oldEndIndex);
					}
					else if ( end.equals(newline) ) {
						temp = getText().substring(oldFrontIndex, newEndIndex);
					}
					else {
						temp = getText().substring(oldFrontIndex, oldEndIndex);
					}
					// finally we need to prpcess the indentation line by line
					BufferedReader bufReader = new BufferedReader(new StringReader(temp));
					buf = new StringBuffer();
					String line = null;
					int count = 0;
					try {
						while((line = bufReader.readLine()) != null) {
							if ( line.startsWith(indentation) ) line = line.substring(indentation.length());
							if ( count>0 ) buf.append(newline);
							buf.append(line);
							count++;
						}
						setText(buf.toString());
					}
					catch (IOException ioe) {
						setText(temp);
					}
					
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
			// org/antlr/gunit/gUnit.g:261:2: ( 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// org/antlr/gunit/gUnit.g:261:4: 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
			matchRange('A','Z'); 
			// org/antlr/gunit/gUnit.g:261:13: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// org/antlr/gunit/gUnit.g:
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
			// org/antlr/gunit/gUnit.g:265:2: ( 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// org/antlr/gunit/gUnit.g:265:4: 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
			matchRange('a','z'); 
			// org/antlr/gunit/gUnit.g:265:13: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// org/antlr/gunit/gUnit.g:
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
			// org/antlr/gunit/gUnit.g:268:5: ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
			// org/antlr/gunit/gUnit.g:268:7: '.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			{
			match('.'); 
			// org/antlr/gunit/gUnit.g:268:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
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
					// org/antlr/gunit/gUnit.g:
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
			// org/antlr/gunit/gUnit.g:270:8: ( NESTED_RETVAL )
			// org/antlr/gunit/gUnit.g:270:10: NESTED_RETVAL
			{
			mNESTED_RETVAL(); 

			setText(getText().substring(1, getText().length()-1));
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
			// org/antlr/gunit/gUnit.g:275:15: ( '[' ( options {greedy=false; } : NESTED_RETVAL | . )* ']' )
			// org/antlr/gunit/gUnit.g:276:2: '[' ( options {greedy=false; } : NESTED_RETVAL | . )* ']'
			{
			match('['); 
			// org/antlr/gunit/gUnit.g:277:2: ( options {greedy=false; } : NESTED_RETVAL | . )*
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
					// org/antlr/gunit/gUnit.g:278:4: NESTED_RETVAL
					{
					mNESTED_RETVAL(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:279:4: .
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
			// org/antlr/gunit/gUnit.g:283:5: ( NESTED_AST ( ( ' ' )? NESTED_AST )* )
			// org/antlr/gunit/gUnit.g:283:7: NESTED_AST ( ( ' ' )? NESTED_AST )*
			{
			mNESTED_AST(); 

			// org/antlr/gunit/gUnit.g:283:18: ( ( ' ' )? NESTED_AST )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==' '||LA11_0=='(') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// org/antlr/gunit/gUnit.g:283:19: ( ' ' )? NESTED_AST
					{
					// org/antlr/gunit/gUnit.g:283:19: ( ' ' )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==' ') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// org/antlr/gunit/gUnit.g:283:19: ' '
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
			// org/antlr/gunit/gUnit.g:287:12: ( '(' ( NESTED_AST | STRING_LITERAL |~ ( '(' | ')' | '\"' ) )* ')' )
			// org/antlr/gunit/gUnit.g:288:2: '(' ( NESTED_AST | STRING_LITERAL |~ ( '(' | ')' | '\"' ) )* ')'
			{
			match('('); 
			// org/antlr/gunit/gUnit.g:289:2: ( NESTED_AST | STRING_LITERAL |~ ( '(' | ')' | '\"' ) )*
			loop12:
			while (true) {
				int alt12=4;
				int LA12_0 = input.LA(1);
				if ( (LA12_0=='(') ) {
					alt12=1;
				}
				else if ( (LA12_0=='\"') ) {
					alt12=2;
				}
				else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '!')||(LA12_0 >= '#' && LA12_0 <= '\'')||(LA12_0 >= '*' && LA12_0 <= '\uFFFF')) ) {
					alt12=3;
				}

				switch (alt12) {
				case 1 :
					// org/antlr/gunit/gUnit.g:289:4: NESTED_AST
					{
					mNESTED_AST(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:290:6: STRING_LITERAL
					{
					mSTRING_LITERAL(); 

					}
					break;
				case 3 :
					// org/antlr/gunit/gUnit.g:291:4: ~ ( '(' | ')' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\'')||(input.LA(1) >= '*' && input.LA(1) <= '\uFFFF') ) {
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

	// $ANTLR start "OPTIONS"
	public final void mOPTIONS() throws RecognitionException {
		try {
			int _type = OPTIONS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:295:9: ( 'options' ( WS )* '{' )
			// org/antlr/gunit/gUnit.g:295:11: 'options' ( WS )* '{'
			{
			match("options"); 

			// org/antlr/gunit/gUnit.g:295:21: ( WS )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '\t' && LA13_0 <= '\n')||LA13_0=='\r'||LA13_0==' ') ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// org/antlr/gunit/gUnit.g:295:21: WS
					{
					mWS(); 

					}
					break;

				default :
					break loop13;
				}
			}

			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPTIONS"

	// $ANTLR start "ACTION"
	public final void mACTION() throws RecognitionException {
		try {
			int _type = ACTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/gunit/gUnit.g:299:2: ( NESTED_ACTION )
			// org/antlr/gunit/gUnit.g:299:4: NESTED_ACTION
			{
			mNESTED_ACTION(); 

			setText(getText().substring(1, getText().length()-1));
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
			// org/antlr/gunit/gUnit.g:304:15: ( '{' ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )* '}' )
			// org/antlr/gunit/gUnit.g:305:2: '{' ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )* '}'
			{
			match('{'); 
			// org/antlr/gunit/gUnit.g:306:2: ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )*
			loop14:
			while (true) {
				int alt14=5;
				alt14 = dfa14.predict(input);
				switch (alt14) {
				case 1 :
					// org/antlr/gunit/gUnit.g:307:4: NESTED_ACTION
					{
					mNESTED_ACTION(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:308:4: STRING_LITERAL
					{
					mSTRING_LITERAL(); 

					}
					break;
				case 3 :
					// org/antlr/gunit/gUnit.g:309:4: CHAR_LITERAL
					{
					mCHAR_LITERAL(); 

					}
					break;
				case 4 :
					// org/antlr/gunit/gUnit.g:310:4: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop14;
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
			// org/antlr/gunit/gUnit.g:317:2: ( '\\'' ( ESC |~ ( '\\'' | '\\\\' ) ) '\\'' )
			// org/antlr/gunit/gUnit.g:317:4: '\\'' ( ESC |~ ( '\\'' | '\\\\' ) ) '\\''
			{
			match('\''); 
			// org/antlr/gunit/gUnit.g:317:9: ( ESC |~ ( '\\'' | '\\\\' ) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0=='\\') ) {
				alt15=1;
			}
			else if ( ((LA15_0 >= '\u0000' && LA15_0 <= '&')||(LA15_0 >= '(' && LA15_0 <= '[')||(LA15_0 >= ']' && LA15_0 <= '\uFFFF')) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// org/antlr/gunit/gUnit.g:317:11: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:317:17: ~ ( '\\'' | '\\\\' )
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
			// org/antlr/gunit/gUnit.g:322:2: ( '\"' ( ESC |~ ( '\\\\' | '\"' ) )* '\"' )
			// org/antlr/gunit/gUnit.g:322:4: '\"' ( ESC |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// org/antlr/gunit/gUnit.g:322:8: ( ESC |~ ( '\\\\' | '\"' ) )*
			loop16:
			while (true) {
				int alt16=3;
				int LA16_0 = input.LA(1);
				if ( (LA16_0=='\\') ) {
					alt16=1;
				}
				else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '!')||(LA16_0 >= '#' && LA16_0 <= '[')||(LA16_0 >= ']' && LA16_0 <= '\uFFFF')) ) {
					alt16=2;
				}

				switch (alt16) {
				case 1 :
					// org/antlr/gunit/gUnit.g:322:10: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:322:16: ~ ( '\\\\' | '\"' )
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
					break loop16;
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
			// org/antlr/gunit/gUnit.g:326:5: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . ) )
			// org/antlr/gunit/gUnit.g:326:7: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
			{
			match('\\'); 
			// org/antlr/gunit/gUnit.g:327:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
			int alt17=11;
			int LA17_0 = input.LA(1);
			if ( (LA17_0=='n') ) {
				alt17=1;
			}
			else if ( (LA17_0=='r') ) {
				alt17=2;
			}
			else if ( (LA17_0=='t') ) {
				alt17=3;
			}
			else if ( (LA17_0=='b') ) {
				alt17=4;
			}
			else if ( (LA17_0=='f') ) {
				alt17=5;
			}
			else if ( (LA17_0=='\"') ) {
				alt17=6;
			}
			else if ( (LA17_0=='\'') ) {
				alt17=7;
			}
			else if ( (LA17_0=='\\') ) {
				alt17=8;
			}
			else if ( (LA17_0=='>') ) {
				alt17=9;
			}
			else if ( (LA17_0=='u') ) {
				int LA17_10 = input.LA(2);
				if ( ((LA17_10 >= '0' && LA17_10 <= '9')||(LA17_10 >= 'A' && LA17_10 <= 'F')||(LA17_10 >= 'a' && LA17_10 <= 'f')) ) {
					alt17=10;
				}

				else {
					alt17=11;
				}

			}
			else if ( ((LA17_0 >= '\u0000' && LA17_0 <= '!')||(LA17_0 >= '#' && LA17_0 <= '&')||(LA17_0 >= '(' && LA17_0 <= '=')||(LA17_0 >= '?' && LA17_0 <= '[')||(LA17_0 >= ']' && LA17_0 <= 'a')||(LA17_0 >= 'c' && LA17_0 <= 'e')||(LA17_0 >= 'g' && LA17_0 <= 'm')||(LA17_0 >= 'o' && LA17_0 <= 'q')||LA17_0=='s'||(LA17_0 >= 'v' && LA17_0 <= '\uFFFF')) ) {
				alt17=11;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// org/antlr/gunit/gUnit.g:327:5: 'n'
					{
					match('n'); 
					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:328:5: 'r'
					{
					match('r'); 
					}
					break;
				case 3 :
					// org/antlr/gunit/gUnit.g:329:5: 't'
					{
					match('t'); 
					}
					break;
				case 4 :
					// org/antlr/gunit/gUnit.g:330:5: 'b'
					{
					match('b'); 
					}
					break;
				case 5 :
					// org/antlr/gunit/gUnit.g:331:5: 'f'
					{
					match('f'); 
					}
					break;
				case 6 :
					// org/antlr/gunit/gUnit.g:332:5: '\"'
					{
					match('\"'); 
					}
					break;
				case 7 :
					// org/antlr/gunit/gUnit.g:333:5: '\\''
					{
					match('\''); 
					}
					break;
				case 8 :
					// org/antlr/gunit/gUnit.g:334:5: '\\\\'
					{
					match('\\'); 
					}
					break;
				case 9 :
					// org/antlr/gunit/gUnit.g:335:5: '>'
					{
					match('>'); 
					}
					break;
				case 10 :
					// org/antlr/gunit/gUnit.g:336:5: 'u' XDIGIT XDIGIT XDIGIT XDIGIT
					{
					match('u'); 
					mXDIGIT(); 

					mXDIGIT(); 

					mXDIGIT(); 

					mXDIGIT(); 

					}
					break;
				case 11 :
					// org/antlr/gunit/gUnit.g:337:5: .
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
			// org/antlr/gunit/gUnit.g:342:8: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// org/antlr/gunit/gUnit.g:
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
			// org/antlr/gunit/gUnit.g:347:4: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' )+ )
			// org/antlr/gunit/gUnit.g:347:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
			{
			// org/antlr/gunit/gUnit.g:347:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=4;
				switch ( input.LA(1) ) {
				case ' ':
					{
					alt19=1;
					}
					break;
				case '\t':
					{
					alt19=2;
					}
					break;
				case '\n':
				case '\r':
					{
					alt19=3;
					}
					break;
				}
				switch (alt19) {
				case 1 :
					// org/antlr/gunit/gUnit.g:347:8: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:348:5: '\\t'
					{
					match('\t'); 
					}
					break;
				case 3 :
					// org/antlr/gunit/gUnit.g:349:5: ( '\\r' )? '\\n'
					{
					// org/antlr/gunit/gUnit.g:349:5: ( '\\r' )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0=='\r') ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// org/antlr/gunit/gUnit.g:349:5: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
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
		// org/antlr/gunit/gUnit.g:1:8: ( FAIL | OK | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | SL_COMMENT | ML_COMMENT | STRING | ML_STRING | TOKEN_REF | RULE_REF | EXT | RETVAL | AST | OPTIONS | ACTION | WS )
		int alt20=23;
		switch ( input.LA(1) ) {
		case 'F':
			{
			int LA20_1 = input.LA(2);
			if ( (LA20_1=='A') ) {
				int LA20_23 = input.LA(3);
				if ( (LA20_23=='I') ) {
					int LA20_31 = input.LA(4);
					if ( (LA20_31=='L') ) {
						int LA20_37 = input.LA(5);
						if ( ((LA20_37 >= '0' && LA20_37 <= '9')||(LA20_37 >= 'A' && LA20_37 <= 'Z')||LA20_37=='_'||(LA20_37 >= 'a' && LA20_37 <= 'z')) ) {
							alt20=16;
						}

						else {
							alt20=1;
						}

					}

					else {
						alt20=16;
					}

				}

				else {
					alt20=16;
				}

			}

			else {
				alt20=16;
			}

			}
			break;
		case 'O':
			{
			int LA20_2 = input.LA(2);
			if ( (LA20_2=='K') ) {
				int LA20_24 = input.LA(3);
				if ( ((LA20_24 >= '0' && LA20_24 <= '9')||(LA20_24 >= 'A' && LA20_24 <= 'Z')||LA20_24=='_'||(LA20_24 >= 'a' && LA20_24 <= 'z')) ) {
					alt20=16;
				}

				else {
					alt20=2;
				}

			}

			else {
				alt20=16;
			}

			}
			break;
		case '-':
			{
			alt20=3;
			}
			break;
		case ':':
			{
			alt20=4;
			}
			break;
		case ';':
			{
			alt20=5;
			}
			break;
		case '=':
			{
			alt20=6;
			}
			break;
		case '@':
			{
			alt20=7;
			}
			break;
		case 'g':
			{
			int LA20_8 = input.LA(2);
			if ( (LA20_8=='u') ) {
				int LA20_25 = input.LA(3);
				if ( (LA20_25=='n') ) {
					int LA20_33 = input.LA(4);
					if ( (LA20_33=='i') ) {
						int LA20_38 = input.LA(5);
						if ( (LA20_38=='t') ) {
							int LA20_43 = input.LA(6);
							if ( ((LA20_43 >= '0' && LA20_43 <= '9')||(LA20_43 >= 'A' && LA20_43 <= 'Z')||LA20_43=='_'||(LA20_43 >= 'a' && LA20_43 <= 'z')) ) {
								alt20=17;
							}

							else {
								alt20=8;
							}

						}

						else {
							alt20=17;
						}

					}

					else {
						alt20=17;
					}

				}

				else {
					alt20=17;
				}

			}

			else {
				alt20=17;
			}

			}
			break;
		case 'r':
			{
			int LA20_9 = input.LA(2);
			if ( (LA20_9=='e') ) {
				int LA20_26 = input.LA(3);
				if ( (LA20_26=='t') ) {
					int LA20_34 = input.LA(4);
					if ( (LA20_34=='u') ) {
						int LA20_39 = input.LA(5);
						if ( (LA20_39=='r') ) {
							int LA20_44 = input.LA(6);
							if ( (LA20_44=='n') ) {
								int LA20_48 = input.LA(7);
								if ( (LA20_48=='s') ) {
									int LA20_51 = input.LA(8);
									if ( ((LA20_51 >= '0' && LA20_51 <= '9')||(LA20_51 >= 'A' && LA20_51 <= 'Z')||LA20_51=='_'||(LA20_51 >= 'a' && LA20_51 <= 'z')) ) {
										alt20=17;
									}

									else {
										alt20=9;
									}

								}

								else {
									alt20=17;
								}

							}

							else {
								alt20=17;
							}

						}

						else {
							alt20=17;
						}

					}

					else {
						alt20=17;
					}

				}

				else {
					alt20=17;
				}

			}

			else {
				alt20=17;
			}

			}
			break;
		case 'w':
			{
			int LA20_10 = input.LA(2);
			if ( (LA20_10=='a') ) {
				int LA20_27 = input.LA(3);
				if ( (LA20_27=='l') ) {
					int LA20_35 = input.LA(4);
					if ( (LA20_35=='k') ) {
						int LA20_40 = input.LA(5);
						if ( (LA20_40=='s') ) {
							int LA20_45 = input.LA(6);
							if ( ((LA20_45 >= '0' && LA20_45 <= '9')||(LA20_45 >= 'A' && LA20_45 <= 'Z')||LA20_45=='_'||(LA20_45 >= 'a' && LA20_45 <= 'z')) ) {
								alt20=17;
							}

							else {
								alt20=10;
							}

						}

						else {
							alt20=17;
						}

					}

					else {
						alt20=17;
					}

				}

				else {
					alt20=17;
				}

			}

			else {
				alt20=17;
			}

			}
			break;
		case '}':
			{
			alt20=11;
			}
			break;
		case '/':
			{
			int LA20_12 = input.LA(2);
			if ( (LA20_12=='/') ) {
				alt20=12;
			}
			else if ( (LA20_12=='*') ) {
				alt20=13;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 20, 12, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case '\"':
			{
			alt20=14;
			}
			break;
		case '<':
			{
			alt20=15;
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
			alt20=16;
			}
			break;
		case 'o':
			{
			int LA20_16 = input.LA(2);
			if ( (LA20_16=='p') ) {
				int LA20_30 = input.LA(3);
				if ( (LA20_30=='t') ) {
					int LA20_36 = input.LA(4);
					if ( (LA20_36=='i') ) {
						int LA20_41 = input.LA(5);
						if ( (LA20_41=='o') ) {
							int LA20_46 = input.LA(6);
							if ( (LA20_46=='n') ) {
								int LA20_50 = input.LA(7);
								if ( (LA20_50=='s') ) {
									int LA20_52 = input.LA(8);
									if ( ((LA20_52 >= '\t' && LA20_52 <= '\n')||LA20_52=='\r'||LA20_52==' '||LA20_52=='{') ) {
										alt20=21;
									}

									else {
										alt20=17;
									}

								}

								else {
									alt20=17;
								}

							}

							else {
								alt20=17;
							}

						}

						else {
							alt20=17;
						}

					}

					else {
						alt20=17;
					}

				}

				else {
					alt20=17;
				}

			}

			else {
				alt20=17;
			}

			}
			break;
		case '.':
			{
			alt20=18;
			}
			break;
		case '[':
			{
			alt20=19;
			}
			break;
		case '(':
			{
			alt20=20;
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
			alt20=17;
			}
			break;
		case '{':
			{
			alt20=22;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt20=23;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 20, 0, input);
			throw nvae;
		}
		switch (alt20) {
			case 1 :
				// org/antlr/gunit/gUnit.g:1:10: FAIL
				{
				mFAIL(); 

				}
				break;
			case 2 :
				// org/antlr/gunit/gUnit.g:1:15: OK
				{
				mOK(); 

				}
				break;
			case 3 :
				// org/antlr/gunit/gUnit.g:1:18: T__26
				{
				mT__26(); 

				}
				break;
			case 4 :
				// org/antlr/gunit/gUnit.g:1:24: T__27
				{
				mT__27(); 

				}
				break;
			case 5 :
				// org/antlr/gunit/gUnit.g:1:30: T__28
				{
				mT__28(); 

				}
				break;
			case 6 :
				// org/antlr/gunit/gUnit.g:1:36: T__29
				{
				mT__29(); 

				}
				break;
			case 7 :
				// org/antlr/gunit/gUnit.g:1:42: T__30
				{
				mT__30(); 

				}
				break;
			case 8 :
				// org/antlr/gunit/gUnit.g:1:48: T__31
				{
				mT__31(); 

				}
				break;
			case 9 :
				// org/antlr/gunit/gUnit.g:1:54: T__32
				{
				mT__32(); 

				}
				break;
			case 10 :
				// org/antlr/gunit/gUnit.g:1:60: T__33
				{
				mT__33(); 

				}
				break;
			case 11 :
				// org/antlr/gunit/gUnit.g:1:66: T__34
				{
				mT__34(); 

				}
				break;
			case 12 :
				// org/antlr/gunit/gUnit.g:1:72: SL_COMMENT
				{
				mSL_COMMENT(); 

				}
				break;
			case 13 :
				// org/antlr/gunit/gUnit.g:1:83: ML_COMMENT
				{
				mML_COMMENT(); 

				}
				break;
			case 14 :
				// org/antlr/gunit/gUnit.g:1:94: STRING
				{
				mSTRING(); 

				}
				break;
			case 15 :
				// org/antlr/gunit/gUnit.g:1:101: ML_STRING
				{
				mML_STRING(); 

				}
				break;
			case 16 :
				// org/antlr/gunit/gUnit.g:1:111: TOKEN_REF
				{
				mTOKEN_REF(); 

				}
				break;
			case 17 :
				// org/antlr/gunit/gUnit.g:1:121: RULE_REF
				{
				mRULE_REF(); 

				}
				break;
			case 18 :
				// org/antlr/gunit/gUnit.g:1:130: EXT
				{
				mEXT(); 

				}
				break;
			case 19 :
				// org/antlr/gunit/gUnit.g:1:134: RETVAL
				{
				mRETVAL(); 

				}
				break;
			case 20 :
				// org/antlr/gunit/gUnit.g:1:141: AST
				{
				mAST(); 

				}
				break;
			case 21 :
				// org/antlr/gunit/gUnit.g:1:145: OPTIONS
				{
				mOPTIONS(); 

				}
				break;
			case 22 :
				// org/antlr/gunit/gUnit.g:1:153: ACTION
				{
				mACTION(); 

				}
				break;
			case 23 :
				// org/antlr/gunit/gUnit.g:1:160: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA14 dfa14 = new DFA14(this);
	static final String DFA14_eotS =
		"\116\uffff";
	static final String DFA14_eofS =
		"\116\uffff";
	static final String DFA14_minS =
		"\1\0\2\uffff\2\0\1\uffff\1\0\2\uffff\4\0\1\uffff\3\0\75\uffff";
	static final String DFA14_maxS =
		"\1\uffff\2\uffff\2\uffff\1\uffff\1\uffff\2\uffff\4\uffff\1\uffff\3\uffff"+
		"\75\uffff";
	static final String DFA14_acceptS =
		"\1\uffff\1\5\1\1\2\uffff\1\4\1\uffff\1\4\1\2\4\uffff\1\4\4\uffff\37\2"+
		"\16\3\4\uffff\1\3\5\uffff\1\3\4\uffff";
	static final String DFA14_specialS =
		"\1\0\2\uffff\1\1\1\2\1\uffff\1\3\2\uffff\1\4\1\5\1\6\1\7\1\uffff\1\10"+
		"\1\11\1\12\75\uffff}>";
	static final String[] DFA14_transitionS = {
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

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 306:2: ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA14_0 = input.LA(1);
						s = -1;
						if ( (LA14_0=='}') ) {s = 1;}
						else if ( (LA14_0=='{') ) {s = 2;}
						else if ( (LA14_0=='\"') ) {s = 3;}
						else if ( (LA14_0=='\'') ) {s = 4;}
						else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '!')||(LA14_0 >= '#' && LA14_0 <= '&')||(LA14_0 >= '(' && LA14_0 <= 'z')||LA14_0=='|'||(LA14_0 >= '~' && LA14_0 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA14_3 = input.LA(1);
						s = -1;
						if ( (LA14_3=='\\') ) {s = 6;}
						else if ( (LA14_3=='}') ) {s = 7;}
						else if ( (LA14_3=='\"') ) {s = 8;}
						else if ( (LA14_3=='{') ) {s = 9;}
						else if ( (LA14_3=='\'') ) {s = 10;}
						else if ( ((LA14_3 >= '\u0000' && LA14_3 <= '!')||(LA14_3 >= '#' && LA14_3 <= '&')||(LA14_3 >= '(' && LA14_3 <= '[')||(LA14_3 >= ']' && LA14_3 <= 'z')||LA14_3=='|'||(LA14_3 >= '~' && LA14_3 <= '\uFFFF')) ) {s = 11;}
						if ( s>=0 ) return s;
						break;
					case 2 : 
						int LA14_4 = input.LA(1);
						s = -1;
						if ( (LA14_4=='\\') ) {s = 12;}
						else if ( (LA14_4=='}') ) {s = 13;}
						else if ( (LA14_4=='{') ) {s = 14;}
						else if ( (LA14_4=='\"') ) {s = 15;}
						else if ( ((LA14_4 >= '\u0000' && LA14_4 <= '!')||(LA14_4 >= '#' && LA14_4 <= '&')||(LA14_4 >= '(' && LA14_4 <= '[')||(LA14_4 >= ']' && LA14_4 <= 'z')||LA14_4=='|'||(LA14_4 >= '~' && LA14_4 <= '\uFFFF')) ) {s = 16;}
						else if ( (LA14_4=='\'') ) {s = 5;}
						if ( s>=0 ) return s;
						break;
					case 3 : 
						int LA14_6 = input.LA(1);
						s = -1;
						if ( (LA14_6=='n') ) {s = 18;}
						else if ( (LA14_6=='r') ) {s = 19;}
						else if ( (LA14_6=='t') ) {s = 20;}
						else if ( (LA14_6=='b') ) {s = 21;}
						else if ( (LA14_6=='f') ) {s = 22;}
						else if ( (LA14_6=='\"') ) {s = 23;}
						else if ( (LA14_6=='\'') ) {s = 24;}
						else if ( (LA14_6=='\\') ) {s = 25;}
						else if ( (LA14_6=='>') ) {s = 26;}
						else if ( (LA14_6=='u') ) {s = 27;}
						else if ( (LA14_6=='}') ) {s = 28;}
						else if ( (LA14_6=='{') ) {s = 29;}
						else if ( ((LA14_6 >= '\u0000' && LA14_6 <= '!')||(LA14_6 >= '#' && LA14_6 <= '&')||(LA14_6 >= '(' && LA14_6 <= '=')||(LA14_6 >= '?' && LA14_6 <= '[')||(LA14_6 >= ']' && LA14_6 <= 'a')||(LA14_6 >= 'c' && LA14_6 <= 'e')||(LA14_6 >= 'g' && LA14_6 <= 'm')||(LA14_6 >= 'o' && LA14_6 <= 'q')||LA14_6=='s'||(LA14_6 >= 'v' && LA14_6 <= 'z')||LA14_6=='|'||(LA14_6 >= '~' && LA14_6 <= '\uFFFF')) ) {s = 30;}
						if ( s>=0 ) return s;
						break;
					case 4 : 
						int LA14_9 = input.LA(1);
						s = -1;
						if ( (LA14_9=='\"') ) {s = 31;}
						else if ( (LA14_9=='\\') ) {s = 32;}
						else if ( (LA14_9=='{') ) {s = 33;}
						else if ( (LA14_9=='\'') ) {s = 34;}
						else if ( (LA14_9=='}') ) {s = 35;}
						else if ( ((LA14_9 >= '\u0000' && LA14_9 <= '!')||(LA14_9 >= '#' && LA14_9 <= '&')||(LA14_9 >= '(' && LA14_9 <= '[')||(LA14_9 >= ']' && LA14_9 <= 'z')||LA14_9=='|'||(LA14_9 >= '~' && LA14_9 <= '\uFFFF')) ) {s = 36;}
						if ( s>=0 ) return s;
						break;
					case 5 : 
						int LA14_10 = input.LA(1);
						s = -1;
						if ( (LA14_10=='\"') ) {s = 37;}
						else if ( (LA14_10=='\\') ) {s = 38;}
						else if ( (LA14_10=='}') ) {s = 39;}
						else if ( (LA14_10=='\'') ) {s = 40;}
						else if ( (LA14_10=='{') ) {s = 41;}
						else if ( ((LA14_10 >= '\u0000' && LA14_10 <= '!')||(LA14_10 >= '#' && LA14_10 <= '&')||(LA14_10 >= '(' && LA14_10 <= '[')||(LA14_10 >= ']' && LA14_10 <= 'z')||LA14_10=='|'||(LA14_10 >= '~' && LA14_10 <= '\uFFFF')) ) {s = 42;}
						if ( s>=0 ) return s;
						break;
					case 6 : 
						int LA14_11 = input.LA(1);
						s = -1;
						if ( (LA14_11=='\"') ) {s = 43;}
						else if ( (LA14_11=='\\') ) {s = 44;}
						else if ( (LA14_11=='}') ) {s = 45;}
						else if ( (LA14_11=='{') ) {s = 46;}
						else if ( (LA14_11=='\'') ) {s = 47;}
						else if ( ((LA14_11 >= '\u0000' && LA14_11 <= '!')||(LA14_11 >= '#' && LA14_11 <= '&')||(LA14_11 >= '(' && LA14_11 <= '[')||(LA14_11 >= ']' && LA14_11 <= 'z')||LA14_11=='|'||(LA14_11 >= '~' && LA14_11 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;
					case 7 : 
						int LA14_12 = input.LA(1);
						s = -1;
						if ( (LA14_12=='n') ) {s = 49;}
						else if ( (LA14_12=='r') ) {s = 50;}
						else if ( (LA14_12=='t') ) {s = 51;}
						else if ( (LA14_12=='b') ) {s = 52;}
						else if ( (LA14_12=='f') ) {s = 53;}
						else if ( (LA14_12=='\"') ) {s = 54;}
						else if ( (LA14_12=='\'') ) {s = 55;}
						else if ( (LA14_12=='\\') ) {s = 56;}
						else if ( (LA14_12=='>') ) {s = 57;}
						else if ( (LA14_12=='u') ) {s = 58;}
						else if ( (LA14_12=='}') ) {s = 59;}
						else if ( (LA14_12=='{') ) {s = 60;}
						else if ( ((LA14_12 >= '\u0000' && LA14_12 <= '!')||(LA14_12 >= '#' && LA14_12 <= '&')||(LA14_12 >= '(' && LA14_12 <= '=')||(LA14_12 >= '?' && LA14_12 <= '[')||(LA14_12 >= ']' && LA14_12 <= 'a')||(LA14_12 >= 'c' && LA14_12 <= 'e')||(LA14_12 >= 'g' && LA14_12 <= 'm')||(LA14_12 >= 'o' && LA14_12 <= 'q')||LA14_12=='s'||(LA14_12 >= 'v' && LA14_12 <= 'z')||LA14_12=='|'||(LA14_12 >= '~' && LA14_12 <= '\uFFFF')) ) {s = 61;}
						if ( s>=0 ) return s;
						break;
					case 8 : 
						int LA14_14 = input.LA(1);
						s = -1;
						if ( (LA14_14=='\'') ) {s = 62;}
						else if ( ((LA14_14 >= '\u0000' && LA14_14 <= '&')||(LA14_14 >= '(' && LA14_14 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
					case 9 : 
						int LA14_15 = input.LA(1);
						s = -1;
						if ( (LA14_15=='\'') ) {s = 67;}
						else if ( ((LA14_15 >= '\u0000' && LA14_15 <= '&')||(LA14_15 >= '(' && LA14_15 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
					case 10 : 
						int LA14_16 = input.LA(1);
						s = -1;
						if ( (LA14_16=='\'') ) {s = 73;}
						else if ( ((LA14_16 >= '\u0000' && LA14_16 <= '&')||(LA14_16 >= '(' && LA14_16 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 14, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
