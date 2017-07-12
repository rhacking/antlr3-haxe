// $ANTLR 3.5 org/antlr/grammar/v3/LeftRecursiveRuleWalker.g 2017-06-11 18:42:20

package org.antlr.grammar.v3;

import org.antlr.analysis.*;
import org.antlr.misc.*;
import org.antlr.tool.*;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/** Find left-recursive rules */
@SuppressWarnings("all")
public class LeftRecursiveRuleWalker extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", 
		"ACTION_ESC", "ACTION_STRING_LITERAL", "ALT", "AMPERSAND", "ARG", "ARGLIST", 
		"ARG_ACTION", "ASSIGN", "BACKTRACK_SEMPRED", "BANG", "BLOCK", "CATCH", 
		"CHAR_LITERAL", "CHAR_RANGE", "CLOSE_ELEMENT_OPTION", "CLOSURE", "COLON", 
		"COMBINED_GRAMMAR", "COMMA", "COMMENT", "DIGIT", "DOC_COMMENT", "DOLLAR", 
		"DOT", "DOUBLE_ANGLE_STRING_LITERAL", "DOUBLE_QUOTE_STRING_LITERAL", "EOA", 
		"EOB", "EOR", "EPSILON", "ESC", "ETC", "FINALLY", "FORCED_ACTION", "FRAGMENT", 
		"GATED_SEMPRED", "GRAMMAR", "ID", "IMPLIES", "IMPORT", "INITACTION", "INT", 
		"LABEL", "LEXER", "LEXER_GRAMMAR", "LPAREN", "ML_COMMENT", "NESTED_ACTION", 
		"NESTED_ARG_ACTION", "NOT", "OPEN_ELEMENT_OPTION", "OPTIONAL", "OPTIONS", 
		"OR", "PARSER", "PARSER_GRAMMAR", "PLUS", "PLUS_ASSIGN", "POSITIVE_CLOSURE", 
		"PREC_RULE", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RCURLY", 
		"RECURSIVE_RULE_REF", "RET", "RETURNS", "REWRITE", "REWRITES", "ROOT", 
		"RPAREN", "RULE", "RULE_REF", "SCOPE", "SEMI", "SEMPRED", "SL_COMMENT", 
		"SRC", "STAR", "STRAY_BRACKET", "STRING_LITERAL", "SYNPRED", "SYN_SEMPRED", 
		"TEMPLATE", "THROWS", "TOKENS", "TOKEN_REF", "TREE", "TREE_BEGIN", "TREE_GRAMMAR", 
		"WILDCARD", "WS", "WS_LOOP", "WS_OPT", "XDIGIT"
	};
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

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public LeftRecursiveRuleWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public LeftRecursiveRuleWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return LeftRecursiveRuleWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/LeftRecursiveRuleWalker.g"; }


	protected Grammar grammar;
	private String ruleName;
	private int outerAlt; // which outer alt of rule?
	public int numAlts;  // how many alts for this rule total?

	@Override
	public void reportError(RecognitionException ex)
	{
	    Token token = null;
	    if (ex instanceof MismatchedTokenException)
	    {
	        token = ((MismatchedTokenException)ex).token;
	    }
	    else if (ex instanceof NoViableAltException)
	    {
	        token = ((NoViableAltException)ex).token;
	    }

	    ErrorManager.syntaxError(
	        ErrorManager.MSG_SYNTAX_ERROR,
	        grammar,
	        token,
	        "assign.types: " + ex.toString(),
	        ex);
	}

	public void setTokenPrec(GrammarAST t, int alt) {}
	public void binaryAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
	public void ternaryAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
	public void prefixAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
	public void suffixAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
	public void otherAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
	public void setReturnValues(GrammarAST t) {}



	// $ANTLR start "optionsSpec"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:89:1: optionsSpec : ^( OPTIONS ( option )+ ) ;
	public final void optionsSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:90:2: ( ^( OPTIONS ( option )+ ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:90:4: ^( OPTIONS ( option )+ )
			{
			match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec57); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:90:14: ( option )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ASSIGN) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:90:14: option
					{
					pushFollow(FOLLOW_option_in_optionsSpec59);
					option();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input, Token.UP, null); if (state.failed) return;

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
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:93:1: option : ^( ASSIGN ID optionValue ) ;
	public final void option() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:94:2: ( ^( ASSIGN ID optionValue ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:94:4: ^( ASSIGN ID optionValue )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_option73); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			match(input,ID,FOLLOW_ID_in_option75); if (state.failed) return;
			pushFollow(FOLLOW_optionValue_in_option77);
			optionValue();
			state._fsp--;
			if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

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
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:97:1: optionValue : ( ID | STRING_LITERAL | CHAR_LITERAL | INT );
	public final void optionValue() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:98:2: ( ID | STRING_LITERAL | CHAR_LITERAL | INT )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:
			{
			if ( input.LA(1)==CHAR_LITERAL||input.LA(1)==ID||input.LA(1)==INT||input.LA(1)==STRING_LITERAL ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
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



	// $ANTLR start "charSetElement"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:104:1: charSetElement : ( CHAR_LITERAL | ^( OR CHAR_LITERAL CHAR_LITERAL ) | ^( RANGE CHAR_LITERAL CHAR_LITERAL ) );
	public final void charSetElement() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:105:2: ( CHAR_LITERAL | ^( OR CHAR_LITERAL CHAR_LITERAL ) | ^( RANGE CHAR_LITERAL CHAR_LITERAL ) )
			int alt2=3;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				alt2=1;
				}
				break;
			case OR:
				{
				alt2=2;
				}
				break;
			case RANGE:
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
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:105:4: CHAR_LITERAL
					{
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement115); if (state.failed) return;
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:106:4: ^( OR CHAR_LITERAL CHAR_LITERAL )
					{
					match(input,OR,FOLLOW_OR_in_charSetElement121); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement123); if (state.failed) return;
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement125); if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:107:4: ^( RANGE CHAR_LITERAL CHAR_LITERAL )
					{
					match(input,RANGE,FOLLOW_RANGE_in_charSetElement132); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement134); if (state.failed) return;
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement136); if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

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
	// $ANTLR end "charSetElement"



	// $ANTLR start "rec_rule"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:111:1: public rec_rule[Grammar g] returns [boolean isLeftRec] : ^(r= RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ruleBlock ( exceptionGroup )? EOR ) ;
	public final boolean rec_rule(Grammar g) throws RecognitionException {
		boolean isLeftRec = false;


		GrammarAST r=null;
		GrammarAST id=null;
		TreeRuleReturnScope ruleBlock1 =null;


			grammar = g;
			outerAlt = 1;

		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:117:2: ( ^(r= RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ruleBlock ( exceptionGroup )? EOR ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:117:4: ^(r= RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ruleBlock ( exceptionGroup )? EOR )
			{
			r=(GrammarAST)match(input,RULE,FOLLOW_RULE_in_rec_rule164); if (state.failed) return isLeftRec;
			match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rec_rule168); if (state.failed) return isLeftRec;
			if ( state.backtracking==0 ) {ruleName=id.getText();}
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:118:4: ( modifier )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==FRAGMENT||(LA3_0 >= PRIVATE && LA3_0 <= PUBLIC)) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:118:4: modifier
					{
					pushFollow(FOLLOW_modifier_in_rec_rule175);
					modifier();
					state._fsp--;
					if (state.failed) return isLeftRec;
					}
					break;

			}

			match(input,ARG,FOLLOW_ARG_in_rec_rule182); if (state.failed) return isLeftRec;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
				// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:119:10: ( ARG_ACTION )?
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==ARG_ACTION) ) {
					alt4=1;
				}
				switch (alt4) {
					case 1 :
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:119:10: ARG_ACTION
						{
						match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rec_rule184); if (state.failed) return isLeftRec;
						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return isLeftRec;
			}

			match(input,RET,FOLLOW_RET_in_rec_rule192); if (state.failed) return isLeftRec;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
				// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:120:10: ( ARG_ACTION )?
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==ARG_ACTION) ) {
					alt5=1;
				}
				switch (alt5) {
					case 1 :
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:120:10: ARG_ACTION
						{
						match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rec_rule194); if (state.failed) return isLeftRec;
						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return isLeftRec;
			}

			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:121:4: ( optionsSpec )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==OPTIONS) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:121:4: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_rec_rule201);
					optionsSpec();
					state._fsp--;
					if (state.failed) return isLeftRec;
					}
					break;

			}

			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:122:4: ( ruleScopeSpec )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==SCOPE) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:122:4: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_rec_rule207);
					ruleScopeSpec();
					state._fsp--;
					if (state.failed) return isLeftRec;
					}
					break;

			}

			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:123:4: ( ^( AMPERSAND ( . )* ) )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==AMPERSAND) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:123:5: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_rec_rule215); if (state.failed) return isLeftRec;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:123:17: ( . )*
						loop8:
						while (true) {
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( ((LA8_0 >= ACTION && LA8_0 <= XDIGIT)) ) {
								alt8=1;
							}
							else if ( (LA8_0==UP) ) {
								alt8=2;
							}

							switch (alt8) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:123:17: .
								{
								matchAny(input); if (state.failed) return isLeftRec;
								}
								break;

							default :
								break loop8;
							}
						}

						match(input, Token.UP, null); if (state.failed) return isLeftRec;
					}

					}
					break;

				default :
					break loop9;
				}
			}

			pushFollow(FOLLOW_ruleBlock_in_rec_rule226);
			ruleBlock1=ruleBlock();
			state._fsp--;
			if (state.failed) return isLeftRec;
			if ( state.backtracking==0 ) {isLeftRec = (ruleBlock1!=null?((LeftRecursiveRuleWalker.ruleBlock_return)ruleBlock1).isLeftRec:false);}
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:125:4: ( exceptionGroup )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==CATCH||LA10_0==FINALLY) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:125:4: exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_rec_rule233);
					exceptionGroup();
					state._fsp--;
					if (state.failed) return isLeftRec;
					}
					break;

			}

			match(input,EOR,FOLLOW_EOR_in_rec_rule239); if (state.failed) return isLeftRec;
			match(input, Token.UP, null); if (state.failed) return isLeftRec;

			if ( state.backtracking==0 ) {if ((ruleBlock1!=null?((LeftRecursiveRuleWalker.ruleBlock_return)ruleBlock1).isLeftRec:false)) r.setType(PREC_RULE);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return isLeftRec;
	}
	// $ANTLR end "rec_rule"



	// $ANTLR start "modifier"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:131:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
	public final void modifier() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:132:2: ( 'protected' | 'public' | 'private' | 'fragment' )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:
			{
			if ( input.LA(1)==FRAGMENT||(input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
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



	// $ANTLR start "ruleScopeSpec"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:138:1: ruleScopeSpec : ^( 'scope' ( ACTION )? ( ID )* ) ;
	public final void ruleScopeSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:139:3: ( ^( 'scope' ( ACTION )? ( ID )* ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:139:5: ^( 'scope' ( ACTION )? ( ID )* )
			{
			match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec286); if (state.failed) return;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return;
				// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:139:15: ( ACTION )?
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==ACTION) ) {
					alt11=1;
				}
				switch (alt11) {
					case 1 :
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:139:15: ACTION
						{
						match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec288); if (state.failed) return;
						}
						break;

				}

				// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:139:23: ( ID )*
				loop12:
				while (true) {
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==ID) ) {
						alt12=1;
					}

					switch (alt12) {
					case 1 :
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:139:23: ID
						{
						match(input,ID,FOLLOW_ID_in_ruleScopeSpec291); if (state.failed) return;
						}
						break;

					default :
						break loop12;
					}
				}

				match(input, Token.UP, null); if (state.failed) return;
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
	// $ANTLR end "ruleScopeSpec"


	public static class ruleBlock_return extends TreeRuleReturnScope {
		public boolean isLeftRec;
	};


	// $ANTLR start "ruleBlock"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:142:1: ruleBlock returns [boolean isLeftRec] : ^( BLOCK ( optionsSpec )? ( outerAlternative ( rewrite )? )+ EOB ) ;
	public final LeftRecursiveRuleWalker.ruleBlock_return ruleBlock() throws RecognitionException {
		LeftRecursiveRuleWalker.ruleBlock_return retval = new LeftRecursiveRuleWalker.ruleBlock_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope outerAlternative2 =null;

		boolean lr=false; this.numAlts = ((GrammarAST)retval.start).getChildCount();
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:144:2: ( ^( BLOCK ( optionsSpec )? ( outerAlternative ( rewrite )? )+ EOB ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:144:4: ^( BLOCK ( optionsSpec )? ( outerAlternative ( rewrite )? )+ EOB )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_ruleBlock315); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:145:4: ( optionsSpec )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==OPTIONS) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:145:4: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_ruleBlock320);
					optionsSpec();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:146:4: ( outerAlternative ( rewrite )? )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==ALT) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:146:6: outerAlternative ( rewrite )?
					{
					pushFollow(FOLLOW_outerAlternative_in_ruleBlock328);
					outerAlternative2=outerAlternative();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {if ((outerAlternative2!=null?((LeftRecursiveRuleWalker.outerAlternative_return)outerAlternative2).isLeftRec:false)) retval.isLeftRec = true;}
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:148:5: ( rewrite )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==REWRITES) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:148:5: rewrite
							{
							pushFollow(FOLLOW_rewrite_in_ruleBlock340);
							rewrite();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					if ( state.backtracking==0 ) {outerAlt++;}
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			match(input,EOB,FOLLOW_EOB_in_ruleBlock358); if (state.failed) return retval;
			match(input, Token.UP, null); if (state.failed) return retval;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ruleBlock"



	// $ANTLR start "block"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:155:1: block : ^( BLOCK ( optionsSpec )? ( ^( ALT ( element )+ EOA ) ( rewrite )? )+ EOB ) ;
	public final void block() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:156:5: ( ^( BLOCK ( optionsSpec )? ( ^( ALT ( element )+ EOA ) ( rewrite )? )+ EOB ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:156:9: ^( BLOCK ( optionsSpec )? ( ^( ALT ( element )+ EOA ) ( rewrite )? )+ EOB )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_block381); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:157:13: ( optionsSpec )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==OPTIONS) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:157:13: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_block395);
					optionsSpec();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:158:13: ( ^( ALT ( element )+ EOA ) ( rewrite )? )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==ALT) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:158:15: ^( ALT ( element )+ EOA ) ( rewrite )?
					{
					match(input,ALT,FOLLOW_ALT_in_block413); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:158:21: ( element )+
					int cnt17=0;
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==ACTION||(LA17_0 >= ASSIGN && LA17_0 <= BLOCK)||LA17_0==CHAR_LITERAL||LA17_0==CLOSURE||LA17_0==DOT||LA17_0==EPSILON||LA17_0==FORCED_ACTION||LA17_0==GATED_SEMPRED||LA17_0==NOT||LA17_0==OPTIONAL||(LA17_0 >= PLUS_ASSIGN && LA17_0 <= POSITIVE_CLOSURE)||LA17_0==RANGE||LA17_0==ROOT||LA17_0==RULE_REF||LA17_0==SEMPRED||(LA17_0 >= STRING_LITERAL && LA17_0 <= SYN_SEMPRED)||LA17_0==TOKEN_REF||LA17_0==TREE_BEGIN||LA17_0==WILDCARD) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:158:21: element
							{
							pushFollow(FOLLOW_element_in_block415);
							element();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt17 >= 1 ) break loop17;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(17, input);
							throw eee;
						}
						cnt17++;
					}

					match(input,EOA,FOLLOW_EOA_in_block418); if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:158:35: ( rewrite )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==REWRITES) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:158:35: rewrite
							{
							pushFollow(FOLLOW_rewrite_in_block421);
							rewrite();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
			}

			match(input,EOB,FOLLOW_EOB_in_block439); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

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


	public static class outerAlternative_return extends TreeRuleReturnScope {
		public boolean isLeftRec;
	};


	// $ANTLR start "outerAlternative"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:164:1: outerAlternative returns [boolean isLeftRec] : ( ( binaryMultipleOp )=> binaryMultipleOp | ( binary )=> binary | ( ternary )=> ternary | ( prefix )=> prefix | ( suffix )=> suffix | ^( ALT ( element )+ EOA ) );
	public final LeftRecursiveRuleWalker.outerAlternative_return outerAlternative() throws RecognitionException {
		LeftRecursiveRuleWalker.outerAlternative_return retval = new LeftRecursiveRuleWalker.outerAlternative_return();
		retval.start = input.LT(1);


		GrammarAST rew = ((GrammarAST)retval.start).getNextSibling();
		if (rew.getType() != REWRITES)
			rew = null;

		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:171:5: ( ( binaryMultipleOp )=> binaryMultipleOp | ( binary )=> binary | ( ternary )=> ternary | ( prefix )=> prefix | ( suffix )=> suffix | ^( ALT ( element )+ EOA ) )
			int alt21=6;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==ALT) ) {
				int LA21_1 = input.LA(2);
				if ( (synpred1_LeftRecursiveRuleWalker()) ) {
					alt21=1;
				}
				else if ( (synpred2_LeftRecursiveRuleWalker()) ) {
					alt21=2;
				}
				else if ( (synpred3_LeftRecursiveRuleWalker()) ) {
					alt21=3;
				}
				else if ( (synpred4_LeftRecursiveRuleWalker()) ) {
					alt21=4;
				}
				else if ( (synpred5_LeftRecursiveRuleWalker()) ) {
					alt21=5;
				}
				else if ( (true) ) {
					alt21=6;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:171:9: ( binaryMultipleOp )=> binaryMultipleOp
					{
					pushFollow(FOLLOW_binaryMultipleOp_in_outerAlternative488);
					binaryMultipleOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {binaryAlt(((GrammarAST)retval.start), rew, outerAlt); retval.isLeftRec =true;}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:173:9: ( binary )=> binary
					{
					pushFollow(FOLLOW_binary_in_outerAlternative544);
					binary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {binaryAlt(((GrammarAST)retval.start), rew, outerAlt); retval.isLeftRec =true;}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:175:9: ( ternary )=> ternary
					{
					pushFollow(FOLLOW_ternary_in_outerAlternative606);
					ternary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {ternaryAlt(((GrammarAST)retval.start), rew, outerAlt); retval.isLeftRec =true;}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:177:9: ( prefix )=> prefix
					{
					pushFollow(FOLLOW_prefix_in_outerAlternative662);
					prefix();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {prefixAlt(((GrammarAST)retval.start), rew, outerAlt);}
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:179:9: ( suffix )=> suffix
					{
					pushFollow(FOLLOW_suffix_in_outerAlternative718);
					suffix();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {suffixAlt(((GrammarAST)retval.start), rew, outerAlt); retval.isLeftRec =true;}
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:181:9: ^( ALT ( element )+ EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_outerAlternative760); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:181:15: ( element )+
					int cnt20=0;
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0==ACTION||(LA20_0 >= ASSIGN && LA20_0 <= BLOCK)||LA20_0==CHAR_LITERAL||LA20_0==CLOSURE||LA20_0==DOT||LA20_0==EPSILON||LA20_0==FORCED_ACTION||LA20_0==GATED_SEMPRED||LA20_0==NOT||LA20_0==OPTIONAL||(LA20_0 >= PLUS_ASSIGN && LA20_0 <= POSITIVE_CLOSURE)||LA20_0==RANGE||LA20_0==ROOT||LA20_0==RULE_REF||LA20_0==SEMPRED||(LA20_0 >= STRING_LITERAL && LA20_0 <= SYN_SEMPRED)||LA20_0==TOKEN_REF||LA20_0==TREE_BEGIN||LA20_0==WILDCARD) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:181:15: element
							{
							pushFollow(FOLLOW_element_in_outerAlternative762);
							element();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

						default :
							if ( cnt20 >= 1 ) break loop20;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(20, input);
							throw eee;
						}
						cnt20++;
					}

					match(input,EOA,FOLLOW_EOA_in_outerAlternative765); if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) {otherAlt(((GrammarAST)retval.start), rew, outerAlt);}
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
		return retval;
	}
	// $ANTLR end "outerAlternative"



	// $ANTLR start "binary"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:185:1: binary : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse EOA ) ;
	public final void binary() throws RecognitionException {
		GrammarAST op =null;

		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:186:2: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse EOA ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:186:4: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_binary814); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:186:11: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==BACKTRACK_SEMPRED) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:186:12: ^( BACKTRACK_SEMPRED ( . )* )
					{
					match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_binary818); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:186:32: ( . )*
						loop22:
						while (true) {
							int alt22=2;
							int LA22_0 = input.LA(1);
							if ( ((LA22_0 >= ACTION && LA22_0 <= XDIGIT)) ) {
								alt22=1;
							}
							else if ( (LA22_0==UP) ) {
								alt22=2;
							}

							switch (alt22) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:186:32: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop22;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

			}

			pushFollow(FOLLOW_recurseNoLabel_in_binary826);
			recurseNoLabel();
			state._fsp--;
			if (state.failed) return;
			pushFollow(FOLLOW_token_in_binary830);
			op=token();
			state._fsp--;
			if (state.failed) return;
			pushFollow(FOLLOW_recurse_in_binary832);
			recurse();
			state._fsp--;
			if (state.failed) return;
			match(input,EOA,FOLLOW_EOA_in_binary834); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {setTokenPrec(op, outerAlt);}
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
	// $ANTLR end "binary"



	// $ANTLR start "binaryMultipleOp"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:1: binaryMultipleOp : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ^( BLOCK ( ^( ALT op= token EOA ) )+ EOB ) recurse EOA ) ;
	public final void binaryMultipleOp() throws RecognitionException {
		GrammarAST op =null;

		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:190:2: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ^( BLOCK ( ^( ALT op= token EOA ) )+ EOB ) recurse EOA ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:190:4: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ^( BLOCK ( ^( ALT op= token EOA ) )+ EOB ) recurse EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_binaryMultipleOp851); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:190:11: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==BACKTRACK_SEMPRED) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:190:12: ^( BACKTRACK_SEMPRED ( . )* )
					{
					match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_binaryMultipleOp855); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:190:32: ( . )*
						loop24:
						while (true) {
							int alt24=2;
							int LA24_0 = input.LA(1);
							if ( ((LA24_0 >= ACTION && LA24_0 <= XDIGIT)) ) {
								alt24=1;
							}
							else if ( (LA24_0==UP) ) {
								alt24=2;
							}

							switch (alt24) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:190:32: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop24;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

			}

			pushFollow(FOLLOW_recurseNoLabel_in_binaryMultipleOp863);
			recurseNoLabel();
			state._fsp--;
			if (state.failed) return;
			match(input,BLOCK,FOLLOW_BLOCK_in_binaryMultipleOp867); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:190:62: ( ^( ALT op= token EOA ) )+
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
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:190:64: ^( ALT op= token EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_binaryMultipleOp873); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_token_in_binaryMultipleOp877);
					op=token();
					state._fsp--;
					if (state.failed) return;
					match(input,EOA,FOLLOW_EOA_in_binaryMultipleOp879); if (state.failed) return;
					if ( state.backtracking==0 ) {setTokenPrec(op, outerAlt);}
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;

				default :
					if ( cnt26 >= 1 ) break loop26;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(26, input);
					throw eee;
				}
				cnt26++;
			}

			match(input,EOB,FOLLOW_EOB_in_binaryMultipleOp888); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			pushFollow(FOLLOW_recurse_in_binaryMultipleOp892);
			recurse();
			state._fsp--;
			if (state.failed) return;
			match(input,EOA,FOLLOW_EOA_in_binaryMultipleOp894); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

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
	// $ANTLR end "binaryMultipleOp"



	// $ANTLR start "ternary"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:193:1: ternary : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse token recurse EOA ) ;
	public final void ternary() throws RecognitionException {
		GrammarAST op =null;

		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:194:2: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse token recurse EOA ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:194:4: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse token recurse EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_ternary909); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:194:11: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==BACKTRACK_SEMPRED) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:194:12: ^( BACKTRACK_SEMPRED ( . )* )
					{
					match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_ternary913); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:194:32: ( . )*
						loop27:
						while (true) {
							int alt27=2;
							int LA27_0 = input.LA(1);
							if ( ((LA27_0 >= ACTION && LA27_0 <= XDIGIT)) ) {
								alt27=1;
							}
							else if ( (LA27_0==UP) ) {
								alt27=2;
							}

							switch (alt27) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:194:32: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop27;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

			}

			pushFollow(FOLLOW_recurseNoLabel_in_ternary921);
			recurseNoLabel();
			state._fsp--;
			if (state.failed) return;
			pushFollow(FOLLOW_token_in_ternary925);
			op=token();
			state._fsp--;
			if (state.failed) return;
			pushFollow(FOLLOW_recurse_in_ternary927);
			recurse();
			state._fsp--;
			if (state.failed) return;
			pushFollow(FOLLOW_token_in_ternary929);
			token();
			state._fsp--;
			if (state.failed) return;
			pushFollow(FOLLOW_recurse_in_ternary931);
			recurse();
			state._fsp--;
			if (state.failed) return;
			match(input,EOA,FOLLOW_EOA_in_ternary933); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {setTokenPrec(op, outerAlt);}
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
	// $ANTLR end "ternary"



	// $ANTLR start "prefix"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:1: prefix : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? ({...}? element )+ recurse EOA ) ;
	public final void prefix() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:8: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? ({...}? element )+ recurse EOA ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:10: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? ({...}? element )+ recurse EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_prefix949); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:17: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==BACKTRACK_SEMPRED) ) {
				int LA30_1 = input.LA(2);
				if ( (LA30_1==DOWN) ) {
					alt30=1;
				}
			}
			switch (alt30) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:18: ^( BACKTRACK_SEMPRED ( . )* )
					{
					match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_prefix953); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:38: ( . )*
						loop29:
						while (true) {
							int alt29=2;
							int LA29_0 = input.LA(1);
							if ( ((LA29_0 >= ACTION && LA29_0 <= XDIGIT)) ) {
								alt29=1;
							}
							else if ( (LA29_0==UP) ) {
								alt29=2;
							}

							switch (alt29) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:38: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop29;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {setTokenPrec((GrammarAST)input.LT(1), outerAlt);}
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:95: ({...}? element )+
			int cnt31=0;
			loop31:
			while (true) {
				int alt31=2;
				switch ( input.LA(1) ) {
				case ASSIGN:
					{
					int LA31_1 = input.LA(2);
					if ( (LA31_1==DOWN) ) {
						int LA31_5 = input.LA(3);
						if ( (LA31_5==ID) ) {
							int LA31_8 = input.LA(4);
							if ( (LA31_8==RULE_REF) ) {
								int LA31_10 = input.LA(5);
								if ( (LA31_10==DOWN) ) {
									alt31=1;
								}

							}
							else if ( (LA31_8==ACTION||(LA31_8 >= ASSIGN && LA31_8 <= BLOCK)||LA31_8==CHAR_LITERAL||LA31_8==CLOSURE||LA31_8==DOT||LA31_8==EPSILON||LA31_8==FORCED_ACTION||LA31_8==GATED_SEMPRED||LA31_8==NOT||LA31_8==OPTIONAL||(LA31_8 >= PLUS_ASSIGN && LA31_8 <= POSITIVE_CLOSURE)||LA31_8==RANGE||LA31_8==ROOT||LA31_8==SEMPRED||(LA31_8 >= STRING_LITERAL && LA31_8 <= SYN_SEMPRED)||LA31_8==TOKEN_REF||LA31_8==TREE_BEGIN||LA31_8==WILDCARD) ) {
								alt31=1;
							}

						}

					}

					}
					break;
				case PLUS_ASSIGN:
					{
					int LA31_2 = input.LA(2);
					if ( (LA31_2==DOWN) ) {
						int LA31_6 = input.LA(3);
						if ( (LA31_6==ID) ) {
							int LA31_9 = input.LA(4);
							if ( (LA31_9==RULE_REF) ) {
								int LA31_11 = input.LA(5);
								if ( (LA31_11==DOWN) ) {
									alt31=1;
								}

							}
							else if ( (LA31_9==ACTION||(LA31_9 >= ASSIGN && LA31_9 <= BLOCK)||LA31_9==CHAR_LITERAL||LA31_9==CLOSURE||LA31_9==DOT||LA31_9==EPSILON||LA31_9==FORCED_ACTION||LA31_9==GATED_SEMPRED||LA31_9==NOT||LA31_9==OPTIONAL||(LA31_9 >= PLUS_ASSIGN && LA31_9 <= POSITIVE_CLOSURE)||LA31_9==RANGE||LA31_9==ROOT||LA31_9==SEMPRED||(LA31_9 >= STRING_LITERAL && LA31_9 <= SYN_SEMPRED)||LA31_9==TOKEN_REF||LA31_9==TREE_BEGIN||LA31_9==WILDCARD) ) {
								alt31=1;
							}

						}

					}

					}
					break;
				case RULE_REF:
					{
					int LA31_3 = input.LA(2);
					if ( (LA31_3==DOWN) ) {
						alt31=1;
					}

					}
					break;
				case ACTION:
				case BACKTRACK_SEMPRED:
				case BANG:
				case BLOCK:
				case CHAR_LITERAL:
				case CLOSURE:
				case DOT:
				case EPSILON:
				case FORCED_ACTION:
				case GATED_SEMPRED:
				case NOT:
				case OPTIONAL:
				case POSITIVE_CLOSURE:
				case RANGE:
				case ROOT:
				case SEMPRED:
				case STRING_LITERAL:
				case SYNPRED:
				case SYN_SEMPRED:
				case TOKEN_REF:
				case TREE_BEGIN:
				case WILDCARD:
					{
					alt31=1;
					}
					break;
				}
				switch (alt31) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:197:96: {...}? element
					{
					if ( !((!((CommonTree)input.LT(1)).getText().equals(ruleName))) ) {
						if (state.backtracking>0) {state.failed=true; return;}
						throw new FailedPredicateException(input, "prefix", "!((CommonTree)input.LT(1)).getText().equals(ruleName)");
					}
					pushFollow(FOLLOW_element_in_prefix966);
					element();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt31 >= 1 ) break loop31;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(31, input);
					throw eee;
				}
				cnt31++;
			}

			pushFollow(FOLLOW_recurse_in_prefix970);
			recurse();
			state._fsp--;
			if (state.failed) return;
			match(input,EOA,FOLLOW_EOA_in_prefix972); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

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
	// $ANTLR end "prefix"



	// $ANTLR start "suffix"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:1: suffix : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ( element )+ EOA ) ;
	public final void suffix() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:8: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ( element )+ EOA ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:10: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ( element )+ EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_suffix985); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:17: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==BACKTRACK_SEMPRED) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:18: ^( BACKTRACK_SEMPRED ( . )* )
					{
					match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_suffix989); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:38: ( . )*
						loop32:
						while (true) {
							int alt32=2;
							int LA32_0 = input.LA(1);
							if ( ((LA32_0 >= ACTION && LA32_0 <= XDIGIT)) ) {
								alt32=1;
							}
							else if ( (LA32_0==UP) ) {
								alt32=2;
							}

							switch (alt32) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:38: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop32;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

			}

			pushFollow(FOLLOW_recurseNoLabel_in_suffix997);
			recurseNoLabel();
			state._fsp--;
			if (state.failed) return;
			if ( state.backtracking==0 ) {setTokenPrec((GrammarAST)input.LT(1), outerAlt);}
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:110: ( element )+
			int cnt34=0;
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==ACTION||(LA34_0 >= ASSIGN && LA34_0 <= BLOCK)||LA34_0==CHAR_LITERAL||LA34_0==CLOSURE||LA34_0==DOT||LA34_0==EPSILON||LA34_0==FORCED_ACTION||LA34_0==GATED_SEMPRED||LA34_0==NOT||LA34_0==OPTIONAL||(LA34_0 >= PLUS_ASSIGN && LA34_0 <= POSITIVE_CLOSURE)||LA34_0==RANGE||LA34_0==ROOT||LA34_0==RULE_REF||LA34_0==SEMPRED||(LA34_0 >= STRING_LITERAL && LA34_0 <= SYN_SEMPRED)||LA34_0==TOKEN_REF||LA34_0==TREE_BEGIN||LA34_0==WILDCARD) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:199:110: element
					{
					pushFollow(FOLLOW_element_in_suffix1001);
					element();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt34 >= 1 ) break loop34;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(34, input);
					throw eee;
				}
				cnt34++;
			}

			match(input,EOA,FOLLOW_EOA_in_suffix1005); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

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
	// $ANTLR end "suffix"



	// $ANTLR start "recurse"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:201:1: recurse : ( ^( ASSIGN ID recurseNoLabel ) | ^( PLUS_ASSIGN ID recurseNoLabel ) | recurseNoLabel );
	public final void recurse() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:202:2: ( ^( ASSIGN ID recurseNoLabel ) | ^( PLUS_ASSIGN ID recurseNoLabel ) | recurseNoLabel )
			int alt35=3;
			switch ( input.LA(1) ) {
			case ASSIGN:
				{
				alt35=1;
				}
				break;
			case PLUS_ASSIGN:
				{
				alt35=2;
				}
				break;
			case RULE_REF:
				{
				alt35=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}
			switch (alt35) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:202:4: ^( ASSIGN ID recurseNoLabel )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_recurse1018); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					match(input,ID,FOLLOW_ID_in_recurse1020); if (state.failed) return;
					pushFollow(FOLLOW_recurseNoLabel_in_recurse1022);
					recurseNoLabel();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:203:4: ^( PLUS_ASSIGN ID recurseNoLabel )
					{
					match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_recurse1029); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					match(input,ID,FOLLOW_ID_in_recurse1031); if (state.failed) return;
					pushFollow(FOLLOW_recurseNoLabel_in_recurse1033);
					recurseNoLabel();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:204:4: recurseNoLabel
					{
					pushFollow(FOLLOW_recurseNoLabel_in_recurse1039);
					recurseNoLabel();
					state._fsp--;
					if (state.failed) return;
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
	// $ANTLR end "recurse"



	// $ANTLR start "recurseNoLabel"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:207:1: recurseNoLabel :{...}? RULE_REF ;
	public final void recurseNoLabel() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:207:16: ({...}? RULE_REF )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:207:18: {...}? RULE_REF
			{
			if ( !((((CommonTree)input.LT(1)).getText().equals(ruleName))) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "recurseNoLabel", "((CommonTree)input.LT(1)).getText().equals(ruleName)");
			}
			match(input,RULE_REF,FOLLOW_RULE_REF_in_recurseNoLabel1051); if (state.failed) return;
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
	// $ANTLR end "recurseNoLabel"



	// $ANTLR start "token"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:216:1: token returns [GrammarAST t=null] : ( ^( ASSIGN ID s= token ) | ^( PLUS_ASSIGN ID s= token ) | ^( ROOT s= token ) | ^( BANG s= token ) |a= CHAR_LITERAL |b= STRING_LITERAL |c= TOKEN_REF );
	public final GrammarAST token() throws RecognitionException {
		GrammarAST t = null;


		GrammarAST a=null;
		GrammarAST b=null;
		GrammarAST c=null;
		GrammarAST s =null;

		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:217:2: ( ^( ASSIGN ID s= token ) | ^( PLUS_ASSIGN ID s= token ) | ^( ROOT s= token ) | ^( BANG s= token ) |a= CHAR_LITERAL |b= STRING_LITERAL |c= TOKEN_REF )
			int alt36=7;
			switch ( input.LA(1) ) {
			case ASSIGN:
				{
				alt36=1;
				}
				break;
			case PLUS_ASSIGN:
				{
				alt36=2;
				}
				break;
			case ROOT:
				{
				alt36=3;
				}
				break;
			case BANG:
				{
				alt36=4;
				}
				break;
			case CHAR_LITERAL:
				{
				alt36=5;
				}
				break;
			case STRING_LITERAL:
				{
				alt36=6;
				}
				break;
			case TOKEN_REF:
				{
				alt36=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return t;}
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}
			switch (alt36) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:217:4: ^( ASSIGN ID s= token )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_token1068); if (state.failed) return t;
					match(input, Token.DOWN, null); if (state.failed) return t;
					match(input,ID,FOLLOW_ID_in_token1070); if (state.failed) return t;
					pushFollow(FOLLOW_token_in_token1074);
					s=token();
					state._fsp--;
					if (state.failed) return t;
					if ( state.backtracking==0 ) {t = s;}
					match(input, Token.UP, null); if (state.failed) return t;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:218:4: ^( PLUS_ASSIGN ID s= token )
					{
					match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_token1083); if (state.failed) return t;
					match(input, Token.DOWN, null); if (state.failed) return t;
					match(input,ID,FOLLOW_ID_in_token1085); if (state.failed) return t;
					pushFollow(FOLLOW_token_in_token1089);
					s=token();
					state._fsp--;
					if (state.failed) return t;
					if ( state.backtracking==0 ) {t = s;}
					match(input, Token.UP, null); if (state.failed) return t;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:219:4: ^( ROOT s= token )
					{
					match(input,ROOT,FOLLOW_ROOT_in_token1098); if (state.failed) return t;
					match(input, Token.DOWN, null); if (state.failed) return t;
					pushFollow(FOLLOW_token_in_token1102);
					s=token();
					state._fsp--;
					if (state.failed) return t;
					if ( state.backtracking==0 ) {t = s;}
					match(input, Token.UP, null); if (state.failed) return t;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:220:4: ^( BANG s= token )
					{
					match(input,BANG,FOLLOW_BANG_in_token1111); if (state.failed) return t;
					match(input, Token.DOWN, null); if (state.failed) return t;
					pushFollow(FOLLOW_token_in_token1115);
					s=token();
					state._fsp--;
					if (state.failed) return t;
					if ( state.backtracking==0 ) {t = s;}
					match(input, Token.UP, null); if (state.failed) return t;

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:221:4: a= CHAR_LITERAL
					{
					a=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_token1125); if (state.failed) return t;
					if ( state.backtracking==0 ) {t = a;}
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:222:4: b= STRING_LITERAL
					{
					b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_token1139); if (state.failed) return t;
					if ( state.backtracking==0 ) {t = b;}
					}
					break;
				case 7 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:223:4: c= TOKEN_REF
					{
					c=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_token1151); if (state.failed) return t;
					if ( state.backtracking==0 ) {t = c;}
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
		return t;
	}
	// $ANTLR end "token"



	// $ANTLR start "exceptionGroup"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:226:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
	public final void exceptionGroup() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:227:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==CATCH) ) {
				alt39=1;
			}
			else if ( (LA39_0==FINALLY) ) {
				alt39=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:227:4: ( exceptionHandler )+ ( finallyClause )?
					{
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:227:4: ( exceptionHandler )+
					int cnt37=0;
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==CATCH) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:227:4: exceptionHandler
							{
							pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1172);
							exceptionHandler();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt37 >= 1 ) break loop37;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(37, input);
							throw eee;
						}
						cnt37++;
					}

					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:227:22: ( finallyClause )?
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0==FINALLY) ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:227:22: finallyClause
							{
							pushFollow(FOLLOW_finallyClause_in_exceptionGroup1175);
							finallyClause();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:228:4: finallyClause
					{
					pushFollow(FOLLOW_finallyClause_in_exceptionGroup1181);
					finallyClause();
					state._fsp--;
					if (state.failed) return;
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
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:231:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
	public final void exceptionHandler() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:232:2: ( ^( 'catch' ARG_ACTION ACTION ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:232:4: ^( 'catch' ARG_ACTION ACTION )
			{
			match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler1196); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1198); if (state.failed) return;
			match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1200); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

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
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:235:1: finallyClause : ^( 'finally' ACTION ) ;
	public final void finallyClause() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:236:2: ( ^( 'finally' ACTION ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:236:4: ^( 'finally' ACTION )
			{
			match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause1213); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			match(input,ACTION,FOLLOW_ACTION_in_finallyClause1215); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

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



	// $ANTLR start "rewrite"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:1: rewrite : ^( REWRITES ( ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) ) )* ) ;
	public final void rewrite() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:2: ( ^( REWRITES ( ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) ) )* ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:4: ^( REWRITES ( ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) ) )* )
			{
			match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1228); if (state.failed) return;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return;
				// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:15: ( ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) ) )*
				loop44:
				while (true) {
					int alt44=2;
					int LA44_0 = input.LA(1);
					if ( (LA44_0==REWRITE) ) {
						alt44=1;
					}

					switch (alt44) {
					case 1 :
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:17: ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) )
						{
						match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1234); if (state.failed) return;
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:28: ( SEMPRED )?
						int alt40=2;
						int LA40_0 = input.LA(1);
						if ( (LA40_0==SEMPRED) ) {
							alt40=1;
						}
						switch (alt40) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:28: SEMPRED
								{
								match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite1236); if (state.failed) return;
								}
								break;

						}

						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:37: ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC )
						int alt43=4;
						switch ( input.LA(1) ) {
						case ALT:
							{
							alt43=1;
							}
							break;
						case TEMPLATE:
							{
							alt43=2;
							}
							break;
						case ACTION:
							{
							alt43=3;
							}
							break;
						case ETC:
							{
							alt43=4;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return;}
							NoViableAltException nvae =
								new NoViableAltException("", 43, 0, input);
							throw nvae;
						}
						switch (alt43) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:38: ^( ALT ( . )* )
								{
								match(input,ALT,FOLLOW_ALT_in_rewrite1241); if (state.failed) return;
								if ( input.LA(1)==Token.DOWN ) {
									match(input, Token.DOWN, null); if (state.failed) return;
									// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:44: ( . )*
									loop41:
									while (true) {
										int alt41=2;
										int LA41_0 = input.LA(1);
										if ( ((LA41_0 >= ACTION && LA41_0 <= XDIGIT)) ) {
											alt41=1;
										}
										else if ( (LA41_0==UP) ) {
											alt41=2;
										}

										switch (alt41) {
										case 1 :
											// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:44: .
											{
											matchAny(input); if (state.failed) return;
											}
											break;

										default :
											break loop41;
										}
									}

									match(input, Token.UP, null); if (state.failed) return;
								}

								}
								break;
							case 2 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:48: ^( TEMPLATE ( . )* )
								{
								match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite1248); if (state.failed) return;
								if ( input.LA(1)==Token.DOWN ) {
									match(input, Token.DOWN, null); if (state.failed) return;
									// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:59: ( . )*
									loop42:
									while (true) {
										int alt42=2;
										int LA42_0 = input.LA(1);
										if ( ((LA42_0 >= ACTION && LA42_0 <= XDIGIT)) ) {
											alt42=1;
										}
										else if ( (LA42_0==UP) ) {
											alt42=2;
										}

										switch (alt42) {
										case 1 :
											// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:59: .
											{
											matchAny(input); if (state.failed) return;
											}
											break;

										default :
											break loop42;
										}
									}

									match(input, Token.UP, null); if (state.failed) return;
								}

								}
								break;
							case 3 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:63: ACTION
								{
								match(input,ACTION,FOLLOW_ACTION_in_rewrite1254); if (state.failed) return;
								}
								break;
							case 4 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:240:70: ETC
								{
								match(input,ETC,FOLLOW_ETC_in_rewrite1256); if (state.failed) return;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return;

						}
						break;

					default :
						break loop44;
					}
				}

				match(input, Token.UP, null); if (state.failed) return;
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
	// $ANTLR end "rewrite"



	// $ANTLR start "element"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:243:1: element : ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) | ebnf | tree_ | ^( SYNPRED block ) | FORCED_ACTION | ACTION | SEMPRED | SYN_SEMPRED | BACKTRACK_SEMPRED | GATED_SEMPRED | EPSILON );
	public final void element() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:244:2: ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) | ebnf | tree_ | ^( SYNPRED block ) | FORCED_ACTION | ACTION | SEMPRED | SYN_SEMPRED | BACKTRACK_SEMPRED | GATED_SEMPRED | EPSILON )
			int alt45=17;
			switch ( input.LA(1) ) {
			case ROOT:
				{
				alt45=1;
				}
				break;
			case BANG:
				{
				alt45=2;
				}
				break;
			case CHAR_LITERAL:
			case DOT:
			case RULE_REF:
			case STRING_LITERAL:
			case TOKEN_REF:
			case WILDCARD:
				{
				alt45=3;
				}
				break;
			case NOT:
				{
				alt45=4;
				}
				break;
			case RANGE:
				{
				alt45=5;
				}
				break;
			case ASSIGN:
				{
				alt45=6;
				}
				break;
			case PLUS_ASSIGN:
				{
				alt45=7;
				}
				break;
			case BLOCK:
			case CLOSURE:
			case OPTIONAL:
			case POSITIVE_CLOSURE:
				{
				alt45=8;
				}
				break;
			case TREE_BEGIN:
				{
				alt45=9;
				}
				break;
			case SYNPRED:
				{
				alt45=10;
				}
				break;
			case FORCED_ACTION:
				{
				alt45=11;
				}
				break;
			case ACTION:
				{
				alt45=12;
				}
				break;
			case SEMPRED:
				{
				alt45=13;
				}
				break;
			case SYN_SEMPRED:
				{
				alt45=14;
				}
				break;
			case BACKTRACK_SEMPRED:
				{
				alt45=15;
				}
				break;
			case GATED_SEMPRED:
				{
				alt45=16;
				}
				break;
			case EPSILON:
				{
				alt45=17;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}
			switch (alt45) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:244:4: ^( ROOT element )
					{
					match(input,ROOT,FOLLOW_ROOT_in_element1276); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_element_in_element1278);
					element();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:245:4: ^( BANG element )
					{
					match(input,BANG,FOLLOW_BANG_in_element1285); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_element_in_element1287);
					element();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:246:4: atom
					{
					pushFollow(FOLLOW_atom_in_element1293);
					atom();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:247:4: ^( NOT element )
					{
					match(input,NOT,FOLLOW_NOT_in_element1299); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_element_in_element1301);
					element();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:248:4: ^( RANGE atom atom )
					{
					match(input,RANGE,FOLLOW_RANGE_in_element1308); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_atom_in_element1310);
					atom();
					state._fsp--;
					if (state.failed) return;
					pushFollow(FOLLOW_atom_in_element1312);
					atom();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:249:4: ^( ASSIGN ID element )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_element1319); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					match(input,ID,FOLLOW_ID_in_element1321); if (state.failed) return;
					pushFollow(FOLLOW_element_in_element1323);
					element();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 7 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:250:4: ^( PLUS_ASSIGN ID element )
					{
					match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element1330); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					match(input,ID,FOLLOW_ID_in_element1332); if (state.failed) return;
					pushFollow(FOLLOW_element_in_element1334);
					element();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 8 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:251:4: ebnf
					{
					pushFollow(FOLLOW_ebnf_in_element1340);
					ebnf();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 9 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:252:4: tree_
					{
					pushFollow(FOLLOW_tree__in_element1345);
					tree_();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 10 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:253:4: ^( SYNPRED block )
					{
					match(input,SYNPRED,FOLLOW_SYNPRED_in_element1351); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_block_in_element1353);
					block();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 11 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:254:4: FORCED_ACTION
					{
					match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element1360); if (state.failed) return;
					}
					break;
				case 12 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:255:4: ACTION
					{
					match(input,ACTION,FOLLOW_ACTION_in_element1365); if (state.failed) return;
					}
					break;
				case 13 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:256:4: SEMPRED
					{
					match(input,SEMPRED,FOLLOW_SEMPRED_in_element1370); if (state.failed) return;
					}
					break;
				case 14 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:257:4: SYN_SEMPRED
					{
					match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element1375); if (state.failed) return;
					}
					break;
				case 15 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:258:4: BACKTRACK_SEMPRED
					{
					match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element1380); if (state.failed) return;
					}
					break;
				case 16 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:259:4: GATED_SEMPRED
					{
					match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element1385); if (state.failed) return;
					}
					break;
				case 17 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:260:4: EPSILON
					{
					match(input,EPSILON,FOLLOW_EPSILON_in_element1390); if (state.failed) return;
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



	// $ANTLR start "ebnf"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:263:1: ebnf : ( block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) );
	public final void ebnf() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:263:5: ( block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) )
			int alt46=4;
			switch ( input.LA(1) ) {
			case BLOCK:
				{
				alt46=1;
				}
				break;
			case OPTIONAL:
				{
				alt46=2;
				}
				break;
			case CLOSURE:
				{
				alt46=3;
				}
				break;
			case POSITIVE_CLOSURE:
				{
				alt46=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:263:9: block
					{
					pushFollow(FOLLOW_block_in_ebnf1402);
					block();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:264:9: ^( OPTIONAL block )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1414); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_block_in_ebnf1416);
					block();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:265:9: ^( CLOSURE block )
					{
					match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1431); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_block_in_ebnf1433);
					block();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:266:9: ^( POSITIVE_CLOSURE block )
					{
					match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1449); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_block_in_ebnf1451);
					block();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

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



	// $ANTLR start "tree_"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:269:1: tree_ : ^( TREE_BEGIN ( element )+ ) ;
	public final void tree_() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:270:2: ( ^( TREE_BEGIN ( element )+ ) )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:270:4: ^( TREE_BEGIN ( element )+ )
			{
			match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1469); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:270:17: ( element )+
			int cnt47=0;
			loop47:
			while (true) {
				int alt47=2;
				int LA47_0 = input.LA(1);
				if ( (LA47_0==ACTION||(LA47_0 >= ASSIGN && LA47_0 <= BLOCK)||LA47_0==CHAR_LITERAL||LA47_0==CLOSURE||LA47_0==DOT||LA47_0==EPSILON||LA47_0==FORCED_ACTION||LA47_0==GATED_SEMPRED||LA47_0==NOT||LA47_0==OPTIONAL||(LA47_0 >= PLUS_ASSIGN && LA47_0 <= POSITIVE_CLOSURE)||LA47_0==RANGE||LA47_0==ROOT||LA47_0==RULE_REF||LA47_0==SEMPRED||(LA47_0 >= STRING_LITERAL && LA47_0 <= SYN_SEMPRED)||LA47_0==TOKEN_REF||LA47_0==TREE_BEGIN||LA47_0==WILDCARD) ) {
					alt47=1;
				}

				switch (alt47) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:270:17: element
					{
					pushFollow(FOLLOW_element_in_tree_1471);
					element();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt47 >= 1 ) break loop47;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(47, input);
					throw eee;
				}
				cnt47++;
			}

			match(input, Token.UP, null); if (state.failed) return;

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
	// $ANTLR end "tree_"



	// $ANTLR start "atom"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:273:1: atom : ( ^( RULE_REF ( ARG_ACTION )? ) | ^( TOKEN_REF ( ARG_ACTION )? ) | CHAR_LITERAL | STRING_LITERAL | WILDCARD | ^( DOT ID atom ) );
	public final void atom() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:274:2: ( ^( RULE_REF ( ARG_ACTION )? ) | ^( TOKEN_REF ( ARG_ACTION )? ) | CHAR_LITERAL | STRING_LITERAL | WILDCARD | ^( DOT ID atom ) )
			int alt50=6;
			switch ( input.LA(1) ) {
			case RULE_REF:
				{
				alt50=1;
				}
				break;
			case TOKEN_REF:
				{
				alt50=2;
				}
				break;
			case CHAR_LITERAL:
				{
				alt50=3;
				}
				break;
			case STRING_LITERAL:
				{
				alt50=4;
				}
				break;
			case WILDCARD:
				{
				alt50=5;
				}
				break;
			case DOT:
				{
				alt50=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}
			switch (alt50) {
				case 1 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:274:4: ^( RULE_REF ( ARG_ACTION )? )
					{
					match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1485); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:274:15: ( ARG_ACTION )?
						int alt48=2;
						int LA48_0 = input.LA(1);
						if ( (LA48_0==ARG_ACTION) ) {
							alt48=1;
						}
						switch (alt48) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:274:15: ARG_ACTION
								{
								match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1487); if (state.failed) return;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:275:4: ^( TOKEN_REF ( ARG_ACTION )? )
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1495); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:275:16: ( ARG_ACTION )?
						int alt49=2;
						int LA49_0 = input.LA(1);
						if ( (LA49_0==ARG_ACTION) ) {
							alt49=1;
						}
						switch (alt49) {
							case 1 :
								// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:275:16: ARG_ACTION
								{
								match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1497); if (state.failed) return;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:276:4: CHAR_LITERAL
					{
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1504); if (state.failed) return;
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:277:4: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1509); if (state.failed) return;
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:278:4: WILDCARD
					{
					match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1514); if (state.failed) return;
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:279:4: ^( DOT ID atom )
					{
					match(input,DOT,FOLLOW_DOT_in_atom1520); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					match(input,ID,FOLLOW_ID_in_atom1522); if (state.failed) return;
					pushFollow(FOLLOW_atom_in_atom1524);
					atom();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

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



	// $ANTLR start "ast_suffix"
	// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:282:1: ast_suffix : ( ROOT | BANG );
	public final void ast_suffix() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:283:2: ( ROOT | BANG )
			// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:
			{
			if ( input.LA(1)==BANG||input.LA(1)==ROOT ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
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
	// $ANTLR end "ast_suffix"

	// $ANTLR start synpred1_LeftRecursiveRuleWalker
	public final void synpred1_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:171:9: ( binaryMultipleOp )
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:171:10: binaryMultipleOp
		{
		pushFollow(FOLLOW_binaryMultipleOp_in_synpred1_LeftRecursiveRuleWalker484);
		binaryMultipleOp();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred1_LeftRecursiveRuleWalker

	// $ANTLR start synpred2_LeftRecursiveRuleWalker
	public final void synpred2_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:173:9: ( binary )
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:173:10: binary
		{
		pushFollow(FOLLOW_binary_in_synpred2_LeftRecursiveRuleWalker530);
		binary();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_LeftRecursiveRuleWalker

	// $ANTLR start synpred3_LeftRecursiveRuleWalker
	public final void synpred3_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:175:9: ( ternary )
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:175:10: ternary
		{
		pushFollow(FOLLOW_ternary_in_synpred3_LeftRecursiveRuleWalker593);
		ternary();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred3_LeftRecursiveRuleWalker

	// $ANTLR start synpred4_LeftRecursiveRuleWalker
	public final void synpred4_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:177:9: ( prefix )
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:177:10: prefix
		{
		pushFollow(FOLLOW_prefix_in_synpred4_LeftRecursiveRuleWalker648);
		prefix();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred4_LeftRecursiveRuleWalker

	// $ANTLR start synpred5_LeftRecursiveRuleWalker
	public final void synpred5_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:179:9: ( suffix )
		// org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:179:10: suffix
		{
		pushFollow(FOLLOW_suffix_in_synpred5_LeftRecursiveRuleWalker704);
		suffix();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred5_LeftRecursiveRuleWalker

	// Delegated rules

	public final boolean synpred1_LeftRecursiveRuleWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_LeftRecursiveRuleWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_LeftRecursiveRuleWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_LeftRecursiveRuleWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_LeftRecursiveRuleWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_LeftRecursiveRuleWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_LeftRecursiveRuleWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_LeftRecursiveRuleWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_LeftRecursiveRuleWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_LeftRecursiveRuleWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_OPTIONS_in_optionsSpec57 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_option_in_optionsSpec59 = new BitSet(new long[]{0x0000000000002008L});
	public static final BitSet FOLLOW_ASSIGN_in_option73 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_option75 = new BitSet(new long[]{0x0000880000040000L,0x0000000001000000L});
	public static final BitSet FOLLOW_optionValue_in_option77 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_charSetElement121 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement123 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement125 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RANGE_in_charSetElement132 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement134 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement136 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_rec_rule164 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rec_rule168 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
	public static final BitSet FOLLOW_modifier_in_rec_rule175 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ARG_in_rec_rule182 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rec_rule184 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RET_in_rec_rule192 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rec_rule194 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_optionsSpec_in_rec_rule201 = new BitSet(new long[]{0x0000000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_rec_rule207 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_AMPERSAND_in_rec_rule215 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ruleBlock_in_rec_rule226 = new BitSet(new long[]{0x0000004400020000L});
	public static final BitSet FOLLOW_exceptionGroup_in_rec_rule233 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_EOR_in_rec_rule239 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec286 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec288 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_ID_in_ruleScopeSpec291 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_BLOCK_in_ruleBlock315 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_optionsSpec_in_ruleBlock320 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_outerAlternative_in_ruleBlock328 = new BitSet(new long[]{0x0000000200000100L,0x0000000000001000L});
	public static final BitSet FOLLOW_rewrite_in_ruleBlock340 = new BitSet(new long[]{0x0000000200000100L});
	public static final BitSet FOLLOW_EOB_in_ruleBlock358 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block381 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_optionsSpec_in_block395 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ALT_in_block413 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_block415 = new BitSet(new long[]{0x828002892025E010L,0x0000000547092041L});
	public static final BitSet FOLLOW_EOA_in_block418 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rewrite_in_block421 = new BitSet(new long[]{0x0000000200000100L});
	public static final BitSet FOLLOW_EOB_in_block439 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_binaryMultipleOp_in_outerAlternative488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binary_in_outerAlternative544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ternary_in_outerAlternative606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefix_in_outerAlternative662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_suffix_in_outerAlternative718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALT_in_outerAlternative760 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_outerAlternative762 = new BitSet(new long[]{0x828002892025E010L,0x0000000547092041L});
	public static final BitSet FOLLOW_EOA_in_outerAlternative765 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_binary814 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_binary818 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_recurseNoLabel_in_binary826 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
	public static final BitSet FOLLOW_token_in_binary830 = new BitSet(new long[]{0x8000000000002000L,0x0000000000010000L});
	public static final BitSet FOLLOW_recurse_in_binary832 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_binary834 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_binaryMultipleOp851 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_binaryMultipleOp855 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_recurseNoLabel_in_binaryMultipleOp863 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_BLOCK_in_binaryMultipleOp867 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ALT_in_binaryMultipleOp873 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_token_in_binaryMultipleOp877 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_binaryMultipleOp879 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EOB_in_binaryMultipleOp888 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_recurse_in_binaryMultipleOp892 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_binaryMultipleOp894 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_ternary909 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_ternary913 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_recurseNoLabel_in_ternary921 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
	public static final BitSet FOLLOW_token_in_ternary925 = new BitSet(new long[]{0x8000000000002000L,0x0000000000010000L});
	public static final BitSet FOLLOW_recurse_in_ternary927 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
	public static final BitSet FOLLOW_token_in_ternary929 = new BitSet(new long[]{0x8000000000002000L,0x0000000000010000L});
	public static final BitSet FOLLOW_recurse_in_ternary931 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_ternary933 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_prefix949 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_prefix953 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_prefix966 = new BitSet(new long[]{0x828002882025E010L,0x0000000547092041L});
	public static final BitSet FOLLOW_recurse_in_prefix970 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_prefix972 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_suffix985 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_suffix989 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_recurseNoLabel_in_suffix997 = new BitSet(new long[]{0x828002882025E010L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_suffix1001 = new BitSet(new long[]{0x828002892025E010L,0x0000000547092041L});
	public static final BitSet FOLLOW_EOA_in_suffix1005 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_recurse1018 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_recurse1020 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_recurseNoLabel_in_recurse1022 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_ASSIGN_in_recurse1029 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_recurse1031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_recurseNoLabel_in_recurse1033 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_recurseNoLabel_in_recurse1039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_recurseNoLabel1051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_token1068 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_token1070 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
	public static final BitSet FOLLOW_token_in_token1074 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_ASSIGN_in_token1083 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_token1085 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
	public static final BitSet FOLLOW_token_in_token1089 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ROOT_in_token1098 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_token_in_token1102 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BANG_in_token1111 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_token_in_token1115 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_token1125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_token1139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_token1151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1172 = new BitSet(new long[]{0x0000004000020002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CATCH_in_exceptionHandler1196 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1198 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_exceptionHandler1200 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FINALLY_in_finallyClause1213 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_finallyClause1215 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REWRITES_in_rewrite1228 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite1234 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_SEMPRED_in_rewrite1236 = new BitSet(new long[]{0x0000002000000110L,0x0000000008000000L});
	public static final BitSet FOLLOW_ALT_in_rewrite1241 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TEMPLATE_in_rewrite1248 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_rewrite1254 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ETC_in_rewrite1256 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ROOT_in_element1276 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element1278 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BANG_in_element1285 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element1287 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_atom_in_element1293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_element1299 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element1301 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RANGE_in_element1308 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_atom_in_element1310 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_element1312 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_element1319 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element1321 = new BitSet(new long[]{0x828002882025E010L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_element1323 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_ASSIGN_in_element1330 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element1332 = new BitSet(new long[]{0x828002882025E010L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_element1334 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ebnf_in_element1340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tree__in_element1345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYNPRED_in_element1351 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_element1353 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FORCED_ACTION_in_element1360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_element1365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMPRED_in_element1370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYN_SEMPRED_in_element1375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element1380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GATED_SEMPRED_in_element1385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EPSILON_in_element1390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_ebnf1402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_ebnf1414 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1416 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CLOSURE_in_ebnf1431 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1433 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1449 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1451 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1469 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_tree_1471 = new BitSet(new long[]{0x828002882025E018L,0x0000000547092041L});
	public static final BitSet FOLLOW_RULE_REF_in_atom1485 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1487 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom1495 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1497 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_atom1509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WILDCARD_in_atom1514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_atom1520 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_atom1522 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_atom1524 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_binaryMultipleOp_in_synpred1_LeftRecursiveRuleWalker484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binary_in_synpred2_LeftRecursiveRuleWalker530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ternary_in_synpred3_LeftRecursiveRuleWalker593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefix_in_synpred4_LeftRecursiveRuleWalker648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_suffix_in_synpred5_LeftRecursiveRuleWalker704 = new BitSet(new long[]{0x0000000000000002L});
}
