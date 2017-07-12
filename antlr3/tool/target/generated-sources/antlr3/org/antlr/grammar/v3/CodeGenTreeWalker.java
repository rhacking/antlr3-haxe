// $ANTLR 3.5 org/antlr/grammar/v3/CodeGenTreeWalker.g 2017-06-11 18:42:20

package org.antlr.grammar.v3;

import org.antlr.analysis.*;
import org.antlr.misc.*;
import org.antlr.tool.*;
import org.antlr.codegen.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/** Walk a grammar and generate code by gradually building up
 *  a bigger and bigger ST.
 *
 *  Terence Parr
 *  University of San Francisco
 *  June 15, 2004
 */
@SuppressWarnings("all")
public class CodeGenTreeWalker extends TreeParser {
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


	public CodeGenTreeWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public CodeGenTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return CodeGenTreeWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/CodeGenTreeWalker.g"; }


	protected static final int RULE_BLOCK_NESTING_LEVEL = 0;
	protected static final int OUTER_REWRITE_NESTING_LEVEL = 0;

	private String currentRuleName = null;
	protected int blockNestingLevel = 0;
	protected int rewriteBlockNestingLevel = 0;
	private int outerAltNum = 0;
	protected ST currentBlockST = null;
	protected boolean currentAltHasASTRewrite = false;
	protected int rewriteTreeNestingLevel = 0;
	protected HashSet<Object> rewriteRuleRefs = null;

	public String getCurrentRuleName() {
	    return currentRuleName;
	}

	public void setCurrentRuleName(String value) {
	    currentRuleName = value;
	}

	public int getOuterAltNum() {
	    return outerAltNum;
	}

	public void setOuterAltNum(int value) {
	    outerAltNum = value;
	}

	@Override
	public void reportError(RecognitionException ex) {
	    Token token = null;
	    if (ex instanceof MismatchedTokenException) {
	        token = ((MismatchedTokenException)ex).token;
	    } else if (ex instanceof NoViableAltException) {
	        token = ((NoViableAltException)ex).token;
	    }

	    ErrorManager.syntaxError(
	        ErrorManager.MSG_SYNTAX_ERROR,
	        grammar,
	        token,
	        "codegen: " + ex.toString(),
	        ex );
	}

	public final void reportError(String s) {
	    System.out.println("codegen: error: " + s);
	}

	protected CodeGenerator generator;
	protected Grammar grammar;
	protected STGroup templates;

	/** The overall lexer/parser template; simulate dynamically scoped
	 *  attributes by making this an instance var of the walker.
	 */
	protected ST recognizerST;

	protected ST outputFileST;
	protected ST headerFileST;

	protected String outputOption = "";

	protected final ST getWildcardST(GrammarAST elementAST, GrammarAST ast_suffix, String label) {
	    String name = "wildcard";
	    if (grammar.type == Grammar.LEXER) {
	        name = "wildcardChar";
	    }
	    return getTokenElementST(name, name, elementAST, ast_suffix, label);
	}

	protected final ST getRuleElementST( String name,
	                                          String ruleTargetName,
	                                          GrammarAST elementAST,
	                                          GrammarAST ast_suffix,
	                                          String label ) {
		Rule r = grammar.getRule( currentRuleName );
		String suffix = getSTSuffix(elementAST, ast_suffix, label);
		if ( !r.isSynPred ) {
			name += suffix;
		}
		// if we're building trees and there is no label, gen a label
		// unless we're in a synpred rule.
		if ( ( grammar.buildAST() || suffix.length() > 0 ) && label == null &&
			 ( r == null || !r.isSynPred ) ) {
			// we will need a label to do the AST or tracking, make one
			label = generator.createUniqueLabel( ruleTargetName );
			CommonToken labelTok = new CommonToken( ANTLRParser.ID, label );
			grammar.defineRuleRefLabel( currentRuleName, labelTok, elementAST );
		}

		ST elementST = templates.getInstanceOf( name );
		if ( label != null ) {
			elementST.add( "label", label );
		}


		return elementST;
	}

	protected final ST getTokenElementST( String name,
	                                           String elementName,
	                                           GrammarAST elementAST,
	                                           GrammarAST ast_suffix,
	                                           String label ) {
	    boolean tryUnchecked = false;
	    if (name == "matchSet" && elementAST.enclosingRuleName != null && elementAST.enclosingRuleName.length() > 0 && Rule.getRuleType(elementAST.enclosingRuleName) == Grammar.LEXER)
	    {
	        if ( ( elementAST.getParent().getType() == ANTLRLexer.ALT && elementAST.getParent().getParent().getParent().getType() == RULE && elementAST.getParent().getParent().getChildCount() == 2 )
	            || ( elementAST.getParent().getType() == ANTLRLexer.NOT && elementAST.getParent().getParent().getParent().getParent().getType() == RULE && elementAST.getParent().getParent().getParent().getChildCount() == 2 ) ) {
	            // single alt at the start of the rule needs to be checked
	        } else {
	            tryUnchecked = true;
	        }
	    }

	    String suffix = getSTSuffix( elementAST, ast_suffix, label );
	    // if we're building trees and there is no label, gen a label
	    // unless we're in a synpred rule.
	    Rule r = grammar.getRule( currentRuleName );
	    if ( ( grammar.buildAST() || suffix.length() > 0 ) && label == null &&
	         ( r == null || !r.isSynPred ) )
	    {
	        label = generator.createUniqueLabel( elementName );
	        CommonToken labelTok = new CommonToken( ANTLRParser.ID, label );
	        grammar.defineTokenRefLabel( currentRuleName, labelTok, elementAST );
	    }

	    ST elementST = null;
	    if ( tryUnchecked && templates.isDefined( name + "Unchecked" + suffix ) )
	        elementST = templates.getInstanceOf( name + "Unchecked" + suffix );
	    if ( elementST == null )
	        elementST = templates.getInstanceOf( name + suffix );

	    if ( label != null )
	    {
	        elementST.add( "label", label );
	    }
	    return elementST;
	}

	public final boolean isListLabel(String label) {
	    boolean hasListLabel = false;
	    if ( label != null ) {
	        Rule r = grammar.getRule( currentRuleName );
	        //String stName = null;
	        if ( r != null )
	        {
	            Grammar.LabelElementPair pair = r.getLabel( label );
	            if ( pair != null &&
	                 ( pair.type == Grammar.TOKEN_LIST_LABEL ||
	                  pair.type == Grammar.RULE_LIST_LABEL ||
	                  pair.type == Grammar.WILDCARD_TREE_LIST_LABEL ) )
	            {
	                hasListLabel = true;
	            }
	        }
	    }
	    return hasListLabel;
	}

	/** Return a non-empty template name suffix if the token is to be
	 *  tracked, added to a tree, or both.
	 */
	protected final String getSTSuffix(GrammarAST elementAST, GrammarAST ast_suffix, String label) {
	    if ( grammar.type == Grammar.LEXER )
	    {
	        return "";
	    }
	    // handle list label stuff; make element use "Track"

	    String operatorPart = "";
	    String rewritePart = "";
	    String listLabelPart = "";
	    Rule ruleDescr = grammar.getRule( currentRuleName );
	    if ( ast_suffix != null && !ruleDescr.isSynPred )
	    {
	        if ( ast_suffix.getType() == ANTLRParser.ROOT )
	        {
	            operatorPart = "RuleRoot";
	        }
	        else if ( ast_suffix.getType() == ANTLRParser.BANG )
	        {
	            operatorPart = "Bang";
	        }
	    }
	    if ( currentAltHasASTRewrite && elementAST.getType() != WILDCARD )
	    {
	        rewritePart = "Track";
	    }
	    if ( isListLabel( label ) )
	    {
	        listLabelPart = "AndListLabel";
	    }
	    String STsuffix = operatorPart + rewritePart + listLabelPart;
	    //JSystem.@out.println("suffix = "+STsuffix);

	    return STsuffix;
	}

	/** Convert rewrite AST lists to target labels list */
	protected final List<String> getTokenTypesAsTargetLabels(Collection<GrammarAST> refs)
	{
	    if ( refs == null || refs.size() == 0 )
	        return null;

	    List<String> labels = new ArrayList<String>( refs.size() );
	    for ( GrammarAST t : refs )
	    {
	        String label;
	        if ( t.getType() == ANTLRParser.RULE_REF || t.getType() == ANTLRParser.TOKEN_REF || t.getType() == ANTLRParser.LABEL)
	        {
	            label = t.getText();
	        }
	        else
	        {
	            // must be char or String literal
	            label = generator.getTokenTypeAsTargetLabel(grammar.getTokenType(t.getText()));
	        }
	        labels.add( label );
	    }
	    return labels;
	}

	public final void init( Grammar g ) {
	    this.grammar = g;
	    this.generator = grammar.getCodeGenerator();
	    this.templates = generator.getTemplates();
	}



	// $ANTLR start "grammar_"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:298:1: public grammar_[Grammar g,\n\t\tST recognizerST,\n\t\tST outputFileST,\n\t\tST headerFileST] : ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) ) ;
	public final void grammar_(Grammar g, ST recognizerST, ST outputFileST, ST headerFileST) throws RecognitionException {

			if ( state.backtracking == 0 )
			{
				init(g);
				this.recognizerST = recognizerST;
				this.outputFileST = outputFileST;
				this.headerFileST = headerFileST;
				String superClass = (String)g.getOption("superClass");
				outputOption = (String)g.getOption("output");
				if ( superClass!=null ) recognizerST.add("superClass", superClass);
				if ( g.type!=Grammar.LEXER ) {
				    Object lt = g.getOption("ASTLabelType");
					if ( lt!=null ) recognizerST.add("ASTLabelType", lt);
				}
				if ( g.type==Grammar.TREE_PARSER && g.getOption("ASTLabelType")==null ) {
					ErrorManager.grammarWarning(ErrorManager.MSG_MISSING_AST_TYPE_IN_TREE_GRAMMAR,
											   g,
											   null,
											   g.name);
				}
				if ( g.type!=Grammar.TREE_PARSER ) {
				    Object lt = g.getOption("TokenLabelType");
					if ( lt!=null ) recognizerST.add("labelType", lt);
				}
				recognizerST.add("numRules", grammar.getRules().size());
				outputFileST.add("numRules", grammar.getRules().size());
				headerFileST.add("numRules", grammar.getRules().size());
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:332:2: ( ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:332:4: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
			{
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:332:4: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
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
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:332:6: ^( LEXER_GRAMMAR grammarSpec )
					{
					match(input,LEXER_GRAMMAR,FOLLOW_LEXER_GRAMMAR_in_grammar_67); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_grammarSpec_in_grammar_69);
					grammarSpec();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:333:5: ^( PARSER_GRAMMAR grammarSpec )
					{
					match(input,PARSER_GRAMMAR,FOLLOW_PARSER_GRAMMAR_in_grammar_79); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_grammarSpec_in_grammar_81);
					grammarSpec();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:334:5: ^( TREE_GRAMMAR grammarSpec )
					{
					match(input,TREE_GRAMMAR,FOLLOW_TREE_GRAMMAR_in_grammar_91); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_grammarSpec_in_grammar_93);
					grammarSpec();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:335:5: ^( COMBINED_GRAMMAR grammarSpec )
					{
					match(input,COMBINED_GRAMMAR,FOLLOW_COMBINED_GRAMMAR_in_grammar_103); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					pushFollow(FOLLOW_grammarSpec_in_grammar_105);
					grammarSpec();
					state._fsp--;
					if (state.failed) return;
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;

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
	// $ANTLR end "grammar_"



	// $ANTLR start "attrScope"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:339:1: attrScope : ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION ) ;
	public final void attrScope() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:340:2: ( ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:340:4: ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION )
			{
			match(input,SCOPE,FOLLOW_SCOPE_in_attrScope124); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			match(input,ID,FOLLOW_ID_in_attrScope126); if (state.failed) return;
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:340:18: ( ^( AMPERSAND ( . )* ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==AMPERSAND) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:340:20: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_attrScope131); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:340:32: ( . )*
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
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:340:32: .
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

			match(input,ACTION,FOLLOW_ACTION_in_attrScope140); if (state.failed) return;
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
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:343:1: grammarSpec : name= ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules[recognizerST] ;
	public final void grammarSpec() throws RecognitionException {
		GrammarAST name=null;
		GrammarAST cmt=null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:344:2: (name= ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules[recognizerST] )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:344:6: name= ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules[recognizerST]
			{
			name=(GrammarAST)match(input,ID,FOLLOW_ID_in_grammarSpec157); if (state.failed) return;
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:345:3: (cmt= DOC_COMMENT )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==DOC_COMMENT) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:345:5: cmt= DOC_COMMENT
					{
					cmt=(GrammarAST)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec165); if (state.failed) return;
					if ( state.backtracking==0 ) {
									outputFileST.add("docComment", (cmt!=null?cmt.getText():null));
									headerFileST.add("docComment", (cmt!=null?cmt.getText():null));
								}
					}
					break;

			}

			if ( state.backtracking==0 ) {
						recognizerST.add("name", grammar.getRecognizerName());
						outputFileST.add("name", grammar.getRecognizerName());
						headerFileST.add("name", grammar.getRecognizerName());
						recognizerST.add("scopes", grammar.getGlobalScopes());
						headerFileST.add("scopes", grammar.getGlobalScopes());
					}
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:358:3: ( ^( OPTIONS ( . )* ) )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==OPTIONS) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:358:5: ^( OPTIONS ( . )* )
					{
					match(input,OPTIONS,FOLLOW_OPTIONS_in_grammarSpec186); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:358:15: ( . )*
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
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:358:15: .
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

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:359:3: ( ^( IMPORT ( . )* ) )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==IMPORT) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:359:5: ^( IMPORT ( . )* )
					{
					match(input,IMPORT,FOLLOW_IMPORT_in_grammarSpec200); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:359:14: ( . )*
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
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:359:14: .
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

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:360:3: ( ^( TOKENS ( . )* ) )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==TOKENS) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:360:5: ^( TOKENS ( . )* )
					{
					match(input,TOKENS,FOLLOW_TOKENS_in_grammarSpec214); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:360:14: ( . )*
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
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:360:14: .
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

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:361:3: ( attrScope )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==SCOPE) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:361:4: attrScope
					{
					pushFollow(FOLLOW_attrScope_in_grammarSpec226);
					attrScope();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop11;
				}
			}

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:362:3: ( ^( AMPERSAND ( . )* ) )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==AMPERSAND) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:362:5: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_grammarSpec235); if (state.failed) return;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:362:17: ( . )*
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
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:362:17: .
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

			pushFollow(FOLLOW_rules_in_grammarSpec246);
			rules(recognizerST);
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
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:366:1: rules[ST recognizerST] : ( ( options {k=1; } :{...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) ) )+ ;
	public final void rules(ST recognizerST) throws RecognitionException {
		TreeRuleReturnScope rST =null;


			String ruleName = ((GrammarAST)input.LT(1)).getChild(0).getText();
			boolean generated = grammar.generateMethodForRule(ruleName);

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:372:2: ( ( ( options {k=1; } :{...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) ) )+ )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:372:4: ( ( options {k=1; } :{...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) ) )+
			{
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:372:4: ( ( options {k=1; } :{...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) ) )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==PREC_RULE||LA17_0==RULE) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:372:6: ( options {k=1; } :{...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) )
					{
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:372:6: ( options {k=1; } :{...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) )
					int alt16=3;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==RULE) ) {
						int LA16_1 = input.LA(2);
						if ( ((generated)) ) {
							alt16=1;
						}
						else if ( (true) ) {
							alt16=2;
						}

					}
					else if ( (LA16_0==PREC_RULE) ) {
						alt16=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:373:5: {...}? =>rST= rule
							{
							if ( !((generated)) ) {
								if (state.backtracking>0) {state.failed=true; return;}
								throw new FailedPredicateException(input, "rules", "generated");
							}
							pushFollow(FOLLOW_rule_in_rules291);
							rST=rule();
							state._fsp--;
							if (state.failed) return;
							if ( state.backtracking==0 ) {
												if ( (rST!=null?((CodeGenTreeWalker.rule_return)rST).code:null) != null )
												{
													recognizerST.add("rules", (rST!=null?((CodeGenTreeWalker.rule_return)rST).code:null));
													outputFileST.add("rules", (rST!=null?((CodeGenTreeWalker.rule_return)rST).code:null));
													headerFileST.add("rules", (rST!=null?((CodeGenTreeWalker.rule_return)rST).code:null));
												}
											}
							}
							break;
						case 2 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:383:6: ^( RULE ( . )* )
							{
							match(input,RULE,FOLLOW_RULE_in_rules305); if (state.failed) return;
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); if (state.failed) return;
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:383:13: ( . )*
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
										// org/antlr/grammar/v3/CodeGenTreeWalker.g:383:13: .
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
						case 3 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:384:6: ^( PREC_RULE ( . )* )
							{
							match(input,PREC_RULE,FOLLOW_PREC_RULE_in_rules317); if (state.failed) return;
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); if (state.failed) return;
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:384:18: ( . )*
								loop15:
								while (true) {
									int alt15=2;
									int LA15_0 = input.LA(1);
									if ( ((LA15_0 >= ACTION && LA15_0 <= XDIGIT)) ) {
										alt15=1;
									}
									else if ( (LA15_0==UP) ) {
										alt15=2;
									}

									switch (alt15) {
									case 1 :
										// org/antlr/grammar/v3/CodeGenTreeWalker.g:384:18: .
										{
										matchAny(input); if (state.failed) return;
										}
										break;

									default :
										break loop15;
									}
								}

								match(input, Token.UP, null); if (state.failed) return;
							}

							}
							break;

					}


									if ( input.LA(1) == RULE )
									{
										ruleName = ((GrammarAST)input.LT(1)).getChild(0).getText();
										//System.Diagnostics.Debug.Assert( ruleName == ((GrammarAST)input.LT(1)).enclosingRuleName );
										generated = grammar.generateMethodForRule(ruleName);
									}
								
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
		public ST code=null;
	};


	// $ANTLR start "rule"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:397:1: rule returns [ST code=null] : ^( RULE id= ID (mod= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block[\"ruleBlock\", dfa, null] ( exceptionGroup[$code] )? EOR ) ;
	public final CodeGenTreeWalker.rule_return rule() throws RecognitionException {
		CodeGenTreeWalker.rule_return retval = new CodeGenTreeWalker.rule_return();
		retval.start = input.LT(1);

		GrammarAST id=null;
		TreeRuleReturnScope mod =null;
		TreeRuleReturnScope b =null;


			String initAction = null;
			// get the dfa for the BLOCK
			GrammarAST block2=(GrammarAST)((GrammarAST)retval.start).getFirstChildWithType(BLOCK);
			org.antlr.analysis.DFA dfa = block2.getLookaheadDFA();
			// init blockNestingLevel so it's block level RULE_BLOCK_NESTING_LEVEL
			// for alts of rule
			blockNestingLevel = RULE_BLOCK_NESTING_LEVEL-1;
			Rule ruleDescr = grammar.getRule(((GrammarAST)retval.start).getChild(0).getText());
			currentRuleName = ((GrammarAST)retval.start).getChild(0).getText();

			// For syn preds, we don't want any AST code etc... in there.
			// Save old templates ptr and restore later.  Base templates include Dbg.
			STGroup saveGroup = templates;
			if ( ruleDescr.isSynPred && generator.target.useBaseTemplatesForSynPredFragments() )
			{
				templates = generator.getBaseTemplates();
			}

			String description = "";

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:420:2: ( ^( RULE id= ID (mod= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block[\"ruleBlock\", dfa, null] ( exceptionGroup[$code] )? EOR ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:420:4: ^( RULE id= ID (mod= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block[\"ruleBlock\", dfa, null] ( exceptionGroup[$code] )? EOR )
			{
			match(input,RULE,FOLLOW_RULE_in_rule359); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rule363); if (state.failed) return retval;
			if ( state.backtracking==0 ) {assert currentRuleName == (id!=null?id.getText():null);}
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:422:4: (mod= modifier )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==FRAGMENT||(LA18_0 >= PRIVATE && LA18_0 <= PUBLIC)) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:422:5: mod= modifier
					{
					pushFollow(FOLLOW_modifier_in_rule376);
					mod=modifier();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			match(input,ARG,FOLLOW_ARG_in_rule384); if (state.failed) return retval;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// org/antlr/grammar/v3/CodeGenTreeWalker.g:423:10: ( ARG_ACTION )?
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==ARG_ACTION) ) {
					alt19=1;
				}
				switch (alt19) {
					case 1 :
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:423:11: ARG_ACTION
						{
						match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule387); if (state.failed) return retval;
						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}

			match(input,RET,FOLLOW_RET_in_rule396); if (state.failed) return retval;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// org/antlr/grammar/v3/CodeGenTreeWalker.g:424:10: ( ARG_ACTION )?
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==ARG_ACTION) ) {
					alt20=1;
				}
				switch (alt20) {
					case 1 :
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:424:11: ARG_ACTION
						{
						match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule399); if (state.failed) return retval;
						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:425:4: ( throwsSpec )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==THROWS) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:425:5: throwsSpec
					{
					pushFollow(FOLLOW_throwsSpec_in_rule408);
					throwsSpec();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:426:4: ( ^( OPTIONS ( . )* ) )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==OPTIONS) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:426:6: ^( OPTIONS ( . )* )
					{
					match(input,OPTIONS,FOLLOW_OPTIONS_in_rule418); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:426:16: ( . )*
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
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:426:16: .
								{
								matchAny(input); if (state.failed) return retval;
								}
								break;

							default :
								break loop22;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:427:4: ( ruleScopeSpec )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==SCOPE) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:427:5: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_rule431);
					ruleScopeSpec();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:428:4: ( ^( AMPERSAND ( . )* ) )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==AMPERSAND) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:428:6: ^( AMPERSAND ( . )* )
					{
					match(input,AMPERSAND,FOLLOW_AMPERSAND_in_rule441); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:428:18: ( . )*
						loop25:
						while (true) {
							int alt25=2;
							int LA25_0 = input.LA(1);
							if ( ((LA25_0 >= ACTION && LA25_0 <= XDIGIT)) ) {
								alt25=1;
							}
							else if ( (LA25_0==UP) ) {
								alt25=2;
							}

							switch (alt25) {
							case 1 :
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:428:18: .
								{
								matchAny(input); if (state.failed) return retval;
								}
								break;

							default :
								break loop25;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					}
					break;

				default :
					break loop26;
				}
			}

			pushFollow(FOLLOW_block_in_rule455);
			b=block("ruleBlock", dfa, null);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {
							description =
								grammar.grammarTreeToString((GrammarAST)((GrammarAST)retval.start).getFirstChildWithType(BLOCK),
															false);
							description =
								generator.target.getTargetStringLiteralFromString(description);
							(b!=null?((CodeGenTreeWalker.block_return)b).code:null).add("description", description);
							// do not generate lexer rules in combined grammar
							String stName = null;
							if ( ruleDescr.isSynPred )
							{
								stName = "synpredRule";
							}
							else if ( grammar.type==Grammar.LEXER )
							{
								if ( currentRuleName.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME) )
								{
									stName = "tokensRule";
								}
								else
								{
									stName = "lexerRule";
								}
							}
							else
							{
								if ( !(grammar.type==Grammar.COMBINED &&
									 Rule.getRuleType(currentRuleName) == Grammar.LEXER) )
								{
									stName = "rule";
								}
							}
							retval.code = templates.getInstanceOf(stName);
							if ( retval.code.getName().equals("/rule") )
							{
								retval.code.add("emptyRule", grammar.isEmptyRule(block2));
							}
							retval.code.add("ruleDescriptor", ruleDescr);
							String memo = (String)grammar.getBlockOption(((GrammarAST)retval.start),"memoize");
							if ( memo==null )
							{
								memo = (String)grammar.getOption("memoize");
							}
							if ( memo!=null && memo.equals("true") &&
								 (stName.equals("rule")||stName.equals("lexerRule")) )
							{
								retval.code.add("memoize", memo!=null && memo.equals("true"));
							}
						}
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:480:4: ( exceptionGroup[$code] )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==CATCH||LA27_0==FINALLY) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:480:5: exceptionGroup[$code]
					{
					pushFollow(FOLLOW_exceptionGroup_in_rule468);
					exceptionGroup(retval.code);
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}

			match(input,EOR,FOLLOW_EOR_in_rule476); if (state.failed) return retval;
			match(input, Token.UP, null); if (state.failed) return retval;

			if ( state.backtracking==0 ) {
						if ( retval.code!=null )
						{
							if ( grammar.type==Grammar.LEXER )
							{
								boolean naked =
									currentRuleName.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME) ||
									((mod!=null?((GrammarAST)mod.start):null)!=null&&(mod!=null?((GrammarAST)mod.start):null).getText().equals(Grammar.FRAGMENT_RULE_MODIFIER));
								retval.code.add("nakedBlock", naked);
							}
							else
							{
								description = grammar.grammarTreeToString(((GrammarAST)retval.start),false);
								description = generator.target.getTargetStringLiteralFromString(description);
								retval.code.add("description", description);
							}
							Rule theRule = grammar.getRule(currentRuleName);
							generator.translateActionAttributeReferencesForSingleScope(
								theRule,
								theRule.getActions()
							);
							retval.code.add("ruleName", currentRuleName);
							retval.code.add("block", (b!=null?((CodeGenTreeWalker.block_return)b).code:null));
							if ( initAction!=null )
							{
								retval.code.add("initAction", initAction);
							}
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
			 templates = saveGroup; 
		}
		return retval;
	}
	// $ANTLR end "rule"


	public static class modifier_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "modifier"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:515:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
	public final CodeGenTreeWalker.modifier_return modifier() throws RecognitionException {
		CodeGenTreeWalker.modifier_return retval = new CodeGenTreeWalker.modifier_return();
		retval.start = input.LT(1);

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:516:2: ( 'protected' | 'public' | 'private' | 'fragment' )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:
			{
			if ( input.LA(1)==FRAGMENT||(input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
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
		return retval;
	}
	// $ANTLR end "modifier"



	// $ANTLR start "throwsSpec"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:522:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
	public final void throwsSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:523:2: ( ^( 'throws' ( ID )+ ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:523:4: ^( 'throws' ( ID )+ )
			{
			match(input,THROWS,FOLLOW_THROWS_in_throwsSpec526); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:523:15: ( ID )+
			int cnt28=0;
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==ID) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:523:15: ID
					{
					match(input,ID,FOLLOW_ID_in_throwsSpec528); if (state.failed) return;
					}
					break;

				default :
					if ( cnt28 >= 1 ) break loop28;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(28, input);
					throw eee;
				}
				cnt28++;
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
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:526:1: ruleScopeSpec : ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* ) ;
	public final void ruleScopeSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:2: ( ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:4: ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* )
			{
			match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec543); if (state.failed) return;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return;
				// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:15: ( ^( AMPERSAND ( . )* ) )*
				loop30:
				while (true) {
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==AMPERSAND) ) {
						alt30=1;
					}

					switch (alt30) {
					case 1 :
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:17: ^( AMPERSAND ( . )* )
						{
						match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleScopeSpec548); if (state.failed) return;
						if ( input.LA(1)==Token.DOWN ) {
							match(input, Token.DOWN, null); if (state.failed) return;
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:29: ( . )*
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
									// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:29: .
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

					default :
						break loop30;
					}
				}

				// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:36: ( ACTION )?
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==ACTION) ) {
					alt31=1;
				}
				switch (alt31) {
					case 1 :
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:37: ACTION
						{
						match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec558); if (state.failed) return;
						}
						break;

				}

				// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:46: ( ID )*
				loop32:
				while (true) {
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==ID) ) {
						alt32=1;
					}

					switch (alt32) {
					case 1 :
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:527:48: ID
						{
						match(input,ID,FOLLOW_ID_in_ruleScopeSpec564); if (state.failed) return;
						}
						break;

					default :
						break loop32;
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
		public ST code=null;
	};


	// $ANTLR start "block"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:530:1: block[String blockTemplateName, org.antlr.analysis.DFA dfa, GrammarAST label] returns [ST code=null] options {k=1; } : ({...}? => setBlock | ^( BLOCK ( ^( OPTIONS ( . )* ) )? (alt= alternative[$label] rew= rewrite )+ EOB ) );
	public final CodeGenTreeWalker.block_return block(String blockTemplateName, org.antlr.analysis.DFA dfa, GrammarAST label) throws RecognitionException {
		CodeGenTreeWalker.block_return retval = new CodeGenTreeWalker.block_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope alt =null;
		TreeRuleReturnScope rew =null;
		TreeRuleReturnScope setBlock1 =null;


			int altNum = 0;

			blockNestingLevel++;
			if ( state.backtracking == 0 )
			{
				ST decision = null;
				if ( dfa != null )
				{
					retval.code = templates.getInstanceOf(blockTemplateName);
					decision = generator.genLookaheadDecision(recognizerST,dfa);
					retval.code.add("decision", decision);
					retval.code.add("decisionNumber", dfa.getDecisionNumber());
					retval.code.add("maxK",dfa.getMaxLookaheadDepth());
					retval.code.add("maxAlt",dfa.getNumberOfAlts());
				}
				else
				{
					retval.code = templates.getInstanceOf(blockTemplateName+"SingleAlt");
				}
				retval.code.add("blockLevel", blockNestingLevel);
				retval.code.add("enclosingBlockLevel", blockNestingLevel-1);
				altNum = 1;
				if ( this.blockNestingLevel==RULE_BLOCK_NESTING_LEVEL ) {
					this.outerAltNum=1;
				}
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:562:2: ({...}? => setBlock | ^( BLOCK ( ^( OPTIONS ( . )* ) )? (alt= alternative[$label] rew= rewrite )+ EOB ) )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==BLOCK) ) {
				int LA36_1 = input.LA(2);
				if ( ((((GrammarAST)retval.start).getSetValue()!=null)) ) {
					alt36=1;
				}
				else if ( (true) ) {
					alt36=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:562:4: {...}? => setBlock
					{
					if ( !((((GrammarAST)retval.start).getSetValue()!=null)) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "block", "$start.getSetValue()!=null");
					}
					pushFollow(FOLLOW_setBlock_in_block605);
					setBlock1=setBlock();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								retval.code.add("alts",(setBlock1!=null?((CodeGenTreeWalker.setBlock_return)setBlock1).code:null));
							}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:567:4: ^( BLOCK ( ^( OPTIONS ( . )* ) )? (alt= alternative[$label] rew= rewrite )+ EOB )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block618); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:568:4: ( ^( OPTIONS ( . )* ) )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0==OPTIONS) ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:568:6: ^( OPTIONS ( . )* )
							{
							match(input,OPTIONS,FOLLOW_OPTIONS_in_block626); if (state.failed) return retval;
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); if (state.failed) return retval;
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:568:16: ( . )*
								loop33:
								while (true) {
									int alt33=2;
									int LA33_0 = input.LA(1);
									if ( ((LA33_0 >= ACTION && LA33_0 <= XDIGIT)) ) {
										alt33=1;
									}
									else if ( (LA33_0==UP) ) {
										alt33=2;
									}

									switch (alt33) {
									case 1 :
										// org/antlr/grammar/v3/CodeGenTreeWalker.g:568:16: .
										{
										matchAny(input); if (state.failed) return retval;
										}
										break;

									default :
										break loop33;
									}
								}

								match(input, Token.UP, null); if (state.failed) return retval;
							}

							}
							break;

					}

					// org/antlr/grammar/v3/CodeGenTreeWalker.g:569:4: (alt= alternative[$label] rew= rewrite )+
					int cnt35=0;
					loop35:
					while (true) {
						int alt35=2;
						int LA35_0 = input.LA(1);
						if ( (LA35_0==ALT) ) {
							alt35=1;
						}

						switch (alt35) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:569:6: alt= alternative[$label] rew= rewrite
							{
							pushFollow(FOLLOW_alternative_in_block643);
							alt=alternative(label);
							state._fsp--;
							if (state.failed) return retval;
							pushFollow(FOLLOW_rewrite_in_block648);
							rew=rewrite();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) {
												if ( this.blockNestingLevel==RULE_BLOCK_NESTING_LEVEL )
												{
													this.outerAltNum++;
												}
												// add the rewrite code as just another element in the alt :)
												// (unless it's a " -> ..." rewrite
												// ( -> ... )
												GrammarAST firstRewriteAST = (rew!=null?((GrammarAST)rew.start):null).findFirstType(REWRITE);
												boolean etc =
													(rew!=null?((GrammarAST)rew.start):null).getType()==REWRITES &&
													firstRewriteAST.getChild(0)!=null &&
													firstRewriteAST.getChild(0).getType()==ETC;
												if ( (rew!=null?((CodeGenTreeWalker.rewrite_return)rew).code:null)!=null && !etc )
												{
													(alt!=null?((CodeGenTreeWalker.alternative_return)alt).code:null).add("rew", (rew!=null?((CodeGenTreeWalker.rewrite_return)rew).code:null));
												}
												// add this alt to the list of alts for this block
												retval.code.add("alts",(alt!=null?((CodeGenTreeWalker.alternative_return)alt).code:null));
												(alt!=null?((CodeGenTreeWalker.alternative_return)alt).code:null).add("altNum", altNum);
												(alt!=null?((CodeGenTreeWalker.alternative_return)alt).code:null).add("outerAlt", blockNestingLevel==RULE_BLOCK_NESTING_LEVEL);
												altNum++;
											}
							}
							break;

						default :
							if ( cnt35 >= 1 ) break loop35;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(35, input);
							throw eee;
						}
						cnt35++;
					}

					match(input,EOB,FOLLOW_EOB_in_block665); if (state.failed) return retval;
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
			 blockNestingLevel--; 
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class setBlock_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "setBlock"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:599:1: setBlock returns [ST code=null] : ^(s= BLOCK ( . )* ) ;
	public final CodeGenTreeWalker.setBlock_return setBlock() throws RecognitionException {
		CodeGenTreeWalker.setBlock_return retval = new CodeGenTreeWalker.setBlock_return();
		retval.start = input.LT(1);

		GrammarAST s=null;


			ST setcode = null;
			if ( state.backtracking == 0 )
			{
				if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL && grammar.buildAST() )
				{
					Rule r = grammar.getRule(currentRuleName);
					currentAltHasASTRewrite = r.hasRewrite(outerAltNum);
					if ( currentAltHasASTRewrite )
					{
						r.trackTokenReferenceInAlt(((GrammarAST)retval.start), outerAltNum);
					}
				}
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:616:2: ( ^(s= BLOCK ( . )* ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:616:4: ^(s= BLOCK ( . )* )
			{
			s=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_setBlock697); if (state.failed) return retval;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// org/antlr/grammar/v3/CodeGenTreeWalker.g:616:14: ( . )*
				loop37:
				while (true) {
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( ((LA37_0 >= ACTION && LA37_0 <= XDIGIT)) ) {
						alt37=1;
					}
					else if ( (LA37_0==UP) ) {
						alt37=2;
					}

					switch (alt37) {
					case 1 :
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:616:14: .
						{
						matchAny(input); if (state.failed) return retval;
						}
						break;

					default :
						break loop37;
					}
				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}

			if ( state.backtracking==0 ) {
						int i = ((CommonToken)s.getToken()).getTokenIndex();
						if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL )
						{
							setcode = getTokenElementST("matchRuleBlockSet", "set", s, null, null);
						}
						else
						{
							setcode = getTokenElementST("matchSet", "set", s, null, null);
						}
						setcode.add("elementIndex", i);
						//if ( grammar.type!=Grammar.LEXER )
						//{
						//	generator.generateLocalFOLLOW(s,"set",currentRuleName,i);
						//}
						setcode.add("s",
							generator.genSetExpr(templates,s.getSetValue(),1,false));
						ST altcode=templates.getInstanceOf("alt");
						altcode.addAggr("elements.{el,line,pos}",
											 setcode,
											 s.getLine(),
											 s.getCharPositionInLine() + 1
											);
						altcode.add("altNum", 1);
						altcode.add("outerAlt", blockNestingLevel==RULE_BLOCK_NESTING_LEVEL);
						if ( !currentAltHasASTRewrite && grammar.buildAST() )
						{
							altcode.add("autoAST", true);
						}
						altcode.add("treeLevel", rewriteTreeNestingLevel);
						retval.code = altcode;
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
	// $ANTLR end "setBlock"



	// $ANTLR start "setAlternative"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:651:1: setAlternative : ^( ALT ( setElement )+ EOA ) ;
	public final void setAlternative() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:652:2: ( ^( ALT ( setElement )+ EOA ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:652:4: ^( ALT ( setElement )+ EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_setAlternative717); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:652:10: ( setElement )+
			int cnt38=0;
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( ((LA38_0 >= CHAR_LITERAL && LA38_0 <= CHAR_RANGE)||LA38_0==STRING_LITERAL||LA38_0==TOKEN_REF) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:652:10: setElement
					{
					pushFollow(FOLLOW_setElement_in_setAlternative719);
					setElement();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt38 >= 1 ) break loop38;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(38, input);
					throw eee;
				}
				cnt38++;
			}

			match(input,EOA,FOLLOW_EOA_in_setAlternative722); if (state.failed) return;
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
	// $ANTLR end "setAlternative"



	// $ANTLR start "exceptionGroup"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:655:1: exceptionGroup[ST ruleST] : ( ( exceptionHandler[$ruleST] )+ ( finallyClause[$ruleST] )? | finallyClause[$ruleST] );
	public final void exceptionGroup(ST ruleST) throws RecognitionException {
		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:656:2: ( ( exceptionHandler[$ruleST] )+ ( finallyClause[$ruleST] )? | finallyClause[$ruleST] )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==CATCH) ) {
				alt41=1;
			}
			else if ( (LA41_0==FINALLY) ) {
				alt41=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:656:4: ( exceptionHandler[$ruleST] )+ ( finallyClause[$ruleST] )?
					{
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:656:4: ( exceptionHandler[$ruleST] )+
					int cnt39=0;
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==CATCH) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:656:6: exceptionHandler[$ruleST]
							{
							pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup737);
							exceptionHandler(ruleST);
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt39 >= 1 ) break loop39;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(39, input);
							throw eee;
						}
						cnt39++;
					}

					// org/antlr/grammar/v3/CodeGenTreeWalker.g:656:35: ( finallyClause[$ruleST] )?
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( (LA40_0==FINALLY) ) {
						alt40=1;
					}
					switch (alt40) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:656:36: finallyClause[$ruleST]
							{
							pushFollow(FOLLOW_finallyClause_in_exceptionGroup744);
							finallyClause(ruleST);
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:657:4: finallyClause[$ruleST]
					{
					pushFollow(FOLLOW_finallyClause_in_exceptionGroup752);
					finallyClause(ruleST);
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
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:660:1: exceptionHandler[ST ruleST] : ^( 'catch' ARG_ACTION ACTION ) ;
	public final void exceptionHandler(ST ruleST) throws RecognitionException {
		GrammarAST ACTION2=null;
		GrammarAST ARG_ACTION3=null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:661:2: ( ^( 'catch' ARG_ACTION ACTION ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:661:4: ^( 'catch' ARG_ACTION ACTION )
			{
			match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler766); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ARG_ACTION3=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler768); if (state.failed) return;
			ACTION2=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler770); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {
						List<? extends Object> chunks = generator.translateAction(currentRuleName,ACTION2);
						ruleST.addAggr("exceptions.{decl,action}",(ARG_ACTION3!=null?ARG_ACTION3.getText():null),chunks);
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
	// $ANTLR end "exceptionHandler"



	// $ANTLR start "finallyClause"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:668:1: finallyClause[ST ruleST] : ^( 'finally' ACTION ) ;
	public final void finallyClause(ST ruleST) throws RecognitionException {
		GrammarAST ACTION4=null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:669:2: ( ^( 'finally' ACTION ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:669:4: ^( 'finally' ACTION )
			{
			match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause788); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ACTION4=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_finallyClause790); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {
						List<? extends Object> chunks = generator.translateAction(currentRuleName,ACTION4);
						ruleST.add("finally",chunks);
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
	// $ANTLR end "finallyClause"


	public static class alternative_return extends TreeRuleReturnScope {
		public ST code;
	};


	// $ANTLR start "alternative"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:676:1: alternative[GrammarAST label] returns [ST code] : ^(a= ALT (e= element[$label,null] )+ EOA ) ;
	public final CodeGenTreeWalker.alternative_return alternative(GrammarAST label) throws RecognitionException {
		CodeGenTreeWalker.alternative_return retval = new CodeGenTreeWalker.alternative_return();
		retval.start = input.LT(1);

		GrammarAST a=null;
		TreeRuleReturnScope e =null;


			if ( state.backtracking == 0 )
			{
				retval.code = templates.getInstanceOf("alt");
				if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL && grammar.buildAST() )
				{
					Rule r = grammar.getRule(currentRuleName);
					currentAltHasASTRewrite = r.hasRewrite(outerAltNum);
				}
				String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
				description = generator.target.getTargetStringLiteralFromString(description);
				retval.code.add("description", description);
				retval.code.add("treeLevel", rewriteTreeNestingLevel);
				if ( !currentAltHasASTRewrite && grammar.buildAST() )
				{
					retval.code.add("autoAST", true);
				}
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:697:2: ( ^(a= ALT (e= element[$label,null] )+ EOA ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:697:4: ^(a= ALT (e= element[$label,null] )+ EOA )
			{
			a=(GrammarAST)match(input,ALT,FOLLOW_ALT_in_alternative820); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:698:4: (e= element[$label,null] )+
			int cnt42=0;
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==ACTION||(LA42_0 >= ASSIGN && LA42_0 <= BLOCK)||(LA42_0 >= CHAR_LITERAL && LA42_0 <= CHAR_RANGE)||LA42_0==CLOSURE||LA42_0==DOT||LA42_0==EPSILON||LA42_0==FORCED_ACTION||LA42_0==GATED_SEMPRED||LA42_0==NOT||LA42_0==OPTIONAL||(LA42_0 >= PLUS_ASSIGN && LA42_0 <= POSITIVE_CLOSURE)||LA42_0==ROOT||LA42_0==RULE_REF||LA42_0==SEMPRED||(LA42_0 >= STRING_LITERAL && LA42_0 <= SYN_SEMPRED)||LA42_0==TOKEN_REF||LA42_0==TREE_BEGIN||LA42_0==WILDCARD) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:699:5: e= element[$label,null]
					{
					pushFollow(FOLLOW_element_in_alternative833);
					e=element(label, null);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
										if ((e!=null?((CodeGenTreeWalker.element_return)e).code:null) != null)
										{
											retval.code.addAggr("elements.{el,line,pos}",
															  (e!=null?((CodeGenTreeWalker.element_return)e).code:null),
															  (e!=null?((GrammarAST)e.start):null).getLine(),
															  (e!=null?((GrammarAST)e.start):null).getCharPositionInLine() + 1
															 );
										}
									}
					}
					break;

				default :
					if ( cnt42 >= 1 ) break loop42;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(42, input);
					throw eee;
				}
				cnt42++;
			}

			match(input,EOA,FOLLOW_EOA_in_alternative851); if (state.failed) return retval;
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
	// $ANTLR end "alternative"


	public static class element_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "element"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:715:1: element[GrammarAST label, GrammarAST astSuffix] returns [ST code=null] options {k=1; } : ( ^( ROOT e= element[$label,$ROOT] ) | ^( BANG e= element[$label,$BANG] ) | ^(n= NOT ne= notElement[$n, $label, $astSuffix] ) | ^( ASSIGN alabel= ID e= element[$alabel,$astSuffix] ) | ^( PLUS_ASSIGN label2= ID e= element[$label2,$astSuffix] ) | ^( CHAR_RANGE a= CHAR_LITERAL b= CHAR_LITERAL ) | ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )=> ebnf[$label] | atom[null, $label, $astSuffix] | tree_ | element_action | (sp= SEMPRED |sp= GATED_SEMPRED ) | SYN_SEMPRED | ^( SYNPRED ( . )* ) | ^( BACKTRACK_SEMPRED ( . )* ) | EPSILON );
	public final CodeGenTreeWalker.element_return element(GrammarAST label, GrammarAST astSuffix) throws RecognitionException {
		CodeGenTreeWalker.element_return retval = new CodeGenTreeWalker.element_return();
		retval.start = input.LT(1);

		GrammarAST n=null;
		GrammarAST alabel=null;
		GrammarAST label2=null;
		GrammarAST a=null;
		GrammarAST b=null;
		GrammarAST sp=null;
		GrammarAST ROOT5=null;
		GrammarAST BANG6=null;
		TreeRuleReturnScope e =null;
		ST ne =null;
		TreeRuleReturnScope ebnf7 =null;
		TreeRuleReturnScope atom8 =null;
		TreeRuleReturnScope tree_9 =null;
		TreeRuleReturnScope element_action10 =null;


			IntSet elements=null;
			GrammarAST ast = null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:722:2: ( ^( ROOT e= element[$label,$ROOT] ) | ^( BANG e= element[$label,$BANG] ) | ^(n= NOT ne= notElement[$n, $label, $astSuffix] ) | ^( ASSIGN alabel= ID e= element[$alabel,$astSuffix] ) | ^( PLUS_ASSIGN label2= ID e= element[$label2,$astSuffix] ) | ^( CHAR_RANGE a= CHAR_LITERAL b= CHAR_LITERAL ) | ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )=> ebnf[$label] | atom[null, $label, $astSuffix] | tree_ | element_action | (sp= SEMPRED |sp= GATED_SEMPRED ) | SYN_SEMPRED | ^( SYNPRED ( . )* ) | ^( BACKTRACK_SEMPRED ( . )* ) | EPSILON )
			int alt46=15;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==ROOT) ) {
				alt46=1;
			}
			else if ( (LA46_0==BANG) ) {
				alt46=2;
			}
			else if ( (LA46_0==NOT) ) {
				alt46=3;
			}
			else if ( (LA46_0==ASSIGN) ) {
				alt46=4;
			}
			else if ( (LA46_0==PLUS_ASSIGN) ) {
				alt46=5;
			}
			else if ( (LA46_0==CHAR_RANGE) ) {
				alt46=6;
			}
			else if ( (LA46_0==BLOCK) ) {
				int LA46_7 = input.LA(2);
				if ( (synpred1_CodeGenTreeWalker()) ) {
					alt46=7;
				}
				else if ( (true) ) {
					alt46=8;
				}

			}
			else if ( (LA46_0==OPTIONAL) && (synpred1_CodeGenTreeWalker())) {
				alt46=7;
			}
			else if ( (LA46_0==CLOSURE) && (synpred1_CodeGenTreeWalker())) {
				alt46=7;
			}
			else if ( (LA46_0==POSITIVE_CLOSURE) && (synpred1_CodeGenTreeWalker())) {
				alt46=7;
			}
			else if ( (LA46_0==CHAR_LITERAL||LA46_0==DOT||LA46_0==RULE_REF||LA46_0==STRING_LITERAL||LA46_0==TOKEN_REF||LA46_0==WILDCARD) ) {
				alt46=8;
			}
			else if ( (LA46_0==TREE_BEGIN) ) {
				alt46=9;
			}
			else if ( (LA46_0==ACTION||LA46_0==FORCED_ACTION) ) {
				alt46=10;
			}
			else if ( (LA46_0==GATED_SEMPRED||LA46_0==SEMPRED) ) {
				alt46=11;
			}
			else if ( (LA46_0==SYN_SEMPRED) ) {
				alt46=12;
			}
			else if ( (LA46_0==SYNPRED) ) {
				alt46=13;
			}
			else if ( (LA46_0==BACKTRACK_SEMPRED) ) {
				alt46=14;
			}
			else if ( (LA46_0==EPSILON) ) {
				alt46=15;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:722:4: ^( ROOT e= element[$label,$ROOT] )
					{
					ROOT5=(GrammarAST)match(input,ROOT,FOLLOW_ROOT_in_element886); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_element_in_element890);
					e=element(label, ROOT5);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = (e!=null?((CodeGenTreeWalker.element_return)e).code:null); }
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:725:4: ^( BANG e= element[$label,$BANG] )
					{
					BANG6=(GrammarAST)match(input,BANG,FOLLOW_BANG_in_element903); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_element_in_element907);
					e=element(label, BANG6);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = (e!=null?((CodeGenTreeWalker.element_return)e).code:null); }
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:728:4: ^(n= NOT ne= notElement[$n, $label, $astSuffix] )
					{
					n=(GrammarAST)match(input,NOT,FOLLOW_NOT_in_element923); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_notElement_in_element927);
					ne=notElement(n, label, astSuffix);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = ne; }
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:731:4: ^( ASSIGN alabel= ID e= element[$alabel,$astSuffix] )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_element942); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					alabel=(GrammarAST)match(input,ID,FOLLOW_ID_in_element946); if (state.failed) return retval;
					pushFollow(FOLLOW_element_in_element950);
					e=element(alabel, astSuffix);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = (e!=null?((CodeGenTreeWalker.element_return)e).code:null); }
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:734:4: ^( PLUS_ASSIGN label2= ID e= element[$label2,$astSuffix] )
					{
					match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element965); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					label2=(GrammarAST)match(input,ID,FOLLOW_ID_in_element969); if (state.failed) return retval;
					pushFollow(FOLLOW_element_in_element973);
					e=element(label2, astSuffix);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = (e!=null?((CodeGenTreeWalker.element_return)e).code:null); }
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:737:4: ^( CHAR_RANGE a= CHAR_LITERAL b= CHAR_LITERAL )
					{
					match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_element987); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					a=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_element991); if (state.failed) return retval;
					b=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_element995); if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) {
								retval.code = templates.getInstanceOf("charRangeRef");
								String low = generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,(a!=null?a.getText():null));
								String high = generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,(b!=null?b.getText():null));
								retval.code.add("a", low);
								retval.code.add("b", high);
								if ( label!=null )
								{
									retval.code.add("label", label.getText());
								}
							}
					}
					break;
				case 7 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:750:4: ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )=> ebnf[$label]
					{
					pushFollow(FOLLOW_ebnf_in_element1024);
					ebnf7=ebnf(label);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = (ebnf7!=null?((CodeGenTreeWalker.ebnf_return)ebnf7).code:null); }
					}
					break;
				case 8 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:753:4: atom[null, $label, $astSuffix]
					{
					pushFollow(FOLLOW_atom_in_element1035);
					atom8=atom(null, label, astSuffix);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = (atom8!=null?((CodeGenTreeWalker.atom_return)atom8).code:null); }
					}
					break;
				case 9 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:756:4: tree_
					{
					pushFollow(FOLLOW_tree__in_element1046);
					tree_9=tree_();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = (tree_9!=null?((CodeGenTreeWalker.tree__return)tree_9).code:null); }
					}
					break;
				case 10 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:759:4: element_action
					{
					pushFollow(FOLLOW_element_action_in_element1056);
					element_action10=element_action();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = (element_action10!=null?((CodeGenTreeWalker.element_action_return)element_action10).code:null); }
					}
					break;
				case 11 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:762:6: (sp= SEMPRED |sp= GATED_SEMPRED )
					{
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:762:6: (sp= SEMPRED |sp= GATED_SEMPRED )
					int alt43=2;
					int LA43_0 = input.LA(1);
					if ( (LA43_0==SEMPRED) ) {
						alt43=1;
					}
					else if ( (LA43_0==GATED_SEMPRED) ) {
						alt43=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 43, 0, input);
						throw nvae;
					}

					switch (alt43) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:762:7: sp= SEMPRED
							{
							sp=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element1071); if (state.failed) return retval;
							}
							break;
						case 2 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:762:18: sp= GATED_SEMPRED
							{
							sp=(GrammarAST)match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element1075); if (state.failed) return retval;
							}
							break;

					}

					if ( state.backtracking==0 ) {
								retval.code = templates.getInstanceOf("validateSemanticPredicate");
								retval.code.add("pred", generator.translateAction(currentRuleName,sp));
								String description = generator.target.getTargetStringLiteralFromString((sp!=null?sp.getText():null));
								retval.code.add("description", description);
							}
					}
					break;
				case 12 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:770:4: SYN_SEMPRED
					{
					match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element1086); if (state.failed) return retval;
					}
					break;
				case 13 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:772:4: ^( SYNPRED ( . )* )
					{
					match(input,SYNPRED,FOLLOW_SYNPRED_in_element1094); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:772:14: ( . )*
						loop44:
						while (true) {
							int alt44=2;
							int LA44_0 = input.LA(1);
							if ( ((LA44_0 >= ACTION && LA44_0 <= XDIGIT)) ) {
								alt44=1;
							}
							else if ( (LA44_0==UP) ) {
								alt44=2;
							}

							switch (alt44) {
							case 1 :
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:772:14: .
								{
								matchAny(input); if (state.failed) return retval;
								}
								break;

							default :
								break loop44;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					}
					break;
				case 14 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:774:4: ^( BACKTRACK_SEMPRED ( . )* )
					{
					match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element1105); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:774:24: ( . )*
						loop45:
						while (true) {
							int alt45=2;
							int LA45_0 = input.LA(1);
							if ( ((LA45_0 >= ACTION && LA45_0 <= XDIGIT)) ) {
								alt45=1;
							}
							else if ( (LA45_0==UP) ) {
								alt45=2;
							}

							switch (alt45) {
							case 1 :
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:774:24: .
								{
								matchAny(input); if (state.failed) return retval;
								}
								break;

							default :
								break loop45;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					}
					break;
				case 15 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:776:6: EPSILON
					{
					match(input,EPSILON,FOLLOW_EPSILON_in_element1117); if (state.failed) return retval;
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


	public static class element_action_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "element_action"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:779:1: element_action returns [ST code=null] : (act= ACTION |act2= FORCED_ACTION );
	public final CodeGenTreeWalker.element_action_return element_action() throws RecognitionException {
		CodeGenTreeWalker.element_action_return retval = new CodeGenTreeWalker.element_action_return();
		retval.start = input.LT(1);

		GrammarAST act=null;
		GrammarAST act2=null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:780:2: (act= ACTION |act2= FORCED_ACTION )
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==ACTION) ) {
				alt47=1;
			}
			else if ( (LA47_0==FORCED_ACTION) ) {
				alt47=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}

			switch (alt47) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:780:4: act= ACTION
					{
					act=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element_action1134); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								retval.code = templates.getInstanceOf("execAction");
								retval.code.add("action", generator.translateAction(currentRuleName,act));
							}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:785:4: act2= FORCED_ACTION
					{
					act2=(GrammarAST)match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element_action1145); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								retval.code = templates.getInstanceOf("execForcedAction");
								retval.code.add("action", generator.translateAction(currentRuleName,act2));
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
	// $ANTLR end "element_action"



	// $ANTLR start "notElement"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:792:1: notElement[GrammarAST n, GrammarAST label, GrammarAST astSuffix] returns [ST code=null] : (assign_c= CHAR_LITERAL |assign_s= STRING_LITERAL |assign_t= TOKEN_REF | ^(assign_st= BLOCK ( . )* ) ) ;
	public final ST notElement(GrammarAST n, GrammarAST label, GrammarAST astSuffix) throws RecognitionException {
		ST code = null;


		GrammarAST assign_c=null;
		GrammarAST assign_s=null;
		GrammarAST assign_t=null;
		GrammarAST assign_st=null;


			IntSet elements=null;
			String labelText = null;
			if ( label!=null )
			{
				labelText = label.getText();
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:802:2: ( (assign_c= CHAR_LITERAL |assign_s= STRING_LITERAL |assign_t= TOKEN_REF | ^(assign_st= BLOCK ( . )* ) ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:802:4: (assign_c= CHAR_LITERAL |assign_s= STRING_LITERAL |assign_t= TOKEN_REF | ^(assign_st= BLOCK ( . )* ) )
			{
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:802:4: (assign_c= CHAR_LITERAL |assign_s= STRING_LITERAL |assign_t= TOKEN_REF | ^(assign_st= BLOCK ( . )* ) )
			int alt49=4;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				alt49=1;
				}
				break;
			case STRING_LITERAL:
				{
				alt49=2;
				}
				break;
			case TOKEN_REF:
				{
				alt49=3;
				}
				break;
			case BLOCK:
				{
				alt49=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return code;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}
			switch (alt49) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:802:6: assign_c= CHAR_LITERAL
					{
					assign_c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_notElement1174); if (state.failed) return code;
					if ( state.backtracking==0 ) {
									int ttype=0;
									if ( grammar.type==Grammar.LEXER )
									{
										ttype = Grammar.getCharValueFromGrammarCharLiteral((assign_c!=null?assign_c.getText():null));
									}
									else
									{
										ttype = grammar.getTokenType((assign_c!=null?assign_c.getText():null));
									}
									elements = grammar.complement(ttype);
								}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:815:5: assign_s= STRING_LITERAL
					{
					assign_s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_notElement1187); if (state.failed) return code;
					if ( state.backtracking==0 ) {
									int ttype=0;
									if ( grammar.type==Grammar.LEXER )
									{
										// TODO: error!
									}
									else
									{
										ttype = grammar.getTokenType((assign_s!=null?assign_s.getText():null));
									}
									elements = grammar.complement(ttype);
								}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:828:5: assign_t= TOKEN_REF
					{
					assign_t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_notElement1200); if (state.failed) return code;
					if ( state.backtracking==0 ) {
									int ttype = grammar.getTokenType((assign_t!=null?assign_t.getText():null));
									elements = grammar.complement(ttype);
								}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:833:5: ^(assign_st= BLOCK ( . )* )
					{
					assign_st=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_notElement1214); if (state.failed) return code;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return code;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:833:23: ( . )*
						loop48:
						while (true) {
							int alt48=2;
							int LA48_0 = input.LA(1);
							if ( ((LA48_0 >= ACTION && LA48_0 <= XDIGIT)) ) {
								alt48=1;
							}
							else if ( (LA48_0==UP) ) {
								alt48=2;
							}

							switch (alt48) {
							case 1 :
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:833:23: .
								{
								matchAny(input); if (state.failed) return code;
								}
								break;

							default :
								break loop48;
							}
						}

						match(input, Token.UP, null); if (state.failed) return code;
					}

					if ( state.backtracking==0 ) {
									elements = assign_st.getSetValue();
									elements = grammar.complement(elements);
								}
					}
					break;

			}

			if ( state.backtracking==0 ) {
						code = getTokenElementST("matchSet",
												 "set",
												 (GrammarAST)n.getChild(0),
												 astSuffix,
												 labelText);
						code.add("s",generator.genSetExpr(templates,elements,1,false));
						int i = ((CommonToken)n.getToken()).getTokenIndex();
						code.add("elementIndex", i);
						if ( grammar.type!=Grammar.LEXER )
						{
							generator.generateLocalFOLLOW(n,"set",currentRuleName,i);
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
		return code;
	}
	// $ANTLR end "notElement"


	public static class ebnf_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "ebnf"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:855:1: ebnf[GrammarAST label] returns [ST code=null] : (blk= block[\"block\", dfa, $label] | ^( OPTIONAL blk= block[\"optionalBlock\", dfa, $label] ) | ^( CLOSURE blk= block[\"closureBlock\", dfa, $label] ) | ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa, $label] ) ) ;
	public final CodeGenTreeWalker.ebnf_return ebnf(GrammarAST label) throws RecognitionException {
		CodeGenTreeWalker.ebnf_return retval = new CodeGenTreeWalker.ebnf_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope blk =null;


			org.antlr.analysis.DFA dfa=null;
			GrammarAST b = (GrammarAST)((GrammarAST)retval.start).getChild(0);
			GrammarAST eob = b.getLastChild(); // loops will use EOB DFA

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:862:2: ( (blk= block[\"block\", dfa, $label] | ^( OPTIONAL blk= block[\"optionalBlock\", dfa, $label] ) | ^( CLOSURE blk= block[\"closureBlock\", dfa, $label] ) | ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa, $label] ) ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:862:4: (blk= block[\"block\", dfa, $label] | ^( OPTIONAL blk= block[\"optionalBlock\", dfa, $label] ) | ^( CLOSURE blk= block[\"closureBlock\", dfa, $label] ) | ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa, $label] ) )
			{
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:862:4: (blk= block[\"block\", dfa, $label] | ^( OPTIONAL blk= block[\"optionalBlock\", dfa, $label] ) | ^( CLOSURE blk= block[\"closureBlock\", dfa, $label] ) | ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa, $label] ) )
			int alt50=4;
			switch ( input.LA(1) ) {
			case BLOCK:
				{
				alt50=1;
				}
				break;
			case OPTIONAL:
				{
				alt50=2;
				}
				break;
			case CLOSURE:
				{
				alt50=3;
				}
				break;
			case POSITIVE_CLOSURE:
				{
				alt50=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}
			switch (alt50) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:862:6: blk= block[\"block\", dfa, $label]
					{
					if ( state.backtracking==0 ) { dfa = ((GrammarAST)retval.start).getLookaheadDFA(); }
					pushFollow(FOLLOW_block_in_ebnf1261);
					blk=block("block", dfa, label);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = (blk!=null?((CodeGenTreeWalker.block_return)blk).code:null); }
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:865:5: ^( OPTIONAL blk= block[\"optionalBlock\", dfa, $label] )
					{
					if ( state.backtracking==0 ) { dfa = ((GrammarAST)retval.start).getLookaheadDFA(); }
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1280); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_block_in_ebnf1284);
					blk=block("optionalBlock", dfa, label);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = (blk!=null?((CodeGenTreeWalker.block_return)blk).code:null); }
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:868:5: ^( CLOSURE blk= block[\"closureBlock\", dfa, $label] )
					{
					if ( state.backtracking==0 ) { dfa = eob.getLookaheadDFA(); }
					match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1305); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_block_in_ebnf1309);
					blk=block("closureBlock", dfa, label);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = (blk!=null?((CodeGenTreeWalker.block_return)blk).code:null); }
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:871:5: ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa, $label] )
					{
					if ( state.backtracking==0 ) { dfa = eob.getLookaheadDFA(); }
					match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1330); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_block_in_ebnf1334);
					blk=block("positiveClosureBlock", dfa, label);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = (blk!=null?((CodeGenTreeWalker.block_return)blk).code:null); }
					}
					break;

			}

			if ( state.backtracking==0 ) {
						String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
						description = generator.target.getTargetStringLiteralFromString(description);
						retval.code.add("description", description);
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
	// $ANTLR end "ebnf"


	public static class tree__return extends TreeRuleReturnScope {
		public ST code;
	};


	// $ANTLR start "tree_"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:882:1: tree_ returns [ST code] : ^( TREE_BEGIN el= element[null,rootSuffix] ( ( element_action )=>act= element_action )* (el= element[null,null] )* ) ;
	public final CodeGenTreeWalker.tree__return tree_() throws RecognitionException {
		CodeGenTreeWalker.tree__return retval = new CodeGenTreeWalker.tree__return();
		retval.start = input.LT(1);

		TreeRuleReturnScope el =null;
		TreeRuleReturnScope act =null;


			rewriteTreeNestingLevel++;
			GrammarAST rootSuffix = null;
			if ( state.backtracking == 0 )
			{
				retval.code = templates.getInstanceOf("tree");
				NFAState afterDOWN = (NFAState)((GrammarAST)retval.start).NFATreeDownState.transition(0).target;
				LookaheadSet s = grammar.LOOK(afterDOWN);
				if ( s.member(Label.UP) ) {
					// nullable child list if we can see the UP as the next token
					// we need an "if ( input.LA(1)==Token.DOWN )" gate around
					// the child list.
					retval.code.add("nullableChildList", "true");
				}
				retval.code.add("enclosingTreeLevel", rewriteTreeNestingLevel-1);
				retval.code.add("treeLevel", rewriteTreeNestingLevel);
				Rule r = grammar.getRule(currentRuleName);
				if ( grammar.buildAST() && !r.hasRewrite(outerAltNum) ) {
					rootSuffix = new GrammarAST(ROOT,"ROOT");
				}
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:906:2: ( ^( TREE_BEGIN el= element[null,rootSuffix] ( ( element_action )=>act= element_action )* (el= element[null,null] )* ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:906:4: ^( TREE_BEGIN el= element[null,rootSuffix] ( ( element_action )=>act= element_action )* (el= element[null,null] )* )
			{
			match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1372); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			pushFollow(FOLLOW_element_in_tree_1379);
			el=element(null, rootSuffix);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {
							retval.code.addAggr("root.{el,line,pos}",
											  (el!=null?((CodeGenTreeWalker.element_return)el).code:null),
											  (el!=null?((GrammarAST)el.start):null).getLine(),
											  (el!=null?((GrammarAST)el.start):null).getCharPositionInLine() + 1
											  );
						}
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:918:4: ( ( element_action )=>act= element_action )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==ACTION) ) {
					int LA51_2 = input.LA(2);
					if ( (synpred2_CodeGenTreeWalker()) ) {
						alt51=1;
					}

				}
				else if ( (LA51_0==FORCED_ACTION) ) {
					int LA51_3 = input.LA(2);
					if ( (synpred2_CodeGenTreeWalker()) ) {
						alt51=1;
					}

				}

				switch (alt51) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:918:6: ( element_action )=>act= element_action
					{
					pushFollow(FOLLOW_element_action_in_tree_1416);
					act=element_action();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
										retval.code.addAggr("actionsAfterRoot.{el,line,pos}",
														  (act!=null?((CodeGenTreeWalker.element_action_return)act).code:null),
														  (act!=null?((GrammarAST)act.start):null).getLine(),
														  (act!=null?((GrammarAST)act.start):null).getCharPositionInLine() + 1
														);
									}
					}
					break;

				default :
					break loop51;
				}
			}

			// org/antlr/grammar/v3/CodeGenTreeWalker.g:928:4: (el= element[null,null] )*
			loop52:
			while (true) {
				int alt52=2;
				int LA52_0 = input.LA(1);
				if ( (LA52_0==ACTION||(LA52_0 >= ASSIGN && LA52_0 <= BLOCK)||(LA52_0 >= CHAR_LITERAL && LA52_0 <= CHAR_RANGE)||LA52_0==CLOSURE||LA52_0==DOT||LA52_0==EPSILON||LA52_0==FORCED_ACTION||LA52_0==GATED_SEMPRED||LA52_0==NOT||LA52_0==OPTIONAL||(LA52_0 >= PLUS_ASSIGN && LA52_0 <= POSITIVE_CLOSURE)||LA52_0==ROOT||LA52_0==RULE_REF||LA52_0==SEMPRED||(LA52_0 >= STRING_LITERAL && LA52_0 <= SYN_SEMPRED)||LA52_0==TOKEN_REF||LA52_0==TREE_BEGIN||LA52_0==WILDCARD) ) {
					alt52=1;
				}

				switch (alt52) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:928:7: el= element[null,null]
					{
					pushFollow(FOLLOW_element_in_tree_1438);
					el=element(null, null);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
									 retval.code.addAggr("children.{el,line,pos}",
													  (el!=null?((CodeGenTreeWalker.element_return)el).code:null),
													  (el!=null?((GrammarAST)el.start):null).getLine(),
													  (el!=null?((GrammarAST)el.start):null).getCharPositionInLine() + 1
													  );
									 }
					}
					break;

				default :
					break loop52;
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
			 rewriteTreeNestingLevel--; 
		}
		return retval;
	}
	// $ANTLR end "tree_"


	public static class atom_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "atom"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:941:1: atom[GrammarAST scope, GrammarAST label, GrammarAST astSuffix] returns [ST code=null] : ( ^(r= RULE_REF (rarg= ARG_ACTION )? ) | ^(t= TOKEN_REF (targ= ARG_ACTION )? ) |c= CHAR_LITERAL |s= STRING_LITERAL |w= WILDCARD | ^( DOT ID a= atom[$ID, label, astSuffix] ) | set[label,astSuffix] );
	public final CodeGenTreeWalker.atom_return atom(GrammarAST scope, GrammarAST label, GrammarAST astSuffix) throws RecognitionException {
		CodeGenTreeWalker.atom_return retval = new CodeGenTreeWalker.atom_return();
		retval.start = input.LT(1);

		GrammarAST r=null;
		GrammarAST rarg=null;
		GrammarAST t=null;
		GrammarAST targ=null;
		GrammarAST c=null;
		GrammarAST s=null;
		GrammarAST w=null;
		GrammarAST ID11=null;
		TreeRuleReturnScope a =null;
		ST set12 =null;


			String labelText=null;
			if ( state.backtracking == 0 )
			{
				if ( label!=null )
				{
					labelText = label.getText();
				}
				if ( grammar.type!=Grammar.LEXER &&
					 (((GrammarAST)retval.start).getType()==RULE_REF||((GrammarAST)retval.start).getType()==TOKEN_REF||
					  ((GrammarAST)retval.start).getType()==CHAR_LITERAL||((GrammarAST)retval.start).getType()==STRING_LITERAL) )
				{
					Rule encRule = grammar.getRule(((GrammarAST)retval.start).enclosingRuleName);
					if ( encRule!=null && encRule.hasRewrite(outerAltNum) && astSuffix!=null )
					{
						ErrorManager.grammarError(ErrorManager.MSG_AST_OP_IN_ALT_WITH_REWRITE,
												  grammar,
												  ((GrammarAST)retval.start).getToken(),
												  ((GrammarAST)retval.start).enclosingRuleName,
												  outerAltNum);
						astSuffix = null;
					}
				}
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:969:2: ( ^(r= RULE_REF (rarg= ARG_ACTION )? ) | ^(t= TOKEN_REF (targ= ARG_ACTION )? ) |c= CHAR_LITERAL |s= STRING_LITERAL |w= WILDCARD | ^( DOT ID a= atom[$ID, label, astSuffix] ) | set[label,astSuffix] )
			int alt55=7;
			switch ( input.LA(1) ) {
			case RULE_REF:
				{
				alt55=1;
				}
				break;
			case TOKEN_REF:
				{
				alt55=2;
				}
				break;
			case CHAR_LITERAL:
				{
				alt55=3;
				}
				break;
			case STRING_LITERAL:
				{
				alt55=4;
				}
				break;
			case WILDCARD:
				{
				alt55=5;
				}
				break;
			case DOT:
				{
				alt55=6;
				}
				break;
			case BLOCK:
				{
				alt55=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 55, 0, input);
				throw nvae;
			}
			switch (alt55) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:969:6: ^(r= RULE_REF (rarg= ARG_ACTION )? )
					{
					r=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1488); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:969:20: (rarg= ARG_ACTION )?
						int alt53=2;
						int LA53_0 = input.LA(1);
						if ( (LA53_0==ARG_ACTION) ) {
							alt53=1;
						}
						switch (alt53) {
							case 1 :
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:969:21: rarg= ARG_ACTION
								{
								rarg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1493); if (state.failed) return retval;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					if ( state.backtracking==0 ) {
								grammar.checkRuleReference(scope, r, rarg, currentRuleName);
								String scopeName = null;
								if ( scope!=null ) {
									scopeName = scope.getText();
								}
								Rule rdef = grammar.getRule(scopeName, (r!=null?r.getText():null));
								// don't insert label=r() if label.attr not used, no ret value, ...
								if ( !rdef.getHasReturnValue() ) {
									labelText = null;
								}
								retval.code = getRuleElementST("ruleRef", (r!=null?r.getText():null), r, astSuffix, labelText);
								retval.code.add("rule", rdef);
								if ( scope!=null ) { // scoped rule ref
									Grammar scopeG = grammar.composite.getGrammar(scope.getText());
									retval.code.add("scope", scopeG);
								}
								else if ( rdef.grammar != this.grammar ) { // nonlocal
									// if rule definition is not in this grammar, it's nonlocal
									List<Grammar> rdefDelegates = rdef.grammar.getDelegates();
									if ( rdefDelegates.contains(this.grammar) ) {
										retval.code.add("scope", rdef.grammar);
									}
									else {
										// defining grammar is not a delegate, scope all the
										// back to root, which has delegate methods for all
										// rules.  Don't use scope if we are root.
										if ( this.grammar != rdef.grammar.composite.delegateGrammarTreeRoot.grammar ) {
											retval.code.add("scope",
															  rdef.grammar.composite.delegateGrammarTreeRoot.grammar);
										}
									}
								}

								if ( rarg!=null ) {
									List<? extends Object> args = generator.translateAction(currentRuleName,rarg);
									retval.code.add("args", args);
								}
								int i = ((CommonToken)r.getToken()).getTokenIndex();
								retval.code.add("elementIndex", i);
								generator.generateLocalFOLLOW(r,(r!=null?r.getText():null),currentRuleName,i);
								r.code = retval.code;
							}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1014:4: ^(t= TOKEN_REF (targ= ARG_ACTION )? )
					{
					t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1511); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:1014:19: (targ= ARG_ACTION )?
						int alt54=2;
						int LA54_0 = input.LA(1);
						if ( (LA54_0==ARG_ACTION) ) {
							alt54=1;
						}
						switch (alt54) {
							case 1 :
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:1014:20: targ= ARG_ACTION
								{
								targ=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1516); if (state.failed) return retval;
								}
								break;

						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					if ( state.backtracking==0 ) {
								if ( currentAltHasASTRewrite && t.terminalOptions!=null &&
									t.terminalOptions.get(Grammar.defaultTokenOption)!=null )
								{
									ErrorManager.grammarError(ErrorManager.MSG_HETERO_ILLEGAL_IN_REWRITE_ALT,
															grammar,
															t.getToken(),
															(t!=null?t.getText():null));
								}
								grammar.checkRuleReference(scope, t, targ, currentRuleName);
								if ( grammar.type==Grammar.LEXER )
								{
									if ( grammar.getTokenType((t!=null?t.getText():null))==Label.EOF )
									{
										retval.code = templates.getInstanceOf("lexerMatchEOF");
									}
									else
									{
										retval.code = templates.getInstanceOf("lexerRuleRef");
										if ( isListLabel(labelText) )
										{
											retval.code = templates.getInstanceOf("lexerRuleRefAndListLabel");
										}
										String scopeName = null;
										if ( scope!=null )
										{
											scopeName = scope.getText();
										}
										Rule rdef2 = grammar.getRule(scopeName, (t!=null?t.getText():null));
										retval.code.add("rule", rdef2);
										if ( scope!=null )
										{ // scoped rule ref
											Grammar scopeG = grammar.composite.getGrammar(scope.getText());
											retval.code.add("scope", scopeG);
										}
										else if ( rdef2.grammar != this.grammar )
										{ // nonlocal
											// if rule definition is not in this grammar, it's nonlocal
											retval.code.add("scope", rdef2.grammar);
										}
										if ( targ!=null )
										{
											List<? extends Object> args = generator.translateAction(currentRuleName,targ);
											retval.code.add("args", args);
										}
									}
									int i = ((CommonToken)t.getToken()).getTokenIndex();
									retval.code.add("elementIndex", i);
									if ( label!=null )
										retval.code.add("label", labelText);
								}
								else
								{
									retval.code = getTokenElementST("tokenRef", (t!=null?t.getText():null), t, astSuffix, labelText);
									String tokenLabel =
										generator.getTokenTypeAsTargetLabel(grammar.getTokenType(t.getText()));
									retval.code.add("token",tokenLabel);
									if ( !currentAltHasASTRewrite && t.terminalOptions!=null )
									{
										retval.code.add("terminalOptions", t.terminalOptions);
									}
									int i = ((CommonToken)t.getToken()).getTokenIndex();
									retval.code.add("elementIndex", i);
									generator.generateLocalFOLLOW(t,tokenLabel,currentRuleName,i);
								}
								t.code = retval.code;
							}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1083:4: c= CHAR_LITERAL
					{
					c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1532); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								if ( grammar.type==Grammar.LEXER )
								{
									retval.code = templates.getInstanceOf("charRef");
									retval.code.add("char",
									   generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,(c!=null?c.getText():null)));
									if ( label!=null )
									{
										retval.code.add("label", labelText);
									}
								}
								else { // else it's a token type reference
									retval.code = getTokenElementST("tokenRef", "char_literal", c, astSuffix, labelText);
									String tokenLabel = generator.getTokenTypeAsTargetLabel(grammar.getTokenType((c!=null?c.getText():null)));
									retval.code.add("token",tokenLabel);
									if ( c.terminalOptions!=null ) {
										retval.code.add("terminalOptions",c.terminalOptions);
									}
									int i = ((CommonToken)c.getToken()).getTokenIndex();
									retval.code.add("elementIndex", i);
									generator.generateLocalFOLLOW(c,tokenLabel,currentRuleName,i);
								}
							}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1108:4: s= STRING_LITERAL
					{
					s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1544); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								int i = ((CommonToken)s.getToken()).getTokenIndex();
								if ( grammar.type==Grammar.LEXER )
								{
									retval.code = templates.getInstanceOf("lexerStringRef");
									retval.code.add("string",
										generator.target.getTargetStringLiteralFromANTLRStringLiteral(generator,(s!=null?s.getText():null)));
									retval.code.add("elementIndex", i);
									if ( label!=null )
									{
										retval.code.add("label", labelText);
									}
								}
								else
								{
									// else it's a token type reference
									retval.code = getTokenElementST("tokenRef", "string_literal", s, astSuffix, labelText);
									String tokenLabel =
										generator.getTokenTypeAsTargetLabel(grammar.getTokenType((s!=null?s.getText():null)));
									retval.code.add("token",tokenLabel);
									if ( s.terminalOptions!=null )
									{
										retval.code.add("terminalOptions",s.terminalOptions);
									}
									retval.code.add("elementIndex", i);
									generator.generateLocalFOLLOW(s,tokenLabel,currentRuleName,i);
								}
							}
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1138:4: w= WILDCARD
					{
					w=(GrammarAST)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1556); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								retval.code = getWildcardST(w,astSuffix,labelText);
								retval.code.add("elementIndex", ((CommonToken)w.getToken()).getTokenIndex());
							}
					}
					break;
				case 6 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1144:4: ^( DOT ID a= atom[$ID, label, astSuffix] )
					{
					match(input,DOT,FOLLOW_DOT_in_atom1567); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					ID11=(GrammarAST)match(input,ID,FOLLOW_ID_in_atom1569); if (state.failed) return retval;
					pushFollow(FOLLOW_atom_in_atom1573);
					a=atom(ID11, label, astSuffix);
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = (a!=null?((CodeGenTreeWalker.atom_return)a).code:null); }
					}
					break;
				case 7 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1147:4: set[label,astSuffix]
					{
					pushFollow(FOLLOW_set_in_atom1586);
					set12=set(label, astSuffix);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = set12; }
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
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1151:1: ast_suffix : ( ROOT | BANG );
	public final void ast_suffix() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1152:2: ( ROOT | BANG )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:
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



	// $ANTLR start "set"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1156:1: set[GrammarAST label, GrammarAST astSuffix] returns [ST code=null] : ^(s= BLOCK ( . )* ) ;
	public final ST set(GrammarAST label, GrammarAST astSuffix) throws RecognitionException {
		ST code = null;


		GrammarAST s=null;


			String labelText=null;
			if ( label!=null )
			{
				labelText = label.getText();
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1165:2: ( ^(s= BLOCK ( . )* ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1165:4: ^(s= BLOCK ( . )* )
			{
			s=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_set1631); if (state.failed) return code;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return code;
				// org/antlr/grammar/v3/CodeGenTreeWalker.g:1165:14: ( . )*
				loop56:
				while (true) {
					int alt56=2;
					int LA56_0 = input.LA(1);
					if ( ((LA56_0 >= ACTION && LA56_0 <= XDIGIT)) ) {
						alt56=1;
					}
					else if ( (LA56_0==UP) ) {
						alt56=2;
					}

					switch (alt56) {
					case 1 :
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:1165:14: .
						{
						matchAny(input); if (state.failed) return code;
						}
						break;

					default :
						break loop56;
					}
				}

				match(input, Token.UP, null); if (state.failed) return code;
			}

			if ( state.backtracking==0 ) {
						code = getTokenElementST("matchSet", "set", s, astSuffix, labelText);
						int i = ((CommonToken)s.getToken()).getTokenIndex();
						code.add("elementIndex", i);
						if ( grammar.type!=Grammar.LEXER )
						{
							generator.generateLocalFOLLOW(s,"set",currentRuleName,i);
						}
						code.add("s", generator.genSetExpr(templates,s.getSetValue(),1,false));
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
		return code;
	}
	// $ANTLR end "set"



	// $ANTLR start "setElement"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1178:1: setElement : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL | ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ) );
	public final void setElement() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1179:2: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL | ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ) )
			int alt57=4;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				alt57=1;
				}
				break;
			case TOKEN_REF:
				{
				alt57=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt57=3;
				}
				break;
			case CHAR_RANGE:
				{
				alt57=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}
			switch (alt57) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1179:4: CHAR_LITERAL
					{
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1651); if (state.failed) return;
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1180:4: TOKEN_REF
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_setElement1656); if (state.failed) return;
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1181:4: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement1661); if (state.failed) return;
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1182:4: ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL )
					{
					match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_setElement1667); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1669); if (state.failed) return;
					match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1671); if (state.failed) return;
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


	public static class rewrite_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "rewrite"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1187:1: rewrite returns [ST code=null] : ( ^( REWRITES ( ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative ) )* ) |);
	public final CodeGenTreeWalker.rewrite_return rewrite() throws RecognitionException {
		CodeGenTreeWalker.rewrite_return retval = new CodeGenTreeWalker.rewrite_return();
		retval.start = input.LT(1);

		GrammarAST r=null;
		GrammarAST pred=null;
		ST alt =null;


			if ( state.backtracking == 0 )
			{
				if ( ((GrammarAST)retval.start).getType()==REWRITES )
				{
					if ( generator.grammar.buildTemplate() )
					{
						retval.code = templates.getInstanceOf("rewriteTemplate");
					}
					else
					{
						retval.code = templates.getInstanceOf("rewriteCode");
						retval.code.add("treeLevel", OUTER_REWRITE_NESTING_LEVEL);
						retval.code.add("rewriteBlockLevel", OUTER_REWRITE_NESTING_LEVEL);
						retval.code.add("referencedElementsDeep",
										  getTokenTypesAsTargetLabels(((GrammarAST)retval.start).rewriteRefsDeep));
						Set<String> tokenLabels =
							grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.TOKEN_LABEL);
						Set<String> tokenListLabels =
							grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.TOKEN_LIST_LABEL);
						Set<String> ruleLabels =
							grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.RULE_LABEL);
						Set<String> ruleListLabels =
							grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.RULE_LIST_LABEL);
						Set<String> wildcardLabels =
							grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.WILDCARD_TREE_LABEL);
						Set<String> wildcardListLabels =
							grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.WILDCARD_TREE_LIST_LABEL);
						// just in case they ref r for "previous value", make a stream
						// from retval.tree
						ST retvalST = templates.getInstanceOf("prevRuleRootRef");
						ruleLabels.add(retvalST.render());
						retval.code.add("referencedTokenLabels", tokenLabels);
						retval.code.add("referencedTokenListLabels", tokenListLabels);
						retval.code.add("referencedRuleLabels", ruleLabels);
						retval.code.add("referencedRuleListLabels", ruleListLabels);
						retval.code.add("referencedWildcardLabels", wildcardLabels);
						retval.code.add("referencedWildcardListLabels", wildcardListLabels);
					}
				}
				else
				{
						retval.code = templates.getInstanceOf("noRewrite");
						retval.code.add("treeLevel", OUTER_REWRITE_NESTING_LEVEL);
						retval.code.add("rewriteBlockLevel", OUTER_REWRITE_NESTING_LEVEL);
				}
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1237:2: ( ^( REWRITES ( ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative ) )* ) |)
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==REWRITES) ) {
				alt60=1;
			}
			else if ( (LA60_0==ALT||LA60_0==EOB) ) {
				alt60=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				throw nvae;
			}

			switch (alt60) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1237:4: ^( REWRITES ( ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative ) )* )
					{
					match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1696); if (state.failed) return retval;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return retval;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:1238:4: ( ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative ) )*
						loop59:
						while (true) {
							int alt59=2;
							int LA59_0 = input.LA(1);
							if ( (LA59_0==REWRITE) ) {
								alt59=1;
							}

							switch (alt59) {
							case 1 :
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:1239:5: ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative )
								{
								if ( state.backtracking==0 ) {rewriteRuleRefs = new HashSet<Object>();}
								r=(GrammarAST)match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1717); if (state.failed) return retval;
								match(input, Token.DOWN, null); if (state.failed) return retval;
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:1240:18: (pred= SEMPRED )?
								int alt58=2;
								int LA58_0 = input.LA(1);
								if ( (LA58_0==SEMPRED) ) {
									alt58=1;
								}
								switch (alt58) {
									case 1 :
										// org/antlr/grammar/v3/CodeGenTreeWalker.g:1240:19: pred= SEMPRED
										{
										pred=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite1722); if (state.failed) return retval;
										}
										break;

								}

								pushFollow(FOLLOW_rewrite_alternative_in_rewrite1728);
								alt=rewrite_alternative();
								state._fsp--;
								if (state.failed) return retval;
								match(input, Token.UP, null); if (state.failed) return retval;

								if ( state.backtracking==0 ) {
													rewriteBlockNestingLevel = OUTER_REWRITE_NESTING_LEVEL;
													List<? extends Object> predChunks = null;
													if ( pred!=null )
													{
														//predText = #pred.getText();
														predChunks = generator.translateAction(currentRuleName,pred);
													}
													String description =
														grammar.grammarTreeToString(r,false);
													description = generator.target.getTargetStringLiteralFromString(description);
													retval.code.addAggr("alts.{pred,alt,description}",
																	  predChunks,
																	  alt,
																	  description);
													pred=null;
												}
								}
								break;

							default :
								break loop59;
							}
						}

						match(input, Token.UP, null); if (state.failed) return retval;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1261:2: 
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



	// $ANTLR start "rewrite_block"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1263:1: rewrite_block[String blockTemplateName] returns [ST code=null] : ^( BLOCK alt= rewrite_alternative EOB ) ;
	public final ST rewrite_block(String blockTemplateName) throws RecognitionException {
		ST code = null;


		GrammarAST BLOCK13=null;
		ST alt =null;


			rewriteBlockNestingLevel++;
			ST save_currentBlockST = currentBlockST;
			if ( state.backtracking == 0 )
			{
				code = templates.getInstanceOf(blockTemplateName);
				currentBlockST = code;
				code.add("rewriteBlockLevel", rewriteBlockNestingLevel);
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1275:2: ( ^( BLOCK alt= rewrite_alternative EOB ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1275:4: ^( BLOCK alt= rewrite_alternative EOB )
			{
			BLOCK13=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_rewrite_block1771); if (state.failed) return code;
			if ( state.backtracking==0 ) {
							currentBlockST.add("referencedElementsDeep",
								getTokenTypesAsTargetLabels(BLOCK13.rewriteRefsDeep));
							currentBlockST.add("referencedElements",
								getTokenTypesAsTargetLabels(BLOCK13.rewriteRefsShallow));
						}
			match(input, Token.DOWN, null); if (state.failed) return code;
			pushFollow(FOLLOW_rewrite_alternative_in_rewrite_block1783);
			alt=rewrite_alternative();
			state._fsp--;
			if (state.failed) return code;
			match(input,EOB,FOLLOW_EOB_in_rewrite_block1788); if (state.failed) return code;
			match(input, Token.UP, null); if (state.failed) return code;

			if ( state.backtracking==0 ) {
						code.add("alt", alt);
					}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			 rewriteBlockNestingLevel--; currentBlockST = save_currentBlockST; 
		}
		return code;
	}
	// $ANTLR end "rewrite_block"



	// $ANTLR start "rewrite_alternative"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1291:1: rewrite_alternative returns [ST code=null] : ({...}? ^(a= ALT ( (el= rewrite_element )+ | EPSILON ) EOA ) |{...}? rewrite_template | ETC );
	public final ST rewrite_alternative() throws RecognitionException {
		ST code = null;


		GrammarAST a=null;
		TreeRuleReturnScope el =null;
		ST rewrite_template14 =null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1292:2: ({...}? ^(a= ALT ( (el= rewrite_element )+ | EPSILON ) EOA ) |{...}? rewrite_template | ETC )
			int alt63=3;
			switch ( input.LA(1) ) {
			case ALT:
				{
				int LA63_1 = input.LA(2);
				if ( (LA63_1==DOWN) ) {
					int LA63_4 = input.LA(3);
					if ( (LA63_4==EPSILON) ) {
						int LA63_5 = input.LA(4);
						if ( (LA63_5==EOA) ) {
							int LA63_7 = input.LA(5);
							if ( (LA63_7==UP) ) {
								int LA63_8 = input.LA(6);
								if ( ((generator.grammar.buildAST())) ) {
									alt63=1;
								}
								else if ( ((generator.grammar.buildTemplate())) ) {
									alt63=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return code;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 63, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return code;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 63, 7, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return code;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 63, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA63_4==ACTION||LA63_4==CHAR_LITERAL||LA63_4==CLOSURE||LA63_4==LABEL||LA63_4==OPTIONAL||LA63_4==POSITIVE_CLOSURE||LA63_4==RULE_REF||LA63_4==STRING_LITERAL||LA63_4==TOKEN_REF||LA63_4==TREE_BEGIN) ) {
						alt63=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return code;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 63, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return code;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 63, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ACTION:
			case TEMPLATE:
				{
				alt63=2;
				}
				break;
			case ETC:
				{
				alt63=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return code;}
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}
			switch (alt63) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1292:4: {...}? ^(a= ALT ( (el= rewrite_element )+ | EPSILON ) EOA )
					{
					if ( !((generator.grammar.buildAST())) ) {
						if (state.backtracking>0) {state.failed=true; return code;}
						throw new FailedPredicateException(input, "rewrite_alternative", "generator.grammar.buildAST()");
					}
					a=(GrammarAST)match(input,ALT,FOLLOW_ALT_in_rewrite_alternative1823); if (state.failed) return code;
					if ( state.backtracking==0 ) {code =templates.getInstanceOf("rewriteElementList");}
					match(input, Token.DOWN, null); if (state.failed) return code;
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1294:4: ( (el= rewrite_element )+ | EPSILON )
					int alt62=2;
					int LA62_0 = input.LA(1);
					if ( (LA62_0==ACTION||LA62_0==CHAR_LITERAL||LA62_0==CLOSURE||LA62_0==LABEL||LA62_0==OPTIONAL||LA62_0==POSITIVE_CLOSURE||LA62_0==RULE_REF||LA62_0==STRING_LITERAL||LA62_0==TOKEN_REF||LA62_0==TREE_BEGIN) ) {
						alt62=1;
					}
					else if ( (LA62_0==EPSILON) ) {
						alt62=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return code;}
						NoViableAltException nvae =
							new NoViableAltException("", 62, 0, input);
						throw nvae;
					}

					switch (alt62) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1294:6: (el= rewrite_element )+
							{
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1294:6: (el= rewrite_element )+
							int cnt61=0;
							loop61:
							while (true) {
								int alt61=2;
								int LA61_0 = input.LA(1);
								if ( (LA61_0==ACTION||LA61_0==CHAR_LITERAL||LA61_0==CLOSURE||LA61_0==LABEL||LA61_0==OPTIONAL||LA61_0==POSITIVE_CLOSURE||LA61_0==RULE_REF||LA61_0==STRING_LITERAL||LA61_0==TOKEN_REF||LA61_0==TREE_BEGIN) ) {
									alt61=1;
								}

								switch (alt61) {
								case 1 :
									// org/antlr/grammar/v3/CodeGenTreeWalker.g:1295:6: el= rewrite_element
									{
									pushFollow(FOLLOW_rewrite_element_in_rewrite_alternative1841);
									el=rewrite_element();
									state._fsp--;
									if (state.failed) return code;
									if ( state.backtracking==0 ) {code.addAggr("elements.{el,line,pos}",
																			(el!=null?((CodeGenTreeWalker.rewrite_element_return)el).code:null),
																			(el!=null?((GrammarAST)el.start):null).getLine(),
																			(el!=null?((GrammarAST)el.start):null).getCharPositionInLine() + 1
																			);
														}
									}
									break;

								default :
									if ( cnt61 >= 1 ) break loop61;
									if (state.backtracking>0) {state.failed=true; return code;}
									EarlyExitException eee = new EarlyExitException(61, input);
									throw eee;
								}
								cnt61++;
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1303:6: EPSILON
							{
							match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_alternative1862); if (state.failed) return code;
							if ( state.backtracking==0 ) {code.addAggr("elements.{el,line,pos}",
															   templates.getInstanceOf("rewriteEmptyAlt"),
															   a.getLine(),
															   a.getCharPositionInLine() + 1
															   );
											}
							}
							break;

					}

					match(input,EOA,FOLLOW_EOA_in_rewrite_alternative1878); if (state.failed) return code;
					match(input, Token.UP, null); if (state.failed) return code;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1314:4: {...}? rewrite_template
					{
					if ( !((generator.grammar.buildTemplate())) ) {
						if (state.backtracking>0) {state.failed=true; return code;}
						throw new FailedPredicateException(input, "rewrite_alternative", "generator.grammar.buildTemplate()");
					}
					pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative1891);
					rewrite_template14=rewrite_template();
					state._fsp--;
					if (state.failed) return code;
					if ( state.backtracking==0 ) { code = rewrite_template14; }
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1318:3: ETC
					{
					match(input,ETC,FOLLOW_ETC_in_rewrite_alternative1904); if (state.failed) return code;
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
		return code;
	}
	// $ANTLR end "rewrite_alternative"


	public static class rewrite_element_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "rewrite_element"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1321:1: rewrite_element returns [ST code=null] : ( rewrite_atom[false] | rewrite_ebnf | rewrite_tree );
	public final CodeGenTreeWalker.rewrite_element_return rewrite_element() throws RecognitionException {
		CodeGenTreeWalker.rewrite_element_return retval = new CodeGenTreeWalker.rewrite_element_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope rewrite_atom15 =null;
		TreeRuleReturnScope rewrite_ebnf16 =null;
		TreeRuleReturnScope rewrite_tree17 =null;


			IntSet elements=null;
			GrammarAST ast = null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1327:2: ( rewrite_atom[false] | rewrite_ebnf | rewrite_tree )
			int alt64=3;
			switch ( input.LA(1) ) {
			case ACTION:
			case CHAR_LITERAL:
			case LABEL:
			case RULE_REF:
			case STRING_LITERAL:
			case TOKEN_REF:
				{
				alt64=1;
				}
				break;
			case CLOSURE:
			case OPTIONAL:
			case POSITIVE_CLOSURE:
				{
				alt64=2;
				}
				break;
			case TREE_BEGIN:
				{
				alt64=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 64, 0, input);
				throw nvae;
			}
			switch (alt64) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1327:4: rewrite_atom[false]
					{
					pushFollow(FOLLOW_rewrite_atom_in_rewrite_element1924);
					rewrite_atom15=rewrite_atom(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = (rewrite_atom15!=null?((CodeGenTreeWalker.rewrite_atom_return)rewrite_atom15).code:null); }
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1329:4: rewrite_ebnf
					{
					pushFollow(FOLLOW_rewrite_ebnf_in_rewrite_element1934);
					rewrite_ebnf16=rewrite_ebnf();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = (rewrite_ebnf16!=null?((CodeGenTreeWalker.rewrite_ebnf_return)rewrite_ebnf16).code:null); }
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1331:4: rewrite_tree
					{
					pushFollow(FOLLOW_rewrite_tree_in_rewrite_element1943);
					rewrite_tree17=rewrite_tree();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.code = (rewrite_tree17!=null?((CodeGenTreeWalker.rewrite_tree_return)rewrite_tree17).code:null); }
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
	// $ANTLR end "rewrite_element"


	public static class rewrite_ebnf_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "rewrite_ebnf"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1335:1: rewrite_ebnf returns [ST code=null] : ( ^( OPTIONAL rewrite_block[\"rewriteOptionalBlock\"] ) | ^( CLOSURE rewrite_block[\"rewriteClosureBlock\"] ) | ^( POSITIVE_CLOSURE rewrite_block[\"rewritePositiveClosureBlock\"] ) );
	public final CodeGenTreeWalker.rewrite_ebnf_return rewrite_ebnf() throws RecognitionException {
		CodeGenTreeWalker.rewrite_ebnf_return retval = new CodeGenTreeWalker.rewrite_ebnf_return();
		retval.start = input.LT(1);

		ST rewrite_block18 =null;
		ST rewrite_block19 =null;
		ST rewrite_block20 =null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1336:2: ( ^( OPTIONAL rewrite_block[\"rewriteOptionalBlock\"] ) | ^( CLOSURE rewrite_block[\"rewriteClosureBlock\"] ) | ^( POSITIVE_CLOSURE rewrite_block[\"rewritePositiveClosureBlock\"] ) )
			int alt65=3;
			switch ( input.LA(1) ) {
			case OPTIONAL:
				{
				alt65=1;
				}
				break;
			case CLOSURE:
				{
				alt65=2;
				}
				break;
			case POSITIVE_CLOSURE:
				{
				alt65=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 65, 0, input);
				throw nvae;
			}
			switch (alt65) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1336:4: ^( OPTIONAL rewrite_block[\"rewriteOptionalBlock\"] )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_rewrite_ebnf1964); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf1966);
					rewrite_block18=rewrite_block("rewriteOptionalBlock");
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = rewrite_block18; }
					if ( state.backtracking==0 ) {
								String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
								description = generator.target.getTargetStringLiteralFromString(description);
								retval.code.add("description", description);
							}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1343:4: ^( CLOSURE rewrite_block[\"rewriteClosureBlock\"] )
					{
					match(input,CLOSURE,FOLLOW_CLOSURE_in_rewrite_ebnf1984); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf1986);
					rewrite_block19=rewrite_block("rewriteClosureBlock");
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = rewrite_block19; }
					if ( state.backtracking==0 ) {
								String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
								description = generator.target.getTargetStringLiteralFromString(description);
								retval.code.add("description", description);
							}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1350:4: ^( POSITIVE_CLOSURE rewrite_block[\"rewritePositiveClosureBlock\"] )
					{
					match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_rewrite_ebnf2004); if (state.failed) return retval;
					match(input, Token.DOWN, null); if (state.failed) return retval;
					pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf2006);
					rewrite_block20=rewrite_block("rewritePositiveClosureBlock");
					state._fsp--;
					if (state.failed) return retval;
					match(input, Token.UP, null); if (state.failed) return retval;

					if ( state.backtracking==0 ) { retval.code = rewrite_block20; }
					if ( state.backtracking==0 ) {
								String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
								description = generator.target.getTargetStringLiteralFromString(description);
								retval.code.add("description", description);
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
	// $ANTLR end "rewrite_ebnf"


	public static class rewrite_tree_return extends TreeRuleReturnScope {
		public ST code;
	};


	// $ANTLR start "rewrite_tree"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1359:1: rewrite_tree returns [ST code] : ^( TREE_BEGIN r= rewrite_atom[true] (el= rewrite_element )* ) ;
	public final CodeGenTreeWalker.rewrite_tree_return rewrite_tree() throws RecognitionException {
		CodeGenTreeWalker.rewrite_tree_return retval = new CodeGenTreeWalker.rewrite_tree_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope r =null;
		TreeRuleReturnScope el =null;


			rewriteTreeNestingLevel++;
			if ( state.backtracking == 0 )
			{
				retval.code = templates.getInstanceOf("rewriteTree");
				retval.code.add("treeLevel", rewriteTreeNestingLevel);
				retval.code.add("enclosingTreeLevel", rewriteTreeNestingLevel-1);
			}

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1370:2: ( ^( TREE_BEGIN r= rewrite_atom[true] (el= rewrite_element )* ) )
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1370:4: ^( TREE_BEGIN r= rewrite_atom[true] (el= rewrite_element )* )
			{
			match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree2039); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			pushFollow(FOLLOW_rewrite_atom_in_rewrite_tree2046);
			r=rewrite_atom(true);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {
							retval.code.addAggr("root.{el,line,pos}",
											   (r!=null?((CodeGenTreeWalker.rewrite_atom_return)r).code:null),
											   (r!=null?((GrammarAST)r.start):null).getLine(),
											   (r!=null?((GrammarAST)r.start):null).getCharPositionInLine() + 1
											  );
						}
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1379:4: (el= rewrite_element )*
			loop66:
			while (true) {
				int alt66=2;
				int LA66_0 = input.LA(1);
				if ( (LA66_0==ACTION||LA66_0==CHAR_LITERAL||LA66_0==CLOSURE||LA66_0==LABEL||LA66_0==OPTIONAL||LA66_0==POSITIVE_CLOSURE||LA66_0==RULE_REF||LA66_0==STRING_LITERAL||LA66_0==TOKEN_REF||LA66_0==TREE_BEGIN) ) {
					alt66=1;
				}

				switch (alt66) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1380:6: el= rewrite_element
					{
					pushFollow(FOLLOW_rewrite_element_in_rewrite_tree2066);
					el=rewrite_element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
									retval.code.addAggr("children.{el,line,pos}",
														(el!=null?((CodeGenTreeWalker.rewrite_element_return)el).code:null),
														(el!=null?((GrammarAST)el.start):null).getLine(),
														(el!=null?((GrammarAST)el.start):null).getCharPositionInLine() + 1
														);
								  }
					}
					break;

				default :
					break loop66;
				}
			}

			match(input, Token.UP, null); if (state.failed) return retval;

			if ( state.backtracking==0 ) {
						String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
						description = generator.target.getTargetStringLiteralFromString(description);
						retval.code.add("description", description);
					}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			 rewriteTreeNestingLevel--; 
		}
		return retval;
	}
	// $ANTLR end "rewrite_tree"


	public static class rewrite_atom_return extends TreeRuleReturnScope {
		public ST code=null;
	};


	// $ANTLR start "rewrite_atom"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1398:1: rewrite_atom[boolean isRoot] returns [ST code=null] : (r= RULE_REF | ( ^(tk= TOKEN_REF (arg= ARG_ACTION )? ) |cl= CHAR_LITERAL |sl= STRING_LITERAL ) | LABEL | ACTION );
	public final CodeGenTreeWalker.rewrite_atom_return rewrite_atom(boolean isRoot) throws RecognitionException {
		CodeGenTreeWalker.rewrite_atom_return retval = new CodeGenTreeWalker.rewrite_atom_return();
		retval.start = input.LT(1);

		GrammarAST r=null;
		GrammarAST tk=null;
		GrammarAST arg=null;
		GrammarAST cl=null;
		GrammarAST sl=null;
		GrammarAST LABEL21=null;
		GrammarAST ACTION22=null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1399:2: (r= RULE_REF | ( ^(tk= TOKEN_REF (arg= ARG_ACTION )? ) |cl= CHAR_LITERAL |sl= STRING_LITERAL ) | LABEL | ACTION )
			int alt69=4;
			switch ( input.LA(1) ) {
			case RULE_REF:
				{
				alt69=1;
				}
				break;
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case TOKEN_REF:
				{
				alt69=2;
				}
				break;
			case LABEL:
				{
				alt69=3;
				}
				break;
			case ACTION:
				{
				alt69=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}
			switch (alt69) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1399:6: r= RULE_REF
					{
					r=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_atom2111); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								String ruleRefName = (r!=null?r.getText():null);
								String stName = "rewriteRuleRef";
								if ( isRoot )
								{
									stName += "Root";
								}
								retval.code = templates.getInstanceOf(stName);
								retval.code.add("rule", ruleRefName);
								if ( grammar.getRule(ruleRefName)==null )
								{
									ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_RULE_REF,
															  grammar,
															  r.getToken(),
															  ruleRefName);
									retval.code = new ST(""); // blank; no code gen
								}
								else if ( grammar.getRule(currentRuleName)
											 .getRuleRefsInAlt(ruleRefName,outerAltNum)==null )
								{
									ErrorManager.grammarError(ErrorManager.MSG_REWRITE_ELEMENT_NOT_PRESENT_ON_LHS,
															  grammar,
															  r.getToken(),
															  ruleRefName);
									retval.code = new ST(""); // blank; no code gen
								}
								else
								{
									// track all rule refs as we must copy 2nd ref to rule and beyond
									if ( !rewriteRuleRefs.contains(ruleRefName) )
									{
										rewriteRuleRefs.add(ruleRefName);
									}
								}
							}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1437:3: ( ^(tk= TOKEN_REF (arg= ARG_ACTION )? ) |cl= CHAR_LITERAL |sl= STRING_LITERAL )
					{
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1437:3: ( ^(tk= TOKEN_REF (arg= ARG_ACTION )? ) |cl= CHAR_LITERAL |sl= STRING_LITERAL )
					int alt68=3;
					switch ( input.LA(1) ) {
					case TOKEN_REF:
						{
						alt68=1;
						}
						break;
					case CHAR_LITERAL:
						{
						alt68=2;
						}
						break;
					case STRING_LITERAL:
						{
						alt68=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 68, 0, input);
						throw nvae;
					}
					switch (alt68) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1437:5: ^(tk= TOKEN_REF (arg= ARG_ACTION )? )
							{
							tk=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_atom2128); if (state.failed) return retval;
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); if (state.failed) return retval;
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:1437:20: (arg= ARG_ACTION )?
								int alt67=2;
								int LA67_0 = input.LA(1);
								if ( (LA67_0==ARG_ACTION) ) {
									alt67=1;
								}
								switch (alt67) {
									case 1 :
										// org/antlr/grammar/v3/CodeGenTreeWalker.g:1437:21: arg= ARG_ACTION
										{
										arg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_atom2133); if (state.failed) return retval;
										}
										break;

								}

								match(input, Token.UP, null); if (state.failed) return retval;
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1438:5: cl= CHAR_LITERAL
							{
							cl=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_atom2144); if (state.failed) return retval;
							}
							break;
						case 3 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1439:5: sl= STRING_LITERAL
							{
							sl=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_atom2152); if (state.failed) return retval;
							}
							break;

					}

					if ( state.backtracking==0 ) {
								GrammarAST term = tk;
								if (term == null) term = cl;
								if (term == null) term = sl;
								String tokenName = ((GrammarAST)retval.start).getToken().getText();
								String stName = "rewriteTokenRef";
								Rule rule = grammar.getRule(currentRuleName);
								Collection<String> tokenRefsInAlt = rule.getTokenRefsInAlt(outerAltNum);
								boolean createNewNode = !tokenRefsInAlt.contains(tokenName) || arg!=null;
								if ( createNewNode )
								{
									stName = "rewriteImaginaryTokenRef";
								}
								if ( isRoot )
								{
									stName += "Root";
								}
								retval.code = templates.getInstanceOf(stName);
								if (term.terminalOptions != null) {
									retval.code.add("terminalOptions",term.terminalOptions);
								}
								if ( arg!=null )
								{
									List<? extends Object> args = generator.translateAction(currentRuleName,arg);
									retval.code.add("args", args);
								}
								retval.code.add("elementIndex", ((CommonToken)((GrammarAST)retval.start).getToken()).getTokenIndex());
								int ttype = grammar.getTokenType(tokenName);
								String tok = generator.getTokenTypeAsTargetLabel(ttype);
								retval.code.add("token", tok);
								if ( grammar.getTokenType(tokenName)==Label.INVALID )
								{
									ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_TOKEN_REF_IN_REWRITE,
															  grammar,
															  ((GrammarAST)retval.start).getToken(),
															  tokenName);
									retval.code = new ST(""); // blank; no code gen
								}
							}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1481:4: LABEL
					{
					LABEL21=(GrammarAST)match(input,LABEL,FOLLOW_LABEL_in_rewrite_atom2166); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								String labelName = (LABEL21!=null?LABEL21.getText():null);
								Rule rule = grammar.getRule(currentRuleName);
								Grammar.LabelElementPair pair = rule.getLabel(labelName);
								if ( labelName.equals(currentRuleName) )
								{
									// special case; ref to old value via $ rule
									if ( rule.hasRewrite(outerAltNum) &&
										 rule.getRuleRefsInAlt(outerAltNum).contains(labelName) )
									{
										ErrorManager.grammarError(ErrorManager.MSG_RULE_REF_AMBIG_WITH_RULE_IN_ALT,
																  grammar,
																  LABEL21.getToken(),
																  labelName);
									}
									ST labelST = templates.getInstanceOf("prevRuleRootRef");
									retval.code = templates.getInstanceOf("rewriteRuleLabelRef"+(isRoot?"Root":""));
									retval.code.add("label", labelST);
								}
								else if ( pair==null )
								{
									ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_LABEL_REF_IN_REWRITE,
															  grammar,
															  LABEL21.getToken(),
															  labelName);
									retval.code = new ST("");
								}
								else
								{
									String stName = null;
									switch ( pair.type )
									{
									case Grammar.TOKEN_LABEL :
										stName = "rewriteTokenLabelRef";
										break;
									case Grammar.WILDCARD_TREE_LABEL :
										stName = "rewriteWildcardLabelRef";
										break;
									case Grammar.WILDCARD_TREE_LIST_LABEL:
										stName = "rewriteRuleListLabelRef"; // acts like rule ref list for ref
										break;
									case Grammar.RULE_LABEL :
										stName = "rewriteRuleLabelRef";
										break;
									case Grammar.TOKEN_LIST_LABEL :
										stName = "rewriteTokenListLabelRef";
										break;
									case Grammar.RULE_LIST_LABEL :
										stName = "rewriteRuleListLabelRef";
										break;
									}
									if ( isRoot )
									{
										stName += "Root";
									}
									retval.code = templates.getInstanceOf(stName);
									retval.code.add("label", labelName);
								}
							}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1542:4: ACTION
					{
					ACTION22=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_atom2176); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
								// actions in rewrite rules yield a tree object
								String actText = (ACTION22!=null?ACTION22.getText():null);
								List<? extends Object> chunks = generator.translateAction(currentRuleName,ACTION22);
								retval.code = templates.getInstanceOf("rewriteNodeAction"+(isRoot?"Root":""));
								retval.code.add("action", chunks);
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
	// $ANTLR end "rewrite_atom"



	// $ANTLR start "rewrite_template"
	// org/antlr/grammar/v3/CodeGenTreeWalker.g:1553:1: public rewrite_template returns [ST code=null] : ( ^( ALT EPSILON EOA ) | ^( TEMPLATE (id= ID |ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) |act= ACTION );
	public final ST rewrite_template() throws RecognitionException {
		ST code = null;


		GrammarAST id=null;
		GrammarAST ind=null;
		GrammarAST arg=null;
		GrammarAST a=null;
		GrammarAST act=null;
		GrammarAST DOUBLE_QUOTE_STRING_LITERAL23=null;
		GrammarAST DOUBLE_ANGLE_STRING_LITERAL24=null;

		try {
			// org/antlr/grammar/v3/CodeGenTreeWalker.g:1554:2: ( ^( ALT EPSILON EOA ) | ^( TEMPLATE (id= ID |ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) |act= ACTION )
			int alt73=3;
			switch ( input.LA(1) ) {
			case ALT:
				{
				alt73=1;
				}
				break;
			case TEMPLATE:
				{
				alt73=2;
				}
				break;
			case ACTION:
				{
				alt73=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return code;}
				NoViableAltException nvae =
					new NoViableAltException("", 73, 0, input);
				throw nvae;
			}
			switch (alt73) {
				case 1 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1554:4: ^( ALT EPSILON EOA )
					{
					match(input,ALT,FOLLOW_ALT_in_rewrite_template2199); if (state.failed) return code;
					match(input, Token.DOWN, null); if (state.failed) return code;
					match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_template2201); if (state.failed) return code;
					match(input,EOA,FOLLOW_EOA_in_rewrite_template2203); if (state.failed) return code;
					match(input, Token.UP, null); if (state.failed) return code;

					if ( state.backtracking==0 ) {code =templates.getInstanceOf("rewriteEmptyTemplate");}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1555:4: ^( TEMPLATE (id= ID |ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? )
					{
					match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template2214); if (state.failed) return code;
					match(input, Token.DOWN, null); if (state.failed) return code;
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1555:16: (id= ID |ind= ACTION )
					int alt70=2;
					int LA70_0 = input.LA(1);
					if ( (LA70_0==ID) ) {
						alt70=1;
					}
					else if ( (LA70_0==ACTION) ) {
						alt70=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return code;}
						NoViableAltException nvae =
							new NoViableAltException("", 70, 0, input);
						throw nvae;
					}

					switch (alt70) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1555:17: id= ID
							{
							id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template2219); if (state.failed) return code;
							}
							break;
						case 2 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1555:23: ind= ACTION
							{
							ind=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template2223); if (state.failed) return code;
							}
							break;

					}

					if ( state.backtracking==0 ) {
									if ( id!=null && (id!=null?id.getText():null).equals("template") )
									{
											code = templates.getInstanceOf("rewriteInlineTemplate");
									}
									else if ( id!=null )
									{
											code = templates.getInstanceOf("rewriteExternalTemplate");
											code.add("name", (id!=null?id.getText():null));
									}
									else if ( ind!=null )
									{ // must be %({expr})(args)
										code = templates.getInstanceOf("rewriteIndirectTemplate");
										List<? extends Object> chunks=generator.translateAction(currentRuleName,ind);
										code.add("expr", chunks);
									}
								}
					match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template2236); if (state.failed) return code;
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); if (state.failed) return code;
						// org/antlr/grammar/v3/CodeGenTreeWalker.g:1574:5: ( ^( ARG arg= ID a= ACTION ) )*
						loop71:
						while (true) {
							int alt71=2;
							int LA71_0 = input.LA(1);
							if ( (LA71_0==ARG) ) {
								alt71=1;
							}

							switch (alt71) {
							case 1 :
								// org/antlr/grammar/v3/CodeGenTreeWalker.g:1574:7: ^( ARG arg= ID a= ACTION )
								{
								match(input,ARG,FOLLOW_ARG_in_rewrite_template2246); if (state.failed) return code;
								match(input, Token.DOWN, null); if (state.failed) return code;
								arg=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template2250); if (state.failed) return code;
								a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template2254); if (state.failed) return code;
								if ( state.backtracking==0 ) {
														// must set alt num here rather than in define.g
														// because actions like %foo(name={$ID.text}) aren't
														// broken up yet into trees.
														a.outerAltNum = this.outerAltNum;
														List<? extends Object> chunks = generator.translateAction(currentRuleName,a);
														code.addAggr("args.{name,value}", (arg!=null?arg.getText():null), chunks);
													}
								match(input, Token.UP, null); if (state.failed) return code;

								}
								break;

							default :
								break loop71;
							}
						}

						match(input, Token.UP, null); if (state.failed) return code;
					}

					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1586:4: ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )?
					int alt72=3;
					int LA72_0 = input.LA(1);
					if ( (LA72_0==DOUBLE_QUOTE_STRING_LITERAL) ) {
						alt72=1;
					}
					else if ( (LA72_0==DOUBLE_ANGLE_STRING_LITERAL) ) {
						alt72=2;
					}
					switch (alt72) {
						case 1 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1586:6: DOUBLE_QUOTE_STRING_LITERAL
							{
							DOUBLE_QUOTE_STRING_LITERAL23=(GrammarAST)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template2287); if (state.failed) return code;
							if ( state.backtracking==0 ) {
												String sl = (DOUBLE_QUOTE_STRING_LITERAL23!=null?DOUBLE_QUOTE_STRING_LITERAL23.getText():null);
												String t = sl.substring( 1, sl.length() - 1 ); // strip quotes
												t = generator.target.getTargetStringLiteralFromString(t);
												code.add("template",t);
											}
							}
							break;
						case 2 :
							// org/antlr/grammar/v3/CodeGenTreeWalker.g:1593:6: DOUBLE_ANGLE_STRING_LITERAL
							{
							DOUBLE_ANGLE_STRING_LITERAL24=(GrammarAST)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template2300); if (state.failed) return code;
							if ( state.backtracking==0 ) {
												String sl = (DOUBLE_ANGLE_STRING_LITERAL24!=null?DOUBLE_ANGLE_STRING_LITERAL24.getText():null);
												String t = sl.substring( 2, sl.length() - 2 ); // strip double angle quotes
												t = generator.target.getTargetStringLiteralFromString(t);
												code.add("template",t);
											}
							}
							break;

					}

					match(input, Token.UP, null); if (state.failed) return code;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/CodeGenTreeWalker.g:1603:4: act= ACTION
					{
					act=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template2324); if (state.failed) return code;
					if ( state.backtracking==0 ) {
								// set alt num for same reason as ARGLIST above
								act.outerAltNum = this.outerAltNum;
								code =templates.getInstanceOf("rewriteAction");
								code.add("action",
												  generator.translateAction(currentRuleName,act));
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
		return code;
	}
	// $ANTLR end "rewrite_template"

	// $ANTLR start synpred1_CodeGenTreeWalker
	public final void synpred1_CodeGenTreeWalker_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/CodeGenTreeWalker.g:750:4: ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )
		// org/antlr/grammar/v3/CodeGenTreeWalker.g:750:5: {...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE )
		{
		if ( !((((GrammarAST)input.LT(1)).getSetValue()==null)) ) {
			if (state.backtracking>0) {state.failed=true; return;}
			throw new FailedPredicateException(input, "synpred1_CodeGenTreeWalker", "((GrammarAST)input.LT(1)).getSetValue()==null");
		}
		if ( input.LA(1)==BLOCK||input.LA(1)==CLOSURE||input.LA(1)==OPTIONAL||input.LA(1)==POSITIVE_CLOSURE ) {
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
	// $ANTLR end synpred1_CodeGenTreeWalker

	// $ANTLR start synpred2_CodeGenTreeWalker
	public final void synpred2_CodeGenTreeWalker_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/CodeGenTreeWalker.g:918:6: ( element_action )
		// org/antlr/grammar/v3/CodeGenTreeWalker.g:918:7: element_action
		{
		pushFollow(FOLLOW_element_action_in_synpred2_CodeGenTreeWalker1405);
		element_action();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_CodeGenTreeWalker

	// Delegated rules

	public final boolean synpred2_CodeGenTreeWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_CodeGenTreeWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_CodeGenTreeWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_CodeGenTreeWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_LEXER_GRAMMAR_in_grammar_67 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_69 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARSER_GRAMMAR_in_grammar_79 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_81 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammar_91 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_93 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMBINED_GRAMMAR_in_grammar_103 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_105 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SCOPE_in_attrScope124 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_attrScope126 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_AMPERSAND_in_attrScope131 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_attrScope140 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_grammarSpec157 = new BitSet(new long[]{0x0400200008000200L,0x0000000020028002L});
	public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec165 = new BitSet(new long[]{0x0400200000000200L,0x0000000020028002L});
	public static final BitSet FOLLOW_OPTIONS_in_grammarSpec186 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IMPORT_in_grammarSpec200 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TOKENS_in_grammarSpec214 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_attrScope_in_grammarSpec226 = new BitSet(new long[]{0x0000000000000200L,0x0000000000028002L});
	public static final BitSet FOLLOW_AMPERSAND_in_grammarSpec235 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rules_in_grammarSpec246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_rules291 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008002L});
	public static final BitSet FOLLOW_RULE_in_rules305 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_PREC_RULE_in_rules317 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_RULE_in_rule359 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule363 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
	public static final BitSet FOLLOW_modifier_in_rule376 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ARG_in_rule384 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule387 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RET_in_rule396 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule399 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_throwsSpec_in_rule408 = new BitSet(new long[]{0x0400000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_OPTIONS_in_rule418 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_rule431 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_AMPERSAND_in_rule441 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_rule455 = new BitSet(new long[]{0x0000004400020000L});
	public static final BitSet FOLLOW_exceptionGroup_in_rule468 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_EOR_in_rule476 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_THROWS_in_throwsSpec526 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_throwsSpec528 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec543 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_AMPERSAND_in_ruleScopeSpec548 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec558 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_ID_in_ruleScopeSpec564 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_setBlock_in_block605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block618 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_OPTIONS_in_block626 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alternative_in_block643 = new BitSet(new long[]{0x0000000200000100L,0x0000000000001000L});
	public static final BitSet FOLLOW_rewrite_in_block648 = new BitSet(new long[]{0x0000000200000100L});
	public static final BitSet FOLLOW_EOB_in_block665 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_setBlock697 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ALT_in_setAlternative717 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_setElement_in_setAlternative719 = new BitSet(new long[]{0x00000001000C0000L,0x0000000041000000L});
	public static final BitSet FOLLOW_EOA_in_setAlternative722 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup737 = new BitSet(new long[]{0x0000004000020002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CATCH_in_exceptionHandler766 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler768 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_exceptionHandler770 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FINALLY_in_finallyClause788 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_finallyClause790 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_alternative820 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_alternative833 = new BitSet(new long[]{0x82800289202DE010L,0x0000000547092001L});
	public static final BitSet FOLLOW_EOA_in_alternative851 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ROOT_in_element886 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element890 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BANG_in_element903 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element907 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_element923 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_notElement_in_element927 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_element942 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element946 = new BitSet(new long[]{0x82800288202DE010L,0x0000000547092001L});
	public static final BitSet FOLLOW_element_in_element950 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_ASSIGN_in_element965 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element969 = new BitSet(new long[]{0x82800288202DE010L,0x0000000547092001L});
	public static final BitSet FOLLOW_element_in_element973 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_RANGE_in_element987 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_element991 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_element995 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ebnf_in_element1024 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_element1035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tree__in_element1046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_action_in_element1056 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMPRED_in_element1071 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GATED_SEMPRED_in_element1075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYN_SEMPRED_in_element1086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYNPRED_in_element1094 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element1105 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_EPSILON_in_element1117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_element_action1134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FORCED_ACTION_in_element_action1145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_notElement1174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_notElement1187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_notElement1200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_notElement1214 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_ebnf1280 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1284 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CLOSURE_in_ebnf1305 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1309 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1330 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1334 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1372 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_tree_1379 = new BitSet(new long[]{0x82800288202DE018L,0x0000000547092001L});
	public static final BitSet FOLLOW_element_action_in_tree_1416 = new BitSet(new long[]{0x82800288202DE018L,0x0000000547092001L});
	public static final BitSet FOLLOW_element_in_tree_1438 = new BitSet(new long[]{0x82800288202DE018L,0x0000000547092001L});
	public static final BitSet FOLLOW_RULE_REF_in_atom1488 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1493 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom1511 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1516 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_atom1544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WILDCARD_in_atom1556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_atom1567 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_atom1569 = new BitSet(new long[]{0x0000000020050000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_atom1573 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_atom1586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_set1631 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_setElement1656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_setElement1661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_RANGE_in_setElement1667 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1669 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1671 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REWRITES_in_rewrite1696 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite1717 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_SEMPRED_in_rewrite1722 = new BitSet(new long[]{0x0000002000000110L,0x0000000008000000L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite1728 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_rewrite_block1771 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite_block1783 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_EOB_in_rewrite_block1788 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_rewrite_alternative1823 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_element_in_rewrite_alternative1841 = new BitSet(new long[]{0x0201000100240010L,0x0000000141010001L});
	public static final BitSet FOLLOW_EPSILON_in_rewrite_alternative1862 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_rewrite_alternative1878 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative1891 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ETC_in_rewrite_alternative1904 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_atom_in_rewrite_element1924 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_ebnf_in_rewrite_element1934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_in_rewrite_element1943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_rewrite_ebnf1964 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf1966 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CLOSURE_in_rewrite_ebnf1984 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf1986 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_rewrite_ebnf2004 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf2006 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree2039 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rewrite_atom_in_rewrite_tree2046 = new BitSet(new long[]{0x0201000000240018L,0x0000000141010001L});
	public static final BitSet FOLLOW_rewrite_element_in_rewrite_tree2066 = new BitSet(new long[]{0x0201000000240018L,0x0000000141010001L});
	public static final BitSet FOLLOW_RULE_REF_in_rewrite_atom2111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_atom2128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_atom2133 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_atom2144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_atom2152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LABEL_in_rewrite_atom2166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_atom2176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALT_in_rewrite_template2199 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_EPSILON_in_rewrite_template2201 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOA_in_rewrite_template2203 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template2214 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rewrite_template2219 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template2223 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ARGLIST_in_rewrite_template2236 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_in_rewrite_template2246 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rewrite_template2250 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template2254 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template2287 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template2300 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template2324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_synpred1_CodeGenTreeWalker1009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_action_in_synpred2_CodeGenTreeWalker1405 = new BitSet(new long[]{0x0000000000000002L});
}
