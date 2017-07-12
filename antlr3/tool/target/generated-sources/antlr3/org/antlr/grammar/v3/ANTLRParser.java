// $ANTLR 3.5 org/antlr/grammar/v3/ANTLR.g 2017-06-11 18:42:19

package org.antlr.grammar.v3;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Grammar;
import org.antlr.tool.GrammarAST;
import org.antlr.misc.IntSet;
import org.antlr.tool.Rule;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


/** Read in an ANTLR grammar and build an AST.  Try not to do
 *  any actions, just build the tree.
 *
 *  The phases are:
 *
 *		antlr.g (this file)
 *		assign.types.g
 *		define.g
 *		buildnfa.g
 *		antlr.print.g (optional)
 *		codegen.g
 *
 *  Terence Parr
 *  University of San Francisco
 *  2005
 */
@SuppressWarnings("all")
public class ANTLRParser extends Parser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ANTLRParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ANTLRParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ANTLRParser.tokenNames; }
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/ANTLR.g"; }


	protected String currentRuleName = null;
	protected GrammarAST currentBlockAST = null;
	protected boolean atTreeRoot; // are we matching a tree root in tree grammar?

	public static ANTLRParser createParser(TokenStream input) {
	    ANTLRParser parser = new ANTLRParser(input);
	    parser.adaptor = new grammar_Adaptor(parser);
	    return parser;
	}

	private static class GrammarASTErrorNode extends GrammarAST {
	    public IntStream input;
	    public Token start;
	    public Token stop;
	    public RecognitionException trappedException;

	    public GrammarASTErrorNode(TokenStream input, Token start, Token stop, RecognitionException e) {
	        super(stop);
	        //Console.Out.WriteLine( "start: " + start + ", stop: " + stop );
	        if ( stop == null ||
	             ( stop.getTokenIndex() < start.getTokenIndex() &&
	              stop.getType() != Token.EOF) ) {
	            // sometimes resync does not consume a token (when LT(1) is
	            // in follow set.  So, stop will be 1 to left to start. adjust.
	            // Also handle case where start is the first token and no token
	            // is consumed during recovery; LT(-1) will return null.
	            stop = start;
	        }
	        this.input = input;
	        this.start = start;
	        this.stop = stop;
	        this.trappedException = e;
	    }

	    @Override
	    public boolean isNil() { return false; }

	    @Override
	    public String getText() {
	        String badText = null;
	        if (start != null) {
	            int i = start.getTokenIndex();
	            int j = stop.getTokenIndex();
	            if (stop.getType() == Token.EOF) {
	                j = input.size();
	            }
	            badText = ((TokenStream)input).toString(i, j);
	        } else {
	            // people should subclass if they alter the tree type so this
	            // next one is for sure correct.
	            badText = "<unknown>";
	        }
	        return badText;
	    }

	    @Override
	    public void setText(String value) { }

	    @Override
	    public int getType() { return Token.INVALID_TOKEN_TYPE; }

	    @Override
	    public void setType(int value) { }

	    @Override
	    public String toString()
	    {
	        if (trappedException instanceof MissingTokenException)
	        {
	            return "<missing type: " +
	                   ( (MissingTokenException)trappedException ).getMissingType() +
	                   ">";
	        } else if (trappedException instanceof UnwantedTokenException) {
	            return "<extraneous: " +
	                   ( (UnwantedTokenException)trappedException ).getUnexpectedToken() +
	                   ", resync=" + getText() + ">";
	        } else if (trappedException instanceof MismatchedTokenException) {
	            return "<mismatched token: " + trappedException.token + ", resync=" + getText() + ">";
	        } else if (trappedException instanceof NoViableAltException) {
	            return "<unexpected: " + trappedException.token +
	                   ", resync=" + getText() + ">";
	        }
	        return "<error: " + getText() + ">";
	    }
	}

	static class grammar_Adaptor extends CommonTreeAdaptor {
	    ANTLRParser _outer;

	    public grammar_Adaptor(ANTLRParser outer) {
	        _outer = outer;
	    }

	    @Override
	    public Object create(Token payload) {
	        GrammarAST t = new GrammarAST( payload );
	        if (_outer != null)
	            t.enclosingRuleName = _outer.currentRuleName;
	        return t;
	    }

	    @Override
	    public Object errorNode(TokenStream input, Token start, Token stop, RecognitionException e) {
	        GrammarAST t = new GrammarASTErrorNode(input, start, stop, e);
	        if (_outer != null)
	            t.enclosingRuleName = _outer.currentRuleName;
	        return t;
	    }
	}

	private Grammar grammar;
	private int grammarType;
	private String fileName;

	public Grammar getGrammar() {
	    return grammar;
	}

	public void setGrammar(Grammar value) {
	    grammar = value;
	}

	public int getGrammarType() {
	    return grammarType;
	}

	public void setGrammarType(int value) {
	    grammarType = value;
	}

	public String getFileName() {
	    return fileName;
	}

	public void setFileName(String value) {
	    fileName = value;
	}

	private final int LA(int i) { return input.LA( i ); }

	private final Token LT(int k) { return input.LT( k ); }

	/*partial void createTreeAdaptor(ref ITreeAdaptor adaptor)
	{
	    adaptor = new grammar_Adaptor(this);
	}*/

	protected GrammarAST setToBlockWithSet(GrammarAST b) {
	    /*
	     * alt = ^(ALT["ALT"] {b} EOA["EOA"])
	     * prefixWithSynpred( alt )
	     * return ^(BLOCK["BLOCK"] {alt} EOB["<end-of-block>"])
	     */
	    GrammarAST alt = (GrammarAST)adaptor.create(ALT, "ALT");
	    adaptor.addChild(alt, b);
	    adaptor.addChild(alt, adaptor.create(EOA, "<end-of-alt>"));

	    prefixWithSynPred(alt);

	    GrammarAST block = (GrammarAST)adaptor.create(BLOCK, b.getToken(), "BLOCK");
	    adaptor.addChild(block, alt);
	    adaptor.addChild(alt, adaptor.create(EOB, "<end-of-block>"));

	    return block;
	}

	/** Create a copy of the alt and make it into a BLOCK; all actions,
	 *  labels, tree operators, rewrites are removed.
	 */
	protected GrammarAST createBlockFromDupAlt(GrammarAST alt) {
	    /*
	     * ^(BLOCK["BLOCK"] {GrammarAST.dupTreeNoActions(alt)} EOB["<end-of-block>"])
	     */
	    GrammarAST nalt = GrammarAST.dupTreeNoActions(alt, null);

	    GrammarAST block = (GrammarAST)adaptor.create(BLOCK, alt.getToken(), "BLOCK");
	    adaptor.addChild( block, nalt );
	    adaptor.addChild( block, adaptor.create( EOB, "<end-of-block>" ) );

	    return block;
	}

	/** Rewrite alt to have a synpred as first element;
	 *  (xxx)=&gt;xxx
	 *  but only if they didn't specify one manually.
	 */
	protected void prefixWithSynPred( GrammarAST alt ) {
	    // if they want backtracking and it's not a lexer rule in combined grammar
	    String autoBacktrack = (String)grammar.getBlockOption( currentBlockAST, "backtrack" );
	    if ( autoBacktrack == null )
	    {
	        autoBacktrack = (String)grammar.getOption( "backtrack" );
	    }
	    if ( autoBacktrack != null && autoBacktrack.equals( "true" ) &&
	         !( grammarType == Grammar.COMBINED &&
	         Rule.getRuleType(currentRuleName) == Grammar.LEXER) &&
	         alt.getChild( 0 ).getType() != SYN_SEMPRED )
	    {
	        // duplicate alt and make a synpred block around that dup'd alt
	        GrammarAST synpredBlockAST = createBlockFromDupAlt( alt );

	        // Create a BACKTRACK_SEMPRED node as if user had typed this in
	        // Effectively we replace (xxx)=>xxx with {synpredxxx}? xxx
	        GrammarAST synpredAST = createSynSemPredFromBlock( synpredBlockAST,
	                                                          BACKTRACK_SEMPRED );

	        // insert BACKTRACK_SEMPRED as first element of alt
	        //synpredAST.getLastSibling().setNextSibling( alt.getFirstChild() );
	        //synpredAST.addChild( alt.getFirstChild() );
	        //alt.setFirstChild( synpredAST );
	        GrammarAST[] children = alt.getChildrenAsArray();
	        adaptor.setChild( alt, 0, synpredAST );
	        for ( int i = 0; i < children.length; i++ )
	        {
	            if ( i < children.length - 1 )
	                adaptor.setChild( alt, i + 1, children[i] );
	            else
	                adaptor.addChild( alt, children[i] );
	        }
	    }
	}

	protected GrammarAST createSynSemPredFromBlock( GrammarAST synpredBlockAST, int synpredTokenType ) {
	    // add grammar fragment to a list so we can make fake rules for them later.
	    String predName = grammar.defineSyntacticPredicate( synpredBlockAST, currentRuleName );
	    // convert (alpha)=> into {synpredN}? where N is some pred count
	    // during code gen we convert to function call with templates
	    String synpredinvoke = predName;
	    GrammarAST p = (GrammarAST)adaptor.create( synpredTokenType, synpredinvoke );
	    // track how many decisions have synpreds
	    grammar.blocksWithSynPreds.add( currentBlockAST );
	    return p;
	}

	public static GrammarAST createSimpleRuleAST( String name, GrammarAST block, boolean fragment ) {
	    TreeAdaptor adaptor = new grammar_Adaptor(null);

	    GrammarAST modifier = null;
	    if ( fragment )
	    {
	        modifier = (GrammarAST)adaptor.create( FRAGMENT, "fragment" );
	    }

	    /*
	     * EOBAST = block.getLastChild()
	     * ^(RULE[block,"rule"] ID["name"] {modifier} ARG["ARG"] RET["RET"] SCOPE["scope"] {block} EOR[EOBAST,"<end-of-rule>"])
	     */
	    GrammarAST rule = (GrammarAST)adaptor.create( RULE, block.getToken(), "rule" );

	    adaptor.addChild( rule, adaptor.create( ID, name ) );
	    if ( modifier != null )
	        adaptor.addChild( rule, modifier );
	    adaptor.addChild( rule, adaptor.create( ARG, "ARG" ) );
	    adaptor.addChild( rule, adaptor.create( RET, "RET" ) );
	    adaptor.addChild( rule, adaptor.create( SCOPE, "scope" ) );
	    adaptor.addChild( rule, block );
	    adaptor.addChild( rule, adaptor.create( EOR, block.getLastChild().getToken(), "<end-of-rule>" ) );

	    return rule;
	}

	@Override
	public void reportError(RecognitionException ex)
	{
	    //Token token = null;
	    //try
	    //{
	    //    token = LT( 1 );
	    //}
	    //catch ( TokenStreamException tse )
	    //{
	    //    ErrorManager.internalError( "can't get token???", tse );
	    //}
	    Token token = ex.token;
	    ErrorManager.syntaxError(
	        ErrorManager.MSG_SYNTAX_ERROR,
	        grammar,
	        token,
	        "antlr: " + ex.toString(),
	        ex );
	}

	public void cleanup( GrammarAST root )
	{
	    if ( grammarType == Grammar.LEXER )
	    {
	        String filter = (String)grammar.getOption( "filter" );
	        GrammarAST tokensRuleAST =
	            grammar.addArtificialMatchTokensRule(
	                root,
	                grammar.lexerRuleNamesInCombined,
	                grammar.getDelegateNames(),
	                filter != null && filter.equals( "true" ) );
	    }
	}


	public static class grammar__return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "grammar_"
	// org/antlr/grammar/v3/ANTLR.g:457:1: public grammar_[Grammar g] : ( ACTION )? (cmt= DOC_COMMENT )? gr= grammarType gid= id SEMI ( optionsSpec )? (ig= delegateGrammars )? (ts= tokensSpec )? scopes= attrScopes (a= actions )? r= rules EOF -> ^( $gr $gid ( $cmt)? ( optionsSpec )? ( $ig)? ( $ts)? ( $scopes)? ( $a)? $r) ;
	public final ANTLRParser.grammar__return grammar_(Grammar g) throws RecognitionException {
		ANTLRParser.grammar__return retval = new ANTLRParser.grammar__return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token cmt=null;
		Token ACTION1=null;
		Token SEMI2=null;
		Token EOF4=null;
		ParserRuleReturnScope gr =null;
		ParserRuleReturnScope gid =null;
		ParserRuleReturnScope ig =null;
		ParserRuleReturnScope ts =null;
		ParserRuleReturnScope scopes =null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope r =null;
		ParserRuleReturnScope optionsSpec3 =null;

		GrammarAST cmt_tree=null;
		GrammarAST ACTION1_tree=null;
		GrammarAST SEMI2_tree=null;
		GrammarAST EOF4_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_tokensSpec=new RewriteRuleSubtreeStream(adaptor,"rule tokensSpec");
		RewriteRuleSubtreeStream stream_grammarType=new RewriteRuleSubtreeStream(adaptor,"rule grammarType");
		RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
		RewriteRuleSubtreeStream stream_delegateGrammars=new RewriteRuleSubtreeStream(adaptor,"rule delegateGrammars");
		RewriteRuleSubtreeStream stream_rules=new RewriteRuleSubtreeStream(adaptor,"rule rules");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
		RewriteRuleSubtreeStream stream_actions=new RewriteRuleSubtreeStream(adaptor,"rule actions");
		RewriteRuleSubtreeStream stream_attrScopes=new RewriteRuleSubtreeStream(adaptor,"rule attrScopes");


			this.grammar = g;
			Map<String, Object> opts;

		try {
			// org/antlr/grammar/v3/ANTLR.g:467:2: ( ( ACTION )? (cmt= DOC_COMMENT )? gr= grammarType gid= id SEMI ( optionsSpec )? (ig= delegateGrammars )? (ts= tokensSpec )? scopes= attrScopes (a= actions )? r= rules EOF -> ^( $gr $gid ( $cmt)? ( optionsSpec )? ( $ig)? ( $ts)? ( $scopes)? ( $a)? $r) )
			// org/antlr/grammar/v3/ANTLR.g:468:3: ( ACTION )? (cmt= DOC_COMMENT )? gr= grammarType gid= id SEMI ( optionsSpec )? (ig= delegateGrammars )? (ts= tokensSpec )? scopes= attrScopes (a= actions )? r= rules EOF
			{
			// org/antlr/grammar/v3/ANTLR.g:468:3: ( ACTION )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==ACTION) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:468:5: ACTION
					{
					ACTION1=(Token)match(input,ACTION,FOLLOW_ACTION_in_grammar_324); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ACTION.add(ACTION1);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:469:3: (cmt= DOC_COMMENT )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==DOC_COMMENT) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:469:5: cmt= DOC_COMMENT
					{
					cmt=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammar_335); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOC_COMMENT.add(cmt);

					}
					break;

			}

			pushFollow(FOLLOW_grammarType_in_grammar_345);
			gr=grammarType();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_grammarType.add(gr.getTree());
			pushFollow(FOLLOW_id_in_grammar_349);
			gid=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(gid.getTree());
			if ( state.backtracking==0 ) {grammar.setName((gid!=null?input.toString(gid.start,gid.stop):null));}
			SEMI2=(Token)match(input,SEMI,FOLLOW_SEMI_in_grammar_353); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI2);

			// org/antlr/grammar/v3/ANTLR.g:471:3: ( optionsSpec )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==OPTIONS) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:471:5: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_grammar_359);
					optionsSpec3=optionsSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_optionsSpec.add(optionsSpec3.getTree());
					if ( state.backtracking==0 ) {opts = (optionsSpec3!=null?((ANTLRParser.optionsSpec_return)optionsSpec3).opts:null); grammar.setOptions(opts, (optionsSpec3!=null?(optionsSpec3.start):null));}
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:473:3: (ig= delegateGrammars )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==IMPORT) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:473:4: ig= delegateGrammars
					{
					pushFollow(FOLLOW_delegateGrammars_in_grammar_373);
					ig=delegateGrammars();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_delegateGrammars.add(ig.getTree());
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:474:3: (ts= tokensSpec )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==TOKENS) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:474:4: ts= tokensSpec
					{
					pushFollow(FOLLOW_tokensSpec_in_grammar_382);
					ts=tokensSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tokensSpec.add(ts.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_attrScopes_in_grammar_390);
			scopes=attrScopes();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_attrScopes.add(scopes.getTree());
			// org/antlr/grammar/v3/ANTLR.g:476:3: (a= actions )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==AMPERSAND) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:476:4: a= actions
					{
					pushFollow(FOLLOW_actions_in_grammar_397);
					a=actions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_actions.add(a.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_rules_in_grammar_405);
			r=rules();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rules.add(r.getTree());
			EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_grammar_409); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF4);

			// AST REWRITE
			// elements: cmt, ig, ts, a, gr, scopes, optionsSpec, gid, r
			// token labels: cmt
			// rule labels: a, r, gid, gr, scopes, ig, retval, ts
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_cmt=new RewriteRuleTokenStream(adaptor,"token cmt",cmt);
			RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
			RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.getTree():null);
			RewriteRuleSubtreeStream stream_gid=new RewriteRuleSubtreeStream(adaptor,"rule gid",gid!=null?gid.getTree():null);
			RewriteRuleSubtreeStream stream_gr=new RewriteRuleSubtreeStream(adaptor,"rule gr",gr!=null?gr.getTree():null);
			RewriteRuleSubtreeStream stream_scopes=new RewriteRuleSubtreeStream(adaptor,"rule scopes",scopes!=null?scopes.getTree():null);
			RewriteRuleSubtreeStream stream_ig=new RewriteRuleSubtreeStream(adaptor,"rule ig",ig!=null?ig.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_ts=new RewriteRuleSubtreeStream(adaptor,"rule ts",ts!=null?ts.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 479:3: -> ^( $gr $gid ( $cmt)? ( optionsSpec )? ( $ig)? ( $ts)? ( $scopes)? ( $a)? $r)
			{
				// org/antlr/grammar/v3/ANTLR.g:479:6: ^( $gr $gid ( $cmt)? ( optionsSpec )? ( $ig)? ( $ts)? ( $scopes)? ( $a)? $r)
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot(stream_gr.nextNode(), root_1);
				adaptor.addChild(root_1, stream_gid.nextTree());
				// org/antlr/grammar/v3/ANTLR.g:479:18: ( $cmt)?
				if ( stream_cmt.hasNext() ) {
					adaptor.addChild(root_1, stream_cmt.nextNode());
				}
				stream_cmt.reset();

				// org/antlr/grammar/v3/ANTLR.g:479:23: ( optionsSpec )?
				if ( stream_optionsSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_optionsSpec.nextTree());
				}
				stream_optionsSpec.reset();

				// org/antlr/grammar/v3/ANTLR.g:479:37: ( $ig)?
				if ( stream_ig.hasNext() ) {
					adaptor.addChild(root_1, stream_ig.nextTree());
				}
				stream_ig.reset();

				// org/antlr/grammar/v3/ANTLR.g:479:42: ( $ts)?
				if ( stream_ts.hasNext() ) {
					adaptor.addChild(root_1, stream_ts.nextTree());
				}
				stream_ts.reset();

				// org/antlr/grammar/v3/ANTLR.g:479:47: ( $scopes)?
				if ( stream_scopes.hasNext() ) {
					adaptor.addChild(root_1, stream_scopes.nextTree());
				}
				stream_scopes.reset();

				// org/antlr/grammar/v3/ANTLR.g:479:56: ( $a)?
				if ( stream_a.hasNext() ) {
					adaptor.addChild(root_1, stream_a.nextTree());
				}
				stream_a.reset();

				adaptor.addChild(root_1, stream_r.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
				cleanup( retval.tree );
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "grammar_"


	public static class grammarType_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "grammarType"
	// org/antlr/grammar/v3/ANTLR.g:482:1: grammarType : ( 'lexer' gr= 'grammar' -> LEXER_GRAMMAR[$gr] | 'parser' gr= 'grammar' -> PARSER_GRAMMAR[$gr] | 'tree' gr= 'grammar' -> TREE_GRAMMAR[$gr] |gr= 'grammar' -> COMBINED_GRAMMAR[$gr] ) ;
	public final ANTLRParser.grammarType_return grammarType() throws RecognitionException {
		ANTLRParser.grammarType_return retval = new ANTLRParser.grammarType_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token gr=null;
		Token string_literal5=null;
		Token string_literal6=null;
		Token string_literal7=null;

		GrammarAST gr_tree=null;
		GrammarAST string_literal5_tree=null;
		GrammarAST string_literal6_tree=null;
		GrammarAST string_literal7_tree=null;
		RewriteRuleTokenStream stream_PARSER=new RewriteRuleTokenStream(adaptor,"token PARSER");
		RewriteRuleTokenStream stream_LEXER=new RewriteRuleTokenStream(adaptor,"token LEXER");
		RewriteRuleTokenStream stream_GRAMMAR=new RewriteRuleTokenStream(adaptor,"token GRAMMAR");
		RewriteRuleTokenStream stream_TREE=new RewriteRuleTokenStream(adaptor,"token TREE");

		try {
			// org/antlr/grammar/v3/ANTLR.g:483:2: ( ( 'lexer' gr= 'grammar' -> LEXER_GRAMMAR[$gr] | 'parser' gr= 'grammar' -> PARSER_GRAMMAR[$gr] | 'tree' gr= 'grammar' -> TREE_GRAMMAR[$gr] |gr= 'grammar' -> COMBINED_GRAMMAR[$gr] ) )
			// org/antlr/grammar/v3/ANTLR.g:483:4: ( 'lexer' gr= 'grammar' -> LEXER_GRAMMAR[$gr] | 'parser' gr= 'grammar' -> PARSER_GRAMMAR[$gr] | 'tree' gr= 'grammar' -> TREE_GRAMMAR[$gr] |gr= 'grammar' -> COMBINED_GRAMMAR[$gr] )
			{
			// org/antlr/grammar/v3/ANTLR.g:483:4: ( 'lexer' gr= 'grammar' -> LEXER_GRAMMAR[$gr] | 'parser' gr= 'grammar' -> PARSER_GRAMMAR[$gr] | 'tree' gr= 'grammar' -> TREE_GRAMMAR[$gr] |gr= 'grammar' -> COMBINED_GRAMMAR[$gr] )
			int alt7=4;
			switch ( input.LA(1) ) {
			case LEXER:
				{
				alt7=1;
				}
				break;
			case PARSER:
				{
				alt7=2;
				}
				break;
			case TREE:
				{
				alt7=3;
				}
				break;
			case GRAMMAR:
				{
				alt7=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:483:6: 'lexer' gr= 'grammar'
					{
					string_literal5=(Token)match(input,LEXER,FOLLOW_LEXER_in_grammarType460); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEXER.add(string_literal5);

					gr=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType465); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GRAMMAR.add(gr);

					if ( state.backtracking==0 ) {grammarType=Grammar.LEXER; grammar.type = Grammar.LEXER;}
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 484:4: -> LEXER_GRAMMAR[$gr]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(LEXER_GRAMMAR, gr));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:485:5: 'parser' gr= 'grammar'
					{
					string_literal6=(Token)match(input,PARSER,FOLLOW_PARSER_in_grammarType488); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PARSER.add(string_literal6);

					gr=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType492); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GRAMMAR.add(gr);

					if ( state.backtracking==0 ) {grammarType=Grammar.PARSER; grammar.type = Grammar.PARSER;}
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 486:4: -> PARSER_GRAMMAR[$gr]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(PARSER_GRAMMAR, gr));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:487:5: 'tree' gr= 'grammar'
					{
					string_literal7=(Token)match(input,TREE,FOLLOW_TREE_in_grammarType513); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TREE.add(string_literal7);

					gr=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType519); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GRAMMAR.add(gr);

					if ( state.backtracking==0 ) {grammarType=Grammar.TREE_PARSER; grammar.type = Grammar.TREE_PARSER;}
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 488:4: -> TREE_GRAMMAR[$gr]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(TREE_GRAMMAR, gr));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:489:8: gr= 'grammar'
					{
					gr=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType542); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GRAMMAR.add(gr);

					if ( state.backtracking==0 ) {grammarType=Grammar.COMBINED; grammar.type = Grammar.COMBINED;}
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 490:4: -> COMBINED_GRAMMAR[$gr]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(COMBINED_GRAMMAR, gr));
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "grammarType"


	public static class actions_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "actions"
	// org/antlr/grammar/v3/ANTLR.g:494:1: actions : ( action )+ ;
	public final ANTLRParser.actions_return actions() throws RecognitionException {
		ANTLRParser.actions_return retval = new ANTLRParser.actions_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope action8 =null;


		try {
			// org/antlr/grammar/v3/ANTLR.g:495:2: ( ( action )+ )
			// org/antlr/grammar/v3/ANTLR.g:495:4: ( action )+
			{
			root_0 = (GrammarAST)adaptor.nil();


			// org/antlr/grammar/v3/ANTLR.g:495:4: ( action )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==AMPERSAND) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:495:5: action
					{
					pushFollow(FOLLOW_action_in_actions569);
					action8=action();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, action8.getTree());

					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "actions"


	public static class action_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "action"
	// org/antlr/grammar/v3/ANTLR.g:499:1: action : AMPERSAND ^ ( actionScopeName COLON ! COLON !)? id ACTION ;
	public final ANTLRParser.action_return action() throws RecognitionException {
		ANTLRParser.action_return retval = new ANTLRParser.action_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token AMPERSAND9=null;
		Token COLON11=null;
		Token COLON12=null;
		Token ACTION14=null;
		ParserRuleReturnScope actionScopeName10 =null;
		ParserRuleReturnScope id13 =null;

		GrammarAST AMPERSAND9_tree=null;
		GrammarAST COLON11_tree=null;
		GrammarAST COLON12_tree=null;
		GrammarAST ACTION14_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:500:2: ( AMPERSAND ^ ( actionScopeName COLON ! COLON !)? id ACTION )
			// org/antlr/grammar/v3/ANTLR.g:500:4: AMPERSAND ^ ( actionScopeName COLON ! COLON !)? id ACTION
			{
			root_0 = (GrammarAST)adaptor.nil();


			AMPERSAND9=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_action584); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			AMPERSAND9_tree = (GrammarAST)adaptor.create(AMPERSAND9);
			root_0 = (GrammarAST)adaptor.becomeRoot(AMPERSAND9_tree, root_0);
			}

			// org/antlr/grammar/v3/ANTLR.g:500:15: ( actionScopeName COLON ! COLON !)?
			int alt9=2;
			switch ( input.LA(1) ) {
				case TOKEN_REF:
					{
					int LA9_1 = input.LA(2);
					if ( (LA9_1==COLON) ) {
						alt9=1;
					}
					}
					break;
				case RULE_REF:
					{
					int LA9_2 = input.LA(2);
					if ( (LA9_2==COLON) ) {
						alt9=1;
					}
					}
					break;
				case LEXER:
				case PARSER:
					{
					alt9=1;
					}
					break;
			}
			switch (alt9) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:500:16: actionScopeName COLON ! COLON !
					{
					pushFollow(FOLLOW_actionScopeName_in_action588);
					actionScopeName10=actionScopeName();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, actionScopeName10.getTree());

					COLON11=(Token)match(input,COLON,FOLLOW_COLON_in_action590); if (state.failed) return retval;
					COLON12=(Token)match(input,COLON,FOLLOW_COLON_in_action593); if (state.failed) return retval;
					}
					break;

			}

			pushFollow(FOLLOW_id_in_action598);
			id13=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id13.getTree());

			ACTION14=(Token)match(input,ACTION,FOLLOW_ACTION_in_action600); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ACTION14_tree = (GrammarAST)adaptor.create(ACTION14);
			adaptor.addChild(root_0, ACTION14_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "action"


	public static class actionScopeName_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "actionScopeName"
	// org/antlr/grammar/v3/ANTLR.g:506:1: actionScopeName : ( id |l= 'lexer' -> ID[$l] |p= 'parser' -> ID[$p] );
	public final ANTLRParser.actionScopeName_return actionScopeName() throws RecognitionException {
		ANTLRParser.actionScopeName_return retval = new ANTLRParser.actionScopeName_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token l=null;
		Token p=null;
		ParserRuleReturnScope id15 =null;

		GrammarAST l_tree=null;
		GrammarAST p_tree=null;
		RewriteRuleTokenStream stream_PARSER=new RewriteRuleTokenStream(adaptor,"token PARSER");
		RewriteRuleTokenStream stream_LEXER=new RewriteRuleTokenStream(adaptor,"token LEXER");

		try {
			// org/antlr/grammar/v3/ANTLR.g:507:2: ( id |l= 'lexer' -> ID[$l] |p= 'parser' -> ID[$p] )
			int alt10=3;
			switch ( input.LA(1) ) {
			case RULE_REF:
			case TOKEN_REF:
				{
				alt10=1;
				}
				break;
			case LEXER:
				{
				alt10=2;
				}
				break;
			case PARSER:
				{
				alt10=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:507:4: id
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_id_in_actionScopeName613);
					id15=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id15.getTree());

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:508:4: l= 'lexer'
					{
					l=(Token)match(input,LEXER,FOLLOW_LEXER_in_actionScopeName620); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEXER.add(l);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 509:3: -> ID[$l]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(ID, l));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:510:4: p= 'parser'
					{
					p=(Token)match(input,PARSER,FOLLOW_PARSER_in_actionScopeName634); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PARSER.add(p);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 511:3: -> ID[$p]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(ID, p));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "actionScopeName"


	public static class optionsSpec_return extends ParserRuleReturnScope {
		public Map<String, Object> opts=new HashMap<String, Object>();
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "optionsSpec"
	// org/antlr/grammar/v3/ANTLR.g:514:1: optionsSpec returns [Map<String, Object> opts=new HashMap<String, Object>()] : OPTIONS ^ ( option[$opts] SEMI !)+ RCURLY !;
	public final ANTLRParser.optionsSpec_return optionsSpec() throws RecognitionException {
		ANTLRParser.optionsSpec_return retval = new ANTLRParser.optionsSpec_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token OPTIONS16=null;
		Token SEMI18=null;
		Token RCURLY19=null;
		ParserRuleReturnScope option17 =null;

		GrammarAST OPTIONS16_tree=null;
		GrammarAST SEMI18_tree=null;
		GrammarAST RCURLY19_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:515:2: ( OPTIONS ^ ( option[$opts] SEMI !)+ RCURLY !)
			// org/antlr/grammar/v3/ANTLR.g:515:4: OPTIONS ^ ( option[$opts] SEMI !)+ RCURLY !
			{
			root_0 = (GrammarAST)adaptor.nil();


			OPTIONS16=(Token)match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec656); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OPTIONS16_tree = (GrammarAST)adaptor.create(OPTIONS16);
			root_0 = (GrammarAST)adaptor.becomeRoot(OPTIONS16_tree, root_0);
			}

			// org/antlr/grammar/v3/ANTLR.g:515:13: ( option[$opts] SEMI !)+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==RULE_REF||LA11_0==TOKEN_REF) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:515:14: option[$opts] SEMI !
					{
					pushFollow(FOLLOW_option_in_optionsSpec660);
					option17=option(retval.opts);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option17.getTree());

					SEMI18=(Token)match(input,SEMI,FOLLOW_SEMI_in_optionsSpec663); if (state.failed) return retval;
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			RCURLY19=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_optionsSpec668); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "optionsSpec"


	public static class option_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "option"
	// org/antlr/grammar/v3/ANTLR.g:518:1: option[Map<String, Object> opts] : id ASSIGN ^ optionValue ;
	public final ANTLRParser.option_return option(Map<String, Object> opts) throws RecognitionException {
		ANTLRParser.option_return retval = new ANTLRParser.option_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token ASSIGN21=null;
		ParserRuleReturnScope id20 =null;
		ParserRuleReturnScope optionValue22 =null;

		GrammarAST ASSIGN21_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:519:2: ( id ASSIGN ^ optionValue )
			// org/antlr/grammar/v3/ANTLR.g:519:4: id ASSIGN ^ optionValue
			{
			root_0 = (GrammarAST)adaptor.nil();


			pushFollow(FOLLOW_id_in_option681);
			id20=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id20.getTree());

			ASSIGN21=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_option683); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN21_tree = (GrammarAST)adaptor.create(ASSIGN21);
			root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN21_tree, root_0);
			}

			pushFollow(FOLLOW_optionValue_in_option686);
			optionValue22=optionValue();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, optionValue22.getTree());

			if ( state.backtracking==0 ) {
						opts.put((id20!=null?input.toString(id20.start,id20.stop):null), (optionValue22!=null?((ANTLRParser.optionValue_return)optionValue22).value:null));
					}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "option"


	public static class optionValue_return extends ParserRuleReturnScope {
		public Object value = null;
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "optionValue"
	// org/antlr/grammar/v3/ANTLR.g:525:1: optionValue returns [Object value = null] : (x= id |s= STRING_LITERAL |c= CHAR_LITERAL |i= INT |ss= STAR -> STRING_LITERAL[$ss] );
	public final ANTLRParser.optionValue_return optionValue() throws RecognitionException {
		ANTLRParser.optionValue_return retval = new ANTLRParser.optionValue_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token s=null;
		Token c=null;
		Token i=null;
		Token ss=null;
		ParserRuleReturnScope x =null;

		GrammarAST s_tree=null;
		GrammarAST c_tree=null;
		GrammarAST i_tree=null;
		GrammarAST ss_tree=null;
		RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");

		try {
			// org/antlr/grammar/v3/ANTLR.g:526:2: (x= id |s= STRING_LITERAL |c= CHAR_LITERAL |i= INT |ss= STAR -> STRING_LITERAL[$ss] )
			int alt12=5;
			switch ( input.LA(1) ) {
			case RULE_REF:
			case TOKEN_REF:
				{
				alt12=1;
				}
				break;
			case STRING_LITERAL:
				{
				alt12=2;
				}
				break;
			case CHAR_LITERAL:
				{
				alt12=3;
				}
				break;
			case INT:
				{
				alt12=4;
				}
				break;
			case STAR:
				{
				alt12=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:526:4: x= id
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_id_in_optionValue707);
					x=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					if ( state.backtracking==0 ) {retval.value = (x!=null?input.toString(x.start,x.stop):null);}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:527:4: s= STRING_LITERAL
					{
					root_0 = (GrammarAST)adaptor.nil();


					s=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_optionValue719); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					s_tree = (GrammarAST)adaptor.create(s);
					adaptor.addChild(root_0, s_tree);
					}

					if ( state.backtracking==0 ) {String vs = (s!=null?s.getText():null);
											  // remove the quotes:
											  retval.value =vs.substring(1,vs.length()-1);}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:530:4: c= CHAR_LITERAL
					{
					root_0 = (GrammarAST)adaptor.nil();


					c=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_optionValue728); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					c_tree = (GrammarAST)adaptor.create(c);
					adaptor.addChild(root_0, c_tree);
					}

					if ( state.backtracking==0 ) {String vs = (c!=null?c.getText():null);
											  // remove the quotes:
											  retval.value =vs.substring(1,vs.length()-1);}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:533:4: i= INT
					{
					root_0 = (GrammarAST)adaptor.nil();


					i=(Token)match(input,INT,FOLLOW_INT_in_optionValue739); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					i_tree = (GrammarAST)adaptor.create(i);
					adaptor.addChild(root_0, i_tree);
					}

					if ( state.backtracking==0 ) {retval.value = Integer.parseInt((i!=null?i.getText():null));}
					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLR.g:534:4: ss= STAR
					{
					ss=(Token)match(input,STAR,FOLLOW_STAR_in_optionValue759); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STAR.add(ss);

					if ( state.backtracking==0 ) {retval.value = "*";}
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 535:3: -> STRING_LITERAL[$ss]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(STRING_LITERAL, ss));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "optionValue"


	public static class delegateGrammars_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "delegateGrammars"
	// org/antlr/grammar/v3/ANTLR.g:539:1: delegateGrammars : 'import' ^ delegateGrammar ( COMMA ! delegateGrammar )* SEMI !;
	public final ANTLRParser.delegateGrammars_return delegateGrammars() throws RecognitionException {
		ANTLRParser.delegateGrammars_return retval = new ANTLRParser.delegateGrammars_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token string_literal23=null;
		Token COMMA25=null;
		Token SEMI27=null;
		ParserRuleReturnScope delegateGrammar24 =null;
		ParserRuleReturnScope delegateGrammar26 =null;

		GrammarAST string_literal23_tree=null;
		GrammarAST COMMA25_tree=null;
		GrammarAST SEMI27_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:540:2: ( 'import' ^ delegateGrammar ( COMMA ! delegateGrammar )* SEMI !)
			// org/antlr/grammar/v3/ANTLR.g:540:4: 'import' ^ delegateGrammar ( COMMA ! delegateGrammar )* SEMI !
			{
			root_0 = (GrammarAST)adaptor.nil();


			string_literal23=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_delegateGrammars784); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal23_tree = (GrammarAST)adaptor.create(string_literal23);
			root_0 = (GrammarAST)adaptor.becomeRoot(string_literal23_tree, root_0);
			}

			pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars787);
			delegateGrammar24=delegateGrammar();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, delegateGrammar24.getTree());

			// org/antlr/grammar/v3/ANTLR.g:540:30: ( COMMA ! delegateGrammar )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:540:31: COMMA ! delegateGrammar
					{
					COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_delegateGrammars790); if (state.failed) return retval;
					pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars793);
					delegateGrammar26=delegateGrammar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, delegateGrammar26.getTree());

					}
					break;

				default :
					break loop13;
				}
			}

			SEMI27=(Token)match(input,SEMI,FOLLOW_SEMI_in_delegateGrammars797); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "delegateGrammars"


	public static class delegateGrammar_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "delegateGrammar"
	// org/antlr/grammar/v3/ANTLR.g:543:1: delegateGrammar : (lab= id ASSIGN ^g= id |g2= id );
	public final ANTLRParser.delegateGrammar_return delegateGrammar() throws RecognitionException {
		ANTLRParser.delegateGrammar_return retval = new ANTLRParser.delegateGrammar_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token ASSIGN28=null;
		ParserRuleReturnScope lab =null;
		ParserRuleReturnScope g =null;
		ParserRuleReturnScope g2 =null;

		GrammarAST ASSIGN28_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:544:2: (lab= id ASSIGN ^g= id |g2= id )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==TOKEN_REF) ) {
				int LA14_1 = input.LA(2);
				if ( (LA14_1==ASSIGN) ) {
					alt14=1;
				}
				else if ( (LA14_1==COMMA||LA14_1==SEMI) ) {
					alt14=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA14_0==RULE_REF) ) {
				int LA14_2 = input.LA(2);
				if ( (LA14_2==ASSIGN) ) {
					alt14=1;
				}
				else if ( (LA14_2==COMMA||LA14_2==SEMI) ) {
					alt14=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:544:4: lab= id ASSIGN ^g= id
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_id_in_delegateGrammar811);
					lab=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lab.getTree());

					ASSIGN28=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammar813); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN28_tree = (GrammarAST)adaptor.create(ASSIGN28);
					root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN28_tree, root_0);
					}

					pushFollow(FOLLOW_id_in_delegateGrammar818);
					g=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, g.getTree());

					if ( state.backtracking==0 ) {grammar.importGrammar((g!=null?((GrammarAST)g.getTree()):null), (lab!=null?input.toString(lab.start,lab.stop):null));}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:545:4: g2= id
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_id_in_delegateGrammar827);
					g2=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, g2.getTree());

					if ( state.backtracking==0 ) {grammar.importGrammar((g2!=null?((GrammarAST)g2.getTree()):null),null);}
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "delegateGrammar"


	public static class tokensSpec_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "tokensSpec"
	// org/antlr/grammar/v3/ANTLR.g:548:1: tokensSpec : TOKENS ^ ( tokenSpec )* RCURLY !;
	public final ANTLRParser.tokensSpec_return tokensSpec() throws RecognitionException {
		ANTLRParser.tokensSpec_return retval = new ANTLRParser.tokensSpec_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token TOKENS29=null;
		Token RCURLY31=null;
		ParserRuleReturnScope tokenSpec30 =null;

		GrammarAST TOKENS29_tree=null;
		GrammarAST RCURLY31_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:549:2: ( TOKENS ^ ( tokenSpec )* RCURLY !)
			// org/antlr/grammar/v3/ANTLR.g:549:4: TOKENS ^ ( tokenSpec )* RCURLY !
			{
			root_0 = (GrammarAST)adaptor.nil();


			TOKENS29=(Token)match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec854); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TOKENS29_tree = (GrammarAST)adaptor.create(TOKENS29);
			root_0 = (GrammarAST)adaptor.becomeRoot(TOKENS29_tree, root_0);
			}

			// org/antlr/grammar/v3/ANTLR.g:550:4: ( tokenSpec )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==TOKEN_REF) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:550:4: tokenSpec
					{
					pushFollow(FOLLOW_tokenSpec_in_tokensSpec860);
					tokenSpec30=tokenSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, tokenSpec30.getTree());

					}
					break;

				default :
					break loop15;
				}
			}

			RCURLY31=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_tokensSpec865); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tokensSpec"


	public static class tokenSpec_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "tokenSpec"
	// org/antlr/grammar/v3/ANTLR.g:554:1: tokenSpec : TOKEN_REF ( ASSIGN ^ ( STRING_LITERAL | CHAR_LITERAL ) )? SEMI !;
	public final ANTLRParser.tokenSpec_return tokenSpec() throws RecognitionException {
		ANTLRParser.tokenSpec_return retval = new ANTLRParser.tokenSpec_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token TOKEN_REF32=null;
		Token ASSIGN33=null;
		Token set34=null;
		Token SEMI35=null;

		GrammarAST TOKEN_REF32_tree=null;
		GrammarAST ASSIGN33_tree=null;
		GrammarAST set34_tree=null;
		GrammarAST SEMI35_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:555:2: ( TOKEN_REF ( ASSIGN ^ ( STRING_LITERAL | CHAR_LITERAL ) )? SEMI !)
			// org/antlr/grammar/v3/ANTLR.g:555:4: TOKEN_REF ( ASSIGN ^ ( STRING_LITERAL | CHAR_LITERAL ) )? SEMI !
			{
			root_0 = (GrammarAST)adaptor.nil();


			TOKEN_REF32=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec877); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TOKEN_REF32_tree = (GrammarAST)adaptor.create(TOKEN_REF32);
			adaptor.addChild(root_0, TOKEN_REF32_tree);
			}

			// org/antlr/grammar/v3/ANTLR.g:555:14: ( ASSIGN ^ ( STRING_LITERAL | CHAR_LITERAL ) )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==ASSIGN) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:555:16: ASSIGN ^ ( STRING_LITERAL | CHAR_LITERAL )
					{
					ASSIGN33=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenSpec881); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN33_tree = (GrammarAST)adaptor.create(ASSIGN33);
					root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN33_tree, root_0);
					}

					set34=input.LT(1);
					if ( input.LA(1)==CHAR_LITERAL||input.LA(1)==STRING_LITERAL ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (GrammarAST)adaptor.create(set34));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			SEMI35=(Token)match(input,SEMI,FOLLOW_SEMI_in_tokenSpec893); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tokenSpec"


	public static class attrScopes_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "attrScopes"
	// org/antlr/grammar/v3/ANTLR.g:558:1: attrScopes : ( attrScope )* ;
	public final ANTLRParser.attrScopes_return attrScopes() throws RecognitionException {
		ANTLRParser.attrScopes_return retval = new ANTLRParser.attrScopes_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope attrScope36 =null;


		try {
			// org/antlr/grammar/v3/ANTLR.g:559:2: ( ( attrScope )* )
			// org/antlr/grammar/v3/ANTLR.g:559:4: ( attrScope )*
			{
			root_0 = (GrammarAST)adaptor.nil();


			// org/antlr/grammar/v3/ANTLR.g:559:4: ( attrScope )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==SCOPE) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:559:5: attrScope
					{
					pushFollow(FOLLOW_attrScope_in_attrScopes906);
					attrScope36=attrScope();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, attrScope36.getTree());

					}
					break;

				default :
					break loop17;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "attrScopes"


	public static class attrScope_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "attrScope"
	// org/antlr/grammar/v3/ANTLR.g:562:1: attrScope : 'scope' ^ id ( ruleActions )? ACTION ;
	public final ANTLRParser.attrScope_return attrScope() throws RecognitionException {
		ANTLRParser.attrScope_return retval = new ANTLRParser.attrScope_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token string_literal37=null;
		Token ACTION40=null;
		ParserRuleReturnScope id38 =null;
		ParserRuleReturnScope ruleActions39 =null;

		GrammarAST string_literal37_tree=null;
		GrammarAST ACTION40_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:563:2: ( 'scope' ^ id ( ruleActions )? ACTION )
			// org/antlr/grammar/v3/ANTLR.g:563:4: 'scope' ^ id ( ruleActions )? ACTION
			{
			root_0 = (GrammarAST)adaptor.nil();


			string_literal37=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_attrScope919); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal37_tree = (GrammarAST)adaptor.create(string_literal37);
			root_0 = (GrammarAST)adaptor.becomeRoot(string_literal37_tree, root_0);
			}

			pushFollow(FOLLOW_id_in_attrScope922);
			id38=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id38.getTree());

			// org/antlr/grammar/v3/ANTLR.g:563:16: ( ruleActions )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==AMPERSAND) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:563:16: ruleActions
					{
					pushFollow(FOLLOW_ruleActions_in_attrScope924);
					ruleActions39=ruleActions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ruleActions39.getTree());

					}
					break;

			}

			ACTION40=(Token)match(input,ACTION,FOLLOW_ACTION_in_attrScope927); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ACTION40_tree = (GrammarAST)adaptor.create(ACTION40);
			adaptor.addChild(root_0, ACTION40_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "attrScope"


	public static class rules_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rules"
	// org/antlr/grammar/v3/ANTLR.g:566:1: rules : ( rule )+ ;
	public final ANTLRParser.rules_return rules() throws RecognitionException {
		ANTLRParser.rules_return retval = new ANTLRParser.rules_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope rule41 =null;


		try {
			// org/antlr/grammar/v3/ANTLR.g:567:2: ( ( rule )+ )
			// org/antlr/grammar/v3/ANTLR.g:567:4: ( rule )+
			{
			root_0 = (GrammarAST)adaptor.nil();


			// org/antlr/grammar/v3/ANTLR.g:567:4: ( rule )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==DOC_COMMENT||LA19_0==FRAGMENT||(LA19_0 >= PRIVATE && LA19_0 <= PUBLIC)||LA19_0==RULE_REF||LA19_0==TOKEN_REF) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:567:6: rule
					{
					pushFollow(FOLLOW_rule_in_rules940);
					rule41=rule();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rule41.getTree());

					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rules"


	public static class rule_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rule"
	// org/antlr/grammar/v3/ANTLR.g:572:1: public rule : ( (d= DOC_COMMENT )? (p1= 'protected' |p2= 'public' |p3= 'private' |p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )? -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] ) ) ;
	public final ANTLRParser.rule_return rule() throws RecognitionException {
		ANTLRParser.rule_return retval = new ANTLRParser.rule_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token d=null;
		Token p1=null;
		Token p2=null;
		Token p3=null;
		Token p4=null;
		Token aa=null;
		Token rt=null;
		Token BANG42=null;
		Token string_literal43=null;
		Token COLON47=null;
		Token SEMI49=null;
		ParserRuleReturnScope ruleName =null;
		ParserRuleReturnScope scopes =null;
		ParserRuleReturnScope ex =null;
		ParserRuleReturnScope throwsSpec44 =null;
		ParserRuleReturnScope optionsSpec45 =null;
		ParserRuleReturnScope ruleActions46 =null;
		ParserRuleReturnScope ruleAltList48 =null;

		GrammarAST d_tree=null;
		GrammarAST p1_tree=null;
		GrammarAST p2_tree=null;
		GrammarAST p3_tree=null;
		GrammarAST p4_tree=null;
		GrammarAST aa_tree=null;
		GrammarAST rt_tree=null;
		GrammarAST BANG42_tree=null;
		GrammarAST string_literal43_tree=null;
		GrammarAST COLON47_tree=null;
		GrammarAST SEMI49_tree=null;
		RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
		RewriteRuleTokenStream stream_RETURNS=new RewriteRuleTokenStream(adaptor,"token RETURNS");
		RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_FRAGMENT=new RewriteRuleTokenStream(adaptor,"token FRAGMENT");
		RewriteRuleTokenStream stream_PUBLIC=new RewriteRuleTokenStream(adaptor,"token PUBLIC");
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
		RewriteRuleTokenStream stream_PROTECTED=new RewriteRuleTokenStream(adaptor,"token PROTECTED");
		RewriteRuleTokenStream stream_PRIVATE=new RewriteRuleTokenStream(adaptor,"token PRIVATE");
		RewriteRuleSubtreeStream stream_throwsSpec=new RewriteRuleSubtreeStream(adaptor,"rule throwsSpec");
		RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
		RewriteRuleSubtreeStream stream_ruleActions=new RewriteRuleSubtreeStream(adaptor,"rule ruleActions");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
		RewriteRuleSubtreeStream stream_ruleAltList=new RewriteRuleSubtreeStream(adaptor,"rule ruleAltList");
		RewriteRuleSubtreeStream stream_ruleScopeSpec=new RewriteRuleSubtreeStream(adaptor,"rule ruleScopeSpec");
		RewriteRuleSubtreeStream stream_exceptionGroup=new RewriteRuleSubtreeStream(adaptor,"rule exceptionGroup");


			GrammarAST eob=null;
			CommonToken start = (CommonToken)LT(1);
			int startLine = LT(1).getLine();

		try {
			// org/antlr/grammar/v3/ANTLR.g:579:2: ( ( (d= DOC_COMMENT )? (p1= 'protected' |p2= 'public' |p3= 'private' |p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )? -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] ) ) )
			// org/antlr/grammar/v3/ANTLR.g:580:2: ( (d= DOC_COMMENT )? (p1= 'protected' |p2= 'public' |p3= 'private' |p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )? -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] ) )
			{
			// org/antlr/grammar/v3/ANTLR.g:580:2: ( (d= DOC_COMMENT )? (p1= 'protected' |p2= 'public' |p3= 'private' |p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )? -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] ) )
			// org/antlr/grammar/v3/ANTLR.g:580:4: (d= DOC_COMMENT )? (p1= 'protected' |p2= 'public' |p3= 'private' |p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )?
			{
			// org/antlr/grammar/v3/ANTLR.g:580:4: (d= DOC_COMMENT )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==DOC_COMMENT) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:580:6: d= DOC_COMMENT
					{
					d=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_rule970); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOC_COMMENT.add(d);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:582:3: (p1= 'protected' |p2= 'public' |p3= 'private' |p4= 'fragment' )?
			int alt21=5;
			switch ( input.LA(1) ) {
				case PROTECTED:
					{
					alt21=1;
					}
					break;
				case PUBLIC:
					{
					alt21=2;
					}
					break;
				case PRIVATE:
					{
					alt21=3;
					}
					break;
				case FRAGMENT:
					{
					alt21=4;
					}
					break;
			}
			switch (alt21) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:582:5: p1= 'protected'
					{
					p1=(Token)match(input,PROTECTED,FOLLOW_PROTECTED_in_rule983); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PROTECTED.add(p1);

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:583:5: p2= 'public'
					{
					p2=(Token)match(input,PUBLIC,FOLLOW_PUBLIC_in_rule992); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUBLIC.add(p2);

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:584:5: p3= 'private'
					{
					p3=(Token)match(input,PRIVATE,FOLLOW_PRIVATE_in_rule1002); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PRIVATE.add(p3);

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:585:5: p4= 'fragment'
					{
					p4=(Token)match(input,FRAGMENT,FOLLOW_FRAGMENT_in_rule1011); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FRAGMENT.add(p4);

					}
					break;

			}

			pushFollow(FOLLOW_id_in_rule1023);
			ruleName=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(ruleName.getTree());
			if ( state.backtracking==0 ) {
						currentRuleName=(ruleName!=null?input.toString(ruleName.start,ruleName.stop):null);
						if ( grammarType==Grammar.LEXER && p4==null )
							grammar.lexerRuleNamesInCombined.add(currentRuleName);
					}
			// org/antlr/grammar/v3/ANTLR.g:593:3: ( BANG )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==BANG) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:593:5: BANG
					{
					BANG42=(Token)match(input,BANG,FOLLOW_BANG_in_rule1033); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BANG.add(BANG42);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:594:3: (aa= ARG_ACTION )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==ARG_ACTION) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:594:5: aa= ARG_ACTION
					{
					aa=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule1044); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARG_ACTION.add(aa);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:595:3: ( 'returns' rt= ARG_ACTION )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==RETURNS) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:595:5: 'returns' rt= ARG_ACTION
					{
					string_literal43=(Token)match(input,RETURNS,FOLLOW_RETURNS_in_rule1053); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RETURNS.add(string_literal43);

					rt=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule1057); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARG_ACTION.add(rt);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:596:3: ( throwsSpec )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==THROWS) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:596:5: throwsSpec
					{
					pushFollow(FOLLOW_throwsSpec_in_rule1067);
					throwsSpec44=throwsSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_throwsSpec.add(throwsSpec44.getTree());
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:597:3: ( optionsSpec )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==OPTIONS) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:597:5: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_rule1076);
					optionsSpec45=optionsSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_optionsSpec.add(optionsSpec45.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_ruleScopeSpec_in_rule1085);
			scopes=ruleScopeSpec();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ruleScopeSpec.add(scopes.getTree());
			// org/antlr/grammar/v3/ANTLR.g:599:3: ( ruleActions )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==AMPERSAND) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:599:4: ruleActions
					{
					pushFollow(FOLLOW_ruleActions_in_rule1090);
					ruleActions46=ruleActions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_ruleActions.add(ruleActions46.getTree());
					}
					break;

			}

			COLON47=(Token)match(input,COLON,FOLLOW_COLON_in_rule1096); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COLON.add(COLON47);

			pushFollow(FOLLOW_ruleAltList_in_rule1100);
			ruleAltList48=ruleAltList((optionsSpec45!=null?((ANTLRParser.optionsSpec_return)optionsSpec45).opts:null));
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ruleAltList.add(ruleAltList48.getTree());
			SEMI49=(Token)match(input,SEMI,FOLLOW_SEMI_in_rule1105); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI49);

			// org/antlr/grammar/v3/ANTLR.g:603:3: (ex= exceptionGroup )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==CATCH||LA28_0==FINALLY) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:603:5: ex= exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_rule1113);
					ex=exceptionGroup();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_exceptionGroup.add(ex.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: throwsSpec, p3, aa, ex, ruleName, p4, p2, p1, ruleAltList, optionsSpec, ruleActions, rt, scopes
			// token labels: aa, p1, p2, rt, p3, p4
			// rule labels: ex, ruleName, scopes, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_aa=new RewriteRuleTokenStream(adaptor,"token aa",aa);
			RewriteRuleTokenStream stream_p1=new RewriteRuleTokenStream(adaptor,"token p1",p1);
			RewriteRuleTokenStream stream_p2=new RewriteRuleTokenStream(adaptor,"token p2",p2);
			RewriteRuleTokenStream stream_rt=new RewriteRuleTokenStream(adaptor,"token rt",rt);
			RewriteRuleTokenStream stream_p3=new RewriteRuleTokenStream(adaptor,"token p3",p3);
			RewriteRuleTokenStream stream_p4=new RewriteRuleTokenStream(adaptor,"token p4",p4);
			RewriteRuleSubtreeStream stream_ex=new RewriteRuleSubtreeStream(adaptor,"rule ex",ex!=null?ex.getTree():null);
			RewriteRuleSubtreeStream stream_ruleName=new RewriteRuleSubtreeStream(adaptor,"rule ruleName",ruleName!=null?ruleName.getTree():null);
			RewriteRuleSubtreeStream stream_scopes=new RewriteRuleSubtreeStream(adaptor,"rule scopes",scopes!=null?scopes.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 604:3: -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] )
			{
				// org/antlr/grammar/v3/ANTLR.g:604:6: ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(RULE, (ruleName!=null?(ruleName.start):null), "rule"), root_1);
				adaptor.addChild(root_1, stream_ruleName.nextTree());
				// org/antlr/grammar/v3/ANTLR.g:607:6: ( $p1)?
				if ( stream_p1.hasNext() ) {
					adaptor.addChild(root_1, stream_p1.nextNode());
				}
				stream_p1.reset();

				// org/antlr/grammar/v3/ANTLR.g:607:11: ( $p2)?
				if ( stream_p2.hasNext() ) {
					adaptor.addChild(root_1, stream_p2.nextNode());
				}
				stream_p2.reset();

				// org/antlr/grammar/v3/ANTLR.g:607:16: ( $p3)?
				if ( stream_p3.hasNext() ) {
					adaptor.addChild(root_1, stream_p3.nextNode());
				}
				stream_p3.reset();

				// org/antlr/grammar/v3/ANTLR.g:607:21: ( $p4)?
				if ( stream_p4.hasNext() ) {
					adaptor.addChild(root_1, stream_p4.nextNode());
				}
				stream_p4.reset();

				// org/antlr/grammar/v3/ANTLR.g:608:5: ^( ARG[\"ARG\"] ( $aa)? )
				{
				GrammarAST root_2 = (GrammarAST)adaptor.nil();
				root_2 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ARG, "ARG"), root_2);
				// org/antlr/grammar/v3/ANTLR.g:608:19: ( $aa)?
				if ( stream_aa.hasNext() ) {
					adaptor.addChild(root_2, stream_aa.nextNode());
				}
				stream_aa.reset();

				adaptor.addChild(root_1, root_2);
				}

				// org/antlr/grammar/v3/ANTLR.g:609:5: ^( RET[\"RET\"] ( $rt)? )
				{
				GrammarAST root_2 = (GrammarAST)adaptor.nil();
				root_2 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(RET, "RET"), root_2);
				// org/antlr/grammar/v3/ANTLR.g:609:19: ( $rt)?
				if ( stream_rt.hasNext() ) {
					adaptor.addChild(root_2, stream_rt.nextNode());
				}
				stream_rt.reset();

				adaptor.addChild(root_1, root_2);
				}

				// org/antlr/grammar/v3/ANTLR.g:610:5: ( throwsSpec )?
				if ( stream_throwsSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_throwsSpec.nextTree());
				}
				stream_throwsSpec.reset();

				// org/antlr/grammar/v3/ANTLR.g:611:5: ( optionsSpec )?
				if ( stream_optionsSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_optionsSpec.nextTree());
				}
				stream_optionsSpec.reset();

				adaptor.addChild(root_1, stream_scopes.nextTree());
				// org/antlr/grammar/v3/ANTLR.g:613:5: ( ruleActions )?
				if ( stream_ruleActions.hasNext() ) {
					adaptor.addChild(root_1, stream_ruleActions.nextTree());
				}
				stream_ruleActions.reset();

				adaptor.addChild(root_1, stream_ruleAltList.nextTree());
				// org/antlr/grammar/v3/ANTLR.g:615:6: ( $ex)?
				if ( stream_ex.hasNext() ) {
					adaptor.addChild(root_1, stream_ex.nextTree());
				}
				stream_ex.reset();

				adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOR, SEMI49, "<end-of-rule>"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			if ( state.backtracking==0 ) {
					retval.tree.setTreeEnclosingRuleNameDeeply(currentRuleName);
					((GrammarAST)retval.tree.getChild(0)).setBlockOptions((optionsSpec45!=null?((ANTLRParser.optionsSpec_return)optionsSpec45).opts:null));
				}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rule"


	public static class ruleActions_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "ruleActions"
	// org/antlr/grammar/v3/ANTLR.g:624:1: ruleActions : ( ruleAction )+ ;
	public final ANTLRParser.ruleActions_return ruleActions() throws RecognitionException {
		ANTLRParser.ruleActions_return retval = new ANTLRParser.ruleActions_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope ruleAction50 =null;


		try {
			// org/antlr/grammar/v3/ANTLR.g:625:2: ( ( ruleAction )+ )
			// org/antlr/grammar/v3/ANTLR.g:625:4: ( ruleAction )+
			{
			root_0 = (GrammarAST)adaptor.nil();


			// org/antlr/grammar/v3/ANTLR.g:625:4: ( ruleAction )+
			int cnt29=0;
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==AMPERSAND) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:625:5: ruleAction
					{
					pushFollow(FOLLOW_ruleAction_in_ruleActions1251);
					ruleAction50=ruleAction();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ruleAction50.getTree());

					}
					break;

				default :
					if ( cnt29 >= 1 ) break loop29;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(29, input);
					throw eee;
				}
				cnt29++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ruleActions"


	public static class ruleAction_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "ruleAction"
	// org/antlr/grammar/v3/ANTLR.g:629:1: ruleAction : AMPERSAND ^ id ACTION ;
	public final ANTLRParser.ruleAction_return ruleAction() throws RecognitionException {
		ANTLRParser.ruleAction_return retval = new ANTLRParser.ruleAction_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token AMPERSAND51=null;
		Token ACTION53=null;
		ParserRuleReturnScope id52 =null;

		GrammarAST AMPERSAND51_tree=null;
		GrammarAST ACTION53_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:630:2: ( AMPERSAND ^ id ACTION )
			// org/antlr/grammar/v3/ANTLR.g:630:4: AMPERSAND ^ id ACTION
			{
			root_0 = (GrammarAST)adaptor.nil();


			AMPERSAND51=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleAction1266); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			AMPERSAND51_tree = (GrammarAST)adaptor.create(AMPERSAND51);
			root_0 = (GrammarAST)adaptor.becomeRoot(AMPERSAND51_tree, root_0);
			}

			pushFollow(FOLLOW_id_in_ruleAction1269);
			id52=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id52.getTree());

			ACTION53=(Token)match(input,ACTION,FOLLOW_ACTION_in_ruleAction1271); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ACTION53_tree = (GrammarAST)adaptor.create(ACTION53);
			adaptor.addChild(root_0, ACTION53_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ruleAction"


	public static class throwsSpec_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "throwsSpec"
	// org/antlr/grammar/v3/ANTLR.g:633:1: throwsSpec : 'throws' ^ id ( COMMA ! id )* ;
	public final ANTLRParser.throwsSpec_return throwsSpec() throws RecognitionException {
		ANTLRParser.throwsSpec_return retval = new ANTLRParser.throwsSpec_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token string_literal54=null;
		Token COMMA56=null;
		ParserRuleReturnScope id55 =null;
		ParserRuleReturnScope id57 =null;

		GrammarAST string_literal54_tree=null;
		GrammarAST COMMA56_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:634:2: ( 'throws' ^ id ( COMMA ! id )* )
			// org/antlr/grammar/v3/ANTLR.g:634:4: 'throws' ^ id ( COMMA ! id )*
			{
			root_0 = (GrammarAST)adaptor.nil();


			string_literal54=(Token)match(input,THROWS,FOLLOW_THROWS_in_throwsSpec1282); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal54_tree = (GrammarAST)adaptor.create(string_literal54);
			root_0 = (GrammarAST)adaptor.becomeRoot(string_literal54_tree, root_0);
			}

			pushFollow(FOLLOW_id_in_throwsSpec1285);
			id55=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id55.getTree());

			// org/antlr/grammar/v3/ANTLR.g:634:17: ( COMMA ! id )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==COMMA) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:634:19: COMMA ! id
					{
					COMMA56=(Token)match(input,COMMA,FOLLOW_COMMA_in_throwsSpec1289); if (state.failed) return retval;
					pushFollow(FOLLOW_id_in_throwsSpec1292);
					id57=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id57.getTree());

					}
					break;

				default :
					break loop30;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "throwsSpec"


	public static class ruleScopeSpec_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "ruleScopeSpec"
	// org/antlr/grammar/v3/ANTLR.g:637:1: ruleScopeSpec : ( 'scope' ( ruleActions )? ACTION )? ( 'scope' idList SEMI )* -> ^( SCOPE[$start,\"scope\"] ( ruleActions )? ( ACTION )? ( idList )* ) ;
	public final ANTLRParser.ruleScopeSpec_return ruleScopeSpec() throws RecognitionException {
		ANTLRParser.ruleScopeSpec_return retval = new ANTLRParser.ruleScopeSpec_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token string_literal58=null;
		Token ACTION60=null;
		Token string_literal61=null;
		Token SEMI63=null;
		ParserRuleReturnScope ruleActions59 =null;
		ParserRuleReturnScope idList62 =null;

		GrammarAST string_literal58_tree=null;
		GrammarAST ACTION60_tree=null;
		GrammarAST string_literal61_tree=null;
		GrammarAST SEMI63_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_SCOPE=new RewriteRuleTokenStream(adaptor,"token SCOPE");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_ruleActions=new RewriteRuleSubtreeStream(adaptor,"rule ruleActions");
		RewriteRuleSubtreeStream stream_idList=new RewriteRuleSubtreeStream(adaptor,"rule idList");

		try {
			// org/antlr/grammar/v3/ANTLR.g:638:2: ( ( 'scope' ( ruleActions )? ACTION )? ( 'scope' idList SEMI )* -> ^( SCOPE[$start,\"scope\"] ( ruleActions )? ( ACTION )? ( idList )* ) )
			// org/antlr/grammar/v3/ANTLR.g:638:4: ( 'scope' ( ruleActions )? ACTION )? ( 'scope' idList SEMI )*
			{
			// org/antlr/grammar/v3/ANTLR.g:638:4: ( 'scope' ( ruleActions )? ACTION )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==SCOPE) ) {
				int LA32_1 = input.LA(2);
				if ( (LA32_1==ACTION||LA32_1==AMPERSAND) ) {
					alt32=1;
				}
			}
			switch (alt32) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:638:6: 'scope' ( ruleActions )? ACTION
					{
					string_literal58=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec1308); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCOPE.add(string_literal58);

					// org/antlr/grammar/v3/ANTLR.g:638:14: ( ruleActions )?
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==AMPERSAND) ) {
						alt31=1;
					}
					switch (alt31) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:638:14: ruleActions
							{
							pushFollow(FOLLOW_ruleActions_in_ruleScopeSpec1310);
							ruleActions59=ruleActions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ruleActions.add(ruleActions59.getTree());
							}
							break;

					}

					ACTION60=(Token)match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec1313); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ACTION.add(ACTION60);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:639:3: ( 'scope' idList SEMI )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==SCOPE) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:639:5: 'scope' idList SEMI
					{
					string_literal61=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec1322); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCOPE.add(string_literal61);

					pushFollow(FOLLOW_idList_in_ruleScopeSpec1324);
					idList62=idList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_idList.add(idList62.getTree());
					SEMI63=(Token)match(input,SEMI,FOLLOW_SEMI_in_ruleScopeSpec1326); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI63);

					}
					break;

				default :
					break loop33;
				}
			}

			// AST REWRITE
			// elements: ACTION, idList, ruleActions
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 640:3: -> ^( SCOPE[$start,\"scope\"] ( ruleActions )? ( ACTION )? ( idList )* )
			{
				// org/antlr/grammar/v3/ANTLR.g:640:6: ^( SCOPE[$start,\"scope\"] ( ruleActions )? ( ACTION )? ( idList )* )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(SCOPE, (retval.start), "scope"), root_1);
				// org/antlr/grammar/v3/ANTLR.g:640:30: ( ruleActions )?
				if ( stream_ruleActions.hasNext() ) {
					adaptor.addChild(root_1, stream_ruleActions.nextTree());
				}
				stream_ruleActions.reset();

				// org/antlr/grammar/v3/ANTLR.g:640:43: ( ACTION )?
				if ( stream_ACTION.hasNext() ) {
					adaptor.addChild(root_1, stream_ACTION.nextNode());
				}
				stream_ACTION.reset();

				// org/antlr/grammar/v3/ANTLR.g:640:51: ( idList )*
				while ( stream_idList.hasNext() ) {
					adaptor.addChild(root_1, stream_idList.nextTree());
				}
				stream_idList.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ruleScopeSpec"


	public static class ruleAltList_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "ruleAltList"
	// org/antlr/grammar/v3/ANTLR.g:643:1: ruleAltList[Map<String, Object> opts] : ( -> BLOCK[input.LT(-1),\"BLOCK\"] ) (a1= alternative r1= rewrite -> $a1 ( $r1)? ) ( ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+ |) -> ^( $ruleAltList EOB[\"<end-of-block>\"] ) ;
	public final ANTLRParser.ruleAltList_return ruleAltList(Map<String, Object> opts) throws RecognitionException {
		ANTLRParser.ruleAltList_return retval = new ANTLRParser.ruleAltList_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token OR64=null;
		ParserRuleReturnScope a1 =null;
		ParserRuleReturnScope r1 =null;
		ParserRuleReturnScope a2 =null;
		ParserRuleReturnScope r2 =null;

		GrammarAST OR64_tree=null;
		RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
		RewriteRuleSubtreeStream stream_alternative=new RewriteRuleSubtreeStream(adaptor,"rule alternative");
		RewriteRuleSubtreeStream stream_rewrite=new RewriteRuleSubtreeStream(adaptor,"rule rewrite");


			GrammarAST blkRoot = null;
			GrammarAST save = currentBlockAST;

		try {
			// org/antlr/grammar/v3/ANTLR.g:649:2: ( ( -> BLOCK[input.LT(-1),\"BLOCK\"] ) (a1= alternative r1= rewrite -> $a1 ( $r1)? ) ( ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+ |) -> ^( $ruleAltList EOB[\"<end-of-block>\"] ) )
			// org/antlr/grammar/v3/ANTLR.g:649:4: ( -> BLOCK[input.LT(-1),\"BLOCK\"] ) (a1= alternative r1= rewrite -> $a1 ( $r1)? ) ( ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+ |)
			{
			// org/antlr/grammar/v3/ANTLR.g:649:4: ( -> BLOCK[input.LT(-1),\"BLOCK\"] )
			// org/antlr/grammar/v3/ANTLR.g:649:6: 
			{
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 649:6: -> BLOCK[input.LT(-1),\"BLOCK\"]
			{
				adaptor.addChild(root_0, (GrammarAST)adaptor.create(BLOCK, input.LT(-1), "BLOCK"));
			}


			retval.tree = root_0;
			}

			}

			if ( state.backtracking==0 ) {
						blkRoot = (GrammarAST)retval.tree.getChild(0);
						blkRoot.setBlockOptions(opts);
						currentBlockAST = blkRoot;
					}
			// org/antlr/grammar/v3/ANTLR.g:655:3: (a1= alternative r1= rewrite -> $a1 ( $r1)? )
			// org/antlr/grammar/v3/ANTLR.g:655:5: a1= alternative r1= rewrite
			{
			pushFollow(FOLLOW_alternative_in_ruleAltList1383);
			a1=alternative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_alternative.add(a1.getTree());
			pushFollow(FOLLOW_rewrite_in_ruleAltList1387);
			r1=rewrite();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite.add(r1.getTree());
			if ( state.backtracking==0 ) {if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred((a1!=null?((GrammarAST)a1.getTree()):null));}
			// AST REWRITE
			// elements: a1, r1
			// token labels: 
			// rule labels: a1, retval, r1
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_a1=new RewriteRuleSubtreeStream(adaptor,"rule a1",a1!=null?a1.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_r1=new RewriteRuleSubtreeStream(adaptor,"rule r1",r1!=null?r1.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 657:4: -> $a1 ( $r1)?
			{
				adaptor.addChild(root_0, stream_a1.nextTree());
				// org/antlr/grammar/v3/ANTLR.g:657:12: ( $r1)?
				if ( stream_r1.hasNext() ) {
					adaptor.addChild(root_0, stream_r1.nextTree());
				}
				stream_r1.reset();

			}


			retval.tree = root_0;
			}

			}

			// org/antlr/grammar/v3/ANTLR.g:659:3: ( ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+ |)
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==OR) ) {
				alt35=1;
			}
			else if ( (LA35_0==SEMI) ) {
				alt35=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:659:5: ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+
					{
					// org/antlr/grammar/v3/ANTLR.g:659:5: ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+
					int cnt34=0;
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==OR) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:659:7: OR a2= alternative r2= rewrite
							{
							OR64=(Token)match(input,OR,FOLLOW_OR_in_ruleAltList1416); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_OR.add(OR64);

							pushFollow(FOLLOW_alternative_in_ruleAltList1420);
							a2=alternative();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_alternative.add(a2.getTree());
							pushFollow(FOLLOW_rewrite_in_ruleAltList1424);
							r2=rewrite();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rewrite.add(r2.getTree());
							if ( state.backtracking==0 ) {if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred((a2!=null?((GrammarAST)a2.getTree()):null));}
							// AST REWRITE
							// elements: a2, r2, ruleAltList
							// token labels: 
							// rule labels: r2, a2, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_r2=new RewriteRuleSubtreeStream(adaptor,"rule r2",r2!=null?r2.getTree():null);
							RewriteRuleSubtreeStream stream_a2=new RewriteRuleSubtreeStream(adaptor,"rule a2",a2!=null?a2.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (GrammarAST)adaptor.nil();
							// 661:5: -> $ruleAltList $a2 ( $r2)?
							{
								adaptor.addChild(root_0, stream_retval.nextTree());
								adaptor.addChild(root_0, stream_a2.nextTree());
								// org/antlr/grammar/v3/ANTLR.g:661:26: ( $r2)?
								if ( stream_r2.hasNext() ) {
									adaptor.addChild(root_0, stream_r2.nextTree());
								}
								stream_r2.reset();

							}


							retval.tree = root_0;
							}

							}
							break;

						default :
							if ( cnt34 >= 1 ) break loop34;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(34, input);
							throw eee;
						}
						cnt34++;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:664:3: 
					{
					}
					break;

			}

			// AST REWRITE
			// elements: ruleAltList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 665:3: -> ^( $ruleAltList EOB[\"<end-of-block>\"] )
			{
				// org/antlr/grammar/v3/ANTLR.g:665:6: ^( $ruleAltList EOB[\"<end-of-block>\"] )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot(blkRoot, root_1);
				adaptor.addChild(root_1, stream_retval.nextTree());
				adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOB, "<end-of-block>"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			 currentBlockAST = save; 
		}
		return retval;
	}
	// $ANTLR end "ruleAltList"


	public static class block_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "block"
	// org/antlr/grammar/v3/ANTLR.g:670:1: block : (lp= LPAREN -> BLOCK[$lp,\"BLOCK\"] ) ( ( optionsSpec )? ( ruleActions )? COLON | ACTION COLON )? a= alternative r= rewrite ( OR a= alternative r= rewrite )* rp= RPAREN -> ^( $block ( optionsSpec )? ( ruleActions )? ( ACTION )? ( alternative )+ EOB[$rp,\"<end-of-block>\"] ) ;
	public final ANTLRParser.block_return block() throws RecognitionException {
		ANTLRParser.block_return retval = new ANTLRParser.block_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token lp=null;
		Token rp=null;
		Token COLON67=null;
		Token ACTION68=null;
		Token COLON69=null;
		Token OR70=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope r =null;
		ParserRuleReturnScope optionsSpec65 =null;
		ParserRuleReturnScope ruleActions66 =null;

		GrammarAST lp_tree=null;
		GrammarAST rp_tree=null;
		GrammarAST COLON67_tree=null;
		GrammarAST ACTION68_tree=null;
		GrammarAST COLON69_tree=null;
		GrammarAST OR70_tree=null;
		RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
		RewriteRuleSubtreeStream stream_ruleActions=new RewriteRuleSubtreeStream(adaptor,"rule ruleActions");
		RewriteRuleSubtreeStream stream_alternative=new RewriteRuleSubtreeStream(adaptor,"rule alternative");
		RewriteRuleSubtreeStream stream_rewrite=new RewriteRuleSubtreeStream(adaptor,"rule rewrite");


			GrammarAST save = currentBlockAST;

		try {
			// org/antlr/grammar/v3/ANTLR.g:675:2: ( (lp= LPAREN -> BLOCK[$lp,\"BLOCK\"] ) ( ( optionsSpec )? ( ruleActions )? COLON | ACTION COLON )? a= alternative r= rewrite ( OR a= alternative r= rewrite )* rp= RPAREN -> ^( $block ( optionsSpec )? ( ruleActions )? ( ACTION )? ( alternative )+ EOB[$rp,\"<end-of-block>\"] ) )
			// org/antlr/grammar/v3/ANTLR.g:675:4: (lp= LPAREN -> BLOCK[$lp,\"BLOCK\"] ) ( ( optionsSpec )? ( ruleActions )? COLON | ACTION COLON )? a= alternative r= rewrite ( OR a= alternative r= rewrite )* rp= RPAREN
			{
			// org/antlr/grammar/v3/ANTLR.g:675:4: (lp= LPAREN -> BLOCK[$lp,\"BLOCK\"] )
			// org/antlr/grammar/v3/ANTLR.g:675:6: lp= LPAREN
			{
			lp=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_block1500); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(lp);

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 676:4: -> BLOCK[$lp,\"BLOCK\"]
			{
				adaptor.addChild(root_0, (GrammarAST)adaptor.create(BLOCK, lp, "BLOCK"));
			}


			retval.tree = root_0;
			}

			}

			if ( state.backtracking==0 ) {currentBlockAST = (GrammarAST)retval.tree.getChild(0);}
			// org/antlr/grammar/v3/ANTLR.g:679:3: ( ( optionsSpec )? ( ruleActions )? COLON | ACTION COLON )?
			int alt38=3;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==AMPERSAND||LA38_0==COLON||LA38_0==OPTIONS) ) {
				alt38=1;
			}
			else if ( (LA38_0==ACTION) ) {
				int LA38_2 = input.LA(2);
				if ( (LA38_2==COLON) ) {
					alt38=2;
				}
			}
			switch (alt38) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:683:4: ( optionsSpec )? ( ruleActions )? COLON
					{
					// org/antlr/grammar/v3/ANTLR.g:683:4: ( optionsSpec )?
					int alt36=2;
					int LA36_0 = input.LA(1);
					if ( (LA36_0==OPTIONS) ) {
						alt36=1;
					}
					switch (alt36) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:683:5: optionsSpec
							{
							pushFollow(FOLLOW_optionsSpec_in_block1538);
							optionsSpec65=optionsSpec();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_optionsSpec.add(optionsSpec65.getTree());
							if ( state.backtracking==0 ) {((GrammarAST)retval.tree.getChild(0)).setOptions(grammar,(optionsSpec65!=null?((ANTLRParser.optionsSpec_return)optionsSpec65).opts:null));}
							}
							break;

					}

					// org/antlr/grammar/v3/ANTLR.g:684:4: ( ruleActions )?
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==AMPERSAND) ) {
						alt37=1;
					}
					switch (alt37) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:684:6: ruleActions
							{
							pushFollow(FOLLOW_ruleActions_in_block1549);
							ruleActions66=ruleActions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ruleActions.add(ruleActions66.getTree());
							}
							break;

					}

					COLON67=(Token)match(input,COLON,FOLLOW_COLON_in_block1557); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON67);

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:686:5: ACTION COLON
					{
					ACTION68=(Token)match(input,ACTION,FOLLOW_ACTION_in_block1563); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ACTION.add(ACTION68);

					COLON69=(Token)match(input,COLON,FOLLOW_COLON_in_block1565); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON69);

					}
					break;

			}

			pushFollow(FOLLOW_alternative_in_block1577);
			a=alternative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_alternative.add(a.getTree());
			pushFollow(FOLLOW_rewrite_in_block1581);
			r=rewrite();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite.add(r.getTree());
			if ( state.backtracking==0 ) {
						stream_alternative.add( (r!=null?((GrammarAST)r.getTree()):null) );
						if ( LA(1)==OR || (LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR) )
							prefixWithSynPred((a!=null?((GrammarAST)a.getTree()):null));
					}
			// org/antlr/grammar/v3/ANTLR.g:695:3: ( OR a= alternative r= rewrite )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( (LA39_0==OR) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:695:5: OR a= alternative r= rewrite
					{
					OR70=(Token)match(input,OR,FOLLOW_OR_in_block1591); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OR.add(OR70);

					pushFollow(FOLLOW_alternative_in_block1595);
					a=alternative();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_alternative.add(a.getTree());
					pushFollow(FOLLOW_rewrite_in_block1599);
					r=rewrite();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite.add(r.getTree());
					if ( state.backtracking==0 ) {
									stream_alternative.add( (r!=null?((GrammarAST)r.getTree()):null) );
									if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR))
										prefixWithSynPred((a!=null?((GrammarAST)a.getTree()):null));
								}
					}
					break;

				default :
					break loop39;
				}
			}

			rp=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_block1616); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(rp);

			// AST REWRITE
			// elements: optionsSpec, ruleActions, alternative, ACTION, block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 704:3: -> ^( $block ( optionsSpec )? ( ruleActions )? ( ACTION )? ( alternative )+ EOB[$rp,\"<end-of-block>\"] )
			{
				// org/antlr/grammar/v3/ANTLR.g:704:6: ^( $block ( optionsSpec )? ( ruleActions )? ( ACTION )? ( alternative )+ EOB[$rp,\"<end-of-block>\"] )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot(stream_retval.nextNode(), root_1);
				// org/antlr/grammar/v3/ANTLR.g:704:15: ( optionsSpec )?
				if ( stream_optionsSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_optionsSpec.nextTree());
				}
				stream_optionsSpec.reset();

				// org/antlr/grammar/v3/ANTLR.g:704:28: ( ruleActions )?
				if ( stream_ruleActions.hasNext() ) {
					adaptor.addChild(root_1, stream_ruleActions.nextTree());
				}
				stream_ruleActions.reset();

				// org/antlr/grammar/v3/ANTLR.g:704:41: ( ACTION )?
				if ( stream_ACTION.hasNext() ) {
					adaptor.addChild(root_1, stream_ACTION.nextNode());
				}
				stream_ACTION.reset();

				if ( !(stream_alternative.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_alternative.hasNext() ) {
					adaptor.addChild(root_1, stream_alternative.nextTree());
				}
				stream_alternative.reset();

				adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOB, rp, "<end-of-block>"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			 currentBlockAST = save; 
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class alternative_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "alternative"
	// org/antlr/grammar/v3/ANTLR.g:709:1: alternative : ( ( element )+ -> ^( ALT[$start,\"ALT\"] ( element )+ EOA[input.LT(-1),\"<end-of-alt>\"] ) | -> ^( ALT[$start,\"ALT\"] EPSILON[input.LT(-1),\"epsilon\"] EOA[input.LT(-1),\"<end-of-alt>\"] ) );
	public final ANTLRParser.alternative_return alternative() throws RecognitionException {
		ANTLRParser.alternative_return retval = new ANTLRParser.alternative_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope element71 =null;

		RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");

		try {
			// org/antlr/grammar/v3/ANTLR.g:710:2: ( ( element )+ -> ^( ALT[$start,\"ALT\"] ( element )+ EOA[input.LT(-1),\"<end-of-alt>\"] ) | -> ^( ALT[$start,\"ALT\"] EPSILON[input.LT(-1),\"epsilon\"] EOA[input.LT(-1),\"<end-of-alt>\"] ) )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==ACTION||LA41_0==CHAR_LITERAL||LA41_0==FORCED_ACTION||LA41_0==LPAREN||LA41_0==NOT||LA41_0==RULE_REF||LA41_0==SEMPRED||LA41_0==STRING_LITERAL||LA41_0==TOKEN_REF||LA41_0==TREE_BEGIN||LA41_0==WILDCARD) ) {
				alt41=1;
			}
			else if ( (LA41_0==OR||LA41_0==REWRITE||LA41_0==RPAREN||LA41_0==SEMI) ) {
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
					// org/antlr/grammar/v3/ANTLR.g:710:4: ( element )+
					{
					// org/antlr/grammar/v3/ANTLR.g:710:4: ( element )+
					int cnt40=0;
					loop40:
					while (true) {
						int alt40=2;
						int LA40_0 = input.LA(1);
						if ( (LA40_0==ACTION||LA40_0==CHAR_LITERAL||LA40_0==FORCED_ACTION||LA40_0==LPAREN||LA40_0==NOT||LA40_0==RULE_REF||LA40_0==SEMPRED||LA40_0==STRING_LITERAL||LA40_0==TOKEN_REF||LA40_0==TREE_BEGIN||LA40_0==WILDCARD) ) {
							alt40=1;
						}

						switch (alt40) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:710:4: element
							{
							pushFollow(FOLLOW_element_in_alternative1656);
							element71=element();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_element.add(element71.getTree());
							}
							break;

						default :
							if ( cnt40 >= 1 ) break loop40;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(40, input);
							throw eee;
						}
						cnt40++;
					}

					// AST REWRITE
					// elements: element
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 711:3: -> ^( ALT[$start,\"ALT\"] ( element )+ EOA[input.LT(-1),\"<end-of-alt>\"] )
					{
						// org/antlr/grammar/v3/ANTLR.g:711:6: ^( ALT[$start,\"ALT\"] ( element )+ EOA[input.LT(-1),\"<end-of-alt>\"] )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, (retval.start), "ALT"), root_1);
						if ( !(stream_element.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_element.hasNext() ) {
							adaptor.addChild(root_1, stream_element.nextTree());
						}
						stream_element.reset();

						adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, input.LT(-1), "<end-of-alt>"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:713:3: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 713:3: -> ^( ALT[$start,\"ALT\"] EPSILON[input.LT(-1),\"epsilon\"] EOA[input.LT(-1),\"<end-of-alt>\"] )
					{
						// org/antlr/grammar/v3/ANTLR.g:713:6: ^( ALT[$start,\"ALT\"] EPSILON[input.LT(-1),\"epsilon\"] EOA[input.LT(-1),\"<end-of-alt>\"] )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, (retval.start), "ALT"), root_1);
						adaptor.addChild(root_1, (GrammarAST)adaptor.create(EPSILON, input.LT(-1), "epsilon"));
						adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, input.LT(-1), "<end-of-alt>"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "alternative"


	public static class exceptionGroup_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "exceptionGroup"
	// org/antlr/grammar/v3/ANTLR.g:716:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
	public final ANTLRParser.exceptionGroup_return exceptionGroup() throws RecognitionException {
		ANTLRParser.exceptionGroup_return retval = new ANTLRParser.exceptionGroup_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope exceptionHandler72 =null;
		ParserRuleReturnScope finallyClause73 =null;
		ParserRuleReturnScope finallyClause74 =null;


		try {
			// org/antlr/grammar/v3/ANTLR.g:717:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==CATCH) ) {
				alt44=1;
			}
			else if ( (LA44_0==FINALLY) ) {
				alt44=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:717:4: ( exceptionHandler )+ ( finallyClause )?
					{
					root_0 = (GrammarAST)adaptor.nil();


					// org/antlr/grammar/v3/ANTLR.g:717:4: ( exceptionHandler )+
					int cnt42=0;
					loop42:
					while (true) {
						int alt42=2;
						int LA42_0 = input.LA(1);
						if ( (LA42_0==CATCH) ) {
							alt42=1;
						}

						switch (alt42) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:717:4: exceptionHandler
							{
							pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1702);
							exceptionHandler72=exceptionHandler();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, exceptionHandler72.getTree());

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

					// org/antlr/grammar/v3/ANTLR.g:717:22: ( finallyClause )?
					int alt43=2;
					int LA43_0 = input.LA(1);
					if ( (LA43_0==FINALLY) ) {
						alt43=1;
					}
					switch (alt43) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:717:22: finallyClause
							{
							pushFollow(FOLLOW_finallyClause_in_exceptionGroup1705);
							finallyClause73=finallyClause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, finallyClause73.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:718:4: finallyClause
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_finallyClause_in_exceptionGroup1711);
					finallyClause74=finallyClause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, finallyClause74.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exceptionGroup"


	public static class exceptionHandler_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "exceptionHandler"
	// org/antlr/grammar/v3/ANTLR.g:721:1: exceptionHandler : 'catch' ^ ARG_ACTION ACTION ;
	public final ANTLRParser.exceptionHandler_return exceptionHandler() throws RecognitionException {
		ANTLRParser.exceptionHandler_return retval = new ANTLRParser.exceptionHandler_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token string_literal75=null;
		Token ARG_ACTION76=null;
		Token ACTION77=null;

		GrammarAST string_literal75_tree=null;
		GrammarAST ARG_ACTION76_tree=null;
		GrammarAST ACTION77_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:722:2: ( 'catch' ^ ARG_ACTION ACTION )
			// org/antlr/grammar/v3/ANTLR.g:722:4: 'catch' ^ ARG_ACTION ACTION
			{
			root_0 = (GrammarAST)adaptor.nil();


			string_literal75=(Token)match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler1722); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal75_tree = (GrammarAST)adaptor.create(string_literal75);
			root_0 = (GrammarAST)adaptor.becomeRoot(string_literal75_tree, root_0);
			}

			ARG_ACTION76=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1725); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ARG_ACTION76_tree = (GrammarAST)adaptor.create(ARG_ACTION76);
			adaptor.addChild(root_0, ARG_ACTION76_tree);
			}

			ACTION77=(Token)match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1727); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ACTION77_tree = (GrammarAST)adaptor.create(ACTION77);
			adaptor.addChild(root_0, ACTION77_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exceptionHandler"


	public static class finallyClause_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "finallyClause"
	// org/antlr/grammar/v3/ANTLR.g:725:1: finallyClause : 'finally' ^ ACTION ;
	public final ANTLRParser.finallyClause_return finallyClause() throws RecognitionException {
		ANTLRParser.finallyClause_return retval = new ANTLRParser.finallyClause_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token string_literal78=null;
		Token ACTION79=null;

		GrammarAST string_literal78_tree=null;
		GrammarAST ACTION79_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:726:2: ( 'finally' ^ ACTION )
			// org/antlr/grammar/v3/ANTLR.g:726:4: 'finally' ^ ACTION
			{
			root_0 = (GrammarAST)adaptor.nil();


			string_literal78=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause1738); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal78_tree = (GrammarAST)adaptor.create(string_literal78);
			root_0 = (GrammarAST)adaptor.becomeRoot(string_literal78_tree, root_0);
			}

			ACTION79=(Token)match(input,ACTION,FOLLOW_ACTION_in_finallyClause1741); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ACTION79_tree = (GrammarAST)adaptor.create(ACTION79);
			adaptor.addChild(root_0, ACTION79_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "finallyClause"


	public static class element_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "element"
	// org/antlr/grammar/v3/ANTLR.g:729:1: element : elementNoOptionSpec ;
	public final ANTLRParser.element_return element() throws RecognitionException {
		ANTLRParser.element_return retval = new ANTLRParser.element_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope elementNoOptionSpec80 =null;


		try {
			// org/antlr/grammar/v3/ANTLR.g:730:2: ( elementNoOptionSpec )
			// org/antlr/grammar/v3/ANTLR.g:730:4: elementNoOptionSpec
			{
			root_0 = (GrammarAST)adaptor.nil();


			pushFollow(FOLLOW_elementNoOptionSpec_in_element1752);
			elementNoOptionSpec80=elementNoOptionSpec();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, elementNoOptionSpec80.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "element"


	public static class elementNoOptionSpec_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "elementNoOptionSpec"
	// org/antlr/grammar/v3/ANTLR.g:733:1: elementNoOptionSpec : ( id ( ASSIGN ^| PLUS_ASSIGN ^) ( atom (sub= ebnfSuffix[root_0,false] !)? | ebnf ) |a= atom (sub2= ebnfSuffix[$a.tree,false] !)? | ebnf | FORCED_ACTION | ACTION |p= SEMPRED ( IMPLIES !)? |t3= tree_ ) ;
	public final ANTLRParser.elementNoOptionSpec_return elementNoOptionSpec() throws RecognitionException {
		ANTLRParser.elementNoOptionSpec_return retval = new ANTLRParser.elementNoOptionSpec_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token p=null;
		Token ASSIGN82=null;
		Token PLUS_ASSIGN83=null;
		Token FORCED_ACTION87=null;
		Token ACTION88=null;
		Token IMPLIES89=null;
		ParserRuleReturnScope sub =null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope sub2 =null;
		ParserRuleReturnScope t3 =null;
		ParserRuleReturnScope id81 =null;
		ParserRuleReturnScope atom84 =null;
		ParserRuleReturnScope ebnf85 =null;
		ParserRuleReturnScope ebnf86 =null;

		GrammarAST p_tree=null;
		GrammarAST ASSIGN82_tree=null;
		GrammarAST PLUS_ASSIGN83_tree=null;
		GrammarAST FORCED_ACTION87_tree=null;
		GrammarAST ACTION88_tree=null;
		GrammarAST IMPLIES89_tree=null;


			IntSet elements=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:738:2: ( ( id ( ASSIGN ^| PLUS_ASSIGN ^) ( atom (sub= ebnfSuffix[root_0,false] !)? | ebnf ) |a= atom (sub2= ebnfSuffix[$a.tree,false] !)? | ebnf | FORCED_ACTION | ACTION |p= SEMPRED ( IMPLIES !)? |t3= tree_ ) )
			// org/antlr/grammar/v3/ANTLR.g:738:4: ( id ( ASSIGN ^| PLUS_ASSIGN ^) ( atom (sub= ebnfSuffix[root_0,false] !)? | ebnf ) |a= atom (sub2= ebnfSuffix[$a.tree,false] !)? | ebnf | FORCED_ACTION | ACTION |p= SEMPRED ( IMPLIES !)? |t3= tree_ )
			{
			root_0 = (GrammarAST)adaptor.nil();


			// org/antlr/grammar/v3/ANTLR.g:738:4: ( id ( ASSIGN ^| PLUS_ASSIGN ^) ( atom (sub= ebnfSuffix[root_0,false] !)? | ebnf ) |a= atom (sub2= ebnfSuffix[$a.tree,false] !)? | ebnf | FORCED_ACTION | ACTION |p= SEMPRED ( IMPLIES !)? |t3= tree_ )
			int alt50=7;
			switch ( input.LA(1) ) {
			case TOKEN_REF:
				{
				int LA50_1 = input.LA(2);
				if ( (LA50_1==ACTION||LA50_1==ARG_ACTION||LA50_1==BANG||LA50_1==CHAR_LITERAL||LA50_1==FORCED_ACTION||LA50_1==LPAREN||(LA50_1 >= NOT && LA50_1 <= OPEN_ELEMENT_OPTION)||LA50_1==OR||LA50_1==PLUS||(LA50_1 >= QUESTION && LA50_1 <= RANGE)||LA50_1==REWRITE||(LA50_1 >= ROOT && LA50_1 <= RPAREN)||LA50_1==RULE_REF||(LA50_1 >= SEMI && LA50_1 <= SEMPRED)||LA50_1==STAR||LA50_1==STRING_LITERAL||LA50_1==TOKEN_REF||LA50_1==TREE_BEGIN||LA50_1==WILDCARD) ) {
					alt50=2;
				}
				else if ( (LA50_1==ASSIGN||LA50_1==PLUS_ASSIGN) ) {
					alt50=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
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
				break;
			case RULE_REF:
				{
				int LA50_2 = input.LA(2);
				if ( (LA50_2==ASSIGN||LA50_2==PLUS_ASSIGN) ) {
					alt50=1;
				}
				else if ( (LA50_2==ACTION||LA50_2==ARG_ACTION||LA50_2==BANG||LA50_2==CHAR_LITERAL||LA50_2==FORCED_ACTION||LA50_2==LPAREN||LA50_2==NOT||LA50_2==OR||LA50_2==PLUS||LA50_2==QUESTION||LA50_2==REWRITE||(LA50_2 >= ROOT && LA50_2 <= RPAREN)||LA50_2==RULE_REF||(LA50_2 >= SEMI && LA50_2 <= SEMPRED)||LA50_2==STAR||LA50_2==STRING_LITERAL||LA50_2==TOKEN_REF||LA50_2==TREE_BEGIN||LA50_2==WILDCARD) ) {
					alt50=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 50, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CHAR_LITERAL:
			case NOT:
			case STRING_LITERAL:
			case WILDCARD:
				{
				alt50=2;
				}
				break;
			case LPAREN:
				{
				alt50=3;
				}
				break;
			case FORCED_ACTION:
				{
				alt50=4;
				}
				break;
			case ACTION:
				{
				alt50=5;
				}
				break;
			case SEMPRED:
				{
				alt50=6;
				}
				break;
			case TREE_BEGIN:
				{
				alt50=7;
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
					// org/antlr/grammar/v3/ANTLR.g:738:6: id ( ASSIGN ^| PLUS_ASSIGN ^) ( atom (sub= ebnfSuffix[root_0,false] !)? | ebnf )
					{
					pushFollow(FOLLOW_id_in_elementNoOptionSpec1770);
					id81=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id81.getTree());

					// org/antlr/grammar/v3/ANTLR.g:738:9: ( ASSIGN ^| PLUS_ASSIGN ^)
					int alt45=2;
					int LA45_0 = input.LA(1);
					if ( (LA45_0==ASSIGN) ) {
						alt45=1;
					}
					else if ( (LA45_0==PLUS_ASSIGN) ) {
						alt45=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 45, 0, input);
						throw nvae;
					}

					switch (alt45) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:738:10: ASSIGN ^
							{
							ASSIGN82=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_elementNoOptionSpec1773); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASSIGN82_tree = (GrammarAST)adaptor.create(ASSIGN82);
							root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN82_tree, root_0);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:738:18: PLUS_ASSIGN ^
							{
							PLUS_ASSIGN83=(Token)match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_elementNoOptionSpec1776); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							PLUS_ASSIGN83_tree = (GrammarAST)adaptor.create(PLUS_ASSIGN83);
							root_0 = (GrammarAST)adaptor.becomeRoot(PLUS_ASSIGN83_tree, root_0);
							}

							}
							break;

					}

					// org/antlr/grammar/v3/ANTLR.g:739:4: ( atom (sub= ebnfSuffix[root_0,false] !)? | ebnf )
					int alt47=2;
					int LA47_0 = input.LA(1);
					if ( (LA47_0==CHAR_LITERAL||LA47_0==NOT||LA47_0==RULE_REF||LA47_0==STRING_LITERAL||LA47_0==TOKEN_REF||LA47_0==WILDCARD) ) {
						alt47=1;
					}
					else if ( (LA47_0==LPAREN) ) {
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
							// org/antlr/grammar/v3/ANTLR.g:739:6: atom (sub= ebnfSuffix[root_0,false] !)?
							{
							pushFollow(FOLLOW_atom_in_elementNoOptionSpec1785);
							atom84=atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, atom84.getTree());

							// org/antlr/grammar/v3/ANTLR.g:739:11: (sub= ebnfSuffix[root_0,false] !)?
							int alt46=2;
							int LA46_0 = input.LA(1);
							if ( (LA46_0==PLUS||LA46_0==QUESTION||LA46_0==STAR) ) {
								alt46=1;
							}
							switch (alt46) {
								case 1 :
									// org/antlr/grammar/v3/ANTLR.g:739:12: sub= ebnfSuffix[root_0,false] !
									{
									pushFollow(FOLLOW_ebnfSuffix_in_elementNoOptionSpec1790);
									sub=ebnfSuffix(root_0, false);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) {root_0 = (sub!=null?((GrammarAST)sub.getTree()):null);}
									}
									break;

							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:740:6: ebnf
							{
							pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec1803);
							ebnf85=ebnf();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, ebnf85.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:742:5: a= atom (sub2= ebnfSuffix[$a.tree,false] !)?
					{
					pushFollow(FOLLOW_atom_in_elementNoOptionSpec1816);
					a=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, a.getTree());

					// org/antlr/grammar/v3/ANTLR.g:743:4: (sub2= ebnfSuffix[$a.tree,false] !)?
					int alt48=2;
					int LA48_0 = input.LA(1);
					if ( (LA48_0==PLUS||LA48_0==QUESTION||LA48_0==STAR) ) {
						alt48=1;
					}
					switch (alt48) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:743:6: sub2= ebnfSuffix[$a.tree,false] !
							{
							pushFollow(FOLLOW_ebnfSuffix_in_elementNoOptionSpec1825);
							sub2=ebnfSuffix((a!=null?((GrammarAST)a.getTree()):null), false);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) {root_0=(sub2!=null?((GrammarAST)sub2.getTree()):null);}
							}
							break;

					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:745:5: ebnf
					{
					pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec1841);
					ebnf86=ebnf();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ebnf86.getTree());

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:746:5: FORCED_ACTION
					{
					FORCED_ACTION87=(Token)match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_elementNoOptionSpec1847); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FORCED_ACTION87_tree = (GrammarAST)adaptor.create(FORCED_ACTION87);
					adaptor.addChild(root_0, FORCED_ACTION87_tree);
					}

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLR.g:747:5: ACTION
					{
					ACTION88=(Token)match(input,ACTION,FOLLOW_ACTION_in_elementNoOptionSpec1853); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACTION88_tree = (GrammarAST)adaptor.create(ACTION88);
					adaptor.addChild(root_0, ACTION88_tree);
					}

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLR.g:748:5: p= SEMPRED ( IMPLIES !)?
					{
					p=(Token)match(input,SEMPRED,FOLLOW_SEMPRED_in_elementNoOptionSpec1861); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					p_tree = (GrammarAST)adaptor.create(p);
					adaptor.addChild(root_0, p_tree);
					}

					// org/antlr/grammar/v3/ANTLR.g:748:15: ( IMPLIES !)?
					int alt49=2;
					int LA49_0 = input.LA(1);
					if ( (LA49_0==IMPLIES) ) {
						alt49=1;
					}
					switch (alt49) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:748:17: IMPLIES !
							{
							IMPLIES89=(Token)match(input,IMPLIES,FOLLOW_IMPLIES_in_elementNoOptionSpec1865); if (state.failed) return retval;
							if ( state.backtracking==0 ) {p.setType(GATED_SEMPRED);}
							}
							break;

					}

					if ( state.backtracking==0 ) {
								grammar.blocksWithSemPreds.add(currentBlockAST);
								}
					}
					break;
				case 7 :
					// org/antlr/grammar/v3/ANTLR.g:752:5: t3= tree_
					{
					pushFollow(FOLLOW_tree__in_elementNoOptionSpec1884);
					t3=tree_();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t3.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elementNoOptionSpec"


	public static class atom_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// org/antlr/grammar/v3/ANTLR.g:756:1: atom : ( range ( ROOT ^| BANG ^)? | ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ^ ( terminal | ruleref ) | terminal | ruleref ) | notSet ( ROOT ^| BANG ^)? );
	public final ANTLRParser.atom_return atom() throws RecognitionException {
		ANTLRParser.atom_return retval = new ANTLRParser.atom_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token w=null;
		Token ROOT91=null;
		Token BANG92=null;
		Token ROOT99=null;
		Token BANG100=null;
		ParserRuleReturnScope range90 =null;
		ParserRuleReturnScope id93 =null;
		ParserRuleReturnScope terminal94 =null;
		ParserRuleReturnScope ruleref95 =null;
		ParserRuleReturnScope terminal96 =null;
		ParserRuleReturnScope ruleref97 =null;
		ParserRuleReturnScope notSet98 =null;

		GrammarAST w_tree=null;
		GrammarAST ROOT91_tree=null;
		GrammarAST BANG92_tree=null;
		GrammarAST ROOT99_tree=null;
		GrammarAST BANG100_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:757:2: ( range ( ROOT ^| BANG ^)? | ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ^ ( terminal | ruleref ) | terminal | ruleref ) | notSet ( ROOT ^| BANG ^)? )
			int alt55=3;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				int LA55_1 = input.LA(2);
				if ( (LA55_1==RANGE) ) {
					alt55=1;
				}
				else if ( (LA55_1==ACTION||LA55_1==BANG||LA55_1==CHAR_LITERAL||LA55_1==FORCED_ACTION||LA55_1==LPAREN||(LA55_1 >= NOT && LA55_1 <= OPEN_ELEMENT_OPTION)||LA55_1==OR||LA55_1==PLUS||LA55_1==QUESTION||LA55_1==REWRITE||(LA55_1 >= ROOT && LA55_1 <= RPAREN)||LA55_1==RULE_REF||(LA55_1 >= SEMI && LA55_1 <= SEMPRED)||LA55_1==STAR||LA55_1==STRING_LITERAL||LA55_1==TOKEN_REF||LA55_1==TREE_BEGIN||LA55_1==WILDCARD) ) {
					alt55=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 55, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case TOKEN_REF:
				{
				int LA55_2 = input.LA(2);
				if ( (LA55_2==RANGE) ) {
					alt55=1;
				}
				else if ( (LA55_2==ACTION||LA55_2==ARG_ACTION||LA55_2==BANG||LA55_2==CHAR_LITERAL||LA55_2==FORCED_ACTION||LA55_2==LPAREN||(LA55_2 >= NOT && LA55_2 <= OPEN_ELEMENT_OPTION)||LA55_2==OR||LA55_2==PLUS||LA55_2==QUESTION||LA55_2==REWRITE||(LA55_2 >= ROOT && LA55_2 <= RPAREN)||LA55_2==RULE_REF||(LA55_2 >= SEMI && LA55_2 <= SEMPRED)||LA55_2==STAR||LA55_2==STRING_LITERAL||LA55_2==TOKEN_REF||LA55_2==TREE_BEGIN||LA55_2==WILDCARD) ) {
					alt55=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 55, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case STRING_LITERAL:
				{
				int LA55_3 = input.LA(2);
				if ( (LA55_3==RANGE) ) {
					alt55=1;
				}
				else if ( (LA55_3==ACTION||LA55_3==BANG||LA55_3==CHAR_LITERAL||LA55_3==FORCED_ACTION||LA55_3==LPAREN||(LA55_3 >= NOT && LA55_3 <= OPEN_ELEMENT_OPTION)||LA55_3==OR||LA55_3==PLUS||LA55_3==QUESTION||LA55_3==REWRITE||(LA55_3 >= ROOT && LA55_3 <= RPAREN)||LA55_3==RULE_REF||(LA55_3 >= SEMI && LA55_3 <= SEMPRED)||LA55_3==STAR||LA55_3==STRING_LITERAL||LA55_3==TOKEN_REF||LA55_3==TREE_BEGIN||LA55_3==WILDCARD) ) {
					alt55=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 55, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_REF:
			case WILDCARD:
				{
				alt55=2;
				}
				break;
			case NOT:
				{
				alt55=3;
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
					// org/antlr/grammar/v3/ANTLR.g:757:4: range ( ROOT ^| BANG ^)?
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_range_in_atom1899);
					range90=range();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, range90.getTree());

					// org/antlr/grammar/v3/ANTLR.g:757:10: ( ROOT ^| BANG ^)?
					int alt51=3;
					int LA51_0 = input.LA(1);
					if ( (LA51_0==ROOT) ) {
						alt51=1;
					}
					else if ( (LA51_0==BANG) ) {
						alt51=2;
					}
					switch (alt51) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:757:11: ROOT ^
							{
							ROOT91=(Token)match(input,ROOT,FOLLOW_ROOT_in_atom1902); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ROOT91_tree = (GrammarAST)adaptor.create(ROOT91);
							root_0 = (GrammarAST)adaptor.becomeRoot(ROOT91_tree, root_0);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:757:17: BANG ^
							{
							BANG92=(Token)match(input,BANG,FOLLOW_BANG_in_atom1905); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							BANG92_tree = (GrammarAST)adaptor.create(BANG92);
							root_0 = (GrammarAST)adaptor.becomeRoot(BANG92_tree, root_0);
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:758:4: ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ^ ( terminal | ruleref ) | terminal | ruleref )
					{
					root_0 = (GrammarAST)adaptor.nil();


					// org/antlr/grammar/v3/ANTLR.g:758:4: ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ^ ( terminal | ruleref ) | terminal | ruleref )
					int alt53=3;
					switch ( input.LA(1) ) {
					case TOKEN_REF:
						{
						int LA53_1 = input.LA(2);
						if ( (LA53_1==WILDCARD) ) {
							switch ( input.LA(3) ) {
							case CHAR_LITERAL:
								{
								int LA53_7 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=2;
								}

								}
								break;
							case TOKEN_REF:
								{
								int LA53_8 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=2;
								}

								}
								break;
							case STRING_LITERAL:
								{
								int LA53_9 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=2;
								}

								}
								break;
							case WILDCARD:
								{
								int LA53_10 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=2;
								}

								}
								break;
							case RULE_REF:
								{
								int LA53_11 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=2;
								}

								}
								break;
							case ACTION:
							case BANG:
							case FORCED_ACTION:
							case LPAREN:
							case NOT:
							case OR:
							case PLUS:
							case QUESTION:
							case REWRITE:
							case ROOT:
							case RPAREN:
							case SEMI:
							case SEMPRED:
							case STAR:
							case TREE_BEGIN:
								{
								alt53=2;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 53, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}
						else if ( (LA53_1==ACTION||LA53_1==ARG_ACTION||LA53_1==BANG||LA53_1==CHAR_LITERAL||LA53_1==FORCED_ACTION||LA53_1==LPAREN||(LA53_1 >= NOT && LA53_1 <= OPEN_ELEMENT_OPTION)||LA53_1==OR||LA53_1==PLUS||LA53_1==QUESTION||LA53_1==REWRITE||(LA53_1 >= ROOT && LA53_1 <= RPAREN)||LA53_1==RULE_REF||(LA53_1 >= SEMI && LA53_1 <= SEMPRED)||LA53_1==STAR||LA53_1==STRING_LITERAL||LA53_1==TOKEN_REF||LA53_1==TREE_BEGIN) ) {
							alt53=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 53, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case RULE_REF:
						{
						int LA53_2 = input.LA(2);
						if ( (LA53_2==WILDCARD) ) {
							switch ( input.LA(3) ) {
							case CHAR_LITERAL:
								{
								int LA53_12 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=3;
								}

								}
								break;
							case TOKEN_REF:
								{
								int LA53_13 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=3;
								}

								}
								break;
							case STRING_LITERAL:
								{
								int LA53_14 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=3;
								}

								}
								break;
							case WILDCARD:
								{
								int LA53_15 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=3;
								}

								}
								break;
							case RULE_REF:
								{
								int LA53_16 = input.LA(4);
								if ( (synpred1_ANTLR()) ) {
									alt53=1;
								}
								else if ( (true) ) {
									alt53=3;
								}

								}
								break;
							case ACTION:
							case BANG:
							case FORCED_ACTION:
							case LPAREN:
							case NOT:
							case OR:
							case PLUS:
							case QUESTION:
							case REWRITE:
							case ROOT:
							case RPAREN:
							case SEMI:
							case SEMPRED:
							case STAR:
							case TREE_BEGIN:
								{
								alt53=3;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 53, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}
						else if ( (LA53_2==ACTION||LA53_2==ARG_ACTION||LA53_2==BANG||LA53_2==CHAR_LITERAL||LA53_2==FORCED_ACTION||LA53_2==LPAREN||LA53_2==NOT||LA53_2==OR||LA53_2==PLUS||LA53_2==QUESTION||LA53_2==REWRITE||(LA53_2 >= ROOT && LA53_2 <= RPAREN)||LA53_2==RULE_REF||(LA53_2 >= SEMI && LA53_2 <= SEMPRED)||LA53_2==STAR||LA53_2==STRING_LITERAL||LA53_2==TOKEN_REF||LA53_2==TREE_BEGIN) ) {
							alt53=3;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 53, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case CHAR_LITERAL:
					case STRING_LITERAL:
					case WILDCARD:
						{
						alt53=2;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 53, 0, input);
						throw nvae;
					}
					switch (alt53) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:761:4: ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ^ ( terminal | ruleref )
							{
							pushFollow(FOLLOW_id_in_atom1945);
							id93=id();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, id93.getTree());

							w=(Token)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1949); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							w_tree = (GrammarAST)adaptor.create(w);
							root_0 = (GrammarAST)adaptor.becomeRoot(w_tree, root_0);
							}

							// org/antlr/grammar/v3/ANTLR.g:763:19: ( terminal | ruleref )
							int alt52=2;
							int LA52_0 = input.LA(1);
							if ( (LA52_0==CHAR_LITERAL||LA52_0==STRING_LITERAL||LA52_0==TOKEN_REF||LA52_0==WILDCARD) ) {
								alt52=1;
							}
							else if ( (LA52_0==RULE_REF) ) {
								alt52=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								NoViableAltException nvae =
									new NoViableAltException("", 52, 0, input);
								throw nvae;
							}

							switch (alt52) {
								case 1 :
									// org/antlr/grammar/v3/ANTLR.g:763:20: terminal
									{
									pushFollow(FOLLOW_terminal_in_atom1953);
									terminal94=terminal();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal94.getTree());

									}
									break;
								case 2 :
									// org/antlr/grammar/v3/ANTLR.g:763:29: ruleref
									{
									pushFollow(FOLLOW_ruleref_in_atom1955);
									ruleref95=ruleref();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, ruleref95.getTree());

									}
									break;

							}

							if ( state.backtracking==0 ) {w.setType(DOT);}
							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:764:5: terminal
							{
							pushFollow(FOLLOW_terminal_in_atom1964);
							terminal96=terminal();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal96.getTree());

							}
							break;
						case 3 :
							// org/antlr/grammar/v3/ANTLR.g:765:5: ruleref
							{
							pushFollow(FOLLOW_ruleref_in_atom1970);
							ruleref97=ruleref();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, ruleref97.getTree());

							}
							break;

					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:767:4: notSet ( ROOT ^| BANG ^)?
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_notSet_in_atom1979);
					notSet98=notSet();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, notSet98.getTree());

					// org/antlr/grammar/v3/ANTLR.g:767:11: ( ROOT ^| BANG ^)?
					int alt54=3;
					int LA54_0 = input.LA(1);
					if ( (LA54_0==ROOT) ) {
						alt54=1;
					}
					else if ( (LA54_0==BANG) ) {
						alt54=2;
					}
					switch (alt54) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:767:12: ROOT ^
							{
							ROOT99=(Token)match(input,ROOT,FOLLOW_ROOT_in_atom1982); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ROOT99_tree = (GrammarAST)adaptor.create(ROOT99);
							root_0 = (GrammarAST)adaptor.becomeRoot(ROOT99_tree, root_0);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:767:18: BANG ^
							{
							BANG100=(Token)match(input,BANG,FOLLOW_BANG_in_atom1985); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							BANG100_tree = (GrammarAST)adaptor.create(BANG100);
							root_0 = (GrammarAST)adaptor.becomeRoot(BANG100_tree, root_0);
							}

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class ruleref_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "ruleref"
	// org/antlr/grammar/v3/ANTLR.g:770:1: ruleref : RULE_REF ^ ( ARG_ACTION )? ( ROOT ^| BANG ^)? ;
	public final ANTLRParser.ruleref_return ruleref() throws RecognitionException {
		ANTLRParser.ruleref_return retval = new ANTLRParser.ruleref_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token RULE_REF101=null;
		Token ARG_ACTION102=null;
		Token ROOT103=null;
		Token BANG104=null;

		GrammarAST RULE_REF101_tree=null;
		GrammarAST ARG_ACTION102_tree=null;
		GrammarAST ROOT103_tree=null;
		GrammarAST BANG104_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:771:2: ( RULE_REF ^ ( ARG_ACTION )? ( ROOT ^| BANG ^)? )
			// org/antlr/grammar/v3/ANTLR.g:771:4: RULE_REF ^ ( ARG_ACTION )? ( ROOT ^| BANG ^)?
			{
			root_0 = (GrammarAST)adaptor.nil();


			RULE_REF101=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_ruleref1999); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RULE_REF101_tree = (GrammarAST)adaptor.create(RULE_REF101);
			root_0 = (GrammarAST)adaptor.becomeRoot(RULE_REF101_tree, root_0);
			}

			// org/antlr/grammar/v3/ANTLR.g:771:14: ( ARG_ACTION )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==ARG_ACTION) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:771:14: ARG_ACTION
					{
					ARG_ACTION102=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleref2002); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ARG_ACTION102_tree = (GrammarAST)adaptor.create(ARG_ACTION102);
					adaptor.addChild(root_0, ARG_ACTION102_tree);
					}

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLR.g:771:26: ( ROOT ^| BANG ^)?
			int alt57=3;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==ROOT) ) {
				alt57=1;
			}
			else if ( (LA57_0==BANG) ) {
				alt57=2;
			}
			switch (alt57) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:771:27: ROOT ^
					{
					ROOT103=(Token)match(input,ROOT,FOLLOW_ROOT_in_ruleref2006); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ROOT103_tree = (GrammarAST)adaptor.create(ROOT103);
					root_0 = (GrammarAST)adaptor.becomeRoot(ROOT103_tree, root_0);
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:771:33: BANG ^
					{
					BANG104=(Token)match(input,BANG,FOLLOW_BANG_in_ruleref2009); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BANG104_tree = (GrammarAST)adaptor.create(BANG104);
					root_0 = (GrammarAST)adaptor.becomeRoot(BANG104_tree, root_0);
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ruleref"


	public static class notSet_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "notSet"
	// org/antlr/grammar/v3/ANTLR.g:774:1: notSet : NOT ^ ( notTerminal | block ) ;
	public final ANTLRParser.notSet_return notSet() throws RecognitionException {
		ANTLRParser.notSet_return retval = new ANTLRParser.notSet_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token NOT105=null;
		ParserRuleReturnScope notTerminal106 =null;
		ParserRuleReturnScope block107 =null;

		GrammarAST NOT105_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:775:2: ( NOT ^ ( notTerminal | block ) )
			// org/antlr/grammar/v3/ANTLR.g:775:4: NOT ^ ( notTerminal | block )
			{
			root_0 = (GrammarAST)adaptor.nil();


			NOT105=(Token)match(input,NOT,FOLLOW_NOT_in_notSet2023); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NOT105_tree = (GrammarAST)adaptor.create(NOT105);
			root_0 = (GrammarAST)adaptor.becomeRoot(NOT105_tree, root_0);
			}

			// org/antlr/grammar/v3/ANTLR.g:776:3: ( notTerminal | block )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==CHAR_LITERAL||LA58_0==STRING_LITERAL||LA58_0==TOKEN_REF) ) {
				alt58=1;
			}
			else if ( (LA58_0==LPAREN) ) {
				alt58=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 58, 0, input);
				throw nvae;
			}

			switch (alt58) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:776:5: notTerminal
					{
					pushFollow(FOLLOW_notTerminal_in_notSet2030);
					notTerminal106=notTerminal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, notTerminal106.getTree());

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:777:5: block
					{
					pushFollow(FOLLOW_block_in_notSet2036);
					block107=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block107.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "notSet"


	public static class treeRoot_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "treeRoot"
	// org/antlr/grammar/v3/ANTLR.g:781:1: treeRoot : ( id ( ASSIGN ^| PLUS_ASSIGN ^) ( atom | block ) | atom | block );
	public final ANTLRParser.treeRoot_return treeRoot() throws RecognitionException {
		ANTLRParser.treeRoot_return retval = new ANTLRParser.treeRoot_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token ASSIGN109=null;
		Token PLUS_ASSIGN110=null;
		ParserRuleReturnScope id108 =null;
		ParserRuleReturnScope atom111 =null;
		ParserRuleReturnScope block112 =null;
		ParserRuleReturnScope atom113 =null;
		ParserRuleReturnScope block114 =null;

		GrammarAST ASSIGN109_tree=null;
		GrammarAST PLUS_ASSIGN110_tree=null;

		atTreeRoot=true;
		try {
			// org/antlr/grammar/v3/ANTLR.g:784:2: ( id ( ASSIGN ^| PLUS_ASSIGN ^) ( atom | block ) | atom | block )
			int alt61=3;
			switch ( input.LA(1) ) {
			case TOKEN_REF:
				{
				int LA61_1 = input.LA(2);
				if ( (LA61_1==ACTION||LA61_1==ARG_ACTION||LA61_1==BANG||LA61_1==CHAR_LITERAL||LA61_1==FORCED_ACTION||LA61_1==LPAREN||(LA61_1 >= NOT && LA61_1 <= OPEN_ELEMENT_OPTION)||LA61_1==RANGE||LA61_1==ROOT||LA61_1==RULE_REF||LA61_1==SEMPRED||LA61_1==STRING_LITERAL||LA61_1==TOKEN_REF||LA61_1==TREE_BEGIN||LA61_1==WILDCARD) ) {
					alt61=2;
				}
				else if ( (LA61_1==ASSIGN||LA61_1==PLUS_ASSIGN) ) {
					alt61=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 61, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_REF:
				{
				int LA61_2 = input.LA(2);
				if ( (LA61_2==ASSIGN||LA61_2==PLUS_ASSIGN) ) {
					alt61=1;
				}
				else if ( (LA61_2==ACTION||LA61_2==ARG_ACTION||LA61_2==BANG||LA61_2==CHAR_LITERAL||LA61_2==FORCED_ACTION||LA61_2==LPAREN||LA61_2==NOT||LA61_2==ROOT||LA61_2==RULE_REF||LA61_2==SEMPRED||LA61_2==STRING_LITERAL||LA61_2==TOKEN_REF||LA61_2==TREE_BEGIN||LA61_2==WILDCARD) ) {
					alt61=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 61, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CHAR_LITERAL:
			case NOT:
			case STRING_LITERAL:
			case WILDCARD:
				{
				alt61=2;
				}
				break;
			case LPAREN:
				{
				alt61=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 61, 0, input);
				throw nvae;
			}
			switch (alt61) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:784:4: id ( ASSIGN ^| PLUS_ASSIGN ^) ( atom | block )
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_id_in_treeRoot2059);
					id108=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id108.getTree());

					// org/antlr/grammar/v3/ANTLR.g:784:7: ( ASSIGN ^| PLUS_ASSIGN ^)
					int alt59=2;
					int LA59_0 = input.LA(1);
					if ( (LA59_0==ASSIGN) ) {
						alt59=1;
					}
					else if ( (LA59_0==PLUS_ASSIGN) ) {
						alt59=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 59, 0, input);
						throw nvae;
					}

					switch (alt59) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:784:8: ASSIGN ^
							{
							ASSIGN109=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_treeRoot2062); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASSIGN109_tree = (GrammarAST)adaptor.create(ASSIGN109);
							root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN109_tree, root_0);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:784:16: PLUS_ASSIGN ^
							{
							PLUS_ASSIGN110=(Token)match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_treeRoot2065); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							PLUS_ASSIGN110_tree = (GrammarAST)adaptor.create(PLUS_ASSIGN110);
							root_0 = (GrammarAST)adaptor.becomeRoot(PLUS_ASSIGN110_tree, root_0);
							}

							}
							break;

					}

					// org/antlr/grammar/v3/ANTLR.g:784:30: ( atom | block )
					int alt60=2;
					int LA60_0 = input.LA(1);
					if ( (LA60_0==CHAR_LITERAL||LA60_0==NOT||LA60_0==RULE_REF||LA60_0==STRING_LITERAL||LA60_0==TOKEN_REF||LA60_0==WILDCARD) ) {
						alt60=1;
					}
					else if ( (LA60_0==LPAREN) ) {
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
							// org/antlr/grammar/v3/ANTLR.g:784:31: atom
							{
							pushFollow(FOLLOW_atom_in_treeRoot2070);
							atom111=atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, atom111.getTree());

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:784:36: block
							{
							pushFollow(FOLLOW_block_in_treeRoot2072);
							block112=block();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, block112.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:785:4: atom
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_atom_in_treeRoot2078);
					atom113=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atom113.getTree());

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:786:4: block
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_block_in_treeRoot2083);
					block114=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block114.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {atTreeRoot=false;}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "treeRoot"


	public static class tree__return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "tree_"
	// org/antlr/grammar/v3/ANTLR.g:789:1: tree_ : TREE_BEGIN ^ treeRoot ( element )+ RPAREN !;
	public final ANTLRParser.tree__return tree_() throws RecognitionException {
		ANTLRParser.tree__return retval = new ANTLRParser.tree__return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token TREE_BEGIN115=null;
		Token RPAREN118=null;
		ParserRuleReturnScope treeRoot116 =null;
		ParserRuleReturnScope element117 =null;

		GrammarAST TREE_BEGIN115_tree=null;
		GrammarAST RPAREN118_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:790:2: ( TREE_BEGIN ^ treeRoot ( element )+ RPAREN !)
			// org/antlr/grammar/v3/ANTLR.g:790:4: TREE_BEGIN ^ treeRoot ( element )+ RPAREN !
			{
			root_0 = (GrammarAST)adaptor.nil();


			TREE_BEGIN115=(Token)match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_2094); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TREE_BEGIN115_tree = (GrammarAST)adaptor.create(TREE_BEGIN115);
			root_0 = (GrammarAST)adaptor.becomeRoot(TREE_BEGIN115_tree, root_0);
			}

			pushFollow(FOLLOW_treeRoot_in_tree_2099);
			treeRoot116=treeRoot();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, treeRoot116.getTree());

			// org/antlr/grammar/v3/ANTLR.g:791:12: ( element )+
			int cnt62=0;
			loop62:
			while (true) {
				int alt62=2;
				int LA62_0 = input.LA(1);
				if ( (LA62_0==ACTION||LA62_0==CHAR_LITERAL||LA62_0==FORCED_ACTION||LA62_0==LPAREN||LA62_0==NOT||LA62_0==RULE_REF||LA62_0==SEMPRED||LA62_0==STRING_LITERAL||LA62_0==TOKEN_REF||LA62_0==TREE_BEGIN||LA62_0==WILDCARD) ) {
					alt62=1;
				}

				switch (alt62) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:791:12: element
					{
					pushFollow(FOLLOW_element_in_tree_2101);
					element117=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, element117.getTree());

					}
					break;

				default :
					if ( cnt62 >= 1 ) break loop62;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(62, input);
					throw eee;
				}
				cnt62++;
			}

			RPAREN118=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tree_2106); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tree_"


	public static class ebnf_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "ebnf"
	// org/antlr/grammar/v3/ANTLR.g:796:1: ebnf : block ( QUESTION -> ^( OPTIONAL[$start,\"?\"] block ) | STAR -> ^( CLOSURE[$start,\"*\"] block ) | PLUS -> ^( POSITIVE_CLOSURE[$start,\"+\"] block ) | IMPLIES -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block ) ->| ROOT -> ^( ROOT block ) | BANG -> ^( BANG block ) | -> block ) ;
	public final ANTLRParser.ebnf_return ebnf() throws RecognitionException {
		ANTLRParser.ebnf_return retval = new ANTLRParser.ebnf_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token QUESTION120=null;
		Token STAR121=null;
		Token PLUS122=null;
		Token IMPLIES123=null;
		Token ROOT124=null;
		Token BANG125=null;
		ParserRuleReturnScope block119 =null;

		GrammarAST QUESTION120_tree=null;
		GrammarAST STAR121_tree=null;
		GrammarAST PLUS122_tree=null;
		GrammarAST IMPLIES123_tree=null;
		GrammarAST ROOT124_tree=null;
		GrammarAST BANG125_tree=null;
		RewriteRuleTokenStream stream_IMPLIES=new RewriteRuleTokenStream(adaptor,"token IMPLIES");
		RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
		RewriteRuleTokenStream stream_ROOT=new RewriteRuleTokenStream(adaptor,"token ROOT");
		RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
		RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
		RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// org/antlr/grammar/v3/ANTLR.g:797:2: ( block ( QUESTION -> ^( OPTIONAL[$start,\"?\"] block ) | STAR -> ^( CLOSURE[$start,\"*\"] block ) | PLUS -> ^( POSITIVE_CLOSURE[$start,\"+\"] block ) | IMPLIES -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block ) ->| ROOT -> ^( ROOT block ) | BANG -> ^( BANG block ) | -> block ) )
			// org/antlr/grammar/v3/ANTLR.g:797:4: block ( QUESTION -> ^( OPTIONAL[$start,\"?\"] block ) | STAR -> ^( CLOSURE[$start,\"*\"] block ) | PLUS -> ^( POSITIVE_CLOSURE[$start,\"+\"] block ) | IMPLIES -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block ) ->| ROOT -> ^( ROOT block ) | BANG -> ^( BANG block ) | -> block )
			{
			pushFollow(FOLLOW_block_in_ebnf2120);
			block119=block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block.add(block119.getTree());
			// org/antlr/grammar/v3/ANTLR.g:798:3: ( QUESTION -> ^( OPTIONAL[$start,\"?\"] block ) | STAR -> ^( CLOSURE[$start,\"*\"] block ) | PLUS -> ^( POSITIVE_CLOSURE[$start,\"+\"] block ) | IMPLIES -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block ) ->| ROOT -> ^( ROOT block ) | BANG -> ^( BANG block ) | -> block )
			int alt63=7;
			switch ( input.LA(1) ) {
			case QUESTION:
				{
				alt63=1;
				}
				break;
			case STAR:
				{
				alt63=2;
				}
				break;
			case PLUS:
				{
				alt63=3;
				}
				break;
			case IMPLIES:
				{
				alt63=4;
				}
				break;
			case ROOT:
				{
				alt63=5;
				}
				break;
			case BANG:
				{
				alt63=6;
				}
				break;
			case ACTION:
			case CHAR_LITERAL:
			case FORCED_ACTION:
			case LPAREN:
			case NOT:
			case OR:
			case REWRITE:
			case RPAREN:
			case RULE_REF:
			case SEMI:
			case SEMPRED:
			case STRING_LITERAL:
			case TOKEN_REF:
			case TREE_BEGIN:
			case WILDCARD:
				{
				alt63=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}
			switch (alt63) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:798:5: QUESTION
					{
					QUESTION120=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_ebnf2126); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION120);

					// AST REWRITE
					// elements: block
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 799:4: -> ^( OPTIONAL[$start,\"?\"] block )
					{
						// org/antlr/grammar/v3/ANTLR.g:799:7: ^( OPTIONAL[$start,\"?\"] block )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(OPTIONAL, (retval.start), "?"), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:800:5: STAR
					{
					STAR121=(Token)match(input,STAR,FOLLOW_STAR_in_ebnf2144); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STAR.add(STAR121);

					// AST REWRITE
					// elements: block
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 801:4: -> ^( CLOSURE[$start,\"*\"] block )
					{
						// org/antlr/grammar/v3/ANTLR.g:801:7: ^( CLOSURE[$start,\"*\"] block )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(CLOSURE, (retval.start), "*"), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:802:5: PLUS
					{
					PLUS122=(Token)match(input,PLUS,FOLLOW_PLUS_in_ebnf2162); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PLUS.add(PLUS122);

					// AST REWRITE
					// elements: block
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 803:4: -> ^( POSITIVE_CLOSURE[$start,\"+\"] block )
					{
						// org/antlr/grammar/v3/ANTLR.g:803:7: ^( POSITIVE_CLOSURE[$start,\"+\"] block )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(POSITIVE_CLOSURE, (retval.start), "+"), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:804:5: IMPLIES
					{
					IMPLIES123=(Token)match(input,IMPLIES,FOLLOW_IMPLIES_in_ebnf2180); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IMPLIES.add(IMPLIES123);

					// AST REWRITE
					// elements: block
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 806:4: -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block )
					if (grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER) {
						// org/antlr/grammar/v3/ANTLR.g:806:96: ^( SYNPRED[$start,\"=>\"] block )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(SYNPRED, (retval.start), "=>"), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 808:4: ->
					{
						adaptor.addChild(root_0, createSynSemPredFromBlock((block119!=null?((GrammarAST)block119.getTree()):null), SYN_SEMPRED));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLR.g:809:5: ROOT
					{
					ROOT124=(Token)match(input,ROOT,FOLLOW_ROOT_in_ebnf2216); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ROOT.add(ROOT124);

					// AST REWRITE
					// elements: block, ROOT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 810:4: -> ^( ROOT block )
					{
						// org/antlr/grammar/v3/ANTLR.g:810:7: ^( ROOT block )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot(stream_ROOT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLR.g:811:5: BANG
					{
					BANG125=(Token)match(input,BANG,FOLLOW_BANG_in_ebnf2233); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BANG.add(BANG125);

					// AST REWRITE
					// elements: block, BANG
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 812:4: -> ^( BANG block )
					{
						// org/antlr/grammar/v3/ANTLR.g:812:7: ^( BANG block )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot(stream_BANG.nextNode(), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// org/antlr/grammar/v3/ANTLR.g:814:4: 
					{
					// AST REWRITE
					// elements: block
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 814:4: -> block
					{
						adaptor.addChild(root_0, stream_block.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ebnf"


	public static class range_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "range"
	// org/antlr/grammar/v3/ANTLR.g:818:1: range : ({...}? =>c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2) | (t= TOKEN_REF r= RANGE TOKEN_REF |t= STRING_LITERAL r= RANGE STRING_LITERAL |t= CHAR_LITERAL r= RANGE CHAR_LITERAL ) -> $t);
	public final ANTLRParser.range_return range() throws RecognitionException {
		ANTLRParser.range_return retval = new ANTLRParser.range_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token c1=null;
		Token c2=null;
		Token t=null;
		Token r=null;
		Token RANGE126=null;
		Token TOKEN_REF127=null;
		Token STRING_LITERAL128=null;
		Token CHAR_LITERAL129=null;

		GrammarAST c1_tree=null;
		GrammarAST c2_tree=null;
		GrammarAST t_tree=null;
		GrammarAST r_tree=null;
		GrammarAST RANGE126_tree=null;
		GrammarAST TOKEN_REF127_tree=null;
		GrammarAST STRING_LITERAL128_tree=null;
		GrammarAST CHAR_LITERAL129_tree=null;
		RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
		RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
		RewriteRuleTokenStream stream_CHAR_LITERAL=new RewriteRuleTokenStream(adaptor,"token CHAR_LITERAL");
		RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");

		try {
			// org/antlr/grammar/v3/ANTLR.g:819:2: ({...}? =>c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2) | (t= TOKEN_REF r= RANGE TOKEN_REF |t= STRING_LITERAL r= RANGE STRING_LITERAL |t= CHAR_LITERAL r= RANGE CHAR_LITERAL ) -> $t)
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==CHAR_LITERAL) ) {
				int LA65_1 = input.LA(2);
				if ( (LA65_1==RANGE) ) {
					int LA65_3 = input.LA(3);
					if ( (LA65_3==CHAR_LITERAL) ) {
						int LA65_4 = input.LA(4);
						if ( ((Rule.getRuleType(currentRuleName) == Grammar.LEXER)) ) {
							alt65=1;
						}
						else if ( (true) ) {
							alt65=2;
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 65, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 65, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA65_0==STRING_LITERAL||LA65_0==TOKEN_REF) ) {
				alt65=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 65, 0, input);
				throw nvae;
			}

			switch (alt65) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:819:4: {...}? =>c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL
					{
					if ( !((Rule.getRuleType(currentRuleName) == Grammar.LEXER)) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "range", "Rule.getRuleType(currentRuleName) == Grammar.LEXER");
					}
					c1=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range2280); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(c1);

					RANGE126=(Token)match(input,RANGE,FOLLOW_RANGE_in_range2282); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RANGE.add(RANGE126);

					c2=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range2286); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(c2);

					// AST REWRITE
					// elements: c1, c2
					// token labels: c1, c2
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_c1=new RewriteRuleTokenStream(adaptor,"token c1",c1);
					RewriteRuleTokenStream stream_c2=new RewriteRuleTokenStream(adaptor,"token c2",c2);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 821:3: -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2)
					{
						// org/antlr/grammar/v3/ANTLR.g:821:6: ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2)
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(CHAR_RANGE, c1, ".."), root_1);
						adaptor.addChild(root_1, stream_c1.nextNode());
						adaptor.addChild(root_1, stream_c2.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:823:3: (t= TOKEN_REF r= RANGE TOKEN_REF |t= STRING_LITERAL r= RANGE STRING_LITERAL |t= CHAR_LITERAL r= RANGE CHAR_LITERAL )
					{
					// org/antlr/grammar/v3/ANTLR.g:823:3: (t= TOKEN_REF r= RANGE TOKEN_REF |t= STRING_LITERAL r= RANGE STRING_LITERAL |t= CHAR_LITERAL r= RANGE CHAR_LITERAL )
					int alt64=3;
					switch ( input.LA(1) ) {
					case TOKEN_REF:
						{
						alt64=1;
						}
						break;
					case STRING_LITERAL:
						{
						alt64=2;
						}
						break;
					case CHAR_LITERAL:
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
							// org/antlr/grammar/v3/ANTLR.g:823:5: t= TOKEN_REF r= RANGE TOKEN_REF
							{
							t=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_range2313); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_TOKEN_REF.add(t);

							r=(Token)match(input,RANGE,FOLLOW_RANGE_in_range2317); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RANGE.add(r);

							TOKEN_REF127=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_range2319); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF127);

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:824:5: t= STRING_LITERAL r= RANGE STRING_LITERAL
							{
							t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range2327); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_STRING_LITERAL.add(t);

							r=(Token)match(input,RANGE,FOLLOW_RANGE_in_range2331); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RANGE.add(r);

							STRING_LITERAL128=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range2333); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_STRING_LITERAL.add(STRING_LITERAL128);

							}
							break;
						case 3 :
							// org/antlr/grammar/v3/ANTLR.g:825:5: t= CHAR_LITERAL r= RANGE CHAR_LITERAL
							{
							t=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range2341); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(t);

							r=(Token)match(input,RANGE,FOLLOW_RANGE_in_range2345); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RANGE.add(r);

							CHAR_LITERAL129=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range2347); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(CHAR_LITERAL129);

							}
							break;

					}

					if ( state.backtracking==0 ) {
							ErrorManager.syntaxError(
								ErrorManager.MSG_RANGE_OP_ILLEGAL,grammar,r,null,null);
							}
					// AST REWRITE
					// elements: t
					// token labels: t
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_t=new RewriteRuleTokenStream(adaptor,"token t",t);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 831:3: -> $t
					{
						adaptor.addChild(root_0, stream_t.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "range"


	public static class terminal_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "terminal"
	// org/antlr/grammar/v3/ANTLR.g:834:1: terminal : (cl= CHAR_LITERAL ^ ( elementOptions[$cl.tree] !)? ( ROOT ^| BANG ^)? |tr= TOKEN_REF ^ ( elementOptions[$tr.tree] !)? ( ARG_ACTION )? ( ROOT ^| BANG ^)? |sl= STRING_LITERAL ^ ( elementOptions[$sl.tree] !)? ( ROOT ^| BANG ^)? |wi= WILDCARD ( ROOT ^| BANG ^)? );
	public final ANTLRParser.terminal_return terminal() throws RecognitionException {
		ANTLRParser.terminal_return retval = new ANTLRParser.terminal_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token cl=null;
		Token tr=null;
		Token sl=null;
		Token wi=null;
		Token ROOT131=null;
		Token BANG132=null;
		Token ARG_ACTION134=null;
		Token ROOT135=null;
		Token BANG136=null;
		Token ROOT138=null;
		Token BANG139=null;
		Token ROOT140=null;
		Token BANG141=null;
		ParserRuleReturnScope elementOptions130 =null;
		ParserRuleReturnScope elementOptions133 =null;
		ParserRuleReturnScope elementOptions137 =null;

		GrammarAST cl_tree=null;
		GrammarAST tr_tree=null;
		GrammarAST sl_tree=null;
		GrammarAST wi_tree=null;
		GrammarAST ROOT131_tree=null;
		GrammarAST BANG132_tree=null;
		GrammarAST ARG_ACTION134_tree=null;
		GrammarAST ROOT135_tree=null;
		GrammarAST BANG136_tree=null;
		GrammarAST ROOT138_tree=null;
		GrammarAST BANG139_tree=null;
		GrammarAST ROOT140_tree=null;
		GrammarAST BANG141_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:835:2: (cl= CHAR_LITERAL ^ ( elementOptions[$cl.tree] !)? ( ROOT ^| BANG ^)? |tr= TOKEN_REF ^ ( elementOptions[$tr.tree] !)? ( ARG_ACTION )? ( ROOT ^| BANG ^)? |sl= STRING_LITERAL ^ ( elementOptions[$sl.tree] !)? ( ROOT ^| BANG ^)? |wi= WILDCARD ( ROOT ^| BANG ^)? )
			int alt74=4;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				alt74=1;
				}
				break;
			case TOKEN_REF:
				{
				alt74=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt74=3;
				}
				break;
			case WILDCARD:
				{
				alt74=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 74, 0, input);
				throw nvae;
			}
			switch (alt74) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:835:4: cl= CHAR_LITERAL ^ ( elementOptions[$cl.tree] !)? ( ROOT ^| BANG ^)?
					{
					root_0 = (GrammarAST)adaptor.nil();


					cl=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_terminal2376); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					cl_tree = (GrammarAST)adaptor.create(cl);
					root_0 = (GrammarAST)adaptor.becomeRoot(cl_tree, root_0);
					}

					// org/antlr/grammar/v3/ANTLR.g:835:21: ( elementOptions[$cl.tree] !)?
					int alt66=2;
					int LA66_0 = input.LA(1);
					if ( (LA66_0==OPEN_ELEMENT_OPTION) ) {
						alt66=1;
					}
					switch (alt66) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:835:23: elementOptions[$cl.tree] !
							{
							pushFollow(FOLLOW_elementOptions_in_terminal2381);
							elementOptions130=elementOptions(cl_tree);
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					// org/antlr/grammar/v3/ANTLR.g:835:52: ( ROOT ^| BANG ^)?
					int alt67=3;
					int LA67_0 = input.LA(1);
					if ( (LA67_0==ROOT) ) {
						alt67=1;
					}
					else if ( (LA67_0==BANG) ) {
						alt67=2;
					}
					switch (alt67) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:835:53: ROOT ^
							{
							ROOT131=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2389); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ROOT131_tree = (GrammarAST)adaptor.create(ROOT131);
							root_0 = (GrammarAST)adaptor.becomeRoot(ROOT131_tree, root_0);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:835:59: BANG ^
							{
							BANG132=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2392); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							BANG132_tree = (GrammarAST)adaptor.create(BANG132);
							root_0 = (GrammarAST)adaptor.becomeRoot(BANG132_tree, root_0);
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:837:4: tr= TOKEN_REF ^ ( elementOptions[$tr.tree] !)? ( ARG_ACTION )? ( ROOT ^| BANG ^)?
					{
					root_0 = (GrammarAST)adaptor.nil();


					tr=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal2403); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					tr_tree = (GrammarAST)adaptor.create(tr);
					root_0 = (GrammarAST)adaptor.becomeRoot(tr_tree, root_0);
					}

					// org/antlr/grammar/v3/ANTLR.g:838:3: ( elementOptions[$tr.tree] !)?
					int alt68=2;
					int LA68_0 = input.LA(1);
					if ( (LA68_0==OPEN_ELEMENT_OPTION) ) {
						alt68=1;
					}
					switch (alt68) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:838:5: elementOptions[$tr.tree] !
							{
							pushFollow(FOLLOW_elementOptions_in_terminal2410);
							elementOptions133=elementOptions(tr_tree);
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					// org/antlr/grammar/v3/ANTLR.g:839:3: ( ARG_ACTION )?
					int alt69=2;
					int LA69_0 = input.LA(1);
					if ( (LA69_0==ARG_ACTION) ) {
						alt69=1;
					}
					switch (alt69) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:839:5: ARG_ACTION
							{
							ARG_ACTION134=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_terminal2421); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ARG_ACTION134_tree = (GrammarAST)adaptor.create(ARG_ACTION134);
							adaptor.addChild(root_0, ARG_ACTION134_tree);
							}

							}
							break;

					}

					// org/antlr/grammar/v3/ANTLR.g:840:3: ( ROOT ^| BANG ^)?
					int alt70=3;
					int LA70_0 = input.LA(1);
					if ( (LA70_0==ROOT) ) {
						alt70=1;
					}
					else if ( (LA70_0==BANG) ) {
						alt70=2;
					}
					switch (alt70) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:840:4: ROOT ^
							{
							ROOT135=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2430); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ROOT135_tree = (GrammarAST)adaptor.create(ROOT135);
							root_0 = (GrammarAST)adaptor.becomeRoot(ROOT135_tree, root_0);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:840:10: BANG ^
							{
							BANG136=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2433); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							BANG136_tree = (GrammarAST)adaptor.create(BANG136);
							root_0 = (GrammarAST)adaptor.becomeRoot(BANG136_tree, root_0);
							}

							}
							break;

					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:842:4: sl= STRING_LITERAL ^ ( elementOptions[$sl.tree] !)? ( ROOT ^| BANG ^)?
					{
					root_0 = (GrammarAST)adaptor.nil();


					sl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal2444); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					sl_tree = (GrammarAST)adaptor.create(sl);
					root_0 = (GrammarAST)adaptor.becomeRoot(sl_tree, root_0);
					}

					// org/antlr/grammar/v3/ANTLR.g:842:23: ( elementOptions[$sl.tree] !)?
					int alt71=2;
					int LA71_0 = input.LA(1);
					if ( (LA71_0==OPEN_ELEMENT_OPTION) ) {
						alt71=1;
					}
					switch (alt71) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:842:25: elementOptions[$sl.tree] !
							{
							pushFollow(FOLLOW_elementOptions_in_terminal2449);
							elementOptions137=elementOptions(sl_tree);
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					// org/antlr/grammar/v3/ANTLR.g:842:54: ( ROOT ^| BANG ^)?
					int alt72=3;
					int LA72_0 = input.LA(1);
					if ( (LA72_0==ROOT) ) {
						alt72=1;
					}
					else if ( (LA72_0==BANG) ) {
						alt72=2;
					}
					switch (alt72) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:842:55: ROOT ^
							{
							ROOT138=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2457); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ROOT138_tree = (GrammarAST)adaptor.create(ROOT138);
							root_0 = (GrammarAST)adaptor.becomeRoot(ROOT138_tree, root_0);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:842:61: BANG ^
							{
							BANG139=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2460); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							BANG139_tree = (GrammarAST)adaptor.create(BANG139);
							root_0 = (GrammarAST)adaptor.becomeRoot(BANG139_tree, root_0);
							}

							}
							break;

					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:844:4: wi= WILDCARD ( ROOT ^| BANG ^)?
					{
					root_0 = (GrammarAST)adaptor.nil();


					wi=(Token)match(input,WILDCARD,FOLLOW_WILDCARD_in_terminal2471); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					wi_tree = (GrammarAST)adaptor.create(wi);
					adaptor.addChild(root_0, wi_tree);
					}

					// org/antlr/grammar/v3/ANTLR.g:844:16: ( ROOT ^| BANG ^)?
					int alt73=3;
					int LA73_0 = input.LA(1);
					if ( (LA73_0==ROOT) ) {
						alt73=1;
					}
					else if ( (LA73_0==BANG) ) {
						alt73=2;
					}
					switch (alt73) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:844:17: ROOT ^
							{
							ROOT140=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2474); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ROOT140_tree = (GrammarAST)adaptor.create(ROOT140);
							root_0 = (GrammarAST)adaptor.becomeRoot(ROOT140_tree, root_0);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:844:23: BANG ^
							{
							BANG141=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2477); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							BANG141_tree = (GrammarAST)adaptor.create(BANG141);
							root_0 = (GrammarAST)adaptor.becomeRoot(BANG141_tree, root_0);
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
								if ( atTreeRoot )
								{
									ErrorManager.syntaxError(
										ErrorManager.MSG_WILDCARD_AS_ROOT,grammar,wi,null,null);
								}
							}
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "terminal"


	public static class elementOptions_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "elementOptions"
	// org/antlr/grammar/v3/ANTLR.g:854:1: elementOptions[GrammarAST terminalAST] : ( OPEN_ELEMENT_OPTION ^ defaultNodeOption[terminalAST] CLOSE_ELEMENT_OPTION !| OPEN_ELEMENT_OPTION ^ elementOption[terminalAST] ( SEMI ! elementOption[terminalAST] )* CLOSE_ELEMENT_OPTION !);
	public final ANTLRParser.elementOptions_return elementOptions(GrammarAST terminalAST) throws RecognitionException {
		ANTLRParser.elementOptions_return retval = new ANTLRParser.elementOptions_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token OPEN_ELEMENT_OPTION142=null;
		Token CLOSE_ELEMENT_OPTION144=null;
		Token OPEN_ELEMENT_OPTION145=null;
		Token SEMI147=null;
		Token CLOSE_ELEMENT_OPTION149=null;
		ParserRuleReturnScope defaultNodeOption143 =null;
		ParserRuleReturnScope elementOption146 =null;
		ParserRuleReturnScope elementOption148 =null;

		GrammarAST OPEN_ELEMENT_OPTION142_tree=null;
		GrammarAST CLOSE_ELEMENT_OPTION144_tree=null;
		GrammarAST OPEN_ELEMENT_OPTION145_tree=null;
		GrammarAST SEMI147_tree=null;
		GrammarAST CLOSE_ELEMENT_OPTION149_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:855:2: ( OPEN_ELEMENT_OPTION ^ defaultNodeOption[terminalAST] CLOSE_ELEMENT_OPTION !| OPEN_ELEMENT_OPTION ^ elementOption[terminalAST] ( SEMI ! elementOption[terminalAST] )* CLOSE_ELEMENT_OPTION !)
			int alt76=2;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==OPEN_ELEMENT_OPTION) ) {
				int LA76_1 = input.LA(2);
				if ( (LA76_1==TOKEN_REF) ) {
					int LA76_2 = input.LA(3);
					if ( (LA76_2==CLOSE_ELEMENT_OPTION||LA76_2==WILDCARD) ) {
						alt76=1;
					}
					else if ( (LA76_2==ASSIGN) ) {
						alt76=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 76, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA76_1==RULE_REF) ) {
					int LA76_3 = input.LA(3);
					if ( (LA76_3==CLOSE_ELEMENT_OPTION||LA76_3==WILDCARD) ) {
						alt76=1;
					}
					else if ( (LA76_3==ASSIGN) ) {
						alt76=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 76, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 76, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				throw nvae;
			}

			switch (alt76) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:855:4: OPEN_ELEMENT_OPTION ^ defaultNodeOption[terminalAST] CLOSE_ELEMENT_OPTION !
					{
					root_0 = (GrammarAST)adaptor.nil();


					OPEN_ELEMENT_OPTION142=(Token)match(input,OPEN_ELEMENT_OPTION,FOLLOW_OPEN_ELEMENT_OPTION_in_elementOptions2496); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OPEN_ELEMENT_OPTION142_tree = (GrammarAST)adaptor.create(OPEN_ELEMENT_OPTION142);
					root_0 = (GrammarAST)adaptor.becomeRoot(OPEN_ELEMENT_OPTION142_tree, root_0);
					}

					pushFollow(FOLLOW_defaultNodeOption_in_elementOptions2499);
					defaultNodeOption143=defaultNodeOption(terminalAST);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultNodeOption143.getTree());

					CLOSE_ELEMENT_OPTION144=(Token)match(input,CLOSE_ELEMENT_OPTION,FOLLOW_CLOSE_ELEMENT_OPTION_in_elementOptions2502); if (state.failed) return retval;
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:856:4: OPEN_ELEMENT_OPTION ^ elementOption[terminalAST] ( SEMI ! elementOption[terminalAST] )* CLOSE_ELEMENT_OPTION !
					{
					root_0 = (GrammarAST)adaptor.nil();


					OPEN_ELEMENT_OPTION145=(Token)match(input,OPEN_ELEMENT_OPTION,FOLLOW_OPEN_ELEMENT_OPTION_in_elementOptions2508); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OPEN_ELEMENT_OPTION145_tree = (GrammarAST)adaptor.create(OPEN_ELEMENT_OPTION145);
					root_0 = (GrammarAST)adaptor.becomeRoot(OPEN_ELEMENT_OPTION145_tree, root_0);
					}

					pushFollow(FOLLOW_elementOption_in_elementOptions2511);
					elementOption146=elementOption(terminalAST);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, elementOption146.getTree());

					// org/antlr/grammar/v3/ANTLR.g:856:52: ( SEMI ! elementOption[terminalAST] )*
					loop75:
					while (true) {
						int alt75=2;
						int LA75_0 = input.LA(1);
						if ( (LA75_0==SEMI) ) {
							alt75=1;
						}

						switch (alt75) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:856:53: SEMI ! elementOption[terminalAST]
							{
							SEMI147=(Token)match(input,SEMI,FOLLOW_SEMI_in_elementOptions2515); if (state.failed) return retval;
							pushFollow(FOLLOW_elementOption_in_elementOptions2518);
							elementOption148=elementOption(terminalAST);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, elementOption148.getTree());

							}
							break;

						default :
							break loop75;
						}
					}

					CLOSE_ELEMENT_OPTION149=(Token)match(input,CLOSE_ELEMENT_OPTION,FOLLOW_CLOSE_ELEMENT_OPTION_in_elementOptions2523); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elementOptions"


	public static class defaultNodeOption_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "defaultNodeOption"
	// org/antlr/grammar/v3/ANTLR.g:859:1: defaultNodeOption[GrammarAST terminalAST] : elementOptionId ;
	public final ANTLRParser.defaultNodeOption_return defaultNodeOption(GrammarAST terminalAST) throws RecognitionException {
		ANTLRParser.defaultNodeOption_return retval = new ANTLRParser.defaultNodeOption_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope elementOptionId150 =null;


		try {
			// org/antlr/grammar/v3/ANTLR.g:860:2: ( elementOptionId )
			// org/antlr/grammar/v3/ANTLR.g:860:4: elementOptionId
			{
			root_0 = (GrammarAST)adaptor.nil();


			pushFollow(FOLLOW_elementOptionId_in_defaultNodeOption2536);
			elementOptionId150=elementOptionId();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, elementOptionId150.getTree());

			if ( state.backtracking==0 ) {terminalAST.setTerminalOption(grammar,Grammar.defaultTokenOption,(elementOptionId150!=null?((ANTLRParser.elementOptionId_return)elementOptionId150).qid:null));}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "defaultNodeOption"


	public static class elementOption_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "elementOption"
	// org/antlr/grammar/v3/ANTLR.g:864:1: elementOption[GrammarAST terminalAST] : id ASSIGN ^ ( elementOptionId | (t= STRING_LITERAL |t= DOUBLE_QUOTE_STRING_LITERAL |t= DOUBLE_ANGLE_STRING_LITERAL ) ) ;
	public final ANTLRParser.elementOption_return elementOption(GrammarAST terminalAST) throws RecognitionException {
		ANTLRParser.elementOption_return retval = new ANTLRParser.elementOption_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token t=null;
		Token ASSIGN152=null;
		ParserRuleReturnScope id151 =null;
		ParserRuleReturnScope elementOptionId153 =null;

		GrammarAST t_tree=null;
		GrammarAST ASSIGN152_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:865:2: ( id ASSIGN ^ ( elementOptionId | (t= STRING_LITERAL |t= DOUBLE_QUOTE_STRING_LITERAL |t= DOUBLE_ANGLE_STRING_LITERAL ) ) )
			// org/antlr/grammar/v3/ANTLR.g:865:4: id ASSIGN ^ ( elementOptionId | (t= STRING_LITERAL |t= DOUBLE_QUOTE_STRING_LITERAL |t= DOUBLE_ANGLE_STRING_LITERAL ) )
			{
			root_0 = (GrammarAST)adaptor.nil();


			pushFollow(FOLLOW_id_in_elementOption2552);
			id151=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id151.getTree());

			ASSIGN152=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption2554); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN152_tree = (GrammarAST)adaptor.create(ASSIGN152);
			root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN152_tree, root_0);
			}

			// org/antlr/grammar/v3/ANTLR.g:866:3: ( elementOptionId | (t= STRING_LITERAL |t= DOUBLE_QUOTE_STRING_LITERAL |t= DOUBLE_ANGLE_STRING_LITERAL ) )
			int alt78=2;
			int LA78_0 = input.LA(1);
			if ( (LA78_0==RULE_REF||LA78_0==TOKEN_REF) ) {
				alt78=1;
			}
			else if ( ((LA78_0 >= DOUBLE_ANGLE_STRING_LITERAL && LA78_0 <= DOUBLE_QUOTE_STRING_LITERAL)||LA78_0==STRING_LITERAL) ) {
				alt78=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 78, 0, input);
				throw nvae;
			}

			switch (alt78) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:866:5: elementOptionId
					{
					pushFollow(FOLLOW_elementOptionId_in_elementOption2561);
					elementOptionId153=elementOptionId();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, elementOptionId153.getTree());

					if ( state.backtracking==0 ) {terminalAST.setTerminalOption(grammar,(id151!=null?input.toString(id151.start,id151.stop):null),(elementOptionId153!=null?((ANTLRParser.elementOptionId_return)elementOptionId153).qid:null));}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:868:5: (t= STRING_LITERAL |t= DOUBLE_QUOTE_STRING_LITERAL |t= DOUBLE_ANGLE_STRING_LITERAL )
					{
					// org/antlr/grammar/v3/ANTLR.g:868:5: (t= STRING_LITERAL |t= DOUBLE_QUOTE_STRING_LITERAL |t= DOUBLE_ANGLE_STRING_LITERAL )
					int alt77=3;
					switch ( input.LA(1) ) {
					case STRING_LITERAL:
						{
						alt77=1;
						}
						break;
					case DOUBLE_QUOTE_STRING_LITERAL:
						{
						alt77=2;
						}
						break;
					case DOUBLE_ANGLE_STRING_LITERAL:
						{
						alt77=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 77, 0, input);
						throw nvae;
					}
					switch (alt77) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:868:6: t= STRING_LITERAL
							{
							t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_elementOption2575); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							t_tree = (GrammarAST)adaptor.create(t);
							adaptor.addChild(root_0, t_tree);
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:868:23: t= DOUBLE_QUOTE_STRING_LITERAL
							{
							t=(Token)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_elementOption2579); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							t_tree = (GrammarAST)adaptor.create(t);
							adaptor.addChild(root_0, t_tree);
							}

							}
							break;
						case 3 :
							// org/antlr/grammar/v3/ANTLR.g:868:53: t= DOUBLE_ANGLE_STRING_LITERAL
							{
							t=(Token)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_elementOption2583); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							t_tree = (GrammarAST)adaptor.create(t);
							adaptor.addChild(root_0, t_tree);
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {terminalAST.setTerminalOption(grammar,(id151!=null?input.toString(id151.start,id151.stop):null),(t!=null?t.getText():null));}
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elementOption"


	public static class elementOptionId_return extends ParserRuleReturnScope {
		public String qid;
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "elementOptionId"
	// org/antlr/grammar/v3/ANTLR.g:873:1: elementOptionId returns [String qid] : i= id ( '.' i= id )* ;
	public final ANTLRParser.elementOptionId_return elementOptionId() throws RecognitionException {
		ANTLRParser.elementOptionId_return retval = new ANTLRParser.elementOptionId_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token char_literal154=null;
		ParserRuleReturnScope i =null;

		GrammarAST char_literal154_tree=null;

		StringBuffer buf = new StringBuffer();
		try {
			// org/antlr/grammar/v3/ANTLR.g:875:2: (i= id ( '.' i= id )* )
			// org/antlr/grammar/v3/ANTLR.g:875:4: i= id ( '.' i= id )*
			{
			root_0 = (GrammarAST)adaptor.nil();


			pushFollow(FOLLOW_id_in_elementOptionId2614);
			i=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, i.getTree());

			if ( state.backtracking==0 ) {buf.append((i!=null?input.toString(i.start,i.stop):null));}
			// org/antlr/grammar/v3/ANTLR.g:875:32: ( '.' i= id )*
			loop79:
			while (true) {
				int alt79=2;
				int LA79_0 = input.LA(1);
				if ( (LA79_0==WILDCARD) ) {
					alt79=1;
				}

				switch (alt79) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:875:33: '.' i= id
					{
					char_literal154=(Token)match(input,WILDCARD,FOLLOW_WILDCARD_in_elementOptionId2619); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal154_tree = (GrammarAST)adaptor.create(char_literal154);
					adaptor.addChild(root_0, char_literal154_tree);
					}

					pushFollow(FOLLOW_id_in_elementOptionId2623);
					i=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, i.getTree());

					if ( state.backtracking==0 ) {buf.append("." + (i!=null?input.toString(i.start,i.stop):null));}
					}
					break;

				default :
					break loop79;
				}
			}

			if ( state.backtracking==0 ) {retval.qid = buf.toString();}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elementOptionId"


	public static class ebnfSuffix_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "ebnfSuffix"
	// org/antlr/grammar/v3/ANTLR.g:879:1: ebnfSuffix[GrammarAST elemAST, boolean inRewrite] : ( -> BLOCK[$elemAST.getToken(), \"BLOCK\"] ) ( -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] ) ) ( QUESTION -> OPTIONAL[$elemAST.getToken(),\"?\"] | STAR -> CLOSURE[$elemAST.getToken(),\"*\"] | PLUS -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"] ) -> ^( $ebnfSuffix ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] ) ) ;
	public final ANTLRParser.ebnfSuffix_return ebnfSuffix(GrammarAST elemAST, boolean inRewrite) throws RecognitionException {
		ANTLRParser.ebnfSuffix_return retval = new ANTLRParser.ebnfSuffix_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token QUESTION155=null;
		Token STAR156=null;
		Token PLUS157=null;

		GrammarAST QUESTION155_tree=null;
		GrammarAST STAR156_tree=null;
		GrammarAST PLUS157_tree=null;
		RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
		RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
		RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");


		GrammarAST blkRoot=null;
		GrammarAST alt=null;
		GrammarAST save = currentBlockAST;

		try {
			// org/antlr/grammar/v3/ANTLR.g:890:2: ( ( -> BLOCK[$elemAST.getToken(), \"BLOCK\"] ) ( -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] ) ) ( QUESTION -> OPTIONAL[$elemAST.getToken(),\"?\"] | STAR -> CLOSURE[$elemAST.getToken(),\"*\"] | PLUS -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"] ) -> ^( $ebnfSuffix ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] ) ) )
			// org/antlr/grammar/v3/ANTLR.g:890:4: ( -> BLOCK[$elemAST.getToken(), \"BLOCK\"] ) ( -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] ) ) ( QUESTION -> OPTIONAL[$elemAST.getToken(),\"?\"] | STAR -> CLOSURE[$elemAST.getToken(),\"*\"] | PLUS -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"] )
			{
			// org/antlr/grammar/v3/ANTLR.g:890:4: ( -> BLOCK[$elemAST.getToken(), \"BLOCK\"] )
			// org/antlr/grammar/v3/ANTLR.g:890:6: 
			{
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 890:6: -> BLOCK[$elemAST.getToken(), \"BLOCK\"]
			{
				adaptor.addChild(root_0, (GrammarAST)adaptor.create(BLOCK, elemAST.getToken(), "BLOCK"));
			}


			retval.tree = root_0;
			}

			}

			if ( state.backtracking==0 ) { blkRoot = (GrammarAST)retval.tree.getChild(0); currentBlockAST = blkRoot; }
			// org/antlr/grammar/v3/ANTLR.g:893:3: ( -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] ) )
			// org/antlr/grammar/v3/ANTLR.g:894:4: 
			{
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 894:4: -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] )
			{
				// org/antlr/grammar/v3/ANTLR.g:894:7: ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, elemAST.getToken(), "ALT"), root_1);
				adaptor.addChild(root_1, elemAST);
				adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, "<end-of-alt>"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			if ( state.backtracking==0 ) {
						alt = (GrammarAST)retval.tree.getChild(0);
						if ( !inRewrite )
							prefixWithSynPred(alt);
					}
			// org/antlr/grammar/v3/ANTLR.g:901:3: ( QUESTION -> OPTIONAL[$elemAST.getToken(),\"?\"] | STAR -> CLOSURE[$elemAST.getToken(),\"*\"] | PLUS -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"] )
			int alt80=3;
			switch ( input.LA(1) ) {
			case QUESTION:
				{
				alt80=1;
				}
				break;
			case STAR:
				{
				alt80=2;
				}
				break;
			case PLUS:
				{
				alt80=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 80, 0, input);
				throw nvae;
			}
			switch (alt80) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:901:5: QUESTION
					{
					QUESTION155=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_ebnfSuffix2700); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION155);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 902:4: -> OPTIONAL[$elemAST.getToken(),\"?\"]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(OPTIONAL, elemAST.getToken(), "?"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:903:5: STAR
					{
					STAR156=(Token)match(input,STAR,FOLLOW_STAR_in_ebnfSuffix2714); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STAR.add(STAR156);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 904:4: -> CLOSURE[$elemAST.getToken(),\"*\"]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(CLOSURE, elemAST.getToken(), "*"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:905:5: PLUS
					{
					PLUS157=(Token)match(input,PLUS,FOLLOW_PLUS_in_ebnfSuffix2728); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PLUS.add(PLUS157);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 906:4: -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(POSITIVE_CLOSURE, elemAST.getToken(), "+"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			// AST REWRITE
			// elements: ebnfSuffix
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 908:3: -> ^( $ebnfSuffix ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] ) )
			{
				// org/antlr/grammar/v3/ANTLR.g:908:6: ^( $ebnfSuffix ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] ) )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot(stream_retval.nextNode(), root_1);
				// org/antlr/grammar/v3/ANTLR.g:908:20: ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] )
				{
				GrammarAST root_2 = (GrammarAST)adaptor.nil();
				root_2 = (GrammarAST)adaptor.becomeRoot(blkRoot, root_2);
				adaptor.addChild(root_2, alt);
				adaptor.addChild(root_2, (GrammarAST)adaptor.create(EOB, elemAST.getToken(), "<end-of-block>"));
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			currentBlockAST = save;
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ebnfSuffix"


	public static class notTerminal_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "notTerminal"
	// org/antlr/grammar/v3/ANTLR.g:911:1: notTerminal : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL );
	public final ANTLRParser.notTerminal_return notTerminal() throws RecognitionException {
		ANTLRParser.notTerminal_return retval = new ANTLRParser.notTerminal_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token set158=null;

		GrammarAST set158_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:912:2: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL )
			// org/antlr/grammar/v3/ANTLR.g:
			{
			root_0 = (GrammarAST)adaptor.nil();


			set158=input.LT(1);
			if ( input.LA(1)==CHAR_LITERAL||input.LA(1)==STRING_LITERAL||input.LA(1)==TOKEN_REF ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (GrammarAST)adaptor.create(set158));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "notTerminal"


	public static class idList_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "idList"
	// org/antlr/grammar/v3/ANTLR.g:917:1: idList : id ( COMMA ! id )* ;
	public final ANTLRParser.idList_return idList() throws RecognitionException {
		ANTLRParser.idList_return retval = new ANTLRParser.idList_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token COMMA160=null;
		ParserRuleReturnScope id159 =null;
		ParserRuleReturnScope id161 =null;

		GrammarAST COMMA160_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:918:2: ( id ( COMMA ! id )* )
			// org/antlr/grammar/v3/ANTLR.g:918:4: id ( COMMA ! id )*
			{
			root_0 = (GrammarAST)adaptor.nil();


			pushFollow(FOLLOW_id_in_idList2790);
			id159=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id159.getTree());

			// org/antlr/grammar/v3/ANTLR.g:918:7: ( COMMA ! id )*
			loop81:
			while (true) {
				int alt81=2;
				int LA81_0 = input.LA(1);
				if ( (LA81_0==COMMA) ) {
					alt81=1;
				}

				switch (alt81) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:918:8: COMMA ! id
					{
					COMMA160=(Token)match(input,COMMA,FOLLOW_COMMA_in_idList2793); if (state.failed) return retval;
					pushFollow(FOLLOW_id_in_idList2796);
					id161=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id161.getTree());

					}
					break;

				default :
					break loop81;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "idList"


	public static class id_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "id"
	// org/antlr/grammar/v3/ANTLR.g:921:1: id : ( TOKEN_REF -> ID[$TOKEN_REF] | RULE_REF -> ID[$RULE_REF] );
	public final ANTLRParser.id_return id() throws RecognitionException {
		ANTLRParser.id_return retval = new ANTLRParser.id_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token TOKEN_REF162=null;
		Token RULE_REF163=null;

		GrammarAST TOKEN_REF162_tree=null;
		GrammarAST RULE_REF163_tree=null;
		RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
		RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");

		try {
			// org/antlr/grammar/v3/ANTLR.g:922:2: ( TOKEN_REF -> ID[$TOKEN_REF] | RULE_REF -> ID[$RULE_REF] )
			int alt82=2;
			int LA82_0 = input.LA(1);
			if ( (LA82_0==TOKEN_REF) ) {
				alt82=1;
			}
			else if ( (LA82_0==RULE_REF) ) {
				alt82=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 82, 0, input);
				throw nvae;
			}

			switch (alt82) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:922:4: TOKEN_REF
					{
					TOKEN_REF162=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_id2809); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF162);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 923:3: -> ID[$TOKEN_REF]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(ID, TOKEN_REF162));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:924:4: RULE_REF
					{
					RULE_REF163=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_id2821); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RULE_REF.add(RULE_REF163);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 925:3: -> ID[$RULE_REF]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(ID, RULE_REF163));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "id"


	public static class rewrite_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite"
	// org/antlr/grammar/v3/ANTLR.g:930:1: rewrite : ( ( rewrite_with_sempred )* REWRITE rewrite_alternative -> ^( REWRITES ( rewrite_with_sempred )* ^( REWRITE rewrite_alternative ) ) |);
	public final ANTLRParser.rewrite_return rewrite() throws RecognitionException {
		ANTLRParser.rewrite_return retval = new ANTLRParser.rewrite_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token REWRITE165=null;
		ParserRuleReturnScope rewrite_with_sempred164 =null;
		ParserRuleReturnScope rewrite_alternative166 =null;

		GrammarAST REWRITE165_tree=null;
		RewriteRuleTokenStream stream_REWRITE=new RewriteRuleTokenStream(adaptor,"token REWRITE");
		RewriteRuleSubtreeStream stream_rewrite_alternative=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_alternative");
		RewriteRuleSubtreeStream stream_rewrite_with_sempred=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_with_sempred");

		try {
			// org/antlr/grammar/v3/ANTLR.g:931:2: ( ( rewrite_with_sempred )* REWRITE rewrite_alternative -> ^( REWRITES ( rewrite_with_sempred )* ^( REWRITE rewrite_alternative ) ) |)
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==REWRITE) ) {
				alt84=1;
			}
			else if ( (LA84_0==OR||LA84_0==RPAREN||LA84_0==SEMI) ) {
				alt84=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 84, 0, input);
				throw nvae;
			}

			switch (alt84) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:931:4: ( rewrite_with_sempred )* REWRITE rewrite_alternative
					{
					// org/antlr/grammar/v3/ANTLR.g:931:4: ( rewrite_with_sempred )*
					loop83:
					while (true) {
						int alt83=2;
						int LA83_0 = input.LA(1);
						if ( (LA83_0==REWRITE) ) {
							int LA83_1 = input.LA(2);
							if ( (LA83_1==SEMPRED) ) {
								alt83=1;
							}

						}

						switch (alt83) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:931:4: rewrite_with_sempred
							{
							pushFollow(FOLLOW_rewrite_with_sempred_in_rewrite2841);
							rewrite_with_sempred164=rewrite_with_sempred();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rewrite_with_sempred.add(rewrite_with_sempred164.getTree());
							}
							break;

						default :
							break loop83;
						}
					}

					REWRITE165=(Token)match(input,REWRITE,FOLLOW_REWRITE_in_rewrite2846); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_REWRITE.add(REWRITE165);

					pushFollow(FOLLOW_rewrite_alternative_in_rewrite2848);
					rewrite_alternative166=rewrite_alternative();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_alternative.add(rewrite_alternative166.getTree());
					// AST REWRITE
					// elements: REWRITE, rewrite_with_sempred, rewrite_alternative
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 933:3: -> ^( REWRITES ( rewrite_with_sempred )* ^( REWRITE rewrite_alternative ) )
					{
						// org/antlr/grammar/v3/ANTLR.g:933:6: ^( REWRITES ( rewrite_with_sempred )* ^( REWRITE rewrite_alternative ) )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(REWRITES, "REWRITES"), root_1);
						// org/antlr/grammar/v3/ANTLR.g:933:17: ( rewrite_with_sempred )*
						while ( stream_rewrite_with_sempred.hasNext() ) {
							adaptor.addChild(root_1, stream_rewrite_with_sempred.nextTree());
						}
						stream_rewrite_with_sempred.reset();

						// org/antlr/grammar/v3/ANTLR.g:933:39: ^( REWRITE rewrite_alternative )
						{
						GrammarAST root_2 = (GrammarAST)adaptor.nil();
						root_2 = (GrammarAST)adaptor.becomeRoot(stream_REWRITE.nextNode(), root_2);
						adaptor.addChild(root_2, stream_rewrite_alternative.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:935:2: 
					{
					root_0 = (GrammarAST)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite"


	public static class rewrite_with_sempred_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_with_sempred"
	// org/antlr/grammar/v3/ANTLR.g:937:1: rewrite_with_sempred : REWRITE ^ SEMPRED rewrite_alternative ;
	public final ANTLRParser.rewrite_with_sempred_return rewrite_with_sempred() throws RecognitionException {
		ANTLRParser.rewrite_with_sempred_return retval = new ANTLRParser.rewrite_with_sempred_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token REWRITE167=null;
		Token SEMPRED168=null;
		ParserRuleReturnScope rewrite_alternative169 =null;

		GrammarAST REWRITE167_tree=null;
		GrammarAST SEMPRED168_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:938:2: ( REWRITE ^ SEMPRED rewrite_alternative )
			// org/antlr/grammar/v3/ANTLR.g:938:4: REWRITE ^ SEMPRED rewrite_alternative
			{
			root_0 = (GrammarAST)adaptor.nil();


			REWRITE167=(Token)match(input,REWRITE,FOLLOW_REWRITE_in_rewrite_with_sempred2879); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			REWRITE167_tree = (GrammarAST)adaptor.create(REWRITE167);
			root_0 = (GrammarAST)adaptor.becomeRoot(REWRITE167_tree, root_0);
			}

			SEMPRED168=(Token)match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite_with_sempred2882); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SEMPRED168_tree = (GrammarAST)adaptor.create(SEMPRED168);
			adaptor.addChild(root_0, SEMPRED168_tree);
			}

			pushFollow(FOLLOW_rewrite_alternative_in_rewrite_with_sempred2884);
			rewrite_alternative169=rewrite_alternative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_alternative169.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_with_sempred"


	public static class rewrite_block_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_block"
	// org/antlr/grammar/v3/ANTLR.g:941:1: rewrite_block : LPAREN rewrite_alternative RPAREN -> ^( BLOCK[$LPAREN,\"BLOCK\"] rewrite_alternative EOB[$RPAREN,\"<end-of-block>\"] ) ;
	public final ANTLRParser.rewrite_block_return rewrite_block() throws RecognitionException {
		ANTLRParser.rewrite_block_return retval = new ANTLRParser.rewrite_block_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token LPAREN170=null;
		Token RPAREN172=null;
		ParserRuleReturnScope rewrite_alternative171 =null;

		GrammarAST LPAREN170_tree=null;
		GrammarAST RPAREN172_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_rewrite_alternative=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_alternative");

		try {
			// org/antlr/grammar/v3/ANTLR.g:942:2: ( LPAREN rewrite_alternative RPAREN -> ^( BLOCK[$LPAREN,\"BLOCK\"] rewrite_alternative EOB[$RPAREN,\"<end-of-block>\"] ) )
			// org/antlr/grammar/v3/ANTLR.g:942:4: LPAREN rewrite_alternative RPAREN
			{
			LPAREN170=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_rewrite_block2895); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN170);

			pushFollow(FOLLOW_rewrite_alternative_in_rewrite_block2899);
			rewrite_alternative171=rewrite_alternative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_alternative.add(rewrite_alternative171.getTree());
			RPAREN172=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_block2903); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN172);

			// AST REWRITE
			// elements: rewrite_alternative
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 945:3: -> ^( BLOCK[$LPAREN,\"BLOCK\"] rewrite_alternative EOB[$RPAREN,\"<end-of-block>\"] )
			{
				// org/antlr/grammar/v3/ANTLR.g:945:6: ^( BLOCK[$LPAREN,\"BLOCK\"] rewrite_alternative EOB[$RPAREN,\"<end-of-block>\"] )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(BLOCK, LPAREN170, "BLOCK"), root_1);
				adaptor.addChild(root_1, stream_rewrite_alternative.nextTree());
				adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOB, RPAREN172, "<end-of-block>"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_block"


	public static class rewrite_alternative_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_alternative"
	// org/antlr/grammar/v3/ANTLR.g:948:1: rewrite_alternative options {k=1; } : ({...}? => rewrite_template |{...}? => ( rewrite_element )+ -> {!stream_rewrite_element.hasNext()}? ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) -> ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] ) | -> ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) |{...}? ETC );
	public final ANTLRParser.rewrite_alternative_return rewrite_alternative() throws RecognitionException {
		ANTLRParser.rewrite_alternative_return retval = new ANTLRParser.rewrite_alternative_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token ETC175=null;
		ParserRuleReturnScope rewrite_template173 =null;
		ParserRuleReturnScope rewrite_element174 =null;

		GrammarAST ETC175_tree=null;
		RewriteRuleSubtreeStream stream_rewrite_element=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_element");

		try {
			// org/antlr/grammar/v3/ANTLR.g:950:2: ({...}? => rewrite_template |{...}? => ( rewrite_element )+ -> {!stream_rewrite_element.hasNext()}? ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) -> ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] ) | -> ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) |{...}? ETC )
			int alt86=4;
			int LA86_0 = input.LA(1);
			if ( (LA86_0==TOKEN_REF) && (((grammar.buildTemplate())||(grammar.buildAST())||((LT(1).getText().equals("template"))&&(grammar.buildTemplate()))))) {
				int LA86_1 = input.LA(2);
				if ( ((grammar.buildTemplate())) ) {
					alt86=1;
				}
				else if ( ((grammar.buildAST())) ) {
					alt86=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 86, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA86_0==RULE_REF) && (((grammar.buildTemplate())||(grammar.buildAST())||((LT(1).getText().equals("template"))&&(grammar.buildTemplate()))))) {
				int LA86_2 = input.LA(2);
				if ( ((grammar.buildTemplate())) ) {
					alt86=1;
				}
				else if ( ((grammar.buildAST())) ) {
					alt86=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 86, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA86_0==LPAREN) && (((grammar.buildTemplate())||(grammar.buildAST())))) {
				int LA86_3 = input.LA(2);
				if ( ((grammar.buildTemplate())) ) {
					alt86=1;
				}
				else if ( ((grammar.buildAST())) ) {
					alt86=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 86, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA86_0==ACTION) && (((grammar.buildTemplate())||(grammar.buildAST())))) {
				int LA86_4 = input.LA(2);
				if ( ((grammar.buildTemplate())) ) {
					alt86=1;
				}
				else if ( ((grammar.buildAST())) ) {
					alt86=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 86, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA86_0==CHAR_LITERAL||LA86_0==DOLLAR||LA86_0==STRING_LITERAL||LA86_0==TREE_BEGIN) && ((grammar.buildAST()))) {
				alt86=2;
			}
			else if ( (LA86_0==OR||LA86_0==REWRITE||LA86_0==RPAREN||LA86_0==SEMI) ) {
				alt86=3;
			}
			else if ( (LA86_0==ETC) ) {
				alt86=4;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 86, 0, input);
				throw nvae;
			}

			switch (alt86) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:950:4: {...}? => rewrite_template
					{
					root_0 = (GrammarAST)adaptor.nil();


					if ( !((grammar.buildTemplate())) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "rewrite_alternative", "grammar.buildTemplate()");
					}
					pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative2939);
					rewrite_template173=rewrite_template();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_template173.getTree());

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:952:4: {...}? => ( rewrite_element )+
					{
					if ( !((grammar.buildAST())) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "rewrite_alternative", "grammar.buildAST()");
					}
					// org/antlr/grammar/v3/ANTLR.g:952:29: ( rewrite_element )+
					int cnt85=0;
					loop85:
					while (true) {
						int alt85=2;
						int LA85_0 = input.LA(1);
						if ( (LA85_0==ACTION||LA85_0==CHAR_LITERAL||LA85_0==DOLLAR||LA85_0==LPAREN||LA85_0==RULE_REF||LA85_0==STRING_LITERAL||LA85_0==TOKEN_REF||LA85_0==TREE_BEGIN) ) {
							alt85=1;
						}

						switch (alt85) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:952:31: rewrite_element
							{
							pushFollow(FOLLOW_rewrite_element_in_rewrite_alternative2951);
							rewrite_element174=rewrite_element();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rewrite_element.add(rewrite_element174.getTree());
							}
							break;

						default :
							if ( cnt85 >= 1 ) break loop85;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(85, input);
							throw eee;
						}
						cnt85++;
					}

					// AST REWRITE
					// elements: rewrite_element
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 953:3: -> {!stream_rewrite_element.hasNext()}? ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] )
					if (!stream_rewrite_element.hasNext()) {
						// org/antlr/grammar/v3/ANTLR.g:953:43: ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, LT(1), "ALT"), root_1);
						adaptor.addChild(root_1, (GrammarAST)adaptor.create(EPSILON, "epsilon"));
						adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, "<end-of-alt>"));
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 954:3: -> ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] )
					{
						// org/antlr/grammar/v3/ANTLR.g:954:6: ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, LT(1), "ALT"), root_1);
						if ( !(stream_rewrite_element.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_rewrite_element.hasNext() ) {
							adaptor.addChild(root_1, stream_rewrite_element.nextTree());
						}
						stream_rewrite_element.reset();

						adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, "<end-of-alt>"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:957:3: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 957:3: -> ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] )
					{
						// org/antlr/grammar/v3/ANTLR.g:957:6: ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, LT(1), "ALT"), root_1);
						adaptor.addChild(root_1, (GrammarAST)adaptor.create(EPSILON, "epsilon"));
						adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, "<end-of-alt>"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:958:4: {...}? ETC
					{
					root_0 = (GrammarAST)adaptor.nil();


					if ( !((grammar.buildAST())) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "rewrite_alternative", "grammar.buildAST()");
					}
					ETC175=(Token)match(input,ETC,FOLLOW_ETC_in_rewrite_alternative3012); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ETC175_tree = (GrammarAST)adaptor.create(ETC175);
					adaptor.addChild(root_0, ETC175_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_alternative"


	public static class rewrite_element_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_element"
	// org/antlr/grammar/v3/ANTLR.g:961:1: rewrite_element : ( (t= rewrite_atom -> $t) (subrule= ebnfSuffix[$t.tree,true] -> $subrule)? | rewrite_ebnf | (tr= rewrite_tree -> $tr) (subrule= ebnfSuffix[$tr.tree,true] -> $subrule)? );
	public final ANTLRParser.rewrite_element_return rewrite_element() throws RecognitionException {
		ANTLRParser.rewrite_element_return retval = new ANTLRParser.rewrite_element_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		ParserRuleReturnScope t =null;
		ParserRuleReturnScope subrule =null;
		ParserRuleReturnScope tr =null;
		ParserRuleReturnScope rewrite_ebnf176 =null;

		RewriteRuleSubtreeStream stream_rewrite_atom=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_atom");
		RewriteRuleSubtreeStream stream_ebnfSuffix=new RewriteRuleSubtreeStream(adaptor,"rule ebnfSuffix");
		RewriteRuleSubtreeStream stream_rewrite_tree=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree");

		try {
			// org/antlr/grammar/v3/ANTLR.g:962:2: ( (t= rewrite_atom -> $t) (subrule= ebnfSuffix[$t.tree,true] -> $subrule)? | rewrite_ebnf | (tr= rewrite_tree -> $tr) (subrule= ebnfSuffix[$tr.tree,true] -> $subrule)? )
			int alt89=3;
			switch ( input.LA(1) ) {
			case ACTION:
			case CHAR_LITERAL:
			case DOLLAR:
			case RULE_REF:
			case STRING_LITERAL:
			case TOKEN_REF:
				{
				alt89=1;
				}
				break;
			case LPAREN:
				{
				alt89=2;
				}
				break;
			case TREE_BEGIN:
				{
				alt89=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 89, 0, input);
				throw nvae;
			}
			switch (alt89) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:962:4: (t= rewrite_atom -> $t) (subrule= ebnfSuffix[$t.tree,true] -> $subrule)?
					{
					// org/antlr/grammar/v3/ANTLR.g:962:4: (t= rewrite_atom -> $t)
					// org/antlr/grammar/v3/ANTLR.g:962:6: t= rewrite_atom
					{
					pushFollow(FOLLOW_rewrite_atom_in_rewrite_element3027);
					t=rewrite_atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_atom.add(t.getTree());
					// AST REWRITE
					// elements: t
					// token labels: 
					// rule labels: t, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 963:4: -> $t
					{
						adaptor.addChild(root_0, stream_t.nextTree());
					}


					retval.tree = root_0;
					}

					}

					// org/antlr/grammar/v3/ANTLR.g:965:3: (subrule= ebnfSuffix[$t.tree,true] -> $subrule)?
					int alt87=2;
					int LA87_0 = input.LA(1);
					if ( (LA87_0==PLUS||LA87_0==QUESTION||LA87_0==STAR) ) {
						alt87=1;
					}
					switch (alt87) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:965:5: subrule= ebnfSuffix[$t.tree,true]
							{
							pushFollow(FOLLOW_ebnfSuffix_in_rewrite_element3047);
							subrule=ebnfSuffix((t!=null?((GrammarAST)t.getTree()):null), true);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ebnfSuffix.add(subrule.getTree());
							// AST REWRITE
							// elements: subrule
							// token labels: 
							// rule labels: subrule, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_subrule=new RewriteRuleSubtreeStream(adaptor,"rule subrule",subrule!=null?subrule.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (GrammarAST)adaptor.nil();
							// 966:4: -> $subrule
							{
								adaptor.addChild(root_0, stream_subrule.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:968:4: rewrite_ebnf
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_rewrite_ebnf_in_rewrite_element3066);
					rewrite_ebnf176=rewrite_ebnf();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_ebnf176.getTree());

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:969:4: (tr= rewrite_tree -> $tr) (subrule= ebnfSuffix[$tr.tree,true] -> $subrule)?
					{
					// org/antlr/grammar/v3/ANTLR.g:969:4: (tr= rewrite_tree -> $tr)
					// org/antlr/grammar/v3/ANTLR.g:969:6: tr= rewrite_tree
					{
					pushFollow(FOLLOW_rewrite_tree_in_rewrite_element3075);
					tr=rewrite_tree();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_tree.add(tr.getTree());
					// AST REWRITE
					// elements: tr
					// token labels: 
					// rule labels: tr, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_tr=new RewriteRuleSubtreeStream(adaptor,"rule tr",tr!=null?tr.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 970:4: -> $tr
					{
						adaptor.addChild(root_0, stream_tr.nextTree());
					}


					retval.tree = root_0;
					}

					}

					// org/antlr/grammar/v3/ANTLR.g:972:3: (subrule= ebnfSuffix[$tr.tree,true] -> $subrule)?
					int alt88=2;
					int LA88_0 = input.LA(1);
					if ( (LA88_0==PLUS||LA88_0==QUESTION||LA88_0==STAR) ) {
						alt88=1;
					}
					switch (alt88) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:972:5: subrule= ebnfSuffix[$tr.tree,true]
							{
							pushFollow(FOLLOW_ebnfSuffix_in_rewrite_element3095);
							subrule=ebnfSuffix((tr!=null?((GrammarAST)tr.getTree()):null), true);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ebnfSuffix.add(subrule.getTree());
							// AST REWRITE
							// elements: subrule
							// token labels: 
							// rule labels: subrule, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_subrule=new RewriteRuleSubtreeStream(adaptor,"rule subrule",subrule!=null?subrule.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (GrammarAST)adaptor.nil();
							// 973:4: -> $subrule
							{
								adaptor.addChild(root_0, stream_subrule.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_element"


	public static class rewrite_atom_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_atom"
	// org/antlr/grammar/v3/ANTLR.g:977:1: rewrite_atom : (tr= TOKEN_REF ^ ( elementOptions[$tr.tree] !)? ( ARG_ACTION )? | RULE_REF |cl= CHAR_LITERAL ( elementOptions[$cl.tree] !)? |sl= STRING_LITERAL ( elementOptions[$sl.tree] !)? | DOLLAR ! label | ACTION );
	public final ANTLRParser.rewrite_atom_return rewrite_atom() throws RecognitionException {
		ANTLRParser.rewrite_atom_return retval = new ANTLRParser.rewrite_atom_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token tr=null;
		Token cl=null;
		Token sl=null;
		Token ARG_ACTION178=null;
		Token RULE_REF179=null;
		Token DOLLAR182=null;
		Token ACTION184=null;
		ParserRuleReturnScope elementOptions177 =null;
		ParserRuleReturnScope elementOptions180 =null;
		ParserRuleReturnScope elementOptions181 =null;
		ParserRuleReturnScope label183 =null;

		GrammarAST tr_tree=null;
		GrammarAST cl_tree=null;
		GrammarAST sl_tree=null;
		GrammarAST ARG_ACTION178_tree=null;
		GrammarAST RULE_REF179_tree=null;
		GrammarAST DOLLAR182_tree=null;
		GrammarAST ACTION184_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:978:2: (tr= TOKEN_REF ^ ( elementOptions[$tr.tree] !)? ( ARG_ACTION )? | RULE_REF |cl= CHAR_LITERAL ( elementOptions[$cl.tree] !)? |sl= STRING_LITERAL ( elementOptions[$sl.tree] !)? | DOLLAR ! label | ACTION )
			int alt94=6;
			switch ( input.LA(1) ) {
			case TOKEN_REF:
				{
				alt94=1;
				}
				break;
			case RULE_REF:
				{
				alt94=2;
				}
				break;
			case CHAR_LITERAL:
				{
				alt94=3;
				}
				break;
			case STRING_LITERAL:
				{
				alt94=4;
				}
				break;
			case DOLLAR:
				{
				alt94=5;
				}
				break;
			case ACTION:
				{
				alt94=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 94, 0, input);
				throw nvae;
			}
			switch (alt94) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:978:4: tr= TOKEN_REF ^ ( elementOptions[$tr.tree] !)? ( ARG_ACTION )?
					{
					root_0 = (GrammarAST)adaptor.nil();


					tr=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_atom3122); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					tr_tree = (GrammarAST)adaptor.create(tr);
					root_0 = (GrammarAST)adaptor.becomeRoot(tr_tree, root_0);
					}

					// org/antlr/grammar/v3/ANTLR.g:978:42: ( elementOptions[$tr.tree] !)?
					int alt90=2;
					int LA90_0 = input.LA(1);
					if ( (LA90_0==OPEN_ELEMENT_OPTION) ) {
						alt90=1;
					}
					switch (alt90) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:978:42: elementOptions[$tr.tree] !
							{
							pushFollow(FOLLOW_elementOptions_in_rewrite_atom3125);
							elementOptions177=elementOptions(tr_tree);
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					// org/antlr/grammar/v3/ANTLR.g:978:45: ( ARG_ACTION )?
					int alt91=2;
					int LA91_0 = input.LA(1);
					if ( (LA91_0==ARG_ACTION) ) {
						alt91=1;
					}
					switch (alt91) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:978:45: ARG_ACTION
							{
							ARG_ACTION178=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_atom3130); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ARG_ACTION178_tree = (GrammarAST)adaptor.create(ARG_ACTION178);
							adaptor.addChild(root_0, ARG_ACTION178_tree);
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:979:4: RULE_REF
					{
					root_0 = (GrammarAST)adaptor.nil();


					RULE_REF179=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_atom3137); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RULE_REF179_tree = (GrammarAST)adaptor.create(RULE_REF179);
					adaptor.addChild(root_0, RULE_REF179_tree);
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:980:4: cl= CHAR_LITERAL ( elementOptions[$cl.tree] !)?
					{
					root_0 = (GrammarAST)adaptor.nil();


					cl=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_atom3144); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					cl_tree = (GrammarAST)adaptor.create(cl);
					adaptor.addChild(root_0, cl_tree);
					}

					// org/antlr/grammar/v3/ANTLR.g:980:44: ( elementOptions[$cl.tree] !)?
					int alt92=2;
					int LA92_0 = input.LA(1);
					if ( (LA92_0==OPEN_ELEMENT_OPTION) ) {
						alt92=1;
					}
					switch (alt92) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:980:44: elementOptions[$cl.tree] !
							{
							pushFollow(FOLLOW_elementOptions_in_rewrite_atom3146);
							elementOptions180=elementOptions(cl_tree);
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:981:4: sl= STRING_LITERAL ( elementOptions[$sl.tree] !)?
					{
					root_0 = (GrammarAST)adaptor.nil();


					sl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_atom3156); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					sl_tree = (GrammarAST)adaptor.create(sl);
					adaptor.addChild(root_0, sl_tree);
					}

					// org/antlr/grammar/v3/ANTLR.g:981:46: ( elementOptions[$sl.tree] !)?
					int alt93=2;
					int LA93_0 = input.LA(1);
					if ( (LA93_0==OPEN_ELEMENT_OPTION) ) {
						alt93=1;
					}
					switch (alt93) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:981:46: elementOptions[$sl.tree] !
							{
							pushFollow(FOLLOW_elementOptions_in_rewrite_atom3158);
							elementOptions181=elementOptions(sl_tree);
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLR.g:982:4: DOLLAR ! label
					{
					root_0 = (GrammarAST)adaptor.nil();


					DOLLAR182=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_rewrite_atom3166); if (state.failed) return retval;
					pushFollow(FOLLOW_label_in_rewrite_atom3169);
					label183=label();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, label183.getTree());

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLR.g:983:4: ACTION
					{
					root_0 = (GrammarAST)adaptor.nil();


					ACTION184=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_atom3175); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACTION184_tree = (GrammarAST)adaptor.create(ACTION184);
					adaptor.addChild(root_0, ACTION184_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_atom"


	public static class label_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "label"
	// org/antlr/grammar/v3/ANTLR.g:986:1: label : ( TOKEN_REF -> LABEL[$TOKEN_REF] | RULE_REF -> LABEL[$RULE_REF] );
	public final ANTLRParser.label_return label() throws RecognitionException {
		ANTLRParser.label_return retval = new ANTLRParser.label_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token TOKEN_REF185=null;
		Token RULE_REF186=null;

		GrammarAST TOKEN_REF185_tree=null;
		GrammarAST RULE_REF186_tree=null;
		RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
		RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");

		try {
			// org/antlr/grammar/v3/ANTLR.g:987:2: ( TOKEN_REF -> LABEL[$TOKEN_REF] | RULE_REF -> LABEL[$RULE_REF] )
			int alt95=2;
			int LA95_0 = input.LA(1);
			if ( (LA95_0==TOKEN_REF) ) {
				alt95=1;
			}
			else if ( (LA95_0==RULE_REF) ) {
				alt95=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 95, 0, input);
				throw nvae;
			}

			switch (alt95) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:987:4: TOKEN_REF
					{
					TOKEN_REF185=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_label3186); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF185);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 987:14: -> LABEL[$TOKEN_REF]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(LABEL, TOKEN_REF185));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:988:4: RULE_REF
					{
					RULE_REF186=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_label3196); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RULE_REF.add(RULE_REF186);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 988:13: -> LABEL[$RULE_REF]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(LABEL, RULE_REF186));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "label"


	public static class rewrite_ebnf_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_ebnf"
	// org/antlr/grammar/v3/ANTLR.g:991:1: rewrite_ebnf : b= rewrite_block ( QUESTION -> ^( OPTIONAL[$b.start,\"?\"] $b) | STAR -> ^( CLOSURE[$b.start,\"*\"] $b) | PLUS -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b) ) ;
	public final ANTLRParser.rewrite_ebnf_return rewrite_ebnf() throws RecognitionException {
		ANTLRParser.rewrite_ebnf_return retval = new ANTLRParser.rewrite_ebnf_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token QUESTION187=null;
		Token STAR188=null;
		Token PLUS189=null;
		ParserRuleReturnScope b =null;

		GrammarAST QUESTION187_tree=null;
		GrammarAST STAR188_tree=null;
		GrammarAST PLUS189_tree=null;
		RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
		RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
		RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
		RewriteRuleSubtreeStream stream_rewrite_block=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_block");

		try {
			// org/antlr/grammar/v3/ANTLR.g:992:2: (b= rewrite_block ( QUESTION -> ^( OPTIONAL[$b.start,\"?\"] $b) | STAR -> ^( CLOSURE[$b.start,\"*\"] $b) | PLUS -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b) ) )
			// org/antlr/grammar/v3/ANTLR.g:992:4: b= rewrite_block ( QUESTION -> ^( OPTIONAL[$b.start,\"?\"] $b) | STAR -> ^( CLOSURE[$b.start,\"*\"] $b) | PLUS -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b) )
			{
			pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf3214);
			b=rewrite_block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_block.add(b.getTree());
			// org/antlr/grammar/v3/ANTLR.g:993:3: ( QUESTION -> ^( OPTIONAL[$b.start,\"?\"] $b) | STAR -> ^( CLOSURE[$b.start,\"*\"] $b) | PLUS -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b) )
			int alt96=3;
			switch ( input.LA(1) ) {
			case QUESTION:
				{
				alt96=1;
				}
				break;
			case STAR:
				{
				alt96=2;
				}
				break;
			case PLUS:
				{
				alt96=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 96, 0, input);
				throw nvae;
			}
			switch (alt96) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:993:5: QUESTION
					{
					QUESTION187=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_rewrite_ebnf3220); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION187);

					// AST REWRITE
					// elements: b
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 994:4: -> ^( OPTIONAL[$b.start,\"?\"] $b)
					{
						// org/antlr/grammar/v3/ANTLR.g:994:7: ^( OPTIONAL[$b.start,\"?\"] $b)
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(OPTIONAL, (b!=null?(b.start):null), "?"), root_1);
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:995:5: STAR
					{
					STAR188=(Token)match(input,STAR,FOLLOW_STAR_in_rewrite_ebnf3239); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STAR.add(STAR188);

					// AST REWRITE
					// elements: b
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 996:4: -> ^( CLOSURE[$b.start,\"*\"] $b)
					{
						// org/antlr/grammar/v3/ANTLR.g:996:7: ^( CLOSURE[$b.start,\"*\"] $b)
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(CLOSURE, (b!=null?(b.start):null), "*"), root_1);
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:997:5: PLUS
					{
					PLUS189=(Token)match(input,PLUS,FOLLOW_PLUS_in_rewrite_ebnf3258); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PLUS.add(PLUS189);

					// AST REWRITE
					// elements: b
					// token labels: 
					// rule labels: b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 998:4: -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b)
					{
						// org/antlr/grammar/v3/ANTLR.g:998:7: ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b)
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(POSITIVE_CLOSURE, (b!=null?(b.start):null), "+"), root_1);
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_ebnf"


	public static class rewrite_tree_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_tree"
	// org/antlr/grammar/v3/ANTLR.g:1002:1: rewrite_tree : TREE_BEGIN ^ rewrite_atom ( rewrite_element )* RPAREN !;
	public final ANTLRParser.rewrite_tree_return rewrite_tree() throws RecognitionException {
		ANTLRParser.rewrite_tree_return retval = new ANTLRParser.rewrite_tree_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token TREE_BEGIN190=null;
		Token RPAREN193=null;
		ParserRuleReturnScope rewrite_atom191 =null;
		ParserRuleReturnScope rewrite_element192 =null;

		GrammarAST TREE_BEGIN190_tree=null;
		GrammarAST RPAREN193_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLR.g:1003:2: ( TREE_BEGIN ^ rewrite_atom ( rewrite_element )* RPAREN !)
			// org/antlr/grammar/v3/ANTLR.g:1003:4: TREE_BEGIN ^ rewrite_atom ( rewrite_element )* RPAREN !
			{
			root_0 = (GrammarAST)adaptor.nil();


			TREE_BEGIN190=(Token)match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree3286); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TREE_BEGIN190_tree = (GrammarAST)adaptor.create(TREE_BEGIN190);
			root_0 = (GrammarAST)adaptor.becomeRoot(TREE_BEGIN190_tree, root_0);
			}

			pushFollow(FOLLOW_rewrite_atom_in_rewrite_tree3292);
			rewrite_atom191=rewrite_atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_atom191.getTree());

			// org/antlr/grammar/v3/ANTLR.g:1004:17: ( rewrite_element )*
			loop97:
			while (true) {
				int alt97=2;
				int LA97_0 = input.LA(1);
				if ( (LA97_0==ACTION||LA97_0==CHAR_LITERAL||LA97_0==DOLLAR||LA97_0==LPAREN||LA97_0==RULE_REF||LA97_0==STRING_LITERAL||LA97_0==TOKEN_REF||LA97_0==TREE_BEGIN) ) {
					alt97=1;
				}

				switch (alt97) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1004:17: rewrite_element
					{
					pushFollow(FOLLOW_rewrite_element_in_rewrite_tree3294);
					rewrite_element192=rewrite_element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_element192.getTree());

					}
					break;

				default :
					break loop97;
				}
			}

			RPAREN193=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_tree3299); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_tree"


	public static class rewrite_template_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_template"
	// org/antlr/grammar/v3/ANTLR.g:1020:1: public rewrite_template options {k=1; } : ({...}? => ( rewrite_template_head -> rewrite_template_head ) (st= DOUBLE_QUOTE_STRING_LITERAL |st= DOUBLE_ANGLE_STRING_LITERAL ) | rewrite_template_head | rewrite_indirect_template_head | ACTION );
	public final ANTLRParser.rewrite_template_return rewrite_template() throws RecognitionException {
		ANTLRParser.rewrite_template_return retval = new ANTLRParser.rewrite_template_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token st=null;
		Token ACTION197=null;
		ParserRuleReturnScope rewrite_template_head194 =null;
		ParserRuleReturnScope rewrite_template_head195 =null;
		ParserRuleReturnScope rewrite_indirect_template_head196 =null;

		GrammarAST st_tree=null;
		GrammarAST ACTION197_tree=null;
		RewriteRuleTokenStream stream_DOUBLE_QUOTE_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token DOUBLE_QUOTE_STRING_LITERAL");
		RewriteRuleTokenStream stream_DOUBLE_ANGLE_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token DOUBLE_ANGLE_STRING_LITERAL");
		RewriteRuleSubtreeStream stream_rewrite_template_head=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_head");

		try {
			// org/antlr/grammar/v3/ANTLR.g:1022:2: ({...}? => ( rewrite_template_head -> rewrite_template_head ) (st= DOUBLE_QUOTE_STRING_LITERAL |st= DOUBLE_ANGLE_STRING_LITERAL ) | rewrite_template_head | rewrite_indirect_template_head | ACTION )
			int alt99=4;
			switch ( input.LA(1) ) {
			case TOKEN_REF:
				{
				int LA99_1 = input.LA(2);
				if ( ((LT(1).getText().equals("template"))) ) {
					alt99=1;
				}
				else if ( (true) ) {
					alt99=2;
				}

				}
				break;
			case RULE_REF:
				{
				int LA99_2 = input.LA(2);
				if ( ((LT(1).getText().equals("template"))) ) {
					alt99=1;
				}
				else if ( (true) ) {
					alt99=2;
				}

				}
				break;
			case LPAREN:
				{
				alt99=3;
				}
				break;
			case ACTION:
				{
				alt99=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 99, 0, input);
				throw nvae;
			}
			switch (alt99) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1023:3: {...}? => ( rewrite_template_head -> rewrite_template_head ) (st= DOUBLE_QUOTE_STRING_LITERAL |st= DOUBLE_ANGLE_STRING_LITERAL )
					{
					if ( !((LT(1).getText().equals("template"))) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "rewrite_template", "LT(1).getText().equals(\"template\")");
					}
					// org/antlr/grammar/v3/ANTLR.g:1024:3: ( rewrite_template_head -> rewrite_template_head )
					// org/antlr/grammar/v3/ANTLR.g:1024:5: rewrite_template_head
					{
					pushFollow(FOLLOW_rewrite_template_head_in_rewrite_template3334);
					rewrite_template_head194=rewrite_template_head();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_template_head.add(rewrite_template_head194.getTree());
					// AST REWRITE
					// elements: rewrite_template_head
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 1025:4: -> rewrite_template_head
					{
						adaptor.addChild(root_0, stream_rewrite_template_head.nextTree());
					}


					retval.tree = root_0;
					}

					}

					// org/antlr/grammar/v3/ANTLR.g:1027:3: (st= DOUBLE_QUOTE_STRING_LITERAL |st= DOUBLE_ANGLE_STRING_LITERAL )
					int alt98=2;
					int LA98_0 = input.LA(1);
					if ( (LA98_0==DOUBLE_QUOTE_STRING_LITERAL) ) {
						alt98=1;
					}
					else if ( (LA98_0==DOUBLE_ANGLE_STRING_LITERAL) ) {
						alt98=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 98, 0, input);
						throw nvae;
					}

					switch (alt98) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:1027:5: st= DOUBLE_QUOTE_STRING_LITERAL
							{
							st=(Token)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template3353); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DOUBLE_QUOTE_STRING_LITERAL.add(st);

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLR.g:1027:38: st= DOUBLE_ANGLE_STRING_LITERAL
							{
							st=(Token)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template3359); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DOUBLE_ANGLE_STRING_LITERAL.add(st);

							}
							break;

					}

					if ( state.backtracking==0 ) { adaptor.addChild( retval.tree.getChild(0), adaptor.create(st) ); }
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1031:3: rewrite_template_head
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_rewrite_template_head_in_rewrite_template3374);
					rewrite_template_head195=rewrite_template_head();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_template_head195.getTree());

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLR.g:1034:3: rewrite_indirect_template_head
					{
					root_0 = (GrammarAST)adaptor.nil();


					pushFollow(FOLLOW_rewrite_indirect_template_head_in_rewrite_template3383);
					rewrite_indirect_template_head196=rewrite_indirect_template_head();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_indirect_template_head196.getTree());

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLR.g:1037:3: ACTION
					{
					root_0 = (GrammarAST)adaptor.nil();


					ACTION197=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template3392); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACTION197_tree = (GrammarAST)adaptor.create(ACTION197);
					adaptor.addChild(root_0, ACTION197_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_template"


	public static class rewrite_template_head_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_template_head"
	// org/antlr/grammar/v3/ANTLR.g:1041:1: rewrite_template_head : id lp= LPAREN rewrite_template_args RPAREN -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args ) ;
	public final ANTLRParser.rewrite_template_head_return rewrite_template_head() throws RecognitionException {
		ANTLRParser.rewrite_template_head_return retval = new ANTLRParser.rewrite_template_head_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token lp=null;
		Token RPAREN200=null;
		ParserRuleReturnScope id198 =null;
		ParserRuleReturnScope rewrite_template_args199 =null;

		GrammarAST lp_tree=null;
		GrammarAST RPAREN200_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
		RewriteRuleSubtreeStream stream_rewrite_template_args=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_args");

		try {
			// org/antlr/grammar/v3/ANTLR.g:1042:2: ( id lp= LPAREN rewrite_template_args RPAREN -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args ) )
			// org/antlr/grammar/v3/ANTLR.g:1042:4: id lp= LPAREN rewrite_template_args RPAREN
			{
			pushFollow(FOLLOW_id_in_rewrite_template_head3405);
			id198=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id198.getTree());
			lp=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_rewrite_template_head3409); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(lp);

			pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template_head3413);
			rewrite_template_args199=rewrite_template_args();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_template_args.add(rewrite_template_args199.getTree());
			RPAREN200=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_template_head3417); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN200);

			// AST REWRITE
			// elements: id, rewrite_template_args
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 1045:3: -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args )
			{
				// org/antlr/grammar/v3/ANTLR.g:1045:6: ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(TEMPLATE, lp, "TEMPLATE"), root_1);
				adaptor.addChild(root_1, stream_id.nextTree());
				adaptor.addChild(root_1, stream_rewrite_template_args.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_template_head"


	public static class rewrite_indirect_template_head_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_indirect_template_head"
	// org/antlr/grammar/v3/ANTLR.g:1049:1: rewrite_indirect_template_head : lp= LPAREN ACTION RPAREN LPAREN rewrite_template_args RPAREN -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args ) ;
	public final ANTLRParser.rewrite_indirect_template_head_return rewrite_indirect_template_head() throws RecognitionException {
		ANTLRParser.rewrite_indirect_template_head_return retval = new ANTLRParser.rewrite_indirect_template_head_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token lp=null;
		Token ACTION201=null;
		Token RPAREN202=null;
		Token LPAREN203=null;
		Token RPAREN205=null;
		ParserRuleReturnScope rewrite_template_args204 =null;

		GrammarAST lp_tree=null;
		GrammarAST ACTION201_tree=null;
		GrammarAST RPAREN202_tree=null;
		GrammarAST LPAREN203_tree=null;
		GrammarAST RPAREN205_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_rewrite_template_args=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_args");

		try {
			// org/antlr/grammar/v3/ANTLR.g:1050:2: (lp= LPAREN ACTION RPAREN LPAREN rewrite_template_args RPAREN -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args ) )
			// org/antlr/grammar/v3/ANTLR.g:1050:4: lp= LPAREN ACTION RPAREN LPAREN rewrite_template_args RPAREN
			{
			lp=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_rewrite_indirect_template_head3445); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(lp);

			ACTION201=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_indirect_template_head3449); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION201);

			RPAREN202=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_indirect_template_head3453); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN202);

			LPAREN203=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_rewrite_indirect_template_head3457); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN203);

			pushFollow(FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head3459);
			rewrite_template_args204=rewrite_template_args();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_template_args.add(rewrite_template_args204.getTree());
			RPAREN205=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_indirect_template_head3461); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN205);

			// AST REWRITE
			// elements: ACTION, rewrite_template_args
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 1054:3: -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args )
			{
				// org/antlr/grammar/v3/ANTLR.g:1054:6: ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(TEMPLATE, lp, "TEMPLATE"), root_1);
				adaptor.addChild(root_1, stream_ACTION.nextNode());
				adaptor.addChild(root_1, stream_rewrite_template_args.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_indirect_template_head"


	public static class rewrite_template_args_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_template_args"
	// org/antlr/grammar/v3/ANTLR.g:1057:1: rewrite_template_args : ( rewrite_template_arg ( COMMA rewrite_template_arg )* -> ^( ARGLIST[\"ARGLIST\"] ( rewrite_template_arg )+ ) | -> ARGLIST[\"ARGLIST\"] );
	public final ANTLRParser.rewrite_template_args_return rewrite_template_args() throws RecognitionException {
		ANTLRParser.rewrite_template_args_return retval = new ANTLRParser.rewrite_template_args_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token COMMA207=null;
		ParserRuleReturnScope rewrite_template_arg206 =null;
		ParserRuleReturnScope rewrite_template_arg208 =null;

		GrammarAST COMMA207_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_rewrite_template_arg=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_arg");

		try {
			// org/antlr/grammar/v3/ANTLR.g:1058:2: ( rewrite_template_arg ( COMMA rewrite_template_arg )* -> ^( ARGLIST[\"ARGLIST\"] ( rewrite_template_arg )+ ) | -> ARGLIST[\"ARGLIST\"] )
			int alt101=2;
			int LA101_0 = input.LA(1);
			if ( (LA101_0==RULE_REF||LA101_0==TOKEN_REF) ) {
				alt101=1;
			}
			else if ( (LA101_0==RPAREN) ) {
				alt101=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 101, 0, input);
				throw nvae;
			}

			switch (alt101) {
				case 1 :
					// org/antlr/grammar/v3/ANTLR.g:1058:4: rewrite_template_arg ( COMMA rewrite_template_arg )*
					{
					pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args3485);
					rewrite_template_arg206=rewrite_template_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_template_arg.add(rewrite_template_arg206.getTree());
					// org/antlr/grammar/v3/ANTLR.g:1058:25: ( COMMA rewrite_template_arg )*
					loop100:
					while (true) {
						int alt100=2;
						int LA100_0 = input.LA(1);
						if ( (LA100_0==COMMA) ) {
							alt100=1;
						}

						switch (alt100) {
						case 1 :
							// org/antlr/grammar/v3/ANTLR.g:1058:26: COMMA rewrite_template_arg
							{
							COMMA207=(Token)match(input,COMMA,FOLLOW_COMMA_in_rewrite_template_args3488); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA207);

							pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args3490);
							rewrite_template_arg208=rewrite_template_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rewrite_template_arg.add(rewrite_template_arg208.getTree());
							}
							break;

						default :
							break loop100;
						}
					}

					// AST REWRITE
					// elements: rewrite_template_arg
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 1059:3: -> ^( ARGLIST[\"ARGLIST\"] ( rewrite_template_arg )+ )
					{
						// org/antlr/grammar/v3/ANTLR.g:1059:6: ^( ARGLIST[\"ARGLIST\"] ( rewrite_template_arg )+ )
						{
						GrammarAST root_1 = (GrammarAST)adaptor.nil();
						root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ARGLIST, "ARGLIST"), root_1);
						if ( !(stream_rewrite_template_arg.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_rewrite_template_arg.hasNext() ) {
							adaptor.addChild(root_1, stream_rewrite_template_arg.nextTree());
						}
						stream_rewrite_template_arg.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLR.g:1061:3: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (GrammarAST)adaptor.nil();
					// 1061:3: -> ARGLIST[\"ARGLIST\"]
					{
						adaptor.addChild(root_0, (GrammarAST)adaptor.create(ARGLIST, "ARGLIST"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_template_args"


	public static class rewrite_template_arg_return extends ParserRuleReturnScope {
		GrammarAST tree;
		@Override
		public GrammarAST getTree() { return tree; }
	};


	// $ANTLR start "rewrite_template_arg"
	// org/antlr/grammar/v3/ANTLR.g:1064:1: rewrite_template_arg : id a= ASSIGN ACTION -> ^( ARG[$a,\"ARG\"] id ACTION ) ;
	public final ANTLRParser.rewrite_template_arg_return rewrite_template_arg() throws RecognitionException {
		ANTLRParser.rewrite_template_arg_return retval = new ANTLRParser.rewrite_template_arg_return();
		retval.start = input.LT(1);

		GrammarAST root_0 = null;

		Token a=null;
		Token ACTION210=null;
		ParserRuleReturnScope id209 =null;

		GrammarAST a_tree=null;
		GrammarAST ACTION210_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLR.g:1065:2: ( id a= ASSIGN ACTION -> ^( ARG[$a,\"ARG\"] id ACTION ) )
			// org/antlr/grammar/v3/ANTLR.g:1065:4: id a= ASSIGN ACTION
			{
			pushFollow(FOLLOW_id_in_rewrite_template_arg3525);
			id209=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id209.getTree());
			a=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_rewrite_template_arg3529); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(a);

			ACTION210=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template_arg3531); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION210);

			// AST REWRITE
			// elements: ACTION, id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (GrammarAST)adaptor.nil();
			// 1066:3: -> ^( ARG[$a,\"ARG\"] id ACTION )
			{
				// org/antlr/grammar/v3/ANTLR.g:1066:6: ^( ARG[$a,\"ARG\"] id ACTION )
				{
				GrammarAST root_1 = (GrammarAST)adaptor.nil();
				root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ARG, a, "ARG"), root_1);
				adaptor.addChild(root_1, stream_id.nextTree());
				adaptor.addChild(root_1, stream_ACTION.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_template_arg"

	// $ANTLR start synpred1_ANTLR
	public final void synpred1_ANTLR_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ANTLR.g:761:4: ({...}? id WILDCARD ( terminal | ruleref ) )
		// org/antlr/grammar/v3/ANTLR.g:761:5: {...}? id WILDCARD ( terminal | ruleref )
		{
		if ( !((LT(1).getCharPositionInLine()+LT(1).getText().length()==LT(2).getCharPositionInLine()&&
					 LT(2).getCharPositionInLine()+1==LT(3).getCharPositionInLine())) ) {
			if (state.backtracking>0) {state.failed=true; return;}
			throw new FailedPredicateException(input, "synpred1_ANTLR", "LT(1).getCharPositionInLine()+LT(1).getText().length()==LT(2).getCharPositionInLine()&&\n\t\t\t LT(2).getCharPositionInLine()+1==LT(3).getCharPositionInLine()");
		}
		pushFollow(FOLLOW_id_in_synpred1_ANTLR1929);
		id();
		state._fsp--;
		if (state.failed) return;

		match(input,WILDCARD,FOLLOW_WILDCARD_in_synpred1_ANTLR1931); if (state.failed) return;

		// org/antlr/grammar/v3/ANTLR.g:762:82: ( terminal | ruleref )
		int alt102=2;
		int LA102_0 = input.LA(1);
		if ( (LA102_0==CHAR_LITERAL||LA102_0==STRING_LITERAL||LA102_0==TOKEN_REF||LA102_0==WILDCARD) ) {
			alt102=1;
		}
		else if ( (LA102_0==RULE_REF) ) {
			alt102=2;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 102, 0, input);
			throw nvae;
		}

		switch (alt102) {
			case 1 :
				// org/antlr/grammar/v3/ANTLR.g:762:83: terminal
				{
				pushFollow(FOLLOW_terminal_in_synpred1_ANTLR1934);
				terminal();
				state._fsp--;
				if (state.failed) return;

				}
				break;
			case 2 :
				// org/antlr/grammar/v3/ANTLR.g:762:92: ruleref
				{
				pushFollow(FOLLOW_ruleref_in_synpred1_ANTLR1936);
				ruleref();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		}

	}
	// $ANTLR end synpred1_ANTLR

	// Delegated rules

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



	public static final BitSet FOLLOW_ACTION_in_grammar_324 = new BitSet(new long[]{0x1002040008000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_DOC_COMMENT_in_grammar_335 = new BitSet(new long[]{0x1002040000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_grammarType_in_grammar_345 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_grammar_349 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_grammar_353 = new BitSet(new long[]{0x0400210008000200L,0x000000006003001CL});
	public static final BitSet FOLLOW_optionsSpec_in_grammar_359 = new BitSet(new long[]{0x0000210008000200L,0x000000006003001CL});
	public static final BitSet FOLLOW_delegateGrammars_in_grammar_373 = new BitSet(new long[]{0x0000010008000200L,0x000000006003001CL});
	public static final BitSet FOLLOW_tokensSpec_in_grammar_382 = new BitSet(new long[]{0x0000010008000200L,0x000000004003001CL});
	public static final BitSet FOLLOW_attrScopes_in_grammar_390 = new BitSet(new long[]{0x0000010008000200L,0x000000004001001CL});
	public static final BitSet FOLLOW_actions_in_grammar_397 = new BitSet(new long[]{0x0000010008000000L,0x000000004001001CL});
	public static final BitSet FOLLOW_rules_in_grammar_405 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_grammar_409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEXER_in_grammarType460 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_GRAMMAR_in_grammarType465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARSER_in_grammarType488 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_GRAMMAR_in_grammarType492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TREE_in_grammarType513 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_GRAMMAR_in_grammarType519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GRAMMAR_in_grammarType542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actions569 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AMPERSAND_in_action584 = new BitSet(new long[]{0x1002000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_actionScopeName_in_action588 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COLON_in_action590 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COLON_in_action593 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_action598 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_action600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_actionScopeName613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEXER_in_actionScopeName620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARSER_in_actionScopeName634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONS_in_optionsSpec656 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_option_in_optionsSpec660 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_optionsSpec663 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010080L});
	public static final BitSet FOLLOW_RCURLY_in_optionsSpec668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_option681 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ASSIGN_in_option683 = new BitSet(new long[]{0x0000800000040000L,0x0000000041410000L});
	public static final BitSet FOLLOW_optionValue_in_option686 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_optionValue707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_optionValue719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_optionValue728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_optionValue739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_optionValue759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_delegateGrammars784 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars787 = new BitSet(new long[]{0x0000000001000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_delegateGrammars790 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars793 = new BitSet(new long[]{0x0000000001000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_delegateGrammars797 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_delegateGrammar811 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ASSIGN_in_delegateGrammar813 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_delegateGrammar818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_delegateGrammar827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKENS_in_tokensSpec854 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000080L});
	public static final BitSet FOLLOW_tokenSpec_in_tokensSpec860 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000080L});
	public static final BitSet FOLLOW_RCURLY_in_tokensSpec865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec877 = new BitSet(new long[]{0x0000000000002000L,0x0000000000040000L});
	public static final BitSet FOLLOW_ASSIGN_in_tokenSpec881 = new BitSet(new long[]{0x0000000000040000L,0x0000000001000000L});
	public static final BitSet FOLLOW_set_in_tokenSpec884 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_tokenSpec893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attrScope_in_attrScopes906 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
	public static final BitSet FOLLOW_SCOPE_in_attrScope919 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_attrScope922 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_ruleActions_in_attrScope924 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_attrScope927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_rules940 = new BitSet(new long[]{0x0000010008000002L,0x000000004001001CL});
	public static final BitSet FOLLOW_DOC_COMMENT_in_rule970 = new BitSet(new long[]{0x0000010000000000L,0x000000004001001CL});
	public static final BitSet FOLLOW_PROTECTED_in_rule983 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_PUBLIC_in_rule992 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_PRIVATE_in_rule1002 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_FRAGMENT_in_rule1011 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_rule1023 = new BitSet(new long[]{0x0400000000409200L,0x0000000010020400L});
	public static final BitSet FOLLOW_BANG_in_rule1033 = new BitSet(new long[]{0x0400000000401200L,0x0000000010020400L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule1044 = new BitSet(new long[]{0x0400000000400200L,0x0000000010020400L});
	public static final BitSet FOLLOW_RETURNS_in_rule1053 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule1057 = new BitSet(new long[]{0x0400000000400200L,0x0000000010020000L});
	public static final BitSet FOLLOW_throwsSpec_in_rule1067 = new BitSet(new long[]{0x0400000000400200L,0x0000000000020000L});
	public static final BitSet FOLLOW_optionsSpec_in_rule1076 = new BitSet(new long[]{0x0000000000400200L,0x0000000000020000L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_rule1085 = new BitSet(new long[]{0x0000000000400200L});
	public static final BitSet FOLLOW_ruleActions_in_rule1090 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COLON_in_rule1096 = new BitSet(new long[]{0x0888008000040010L,0x0000000541090800L});
	public static final BitSet FOLLOW_ruleAltList_in_rule1100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_rule1105 = new BitSet(new long[]{0x0000004000020002L});
	public static final BitSet FOLLOW_exceptionGroup_in_rule1113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleAction_in_ruleActions1251 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AMPERSAND_in_ruleAction1266 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_ruleAction1269 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_ruleAction1271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_THROWS_in_throwsSpec1282 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_throwsSpec1285 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_throwsSpec1289 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_throwsSpec1292 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec1308 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_ruleActions_in_ruleScopeSpec1310 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec1313 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec1322 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_idList_in_ruleScopeSpec1324 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_ruleScopeSpec1326 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
	public static final BitSet FOLLOW_alternative_in_ruleAltList1383 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_rewrite_in_ruleAltList1387 = new BitSet(new long[]{0x0800000000000002L});
	public static final BitSet FOLLOW_OR_in_ruleAltList1416 = new BitSet(new long[]{0x0888008000040010L,0x0000000541090800L});
	public static final BitSet FOLLOW_alternative_in_ruleAltList1420 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_rewrite_in_ruleAltList1424 = new BitSet(new long[]{0x0800000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_block1500 = new BitSet(new long[]{0x0C88008000440210L,0x0000000541094800L});
	public static final BitSet FOLLOW_optionsSpec_in_block1538 = new BitSet(new long[]{0x0000000000400200L});
	public static final BitSet FOLLOW_ruleActions_in_block1549 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COLON_in_block1557 = new BitSet(new long[]{0x0888008000040010L,0x0000000541094800L});
	public static final BitSet FOLLOW_ACTION_in_block1563 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COLON_in_block1565 = new BitSet(new long[]{0x0888008000040010L,0x0000000541094800L});
	public static final BitSet FOLLOW_alternative_in_block1577 = new BitSet(new long[]{0x0800000000000000L,0x0000000000004800L});
	public static final BitSet FOLLOW_rewrite_in_block1581 = new BitSet(new long[]{0x0800000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_OR_in_block1591 = new BitSet(new long[]{0x0888008000040010L,0x0000000541094800L});
	public static final BitSet FOLLOW_alternative_in_block1595 = new BitSet(new long[]{0x0800000000000000L,0x0000000000004800L});
	public static final BitSet FOLLOW_rewrite_in_block1599 = new BitSet(new long[]{0x0800000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_RPAREN_in_block1616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_in_alternative1656 = new BitSet(new long[]{0x0088008000040012L,0x0000000541090000L});
	public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1702 = new BitSet(new long[]{0x0000004000020002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1705 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CATCH_in_exceptionHandler1722 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1725 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_exceptionHandler1727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FINALLY_in_finallyClause1738 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_finallyClause1741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_elementNoOptionSpec_in_element1752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_elementNoOptionSpec1770 = new BitSet(new long[]{0x8000000000002000L});
	public static final BitSet FOLLOW_ASSIGN_in_elementNoOptionSpec1773 = new BitSet(new long[]{0x0088000000040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_PLUS_ASSIGN_in_elementNoOptionSpec1776 = new BitSet(new long[]{0x0088000000040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_elementNoOptionSpec1785 = new BitSet(new long[]{0x4000000000000002L,0x0000000000400020L});
	public static final BitSet FOLLOW_ebnfSuffix_in_elementNoOptionSpec1790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ebnf_in_elementNoOptionSpec1803 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_elementNoOptionSpec1816 = new BitSet(new long[]{0x4000000000000002L,0x0000000000400020L});
	public static final BitSet FOLLOW_ebnfSuffix_in_elementNoOptionSpec1825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ebnf_in_elementNoOptionSpec1841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FORCED_ACTION_in_elementNoOptionSpec1847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_elementNoOptionSpec1853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMPRED_in_elementNoOptionSpec1861 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_IMPLIES_in_elementNoOptionSpec1865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tree__in_elementNoOptionSpec1884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_range_in_atom1899 = new BitSet(new long[]{0x0000000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ROOT_in_atom1902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_atom1905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_atom1945 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_WILDCARD_in_atom1949 = new BitSet(new long[]{0x0000000000040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_terminal_in_atom1953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleref_in_atom1955 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_terminal_in_atom1964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleref_in_atom1970 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notSet_in_atom1979 = new BitSet(new long[]{0x0000000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ROOT_in_atom1982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_atom1985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_ruleref1999 = new BitSet(new long[]{0x0000000000009002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ARG_ACTION_in_ruleref2002 = new BitSet(new long[]{0x0000000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ROOT_in_ruleref2006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_ruleref2009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notSet2023 = new BitSet(new long[]{0x0008000000040000L,0x0000000041000000L});
	public static final BitSet FOLLOW_notTerminal_in_notSet2030 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_notSet2036 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_treeRoot2059 = new BitSet(new long[]{0x8000000000002000L});
	public static final BitSet FOLLOW_ASSIGN_in_treeRoot2062 = new BitSet(new long[]{0x0088000000040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_PLUS_ASSIGN_in_treeRoot2065 = new BitSet(new long[]{0x0088000000040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_treeRoot2070 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_treeRoot2072 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_treeRoot2078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_treeRoot2083 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_tree_2094 = new BitSet(new long[]{0x0088000000040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_treeRoot_in_tree_2099 = new BitSet(new long[]{0x0088008000040010L,0x0000000541090000L});
	public static final BitSet FOLLOW_element_in_tree_2101 = new BitSet(new long[]{0x0088008000040010L,0x0000000541094000L});
	public static final BitSet FOLLOW_RPAREN_in_tree_2106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_ebnf2120 = new BitSet(new long[]{0x4000100000008002L,0x0000000000402020L});
	public static final BitSet FOLLOW_QUESTION_in_ebnf2126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_ebnf2144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_ebnf2162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPLIES_in_ebnf2180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROOT_in_ebnf2216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_ebnf2233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_range2280 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_RANGE_in_range2282 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_range2286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_range2313 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_RANGE_in_range2317 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_TOKEN_REF_in_range2319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_range2327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_RANGE_in_range2331 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_range2333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_range2341 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_RANGE_in_range2345 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_range2347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_terminal2376 = new BitSet(new long[]{0x0100000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_terminal2381 = new BitSet(new long[]{0x0000000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ROOT_in_terminal2389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_terminal2392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_terminal2403 = new BitSet(new long[]{0x0100000000009002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_terminal2410 = new BitSet(new long[]{0x0000000000009002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ARG_ACTION_in_terminal2421 = new BitSet(new long[]{0x0000000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ROOT_in_terminal2430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_terminal2433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_terminal2444 = new BitSet(new long[]{0x0100000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_terminal2449 = new BitSet(new long[]{0x0000000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ROOT_in_terminal2457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_terminal2460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WILDCARD_in_terminal2471 = new BitSet(new long[]{0x0000000000008002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ROOT_in_terminal2474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_terminal2477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_ELEMENT_OPTION_in_elementOptions2496 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_defaultNodeOption_in_elementOptions2499 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_CLOSE_ELEMENT_OPTION_in_elementOptions2502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_ELEMENT_OPTION_in_elementOptions2508 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_elementOption_in_elementOptions2511 = new BitSet(new long[]{0x0000000000100000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_elementOptions2515 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_elementOption_in_elementOptions2518 = new BitSet(new long[]{0x0000000000100000L,0x0000000000040000L});
	public static final BitSet FOLLOW_CLOSE_ELEMENT_OPTION_in_elementOptions2523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_elementOptionId_in_defaultNodeOption2536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_elementOption2552 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ASSIGN_in_elementOption2554 = new BitSet(new long[]{0x00000000C0000000L,0x0000000041010000L});
	public static final BitSet FOLLOW_elementOptionId_in_elementOption2561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption2575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_elementOption2579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_elementOption2583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_elementOptionId2614 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
	public static final BitSet FOLLOW_WILDCARD_in_elementOptionId2619 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_elementOptionId2623 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
	public static final BitSet FOLLOW_QUESTION_in_ebnfSuffix2700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_ebnfSuffix2714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_ebnfSuffix2728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_idList2790 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_idList2793 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_id_in_idList2796 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_id2809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_id2821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_with_sempred_in_rewrite2841 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite2846 = new BitSet(new long[]{0x0008002010040010L,0x0000000141010000L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite2848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite_with_sempred2879 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_SEMPRED_in_rewrite_with_sempred2882 = new BitSet(new long[]{0x0008002010040010L,0x0000000141010000L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite_with_sempred2884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_rewrite_block2895 = new BitSet(new long[]{0x0008002010040010L,0x0000000141014000L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite_block2899 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_RPAREN_in_rewrite_block2903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative2939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_element_in_rewrite_alternative2951 = new BitSet(new long[]{0x0008000010040012L,0x0000000141010000L});
	public static final BitSet FOLLOW_ETC_in_rewrite_alternative3012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_atom_in_rewrite_element3027 = new BitSet(new long[]{0x4000000000000002L,0x0000000000400020L});
	public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_element3047 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_ebnf_in_rewrite_element3066 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_in_rewrite_element3075 = new BitSet(new long[]{0x4000000000000002L,0x0000000000400020L});
	public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_element3095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_atom3122 = new BitSet(new long[]{0x0100000000001002L});
	public static final BitSet FOLLOW_elementOptions_in_rewrite_atom3125 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_atom3130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_rewrite_atom3137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_atom3144 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_elementOptions_in_rewrite_atom3146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_atom3156 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_elementOptions_in_rewrite_atom3158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOLLAR_in_rewrite_atom3166 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_label_in_rewrite_atom3169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_atom3175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_label3186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_label3196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf3214 = new BitSet(new long[]{0x4000000000000000L,0x0000000000400020L});
	public static final BitSet FOLLOW_QUESTION_in_rewrite_ebnf3220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_rewrite_ebnf3239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_rewrite_ebnf3258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree3286 = new BitSet(new long[]{0x0000000010040010L,0x0000000041010000L});
	public static final BitSet FOLLOW_rewrite_atom_in_rewrite_tree3292 = new BitSet(new long[]{0x0008000010040010L,0x0000000141014000L});
	public static final BitSet FOLLOW_rewrite_element_in_rewrite_tree3294 = new BitSet(new long[]{0x0008000010040010L,0x0000000141014000L});
	public static final BitSet FOLLOW_RPAREN_in_rewrite_tree3299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_template_head_in_rewrite_template3334 = new BitSet(new long[]{0x00000000C0000000L});
	public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template3353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template3359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_template_head_in_rewrite_template3374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_indirect_template_head_in_rewrite_template3383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template3392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_rewrite_template_head3405 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_LPAREN_in_rewrite_template_head3409 = new BitSet(new long[]{0x0000000000000000L,0x0000000040014000L});
	public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template_head3413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_RPAREN_in_rewrite_template_head3417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_rewrite_indirect_template_head3445 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_indirect_template_head3449 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_RPAREN_in_rewrite_indirect_template_head3453 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_LPAREN_in_rewrite_indirect_template_head3457 = new BitSet(new long[]{0x0000000000000000L,0x0000000040014000L});
	public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head3459 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_RPAREN_in_rewrite_indirect_template_head3461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args3485 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_rewrite_template_args3488 = new BitSet(new long[]{0x0000000000000000L,0x0000000040010000L});
	public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args3490 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_id_in_rewrite_template_arg3525 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ASSIGN_in_rewrite_template_arg3529 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template_arg3531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_synpred1_ANTLR1929 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_WILDCARD_in_synpred1_ANTLR1931 = new BitSet(new long[]{0x0000000000040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_terminal_in_synpred1_ANTLR1934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleref_in_synpred1_ANTLR1936 = new BitSet(new long[]{0x0000000000000002L});
}
