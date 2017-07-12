// $ANTLR 3.5 org/antlr/grammar/v3/TreeToNFAConverter.g 2017-06-11 18:42:20

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

/** Build an NFA from a tree representing an ANTLR grammar. */
@SuppressWarnings("all")
public class TreeToNFAConverter extends TreeParser {
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


	public TreeToNFAConverter(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public TreeToNFAConverter(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return TreeToNFAConverter.tokenNames; }
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/TreeToNFAConverter.g"; }


	/** Factory used to create nodes and submachines */
	protected NFAFactory factory = null;

	/** Which NFA object are we filling in? */
	protected NFA nfa = null;

	/** Which grammar are we converting an NFA for? */
	protected Grammar grammar = null;

	protected String currentRuleName = null;

	protected int outerAltNum = 0;
	protected int blockLevel = 0;

	protected int inTest = 0;

	public TreeToNFAConverter(TreeNodeStream input, Grammar g, NFA nfa, NFAFactory factory) {
	    this(input);
	    this.grammar = g;
	    this.nfa = nfa;
	    this.factory = factory;
	}

	public final IntSet setRule(GrammarAST t) throws RecognitionException {
	    TreeToNFAConverter other = new TreeToNFAConverter( new CommonTreeNodeStream( t ), grammar, nfa, factory );

	    other.currentRuleName = currentRuleName;
	    other.outerAltNum = outerAltNum;
	    other.blockLevel = blockLevel;

	    return other.setRule();
	}

	public final int testBlockAsSet( GrammarAST t ) throws RecognitionException {
	    Rule r = grammar.getLocallyDefinedRule( currentRuleName );
	    if ( r.hasRewrite( outerAltNum ) )
	        return -1;

	    TreeToNFAConverter other = new TreeToNFAConverter( new CommonTreeNodeStream( t ), grammar, nfa, factory );

	    other.state.backtracking++;
	    other.currentRuleName = currentRuleName;
	    other.outerAltNum = outerAltNum;
	    other.blockLevel = blockLevel;

	    int result = other.testBlockAsSet();
	    if ( other.state.failed )
	        return -1;

	    return result;
	}

	public final int testSetRule( GrammarAST t ) throws RecognitionException {
	    TreeToNFAConverter other = new TreeToNFAConverter( new CommonTreeNodeStream( t ), grammar, nfa, factory );

	    other.state.backtracking++;
	    other.currentRuleName = currentRuleName;
	    other.outerAltNum = outerAltNum;
	    other.blockLevel = blockLevel;

	    int result = other.testSetRule();
	    if ( other.state.failed )
	        state.failed = true;

	    return result;
	}

	protected void addFollowTransition( String ruleName, NFAState following ) {
	    //System.Console.Out.WriteLine( "adding follow link to rule " + ruleName );
	    // find last link in FOLLOW chain emanating from rule
	    Rule r = grammar.getRule( ruleName );
	    NFAState end = r.stopState;
	    while ( end.transition( 1 ) != null )
	    {
	        end = (NFAState)end.transition( 1 ).target;
	    }
	    if ( end.transition( 0 ) != null )
	    {
	        // already points to a following node
	        // gotta add another node to keep edges to a max of 2
	        NFAState n = factory.newState();
	        Transition e = new Transition( Label.EPSILON, n );
	        end.addTransition( e );
	        end = n;
	    }
	    Transition followEdge = new Transition( Label.EPSILON, following );
	    end.addTransition( followEdge );
	}

	protected void finish() {
	    int numEntryPoints = factory.build_EOFStates( grammar.getRules() );
	    if ( numEntryPoints == 0 )
	    {
	        ErrorManager.grammarWarning( ErrorManager.MSG_NO_GRAMMAR_START_RULE,
	                                   grammar,
	                                   null,
	                                   grammar.name );
	    }
	}

	@Override
	public void reportError(RecognitionException ex) {
	    if ( inTest > 0 )
	        throw new IllegalStateException(ex);

	    Token token = null;
	    if ( ex instanceof MismatchedTokenException )
	    {
	        token = ( (MismatchedTokenException)ex ).token;
	    }
	    else if ( ex instanceof NoViableAltException )
	    {
	        token = ( (NoViableAltException)ex ).token;
	    }

	    ErrorManager.syntaxError(
	        ErrorManager.MSG_SYNTAX_ERROR,
	        grammar,
	        token,
	        "buildnfa: " + ex.toString(),
	        ex );
	}

	private boolean hasElementOptions(GrammarAST node) {
	    if (node == null)
	        throw new NullPointerException("node");
	    return node.terminalOptions != null && node.terminalOptions.size() > 0;
	}



	// $ANTLR start "grammar_"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:185:1: public grammar_ : ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) ) ;
	public final void grammar_() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:190:2: ( ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:190:4: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
			{
			// org/antlr/grammar/v3/TreeToNFAConverter.g:190:4: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
			int alt1=4;
			switch ( input.LA(1) ) {
			case LEXER_GRAMMAR:
				{
				alt1=1;
				}
				break;
			case PARSER_GRAMMAR:
				{
				alt1=2;
				}
				break;
			case TREE_GRAMMAR:
				{
				alt1=3;
				}
				break;
			case COMBINED_GRAMMAR:
				{
				alt1=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:190:6: ^( LEXER_GRAMMAR grammarSpec )
					{
					match(input,LEXER_GRAMMAR,FOLLOW_LEXER_GRAMMAR_in_grammar_68); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_grammarSpec_in_grammar_70);
					grammarSpec();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:191:5: ^( PARSER_GRAMMAR grammarSpec )
					{
					match(input,PARSER_GRAMMAR,FOLLOW_PARSER_GRAMMAR_in_grammar_80); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_grammarSpec_in_grammar_82);
					grammarSpec();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:192:5: ^( TREE_GRAMMAR grammarSpec )
					{
					match(input,TREE_GRAMMAR,FOLLOW_TREE_GRAMMAR_in_grammar_92); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_grammarSpec_in_grammar_94);
					grammarSpec();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:193:5: ^( COMBINED_GRAMMAR grammarSpec )
					{
					match(input,COMBINED_GRAMMAR,FOLLOW_COMBINED_GRAMMAR_in_grammar_104); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_grammarSpec_in_grammar_106);
					grammarSpec();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				finish();
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
	// $ANTLR end "grammar_"



	// $ANTLR start "attrScope"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:197:1: attrScope : ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION ) ;
	public final void attrScope() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:198:2: ( ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:198:4: ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION )
			{
			match(input,SCOPE,FOLLOW_SCOPE_in_attrScope125); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			match(input,ID,FOLLOW_ID_in_attrScope127); if (state.failed) return;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:198:18: ( ^( AMPERSAND ( . )* ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==AMPERSAND) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:198:20: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_attrScope132); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:198:32: ( . )*
						loop2:
						while (true) {
							int alt2=2;
							int LA2_0 = input.LA(1);
							if ( ((LA2_0 >= ACTION && LA2_0 <= XDIGIT)) ) {
								alt2=1;
							}
							else if ( (LA2_0==UP) ) {
								alt2=2;
							}

							switch (alt2) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:198:32: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop2;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,ACTION,FOLLOW_ACTION_in_attrScope141); if (state.failed) return;
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
	// $ANTLR end "attrScope"



	// $ANTLR start "grammarSpec"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:201:1: grammarSpec : ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules ;
	public final void grammarSpec() throws RecognitionException {
		GrammarAST cmt=null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:202:2: ( ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:202:4: ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules
			{
			match(input,ID,FOLLOW_ID_in_grammarSpec154); if (state.failed) return;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:203:3: (cmt= DOC_COMMENT )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==DOC_COMMENT) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:203:4: cmt= DOC_COMMENT
					{
					cmt=(GrammarAST)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec161); if (state.failed) return;
					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:204:3: ( ^( OPTIONS ( . )* ) )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==OPTIONS) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:204:5: ^( OPTIONS ( . )* )
					{
					match(input,OPTIONS,FOLLOW_OPTIONS_in_grammarSpec170); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:204:15: ( . )*
						loop5:
						while (true) {
							int alt5=2;
							int LA5_0 = input.LA(1);
							if ( ((LA5_0 >= ACTION && LA5_0 <= XDIGIT)) ) {
								alt5=1;
							}
							else if ( (LA5_0==UP) ) {
								alt5=2;
							}

							switch (alt5) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:204:15: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop5;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:205:3: ( ^( IMPORT ( . )* ) )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==IMPORT) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:205:5: ^( IMPORT ( . )* )
					{
					match(input,IMPORT,FOLLOW_IMPORT_in_grammarSpec184); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:205:14: ( . )*
						loop7:
						while (true) {
							int alt7=2;
							int LA7_0 = input.LA(1);
							if ( ((LA7_0 >= ACTION && LA7_0 <= XDIGIT)) ) {
								alt7=1;
							}
							else if ( (LA7_0==UP) ) {
								alt7=2;
							}

							switch (alt7) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:205:14: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop7;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:206:3: ( ^( TOKENS ( . )* ) )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==TOKENS) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:206:5: ^( TOKENS ( . )* )
					{
					match(input,TOKENS,FOLLOW_TOKENS_in_grammarSpec198); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:206:14: ( . )*
						loop9:
						while (true) {
							int alt9=2;
							int LA9_0 = input.LA(1);
							if ( ((LA9_0 >= ACTION && LA9_0 <= XDIGIT)) ) {
								alt9=1;
							}
							else if ( (LA9_0==UP) ) {
								alt9=2;
							}

							switch (alt9) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:206:14: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop9;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:207:3: ( attrScope )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==SCOPE) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:207:4: attrScope
					{
					pushFollow(FOLLOW_attrScope_in_grammarSpec210);
					attrScope();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop11;
				}
			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:208:3: ( ^( AMPERSAND ( . )* ) )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==AMPERSAND) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:208:5: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_grammarSpec219); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:208:17: ( . )*
						loop12:
						while (true) {
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( ((LA12_0 >= ACTION && LA12_0 <= XDIGIT)) ) {
								alt12=1;
							}
							else if ( (LA12_0==UP) ) {
								alt12=2;
							}

							switch (alt12) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:208:17: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop12;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

				default :
					break loop13;
				}
			}

			pushFollow(FOLLOW_rules_in_grammarSpec231);
			rules();
			state._fsp--;
			if (state.failed) return;
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
	// $ANTLR end "grammarSpec"



	// $ANTLR start "rules"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:212:1: rules : ( rule | ^( PREC_RULE ( . )* ) )+ ;
	public final void rules() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:213:2: ( ( rule | ^( PREC_RULE ( . )* ) )+ )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:213:4: ( rule | ^( PREC_RULE ( . )* ) )+
			{
			// org/antlr/grammar/v3/TreeToNFAConverter.g:213:4: ( rule | ^( PREC_RULE ( . )* ) )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=3;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==RULE) ) {
					alt15=1;
				}
				else if ( (LA15_0==PREC_RULE) ) {
					alt15=2;
				}

				switch (alt15) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:213:5: rule
					{
					pushFollow(FOLLOW_rule_in_rules243);
					rule();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:213:12: ^( PREC_RULE ( . )* )
					{
					match(input,PREC_RULE,FOLLOW_PREC_RULE_in_rules248); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:213:24: ( . )*
						loop14:
						while (true) {
							int alt14=2;
							int LA14_0 = input.LA(1);
							if ( ((LA14_0 >= ACTION && LA14_0 <= XDIGIT)) ) {
								alt14=1;
							}
							else if ( (LA14_0==UP) ) {
								alt14=2;
							}

							switch (alt14) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:213:24: .
								{
								matchAny(input); if (state.failed) return;
								}
								break;

							default :
								break loop14;
							}
						}

						match(input, Token.UP, null); if (state.failed) return;
					}

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
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
	// $ANTLR end "rules"


	public static class rule_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "rule"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:216:1: rule : ^( RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block ( exceptionGroup )? EOR ) ;
	public final TreeToNFAConverter.rule_return rule() throws RecognitionException {
		TreeToNFAConverter.rule_return retval = new TreeToNFAConverter.rule_return();
		retval.start = input.LT(1);

		GrammarAST id=null;
		TreeRuleReturnScope b =null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:217:2: ( ^( RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block ( exceptionGroup )? EOR ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:217:4: ^( RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block ( exceptionGroup )? EOR )
			{
			match(input,RULE,FOLLOW_RULE_in_rule267); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rule271); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
							currentRuleName = (id!=null?id.getText():null);
							factory.setCurrentRule(grammar.getLocallyDefinedRule(currentRuleName));
						}
			// org/antlr/grammar/v3/TreeToNFAConverter.g:222:4: ( modifier )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==FRAGMENT||(LA16_0 >= PRIVATE && LA16_0 <= PUBLIC)) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:222:5: modifier
					{
					pushFollow(FOLLOW_modifier_in_rule282);
					modifier();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			match(input,ARG,FOLLOW_ARG_in_rule290); if (state.failed) return retval;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// org/antlr/grammar/v3/TreeToNFAConverter.g:223:10: ( ARG_ACTION )?
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==ARG_ACTION) ) {
					alt17=1;
				}
				switch (alt17) {
					case 1 :
						// org/antlr/grammar/v3/TreeToNFAConverter.g:223:11: ARG_ACTION
						{
						match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule293); if (state.failed) return retval;
						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}

			match(input,RET,FOLLOW_RET_in_rule302); if (state.failed) return retval;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// org/antlr/grammar/v3/TreeToNFAConverter.g:224:10: ( ARG_ACTION )?
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==ARG_ACTION) ) {
					alt18=1;
				}
				switch (alt18) {
					case 1 :
						// org/antlr/grammar/v3/TreeToNFAConverter.g:224:11: ARG_ACTION
						{
						match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule305); if (state.failed) return retval;
						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:225:4: ( throwsSpec )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==THROWS) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:225:5: throwsSpec
					{
					pushFollow(FOLLOW_throwsSpec_in_rule314);
					throwsSpec();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:226:4: ( ^( OPTIONS ( . )* ) )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==OPTIONS) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:226:6: ^( OPTIONS ( . )* )
					{
					match(input,OPTIONS,FOLLOW_OPTIONS_in_rule324); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:226:16: ( . )*
						loop20:
						while (true) {
							int alt20=2;
							int LA20_0 = input.LA(1);
							if ( ((LA20_0 >= ACTION && LA20_0 <= XDIGIT)) ) {
								alt20=1;
							}
							else if ( (LA20_0==UP) ) {
								alt20=2;
							}

							switch (alt20) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:226:16: .
								{
								matchAny(input); if (state.failed) return retval;
								}
								break;

							default :
								break loop20;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:227:4: ( ruleScopeSpec )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==SCOPE) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:227:6: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_rule338);
					ruleScopeSpec();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:228:4: ( ^( AMPERSAND ( . )* ) )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==AMPERSAND) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:228:6: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_rule349); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:228:18: ( . )*
						loop23:
						while (true) {
							int alt23=2;
							int LA23_0 = input.LA(1);
							if ( ((LA23_0 >= ACTION && LA23_0 <= XDIGIT)) ) {
								alt23=1;
							}
							else if ( (LA23_0==UP) ) {
								alt23=2;
							}

							switch (alt23) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:228:18: .
								{
								matchAny(input); if (state.failed) return retval;
								}
								break;

							default :
								break loop23;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					}
					break;

				default :
					break loop24;
				}
			}

			pushFollow(FOLLOW_block_in_rule363);
			b=block();
			state._fsp--;
			if (state.failed) return retval;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:230:4: ( exceptionGroup )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==CATCH||LA25_0==FINALLY) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:230:5: exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_rule369);
					exceptionGroup();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			match(input,EOR,FOLLOW_EOR_in_rule376); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
							StateCluster g = (b!=null?((TreeToNFAConverter.block_return)b).g:null);
							if ((b!=null?((GrammarAST)b.start):null).getSetValue() != null)
							{
								// if block comes back as a set not BLOCK, make it
								// a single ALT block
								g = factory.build_AlternativeBlockFromSet(g);
							}
							if (Rule.getRuleType(currentRuleName) == Grammar.PARSER || grammar.type==Grammar.LEXER)
							{
								// attach start node to block for this rule
								Rule thisR = grammar.getLocallyDefinedRule(currentRuleName);
								NFAState start = thisR.startState;
								start.associatedASTNode = id;
								start.addTransition(new Transition(Label.EPSILON, g.left));

								// track decision if > 1 alts
								if ( grammar.getNumberOfAltsForDecisionNFA(g.left)>1 )
								{
									g.left.setDescription(grammar.grammarTreeToString(((GrammarAST)retval.start), false));
									g.left.setDecisionASTNode((b!=null?((GrammarAST)b.start):null));
									int d = grammar.assignDecisionNumber( g.left );
									grammar.setDecisionNFA( d, g.left );
									grammar.setDecisionBlockAST(d, (b!=null?((GrammarAST)b.start):null));
								}

								// hook to end of rule node
								NFAState end = thisR.stopState;
								g.right.addTransition(new Transition(Label.EPSILON,end));
							}
						}
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
	// $ANTLR end "rule"



	// $ANTLR start "modifier"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:266:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
	public final void modifier() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:267:2: ( 'protected' | 'public' | 'private' | 'fragment' )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:
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



	// $ANTLR start "throwsSpec"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:273:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
	public final void throwsSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:274:2: ( ^( 'throws' ( ID )+ ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:274:4: ^( 'throws' ( ID )+ )
			{
			match(input,THROWS,FOLLOW_THROWS_in_throwsSpec423); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:274:15: ( ID )+
			int cnt26=0;
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==ID) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:274:15: ID
					{
					match(input,ID,FOLLOW_ID_in_throwsSpec425); if (state.failed) return;
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
	// $ANTLR end "throwsSpec"



	// $ANTLR start "ruleScopeSpec"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:277:1: ruleScopeSpec : ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* ) ;
	public final void ruleScopeSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:278:2: ( ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:278:4: ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* )
			{
			match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec440); if (state.failed) return;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return;
				// org/antlr/grammar/v3/TreeToNFAConverter.g:278:15: ( ^( AMPERSAND ( . )* ) )*
				loop28:
				while (true) {
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==AMPERSAND) ) {
						alt28=1;
					}

					switch (alt28) {
					case 1 :
						// org/antlr/grammar/v3/TreeToNFAConverter.g:278:17: ^( AMPERSAND ( . )* )
						{
						match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleScopeSpec445); if (state.failed) return;
						if ( input.LA(1)==Token.DOWN ) {
							match(input, Token.DOWN, null); if (state.failed) return;
							// org/antlr/grammar/v3/TreeToNFAConverter.g:278:29: ( . )*
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
									// org/antlr/grammar/v3/TreeToNFAConverter.g:278:29: .
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

					default :
						break loop28;
					}
				}

				// org/antlr/grammar/v3/TreeToNFAConverter.g:278:36: ( ACTION )?
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==ACTION) ) {
					alt29=1;
				}
				switch (alt29) {
					case 1 :
						// org/antlr/grammar/v3/TreeToNFAConverter.g:278:37: ACTION
						{
						match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec455); if (state.failed) return;
						}
						break;

				}

				// org/antlr/grammar/v3/TreeToNFAConverter.g:278:46: ( ID )*
				loop30:
				while (true) {
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==ID) ) {
						alt30=1;
					}

					switch (alt30) {
					case 1 :
						// org/antlr/grammar/v3/TreeToNFAConverter.g:278:48: ID
						{
						match(input,ID,FOLLOW_ID_in_ruleScopeSpec461); if (state.failed) return;
						}
						break;

					default :
						break loop30;
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


	public static class block_return extends TreeRuleReturnScope {
		public StateCluster g = null;
	};


	// $ANTLR start "block"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:281:1: block returns [StateCluster g = null] : ({...}? => set | ^( BLOCK ( ^( OPTIONS ( . )* ) )? (a= alternative rewrite )+ EOB ) );
	public final TreeToNFAConverter.block_return block() throws RecognitionException {
		TreeToNFAConverter.block_return retval = new TreeToNFAConverter.block_return();
		retval.start = input.LT(1);

		StateCluster a =null;
		TreeRuleReturnScope set1 =null;


			List<StateCluster> alts = new ArrayList<StateCluster>();
			this.blockLevel++;
			if ( this.blockLevel==1 )
				this.outerAltNum=1;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:289:2: ({...}? => set | ^( BLOCK ( ^( OPTIONS ( . )* ) )? (a= alternative rewrite )+ EOB ) )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==BLOCK) ) {
				int LA34_1 = input.LA(2);
				if ( ((grammar.isValidSet(this,((GrammarAST)retval.start)) &&
						 !currentRuleName.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME))) ) {
					alt34=1;
				}
				else if ( (true) ) {
					alt34=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:289:4: {...}? => set
					{
					if ( !((grammar.isValidSet(this,((GrammarAST)retval.start)) &&
							 !currentRuleName.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME))) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "block", "grammar.isValidSet(this,$start) &&\n\t\t !currentRuleName.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME)");
					}
					pushFollow(FOLLOW_set_in_block492);
					set1=set();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (set1!=null?((TreeToNFAConverter.set_return)set1).g:null);}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:293:4: ^( BLOCK ( ^( OPTIONS ( . )* ) )? (a= alternative rewrite )+ EOB )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block502); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					// org/antlr/grammar/v3/TreeToNFAConverter.g:293:13: ( ^( OPTIONS ( . )* ) )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==OPTIONS) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:293:15: ^( OPTIONS ( . )* )
							{
							match(input,OPTIONS,FOLLOW_OPTIONS_in_block507); if (state.failed) return retval;
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); if (state.failed) return retval;
								// org/antlr/grammar/v3/TreeToNFAConverter.g:293:25: ( . )*
								loop31:
								while (true) {
									int alt31=2;
									int LA31_0 = input.LA(1);
									if ( ((LA31_0 >= ACTION && LA31_0 <= XDIGIT)) ) {
										alt31=1;
									}
									else if ( (LA31_0==UP) ) {
										alt31=2;
									}

									switch (alt31) {
									case 1 :
										// org/antlr/grammar/v3/TreeToNFAConverter.g:293:25: .
										{
										matchAny(input); if (state.failed) return retval;
										}
										break;

									default :
										break loop31;
									}
								}

								match(input, Token.UP, null); if (state.failed) return retval;
							}

							}
							break;

					}

					// org/antlr/grammar/v3/TreeToNFAConverter.g:294:4: (a= alternative rewrite )+
					int cnt33=0;
					loop33:
					while (true) {
						int alt33=2;
						int LA33_0 = input.LA(1);
						if ( (LA33_0==ALT) ) {
							alt33=1;
						}

						switch (alt33) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:294:6: a= alternative rewrite
							{
							pushFollow(FOLLOW_alternative_in_block523);
							a=alternative();
							state._fsp--;
							if (state.failed) return retval;
							pushFollow(FOLLOW_rewrite_in_block525);
							rewrite();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) {
												alts.add(a);
											}

												if ( blockLevel == 1 )
													outerAltNum++;
											
							}
							break;

						default :
							if ( cnt33 >= 1 ) break loop33;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(33, input);
							throw eee;
						}
						cnt33++;
					}

					match(input,EOB,FOLLOW_EOB_in_block548); if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) {retval.g = factory.build_AlternativeBlock(alts);}
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
			 blockLevel--; 
		}
		return retval;
	}
	// $ANTLR end "block"



	// $ANTLR start "alternative"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:309:1: alternative returns [StateCluster g=null] : ^( ALT (e= element )+ EOA ) ;
	public final StateCluster alternative() throws RecognitionException {
		StateCluster g = null;


		TreeRuleReturnScope e =null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:310:2: ( ^( ALT (e= element )+ EOA ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:310:4: ^( ALT (e= element )+ EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_alternative577); if (state.failed) return g;
			match(input, Token.DOWN, null); if (state.failed) return g;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:310:11: (e= element )+
			int cnt35=0;
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( (LA35_0==ACTION||(LA35_0 >= ASSIGN && LA35_0 <= BLOCK)||(LA35_0 >= CHAR_LITERAL && LA35_0 <= CHAR_RANGE)||LA35_0==CLOSURE||LA35_0==DOT||LA35_0==EPSILON||LA35_0==FORCED_ACTION||LA35_0==GATED_SEMPRED||LA35_0==NOT||LA35_0==OPTIONAL||(LA35_0 >= PLUS_ASSIGN && LA35_0 <= POSITIVE_CLOSURE)||LA35_0==RANGE||LA35_0==ROOT||LA35_0==RULE_REF||LA35_0==SEMPRED||(LA35_0 >= STRING_LITERAL && LA35_0 <= SYN_SEMPRED)||LA35_0==TOKEN_REF||LA35_0==TREE_BEGIN||LA35_0==WILDCARD) ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:310:12: e= element
					{
					pushFollow(FOLLOW_element_in_alternative582);
					e=element();
					state._fsp--;
					if (state.failed) return g;
					if ( state.backtracking==0 ) {g = factory.build_AB(g,(e!=null?((TreeToNFAConverter.element_return)e).g:null));}
					}
					break;

				default :
					if ( cnt35 >= 1 ) break loop35;
					if (state.backtracking>0) {state.failed=true; return g;}
					EarlyExitException eee = new EarlyExitException(35, input);
					throw eee;
				}
				cnt35++;
			}

			match(input,EOA,FOLLOW_EOA_in_alternative589); if (state.failed) return g;
			match(input, Token.UP, null); if (state.failed) return g;

			if ( state.backtracking==0 ) {
						if (g==null) { // if alt was a list of actions or whatever
							g = factory.build_Epsilon();
						}
						else {
							factory.optimizeAlternative(g);
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
		return g;
	}
	// $ANTLR end "alternative"



	// $ANTLR start "exceptionGroup"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:321:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
	public final void exceptionGroup() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:322:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==CATCH) ) {
				alt38=1;
			}
			else if ( (LA38_0==FINALLY) ) {
				alt38=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:322:4: ( exceptionHandler )+ ( finallyClause )?
					{
					// org/antlr/grammar/v3/TreeToNFAConverter.g:322:4: ( exceptionHandler )+
					int cnt36=0;
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==CATCH) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:322:6: exceptionHandler
							{
							pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup608);
							exceptionHandler();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt36 >= 1 ) break loop36;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(36, input);
							throw eee;
						}
						cnt36++;
					}

					// org/antlr/grammar/v3/TreeToNFAConverter.g:322:26: ( finallyClause )?
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==FINALLY) ) {
						alt37=1;
					}
					switch (alt37) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:322:27: finallyClause
							{
							pushFollow(FOLLOW_finallyClause_in_exceptionGroup614);
							finallyClause();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:323:4: finallyClause
					{
					pushFollow(FOLLOW_finallyClause_in_exceptionGroup621);
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
	// org/antlr/grammar/v3/TreeToNFAConverter.g:326:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
	public final void exceptionHandler() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:327:2: ( ^( 'catch' ARG_ACTION ACTION ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:327:7: ^( 'catch' ARG_ACTION ACTION )
			{
			match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler636); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler638); if (state.failed) return;
			match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler640); if (state.failed) return;
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
	// org/antlr/grammar/v3/TreeToNFAConverter.g:330:1: finallyClause : ^( 'finally' ACTION ) ;
	public final void finallyClause() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:331:2: ( ^( 'finally' ACTION ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:331:7: ^( 'finally' ACTION )
			{
			match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause656); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			match(input,ACTION,FOLLOW_ACTION_in_finallyClause658); if (state.failed) return;
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


	public static class rewrite_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "rewrite"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:334:1: rewrite : ( ^( REWRITES ( ^( REWRITE ( . )* ) )* ) |);
	public final TreeToNFAConverter.rewrite_return rewrite() throws RecognitionException {
		TreeToNFAConverter.rewrite_return retval = new TreeToNFAConverter.rewrite_return();
		retval.start = input.LT(1);

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:335:2: ( ^( REWRITES ( ^( REWRITE ( . )* ) )* ) |)
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==REWRITES) ) {
				alt41=1;
			}
			else if ( (LA41_0==ALT||LA41_0==EOB) ) {
				alt41=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:335:4: ^( REWRITES ( ^( REWRITE ( . )* ) )* )
					{
					match(input,REWRITES,FOLLOW_REWRITES_in_rewrite672); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:336:4: ( ^( REWRITE ( . )* ) )*
						loop40:
						while (true) {
							int alt40=2;
							int LA40_0 = input.LA(1);
							if ( (LA40_0==REWRITE) ) {
								alt40=1;
							}

							switch (alt40) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:337:5: ^( REWRITE ( . )* )
								{
								if ( state.backtracking==0 ) {
													if ( grammar.getOption("output")==null )
													{
														ErrorManager.grammarError(ErrorManager.MSG_REWRITE_OR_OP_WITH_NO_OUTPUT_OPTION,
																				  grammar, ((GrammarAST)retval.start).getToken(), currentRuleName);
													}
												}
								match(input,REWRITE,FOLLOW_REWRITE_in_rewrite690); if (state.failed) return retval;
								if ( input.LA(1)==Token.DOWN ) {
									match(input, Token.DOWN, null); if (state.failed) return retval;
									// org/antlr/grammar/v3/TreeToNFAConverter.g:344:15: ( . )*
									loop39:
									while (true) {
										int alt39=2;
										int LA39_0 = input.LA(1);
										if ( ((LA39_0 >= ACTION && LA39_0 <= XDIGIT)) ) {
											alt39=1;
										}
										else if ( (LA39_0==UP) ) {
											alt39=2;
										}

										switch (alt39) {
										case 1 :
											// org/antlr/grammar/v3/TreeToNFAConverter.g:344:15: .
											{
											matchAny(input); if (state.failed) return retval;
											}
											break;

										default :
											break loop39;
										}
									}

									match(input, Token.UP, null); if (state.failed) return retval;
								}

								}
								break;

							default :
								break loop40;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:348:2: 
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
		return retval;
	}
	// $ANTLR end "rewrite"


	public static class element_return extends TreeRuleReturnScope {
		public StateCluster g=null;
	};


	// $ANTLR start "element"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:350:1: element returns [StateCluster g=null] : ( ^( ROOT e= element ) | ^( BANG e= element ) | ^( ASSIGN ID e= element ) | ^( PLUS_ASSIGN ID e= element ) | ^( RANGE a= atom[null] b= atom[null] ) | ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL ) | atom_or_notatom | ebnf | tree_ | ^( SYNPRED block ) | ACTION | FORCED_ACTION |pred= SEMPRED |spred= SYN_SEMPRED | ^(bpred= BACKTRACK_SEMPRED ( . )* ) |gpred= GATED_SEMPRED | EPSILON );
	public final TreeToNFAConverter.element_return element() throws RecognitionException {
		TreeToNFAConverter.element_return retval = new TreeToNFAConverter.element_return();
		retval.start = input.LT(1);

		GrammarAST c1=null;
		GrammarAST c2=null;
		GrammarAST pred=null;
		GrammarAST spred=null;
		GrammarAST bpred=null;
		GrammarAST gpred=null;
		GrammarAST ACTION5=null;
		GrammarAST FORCED_ACTION6=null;
		TreeRuleReturnScope e =null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope b =null;
		StateCluster atom_or_notatom2 =null;
		TreeRuleReturnScope ebnf3 =null;
		TreeRuleReturnScope tree_4 =null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:351:2: ( ^( ROOT e= element ) | ^( BANG e= element ) | ^( ASSIGN ID e= element ) | ^( PLUS_ASSIGN ID e= element ) | ^( RANGE a= atom[null] b= atom[null] ) | ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL ) | atom_or_notatom | ebnf | tree_ | ^( SYNPRED block ) | ACTION | FORCED_ACTION |pred= SEMPRED |spred= SYN_SEMPRED | ^(bpred= BACKTRACK_SEMPRED ( . )* ) |gpred= GATED_SEMPRED | EPSILON )
			int alt43=17;
			switch ( input.LA(1) ) {
			case ROOT:
				{
				alt43=1;
				}
				break;
			case BANG:
				{
				alt43=2;
				}
				break;
			case ASSIGN:
				{
				alt43=3;
				}
				break;
			case PLUS_ASSIGN:
				{
				alt43=4;
				}
				break;
			case RANGE:
				{
				alt43=5;
				}
				break;
			case CHAR_RANGE:
				{
				alt43=6;
				}
				break;
			case CHAR_LITERAL:
			case DOT:
			case NOT:
			case RULE_REF:
			case STRING_LITERAL:
			case TOKEN_REF:
			case WILDCARD:
				{
				alt43=7;
				}
				break;
			case BLOCK:
			case CLOSURE:
			case OPTIONAL:
			case POSITIVE_CLOSURE:
				{
				alt43=8;
				}
				break;
			case TREE_BEGIN:
				{
				alt43=9;
				}
				break;
			case SYNPRED:
				{
				alt43=10;
				}
				break;
			case ACTION:
				{
				alt43=11;
				}
				break;
			case FORCED_ACTION:
				{
				alt43=12;
				}
				break;
			case SEMPRED:
				{
				alt43=13;
				}
				break;
			case SYN_SEMPRED:
				{
				alt43=14;
				}
				break;
			case BACKTRACK_SEMPRED:
				{
				alt43=15;
				}
				break;
			case GATED_SEMPRED:
				{
				alt43=16;
				}
				break;
			case EPSILON:
				{
				alt43=17;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}
			switch (alt43) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:351:6: ^( ROOT e= element )
					{
					match(input,ROOT,FOLLOW_ROOT_in_element725); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_element_in_element729);
					e=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (e!=null?((TreeToNFAConverter.element_return)e).g:null);}
					match(input, Token.UP, null); if (state.failed) return retval;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:352:6: ^( BANG e= element )
					{
					match(input,BANG,FOLLOW_BANG_in_element740); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_element_in_element744);
					e=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (e!=null?((TreeToNFAConverter.element_return)e).g:null);}
					match(input, Token.UP, null); if (state.failed) return retval;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:353:4: ^( ASSIGN ID e= element )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_element753); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					match(input,ID,FOLLOW_ID_in_element755); if (state.failed) return retval;
					pushFollow(FOLLOW_element_in_element759);
					e=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (e!=null?((TreeToNFAConverter.element_return)e).g:null);}
					match(input, Token.UP, null); if (state.failed) return retval;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:354:4: ^( PLUS_ASSIGN ID e= element )
					{
					match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element768); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					match(input,ID,FOLLOW_ID_in_element770); if (state.failed) return retval;
					pushFollow(FOLLOW_element_in_element774);
					e=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (e!=null?((TreeToNFAConverter.element_return)e).g:null);}
					match(input, Token.UP, null); if (state.failed) return retval;

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:355:6: ^( RANGE a= atom[null] b= atom[null] )
					{
					match(input,RANGE,FOLLOW_RANGE_in_element785); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_atom_in_element789);
					a=atom(null);
					state._fsp--;
					if (state.failed) return retval;
					pushFollow(FOLLOW_atom_in_element794);
					b=atom(null);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) {retval.g = factory.build_Range(grammar.getTokenType((a!=null?(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(a.start),input.getTreeAdaptor().getTokenStopIndex(a.start))):null)),
													 grammar.getTokenType((b!=null?(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(b.start),input.getTreeAdaptor().getTokenStopIndex(b.start))):null)));}
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:358:6: ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL )
					{
					match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_element808); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					c1=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_element812); if (state.failed) return retval;
					c2=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_element816); if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) {
							if ( grammar.type==Grammar.LEXER ) {
								retval.g = factory.build_CharRange((c1!=null?c1.getText():null), (c2!=null?c2.getText():null));
							}
							}
					}
					break;
				case 7 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:364:6: atom_or_notatom
					{
					pushFollow(FOLLOW_atom_or_notatom_in_element828);
					atom_or_notatom2=atom_or_notatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = atom_or_notatom2;}
					}
					break;
				case 8 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:365:6: ebnf
					{
					pushFollow(FOLLOW_ebnf_in_element837);
					ebnf3=ebnf();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (ebnf3!=null?((TreeToNFAConverter.ebnf_return)ebnf3).g:null);}
					}
					break;
				case 9 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:366:6: tree_
					{
					pushFollow(FOLLOW_tree__in_element846);
					tree_4=tree_();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (tree_4!=null?((TreeToNFAConverter.tree__return)tree_4).g:null);}
					}
					break;
				case 10 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:367:6: ^( SYNPRED block )
					{
					match(input,SYNPRED,FOLLOW_SYNPRED_in_element857); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_block_in_element859);
					block();
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					}
					break;
				case 11 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:368:6: ACTION
					{
					ACTION5=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element868); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = factory.build_Action(ACTION5);}
					}
					break;
				case 12 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:369:6: FORCED_ACTION
					{
					FORCED_ACTION6=(GrammarAST)match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element877); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = factory.build_Action(FORCED_ACTION6);}
					}
					break;
				case 13 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:370:6: pred= SEMPRED
					{
					pred=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element888); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = factory.build_SemanticPredicate(pred);}
					}
					break;
				case 14 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:371:6: spred= SYN_SEMPRED
					{
					spred=(GrammarAST)match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element899); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = factory.build_SemanticPredicate(spred);}
					}
					break;
				case 15 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:372:6: ^(bpred= BACKTRACK_SEMPRED ( . )* )
					{
					bpred=(GrammarAST)match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element911); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:372:32: ( . )*
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
								// org/antlr/grammar/v3/TreeToNFAConverter.g:372:32: .
								{
								matchAny(input); if (state.failed) return retval;
								}
								break;

							default :
								break loop42;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					if ( state.backtracking==0 ) {retval.g = factory.build_SemanticPredicate(bpred);}
					}
					break;
				case 16 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:373:6: gpred= GATED_SEMPRED
					{
					gpred=(GrammarAST)match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element926); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = factory.build_SemanticPredicate(gpred);}
					}
					break;
				case 17 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:374:6: EPSILON
					{
					match(input,EPSILON,FOLLOW_EPSILON_in_element935); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = factory.build_Epsilon();}
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
	// $ANTLR end "element"


	public static class ebnf_return extends TreeRuleReturnScope {
		public StateCluster g=null;
	};


	// $ANTLR start "ebnf"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:377:1: ebnf returns [StateCluster g=null] : ({...}? => set |b= block | ^( OPTIONAL b= block ) | ^( CLOSURE b= block ) | ^( POSITIVE_CLOSURE b= block ) );
	public final TreeToNFAConverter.ebnf_return ebnf() throws RecognitionException {
		TreeToNFAConverter.ebnf_return retval = new TreeToNFAConverter.ebnf_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope b =null;
		TreeRuleReturnScope set7 =null;


			GrammarAST blk = ((GrammarAST)retval.start);
			if (blk.getType() != BLOCK) {
				blk = (GrammarAST)blk.getChild(0);
			}
			GrammarAST eob = blk.getLastChild();

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:386:2: ({...}? => set |b= block | ^( OPTIONAL b= block ) | ^( CLOSURE b= block ) | ^( POSITIVE_CLOSURE b= block ) )
			int alt44=5;
			switch ( input.LA(1) ) {
			case BLOCK:
				{
				int LA44_1 = input.LA(2);
				if ( ((grammar.isValidSet(this,((GrammarAST)retval.start)))) ) {
					alt44=1;
				}
				else if ( (true) ) {
					alt44=2;
				}

				}
				break;
			case OPTIONAL:
				{
				alt44=3;
				}
				break;
			case CLOSURE:
				{
				alt44=4;
				}
				break;
			case POSITIVE_CLOSURE:
				{
				alt44=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}
			switch (alt44) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:386:4: {...}? => set
					{
					if ( !((grammar.isValidSet(this,((GrammarAST)retval.start)))) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "ebnf", "grammar.isValidSet(this,$start)");
					}
					pushFollow(FOLLOW_set_in_ebnf961);
					set7=set();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (set7!=null?((TreeToNFAConverter.set_return)set7).g:null);}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:388:4: b= block
					{
					pushFollow(FOLLOW_block_in_ebnf971);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								// track decision if > 1 alts
								if ( grammar.getNumberOfAltsForDecisionNFA((b!=null?((TreeToNFAConverter.block_return)b).g:null).left)>1 )
								{
									(b!=null?((TreeToNFAConverter.block_return)b).g:null).left.setDescription(grammar.grammarTreeToString(blk, false));
									(b!=null?((TreeToNFAConverter.block_return)b).g:null).left.setDecisionASTNode(blk);
									int d = grammar.assignDecisionNumber( (b!=null?((TreeToNFAConverter.block_return)b).g:null).left );
									grammar.setDecisionNFA( d, (b!=null?((TreeToNFAConverter.block_return)b).g:null).left );
									grammar.setDecisionBlockAST(d, blk);
								}
								retval.g = (b!=null?((TreeToNFAConverter.block_return)b).g:null);
							}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:401:4: ^( OPTIONAL b= block )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf982); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_block_in_ebnf986);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) {
								StateCluster bg = (b!=null?((TreeToNFAConverter.block_return)b).g:null);
								if ( blk.getSetValue()!=null )
								{
									// if block comes back SET not BLOCK, make it
									// a single ALT block
									bg = factory.build_AlternativeBlockFromSet(bg);
								}
								retval.g = factory.build_Aoptional(bg);
								retval.g.left.setDescription(grammar.grammarTreeToString(((GrammarAST)retval.start), false));
								// there is always at least one alt even if block has just 1 alt
								int d = grammar.assignDecisionNumber( retval.g.left );
								grammar.setDecisionNFA(d, retval.g.left);
								grammar.setDecisionBlockAST(d, blk);
								retval.g.left.setDecisionASTNode(((GrammarAST)retval.start));
							}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:418:4: ^( CLOSURE b= block )
					{
					match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf999); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_block_in_ebnf1003);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) {
								StateCluster bg = (b!=null?((TreeToNFAConverter.block_return)b).g:null);
								if ( blk.getSetValue()!=null )
								{
									bg = factory.build_AlternativeBlockFromSet(bg);
								}
								retval.g = factory.build_Astar(bg);
								// track the loop back / exit decision point
								bg.right.setDescription("()* loopback of "+grammar.grammarTreeToString(((GrammarAST)retval.start), false));
								int d = grammar.assignDecisionNumber( bg.right );
								grammar.setDecisionNFA(d, bg.right);
								grammar.setDecisionBlockAST(d, blk);
								bg.right.setDecisionASTNode(eob);
								// make block entry state also have same decision for interpreting grammar
								NFAState altBlockState = (NFAState)retval.g.left.transition(0).target;
								altBlockState.setDecisionASTNode(((GrammarAST)retval.start));
								altBlockState.setDecisionNumber(d);
								retval.g.left.setDecisionNumber(d); // this is the bypass decision (2 alts)
								retval.g.left.setDecisionASTNode(((GrammarAST)retval.start));
							}
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:439:4: ^( POSITIVE_CLOSURE b= block )
					{
					match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1016); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_block_in_ebnf1020);
					b=block();
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) {
								StateCluster bg = (b!=null?((TreeToNFAConverter.block_return)b).g:null);
								if ( blk.getSetValue()!=null )
								{
									bg = factory.build_AlternativeBlockFromSet(bg);
								}
								retval.g = factory.build_Aplus(bg);
								// don't make a decision on left edge, can reuse loop end decision
								// track the loop back / exit decision point
								bg.right.setDescription("()+ loopback of "+grammar.grammarTreeToString(((GrammarAST)retval.start), false));
								int d = grammar.assignDecisionNumber( bg.right );
								grammar.setDecisionNFA(d, bg.right);
								grammar.setDecisionBlockAST(d, blk);
								bg.right.setDecisionASTNode(eob);
								// make block entry state also have same decision for interpreting grammar
								NFAState altBlockState = (NFAState)retval.g.left.transition(0).target;
								altBlockState.setDecisionASTNode(((GrammarAST)retval.start));
								altBlockState.setDecisionNumber(d);
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
		return retval;
	}
	// $ANTLR end "ebnf"


	public static class tree__return extends TreeRuleReturnScope {
		public StateCluster g=null;
	};


	// $ANTLR start "tree_"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:461:1: tree_ returns [StateCluster g=null] : ^( TREE_BEGIN e= element (e= element )* ) ;
	public final TreeToNFAConverter.tree__return tree_() throws RecognitionException {
		TreeToNFAConverter.tree__return retval = new TreeToNFAConverter.tree__return();
		retval.start = input.LT(1);

		TreeRuleReturnScope e =null;


			StateCluster down=null, up=null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:466:2: ( ^( TREE_BEGIN e= element (e= element )* ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:466:4: ^( TREE_BEGIN e= element (e= element )* )
			{
			match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1048); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			pushFollow(FOLLOW_element_in_tree_1055);
			e=element();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) { retval.g = (e!=null?((TreeToNFAConverter.element_return)e).g:null); }
			if ( state.backtracking==0 ) {
							down = factory.build_Atom(Label.DOWN, (e!=null?((GrammarAST)e.start):null));
							// TODO set following states for imaginary nodes?
							//el.followingNFAState = down.right;
							retval.g = factory.build_AB(retval.g,down);
						}
			// org/antlr/grammar/v3/TreeToNFAConverter.g:474:4: (e= element )*
			loop45:
			while (true) {
				int alt45=2;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==ACTION||(LA45_0 >= ASSIGN && LA45_0 <= BLOCK)||(LA45_0 >= CHAR_LITERAL && LA45_0 <= CHAR_RANGE)||LA45_0==CLOSURE||LA45_0==DOT||LA45_0==EPSILON||LA45_0==FORCED_ACTION||LA45_0==GATED_SEMPRED||LA45_0==NOT||LA45_0==OPTIONAL||(LA45_0 >= PLUS_ASSIGN && LA45_0 <= POSITIVE_CLOSURE)||LA45_0==RANGE||LA45_0==ROOT||LA45_0==RULE_REF||LA45_0==SEMPRED||(LA45_0 >= STRING_LITERAL && LA45_0 <= SYN_SEMPRED)||LA45_0==TOKEN_REF||LA45_0==TREE_BEGIN||LA45_0==WILDCARD) ) {
					alt45=1;
				}

				switch (alt45) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:474:6: e= element
					{
					pushFollow(FOLLOW_element_in_tree_1071);
					e=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = factory.build_AB(retval.g,(e!=null?((TreeToNFAConverter.element_return)e).g:null));}
					}
					break;

				default :
					break loop45;
				}
			}

			if ( state.backtracking==0 ) {
							up = factory.build_Atom(Label.UP, (e!=null?((GrammarAST)e.start):null));
							//el.followingNFAState = up.right;
							retval.g = factory.build_AB(retval.g,up);
							// tree roots point at right edge of DOWN for LOOK computation later
							((GrammarAST)retval.start).NFATreeDownState = down.left;
						}
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
	// $ANTLR end "tree_"



	// $ANTLR start "atom_or_notatom"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:485:1: atom_or_notatom returns [StateCluster g=null] : ( atom[null] | ^(n= NOT (c= CHAR_LITERAL (ast1= ast_suffix )? |t= TOKEN_REF (ast3= ast_suffix )? | set ) ) );
	public final StateCluster atom_or_notatom() throws RecognitionException {
		StateCluster g = null;


		GrammarAST n=null;
		GrammarAST c=null;
		GrammarAST t=null;
		TreeRuleReturnScope atom8 =null;
		TreeRuleReturnScope set9 =null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:486:2: ( atom[null] | ^(n= NOT (c= CHAR_LITERAL (ast1= ast_suffix )? |t= TOKEN_REF (ast3= ast_suffix )? | set ) ) )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==CHAR_LITERAL||LA49_0==DOT||LA49_0==RULE_REF||LA49_0==STRING_LITERAL||LA49_0==TOKEN_REF||LA49_0==WILDCARD) ) {
				alt49=1;
			}
			else if ( (LA49_0==NOT) ) {
				alt49=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return g;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:486:4: atom[null]
					{
					pushFollow(FOLLOW_atom_in_atom_or_notatom1100);
					atom8=atom(null);
					state._fsp--;
					if (state.failed) return g;
					if ( state.backtracking==0 ) {g = (atom8!=null?((TreeToNFAConverter.atom_return)atom8).g:null);}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:487:4: ^(n= NOT (c= CHAR_LITERAL (ast1= ast_suffix )? |t= TOKEN_REF (ast3= ast_suffix )? | set ) )
					{
					n=(GrammarAST)match(input,NOT,FOLLOW_NOT_in_atom_or_notatom1112); if (state.failed) return g;
					match(input, Token.DOWN, null); if (state.failed) return g;
					// org/antlr/grammar/v3/TreeToNFAConverter.g:488:4: (c= CHAR_LITERAL (ast1= ast_suffix )? |t= TOKEN_REF (ast3= ast_suffix )? | set )
					int alt48=3;
					switch ( input.LA(1) ) {
					case CHAR_LITERAL:
						{
						alt48=1;
						}
						break;
					case TOKEN_REF:
						{
						alt48=2;
						}
						break;
					case BLOCK:
						{
						alt48=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return g;}
						NoViableAltException nvae =
							new NoViableAltException("", 48, 0, input);
						throw nvae;
					}
					switch (alt48) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:488:6: c= CHAR_LITERAL (ast1= ast_suffix )?
							{
							c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom_or_notatom1121); if (state.failed) return g;
							// org/antlr/grammar/v3/TreeToNFAConverter.g:488:21: (ast1= ast_suffix )?
							int alt46=2;
							int LA46_0 = input.LA(1);
							if ( (LA46_0==BANG||LA46_0==ROOT) ) {
								alt46=1;
							}
							switch (alt46) {
								case 1 :
									// org/antlr/grammar/v3/TreeToNFAConverter.g:488:22: ast1= ast_suffix
									{
									pushFollow(FOLLOW_ast_suffix_in_atom_or_notatom1126);
									ast_suffix();
									state._fsp--;
									if (state.failed) return g;
									}
									break;

							}

							if ( state.backtracking==0 ) {
												int ttype=0;
												if ( grammar.type==Grammar.LEXER )
												{
													ttype = Grammar.getCharValueFromGrammarCharLiteral((c!=null?c.getText():null));
												}
												else
												{
													ttype = grammar.getTokenType((c!=null?c.getText():null));
												}
												IntSet notAtom = grammar.complement(ttype);
												if ( notAtom.isNil() )
												{
													ErrorManager.grammarError(
														ErrorManager.MSG_EMPTY_COMPLEMENT,
														grammar,
														c.getToken(),
														(c!=null?c.getText():null));
												}
												g =factory.build_Set(notAtom,n);
											}
							}
							break;
						case 2 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:510:6: t= TOKEN_REF (ast3= ast_suffix )?
							{
							t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom_or_notatom1143); if (state.failed) return g;
							// org/antlr/grammar/v3/TreeToNFAConverter.g:510:18: (ast3= ast_suffix )?
							int alt47=2;
							int LA47_0 = input.LA(1);
							if ( (LA47_0==BANG||LA47_0==ROOT) ) {
								alt47=1;
							}
							switch (alt47) {
								case 1 :
									// org/antlr/grammar/v3/TreeToNFAConverter.g:510:19: ast3= ast_suffix
									{
									pushFollow(FOLLOW_ast_suffix_in_atom_or_notatom1148);
									ast_suffix();
									state._fsp--;
									if (state.failed) return g;
									}
									break;

							}

							if ( state.backtracking==0 ) {
												int ttype=0;
												IntSet notAtom = null;
												if ( grammar.type==Grammar.LEXER )
												{
													notAtom = grammar.getSetFromRule(this,(t!=null?t.getText():null));
													if ( notAtom==null )
													{
														ErrorManager.grammarError(
															ErrorManager.MSG_RULE_INVALID_SET,
															grammar,
															t.getToken(),
															(t!=null?t.getText():null));
													}
													else
													{
														notAtom = grammar.complement(notAtom);
													}
												}
												else
												{
													ttype = grammar.getTokenType((t!=null?t.getText():null));
													notAtom = grammar.complement(ttype);
												}
												if ( notAtom==null || notAtom.isNil() )
												{
													ErrorManager.grammarError(
														ErrorManager.MSG_EMPTY_COMPLEMENT,
														grammar,
														t.getToken(),
														(t!=null?t.getText():null));
												}
												g =factory.build_Set(notAtom,n);
											}
							}
							break;
						case 3 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:545:6: set
							{
							pushFollow(FOLLOW_set_in_atom_or_notatom1163);
							set9=set();
							state._fsp--;
							if (state.failed) return g;
							if ( state.backtracking==0 ) {g = (set9!=null?((TreeToNFAConverter.set_return)set9).g:null);}
							if ( state.backtracking==0 ) {
												GrammarAST stNode = (GrammarAST)n.getChild(0);
												//IntSet notSet = grammar.complement(stNode.getSetValue());
												// let code generator complement the sets
												IntSet s = stNode.getSetValue();
												stNode.setSetValue(s);
												// let code gen do the complement again; here we compute
												// for NFA construction
												s = grammar.complement(s);
												if ( s.isNil() )
												{
													ErrorManager.grammarError(
														ErrorManager.MSG_EMPTY_COMPLEMENT,
														grammar,
														n.getToken());
												}
												g =factory.build_Set(s,n);
											}
							}
							break;

					}

					if ( state.backtracking==0 ) {n.followingNFAState = g.right;}
					match(input, Token.UP, null); if (state.failed) return g;

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
		return g;
	}
	// $ANTLR end "atom_or_notatom"


	public static class atom_return extends TreeRuleReturnScope {
		public StateCluster g=null;
	};


	// $ANTLR start "atom"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:569:1: atom[String scopeName] returns [StateCluster g=null] : ( ^(r= RULE_REF (rarg= ARG_ACTION )? (as1= ast_suffix )? ) | ^(t= TOKEN_REF (targ= ARG_ACTION )? (as2= ast_suffix )? ) | ^(c= CHAR_LITERAL (as3= ast_suffix )? ) | ^(s= STRING_LITERAL (as4= ast_suffix )? ) | ^(w= WILDCARD (as5= ast_suffix )? ) | ^( DOT scope_= ID a= atom[$scope_.text] ) );
	public final TreeToNFAConverter.atom_return atom(String scopeName) throws RecognitionException {
		TreeToNFAConverter.atom_return retval = new TreeToNFAConverter.atom_return();
		retval.start = input.LT(1);

		GrammarAST r=null;
		GrammarAST rarg=null;
		GrammarAST t=null;
		GrammarAST targ=null;
		GrammarAST c=null;
		GrammarAST s=null;
		GrammarAST w=null;
		GrammarAST scope_=null;
		TreeRuleReturnScope a =null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:570:2: ( ^(r= RULE_REF (rarg= ARG_ACTION )? (as1= ast_suffix )? ) | ^(t= TOKEN_REF (targ= ARG_ACTION )? (as2= ast_suffix )? ) | ^(c= CHAR_LITERAL (as3= ast_suffix )? ) | ^(s= STRING_LITERAL (as4= ast_suffix )? ) | ^(w= WILDCARD (as5= ast_suffix )? ) | ^( DOT scope_= ID a= atom[$scope_.text] ) )
			int alt57=6;
			switch ( input.LA(1) ) {
			case RULE_REF:
				{
				alt57=1;
				}
				break;
			case TOKEN_REF:
				{
				alt57=2;
				}
				break;
			case CHAR_LITERAL:
				{
				alt57=3;
				}
				break;
			case STRING_LITERAL:
				{
				alt57=4;
				}
				break;
			case WILDCARD:
				{
				alt57=5;
				}
				break;
			case DOT:
				{
				alt57=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}
			switch (alt57) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:570:4: ^(r= RULE_REF (rarg= ARG_ACTION )? (as1= ast_suffix )? )
					{
					r=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1205); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:570:18: (rarg= ARG_ACTION )?
						int alt50=2;
						int LA50_0 = input.LA(1);
						if ( (LA50_0==ARG_ACTION) ) {
							alt50=1;
						}
						switch (alt50) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:570:19: rarg= ARG_ACTION
								{
								rarg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1210); if (state.failed) return retval;
								}
								break;

						}

						// org/antlr/grammar/v3/TreeToNFAConverter.g:570:37: (as1= ast_suffix )?
						int alt51=2;
						int LA51_0 = input.LA(1);
						if ( (LA51_0==BANG||LA51_0==ROOT) ) {
							alt51=1;
						}
						switch (alt51) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:570:38: as1= ast_suffix
								{
								pushFollow(FOLLOW_ast_suffix_in_atom1217);
								ast_suffix();
								state._fsp--;
								if (state.failed) return retval;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					if ( state.backtracking==0 ) {
								NFAState start = grammar.getRuleStartState(scopeName,(r!=null?r.getText():null));
								if ( start!=null )
								{
									Rule rr = grammar.getRule(scopeName,(r!=null?r.getText():null));
									retval.g = factory.build_RuleRef(rr, start);
									r.followingNFAState = retval.g.right;
									r.NFAStartState = retval.g.left;
									if ( retval.g.left.transition(0) instanceof RuleClosureTransition
										&& grammar.type!=Grammar.LEXER )
									{
										addFollowTransition((r!=null?r.getText():null), retval.g.right);
									}
									// else rule ref got inlined to a set
								}
							}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:588:4: ^(t= TOKEN_REF (targ= ARG_ACTION )? (as2= ast_suffix )? )
					{
					t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1235); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:588:20: (targ= ARG_ACTION )?
						int alt52=2;
						int LA52_0 = input.LA(1);
						if ( (LA52_0==ARG_ACTION) ) {
							alt52=1;
						}
						switch (alt52) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:588:21: targ= ARG_ACTION
								{
								targ=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1241); if (state.failed) return retval;
								}
								break;

						}

						// org/antlr/grammar/v3/TreeToNFAConverter.g:588:39: (as2= ast_suffix )?
						int alt53=2;
						int LA53_0 = input.LA(1);
						if ( (LA53_0==BANG||LA53_0==ROOT) ) {
							alt53=1;
						}
						switch (alt53) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:588:40: as2= ast_suffix
								{
								pushFollow(FOLLOW_ast_suffix_in_atom1248);
								ast_suffix();
								state._fsp--;
								if (state.failed) return retval;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					if ( state.backtracking==0 ) {
								if ( grammar.type==Grammar.LEXER )
								{
									NFAState start = grammar.getRuleStartState(scopeName,(t!=null?t.getText():null));
									if ( start!=null )
									{
										Rule rr = grammar.getRule(scopeName,t.getText());
										retval.g = factory.build_RuleRef(rr, start);
										t.NFAStartState = retval.g.left;
										// don't add FOLLOW transitions in the lexer;
										// only exact context should be used.
									}
								}
								else
								{
									retval.g = factory.build_Atom(t);
									t.followingNFAState = retval.g.right;
								}
							}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:609:4: ^(c= CHAR_LITERAL (as3= ast_suffix )? )
					{
					c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1266); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:609:23: (as3= ast_suffix )?
						int alt54=2;
						int LA54_0 = input.LA(1);
						if ( (LA54_0==BANG||LA54_0==ROOT) ) {
							alt54=1;
						}
						switch (alt54) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:609:24: as3= ast_suffix
								{
								pushFollow(FOLLOW_ast_suffix_in_atom1272);
								ast_suffix();
								state._fsp--;
								if (state.failed) return retval;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					if ( state.backtracking==0 ) {
								if ( grammar.type==Grammar.LEXER )
								{
									retval.g = factory.build_CharLiteralAtom(c);
								}
								else
								{
									retval.g = factory.build_Atom(c);
									c.followingNFAState = retval.g.right;
								}
							}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:622:4: ^(s= STRING_LITERAL (as4= ast_suffix )? )
					{
					s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1290); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:622:25: (as4= ast_suffix )?
						int alt55=2;
						int LA55_0 = input.LA(1);
						if ( (LA55_0==BANG||LA55_0==ROOT) ) {
							alt55=1;
						}
						switch (alt55) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:622:26: as4= ast_suffix
								{
								pushFollow(FOLLOW_ast_suffix_in_atom1296);
								ast_suffix();
								state._fsp--;
								if (state.failed) return retval;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					if ( state.backtracking==0 ) {
								if ( grammar.type==Grammar.LEXER )
								{
									retval.g = factory.build_StringLiteralAtom(s);
								}
								else
								{
									retval.g = factory.build_Atom(s);
									s.followingNFAState = retval.g.right;
								}
							}
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:635:4: ^(w= WILDCARD (as5= ast_suffix )? )
					{
					w=(GrammarAST)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1314); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:635:18: (as5= ast_suffix )?
						int alt56=2;
						int LA56_0 = input.LA(1);
						if ( (LA56_0==BANG||LA56_0==ROOT) ) {
							alt56=1;
						}
						switch (alt56) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:635:19: as5= ast_suffix
								{
								pushFollow(FOLLOW_ast_suffix_in_atom1319);
								ast_suffix();
								state._fsp--;
								if (state.failed) return retval;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					if ( state.backtracking==0 ) {
									if ( nfa.grammar.type == Grammar.TREE_PARSER
										&& (w.getChildIndex() > 0 || w.getParent().getChild(1).getType() == EOA) )
									{
										retval.g = factory.build_WildcardTree( w );
									}
									else
									{
										retval.g = factory.build_Wildcard( w );
									}
								}
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:648:4: ^( DOT scope_= ID a= atom[$scope_.text] )
					{
					match(input,DOT,FOLLOW_DOT_in_atom1336); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					scope_=(GrammarAST)match(input,ID,FOLLOW_ID_in_atom1340); if (state.failed) return retval;
					pushFollow(FOLLOW_atom_in_atom1344);
					a=atom((scope_!=null?scope_.getText():null));
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.g = (a!=null?((TreeToNFAConverter.atom_return)a).g:null);}
					match(input, Token.UP, null); if (state.failed) return retval;

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
	// $ANTLR end "atom"



	// $ANTLR start "ast_suffix"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:651:1: ast_suffix : ( ROOT | BANG );
	public final void ast_suffix() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:652:2: ( ROOT | BANG )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:
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


	public static class set_return extends TreeRuleReturnScope {
		public StateCluster g=null;
	};


	// $ANTLR start "set"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:656:1: set returns [StateCluster g=null] : ^(b= BLOCK ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? setElement[elements] EOA ) )+ EOB ) ;
	public final TreeToNFAConverter.set_return set() throws RecognitionException {
		TreeToNFAConverter.set_return retval = new TreeToNFAConverter.set_return();
		retval.start = input.LT(1);

		GrammarAST b=null;


			IntSet elements=new IntervalSet();
			if ( state.backtracking == 0 )
				((GrammarAST)retval.start).setSetValue(elements); // track set for use by code gen

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:663:2: ( ^(b= BLOCK ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? setElement[elements] EOA ) )+ EOB ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:663:4: ^(b= BLOCK ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? setElement[elements] EOA ) )+ EOB )
			{
			b=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_set1390); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:664:6: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? setElement[elements] EOA ) )+
			int cnt60=0;
			loop60:
			while (true) {
				int alt60=2;
				int LA60_0 = input.LA(1);
				if ( (LA60_0==ALT) ) {
					alt60=1;
				}

				switch (alt60) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:664:7: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? setElement[elements] EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_set1399); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					// org/antlr/grammar/v3/TreeToNFAConverter.g:664:13: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
					int alt59=2;
					int LA59_0 = input.LA(1);
					if ( (LA59_0==BACKTRACK_SEMPRED) ) {
						alt59=1;
					}
					switch (alt59) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:664:15: ^( BACKTRACK_SEMPRED ( . )* )
							{
							match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_set1404); if (state.failed) return retval;
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); if (state.failed) return retval;
								// org/antlr/grammar/v3/TreeToNFAConverter.g:664:35: ( . )*
								loop58:
								while (true) {
									int alt58=2;
									int LA58_0 = input.LA(1);
									if ( ((LA58_0 >= ACTION && LA58_0 <= XDIGIT)) ) {
										alt58=1;
									}
									else if ( (LA58_0==UP) ) {
										alt58=2;
									}

									switch (alt58) {
									case 1 :
										// org/antlr/grammar/v3/TreeToNFAConverter.g:664:35: .
										{
										matchAny(input); if (state.failed) return retval;
										}
										break;

									default :
										break loop58;
									}
								}

								match(input, Token.UP, null); if (state.failed) return retval;
							}

							}
							break;

					}

					pushFollow(FOLLOW_setElement_in_set1413);
					setElement(elements);
					state._fsp--;
					if (state.failed) return retval;
					match(input,EOA,FOLLOW_EOA_in_set1416); if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					}
					break;

				default :
					if ( cnt60 >= 1 ) break loop60;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(60, input);
					throw eee;
				}
				cnt60++;
			}

			match(input,EOB,FOLLOW_EOB_in_set1426); if (state.failed) return retval;
			match(input, Token.UP, null); if (state.failed) return retval;

			if ( state.backtracking==0 ) {
					retval.g = factory.build_Set(elements,b);
					b.followingNFAState = retval.g.right;
					b.setSetValue(elements); // track set value of this block
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
		return retval;
	}
	// $ANTLR end "set"



	// $ANTLR start "setRule"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:675:1: setRule returns [IntSet elements=new IntervalSet()] : ^( RULE id= ID ( modifier )? ARG RET ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ^( BLOCK ( ^( OPTIONS ( . )* ) )? ( ^( ALT ( BACKTRACK_SEMPRED )? setElement[elements] EOA ) )+ EOB ) ( exceptionGroup )? EOR ) ;
	public final IntSet setRule() throws RecognitionException {
		IntSet elements = new IntervalSet();


		GrammarAST id=null;


			IntSet s=null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:680:2: ( ^( RULE id= ID ( modifier )? ARG RET ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ^( BLOCK ( ^( OPTIONS ( . )* ) )? ( ^( ALT ( BACKTRACK_SEMPRED )? setElement[elements] EOA ) )+ EOB ) ( exceptionGroup )? EOR ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:680:4: ^( RULE id= ID ( modifier )? ARG RET ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ^( BLOCK ( ^( OPTIONS ( . )* ) )? ( ^( ALT ( BACKTRACK_SEMPRED )? setElement[elements] EOA ) )+ EOB ) ( exceptionGroup )? EOR )
			{
			match(input,RULE,FOLLOW_RULE_in_setRule1460); if (state.failed) return elements;
			match(input, Token.DOWN, null); if (state.failed) return elements;
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_setRule1464); if (state.failed) return elements;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:680:18: ( modifier )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==FRAGMENT||(LA61_0 >= PRIVATE && LA61_0 <= PUBLIC)) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:680:19: modifier
					{
					pushFollow(FOLLOW_modifier_in_setRule1467);
					modifier();
					state._fsp--;
					if (state.failed) return elements;
					}
					break;

			}

			match(input,ARG,FOLLOW_ARG_in_setRule1471); if (state.failed) return elements;
			match(input,RET,FOLLOW_RET_in_setRule1473); if (state.failed) return elements;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:680:38: ( ^( OPTIONS ( . )* ) )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==OPTIONS) ) {
				alt63=1;
			}
			switch (alt63) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:680:40: ^( OPTIONS ( . )* )
					{
					match(input,OPTIONS,FOLLOW_OPTIONS_in_setRule1478); if (state.failed) return elements;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return elements;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:680:50: ( . )*
						loop62:
						while (true) {
							int alt62=2;
							int LA62_0 = input.LA(1);
							if ( ((LA62_0 >= ACTION && LA62_0 <= XDIGIT)) ) {
								alt62=1;
							}
							else if ( (LA62_0==UP) ) {
								alt62=2;
							}

							switch (alt62) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:680:50: .
								{
								matchAny(input); if (state.failed) return elements;
								}
								break;

							default :
								break loop62;
							}
						}

						match(input, Token.UP, null); if (state.failed) return elements;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:680:57: ( ruleScopeSpec )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==SCOPE) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:680:59: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_setRule1489);
					ruleScopeSpec();
					state._fsp--;
					if (state.failed) return elements;
					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:681:4: ( ^( AMPERSAND ( . )* ) )*
			loop66:
			while (true) {
				int alt66=2;
				int LA66_0 = input.LA(1);
				if ( (LA66_0==AMPERSAND) ) {
					alt66=1;
				}

				switch (alt66) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:681:6: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_setRule1500); if (state.failed) return elements;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return elements;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:681:18: ( . )*
						loop65:
						while (true) {
							int alt65=2;
							int LA65_0 = input.LA(1);
							if ( ((LA65_0 >= ACTION && LA65_0 <= XDIGIT)) ) {
								alt65=1;
							}
							else if ( (LA65_0==UP) ) {
								alt65=2;
							}

							switch (alt65) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:681:18: .
								{
								matchAny(input); if (state.failed) return elements;
								}
								break;

							default :
								break loop65;
							}
						}

						match(input, Token.UP, null); if (state.failed) return elements;
					}

					}
					break;

				default :
					break loop66;
				}
			}

			match(input,BLOCK,FOLLOW_BLOCK_in_setRule1514); if (state.failed) return elements;
			match(input, Token.DOWN, null); if (state.failed) return elements;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:682:13: ( ^( OPTIONS ( . )* ) )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==OPTIONS) ) {
				alt68=1;
			}
			switch (alt68) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:682:15: ^( OPTIONS ( . )* )
					{
					match(input,OPTIONS,FOLLOW_OPTIONS_in_setRule1519); if (state.failed) return elements;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return elements;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:682:25: ( . )*
						loop67:
						while (true) {
							int alt67=2;
							int LA67_0 = input.LA(1);
							if ( ((LA67_0 >= ACTION && LA67_0 <= XDIGIT)) ) {
								alt67=1;
							}
							else if ( (LA67_0==UP) ) {
								alt67=2;
							}

							switch (alt67) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:682:25: .
								{
								matchAny(input); if (state.failed) return elements;
								}
								break;

							default :
								break loop67;
							}
						}

						match(input, Token.UP, null); if (state.failed) return elements;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:683:7: ( ^( ALT ( BACKTRACK_SEMPRED )? setElement[elements] EOA ) )+
			int cnt70=0;
			loop70:
			while (true) {
				int alt70=2;
				int LA70_0 = input.LA(1);
				if ( (LA70_0==ALT) ) {
					alt70=1;
				}

				switch (alt70) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:683:9: ^( ALT ( BACKTRACK_SEMPRED )? setElement[elements] EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_setRule1537); if (state.failed) return elements;
					match(input, Token.DOWN, null); if (state.failed) return elements;
					// org/antlr/grammar/v3/TreeToNFAConverter.g:683:15: ( BACKTRACK_SEMPRED )?
					int alt69=2;
					int LA69_0 = input.LA(1);
					if ( (LA69_0==BACKTRACK_SEMPRED) ) {
						alt69=1;
					}
					switch (alt69) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:683:16: BACKTRACK_SEMPRED
							{
							match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_setRule1540); if (state.failed) return elements;
							}
							break;

					}

					pushFollow(FOLLOW_setElement_in_setRule1544);
					setElement(elements);
					state._fsp--;
					if (state.failed) return elements;
					match(input,EOA,FOLLOW_EOA_in_setRule1547); if (state.failed) return elements;
					match(input, Token.UP, null); if (state.failed) return elements;

					}
					break;

				default :
					if ( cnt70 >= 1 ) break loop70;
					if (state.backtracking>0) {state.failed=true; return elements;}
					EarlyExitException eee = new EarlyExitException(70, input);
					throw eee;
				}
				cnt70++;
			}

			match(input,EOB,FOLLOW_EOB_in_setRule1559); if (state.failed) return elements;
			match(input, Token.UP, null); if (state.failed) return elements;

			// org/antlr/grammar/v3/TreeToNFAConverter.g:686:4: ( exceptionGroup )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==CATCH||LA71_0==FINALLY) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:686:5: exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_setRule1571);
					exceptionGroup();
					state._fsp--;
					if (state.failed) return elements;
					}
					break;

			}

			match(input,EOR,FOLLOW_EOR_in_setRule1578); if (state.failed) return elements;
			match(input, Token.UP, null); if (state.failed) return elements;

			}

		}
		catch (RecognitionException re) {
			 throw re; 
		}

		finally {
			// do for sure before leaving
		}
		return elements;
	}
	// $ANTLR end "setRule"



	// $ANTLR start "setElement"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:692:1: setElement[IntSet elements] : (c= CHAR_LITERAL |t= TOKEN_REF |s= STRING_LITERAL | ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL ) |gset= set | ^( NOT setElement[ns] ) );
	public final void setElement(IntSet elements) throws RecognitionException {
		GrammarAST c=null;
		GrammarAST t=null;
		GrammarAST s=null;
		GrammarAST c1=null;
		GrammarAST c2=null;
		TreeRuleReturnScope gset =null;


			int ttype;
			IntSet ns=null;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:698:2: (c= CHAR_LITERAL |t= TOKEN_REF |s= STRING_LITERAL | ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL ) |gset= set | ^( NOT setElement[ns] ) )
			int alt72=6;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				alt72=1;
				}
				break;
			case TOKEN_REF:
				{
				alt72=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt72=3;
				}
				break;
			case CHAR_RANGE:
				{
				alt72=4;
				}
				break;
			case BLOCK:
				{
				alt72=5;
				}
				break;
			case NOT:
				{
				alt72=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}
			switch (alt72) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:698:4: c= CHAR_LITERAL
					{
					c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1607); if (state.failed) return;
					if ( state.backtracking==0 ) {
								if ( grammar.type==Grammar.LEXER )
								{
									ttype = Grammar.getCharValueFromGrammarCharLiteral((c!=null?c.getText():null));
								}
								else
								{
									ttype = grammar.getTokenType((c!=null?c.getText():null));
								}
								if ( elements.member(ttype) )
								{
									ErrorManager.grammarError(
										ErrorManager.MSG_DUPLICATE_SET_ENTRY,
										grammar,
										c.getToken(),
										(c!=null?c.getText():null));
								}
								elements.add(ttype);
							}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:718:4: t= TOKEN_REF
					{
					t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_setElement1618); if (state.failed) return;
					if ( state.backtracking==0 ) {
								if ( grammar.type==Grammar.LEXER )
								{
									// recursively will invoke this rule to match elements in target rule ref
									IntSet ruleSet = grammar.getSetFromRule(this,(t!=null?t.getText():null));
									if ( ruleSet==null )
									{
										ErrorManager.grammarError(
											ErrorManager.MSG_RULE_INVALID_SET,
											grammar,
											t.getToken(),
											(t!=null?t.getText():null));
									}
									else
									{
										elements.addAll(ruleSet);
									}
								}
								else
								{
									ttype = grammar.getTokenType((t!=null?t.getText():null));
									if ( elements.member(ttype) )
									{
										ErrorManager.grammarError(
											ErrorManager.MSG_DUPLICATE_SET_ENTRY,
											grammar,
											t.getToken(),
											(t!=null?t.getText():null));
									}
									elements.add(ttype);
								}
							}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:752:4: s= STRING_LITERAL
					{
					s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement1630); if (state.failed) return;
					if ( state.backtracking==0 ) {
								ttype = grammar.getTokenType((s!=null?s.getText():null));
								if ( elements.member(ttype) )
								{
									ErrorManager.grammarError(
										ErrorManager.MSG_DUPLICATE_SET_ENTRY,
										grammar,
										s.getToken(),
										(s!=null?s.getText():null));
								}
								elements.add(ttype);
							}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:765:4: ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL )
					{
					match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_setElement1640); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					c1=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1644); if (state.failed) return;
					c2=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1648); if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					if ( state.backtracking==0 ) {
								if ( grammar.type==Grammar.LEXER )
								{
									int a = Grammar.getCharValueFromGrammarCharLiteral((c1!=null?c1.getText():null));
									int b = Grammar.getCharValueFromGrammarCharLiteral((c2!=null?c2.getText():null));
									elements.addAll(IntervalSet.of(a,b));
								}
							}
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:775:4: gset= set
					{
					pushFollow(FOLLOW_set_in_setElement1661);
					gset=set();
					state._fsp--;
					if (state.failed) return;
					if ( state.backtracking==0 ) {
								Transition setTrans = (gset!=null?((TreeToNFAConverter.set_return)gset).g:null).left.transition(0);
								elements.addAll(setTrans.label.getSet());
							}
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:781:4: ^( NOT setElement[ns] )
					{
					match(input,NOT,FOLLOW_NOT_in_setElement1673); if (state.failed) return;
					if ( state.backtracking==0 ) {ns=new IntervalSet();}
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_setElement_in_setElement1680);
					setElement(ns);
					state._fsp--;
					if (state.failed) return;
					if ( state.backtracking==0 ) {
									IntSet not = grammar.complement(ns);
									elements.addAll(not);
								}
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
	// $ANTLR end "setElement"



	// $ANTLR start "testBlockAsSet"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:797:1: testBlockAsSet returns [int alts=0] options {backtrack=true; } : ^( BLOCK ( ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA ) )+ EOB ) ;
	public final int testBlockAsSet() throws RecognitionException {
		int alts = 0;


		int testSetElement10 =0;


			inTest++;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:803:2: ( ^( BLOCK ( ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA ) )+ EOB ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:803:4: ^( BLOCK ( ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA ) )+ EOB )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_testBlockAsSet1725); if (state.failed) return alts;
			match(input, Token.DOWN, null); if (state.failed) return alts;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:804:4: ( ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA ) )+
			int cnt74=0;
			loop74:
			while (true) {
				int alt74=2;
				int LA74_0 = input.LA(1);
				if ( (LA74_0==ALT) ) {
					alt74=1;
				}

				switch (alt74) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:804:6: ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_testBlockAsSet1733); if (state.failed) return alts;
					match(input, Token.DOWN, null); if (state.failed) return alts;
					// org/antlr/grammar/v3/TreeToNFAConverter.g:804:12: ( BACKTRACK_SEMPRED )?
					int alt73=2;
					int LA73_0 = input.LA(1);
					if ( (LA73_0==BACKTRACK_SEMPRED) ) {
						alt73=1;
					}
					switch (alt73) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:804:13: BACKTRACK_SEMPRED
							{
							match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_testBlockAsSet1736); if (state.failed) return alts;
							}
							break;

					}

					pushFollow(FOLLOW_testSetElement_in_testBlockAsSet1740);
					testSetElement10=testSetElement();
					state._fsp--;
					if (state.failed) return alts;
					alts += testSetElement10;
					match(input,EOA,FOLLOW_EOA_in_testBlockAsSet1744); if (state.failed) return alts;
					match(input, Token.UP, null); if (state.failed) return alts;

					}
					break;

				default :
					if ( cnt74 >= 1 ) break loop74;
					if (state.backtracking>0) {state.failed=true; return alts;}
					EarlyExitException eee = new EarlyExitException(74, input);
					throw eee;
				}
				cnt74++;
			}

			match(input,EOB,FOLLOW_EOB_in_testBlockAsSet1756); if (state.failed) return alts;
			match(input, Token.UP, null); if (state.failed) return alts;

			}

		}
		catch (RecognitionException re) {
			 throw re; 
		}

		finally {
			// do for sure before leaving
			 inTest--; 
		}
		return alts;
	}
	// $ANTLR end "testBlockAsSet"



	// $ANTLR start "testSetRule"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:812:1: testSetRule returns [int alts=0] : ^( RULE id= ID ( modifier )? ARG RET ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ^( BLOCK ( ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA ) )+ EOB ) ( exceptionGroup )? EOR ) ;
	public final int testSetRule() throws RecognitionException {
		int alts = 0;


		GrammarAST id=null;
		int testSetElement11 =0;


			inTest++;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:817:2: ( ^( RULE id= ID ( modifier )? ARG RET ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ^( BLOCK ( ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA ) )+ EOB ) ( exceptionGroup )? EOR ) )
			// org/antlr/grammar/v3/TreeToNFAConverter.g:817:4: ^( RULE id= ID ( modifier )? ARG RET ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ^( BLOCK ( ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA ) )+ EOB ) ( exceptionGroup )? EOR )
			{
			match(input,RULE,FOLLOW_RULE_in_testSetRule1791); if (state.failed) return alts;
			match(input, Token.DOWN, null); if (state.failed) return alts;
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_testSetRule1795); if (state.failed) return alts;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:817:18: ( modifier )?
			int alt75=2;
			int LA75_0 = input.LA(1);
			if ( (LA75_0==FRAGMENT||(LA75_0 >= PRIVATE && LA75_0 <= PUBLIC)) ) {
				alt75=1;
			}
			switch (alt75) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:817:19: modifier
					{
					pushFollow(FOLLOW_modifier_in_testSetRule1798);
					modifier();
					state._fsp--;
					if (state.failed) return alts;
					}
					break;

			}

			match(input,ARG,FOLLOW_ARG_in_testSetRule1802); if (state.failed) return alts;
			match(input,RET,FOLLOW_RET_in_testSetRule1804); if (state.failed) return alts;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:817:38: ( ^( OPTIONS ( . )* ) )?
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==OPTIONS) ) {
				alt77=1;
			}
			switch (alt77) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:817:40: ^( OPTIONS ( . )* )
					{
					match(input,OPTIONS,FOLLOW_OPTIONS_in_testSetRule1809); if (state.failed) return alts;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return alts;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:817:50: ( . )*
						loop76:
						while (true) {
							int alt76=2;
							int LA76_0 = input.LA(1);
							if ( ((LA76_0 >= ACTION && LA76_0 <= XDIGIT)) ) {
								alt76=1;
							}
							else if ( (LA76_0==UP) ) {
								alt76=2;
							}

							switch (alt76) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:817:50: .
								{
								matchAny(input); if (state.failed) return alts;
								}
								break;

							default :
								break loop76;
							}
						}

						match(input, Token.UP, null); if (state.failed) return alts;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:817:57: ( ruleScopeSpec )?
			int alt78=2;
			int LA78_0 = input.LA(1);
			if ( (LA78_0==SCOPE) ) {
				alt78=1;
			}
			switch (alt78) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:817:59: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_testSetRule1820);
					ruleScopeSpec();
					state._fsp--;
					if (state.failed) return alts;
					}
					break;

			}

			// org/antlr/grammar/v3/TreeToNFAConverter.g:818:4: ( ^( AMPERSAND ( . )* ) )*
			loop80:
			while (true) {
				int alt80=2;
				int LA80_0 = input.LA(1);
				if ( (LA80_0==AMPERSAND) ) {
					alt80=1;
				}

				switch (alt80) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:818:6: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_testSetRule1831); if (state.failed) return alts;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return alts;
						// org/antlr/grammar/v3/TreeToNFAConverter.g:818:18: ( . )*
						loop79:
						while (true) {
							int alt79=2;
							int LA79_0 = input.LA(1);
							if ( ((LA79_0 >= ACTION && LA79_0 <= XDIGIT)) ) {
								alt79=1;
							}
							else if ( (LA79_0==UP) ) {
								alt79=2;
							}

							switch (alt79) {
							case 1 :
								// org/antlr/grammar/v3/TreeToNFAConverter.g:818:18: .
								{
								matchAny(input); if (state.failed) return alts;
								}
								break;

							default :
								break loop79;
							}
						}

						match(input, Token.UP, null); if (state.failed) return alts;
					}

					}
					break;

				default :
					break loop80;
				}
			}

			match(input,BLOCK,FOLLOW_BLOCK_in_testSetRule1845); if (state.failed) return alts;
			match(input, Token.DOWN, null); if (state.failed) return alts;
			// org/antlr/grammar/v3/TreeToNFAConverter.g:820:5: ( ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA ) )+
			int cnt82=0;
			loop82:
			while (true) {
				int alt82=2;
				int LA82_0 = input.LA(1);
				if ( (LA82_0==ALT) ) {
					alt82=1;
				}

				switch (alt82) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:820:7: ^( ALT ( BACKTRACK_SEMPRED )? testSetElement EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_testSetRule1854); if (state.failed) return alts;
					match(input, Token.DOWN, null); if (state.failed) return alts;
					// org/antlr/grammar/v3/TreeToNFAConverter.g:820:13: ( BACKTRACK_SEMPRED )?
					int alt81=2;
					int LA81_0 = input.LA(1);
					if ( (LA81_0==BACKTRACK_SEMPRED) ) {
						alt81=1;
					}
					switch (alt81) {
						case 1 :
							// org/antlr/grammar/v3/TreeToNFAConverter.g:820:14: BACKTRACK_SEMPRED
							{
							match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_testSetRule1857); if (state.failed) return alts;
							}
							break;

					}

					pushFollow(FOLLOW_testSetElement_in_testSetRule1861);
					testSetElement11=testSetElement();
					state._fsp--;
					if (state.failed) return alts;
					alts += testSetElement11;
					match(input,EOA,FOLLOW_EOA_in_testSetRule1865); if (state.failed) return alts;
					match(input, Token.UP, null); if (state.failed) return alts;

					}
					break;

				default :
					if ( cnt82 >= 1 ) break loop82;
					if (state.backtracking>0) {state.failed=true; return alts;}
					EarlyExitException eee = new EarlyExitException(82, input);
					throw eee;
				}
				cnt82++;
			}

			match(input,EOB,FOLLOW_EOB_in_testSetRule1879); if (state.failed) return alts;
			match(input, Token.UP, null); if (state.failed) return alts;

			// org/antlr/grammar/v3/TreeToNFAConverter.g:824:4: ( exceptionGroup )?
			int alt83=2;
			int LA83_0 = input.LA(1);
			if ( (LA83_0==CATCH||LA83_0==FINALLY) ) {
				alt83=1;
			}
			switch (alt83) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:824:5: exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_testSetRule1890);
					exceptionGroup();
					state._fsp--;
					if (state.failed) return alts;
					}
					break;

			}

			match(input,EOR,FOLLOW_EOR_in_testSetRule1897); if (state.failed) return alts;
			match(input, Token.UP, null); if (state.failed) return alts;

			}

		}
		catch (RecognitionException re) {
			 throw re; 
		}

		finally {
			// do for sure before leaving
			 inTest--; 
		}
		return alts;
	}
	// $ANTLR end "testSetRule"



	// $ANTLR start "testSetElement"
	// org/antlr/grammar/v3/TreeToNFAConverter.g:832:1: testSetElement returns [int alts=1] : (c= CHAR_LITERAL {...}?|t= TOKEN_REF {...}?|{...}? =>s= STRING_LITERAL | ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL ) | testBlockAsSet | ^( NOT tse= testSetElement ) );
	public final int testSetElement() throws RecognitionException {
		int alts = 1;


		GrammarAST c=null;
		GrammarAST t=null;
		GrammarAST s=null;
		GrammarAST c1=null;
		GrammarAST c2=null;
		int tse =0;
		int testBlockAsSet12 =0;

		try {
			// org/antlr/grammar/v3/TreeToNFAConverter.g:833:2: (c= CHAR_LITERAL {...}?|t= TOKEN_REF {...}?|{...}? =>s= STRING_LITERAL | ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL ) | testBlockAsSet | ^( NOT tse= testSetElement ) )
			int alt84=6;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==CHAR_LITERAL) ) {
				alt84=1;
			}
			else if ( (LA84_0==TOKEN_REF) ) {
				alt84=2;
			}
			else if ( (LA84_0==STRING_LITERAL) && ((grammar.type!=Grammar.LEXER))) {
				alt84=3;
			}
			else if ( (LA84_0==CHAR_RANGE) ) {
				alt84=4;
			}
			else if ( (LA84_0==BLOCK) ) {
				alt84=5;
			}
			else if ( (LA84_0==NOT) ) {
				alt84=6;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return alts;}
				NoViableAltException nvae =
					new NoViableAltException("", 84, 0, input);
				throw nvae;
			}

			switch (alt84) {
				case 1 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:833:4: c= CHAR_LITERAL {...}?
					{
					c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_testSetElement1929); if (state.failed) return alts;
					if ( !((!hasElementOptions(c))) ) {
						if (state.backtracking>0) {state.failed=true; return alts;}
						throw new FailedPredicateException(input, "testSetElement", "!hasElementOptions($c)");
					}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:834:4: t= TOKEN_REF {...}?
					{
					t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_testSetElement1938); if (state.failed) return alts;
					if ( !((!hasElementOptions(t))) ) {
						if (state.backtracking>0) {state.failed=true; return alts;}
						throw new FailedPredicateException(input, "testSetElement", "!hasElementOptions($t)");
					}

								if ( grammar.type==Grammar.LEXER )
								{
									Rule rule = grammar.getRule((t!=null?t.getText():null));
									if ( rule==null )
									{
										//throw new RecognitionException("invalid rule");
										throw new RecognitionException();
									}
									// recursively will invoke this rule to match elements in target rule ref
									alts += testSetRule(rule.tree);
								}
							
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:848:6: {...}? =>s= STRING_LITERAL
					{
					if ( !((grammar.type!=Grammar.LEXER)) ) {
						if (state.backtracking>0) {state.failed=true; return alts;}
						throw new FailedPredicateException(input, "testSetElement", "grammar.type!=Grammar.LEXER");
					}
					s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_testSetElement1957); if (state.failed) return alts;
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:849:4: ^( CHAR_RANGE c1= CHAR_LITERAL c2= CHAR_LITERAL )
					{
					match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_testSetElement1963); if (state.failed) return alts;
					match(input, Token.DOWN, null); if (state.failed) return alts;
					c1=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_testSetElement1967); if (state.failed) return alts;
					c2=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_testSetElement1971); if (state.failed) return alts;
					match(input, Token.UP, null); if (state.failed) return alts;

					 alts = IntervalSet.of( Grammar.getCharValueFromGrammarCharLiteral((c1!=null?c1.getText():null)), Grammar.getCharValueFromGrammarCharLiteral((c2!=null?c2.getText():null)) ).size(); 
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:851:6: testBlockAsSet
					{
					pushFollow(FOLLOW_testBlockAsSet_in_testSetElement1983);
					testBlockAsSet12=testBlockAsSet();
					state._fsp--;
					if (state.failed) return alts;
					 alts = testBlockAsSet12; 
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/TreeToNFAConverter.g:853:6: ^( NOT tse= testSetElement )
					{
					match(input,NOT,FOLLOW_NOT_in_testSetElement1996); if (state.failed) return alts;
					match(input, Token.DOWN, null); if (state.failed) return alts;
					pushFollow(FOLLOW_testSetElement_in_testSetElement2000);
					tse=testSetElement();
					state._fsp--;
					if (state.failed) return alts;
					match(input, Token.UP, null); if (state.failed) return alts;

					 alts = grammar.getTokenTypes().size() - tse; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			 throw re; 
		}

		finally {
			// do for sure before leaving
		}
		return alts;
	}
	// $ANTLR end "testSetElement"

	// Delegated rules



	public static final BitSet FOLLOW_LEXER_GRAMMAR_in_grammar_68 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_70 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARSER_GRAMMAR_in_grammar_80 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_82 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammar_92 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_94 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMBINED_GRAMMAR_in_grammar_104 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_106 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SCOPE_in_attrScope125 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_attrScope127 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_AMPERSAND_in_attrScope132 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_attrScope141 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_grammarSpec154 = new BitSet(new long[]{0x0400200008000200L,0x0000000020028002L});
	public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec161 = new BitSet(new long[]{0x0400200000000200L,0x0000000020028002L});
	public static final BitSet FOLLOW_OPTIONS_in_grammarSpec170 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IMPORT_in_grammarSpec184 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TOKENS_in_grammarSpec198 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_attrScope_in_grammarSpec210 = new BitSet(new long[]{0x0000000000000200L,0x0000000000028002L});
	public static final BitSet FOLLOW_AMPERSAND_in_grammarSpec219 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rules_in_grammarSpec231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_rules243 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008002L});
	public static final BitSet FOLLOW_PREC_RULE_in_rules248 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_RULE_in_rule267 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule271 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
	public static final BitSet FOLLOW_modifier_in_rule282 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ARG_in_rule290 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule293 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RET_in_rule302 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule305 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_throwsSpec_in_rule314 = new BitSet(new long[]{0x0400000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_OPTIONS_in_rule324 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_rule338 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_AMPERSAND_in_rule349 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_rule363 = new BitSet(new long[]{0x0000004400020000L});
	public static final BitSet FOLLOW_exceptionGroup_in_rule369 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_EOR_in_rule376 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_THROWS_in_throwsSpec423 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_throwsSpec425 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec440 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_AMPERSAND_in_ruleScopeSpec445 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec455 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_ID_in_ruleScopeSpec461 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_set_in_block492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block502 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_OPTIONS_in_block507 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alternative_in_block523 = new BitSet(new long[]{0x0000000200000100L,0x0000000000001000L});
	public static final BitSet FOLLOW_rewrite_in_block525 = new BitSet(new long[]{0x0000000200000100L});
	public static final BitSet FOLLOW_EOB_in_block548 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_alternative577 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_alternative582 = new BitSet(new long[]{0x82800289202DE010L,0x0000000547092041L});
	public static final BitSet FOLLOW_EOA_in_alternative589 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup608 = new BitSet(new long[]{0x0000004000020002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CATCH_in_exceptionHandler636 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler638 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_exceptionHandler640 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FINALLY_in_finallyClause656 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_finallyClause658 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REWRITES_in_rewrite672 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite690 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ROOT_in_element725 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element729 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BANG_in_element740 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element744 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_element753 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element755 = new BitSet(new long[]{0x82800288202DE010L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_element759 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_ASSIGN_in_element768 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element770 = new BitSet(new long[]{0x82800288202DE010L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_element774 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RANGE_in_element785 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_atom_in_element789 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_element794 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_RANGE_in_element808 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_element812 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_element816 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_atom_or_notatom_in_element828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ebnf_in_element837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tree__in_element846 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYNPRED_in_element857 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_element859 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ACTION_in_element868 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FORCED_ACTION_in_element877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMPRED_in_element888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYN_SEMPRED_in_element899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element911 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_GATED_SEMPRED_in_element926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EPSILON_in_element935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_ebnf961 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_ebnf971 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_ebnf982 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf986 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CLOSURE_in_ebnf999 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1003 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1016 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1020 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1048 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_tree_1055 = new BitSet(new long[]{0x82800288202DE018L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_tree_1071 = new BitSet(new long[]{0x82800288202DE018L,0x0000000547092041L});
	public static final BitSet FOLLOW_atom_in_atom_or_notatom1100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_atom_or_notatom1112 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom_or_notatom1121 = new BitSet(new long[]{0x0000000000008008L,0x0000000000002000L});
	public static final BitSet FOLLOW_ast_suffix_in_atom_or_notatom1126 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom_or_notatom1143 = new BitSet(new long[]{0x0000000000008008L,0x0000000000002000L});
	public static final BitSet FOLLOW_ast_suffix_in_atom_or_notatom1148 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_atom_or_notatom1163 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_REF_in_atom1205 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1210 = new BitSet(new long[]{0x0000000000008008L,0x0000000000002000L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1217 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom1235 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1241 = new BitSet(new long[]{0x0000000000008008L,0x0000000000002000L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1248 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1266 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1272 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_atom1290 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1296 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WILDCARD_in_atom1314 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1319 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_atom1336 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_atom1340 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_atom1344 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_set1390 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ALT_in_set1399 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_set1404 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_setElement_in_set1413 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_set1416 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EOB_in_set1426 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_setRule1460 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_setRule1464 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
	public static final BitSet FOLLOW_modifier_in_setRule1467 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ARG_in_setRule1471 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_RET_in_setRule1473 = new BitSet(new long[]{0x0400000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_OPTIONS_in_setRule1478 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_setRule1489 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_AMPERSAND_in_setRule1500 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_setRule1514 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_OPTIONS_in_setRule1519 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ALT_in_setRule1537 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_setRule1540 = new BitSet(new long[]{0x00800000000D0000L,0x0000000041000000L});
	public static final BitSet FOLLOW_setElement_in_setRule1544 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_setRule1547 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EOB_in_setRule1559 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_exceptionGroup_in_setRule1571 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_EOR_in_setRule1578 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_setElement1618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_setElement1630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_RANGE_in_setElement1640 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1644 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1648 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_setElement1661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_setElement1673 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_setElement_in_setElement1680 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_testBlockAsSet1725 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ALT_in_testBlockAsSet1733 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_testBlockAsSet1736 = new BitSet(new long[]{0x00800000000D0000L,0x0000000041000000L});
	public static final BitSet FOLLOW_testSetElement_in_testBlockAsSet1740 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_testBlockAsSet1744 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EOB_in_testBlockAsSet1756 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_testSetRule1791 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_testSetRule1795 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
	public static final BitSet FOLLOW_modifier_in_testSetRule1798 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ARG_in_testSetRule1802 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_RET_in_testSetRule1804 = new BitSet(new long[]{0x0400000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_OPTIONS_in_testSetRule1809 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_testSetRule1820 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_AMPERSAND_in_testSetRule1831 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_testSetRule1845 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ALT_in_testSetRule1854 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_testSetRule1857 = new BitSet(new long[]{0x00800000000D0000L,0x0000000041000000L});
	public static final BitSet FOLLOW_testSetElement_in_testSetRule1861 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_testSetRule1865 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EOB_in_testSetRule1879 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_exceptionGroup_in_testSetRule1890 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_EOR_in_testSetRule1897 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_testSetElement1929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_testSetElement1938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_testSetElement1957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_RANGE_in_testSetElement1963 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_testSetElement1967 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_testSetElement1971 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_testBlockAsSet_in_testSetElement1983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_testSetElement1996 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_testSetElement_in_testSetElement2000 = new BitSet(new long[]{0x0000000000000008L});
}
