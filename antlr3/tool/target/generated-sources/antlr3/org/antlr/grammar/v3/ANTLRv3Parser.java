// $ANTLR 3.5 org/antlr/grammar/v3/ANTLRv3.g 2017-06-11 18:42:19

    package org.antlr.grammar.v3;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


/** ANTLR v3 grammar written in ANTLR v3 with AST construction */
@SuppressWarnings("all")
public class ANTLRv3Parser extends Parser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ANTLRv3Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ANTLRv3Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ANTLRv3Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/ANTLRv3.g"; }


		int gtype;


	public static class grammarDef_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "grammarDef"
	// org/antlr/grammar/v3/ANTLRv3.g:93:1: grammarDef : ( DOC_COMMENT )? ( 'lexer' | 'parser' | 'tree' |) g= 'grammar' id ';' ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ EOF -> ^( id ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ ) ;
	public final ANTLRv3Parser.grammarDef_return grammarDef() throws RecognitionException {
		ANTLRv3Parser.grammarDef_return retval = new ANTLRv3Parser.grammarDef_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token g=null;
		Token DOC_COMMENT1=null;
		Token string_literal2=null;
		Token string_literal3=null;
		Token string_literal4=null;
		Token char_literal6=null;
		Token EOF12=null;
		ParserRuleReturnScope id5 =null;
		ParserRuleReturnScope optionsSpec7 =null;
		ParserRuleReturnScope tokensSpec8 =null;
		ParserRuleReturnScope attrScope9 =null;
		ParserRuleReturnScope action10 =null;
		ParserRuleReturnScope rule11 =null;

		CommonTree g_tree=null;
		CommonTree DOC_COMMENT1_tree=null;
		CommonTree string_literal2_tree=null;
		CommonTree string_literal3_tree=null;
		CommonTree string_literal4_tree=null;
		CommonTree char_literal6_tree=null;
		CommonTree EOF12_tree=null;
		RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
		RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
		RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_attrScope=new RewriteRuleSubtreeStream(adaptor,"rule attrScope");
		RewriteRuleSubtreeStream stream_tokensSpec=new RewriteRuleSubtreeStream(adaptor,"rule tokensSpec");
		RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
		RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
		RewriteRuleSubtreeStream stream_rule=new RewriteRuleSubtreeStream(adaptor,"rule rule");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:94:5: ( ( DOC_COMMENT )? ( 'lexer' | 'parser' | 'tree' |) g= 'grammar' id ';' ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ EOF -> ^( id ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ ) )
			// org/antlr/grammar/v3/ANTLRv3.g:94:9: ( DOC_COMMENT )? ( 'lexer' | 'parser' | 'tree' |) g= 'grammar' id ';' ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ EOF
			{
			// org/antlr/grammar/v3/ANTLRv3.g:94:9: ( DOC_COMMENT )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==DOC_COMMENT) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:94:9: DOC_COMMENT
					{
					DOC_COMMENT1=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarDef373); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOC_COMMENT.add(DOC_COMMENT1);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:95:6: ( 'lexer' | 'parser' | 'tree' |)
			int alt2=4;
			switch ( input.LA(1) ) {
			case 84:
				{
				alt2=1;
				}
				break;
			case 85:
				{
				alt2=2;
				}
				break;
			case 90:
				{
				alt2=3;
				}
				break;
			case 83:
				{
				alt2=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:95:8: 'lexer'
					{
					string_literal2=(Token)match(input,84,FOLLOW_84_in_grammarDef383); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_84.add(string_literal2);

					if ( state.backtracking==0 ) {gtype=LEXER_GRAMMAR;}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:96:10: 'parser'
					{
					string_literal3=(Token)match(input,85,FOLLOW_85_in_grammarDef401); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_85.add(string_literal3);

					if ( state.backtracking==0 ) {gtype=PARSER_GRAMMAR;}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:97:10: 'tree'
					{
					string_literal4=(Token)match(input,90,FOLLOW_90_in_grammarDef417); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_90.add(string_literal4);

					if ( state.backtracking==0 ) {gtype=TREE_GRAMMAR;}
					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:98:14: 
					{
					if ( state.backtracking==0 ) {gtype=COMBINED_GRAMMAR;}
					}
					break;

			}

			g=(Token)match(input,83,FOLLOW_83_in_grammarDef458); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_83.add(g);

			pushFollow(FOLLOW_id_in_grammarDef460);
			id5=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id5.getTree());
			char_literal6=(Token)match(input,76,FOLLOW_76_in_grammarDef462); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(char_literal6);

			// org/antlr/grammar/v3/ANTLRv3.g:100:25: ( optionsSpec )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==OPTIONS) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:100:25: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_grammarDef464);
					optionsSpec7=optionsSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_optionsSpec.add(optionsSpec7.getTree());
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:100:38: ( tokensSpec )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==TOKENS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:100:38: tokensSpec
					{
					pushFollow(FOLLOW_tokensSpec_in_grammarDef467);
					tokensSpec8=tokensSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tokensSpec.add(tokensSpec8.getTree());
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:100:50: ( attrScope )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==SCOPE) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:100:50: attrScope
					{
					pushFollow(FOLLOW_attrScope_in_grammarDef470);
					attrScope9=attrScope();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_attrScope.add(attrScope9.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			// org/antlr/grammar/v3/ANTLRv3.g:100:61: ( action )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==AT) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:100:61: action
					{
					pushFollow(FOLLOW_action_in_grammarDef473);
					action10=action();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_action.add(action10.getTree());
					}
					break;

				default :
					break loop6;
				}
			}

			// org/antlr/grammar/v3/ANTLRv3.g:101:6: ( rule )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==DOC_COMMENT||LA7_0==FRAGMENT||LA7_0==RULE_REF||LA7_0==TOKEN_REF||(LA7_0 >= 86 && LA7_0 <= 88)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:101:6: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef481);
					rule11=rule();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rule.add(rule11.getTree());
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			EOF12=(Token)match(input,EOF,FOLLOW_EOF_in_grammarDef489); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF12);

			// AST REWRITE
			// elements: rule, optionsSpec, id, DOC_COMMENT, attrScope, action, tokensSpec
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 103:6: -> ^( id ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:103:9: ^( id ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(gtype,g), root_1);
				adaptor.addChild(root_1, stream_id.nextTree());
				// org/antlr/grammar/v3/ANTLRv3.g:104:12: ( DOC_COMMENT )?
				if ( stream_DOC_COMMENT.hasNext() ) {
					adaptor.addChild(root_1, stream_DOC_COMMENT.nextNode());
				}
				stream_DOC_COMMENT.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:104:25: ( optionsSpec )?
				if ( stream_optionsSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_optionsSpec.nextTree());
				}
				stream_optionsSpec.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:104:38: ( tokensSpec )?
				if ( stream_tokensSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_tokensSpec.nextTree());
				}
				stream_tokensSpec.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:104:50: ( attrScope )*
				while ( stream_attrScope.hasNext() ) {
					adaptor.addChild(root_1, stream_attrScope.nextTree());
				}
				stream_attrScope.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:104:61: ( action )*
				while ( stream_action.hasNext() ) {
					adaptor.addChild(root_1, stream_action.nextTree());
				}
				stream_action.reset();

				if ( !(stream_rule.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_rule.hasNext() ) {
					adaptor.addChild(root_1, stream_rule.nextTree());
				}
				stream_rule.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "grammarDef"


	public static class tokensSpec_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tokensSpec"
	// org/antlr/grammar/v3/ANTLRv3.g:108:1: tokensSpec : TOKENS ( tokenSpec )+ '}' -> ^( TOKENS ( tokenSpec )+ ) ;
	public final ANTLRv3Parser.tokensSpec_return tokensSpec() throws RecognitionException {
		ANTLRv3Parser.tokensSpec_return retval = new ANTLRv3Parser.tokensSpec_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TOKENS13=null;
		Token char_literal15=null;
		ParserRuleReturnScope tokenSpec14 =null;

		CommonTree TOKENS13_tree=null;
		CommonTree char_literal15_tree=null;
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_TOKENS=new RewriteRuleTokenStream(adaptor,"token TOKENS");
		RewriteRuleSubtreeStream stream_tokenSpec=new RewriteRuleSubtreeStream(adaptor,"rule tokenSpec");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:109:2: ( TOKENS ( tokenSpec )+ '}' -> ^( TOKENS ( tokenSpec )+ ) )
			// org/antlr/grammar/v3/ANTLRv3.g:109:4: TOKENS ( tokenSpec )+ '}'
			{
			TOKENS13=(Token)match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec550); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TOKENS.add(TOKENS13);

			// org/antlr/grammar/v3/ANTLRv3.g:109:11: ( tokenSpec )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==TOKEN_REF) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:109:11: tokenSpec
					{
					pushFollow(FOLLOW_tokenSpec_in_tokensSpec552);
					tokenSpec14=tokenSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tokenSpec.add(tokenSpec14.getTree());
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

			char_literal15=(Token)match(input,92,FOLLOW_92_in_tokensSpec555); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_92.add(char_literal15);

			// AST REWRITE
			// elements: TOKENS, tokenSpec
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 109:26: -> ^( TOKENS ( tokenSpec )+ )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:109:29: ^( TOKENS ( tokenSpec )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_TOKENS.nextNode(), root_1);
				if ( !(stream_tokenSpec.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_tokenSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_tokenSpec.nextTree());
				}
				stream_tokenSpec.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tokensSpec"


	public static class tokenSpec_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tokenSpec"
	// org/antlr/grammar/v3/ANTLRv3.g:112:1: tokenSpec : TOKEN_REF ( '=' (lit= STRING_LITERAL |lit= CHAR_LITERAL ) -> ^( '=' TOKEN_REF $lit) | -> TOKEN_REF ) ';' ;
	public final ANTLRv3Parser.tokenSpec_return tokenSpec() throws RecognitionException {
		ANTLRv3Parser.tokenSpec_return retval = new ANTLRv3Parser.tokenSpec_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token lit=null;
		Token TOKEN_REF16=null;
		Token char_literal17=null;
		Token char_literal18=null;

		CommonTree lit_tree=null;
		CommonTree TOKEN_REF16_tree=null;
		CommonTree char_literal17_tree=null;
		CommonTree char_literal18_tree=null;
		RewriteRuleTokenStream stream_LABEL_ASSIGN=new RewriteRuleTokenStream(adaptor,"token LABEL_ASSIGN");
		RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
		RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
		RewriteRuleTokenStream stream_CHAR_LITERAL=new RewriteRuleTokenStream(adaptor,"token CHAR_LITERAL");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:113:2: ( TOKEN_REF ( '=' (lit= STRING_LITERAL |lit= CHAR_LITERAL ) -> ^( '=' TOKEN_REF $lit) | -> TOKEN_REF ) ';' )
			// org/antlr/grammar/v3/ANTLRv3.g:113:4: TOKEN_REF ( '=' (lit= STRING_LITERAL |lit= CHAR_LITERAL ) -> ^( '=' TOKEN_REF $lit) | -> TOKEN_REF ) ';'
			{
			TOKEN_REF16=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec575); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF16);

			// org/antlr/grammar/v3/ANTLRv3.g:114:3: ( '=' (lit= STRING_LITERAL |lit= CHAR_LITERAL ) -> ^( '=' TOKEN_REF $lit) | -> TOKEN_REF )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==LABEL_ASSIGN) ) {
				alt10=1;
			}
			else if ( (LA10_0==76) ) {
				alt10=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:114:5: '=' (lit= STRING_LITERAL |lit= CHAR_LITERAL )
					{
					char_literal17=(Token)match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_tokenSpec581); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LABEL_ASSIGN.add(char_literal17);

					// org/antlr/grammar/v3/ANTLRv3.g:114:9: (lit= STRING_LITERAL |lit= CHAR_LITERAL )
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==STRING_LITERAL) ) {
						alt9=1;
					}
					else if ( (LA9_0==CHAR_LITERAL) ) {
						alt9=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}

					switch (alt9) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:114:10: lit= STRING_LITERAL
							{
							lit=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenSpec586); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_STRING_LITERAL.add(lit);

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:114:29: lit= CHAR_LITERAL
							{
							lit=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_tokenSpec590); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(lit);

							}
							break;

					}

					// AST REWRITE
					// elements: LABEL_ASSIGN, lit, TOKEN_REF
					// token labels: lit
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_lit=new RewriteRuleTokenStream(adaptor,"token lit",lit);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 114:47: -> ^( '=' TOKEN_REF $lit)
					{
						// org/antlr/grammar/v3/ANTLRv3.g:114:50: ^( '=' TOKEN_REF $lit)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_LABEL_ASSIGN.nextNode(), root_1);
						adaptor.addChild(root_1, stream_TOKEN_REF.nextNode());
						adaptor.addChild(root_1, stream_lit.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:115:16: 
					{
					// AST REWRITE
					// elements: TOKEN_REF
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 115:16: -> TOKEN_REF
					{
						adaptor.addChild(root_0, stream_TOKEN_REF.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			char_literal18=(Token)match(input,76,FOLLOW_76_in_tokenSpec629); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(char_literal18);

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tokenSpec"


	public static class attrScope_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "attrScope"
	// org/antlr/grammar/v3/ANTLRv3.g:120:1: attrScope : 'scope' id ACTION -> ^( 'scope' id ACTION ) ;
	public final ANTLRv3Parser.attrScope_return attrScope() throws RecognitionException {
		ANTLRv3Parser.attrScope_return retval = new ANTLRv3Parser.attrScope_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal19=null;
		Token ACTION21=null;
		ParserRuleReturnScope id20 =null;

		CommonTree string_literal19_tree=null;
		CommonTree ACTION21_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_SCOPE=new RewriteRuleTokenStream(adaptor,"token SCOPE");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:121:2: ( 'scope' id ACTION -> ^( 'scope' id ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3.g:121:4: 'scope' id ACTION
			{
			string_literal19=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_attrScope640); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SCOPE.add(string_literal19);

			pushFollow(FOLLOW_id_in_attrScope642);
			id20=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id20.getTree());
			ACTION21=(Token)match(input,ACTION,FOLLOW_ACTION_in_attrScope644); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION21);

			// AST REWRITE
			// elements: ACTION, SCOPE, id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 121:22: -> ^( 'scope' id ACTION )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:121:25: ^( 'scope' id ACTION )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_SCOPE.nextNode(), root_1);
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "attrScope"


	public static class action_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "action"
	// org/antlr/grammar/v3/ANTLRv3.g:125:1: action : '@' ( actionScopeName '::' )? id ACTION -> ^( '@' ( actionScopeName )? id ACTION ) ;
	public final ANTLRv3Parser.action_return action() throws RecognitionException {
		ANTLRv3Parser.action_return retval = new ANTLRv3Parser.action_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal22=null;
		Token string_literal24=null;
		Token ACTION26=null;
		ParserRuleReturnScope actionScopeName23 =null;
		ParserRuleReturnScope id25 =null;

		CommonTree char_literal22_tree=null;
		CommonTree string_literal24_tree=null;
		CommonTree ACTION26_tree=null;
		RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
		RewriteRuleSubtreeStream stream_actionScopeName=new RewriteRuleSubtreeStream(adaptor,"rule actionScopeName");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:126:2: ( '@' ( actionScopeName '::' )? id ACTION -> ^( '@' ( actionScopeName )? id ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3.g:126:4: '@' ( actionScopeName '::' )? id ACTION
			{
			char_literal22=(Token)match(input,AT,FOLLOW_AT_in_action667); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_AT.add(char_literal22);

			// org/antlr/grammar/v3/ANTLRv3.g:126:8: ( actionScopeName '::' )?
			int alt11=2;
			switch ( input.LA(1) ) {
				case TOKEN_REF:
					{
					int LA11_1 = input.LA(2);
					if ( (LA11_1==75) ) {
						alt11=1;
					}
					}
					break;
				case RULE_REF:
					{
					int LA11_2 = input.LA(2);
					if ( (LA11_2==75) ) {
						alt11=1;
					}
					}
					break;
				case 84:
				case 85:
					{
					alt11=1;
					}
					break;
			}
			switch (alt11) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:126:9: actionScopeName '::'
					{
					pushFollow(FOLLOW_actionScopeName_in_action670);
					actionScopeName23=actionScopeName();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_actionScopeName.add(actionScopeName23.getTree());
					string_literal24=(Token)match(input,75,FOLLOW_75_in_action672); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_75.add(string_literal24);

					}
					break;

			}

			pushFollow(FOLLOW_id_in_action676);
			id25=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id25.getTree());
			ACTION26=(Token)match(input,ACTION,FOLLOW_ACTION_in_action678); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION26);

			// AST REWRITE
			// elements: id, AT, actionScopeName, ACTION
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 126:42: -> ^( '@' ( actionScopeName )? id ACTION )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:126:45: ^( '@' ( actionScopeName )? id ACTION )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_AT.nextNode(), root_1);
				// org/antlr/grammar/v3/ANTLRv3.g:126:51: ( actionScopeName )?
				if ( stream_actionScopeName.hasNext() ) {
					adaptor.addChild(root_1, stream_actionScopeName.nextTree());
				}
				stream_actionScopeName.reset();

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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "action"


	public static class actionScopeName_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actionScopeName"
	// org/antlr/grammar/v3/ANTLRv3.g:132:1: actionScopeName : ( id |l= 'lexer' -> ID[$l] |p= 'parser' -> ID[$p] );
	public final ANTLRv3Parser.actionScopeName_return actionScopeName() throws RecognitionException {
		ANTLRv3Parser.actionScopeName_return retval = new ANTLRv3Parser.actionScopeName_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token l=null;
		Token p=null;
		ParserRuleReturnScope id27 =null;

		CommonTree l_tree=null;
		CommonTree p_tree=null;
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:133:2: ( id |l= 'lexer' -> ID[$l] |p= 'parser' -> ID[$p] )
			int alt12=3;
			switch ( input.LA(1) ) {
			case RULE_REF:
			case TOKEN_REF:
				{
				alt12=1;
				}
				break;
			case 84:
				{
				alt12=2;
				}
				break;
			case 85:
				{
				alt12=3;
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
					// org/antlr/grammar/v3/ANTLRv3.g:133:4: id
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_id_in_actionScopeName704);
					id27=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id27.getTree());

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:134:4: l= 'lexer'
					{
					l=(Token)match(input,84,FOLLOW_84_in_actionScopeName711); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_84.add(l);

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

					root_0 = (CommonTree)adaptor.nil();
					// 134:14: -> ID[$l]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ID, l));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:135:9: p= 'parser'
					{
					p=(Token)match(input,85,FOLLOW_85_in_actionScopeName728); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_85.add(p);

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

					root_0 = (CommonTree)adaptor.nil();
					// 135:20: -> ID[$p]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ID, p));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "actionScopeName"


	public static class optionsSpec_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "optionsSpec"
	// org/antlr/grammar/v3/ANTLRv3.g:138:1: optionsSpec : OPTIONS ( option ';' )+ '}' -> ^( OPTIONS ( option )+ ) ;
	public final ANTLRv3Parser.optionsSpec_return optionsSpec() throws RecognitionException {
		ANTLRv3Parser.optionsSpec_return retval = new ANTLRv3Parser.optionsSpec_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OPTIONS28=null;
		Token char_literal30=null;
		Token char_literal31=null;
		ParserRuleReturnScope option29 =null;

		CommonTree OPTIONS28_tree=null;
		CommonTree char_literal30_tree=null;
		CommonTree char_literal31_tree=null;
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_OPTIONS=new RewriteRuleTokenStream(adaptor,"token OPTIONS");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_option=new RewriteRuleSubtreeStream(adaptor,"rule option");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:139:2: ( OPTIONS ( option ';' )+ '}' -> ^( OPTIONS ( option )+ ) )
			// org/antlr/grammar/v3/ANTLRv3.g:139:4: OPTIONS ( option ';' )+ '}'
			{
			OPTIONS28=(Token)match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec744); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_OPTIONS.add(OPTIONS28);

			// org/antlr/grammar/v3/ANTLRv3.g:139:12: ( option ';' )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==RULE_REF||LA13_0==TOKEN_REF) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:139:13: option ';'
					{
					pushFollow(FOLLOW_option_in_optionsSpec747);
					option29=option();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_option.add(option29.getTree());
					char_literal30=(Token)match(input,76,FOLLOW_76_in_optionsSpec749); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_76.add(char_literal30);

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			char_literal31=(Token)match(input,92,FOLLOW_92_in_optionsSpec753); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_92.add(char_literal31);

			// AST REWRITE
			// elements: option, OPTIONS
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 139:30: -> ^( OPTIONS ( option )+ )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:139:33: ^( OPTIONS ( option )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_OPTIONS.nextNode(), root_1);
				if ( !(stream_option.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_option.hasNext() ) {
					adaptor.addChild(root_1, stream_option.nextTree());
				}
				stream_option.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "optionsSpec"


	public static class option_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "option"
	// org/antlr/grammar/v3/ANTLRv3.g:142:1: option : id '=' optionValue -> ^( '=' id optionValue ) ;
	public final ANTLRv3Parser.option_return option() throws RecognitionException {
		ANTLRv3Parser.option_return retval = new ANTLRv3Parser.option_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal33=null;
		ParserRuleReturnScope id32 =null;
		ParserRuleReturnScope optionValue34 =null;

		CommonTree char_literal33_tree=null;
		RewriteRuleTokenStream stream_LABEL_ASSIGN=new RewriteRuleTokenStream(adaptor,"token LABEL_ASSIGN");
		RewriteRuleSubtreeStream stream_optionValue=new RewriteRuleSubtreeStream(adaptor,"rule optionValue");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:143:5: ( id '=' optionValue -> ^( '=' id optionValue ) )
			// org/antlr/grammar/v3/ANTLRv3.g:143:9: id '=' optionValue
			{
			pushFollow(FOLLOW_id_in_option778);
			id32=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id32.getTree());
			char_literal33=(Token)match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_option780); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LABEL_ASSIGN.add(char_literal33);

			pushFollow(FOLLOW_optionValue_in_option782);
			optionValue34=optionValue();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optionValue.add(optionValue34.getTree());
			// AST REWRITE
			// elements: LABEL_ASSIGN, id, optionValue
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 143:28: -> ^( '=' id optionValue )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:143:31: ^( '=' id optionValue )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_LABEL_ASSIGN.nextNode(), root_1);
				adaptor.addChild(root_1, stream_id.nextTree());
				adaptor.addChild(root_1, stream_optionValue.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "option"


	public static class optionValue_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "optionValue"
	// org/antlr/grammar/v3/ANTLRv3.g:146:1: optionValue : ( qid | STRING_LITERAL | CHAR_LITERAL | INT |s= '*' -> STRING_LITERAL[$s] );
	public final ANTLRv3Parser.optionValue_return optionValue() throws RecognitionException {
		ANTLRv3Parser.optionValue_return retval = new ANTLRv3Parser.optionValue_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token STRING_LITERAL36=null;
		Token CHAR_LITERAL37=null;
		Token INT38=null;
		ParserRuleReturnScope qid35 =null;

		CommonTree s_tree=null;
		CommonTree STRING_LITERAL36_tree=null;
		CommonTree CHAR_LITERAL37_tree=null;
		CommonTree INT38_tree=null;
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:147:5: ( qid | STRING_LITERAL | CHAR_LITERAL | INT |s= '*' -> STRING_LITERAL[$s] )
			int alt14=5;
			switch ( input.LA(1) ) {
			case RULE_REF:
			case TOKEN_REF:
				{
				alt14=1;
				}
				break;
			case STRING_LITERAL:
				{
				alt14=2;
				}
				break;
			case CHAR_LITERAL:
				{
				alt14=3;
				}
				break;
			case INT:
				{
				alt14=4;
				}
				break;
			case 70:
				{
				alt14=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:147:9: qid
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_qid_in_optionValue811);
					qid35=qid();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qid35.getTree());

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:148:9: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL36=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_optionValue821); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL36_tree = (CommonTree)adaptor.create(STRING_LITERAL36);
					adaptor.addChild(root_0, STRING_LITERAL36_tree);
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:149:9: CHAR_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					CHAR_LITERAL37=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_optionValue831); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHAR_LITERAL37_tree = (CommonTree)adaptor.create(CHAR_LITERAL37);
					adaptor.addChild(root_0, CHAR_LITERAL37_tree);
					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:150:9: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					INT38=(Token)match(input,INT,FOLLOW_INT_in_optionValue841); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT38_tree = (CommonTree)adaptor.create(INT38);
					adaptor.addChild(root_0, INT38_tree);
					}

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRv3.g:151:7: s= '*'
					{
					s=(Token)match(input,70,FOLLOW_70_in_optionValue851); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(s);

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

					root_0 = (CommonTree)adaptor.nil();
					// 151:13: -> STRING_LITERAL[$s]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(STRING_LITERAL, s));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "optionValue"


	protected static class rule_scope {
		String name;
	}
	protected Stack<rule_scope> rule_stack = new Stack<rule_scope>();

	public static class rule_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rule"
	// org/antlr/grammar/v3/ANTLRv3.g:154:1: rule : ( DOC_COMMENT )? (modifier= ( 'protected' | 'public' | 'private' | 'fragment' ) )? id ( '!' )? (arg= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* ':' altList ';' ( exceptionGroup )? -> ^( RULE id ( ^( ARG[$arg] $arg) )? ( ^( 'returns' $rt) )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR[\"EOR\"] ) ;
	public final ANTLRv3Parser.rule_return rule() throws RecognitionException {
		rule_stack.push(new rule_scope());
		ANTLRv3Parser.rule_return retval = new ANTLRv3Parser.rule_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token modifier=null;
		Token arg=null;
		Token rt=null;
		Token DOC_COMMENT39=null;
		Token char_literal41=null;
		Token string_literal42=null;
		Token char_literal47=null;
		Token char_literal49=null;
		ParserRuleReturnScope id40 =null;
		ParserRuleReturnScope throwsSpec43 =null;
		ParserRuleReturnScope optionsSpec44 =null;
		ParserRuleReturnScope ruleScopeSpec45 =null;
		ParserRuleReturnScope ruleAction46 =null;
		ParserRuleReturnScope altList48 =null;
		ParserRuleReturnScope exceptionGroup50 =null;

		CommonTree modifier_tree=null;
		CommonTree arg_tree=null;
		CommonTree rt_tree=null;
		CommonTree DOC_COMMENT39_tree=null;
		CommonTree char_literal41_tree=null;
		CommonTree string_literal42_tree=null;
		CommonTree char_literal47_tree=null;
		CommonTree char_literal49_tree=null;
		RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
		RewriteRuleTokenStream stream_RET=new RewriteRuleTokenStream(adaptor,"token RET");
		RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
		RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");
		RewriteRuleTokenStream stream_FRAGMENT=new RewriteRuleTokenStream(adaptor,"token FRAGMENT");
		RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_ruleAction=new RewriteRuleSubtreeStream(adaptor,"rule ruleAction");
		RewriteRuleSubtreeStream stream_throwsSpec=new RewriteRuleSubtreeStream(adaptor,"rule throwsSpec");
		RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
		RewriteRuleSubtreeStream stream_altList=new RewriteRuleSubtreeStream(adaptor,"rule altList");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
		RewriteRuleSubtreeStream stream_ruleScopeSpec=new RewriteRuleSubtreeStream(adaptor,"rule ruleScopeSpec");
		RewriteRuleSubtreeStream stream_exceptionGroup=new RewriteRuleSubtreeStream(adaptor,"rule exceptionGroup");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:158:2: ( ( DOC_COMMENT )? (modifier= ( 'protected' | 'public' | 'private' | 'fragment' ) )? id ( '!' )? (arg= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* ':' altList ';' ( exceptionGroup )? -> ^( RULE id ( ^( ARG[$arg] $arg) )? ( ^( 'returns' $rt) )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR[\"EOR\"] ) )
			// org/antlr/grammar/v3/ANTLRv3.g:158:4: ( DOC_COMMENT )? (modifier= ( 'protected' | 'public' | 'private' | 'fragment' ) )? id ( '!' )? (arg= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* ':' altList ';' ( exceptionGroup )?
			{
			// org/antlr/grammar/v3/ANTLRv3.g:158:4: ( DOC_COMMENT )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==DOC_COMMENT) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:158:4: DOC_COMMENT
					{
					DOC_COMMENT39=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_rule876); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOC_COMMENT.add(DOC_COMMENT39);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:159:3: (modifier= ( 'protected' | 'public' | 'private' | 'fragment' ) )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==FRAGMENT||(LA17_0 >= 86 && LA17_0 <= 88)) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:159:5: modifier= ( 'protected' | 'public' | 'private' | 'fragment' )
					{
					// org/antlr/grammar/v3/ANTLRv3.g:159:14: ( 'protected' | 'public' | 'private' | 'fragment' )
					int alt16=4;
					switch ( input.LA(1) ) {
					case 87:
						{
						alt16=1;
						}
						break;
					case 88:
						{
						alt16=2;
						}
						break;
					case 86:
						{
						alt16=3;
						}
						break;
					case FRAGMENT:
						{
						alt16=4;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}
					switch (alt16) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:159:15: 'protected'
							{
							modifier=(Token)match(input,87,FOLLOW_87_in_rule886); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_87.add(modifier);

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:159:27: 'public'
							{
							modifier=(Token)match(input,88,FOLLOW_88_in_rule888); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_88.add(modifier);

							}
							break;
						case 3 :
							// org/antlr/grammar/v3/ANTLRv3.g:159:36: 'private'
							{
							modifier=(Token)match(input,86,FOLLOW_86_in_rule890); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_86.add(modifier);

							}
							break;
						case 4 :
							// org/antlr/grammar/v3/ANTLRv3.g:159:46: 'fragment'
							{
							modifier=(Token)match(input,FRAGMENT,FOLLOW_FRAGMENT_in_rule892); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_FRAGMENT.add(modifier);

							}
							break;

					}

					}
					break;

			}

			pushFollow(FOLLOW_id_in_rule900);
			id40=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id40.getTree());
			if ( state.backtracking==0 ) {rule_stack.peek().name = (id40!=null?input.toString(id40.start,id40.stop):null);}
			// org/antlr/grammar/v3/ANTLRv3.g:161:3: ( '!' )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==BANG) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:161:3: '!'
					{
					char_literal41=(Token)match(input,BANG,FOLLOW_BANG_in_rule906); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BANG.add(char_literal41);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:162:3: (arg= ARG_ACTION )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==ARG_ACTION) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:162:5: arg= ARG_ACTION
					{
					arg=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule915); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARG_ACTION.add(arg);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:163:3: ( 'returns' rt= ARG_ACTION )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==RET) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:163:5: 'returns' rt= ARG_ACTION
					{
					string_literal42=(Token)match(input,RET,FOLLOW_RET_in_rule924); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RET.add(string_literal42);

					rt=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule928); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARG_ACTION.add(rt);

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:164:3: ( throwsSpec )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==89) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:164:3: throwsSpec
					{
					pushFollow(FOLLOW_throwsSpec_in_rule936);
					throwsSpec43=throwsSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_throwsSpec.add(throwsSpec43.getTree());
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:164:15: ( optionsSpec )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==OPTIONS) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:164:15: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_rule939);
					optionsSpec44=optionsSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_optionsSpec.add(optionsSpec44.getTree());
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:164:28: ( ruleScopeSpec )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==SCOPE) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:164:28: ruleScopeSpec
					{
					pushFollow(FOLLOW_ruleScopeSpec_in_rule942);
					ruleScopeSpec45=ruleScopeSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_ruleScopeSpec.add(ruleScopeSpec45.getTree());
					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:164:43: ( ruleAction )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==AT) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:164:43: ruleAction
					{
					pushFollow(FOLLOW_ruleAction_in_rule945);
					ruleAction46=ruleAction();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_ruleAction.add(ruleAction46.getTree());
					}
					break;

				default :
					break loop24;
				}
			}

			char_literal47=(Token)match(input,74,FOLLOW_74_in_rule950); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_74.add(char_literal47);

			pushFollow(FOLLOW_altList_in_rule952);
			altList48=altList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_altList.add(altList48.getTree());
			char_literal49=(Token)match(input,76,FOLLOW_76_in_rule954); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(char_literal49);

			// org/antlr/grammar/v3/ANTLRv3.g:166:3: ( exceptionGroup )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( ((LA25_0 >= 81 && LA25_0 <= 82)) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:166:3: exceptionGroup
					{
					pushFollow(FOLLOW_exceptionGroup_in_rule958);
					exceptionGroup50=exceptionGroup();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_exceptionGroup.add(exceptionGroup50.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: arg, rt, throwsSpec, exceptionGroup, ruleAction, optionsSpec, ruleScopeSpec, altList, id, RET
			// token labels: rt, arg
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_rt=new RewriteRuleTokenStream(adaptor,"token rt",rt);
			RewriteRuleTokenStream stream_arg=new RewriteRuleTokenStream(adaptor,"token arg",arg);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 167:6: -> ^( RULE id ( ^( ARG[$arg] $arg) )? ( ^( 'returns' $rt) )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR[\"EOR\"] )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:167:9: ^( RULE id ( ^( ARG[$arg] $arg) )? ( ^( 'returns' $rt) )? ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR[\"EOR\"] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_id.nextTree());
				adaptor.addChild(root_1, modifier!=null?adaptor.create(modifier):null);
				// org/antlr/grammar/v3/ANTLRv3.g:167:67: ( ^( ARG[$arg] $arg) )?
				if ( stream_arg.hasNext() ) {
					// org/antlr/grammar/v3/ANTLRv3.g:167:67: ^( ARG[$arg] $arg)
					{
					CommonTree root_2 = (CommonTree)adaptor.nil();
					root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARG, arg), root_2);
					adaptor.addChild(root_2, stream_arg.nextNode());
					adaptor.addChild(root_1, root_2);
					}

				}
				stream_arg.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:167:86: ( ^( 'returns' $rt) )?
				if ( stream_rt.hasNext()||stream_RET.hasNext() ) {
					// org/antlr/grammar/v3/ANTLRv3.g:167:86: ^( 'returns' $rt)
					{
					CommonTree root_2 = (CommonTree)adaptor.nil();
					root_2 = (CommonTree)adaptor.becomeRoot(stream_RET.nextNode(), root_2);
					adaptor.addChild(root_2, stream_rt.nextNode());
					adaptor.addChild(root_1, root_2);
					}

				}
				stream_rt.reset();
				stream_RET.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:168:9: ( throwsSpec )?
				if ( stream_throwsSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_throwsSpec.nextTree());
				}
				stream_throwsSpec.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:168:21: ( optionsSpec )?
				if ( stream_optionsSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_optionsSpec.nextTree());
				}
				stream_optionsSpec.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:168:34: ( ruleScopeSpec )?
				if ( stream_ruleScopeSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_ruleScopeSpec.nextTree());
				}
				stream_ruleScopeSpec.reset();

				// org/antlr/grammar/v3/ANTLRv3.g:168:49: ( ruleAction )*
				while ( stream_ruleAction.hasNext() ) {
					adaptor.addChild(root_1, stream_ruleAction.nextTree());
				}
				stream_ruleAction.reset();

				adaptor.addChild(root_1, stream_altList.nextTree());
				// org/antlr/grammar/v3/ANTLRv3.g:170:9: ( exceptionGroup )?
				if ( stream_exceptionGroup.hasNext() ) {
					adaptor.addChild(root_1, stream_exceptionGroup.nextTree());
				}
				stream_exceptionGroup.reset();

				adaptor.addChild(root_1, (CommonTree)adaptor.create(EOR, "EOR"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			rule_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "rule"


	public static class ruleAction_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ruleAction"
	// org/antlr/grammar/v3/ANTLRv3.g:176:1: ruleAction : '@' id ACTION -> ^( '@' id ACTION ) ;
	public final ANTLRv3Parser.ruleAction_return ruleAction() throws RecognitionException {
		ANTLRv3Parser.ruleAction_return retval = new ANTLRv3Parser.ruleAction_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal51=null;
		Token ACTION53=null;
		ParserRuleReturnScope id52 =null;

		CommonTree char_literal51_tree=null;
		CommonTree ACTION53_tree=null;
		RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:177:2: ( '@' id ACTION -> ^( '@' id ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3.g:177:4: '@' id ACTION
			{
			char_literal51=(Token)match(input,AT,FOLLOW_AT_in_ruleAction1064); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_AT.add(char_literal51);

			pushFollow(FOLLOW_id_in_ruleAction1066);
			id52=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id52.getTree());
			ACTION53=(Token)match(input,ACTION,FOLLOW_ACTION_in_ruleAction1068); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION53);

			// AST REWRITE
			// elements: id, AT, ACTION
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 177:18: -> ^( '@' id ACTION )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:177:21: ^( '@' id ACTION )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_AT.nextNode(), root_1);
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ruleAction"


	public static class throwsSpec_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "throwsSpec"
	// org/antlr/grammar/v3/ANTLRv3.g:180:1: throwsSpec : 'throws' id ( ',' id )* -> ^( 'throws' ( id )+ ) ;
	public final ANTLRv3Parser.throwsSpec_return throwsSpec() throws RecognitionException {
		ANTLRv3Parser.throwsSpec_return retval = new ANTLRv3Parser.throwsSpec_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal54=null;
		Token char_literal56=null;
		ParserRuleReturnScope id55 =null;
		ParserRuleReturnScope id57 =null;

		CommonTree string_literal54_tree=null;
		CommonTree char_literal56_tree=null;
		RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:181:2: ( 'throws' id ( ',' id )* -> ^( 'throws' ( id )+ ) )
			// org/antlr/grammar/v3/ANTLRv3.g:181:4: 'throws' id ( ',' id )*
			{
			string_literal54=(Token)match(input,89,FOLLOW_89_in_throwsSpec1089); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_89.add(string_literal54);

			pushFollow(FOLLOW_id_in_throwsSpec1091);
			id55=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id55.getTree());
			// org/antlr/grammar/v3/ANTLRv3.g:181:16: ( ',' id )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==72) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:181:18: ',' id
					{
					char_literal56=(Token)match(input,72,FOLLOW_72_in_throwsSpec1095); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal56);

					pushFollow(FOLLOW_id_in_throwsSpec1097);
					id57=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id.add(id57.getTree());
					}
					break;

				default :
					break loop26;
				}
			}

			// AST REWRITE
			// elements: id, 89
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 181:28: -> ^( 'throws' ( id )+ )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:181:31: ^( 'throws' ( id )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_89.nextNode(), root_1);
				if ( !(stream_id.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_id.hasNext() ) {
					adaptor.addChild(root_1, stream_id.nextTree());
				}
				stream_id.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "throwsSpec"


	public static class ruleScopeSpec_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ruleScopeSpec"
	// org/antlr/grammar/v3/ANTLRv3.g:184:1: ruleScopeSpec : ( 'scope' ACTION -> ^( 'scope' ACTION ) | 'scope' id ( ',' id )* ';' -> ^( 'scope' ( id )+ ) | 'scope' ACTION 'scope' id ( ',' id )* ';' -> ^( 'scope' ACTION ( id )+ ) );
	public final ANTLRv3Parser.ruleScopeSpec_return ruleScopeSpec() throws RecognitionException {
		ANTLRv3Parser.ruleScopeSpec_return retval = new ANTLRv3Parser.ruleScopeSpec_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal58=null;
		Token ACTION59=null;
		Token string_literal60=null;
		Token char_literal62=null;
		Token char_literal64=null;
		Token string_literal65=null;
		Token ACTION66=null;
		Token string_literal67=null;
		Token char_literal69=null;
		Token char_literal71=null;
		ParserRuleReturnScope id61 =null;
		ParserRuleReturnScope id63 =null;
		ParserRuleReturnScope id68 =null;
		ParserRuleReturnScope id70 =null;

		CommonTree string_literal58_tree=null;
		CommonTree ACTION59_tree=null;
		CommonTree string_literal60_tree=null;
		CommonTree char_literal62_tree=null;
		CommonTree char_literal64_tree=null;
		CommonTree string_literal65_tree=null;
		CommonTree ACTION66_tree=null;
		CommonTree string_literal67_tree=null;
		CommonTree char_literal69_tree=null;
		CommonTree char_literal71_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_SCOPE=new RewriteRuleTokenStream(adaptor,"token SCOPE");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:185:2: ( 'scope' ACTION -> ^( 'scope' ACTION ) | 'scope' id ( ',' id )* ';' -> ^( 'scope' ( id )+ ) | 'scope' ACTION 'scope' id ( ',' id )* ';' -> ^( 'scope' ACTION ( id )+ ) )
			int alt29=3;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==SCOPE) ) {
				int LA29_1 = input.LA(2);
				if ( (LA29_1==ACTION) ) {
					int LA29_2 = input.LA(3);
					if ( (LA29_2==SCOPE) ) {
						alt29=3;
					}
					else if ( (LA29_2==AT||LA29_2==74) ) {
						alt29=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 29, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA29_1==RULE_REF||LA29_1==TOKEN_REF) ) {
					alt29=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 29, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:185:4: 'scope' ACTION
					{
					string_literal58=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec1120); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCOPE.add(string_literal58);

					ACTION59=(Token)match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec1122); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ACTION.add(ACTION59);

					// AST REWRITE
					// elements: SCOPE, ACTION
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 185:19: -> ^( 'scope' ACTION )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:185:22: ^( 'scope' ACTION )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_SCOPE.nextNode(), root_1);
						adaptor.addChild(root_1, stream_ACTION.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:186:4: 'scope' id ( ',' id )* ';'
					{
					string_literal60=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec1135); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCOPE.add(string_literal60);

					pushFollow(FOLLOW_id_in_ruleScopeSpec1137);
					id61=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id.add(id61.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:186:15: ( ',' id )*
					loop27:
					while (true) {
						int alt27=2;
						int LA27_0 = input.LA(1);
						if ( (LA27_0==72) ) {
							alt27=1;
						}

						switch (alt27) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:186:16: ',' id
							{
							char_literal62=(Token)match(input,72,FOLLOW_72_in_ruleScopeSpec1140); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_72.add(char_literal62);

							pushFollow(FOLLOW_id_in_ruleScopeSpec1142);
							id63=id();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_id.add(id63.getTree());
							}
							break;

						default :
							break loop27;
						}
					}

					char_literal64=(Token)match(input,76,FOLLOW_76_in_ruleScopeSpec1146); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_76.add(char_literal64);

					// AST REWRITE
					// elements: id, SCOPE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 186:29: -> ^( 'scope' ( id )+ )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:186:32: ^( 'scope' ( id )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_SCOPE.nextNode(), root_1);
						if ( !(stream_id.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_id.hasNext() ) {
							adaptor.addChild(root_1, stream_id.nextTree());
						}
						stream_id.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:187:4: 'scope' ACTION 'scope' id ( ',' id )* ';'
					{
					string_literal65=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec1160); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCOPE.add(string_literal65);

					ACTION66=(Token)match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec1162); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ACTION.add(ACTION66);

					string_literal67=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec1166); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SCOPE.add(string_literal67);

					pushFollow(FOLLOW_id_in_ruleScopeSpec1168);
					id68=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id.add(id68.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:188:14: ( ',' id )*
					loop28:
					while (true) {
						int alt28=2;
						int LA28_0 = input.LA(1);
						if ( (LA28_0==72) ) {
							alt28=1;
						}

						switch (alt28) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:188:15: ',' id
							{
							char_literal69=(Token)match(input,72,FOLLOW_72_in_ruleScopeSpec1171); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_72.add(char_literal69);

							pushFollow(FOLLOW_id_in_ruleScopeSpec1173);
							id70=id();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_id.add(id70.getTree());
							}
							break;

						default :
							break loop28;
						}
					}

					char_literal71=(Token)match(input,76,FOLLOW_76_in_ruleScopeSpec1177); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_76.add(char_literal71);

					// AST REWRITE
					// elements: id, ACTION, SCOPE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 189:3: -> ^( 'scope' ACTION ( id )+ )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:189:6: ^( 'scope' ACTION ( id )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_SCOPE.nextNode(), root_1);
						adaptor.addChild(root_1, stream_ACTION.nextNode());
						if ( !(stream_id.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_id.hasNext() ) {
							adaptor.addChild(root_1, stream_id.nextTree());
						}
						stream_id.reset();

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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ruleScopeSpec"


	public static class block_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block"
	// org/antlr/grammar/v3/ANTLRv3.g:192:1: block : lp= '(' ( (opts= optionsSpec )? ':' )? altpair ( '|' altpair )* rp= ')' -> ^( BLOCK[$lp,\"BLOCK\"] ( optionsSpec )? ( altpair )+ EOB[$rp,\"EOB\"] ) ;
	public final ANTLRv3Parser.block_return block() throws RecognitionException {
		ANTLRv3Parser.block_return retval = new ANTLRv3Parser.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token lp=null;
		Token rp=null;
		Token char_literal72=null;
		Token char_literal74=null;
		ParserRuleReturnScope opts =null;
		ParserRuleReturnScope altpair73 =null;
		ParserRuleReturnScope altpair75 =null;

		CommonTree lp_tree=null;
		CommonTree rp_tree=null;
		CommonTree char_literal72_tree=null;
		CommonTree char_literal74_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
		RewriteRuleSubtreeStream stream_altpair=new RewriteRuleSubtreeStream(adaptor,"rule altpair");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:193:5: (lp= '(' ( (opts= optionsSpec )? ':' )? altpair ( '|' altpair )* rp= ')' -> ^( BLOCK[$lp,\"BLOCK\"] ( optionsSpec )? ( altpair )+ EOB[$rp,\"EOB\"] ) )
			// org/antlr/grammar/v3/ANTLRv3.g:193:9: lp= '(' ( (opts= optionsSpec )? ':' )? altpair ( '|' altpair )* rp= ')'
			{
			lp=(Token)match(input,68,FOLLOW_68_in_block1209); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(lp);

			// org/antlr/grammar/v3/ANTLRv3.g:194:3: ( (opts= optionsSpec )? ':' )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==OPTIONS||LA31_0==74) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:194:5: (opts= optionsSpec )? ':'
					{
					// org/antlr/grammar/v3/ANTLRv3.g:194:5: (opts= optionsSpec )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==OPTIONS) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:194:6: opts= optionsSpec
							{
							pushFollow(FOLLOW_optionsSpec_in_block1218);
							opts=optionsSpec();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_optionsSpec.add(opts.getTree());
							}
							break;

					}

					char_literal72=(Token)match(input,74,FOLLOW_74_in_block1222); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_74.add(char_literal72);

					}
					break;

			}

			pushFollow(FOLLOW_altpair_in_block1229);
			altpair73=altpair();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_altpair.add(altpair73.getTree());
			// org/antlr/grammar/v3/ANTLRv3.g:195:11: ( '|' altpair )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==91) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:195:13: '|' altpair
					{
					char_literal74=(Token)match(input,91,FOLLOW_91_in_block1233); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_91.add(char_literal74);

					pushFollow(FOLLOW_altpair_in_block1235);
					altpair75=altpair();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_altpair.add(altpair75.getTree());
					}
					break;

				default :
					break loop32;
				}
			}

			rp=(Token)match(input,69,FOLLOW_69_in_block1250); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(rp);

			// AST REWRITE
			// elements: altpair, optionsSpec
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 197:9: -> ^( BLOCK[$lp,\"BLOCK\"] ( optionsSpec )? ( altpair )+ EOB[$rp,\"EOB\"] )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:197:12: ^( BLOCK[$lp,\"BLOCK\"] ( optionsSpec )? ( altpair )+ EOB[$rp,\"EOB\"] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, lp, "BLOCK"), root_1);
				// org/antlr/grammar/v3/ANTLRv3.g:197:34: ( optionsSpec )?
				if ( stream_optionsSpec.hasNext() ) {
					adaptor.addChild(root_1, stream_optionsSpec.nextTree());
				}
				stream_optionsSpec.reset();

				if ( !(stream_altpair.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_altpair.hasNext() ) {
					adaptor.addChild(root_1, stream_altpair.nextTree());
				}
				stream_altpair.reset();

				adaptor.addChild(root_1, (CommonTree)adaptor.create(EOB, rp, "EOB"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class altpair_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "altpair"
	// org/antlr/grammar/v3/ANTLRv3.g:200:1: altpair : alternative rewrite ;
	public final ANTLRv3Parser.altpair_return altpair() throws RecognitionException {
		ANTLRv3Parser.altpair_return retval = new ANTLRv3Parser.altpair_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope alternative76 =null;
		ParserRuleReturnScope rewrite77 =null;


		try {
			// org/antlr/grammar/v3/ANTLRv3.g:200:9: ( alternative rewrite )
			// org/antlr/grammar/v3/ANTLRv3.g:200:11: alternative rewrite
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_alternative_in_altpair1289);
			alternative76=alternative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, alternative76.getTree());

			pushFollow(FOLLOW_rewrite_in_altpair1291);
			rewrite77=rewrite();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite77.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "altpair"


	public static class altList_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "altList"
	// org/antlr/grammar/v3/ANTLRv3.g:202:1: altList : altpair ( '|' altpair )* -> ^( ( altpair )+ EOB[\"EOB\"] ) ;
	public final ANTLRv3Parser.altList_return altList() throws RecognitionException {
		ANTLRv3Parser.altList_return retval = new ANTLRv3Parser.altList_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal79=null;
		ParserRuleReturnScope altpair78 =null;
		ParserRuleReturnScope altpair80 =null;

		CommonTree char_literal79_tree=null;
		RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
		RewriteRuleSubtreeStream stream_altpair=new RewriteRuleSubtreeStream(adaptor,"rule altpair");


			// must create root manually as it's used by invoked rules in real antlr tool.
			// leave here to demonstrate use of {...} in rewrite rule
			// it's really BLOCK[firstToken,"BLOCK"]; set line/col to previous ( or : token.
		    CommonTree blkRoot = (CommonTree)adaptor.create(BLOCK,input.LT(-1),"BLOCK");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:209:5: ( altpair ( '|' altpair )* -> ^( ( altpair )+ EOB[\"EOB\"] ) )
			// org/antlr/grammar/v3/ANTLRv3.g:209:9: altpair ( '|' altpair )*
			{
			pushFollow(FOLLOW_altpair_in_altList1311);
			altpair78=altpair();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_altpair.add(altpair78.getTree());
			// org/antlr/grammar/v3/ANTLRv3.g:209:17: ( '|' altpair )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==91) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:209:19: '|' altpair
					{
					char_literal79=(Token)match(input,91,FOLLOW_91_in_altList1315); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_91.add(char_literal79);

					pushFollow(FOLLOW_altpair_in_altList1317);
					altpair80=altpair();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_altpair.add(altpair80.getTree());
					}
					break;

				default :
					break loop33;
				}
			}

			// AST REWRITE
			// elements: altpair
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 209:34: -> ^( ( altpair )+ EOB[\"EOB\"] )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:209:37: ^( ( altpair )+ EOB[\"EOB\"] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(blkRoot, root_1);
				if ( !(stream_altpair.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_altpair.hasNext() ) {
					adaptor.addChild(root_1, stream_altpair.nextTree());
				}
				stream_altpair.reset();

				adaptor.addChild(root_1, (CommonTree)adaptor.create(EOB, "EOB"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "altList"


	public static class alternative_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alternative"
	// org/antlr/grammar/v3/ANTLRv3.g:212:1: alternative : ( ( element )+ -> ^( ALT[firstToken,\"ALT\"] ( element )+ EOA[\"EOA\"] ) | -> ^( ALT[prevToken,\"ALT\"] EPSILON[prevToken,\"EPSILON\"] EOA[\"EOA\"] ) );
	public final ANTLRv3Parser.alternative_return alternative() throws RecognitionException {
		ANTLRv3Parser.alternative_return retval = new ANTLRv3Parser.alternative_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope element81 =null;

		RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");


			Token firstToken = input.LT(1);
			Token prevToken = input.LT(-1); // either : or | I think

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:217:5: ( ( element )+ -> ^( ALT[firstToken,\"ALT\"] ( element )+ EOA[\"EOA\"] ) | -> ^( ALT[prevToken,\"ALT\"] EPSILON[prevToken,\"EPSILON\"] EOA[\"EOA\"] ) )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==ACTION||LA35_0==CHAR_LITERAL||LA35_0==RULE_REF||LA35_0==SEMPRED||LA35_0==STRING_LITERAL||(LA35_0 >= TOKEN_REF && LA35_0 <= TREE_BEGIN)||LA35_0==68||LA35_0==73||LA35_0==93) ) {
				alt35=1;
			}
			else if ( (LA35_0==REWRITE||LA35_0==69||LA35_0==76||LA35_0==91) ) {
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
					// org/antlr/grammar/v3/ANTLRv3.g:217:9: ( element )+
					{
					// org/antlr/grammar/v3/ANTLRv3.g:217:9: ( element )+
					int cnt34=0;
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==ACTION||LA34_0==CHAR_LITERAL||LA34_0==RULE_REF||LA34_0==SEMPRED||LA34_0==STRING_LITERAL||(LA34_0 >= TOKEN_REF && LA34_0 <= TREE_BEGIN)||LA34_0==68||LA34_0==73||LA34_0==93) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:217:9: element
							{
							pushFollow(FOLLOW_element_in_alternative1358);
							element81=element();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_element.add(element81.getTree());
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

					root_0 = (CommonTree)adaptor.nil();
					// 217:18: -> ^( ALT[firstToken,\"ALT\"] ( element )+ EOA[\"EOA\"] )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:217:21: ^( ALT[firstToken,\"ALT\"] ( element )+ EOA[\"EOA\"] )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, firstToken, "ALT"), root_1);
						if ( !(stream_element.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_element.hasNext() ) {
							adaptor.addChild(root_1, stream_element.nextTree());
						}
						stream_element.reset();

						adaptor.addChild(root_1, (CommonTree)adaptor.create(EOA, "EOA"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:218:9: 
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

					root_0 = (CommonTree)adaptor.nil();
					// 218:9: -> ^( ALT[prevToken,\"ALT\"] EPSILON[prevToken,\"EPSILON\"] EOA[\"EOA\"] )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:218:12: ^( ALT[prevToken,\"ALT\"] EPSILON[prevToken,\"EPSILON\"] EOA[\"EOA\"] )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, prevToken, "ALT"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(EPSILON, prevToken, "EPSILON"));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(EOA, "EOA"));
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "alternative"


	public static class exceptionGroup_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "exceptionGroup"
	// org/antlr/grammar/v3/ANTLRv3.g:221:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
	public final ANTLRv3Parser.exceptionGroup_return exceptionGroup() throws RecognitionException {
		ANTLRv3Parser.exceptionGroup_return retval = new ANTLRv3Parser.exceptionGroup_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope exceptionHandler82 =null;
		ParserRuleReturnScope finallyClause83 =null;
		ParserRuleReturnScope finallyClause84 =null;


		try {
			// org/antlr/grammar/v3/ANTLRv3.g:222:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==81) ) {
				alt38=1;
			}
			else if ( (LA38_0==82) ) {
				alt38=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:222:4: ( exceptionHandler )+ ( finallyClause )?
					{
					root_0 = (CommonTree)adaptor.nil();


					// org/antlr/grammar/v3/ANTLRv3.g:222:4: ( exceptionHandler )+
					int cnt36=0;
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==81) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:222:6: exceptionHandler
							{
							pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1409);
							exceptionHandler82=exceptionHandler();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, exceptionHandler82.getTree());

							}
							break;

						default :
							if ( cnt36 >= 1 ) break loop36;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(36, input);
							throw eee;
						}
						cnt36++;
					}

					// org/antlr/grammar/v3/ANTLRv3.g:222:26: ( finallyClause )?
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==82) ) {
						alt37=1;
					}
					switch (alt37) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:222:28: finallyClause
							{
							pushFollow(FOLLOW_finallyClause_in_exceptionGroup1416);
							finallyClause83=finallyClause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, finallyClause83.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:223:4: finallyClause
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_finallyClause_in_exceptionGroup1424);
					finallyClause84=finallyClause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, finallyClause84.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exceptionGroup"


	public static class exceptionHandler_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "exceptionHandler"
	// org/antlr/grammar/v3/ANTLRv3.g:226:1: exceptionHandler : 'catch' ARG_ACTION ACTION -> ^( 'catch' ARG_ACTION ACTION ) ;
	public final ANTLRv3Parser.exceptionHandler_return exceptionHandler() throws RecognitionException {
		ANTLRv3Parser.exceptionHandler_return retval = new ANTLRv3Parser.exceptionHandler_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal85=null;
		Token ARG_ACTION86=null;
		Token ACTION87=null;

		CommonTree string_literal85_tree=null;
		CommonTree ARG_ACTION86_tree=null;
		CommonTree ACTION87_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:227:5: ( 'catch' ARG_ACTION ACTION -> ^( 'catch' ARG_ACTION ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3.g:227:10: 'catch' ARG_ACTION ACTION
			{
			string_literal85=(Token)match(input,81,FOLLOW_81_in_exceptionHandler1444); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal85);

			ARG_ACTION86=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1446); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ARG_ACTION.add(ARG_ACTION86);

			ACTION87=(Token)match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1448); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION87);

			// AST REWRITE
			// elements: 81, ARG_ACTION, ACTION
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 227:36: -> ^( 'catch' ARG_ACTION ACTION )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:227:39: ^( 'catch' ARG_ACTION ACTION )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_81.nextNode(), root_1);
				adaptor.addChild(root_1, stream_ARG_ACTION.nextNode());
				adaptor.addChild(root_1, stream_ACTION.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exceptionHandler"


	public static class finallyClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "finallyClause"
	// org/antlr/grammar/v3/ANTLRv3.g:230:1: finallyClause : 'finally' ACTION -> ^( 'finally' ACTION ) ;
	public final ANTLRv3Parser.finallyClause_return finallyClause() throws RecognitionException {
		ANTLRv3Parser.finallyClause_return retval = new ANTLRv3Parser.finallyClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal88=null;
		Token ACTION89=null;

		CommonTree string_literal88_tree=null;
		CommonTree ACTION89_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:231:5: ( 'finally' ACTION -> ^( 'finally' ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3.g:231:10: 'finally' ACTION
			{
			string_literal88=(Token)match(input,82,FOLLOW_82_in_finallyClause1478); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_82.add(string_literal88);

			ACTION89=(Token)match(input,ACTION,FOLLOW_ACTION_in_finallyClause1480); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION89);

			// AST REWRITE
			// elements: 82, ACTION
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 231:27: -> ^( 'finally' ACTION )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:231:30: ^( 'finally' ACTION )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_82.nextNode(), root_1);
				adaptor.addChild(root_1, stream_ACTION.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "finallyClause"


	public static class element_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "element"
	// org/antlr/grammar/v3/ANTLRv3.g:234:1: element : ( id (labelOp= '=' |labelOp= '+=' ) atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id atom ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> ^( $labelOp id atom ) ) | id (labelOp= '=' |labelOp= '+=' ) block ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id block ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> ^( $labelOp id block ) ) | atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> atom ) | ebnf | ACTION | SEMPRED (g= '=>' -> GATED_SEMPRED[$g] | -> SEMPRED ) | treeSpec ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] treeSpec EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> treeSpec ) );
	public final ANTLRv3Parser.element_return element() throws RecognitionException {
		ANTLRv3Parser.element_return retval = new ANTLRv3Parser.element_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token labelOp=null;
		Token g=null;
		Token ACTION99=null;
		Token SEMPRED100=null;
		ParserRuleReturnScope id90 =null;
		ParserRuleReturnScope atom91 =null;
		ParserRuleReturnScope ebnfSuffix92 =null;
		ParserRuleReturnScope id93 =null;
		ParserRuleReturnScope block94 =null;
		ParserRuleReturnScope ebnfSuffix95 =null;
		ParserRuleReturnScope atom96 =null;
		ParserRuleReturnScope ebnfSuffix97 =null;
		ParserRuleReturnScope ebnf98 =null;
		ParserRuleReturnScope treeSpec101 =null;
		ParserRuleReturnScope ebnfSuffix102 =null;

		CommonTree labelOp_tree=null;
		CommonTree g_tree=null;
		CommonTree ACTION99_tree=null;
		CommonTree SEMPRED100_tree=null;
		RewriteRuleTokenStream stream_LIST_LABEL_ASSIGN=new RewriteRuleTokenStream(adaptor,"token LIST_LABEL_ASSIGN");
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_LABEL_ASSIGN=new RewriteRuleTokenStream(adaptor,"token LABEL_ASSIGN");
		RewriteRuleTokenStream stream_SEMPRED=new RewriteRuleTokenStream(adaptor,"token SEMPRED");
		RewriteRuleSubtreeStream stream_treeSpec=new RewriteRuleSubtreeStream(adaptor,"rule treeSpec");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_ebnfSuffix=new RewriteRuleSubtreeStream(adaptor,"rule ebnfSuffix");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:235:2: ( id (labelOp= '=' |labelOp= '+=' ) atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id atom ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> ^( $labelOp id atom ) ) | id (labelOp= '=' |labelOp= '+=' ) block ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id block ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> ^( $labelOp id block ) ) | atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> atom ) | ebnf | ACTION | SEMPRED (g= '=>' -> GATED_SEMPRED[$g] | -> SEMPRED ) | treeSpec ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] treeSpec EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> treeSpec ) )
			int alt46=7;
			switch ( input.LA(1) ) {
			case TOKEN_REF:
				{
				switch ( input.LA(2) ) {
				case LABEL_ASSIGN:
					{
					int LA46_8 = input.LA(3);
					if ( (LA46_8==CHAR_LITERAL||LA46_8==RULE_REF||LA46_8==STRING_LITERAL||LA46_8==TOKEN_REF||LA46_8==73||LA46_8==93) ) {
						alt46=1;
					}
					else if ( (LA46_8==68) ) {
						alt46=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 46, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case LIST_LABEL_ASSIGN:
					{
					int LA46_9 = input.LA(3);
					if ( (LA46_9==CHAR_LITERAL||LA46_9==RULE_REF||LA46_9==STRING_LITERAL||LA46_9==TOKEN_REF||LA46_9==73||LA46_9==93) ) {
						alt46=1;
					}
					else if ( (LA46_9==68) ) {
						alt46=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 46, 9, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case ACTION:
				case ARG_ACTION:
				case BANG:
				case CHAR_LITERAL:
				case REWRITE:
				case ROOT:
				case RULE_REF:
				case SEMPRED:
				case STRING_LITERAL:
				case TOKEN_REF:
				case TREE_BEGIN:
				case 68:
				case 69:
				case 70:
				case 71:
				case 73:
				case 76:
				case 77:
				case 80:
				case 91:
				case 93:
					{
					alt46=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 46, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case RULE_REF:
				{
				switch ( input.LA(2) ) {
				case LABEL_ASSIGN:
					{
					int LA46_8 = input.LA(3);
					if ( (LA46_8==CHAR_LITERAL||LA46_8==RULE_REF||LA46_8==STRING_LITERAL||LA46_8==TOKEN_REF||LA46_8==73||LA46_8==93) ) {
						alt46=1;
					}
					else if ( (LA46_8==68) ) {
						alt46=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 46, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case LIST_LABEL_ASSIGN:
					{
					int LA46_9 = input.LA(3);
					if ( (LA46_9==CHAR_LITERAL||LA46_9==RULE_REF||LA46_9==STRING_LITERAL||LA46_9==TOKEN_REF||LA46_9==73||LA46_9==93) ) {
						alt46=1;
					}
					else if ( (LA46_9==68) ) {
						alt46=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 46, 9, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case ACTION:
				case ARG_ACTION:
				case BANG:
				case CHAR_LITERAL:
				case REWRITE:
				case ROOT:
				case RULE_REF:
				case SEMPRED:
				case STRING_LITERAL:
				case TOKEN_REF:
				case TREE_BEGIN:
				case 68:
				case 69:
				case 70:
				case 71:
				case 73:
				case 76:
				case 80:
				case 91:
				case 93:
					{
					alt46=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 46, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case 73:
			case 93:
				{
				alt46=3;
				}
				break;
			case 68:
				{
				alt46=4;
				}
				break;
			case ACTION:
				{
				alt46=5;
				}
				break;
			case SEMPRED:
				{
				alt46=6;
				}
				break;
			case TREE_BEGIN:
				{
				alt46=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:235:4: id (labelOp= '=' |labelOp= '+=' ) atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id atom ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> ^( $labelOp id atom ) )
					{
					pushFollow(FOLLOW_id_in_element1502);
					id90=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id.add(id90.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:235:7: (labelOp= '=' |labelOp= '+=' )
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0==LABEL_ASSIGN) ) {
						alt39=1;
					}
					else if ( (LA39_0==LIST_LABEL_ASSIGN) ) {
						alt39=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 39, 0, input);
						throw nvae;
					}

					switch (alt39) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:235:8: labelOp= '='
							{
							labelOp=(Token)match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_element1507); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LABEL_ASSIGN.add(labelOp);

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:235:20: labelOp= '+='
							{
							labelOp=(Token)match(input,LIST_LABEL_ASSIGN,FOLLOW_LIST_LABEL_ASSIGN_in_element1511); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LIST_LABEL_ASSIGN.add(labelOp);

							}
							break;

					}

					pushFollow(FOLLOW_atom_in_element1514);
					atom91=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atom.add(atom91.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:236:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id atom ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> ^( $labelOp id atom ) )
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( ((LA40_0 >= 70 && LA40_0 <= 71)||LA40_0==80) ) {
						alt40=1;
					}
					else if ( (LA40_0==ACTION||LA40_0==CHAR_LITERAL||LA40_0==REWRITE||LA40_0==RULE_REF||LA40_0==SEMPRED||LA40_0==STRING_LITERAL||(LA40_0 >= TOKEN_REF && LA40_0 <= TREE_BEGIN)||(LA40_0 >= 68 && LA40_0 <= 69)||LA40_0==73||LA40_0==76||LA40_0==91||LA40_0==93) ) {
						alt40=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 40, 0, input);
						throw nvae;
					}

					switch (alt40) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:236:5: ebnfSuffix
							{
							pushFollow(FOLLOW_ebnfSuffix_in_element1520);
							ebnfSuffix92=ebnfSuffix();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ebnfSuffix.add(ebnfSuffix92.getTree());
							// AST REWRITE
							// elements: ebnfSuffix, labelOp, atom, id
							// token labels: labelOp
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleTokenStream stream_labelOp=new RewriteRuleTokenStream(adaptor,"token labelOp",labelOp);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 236:16: -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id atom ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:236:19: ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id atom ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);
								// org/antlr/grammar/v3/ANTLRv3.g:236:33: ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id atom ) EOA[\"EOA\"] ) EOB[\"EOB\"] )
								{
								CommonTree root_2 = (CommonTree)adaptor.nil();
								root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_2);
								// org/antlr/grammar/v3/ANTLRv3.g:236:50: ^( ALT[\"ALT\"] ^( $labelOp id atom ) EOA[\"EOA\"] )
								{
								CommonTree root_3 = (CommonTree)adaptor.nil();
								root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, "ALT"), root_3);
								// org/antlr/grammar/v3/ANTLRv3.g:236:63: ^( $labelOp id atom )
								{
								CommonTree root_4 = (CommonTree)adaptor.nil();
								root_4 = (CommonTree)adaptor.becomeRoot(stream_labelOp.nextNode(), root_4);
								adaptor.addChild(root_4, stream_id.nextTree());
								adaptor.addChild(root_4, stream_atom.nextTree());
								adaptor.addChild(root_3, root_4);
								}

								adaptor.addChild(root_3, (CommonTree)adaptor.create(EOA, "EOA"));
								adaptor.addChild(root_2, root_3);
								}

								adaptor.addChild(root_2, (CommonTree)adaptor.create(EOB, "EOB"));
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
							// org/antlr/grammar/v3/ANTLRv3.g:237:8: 
							{
							// AST REWRITE
							// elements: labelOp, id, atom
							// token labels: labelOp
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleTokenStream stream_labelOp=new RewriteRuleTokenStream(adaptor,"token labelOp",labelOp);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 237:8: -> ^( $labelOp id atom )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:237:11: ^( $labelOp id atom )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_labelOp.nextNode(), root_1);
								adaptor.addChild(root_1, stream_id.nextTree());
								adaptor.addChild(root_1, stream_atom.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:239:4: id (labelOp= '=' |labelOp= '+=' ) block ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id block ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> ^( $labelOp id block ) )
					{
					pushFollow(FOLLOW_id_in_element1579);
					id93=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id.add(id93.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:239:7: (labelOp= '=' |labelOp= '+=' )
					int alt41=2;
					int LA41_0 = input.LA(1);
					if ( (LA41_0==LABEL_ASSIGN) ) {
						alt41=1;
					}
					else if ( (LA41_0==LIST_LABEL_ASSIGN) ) {
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
							// org/antlr/grammar/v3/ANTLRv3.g:239:8: labelOp= '='
							{
							labelOp=(Token)match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_element1584); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LABEL_ASSIGN.add(labelOp);

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:239:20: labelOp= '+='
							{
							labelOp=(Token)match(input,LIST_LABEL_ASSIGN,FOLLOW_LIST_LABEL_ASSIGN_in_element1588); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LIST_LABEL_ASSIGN.add(labelOp);

							}
							break;

					}

					pushFollow(FOLLOW_block_in_element1591);
					block94=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block.add(block94.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:240:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id block ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> ^( $labelOp id block ) )
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( ((LA42_0 >= 70 && LA42_0 <= 71)||LA42_0==80) ) {
						alt42=1;
					}
					else if ( (LA42_0==ACTION||LA42_0==CHAR_LITERAL||LA42_0==REWRITE||LA42_0==RULE_REF||LA42_0==SEMPRED||LA42_0==STRING_LITERAL||(LA42_0 >= TOKEN_REF && LA42_0 <= TREE_BEGIN)||(LA42_0 >= 68 && LA42_0 <= 69)||LA42_0==73||LA42_0==76||LA42_0==91||LA42_0==93) ) {
						alt42=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 42, 0, input);
						throw nvae;
					}

					switch (alt42) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:240:5: ebnfSuffix
							{
							pushFollow(FOLLOW_ebnfSuffix_in_element1597);
							ebnfSuffix95=ebnfSuffix();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ebnfSuffix.add(ebnfSuffix95.getTree());
							// AST REWRITE
							// elements: ebnfSuffix, id, labelOp, block
							// token labels: labelOp
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleTokenStream stream_labelOp=new RewriteRuleTokenStream(adaptor,"token labelOp",labelOp);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 240:16: -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id block ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:240:19: ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id block ) EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);
								// org/antlr/grammar/v3/ANTLRv3.g:240:33: ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] ^( $labelOp id block ) EOA[\"EOA\"] ) EOB[\"EOB\"] )
								{
								CommonTree root_2 = (CommonTree)adaptor.nil();
								root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_2);
								// org/antlr/grammar/v3/ANTLRv3.g:240:50: ^( ALT[\"ALT\"] ^( $labelOp id block ) EOA[\"EOA\"] )
								{
								CommonTree root_3 = (CommonTree)adaptor.nil();
								root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, "ALT"), root_3);
								// org/antlr/grammar/v3/ANTLRv3.g:240:63: ^( $labelOp id block )
								{
								CommonTree root_4 = (CommonTree)adaptor.nil();
								root_4 = (CommonTree)adaptor.becomeRoot(stream_labelOp.nextNode(), root_4);
								adaptor.addChild(root_4, stream_id.nextTree());
								adaptor.addChild(root_4, stream_block.nextTree());
								adaptor.addChild(root_3, root_4);
								}

								adaptor.addChild(root_3, (CommonTree)adaptor.create(EOA, "EOA"));
								adaptor.addChild(root_2, root_3);
								}

								adaptor.addChild(root_2, (CommonTree)adaptor.create(EOB, "EOB"));
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
							// org/antlr/grammar/v3/ANTLRv3.g:241:8: 
							{
							// AST REWRITE
							// elements: id, labelOp, block
							// token labels: labelOp
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleTokenStream stream_labelOp=new RewriteRuleTokenStream(adaptor,"token labelOp",labelOp);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 241:8: -> ^( $labelOp id block )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:241:11: ^( $labelOp id block )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_labelOp.nextNode(), root_1);
								adaptor.addChild(root_1, stream_id.nextTree());
								adaptor.addChild(root_1, stream_block.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:243:4: atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> atom )
					{
					pushFollow(FOLLOW_atom_in_element1656);
					atom96=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atom.add(atom96.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:244:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> atom )
					int alt43=2;
					int LA43_0 = input.LA(1);
					if ( ((LA43_0 >= 70 && LA43_0 <= 71)||LA43_0==80) ) {
						alt43=1;
					}
					else if ( (LA43_0==ACTION||LA43_0==CHAR_LITERAL||LA43_0==REWRITE||LA43_0==RULE_REF||LA43_0==SEMPRED||LA43_0==STRING_LITERAL||(LA43_0 >= TOKEN_REF && LA43_0 <= TREE_BEGIN)||(LA43_0 >= 68 && LA43_0 <= 69)||LA43_0==73||LA43_0==76||LA43_0==91||LA43_0==93) ) {
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
							// org/antlr/grammar/v3/ANTLRv3.g:244:5: ebnfSuffix
							{
							pushFollow(FOLLOW_ebnfSuffix_in_element1662);
							ebnfSuffix97=ebnfSuffix();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ebnfSuffix.add(ebnfSuffix97.getTree());
							// AST REWRITE
							// elements: atom, ebnfSuffix
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 244:16: -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:244:19: ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);
								// org/antlr/grammar/v3/ANTLRv3.g:244:33: ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] atom EOA[\"EOA\"] ) EOB[\"EOB\"] )
								{
								CommonTree root_2 = (CommonTree)adaptor.nil();
								root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_2);
								// org/antlr/grammar/v3/ANTLRv3.g:244:50: ^( ALT[\"ALT\"] atom EOA[\"EOA\"] )
								{
								CommonTree root_3 = (CommonTree)adaptor.nil();
								root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, "ALT"), root_3);
								adaptor.addChild(root_3, stream_atom.nextTree());
								adaptor.addChild(root_3, (CommonTree)adaptor.create(EOA, "EOA"));
								adaptor.addChild(root_2, root_3);
								}

								adaptor.addChild(root_2, (CommonTree)adaptor.create(EOB, "EOB"));
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
							// org/antlr/grammar/v3/ANTLRv3.g:245:8: 
							{
							// AST REWRITE
							// elements: atom
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 245:8: -> atom
							{
								adaptor.addChild(root_0, stream_atom.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:247:4: ebnf
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_ebnf_in_element1708);
					ebnf98=ebnf();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ebnf98.getTree());

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRv3.g:248:6: ACTION
					{
					root_0 = (CommonTree)adaptor.nil();


					ACTION99=(Token)match(input,ACTION,FOLLOW_ACTION_in_element1715); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACTION99_tree = (CommonTree)adaptor.create(ACTION99);
					adaptor.addChild(root_0, ACTION99_tree);
					}

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLRv3.g:249:6: SEMPRED (g= '=>' -> GATED_SEMPRED[$g] | -> SEMPRED )
					{
					SEMPRED100=(Token)match(input,SEMPRED,FOLLOW_SEMPRED_in_element1722); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMPRED.add(SEMPRED100);

					// org/antlr/grammar/v3/ANTLRv3.g:249:14: (g= '=>' -> GATED_SEMPRED[$g] | -> SEMPRED )
					int alt44=2;
					int LA44_0 = input.LA(1);
					if ( (LA44_0==78) ) {
						alt44=1;
					}
					else if ( (LA44_0==ACTION||LA44_0==CHAR_LITERAL||LA44_0==REWRITE||LA44_0==RULE_REF||LA44_0==SEMPRED||LA44_0==STRING_LITERAL||(LA44_0 >= TOKEN_REF && LA44_0 <= TREE_BEGIN)||(LA44_0 >= 68 && LA44_0 <= 69)||LA44_0==73||LA44_0==76||LA44_0==91||LA44_0==93) ) {
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
							// org/antlr/grammar/v3/ANTLRv3.g:249:16: g= '=>'
							{
							g=(Token)match(input,78,FOLLOW_78_in_element1728); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_78.add(g);

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

							root_0 = (CommonTree)adaptor.nil();
							// 249:23: -> GATED_SEMPRED[$g]
							{
								adaptor.addChild(root_0, (CommonTree)adaptor.create(GATED_SEMPRED, g));
							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:249:46: 
							{
							// AST REWRITE
							// elements: SEMPRED
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 249:46: -> SEMPRED
							{
								adaptor.addChild(root_0, stream_SEMPRED.nextNode());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 7 :
					// org/antlr/grammar/v3/ANTLRv3.g:250:6: treeSpec ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] treeSpec EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> treeSpec )
					{
					pushFollow(FOLLOW_treeSpec_in_element1748);
					treeSpec101=treeSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_treeSpec.add(treeSpec101.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:251:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] treeSpec EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> treeSpec )
					int alt45=2;
					int LA45_0 = input.LA(1);
					if ( ((LA45_0 >= 70 && LA45_0 <= 71)||LA45_0==80) ) {
						alt45=1;
					}
					else if ( (LA45_0==ACTION||LA45_0==CHAR_LITERAL||LA45_0==REWRITE||LA45_0==RULE_REF||LA45_0==SEMPRED||LA45_0==STRING_LITERAL||(LA45_0 >= TOKEN_REF && LA45_0 <= TREE_BEGIN)||(LA45_0 >= 68 && LA45_0 <= 69)||LA45_0==73||LA45_0==76||LA45_0==91||LA45_0==93) ) {
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
							// org/antlr/grammar/v3/ANTLRv3.g:251:5: ebnfSuffix
							{
							pushFollow(FOLLOW_ebnfSuffix_in_element1754);
							ebnfSuffix102=ebnfSuffix();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ebnfSuffix.add(ebnfSuffix102.getTree());
							// AST REWRITE
							// elements: ebnfSuffix, treeSpec
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 251:16: -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] treeSpec EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:251:19: ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] treeSpec EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);
								// org/antlr/grammar/v3/ANTLRv3.g:251:33: ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] treeSpec EOA[\"EOA\"] ) EOB[\"EOB\"] )
								{
								CommonTree root_2 = (CommonTree)adaptor.nil();
								root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_2);
								// org/antlr/grammar/v3/ANTLRv3.g:251:50: ^( ALT[\"ALT\"] treeSpec EOA[\"EOA\"] )
								{
								CommonTree root_3 = (CommonTree)adaptor.nil();
								root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, "ALT"), root_3);
								adaptor.addChild(root_3, stream_treeSpec.nextTree());
								adaptor.addChild(root_3, (CommonTree)adaptor.create(EOA, "EOA"));
								adaptor.addChild(root_2, root_3);
								}

								adaptor.addChild(root_2, (CommonTree)adaptor.create(EOB, "EOB"));
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
							// org/antlr/grammar/v3/ANTLRv3.g:252:8: 
							{
							// AST REWRITE
							// elements: treeSpec
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 252:8: -> treeSpec
							{
								adaptor.addChild(root_0, stream_treeSpec.nextTree());
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "element"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// org/antlr/grammar/v3/ANTLRv3.g:256:1: atom : ( terminal | range ( (op= '^' |op= '!' ) -> ^( $op range ) | -> range ) | notSet ( (op= '^' |op= '!' ) -> ^( $op notSet ) | -> notSet ) | RULE_REF ( ARG_ACTION )? ( (op= '^' |op= '!' ) -> ^( $op RULE_REF ( ARG_ACTION )? ) | -> ^( RULE_REF ( ARG_ACTION )? ) ) );
	public final ANTLRv3Parser.atom_return atom() throws RecognitionException {
		ANTLRv3Parser.atom_return retval = new ANTLRv3Parser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token op=null;
		Token RULE_REF106=null;
		Token ARG_ACTION107=null;
		ParserRuleReturnScope terminal103 =null;
		ParserRuleReturnScope range104 =null;
		ParserRuleReturnScope notSet105 =null;

		CommonTree op_tree=null;
		CommonTree RULE_REF106_tree=null;
		CommonTree ARG_ACTION107_tree=null;
		RewriteRuleTokenStream stream_ROOT=new RewriteRuleTokenStream(adaptor,"token ROOT");
		RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
		RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");
		RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");
		RewriteRuleSubtreeStream stream_notSet=new RewriteRuleSubtreeStream(adaptor,"rule notSet");
		RewriteRuleSubtreeStream stream_range=new RewriteRuleSubtreeStream(adaptor,"rule range");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:256:5: ( terminal | range ( (op= '^' |op= '!' ) -> ^( $op range ) | -> range ) | notSet ( (op= '^' |op= '!' ) -> ^( $op notSet ) | -> notSet ) | RULE_REF ( ARG_ACTION )? ( (op= '^' |op= '!' ) -> ^( $op RULE_REF ( ARG_ACTION )? ) | -> ^( RULE_REF ( ARG_ACTION )? ) ) )
			int alt54=4;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				int LA54_1 = input.LA(2);
				if ( (LA54_1==RANGE) ) {
					alt54=2;
				}
				else if ( (LA54_1==ACTION||LA54_1==BANG||LA54_1==CHAR_LITERAL||(LA54_1 >= REWRITE && LA54_1 <= ROOT)||LA54_1==RULE_REF||LA54_1==SEMPRED||LA54_1==STRING_LITERAL||(LA54_1 >= TOKEN_REF && LA54_1 <= TREE_BEGIN)||(LA54_1 >= 68 && LA54_1 <= 71)||LA54_1==73||(LA54_1 >= 76 && LA54_1 <= 77)||LA54_1==80||LA54_1==91||LA54_1==93) ) {
					alt54=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 54, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case STRING_LITERAL:
			case TOKEN_REF:
			case 73:
				{
				alt54=1;
				}
				break;
			case 93:
				{
				alt54=3;
				}
				break;
			case RULE_REF:
				{
				alt54=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 54, 0, input);
				throw nvae;
			}
			switch (alt54) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:256:9: terminal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_terminal_in_atom1806);
					terminal103=terminal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal103.getTree());

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:257:4: range ( (op= '^' |op= '!' ) -> ^( $op range ) | -> range )
					{
					pushFollow(FOLLOW_range_in_atom1811);
					range104=range();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_range.add(range104.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:258:3: ( (op= '^' |op= '!' ) -> ^( $op range ) | -> range )
					int alt48=2;
					int LA48_0 = input.LA(1);
					if ( (LA48_0==BANG||LA48_0==ROOT) ) {
						alt48=1;
					}
					else if ( (LA48_0==ACTION||LA48_0==CHAR_LITERAL||LA48_0==REWRITE||LA48_0==RULE_REF||LA48_0==SEMPRED||LA48_0==STRING_LITERAL||(LA48_0 >= TOKEN_REF && LA48_0 <= TREE_BEGIN)||(LA48_0 >= 68 && LA48_0 <= 71)||LA48_0==73||LA48_0==76||LA48_0==80||LA48_0==91||LA48_0==93) ) {
						alt48=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 48, 0, input);
						throw nvae;
					}

					switch (alt48) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:258:5: (op= '^' |op= '!' )
							{
							// org/antlr/grammar/v3/ANTLRv3.g:258:5: (op= '^' |op= '!' )
							int alt47=2;
							int LA47_0 = input.LA(1);
							if ( (LA47_0==ROOT) ) {
								alt47=1;
							}
							else if ( (LA47_0==BANG) ) {
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
									// org/antlr/grammar/v3/ANTLRv3.g:258:6: op= '^'
									{
									op=(Token)match(input,ROOT,FOLLOW_ROOT_in_atom1821); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_ROOT.add(op);

									}
									break;
								case 2 :
									// org/antlr/grammar/v3/ANTLRv3.g:258:13: op= '!'
									{
									op=(Token)match(input,BANG,FOLLOW_BANG_in_atom1825); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_BANG.add(op);

									}
									break;

							}

							// AST REWRITE
							// elements: op, range
							// token labels: op
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleTokenStream stream_op=new RewriteRuleTokenStream(adaptor,"token op",op);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 258:21: -> ^( $op range )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:258:24: ^( $op range )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_op.nextNode(), root_1);
								adaptor.addChild(root_1, stream_range.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:259:9: 
							{
							// AST REWRITE
							// elements: range
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 259:9: -> range
							{
								adaptor.addChild(root_0, stream_range.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:261:7: notSet ( (op= '^' |op= '!' ) -> ^( $op notSet ) | -> notSet )
					{
					pushFollow(FOLLOW_notSet_in_atom1859);
					notSet105=notSet();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_notSet.add(notSet105.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:262:3: ( (op= '^' |op= '!' ) -> ^( $op notSet ) | -> notSet )
					int alt50=2;
					int LA50_0 = input.LA(1);
					if ( (LA50_0==BANG||LA50_0==ROOT) ) {
						alt50=1;
					}
					else if ( (LA50_0==ACTION||LA50_0==CHAR_LITERAL||LA50_0==REWRITE||LA50_0==RULE_REF||LA50_0==SEMPRED||LA50_0==STRING_LITERAL||(LA50_0 >= TOKEN_REF && LA50_0 <= TREE_BEGIN)||(LA50_0 >= 68 && LA50_0 <= 71)||LA50_0==73||LA50_0==76||LA50_0==80||LA50_0==91||LA50_0==93) ) {
						alt50=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 50, 0, input);
						throw nvae;
					}

					switch (alt50) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:262:5: (op= '^' |op= '!' )
							{
							// org/antlr/grammar/v3/ANTLRv3.g:262:5: (op= '^' |op= '!' )
							int alt49=2;
							int LA49_0 = input.LA(1);
							if ( (LA49_0==ROOT) ) {
								alt49=1;
							}
							else if ( (LA49_0==BANG) ) {
								alt49=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								NoViableAltException nvae =
									new NoViableAltException("", 49, 0, input);
								throw nvae;
							}

							switch (alt49) {
								case 1 :
									// org/antlr/grammar/v3/ANTLRv3.g:262:6: op= '^'
									{
									op=(Token)match(input,ROOT,FOLLOW_ROOT_in_atom1868); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_ROOT.add(op);

									}
									break;
								case 2 :
									// org/antlr/grammar/v3/ANTLRv3.g:262:13: op= '!'
									{
									op=(Token)match(input,BANG,FOLLOW_BANG_in_atom1872); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_BANG.add(op);

									}
									break;

							}

							// AST REWRITE
							// elements: op, notSet
							// token labels: op
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleTokenStream stream_op=new RewriteRuleTokenStream(adaptor,"token op",op);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 262:21: -> ^( $op notSet )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:262:24: ^( $op notSet )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_op.nextNode(), root_1);
								adaptor.addChild(root_1, stream_notSet.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:263:9: 
							{
							// AST REWRITE
							// elements: notSet
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 263:9: -> notSet
							{
								adaptor.addChild(root_0, stream_notSet.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:265:9: RULE_REF ( ARG_ACTION )? ( (op= '^' |op= '!' ) -> ^( $op RULE_REF ( ARG_ACTION )? ) | -> ^( RULE_REF ( ARG_ACTION )? ) )
					{
					RULE_REF106=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1908); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RULE_REF.add(RULE_REF106);

					// org/antlr/grammar/v3/ANTLRv3.g:265:18: ( ARG_ACTION )?
					int alt51=2;
					int LA51_0 = input.LA(1);
					if ( (LA51_0==ARG_ACTION) ) {
						alt51=1;
					}
					switch (alt51) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:265:18: ARG_ACTION
							{
							ARG_ACTION107=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1910); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ARG_ACTION.add(ARG_ACTION107);

							}
							break;

					}

					// org/antlr/grammar/v3/ANTLRv3.g:266:3: ( (op= '^' |op= '!' ) -> ^( $op RULE_REF ( ARG_ACTION )? ) | -> ^( RULE_REF ( ARG_ACTION )? ) )
					int alt53=2;
					int LA53_0 = input.LA(1);
					if ( (LA53_0==BANG||LA53_0==ROOT) ) {
						alt53=1;
					}
					else if ( (LA53_0==ACTION||LA53_0==CHAR_LITERAL||LA53_0==REWRITE||LA53_0==RULE_REF||LA53_0==SEMPRED||LA53_0==STRING_LITERAL||(LA53_0 >= TOKEN_REF && LA53_0 <= TREE_BEGIN)||(LA53_0 >= 68 && LA53_0 <= 71)||LA53_0==73||LA53_0==76||LA53_0==80||LA53_0==91||LA53_0==93) ) {
						alt53=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 53, 0, input);
						throw nvae;
					}

					switch (alt53) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:266:5: (op= '^' |op= '!' )
							{
							// org/antlr/grammar/v3/ANTLRv3.g:266:5: (op= '^' |op= '!' )
							int alt52=2;
							int LA52_0 = input.LA(1);
							if ( (LA52_0==ROOT) ) {
								alt52=1;
							}
							else if ( (LA52_0==BANG) ) {
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
									// org/antlr/grammar/v3/ANTLRv3.g:266:6: op= '^'
									{
									op=(Token)match(input,ROOT,FOLLOW_ROOT_in_atom1920); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_ROOT.add(op);

									}
									break;
								case 2 :
									// org/antlr/grammar/v3/ANTLRv3.g:266:13: op= '!'
									{
									op=(Token)match(input,BANG,FOLLOW_BANG_in_atom1924); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_BANG.add(op);

									}
									break;

							}

							// AST REWRITE
							// elements: RULE_REF, ARG_ACTION, op
							// token labels: op
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleTokenStream stream_op=new RewriteRuleTokenStream(adaptor,"token op",op);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 266:21: -> ^( $op RULE_REF ( ARG_ACTION )? )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:266:24: ^( $op RULE_REF ( ARG_ACTION )? )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_op.nextNode(), root_1);
								adaptor.addChild(root_1, stream_RULE_REF.nextNode());
								// org/antlr/grammar/v3/ANTLRv3.g:266:39: ( ARG_ACTION )?
								if ( stream_ARG_ACTION.hasNext() ) {
									adaptor.addChild(root_1, stream_ARG_ACTION.nextNode());
								}
								stream_ARG_ACTION.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:267:9: 
							{
							// AST REWRITE
							// elements: RULE_REF, ARG_ACTION
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 267:9: -> ^( RULE_REF ( ARG_ACTION )? )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:267:12: ^( RULE_REF ( ARG_ACTION )? )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_RULE_REF.nextNode(), root_1);
								// org/antlr/grammar/v3/ANTLRv3.g:267:23: ( ARG_ACTION )?
								if ( stream_ARG_ACTION.hasNext() ) {
									adaptor.addChild(root_1, stream_ARG_ACTION.nextNode());
								}
								stream_ARG_ACTION.reset();

								adaptor.addChild(root_0, root_1);
								}

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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class notSet_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "notSet"
	// org/antlr/grammar/v3/ANTLRv3.g:271:1: notSet : '~' ( notTerminal ( elementOptions )? -> ^( '~' notTerminal ( elementOptions )? ) | block ( elementOptions )? -> ^( '~' block ( elementOptions )? ) ) ;
	public final ANTLRv3Parser.notSet_return notSet() throws RecognitionException {
		ANTLRv3Parser.notSet_return retval = new ANTLRv3Parser.notSet_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal108=null;
		ParserRuleReturnScope notTerminal109 =null;
		ParserRuleReturnScope elementOptions110 =null;
		ParserRuleReturnScope block111 =null;
		ParserRuleReturnScope elementOptions112 =null;

		CommonTree char_literal108_tree=null;
		RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
		RewriteRuleSubtreeStream stream_elementOptions=new RewriteRuleSubtreeStream(adaptor,"rule elementOptions");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
		RewriteRuleSubtreeStream stream_notTerminal=new RewriteRuleSubtreeStream(adaptor,"rule notTerminal");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:272:2: ( '~' ( notTerminal ( elementOptions )? -> ^( '~' notTerminal ( elementOptions )? ) | block ( elementOptions )? -> ^( '~' block ( elementOptions )? ) ) )
			// org/antlr/grammar/v3/ANTLRv3.g:272:4: '~' ( notTerminal ( elementOptions )? -> ^( '~' notTerminal ( elementOptions )? ) | block ( elementOptions )? -> ^( '~' block ( elementOptions )? ) )
			{
			char_literal108=(Token)match(input,93,FOLLOW_93_in_notSet1972); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_93.add(char_literal108);

			// org/antlr/grammar/v3/ANTLRv3.g:273:3: ( notTerminal ( elementOptions )? -> ^( '~' notTerminal ( elementOptions )? ) | block ( elementOptions )? -> ^( '~' block ( elementOptions )? ) )
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==CHAR_LITERAL||LA57_0==STRING_LITERAL||LA57_0==TOKEN_REF) ) {
				alt57=1;
			}
			else if ( (LA57_0==68) ) {
				alt57=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}

			switch (alt57) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:273:5: notTerminal ( elementOptions )?
					{
					pushFollow(FOLLOW_notTerminal_in_notSet1978);
					notTerminal109=notTerminal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_notTerminal.add(notTerminal109.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:273:17: ( elementOptions )?
					int alt55=2;
					int LA55_0 = input.LA(1);
					if ( (LA55_0==77) ) {
						alt55=1;
					}
					switch (alt55) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:273:17: elementOptions
							{
							pushFollow(FOLLOW_elementOptions_in_notSet1980);
							elementOptions110=elementOptions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_elementOptions.add(elementOptions110.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: 93, notTerminal, elementOptions
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 273:33: -> ^( '~' notTerminal ( elementOptions )? )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:273:36: ^( '~' notTerminal ( elementOptions )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_93.nextNode(), root_1);
						adaptor.addChild(root_1, stream_notTerminal.nextTree());
						// org/antlr/grammar/v3/ANTLRv3.g:273:54: ( elementOptions )?
						if ( stream_elementOptions.hasNext() ) {
							adaptor.addChild(root_1, stream_elementOptions.nextTree());
						}
						stream_elementOptions.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:274:5: block ( elementOptions )?
					{
					pushFollow(FOLLOW_block_in_notSet1998);
					block111=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block.add(block111.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:274:11: ( elementOptions )?
					int alt56=2;
					int LA56_0 = input.LA(1);
					if ( (LA56_0==77) ) {
						alt56=1;
					}
					switch (alt56) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:274:11: elementOptions
							{
							pushFollow(FOLLOW_elementOptions_in_notSet2000);
							elementOptions112=elementOptions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_elementOptions.add(elementOptions112.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: block, elementOptions, 93
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 274:28: -> ^( '~' block ( elementOptions )? )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:274:31: ^( '~' block ( elementOptions )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_93.nextNode(), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						// org/antlr/grammar/v3/ANTLRv3.g:274:43: ( elementOptions )?
						if ( stream_elementOptions.hasNext() ) {
							adaptor.addChild(root_1, stream_elementOptions.nextTree());
						}
						stream_elementOptions.reset();

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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "notSet"


	public static class notTerminal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "notTerminal"
	// org/antlr/grammar/v3/ANTLRv3.g:278:1: notTerminal : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL );
	public final ANTLRv3Parser.notTerminal_return notTerminal() throws RecognitionException {
		ANTLRv3Parser.notTerminal_return retval = new ANTLRv3Parser.notTerminal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set113=null;

		CommonTree set113_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:279:2: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL )
			// org/antlr/grammar/v3/ANTLRv3.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set113=input.LT(1);
			if ( input.LA(1)==CHAR_LITERAL||input.LA(1)==STRING_LITERAL||input.LA(1)==TOKEN_REF ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set113));
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "notTerminal"


	public static class elementOptions_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "elementOptions"
	// org/antlr/grammar/v3/ANTLRv3.g:284:1: elementOptions : ( '<' qid '>' -> ^( OPTIONS qid ) | '<' option ( ';' option )* '>' -> ^( OPTIONS ( option )+ ) );
	public final ANTLRv3Parser.elementOptions_return elementOptions() throws RecognitionException {
		ANTLRv3Parser.elementOptions_return retval = new ANTLRv3Parser.elementOptions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal114=null;
		Token char_literal116=null;
		Token char_literal117=null;
		Token char_literal119=null;
		Token char_literal121=null;
		ParserRuleReturnScope qid115 =null;
		ParserRuleReturnScope option118 =null;
		ParserRuleReturnScope option120 =null;

		CommonTree char_literal114_tree=null;
		CommonTree char_literal116_tree=null;
		CommonTree char_literal117_tree=null;
		CommonTree char_literal119_tree=null;
		CommonTree char_literal121_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_qid=new RewriteRuleSubtreeStream(adaptor,"rule qid");
		RewriteRuleSubtreeStream stream_option=new RewriteRuleSubtreeStream(adaptor,"rule option");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:285:2: ( '<' qid '>' -> ^( OPTIONS qid ) | '<' option ( ';' option )* '>' -> ^( OPTIONS ( option )+ ) )
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==77) ) {
				int LA59_1 = input.LA(2);
				if ( (LA59_1==TOKEN_REF) ) {
					int LA59_2 = input.LA(3);
					if ( (LA59_2==73||LA59_2==79) ) {
						alt59=1;
					}
					else if ( (LA59_2==LABEL_ASSIGN) ) {
						alt59=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 59, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA59_1==RULE_REF) ) {
					int LA59_3 = input.LA(3);
					if ( (LA59_3==73||LA59_3==79) ) {
						alt59=1;
					}
					else if ( (LA59_3==LABEL_ASSIGN) ) {
						alt59=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 59, 3, input);
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
							new NoViableAltException("", 59, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}

			switch (alt59) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:285:4: '<' qid '>'
					{
					char_literal114=(Token)match(input,77,FOLLOW_77_in_elementOptions2052); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_77.add(char_literal114);

					pushFollow(FOLLOW_qid_in_elementOptions2054);
					qid115=qid();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qid.add(qid115.getTree());
					char_literal116=(Token)match(input,79,FOLLOW_79_in_elementOptions2056); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_79.add(char_literal116);

					// AST REWRITE
					// elements: qid
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 285:21: -> ^( OPTIONS qid )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:285:24: ^( OPTIONS qid )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONS, "OPTIONS"), root_1);
						adaptor.addChild(root_1, stream_qid.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:286:4: '<' option ( ';' option )* '>'
					{
					char_literal117=(Token)match(input,77,FOLLOW_77_in_elementOptions2074); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_77.add(char_literal117);

					pushFollow(FOLLOW_option_in_elementOptions2076);
					option118=option();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_option.add(option118.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:286:15: ( ';' option )*
					loop58:
					while (true) {
						int alt58=2;
						int LA58_0 = input.LA(1);
						if ( (LA58_0==76) ) {
							alt58=1;
						}

						switch (alt58) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:286:16: ';' option
							{
							char_literal119=(Token)match(input,76,FOLLOW_76_in_elementOptions2079); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_76.add(char_literal119);

							pushFollow(FOLLOW_option_in_elementOptions2081);
							option120=option();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_option.add(option120.getTree());
							}
							break;

						default :
							break loop58;
						}
					}

					char_literal121=(Token)match(input,79,FOLLOW_79_in_elementOptions2085); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_79.add(char_literal121);

					// AST REWRITE
					// elements: option
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 286:33: -> ^( OPTIONS ( option )+ )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:286:36: ^( OPTIONS ( option )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONS, "OPTIONS"), root_1);
						if ( !(stream_option.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_option.hasNext() ) {
							adaptor.addChild(root_1, stream_option.nextTree());
						}
						stream_option.reset();

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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elementOptions"


	public static class elementOption_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "elementOption"
	// org/antlr/grammar/v3/ANTLRv3.g:289:1: elementOption : id '=' optionValue -> ^( '=' id optionValue ) ;
	public final ANTLRv3Parser.elementOption_return elementOption() throws RecognitionException {
		ANTLRv3Parser.elementOption_return retval = new ANTLRv3Parser.elementOption_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal123=null;
		ParserRuleReturnScope id122 =null;
		ParserRuleReturnScope optionValue124 =null;

		CommonTree char_literal123_tree=null;
		RewriteRuleTokenStream stream_LABEL_ASSIGN=new RewriteRuleTokenStream(adaptor,"token LABEL_ASSIGN");
		RewriteRuleSubtreeStream stream_optionValue=new RewriteRuleSubtreeStream(adaptor,"rule optionValue");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:290:2: ( id '=' optionValue -> ^( '=' id optionValue ) )
			// org/antlr/grammar/v3/ANTLRv3.g:290:4: id '=' optionValue
			{
			pushFollow(FOLLOW_id_in_elementOption2105);
			id122=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id122.getTree());
			char_literal123=(Token)match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_elementOption2107); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LABEL_ASSIGN.add(char_literal123);

			pushFollow(FOLLOW_optionValue_in_elementOption2109);
			optionValue124=optionValue();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optionValue.add(optionValue124.getTree());
			// AST REWRITE
			// elements: optionValue, LABEL_ASSIGN, id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 290:23: -> ^( '=' id optionValue )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:290:26: ^( '=' id optionValue )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_LABEL_ASSIGN.nextNode(), root_1);
				adaptor.addChild(root_1, stream_id.nextTree());
				adaptor.addChild(root_1, stream_optionValue.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elementOption"


	public static class treeSpec_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "treeSpec"
	// org/antlr/grammar/v3/ANTLRv3.g:293:1: treeSpec : '^(' element ( element )+ ')' -> ^( TREE_BEGIN ( element )+ ) ;
	public final ANTLRv3Parser.treeSpec_return treeSpec() throws RecognitionException {
		ANTLRv3Parser.treeSpec_return retval = new ANTLRv3Parser.treeSpec_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal125=null;
		Token char_literal128=null;
		ParserRuleReturnScope element126 =null;
		ParserRuleReturnScope element127 =null;

		CommonTree string_literal125_tree=null;
		CommonTree char_literal128_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_TREE_BEGIN=new RewriteRuleTokenStream(adaptor,"token TREE_BEGIN");
		RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:294:2: ( '^(' element ( element )+ ')' -> ^( TREE_BEGIN ( element )+ ) )
			// org/antlr/grammar/v3/ANTLRv3.g:294:4: '^(' element ( element )+ ')'
			{
			string_literal125=(Token)match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_treeSpec2131); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TREE_BEGIN.add(string_literal125);

			pushFollow(FOLLOW_element_in_treeSpec2133);
			element126=element();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_element.add(element126.getTree());
			// org/antlr/grammar/v3/ANTLRv3.g:294:17: ( element )+
			int cnt60=0;
			loop60:
			while (true) {
				int alt60=2;
				int LA60_0 = input.LA(1);
				if ( (LA60_0==ACTION||LA60_0==CHAR_LITERAL||LA60_0==RULE_REF||LA60_0==SEMPRED||LA60_0==STRING_LITERAL||(LA60_0 >= TOKEN_REF && LA60_0 <= TREE_BEGIN)||LA60_0==68||LA60_0==73||LA60_0==93) ) {
					alt60=1;
				}

				switch (alt60) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:294:19: element
					{
					pushFollow(FOLLOW_element_in_treeSpec2137);
					element127=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_element.add(element127.getTree());
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

			char_literal128=(Token)match(input,69,FOLLOW_69_in_treeSpec2142); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal128);

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

			root_0 = (CommonTree)adaptor.nil();
			// 294:34: -> ^( TREE_BEGIN ( element )+ )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:294:37: ^( TREE_BEGIN ( element )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TREE_BEGIN, "TREE_BEGIN"), root_1);
				if ( !(stream_element.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_element.hasNext() ) {
					adaptor.addChild(root_1, stream_element.nextTree());
				}
				stream_element.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "treeSpec"


	public static class range_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "range"
	// org/antlr/grammar/v3/ANTLRv3.g:297:1: range : c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL ( elementOptions )? -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2 ( elementOptions )? ) ;
	public final ANTLRv3Parser.range_return range() throws RecognitionException {
		ANTLRv3Parser.range_return retval = new ANTLRv3Parser.range_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token c1=null;
		Token c2=null;
		Token RANGE129=null;
		ParserRuleReturnScope elementOptions130 =null;

		CommonTree c1_tree=null;
		CommonTree c2_tree=null;
		CommonTree RANGE129_tree=null;
		RewriteRuleTokenStream stream_CHAR_LITERAL=new RewriteRuleTokenStream(adaptor,"token CHAR_LITERAL");
		RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
		RewriteRuleSubtreeStream stream_elementOptions=new RewriteRuleSubtreeStream(adaptor,"rule elementOptions");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:298:2: (c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL ( elementOptions )? -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2 ( elementOptions )? ) )
			// org/antlr/grammar/v3/ANTLRv3.g:298:4: c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL ( elementOptions )?
			{
			c1=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range2165); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(c1);

			RANGE129=(Token)match(input,RANGE,FOLLOW_RANGE_in_range2167); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RANGE.add(RANGE129);

			c2=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range2171); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(c2);

			// org/antlr/grammar/v3/ANTLRv3.g:298:42: ( elementOptions )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==77) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:298:42: elementOptions
					{
					pushFollow(FOLLOW_elementOptions_in_range2173);
					elementOptions130=elementOptions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elementOptions.add(elementOptions130.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: c2, elementOptions, c1
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

			root_0 = (CommonTree)adaptor.nil();
			// 299:3: -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2 ( elementOptions )? )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:299:6: ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2 ( elementOptions )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHAR_RANGE, c1, ".."), root_1);
				adaptor.addChild(root_1, stream_c1.nextNode());
				adaptor.addChild(root_1, stream_c2.nextNode());
				// org/antlr/grammar/v3/ANTLRv3.g:299:37: ( elementOptions )?
				if ( stream_elementOptions.hasNext() ) {
					adaptor.addChild(root_1, stream_elementOptions.nextTree());
				}
				stream_elementOptions.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "range"


	public static class terminal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "terminal"
	// org/antlr/grammar/v3/ANTLRv3.g:302:1: terminal : ( CHAR_LITERAL ( elementOptions )? -> ^( CHAR_LITERAL ( elementOptions )? ) | TOKEN_REF ( ARG_ACTION )? ( elementOptions )? -> ^( TOKEN_REF ( ARG_ACTION )? ( elementOptions )? ) | STRING_LITERAL ( elementOptions )? -> ^( STRING_LITERAL ( elementOptions )? ) | '.' ( elementOptions )? -> ^( '.' ( elementOptions )? ) ) ( '^' -> ^( '^' $terminal) | '!' -> ^( '!' $terminal) )? ;
	public final ANTLRv3Parser.terminal_return terminal() throws RecognitionException {
		ANTLRv3Parser.terminal_return retval = new ANTLRv3Parser.terminal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token CHAR_LITERAL131=null;
		Token TOKEN_REF133=null;
		Token ARG_ACTION134=null;
		Token STRING_LITERAL136=null;
		Token char_literal138=null;
		Token char_literal140=null;
		Token char_literal141=null;
		ParserRuleReturnScope elementOptions132 =null;
		ParserRuleReturnScope elementOptions135 =null;
		ParserRuleReturnScope elementOptions137 =null;
		ParserRuleReturnScope elementOptions139 =null;

		CommonTree CHAR_LITERAL131_tree=null;
		CommonTree TOKEN_REF133_tree=null;
		CommonTree ARG_ACTION134_tree=null;
		CommonTree STRING_LITERAL136_tree=null;
		CommonTree char_literal138_tree=null;
		CommonTree char_literal140_tree=null;
		CommonTree char_literal141_tree=null;
		RewriteRuleTokenStream stream_ROOT=new RewriteRuleTokenStream(adaptor,"token ROOT");
		RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
		RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
		RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");
		RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
		RewriteRuleTokenStream stream_CHAR_LITERAL=new RewriteRuleTokenStream(adaptor,"token CHAR_LITERAL");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_elementOptions=new RewriteRuleSubtreeStream(adaptor,"rule elementOptions");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:303:5: ( ( CHAR_LITERAL ( elementOptions )? -> ^( CHAR_LITERAL ( elementOptions )? ) | TOKEN_REF ( ARG_ACTION )? ( elementOptions )? -> ^( TOKEN_REF ( ARG_ACTION )? ( elementOptions )? ) | STRING_LITERAL ( elementOptions )? -> ^( STRING_LITERAL ( elementOptions )? ) | '.' ( elementOptions )? -> ^( '.' ( elementOptions )? ) ) ( '^' -> ^( '^' $terminal) | '!' -> ^( '!' $terminal) )? )
			// org/antlr/grammar/v3/ANTLRv3.g:303:9: ( CHAR_LITERAL ( elementOptions )? -> ^( CHAR_LITERAL ( elementOptions )? ) | TOKEN_REF ( ARG_ACTION )? ( elementOptions )? -> ^( TOKEN_REF ( ARG_ACTION )? ( elementOptions )? ) | STRING_LITERAL ( elementOptions )? -> ^( STRING_LITERAL ( elementOptions )? ) | '.' ( elementOptions )? -> ^( '.' ( elementOptions )? ) ) ( '^' -> ^( '^' $terminal) | '!' -> ^( '!' $terminal) )?
			{
			// org/antlr/grammar/v3/ANTLRv3.g:303:9: ( CHAR_LITERAL ( elementOptions )? -> ^( CHAR_LITERAL ( elementOptions )? ) | TOKEN_REF ( ARG_ACTION )? ( elementOptions )? -> ^( TOKEN_REF ( ARG_ACTION )? ( elementOptions )? ) | STRING_LITERAL ( elementOptions )? -> ^( STRING_LITERAL ( elementOptions )? ) | '.' ( elementOptions )? -> ^( '.' ( elementOptions )? ) )
			int alt67=4;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				alt67=1;
				}
				break;
			case TOKEN_REF:
				{
				alt67=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt67=3;
				}
				break;
			case 73:
				{
				alt67=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}
			switch (alt67) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:303:11: CHAR_LITERAL ( elementOptions )?
					{
					CHAR_LITERAL131=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_terminal2210); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(CHAR_LITERAL131);

					// org/antlr/grammar/v3/ANTLRv3.g:303:24: ( elementOptions )?
					int alt62=2;
					int LA62_0 = input.LA(1);
					if ( (LA62_0==77) ) {
						alt62=1;
					}
					switch (alt62) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:303:24: elementOptions
							{
							pushFollow(FOLLOW_elementOptions_in_terminal2212);
							elementOptions132=elementOptions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_elementOptions.add(elementOptions132.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: CHAR_LITERAL, elementOptions
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 303:46: -> ^( CHAR_LITERAL ( elementOptions )? )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:303:49: ^( CHAR_LITERAL ( elementOptions )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_CHAR_LITERAL.nextNode(), root_1);
						// org/antlr/grammar/v3/ANTLRv3.g:303:64: ( elementOptions )?
						if ( stream_elementOptions.hasNext() ) {
							adaptor.addChild(root_1, stream_elementOptions.nextTree());
						}
						stream_elementOptions.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:305:7: TOKEN_REF ( ARG_ACTION )? ( elementOptions )?
					{
					TOKEN_REF133=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal2243); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF133);

					// org/antlr/grammar/v3/ANTLRv3.g:305:17: ( ARG_ACTION )?
					int alt63=2;
					int LA63_0 = input.LA(1);
					if ( (LA63_0==ARG_ACTION) ) {
						alt63=1;
					}
					switch (alt63) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:305:17: ARG_ACTION
							{
							ARG_ACTION134=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_terminal2245); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ARG_ACTION.add(ARG_ACTION134);

							}
							break;

					}

					// org/antlr/grammar/v3/ANTLRv3.g:305:29: ( elementOptions )?
					int alt64=2;
					int LA64_0 = input.LA(1);
					if ( (LA64_0==77) ) {
						alt64=1;
					}
					switch (alt64) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:305:29: elementOptions
							{
							pushFollow(FOLLOW_elementOptions_in_terminal2248);
							elementOptions135=elementOptions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_elementOptions.add(elementOptions135.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: elementOptions, ARG_ACTION, TOKEN_REF
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 305:45: -> ^( TOKEN_REF ( ARG_ACTION )? ( elementOptions )? )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:305:48: ^( TOKEN_REF ( ARG_ACTION )? ( elementOptions )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_TOKEN_REF.nextNode(), root_1);
						// org/antlr/grammar/v3/ANTLRv3.g:305:60: ( ARG_ACTION )?
						if ( stream_ARG_ACTION.hasNext() ) {
							adaptor.addChild(root_1, stream_ARG_ACTION.nextNode());
						}
						stream_ARG_ACTION.reset();

						// org/antlr/grammar/v3/ANTLRv3.g:305:72: ( elementOptions )?
						if ( stream_elementOptions.hasNext() ) {
							adaptor.addChild(root_1, stream_elementOptions.nextTree());
						}
						stream_elementOptions.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:306:7: STRING_LITERAL ( elementOptions )?
					{
					STRING_LITERAL136=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal2269); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING_LITERAL.add(STRING_LITERAL136);

					// org/antlr/grammar/v3/ANTLRv3.g:306:22: ( elementOptions )?
					int alt65=2;
					int LA65_0 = input.LA(1);
					if ( (LA65_0==77) ) {
						alt65=1;
					}
					switch (alt65) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:306:22: elementOptions
							{
							pushFollow(FOLLOW_elementOptions_in_terminal2271);
							elementOptions137=elementOptions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_elementOptions.add(elementOptions137.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: elementOptions, STRING_LITERAL
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 306:41: -> ^( STRING_LITERAL ( elementOptions )? )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:306:44: ^( STRING_LITERAL ( elementOptions )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_STRING_LITERAL.nextNode(), root_1);
						// org/antlr/grammar/v3/ANTLRv3.g:306:61: ( elementOptions )?
						if ( stream_elementOptions.hasNext() ) {
							adaptor.addChild(root_1, stream_elementOptions.nextTree());
						}
						stream_elementOptions.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:307:7: '.' ( elementOptions )?
					{
					char_literal138=(Token)match(input,73,FOLLOW_73_in_terminal2292); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal138);

					// org/antlr/grammar/v3/ANTLRv3.g:307:11: ( elementOptions )?
					int alt66=2;
					int LA66_0 = input.LA(1);
					if ( (LA66_0==77) ) {
						alt66=1;
					}
					switch (alt66) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:307:11: elementOptions
							{
							pushFollow(FOLLOW_elementOptions_in_terminal2294);
							elementOptions139=elementOptions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_elementOptions.add(elementOptions139.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: 73, elementOptions
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 307:34: -> ^( '.' ( elementOptions )? )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:307:37: ^( '.' ( elementOptions )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_73.nextNode(), root_1);
						// org/antlr/grammar/v3/ANTLRv3.g:307:43: ( elementOptions )?
						if ( stream_elementOptions.hasNext() ) {
							adaptor.addChild(root_1, stream_elementOptions.nextTree());
						}
						stream_elementOptions.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			// org/antlr/grammar/v3/ANTLRv3.g:309:3: ( '^' -> ^( '^' $terminal) | '!' -> ^( '!' $terminal) )?
			int alt68=3;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==ROOT) ) {
				alt68=1;
			}
			else if ( (LA68_0==BANG) ) {
				alt68=2;
			}
			switch (alt68) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:309:5: '^'
					{
					char_literal140=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2321); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ROOT.add(char_literal140);

					// AST REWRITE
					// elements: ROOT, terminal
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 309:15: -> ^( '^' $terminal)
					{
						// org/antlr/grammar/v3/ANTLRv3.g:309:18: ^( '^' $terminal)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ROOT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:310:5: '!'
					{
					char_literal141=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2342); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BANG.add(char_literal141);

					// AST REWRITE
					// elements: BANG, terminal
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 310:15: -> ^( '!' $terminal)
					{
						// org/antlr/grammar/v3/ANTLRv3.g:310:18: ^( '!' $terminal)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_BANG.nextNode(), root_1);
						adaptor.addChild(root_1, stream_retval.nextTree());
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "terminal"


	public static class ebnf_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ebnf"
	// org/antlr/grammar/v3/ANTLRv3.g:315:1: ebnf : block (op= '?' -> ^( OPTIONAL[op] block ) |op= '*' -> ^( CLOSURE[op] block ) |op= '+' -> ^( POSITIVE_CLOSURE[op] block ) | '=>' -> {gtype==COMBINED_GRAMMAR &&\n\t\t\t\t\t Character.isUpperCase($rule::name.charAt(0))}? ^( SYNPRED[\"=>\"] block ) -> SYN_SEMPRED | -> block ) ;
	public final ANTLRv3Parser.ebnf_return ebnf() throws RecognitionException {
		ANTLRv3Parser.ebnf_return retval = new ANTLRv3Parser.ebnf_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token op=null;
		Token string_literal143=null;
		ParserRuleReturnScope block142 =null;

		CommonTree op_tree=null;
		CommonTree string_literal143_tree=null;
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");


		    Token firstToken = input.LT(1);

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:323:2: ( block (op= '?' -> ^( OPTIONAL[op] block ) |op= '*' -> ^( CLOSURE[op] block ) |op= '+' -> ^( POSITIVE_CLOSURE[op] block ) | '=>' -> {gtype==COMBINED_GRAMMAR &&\n\t\t\t\t\t Character.isUpperCase($rule::name.charAt(0))}? ^( SYNPRED[\"=>\"] block ) -> SYN_SEMPRED | -> block ) )
			// org/antlr/grammar/v3/ANTLRv3.g:323:4: block (op= '?' -> ^( OPTIONAL[op] block ) |op= '*' -> ^( CLOSURE[op] block ) |op= '+' -> ^( POSITIVE_CLOSURE[op] block ) | '=>' -> {gtype==COMBINED_GRAMMAR &&\n\t\t\t\t\t Character.isUpperCase($rule::name.charAt(0))}? ^( SYNPRED[\"=>\"] block ) -> SYN_SEMPRED | -> block )
			{
			pushFollow(FOLLOW_block_in_ebnf2385);
			block142=block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block.add(block142.getTree());
			// org/antlr/grammar/v3/ANTLRv3.g:324:3: (op= '?' -> ^( OPTIONAL[op] block ) |op= '*' -> ^( CLOSURE[op] block ) |op= '+' -> ^( POSITIVE_CLOSURE[op] block ) | '=>' -> {gtype==COMBINED_GRAMMAR &&\n\t\t\t\t\t Character.isUpperCase($rule::name.charAt(0))}? ^( SYNPRED[\"=>\"] block ) -> SYN_SEMPRED | -> block )
			int alt69=5;
			switch ( input.LA(1) ) {
			case 80:
				{
				alt69=1;
				}
				break;
			case 70:
				{
				alt69=2;
				}
				break;
			case 71:
				{
				alt69=3;
				}
				break;
			case 78:
				{
				alt69=4;
				}
				break;
			case ACTION:
			case CHAR_LITERAL:
			case REWRITE:
			case RULE_REF:
			case SEMPRED:
			case STRING_LITERAL:
			case TOKEN_REF:
			case TREE_BEGIN:
			case 68:
			case 69:
			case 73:
			case 76:
			case 91:
			case 93:
				{
				alt69=5;
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
					// org/antlr/grammar/v3/ANTLRv3.g:324:5: op= '?'
					{
					op=(Token)match(input,80,FOLLOW_80_in_ebnf2393); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_80.add(op);

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

					root_0 = (CommonTree)adaptor.nil();
					// 324:12: -> ^( OPTIONAL[op] block )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:324:15: ^( OPTIONAL[op] block )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, op), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:325:5: op= '*'
					{
					op=(Token)match(input,70,FOLLOW_70_in_ebnf2410); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(op);

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

					root_0 = (CommonTree)adaptor.nil();
					// 325:12: -> ^( CLOSURE[op] block )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:325:15: ^( CLOSURE[op] block )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CLOSURE, op), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:326:5: op= '+'
					{
					op=(Token)match(input,71,FOLLOW_71_in_ebnf2427); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_71.add(op);

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

					root_0 = (CommonTree)adaptor.nil();
					// 326:12: -> ^( POSITIVE_CLOSURE[op] block )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:326:15: ^( POSITIVE_CLOSURE[op] block )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(POSITIVE_CLOSURE, op), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:327:7: '=>'
					{
					string_literal143=(Token)match(input,78,FOLLOW_78_in_ebnf2444); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_78.add(string_literal143);

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

					root_0 = (CommonTree)adaptor.nil();
					// 328:6: -> {gtype==COMBINED_GRAMMAR &&\n\t\t\t\t\t Character.isUpperCase($rule::name.charAt(0))}? ^( SYNPRED[\"=>\"] block )
					if (gtype==COMBINED_GRAMMAR &&
										    Character.isUpperCase(rule_stack.peek().name.charAt(0))) {
						// org/antlr/grammar/v3/ANTLRv3.g:331:9: ^( SYNPRED[\"=>\"] block )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SYNPRED, "=>"), root_1);
						adaptor.addChild(root_1, stream_block.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 333:6: -> SYN_SEMPRED
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(SYN_SEMPRED, "SYN_SEMPRED"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRv3.g:334:13: 
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

					root_0 = (CommonTree)adaptor.nil();
					// 334:13: -> block
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
				retval.tree.getToken().setLine(firstToken.getLine());
				retval.tree.getToken().setCharPositionInLine(firstToken.getCharPositionInLine());
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ebnf"


	public static class ebnfSuffix_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ebnfSuffix"
	// org/antlr/grammar/v3/ANTLRv3.g:338:1: ebnfSuffix : ( '?' -> OPTIONAL[op] | '*' -> CLOSURE[op] | '+' -> POSITIVE_CLOSURE[op] );
	public final ANTLRv3Parser.ebnfSuffix_return ebnfSuffix() throws RecognitionException {
		ANTLRv3Parser.ebnfSuffix_return retval = new ANTLRv3Parser.ebnfSuffix_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal144=null;
		Token char_literal145=null;
		Token char_literal146=null;

		CommonTree char_literal144_tree=null;
		CommonTree char_literal145_tree=null;
		CommonTree char_literal146_tree=null;
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");


			Token op = input.LT(1);

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:342:2: ( '?' -> OPTIONAL[op] | '*' -> CLOSURE[op] | '+' -> POSITIVE_CLOSURE[op] )
			int alt70=3;
			switch ( input.LA(1) ) {
			case 80:
				{
				alt70=1;
				}
				break;
			case 70:
				{
				alt70=2;
				}
				break;
			case 71:
				{
				alt70=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 70, 0, input);
				throw nvae;
			}
			switch (alt70) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:342:4: '?'
					{
					char_literal144=(Token)match(input,80,FOLLOW_80_in_ebnfSuffix2529); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_80.add(char_literal144);

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

					root_0 = (CommonTree)adaptor.nil();
					// 342:8: -> OPTIONAL[op]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTIONAL, op));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:343:6: '*'
					{
					char_literal145=(Token)match(input,70,FOLLOW_70_in_ebnfSuffix2541); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal145);

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

					root_0 = (CommonTree)adaptor.nil();
					// 343:10: -> CLOSURE[op]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(CLOSURE, op));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:344:7: '+'
					{
					char_literal146=(Token)match(input,71,FOLLOW_71_in_ebnfSuffix2554); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_71.add(char_literal146);

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

					root_0 = (CommonTree)adaptor.nil();
					// 344:11: -> POSITIVE_CLOSURE[op]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(POSITIVE_CLOSURE, op));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ebnfSuffix"


	public static class rewrite_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite"
	// org/antlr/grammar/v3/ANTLRv3.g:351:1: rewrite : ( (rew+= '->' preds+= SEMPRED predicated+= rewrite_alternative )* rew2= '->' last= rewrite_alternative -> ( ^( $rew $preds $predicated) )* ^( $rew2 $last) |);
	public final ANTLRv3Parser.rewrite_return rewrite() throws RecognitionException {
		ANTLRv3Parser.rewrite_return retval = new ANTLRv3Parser.rewrite_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token rew2=null;
		Token rew=null;
		Token preds=null;
		List<Object> list_rew=null;
		List<Object> list_preds=null;
		List<Object> list_predicated=null;
		ParserRuleReturnScope last =null;
		RuleReturnScope predicated = null;
		CommonTree rew2_tree=null;
		CommonTree rew_tree=null;
		CommonTree preds_tree=null;
		RewriteRuleTokenStream stream_REWRITE=new RewriteRuleTokenStream(adaptor,"token REWRITE");
		RewriteRuleTokenStream stream_SEMPRED=new RewriteRuleTokenStream(adaptor,"token SEMPRED");
		RewriteRuleSubtreeStream stream_rewrite_alternative=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_alternative");


			Token firstToken = input.LT(1);

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:355:2: ( (rew+= '->' preds+= SEMPRED predicated+= rewrite_alternative )* rew2= '->' last= rewrite_alternative -> ( ^( $rew $preds $predicated) )* ^( $rew2 $last) |)
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==REWRITE) ) {
				alt72=1;
			}
			else if ( (LA72_0==69||LA72_0==76||LA72_0==91) ) {
				alt72=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}

			switch (alt72) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:355:4: (rew+= '->' preds+= SEMPRED predicated+= rewrite_alternative )* rew2= '->' last= rewrite_alternative
					{
					// org/antlr/grammar/v3/ANTLRv3.g:355:4: (rew+= '->' preds+= SEMPRED predicated+= rewrite_alternative )*
					loop71:
					while (true) {
						int alt71=2;
						int LA71_0 = input.LA(1);
						if ( (LA71_0==REWRITE) ) {
							int LA71_1 = input.LA(2);
							if ( (LA71_1==SEMPRED) ) {
								alt71=1;
							}

						}

						switch (alt71) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:355:5: rew+= '->' preds+= SEMPRED predicated+= rewrite_alternative
							{
							rew=(Token)match(input,REWRITE,FOLLOW_REWRITE_in_rewrite2583); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_REWRITE.add(rew);

							if (list_rew==null) list_rew=new ArrayList<Object>();
							list_rew.add(rew);
							preds=(Token)match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite2587); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMPRED.add(preds);

							if (list_preds==null) list_preds=new ArrayList<Object>();
							list_preds.add(preds);
							pushFollow(FOLLOW_rewrite_alternative_in_rewrite2591);
							predicated=rewrite_alternative();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rewrite_alternative.add(predicated.getTree());
							if (list_predicated==null) list_predicated=new ArrayList<Object>();
							list_predicated.add(predicated.getTree());
							}
							break;

						default :
							break loop71;
						}
					}

					rew2=(Token)match(input,REWRITE,FOLLOW_REWRITE_in_rewrite2599); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_REWRITE.add(rew2);

					pushFollow(FOLLOW_rewrite_alternative_in_rewrite2603);
					last=rewrite_alternative();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_alternative.add(last.getTree());
					// AST REWRITE
					// elements: preds, predicated, last, rew2, rew
					// token labels: rew2
					// rule labels: last, retval
					// token list labels: rew, preds
					// rule list labels: predicated
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_rew2=new RewriteRuleTokenStream(adaptor,"token rew2",rew2);
					RewriteRuleTokenStream stream_rew=new RewriteRuleTokenStream(adaptor,"token rew", list_rew);
					RewriteRuleTokenStream stream_preds=new RewriteRuleTokenStream(adaptor,"token preds", list_preds);
					RewriteRuleSubtreeStream stream_last=new RewriteRuleSubtreeStream(adaptor,"rule last",last!=null?last.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
					RewriteRuleSubtreeStream stream_predicated=new RewriteRuleSubtreeStream(adaptor,"token predicated",list_predicated);
					root_0 = (CommonTree)adaptor.nil();
					// 357:9: -> ( ^( $rew $preds $predicated) )* ^( $rew2 $last)
					{
						// org/antlr/grammar/v3/ANTLRv3.g:357:12: ( ^( $rew $preds $predicated) )*
						while ( stream_preds.hasNext()||stream_predicated.hasNext()||stream_rew.hasNext() ) {
							// org/antlr/grammar/v3/ANTLRv3.g:357:12: ^( $rew $preds $predicated)
							{
							CommonTree root_1 = (CommonTree)adaptor.nil();
							root_1 = (CommonTree)adaptor.becomeRoot(stream_rew.nextNode(), root_1);
							adaptor.addChild(root_1, stream_preds.nextNode());
							adaptor.addChild(root_1, stream_predicated.nextTree());
							adaptor.addChild(root_0, root_1);
							}

						}
						stream_preds.reset();
						stream_predicated.reset();
						stream_rew.reset();

						// org/antlr/grammar/v3/ANTLRv3.g:357:40: ^( $rew2 $last)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_rew2.nextNode(), root_1);
						adaptor.addChild(root_1, stream_last.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:359:2: 
					{
					root_0 = (CommonTree)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite"


	public static class rewrite_alternative_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_alternative"
	// org/antlr/grammar/v3/ANTLRv3.g:361:1: rewrite_alternative options {backtrack=true; } : ( rewrite_template | rewrite_tree_alternative | -> ^( ALT[\"ALT\"] EPSILON[\"EPSILON\"] EOA[\"EOA\"] ) );
	public final ANTLRv3Parser.rewrite_alternative_return rewrite_alternative() throws RecognitionException {
		ANTLRv3Parser.rewrite_alternative_return retval = new ANTLRv3Parser.rewrite_alternative_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rewrite_template147 =null;
		ParserRuleReturnScope rewrite_tree_alternative148 =null;


		try {
			// org/antlr/grammar/v3/ANTLRv3.g:363:2: ( rewrite_template | rewrite_tree_alternative | -> ^( ALT[\"ALT\"] EPSILON[\"EPSILON\"] EOA[\"EOA\"] ) )
			int alt73=3;
			switch ( input.LA(1) ) {
			case TOKEN_REF:
				{
				int LA73_1 = input.LA(2);
				if ( (LA73_1==68) ) {
					switch ( input.LA(3) ) {
					case TOKEN_REF:
						{
						int LA73_10 = input.LA(4);
						if ( (LA73_10==LABEL_ASSIGN) ) {
							alt73=1;
						}
						else if ( (LA73_10==ACTION||LA73_10==ARG_ACTION||LA73_10==CHAR_LITERAL||LA73_10==RULE_REF||LA73_10==STRING_LITERAL||(LA73_10 >= TOKEN_REF && LA73_10 <= TREE_BEGIN)||(LA73_10 >= 67 && LA73_10 <= 71)||LA73_10==80) ) {
							alt73=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 73, 10, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case RULE_REF:
						{
						int LA73_11 = input.LA(4);
						if ( (LA73_11==LABEL_ASSIGN) ) {
							alt73=1;
						}
						else if ( (LA73_11==ACTION||LA73_11==CHAR_LITERAL||LA73_11==RULE_REF||LA73_11==STRING_LITERAL||(LA73_11 >= TOKEN_REF && LA73_11 <= TREE_BEGIN)||(LA73_11 >= 67 && LA73_11 <= 71)||LA73_11==80) ) {
							alt73=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 73, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 69:
						{
						alt73=1;
						}
						break;
					case ACTION:
					case CHAR_LITERAL:
					case STRING_LITERAL:
					case TREE_BEGIN:
					case 67:
					case 68:
						{
						alt73=2;
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
								new NoViableAltException("", 73, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA73_1==ACTION||LA73_1==ARG_ACTION||LA73_1==CHAR_LITERAL||LA73_1==REWRITE||LA73_1==RULE_REF||LA73_1==STRING_LITERAL||(LA73_1 >= TOKEN_REF && LA73_1 <= TREE_BEGIN)||LA73_1==67||(LA73_1 >= 69 && LA73_1 <= 71)||LA73_1==76||LA73_1==80||LA73_1==91) ) {
					alt73=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 73, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_REF:
				{
				int LA73_2 = input.LA(2);
				if ( (LA73_2==68) ) {
					switch ( input.LA(3) ) {
					case TOKEN_REF:
						{
						int LA73_10 = input.LA(4);
						if ( (LA73_10==LABEL_ASSIGN) ) {
							alt73=1;
						}
						else if ( (LA73_10==ACTION||LA73_10==ARG_ACTION||LA73_10==CHAR_LITERAL||LA73_10==RULE_REF||LA73_10==STRING_LITERAL||(LA73_10 >= TOKEN_REF && LA73_10 <= TREE_BEGIN)||(LA73_10 >= 67 && LA73_10 <= 71)||LA73_10==80) ) {
							alt73=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 73, 10, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case RULE_REF:
						{
						int LA73_11 = input.LA(4);
						if ( (LA73_11==LABEL_ASSIGN) ) {
							alt73=1;
						}
						else if ( (LA73_11==ACTION||LA73_11==CHAR_LITERAL||LA73_11==RULE_REF||LA73_11==STRING_LITERAL||(LA73_11 >= TOKEN_REF && LA73_11 <= TREE_BEGIN)||(LA73_11 >= 67 && LA73_11 <= 71)||LA73_11==80) ) {
							alt73=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 73, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 69:
						{
						alt73=1;
						}
						break;
					case ACTION:
					case CHAR_LITERAL:
					case STRING_LITERAL:
					case TREE_BEGIN:
					case 67:
					case 68:
						{
						alt73=2;
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
								new NoViableAltException("", 73, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA73_2==ACTION||LA73_2==CHAR_LITERAL||LA73_2==REWRITE||LA73_2==RULE_REF||LA73_2==STRING_LITERAL||(LA73_2 >= TOKEN_REF && LA73_2 <= TREE_BEGIN)||LA73_2==67||(LA73_2 >= 69 && LA73_2 <= 71)||LA73_2==76||LA73_2==80||LA73_2==91) ) {
					alt73=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 73, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 68:
				{
				int LA73_3 = input.LA(2);
				if ( (LA73_3==ACTION) ) {
					int LA73_8 = input.LA(3);
					if ( (LA73_8==69) ) {
						int LA73_12 = input.LA(4);
						if ( (LA73_12==68) ) {
							alt73=1;
						}
						else if ( ((LA73_12 >= 70 && LA73_12 <= 71)||LA73_12==80) ) {
							alt73=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 73, 12, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA73_8==ACTION||LA73_8==CHAR_LITERAL||LA73_8==RULE_REF||LA73_8==STRING_LITERAL||(LA73_8 >= TOKEN_REF && LA73_8 <= TREE_BEGIN)||(LA73_8 >= 67 && LA73_8 <= 68)||(LA73_8 >= 70 && LA73_8 <= 71)||LA73_8==80) ) {
						alt73=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 73, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA73_3==CHAR_LITERAL||LA73_3==RULE_REF||LA73_3==STRING_LITERAL||(LA73_3 >= TOKEN_REF && LA73_3 <= TREE_BEGIN)||(LA73_3 >= 67 && LA73_3 <= 68)) ) {
					alt73=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 73, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ACTION:
				{
				int LA73_4 = input.LA(2);
				if ( (synpred1_ANTLRv3()) ) {
					alt73=1;
				}
				else if ( (synpred2_ANTLRv3()) ) {
					alt73=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 73, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case TREE_BEGIN:
			case 67:
				{
				alt73=2;
				}
				break;
			case REWRITE:
			case 69:
			case 76:
			case 91:
				{
				alt73=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 73, 0, input);
				throw nvae;
			}
			switch (alt73) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:363:4: rewrite_template
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative2654);
					rewrite_template147=rewrite_template();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_template147.getTree());

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:364:4: rewrite_tree_alternative
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_rewrite_tree_alternative_in_rewrite_alternative2659);
					rewrite_tree_alternative148=rewrite_tree_alternative();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_tree_alternative148.getTree());

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:365:29: 
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

					root_0 = (CommonTree)adaptor.nil();
					// 365:29: -> ^( ALT[\"ALT\"] EPSILON[\"EPSILON\"] EOA[\"EOA\"] )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:365:32: ^( ALT[\"ALT\"] EPSILON[\"EPSILON\"] EOA[\"EOA\"] )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, "ALT"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(EPSILON, "EPSILON"));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(EOA, "EOA"));
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_alternative"


	public static class rewrite_tree_block_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_tree_block"
	// org/antlr/grammar/v3/ANTLRv3.g:368:1: rewrite_tree_block : lp= '(' rewrite_tree_alternative ')' -> ^( BLOCK[$lp,\"BLOCK\"] rewrite_tree_alternative EOB[$lp,\"EOB\"] ) ;
	public final ANTLRv3Parser.rewrite_tree_block_return rewrite_tree_block() throws RecognitionException {
		ANTLRv3Parser.rewrite_tree_block_return retval = new ANTLRv3Parser.rewrite_tree_block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token lp=null;
		Token char_literal150=null;
		ParserRuleReturnScope rewrite_tree_alternative149 =null;

		CommonTree lp_tree=null;
		CommonTree char_literal150_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleSubtreeStream stream_rewrite_tree_alternative=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree_alternative");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:369:5: (lp= '(' rewrite_tree_alternative ')' -> ^( BLOCK[$lp,\"BLOCK\"] rewrite_tree_alternative EOB[$lp,\"EOB\"] ) )
			// org/antlr/grammar/v3/ANTLRv3.g:369:9: lp= '(' rewrite_tree_alternative ')'
			{
			lp=(Token)match(input,68,FOLLOW_68_in_rewrite_tree_block2701); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(lp);

			pushFollow(FOLLOW_rewrite_tree_alternative_in_rewrite_tree_block2703);
			rewrite_tree_alternative149=rewrite_tree_alternative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_tree_alternative.add(rewrite_tree_alternative149.getTree());
			char_literal150=(Token)match(input,69,FOLLOW_69_in_rewrite_tree_block2705); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal150);

			// AST REWRITE
			// elements: rewrite_tree_alternative
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 370:6: -> ^( BLOCK[$lp,\"BLOCK\"] rewrite_tree_alternative EOB[$lp,\"EOB\"] )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:370:9: ^( BLOCK[$lp,\"BLOCK\"] rewrite_tree_alternative EOB[$lp,\"EOB\"] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, lp, "BLOCK"), root_1);
				adaptor.addChild(root_1, stream_rewrite_tree_alternative.nextTree());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(EOB, lp, "EOB"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_tree_block"


	public static class rewrite_tree_alternative_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_tree_alternative"
	// org/antlr/grammar/v3/ANTLRv3.g:373:1: rewrite_tree_alternative : ( rewrite_tree_element )+ -> ^( ALT[\"ALT\"] ( rewrite_tree_element )+ EOA[\"EOA\"] ) ;
	public final ANTLRv3Parser.rewrite_tree_alternative_return rewrite_tree_alternative() throws RecognitionException {
		ANTLRv3Parser.rewrite_tree_alternative_return retval = new ANTLRv3Parser.rewrite_tree_alternative_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rewrite_tree_element151 =null;

		RewriteRuleSubtreeStream stream_rewrite_tree_element=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree_element");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:374:5: ( ( rewrite_tree_element )+ -> ^( ALT[\"ALT\"] ( rewrite_tree_element )+ EOA[\"EOA\"] ) )
			// org/antlr/grammar/v3/ANTLRv3.g:374:7: ( rewrite_tree_element )+
			{
			// org/antlr/grammar/v3/ANTLRv3.g:374:7: ( rewrite_tree_element )+
			int cnt74=0;
			loop74:
			while (true) {
				int alt74=2;
				int LA74_0 = input.LA(1);
				if ( (LA74_0==ACTION||LA74_0==CHAR_LITERAL||LA74_0==RULE_REF||LA74_0==STRING_LITERAL||(LA74_0 >= TOKEN_REF && LA74_0 <= TREE_BEGIN)||(LA74_0 >= 67 && LA74_0 <= 68)) ) {
					alt74=1;
				}

				switch (alt74) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:374:7: rewrite_tree_element
					{
					pushFollow(FOLLOW_rewrite_tree_element_in_rewrite_tree_alternative2739);
					rewrite_tree_element151=rewrite_tree_element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_tree_element.add(rewrite_tree_element151.getTree());
					}
					break;

				default :
					if ( cnt74 >= 1 ) break loop74;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(74, input);
					throw eee;
				}
				cnt74++;
			}

			// AST REWRITE
			// elements: rewrite_tree_element
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 374:29: -> ^( ALT[\"ALT\"] ( rewrite_tree_element )+ EOA[\"EOA\"] )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:374:32: ^( ALT[\"ALT\"] ( rewrite_tree_element )+ EOA[\"EOA\"] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, "ALT"), root_1);
				if ( !(stream_rewrite_tree_element.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_rewrite_tree_element.hasNext() ) {
					adaptor.addChild(root_1, stream_rewrite_tree_element.nextTree());
				}
				stream_rewrite_tree_element.reset();

				adaptor.addChild(root_1, (CommonTree)adaptor.create(EOA, "EOA"));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_tree_alternative"


	public static class rewrite_tree_element_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_tree_element"
	// org/antlr/grammar/v3/ANTLRv3.g:377:1: rewrite_tree_element : ( rewrite_tree_atom | rewrite_tree_atom ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree_atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | rewrite_tree ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> rewrite_tree ) | rewrite_tree_ebnf );
	public final ANTLRv3Parser.rewrite_tree_element_return rewrite_tree_element() throws RecognitionException {
		ANTLRv3Parser.rewrite_tree_element_return retval = new ANTLRv3Parser.rewrite_tree_element_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rewrite_tree_atom152 =null;
		ParserRuleReturnScope rewrite_tree_atom153 =null;
		ParserRuleReturnScope ebnfSuffix154 =null;
		ParserRuleReturnScope rewrite_tree155 =null;
		ParserRuleReturnScope ebnfSuffix156 =null;
		ParserRuleReturnScope rewrite_tree_ebnf157 =null;

		RewriteRuleSubtreeStream stream_rewrite_tree_atom=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree_atom");
		RewriteRuleSubtreeStream stream_ebnfSuffix=new RewriteRuleSubtreeStream(adaptor,"rule ebnfSuffix");
		RewriteRuleSubtreeStream stream_rewrite_tree=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:378:2: ( rewrite_tree_atom | rewrite_tree_atom ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree_atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | rewrite_tree ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> rewrite_tree ) | rewrite_tree_ebnf )
			int alt76=4;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				int LA76_1 = input.LA(2);
				if ( (LA76_1==EOF||LA76_1==ACTION||LA76_1==CHAR_LITERAL||LA76_1==REWRITE||LA76_1==RULE_REF||LA76_1==STRING_LITERAL||(LA76_1 >= TOKEN_REF && LA76_1 <= TREE_BEGIN)||(LA76_1 >= 67 && LA76_1 <= 69)||LA76_1==76||LA76_1==91) ) {
					alt76=1;
				}
				else if ( ((LA76_1 >= 70 && LA76_1 <= 71)||LA76_1==80) ) {
					alt76=2;
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
				break;
			case TOKEN_REF:
				{
				switch ( input.LA(2) ) {
				case ARG_ACTION:
					{
					int LA76_11 = input.LA(3);
					if ( (LA76_11==EOF||LA76_11==ACTION||LA76_11==CHAR_LITERAL||LA76_11==REWRITE||LA76_11==RULE_REF||LA76_11==STRING_LITERAL||(LA76_11 >= TOKEN_REF && LA76_11 <= TREE_BEGIN)||(LA76_11 >= 67 && LA76_11 <= 69)||LA76_11==76||LA76_11==91) ) {
						alt76=1;
					}
					else if ( ((LA76_11 >= 70 && LA76_11 <= 71)||LA76_11==80) ) {
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
								new NoViableAltException("", 76, 11, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case EOF:
				case ACTION:
				case CHAR_LITERAL:
				case REWRITE:
				case RULE_REF:
				case STRING_LITERAL:
				case TOKEN_REF:
				case TREE_BEGIN:
				case 67:
				case 68:
				case 69:
				case 76:
				case 91:
					{
					alt76=1;
					}
					break;
				case 70:
				case 71:
				case 80:
					{
					alt76=2;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 76, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case RULE_REF:
				{
				int LA76_3 = input.LA(2);
				if ( (LA76_3==EOF||LA76_3==ACTION||LA76_3==CHAR_LITERAL||LA76_3==REWRITE||LA76_3==RULE_REF||LA76_3==STRING_LITERAL||(LA76_3 >= TOKEN_REF && LA76_3 <= TREE_BEGIN)||(LA76_3 >= 67 && LA76_3 <= 69)||LA76_3==76||LA76_3==91) ) {
					alt76=1;
				}
				else if ( ((LA76_3 >= 70 && LA76_3 <= 71)||LA76_3==80) ) {
					alt76=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 76, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case STRING_LITERAL:
				{
				int LA76_4 = input.LA(2);
				if ( (LA76_4==EOF||LA76_4==ACTION||LA76_4==CHAR_LITERAL||LA76_4==REWRITE||LA76_4==RULE_REF||LA76_4==STRING_LITERAL||(LA76_4 >= TOKEN_REF && LA76_4 <= TREE_BEGIN)||(LA76_4 >= 67 && LA76_4 <= 69)||LA76_4==76||LA76_4==91) ) {
					alt76=1;
				}
				else if ( ((LA76_4 >= 70 && LA76_4 <= 71)||LA76_4==80) ) {
					alt76=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 76, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 67:
				{
				int LA76_5 = input.LA(2);
				if ( (LA76_5==TOKEN_REF) ) {
					int LA76_12 = input.LA(3);
					if ( (LA76_12==EOF||LA76_12==ACTION||LA76_12==CHAR_LITERAL||LA76_12==REWRITE||LA76_12==RULE_REF||LA76_12==STRING_LITERAL||(LA76_12 >= TOKEN_REF && LA76_12 <= TREE_BEGIN)||(LA76_12 >= 67 && LA76_12 <= 69)||LA76_12==76||LA76_12==91) ) {
						alt76=1;
					}
					else if ( ((LA76_12 >= 70 && LA76_12 <= 71)||LA76_12==80) ) {
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
								new NoViableAltException("", 76, 12, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA76_5==RULE_REF) ) {
					int LA76_13 = input.LA(3);
					if ( (LA76_13==EOF||LA76_13==ACTION||LA76_13==CHAR_LITERAL||LA76_13==REWRITE||LA76_13==RULE_REF||LA76_13==STRING_LITERAL||(LA76_13 >= TOKEN_REF && LA76_13 <= TREE_BEGIN)||(LA76_13 >= 67 && LA76_13 <= 69)||LA76_13==76||LA76_13==91) ) {
						alt76=1;
					}
					else if ( ((LA76_13 >= 70 && LA76_13 <= 71)||LA76_13==80) ) {
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
								new NoViableAltException("", 76, 13, input);
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
							new NoViableAltException("", 76, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ACTION:
				{
				int LA76_6 = input.LA(2);
				if ( (LA76_6==EOF||LA76_6==ACTION||LA76_6==CHAR_LITERAL||LA76_6==REWRITE||LA76_6==RULE_REF||LA76_6==STRING_LITERAL||(LA76_6 >= TOKEN_REF && LA76_6 <= TREE_BEGIN)||(LA76_6 >= 67 && LA76_6 <= 69)||LA76_6==76||LA76_6==91) ) {
					alt76=1;
				}
				else if ( ((LA76_6 >= 70 && LA76_6 <= 71)||LA76_6==80) ) {
					alt76=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 76, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case TREE_BEGIN:
				{
				alt76=3;
				}
				break;
			case 68:
				{
				alt76=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				throw nvae;
			}
			switch (alt76) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:378:4: rewrite_tree_atom
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree_element2767);
					rewrite_tree_atom152=rewrite_tree_atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_tree_atom152.getTree());

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:379:4: rewrite_tree_atom ebnfSuffix
					{
					pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree_element2772);
					rewrite_tree_atom153=rewrite_tree_atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_tree_atom.add(rewrite_tree_atom153.getTree());
					pushFollow(FOLLOW_ebnfSuffix_in_rewrite_tree_element2774);
					ebnfSuffix154=ebnfSuffix();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_ebnfSuffix.add(ebnfSuffix154.getTree());
					// AST REWRITE
					// elements: ebnfSuffix, rewrite_tree_atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 380:3: -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree_atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:380:6: ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree_atom EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);
						// org/antlr/grammar/v3/ANTLRv3.g:380:20: ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree_atom EOA[\"EOA\"] ) EOB[\"EOB\"] )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_2);
						// org/antlr/grammar/v3/ANTLRv3.g:380:37: ^( ALT[\"ALT\"] rewrite_tree_atom EOA[\"EOA\"] )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, "ALT"), root_3);
						adaptor.addChild(root_3, stream_rewrite_tree_atom.nextTree());
						adaptor.addChild(root_3, (CommonTree)adaptor.create(EOA, "EOA"));
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_2, (CommonTree)adaptor.create(EOB, "EOB"));
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:381:6: rewrite_tree ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> rewrite_tree )
					{
					pushFollow(FOLLOW_rewrite_tree_in_rewrite_tree_element2808);
					rewrite_tree155=rewrite_tree();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_tree.add(rewrite_tree155.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:382:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree EOA[\"EOA\"] ) EOB[\"EOB\"] ) ) | -> rewrite_tree )
					int alt75=2;
					int LA75_0 = input.LA(1);
					if ( ((LA75_0 >= 70 && LA75_0 <= 71)||LA75_0==80) ) {
						alt75=1;
					}
					else if ( (LA75_0==EOF||LA75_0==ACTION||LA75_0==CHAR_LITERAL||LA75_0==REWRITE||LA75_0==RULE_REF||LA75_0==STRING_LITERAL||(LA75_0 >= TOKEN_REF && LA75_0 <= TREE_BEGIN)||(LA75_0 >= 67 && LA75_0 <= 69)||LA75_0==76||LA75_0==91) ) {
						alt75=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 75, 0, input);
						throw nvae;
					}

					switch (alt75) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:382:5: ebnfSuffix
							{
							pushFollow(FOLLOW_ebnfSuffix_in_rewrite_tree_element2814);
							ebnfSuffix156=ebnfSuffix();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_ebnfSuffix.add(ebnfSuffix156.getTree());
							// AST REWRITE
							// elements: rewrite_tree, ebnfSuffix
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 383:4: -> ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
							{
								// org/antlr/grammar/v3/ANTLRv3.g:383:7: ^( ebnfSuffix ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree EOA[\"EOA\"] ) EOB[\"EOB\"] ) )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);
								// org/antlr/grammar/v3/ANTLRv3.g:383:20: ^( BLOCK[\"BLOCK\"] ^( ALT[\"ALT\"] rewrite_tree EOA[\"EOA\"] ) EOB[\"EOB\"] )
								{
								CommonTree root_2 = (CommonTree)adaptor.nil();
								root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_2);
								// org/antlr/grammar/v3/ANTLRv3.g:383:37: ^( ALT[\"ALT\"] rewrite_tree EOA[\"EOA\"] )
								{
								CommonTree root_3 = (CommonTree)adaptor.nil();
								root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALT, "ALT"), root_3);
								adaptor.addChild(root_3, stream_rewrite_tree.nextTree());
								adaptor.addChild(root_3, (CommonTree)adaptor.create(EOA, "EOA"));
								adaptor.addChild(root_2, root_3);
								}

								adaptor.addChild(root_2, (CommonTree)adaptor.create(EOB, "EOB"));
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
							// org/antlr/grammar/v3/ANTLRv3.g:384:5: 
							{
							// AST REWRITE
							// elements: rewrite_tree
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 384:5: -> rewrite_tree
							{
								adaptor.addChild(root_0, stream_rewrite_tree.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:386:6: rewrite_tree_ebnf
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_rewrite_tree_ebnf_in_rewrite_tree_element2860);
					rewrite_tree_ebnf157=rewrite_tree_ebnf();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_tree_ebnf157.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_tree_element"


	public static class rewrite_tree_atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_tree_atom"
	// org/antlr/grammar/v3/ANTLRv3.g:389:1: rewrite_tree_atom : ( CHAR_LITERAL | TOKEN_REF ( ARG_ACTION )? -> ^( TOKEN_REF ( ARG_ACTION )? ) | RULE_REF | STRING_LITERAL |d= '$' id -> LABEL[$d,$id.text] | ACTION );
	public final ANTLRv3Parser.rewrite_tree_atom_return rewrite_tree_atom() throws RecognitionException {
		ANTLRv3Parser.rewrite_tree_atom_return retval = new ANTLRv3Parser.rewrite_tree_atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token CHAR_LITERAL158=null;
		Token TOKEN_REF159=null;
		Token ARG_ACTION160=null;
		Token RULE_REF161=null;
		Token STRING_LITERAL162=null;
		Token ACTION164=null;
		ParserRuleReturnScope id163 =null;

		CommonTree d_tree=null;
		CommonTree CHAR_LITERAL158_tree=null;
		CommonTree TOKEN_REF159_tree=null;
		CommonTree ARG_ACTION160_tree=null;
		CommonTree RULE_REF161_tree=null;
		CommonTree STRING_LITERAL162_tree=null;
		CommonTree ACTION164_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
		RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:390:5: ( CHAR_LITERAL | TOKEN_REF ( ARG_ACTION )? -> ^( TOKEN_REF ( ARG_ACTION )? ) | RULE_REF | STRING_LITERAL |d= '$' id -> LABEL[$d,$id.text] | ACTION )
			int alt78=6;
			switch ( input.LA(1) ) {
			case CHAR_LITERAL:
				{
				alt78=1;
				}
				break;
			case TOKEN_REF:
				{
				alt78=2;
				}
				break;
			case RULE_REF:
				{
				alt78=3;
				}
				break;
			case STRING_LITERAL:
				{
				alt78=4;
				}
				break;
			case 67:
				{
				alt78=5;
				}
				break;
			case ACTION:
				{
				alt78=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 78, 0, input);
				throw nvae;
			}
			switch (alt78) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:390:9: CHAR_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					CHAR_LITERAL158=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_tree_atom2876); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHAR_LITERAL158_tree = (CommonTree)adaptor.create(CHAR_LITERAL158);
					adaptor.addChild(root_0, CHAR_LITERAL158_tree);
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:391:6: TOKEN_REF ( ARG_ACTION )?
					{
					TOKEN_REF159=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_tree_atom2883); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF159);

					// org/antlr/grammar/v3/ANTLRv3.g:391:16: ( ARG_ACTION )?
					int alt77=2;
					int LA77_0 = input.LA(1);
					if ( (LA77_0==ARG_ACTION) ) {
						alt77=1;
					}
					switch (alt77) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:391:16: ARG_ACTION
							{
							ARG_ACTION160=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_tree_atom2885); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ARG_ACTION.add(ARG_ACTION160);

							}
							break;

					}

					// AST REWRITE
					// elements: TOKEN_REF, ARG_ACTION
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 391:28: -> ^( TOKEN_REF ( ARG_ACTION )? )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:391:31: ^( TOKEN_REF ( ARG_ACTION )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_TOKEN_REF.nextNode(), root_1);
						// org/antlr/grammar/v3/ANTLRv3.g:391:43: ( ARG_ACTION )?
						if ( stream_ARG_ACTION.hasNext() ) {
							adaptor.addChild(root_1, stream_ARG_ACTION.nextNode());
						}
						stream_ARG_ACTION.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:392:9: RULE_REF
					{
					root_0 = (CommonTree)adaptor.nil();


					RULE_REF161=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_tree_atom2906); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RULE_REF161_tree = (CommonTree)adaptor.create(RULE_REF161);
					adaptor.addChild(root_0, RULE_REF161_tree);
					}

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:393:6: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL162=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_tree_atom2913); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL162_tree = (CommonTree)adaptor.create(STRING_LITERAL162);
					adaptor.addChild(root_0, STRING_LITERAL162_tree);
					}

					}
					break;
				case 5 :
					// org/antlr/grammar/v3/ANTLRv3.g:394:6: d= '$' id
					{
					d=(Token)match(input,67,FOLLOW_67_in_rewrite_tree_atom2922); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_67.add(d);

					pushFollow(FOLLOW_id_in_rewrite_tree_atom2924);
					id163=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id.add(id163.getTree());
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

					root_0 = (CommonTree)adaptor.nil();
					// 394:15: -> LABEL[$d,$id.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LABEL, d, (id163!=null?input.toString(id163.start,id163.stop):null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// org/antlr/grammar/v3/ANTLRv3.g:395:4: ACTION
					{
					root_0 = (CommonTree)adaptor.nil();


					ACTION164=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_tree_atom2935); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACTION164_tree = (CommonTree)adaptor.create(ACTION164);
					adaptor.addChild(root_0, ACTION164_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_tree_atom"


	public static class rewrite_tree_ebnf_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_tree_ebnf"
	// org/antlr/grammar/v3/ANTLRv3.g:398:1: rewrite_tree_ebnf : rewrite_tree_block ebnfSuffix -> ^( ebnfSuffix rewrite_tree_block ) ;
	public final ANTLRv3Parser.rewrite_tree_ebnf_return rewrite_tree_ebnf() throws RecognitionException {
		ANTLRv3Parser.rewrite_tree_ebnf_return retval = new ANTLRv3Parser.rewrite_tree_ebnf_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rewrite_tree_block165 =null;
		ParserRuleReturnScope ebnfSuffix166 =null;

		RewriteRuleSubtreeStream stream_rewrite_tree_block=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree_block");
		RewriteRuleSubtreeStream stream_ebnfSuffix=new RewriteRuleSubtreeStream(adaptor,"rule ebnfSuffix");


		    Token firstToken = input.LT(1);

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:406:2: ( rewrite_tree_block ebnfSuffix -> ^( ebnfSuffix rewrite_tree_block ) )
			// org/antlr/grammar/v3/ANTLRv3.g:406:4: rewrite_tree_block ebnfSuffix
			{
			pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf2956);
			rewrite_tree_block165=rewrite_tree_block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_tree_block.add(rewrite_tree_block165.getTree());
			pushFollow(FOLLOW_ebnfSuffix_in_rewrite_tree_ebnf2958);
			ebnfSuffix166=ebnfSuffix();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ebnfSuffix.add(ebnfSuffix166.getTree());
			// AST REWRITE
			// elements: ebnfSuffix, rewrite_tree_block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 406:34: -> ^( ebnfSuffix rewrite_tree_block )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:406:37: ^( ebnfSuffix rewrite_tree_block )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);
				adaptor.addChild(root_1, stream_rewrite_tree_block.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
				retval.tree.getToken().setLine(firstToken.getLine());
				retval.tree.getToken().setCharPositionInLine(firstToken.getCharPositionInLine());
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_tree_ebnf"


	public static class rewrite_tree_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_tree"
	// org/antlr/grammar/v3/ANTLRv3.g:409:1: rewrite_tree : '^(' rewrite_tree_atom ( rewrite_tree_element )* ')' -> ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* ) ;
	public final ANTLRv3Parser.rewrite_tree_return rewrite_tree() throws RecognitionException {
		ANTLRv3Parser.rewrite_tree_return retval = new ANTLRv3Parser.rewrite_tree_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal167=null;
		Token char_literal170=null;
		ParserRuleReturnScope rewrite_tree_atom168 =null;
		ParserRuleReturnScope rewrite_tree_element169 =null;

		CommonTree string_literal167_tree=null;
		CommonTree char_literal170_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_TREE_BEGIN=new RewriteRuleTokenStream(adaptor,"token TREE_BEGIN");
		RewriteRuleSubtreeStream stream_rewrite_tree_atom=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree_atom");
		RewriteRuleSubtreeStream stream_rewrite_tree_element=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree_element");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:410:2: ( '^(' rewrite_tree_atom ( rewrite_tree_element )* ')' -> ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* ) )
			// org/antlr/grammar/v3/ANTLRv3.g:410:4: '^(' rewrite_tree_atom ( rewrite_tree_element )* ')'
			{
			string_literal167=(Token)match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree2978); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TREE_BEGIN.add(string_literal167);

			pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree2980);
			rewrite_tree_atom168=rewrite_tree_atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_tree_atom.add(rewrite_tree_atom168.getTree());
			// org/antlr/grammar/v3/ANTLRv3.g:410:27: ( rewrite_tree_element )*
			loop79:
			while (true) {
				int alt79=2;
				int LA79_0 = input.LA(1);
				if ( (LA79_0==ACTION||LA79_0==CHAR_LITERAL||LA79_0==RULE_REF||LA79_0==STRING_LITERAL||(LA79_0 >= TOKEN_REF && LA79_0 <= TREE_BEGIN)||(LA79_0 >= 67 && LA79_0 <= 68)) ) {
					alt79=1;
				}

				switch (alt79) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:410:27: rewrite_tree_element
					{
					pushFollow(FOLLOW_rewrite_tree_element_in_rewrite_tree2982);
					rewrite_tree_element169=rewrite_tree_element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_tree_element.add(rewrite_tree_element169.getTree());
					}
					break;

				default :
					break loop79;
				}
			}

			char_literal170=(Token)match(input,69,FOLLOW_69_in_rewrite_tree2985); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal170);

			// AST REWRITE
			// elements: rewrite_tree_atom, rewrite_tree_element
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 411:3: -> ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:411:6: ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TREE_BEGIN, "TREE_BEGIN"), root_1);
				adaptor.addChild(root_1, stream_rewrite_tree_atom.nextTree());
				// org/antlr/grammar/v3/ANTLRv3.g:411:37: ( rewrite_tree_element )*
				while ( stream_rewrite_tree_element.hasNext() ) {
					adaptor.addChild(root_1, stream_rewrite_tree_element.nextTree());
				}
				stream_rewrite_tree_element.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_tree"


	public static class rewrite_template_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_template"
	// org/antlr/grammar/v3/ANTLRv3.g:425:1: rewrite_template : ( id lp= '(' rewrite_template_args ')' (str= DOUBLE_QUOTE_STRING_LITERAL |str= DOUBLE_ANGLE_STRING_LITERAL ) -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args $str) | rewrite_template_ref | rewrite_indirect_template_head | ACTION );
	public final ANTLRv3Parser.rewrite_template_return rewrite_template() throws RecognitionException {
		ANTLRv3Parser.rewrite_template_return retval = new ANTLRv3Parser.rewrite_template_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token lp=null;
		Token str=null;
		Token char_literal173=null;
		Token ACTION176=null;
		ParserRuleReturnScope id171 =null;
		ParserRuleReturnScope rewrite_template_args172 =null;
		ParserRuleReturnScope rewrite_template_ref174 =null;
		ParserRuleReturnScope rewrite_indirect_template_head175 =null;

		CommonTree lp_tree=null;
		CommonTree str_tree=null;
		CommonTree char_literal173_tree=null;
		CommonTree ACTION176_tree=null;
		RewriteRuleTokenStream stream_DOUBLE_QUOTE_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token DOUBLE_QUOTE_STRING_LITERAL");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_DOUBLE_ANGLE_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token DOUBLE_ANGLE_STRING_LITERAL");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
		RewriteRuleSubtreeStream stream_rewrite_template_args=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_args");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:426:2: ( id lp= '(' rewrite_template_args ')' (str= DOUBLE_QUOTE_STRING_LITERAL |str= DOUBLE_ANGLE_STRING_LITERAL ) -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args $str) | rewrite_template_ref | rewrite_indirect_template_head | ACTION )
			int alt81=4;
			alt81 = dfa81.predict(input);
			switch (alt81) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:427:3: id lp= '(' rewrite_template_args ')' (str= DOUBLE_QUOTE_STRING_LITERAL |str= DOUBLE_ANGLE_STRING_LITERAL )
					{
					pushFollow(FOLLOW_id_in_rewrite_template3017);
					id171=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id.add(id171.getTree());
					lp=(Token)match(input,68,FOLLOW_68_in_rewrite_template3021); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_68.add(lp);

					pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template3023);
					rewrite_template_args172=rewrite_template_args();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_template_args.add(rewrite_template_args172.getTree());
					char_literal173=(Token)match(input,69,FOLLOW_69_in_rewrite_template3025); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal173);

					// org/antlr/grammar/v3/ANTLRv3.g:428:3: (str= DOUBLE_QUOTE_STRING_LITERAL |str= DOUBLE_ANGLE_STRING_LITERAL )
					int alt80=2;
					int LA80_0 = input.LA(1);
					if ( (LA80_0==DOUBLE_QUOTE_STRING_LITERAL) ) {
						alt80=1;
					}
					else if ( (LA80_0==DOUBLE_ANGLE_STRING_LITERAL) ) {
						alt80=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 80, 0, input);
						throw nvae;
					}

					switch (alt80) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:428:5: str= DOUBLE_QUOTE_STRING_LITERAL
							{
							str=(Token)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template3033); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DOUBLE_QUOTE_STRING_LITERAL.add(str);

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ANTLRv3.g:428:39: str= DOUBLE_ANGLE_STRING_LITERAL
							{
							str=(Token)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template3039); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_DOUBLE_ANGLE_STRING_LITERAL.add(str);

							}
							break;

					}

					// AST REWRITE
					// elements: rewrite_template_args, str, id
					// token labels: str
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_str=new RewriteRuleTokenStream(adaptor,"token str",str);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 429:3: -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args $str)
					{
						// org/antlr/grammar/v3/ANTLRv3.g:429:6: ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args $str)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TEMPLATE, lp, "TEMPLATE"), root_1);
						adaptor.addChild(root_1, stream_id.nextTree());
						adaptor.addChild(root_1, stream_rewrite_template_args.nextTree());
						adaptor.addChild(root_1, stream_str.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:432:3: rewrite_template_ref
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_rewrite_template_ref_in_rewrite_template3066);
					rewrite_template_ref174=rewrite_template_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_template_ref174.getTree());

					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ANTLRv3.g:435:3: rewrite_indirect_template_head
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_rewrite_indirect_template_head_in_rewrite_template3075);
					rewrite_indirect_template_head175=rewrite_indirect_template_head();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_indirect_template_head175.getTree());

					}
					break;
				case 4 :
					// org/antlr/grammar/v3/ANTLRv3.g:438:3: ACTION
					{
					root_0 = (CommonTree)adaptor.nil();


					ACTION176=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template3084); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACTION176_tree = (CommonTree)adaptor.create(ACTION176);
					adaptor.addChild(root_0, ACTION176_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_template"


	public static class rewrite_template_ref_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_template_ref"
	// org/antlr/grammar/v3/ANTLRv3.g:442:1: rewrite_template_ref : id lp= '(' rewrite_template_args ')' -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args ) ;
	public final ANTLRv3Parser.rewrite_template_ref_return rewrite_template_ref() throws RecognitionException {
		ANTLRv3Parser.rewrite_template_ref_return retval = new ANTLRv3Parser.rewrite_template_ref_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token lp=null;
		Token char_literal179=null;
		ParserRuleReturnScope id177 =null;
		ParserRuleReturnScope rewrite_template_args178 =null;

		CommonTree lp_tree=null;
		CommonTree char_literal179_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
		RewriteRuleSubtreeStream stream_rewrite_template_args=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_args");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:443:2: ( id lp= '(' rewrite_template_args ')' -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args ) )
			// org/antlr/grammar/v3/ANTLRv3.g:443:4: id lp= '(' rewrite_template_args ')'
			{
			pushFollow(FOLLOW_id_in_rewrite_template_ref3097);
			id177=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id177.getTree());
			lp=(Token)match(input,68,FOLLOW_68_in_rewrite_template_ref3101); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(lp);

			pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template_ref3103);
			rewrite_template_args178=rewrite_template_args();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_template_args.add(rewrite_template_args178.getTree());
			char_literal179=(Token)match(input,69,FOLLOW_69_in_rewrite_template_ref3105); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal179);

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

			root_0 = (CommonTree)adaptor.nil();
			// 444:3: -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:444:6: ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TEMPLATE, lp, "TEMPLATE"), root_1);
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_template_ref"


	public static class rewrite_indirect_template_head_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_indirect_template_head"
	// org/antlr/grammar/v3/ANTLRv3.g:448:1: rewrite_indirect_template_head : lp= '(' ACTION ')' '(' rewrite_template_args ')' -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args ) ;
	public final ANTLRv3Parser.rewrite_indirect_template_head_return rewrite_indirect_template_head() throws RecognitionException {
		ANTLRv3Parser.rewrite_indirect_template_head_return retval = new ANTLRv3Parser.rewrite_indirect_template_head_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token lp=null;
		Token ACTION180=null;
		Token char_literal181=null;
		Token char_literal182=null;
		Token char_literal184=null;
		ParserRuleReturnScope rewrite_template_args183 =null;

		CommonTree lp_tree=null;
		CommonTree ACTION180_tree=null;
		CommonTree char_literal181_tree=null;
		CommonTree char_literal182_tree=null;
		CommonTree char_literal184_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleSubtreeStream stream_rewrite_template_args=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_args");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:449:2: (lp= '(' ACTION ')' '(' rewrite_template_args ')' -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args ) )
			// org/antlr/grammar/v3/ANTLRv3.g:449:4: lp= '(' ACTION ')' '(' rewrite_template_args ')'
			{
			lp=(Token)match(input,68,FOLLOW_68_in_rewrite_indirect_template_head3133); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(lp);

			ACTION180=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_indirect_template_head3135); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION180);

			char_literal181=(Token)match(input,69,FOLLOW_69_in_rewrite_indirect_template_head3137); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal181);

			char_literal182=(Token)match(input,68,FOLLOW_68_in_rewrite_indirect_template_head3139); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(char_literal182);

			pushFollow(FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head3141);
			rewrite_template_args183=rewrite_template_args();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rewrite_template_args.add(rewrite_template_args183.getTree());
			char_literal184=(Token)match(input,69,FOLLOW_69_in_rewrite_indirect_template_head3143); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal184);

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

			root_0 = (CommonTree)adaptor.nil();
			// 450:3: -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:450:6: ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TEMPLATE, lp, "TEMPLATE"), root_1);
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_indirect_template_head"


	public static class rewrite_template_args_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_template_args"
	// org/antlr/grammar/v3/ANTLRv3.g:453:1: rewrite_template_args : ( rewrite_template_arg ( ',' rewrite_template_arg )* -> ^( ARGLIST ( rewrite_template_arg )+ ) | -> ARGLIST );
	public final ANTLRv3Parser.rewrite_template_args_return rewrite_template_args() throws RecognitionException {
		ANTLRv3Parser.rewrite_template_args_return retval = new ANTLRv3Parser.rewrite_template_args_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal186=null;
		ParserRuleReturnScope rewrite_template_arg185 =null;
		ParserRuleReturnScope rewrite_template_arg187 =null;

		CommonTree char_literal186_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleSubtreeStream stream_rewrite_template_arg=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_arg");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:454:2: ( rewrite_template_arg ( ',' rewrite_template_arg )* -> ^( ARGLIST ( rewrite_template_arg )+ ) | -> ARGLIST )
			int alt83=2;
			int LA83_0 = input.LA(1);
			if ( (LA83_0==RULE_REF||LA83_0==TOKEN_REF) ) {
				alt83=1;
			}
			else if ( (LA83_0==69) ) {
				alt83=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 83, 0, input);
				throw nvae;
			}

			switch (alt83) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:454:4: rewrite_template_arg ( ',' rewrite_template_arg )*
					{
					pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args3167);
					rewrite_template_arg185=rewrite_template_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rewrite_template_arg.add(rewrite_template_arg185.getTree());
					// org/antlr/grammar/v3/ANTLRv3.g:454:25: ( ',' rewrite_template_arg )*
					loop82:
					while (true) {
						int alt82=2;
						int LA82_0 = input.LA(1);
						if ( (LA82_0==72) ) {
							alt82=1;
						}

						switch (alt82) {
						case 1 :
							// org/antlr/grammar/v3/ANTLRv3.g:454:26: ',' rewrite_template_arg
							{
							char_literal186=(Token)match(input,72,FOLLOW_72_in_rewrite_template_args3170); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_72.add(char_literal186);

							pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args3172);
							rewrite_template_arg187=rewrite_template_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rewrite_template_arg.add(rewrite_template_arg187.getTree());
							}
							break;

						default :
							break loop82;
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

					root_0 = (CommonTree)adaptor.nil();
					// 455:3: -> ^( ARGLIST ( rewrite_template_arg )+ )
					{
						// org/antlr/grammar/v3/ANTLRv3.g:455:6: ^( ARGLIST ( rewrite_template_arg )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGLIST, "ARGLIST"), root_1);
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
					// org/antlr/grammar/v3/ANTLRv3.g:456:4: 
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

					root_0 = (CommonTree)adaptor.nil();
					// 456:4: -> ARGLIST
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ARGLIST, "ARGLIST"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_template_args"


	public static class rewrite_template_arg_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rewrite_template_arg"
	// org/antlr/grammar/v3/ANTLRv3.g:459:1: rewrite_template_arg : id '=' ACTION -> ^( ARG[$id.start] id ACTION ) ;
	public final ANTLRv3Parser.rewrite_template_arg_return rewrite_template_arg() throws RecognitionException {
		ANTLRv3Parser.rewrite_template_arg_return retval = new ANTLRv3Parser.rewrite_template_arg_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal189=null;
		Token ACTION190=null;
		ParserRuleReturnScope id188 =null;

		CommonTree char_literal189_tree=null;
		CommonTree ACTION190_tree=null;
		RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
		RewriteRuleTokenStream stream_LABEL_ASSIGN=new RewriteRuleTokenStream(adaptor,"token LABEL_ASSIGN");
		RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:460:2: ( id '=' ACTION -> ^( ARG[$id.start] id ACTION ) )
			// org/antlr/grammar/v3/ANTLRv3.g:460:6: id '=' ACTION
			{
			pushFollow(FOLLOW_id_in_rewrite_template_arg3205);
			id188=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_id.add(id188.getTree());
			char_literal189=(Token)match(input,LABEL_ASSIGN,FOLLOW_LABEL_ASSIGN_in_rewrite_template_arg3207); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LABEL_ASSIGN.add(char_literal189);

			ACTION190=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template_arg3209); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ACTION.add(ACTION190);

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

			root_0 = (CommonTree)adaptor.nil();
			// 460:20: -> ^( ARG[$id.start] id ACTION )
			{
				// org/antlr/grammar/v3/ANTLRv3.g:460:23: ^( ARG[$id.start] id ACTION )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARG, (id188!=null?(id188.start):null)), root_1);
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
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rewrite_template_arg"


	public static class qid_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qid"
	// org/antlr/grammar/v3/ANTLRv3.g:463:1: qid : id ( '.' id )* ;
	public final ANTLRv3Parser.qid_return qid() throws RecognitionException {
		ANTLRv3Parser.qid_return retval = new ANTLRv3Parser.qid_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal192=null;
		ParserRuleReturnScope id191 =null;
		ParserRuleReturnScope id193 =null;

		CommonTree char_literal192_tree=null;

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:463:5: ( id ( '.' id )* )
			// org/antlr/grammar/v3/ANTLRv3.g:463:7: id ( '.' id )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_id_in_qid3230);
			id191=id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id191.getTree());

			// org/antlr/grammar/v3/ANTLRv3.g:463:10: ( '.' id )*
			loop84:
			while (true) {
				int alt84=2;
				int LA84_0 = input.LA(1);
				if ( (LA84_0==73) ) {
					alt84=1;
				}

				switch (alt84) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:463:11: '.' id
					{
					char_literal192=(Token)match(input,73,FOLLOW_73_in_qid3233); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal192_tree = (CommonTree)adaptor.create(char_literal192);
					adaptor.addChild(root_0, char_literal192_tree);
					}

					pushFollow(FOLLOW_id_in_qid3235);
					id193=id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id193.getTree());

					}
					break;

				default :
					break loop84;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "qid"


	public static class id_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "id"
	// org/antlr/grammar/v3/ANTLRv3.g:465:1: id : ( TOKEN_REF -> ID[$TOKEN_REF] | RULE_REF -> ID[$RULE_REF] );
	public final ANTLRv3Parser.id_return id() throws RecognitionException {
		ANTLRv3Parser.id_return retval = new ANTLRv3Parser.id_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TOKEN_REF194=null;
		Token RULE_REF195=null;

		CommonTree TOKEN_REF194_tree=null;
		CommonTree RULE_REF195_tree=null;
		RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
		RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");

		try {
			// org/antlr/grammar/v3/ANTLRv3.g:465:4: ( TOKEN_REF -> ID[$TOKEN_REF] | RULE_REF -> ID[$RULE_REF] )
			int alt85=2;
			int LA85_0 = input.LA(1);
			if ( (LA85_0==TOKEN_REF) ) {
				alt85=1;
			}
			else if ( (LA85_0==RULE_REF) ) {
				alt85=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 85, 0, input);
				throw nvae;
			}

			switch (alt85) {
				case 1 :
					// org/antlr/grammar/v3/ANTLRv3.g:465:6: TOKEN_REF
					{
					TOKEN_REF194=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_id3247); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF194);

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

					root_0 = (CommonTree)adaptor.nil();
					// 465:16: -> ID[$TOKEN_REF]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ID, TOKEN_REF194));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ANTLRv3.g:466:4: RULE_REF
					{
					RULE_REF195=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_id3257); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RULE_REF.add(RULE_REF195);

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

					root_0 = (CommonTree)adaptor.nil();
					// 466:14: -> ID[$RULE_REF]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ID, RULE_REF195));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "id"

	// $ANTLR start synpred1_ANTLRv3
	public final void synpred1_ANTLRv3_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ANTLRv3.g:363:4: ( rewrite_template )
		// org/antlr/grammar/v3/ANTLRv3.g:363:4: rewrite_template
		{
		pushFollow(FOLLOW_rewrite_template_in_synpred1_ANTLRv32654);
		rewrite_template();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_ANTLRv3

	// $ANTLR start synpred2_ANTLRv3
	public final void synpred2_ANTLRv3_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ANTLRv3.g:364:4: ( rewrite_tree_alternative )
		// org/antlr/grammar/v3/ANTLRv3.g:364:4: rewrite_tree_alternative
		{
		pushFollow(FOLLOW_rewrite_tree_alternative_in_synpred2_ANTLRv32659);
		rewrite_tree_alternative();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_ANTLRv3

	// Delegated rules

	public final boolean synpred2_ANTLRv3() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_ANTLRv3_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_ANTLRv3() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_ANTLRv3_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA81 dfa81 = new DFA81(this);
	static final String DFA81_eotS =
		"\22\uffff";
	static final String DFA81_eofS =
		"\10\uffff\1\13\11\uffff";
	static final String DFA81_minS =
		"\1\4\2\104\2\uffff\1\63\2\41\1\25\1\4\2\uffff\1\105\1\63\2\41\1\4\1\105";
	static final String DFA81_maxS =
		"\3\104\2\uffff\1\105\2\41\1\133\1\4\2\uffff\1\110\1\75\2\41\1\4\1\110";
	static final String DFA81_acceptS =
		"\3\uffff\1\3\1\4\5\uffff\1\1\1\2\6\uffff";
	static final String DFA81_specialS =
		"\22\uffff}>";
	static final String[] DFA81_transitionS = {
			"\1\4\56\uffff\1\2\11\uffff\1\1\6\uffff\1\3",
			"\1\5",
			"\1\5",
			"",
			"",
			"\1\7\11\uffff\1\6\7\uffff\1\10",
			"\1\11",
			"\1\11",
			"\2\12\31\uffff\1\13\24\uffff\1\13\6\uffff\1\13\16\uffff\1\13",
			"\1\14",
			"",
			"",
			"\1\10\2\uffff\1\15",
			"\1\17\11\uffff\1\16",
			"\1\20",
			"\1\20",
			"\1\21",
			"\1\10\2\uffff\1\15"
	};

	static final short[] DFA81_eot = DFA.unpackEncodedString(DFA81_eotS);
	static final short[] DFA81_eof = DFA.unpackEncodedString(DFA81_eofS);
	static final char[] DFA81_min = DFA.unpackEncodedStringToUnsignedChars(DFA81_minS);
	static final char[] DFA81_max = DFA.unpackEncodedStringToUnsignedChars(DFA81_maxS);
	static final short[] DFA81_accept = DFA.unpackEncodedString(DFA81_acceptS);
	static final short[] DFA81_special = DFA.unpackEncodedString(DFA81_specialS);
	static final short[][] DFA81_transition;

	static {
		int numStates = DFA81_transitionS.length;
		DFA81_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA81_transition[i] = DFA.unpackEncodedString(DFA81_transitionS[i]);
		}
	}

	protected class DFA81 extends DFA {

		public DFA81(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 81;
			this.eot = DFA81_eot;
			this.eof = DFA81_eof;
			this.min = DFA81_min;
			this.max = DFA81_max;
			this.accept = DFA81_accept;
			this.special = DFA81_special;
			this.transition = DFA81_transition;
		}
		@Override
		public String getDescription() {
			return "425:1: rewrite_template : ( id lp= '(' rewrite_template_args ')' (str= DOUBLE_QUOTE_STRING_LITERAL |str= DOUBLE_ANGLE_STRING_LITERAL ) -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args $str) | rewrite_template_ref | rewrite_indirect_template_head | ACTION );";
		}
	}

	public static final BitSet FOLLOW_DOC_COMMENT_in_grammarDef373 = new BitSet(new long[]{0x0000000000000000L,0x0000000004380000L});
	public static final BitSet FOLLOW_84_in_grammarDef383 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_85_in_grammarDef401 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_90_in_grammarDef417 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_83_in_grammarDef458 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_grammarDef460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_grammarDef462 = new BitSet(new long[]{0x3018040010101000L,0x0000000001C00000L});
	public static final BitSet FOLLOW_optionsSpec_in_grammarDef464 = new BitSet(new long[]{0x3018000010101000L,0x0000000001C00000L});
	public static final BitSet FOLLOW_tokensSpec_in_grammarDef467 = new BitSet(new long[]{0x2018000010101000L,0x0000000001C00000L});
	public static final BitSet FOLLOW_attrScope_in_grammarDef470 = new BitSet(new long[]{0x2018000010101000L,0x0000000001C00000L});
	public static final BitSet FOLLOW_action_in_grammarDef473 = new BitSet(new long[]{0x2008000010101000L,0x0000000001C00000L});
	public static final BitSet FOLLOW_rule_in_grammarDef481 = new BitSet(new long[]{0x2008000010100000L,0x0000000001C00000L});
	public static final BitSet FOLLOW_EOF_in_grammarDef489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKENS_in_tokensSpec550 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_tokenSpec_in_tokensSpec552 = new BitSet(new long[]{0x2000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_tokensSpec555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec575 = new BitSet(new long[]{0x0000000200000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_tokenSpec581 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_tokenSpec586 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_tokenSpec590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_tokenSpec629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCOPE_in_attrScope640 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_attrScope642 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_attrScope644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AT_in_action667 = new BitSet(new long[]{0x2008000000000000L,0x0000000000300000L});
	public static final BitSet FOLLOW_actionScopeName_in_action670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_75_in_action672 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_action676 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_action678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_actionScopeName704 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_actionScopeName711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_85_in_actionScopeName728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONS_in_optionsSpec744 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_option_in_optionsSpec747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_optionsSpec749 = new BitSet(new long[]{0x2008000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_optionsSpec753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_option778 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_option780 = new BitSet(new long[]{0x2108000080010000L,0x0000000000000040L});
	public static final BitSet FOLLOW_optionValue_in_option782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qid_in_optionValue811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_optionValue821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_optionValue831 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_optionValue841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_optionValue851 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOC_COMMENT_in_rule876 = new BitSet(new long[]{0x2008000010000000L,0x0000000001C00000L});
	public static final BitSet FOLLOW_87_in_rule886 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_88_in_rule888 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_86_in_rule890 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_FRAGMENT_in_rule892 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_rule900 = new BitSet(new long[]{0x0010840000005800L,0x0000000002000400L});
	public static final BitSet FOLLOW_BANG_in_rule906 = new BitSet(new long[]{0x0010840000001800L,0x0000000002000400L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule915 = new BitSet(new long[]{0x0010840000001000L,0x0000000002000400L});
	public static final BitSet FOLLOW_RET_in_rule924 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rule928 = new BitSet(new long[]{0x0010040000001000L,0x0000000002000400L});
	public static final BitSet FOLLOW_throwsSpec_in_rule936 = new BitSet(new long[]{0x0010040000001000L,0x0000000000000400L});
	public static final BitSet FOLLOW_optionsSpec_in_rule939 = new BitSet(new long[]{0x0010000000001000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ruleScopeSpec_in_rule942 = new BitSet(new long[]{0x0000000000001000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ruleAction_in_rule945 = new BitSet(new long[]{0x0000000000001000L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_rule950 = new BitSet(new long[]{0x6129000000010010L,0x0000000020000210L});
	public static final BitSet FOLLOW_altList_in_rule952 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_rule954 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
	public static final BitSet FOLLOW_exceptionGroup_in_rule958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AT_in_ruleAction1064 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_ruleAction1066 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_ruleAction1068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_throwsSpec1089 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_throwsSpec1091 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_throwsSpec1095 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_throwsSpec1097 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec1120 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec1122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec1135 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_ruleScopeSpec1137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001100L});
	public static final BitSet FOLLOW_72_in_ruleScopeSpec1140 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_ruleScopeSpec1142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001100L});
	public static final BitSet FOLLOW_76_in_ruleScopeSpec1146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec1160 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec1162 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec1166 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_ruleScopeSpec1168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001100L});
	public static final BitSet FOLLOW_72_in_ruleScopeSpec1171 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_ruleScopeSpec1173 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001100L});
	public static final BitSet FOLLOW_76_in_ruleScopeSpec1177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_block1209 = new BitSet(new long[]{0x6129040000010010L,0x0000000020000610L});
	public static final BitSet FOLLOW_optionsSpec_in_block1218 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_block1222 = new BitSet(new long[]{0x6129000000010010L,0x0000000020000210L});
	public static final BitSet FOLLOW_altpair_in_block1229 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000020L});
	public static final BitSet FOLLOW_91_in_block1233 = new BitSet(new long[]{0x6129000000010010L,0x0000000020000210L});
	public static final BitSet FOLLOW_altpair_in_block1235 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000020L});
	public static final BitSet FOLLOW_69_in_block1250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alternative_in_altpair1289 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_rewrite_in_altpair1291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_altpair_in_altList1311 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
	public static final BitSet FOLLOW_91_in_altList1315 = new BitSet(new long[]{0x6129000000010010L,0x0000000020000210L});
	public static final BitSet FOLLOW_altpair_in_altList1317 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
	public static final BitSet FOLLOW_element_in_alternative1358 = new BitSet(new long[]{0x6128000000010012L,0x0000000020000210L});
	public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1409 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_81_in_exceptionHandler1444 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1446 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_exceptionHandler1448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_finallyClause1478 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_finallyClause1480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_element1502 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_element1507 = new BitSet(new long[]{0x2108000000010000L,0x0000000020000200L});
	public static final BitSet FOLLOW_LIST_LABEL_ASSIGN_in_element1511 = new BitSet(new long[]{0x2108000000010000L,0x0000000020000200L});
	public static final BitSet FOLLOW_atom_in_element1514 = new BitSet(new long[]{0x0000000000000002L,0x00000000000100C0L});
	public static final BitSet FOLLOW_ebnfSuffix_in_element1520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_element1579 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_element1584 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_LIST_LABEL_ASSIGN_in_element1588 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_block_in_element1591 = new BitSet(new long[]{0x0000000000000002L,0x00000000000100C0L});
	public static final BitSet FOLLOW_ebnfSuffix_in_element1597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_element1656 = new BitSet(new long[]{0x0000000000000002L,0x00000000000100C0L});
	public static final BitSet FOLLOW_ebnfSuffix_in_element1662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ebnf_in_element1708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_element1715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMPRED_in_element1722 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_element1728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_treeSpec_in_element1748 = new BitSet(new long[]{0x0000000000000002L,0x00000000000100C0L});
	public static final BitSet FOLLOW_ebnfSuffix_in_element1754 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_terminal_in_atom1806 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_range_in_atom1811 = new BitSet(new long[]{0x0002000000004002L});
	public static final BitSet FOLLOW_ROOT_in_atom1821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_atom1825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notSet_in_atom1859 = new BitSet(new long[]{0x0002000000004002L});
	public static final BitSet FOLLOW_ROOT_in_atom1868 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_atom1872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_atom1908 = new BitSet(new long[]{0x0002000000004802L});
	public static final BitSet FOLLOW_ARG_ACTION_in_atom1910 = new BitSet(new long[]{0x0002000000004002L});
	public static final BitSet FOLLOW_ROOT_in_atom1920 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_atom1924 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_93_in_notSet1972 = new BitSet(new long[]{0x2100000000010000L,0x0000000000000010L});
	public static final BitSet FOLLOW_notTerminal_in_notSet1978 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_notSet1980 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_notSet1998 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_notSet2000 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_elementOptions2052 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_qid_in_elementOptions2054 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_elementOptions2056 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_elementOptions2074 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_option_in_elementOptions2076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000009000L});
	public static final BitSet FOLLOW_76_in_elementOptions2079 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_option_in_elementOptions2081 = new BitSet(new long[]{0x0000000000000000L,0x0000000000009000L});
	public static final BitSet FOLLOW_79_in_elementOptions2085 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_elementOption2105 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_elementOption2107 = new BitSet(new long[]{0x2108000080010000L,0x0000000000000040L});
	public static final BitSet FOLLOW_optionValue_in_elementOption2109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_treeSpec2131 = new BitSet(new long[]{0x6128000000010010L,0x0000000020000210L});
	public static final BitSet FOLLOW_element_in_treeSpec2133 = new BitSet(new long[]{0x6128000000010010L,0x0000000020000210L});
	public static final BitSet FOLLOW_element_in_treeSpec2137 = new BitSet(new long[]{0x6128000000010010L,0x0000000020000230L});
	public static final BitSet FOLLOW_69_in_treeSpec2142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_range2165 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_RANGE_in_range2167 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_range2171 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_range2173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_terminal2210 = new BitSet(new long[]{0x0002000000004002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_terminal2212 = new BitSet(new long[]{0x0002000000004002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_terminal2243 = new BitSet(new long[]{0x0002000000004802L,0x0000000000002000L});
	public static final BitSet FOLLOW_ARG_ACTION_in_terminal2245 = new BitSet(new long[]{0x0002000000004002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_terminal2248 = new BitSet(new long[]{0x0002000000004002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_terminal2269 = new BitSet(new long[]{0x0002000000004002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_terminal2271 = new BitSet(new long[]{0x0002000000004002L});
	public static final BitSet FOLLOW_73_in_terminal2292 = new BitSet(new long[]{0x0002000000004002L,0x0000000000002000L});
	public static final BitSet FOLLOW_elementOptions_in_terminal2294 = new BitSet(new long[]{0x0002000000004002L});
	public static final BitSet FOLLOW_ROOT_in_terminal2321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_terminal2342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_ebnf2385 = new BitSet(new long[]{0x0000000000000002L,0x00000000000140C0L});
	public static final BitSet FOLLOW_80_in_ebnf2393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_ebnf2410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_ebnf2427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_ebnf2444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_ebnfSuffix2529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_ebnfSuffix2541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_ebnfSuffix2554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite2583 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMPRED_in_rewrite2587 = new BitSet(new long[]{0x6109000000010010L,0x0000000000000018L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite2591 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_REWRITE_in_rewrite2599 = new BitSet(new long[]{0x6108000000010010L,0x0000000000000018L});
	public static final BitSet FOLLOW_rewrite_alternative_in_rewrite2603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative2654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_alternative_in_rewrite_alternative2659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_rewrite_tree_block2701 = new BitSet(new long[]{0x6108000000010010L,0x0000000000000018L});
	public static final BitSet FOLLOW_rewrite_tree_alternative_in_rewrite_tree_block2703 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_rewrite_tree_block2705 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_element_in_rewrite_tree_alternative2739 = new BitSet(new long[]{0x6108000000010012L,0x0000000000000018L});
	public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree_element2767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree_element2772 = new BitSet(new long[]{0x0000000000000000L,0x00000000000100C0L});
	public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_tree_element2774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_in_rewrite_tree_element2808 = new BitSet(new long[]{0x0000000000000002L,0x00000000000100C0L});
	public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_tree_element2814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_ebnf_in_rewrite_tree_element2860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_tree_atom2876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_tree_atom2883 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_tree_atom2885 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_rewrite_tree_atom2906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_tree_atom2913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_rewrite_tree_atom2922 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_rewrite_tree_atom2924 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_tree_atom2935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf2956 = new BitSet(new long[]{0x0000000000000000L,0x00000000000100C0L});
	public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_tree_ebnf2958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree2978 = new BitSet(new long[]{0x2108000000010010L,0x0000000000000008L});
	public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree2980 = new BitSet(new long[]{0x6108000000010010L,0x0000000000000038L});
	public static final BitSet FOLLOW_rewrite_tree_element_in_rewrite_tree2982 = new BitSet(new long[]{0x6108000000010010L,0x0000000000000038L});
	public static final BitSet FOLLOW_69_in_rewrite_tree2985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_rewrite_template3017 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_rewrite_template3021 = new BitSet(new long[]{0x2008000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template3023 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_rewrite_template3025 = new BitSet(new long[]{0x0000000000600000L});
	public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template3033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template3039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_template_ref_in_rewrite_template3066 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_indirect_template_head_in_rewrite_template3075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template3084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_rewrite_template_ref3097 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_rewrite_template_ref3101 = new BitSet(new long[]{0x2008000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template_ref3103 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_rewrite_template_ref3105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_rewrite_indirect_template_head3133 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_indirect_template_head3135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_rewrite_indirect_template_head3137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_rewrite_indirect_template_head3139 = new BitSet(new long[]{0x2008000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head3141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_rewrite_indirect_template_head3143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args3167 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_rewrite_template_args3170 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args3172 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_id_in_rewrite_template_arg3205 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LABEL_ASSIGN_in_rewrite_template_arg3207 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_rewrite_template_arg3209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_qid3230 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_qid3233 = new BitSet(new long[]{0x2008000000000000L});
	public static final BitSet FOLLOW_id_in_qid3235 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_TOKEN_REF_in_id3247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_id3257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_template_in_synpred1_ANTLRv32654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rewrite_tree_alternative_in_synpred2_ANTLRv32659 = new BitSet(new long[]{0x0000000000000002L});
}
