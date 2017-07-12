// $ANTLR 3.5 org/antlr/grammar/v3/ANTLRTreePrinter.g 2017-06-11 18:42:19

package org.antlr.grammar.v3;
import org.antlr.tool.*;
import java.util.StringTokenizer;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/** Print out a grammar (no pretty printing).
 *
 *  Terence Parr
 *  University of San Francisco
 *  August 19, 2003
 */
@SuppressWarnings("all")
public class ANTLRTreePrinter extends TreeParser {
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


	public ANTLRTreePrinter(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public ANTLRTreePrinter(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ANTLRTreePrinter.tokenNames; }
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/ANTLRTreePrinter.g"; }


	protected Grammar grammar;
	protected boolean showActions;
	protected StringBuilder buf = new StringBuilder(300);

	private ANTLRTreePrinter.block_return block(GrammarAST t, boolean forceParens) throws RecognitionException {
	    ANTLRTreePrinter other = new ANTLRTreePrinter(new CommonTreeNodeStream(t));
	    other.buf = buf;
	    return other.block(forceParens);
	}

	public final int countAltsForBlock(GrammarAST t) {
	    int n = 0;
	    for ( int i = 0; i < t.getChildCount(); i++ )
	    {
	        if ( t.getChild(i).getType() == ALT )
	            n++;
	    }

	    return n;
	}

	public void out(String s) {
	    buf.append(s);
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
	        "antlr.print: " + ex.toString(),
	        ex );
	}

	/** Normalize a grammar print out by removing all double spaces
	 *  and trailing/beginning stuff.  FOr example, convert
	 *
	 *  ( A  |  B  |  C )*
	 *
	 *  to
	 *
	 *  ( A | B | C )*
	 */
	public static String normalize(String g) {
	    StringTokenizer st = new StringTokenizer(g, " ", false);
	    StringBuffer buf = new StringBuffer();
	    while ( st.hasMoreTokens() ) {
	        String w = st.nextToken();
	        buf.append(w);
	        buf.append(" ");
	    }
	    return buf.toString().trim();
	}



	// $ANTLR start "toString"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:120:1: public toString[Grammar g, boolean showActions] returns [String s=null] : ( grammar_ | rule | alternative | element | single_rewrite | rewrite | EOR ) ;
	public final String toString(Grammar g, boolean showActions) throws RecognitionException {
		String s = null;



			grammar = g;
			this.showActions = showActions;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:125:2: ( ( grammar_ | rule | alternative | element | single_rewrite | rewrite | EOR ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:125:4: ( grammar_ | rule | alternative | element | single_rewrite | rewrite | EOR )
			{
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:125:4: ( grammar_ | rule | alternative | element | single_rewrite | rewrite | EOR )
			int alt1=7;
			switch ( input.LA(1) ) {
			case COMBINED_GRAMMAR:
			case LEXER_GRAMMAR:
			case PARSER_GRAMMAR:
			case TREE_GRAMMAR:
				{
				alt1=1;
				}
				break;
			case RULE:
				{
				alt1=2;
				}
				break;
			case ALT:
				{
				alt1=3;
				}
				break;
			case ACTION:
			case ASSIGN:
			case BACKTRACK_SEMPRED:
			case BANG:
			case BLOCK:
			case CHAR_LITERAL:
			case CHAR_RANGE:
			case CLOSURE:
			case DOT:
			case EPSILON:
			case FORCED_ACTION:
			case GATED_SEMPRED:
			case LABEL:
			case NOT:
			case OPTIONAL:
			case PLUS_ASSIGN:
			case POSITIVE_CLOSURE:
			case RANGE:
			case ROOT:
			case RULE_REF:
			case SEMPRED:
			case STRING_LITERAL:
			case SYNPRED:
			case SYN_SEMPRED:
			case TOKEN_REF:
			case TREE_BEGIN:
			case WILDCARD:
				{
				alt1=4;
				}
				break;
			case REWRITE:
				{
				alt1=5;
				}
				break;
			case EOF:
			case REWRITES:
				{
				alt1=6;
				}
				break;
			case EOR:
				{
				alt1=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:125:6: grammar_
					{
					pushFollow(FOLLOW_grammar__in_toString73);
					grammar_();
					state._fsp--;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:126:5: rule
					{
					pushFollow(FOLLOW_rule_in_toString79);
					rule();
					state._fsp--;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:127:5: alternative
					{
					pushFollow(FOLLOW_alternative_in_toString85);
					alternative();
					state._fsp--;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:128:5: element
					{
					pushFollow(FOLLOW_element_in_toString91);
					element();
					state._fsp--;

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:129:5: single_rewrite
					{
					pushFollow(FOLLOW_single_rewrite_in_toString97);
					single_rewrite();
					state._fsp--;

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:130:5: rewrite
					{
					pushFollow(FOLLOW_rewrite_in_toString103);
					rewrite();
					state._fsp--;

					}
					break;
				case 7 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:131:5: EOR
					{
					match(input,EOR,FOLLOW_EOR_in_toString109); 
					}
					break;

			}

			return normalize(buf.toString());
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "toString"



	// $ANTLR start "grammar_"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:138:1: grammar_ : ( ^( LEXER_GRAMMAR grammarSpec[\"lexer \" ] ) | ^( PARSER_GRAMMAR grammarSpec[\"parser \"] ) | ^( TREE_GRAMMAR grammarSpec[\"tree \"] ) | ^( COMBINED_GRAMMAR grammarSpec[\"\"] ) );
	public final void grammar_() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:139:2: ( ^( LEXER_GRAMMAR grammarSpec[\"lexer \" ] ) | ^( PARSER_GRAMMAR grammarSpec[\"parser \"] ) | ^( TREE_GRAMMAR grammarSpec[\"tree \"] ) | ^( COMBINED_GRAMMAR grammarSpec[\"\"] ) )
			int alt2=4;
			switch ( input.LA(1) ) {
			case LEXER_GRAMMAR:
				{
				alt2=1;
				}
				break;
			case PARSER_GRAMMAR:
				{
				alt2=2;
				}
				break;
			case TREE_GRAMMAR:
				{
				alt2=3;
				}
				break;
			case COMBINED_GRAMMAR:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:139:4: ^( LEXER_GRAMMAR grammarSpec[\"lexer \" ] )
					{
					match(input,LEXER_GRAMMAR,FOLLOW_LEXER_GRAMMAR_in_grammar_133); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_grammarSpec_in_grammar_135);
					grammarSpec("lexer ");
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:140:4: ^( PARSER_GRAMMAR grammarSpec[\"parser \"] )
					{
					match(input,PARSER_GRAMMAR,FOLLOW_PARSER_GRAMMAR_in_grammar_145); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_grammarSpec_in_grammar_147);
					grammarSpec("parser ");
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:141:4: ^( TREE_GRAMMAR grammarSpec[\"tree \"] )
					{
					match(input,TREE_GRAMMAR,FOLLOW_TREE_GRAMMAR_in_grammar_157); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_grammarSpec_in_grammar_159);
					grammarSpec("tree ");
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:142:4: ^( COMBINED_GRAMMAR grammarSpec[\"\"] )
					{
					match(input,COMBINED_GRAMMAR,FOLLOW_COMBINED_GRAMMAR_in_grammar_169); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_grammarSpec_in_grammar_171);
					grammarSpec("");
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
	// $ANTLR end "grammar_"



	// $ANTLR start "attrScope"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:145:1: attrScope : ^( 'scope' ID ( ruleAction )* ACTION ) ;
	public final void attrScope() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:146:2: ( ^( 'scope' ID ( ruleAction )* ACTION ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:146:4: ^( 'scope' ID ( ruleAction )* ACTION )
			{
			match(input,SCOPE,FOLLOW_SCOPE_in_attrScope187); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_attrScope189); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:146:18: ( ruleAction )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==AMPERSAND) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:146:18: ruleAction
					{
					pushFollow(FOLLOW_ruleAction_in_attrScope191);
					ruleAction();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,ACTION,FOLLOW_ACTION_in_attrScope194); 
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



	// $ANTLR start "grammarSpec"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:149:1: grammarSpec[String gtype] : id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules ;
	public final void grammarSpec(String gtype) throws RecognitionException {
		GrammarAST id=null;
		GrammarAST cmt=null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:150:2: (id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:150:4: id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules
			{
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_grammarSpec210); 
			out(gtype+"grammar "+(id!=null?id.getText():null));
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:151:3: (cmt= DOC_COMMENT )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==DOC_COMMENT) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:151:4: cmt= DOC_COMMENT
					{
					cmt=(GrammarAST)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec219); 
					out((cmt!=null?cmt.getText():null)+"\n");
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:152:3: ( optionsSpec )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==OPTIONS) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:152:4: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_grammarSpec229);
					optionsSpec();
					state._fsp--;

					}
					break;

			}

			out(";\n");
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:153:3: ( delegateGrammars )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IMPORT) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:153:4: delegateGrammars
					{
					pushFollow(FOLLOW_delegateGrammars_in_grammarSpec238);
					delegateGrammars();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:154:3: ( tokensSpec )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==TOKENS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:154:4: tokensSpec
					{
					pushFollow(FOLLOW_tokensSpec_in_grammarSpec245);
					tokensSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:155:3: ( attrScope )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==SCOPE) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:155:4: attrScope
					{
					pushFollow(FOLLOW_attrScope_in_grammarSpec252);
					attrScope();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:156:3: ( actions )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==AMPERSAND) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:156:4: actions
					{
					pushFollow(FOLLOW_actions_in_grammarSpec259);
					actions();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_rules_in_grammarSpec265);
			rules();
			state._fsp--;

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



	// $ANTLR start "actions"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:160:1: actions : ( action )+ ;
	public final void actions() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:161:2: ( ( action )+ )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:161:4: ( action )+
			{
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:161:4: ( action )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==AMPERSAND) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:161:6: action
					{
					pushFollow(FOLLOW_action_in_actions278);
					action();
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
	// $ANTLR end "actions"



	// $ANTLR start "action"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:164:1: action : ^( AMPERSAND id1= ID (id2= ID a1= ACTION |a2= ACTION ) ) ;
	public final void action() throws RecognitionException {
		GrammarAST id1=null;
		GrammarAST id2=null;
		GrammarAST a1=null;
		GrammarAST a2=null;


			String scope=null, name=null;
			String action=null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:169:2: ( ^( AMPERSAND id1= ID (id2= ID a1= ACTION |a2= ACTION ) ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:169:4: ^( AMPERSAND id1= ID (id2= ID a1= ACTION |a2= ACTION ) )
			{
			match(input,AMPERSAND,FOLLOW_AMPERSAND_in_action299); 
			match(input, Token.DOWN, null); 
			id1=(GrammarAST)match(input,ID,FOLLOW_ID_in_action303); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:170:4: (id2= ID a1= ACTION |a2= ACTION )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==ID) ) {
				alt11=1;
			}
			else if ( (LA11_0==ACTION) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:170:6: id2= ID a1= ACTION
					{
					id2=(GrammarAST)match(input,ID,FOLLOW_ID_in_action312); 
					a1=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_action316); 
					scope=(id1!=null?id1.getText():null); name=(a1!=null?a1.getText():null); action=(a1!=null?a1.getText():null);
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:172:6: a2= ACTION
					{
					a2=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_action331); 
					scope=null; name=(id1!=null?id1.getText():null); action=(a2!=null?a2.getText():null);
					}
					break;

			}

			match(input, Token.UP, null); 


						if ( showActions )
						{
							out("@"+(scope!=null?scope+"::":"")+name+action);
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
	// $ANTLR end "action"



	// $ANTLR start "optionsSpec"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:184:1: optionsSpec : ^( OPTIONS ( option )+ ) ;
	public final void optionsSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:185:2: ( ^( OPTIONS ( option )+ ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:185:4: ^( OPTIONS ( option )+ )
			{
			match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec363); 
			out(" options {");
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:186:4: ( option )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==ASSIGN) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:186:5: option
					{
					pushFollow(FOLLOW_option_in_optionsSpec371);
					option();
					state._fsp--;

					out("; ");
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			out("} ");
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
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:191:1: option : ^( ASSIGN id= ID optionValue ) ;
	public final void option() throws RecognitionException {
		GrammarAST id=null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:192:2: ( ^( ASSIGN id= ID optionValue ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:192:4: ^( ASSIGN id= ID optionValue )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_option397); 
			match(input, Token.DOWN, null); 
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_option401); 
			out((id!=null?id.getText():null)+"=");
			pushFollow(FOLLOW_optionValue_in_option405);
			optionValue();
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
	// $ANTLR end "option"



	// $ANTLR start "optionValue"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:195:1: optionValue : (id= ID |s= STRING_LITERAL |c= CHAR_LITERAL |i= INT );
	public final void optionValue() throws RecognitionException {
		GrammarAST id=null;
		GrammarAST s=null;
		GrammarAST c=null;
		GrammarAST i=null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:196:2: (id= ID |s= STRING_LITERAL |c= CHAR_LITERAL |i= INT )
			int alt13=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt13=1;
				}
				break;
			case STRING_LITERAL:
				{
				alt13=2;
				}
				break;
			case CHAR_LITERAL:
				{
				alt13=3;
				}
				break;
			case INT:
				{
				alt13=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:196:4: id= ID
					{
					id=(GrammarAST)match(input,ID,FOLLOW_ID_in_optionValue420); 
					out((id!=null?id.getText():null));
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:197:4: s= STRING_LITERAL
					{
					s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_optionValue440); 
					out((s!=null?s.getText():null));
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:198:4: c= CHAR_LITERAL
					{
					c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_optionValue449); 
					out((c!=null?c.getText():null));
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:199:4: i= INT
					{
					i=(GrammarAST)match(input,INT,FOLLOW_INT_in_optionValue460); 
					out((i!=null?i.getText():null));
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
	// $ANTLR end "optionValue"



	// $ANTLR start "delegateGrammars"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:215:1: delegateGrammars : ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ ) ;
	public final void delegateGrammars() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:216:2: ( ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:216:4: ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ )
			{
			match(input,IMPORT,FOLLOW_IMPORT_in_delegateGrammars490); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:216:16: ( ^( ASSIGN ID ID ) | ID )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=3;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==ASSIGN) ) {
					alt14=1;
				}
				else if ( (LA14_0==ID) ) {
					alt14=2;
				}

				switch (alt14) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:216:18: ^( ASSIGN ID ID )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammars495); 
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_delegateGrammars497); 
					match(input,ID,FOLLOW_ID_in_delegateGrammars499); 
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:216:36: ID
					{
					match(input,ID,FOLLOW_ID_in_delegateGrammars504); 
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
	// $ANTLR end "delegateGrammars"



	// $ANTLR start "tokensSpec"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:219:1: tokensSpec : ^( TOKENS ( tokenSpec )* ) ;
	public final void tokensSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:220:2: ( ^( TOKENS ( tokenSpec )* ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:220:4: ^( TOKENS ( tokenSpec )* )
			{
			match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec521); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// org/antlr/grammar/v3/ANTLRTreePrinter.g:220:13: ( tokenSpec )*
				loop15:
				while (true) {
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==ASSIGN||LA15_0==TOKEN_REF) ) {
						alt15=1;
					}

					switch (alt15) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:220:13: tokenSpec
						{
						pushFollow(FOLLOW_tokenSpec_in_tokensSpec523);
						tokenSpec();
						state._fsp--;

						}
						break;

					default :
						break loop15;
					}
				}

				match(input, Token.UP, null); 
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
	// $ANTLR end "tokensSpec"



	// $ANTLR start "tokenSpec"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:223:1: tokenSpec : ( TOKEN_REF | ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) ) );
	public final void tokenSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:224:2: ( TOKEN_REF | ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==TOKEN_REF) ) {
				alt16=1;
			}
			else if ( (LA16_0==ASSIGN) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:224:4: TOKEN_REF
					{
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec536); 
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:225:4: ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenSpec543); 
					match(input, Token.DOWN, null); 
					match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec545); 
					if ( input.LA(1)==CHAR_LITERAL||input.LA(1)==STRING_LITERAL ) {
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



	// $ANTLR start "rules"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:228:1: rules : ( rule | precRule )+ ;
	public final void rules() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:229:2: ( ( rule | precRule )+ )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:229:4: ( rule | precRule )+
			{
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:229:4: ( rule | precRule )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=3;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==RULE) ) {
					alt17=1;
				}
				else if ( (LA17_0==PREC_RULE) ) {
					alt17=2;
				}

				switch (alt17) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:229:6: rule
					{
					pushFollow(FOLLOW_rule_in_rules566);
					rule();
					state._fsp--;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:229:13: precRule
					{
					pushFollow(FOLLOW_precRule_in_rules570);
					precRule();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
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



	// $ANTLR start "rule"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:232:1: rule : ^( RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR ) ;
	public final void rule() throws RecognitionException {
		GrammarAST id=null;
		GrammarAST arg=null;
		GrammarAST ret=null;
		TreeRuleReturnScope b =null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:233:2: ( ^( RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:233:4: ^( RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR )
			{
			match(input,RULE,FOLLOW_RULE_in_rule586); 
			match(input, Token.DOWN, null); 
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rule590); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:234:4: ( modifier )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==FRAGMENT||(LA18_0 >= PRIVATE && LA18_0 <= PUBLIC)) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:234:5: modifier
					{
					pushFollow(FOLLOW_modifier_in_rule596);
					modifier();
					state._fsp--;

					}
					break;

			}

			out((id!=null?id.getText():null));
			match(input,ARG,FOLLOW_ARG_in_rule609); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// org/antlr/grammar/v3/ANTLRTreePrinter.g:236:10: (arg= ARG_ACTION )?
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==ARG_ACTION) ) {
					alt19=1;
				}
				switch (alt19) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:236:11: arg= ARG_ACTION
						{
						arg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule614); 
						out("["+(arg!=null?arg.getText():null)+"]");
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			match(input,RET,FOLLOW_RET_in_rule627); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// org/antlr/grammar/v3/ANTLRTreePrinter.g:237:10: (ret= ARG_ACTION )?
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==ARG_ACTION) ) {
					alt20=1;
				}
				switch (alt20) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:237:11: ret= ARG_ACTION
						{
						ret=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule632); 
						out(" returns ["+(ret!=null?ret.getText():null)+"]");
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:238:4: ( throwsSpec )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==THROWS) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:238:5: throwsSpec
					{
					pushFollow(FOLLOW_throwsSpec_in_rule645);
					throwsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:239:4: ( optionsSpec )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==OPTIONS) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:239:5: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_rule653);
					optionsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:240:4: ( ruleScopeSpec )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==SCOPE) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:240:5: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_rule661);
					ruleScopeSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:241:4: ( ruleAction )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==AMPERSAND) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:241:5: ruleAction
					{
					pushFollow(FOLLOW_ruleAction_in_rule669);
					ruleAction();
					state._fsp--;

					}
					break;

				default :
					break loop24;
				}
			}

			out(" :");

							if ( input.LA(5) == NOT || input.LA(5) == ASSIGN )
								out(" ");
						
			pushFollow(FOLLOW_block_in_rule688);
			b=block(false);
			state._fsp--;

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:248:4: ( exceptionGroup )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==CATCH||LA25_0==FINALLY) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:248:5: exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_rule695);
					exceptionGroup();
					state._fsp--;

					}
					break;

			}

			match(input,EOR,FOLLOW_EOR_in_rule702); 
			out(";\n");
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



	// $ANTLR start "precRule"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:253:1: precRule : ^( PREC_RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR ) ;
	public final void precRule() throws RecognitionException {
		GrammarAST id=null;
		GrammarAST arg=null;
		GrammarAST ret=null;
		TreeRuleReturnScope b =null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:254:2: ( ^( PREC_RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:254:4: ^( PREC_RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR )
			{
			match(input,PREC_RULE,FOLLOW_PREC_RULE_in_precRule721); 
			match(input, Token.DOWN, null); 
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_precRule725); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:255:4: ( modifier )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==FRAGMENT||(LA26_0 >= PRIVATE && LA26_0 <= PUBLIC)) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:255:5: modifier
					{
					pushFollow(FOLLOW_modifier_in_precRule731);
					modifier();
					state._fsp--;

					}
					break;

			}

			out((id!=null?id.getText():null));
			match(input,ARG,FOLLOW_ARG_in_precRule744); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// org/antlr/grammar/v3/ANTLRTreePrinter.g:257:10: (arg= ARG_ACTION )?
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==ARG_ACTION) ) {
					alt27=1;
				}
				switch (alt27) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:257:11: arg= ARG_ACTION
						{
						arg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_precRule749); 
						out("["+(arg!=null?arg.getText():null)+"]");
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			match(input,RET,FOLLOW_RET_in_precRule762); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// org/antlr/grammar/v3/ANTLRTreePrinter.g:258:10: (ret= ARG_ACTION )?
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==ARG_ACTION) ) {
					alt28=1;
				}
				switch (alt28) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:258:11: ret= ARG_ACTION
						{
						ret=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_precRule767); 
						out(" returns ["+(ret!=null?ret.getText():null)+"]");
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:259:4: ( throwsSpec )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==THROWS) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:259:5: throwsSpec
					{
					pushFollow(FOLLOW_throwsSpec_in_precRule780);
					throwsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:260:4: ( optionsSpec )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==OPTIONS) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:260:5: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_precRule788);
					optionsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:261:4: ( ruleScopeSpec )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==SCOPE) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:261:5: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_precRule796);
					ruleScopeSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:262:4: ( ruleAction )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==AMPERSAND) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:262:5: ruleAction
					{
					pushFollow(FOLLOW_ruleAction_in_precRule804);
					ruleAction();
					state._fsp--;

					}
					break;

				default :
					break loop32;
				}
			}

			out(" :");

							if ( input.LA(5) == NOT || input.LA(5) == ASSIGN )
								out(" ");
						
			pushFollow(FOLLOW_block_in_precRule823);
			b=block(false);
			state._fsp--;

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:269:4: ( exceptionGroup )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==CATCH||LA33_0==FINALLY) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:269:5: exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_precRule830);
					exceptionGroup();
					state._fsp--;

					}
					break;

			}

			match(input,EOR,FOLLOW_EOR_in_precRule837); 
			out(";\n");
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
	// $ANTLR end "precRule"



	// $ANTLR start "ruleAction"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:274:1: ruleAction : ^( AMPERSAND id= ID a= ACTION ) ;
	public final void ruleAction() throws RecognitionException {
		GrammarAST id=null;
		GrammarAST a=null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:275:2: ( ^( AMPERSAND id= ID a= ACTION ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:275:4: ^( AMPERSAND id= ID a= ACTION )
			{
			match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleAction855); 
			match(input, Token.DOWN, null); 
			id=(GrammarAST)match(input,ID,FOLLOW_ID_in_ruleAction859); 
			a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_ruleAction863); 
			match(input, Token.UP, null); 

			if ( showActions ) out("@"+(id!=null?id.getText():null)+"{"+(a!=null?a.getText():null)+"}");
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


	public static class modifier_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "modifier"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:279:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
	public final ANTLRTreePrinter.modifier_return modifier() throws RecognitionException {
		ANTLRTreePrinter.modifier_return retval = new ANTLRTreePrinter.modifier_return();
		retval.start = input.LT(1);

		out(((GrammarAST)retval.start).getText()); out(" ");
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:282:2: ( 'protected' | 'public' | 'private' | 'fragment' )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:
			{
			if ( input.LA(1)==FRAGMENT||(input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
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
		return retval;
	}
	// $ANTLR end "modifier"



	// $ANTLR start "throwsSpec"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:288:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
	public final void throwsSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:289:2: ( ^( 'throws' ( ID )+ ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:289:4: ^( 'throws' ( ID )+ )
			{
			match(input,THROWS,FOLLOW_THROWS_in_throwsSpec912); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:289:15: ( ID )+
			int cnt34=0;
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==ID) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:289:15: ID
					{
					match(input,ID,FOLLOW_ID_in_throwsSpec914); 
					}
					break;

				default :
					if ( cnt34 >= 1 ) break loop34;
					EarlyExitException eee = new EarlyExitException(34, input);
					throw eee;
				}
				cnt34++;
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
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:292:1: ruleScopeSpec : ^( 'scope' ( ruleAction )* ( ACTION )? ( ID )* ) ;
	public final void ruleScopeSpec() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:293:2: ( ^( 'scope' ( ruleAction )* ( ACTION )? ( ID )* ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:293:4: ^( 'scope' ( ruleAction )* ( ACTION )? ( ID )* )
			{
			match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec929); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// org/antlr/grammar/v3/ANTLRTreePrinter.g:293:15: ( ruleAction )*
				loop35:
				while (true) {
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==AMPERSAND) ) {
						alt35=1;
					}

					switch (alt35) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:293:15: ruleAction
						{
						pushFollow(FOLLOW_ruleAction_in_ruleScopeSpec931);
						ruleAction();
						state._fsp--;

						}
						break;

					default :
						break loop35;
					}
				}

				// org/antlr/grammar/v3/ANTLRTreePrinter.g:293:27: ( ACTION )?
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==ACTION) ) {
					alt36=1;
				}
				switch (alt36) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:293:28: ACTION
						{
						match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec935); 
						}
						break;

				}

				// org/antlr/grammar/v3/ANTLRTreePrinter.g:293:37: ( ID )*
				loop37:
				while (true) {
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==ID) ) {
						alt37=1;
					}

					switch (alt37) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:293:39: ID
						{
						match(input,ID,FOLLOW_ID_in_ruleScopeSpec941); 
						}
						break;

					default :
						break loop37;
					}
				}

				match(input, Token.UP, null); 
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
	};


	// $ANTLR start "block"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:296:1: block[boolean forceParens] : ^( BLOCK ( optionsSpec )? alternative rewrite ( alternative rewrite )* EOB ) ;
	public final ANTLRTreePrinter.block_return block(boolean forceParens) throws RecognitionException {
		ANTLRTreePrinter.block_return retval = new ANTLRTreePrinter.block_return();
		retval.start = input.LT(1);


		int numAlts = countAltsForBlock(((GrammarAST)retval.start));

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:301:2: ( ^( BLOCK ( optionsSpec )? alternative rewrite ( alternative rewrite )* EOB ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:301:4: ^( BLOCK ( optionsSpec )? alternative rewrite ( alternative rewrite )* EOB )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_block965); 

							if ( forceParens||numAlts>1 )
							{
								//for ( Antlr.Runtime.Tree.Tree parent = ((GrammarAST)retval.start).getParent(); parent != null && parent.getType() != RULE; parent = parent.getParent() )
								//{
								//	if ( parent.getType() == BLOCK && countAltsForBlock((GrammarAST)parent) > 1 )
								//	{
								//		out(" ");
								//		break;
								//	}
								//}
								out(" (");
							}
						
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:316:4: ( optionsSpec )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==OPTIONS) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:316:5: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_block976);
					optionsSpec();
					state._fsp--;

					out(" :");
					}
					break;

			}

			pushFollow(FOLLOW_alternative_in_block986);
			alternative();
			state._fsp--;

			pushFollow(FOLLOW_rewrite_in_block988);
			rewrite();
			state._fsp--;

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:317:24: ( alternative rewrite )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( (LA39_0==ALT) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:317:26: alternative rewrite
					{
					out("|");
					pushFollow(FOLLOW_alternative_in_block994);
					alternative();
					state._fsp--;

					pushFollow(FOLLOW_rewrite_in_block996);
					rewrite();
					state._fsp--;

					}
					break;

				default :
					break loop39;
				}
			}

			match(input,EOB,FOLLOW_EOB_in_block1004); 
			if ( forceParens||numAlts>1 ) out(")");
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
		return retval;
	}
	// $ANTLR end "block"



	// $ANTLR start "alternative"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:322:1: alternative : ^( ALT ( element )* EOA ) ;
	public final void alternative() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:323:2: ( ^( ALT ( element )* EOA ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:323:4: ^( ALT ( element )* EOA )
			{
			match(input,ALT,FOLLOW_ALT_in_alternative1026); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:323:11: ( element )*
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==ACTION||(LA40_0 >= ASSIGN && LA40_0 <= BLOCK)||(LA40_0 >= CHAR_LITERAL && LA40_0 <= CHAR_RANGE)||LA40_0==CLOSURE||LA40_0==DOT||LA40_0==EPSILON||LA40_0==FORCED_ACTION||LA40_0==GATED_SEMPRED||LA40_0==LABEL||LA40_0==NOT||LA40_0==OPTIONAL||(LA40_0 >= PLUS_ASSIGN && LA40_0 <= POSITIVE_CLOSURE)||LA40_0==RANGE||LA40_0==ROOT||LA40_0==RULE_REF||LA40_0==SEMPRED||(LA40_0 >= STRING_LITERAL && LA40_0 <= SYN_SEMPRED)||LA40_0==TOKEN_REF||LA40_0==TREE_BEGIN||LA40_0==WILDCARD) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:323:11: element
					{
					pushFollow(FOLLOW_element_in_alternative1028);
					element();
					state._fsp--;

					}
					break;

				default :
					break loop40;
				}
			}

			match(input,EOA,FOLLOW_EOA_in_alternative1031); 
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
	// $ANTLR end "alternative"



	// $ANTLR start "exceptionGroup"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:326:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
	public final void exceptionGroup() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:327:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==CATCH) ) {
				alt43=1;
			}
			else if ( (LA43_0==FINALLY) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:327:4: ( exceptionHandler )+ ( finallyClause )?
					{
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:327:4: ( exceptionHandler )+
					int cnt41=0;
					loop41:
					while (true) {
						int alt41=2;
						int LA41_0 = input.LA(1);
						if ( (LA41_0==CATCH) ) {
							alt41=1;
						}

						switch (alt41) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRTreePrinter.g:327:6: exceptionHandler
							{
							pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1046);
							exceptionHandler();
							state._fsp--;

							}
							break;

						default :
							if ( cnt41 >= 1 ) break loop41;
							EarlyExitException eee = new EarlyExitException(41, input);
							throw eee;
						}
						cnt41++;
					}

					// org/antlr/grammar/v3/ANTLRTreePrinter.g:327:26: ( finallyClause )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==FINALLY) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRTreePrinter.g:327:27: finallyClause
							{
							pushFollow(FOLLOW_finallyClause_in_exceptionGroup1052);
							finallyClause();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:328:4: finallyClause
					{
					pushFollow(FOLLOW_finallyClause_in_exceptionGroup1059);
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
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:331:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
	public final void exceptionHandler() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:332:2: ( ^( 'catch' ARG_ACTION ACTION ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:332:4: ^( 'catch' ARG_ACTION ACTION )
			{
			match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler1071); 
			match(input, Token.DOWN, null); 
			match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1073); 
			match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1075); 
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
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:335:1: finallyClause : ^( 'finally' ACTION ) ;
	public final void finallyClause() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:336:2: ( ^( 'finally' ACTION ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:336:4: ^( 'finally' ACTION )
			{
			match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause1088); 
			match(input, Token.DOWN, null); 
			match(input,ACTION,FOLLOW_ACTION_in_finallyClause1090); 
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



	// $ANTLR start "rewrite"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:339:1: rewrite : ( ^( REWRITES ( single_rewrite )+ ) | REWRITES |);
	public final void rewrite() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:340:2: ( ^( REWRITES ( single_rewrite )+ ) | REWRITES |)
			int alt45=3;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==REWRITES) ) {
				int LA45_1 = input.LA(2);
				if ( (LA45_1==DOWN) ) {
					alt45=1;
				}
				else if ( (LA45_1==EOF||LA45_1==ALT||LA45_1==EOB) ) {
					alt45=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 45, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA45_0==EOF||LA45_0==ALT||LA45_0==EOB) ) {
				alt45=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:340:4: ^( REWRITES ( single_rewrite )+ )
					{
					match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1103); 
					match(input, Token.DOWN, null); 
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:340:15: ( single_rewrite )+
					int cnt44=0;
					loop44:
					while (true) {
						int alt44=2;
						int LA44_0 = input.LA(1);
						if ( (LA44_0==REWRITE) ) {
							alt44=1;
						}

						switch (alt44) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRTreePrinter.g:340:15: single_rewrite
							{
							pushFollow(FOLLOW_single_rewrite_in_rewrite1105);
							single_rewrite();
							state._fsp--;

							}
							break;

						default :
							if ( cnt44 >= 1 ) break loop44;
							EarlyExitException eee = new EarlyExitException(44, input);
							throw eee;
						}
						cnt44++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:341:4: REWRITES
					{
					match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1112); 
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:343:2: 
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



	// $ANTLR start "single_rewrite"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:345:1: single_rewrite : ^( REWRITE ( SEMPRED )? ( alternative | rewrite_template | ETC | ACTION ) ) ;
	public final void single_rewrite() throws RecognitionException {
		GrammarAST SEMPRED1=null;
		GrammarAST ACTION2=null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:346:2: ( ^( REWRITE ( SEMPRED )? ( alternative | rewrite_template | ETC | ACTION ) ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:346:4: ^( REWRITE ( SEMPRED )? ( alternative | rewrite_template | ETC | ACTION ) )
			{
			match(input,REWRITE,FOLLOW_REWRITE_in_single_rewrite1128); 
			out(" ->");
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:347:4: ( SEMPRED )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==SEMPRED) ) {
				alt46=1;
			}
			switch (alt46) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:347:6: SEMPRED
					{
					SEMPRED1=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_single_rewrite1137); 
					out(" {"+(SEMPRED1!=null?SEMPRED1.getText():null)+"}?");
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:349:4: ( alternative | rewrite_template | ETC | ACTION )
			int alt47=4;
			switch ( input.LA(1) ) {
			case ALT:
				{
				alt47=1;
				}
				break;
			case TEMPLATE:
				{
				alt47=2;
				}
				break;
			case ETC:
				{
				alt47=3;
				}
				break;
			case ACTION:
				{
				alt47=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:349:6: alternative
					{
					pushFollow(FOLLOW_alternative_in_single_rewrite1152);
					alternative();
					state._fsp--;

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:350:6: rewrite_template
					{
					pushFollow(FOLLOW_rewrite_template_in_single_rewrite1159);
					rewrite_template();
					state._fsp--;

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:351:6: ETC
					{
					match(input,ETC,FOLLOW_ETC_in_single_rewrite1166); 
					out("...");
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:352:6: ACTION
					{
					ACTION2=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_single_rewrite1175); 
					out(" {"+(ACTION2!=null?ACTION2.getText():null)+"}");
					}
					break;

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
	// $ANTLR end "single_rewrite"



	// $ANTLR start "rewrite_template"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:357:1: rewrite_template : ^( TEMPLATE (id= ID |ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) ;
	public final void rewrite_template() throws RecognitionException {
		GrammarAST id=null;
		GrammarAST ind=null;
		GrammarAST arg=null;
		GrammarAST a=null;
		GrammarAST DOUBLE_QUOTE_STRING_LITERAL3=null;
		GrammarAST DOUBLE_ANGLE_STRING_LITERAL4=null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:358:2: ( ^( TEMPLATE (id= ID |ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:358:4: ^( TEMPLATE (id= ID |ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? )
			{
			match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template1199); 
			match(input, Token.DOWN, null); 
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:359:4: (id= ID |ind= ACTION )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==ID) ) {
				alt48=1;
			}
			else if ( (LA48_0==ACTION) ) {
				alt48=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}

			switch (alt48) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:359:6: id= ID
					{
					id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template1208); 
					out(" "+(id!=null?id.getText():null));
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:360:6: ind= ACTION
					{
					ind=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1219); 
					out(" ({"+(ind!=null?ind.getText():null)+"})");
					}
					break;

			}

			match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template1233); 
			out("(");
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// org/antlr/grammar/v3/ANTLRTreePrinter.g:364:5: ( ^( ARG arg= ID a= ACTION ) )*
				loop49:
				while (true) {
					int alt49=2;
					int LA49_0 = input.LA(1);
					if ( (LA49_0==ARG) ) {
						alt49=1;
					}

					switch (alt49) {
					case 1 :
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:364:7: ^( ARG arg= ID a= ACTION )
						{
						match(input,ARG,FOLLOW_ARG_in_rewrite_template1249); 
						match(input, Token.DOWN, null); 
						arg=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template1253); 
						out((arg!=null?arg.getText():null)+"=");
						a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1265); 
						out((a!=null?a.getText():null));
						match(input, Token.UP, null); 

						}
						break;

					default :
						break loop49;
					}
				}

				out(")");
				match(input, Token.UP, null); 
			}

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:370:4: ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )?
			int alt50=3;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==DOUBLE_QUOTE_STRING_LITERAL) ) {
				alt50=1;
			}
			else if ( (LA50_0==DOUBLE_ANGLE_STRING_LITERAL) ) {
				alt50=2;
			}
			switch (alt50) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:370:6: DOUBLE_QUOTE_STRING_LITERAL
					{
					DOUBLE_QUOTE_STRING_LITERAL3=(GrammarAST)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template1301); 
					out(" "+(DOUBLE_QUOTE_STRING_LITERAL3!=null?DOUBLE_QUOTE_STRING_LITERAL3.getText():null));
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:371:6: DOUBLE_ANGLE_STRING_LITERAL
					{
					DOUBLE_ANGLE_STRING_LITERAL4=(GrammarAST)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template1310); 
					out(" "+(DOUBLE_ANGLE_STRING_LITERAL4!=null?DOUBLE_ANGLE_STRING_LITERAL4.getText():null));
					}
					break;

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
	// $ANTLR end "rewrite_template"



	// $ANTLR start "element"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:376:1: element : ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( CHAR_RANGE atom atom ) | ^( ASSIGN id= ID element ) | ^( PLUS_ASSIGN id2= ID element ) | ebnf | tree_ | ^( SYNPRED block[true] ) |a= ACTION |a2= FORCED_ACTION |pred= SEMPRED |spred= SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) |gpred= GATED_SEMPRED | EPSILON );
	public final void element() throws RecognitionException {
		GrammarAST id=null;
		GrammarAST id2=null;
		GrammarAST a=null;
		GrammarAST a2=null;
		GrammarAST pred=null;
		GrammarAST spred=null;
		GrammarAST gpred=null;

		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:377:2: ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( CHAR_RANGE atom atom ) | ^( ASSIGN id= ID element ) | ^( PLUS_ASSIGN id2= ID element ) | ebnf | tree_ | ^( SYNPRED block[true] ) |a= ACTION |a2= FORCED_ACTION |pred= SEMPRED |spred= SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) |gpred= GATED_SEMPRED | EPSILON )
			int alt52=18;
			switch ( input.LA(1) ) {
			case ROOT:
				{
				alt52=1;
				}
				break;
			case BANG:
				{
				alt52=2;
				}
				break;
			case CHAR_LITERAL:
			case DOT:
			case LABEL:
			case RULE_REF:
			case STRING_LITERAL:
			case TOKEN_REF:
			case WILDCARD:
				{
				alt52=3;
				}
				break;
			case NOT:
				{
				alt52=4;
				}
				break;
			case RANGE:
				{
				alt52=5;
				}
				break;
			case CHAR_RANGE:
				{
				alt52=6;
				}
				break;
			case ASSIGN:
				{
				alt52=7;
				}
				break;
			case PLUS_ASSIGN:
				{
				alt52=8;
				}
				break;
			case BLOCK:
			case CLOSURE:
			case OPTIONAL:
			case POSITIVE_CLOSURE:
				{
				alt52=9;
				}
				break;
			case TREE_BEGIN:
				{
				alt52=10;
				}
				break;
			case SYNPRED:
				{
				alt52=11;
				}
				break;
			case ACTION:
				{
				alt52=12;
				}
				break;
			case FORCED_ACTION:
				{
				alt52=13;
				}
				break;
			case SEMPRED:
				{
				alt52=14;
				}
				break;
			case SYN_SEMPRED:
				{
				alt52=15;
				}
				break;
			case BACKTRACK_SEMPRED:
				{
				alt52=16;
				}
				break;
			case GATED_SEMPRED:
				{
				alt52=17;
				}
				break;
			case EPSILON:
				{
				alt52=18;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}
			switch (alt52) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:377:4: ^( ROOT element )
					{
					match(input,ROOT,FOLLOW_ROOT_in_element1334); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_element_in_element1336);
					element();
					state._fsp--;

					match(input, Token.UP, null); 

					out("^");
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:378:4: ^( BANG element )
					{
					match(input,BANG,FOLLOW_BANG_in_element1345); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_element_in_element1347);
					element();
					state._fsp--;

					match(input, Token.UP, null); 

					out("!");
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:379:4: atom
					{
					pushFollow(FOLLOW_atom_in_element1355);
					atom();
					state._fsp--;

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:380:4: ^( NOT element )
					{
					match(input,NOT,FOLLOW_NOT_in_element1361); 
					out("~");
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_element_in_element1365);
					element();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:381:4: ^( RANGE atom atom )
					{
					match(input,RANGE,FOLLOW_RANGE_in_element1372); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_atom_in_element1374);
					atom();
					state._fsp--;

					out("..");
					pushFollow(FOLLOW_atom_in_element1378);
					atom();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:382:4: ^( CHAR_RANGE atom atom )
					{
					match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_element1385); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_atom_in_element1387);
					atom();
					state._fsp--;

					out("..");
					pushFollow(FOLLOW_atom_in_element1391);
					atom();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:383:4: ^( ASSIGN id= ID element )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_element1398); 
					match(input, Token.DOWN, null); 
					id=(GrammarAST)match(input,ID,FOLLOW_ID_in_element1402); 
					out((id!=null?id.getText():null)+"=");
					pushFollow(FOLLOW_element_in_element1406);
					element();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:384:4: ^( PLUS_ASSIGN id2= ID element )
					{
					match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element1413); 
					match(input, Token.DOWN, null); 
					id2=(GrammarAST)match(input,ID,FOLLOW_ID_in_element1417); 
					out((id2!=null?id2.getText():null)+"+=");
					pushFollow(FOLLOW_element_in_element1421);
					element();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:385:4: ebnf
					{
					pushFollow(FOLLOW_ebnf_in_element1427);
					ebnf();
					state._fsp--;

					}
					break;
				case 10 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:386:4: tree_
					{
					pushFollow(FOLLOW_tree__in_element1432);
					tree_();
					state._fsp--;

					}
					break;
				case 11 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:387:4: ^( SYNPRED block[true] )
					{
					match(input,SYNPRED,FOLLOW_SYNPRED_in_element1439); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_element1441);
					block(true);
					state._fsp--;

					match(input, Token.UP, null); 

					out("=>");
					}
					break;
				case 12 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:388:4: a= ACTION
					{
					a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element1453); 
					if ( showActions ) {out("{"); out((a!=null?a.getText():null)); out("}");}
					}
					break;
				case 13 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:389:4: a2= FORCED_ACTION
					{
					a2=(GrammarAST)match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element1463); 
					if ( showActions ) {out("{{"); out((a2!=null?a2.getText():null)); out("}}");}
					}
					break;
				case 14 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:390:4: pred= SEMPRED
					{
					pred=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element1473); 

								if ( showActions )
								{
									out("{");
									out((pred!=null?pred.getText():null));
									out("}?");
								}
								else
								{
									out("{...}?");
								}
							
					}
					break;
				case 15 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:403:4: spred= SYN_SEMPRED
					{
					spred=(GrammarAST)match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element1484); 

								String name = (spred!=null?spred.getText():null);
								GrammarAST predAST=grammar.getSyntacticPredicate(name);
								block(predAST, true);
								out("=>");
							
					}
					break;
				case 16 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:410:4: ^( BACKTRACK_SEMPRED ( . )* )
					{
					match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element1494); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// org/antlr/grammar/v3/ANTLRTreePrinter.g:410:24: ( . )*
						loop51:
						while (true) {
							int alt51=2;
							int LA51_0 = input.LA(1);
							if ( ((LA51_0 >= ACTION && LA51_0 <= XDIGIT)) ) {
								alt51=1;
							}
							else if ( (LA51_0==UP) ) {
								alt51=2;
							}

							switch (alt51) {
							case 1 :
								// org/antlr/grammar/v3/ANTLRTreePrinter.g:410:24: .
								{
								matchAny(input); 
								}
								break;

							default :
								break loop51;
							}
						}

						match(input, Token.UP, null); 
					}

					}
					break;
				case 17 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:411:4: gpred= GATED_SEMPRED
					{
					gpred=(GrammarAST)match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element1506); 

							if ( showActions ) {out("{"); out((gpred!=null?gpred.getText():null)); out("}? =>");}
							else {out("{...}? =>");}
							
					}
					break;
				case 18 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:416:4: EPSILON
					{
					match(input,EPSILON,FOLLOW_EPSILON_in_element1515); 
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
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:419:1: ebnf : ( block[true] | ^( OPTIONAL block[true] ) | ^( CLOSURE block[true] ) | ^( POSITIVE_CLOSURE block[true] ) );
	public final void ebnf() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:420:2: ( block[true] | ^( OPTIONAL block[true] ) | ^( CLOSURE block[true] ) | ^( POSITIVE_CLOSURE block[true] ) )
			int alt53=4;
			switch ( input.LA(1) ) {
			case BLOCK:
				{
				alt53=1;
				}
				break;
			case OPTIONAL:
				{
				alt53=2;
				}
				break;
			case CLOSURE:
				{
				alt53=3;
				}
				break;
			case POSITIVE_CLOSURE:
				{
				alt53=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 53, 0, input);
				throw nvae;
			}
			switch (alt53) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:420:4: block[true]
					{
					pushFollow(FOLLOW_block_in_ebnf1526);
					block(true);
					state._fsp--;

					out(" ");
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:421:4: ^( OPTIONAL block[true] )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1536); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ebnf1538);
					block(true);
					state._fsp--;

					match(input, Token.UP, null); 

					out("? ");
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:422:4: ^( CLOSURE block[true] )
					{
					match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1550); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ebnf1552);
					block(true);
					state._fsp--;

					match(input, Token.UP, null); 

					out("* ");
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:423:4: ^( POSITIVE_CLOSURE block[true] )
					{
					match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1565); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ebnf1567);
					block(true);
					state._fsp--;

					match(input, Token.UP, null); 

					out("+ ");
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
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:426:1: tree_ : ^( TREE_BEGIN element ( element )* ) ;
	public final void tree_() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:427:2: ( ^( TREE_BEGIN element ( element )* ) )
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:427:4: ^( TREE_BEGIN element ( element )* )
			{
			match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1584); 
			out(" ^(");
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_element_in_tree_1588);
			element();
			state._fsp--;

			// org/antlr/grammar/v3/ANTLRTreePrinter.g:427:39: ( element )*
			loop54:
			while (true) {
				int alt54=2;
				int LA54_0 = input.LA(1);
				if ( (LA54_0==ACTION||(LA54_0 >= ASSIGN && LA54_0 <= BLOCK)||(LA54_0 >= CHAR_LITERAL && LA54_0 <= CHAR_RANGE)||LA54_0==CLOSURE||LA54_0==DOT||LA54_0==EPSILON||LA54_0==FORCED_ACTION||LA54_0==GATED_SEMPRED||LA54_0==LABEL||LA54_0==NOT||LA54_0==OPTIONAL||(LA54_0 >= PLUS_ASSIGN && LA54_0 <= POSITIVE_CLOSURE)||LA54_0==RANGE||LA54_0==ROOT||LA54_0==RULE_REF||LA54_0==SEMPRED||(LA54_0 >= STRING_LITERAL && LA54_0 <= SYN_SEMPRED)||LA54_0==TOKEN_REF||LA54_0==TREE_BEGIN||LA54_0==WILDCARD) ) {
					alt54=1;
				}

				switch (alt54) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:427:40: element
					{
					pushFollow(FOLLOW_element_in_tree_1591);
					element();
					state._fsp--;

					}
					break;

				default :
					break loop54;
				}
			}

			out(") ");
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
	// $ANTLR end "tree_"


	public static class atom_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "atom"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:430:1: atom : ( ( ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? ) | ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? ) | ^( CHAR_LITERAL ( ast_suffix )? ) | ^( STRING_LITERAL ( ast_suffix )? ) | ^( WILDCARD ( ast_suffix )? ) ) | LABEL | ^( DOT ID atom ) );
	public final ANTLRTreePrinter.atom_return atom() throws RecognitionException {
		ANTLRTreePrinter.atom_return retval = new ANTLRTreePrinter.atom_return();
		retval.start = input.LT(1);

		GrammarAST rarg=null;
		GrammarAST targ=null;
		GrammarAST LABEL5=null;
		GrammarAST ID6=null;

		out(" ");
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:433:2: ( ( ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? ) | ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? ) | ^( CHAR_LITERAL ( ast_suffix )? ) | ^( STRING_LITERAL ( ast_suffix )? ) | ^( WILDCARD ( ast_suffix )? ) ) | LABEL | ^( DOT ID atom ) )
			int alt63=3;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
			case RULE_REF:
			case STRING_LITERAL:
			case TOKEN_REF:
			case WILDCARD:
				{
				alt63=1;
				}
				break;
			case LABEL:
				{
				alt63=2;
				}
				break;
			case DOT:
				{
				alt63=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}
			switch (alt63) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:433:4: ( ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? ) | ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? ) | ^( CHAR_LITERAL ( ast_suffix )? ) | ^( STRING_LITERAL ( ast_suffix )? ) | ^( WILDCARD ( ast_suffix )? ) )
					{
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:433:4: ( ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? ) | ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? ) | ^( CHAR_LITERAL ( ast_suffix )? ) | ^( STRING_LITERAL ( ast_suffix )? ) | ^( WILDCARD ( ast_suffix )? ) )
					int alt62=5;
					switch ( input.LA(1) ) {
					case RULE_REF:
						{
						alt62=1;
						}
						break;
					case TOKEN_REF:
						{
						alt62=2;
						}
						break;
					case CHAR_LITERAL:
						{
						alt62=3;
						}
						break;
					case STRING_LITERAL:
						{
						alt62=4;
						}
						break;
					case WILDCARD:
						{
						alt62=5;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 62, 0, input);
						throw nvae;
					}
					switch (alt62) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRTreePrinter.g:433:6: ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? )
							{
							match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1617); 
							out(((GrammarAST)retval.start).toString());
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); 
								// org/antlr/grammar/v3/ANTLRTreePrinter.g:434:5: (rarg= ARG_ACTION )?
								int alt55=2;
								int LA55_0 = input.LA(1);
								if ( (LA55_0==ARG_ACTION) ) {
									alt55=1;
								}
								switch (alt55) {
									case 1 :
										// org/antlr/grammar/v3/ANTLRTreePrinter.g:434:6: rarg= ARG_ACTION
										{
										rarg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1629); 
										out("["+rarg.toString()+"]");
										}
										break;

								}

								// org/antlr/grammar/v3/ANTLRTreePrinter.g:435:5: ( ast_suffix )?
								int alt56=2;
								int LA56_0 = input.LA(1);
								if ( (LA56_0==BANG||LA56_0==ROOT) ) {
									alt56=1;
								}
								switch (alt56) {
									case 1 :
										// org/antlr/grammar/v3/ANTLRTreePrinter.g:435:6: ast_suffix
										{
										pushFollow(FOLLOW_ast_suffix_in_atom1640);
										ast_suffix();
										state._fsp--;

										}
										break;

								}

								match(input, Token.UP, null); 
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRTreePrinter.g:437:5: ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? )
							{
							match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1655); 
							out(((GrammarAST)retval.start).toString());
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); 
								// org/antlr/grammar/v3/ANTLRTreePrinter.g:438:5: (targ= ARG_ACTION )?
								int alt57=2;
								int LA57_0 = input.LA(1);
								if ( (LA57_0==ARG_ACTION) ) {
									alt57=1;
								}
								switch (alt57) {
									case 1 :
										// org/antlr/grammar/v3/ANTLRTreePrinter.g:438:6: targ= ARG_ACTION
										{
										targ=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1667); 
										out("["+targ.toString()+"]");
										}
										break;

								}

								// org/antlr/grammar/v3/ANTLRTreePrinter.g:439:5: ( ast_suffix )?
								int alt58=2;
								int LA58_0 = input.LA(1);
								if ( (LA58_0==BANG||LA58_0==ROOT) ) {
									alt58=1;
								}
								switch (alt58) {
									case 1 :
										// org/antlr/grammar/v3/ANTLRTreePrinter.g:439:6: ast_suffix
										{
										pushFollow(FOLLOW_ast_suffix_in_atom1679);
										ast_suffix();
										state._fsp--;

										}
										break;

								}

								match(input, Token.UP, null); 
							}

							}
							break;
						case 3 :
							// org/antlr/grammar/v3/ANTLRTreePrinter.g:441:5: ^( CHAR_LITERAL ( ast_suffix )? )
							{
							match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1694); 
							out(((GrammarAST)retval.start).toString());
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); 
								// org/antlr/grammar/v3/ANTLRTreePrinter.g:442:5: ( ast_suffix )?
								int alt59=2;
								int LA59_0 = input.LA(1);
								if ( (LA59_0==BANG||LA59_0==ROOT) ) {
									alt59=1;
								}
								switch (alt59) {
									case 1 :
										// org/antlr/grammar/v3/ANTLRTreePrinter.g:442:6: ast_suffix
										{
										pushFollow(FOLLOW_ast_suffix_in_atom1703);
										ast_suffix();
										state._fsp--;

										}
										break;

								}

								match(input, Token.UP, null); 
							}

							}
							break;
						case 4 :
							// org/antlr/grammar/v3/ANTLRTreePrinter.g:444:5: ^( STRING_LITERAL ( ast_suffix )? )
							{
							match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1718); 
							out(((GrammarAST)retval.start).toString());
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); 
								// org/antlr/grammar/v3/ANTLRTreePrinter.g:445:5: ( ast_suffix )?
								int alt60=2;
								int LA60_0 = input.LA(1);
								if ( (LA60_0==BANG||LA60_0==ROOT) ) {
									alt60=1;
								}
								switch (alt60) {
									case 1 :
										// org/antlr/grammar/v3/ANTLRTreePrinter.g:445:6: ast_suffix
										{
										pushFollow(FOLLOW_ast_suffix_in_atom1727);
										ast_suffix();
										state._fsp--;

										}
										break;

								}

								match(input, Token.UP, null); 
							}

							}
							break;
						case 5 :
							// org/antlr/grammar/v3/ANTLRTreePrinter.g:447:5: ^( WILDCARD ( ast_suffix )? )
							{
							match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1742); 
							out(((GrammarAST)retval.start).toString());
							if ( input.LA(1)==Token.DOWN ) {
								match(input, Token.DOWN, null); 
								// org/antlr/grammar/v3/ANTLRTreePrinter.g:448:5: ( ast_suffix )?
								int alt61=2;
								int LA61_0 = input.LA(1);
								if ( (LA61_0==BANG||LA61_0==ROOT) ) {
									alt61=1;
								}
								switch (alt61) {
									case 1 :
										// org/antlr/grammar/v3/ANTLRTreePrinter.g:448:6: ast_suffix
										{
										pushFollow(FOLLOW_ast_suffix_in_atom1752);
										ast_suffix();
										state._fsp--;

										}
										break;

								}

								match(input, Token.UP, null); 
							}

							}
							break;

					}

					out(" ");
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:452:4: LABEL
					{
					LABEL5=(GrammarAST)match(input,LABEL,FOLLOW_LABEL_in_atom1772); 
					out(" $"+(LABEL5!=null?LABEL5.getText():null));
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:453:4: ^( DOT ID atom )
					{
					match(input,DOT,FOLLOW_DOT_in_atom1781); 
					match(input, Token.DOWN, null); 
					ID6=(GrammarAST)match(input,ID,FOLLOW_ID_in_atom1783); 
					out((ID6!=null?ID6.getText():null)+".");
					pushFollow(FOLLOW_atom_in_atom1787);
					atom();
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
		return retval;
	}
	// $ANTLR end "atom"



	// $ANTLR start "ast_suffix"
	// org/antlr/grammar/v3/ANTLRTreePrinter.g:456:1: ast_suffix : ( ROOT | BANG );
	public final void ast_suffix() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ANTLRTreePrinter.g:457:2: ( ROOT | BANG )
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==ROOT) ) {
				alt64=1;
			}
			else if ( (LA64_0==BANG) ) {
				alt64=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 64, 0, input);
				throw nvae;
			}

			switch (alt64) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:457:4: ROOT
					{
					match(input,ROOT,FOLLOW_ROOT_in_ast_suffix1800); 
					out("^");
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRTreePrinter.g:458:4: BANG
					{
					match(input,BANG,FOLLOW_BANG_in_ast_suffix1807); 
					out("!");
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
	// $ANTLR end "ast_suffix"

	// Delegated rules



	public static final BitSet FOLLOW_grammar__in_toString73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_toString79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alternative_in_toString85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_in_toString91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_single_rewrite_in_toString97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_in_toString103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EOR_in_toString109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEXER_GRAMMAR_in_grammar_133 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_135 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARSER_GRAMMAR_in_grammar_145 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_147 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammar_157 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_159 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMBINED_GRAMMAR_in_grammar_169 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_grammarSpec_in_grammar_171 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SCOPE_in_attrScope187 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_attrScope189 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_ruleAction_in_attrScope191 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_ACTION_in_attrScope194 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_grammarSpec210 = new BitSet(new long[]{0x0400200008000200L,0x0000000020028002L});
	public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec219 = new BitSet(new long[]{0x0400200000000200L,0x0000000020028002L});
	public static final BitSet FOLLOW_optionsSpec_in_grammarSpec229 = new BitSet(new long[]{0x0000200000000200L,0x0000000020028002L});
	public static final BitSet FOLLOW_delegateGrammars_in_grammarSpec238 = new BitSet(new long[]{0x0000000000000200L,0x0000000020028002L});
	public static final BitSet FOLLOW_tokensSpec_in_grammarSpec245 = new BitSet(new long[]{0x0000000000000200L,0x0000000000028002L});
	public static final BitSet FOLLOW_attrScope_in_grammarSpec252 = new BitSet(new long[]{0x0000000000000200L,0x0000000000028002L});
	public static final BitSet FOLLOW_actions_in_grammarSpec259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008002L});
	public static final BitSet FOLLOW_rules_in_grammarSpec265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actions278 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AMPERSAND_in_action299 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_action303 = new BitSet(new long[]{0x0000080000000010L});
	public static final BitSet FOLLOW_ID_in_action312 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_action316 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ACTION_in_action331 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OPTIONS_in_optionsSpec363 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_option_in_optionsSpec371 = new BitSet(new long[]{0x0000000000002008L});
	public static final BitSet FOLLOW_ASSIGN_in_option397 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_option401 = new BitSet(new long[]{0x0000880000040000L,0x0000000001000000L});
	public static final BitSet FOLLOW_optionValue_in_option405 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_optionValue420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_optionValue440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_optionValue449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_optionValue460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_delegateGrammars490 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ASSIGN_in_delegateGrammars495 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_delegateGrammars497 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_ID_in_delegateGrammars499 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_delegateGrammars504 = new BitSet(new long[]{0x0000080000002008L});
	public static final BitSet FOLLOW_TOKENS_in_tokensSpec521 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_tokenSpec_in_tokensSpec523 = new BitSet(new long[]{0x0000000000002008L,0x0000000040000000L});
	public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_tokenSpec543 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec545 = new BitSet(new long[]{0x0000000000040000L,0x0000000001000000L});
	public static final BitSet FOLLOW_set_in_tokenSpec547 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rule_in_rules566 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008002L});
	public static final BitSet FOLLOW_precRule_in_rules570 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008002L});
	public static final BitSet FOLLOW_RULE_in_rule586 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule590 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
	public static final BitSet FOLLOW_modifier_in_rule596 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ARG_in_rule609 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule614 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RET_in_rule627 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule632 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_throwsSpec_in_rule645 = new BitSet(new long[]{0x0400000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_optionsSpec_in_rule653 = new BitSet(new long[]{0x0000000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_rule661 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_ruleAction_in_rule669 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_block_in_rule688 = new BitSet(new long[]{0x0000004400020000L});
	public static final BitSet FOLLOW_exceptionGroup_in_rule695 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_EOR_in_rule702 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PREC_RULE_in_precRule721 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_precRule725 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
	public static final BitSet FOLLOW_modifier_in_precRule731 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ARG_in_precRule744 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_precRule749 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RET_in_precRule762 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_precRule767 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_throwsSpec_in_precRule780 = new BitSet(new long[]{0x0400000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_optionsSpec_in_precRule788 = new BitSet(new long[]{0x0000000000010200L,0x0000000000020000L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_precRule796 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_ruleAction_in_precRule804 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_block_in_precRule823 = new BitSet(new long[]{0x0000004400020000L});
	public static final BitSet FOLLOW_exceptionGroup_in_precRule830 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_EOR_in_precRule837 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AMPERSAND_in_ruleAction855 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_ruleAction859 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_ruleAction863 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_THROWS_in_throwsSpec912 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_throwsSpec914 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec929 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ruleAction_in_ruleScopeSpec931 = new BitSet(new long[]{0x0000080000000218L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec935 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_ID_in_ruleScopeSpec941 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block965 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_optionsSpec_in_block976 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_alternative_in_block986 = new BitSet(new long[]{0x0000000200000100L,0x0000000000001000L});
	public static final BitSet FOLLOW_rewrite_in_block988 = new BitSet(new long[]{0x0000000200000100L});
	public static final BitSet FOLLOW_alternative_in_block994 = new BitSet(new long[]{0x0000000200000100L,0x0000000000001000L});
	public static final BitSet FOLLOW_rewrite_in_block996 = new BitSet(new long[]{0x0000000200000100L});
	public static final BitSet FOLLOW_EOB_in_block1004 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ALT_in_alternative1026 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_alternative1028 = new BitSet(new long[]{0x82810289202DE010L,0x0000000547092041L});
	public static final BitSet FOLLOW_EOA_in_alternative1031 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1046 = new BitSet(new long[]{0x0000004000020002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1059 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CATCH_in_exceptionHandler1071 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1073 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_exceptionHandler1075 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FINALLY_in_finallyClause1088 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ACTION_in_finallyClause1090 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REWRITES_in_rewrite1103 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_single_rewrite_in_rewrite1105 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000800L});
	public static final BitSet FOLLOW_REWRITES_in_rewrite1112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REWRITE_in_single_rewrite1128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_SEMPRED_in_single_rewrite1137 = new BitSet(new long[]{0x0000002000000110L,0x0000000008000000L});
	public static final BitSet FOLLOW_alternative_in_single_rewrite1152 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rewrite_template_in_single_rewrite1159 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ETC_in_single_rewrite1166 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ACTION_in_single_rewrite1175 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template1199 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rewrite_template1208 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template1219 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ARGLIST_in_rewrite_template1233 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_in_rewrite_template1249 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rewrite_template1253 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template1265 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template1301 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template1310 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ROOT_in_element1334 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element1336 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BANG_in_element1345 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element1347 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_atom_in_element1355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_element1361 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_element1365 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RANGE_in_element1372 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_atom_in_element1374 = new BitSet(new long[]{0x0001000020040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_element1378 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_RANGE_in_element1385 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_atom_in_element1387 = new BitSet(new long[]{0x0001000020040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_element1391 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_element1398 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element1402 = new BitSet(new long[]{0x82810288202DE010L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_element1406 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_ASSIGN_in_element1413 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_element1417 = new BitSet(new long[]{0x82810288202DE010L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_element1421 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ebnf_in_element1427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tree__in_element1432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYNPRED_in_element1439 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_element1441 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ACTION_in_element1453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FORCED_ACTION_in_element1463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMPRED_in_element1473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYN_SEMPRED_in_element1484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element1494 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_GATED_SEMPRED_in_element1506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EPSILON_in_element1515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_ebnf1526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_ebnf1536 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1538 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CLOSURE_in_ebnf1550 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1552 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1565 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ebnf1567 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1584 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_element_in_tree_1588 = new BitSet(new long[]{0x82810288202DE018L,0x0000000547092041L});
	public static final BitSet FOLLOW_element_in_tree_1591 = new BitSet(new long[]{0x82810288202DE018L,0x0000000547092041L});
	public static final BitSet FOLLOW_RULE_REF_in_atom1617 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1629 = new BitSet(new long[]{0x0000000000008008L,0x0000000000002000L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1640 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_REF_in_atom1655 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1667 = new BitSet(new long[]{0x0000000000008008L,0x0000000000002000L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1679 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1694 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1703 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_atom1718 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1727 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WILDCARD_in_atom1742 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ast_suffix_in_atom1752 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LABEL_in_atom1772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_atom1781 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_atom1783 = new BitSet(new long[]{0x0001000020040000L,0x0000000441010000L});
	public static final BitSet FOLLOW_atom_in_atom1787 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ROOT_in_ast_suffix1800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_ast_suffix1807 = new BitSet(new long[]{0x0000000000000002L});
}
