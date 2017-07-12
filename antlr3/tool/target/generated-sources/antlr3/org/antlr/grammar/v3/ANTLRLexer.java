// $ANTLR 3.5 org/antlr/grammar/v3/ANTLR.g 2017-06-11 18:42:19

package org.antlr.grammar.v3;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class ANTLRLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ACTION=4;
	public static final int ACTION_CHAR_LITERAL=5;
	public static final int ACTION_ESC=6;
	public static final int ACTION_STRING_LITERAL=7;
	public static final int ALT=8;
	public static final int AMPERSAND=9;
	public static final int ARG=10;
	public static final int ARGLIST=11;
	public static final int ARG_ACTION=12;
	public static final int ASSIGN=13;
	public static final int BACKTRACK_SEMPRED=14;
	public static final int BANG=15;
	public static final int BLOCK=16;
	public static final int CATCH=17;
	public static final int CHAR_LITERAL=18;
	public static final int CHAR_RANGE=19;
	public static final int CLOSE_ELEMENT_OPTION=20;
	public static final int CLOSURE=21;
	public static final int COLON=22;
	public static final int COMBINED_GRAMMAR=23;
	public static final int COMMA=24;
	public static final int COMMENT=25;
	public static final int DIGIT=26;
	public static final int DOC_COMMENT=27;
	public static final int DOLLAR=28;
	public static final int DOT=29;
	public static final int DOUBLE_ANGLE_STRING_LITERAL=30;
	public static final int DOUBLE_QUOTE_STRING_LITERAL=31;
	public static final int EOA=32;
	public static final int EOB=33;
	public static final int EOR=34;
	public static final int EPSILON=35;
	public static final int ESC=36;
	public static final int ETC=37;
	public static final int FINALLY=38;
	public static final int FORCED_ACTION=39;
	public static final int FRAGMENT=40;
	public static final int GATED_SEMPRED=41;
	public static final int GRAMMAR=42;
	public static final int ID=43;
	public static final int IMPLIES=44;
	public static final int IMPORT=45;
	public static final int INITACTION=46;
	public static final int INT=47;
	public static final int LABEL=48;
	public static final int LEXER=49;
	public static final int LEXER_GRAMMAR=50;
	public static final int LPAREN=51;
	public static final int ML_COMMENT=52;
	public static final int NESTED_ACTION=53;
	public static final int NESTED_ARG_ACTION=54;
	public static final int NOT=55;
	public static final int OPEN_ELEMENT_OPTION=56;
	public static final int OPTIONAL=57;
	public static final int OPTIONS=58;
	public static final int OR=59;
	public static final int PARSER=60;
	public static final int PARSER_GRAMMAR=61;
	public static final int PLUS=62;
	public static final int PLUS_ASSIGN=63;
	public static final int POSITIVE_CLOSURE=64;
	public static final int PREC_RULE=65;
	public static final int PRIVATE=66;
	public static final int PROTECTED=67;
	public static final int PUBLIC=68;
	public static final int QUESTION=69;
	public static final int RANGE=70;
	public static final int RCURLY=71;
	public static final int RECURSIVE_RULE_REF=72;
	public static final int RET=73;
	public static final int RETURNS=74;
	public static final int REWRITE=75;
	public static final int REWRITES=76;
	public static final int ROOT=77;
	public static final int RPAREN=78;
	public static final int RULE=79;
	public static final int RULE_REF=80;
	public static final int SCOPE=81;
	public static final int SEMI=82;
	public static final int SEMPRED=83;
	public static final int SL_COMMENT=84;
	public static final int SRC=85;
	public static final int STAR=86;
	public static final int STRAY_BRACKET=87;
	public static final int STRING_LITERAL=88;
	public static final int SYNPRED=89;
	public static final int SYN_SEMPRED=90;
	public static final int TEMPLATE=91;
	public static final int THROWS=92;
	public static final int TOKENS=93;
	public static final int TOKEN_REF=94;
	public static final int TREE=95;
	public static final int TREE_BEGIN=96;
	public static final int TREE_GRAMMAR=97;
	public static final int WILDCARD=98;
	public static final int WS=99;
	public static final int WS_LOOP=100;
	public static final int WS_OPT=101;
	public static final int XDIGIT=102;

	public boolean hasASTOperator = false;
	private String fileName;

	public String getFileName() {
	    return fileName;
	}

	public void setFileName(String value) {
	    fileName = value;
	}

	@Override
	public Token nextToken() {
		Token token = super.nextToken();
		while (token.getType() == STRAY_BRACKET) {
			ErrorManager.syntaxError(
				ErrorManager.MSG_SYNTAX_ERROR,
				null,
				token,
				"antlr: dangling ']'? make sure to escape with \\]",
				null);

			// skip this token
			token = super.nextToken();
		}

		return token;
	}


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ANTLRLexer() {} 
	public ANTLRLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ANTLRLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/ANTLR.g"; }

	// $ANTLR start "CATCH"
	public final void mCATCH() throws RecognitionException {
		try {
			int _type = CATCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:43:7: ( 'catch' )
			// org/antlr/grammar/v3/ANTLR.g:43:9: 'catch'
			{
			match("catch"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CATCH"

	// $ANTLR start "FINALLY"
	public final void mFINALLY() throws RecognitionException {
		try {
			int _type = FINALLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:44:9: ( 'finally' )
			// org/antlr/grammar/v3/ANTLR.g:44:11: 'finally'
			{
			match("finally"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FINALLY"

	// $ANTLR start "FRAGMENT"
	public final void mFRAGMENT() throws RecognitionException {
		try {
			int _type = FRAGMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:45:10: ( 'fragment' )
			// org/antlr/grammar/v3/ANTLR.g:45:12: 'fragment'
			{
			match("fragment"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FRAGMENT"

	// $ANTLR start "GRAMMAR"
	public final void mGRAMMAR() throws RecognitionException {
		try {
			int _type = GRAMMAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:46:9: ( 'grammar' )
			// org/antlr/grammar/v3/ANTLR.g:46:11: 'grammar'
			{
			match("grammar"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GRAMMAR"

	// $ANTLR start "IMPORT"
	public final void mIMPORT() throws RecognitionException {
		try {
			int _type = IMPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:47:8: ( 'import' )
			// org/antlr/grammar/v3/ANTLR.g:47:10: 'import'
			{
			match("import"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPORT"

	// $ANTLR start "LEXER"
	public final void mLEXER() throws RecognitionException {
		try {
			int _type = LEXER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:48:7: ( 'lexer' )
			// org/antlr/grammar/v3/ANTLR.g:48:9: 'lexer'
			{
			match("lexer"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEXER"

	// $ANTLR start "PARSER"
	public final void mPARSER() throws RecognitionException {
		try {
			int _type = PARSER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:49:8: ( 'parser' )
			// org/antlr/grammar/v3/ANTLR.g:49:10: 'parser'
			{
			match("parser"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PARSER"

	// $ANTLR start "PRIVATE"
	public final void mPRIVATE() throws RecognitionException {
		try {
			int _type = PRIVATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:50:9: ( 'private' )
			// org/antlr/grammar/v3/ANTLR.g:50:11: 'private'
			{
			match("private"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRIVATE"

	// $ANTLR start "PROTECTED"
	public final void mPROTECTED() throws RecognitionException {
		try {
			int _type = PROTECTED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:51:11: ( 'protected' )
			// org/antlr/grammar/v3/ANTLR.g:51:13: 'protected'
			{
			match("protected"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROTECTED"

	// $ANTLR start "PUBLIC"
	public final void mPUBLIC() throws RecognitionException {
		try {
			int _type = PUBLIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:52:8: ( 'public' )
			// org/antlr/grammar/v3/ANTLR.g:52:10: 'public'
			{
			match("public"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUBLIC"

	// $ANTLR start "RETURNS"
	public final void mRETURNS() throws RecognitionException {
		try {
			int _type = RETURNS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:53:9: ( 'returns' )
			// org/antlr/grammar/v3/ANTLR.g:53:11: 'returns'
			{
			match("returns"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURNS"

	// $ANTLR start "SCOPE"
	public final void mSCOPE() throws RecognitionException {
		try {
			int _type = SCOPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:54:7: ( 'scope' )
			// org/antlr/grammar/v3/ANTLR.g:54:9: 'scope'
			{
			match("scope"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCOPE"

	// $ANTLR start "THROWS"
	public final void mTHROWS() throws RecognitionException {
		try {
			int _type = THROWS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:55:8: ( 'throws' )
			// org/antlr/grammar/v3/ANTLR.g:55:10: 'throws'
			{
			match("throws"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THROWS"

	// $ANTLR start "TREE"
	public final void mTREE() throws RecognitionException {
		try {
			int _type = TREE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:56:6: ( 'tree' )
			// org/antlr/grammar/v3/ANTLR.g:56:8: 'tree'
			{
			match("tree"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TREE"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1075:25: ()
			// org/antlr/grammar/v3/ANTLR.g:1075:27: 
			{
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "FORCED_ACTION"
	public final void mFORCED_ACTION() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1076:24: ()
			// org/antlr/grammar/v3/ANTLR.g:1076:26: 
			{
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FORCED_ACTION"

	// $ANTLR start "DOC_COMMENT"
	public final void mDOC_COMMENT() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1077:22: ()
			// org/antlr/grammar/v3/ANTLR.g:1077:24: 
			{
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOC_COMMENT"

	// $ANTLR start "SEMPRED"
	public final void mSEMPRED() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1078:18: ()
			// org/antlr/grammar/v3/ANTLR.g:1078:20: 
			{
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMPRED"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1081:2: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' ) )
			// org/antlr/grammar/v3/ANTLR.g:1081:4: ( ' ' | '\\t' | ( '\\r' )? '\\n' )
			{
			// org/antlr/grammar/v3/ANTLR.g:1081:4: ( ' ' | '\\t' | ( '\\r' )? '\\n' )
			int alt2=3;
			switch ( input.LA(1) ) {
			case ' ':
				{
				alt2=1;
				}
				break;
			case '\t':
				{
				alt2=2;
				}
				break;
			case '\n':
			case '\r':
				{
				alt2=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1081:6: ' '
					{
					match(' '); if (state.failed) return;
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1082:5: '\\t'
					{
					match('\t'); if (state.failed) return;
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:1083:5: ( '\\r' )? '\\n'
					{
					// org/antlr/grammar/v3/ANTLR.g:1083:5: ( '\\r' )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0=='\r') ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:1083:6: '\\r'
							{
							match('\r'); if (state.failed) return;
							}
							break;

					}

					match('\n'); if (state.failed) return;
					}
					break;

			}

			if ( state.backtracking==0 ) { _channel = HIDDEN; }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			List<Integer> type = new ArrayList<Integer>() {{ add(0); }};
			// org/antlr/grammar/v3/ANTLR.g:1090:2: ( ( SL_COMMENT | ML_COMMENT[type] ) )
			// org/antlr/grammar/v3/ANTLR.g:1090:4: ( SL_COMMENT | ML_COMMENT[type] )
			{
			// org/antlr/grammar/v3/ANTLR.g:1090:4: ( SL_COMMENT | ML_COMMENT[type] )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='/') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='/') ) {
					alt3=1;
				}
				else if ( (LA3_1=='*') ) {
					alt3=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1090:6: SL_COMMENT
					{
					mSL_COMMENT(); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1090:19: ML_COMMENT[type]
					{
					mML_COMMENT(type); if (state.failed) return;

					if ( state.backtracking==0 ) {_type = type.get(0);}
					}
					break;

			}

			if ( state.backtracking==0 ) {
						if ( _type != DOC_COMMENT )
							_channel = HIDDEN;
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1100:2: ( '//' ( ( ' $ANTLR' )=> ' $ANTLR ' SRC ( ( '\\r' )? '\\n' )? | (~ ( '\\r' | '\\n' ) )* ( ( '\\r' )? '\\n' )? ) )
			// org/antlr/grammar/v3/ANTLR.g:1100:4: '//' ( ( ' $ANTLR' )=> ' $ANTLR ' SRC ( ( '\\r' )? '\\n' )? | (~ ( '\\r' | '\\n' ) )* ( ( '\\r' )? '\\n' )? )
			{
			match("//"); if (state.failed) return;

			// org/antlr/grammar/v3/ANTLR.g:1101:3: ( ( ' $ANTLR' )=> ' $ANTLR ' SRC ( ( '\\r' )? '\\n' )? | (~ ( '\\r' | '\\n' ) )* ( ( '\\r' )? '\\n' )? )
			int alt9=2;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1101:5: ( ' $ANTLR' )=> ' $ANTLR ' SRC ( ( '\\r' )? '\\n' )?
					{
					match(" $ANTLR "); if (state.failed) return;

					mSRC(); if (state.failed) return;

					// org/antlr/grammar/v3/ANTLR.g:1101:35: ( ( '\\r' )? '\\n' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0=='\n'||LA5_0=='\r') ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:1101:36: ( '\\r' )? '\\n'
							{
							// org/antlr/grammar/v3/ANTLR.g:1101:36: ( '\\r' )?
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0=='\r') ) {
								alt4=1;
							}
							switch (alt4) {
								case 1 :
									// org/antlr/grammar/v3/ANTLR.g:1101:37: '\\r'
									{
									match('\r'); if (state.failed) return;
									}
									break;

							}

							match('\n'); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1102:5: (~ ( '\\r' | '\\n' ) )* ( ( '\\r' )? '\\n' )?
					{
					// org/antlr/grammar/v3/ANTLR.g:1102:5: (~ ( '\\r' | '\\n' ) )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\uFFFF')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
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

					// org/antlr/grammar/v3/ANTLR.g:1102:19: ( ( '\\r' )? '\\n' )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0=='\n'||LA8_0=='\r') ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:1102:20: ( '\\r' )? '\\n'
							{
							// org/antlr/grammar/v3/ANTLR.g:1102:20: ( '\\r' )?
							int alt7=2;
							int LA7_0 = input.LA(1);
							if ( (LA7_0=='\r') ) {
								alt7=1;
							}
							switch (alt7) {
								case 1 :
									// org/antlr/grammar/v3/ANTLR.g:1102:21: '\\r'
									{
									match('\r'); if (state.failed) return;
									}
									break;

							}

							match('\n'); if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT"

	// $ANTLR start "ML_COMMENT"
	public final void mML_COMMENT(List<Integer> type) throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1108:2: ( '/*' ( . )* '*/' )
			// org/antlr/grammar/v3/ANTLR.g:1108:4: '/*' ( . )* '*/'
			{
			match("/*"); if (state.failed) return;

			if ( state.backtracking==0 ) {type.set(0, (input.LA(1) == '*' && input.LA(2) != '/') ? DOC_COMMENT : ML_COMMENT);}
			// org/antlr/grammar/v3/ANTLR.g:1110:3: ( . )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0=='*') ) {
					int LA10_1 = input.LA(2);
					if ( (LA10_1=='/') ) {
						alt10=2;
					}
					else if ( ((LA10_1 >= '\u0000' && LA10_1 <= '.')||(LA10_1 >= '0' && LA10_1 <= '\uFFFF')) ) {
						alt10=1;
					}

				}
				else if ( ((LA10_0 >= '\u0000' && LA10_0 <= ')')||(LA10_0 >= '+' && LA10_0 <= '\uFFFF')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1110:3: .
					{
					matchAny(); if (state.failed) return;
					}
					break;

				default :
					break loop10;
				}
			}

			match("*/"); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_COMMENT"

	// $ANTLR start "OPEN_ELEMENT_OPTION"
	public final void mOPEN_ELEMENT_OPTION() throws RecognitionException {
		try {
			int _type = OPEN_ELEMENT_OPTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1114:2: ( '<' )
			// org/antlr/grammar/v3/ANTLR.g:1114:4: '<'
			{
			match('<'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPEN_ELEMENT_OPTION"

	// $ANTLR start "CLOSE_ELEMENT_OPTION"
	public final void mCLOSE_ELEMENT_OPTION() throws RecognitionException {
		try {
			int _type = CLOSE_ELEMENT_OPTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1118:2: ( '>' )
			// org/antlr/grammar/v3/ANTLR.g:1118:4: '>'
			{
			match('>'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSE_ELEMENT_OPTION"

	// $ANTLR start "AMPERSAND"
	public final void mAMPERSAND() throws RecognitionException {
		try {
			int _type = AMPERSAND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1121:11: ( '@' )
			// org/antlr/grammar/v3/ANTLR.g:1121:13: '@'
			{
			match('@'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AMPERSAND"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1123:7: ( ',' )
			// org/antlr/grammar/v3/ANTLR.g:1123:9: ','
			{
			match(','); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "QUESTION"
	public final void mQUESTION() throws RecognitionException {
		try {
			int _type = QUESTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1125:10: ( '?' )
			// org/antlr/grammar/v3/ANTLR.g:1125:12: '?'
			{
			match('?'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUESTION"

	// $ANTLR start "TREE_BEGIN"
	public final void mTREE_BEGIN() throws RecognitionException {
		try {
			int _type = TREE_BEGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1127:12: ( '^(' )
			// org/antlr/grammar/v3/ANTLR.g:1127:14: '^('
			{
			match("^("); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TREE_BEGIN"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1129:7: ( '(' )
			// org/antlr/grammar/v3/ANTLR.g:1129:9: '('
			{
			match('('); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1131:7: ( ')' )
			// org/antlr/grammar/v3/ANTLR.g:1131:9: ')'
			{
			match(')'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1133:7: ( ':' )
			// org/antlr/grammar/v3/ANTLR.g:1133:9: ':'
			{
			match(':'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1135:5: ( '*' )
			// org/antlr/grammar/v3/ANTLR.g:1135:7: '*'
			{
			match('*'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1137:5: ( '+' )
			// org/antlr/grammar/v3/ANTLR.g:1137:7: '+'
			{
			match('+'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1139:8: ( '=' )
			// org/antlr/grammar/v3/ANTLR.g:1139:10: '='
			{
			match('='); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "PLUS_ASSIGN"
	public final void mPLUS_ASSIGN() throws RecognitionException {
		try {
			int _type = PLUS_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1141:13: ( '+=' )
			// org/antlr/grammar/v3/ANTLR.g:1141:15: '+='
			{
			match("+="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS_ASSIGN"

	// $ANTLR start "IMPLIES"
	public final void mIMPLIES() throws RecognitionException {
		try {
			int _type = IMPLIES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1143:9: ( '=>' )
			// org/antlr/grammar/v3/ANTLR.g:1143:11: '=>'
			{
			match("=>"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPLIES"

	// $ANTLR start "REWRITE"
	public final void mREWRITE() throws RecognitionException {
		try {
			int _type = REWRITE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1145:9: ( '->' )
			// org/antlr/grammar/v3/ANTLR.g:1145:11: '->'
			{
			match("->"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REWRITE"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1147:5: ( ';' )
			// org/antlr/grammar/v3/ANTLR.g:1147:7: ';'
			{
			match(';'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "ROOT"
	public final void mROOT() throws RecognitionException {
		try {
			int _type = ROOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1149:6: ( '^' )
			// org/antlr/grammar/v3/ANTLR.g:1149:8: '^'
			{
			match('^'); if (state.failed) return;
			if ( state.backtracking==0 ) {hasASTOperator=true;}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROOT"

	// $ANTLR start "BANG"
	public final void mBANG() throws RecognitionException {
		try {
			int _type = BANG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1151:6: ( '!' )
			// org/antlr/grammar/v3/ANTLR.g:1151:8: '!'
			{
			match('!'); if (state.failed) return;
			if ( state.backtracking==0 ) {hasASTOperator=true;}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BANG"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1153:4: ( '|' )
			// org/antlr/grammar/v3/ANTLR.g:1153:6: '|'
			{
			match('|'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "WILDCARD"
	public final void mWILDCARD() throws RecognitionException {
		try {
			int _type = WILDCARD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1155:10: ( '.' )
			// org/antlr/grammar/v3/ANTLR.g:1155:12: '.'
			{
			match('.'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WILDCARD"

	// $ANTLR start "ETC"
	public final void mETC() throws RecognitionException {
		try {
			int _type = ETC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1157:5: ( '...' )
			// org/antlr/grammar/v3/ANTLR.g:1157:7: '...'
			{
			match("..."); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ETC"

	// $ANTLR start "RANGE"
	public final void mRANGE() throws RecognitionException {
		try {
			int _type = RANGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1159:7: ( '..' )
			// org/antlr/grammar/v3/ANTLR.g:1159:9: '..'
			{
			match(".."); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RANGE"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1161:5: ( '~' )
			// org/antlr/grammar/v3/ANTLR.g:1161:7: '~'
			{
			match('~'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
		try {
			int _type = RCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1163:7: ( '}' )
			// org/antlr/grammar/v3/ANTLR.g:1163:9: '}'
			{
			match('}'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "DOLLAR"
	public final void mDOLLAR() throws RecognitionException {
		try {
			int _type = DOLLAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1165:8: ( '$' )
			// org/antlr/grammar/v3/ANTLR.g:1165:10: '$'
			{
			match('$'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOLLAR"

	// $ANTLR start "STRAY_BRACKET"
	public final void mSTRAY_BRACKET() throws RecognitionException {
		try {
			int _type = STRAY_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1168:2: ( ']' )
			// org/antlr/grammar/v3/ANTLR.g:1168:4: ']'
			{
			match(']'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRAY_BRACKET"

	// $ANTLR start "CHAR_LITERAL"
	public final void mCHAR_LITERAL() throws RecognitionException {
		try {
			int _type = CHAR_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1172:2: ( '\\'' ( ESC |~ ( '\\\\' | '\\'' ) )* '\\'' )
			// org/antlr/grammar/v3/ANTLR.g:1172:4: '\\'' ( ESC |~ ( '\\\\' | '\\'' ) )* '\\''
			{
			match('\''); if (state.failed) return;
			// org/antlr/grammar/v3/ANTLR.g:1173:3: ( ESC |~ ( '\\\\' | '\\'' ) )*
			loop11:
			while (true) {
				int alt11=3;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\\') ) {
					alt11=1;
				}
				else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '&')||(LA11_0 >= '(' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
					alt11=2;
				}

				switch (alt11) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1173:5: ESC
					{
					mESC(); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1174:5: ~ ( '\\\\' | '\\'' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop11;
				}
			}

			match('\''); if (state.failed) return;
			if ( state.backtracking==0 ) {
						StringBuffer s = Grammar.getUnescapedStringFromGrammarStringLiteral(getText());
						if ( s.length() > 1 )
						{
							_type = STRING_LITERAL;
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
	// $ANTLR end "CHAR_LITERAL"

	// $ANTLR start "DOUBLE_QUOTE_STRING_LITERAL"
	public final void mDOUBLE_QUOTE_STRING_LITERAL() throws RecognitionException {
		try {
			int _type = DOUBLE_QUOTE_STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			int c;


				StringBuilder builder = new StringBuilder();

			// org/antlr/grammar/v3/ANTLR.g:1191:2: ( '\"' ( ( '\\\\\\\"' )=> '\\\\' '\"' | '\\\\' c=~ '\"' |c=~ ( '\\\\' | '\"' ) )* '\"' )
			// org/antlr/grammar/v3/ANTLR.g:1191:4: '\"' ( ( '\\\\\\\"' )=> '\\\\' '\"' | '\\\\' c=~ '\"' |c=~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); if (state.failed) return;
			if ( state.backtracking==0 ) {builder.append('"');}
			// org/antlr/grammar/v3/ANTLR.g:1192:3: ( ( '\\\\\\\"' )=> '\\\\' '\"' | '\\\\' c=~ '\"' |c=~ ( '\\\\' | '\"' ) )*
			loop12:
			while (true) {
				int alt12=4;
				int LA12_0 = input.LA(1);
				if ( (LA12_0=='\\') ) {
					int LA12_2 = input.LA(2);
					if ( (LA12_2=='\"') && (synpred2_ANTLR())) {
						alt12=1;
					}
					else if ( ((LA12_2 >= '\u0000' && LA12_2 <= '!')||(LA12_2 >= '#' && LA12_2 <= '\uFFFF')) ) {
						alt12=2;
					}

				}
				else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '!')||(LA12_0 >= '#' && LA12_0 <= '[')||(LA12_0 >= ']' && LA12_0 <= '\uFFFF')) ) {
					alt12=3;
				}

				switch (alt12) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1192:5: ( '\\\\\\\"' )=> '\\\\' '\"'
					{
					match('\\'); if (state.failed) return;
					match('\"'); if (state.failed) return;
					if ( state.backtracking==0 ) {builder.append('"');}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1193:5: '\\\\' c=~ '\"'
					{
					match('\\'); if (state.failed) return;
					c= input.LA(1);
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( state.backtracking==0 ) {builder.append("\\" + (char)c);}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:1194:5: c=~ ( '\\\\' | '\"' )
					{
					c= input.LA(1);
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( state.backtracking==0 ) {builder.append((char)c);}
					}
					break;

				default :
					break loop12;
				}
			}

			match('\"'); if (state.failed) return;
			if ( state.backtracking==0 ) {builder.append('"');}
			if ( state.backtracking==0 ) {
						setText(builder.toString());
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE_QUOTE_STRING_LITERAL"

	// $ANTLR start "DOUBLE_ANGLE_STRING_LITERAL"
	public final void mDOUBLE_ANGLE_STRING_LITERAL() throws RecognitionException {
		try {
			int _type = DOUBLE_ANGLE_STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1203:2: ( '<<' ( . )* '>>' )
			// org/antlr/grammar/v3/ANTLR.g:1203:4: '<<' ( . )* '>>'
			{
			match("<<"); if (state.failed) return;

			// org/antlr/grammar/v3/ANTLR.g:1203:9: ( . )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0=='>') ) {
					int LA13_1 = input.LA(2);
					if ( (LA13_1=='>') ) {
						alt13=2;
					}
					else if ( ((LA13_1 >= '\u0000' && LA13_1 <= '=')||(LA13_1 >= '?' && LA13_1 <= '\uFFFF')) ) {
						alt13=1;
					}

				}
				else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '=')||(LA13_0 >= '?' && LA13_0 <= '\uFFFF')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1203:9: .
					{
					matchAny(); if (state.failed) return;
					}
					break;

				default :
					break loop13;
				}
			}

			match(">>"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE_ANGLE_STRING_LITERAL"

	// $ANTLR start "ESC"
	public final void mESC() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1209:2: ( '\\\\' ( . ) )
			// org/antlr/grammar/v3/ANTLR.g:1209:4: '\\\\' ( . )
			{
			match('\\'); if (state.failed) return;
			// org/antlr/grammar/v3/ANTLR.g:1210:3: ( . )
			// org/antlr/grammar/v3/ANTLR.g:1221:7: .
			{
			matchAny(); if (state.failed) return;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1227:2: ( '0' .. '9' )
			// org/antlr/grammar/v3/ANTLR.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
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
	// $ANTLR end "DIGIT"

	// $ANTLR start "XDIGIT"
	public final void mXDIGIT() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1232:2: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// org/antlr/grammar/v3/ANTLR.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
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

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1237:2: ( ( '0' .. '9' )+ )
			// org/antlr/grammar/v3/ANTLR.g:1237:4: ( '0' .. '9' )+
			{
			// org/antlr/grammar/v3/ANTLR.g:1237:4: ( '0' .. '9' )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "ARG_ACTION"
	public final void mARG_ACTION() throws RecognitionException {
		try {
			int _type = ARG_ACTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;

				List<String> text = new ArrayList<String>() {{ add(null); }};

			// org/antlr/grammar/v3/ANTLR.g:1244:2: ( '[' NESTED_ARG_ACTION[text] ']' )
			// org/antlr/grammar/v3/ANTLR.g:1244:4: '[' NESTED_ARG_ACTION[text] ']'
			{
			match('['); if (state.failed) return;
			mNESTED_ARG_ACTION(text); if (state.failed) return;

			match(']'); if (state.failed) return;
			if ( state.backtracking==0 ) {setText(text.get(0));}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARG_ACTION"

	// $ANTLR start "NESTED_ARG_ACTION"
	public final void mNESTED_ARG_ACTION(List<String> text) throws RecognitionException {
		try {
			CommonToken ACTION_STRING_LITERAL1=null;
			CommonToken ACTION_CHAR_LITERAL2=null;
			int c;


				text.set(0, "");
				StringBuilder builder = new StringBuilder();

			// org/antlr/grammar/v3/ANTLR.g:1257:2: ( ( ( '\\\\]' )=> '\\\\' ']' | '\\\\' c=~ ( ']' ) | ACTION_STRING_LITERAL | ACTION_CHAR_LITERAL |c=~ ( '\\\\' | '\"' | '\\'' | ']' ) )* )
			// org/antlr/grammar/v3/ANTLR.g:1257:4: ( ( '\\\\]' )=> '\\\\' ']' | '\\\\' c=~ ( ']' ) | ACTION_STRING_LITERAL | ACTION_CHAR_LITERAL |c=~ ( '\\\\' | '\"' | '\\'' | ']' ) )*
			{
			// org/antlr/grammar/v3/ANTLR.g:1257:4: ( ( '\\\\]' )=> '\\\\' ']' | '\\\\' c=~ ( ']' ) | ACTION_STRING_LITERAL | ACTION_CHAR_LITERAL |c=~ ( '\\\\' | '\"' | '\\'' | ']' ) )*
			loop15:
			while (true) {
				int alt15=6;
				int LA15_0 = input.LA(1);
				if ( (LA15_0=='\\') ) {
					int LA15_2 = input.LA(2);
					if ( (LA15_2==']') && (synpred3_ANTLR())) {
						alt15=1;
					}
					else if ( ((LA15_2 >= '\u0000' && LA15_2 <= '\\')||(LA15_2 >= '^' && LA15_2 <= '\uFFFF')) ) {
						alt15=2;
					}

				}
				else if ( (LA15_0=='\"') ) {
					alt15=3;
				}
				else if ( (LA15_0=='\'') ) {
					alt15=4;
				}
				else if ( ((LA15_0 >= '\u0000' && LA15_0 <= '!')||(LA15_0 >= '#' && LA15_0 <= '&')||(LA15_0 >= '(' && LA15_0 <= '[')||(LA15_0 >= '^' && LA15_0 <= '\uFFFF')) ) {
					alt15=5;
				}

				switch (alt15) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1257:6: ( '\\\\]' )=> '\\\\' ']'
					{
					match('\\'); if (state.failed) return;
					match(']'); if (state.failed) return;
					if ( state.backtracking==0 ) {builder.append("]");}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1258:5: '\\\\' c=~ ( ']' )
					{
					match('\\'); if (state.failed) return;
					c= input.LA(1);
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\\')||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( state.backtracking==0 ) {builder.append("\\" + (char)c);}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:1259:5: ACTION_STRING_LITERAL
					{
					int ACTION_STRING_LITERAL1Start859 = getCharIndex();
					int ACTION_STRING_LITERAL1StartLine859 = getLine();
					int ACTION_STRING_LITERAL1StartCharPos859 = getCharPositionInLine();
					mACTION_STRING_LITERAL(); if (state.failed) return;
					ACTION_STRING_LITERAL1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ACTION_STRING_LITERAL1Start859, getCharIndex()-1);
					ACTION_STRING_LITERAL1.setLine(ACTION_STRING_LITERAL1StartLine859);
					ACTION_STRING_LITERAL1.setCharPositionInLine(ACTION_STRING_LITERAL1StartCharPos859);

					if ( state.backtracking==0 ) {builder.append((ACTION_STRING_LITERAL1!=null?ACTION_STRING_LITERAL1.getText():null));}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:1260:5: ACTION_CHAR_LITERAL
					{
					int ACTION_CHAR_LITERAL2Start867 = getCharIndex();
					int ACTION_CHAR_LITERAL2StartLine867 = getLine();
					int ACTION_CHAR_LITERAL2StartCharPos867 = getCharPositionInLine();
					mACTION_CHAR_LITERAL(); if (state.failed) return;
					ACTION_CHAR_LITERAL2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ACTION_CHAR_LITERAL2Start867, getCharIndex()-1);
					ACTION_CHAR_LITERAL2.setLine(ACTION_CHAR_LITERAL2StartLine867);
					ACTION_CHAR_LITERAL2.setCharPositionInLine(ACTION_CHAR_LITERAL2StartCharPos867);

					if ( state.backtracking==0 ) {builder.append((ACTION_CHAR_LITERAL2!=null?ACTION_CHAR_LITERAL2.getText():null));}
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLR.g:1261:5: c=~ ( '\\\\' | '\"' | '\\'' | ']' )
					{
					c= input.LA(1);
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( state.backtracking==0 ) {builder.append((char)c);}
					}
					break;

				default :
					break loop15;
				}
			}

			if ( state.backtracking==0 ) {
						text.set(0, builder.toString());
					}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NESTED_ARG_ACTION"

	// $ANTLR start "ACTION"
	public final void mACTION() throws RecognitionException {
		try {
			int _type = ACTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;

				int actionLine = getLine();
				int actionColumn = getCharPositionInLine();

			// org/antlr/grammar/v3/ANTLR.g:1273:2: ( NESTED_ACTION ( '?' )? )
			// org/antlr/grammar/v3/ANTLR.g:1273:4: NESTED_ACTION ( '?' )?
			{
			mNESTED_ACTION(); if (state.failed) return;

			// org/antlr/grammar/v3/ANTLR.g:1274:3: ( '?' )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0=='?') ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1274:4: '?'
					{
					match('?'); if (state.failed) return;
					if ( state.backtracking==0 ) {_type = SEMPRED;}
					}
					break;

			}

			if ( state.backtracking==0 ) {
						String action = getText();
						int n = 1; // num delimiter chars
						if ( action.startsWith("{{") && action.endsWith("}}") )
						{
							_type = FORCED_ACTION;
							n = 2;
						}
						action = action.substring(n,action.length()-n - (_type==SEMPRED ? 1 : 0));
						setText(action);
					}
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
			// org/antlr/grammar/v3/ANTLR.g:1291:2: ( '{' ( NESTED_ACTION | ACTION_CHAR_LITERAL | ( '//' | '/*' )=> COMMENT | ACTION_STRING_LITERAL | ACTION_ESC |~ ( '{' | '\\'' | '\"' | '\\\\' | '}' ) )* '}' )
			// org/antlr/grammar/v3/ANTLR.g:1291:4: '{' ( NESTED_ACTION | ACTION_CHAR_LITERAL | ( '//' | '/*' )=> COMMENT | ACTION_STRING_LITERAL | ACTION_ESC |~ ( '{' | '\\'' | '\"' | '\\\\' | '}' ) )* '}'
			{
			match('{'); if (state.failed) return;
			// org/antlr/grammar/v3/ANTLR.g:1292:3: ( NESTED_ACTION | ACTION_CHAR_LITERAL | ( '//' | '/*' )=> COMMENT | ACTION_STRING_LITERAL | ACTION_ESC |~ ( '{' | '\\'' | '\"' | '\\\\' | '}' ) )*
			loop17:
			while (true) {
				int alt17=7;
				int LA17_0 = input.LA(1);
				if ( (LA17_0=='{') ) {
					alt17=1;
				}
				else if ( (LA17_0=='\'') ) {
					alt17=2;
				}
				else if ( (LA17_0=='/') ) {
					int LA17_4 = input.LA(2);
					if ( (synpred4_ANTLR()) ) {
						alt17=3;
					}
					else if ( (true) ) {
						alt17=6;
					}

				}
				else if ( (LA17_0=='\"') ) {
					alt17=4;
				}
				else if ( (LA17_0=='\\') ) {
					alt17=5;
				}
				else if ( ((LA17_0 >= '\u0000' && LA17_0 <= '!')||(LA17_0 >= '#' && LA17_0 <= '&')||(LA17_0 >= '(' && LA17_0 <= '.')||(LA17_0 >= '0' && LA17_0 <= '[')||(LA17_0 >= ']' && LA17_0 <= 'z')||LA17_0=='|'||(LA17_0 >= '~' && LA17_0 <= '\uFFFF')) ) {
					alt17=6;
				}

				switch (alt17) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1292:5: NESTED_ACTION
					{
					mNESTED_ACTION(); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1293:5: ACTION_CHAR_LITERAL
					{
					mACTION_CHAR_LITERAL(); if (state.failed) return;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:1294:5: ( '//' | '/*' )=> COMMENT
					{
					mCOMMENT(); if (state.failed) return;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:1295:5: ACTION_STRING_LITERAL
					{
					mACTION_STRING_LITERAL(); if (state.failed) return;

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLR.g:1296:5: ACTION_ESC
					{
					mACTION_ESC(); if (state.failed) return;

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLR.g:1297:5: ~ ( '{' | '\\'' | '\"' | '\\\\' | '}' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= 'z')||input.LA(1)=='|'||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop17;
				}
			}

			match('}'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NESTED_ACTION"

	// $ANTLR start "ACTION_CHAR_LITERAL"
	public final void mACTION_CHAR_LITERAL() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1304:2: ( '\\'' ( ACTION_ESC |~ ( '\\\\' | '\\'' ) )* '\\'' )
			// org/antlr/grammar/v3/ANTLR.g:1304:4: '\\'' ( ACTION_ESC |~ ( '\\\\' | '\\'' ) )* '\\''
			{
			match('\''); if (state.failed) return;
			// org/antlr/grammar/v3/ANTLR.g:1305:3: ( ACTION_ESC |~ ( '\\\\' | '\\'' ) )*
			loop18:
			while (true) {
				int alt18=3;
				int LA18_0 = input.LA(1);
				if ( (LA18_0=='\\') ) {
					alt18=1;
				}
				else if ( ((LA18_0 >= '\u0000' && LA18_0 <= '&')||(LA18_0 >= '(' && LA18_0 <= '[')||(LA18_0 >= ']' && LA18_0 <= '\uFFFF')) ) {
					alt18=2;
				}

				switch (alt18) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1305:5: ACTION_ESC
					{
					mACTION_ESC(); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1306:5: ~ ( '\\\\' | '\\'' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop18;
				}
			}

			match('\''); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTION_CHAR_LITERAL"

	// $ANTLR start "ACTION_STRING_LITERAL"
	public final void mACTION_STRING_LITERAL() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1313:2: ( '\"' ( ACTION_ESC |~ ( '\\\\' | '\"' ) )* '\"' )
			// org/antlr/grammar/v3/ANTLR.g:1313:4: '\"' ( ACTION_ESC |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); if (state.failed) return;
			// org/antlr/grammar/v3/ANTLR.g:1314:3: ( ACTION_ESC |~ ( '\\\\' | '\"' ) )*
			loop19:
			while (true) {
				int alt19=3;
				int LA19_0 = input.LA(1);
				if ( (LA19_0=='\\') ) {
					alt19=1;
				}
				else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '!')||(LA19_0 >= '#' && LA19_0 <= '[')||(LA19_0 >= ']' && LA19_0 <= '\uFFFF')) ) {
					alt19=2;
				}

				switch (alt19) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1314:5: ACTION_ESC
					{
					mACTION_ESC(); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1315:5: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop19;
				}
			}

			match('\"'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTION_STRING_LITERAL"

	// $ANTLR start "ACTION_ESC"
	public final void mACTION_ESC() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1322:2: ( '\\\\\\'' | '\\\\\\\"' | '\\\\' ~ ( '\\'' | '\"' ) )
			int alt20=3;
			int LA20_0 = input.LA(1);
			if ( (LA20_0=='\\') ) {
				int LA20_1 = input.LA(2);
				if ( (LA20_1=='\'') ) {
					alt20=1;
				}
				else if ( (LA20_1=='\"') ) {
					alt20=2;
				}
				else if ( ((LA20_1 >= '\u0000' && LA20_1 <= '!')||(LA20_1 >= '#' && LA20_1 <= '&')||(LA20_1 >= '(' && LA20_1 <= '\uFFFF')) ) {
					alt20=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1322:4: '\\\\\\''
					{
					match("\\'"); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1323:4: '\\\\\\\"'
					{
					match("\\\""); if (state.failed) return;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:1324:4: '\\\\' ~ ( '\\'' | '\"' )
					{
					match('\\'); if (state.failed) return;
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTION_ESC"

	// $ANTLR start "TOKEN_REF"
	public final void mTOKEN_REF() throws RecognitionException {
		try {
			int _type = TOKEN_REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1327:2: ( 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// org/antlr/grammar/v3/ANTLR.g:1327:4: 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
			matchRange('A','Z'); if (state.failed) return;
			// org/antlr/grammar/v3/ANTLR.g:1328:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( ((LA21_0 >= '0' && LA21_0 <= '9')||(LA21_0 >= 'A' && LA21_0 <= 'Z')||LA21_0=='_'||(LA21_0 >= 'a' && LA21_0 <= 'z')) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop21;
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

	// $ANTLR start "TOKENS"
	public final void mTOKENS() throws RecognitionException {
		try {
			int _type = TOKENS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1333:2: ( 'tokens' WS_LOOP '{' )
			// org/antlr/grammar/v3/ANTLR.g:1333:4: 'tokens' WS_LOOP '{'
			{
			match("tokens"); if (state.failed) return;

			mWS_LOOP(); if (state.failed) return;

			match('{'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TOKENS"

	// $ANTLR start "OPTIONS"
	public final void mOPTIONS() throws RecognitionException {
		try {
			int _type = OPTIONS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ANTLR.g:1337:2: ( 'options' WS_LOOP '{' )
			// org/antlr/grammar/v3/ANTLR.g:1337:4: 'options' WS_LOOP '{'
			{
			match("options"); if (state.failed) return;

			mWS_LOOP(); if (state.failed) return;

			match('{'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPTIONS"

	// $ANTLR start "RULE_REF"
	public final void mRULE_REF() throws RecognitionException {
		try {
			int _type = RULE_REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;

				int t=0;

			// org/antlr/grammar/v3/ANTLR.g:1346:2: ( 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// org/antlr/grammar/v3/ANTLR.g:1346:4: 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
			matchRange('a','z'); if (state.failed) return;
			// org/antlr/grammar/v3/ANTLR.g:1346:13: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( ((LA22_0 >= '0' && LA22_0 <= '9')||(LA22_0 >= 'A' && LA22_0 <= 'Z')||LA22_0=='_'||(LA22_0 >= 'a' && LA22_0 <= 'z')) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop22;
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

	// $ANTLR start "WS_LOOP"
	public final void mWS_LOOP() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1352:2: ( ( WS | COMMENT )* )
			// org/antlr/grammar/v3/ANTLR.g:1352:4: ( WS | COMMENT )*
			{
			// org/antlr/grammar/v3/ANTLR.g:1352:4: ( WS | COMMENT )*
			loop23:
			while (true) {
				int alt23=3;
				int LA23_0 = input.LA(1);
				if ( ((LA23_0 >= '\t' && LA23_0 <= '\n')||LA23_0=='\r'||LA23_0==' ') ) {
					alt23=1;
				}
				else if ( (LA23_0=='/') ) {
					alt23=2;
				}

				switch (alt23) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1352:6: WS
					{
					mWS(); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1353:5: COMMENT
					{
					mCOMMENT(); if (state.failed) return;

					}
					break;

				default :
					break loop23;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS_LOOP"

	// $ANTLR start "WS_OPT"
	public final void mWS_OPT() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLR.g:1359:2: ( ( WS )? )
			// org/antlr/grammar/v3/ANTLR.g:1359:4: ( WS )?
			{
			// org/antlr/grammar/v3/ANTLR.g:1359:4: ( WS )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( ((LA24_0 >= '\t' && LA24_0 <= '\n')||LA24_0=='\r'||LA24_0==' ') ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1359:5: WS
					{
					mWS(); if (state.failed) return;

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS_OPT"

	// $ANTLR start "SRC"
	public final void mSRC() throws RecognitionException {
		try {
			CommonToken file=null;
			CommonToken line=null;

			// org/antlr/grammar/v3/ANTLR.g:1372:2: ( 'src' ' ' file= ACTION_STRING_LITERAL ' ' line= INT )
			// org/antlr/grammar/v3/ANTLR.g:1372:4: 'src' ' ' file= ACTION_STRING_LITERAL ' ' line= INT
			{
			match("src"); if (state.failed) return;

			match(' '); if (state.failed) return;
			int fileStart1272 = getCharIndex();
			int fileStartLine1272 = getLine();
			int fileStartCharPos1272 = getCharPositionInLine();
			mACTION_STRING_LITERAL(); if (state.failed) return;
			file = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fileStart1272, getCharIndex()-1);
			file.setLine(fileStartLine1272);
			file.setCharPositionInLine(fileStartCharPos1272);

			match(' '); if (state.failed) return;
			int lineStart1278 = getCharIndex();
			int lineStartLine1278 = getLine();
			int lineStartCharPos1278 = getCharPositionInLine();
			mINT(); if (state.failed) return;
			line = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, lineStart1278, getCharIndex()-1);
			line.setLine(lineStartLine1278);
			line.setCharPositionInLine(lineStartCharPos1278);

			if ( state.backtracking==0 ) {
						setFileName((file!=null?file.getText():null).substring(1,(file!=null?file.getText():null).length()-1));
						input.setLine(Integer.parseInt((line!=null?line.getText():null)) - 1);  // -1 because SL_COMMENT will increment the line no. KR
					}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SRC"

	@Override
	public void mTokens() throws RecognitionException {
		// org/antlr/grammar/v3/ANTLR.g:1:8: ( CATCH | FINALLY | FRAGMENT | GRAMMAR | IMPORT | LEXER | PARSER | PRIVATE | PROTECTED | PUBLIC | RETURNS | SCOPE | THROWS | TREE | WS | COMMENT | OPEN_ELEMENT_OPTION | CLOSE_ELEMENT_OPTION | AMPERSAND | COMMA | QUESTION | TREE_BEGIN | LPAREN | RPAREN | COLON | STAR | PLUS | ASSIGN | PLUS_ASSIGN | IMPLIES | REWRITE | SEMI | ROOT | BANG | OR | WILDCARD | ETC | RANGE | NOT | RCURLY | DOLLAR | STRAY_BRACKET | CHAR_LITERAL | DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL | INT | ARG_ACTION | ACTION | TOKEN_REF | TOKENS | OPTIONS | RULE_REF )
		int alt25=52;
		alt25 = dfa25.predict(input);
		switch (alt25) {
			case 1 :
				// org/antlr/grammar/v3/ANTLR.g:1:10: CATCH
				{
				mCATCH(); if (state.failed) return;

				}
				break;
			case 2 :
				// org/antlr/grammar/v3/ANTLR.g:1:16: FINALLY
				{
				mFINALLY(); if (state.failed) return;

				}
				break;
			case 3 :
				// org/antlr/grammar/v3/ANTLR.g:1:24: FRAGMENT
				{
				mFRAGMENT(); if (state.failed) return;

				}
				break;
			case 4 :
				// org/antlr/grammar/v3/ANTLR.g:1:33: GRAMMAR
				{
				mGRAMMAR(); if (state.failed) return;

				}
				break;
			case 5 :
				// org/antlr/grammar/v3/ANTLR.g:1:41: IMPORT
				{
				mIMPORT(); if (state.failed) return;

				}
				break;
			case 6 :
				// org/antlr/grammar/v3/ANTLR.g:1:48: LEXER
				{
				mLEXER(); if (state.failed) return;

				}
				break;
			case 7 :
				// org/antlr/grammar/v3/ANTLR.g:1:54: PARSER
				{
				mPARSER(); if (state.failed) return;

				}
				break;
			case 8 :
				// org/antlr/grammar/v3/ANTLR.g:1:61: PRIVATE
				{
				mPRIVATE(); if (state.failed) return;

				}
				break;
			case 9 :
				// org/antlr/grammar/v3/ANTLR.g:1:69: PROTECTED
				{
				mPROTECTED(); if (state.failed) return;

				}
				break;
			case 10 :
				// org/antlr/grammar/v3/ANTLR.g:1:79: PUBLIC
				{
				mPUBLIC(); if (state.failed) return;

				}
				break;
			case 11 :
				// org/antlr/grammar/v3/ANTLR.g:1:86: RETURNS
				{
				mRETURNS(); if (state.failed) return;

				}
				break;
			case 12 :
				// org/antlr/grammar/v3/ANTLR.g:1:94: SCOPE
				{
				mSCOPE(); if (state.failed) return;

				}
				break;
			case 13 :
				// org/antlr/grammar/v3/ANTLR.g:1:100: THROWS
				{
				mTHROWS(); if (state.failed) return;

				}
				break;
			case 14 :
				// org/antlr/grammar/v3/ANTLR.g:1:107: TREE
				{
				mTREE(); if (state.failed) return;

				}
				break;
			case 15 :
				// org/antlr/grammar/v3/ANTLR.g:1:112: WS
				{
				mWS(); if (state.failed) return;

				}
				break;
			case 16 :
				// org/antlr/grammar/v3/ANTLR.g:1:115: COMMENT
				{
				mCOMMENT(); if (state.failed) return;

				}
				break;
			case 17 :
				// org/antlr/grammar/v3/ANTLR.g:1:123: OPEN_ELEMENT_OPTION
				{
				mOPEN_ELEMENT_OPTION(); if (state.failed) return;

				}
				break;
			case 18 :
				// org/antlr/grammar/v3/ANTLR.g:1:143: CLOSE_ELEMENT_OPTION
				{
				mCLOSE_ELEMENT_OPTION(); if (state.failed) return;

				}
				break;
			case 19 :
				// org/antlr/grammar/v3/ANTLR.g:1:164: AMPERSAND
				{
				mAMPERSAND(); if (state.failed) return;

				}
				break;
			case 20 :
				// org/antlr/grammar/v3/ANTLR.g:1:174: COMMA
				{
				mCOMMA(); if (state.failed) return;

				}
				break;
			case 21 :
				// org/antlr/grammar/v3/ANTLR.g:1:180: QUESTION
				{
				mQUESTION(); if (state.failed) return;

				}
				break;
			case 22 :
				// org/antlr/grammar/v3/ANTLR.g:1:189: TREE_BEGIN
				{
				mTREE_BEGIN(); if (state.failed) return;

				}
				break;
			case 23 :
				// org/antlr/grammar/v3/ANTLR.g:1:200: LPAREN
				{
				mLPAREN(); if (state.failed) return;

				}
				break;
			case 24 :
				// org/antlr/grammar/v3/ANTLR.g:1:207: RPAREN
				{
				mRPAREN(); if (state.failed) return;

				}
				break;
			case 25 :
				// org/antlr/grammar/v3/ANTLR.g:1:214: COLON
				{
				mCOLON(); if (state.failed) return;

				}
				break;
			case 26 :
				// org/antlr/grammar/v3/ANTLR.g:1:220: STAR
				{
				mSTAR(); if (state.failed) return;

				}
				break;
			case 27 :
				// org/antlr/grammar/v3/ANTLR.g:1:225: PLUS
				{
				mPLUS(); if (state.failed) return;

				}
				break;
			case 28 :
				// org/antlr/grammar/v3/ANTLR.g:1:230: ASSIGN
				{
				mASSIGN(); if (state.failed) return;

				}
				break;
			case 29 :
				// org/antlr/grammar/v3/ANTLR.g:1:237: PLUS_ASSIGN
				{
				mPLUS_ASSIGN(); if (state.failed) return;

				}
				break;
			case 30 :
				// org/antlr/grammar/v3/ANTLR.g:1:249: IMPLIES
				{
				mIMPLIES(); if (state.failed) return;

				}
				break;
			case 31 :
				// org/antlr/grammar/v3/ANTLR.g:1:257: REWRITE
				{
				mREWRITE(); if (state.failed) return;

				}
				break;
			case 32 :
				// org/antlr/grammar/v3/ANTLR.g:1:265: SEMI
				{
				mSEMI(); if (state.failed) return;

				}
				break;
			case 33 :
				// org/antlr/grammar/v3/ANTLR.g:1:270: ROOT
				{
				mROOT(); if (state.failed) return;

				}
				break;
			case 34 :
				// org/antlr/grammar/v3/ANTLR.g:1:275: BANG
				{
				mBANG(); if (state.failed) return;

				}
				break;
			case 35 :
				// org/antlr/grammar/v3/ANTLR.g:1:280: OR
				{
				mOR(); if (state.failed) return;

				}
				break;
			case 36 :
				// org/antlr/grammar/v3/ANTLR.g:1:283: WILDCARD
				{
				mWILDCARD(); if (state.failed) return;

				}
				break;
			case 37 :
				// org/antlr/grammar/v3/ANTLR.g:1:292: ETC
				{
				mETC(); if (state.failed) return;

				}
				break;
			case 38 :
				// org/antlr/grammar/v3/ANTLR.g:1:296: RANGE
				{
				mRANGE(); if (state.failed) return;

				}
				break;
			case 39 :
				// org/antlr/grammar/v3/ANTLR.g:1:302: NOT
				{
				mNOT(); if (state.failed) return;

				}
				break;
			case 40 :
				// org/antlr/grammar/v3/ANTLR.g:1:306: RCURLY
				{
				mRCURLY(); if (state.failed) return;

				}
				break;
			case 41 :
				// org/antlr/grammar/v3/ANTLR.g:1:313: DOLLAR
				{
				mDOLLAR(); if (state.failed) return;

				}
				break;
			case 42 :
				// org/antlr/grammar/v3/ANTLR.g:1:320: STRAY_BRACKET
				{
				mSTRAY_BRACKET(); if (state.failed) return;

				}
				break;
			case 43 :
				// org/antlr/grammar/v3/ANTLR.g:1:334: CHAR_LITERAL
				{
				mCHAR_LITERAL(); if (state.failed) return;

				}
				break;
			case 44 :
				// org/antlr/grammar/v3/ANTLR.g:1:347: DOUBLE_QUOTE_STRING_LITERAL
				{
				mDOUBLE_QUOTE_STRING_LITERAL(); if (state.failed) return;

				}
				break;
			case 45 :
				// org/antlr/grammar/v3/ANTLR.g:1:375: DOUBLE_ANGLE_STRING_LITERAL
				{
				mDOUBLE_ANGLE_STRING_LITERAL(); if (state.failed) return;

				}
				break;
			case 46 :
				// org/antlr/grammar/v3/ANTLR.g:1:403: INT
				{
				mINT(); if (state.failed) return;

				}
				break;
			case 47 :
				// org/antlr/grammar/v3/ANTLR.g:1:407: ARG_ACTION
				{
				mARG_ACTION(); if (state.failed) return;

				}
				break;
			case 48 :
				// org/antlr/grammar/v3/ANTLR.g:1:418: ACTION
				{
				mACTION(); if (state.failed) return;

				}
				break;
			case 49 :
				// org/antlr/grammar/v3/ANTLR.g:1:425: TOKEN_REF
				{
				mTOKEN_REF(); if (state.failed) return;

				}
				break;
			case 50 :
				// org/antlr/grammar/v3/ANTLR.g:1:435: TOKENS
				{
				mTOKENS(); if (state.failed) return;

				}
				break;
			case 51 :
				// org/antlr/grammar/v3/ANTLR.g:1:442: OPTIONS
				{
				mOPTIONS(); if (state.failed) return;

				}
				break;
			case 52 :
				// org/antlr/grammar/v3/ANTLR.g:1:450: RULE_REF
				{
				mRULE_REF(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_ANTLR
	public final void synpred1_ANTLR_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ANTLR.g:1101:5: ( ' $ANTLR' )
		// org/antlr/grammar/v3/ANTLR.g:1101:6: ' $ANTLR'
		{
		match(" $ANTLR"); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_ANTLR

	// $ANTLR start synpred2_ANTLR
	public final void synpred2_ANTLR_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ANTLR.g:1192:5: ( '\\\\\\\"' )
		// org/antlr/grammar/v3/ANTLR.g:1192:6: '\\\\\\\"'
		{
		match("\\\""); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_ANTLR

	// $ANTLR start synpred3_ANTLR
	public final void synpred3_ANTLR_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ANTLR.g:1257:6: ( '\\\\]' )
		// org/antlr/grammar/v3/ANTLR.g:1257:7: '\\\\]'
		{
		match("\\]"); if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_ANTLR

	// $ANTLR start synpred4_ANTLR
	public final void synpred4_ANTLR_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ANTLR.g:1294:5: ( '//' | '/*' )
		int alt26=2;
		int LA26_0 = input.LA(1);
		if ( (LA26_0=='/') ) {
			int LA26_1 = input.LA(2);
			if ( (LA26_1=='/') ) {
				alt26=1;
			}
			else if ( (LA26_1=='*') ) {
				alt26=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 26, 1, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 26, 0, input);
			throw nvae;
		}

		switch (alt26) {
			case 1 :
				// org/antlr/grammar/v3/ANTLR.g:1294:6: '//'
				{
				match("//"); if (state.failed) return;

				}
				break;
			case 2 :
				// org/antlr/grammar/v3/ANTLR.g:1294:13: '/*'
				{
				match("/*"); if (state.failed) return;

				}
				break;

		}
	}
	// $ANTLR end synpred4_ANTLR

	public final boolean synpred1_ANTLR() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_ANTLR_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_ANTLR() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_ANTLR_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_ANTLR() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_ANTLR_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_ANTLR() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_ANTLR_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA9 dfa9 = new DFA9(this);
	protected DFA25 dfa25 = new DFA25(this);
	static final String DFA9_eotS =
		"\2\2\1\uffff\15\2\1\uffff\5\2\1\uffff\2\2\3\uffff\1\2\1\uffff";
	static final String DFA9_eofS =
		"\36\uffff";
	static final String DFA9_minS =
		"\1\40\1\44\1\uffff\1\101\1\116\1\124\1\114\1\122\1\40\1\163\1\162\1\143"+
		"\1\40\1\42\3\0\1\40\7\0\3\uffff\1\60\1\0";
	static final String DFA9_maxS =
		"\1\40\1\44\1\uffff\1\101\1\116\1\124\1\114\1\122\1\40\1\163\1\162\1\143"+
		"\1\40\1\42\3\uffff\1\40\7\uffff\3\uffff\1\71\1\0";
	static final String DFA9_acceptS =
		"\2\uffff\1\2\26\uffff\3\1\2\uffff";
	static final String DFA9_specialS =
		"\16\uffff\1\6\1\0\1\7\1\uffff\1\11\1\1\1\2\1\4\1\12\1\3\1\5\4\uffff\1"+
		"\10}>";
	static final String[] DFA9_transitionS = {
			"\1\1",
			"\1\3",
			"",
			"\1\4",
			"\1\5",
			"\1\6",
			"\1\7",
			"\1\10",
			"\1\11",
			"\1\12",
			"\1\13",
			"\1\14",
			"\1\15",
			"\1\16",
			"\12\23\1\22\2\23\1\20\24\23\1\21\71\23\1\17\uffa3\23",
			"\12\30\1\27\2\30\1\26\24\30\1\25\4\30\1\24\uffd8\30",
			"\12\33\1\22\27\33\1\31\71\33\1\32\uffa3\33",
			"\1\34",
			"\42\33\1\31\71\33\1\32\uffa3\33",
			"\12\23\1\22\2\23\1\20\24\23\1\21\71\23\1\17\uffa3\23",
			"\12\23\1\22\2\23\1\20\24\23\1\21\71\23\1\17\uffa3\23",
			"\12\23\1\22\2\23\1\20\24\23\1\21\71\23\1\17\uffa3\23",
			"\12\33\1\22\27\33\1\31\71\33\1\32\uffa3\33",
			"\42\33\1\31\71\33\1\32\uffa3\33",
			"\12\23\1\22\2\23\1\20\24\23\1\21\71\23\1\17\uffa3\23",
			"",
			"",
			"",
			"\12\35",
			"\1\uffff"
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "1101:3: ( ( ' $ANTLR' )=> ' $ANTLR ' SRC ( ( '\\r' )? '\\n' )? | (~ ( '\\r' | '\\n' ) )* ( ( '\\r' )? '\\n' )? )";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA9_15 = input.LA(1);
						s = -1;
						if ( (LA9_15=='\'') ) {s = 20;}
						else if ( (LA9_15=='\"') ) {s = 21;}
						else if ( (LA9_15=='\r') ) {s = 22;}
						else if ( (LA9_15=='\n') ) {s = 23;}
						else if ( ((LA9_15 >= '\u0000' && LA9_15 <= '\t')||(LA9_15 >= '\u000B' && LA9_15 <= '\f')||(LA9_15 >= '\u000E' && LA9_15 <= '!')||(LA9_15 >= '#' && LA9_15 <= '&')||(LA9_15 >= '(' && LA9_15 <= '\uFFFF')) ) {s = 24;}
						else s = 2;
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA9_19 = input.LA(1);
						s = -1;
						if ( (LA9_19=='\"') ) {s = 17;}
						else if ( (LA9_19=='\\') ) {s = 15;}
						else if ( (LA9_19=='\r') ) {s = 16;}
						else if ( (LA9_19=='\n') ) {s = 18;}
						else if ( ((LA9_19 >= '\u0000' && LA9_19 <= '\t')||(LA9_19 >= '\u000B' && LA9_19 <= '\f')||(LA9_19 >= '\u000E' && LA9_19 <= '!')||(LA9_19 >= '#' && LA9_19 <= '[')||(LA9_19 >= ']' && LA9_19 <= '\uFFFF')) ) {s = 19;}
						else s = 2;
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA9_20 = input.LA(1);
						s = -1;
						if ( (LA9_20=='\"') ) {s = 17;}
						else if ( (LA9_20=='\\') ) {s = 15;}
						else if ( (LA9_20=='\r') ) {s = 16;}
						else if ( (LA9_20=='\n') ) {s = 18;}
						else if ( ((LA9_20 >= '\u0000' && LA9_20 <= '\t')||(LA9_20 >= '\u000B' && LA9_20 <= '\f')||(LA9_20 >= '\u000E' && LA9_20 <= '!')||(LA9_20 >= '#' && LA9_20 <= '[')||(LA9_20 >= ']' && LA9_20 <= '\uFFFF')) ) {s = 19;}
						else s = 2;
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA9_23 = input.LA(1);
						 
						int index9_23 = input.index();
						input.rewind();
						s = -1;
						if ( (LA9_23=='\"') && (synpred1_ANTLR())) {s = 25;}
						else if ( (LA9_23=='\\') && (synpred1_ANTLR())) {s = 26;}
						else if ( ((LA9_23 >= '\u0000' && LA9_23 <= '!')||(LA9_23 >= '#' && LA9_23 <= '[')||(LA9_23 >= ']' && LA9_23 <= '\uFFFF')) && (synpred1_ANTLR())) {s = 27;}
						else s = 2;
						 
						input.seek(index9_23);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA9_21 = input.LA(1);
						s = -1;
						if ( (LA9_21=='\"') ) {s = 17;}
						else if ( (LA9_21=='\\') ) {s = 15;}
						else if ( (LA9_21=='\r') ) {s = 16;}
						else if ( (LA9_21=='\n') ) {s = 18;}
						else if ( ((LA9_21 >= '\u0000' && LA9_21 <= '\t')||(LA9_21 >= '\u000B' && LA9_21 <= '\f')||(LA9_21 >= '\u000E' && LA9_21 <= '!')||(LA9_21 >= '#' && LA9_21 <= '[')||(LA9_21 >= ']' && LA9_21 <= '\uFFFF')) ) {s = 19;}
						else s = 2;
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA9_24 = input.LA(1);
						s = -1;
						if ( (LA9_24=='\"') ) {s = 17;}
						else if ( (LA9_24=='\\') ) {s = 15;}
						else if ( (LA9_24=='\r') ) {s = 16;}
						else if ( (LA9_24=='\n') ) {s = 18;}
						else if ( ((LA9_24 >= '\u0000' && LA9_24 <= '\t')||(LA9_24 >= '\u000B' && LA9_24 <= '\f')||(LA9_24 >= '\u000E' && LA9_24 <= '!')||(LA9_24 >= '#' && LA9_24 <= '[')||(LA9_24 >= ']' && LA9_24 <= '\uFFFF')) ) {s = 19;}
						else s = 2;
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA9_14 = input.LA(1);
						s = -1;
						if ( (LA9_14=='\\') ) {s = 15;}
						else if ( (LA9_14=='\r') ) {s = 16;}
						else if ( (LA9_14=='\"') ) {s = 17;}
						else if ( (LA9_14=='\n') ) {s = 18;}
						else if ( ((LA9_14 >= '\u0000' && LA9_14 <= '\t')||(LA9_14 >= '\u000B' && LA9_14 <= '\f')||(LA9_14 >= '\u000E' && LA9_14 <= '!')||(LA9_14 >= '#' && LA9_14 <= '[')||(LA9_14 >= ']' && LA9_14 <= '\uFFFF')) ) {s = 19;}
						else s = 2;
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA9_16 = input.LA(1);
						 
						int index9_16 = input.index();
						input.rewind();
						s = -1;
						if ( (LA9_16=='\"') && (synpred1_ANTLR())) {s = 25;}
						else if ( (LA9_16=='\\') && (synpred1_ANTLR())) {s = 26;}
						else if ( (LA9_16=='\n') ) {s = 18;}
						else if ( ((LA9_16 >= '\u0000' && LA9_16 <= '\t')||(LA9_16 >= '\u000B' && LA9_16 <= '!')||(LA9_16 >= '#' && LA9_16 <= '[')||(LA9_16 >= ']' && LA9_16 <= '\uFFFF')) && (synpred1_ANTLR())) {s = 27;}
						 
						input.seek(index9_16);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA9_29 = input.LA(1);
						 
						int index9_29 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_ANTLR()) ) {s = 27;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index9_29);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA9_18 = input.LA(1);
						 
						int index9_18 = input.index();
						input.rewind();
						s = -1;
						if ( (LA9_18=='\"') && (synpred1_ANTLR())) {s = 25;}
						else if ( (LA9_18=='\\') && (synpred1_ANTLR())) {s = 26;}
						else if ( ((LA9_18 >= '\u0000' && LA9_18 <= '!')||(LA9_18 >= '#' && LA9_18 <= '[')||(LA9_18 >= ']' && LA9_18 <= '\uFFFF')) && (synpred1_ANTLR())) {s = 27;}
						else s = 2;
						 
						input.seek(index9_18);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA9_22 = input.LA(1);
						 
						int index9_22 = input.index();
						input.rewind();
						s = -1;
						if ( (LA9_22=='\"') && (synpred1_ANTLR())) {s = 25;}
						else if ( (LA9_22=='\\') && (synpred1_ANTLR())) {s = 26;}
						else if ( (LA9_22=='\n') ) {s = 18;}
						else if ( ((LA9_22 >= '\u0000' && LA9_22 <= '\t')||(LA9_22 >= '\u000B' && LA9_22 <= '!')||(LA9_22 >= '#' && LA9_22 <= '[')||(LA9_22 >= ']' && LA9_22 <= '\uFFFF')) && (synpred1_ANTLR())) {s = 27;}
						 
						input.seek(index9_22);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 9, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA25_eotS =
		"\1\uffff\11\50\2\uffff\1\70\4\uffff\1\72\4\uffff\1\74\1\76\4\uffff\1\100"+
		"\12\uffff\1\50\1\uffff\16\50\10\uffff\1\122\1\uffff\20\50\2\uffff\16\50"+
		"\1\161\2\50\1\164\4\50\1\171\5\50\1\177\1\50\1\uffff\2\50\1\uffff\3\50"+
		"\1\u0086\1\uffff\1\u0087\2\50\1\u008a\1\50\1\uffff\1\u008c\2\50\1\u008f"+
		"\1\50\1\u0091\2\uffff\1\u0092\1\50\1\uffff\1\u0094\2\uffff\1\50\1\uffff"+
		"\1\u0096\2\uffff\1\50\3\uffff\1\u0098\1\uffff";
	static final String DFA25_eofS =
		"\u0099\uffff";
	static final String DFA25_minS =
		"\1\11\1\141\1\151\1\162\1\155\1\145\1\141\1\145\1\143\1\150\2\uffff\1"+
		"\74\4\uffff\1\50\4\uffff\1\75\1\76\4\uffff\1\56\12\uffff\1\160\1\uffff"+
		"\1\164\1\156\2\141\1\160\1\170\1\162\1\151\1\142\1\164\1\157\1\162\1\145"+
		"\1\153\10\uffff\1\56\1\uffff\1\164\1\143\1\141\1\147\1\155\1\157\1\145"+
		"\1\163\1\166\1\164\1\154\1\165\1\160\1\157\2\145\2\uffff\1\151\1\150\1"+
		"\154\2\155\2\162\1\145\1\141\1\145\1\151\1\162\1\145\1\167\1\60\1\156"+
		"\1\157\1\60\1\154\1\145\1\141\1\164\1\60\1\162\1\164\2\143\1\156\1\60"+
		"\1\163\1\uffff\1\163\1\156\1\uffff\1\171\1\156\1\162\1\60\1\uffff\1\60"+
		"\1\145\1\164\1\60\1\163\1\uffff\1\60\1\11\1\163\1\60\1\164\1\60\2\uffff"+
		"\1\60\1\145\1\uffff\1\60\2\uffff\1\11\1\uffff\1\60\2\uffff\1\144\3\uffff"+
		"\1\60\1\uffff";
	static final String DFA25_maxS =
		"\1\176\1\141\2\162\1\155\1\145\1\165\1\145\1\143\1\162\2\uffff\1\74\4"+
		"\uffff\1\50\4\uffff\1\75\1\76\4\uffff\1\56\12\uffff\1\160\1\uffff\1\164"+
		"\1\156\2\141\1\160\1\170\1\162\1\157\1\142\1\164\1\157\1\162\1\145\1\153"+
		"\10\uffff\1\56\1\uffff\1\164\1\143\1\141\1\147\1\155\1\157\1\145\1\163"+
		"\1\166\1\164\1\154\1\165\1\160\1\157\2\145\2\uffff\1\151\1\150\1\154\2"+
		"\155\2\162\1\145\1\141\1\145\1\151\1\162\1\145\1\167\1\172\1\156\1\157"+
		"\1\172\1\154\1\145\1\141\1\164\1\172\1\162\1\164\2\143\1\156\1\172\1\163"+
		"\1\uffff\1\163\1\156\1\uffff\1\171\1\156\1\162\1\172\1\uffff\1\172\1\145"+
		"\1\164\1\172\1\163\1\uffff\1\172\1\173\1\163\1\172\1\164\1\172\2\uffff"+
		"\1\172\1\145\1\uffff\1\172\2\uffff\1\173\1\uffff\1\172\2\uffff\1\144\3"+
		"\uffff\1\172\1\uffff";
	static final String DFA25_acceptS =
		"\12\uffff\1\17\1\20\1\uffff\1\22\1\23\1\24\1\25\1\uffff\1\27\1\30\1\31"+
		"\1\32\2\uffff\1\37\1\40\1\42\1\43\1\uffff\1\47\1\50\1\51\1\52\1\53\1\54"+
		"\1\56\1\57\1\60\1\61\1\uffff\1\64\16\uffff\1\55\1\21\1\26\1\41\1\35\1"+
		"\33\1\36\1\34\1\uffff\1\44\20\uffff\1\45\1\46\36\uffff\1\16\2\uffff\1"+
		"\1\4\uffff\1\6\5\uffff\1\14\6\uffff\1\5\1\7\2\uffff\1\12\1\uffff\1\15"+
		"\1\62\1\uffff\1\2\1\uffff\1\4\1\10\1\uffff\1\13\1\63\1\3\1\uffff\1\11";
	static final String DFA25_specialS =
		"\u0099\uffff}>";
	static final String[] DFA25_transitionS = {
			"\2\12\2\uffff\1\12\22\uffff\1\12\1\32\1\42\1\uffff\1\37\2\uffff\1\41"+
			"\1\22\1\23\1\25\1\26\1\17\1\30\1\34\1\13\12\43\1\24\1\31\1\14\1\27\1"+
			"\15\1\20\1\16\32\46\1\44\1\uffff\1\40\1\21\2\uffff\2\50\1\1\2\50\1\2"+
			"\1\3\1\50\1\4\2\50\1\5\2\50\1\47\1\6\1\50\1\7\1\10\1\11\6\50\1\45\1\33"+
			"\1\36\1\35",
			"\1\51",
			"\1\52\10\uffff\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57\20\uffff\1\60\2\uffff\1\61",
			"\1\62",
			"\1\63",
			"\1\64\6\uffff\1\66\2\uffff\1\65",
			"",
			"",
			"\1\67",
			"",
			"",
			"",
			"",
			"\1\71",
			"",
			"",
			"",
			"",
			"\1\73",
			"\1\75",
			"",
			"",
			"",
			"",
			"\1\77",
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
			"\1\101",
			"",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111\5\uffff\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\121",
			"",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"",
			"",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\1\162",
			"\1\163",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\1\u0080",
			"",
			"\1\u0081",
			"\1\u0082",
			"",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\1\u0088",
			"\1\u0089",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\1\u008b",
			"",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\2\u008d\2\uffff\1\u008d\22\uffff\1\u008d\16\uffff\1\u008d\113\uffff"+
			"\1\u008d",
			"\1\u008e",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\1\u0090",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"",
			"",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"\1\u0093",
			"",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"",
			"",
			"\2\u0095\2\uffff\1\u0095\22\uffff\1\u0095\16\uffff\1\u0095\113\uffff"+
			"\1\u0095",
			"",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			"",
			"",
			"\1\u0097",
			"",
			"",
			"",
			"\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
			""
	};

	static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
	static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
	static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
	static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
	static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
	static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
	static final short[][] DFA25_transition;

	static {
		int numStates = DFA25_transitionS.length;
		DFA25_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
		}
	}

	protected class DFA25 extends DFA {

		public DFA25(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 25;
			this.eot = DFA25_eot;
			this.eof = DFA25_eof;
			this.min = DFA25_min;
			this.max = DFA25_max;
			this.accept = DFA25_accept;
			this.special = DFA25_special;
			this.transition = DFA25_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( CATCH | FINALLY | FRAGMENT | GRAMMAR | IMPORT | LEXER | PARSER | PRIVATE | PROTECTED | PUBLIC | RETURNS | SCOPE | THROWS | TREE | WS | COMMENT | OPEN_ELEMENT_OPTION | CLOSE_ELEMENT_OPTION | AMPERSAND | COMMA | QUESTION | TREE_BEGIN | LPAREN | RPAREN | COLON | STAR | PLUS | ASSIGN | PLUS_ASSIGN | IMPLIES | REWRITE | SEMI | ROOT | BANG | OR | WILDCARD | ETC | RANGE | NOT | RCURLY | DOLLAR | STRAY_BRACKET | CHAR_LITERAL | DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL | INT | ARG_ACTION | ACTION | TOKEN_REF | TOKENS | OPTIONS | RULE_REF );";
		}
	}

}
