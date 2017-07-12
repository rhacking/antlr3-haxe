// $ANTLR 3.5.3-SNAPSHOT org/antlr/gunit/gUnit.g 2017-06-11 18:43:43
package org.antlr.gunit;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class gUnitParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "AST", "CHAR_LITERAL", 
		"DOC_COMMENT", "ESC", "EXT", "FAIL", "ML_COMMENT", "ML_STRING", "NESTED_ACTION", 
		"NESTED_AST", "NESTED_RETVAL", "OK", "OPTIONS", "RETVAL", "RULE_REF", 
		"SL_COMMENT", "STRING", "STRING_LITERAL", "TOKEN_REF", "WS", "XDIGIT", 
		"'->'", "':'", "';'", "'='", "'@header'", "'gunit'", "'returns'", "'walks'", 
		"'}'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public gUnitParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public gUnitParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return gUnitParser.tokenNames; }
	@Override public String getGrammarFileName() { return "org/antlr/gunit/gUnit.g"; }


	public GrammarInfo grammarInfo;
	public gUnitParser(TokenStream input, GrammarInfo grammarInfo) {
		super(input);
		this.grammarInfo = grammarInfo;
	}



	// $ANTLR start "gUnitDef"
	// org/antlr/gunit/gUnit.g:51:1: gUnitDef : 'gunit' g1= id ( 'walks' g2= id )? ';' ( optionsSpec )? ( header )? ( testsuite )* ;
	public final void gUnitDef() throws RecognitionException {
		ParserRuleReturnScope g1 =null;
		ParserRuleReturnScope g2 =null;

		try {
			// org/antlr/gunit/gUnit.g:51:9: ( 'gunit' g1= id ( 'walks' g2= id )? ';' ( optionsSpec )? ( header )? ( testsuite )* )
			// org/antlr/gunit/gUnit.g:51:11: 'gunit' g1= id ( 'walks' g2= id )? ';' ( optionsSpec )? ( header )? ( testsuite )*
			{
			match(input,31,FOLLOW_31_in_gUnitDef60); 
			pushFollow(FOLLOW_id_in_gUnitDef64);
			g1=id();
			state._fsp--;

			// org/antlr/gunit/gUnit.g:51:25: ( 'walks' g2= id )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==33) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// org/antlr/gunit/gUnit.g:51:26: 'walks' g2= id
					{
					match(input,33,FOLLOW_33_in_gUnitDef67); 
					pushFollow(FOLLOW_id_in_gUnitDef71);
					g2=id();
					state._fsp--;

					}
					break;

			}

			match(input,28,FOLLOW_28_in_gUnitDef75); 

					if ( (g2!=null?input.toString(g2.start,g2.stop):null)!=null ) {
						grammarInfo.setGrammarName((g2!=null?input.toString(g2.start,g2.stop):null));
						grammarInfo.setTreeGrammarName((g1!=null?input.toString(g1.start,g1.stop):null));
					}
					else {
						grammarInfo.setGrammarName((g1!=null?input.toString(g1.start,g1.stop):null));
					}
					
			// org/antlr/gunit/gUnit.g:61:3: ( optionsSpec )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==OPTIONS) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/gunit/gUnit.g:61:3: optionsSpec
					{
					pushFollow(FOLLOW_optionsSpec_in_gUnitDef84);
					optionsSpec();
					state._fsp--;

					}
					break;

			}

			// org/antlr/gunit/gUnit.g:61:16: ( header )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==30) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// org/antlr/gunit/gUnit.g:61:16: header
					{
					pushFollow(FOLLOW_header_in_gUnitDef87);
					header();
					state._fsp--;

					}
					break;

			}

			// org/antlr/gunit/gUnit.g:61:24: ( testsuite )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==RULE_REF||LA4_0==TOKEN_REF) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// org/antlr/gunit/gUnit.g:61:24: testsuite
					{
					pushFollow(FOLLOW_testsuite_in_gUnitDef90);
					testsuite();
					state._fsp--;

					}
					break;

				default :
					break loop4;
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
	// $ANTLR end "gUnitDef"



	// $ANTLR start "optionsSpec"
	// org/antlr/gunit/gUnit.g:64:1: optionsSpec : OPTIONS ( option ';' )+ '}' ;
	public final void optionsSpec() throws RecognitionException {
		try {
			// org/antlr/gunit/gUnit.g:65:2: ( OPTIONS ( option ';' )+ '}' )
			// org/antlr/gunit/gUnit.g:65:4: OPTIONS ( option ';' )+ '}'
			{
			match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec104); 
			// org/antlr/gunit/gUnit.g:65:12: ( option ';' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==RULE_REF||LA5_0==TOKEN_REF) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// org/antlr/gunit/gUnit.g:65:13: option ';'
					{
					pushFollow(FOLLOW_option_in_optionsSpec107);
					option();
					state._fsp--;

					match(input,28,FOLLOW_28_in_optionsSpec109); 
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			match(input,34,FOLLOW_34_in_optionsSpec113); 
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


	public static class option_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "option"
	// org/antlr/gunit/gUnit.g:69:1: option : id '=' treeAdaptor ;
	public final gUnitParser.option_return option() throws RecognitionException {
		gUnitParser.option_return retval = new gUnitParser.option_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope id1 =null;
		ParserRuleReturnScope treeAdaptor2 =null;

		try {
			// org/antlr/gunit/gUnit.g:69:8: ( id '=' treeAdaptor )
			// org/antlr/gunit/gUnit.g:69:10: id '=' treeAdaptor
			{
			pushFollow(FOLLOW_id_in_option124);
			id1=id();
			state._fsp--;

			match(input,29,FOLLOW_29_in_option126); 
			pushFollow(FOLLOW_treeAdaptor_in_option128);
			treeAdaptor2=treeAdaptor();
			state._fsp--;


					if ( (id1!=null?input.toString(id1.start,id1.stop):null).equals("TreeAdaptor") ) {
					    grammarInfo.setAdaptor((treeAdaptor2!=null?input.toString(treeAdaptor2.start,treeAdaptor2.stop):null));
					}
					// TODO: need a better error logging strategy
					else System.err.println("Invalid option detected: "+input.toString(retval.start,input.LT(-1)));
					
			}

			retval.stop = input.LT(-1);

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
	// $ANTLR end "option"


	public static class treeAdaptor_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "treeAdaptor"
	// org/antlr/gunit/gUnit.g:79:1: treeAdaptor : id ( EXT )* ;
	public final gUnitParser.treeAdaptor_return treeAdaptor() throws RecognitionException {
		gUnitParser.treeAdaptor_return retval = new gUnitParser.treeAdaptor_return();
		retval.start = input.LT(1);

		try {
			// org/antlr/gunit/gUnit.g:80:2: ( id ( EXT )* )
			// org/antlr/gunit/gUnit.g:80:4: id ( EXT )*
			{
			pushFollow(FOLLOW_id_in_treeAdaptor144);
			id();
			state._fsp--;

			// org/antlr/gunit/gUnit.g:80:7: ( EXT )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==EXT) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// org/antlr/gunit/gUnit.g:80:7: EXT
					{
					match(input,EXT,FOLLOW_EXT_in_treeAdaptor146); 
					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

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
	// $ANTLR end "treeAdaptor"



	// $ANTLR start "header"
	// org/antlr/gunit/gUnit.g:83:1: header : '@header' ACTION ;
	public final void header() throws RecognitionException {
		Token ACTION3=null;

		try {
			// org/antlr/gunit/gUnit.g:83:8: ( '@header' ACTION )
			// org/antlr/gunit/gUnit.g:83:10: '@header' ACTION
			{
			match(input,30,FOLLOW_30_in_header157); 
			ACTION3=(Token)match(input,ACTION,FOLLOW_ACTION_in_header159); 

					int pos1, pos2;
					if ( (pos1=(ACTION3!=null?ACTION3.getText():null).indexOf("package"))!=-1 && (pos2=(ACTION3!=null?ACTION3.getText():null).indexOf(';'))!=-1 ) {
						grammarInfo.setGrammarPackage((ACTION3!=null?ACTION3.getText():null).substring(pos1+8, pos2).trim());	// substring the package path
					}
					else {
						System.err.println("error(line "+ACTION3.getLine()+"): invalid header");
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
	// $ANTLR end "header"


	protected static class testsuite_scope {
		boolean isLexicalRule;
	}
	protected Stack<testsuite_scope> testsuite_stack = new Stack<testsuite_scope>();


	// $ANTLR start "testsuite"
	// org/antlr/gunit/gUnit.g:95:1: testsuite : (r1= RULE_REF ( 'walks' r2= RULE_REF )? |t= TOKEN_REF ) ':' ( testcase[ts] )+ ;
	public final void testsuite() throws RecognitionException {
		testsuite_stack.push(new testsuite_scope());
		Token r1=null;
		Token r2=null;
		Token t=null;


		gUnitTestSuite ts = null;
		testsuite_stack.peek().isLexicalRule = false;

		try {
			// org/antlr/gunit/gUnit.g:103:2: ( (r1= RULE_REF ( 'walks' r2= RULE_REF )? |t= TOKEN_REF ) ':' ( testcase[ts] )+ )
			// org/antlr/gunit/gUnit.g:103:4: (r1= RULE_REF ( 'walks' r2= RULE_REF )? |t= TOKEN_REF ) ':' ( testcase[ts] )+
			{
			// org/antlr/gunit/gUnit.g:103:4: (r1= RULE_REF ( 'walks' r2= RULE_REF )? |t= TOKEN_REF )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==RULE_REF) ) {
				alt8=1;
			}
			else if ( (LA8_0==TOKEN_REF) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// org/antlr/gunit/gUnit.g:103:6: r1= RULE_REF ( 'walks' r2= RULE_REF )?
					{
					r1=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_testsuite190); 
					// org/antlr/gunit/gUnit.g:103:18: ( 'walks' r2= RULE_REF )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==33) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// org/antlr/gunit/gUnit.g:103:19: 'walks' r2= RULE_REF
							{
							match(input,33,FOLLOW_33_in_testsuite193); 
							r2=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_testsuite197); 
							}
							break;

					}


								if ( r2==null ) ts = new gUnitTestSuite((r1!=null?r1.getText():null));
								else ts = new gUnitTestSuite((r1!=null?r1.getText():null), (r2!=null?r2.getText():null));
								
					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:108:5: t= TOKEN_REF
					{
					t=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_testsuite213); 

								ts = new gUnitTestSuite();
								ts.setLexicalRuleName((t!=null?t.getText():null));
								testsuite_stack.peek().isLexicalRule = true;
								
					}
					break;

			}

			match(input,27,FOLLOW_27_in_testsuite227); 
			// org/antlr/gunit/gUnit.g:116:3: ( testcase[ts] )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				switch ( input.LA(1) ) {
				case RULE_REF:
					{
					int LA9_2 = input.LA(2);
					if ( ((LA9_2 >= EXT && LA9_2 <= FAIL)||LA9_2==OK||LA9_2==26||LA9_2==32) ) {
						alt9=1;
					}

					}
					break;
				case TOKEN_REF:
					{
					int LA9_3 = input.LA(2);
					if ( ((LA9_3 >= EXT && LA9_3 <= FAIL)||LA9_3==OK||LA9_3==26||LA9_3==32) ) {
						alt9=1;
					}

					}
					break;
				case ML_STRING:
				case STRING:
					{
					alt9=1;
					}
					break;
				}
				switch (alt9) {
				case 1 :
					// org/antlr/gunit/gUnit.g:116:3: testcase[ts]
					{
					pushFollow(FOLLOW_testcase_in_testsuite231);
					testcase(ts);
					state._fsp--;

					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			grammarInfo.addRuleTestSuite(ts);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			testsuite_stack.pop();
		}
	}
	// $ANTLR end "testsuite"



	// $ANTLR start "testcase"
	// org/antlr/gunit/gUnit.g:120:1: testcase[gUnitTestSuite ts] : input expect ;
	public final void testcase(gUnitTestSuite ts) throws RecognitionException {
		gUnitTestInput input4 =null;
		AbstractTest expect5 =null;

		try {
			// org/antlr/gunit/gUnit.g:121:2: ( input expect )
			// org/antlr/gunit/gUnit.g:121:4: input expect
			{
			pushFollow(FOLLOW_input_in_testcase249);
			input4=input();
			state._fsp--;

			pushFollow(FOLLOW_expect_in_testcase251);
			expect5=expect();
			state._fsp--;

			ts.addTestCase(input4, expect5);
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
	// $ANTLR end "testcase"



	// $ANTLR start "input"
	// org/antlr/gunit/gUnit.g:124:1: input returns [gUnitTestInput in] : ( STRING | ML_STRING | file );
	public final gUnitTestInput input() throws RecognitionException {
		gUnitTestInput in = null;


		Token STRING6=null;
		Token ML_STRING7=null;
		ParserRuleReturnScope file8 =null;


		String testInput = null;
		boolean inputIsFile = false;
		int line = -1;

		try {
			// org/antlr/gunit/gUnit.g:133:2: ( STRING | ML_STRING | file )
			int alt10=3;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt10=1;
				}
				break;
			case ML_STRING:
				{
				alt10=2;
				}
				break;
			case RULE_REF:
			case TOKEN_REF:
				{
				alt10=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// org/antlr/gunit/gUnit.g:133:4: STRING
					{
					STRING6=(Token)match(input,STRING,FOLLOW_STRING_in_input278); 

							testInput = (STRING6!=null?STRING6.getText():null).replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t")
							.replace("\\b", "\b").replace("\\f", "\f").replace("\\\"", "\"").replace("\\'", "\'").replace("\\\\", "\\");
							line = (STRING6!=null?STRING6.getLine():0);
							
					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:139:4: ML_STRING
					{
					ML_STRING7=(Token)match(input,ML_STRING,FOLLOW_ML_STRING_in_input288); 

							testInput = (ML_STRING7!=null?ML_STRING7.getText():null);
							line = (ML_STRING7!=null?ML_STRING7.getLine():0);
							
					}
					break;
				case 3 :
					// org/antlr/gunit/gUnit.g:144:4: file
					{
					pushFollow(FOLLOW_file_in_input297);
					file8=file();
					state._fsp--;


							testInput = (file8!=null?input.toString(file8.start,file8.stop):null);
							inputIsFile = true;
							line = (file8!=null?((gUnitParser.file_return)file8).line:0);
							
					}
					break;

			}

			in = new gUnitTestInput(testInput, inputIsFile, line);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return in;
	}
	// $ANTLR end "input"



	// $ANTLR start "expect"
	// org/antlr/gunit/gUnit.g:152:1: expect returns [AbstractTest out] : ( OK | FAIL | 'returns' RETVAL | '->' output );
	public final AbstractTest expect() throws RecognitionException {
		AbstractTest out = null;


		Token RETVAL9=null;
		Token output10 =null;

		try {
			// org/antlr/gunit/gUnit.g:153:2: ( OK | FAIL | 'returns' RETVAL | '->' output )
			int alt11=4;
			switch ( input.LA(1) ) {
			case OK:
				{
				alt11=1;
				}
				break;
			case FAIL:
				{
				alt11=2;
				}
				break;
			case 32:
				{
				alt11=3;
				}
				break;
			case 26:
				{
				alt11=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// org/antlr/gunit/gUnit.g:153:4: OK
					{
					match(input,OK,FOLLOW_OK_in_expect317); 
					out = new BooleanTest(true);
					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:154:4: FAIL
					{
					match(input,FAIL,FOLLOW_FAIL_in_expect324); 
					out = new BooleanTest(false);
					}
					break;
				case 3 :
					// org/antlr/gunit/gUnit.g:155:4: 'returns' RETVAL
					{
					match(input,32,FOLLOW_32_in_expect331); 
					RETVAL9=(Token)match(input,RETVAL,FOLLOW_RETVAL_in_expect333); 
					if ( !testsuite_stack.peek().isLexicalRule ) out = new ReturnTest(RETVAL9);
					}
					break;
				case 4 :
					// org/antlr/gunit/gUnit.g:156:4: '->' output
					{
					match(input,26,FOLLOW_26_in_expect340); 
					pushFollow(FOLLOW_output_in_expect342);
					output10=output();
					state._fsp--;

					if ( !testsuite_stack.peek().isLexicalRule ) out = new OutputTest(output10);
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
		return out;
	}
	// $ANTLR end "expect"



	// $ANTLR start "output"
	// org/antlr/gunit/gUnit.g:159:1: output returns [Token token] : ( STRING | ML_STRING | AST | ACTION );
	public final Token output() throws RecognitionException {
		Token token = null;


		Token STRING11=null;
		Token ML_STRING12=null;
		Token AST13=null;
		Token ACTION14=null;

		try {
			// org/antlr/gunit/gUnit.g:160:2: ( STRING | ML_STRING | AST | ACTION )
			int alt12=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt12=1;
				}
				break;
			case ML_STRING:
				{
				alt12=2;
				}
				break;
			case AST:
				{
				alt12=3;
				}
				break;
			case ACTION:
				{
				alt12=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// org/antlr/gunit/gUnit.g:160:4: STRING
					{
					STRING11=(Token)match(input,STRING,FOLLOW_STRING_in_output359); 

							STRING11.setText((STRING11!=null?STRING11.getText():null).replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t")
							.replace("\\b", "\b").replace("\\f", "\f").replace("\\\"", "\"").replace("\\'", "\'").replace("\\\\", "\\"));
							token = STRING11;
							
					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:166:4: ML_STRING
					{
					ML_STRING12=(Token)match(input,ML_STRING,FOLLOW_ML_STRING_in_output369); 
					token = ML_STRING12;
					}
					break;
				case 3 :
					// org/antlr/gunit/gUnit.g:167:4: AST
					{
					AST13=(Token)match(input,AST,FOLLOW_AST_in_output376); 
					token = AST13;
					}
					break;
				case 4 :
					// org/antlr/gunit/gUnit.g:168:4: ACTION
					{
					ACTION14=(Token)match(input,ACTION,FOLLOW_ACTION_in_output383); 
					token = ACTION14;
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
		return token;
	}
	// $ANTLR end "output"


	public static class file_return extends ParserRuleReturnScope {
		public int line;
	};


	// $ANTLR start "file"
	// org/antlr/gunit/gUnit.g:171:1: file returns [int line] : id ( EXT )? ;
	public final gUnitParser.file_return file() throws RecognitionException {
		gUnitParser.file_return retval = new gUnitParser.file_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope id15 =null;

		try {
			// org/antlr/gunit/gUnit.g:172:2: ( id ( EXT )? )
			// org/antlr/gunit/gUnit.g:172:4: id ( EXT )?
			{
			pushFollow(FOLLOW_id_in_file401);
			id15=id();
			state._fsp--;

			// org/antlr/gunit/gUnit.g:172:7: ( EXT )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==EXT) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// org/antlr/gunit/gUnit.g:172:7: EXT
					{
					match(input,EXT,FOLLOW_EXT_in_file403); 
					}
					break;

			}

			retval.line = (id15!=null?((gUnitParser.id_return)id15).line:0);
			}

			retval.stop = input.LT(-1);

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
	// $ANTLR end "file"


	public static class id_return extends ParserRuleReturnScope {
		public int line;
	};


	// $ANTLR start "id"
	// org/antlr/gunit/gUnit.g:175:1: id returns [int line] : ( TOKEN_REF | RULE_REF );
	public final gUnitParser.id_return id() throws RecognitionException {
		gUnitParser.id_return retval = new gUnitParser.id_return();
		retval.start = input.LT(1);

		Token TOKEN_REF16=null;
		Token RULE_REF17=null;

		try {
			// org/antlr/gunit/gUnit.g:176:2: ( TOKEN_REF | RULE_REF )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==TOKEN_REF) ) {
				alt14=1;
			}
			else if ( (LA14_0==RULE_REF) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// org/antlr/gunit/gUnit.g:176:4: TOKEN_REF
					{
					TOKEN_REF16=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_id422); 
					retval.line = (TOKEN_REF16!=null?TOKEN_REF16.getLine():0);
					}
					break;
				case 2 :
					// org/antlr/gunit/gUnit.g:177:4: RULE_REF
					{
					RULE_REF17=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_id429); 
					retval.line = (RULE_REF17!=null?RULE_REF17.getLine():0);
					}
					break;

			}
			retval.stop = input.LT(-1);

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
	// $ANTLR end "id"

	// Delegated rules



	public static final BitSet FOLLOW_31_in_gUnitDef60 = new BitSet(new long[]{0x0000000000880000L});
	public static final BitSet FOLLOW_id_in_gUnitDef64 = new BitSet(new long[]{0x0000000210000000L});
	public static final BitSet FOLLOW_33_in_gUnitDef67 = new BitSet(new long[]{0x0000000000880000L});
	public static final BitSet FOLLOW_id_in_gUnitDef71 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_gUnitDef75 = new BitSet(new long[]{0x00000000408A0002L});
	public static final BitSet FOLLOW_optionsSpec_in_gUnitDef84 = new BitSet(new long[]{0x0000000040880002L});
	public static final BitSet FOLLOW_header_in_gUnitDef87 = new BitSet(new long[]{0x0000000000880002L});
	public static final BitSet FOLLOW_testsuite_in_gUnitDef90 = new BitSet(new long[]{0x0000000000880002L});
	public static final BitSet FOLLOW_OPTIONS_in_optionsSpec104 = new BitSet(new long[]{0x0000000000880000L});
	public static final BitSet FOLLOW_option_in_optionsSpec107 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_optionsSpec109 = new BitSet(new long[]{0x0000000400880000L});
	public static final BitSet FOLLOW_34_in_optionsSpec113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_option124 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_option126 = new BitSet(new long[]{0x0000000000880000L});
	public static final BitSet FOLLOW_treeAdaptor_in_option128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_treeAdaptor144 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_EXT_in_treeAdaptor146 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_30_in_header157 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ACTION_in_header159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_testsuite190 = new BitSet(new long[]{0x0000000208000000L});
	public static final BitSet FOLLOW_33_in_testsuite193 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_RULE_REF_in_testsuite197 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_TOKEN_REF_in_testsuite213 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_testsuite227 = new BitSet(new long[]{0x0000000000A81000L});
	public static final BitSet FOLLOW_testcase_in_testsuite231 = new BitSet(new long[]{0x0000000000A81002L});
	public static final BitSet FOLLOW_input_in_testcase249 = new BitSet(new long[]{0x0000000104010400L});
	public static final BitSet FOLLOW_expect_in_testcase251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_input278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ML_STRING_in_input288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_file_in_input297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OK_in_expect317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FAIL_in_expect324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_expect331 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_RETVAL_in_expect333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_expect340 = new BitSet(new long[]{0x0000000000201030L});
	public static final BitSet FOLLOW_output_in_expect342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_output359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ML_STRING_in_output369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AST_in_output376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTION_in_output383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_file401 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_EXT_in_file403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_REF_in_id422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_REF_in_id429 = new BitSet(new long[]{0x0000000000000002L});
}
