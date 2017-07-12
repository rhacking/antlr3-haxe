// $ANTLR 3.5 org/antlr/grammar/v3/ANTLRv3Tree.g 2017-06-11 18:42:20

package org.antlr.grammar.v3;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/** ANTLR v3 tree grammar to walk trees created by ANTLRv3.g */
@SuppressWarnings("all")
public class ANTLRv3Tree extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", 
		"ACTION_ESC", "ACTION_STRING_LITERAL", "ALT", "ARG", "ARGLIST", "ARG_ACTION", 
		"AT", "BACKTRACK_SEMPRED", "BANG", "BLOCK", "CHAR_LITERAL", "CHAR_RANGE", 
		"CLOSURE", "COMBINED_GRAMMAR", "DOC_COMMENT", "DOUBLE_ANGLE_STRING_LITERAL", 
		"DOUBLE_QUOTE_STRING_LITERAL", "EOA", "EOB", "EOR", "EPSILON", "ESC", 
		"FRAGMENT", "GATED_SEMPRED", "ID", "INT", "LABEL", "LABEL_ASSIGN", "LEXER", 
		"LEXER_GRAMMAR", "LIST_LABEL_ASSIGN", "LITERAL_CHAR", "ML_COMMENT", "NESTED_ACTION", 
		"NESTED_ARG_ACTION", "OPTIONAL", "OPTIONS", "PARSER", "PARSER_GRAMMAR", 
		"POSITIVE_CLOSURE", "RANGE", "RET", "REWRITE", "ROOT", "RULE", "RULE_REF", 
		"SCOPE", "SEMPRED", "SL_COMMENT", "SRC", "STRING_LITERAL", "SYNPRED", 
		"SYN_SEMPRED", "TEMPLATE", "TOKENS", "TOKEN_REF", "TREE_BEGIN", "TREE_GRAMMAR", 
		"WS", "WS_LOOP", "XDIGIT", "'$'", "'('", "')'", "'*'", "'+'", "','", "'.'", 
		"':'", "'::'", "';'", "'<'", "'=>'", "'>'", "'?'", "'catch'", "'finally'", 
		"'grammar'", "'lexer'", "'parser'", "'private'", "'protected'", "'public'", 
		"'throws'", "'tree'", "'|'", "'}'", "'~'"
	};
	public static final int EOF=-1;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int T__87=87;
	public static final int T__88=88;
	public static final int T__89=89;
	public static final int T__90=90;
	public static final int T__91=91;
	public static final int T__92=92;
	public static final int T__93=93;
	public static final int ACTION=4;
	public static final int ACTION_CHAR_LITERAL=5;
	public static final int ACTION_ESC=6;
	public static final int ACTION_STRING_LITERAL=7;
	public static final int ALT=8;
	public static final int ARG=9;
	public static final int ARGLIST=10;
	public static final int ARG_ACTION=11;
	public static final int AT=12;
	public static final int BACKTRACK_SEMPRED=13;
	public static final int BANG=14;
	public static final int BLOCK=15;
	public static final int CHAR_LITERAL=16;
	public static final int CHAR_RANGE=17;
	public static final int CLOSURE=18;
	public static final int COMBINED_GRAMMAR=19;
	public static final int DOC_COMMENT=20;
	public static final int DOUBLE_ANGLE_STRING_LITERAL=21;
	public static final int DOUBLE_QUOTE_STRING_LITERAL=22;
	public static final int EOA=23;
	public static final int EOB=24;
	public static final int EOR=25;
	public static final int EPSILON=26;
	public static final int ESC=27;
	public static final int FRAGMENT=28;
	public static final int GATED_SEMPRED=29;
	public static final int ID=30;
	public static final int INT=31;
	public static final int LABEL=32;
	public static final int LABEL_ASSIGN=33;
	public static final int LEXER=34;
	public static final int LEXER_GRAMMAR=35;
	public static final int LIST_LABEL_ASSIGN=36;
	public static final int LITERAL_CHAR=37;
	public static final int ML_COMMENT=38;
	public static final int NESTED_ACTION=39;
	public static final int NESTED_ARG_ACTION=40;
	public static final int OPTIONAL=41;
	public static final int OPTIONS=42;
	public static final int PARSER=43;
	public static final int PARSER_GRAMMAR=44;
	public static final int POSITIVE_CLOSURE=45;
	public static final int RANGE=46;
	public static final int RET=47;
	public static final int REWRITE=48;
	public static final int ROOT=49;
	public static final int RULE=50;
	public static final int RULE_REF=51;
	public static final int SCOPE=52;
	public static final int SEMPRED=53;
	public static final int SL_COMMENT=54;
	public static final int SRC=55;
	public static final int STRING_LITERAL=56;
	public static final int SYNPRED=57;
	public static final int SYN_SEMPRED=58;
	public static final int TEMPLATE=59;
	public static final int TOKENS=60;
	public static final int TOKEN_REF=61;
	public static final int TREE_BEGIN=62;
	public static final int TREE_GRAMMAR=63;
	public static final int WS=64;
	public static final int WS_LOOP=65;
	public static final int XDIGIT=66;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public ANTLRv3Tree(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public ANTLRv3Tree(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ANTLRv3Tree.tokenNames; }
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/ANTLRv3Tree.g"; }



	// $ANTLR start "grammarDef"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:42:1: grammarDef : ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ ) ;
	public final void grammarDef() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:43:5: ( ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:43:9: ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ )
			{
			pushFollow(FOLLOW_grammarType_in_grammarDef58);
			grammarType();
			state._fsp--;

			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_grammarDef60); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:43:27: ( DOC_COMMENT )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==DOC_COMMENT) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:43:27: DOC_COMMENT
					{
					match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarDef62); 
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:43:40: ( optionsSpec )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==OPTIONS) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:43:40: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_grammarDef65);
					optionsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:43:53: ( tokensSpec )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==TOKENS) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:43:53: tokensSpec
					{
					pushFollow(FOLLOW_tokensSpec_in_grammarDef68);
					tokensSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:43:65: ( attrScope )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==SCOPE) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:43:65: attrScope
					{
					pushFollow(FOLLOW_attrScope_in_grammarDef71);
					attrScope();
					state._fsp--;

					}
					break;

				default :
					break loop4;
				}
			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:43:76: ( action )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==AT) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:43:76: action
					{
					pushFollow(FOLLOW_action_in_grammarDef74);
					action();
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:43:84: ( rule )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==RULE) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:43:84: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef77);
					rule();
					state._fsp--;

					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "grammarDef"



	// $ANTLR start "grammarType"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:46:1: grammarType : ( LEXER_GRAMMAR | PARSER_GRAMMAR | TREE_GRAMMAR | COMBINED_GRAMMAR );
	public final void grammarType() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:47:2: ( LEXER_GRAMMAR | PARSER_GRAMMAR | TREE_GRAMMAR | COMBINED_GRAMMAR )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:
			{
			if ( input.LA(1)==COMBINED_GRAMMAR||input.LA(1)==LEXER_GRAMMAR||input.LA(1)==PARSER_GRAMMAR||input.LA(1)==TREE_GRAMMAR ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "grammarType"



	// $ANTLR start "tokensSpec"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:53:1: tokensSpec : ^( TOKENS ( tokenSpec )+ ) ;
	public final void tokensSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:54:2: ( ^( TOKENS ( tokenSpec )+ ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:54:4: ^( TOKENS ( tokenSpec )+ )
			{
			match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec133); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:54:13: ( tokenSpec )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==LABEL_ASSIGN||LA7_0==TOKEN_REF) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:54:13: tokenSpec
					{
					pushFollow(FOLLOW_tokenSpec_in_tokensSpec135);
					tokenSpec();
					state._fsp--;

					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tokensSpec"



	// $ANTLR start "tokenSpec"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:57:1: tokenSpec : ( ^( '=' TOKEN_REF STRING_LITERAL ) | ^( '=' TOKEN_REF CHAR_LITERAL ) | TOKEN_REF );
	public final void tokenSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:58:2: ( ^( '=' TOKEN_REF STRING_LITERAL ) | ^( '=' TOKEN_REF CHAR_LITERAL ) | TOKEN_REF )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==LABEL_ASSIGN) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==DOWN) ) {
					int LA8_3 = input.LA(3);
					if ( (LA8_3==TOKEN_REF) ) {
						int LA8_4 = input.LA(4);
						if ( (LA8_4==STRING_LITERAL) ) {
							alt8=1;
						}
						else if ( (LA8_4==CHAR_LITERAL) ) {
							alt8=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 8, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 8, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA8_0==TOKEN_REF) ) {
				alt8=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:58:4: ^( '=' TOKEN_REF STRING_LITERAL )
					{
					match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_tokenSpec149); 
					match(input, Token.DOWN, null); 
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec151); 
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenSpec153); 
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:59:4: ^( '=' TOKEN_REF CHAR_LITERAL )
					{
					match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_tokenSpec160); 
					match(input, Token.DOWN, null); 
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec162); 
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_tokenSpec164); 
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:60:4: TOKEN_REF
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec170); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tokenSpec"



	// $ANTLR start "attrScope"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:63:1: attrScope : ^( 'scope' ID ACTION ) ;
	public final void attrScope() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:64:2: ( ^( 'scope' ID ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:64:4: ^( 'scope' ID ACTION )
			{
			match(input,SCOPE,FOLLOW_SCOPE_in_attrScope182); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_attrScope184); 
			match(input,ACTION,FOLLOW_ACTION_in_attrScope186); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "attrScope"



	// $ANTLR start "action"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:67:1: action : ( ^( '@' ID ID ACTION ) | ^( '@' ID ACTION ) );
	public final void action() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:68:2: ( ^( '@' ID ID ACTION ) | ^( '@' ID ACTION ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==AT) ) {
				int LA9_1 = input.LA(2);
				if ( (LA9_1==DOWN) ) {
					int LA9_2 = input.LA(3);
					if ( (LA9_2==ID) ) {
						int LA9_3 = input.LA(4);
						if ( (LA9_3==ID) ) {
							alt9=1;
						}
						else if ( (LA9_3==ACTION) ) {
							alt9=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 9, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 9, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:68:4: ^( '@' ID ID ACTION )
					{
					match(input,AT,FOLLOW_AT_in_action199); 
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_action201); 
					match(input,ID,FOLLOW_ID_in_action203); 
					match(input,ACTION,FOLLOW_ACTION_in_action205); 
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:69:4: ^( '@' ID ACTION )
					{
					match(input,AT,FOLLOW_AT_in_action212); 
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_action214); 
					match(input,ACTION,FOLLOW_ACTION_in_action216); 
					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "action"



	// $ANTLR start "optionsSpec"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:72:1: optionsSpec : ^( OPTIONS ( option )+ ) ;
	public final void optionsSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:73:2: ( ^( OPTIONS ( option )+ ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:73:4: ^( OPTIONS ( option )+ )
			{
			match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec229); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:73:14: ( option )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==ID||LA10_0==LABEL_ASSIGN) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:73:14: option
					{
					pushFollow(FOLLOW_option_in_optionsSpec231);
					option();
					state._fsp--;

					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "optionsSpec"



	// $ANTLR start "option"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:76:1: option : ( qid | ^( '=' ID optionValue ) );
	public final void option() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:77:5: ( qid | ^( '=' ID optionValue ) )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==ID) ) {
				alt11=1;
			}
			else if ( (LA11_0==LABEL_ASSIGN) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:77:9: qid
					{
					pushFollow(FOLLOW_qid_in_option249);
					qid();
					state._fsp--;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:78:7: ^( '=' ID optionValue )
					{
					match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_option259); 
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_option261); 
					pushFollow(FOLLOW_optionValue_in_option263);
					optionValue();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "option"



	// $ANTLR start "optionValue"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:81:1: optionValue : ( ID | STRING_LITERAL | CHAR_LITERAL | INT );
	public final void optionValue() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:82:5: ( ID | STRING_LITERAL | CHAR_LITERAL | INT )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:
			{
			if ( input.LA(1)==CHAR_LITERAL||(input.LA(1) >= ID && input.LA(1) <= INT)||input.LA(1)==STRING_LITERAL ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "optionValue"



	// $ANTLR start "rule"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:88:1: rule : ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR ) ;
	public final void rule() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:89:2: ( ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:89:4: ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR )
			{
			match(input,RULE,FOLLOW_RULE_in_rule329); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_rule331); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:89:15: ( modifier )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==FRAGMENT||(LA12_0 >= 86 && LA12_0 <= 88)) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:89:15: modifier
					{
					pushFollow(FOLLOW_modifier_in_rule333);
					modifier();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:89:25: ( ^( ARG ARG_ACTION ) )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==ARG) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:89:26: ^( ARG ARG_ACTION )
					{
					match(input,ARG,FOLLOW_ARG_in_rule338); 
					match(input, Token.DOWN, null); 
					match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule340); 
					match(input, Token.UP, null); 

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:89:46: ( ^( RET ARG_ACTION ) )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==RET) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:89:47: ^( RET ARG_ACTION )
					{
					match(input,RET,FOLLOW_RET_in_rule347); 
					match(input, Token.DOWN, null); 
					match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule349); 
					match(input, Token.UP, null); 

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:90:9: ( throwsSpec )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==89) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:90:9: throwsSpec
					{
					pushFollow(FOLLOW_throwsSpec_in_rule362);
					throwsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:90:21: ( optionsSpec )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==OPTIONS) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:90:21: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_rule365);
					optionsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:90:34: ( ruleScopeSpec )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==SCOPE) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:90:34: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_rule368);
					ruleScopeSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:90:49: ( ruleAction )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==AT) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:90:49: ruleAction
					{
					pushFollow(FOLLOW_ruleAction_in_rule371);
					ruleAction();
					state._fsp--;

					}
					break;

				default :
					break loop18;
				}
			}

			pushFollow(FOLLOW_altList_in_rule382);
			altList();
			state._fsp--;

			// org/antlr/grammar/v3/ANTLRv3Tree.g:92:9: ( exceptionGroup )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( ((LA19_0 >= 81 && LA19_0 <= 82)) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:92:9: exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_rule392);
					exceptionGroup();
					state._fsp--;

					}
					break;

			}

			match(input,EOR,FOLLOW_EOR_in_rule395); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rule"



	// $ANTLR start "modifier"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:96:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
	public final void modifier() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:97:2: ( 'protected' | 'public' | 'private' | 'fragment' )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:
			{
			if ( input.LA(1)==FRAGMENT||(input.LA(1) >= 86 && input.LA(1) <= 88) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "modifier"



	// $ANTLR start "ruleAction"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:101:1: ruleAction : ^( '@' ID ACTION ) ;
	public final void ruleAction() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:102:2: ( ^( '@' ID ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:102:4: ^( '@' ID ACTION )
			{
			match(input,AT,FOLLOW_AT_in_ruleAction434); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_ruleAction436); 
			match(input,ACTION,FOLLOW_ACTION_in_ruleAction438); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ruleAction"



	// $ANTLR start "throwsSpec"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:105:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
	public final void throwsSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:106:2: ( ^( 'throws' ( ID )+ ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:106:4: ^( 'throws' ( ID )+ )
			{
			match(input,89,FOLLOW_89_in_throwsSpec451); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:106:15: ( ID )+
			int cnt20=0;
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==ID) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:106:15: ID
					{
					match(input,ID,FOLLOW_ID_in_throwsSpec453); 
					}
					break;

				default :
					if ( cnt20 >= 1 ) break loop20;
					EarlyExitException eee = new EarlyExitException(20, input);
					throw eee;
				}
				cnt20++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "throwsSpec"



	// $ANTLR start "ruleScopeSpec"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:109:1: ruleScopeSpec : ( ^( 'scope' ACTION ) | ^( 'scope' ACTION ( ID )+ ) | ^( 'scope' ( ID )+ ) );
	public final void ruleScopeSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:110:2: ( ^( 'scope' ACTION ) | ^( 'scope' ACTION ( ID )+ ) | ^( 'scope' ( ID )+ ) )
			int alt23=3;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==SCOPE) ) {
				int LA23_1 = input.LA(2);
				if ( (LA23_1==DOWN) ) {
					int LA23_2 = input.LA(3);
					if ( (LA23_2==ACTION) ) {
						int LA23_3 = input.LA(4);
						if ( (LA23_3==UP) ) {
							alt23=1;
						}
						else if ( (LA23_3==ID) ) {
							alt23=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 23, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA23_2==ID) ) {
						alt23=3;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 23, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 23, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:110:4: ^( 'scope' ACTION )
					{
					match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec467); 
					match(input, Token.DOWN, null); 
					match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec469); 
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:111:4: ^( 'scope' ACTION ( ID )+ )
					{
					match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec476); 
					match(input, Token.DOWN, null); 
					match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec478); 
					// org/antlr/grammar/v3/ANTLRv3Tree.g:111:21: ( ID )+
					int cnt21=0;
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0==ID) ) {
							alt21=1;
						}

						switch (alt21) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:111:21: ID
							{
							match(input,ID,FOLLOW_ID_in_ruleScopeSpec480); 
							}
							break;

						default :
							if ( cnt21 >= 1 ) break loop21;
							EarlyExitException eee = new EarlyExitException(21, input);
							throw eee;
						}
						cnt21++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:112:4: ^( 'scope' ( ID )+ )
					{
					match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec488); 
					match(input, Token.DOWN, null); 
					// org/antlr/grammar/v3/ANTLRv3Tree.g:112:14: ( ID )+
					int cnt22=0;
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==ID) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:112:14: ID
							{
							match(input,ID,FOLLOW_ID_in_ruleScopeSpec490); 
							}
							break;

						default :
							if ( cnt22 >= 1 ) break loop22;
							EarlyExitException eee = new EarlyExitException(22, input);
							throw eee;
						}
						cnt22++;
					}

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ruleScopeSpec"



	// $ANTLR start "block"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:115:1: block : ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB ) ;
	public final void block() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:116:5: ( ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:116:9: ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_block510); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:116:18: ( optionsSpec )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==OPTIONS) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:116:18: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_block512);
					optionsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3Tree.g:116:31: ( alternative rewrite )+
			int cnt25=0;
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==ALT) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:116:32: alternative rewrite
					{
					pushFollow(FOLLOW_alternative_in_block516);
					alternative();
					state._fsp--;

					pushFollow(FOLLOW_rewrite_in_block518);
					rewrite();
					state._fsp--;

					}
					break;

				default :
					if ( cnt25 >= 1 ) break loop25;
					EarlyExitException eee = new EarlyExitException(25, input);
					throw eee;
				}
				cnt25++;
			}

			match(input,EOB,FOLLOW_EOB_in_block522); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "block"



	// $ANTLR start "altList"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:119:1: altList : ^( BLOCK ( alternative rewrite )+ EOB ) ;
	public final void altList() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:120:5: ( ^( BLOCK ( alternative rewrite )+ EOB ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:120:9: ^( BLOCK ( alternative rewrite )+ EOB )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_altList545); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:120:18: ( alternative rewrite )+
			int cnt26=0;
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==ALT) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:120:19: alternative rewrite
					{
					pushFollow(FOLLOW_alternative_in_altList548);
					alternative();
					state._fsp--;

					pushFollow(FOLLOW_rewrite_in_altList550);
					rewrite();
					state._fsp--;

					}
					break;

				default :
					if ( cnt26 >= 1 ) break loop26;
					EarlyExitException eee = new EarlyExitException(26, input);
					throw eee;
				}
				cnt26++;
			}

			match(input,EOB,FOLLOW_EOB_in_altList554); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "altList"



	// $ANTLR start "alternative"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:123:1: alternative : ( ^( ALT ( element )+ EOA ) | ^( ALT EPSILON EOA ) );
	public final void alternative() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:124:5: ( ^( ALT ( element )+ EOA ) | ^( ALT EPSILON EOA ) )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==ALT) ) {
				int LA28_1 = input.LA(2);
				if ( (LA28_1==DOWN) ) {
					int LA28_2 = input.LA(3);
					if ( (LA28_2==EPSILON) ) {
						alt28=2;
					}
					else if ( (LA28_2==ACTION||(LA28_2 >= BANG && LA28_2 <= CLOSURE)||LA28_2==GATED_SEMPRED||LA28_2==LABEL_ASSIGN||LA28_2==LIST_LABEL_ASSIGN||LA28_2==OPTIONAL||LA28_2==POSITIVE_CLOSURE||LA28_2==ROOT||LA28_2==RULE_REF||LA28_2==SEMPRED||(LA28_2 >= STRING_LITERAL && LA28_2 <= SYN_SEMPRED)||(LA28_2 >= TOKEN_REF && LA28_2 <= TREE_BEGIN)||LA28_2==73||LA28_2==93) ) {
						alt28=1;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 28, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 28, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:124:9: ^( ALT ( element )+ EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_alternative576); 
					match(input, Token.DOWN, null); 
					// org/antlr/grammar/v3/ANTLRv3Tree.g:124:15: ( element )+
					int cnt27=0;
					loop27:
					while (true) {
						int alt27=2;
						int LA27_0 = input.LA(1);
						if ( (LA27_0==ACTION||(LA27_0 >= BANG && LA27_0 <= CLOSURE)||LA27_0==GATED_SEMPRED||LA27_0==LABEL_ASSIGN||LA27_0==LIST_LABEL_ASSIGN||LA27_0==OPTIONAL||LA27_0==POSITIVE_CLOSURE||LA27_0==ROOT||LA27_0==RULE_REF||LA27_0==SEMPRED||(LA27_0 >= STRING_LITERAL && LA27_0 <= SYN_SEMPRED)||(LA27_0 >= TOKEN_REF && LA27_0 <= TREE_BEGIN)||LA27_0==73||LA27_0==93) ) {
							alt27=1;
						}

						switch (alt27) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:124:15: element
							{
							pushFollow(FOLLOW_element_in_alternative578);
							element();
							state._fsp--;

							}
							break;

						default :
							if ( cnt27 >= 1 ) break loop27;
							EarlyExitException eee = new EarlyExitException(27, input);
							throw eee;
						}
						cnt27++;
					}

					match(input,EOA,FOLLOW_EOA_in_alternative581); 
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:125:9: ^( ALT EPSILON EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_alternative593); 
					match(input, Token.DOWN, null); 
					match(input,EPSILON,FOLLOW_EPSILON_in_alternative595); 
					match(input,EOA,FOLLOW_EOA_in_alternative597); 
					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "alternative"



	// $ANTLR start "exceptionGroup"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:128:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
	public final void exceptionGroup() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:129:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==81) ) {
				alt31=1;
			}
			else if ( (LA31_0==82) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:129:4: ( exceptionHandler )+ ( finallyClause )?
					{
					// org/antlr/grammar/v3/ANTLRv3Tree.g:129:4: ( exceptionHandler )+
					int cnt29=0;
					loop29:
					while (true) {
						int alt29=2;
						int LA29_0 = input.LA(1);
						if ( (LA29_0==81) ) {
							alt29=1;
						}

						switch (alt29) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:129:4: exceptionHandler
							{
							pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup612);
							exceptionHandler();
							state._fsp--;

							}
							break;

						default :
							if ( cnt29 >= 1 ) break loop29;
							EarlyExitException eee = new EarlyExitException(29, input);
							throw eee;
						}
						cnt29++;
					}

					// org/antlr/grammar/v3/ANTLRv3Tree.g:129:22: ( finallyClause )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==82) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:129:22: finallyClause
							{
							pushFollow(FOLLOW_finallyClause_in_exceptionGroup615);
							finallyClause();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:130:4: finallyClause
					{
					pushFollow(FOLLOW_finallyClause_in_exceptionGroup621);
					finallyClause();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exceptionGroup"



	// $ANTLR start "exceptionHandler"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:133:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
	public final void exceptionHandler() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:134:5: ( ^( 'catch' ARG_ACTION ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:134:10: ^( 'catch' ARG_ACTION ACTION )
			{
			match(input,81,FOLLOW_81_in_exceptionHandler642); 
			match(input, Token.DOWN, null); 
			match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler644); 
			match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler646); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exceptionHandler"



	// $ANTLR start "finallyClause"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:137:1: finallyClause : ^( 'finally' ACTION ) ;
	public final void finallyClause() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:138:5: ( ^( 'finally' ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:138:10: ^( 'finally' ACTION )
			{
			match(input,82,FOLLOW_82_in_finallyClause668); 
			match(input, Token.DOWN, null); 
			match(input,ACTION,FOLLOW_ACTION_in_finallyClause670); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "finallyClause"



	// $ANTLR start "element"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:141:1: element : ( ^( ( '=' | '+=' ) ID block ) | ^( ( '=' | '+=' ) ID atom ) | atom | ebnf | ACTION | SEMPRED | GATED_SEMPRED | ^( TREE_BEGIN ( element )+ ) );
	public final void element() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:142:2: ( ^( ( '=' | '+=' ) ID block ) | ^( ( '=' | '+=' ) ID atom ) | atom | ebnf | ACTION | SEMPRED | GATED_SEMPRED | ^( TREE_BEGIN ( element )+ ) )
			int alt33=8;
			switch ( input.LA(1) ) {
			case LABEL_ASSIGN:
			case LIST_LABEL_ASSIGN:
				{
				int LA33_1 = input.LA(2);
				if ( (LA33_1==DOWN) ) {
					int LA33_8 = input.LA(3);
					if ( (LA33_8==ID) ) {
						int LA33_9 = input.LA(4);
						if ( (LA33_9==BLOCK) ) {
							alt33=1;
						}
						else if ( (LA33_9==BANG||(LA33_9 >= CHAR_LITERAL && LA33_9 <= CHAR_RANGE)||LA33_9==ROOT||LA33_9==RULE_REF||LA33_9==STRING_LITERAL||LA33_9==TOKEN_REF||LA33_9==73||LA33_9==93) ) {
							alt33=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 33, 9, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 33, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 33, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case BANG:
			case CHAR_LITERAL:
			case CHAR_RANGE:
			case ROOT:
			case RULE_REF:
			case STRING_LITERAL:
			case TOKEN_REF:
			case 73:
			case 93:
				{
				alt33=3;
				}
				break;
			case BLOCK:
			case CLOSURE:
			case OPTIONAL:
			case POSITIVE_CLOSURE:
			case SYNPRED:
			case SYN_SEMPRED:
				{
				alt33=4;
				}
				break;
			case ACTION:
				{
				alt33=5;
				}
				break;
			case SEMPRED:
				{
				alt33=6;
				}
				break;
			case GATED_SEMPRED:
				{
				alt33=7;
				}
				break;
			case TREE_BEGIN:
				{
				alt33=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}
			switch (alt33) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:142:4: ^( ( '=' | '+=' ) ID block )
					{
					if ( input.LA(1)==LABEL_ASSIGN||input.LA(1)==LIST_LABEL_ASSIGN ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_element692); 
					pushFollow(FOLLOW_block_in_element694);
					block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:143:4: ^( ( '=' | '+=' ) ID atom )
					{
					if ( input.LA(1)==LABEL_ASSIGN||input.LA(1)==LIST_LABEL_ASSIGN ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_element707); 
					pushFollow(FOLLOW_atom_in_element709);
					atom();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:144:4: atom
					{
					pushFollow(FOLLOW_atom_in_element715);
					atom();
					state._fsp--;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:145:4: ebnf
					{
					pushFollow(FOLLOW_ebnf_in_element720);
					ebnf();
					state._fsp--;

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:146:6: ACTION
					{
					match(input,ACTION,FOLLOW_ACTION_in_element727); 
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:147:6: SEMPRED
					{
					match(input,SEMPRED,FOLLOW_SEMPRED_in_element734); 
					}
					break;
				case 7 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:148:4: GATED_SEMPRED
					{
					match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element739); 
					}
					break;
				case 8 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:149:6: ^( TREE_BEGIN ( element )+ )
					{
					match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_element747); 
					match(input, Token.DOWN, null); 
					// org/antlr/grammar/v3/ANTLRv3Tree.g:149:19: ( element )+
					int cnt32=0;
					loop32:
					while (true) {
						int alt32=2;
						int LA32_0 = input.LA(1);
						if ( (LA32_0==ACTION||(LA32_0 >= BANG && LA32_0 <= CLOSURE)||LA32_0==GATED_SEMPRED||LA32_0==LABEL_ASSIGN||LA32_0==LIST_LABEL_ASSIGN||LA32_0==OPTIONAL||LA32_0==POSITIVE_CLOSURE||LA32_0==ROOT||LA32_0==RULE_REF||LA32_0==SEMPRED||(LA32_0 >= STRING_LITERAL && LA32_0 <= SYN_SEMPRED)||(LA32_0 >= TOKEN_REF && LA32_0 <= TREE_BEGIN)||LA32_0==73||LA32_0==93) ) {
							alt32=1;
						}

						switch (alt32) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:149:19: element
							{
							pushFollow(FOLLOW_element_in_element749);
							element();
							state._fsp--;

							}
							break;

						default :
							if ( cnt32 >= 1 ) break loop32;
							EarlyExitException eee = new EarlyExitException(32, input);
							throw eee;
						}
						cnt32++;
					}

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "element"



	// $ANTLR start "atom"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:152:1: atom : ( ^( ( '^' | '!' ) atom ) | ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ( optionsSpec )? ) | ^( '~' notTerminal ( optionsSpec )? ) | ^( '~' block ( optionsSpec )? ) | ^( RULE_REF ARG_ACTION ) | RULE_REF | CHAR_LITERAL | ^( CHAR_LITERAL optionsSpec ) | TOKEN_REF | ^( TOKEN_REF optionsSpec ) | ^( TOKEN_REF ARG_ACTION optionsSpec ) | ^( TOKEN_REF ARG_ACTION ) | STRING_LITERAL | ^( STRING_LITERAL optionsSpec ) | '.' | ^( '.' ( optionsSpec )? ) );
	public final void atom() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:152:5: ( ^( ( '^' | '!' ) atom ) | ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ( optionsSpec )? ) | ^( '~' notTerminal ( optionsSpec )? ) | ^( '~' block ( optionsSpec )? ) | ^( RULE_REF ARG_ACTION ) | RULE_REF | CHAR_LITERAL | ^( CHAR_LITERAL optionsSpec ) | TOKEN_REF | ^( TOKEN_REF optionsSpec ) | ^( TOKEN_REF ARG_ACTION optionsSpec ) | ^( TOKEN_REF ARG_ACTION ) | STRING_LITERAL | ^( STRING_LITERAL optionsSpec ) | '.' | ^( '.' ( optionsSpec )? ) )
			int alt38=16;
			switch ( input.LA(1) ) {
			case BANG:
			case ROOT:
				{
				alt38=1;
				}
				break;
			case CHAR_RANGE:
				{
				alt38=2;
				}
				break;
			case 93:
				{
				int LA38_3 = input.LA(2);
				if ( (LA38_3==DOWN) ) {
					int LA38_9 = input.LA(3);
					if ( (LA38_9==CHAR_LITERAL||LA38_9==STRING_LITERAL||LA38_9==TOKEN_REF) ) {
						alt38=3;
					}
					else if ( (LA38_9==BLOCK) ) {
						alt38=4;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 38, 9, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_REF:
				{
				int LA38_4 = input.LA(2);
				if ( (LA38_4==DOWN) ) {
					alt38=5;
				}
				else if ( ((LA38_4 >= UP && LA38_4 <= ACTION)||(LA38_4 >= BANG && LA38_4 <= CLOSURE)||LA38_4==EOA||LA38_4==GATED_SEMPRED||LA38_4==LABEL_ASSIGN||LA38_4==LIST_LABEL_ASSIGN||LA38_4==OPTIONAL||LA38_4==POSITIVE_CLOSURE||LA38_4==ROOT||LA38_4==RULE_REF||LA38_4==SEMPRED||(LA38_4 >= STRING_LITERAL && LA38_4 <= SYN_SEMPRED)||(LA38_4 >= TOKEN_REF && LA38_4 <= TREE_BEGIN)||LA38_4==73||LA38_4==93) ) {
					alt38=6;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CHAR_LITERAL:
				{
				int LA38_5 = input.LA(2);
				if ( (LA38_5==DOWN) ) {
					alt38=8;
				}
				else if ( ((LA38_5 >= UP && LA38_5 <= ACTION)||(LA38_5 >= BANG && LA38_5 <= CLOSURE)||LA38_5==EOA||LA38_5==GATED_SEMPRED||LA38_5==LABEL_ASSIGN||LA38_5==LIST_LABEL_ASSIGN||LA38_5==OPTIONAL||LA38_5==POSITIVE_CLOSURE||LA38_5==ROOT||LA38_5==RULE_REF||LA38_5==SEMPRED||(LA38_5 >= STRING_LITERAL && LA38_5 <= SYN_SEMPRED)||(LA38_5 >= TOKEN_REF && LA38_5 <= TREE_BEGIN)||LA38_5==73||LA38_5==93) ) {
					alt38=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case TOKEN_REF:
				{
				int LA38_6 = input.LA(2);
				if ( (LA38_6==DOWN) ) {
					int LA38_14 = input.LA(3);
					if ( (LA38_14==ARG_ACTION) ) {
						int LA38_22 = input.LA(4);
						if ( (LA38_22==UP) ) {
							alt38=12;
						}
						else if ( (LA38_22==OPTIONS) ) {
							alt38=11;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 38, 22, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA38_14==OPTIONS) ) {
						alt38=10;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 38, 14, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( ((LA38_6 >= UP && LA38_6 <= ACTION)||(LA38_6 >= BANG && LA38_6 <= CLOSURE)||LA38_6==EOA||LA38_6==GATED_SEMPRED||LA38_6==LABEL_ASSIGN||LA38_6==LIST_LABEL_ASSIGN||LA38_6==OPTIONAL||LA38_6==POSITIVE_CLOSURE||LA38_6==ROOT||LA38_6==RULE_REF||LA38_6==SEMPRED||(LA38_6 >= STRING_LITERAL && LA38_6 <= SYN_SEMPRED)||(LA38_6 >= TOKEN_REF && LA38_6 <= TREE_BEGIN)||LA38_6==73||LA38_6==93) ) {
					alt38=9;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case STRING_LITERAL:
				{
				int LA38_7 = input.LA(2);
				if ( (LA38_7==DOWN) ) {
					alt38=14;
				}
				else if ( ((LA38_7 >= UP && LA38_7 <= ACTION)||(LA38_7 >= BANG && LA38_7 <= CLOSURE)||LA38_7==EOA||LA38_7==GATED_SEMPRED||LA38_7==LABEL_ASSIGN||LA38_7==LIST_LABEL_ASSIGN||LA38_7==OPTIONAL||LA38_7==POSITIVE_CLOSURE||LA38_7==ROOT||LA38_7==RULE_REF||LA38_7==SEMPRED||(LA38_7 >= STRING_LITERAL && LA38_7 <= SYN_SEMPRED)||(LA38_7 >= TOKEN_REF && LA38_7 <= TREE_BEGIN)||LA38_7==73||LA38_7==93) ) {
					alt38=13;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 73:
				{
				int LA38_8 = input.LA(2);
				if ( (LA38_8==DOWN) ) {
					alt38=16;
				}
				else if ( ((LA38_8 >= UP && LA38_8 <= ACTION)||(LA38_8 >= BANG && LA38_8 <= CLOSURE)||LA38_8==EOA||LA38_8==GATED_SEMPRED||LA38_8==LABEL_ASSIGN||LA38_8==LIST_LABEL_ASSIGN||LA38_8==OPTIONAL||LA38_8==POSITIVE_CLOSURE||LA38_8==ROOT||LA38_8==RULE_REF||LA38_8==SEMPRED||(LA38_8 >= STRING_LITERAL && LA38_8 <= SYN_SEMPRED)||(LA38_8 >= TOKEN_REF && LA38_8 <= TREE_BEGIN)||LA38_8==73||LA38_8==93) ) {
					alt38=15;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 8, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}
			switch (alt38) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:152:9: ^( ( '^' | '!' ) atom )
					{
					if ( input.LA(1)==BANG||input.LA(1)==ROOT ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_atom_in_atom769);
					atom();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:153:4: ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ( optionsSpec )? )
					{
					match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_atom776); 
					match(input, Token.DOWN, null); 
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom778); 
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom780); 
					// org/antlr/grammar/v3/ANTLRv3Tree.g:153:43: ( optionsSpec )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0==OPTIONS) ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:153:43: optionsSpec
							{
							pushFollow(FOLLOW_optionsSpec_in_atom782);
							optionsSpec();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:154:4: ^( '~' notTerminal ( optionsSpec )? )
					{
					match(input,93,FOLLOW_93_in_atom790); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_notTerminal_in_atom792);
					notTerminal();
					state._fsp--;

					// org/antlr/grammar/v3/ANTLRv3Tree.g:154:22: ( optionsSpec )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==OPTIONS) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:154:22: optionsSpec
							{
							pushFollow(FOLLOW_optionsSpec_in_atom794);
							optionsSpec();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:155:4: ^( '~' block ( optionsSpec )? )
					{
					match(input,93,FOLLOW_93_in_atom802); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_atom804);
					block();
					state._fsp--;

					// org/antlr/grammar/v3/ANTLRv3Tree.g:155:16: ( optionsSpec )?
					int alt36=2;
					int LA36_0 = input.LA(1);
					if ( (LA36_0==OPTIONS) ) {
						alt36=1;
					}
					switch (alt36) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:155:16: optionsSpec
							{
							pushFollow(FOLLOW_optionsSpec_in_atom806);
							optionsSpec();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:156:7: ^( RULE_REF ARG_ACTION )
					{
					match(input,RULE_REF,FOLLOW_RULE_REF_in_atom817); 
					match(input, Token.DOWN, null); 
					match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom819); 
					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:157:7: RULE_REF
					{
					match(input,RULE_REF,FOLLOW_RULE_REF_in_atom828); 
					}
					break;
				case 7 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:158:9: CHAR_LITERAL
					{
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom838); 
					}
					break;
				case 8 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:159:9: ^( CHAR_LITERAL optionsSpec )
					{
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom849); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_optionsSpec_in_atom851);
					optionsSpec();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:160:7: TOKEN_REF
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom860); 
					}
					break;
				case 10 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:161:7: ^( TOKEN_REF optionsSpec )
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom869); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_optionsSpec_in_atom871);
					optionsSpec();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:162:7: ^( TOKEN_REF ARG_ACTION optionsSpec )
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom881); 
					match(input, Token.DOWN, null); 
					match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom883); 
					pushFollow(FOLLOW_optionsSpec_in_atom885);
					optionsSpec();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:163:7: ^( TOKEN_REF ARG_ACTION )
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom895); 
					match(input, Token.DOWN, null); 
					match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom897); 
					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:164:7: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom906); 
					}
					break;
				case 14 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:165:7: ^( STRING_LITERAL optionsSpec )
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom915); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_optionsSpec_in_atom917);
					optionsSpec();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:166:7: '.'
					{
					match(input,73,FOLLOW_73_in_atom926); 
					}
					break;
				case 16 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:167:7: ^( '.' ( optionsSpec )? )
					{
					match(input,73,FOLLOW_73_in_atom935); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// org/antlr/grammar/v3/ANTLRv3Tree.g:167:13: ( optionsSpec )?
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==OPTIONS) ) {
							alt37=1;
						}
						switch (alt37) {
							case 1 :
								// org/antlr/grammar/v3/ANTLRv3Tree.g:167:13: optionsSpec
								{
								pushFollow(FOLLOW_optionsSpec_in_atom937);
								optionsSpec();
								state._fsp--;

								}
								break;

						}

						match(input, Token.UP, null); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atom"



	// $ANTLR start "ebnf"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:171:1: ebnf : ( ^( SYNPRED block ) | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) | SYN_SEMPRED | block );
	public final void ebnf() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:172:2: ( ^( SYNPRED block ) | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) | SYN_SEMPRED | block )
			int alt39=6;
			switch ( input.LA(1) ) {
			case SYNPRED:
				{
				alt39=1;
				}
				break;
			case OPTIONAL:
				{
				alt39=2;
				}
				break;
			case CLOSURE:
				{
				alt39=3;
				}
				break;
			case POSITIVE_CLOSURE:
				{
				alt39=4;
				}
				break;
			case SYN_SEMPRED:
				{
				alt39=5;
				}
				break;
			case BLOCK:
				{
				alt39=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}
			switch (alt39) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:172:4: ^( SYNPRED block )
					{
					match(input,SYNPRED,FOLLOW_SYNPRED_in_ebnf956); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ebnf958);
					block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:173:4: ^( OPTIONAL block )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf965); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ebnf967);
					block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:174:6: ^( CLOSURE block )
					{
					match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf976); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ebnf978);
					block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:175:7: ^( POSITIVE_CLOSURE block )
					{
					match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf988); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ebnf990);
					block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:176:4: SYN_SEMPRED
					{
					match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_ebnf996); 
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:177:4: block
					{
					pushFollow(FOLLOW_block_in_ebnf1001);
					block();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ebnf"



	// $ANTLR start "notTerminal"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:180:1: notTerminal : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL );
	public final void notTerminal() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:181:2: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:
			{
			if ( input.LA(1)==CHAR_LITERAL||input.LA(1)==STRING_LITERAL||input.LA(1)==TOKEN_REF ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "notTerminal"



	// $ANTLR start "rewrite"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:188:1: rewrite : ( ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative ) |);
	public final void rewrite() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:189:2: ( ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative ) |)
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==REWRITE) ) {
				alt41=1;
			}
			else if ( (LA41_0==ALT||LA41_0==EOB) ) {
				alt41=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:189:4: ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative )
					{
					// org/antlr/grammar/v3/ANTLRv3Tree.g:189:4: ( ^( '->' SEMPRED rewrite_alternative ) )*
					loop40:
					while (true) {
						int alt40=2;
						int LA40_0 = input.LA(1);
						if ( (LA40_0==REWRITE) ) {
							int LA40_1 = input.LA(2);
							if ( (LA40_1==DOWN) ) {
								int LA40_2 = input.LA(3);
								if ( (LA40_2==SEMPRED) ) {
									alt40=1;
								}

							}

						}

						switch (alt40) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:189:5: ^( '->' SEMPRED rewrite_alternative )
							{
							match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1041); 
							match(input, Token.DOWN, null); 
							match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite1043); 
							pushFollow(FOLLOW_rewrite_alternative_in_rewrite1045);
							rewrite_alternative();
							state._fsp--;

							match(input, Token.UP, null); 

							}
							break;

						default :
							break loop40;
						}
					}

					match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1051); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_rewrite_alternative_in_rewrite1053);
					rewrite_alternative();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:191:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite"



	// $ANTLR start "rewrite_alternative"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:193:1: rewrite_alternative : ( rewrite_template | rewrite_tree_alternative | ^( ALT EPSILON EOA ) );
	public final void rewrite_alternative() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:194:2: ( rewrite_template | rewrite_tree_alternative | ^( ALT EPSILON EOA ) )
			int alt42=3;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==ACTION||LA42_0==TEMPLATE) ) {
				alt42=1;
			}
			else if ( (LA42_0==ALT) ) {
				int LA42_2 = input.LA(2);
				if ( (LA42_2==DOWN) ) {
					int LA42_3 = input.LA(3);
					if ( (LA42_3==EPSILON) ) {
						alt42=3;
					}
					else if ( (LA42_3==ACTION||(LA42_3 >= BLOCK && LA42_3 <= CHAR_LITERAL)||LA42_3==CLOSURE||LA42_3==LABEL||LA42_3==OPTIONAL||LA42_3==POSITIVE_CLOSURE||LA42_3==RULE_REF||LA42_3==STRING_LITERAL||(LA42_3 >= TOKEN_REF && LA42_3 <= TREE_BEGIN)) ) {
						alt42=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 42, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 42, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:194:4: rewrite_template
					{
					pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative1068);
					rewrite_template();
					state._fsp--;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:195:4: rewrite_tree_alternative
					{
					pushFollow(FOLLOW_rewrite_tree_alternative_in_rewrite_alternative1073);
					rewrite_tree_alternative();
					state._fsp--;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:196:9: ^( ALT EPSILON EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_rewrite_alternative1084); 
					match(input, Token.DOWN, null); 
					match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_alternative1086); 
					match(input,EOA,FOLLOW_EOA_in_rewrite_alternative1088); 
					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_alternative"



	// $ANTLR start "rewrite_tree_block"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:199:1: rewrite_tree_block : ^( BLOCK rewrite_tree_alternative EOB ) ;
	public final void rewrite_tree_block() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:200:5: ( ^( BLOCK rewrite_tree_alternative EOB ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:200:9: ^( BLOCK rewrite_tree_alternative EOB )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_rewrite_tree_block1107); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_rewrite_tree_alternative_in_rewrite_tree_block1109);
			rewrite_tree_alternative();
			state._fsp--;

			match(input,EOB,FOLLOW_EOB_in_rewrite_tree_block1111); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_tree_block"



	// $ANTLR start "rewrite_tree_alternative"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:203:1: rewrite_tree_alternative : ^( ALT ( rewrite_tree_element )+ EOA ) ;
	public final void rewrite_tree_alternative() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:204:5: ( ^( ALT ( rewrite_tree_element )+ EOA ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:204:7: ^( ALT ( rewrite_tree_element )+ EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_rewrite_tree_alternative1130); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:204:13: ( rewrite_tree_element )+
			int cnt43=0;
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==ACTION||(LA43_0 >= BLOCK && LA43_0 <= CHAR_LITERAL)||LA43_0==CLOSURE||LA43_0==LABEL||LA43_0==OPTIONAL||LA43_0==POSITIVE_CLOSURE||LA43_0==RULE_REF||LA43_0==STRING_LITERAL||(LA43_0 >= TOKEN_REF && LA43_0 <= TREE_BEGIN)) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:204:13: rewrite_tree_element
					{
					pushFollow(FOLLOW_rewrite_tree_element_in_rewrite_tree_alternative1132);
					rewrite_tree_element();
					state._fsp--;

					}
					break;

				default :
					if ( cnt43 >= 1 ) break loop43;
					EarlyExitException eee = new EarlyExitException(43, input);
					throw eee;
				}
				cnt43++;
			}

			match(input,EOA,FOLLOW_EOA_in_rewrite_tree_alternative1135); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_tree_alternative"



	// $ANTLR start "rewrite_tree_element"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:207:1: rewrite_tree_element : ( rewrite_tree_atom | rewrite_tree | rewrite_tree_block | rewrite_tree_ebnf );
	public final void rewrite_tree_element() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:208:2: ( rewrite_tree_atom | rewrite_tree | rewrite_tree_block | rewrite_tree_ebnf )
			int alt44=4;
			switch ( input.LA(1) ) {
			case ACTION:
			case CHAR_LITERAL:
			case LABEL:
			case RULE_REF:
			case STRING_LITERAL:
			case TOKEN_REF:
				{
				alt44=1;
				}
				break;
			case TREE_BEGIN:
				{
				alt44=2;
				}
				break;
			case BLOCK:
				{
				alt44=3;
				}
				break;
			case CLOSURE:
			case OPTIONAL:
			case POSITIVE_CLOSURE:
				{
				alt44=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}
			switch (alt44) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:208:4: rewrite_tree_atom
					{
					pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree_element1150);
					rewrite_tree_atom();
					state._fsp--;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:209:4: rewrite_tree
					{
					pushFollow(FOLLOW_rewrite_tree_in_rewrite_tree_element1155);
					rewrite_tree();
					state._fsp--;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:210:6: rewrite_tree_block
					{
					pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_element1162);
					rewrite_tree_block();
					state._fsp--;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:211:6: rewrite_tree_ebnf
					{
					pushFollow(FOLLOW_rewrite_tree_ebnf_in_rewrite_tree_element1169);
					rewrite_tree_ebnf();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_tree_element"



	// $ANTLR start "rewrite_tree_atom"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:214:1: rewrite_tree_atom : ( CHAR_LITERAL | TOKEN_REF | ^( TOKEN_REF ARG_ACTION ) | RULE_REF | STRING_LITERAL | LABEL | ACTION );
	public final void rewrite_tree_atom() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:215:5: ( CHAR_LITERAL | TOKEN_REF | ^( TOKEN_REF ARG_ACTION ) | RULE_REF | STRING_LITERAL | LABEL | ACTION )
			int alt45=7;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				alt45=1;
				}
				break;
			case TOKEN_REF:
				{
				int LA45_2 = input.LA(2);
				if ( (LA45_2==DOWN) ) {
					alt45=3;
				}
				else if ( ((LA45_2 >= UP && LA45_2 <= ACTION)||(LA45_2 >= BLOCK && LA45_2 <= CHAR_LITERAL)||LA45_2==CLOSURE||LA45_2==EOA||LA45_2==LABEL||LA45_2==OPTIONAL||LA45_2==POSITIVE_CLOSURE||LA45_2==RULE_REF||LA45_2==STRING_LITERAL||(LA45_2 >= TOKEN_REF && LA45_2 <= TREE_BEGIN)) ) {
					alt45=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 45, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_REF:
				{
				alt45=4;
				}
				break;
			case STRING_LITERAL:
				{
				alt45=5;
				}
				break;
			case LABEL:
				{
				alt45=6;
				}
				break;
			case ACTION:
				{
				alt45=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}
			switch (alt45) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:215:9: CHAR_LITERAL
					{
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_tree_atom1185); 
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:216:6: TOKEN_REF
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_tree_atom1192); 
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:217:6: ^( TOKEN_REF ARG_ACTION )
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_tree_atom1200); 
					match(input, Token.DOWN, null); 
					match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_tree_atom1202); 
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:218:9: RULE_REF
					{
					match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_tree_atom1214); 
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:219:6: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_tree_atom1221); 
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:220:6: LABEL
					{
					match(input,LABEL,FOLLOW_LABEL_in_rewrite_tree_atom1228); 
					}
					break;
				case 7 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:221:4: ACTION
					{
					match(input,ACTION,FOLLOW_ACTION_in_rewrite_tree_atom1233); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_tree_atom"



	// $ANTLR start "rewrite_tree_ebnf"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:224:1: rewrite_tree_ebnf : ( ^( OPTIONAL rewrite_tree_block ) | ^( CLOSURE rewrite_tree_block ) | ^( POSITIVE_CLOSURE rewrite_tree_block ) );
	public final void rewrite_tree_ebnf() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:225:2: ( ^( OPTIONAL rewrite_tree_block ) | ^( CLOSURE rewrite_tree_block ) | ^( POSITIVE_CLOSURE rewrite_tree_block ) )
			int alt46=3;
			switch ( input.LA(1) ) {
			case OPTIONAL:
				{
				alt46=1;
				}
				break;
			case CLOSURE:
				{
				alt46=2;
				}
				break;
			case POSITIVE_CLOSURE:
				{
				alt46=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:225:4: ^( OPTIONAL rewrite_tree_block )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_rewrite_tree_ebnf1245); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf1247);
					rewrite_tree_block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:226:6: ^( CLOSURE rewrite_tree_block )
					{
					match(input,CLOSURE,FOLLOW_CLOSURE_in_rewrite_tree_ebnf1256); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf1258);
					rewrite_tree_block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:227:7: ^( POSITIVE_CLOSURE rewrite_tree_block )
					{
					match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_rewrite_tree_ebnf1268); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf1270);
					rewrite_tree_block();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_tree_ebnf"



	// $ANTLR start "rewrite_tree"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:230:1: rewrite_tree : ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* ) ;
	public final void rewrite_tree() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:231:2: ( ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:231:4: ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* )
			{
			match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree1284); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree1286);
			rewrite_tree_atom();
			state._fsp--;

			// org/antlr/grammar/v3/ANTLRv3Tree.g:231:35: ( rewrite_tree_element )*
			loop47:
			while (true) {
				int alt47=2;
				int LA47_0 = input.LA(1);
				if ( (LA47_0==ACTION||(LA47_0 >= BLOCK && LA47_0 <= CHAR_LITERAL)||LA47_0==CLOSURE||LA47_0==LABEL||LA47_0==OPTIONAL||LA47_0==POSITIVE_CLOSURE||LA47_0==RULE_REF||LA47_0==STRING_LITERAL||(LA47_0 >= TOKEN_REF && LA47_0 <= TREE_BEGIN)) ) {
					alt47=1;
				}

				switch (alt47) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:231:35: rewrite_tree_element
					{
					pushFollow(FOLLOW_rewrite_tree_element_in_rewrite_tree1288);
					rewrite_tree_element();
					state._fsp--;

					}
					break;

				default :
					break loop47;
				}
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_tree"



	// $ANTLR start "rewrite_template"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:234:1: rewrite_template : ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION );
	public final void rewrite_template() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:235:2: ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION )
			int alt48=4;
			alt48 = dfa48.predict(input);
			switch (alt48) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:235:6: ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) )
					{
					match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template1306); 
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_rewrite_template1308); 
					pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template1310);
					rewrite_template_args();
					state._fsp--;

					if ( (input.LA(1) >= DOUBLE_ANGLE_STRING_LITERAL && input.LA(1) <= DOUBLE_QUOTE_STRING_LITERAL) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:238:4: rewrite_template_ref
					{
					pushFollow(FOLLOW_rewrite_template_ref_in_rewrite_template1333);
					rewrite_template_ref();
					state._fsp--;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:239:4: rewrite_indirect_template_head
					{
					pushFollow(FOLLOW_rewrite_indirect_template_head_in_rewrite_template1338);
					rewrite_indirect_template_head();
					state._fsp--;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:240:4: ACTION
					{
					match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1343); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_template"



	// $ANTLR start "rewrite_template_ref"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:244:1: rewrite_template_ref : ^( TEMPLATE ID rewrite_template_args ) ;
	public final void rewrite_template_ref() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:245:2: ( ^( TEMPLATE ID rewrite_template_args ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:245:4: ^( TEMPLATE ID rewrite_template_args )
			{
			match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template_ref1357); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_rewrite_template_ref1359); 
			pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template_ref1361);
			rewrite_template_args();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_template_ref"



	// $ANTLR start "rewrite_indirect_template_head"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:249:1: rewrite_indirect_template_head : ^( TEMPLATE ACTION rewrite_template_args ) ;
	public final void rewrite_indirect_template_head() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:250:2: ( ^( TEMPLATE ACTION rewrite_template_args ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:250:4: ^( TEMPLATE ACTION rewrite_template_args )
			{
			match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_indirect_template_head1376); 
			match(input, Token.DOWN, null); 
			match(input,ACTION,FOLLOW_ACTION_in_rewrite_indirect_template_head1378); 
			pushFollow(FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head1380);
			rewrite_template_args();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_indirect_template_head"



	// $ANTLR start "rewrite_template_args"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:253:1: rewrite_template_args : ( ^( ARGLIST ( rewrite_template_arg )+ ) | ARGLIST );
	public final void rewrite_template_args() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:254:2: ( ^( ARGLIST ( rewrite_template_arg )+ ) | ARGLIST )
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==ARGLIST) ) {
				int LA50_1 = input.LA(2);
				if ( (LA50_1==DOWN) ) {
					alt50=1;
				}
				else if ( (LA50_1==UP||(LA50_1 >= DOUBLE_ANGLE_STRING_LITERAL && LA50_1 <= DOUBLE_QUOTE_STRING_LITERAL)) ) {
					alt50=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 50, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}

			switch (alt50) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:254:4: ^( ARGLIST ( rewrite_template_arg )+ )
					{
					match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template_args1393); 
					match(input, Token.DOWN, null); 
					// org/antlr/grammar/v3/ANTLRv3Tree.g:254:14: ( rewrite_template_arg )+
					int cnt49=0;
					loop49:
					while (true) {
						int alt49=2;
						int LA49_0 = input.LA(1);
						if ( (LA49_0==ARG) ) {
							alt49=1;
						}

						switch (alt49) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3Tree.g:254:14: rewrite_template_arg
							{
							pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args1395);
							rewrite_template_arg();
							state._fsp--;

							}
							break;

						default :
							if ( cnt49 >= 1 ) break loop49;
							EarlyExitException eee = new EarlyExitException(49, input);
							throw eee;
						}
						cnt49++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:255:4: ARGLIST
					{
					match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template_args1402); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_template_args"



	// $ANTLR start "rewrite_template_arg"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:258:1: rewrite_template_arg : ^( ARG ID ACTION ) ;
	public final void rewrite_template_arg() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:259:2: ( ^( ARG ID ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:259:6: ^( ARG ID ACTION )
			{
			match(input,ARG,FOLLOW_ARG_in_rewrite_template_arg1416); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_rewrite_template_arg1418); 
			match(input,ACTION,FOLLOW_ACTION_in_rewrite_template_arg1420); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rewrite_template_arg"



	// $ANTLR start "qid"
	// org/antlr/grammar/v3/ANTLRv3Tree.g:262:1: qid : ID ( '.' ID )* ;
	public final void qid() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRv3Tree.g:262:5: ( ID ( '.' ID )* )
			// org/antlr/grammar/v3/ANTLRv3Tree.g:262:7: ID ( '.' ID )*
			{
			match(input,ID,FOLLOW_ID_in_qid1431); 
			// org/antlr/grammar/v3/ANTLRv3Tree.g:262:10: ( '.' ID )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==73) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3Tree.g:262:11: '.' ID
					{
					match(input,73,FOLLOW_73_in_qid1434); 
					match(input,ID,FOLLOW_ID_in_qid1436); 
					}
					break;

				default :
					break loop51;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "qid"

	// Delegated rules


	protected DFA48 dfa48 = new DFA48(this);
	static final String DFA48_eotS =
		"\20\uffff";
	static final String DFA48_eofS =
		"\20\uffff";
	static final String DFA48_minS =
		"\1\4\1\2\1\uffff\1\4\1\12\1\uffff\1\2\1\11\2\uffff\1\2\1\36\1\4\3\3";
	static final String DFA48_maxS =
		"\1\73\1\2\1\uffff\1\36\1\12\1\uffff\1\26\1\11\2\uffff\1\2\1\36\1\4\1\3"+
		"\1\11\1\26";
	static final String DFA48_acceptS =
		"\2\uffff\1\4\2\uffff\1\3\2\uffff\1\1\1\2\6\uffff";
	static final String DFA48_specialS =
		"\20\uffff}>";
	static final String[] DFA48_transitionS = {
			"\1\2\66\uffff\1\1",
			"\1\3",
			"",
			"\1\5\31\uffff\1\4",
			"\1\6",
			"",
			"\1\7\1\11\21\uffff\2\10",
			"\1\12",
			"",
			"",
			"\1\13",
			"\1\14",
			"\1\15",
			"\1\16",
			"\1\17\5\uffff\1\12",
			"\1\11\21\uffff\2\10"
	};

	static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
	static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
	static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
	static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
	static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
	static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
	static final short[][] DFA48_transition;

	static {
		int numStates = DFA48_transitionS.length;
		DFA48_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
		}
	}

	protected class DFA48 extends DFA {

		public DFA48(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 48;
			this.eot = DFA48_eot;
			this.eof = DFA48_eof;
			this.min = DFA48_min;
			this.max = DFA48_max;
			this.accept = DFA48_accept;
			this.special = DFA48_special;
			this.transition = DFA48_transition;
		}
		@Override
		public String getDescription() {
			return "234:1: rewrite_template : ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION );";
		}
	}

	public static final BitSet FOLLOW_grammarType_in_grammarDef58 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_grammarDef60 = new BitSet(new long[]{0x1014040000101000L});
	public static final BitSet FOLLOW_DOC_COMMENT_in_grammarDef62 = new BitSet(new long[]{0x1014040000001000L});
	public static final BitSet FOLLOW_optionsSpec_in_grammarDef65 = new BitSet(new long[]{0x1014000000001000L});
	public static final BitSet FOLLOW_tokensSpec_in_grammarDef68 = new BitSet(new long[]{0x0014000000001000L});
	public static final BitSet FOLLOW_attrScope_in_grammarDef71 = new BitSet(new long[]{0x0014000000001000L});
	public static final BitSet FOLLOW_action_in_grammarDef74 = new BitSet(new long[]{0x0004000000001000L});
	public static final BitSet FOLLOW_rule_in_grammarDef77 = new BitSet(new long[]{0x0004000000000008L});
	public static final BitSet FOLLOW_TOKENS_in_tokensSpec133 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_tokenSpec_in_tokensSpec135 = new BitSet(new long[]{0x2000000200000008L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_tokenSpec149 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec151 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_tokenSpec153 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_tokenSpec160 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec162 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_tokenSpec164 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCOPE_in_attrScope182 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_attrScope184 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_attrScope186 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AT_in_action199 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_action201 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ID_in_action203 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_action205 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AT_in_action212 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_action214 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_action216 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OPTIONS_in_optionsSpec229 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_option_in_optionsSpec231 = new BitSet(new long[]{0x0000000240000008L});
	public static final BitSet FOLLOW_qid_in_option249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_option259 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_option261 = new BitSet(new long[]{0x01000000C0010000L});
	public static final BitSet FOLLOW_optionValue_in_option263 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_rule329 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule331 = new BitSet(new long[]{0x0010840010009200L,0x0000000003C00000L});
	public static final BitSet FOLLOW_modifier_in_rule333 = new BitSet(new long[]{0x0010840000009200L,0x0000000002000000L});
	public static final BitSet FOLLOW_ARG_in_rule338 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule340 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RET_in_rule347 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule349 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_throwsSpec_in_rule362 = new BitSet(new long[]{0x0010040000009000L});
	public static final BitSet FOLLOW_optionsSpec_in_rule365 = new BitSet(new long[]{0x0010000000009000L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_rule368 = new BitSet(new long[]{0x0000000000009000L});
	public static final BitSet FOLLOW_ruleAction_in_rule371 = new BitSet(new long[]{0x0000000000009000L});
	public static final BitSet FOLLOW_altList_in_rule382 = new BitSet(new long[]{0x0000000002000000L,0x0000000000060000L});
	public static final BitSet FOLLOW_exceptionGroup_in_rule392 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_EOR_in_rule395 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AT_in_ruleAction434 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_ruleAction436 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_ruleAction438 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_89_in_throwsSpec451 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_throwsSpec453 = new BitSet(new long[]{0x0000000040000008L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec467 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec469 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec476 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec478 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ID_in_ruleScopeSpec480 = new BitSet(new long[]{0x0000000040000008L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec488 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_ruleScopeSpec490 = new BitSet(new long[]{0x0000000040000008L});
	public static final BitSet FOLLOW_BLOCK_in_block510 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_optionsSpec_in_block512 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_alternative_in_block516 = new BitSet(new long[]{0x0001000001000100L});
	public static final BitSet FOLLOW_rewrite_in_block518 = new BitSet(new long[]{0x0000000001000100L});
	public static final BitSet FOLLOW_EOB_in_block522 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_altList545 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alternative_in_altList548 = new BitSet(new long[]{0x0001000001000100L});
	public static final BitSet FOLLOW_rewrite_in_altList550 = new BitSet(new long[]{0x0000000001000100L});
	public static final BitSet FOLLOW_EOB_in_altList554 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_alternative576 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_alternative578 = new BitSet(new long[]{0x672A22122087C010L,0x0000000020000200L});
	public static final BitSet FOLLOW_EOA_in_alternative581 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_alternative593 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_EPSILON_in_alternative595 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_EOA_in_alternative597 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup612 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup615 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_81_in_exceptionHandler642 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler644 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_exceptionHandler646 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_82_in_finallyClause668 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_finallyClause670 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_element686 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element692 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_in_element694 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_element701 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element707 = new BitSet(new long[]{0x210A000000034000L,0x0000000020000200L});
	public static final BitSet FOLLOW_atom_in_element709 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_atom_in_element715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ebnf_in_element720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_element727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMPRED_in_element734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GATED_SEMPRED_in_element739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_element747 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element749 = new BitSet(new long[]{0x672A22122007C018L,0x0000000020000200L});
	public static final BitSet FOLLOW_set_in_atom763 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_atom_in_atom769 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_RANGE_in_atom776 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom778 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom780 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_optionsSpec_in_atom782 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_93_in_atom790 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_notTerminal_in_atom792 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_optionsSpec_in_atom794 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_93_in_atom802 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_atom804 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_optionsSpec_in_atom806 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_REF_in_atom817 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom819 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_REF_in_atom828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom849 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_optionsSpec_in_atom851 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom869 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_optionsSpec_in_atom871 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom881 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom883 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_optionsSpec_in_atom885 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom895 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom897 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_atom906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_atom915 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_optionsSpec_in_atom917 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_73_in_atom926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_atom935 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_optionsSpec_in_atom937 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SYNPRED_in_ebnf956 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf958 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OPTIONAL_in_ebnf965 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf967 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CLOSURE_in_ebnf976 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf978 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf988 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf990 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SYN_SEMPRED_in_ebnf996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_ebnf1001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite1041 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_SEMPRED_in_rewrite1043 = new BitSet(new long[]{0x0800000000000110L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite1045 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite1051 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite1053 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative1068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_alternative_in_rewrite_alternative1073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALT_in_rewrite_alternative1084 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_EPSILON_in_rewrite_alternative1086 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_EOA_in_rewrite_alternative1088 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_rewrite_tree_block1107 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_tree_alternative_in_rewrite_tree_block1109 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EOB_in_rewrite_tree_block1111 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_rewrite_tree_alternative1130 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_tree_element_in_rewrite_tree_alternative1132 = new BitSet(new long[]{0x6108220100858010L});
	public static final BitSet FOLLOW_EOA_in_rewrite_tree_alternative1135 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree_element1150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_in_rewrite_tree_element1155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_element1162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_ebnf_in_rewrite_tree_element1169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_tree_atom1185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_tree_atom1192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_tree_atom1200 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_tree_atom1202 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_REF_in_rewrite_tree_atom1214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_tree_atom1221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LABEL_in_rewrite_tree_atom1228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_tree_atom1233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_rewrite_tree_ebnf1245 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf1247 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CLOSURE_in_rewrite_tree_ebnf1256 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf1258 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_rewrite_tree_ebnf1268 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf1270 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree1284 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree1286 = new BitSet(new long[]{0x6108220100058018L});
	public static final BitSet FOLLOW_rewrite_tree_element_in_rewrite_tree1288 = new BitSet(new long[]{0x6108220100058018L});
	public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template1306 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rewrite_template1308 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template1310 = new BitSet(new long[]{0x0000000000600000L});
	public static final BitSet FOLLOW_set_in_rewrite_template1317 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rewrite_template_ref_in_rewrite_template1333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_indirect_template_head_in_rewrite_template1338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template1343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template_ref1357 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rewrite_template_ref1359 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template_ref1361 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TEMPLATE_in_rewrite_indirect_template_head1376 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_indirect_template_head1378 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head1380 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARGLIST_in_rewrite_template_args1393 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args1395 = new BitSet(new long[]{0x0000000000000208L});
	public static final BitSet FOLLOW_ARGLIST_in_rewrite_template_args1402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARG_in_rewrite_template_arg1416 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rewrite_template_arg1418 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template_arg1420 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_qid1431 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_qid1434 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ID_in_qid1436 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
}
