// $ANTLR 3.5 org/antlr/grammar/v3/ActionTranslator.g 2017-06-11 18:42:20

package org.antlr.grammar.v3;
import org.stringtemplate.v4.ST;
import org.antlr.runtime.*;
import org.antlr.tool.*;
import org.antlr.codegen.*;

import org.antlr.runtime.*;
import java.util.List;
import java.util.ArrayList;
import org.antlr.grammar.v3.ANTLRParser;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class ActionTranslator extends Lexer {
	public static final int EOF=-1;
	public static final int ACTION=4;
	public static final int ARG=5;
	public static final int ATTR_VALUE_EXPR=6;
	public static final int DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR=7;
	public static final int DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR=8;
	public static final int DYNAMIC_SCOPE_ATTR=9;
	public static final int ENCLOSING_RULE_SCOPE_ATTR=10;
	public static final int ERROR_SCOPED_XY=11;
	public static final int ERROR_X=12;
	public static final int ERROR_XY=13;
	public static final int ESC=14;
	public static final int ID=15;
	public static final int INDIRECT_TEMPLATE_INSTANCE=16;
	public static final int INT=17;
	public static final int ISOLATED_DYNAMIC_SCOPE=18;
	public static final int ISOLATED_LEXER_RULE_REF=19;
	public static final int ISOLATED_TOKEN_REF=20;
	public static final int LABEL_REF=21;
	public static final int LOCAL_ATTR=22;
	public static final int RULE_SCOPE_ATTR=23;
	public static final int SCOPE_INDEX_EXPR=24;
	public static final int SET_ATTRIBUTE=25;
	public static final int SET_DYNAMIC_SCOPE_ATTR=26;
	public static final int SET_ENCLOSING_RULE_SCOPE_ATTR=27;
	public static final int SET_EXPR_ATTRIBUTE=28;
	public static final int SET_LOCAL_ATTR=29;
	public static final int SET_RULE_SCOPE_ATTR=30;
	public static final int SET_TOKEN_SCOPE_ATTR=31;
	public static final int TEMPLATE_EXPR=32;
	public static final int TEMPLATE_INSTANCE=33;
	public static final int TEXT=34;
	public static final int TOKEN_SCOPE_ATTR=35;
	public static final int UNKNOWN_SYNTAX=36;
	public static final int WS=37;

	public List<Object> chunks = new ArrayList<Object>();
	Rule enclosingRule;
	int outerAltNum;
	Grammar grammar;
	CodeGenerator generator;
	Token actionToken;

		public ActionTranslator(CodeGenerator generator,
									 String ruleName,
									 GrammarAST actionAST)
		{
			this(new ANTLRStringStream(actionAST.token.getText()));
			this.generator = generator;
			this.grammar = generator.grammar;
		    this.enclosingRule = grammar.getLocallyDefinedRule(ruleName);
		    this.actionToken = actionAST.token;
		    this.outerAltNum = actionAST.outerAltNum;
		}

		public ActionTranslator(CodeGenerator generator,
									 String ruleName,
									 Token actionToken,
									 int outerAltNum)
		{
			this(new ANTLRStringStream(actionToken.getText()));
			this.generator = generator;
			grammar = generator.grammar;
		    this.enclosingRule = grammar.getRule(ruleName);
		    this.actionToken = actionToken;
			this.outerAltNum = outerAltNum;
		}

	/** Return a list of strings and ST objects that
	 *  represent the translated action.
	 */
	public List<Object> translateToChunks() {
		// System.out.println("###\naction="+action);
		Token t;
		do {
			t = nextToken();
		} while ( t.getType()!= Token.EOF );
		return chunks;
	}

	public String translate() {
		List<Object> theChunks = translateToChunks();
		//System.out.println("chunks="+a.chunks);
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < theChunks.size(); i++) {
			Object o = theChunks.get(i);
			if ( o instanceof ST ) buf.append(((ST)o).render());
			else buf.append(o);
		}
		//System.out.println("translated: "+buf.toString());
		return buf.toString();
	}

	public List<Object> translateAction(String action) {
		String rname = null;
		if ( enclosingRule!=null ) {
			rname = enclosingRule.name;
		}
		ActionTranslator translator =
			new ActionTranslator(generator,
									  rname,
									  new CommonToken(ANTLRParser.ACTION,action),outerAltNum);
	    return translator.translateToChunks();
	}

	public boolean isTokenRefInAlt(String id) {
	    return enclosingRule.getTokenRefsInAlt(id, outerAltNum)!=null;
	}
	public boolean isRuleRefInAlt(String id) {
	    return enclosingRule.getRuleRefsInAlt(id, outerAltNum)!=null;
	}
	public Grammar.LabelElementPair getElementLabel(String id) {
	    return enclosingRule.getLabel(id);
	}

	public void checkElementRefUniqueness(String ref, boolean isToken) {
			List<GrammarAST> refs = null;
			if ( isToken ) {
			    refs = enclosingRule.getTokenRefsInAlt(ref, outerAltNum);
			}
			else {
			    refs = enclosingRule.getRuleRefsInAlt(ref, outerAltNum);
			}
			if ( refs!=null && refs.size()>1 ) {
				ErrorManager.grammarError(ErrorManager.MSG_NONUNIQUE_REF,
										  grammar,
										  actionToken,
										  ref);
			}
	}

	/** For $rulelabel.name, return the Attribute found for name.  It
	 *  will be a predefined property or a return value.
	 */
	public Attribute getRuleLabelAttribute(String ruleName, String attrName) {
		Rule r = grammar.getRule(ruleName);
		AttributeScope scope = r.getLocalAttributeScope(attrName);
		if ( scope!=null && !scope.isParameterScope ) {
			return scope.getAttribute(attrName);
		}
		return null;
	}

	AttributeScope resolveDynamicScope(String scopeName) {
		if ( grammar.getGlobalScope(scopeName)!=null ) {
			return grammar.getGlobalScope(scopeName);
		}
		Rule scopeRule = grammar.getRule(scopeName);
		if ( scopeRule!=null ) {
			return scopeRule.ruleScope;
		}
		return null; // not a valid dynamic scope
	}

	protected ST template(String name) {
		ST st = generator.getTemplates().getInstanceOf(name);
		chunks.add(st);
		return st;
	}




	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ActionTranslator() {} 
	public ActionTranslator(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ActionTranslator(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/ActionTranslator.g"; }

	@Override
	public Token nextToken() {
		while (true) {
			if ( input.LA(1)==CharStream.EOF ) {
				Token eof = new CommonToken(input,Token.EOF,
											Token.DEFAULT_CHANNEL,
											input.index(),input.index());
				eof.setLine(getLine());
				eof.setCharPositionInLine(getCharPositionInLine());
				return eof;
			}
			state.token = null;
		state.channel = Token.DEFAULT_CHANNEL;
			state.tokenStartCharIndex = input.index();
			state.tokenStartCharPositionInLine = input.getCharPositionInLine();
			state.tokenStartLine = input.getLine();
		state.text = null;
			try {
				int m = input.mark();
				state.backtracking=1; 
				state.failed=false;
				mTokens();
				state.backtracking=0;
				if ( state.failed ) {
					input.rewind(m);
					input.consume(); 
				}
				else {
					emit();
					return state.token;
				}
			}
			catch (RecognitionException re) {
				// shouldn't happen in backtracking mode, but...
				reportError(re);
				recover(re);
			}
		}
	}

	@Override
	public void memoize(IntStream input,
			int ruleIndex,
			int ruleStartIndex)
	{
	if ( state.backtracking>1 ) super.memoize(input, ruleIndex, ruleStartIndex);
	}

	@Override
	public boolean alreadyParsedRule(IntStream input, int ruleIndex) {
	if ( state.backtracking>1 ) return super.alreadyParsedRule(input, ruleIndex);
	return false;
	}
	// $ANTLR start "SET_ENCLOSING_RULE_SCOPE_ATTR"
	public final void mSET_ENCLOSING_RULE_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = SET_ENCLOSING_RULE_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;
			CommonToken expr=null;

			// org/antlr/grammar/v3/ActionTranslator.g:185:2: ( '$' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:185:4: '$' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
			{
			match('$'); if (state.failed) return;
			int xStart56 = getCharIndex();
			int xStartLine56 = getLine();
			int xStartCharPos56 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart56, getCharIndex()-1);
			x.setLine(xStartLine56);
			x.setCharPositionInLine(xStartCharPos56);

			match('.'); if (state.failed) return;
			int yStart62 = getCharIndex();
			int yStartLine62 = getLine();
			int yStartCharPos62 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart62, getCharIndex()-1);
			y.setLine(yStartLine62);
			y.setCharPositionInLine(yStartCharPos62);

			// org/antlr/grammar/v3/ActionTranslator.g:185:22: ( WS )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:185:22: WS
					{
					mWS(); if (state.failed) return;

					}
					break;

			}

			match('='); if (state.failed) return;
			int exprStart71 = getCharIndex();
			int exprStartLine71 = getLine();
			int exprStartCharPos71 = getCharPositionInLine();
			mATTR_VALUE_EXPR(); if (state.failed) return;
			expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart71, getCharIndex()-1);
			expr.setLine(exprStartLine71);
			expr.setCharPositionInLine(exprStartCharPos71);

			match(';'); if (state.failed) return;
			if ( !((enclosingRule!=null &&
				                         (x!=null?x.getText():null).equals(enclosingRule.name) &&
				                         enclosingRule.getLocalAttributeScope((y!=null?y.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "SET_ENCLOSING_RULE_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         $x.text.equals(enclosingRule.name) &&\n\t                         enclosingRule.getLocalAttributeScope($y.text)!=null");
			}
			if ( state.backtracking==1 ) {
					ST st = null;
					AttributeScope scope = enclosingRule.getLocalAttributeScope((y!=null?y.getText():null));
					if ( scope.isPredefinedRuleScope ) {
						if ( (y!=null?y.getText():null).equals("st") || (y!=null?y.getText():null).equals("tree") ) {
							st = template("ruleSetPropertyRef_"+(y!=null?y.getText():null));
							grammar.referenceRuleLabelPredefinedAttribute((x!=null?x.getText():null));
							st.add("scope", (x!=null?x.getText():null));
							st.add("attr", (y!=null?y.getText():null));
							st.add("expr", translateAction((expr!=null?expr.getText():null)));
						} else {
							ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
													  grammar,
													  actionToken,
													  (x!=null?x.getText():null),
													  (y!=null?y.getText():null));
						}
					}
				    else if ( scope.isPredefinedLexerRuleScope ) {
				    	// this is a better message to emit than the previous one...
						ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
												  grammar,
												  actionToken,
												  (x!=null?x.getText():null),
												  (y!=null?y.getText():null));
				    }
					else if ( scope.isParameterScope ) {
						st = template("parameterSetAttributeRef");
						st.add("attr", scope.getAttribute((y!=null?y.getText():null)));
						st.add("expr", translateAction((expr!=null?expr.getText():null)));
					}
					else { // must be return value
						st = template("returnSetAttributeRef");
						st.add("ruleDescriptor", enclosingRule);
						st.add("attr", scope.getAttribute((y!=null?y.getText():null)));
						st.add("expr", translateAction((expr!=null?expr.getText():null)));
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
	// $ANTLR end "SET_ENCLOSING_RULE_SCOPE_ATTR"

	// $ANTLR start "ENCLOSING_RULE_SCOPE_ATTR"
	public final void mENCLOSING_RULE_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = ENCLOSING_RULE_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionTranslator.g:230:2: ( '$' x= ID '.' y= ID {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:230:4: '$' x= ID '.' y= ID {...}?
			{
			match('$'); if (state.failed) return;
			int xStart103 = getCharIndex();
			int xStartLine103 = getLine();
			int xStartCharPos103 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart103, getCharIndex()-1);
			x.setLine(xStartLine103);
			x.setCharPositionInLine(xStartCharPos103);

			match('.'); if (state.failed) return;
			int yStart109 = getCharIndex();
			int yStartLine109 = getLine();
			int yStartCharPos109 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart109, getCharIndex()-1);
			y.setLine(yStartLine109);
			y.setCharPositionInLine(yStartCharPos109);

			if ( !((enclosingRule!=null &&
				                         (x!=null?x.getText():null).equals(enclosingRule.name) &&
				                         enclosingRule.getLocalAttributeScope((y!=null?y.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "ENCLOSING_RULE_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         $x.text.equals(enclosingRule.name) &&\n\t                         enclosingRule.getLocalAttributeScope($y.text)!=null");
			}
			if ( state.backtracking==1 ) {
					if ( isRuleRefInAlt((x!=null?x.getText():null))  ) {
						ErrorManager.grammarError(ErrorManager.MSG_RULE_REF_AMBIG_WITH_RULE_IN_ALT,
												  grammar,
												  actionToken,
												  (x!=null?x.getText():null));
					}
					ST st = null;
					AttributeScope scope = enclosingRule.getLocalAttributeScope((y!=null?y.getText():null));
					if ( scope.isPredefinedRuleScope ) {
						st = template("rulePropertyRef_"+(y!=null?y.getText():null));
						grammar.referenceRuleLabelPredefinedAttribute((x!=null?x.getText():null));
						st.add("scope", (x!=null?x.getText():null));
						st.add("attr", (y!=null?y.getText():null));
					}
				    else if ( scope.isPredefinedLexerRuleScope ) {
				    	// perhaps not the most precise error message to use, but...
						ErrorManager.grammarError(ErrorManager.MSG_RULE_HAS_NO_ARGS,
												  grammar,
												  actionToken,
												  (x!=null?x.getText():null));
				    }
					else if ( scope.isParameterScope ) {
						st = template("parameterAttributeRef");
						st.add("attr", scope.getAttribute((y!=null?y.getText():null)));
					}
					else { // must be return value
						st = template("returnAttributeRef");
						st.add("ruleDescriptor", enclosingRule);
						st.add("attr", scope.getAttribute((y!=null?y.getText():null)));
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
	// $ANTLR end "ENCLOSING_RULE_SCOPE_ATTR"

	// $ANTLR start "SET_TOKEN_SCOPE_ATTR"
	public final void mSET_TOKEN_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = SET_TOKEN_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionTranslator.g:270:2: ( '$' x= ID '.' y= ID ( WS )? '=' {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:270:4: '$' x= ID '.' y= ID ( WS )? '=' {...}?
			{
			match('$'); if (state.failed) return;
			int xStart135 = getCharIndex();
			int xStartLine135 = getLine();
			int xStartCharPos135 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart135, getCharIndex()-1);
			x.setLine(xStartLine135);
			x.setCharPositionInLine(xStartCharPos135);

			match('.'); if (state.failed) return;
			int yStart141 = getCharIndex();
			int yStartLine141 = getLine();
			int yStartCharPos141 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart141, getCharIndex()-1);
			y.setLine(yStartLine141);
			y.setCharPositionInLine(yStartCharPos141);

			// org/antlr/grammar/v3/ActionTranslator.g:270:22: ( WS )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:270:22: WS
					{
					mWS(); if (state.failed) return;

					}
					break;

			}

			match('='); if (state.failed) return;
			if ( !((enclosingRule!=null && input.LA(1)!='=' &&
				                         (enclosingRule.getTokenLabel((x!=null?x.getText():null))!=null||
				                          isTokenRefInAlt((x!=null?x.getText():null))) &&
				                         AttributeScope.tokenScope.getAttribute((y!=null?y.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "SET_TOKEN_SCOPE_ATTR", "enclosingRule!=null && input.LA(1)!='=' &&\n\t                         (enclosingRule.getTokenLabel($x.text)!=null||\n\t                          isTokenRefInAlt($x.text)) &&\n\t                         AttributeScope.tokenScope.getAttribute($y.text)!=null");
			}
			if ( state.backtracking==1 ) {
					ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
											  grammar,
											  actionToken,
											  (x!=null?x.getText():null),
											  (y!=null?y.getText():null));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET_TOKEN_SCOPE_ATTR"

	// $ANTLR start "TOKEN_SCOPE_ATTR"
	public final void mTOKEN_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = TOKEN_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionTranslator.g:289:2: ( '$' x= ID '.' y= ID {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:289:4: '$' x= ID '.' y= ID {...}?
			{
			match('$'); if (state.failed) return;
			int xStart180 = getCharIndex();
			int xStartLine180 = getLine();
			int xStartCharPos180 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart180, getCharIndex()-1);
			x.setLine(xStartLine180);
			x.setCharPositionInLine(xStartCharPos180);

			match('.'); if (state.failed) return;
			int yStart186 = getCharIndex();
			int yStartLine186 = getLine();
			int yStartCharPos186 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart186, getCharIndex()-1);
			y.setLine(yStartLine186);
			y.setCharPositionInLine(yStartCharPos186);

			if ( !((enclosingRule!=null &&
				                         (enclosingRule.getTokenLabel((x!=null?x.getText():null))!=null||
				                          isTokenRefInAlt((x!=null?x.getText():null))) &&
				                         AttributeScope.tokenScope.getAttribute((y!=null?y.getText():null))!=null &&
				                         (grammar.type!=Grammar.LEXER ||
				                         getElementLabel((x!=null?x.getText():null)).elementRef.token.getType()==ANTLRParser.TOKEN_REF ||
				                         getElementLabel((x!=null?x.getText():null)).elementRef.token.getType()==ANTLRParser.STRING_LITERAL))) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "TOKEN_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         (enclosingRule.getTokenLabel($x.text)!=null||\n\t                          isTokenRefInAlt($x.text)) &&\n\t                         AttributeScope.tokenScope.getAttribute($y.text)!=null &&\n\t                         (grammar.type!=Grammar.LEXER ||\n\t                         getElementLabel($x.text).elementRef.token.getType()==ANTLRParser.TOKEN_REF ||\n\t                         getElementLabel($x.text).elementRef.token.getType()==ANTLRParser.STRING_LITERAL)");
			}
			if ( state.backtracking==1 ) {
					String label = (x!=null?x.getText():null);
					if ( enclosingRule.getTokenLabel((x!=null?x.getText():null))==null ) {
						// $tokenref.attr  gotta get old label or compute new one
						checkElementRefUniqueness((x!=null?x.getText():null), true);
						label = enclosingRule.getElementLabel((x!=null?x.getText():null), outerAltNum, generator);
						if ( label==null ) {
							ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
													  grammar,
													  actionToken,
													  "$"+(x!=null?x.getText():null)+"."+(y!=null?y.getText():null));
							label = (x!=null?x.getText():null);
						}
					}
					ST st = template("tokenLabelPropertyRef_"+(y!=null?y.getText():null));
					st.add("scope", label);
					st.add("attr", AttributeScope.tokenScope.getAttribute((y!=null?y.getText():null)));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TOKEN_SCOPE_ATTR"

	// $ANTLR start "SET_RULE_SCOPE_ATTR"
	public final void mSET_RULE_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = SET_RULE_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;


			Grammar.LabelElementPair pair=null;
			String refdRuleName=null;

			// org/antlr/grammar/v3/ActionTranslator.g:327:2: ( '$' x= ID '.' y= ID ( WS )? '=' {...}?{...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:327:4: '$' x= ID '.' y= ID ( WS )? '=' {...}?{...}?
			{
			match('$'); if (state.failed) return;
			int xStart217 = getCharIndex();
			int xStartLine217 = getLine();
			int xStartCharPos217 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart217, getCharIndex()-1);
			x.setLine(xStartLine217);
			x.setCharPositionInLine(xStartCharPos217);

			match('.'); if (state.failed) return;
			int yStart223 = getCharIndex();
			int yStartLine223 = getLine();
			int yStartCharPos223 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart223, getCharIndex()-1);
			y.setLine(yStartLine223);
			y.setCharPositionInLine(yStartCharPos223);

			// org/antlr/grammar/v3/ActionTranslator.g:327:22: ( WS )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||LA3_0=='\r'||LA3_0==' ') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:327:22: WS
					{
					mWS(); if (state.failed) return;

					}
					break;

			}

			match('='); if (state.failed) return;
			if ( !((enclosingRule!=null && input.LA(1)!='=')) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "SET_RULE_SCOPE_ATTR", "enclosingRule!=null && input.LA(1)!='='");
			}
			if ( state.backtracking==1 ) {
					pair = enclosingRule.getRuleLabel((x!=null?x.getText():null));
					refdRuleName = (x!=null?x.getText():null);
					if ( pair!=null ) {
						refdRuleName = pair.referencedRuleName;
					}
					}
			if ( !(((enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null || isRuleRefInAlt((x!=null?x.getText():null))) &&
				      getRuleLabelAttribute(enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null?enclosingRule.getRuleLabel((x!=null?x.getText():null)).referencedRuleName:(x!=null?x.getText():null),(y!=null?y.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "SET_RULE_SCOPE_ATTR", "(enclosingRule.getRuleLabel($x.text)!=null || isRuleRefInAlt($x.text)) &&\n\t      getRuleLabelAttribute(enclosingRule.getRuleLabel($x.text)!=null?enclosingRule.getRuleLabel($x.text).referencedRuleName:$x.text,$y.text)!=null");
			}
			if ( state.backtracking==1 ) {
					ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
											  grammar,
											  actionToken,
											  (x!=null?x.getText():null),
											  (y!=null?y.getText():null));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET_RULE_SCOPE_ATTR"

	// $ANTLR start "RULE_SCOPE_ATTR"
	public final void mRULE_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = RULE_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;


			Grammar.LabelElementPair pair=null;
			String refdRuleName=null;

			// org/antlr/grammar/v3/ActionTranslator.g:356:2: ( '$' x= ID '.' y= ID {...}?{...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:356:4: '$' x= ID '.' y= ID {...}?{...}?
			{
			match('$'); if (state.failed) return;
			int xStart276 = getCharIndex();
			int xStartLine276 = getLine();
			int xStartCharPos276 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart276, getCharIndex()-1);
			x.setLine(xStartLine276);
			x.setCharPositionInLine(xStartCharPos276);

			match('.'); if (state.failed) return;
			int yStart282 = getCharIndex();
			int yStartLine282 = getLine();
			int yStartCharPos282 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart282, getCharIndex()-1);
			y.setLine(yStartLine282);
			y.setCharPositionInLine(yStartCharPos282);

			if ( !((enclosingRule!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "RULE_SCOPE_ATTR", "enclosingRule!=null");
			}
			if ( state.backtracking==1 ) {
					pair = enclosingRule.getRuleLabel((x!=null?x.getText():null));
					refdRuleName = (x!=null?x.getText():null);
					if ( pair!=null ) {
						refdRuleName = pair.referencedRuleName;
					}
					}
			if ( !(((enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null || isRuleRefInAlt((x!=null?x.getText():null))) &&
				      getRuleLabelAttribute(enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null?enclosingRule.getRuleLabel((x!=null?x.getText():null)).referencedRuleName:(x!=null?x.getText():null),(y!=null?y.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "RULE_SCOPE_ATTR", "(enclosingRule.getRuleLabel($x.text)!=null || isRuleRefInAlt($x.text)) &&\n\t      getRuleLabelAttribute(enclosingRule.getRuleLabel($x.text)!=null?enclosingRule.getRuleLabel($x.text).referencedRuleName:$x.text,$y.text)!=null");
			}
			if ( state.backtracking==1 ) {
					String label = (x!=null?x.getText():null);
					if ( pair==null ) {
						// $ruleref.attr  gotta get old label or compute new one
						checkElementRefUniqueness((x!=null?x.getText():null), false);
						label = enclosingRule.getElementLabel((x!=null?x.getText():null), outerAltNum, generator);
						if ( label==null ) {
							ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
													  grammar,
													  actionToken,
													  "$"+(x!=null?x.getText():null)+"."+(y!=null?y.getText():null));
							label = (x!=null?x.getText():null);
						}
					}
					ST st;
					Rule refdRule = grammar.getRule(refdRuleName);
					AttributeScope scope = refdRule.getLocalAttributeScope((y!=null?y.getText():null));
					if ( scope.isPredefinedRuleScope ) {
						st = template("ruleLabelPropertyRef_"+(y!=null?y.getText():null));
						grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
						st.add("scope", label);
						st.add("attr", (y!=null?y.getText():null));
					}
					else if ( scope.isPredefinedLexerRuleScope ) {
						st = template("lexerRuleLabelPropertyRef_"+(y!=null?y.getText():null));
						grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
						st.add("scope", label);
						st.add("attr", (y!=null?y.getText():null));
					}
					else if ( scope.isParameterScope ) {
						// TODO: error!
					}
					else {
						st = template("ruleLabelRef");
						st.add("referencedRule", refdRule);
						st.add("scope", label);
						st.add("attr", scope.getAttribute((y!=null?y.getText():null)));
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
	// $ANTLR end "RULE_SCOPE_ATTR"

	// $ANTLR start "LABEL_REF"
	public final void mLABEL_REF() throws RecognitionException {
		try {
			int _type = LABEL_REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken ID1=null;

			// org/antlr/grammar/v3/ActionTranslator.g:414:2: ( '$' ID {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:414:4: '$' ID {...}?
			{
			match('$'); if (state.failed) return;
			int ID1Start324 = getCharIndex();
			int ID1StartLine324 = getLine();
			int ID1StartCharPos324 = getCharPositionInLine();
			mID(); if (state.failed) return;
			ID1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID1Start324, getCharIndex()-1);
			ID1.setLine(ID1StartLine324);
			ID1.setCharPositionInLine(ID1StartCharPos324);

			if ( !((enclosingRule!=null &&
				            getElementLabel((ID1!=null?ID1.getText():null))!=null &&
					        enclosingRule.getRuleLabel((ID1!=null?ID1.getText():null))==null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "LABEL_REF", "enclosingRule!=null &&\n\t            getElementLabel($ID.text)!=null &&\n\t\t        enclosingRule.getRuleLabel($ID.text)==null");
			}
			if ( state.backtracking==1 ) {
					ST st;
					Grammar.LabelElementPair pair = getElementLabel((ID1!=null?ID1.getText():null));
					if ( pair.type==Grammar.RULE_LIST_LABEL ||
			             pair.type==Grammar.TOKEN_LIST_LABEL ||
			             pair.type==Grammar.WILDCARD_TREE_LIST_LABEL )
			        {
						st = template("listLabelRef");
					}
					else {
						st = template("tokenLabelRef");
					}
					st.add("label", (ID1!=null?ID1.getText():null));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LABEL_REF"

	// $ANTLR start "ISOLATED_TOKEN_REF"
	public final void mISOLATED_TOKEN_REF() throws RecognitionException {
		try {
			int _type = ISOLATED_TOKEN_REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken ID2=null;

			// org/antlr/grammar/v3/ActionTranslator.g:436:2: ( '$' ID {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:436:4: '$' ID {...}?
			{
			match('$'); if (state.failed) return;
			int ID2Start348 = getCharIndex();
			int ID2StartLine348 = getLine();
			int ID2StartCharPos348 = getCharPositionInLine();
			mID(); if (state.failed) return;
			ID2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID2Start348, getCharIndex()-1);
			ID2.setLine(ID2StartLine348);
			ID2.setCharPositionInLine(ID2StartCharPos348);

			if ( !((grammar.type!=Grammar.LEXER && enclosingRule!=null && isTokenRefInAlt((ID2!=null?ID2.getText():null)))) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "ISOLATED_TOKEN_REF", "grammar.type!=Grammar.LEXER && enclosingRule!=null && isTokenRefInAlt($ID.text)");
			}
			if ( state.backtracking==1 ) {
					String label = enclosingRule.getElementLabel((ID2!=null?ID2.getText():null), outerAltNum, generator);
					checkElementRefUniqueness((ID2!=null?ID2.getText():null), true);
					if ( label==null ) {
						ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
												  grammar,
												  actionToken,
												  (ID2!=null?ID2.getText():null));
					}
					else {
						ST st = template("tokenLabelRef");
						st.add("label", label);
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
	// $ANTLR end "ISOLATED_TOKEN_REF"

	// $ANTLR start "ISOLATED_LEXER_RULE_REF"
	public final void mISOLATED_LEXER_RULE_REF() throws RecognitionException {
		try {
			int _type = ISOLATED_LEXER_RULE_REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken ID3=null;

			// org/antlr/grammar/v3/ActionTranslator.g:456:2: ( '$' ID {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:456:4: '$' ID {...}?
			{
			match('$'); if (state.failed) return;
			int ID3Start372 = getCharIndex();
			int ID3StartLine372 = getLine();
			int ID3StartCharPos372 = getCharPositionInLine();
			mID(); if (state.failed) return;
			ID3 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID3Start372, getCharIndex()-1);
			ID3.setLine(ID3StartLine372);
			ID3.setCharPositionInLine(ID3StartCharPos372);

			if ( !((grammar.type==Grammar.LEXER &&
				             enclosingRule!=null &&
				             isRuleRefInAlt((ID3!=null?ID3.getText():null)))) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "ISOLATED_LEXER_RULE_REF", "grammar.type==Grammar.LEXER &&\n\t             enclosingRule!=null &&\n\t             isRuleRefInAlt($ID.text)");
			}
			if ( state.backtracking==1 ) {
					String label = enclosingRule.getElementLabel((ID3!=null?ID3.getText():null), outerAltNum, generator);
					checkElementRefUniqueness((ID3!=null?ID3.getText():null), false);
					if ( label==null ) {
						ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
												  grammar,
												  actionToken,
												  (ID3!=null?ID3.getText():null));
					}
					else {
						ST st = template("lexerRuleLabel");
						st.add("label", label);
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
	// $ANTLR end "ISOLATED_LEXER_RULE_REF"

	// $ANTLR start "SET_LOCAL_ATTR"
	public final void mSET_LOCAL_ATTR() throws RecognitionException {
		try {
			int _type = SET_LOCAL_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken expr=null;
			CommonToken ID4=null;

			// org/antlr/grammar/v3/ActionTranslator.g:488:2: ( '$' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:488:4: '$' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
			{
			match('$'); if (state.failed) return;
			int ID4Start396 = getCharIndex();
			int ID4StartLine396 = getLine();
			int ID4StartCharPos396 = getCharPositionInLine();
			mID(); if (state.failed) return;
			ID4 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID4Start396, getCharIndex()-1);
			ID4.setLine(ID4StartLine396);
			ID4.setCharPositionInLine(ID4StartCharPos396);

			// org/antlr/grammar/v3/ActionTranslator.g:488:11: ( WS )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:488:11: WS
					{
					mWS(); if (state.failed) return;

					}
					break;

			}

			match('='); if (state.failed) return;
			int exprStart405 = getCharIndex();
			int exprStartLine405 = getLine();
			int exprStartCharPos405 = getCharPositionInLine();
			mATTR_VALUE_EXPR(); if (state.failed) return;
			expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart405, getCharIndex()-1);
			expr.setLine(exprStartLine405);
			expr.setCharPositionInLine(exprStartCharPos405);

			match(';'); if (state.failed) return;
			if ( !((enclosingRule!=null
																&& enclosingRule.getLocalAttributeScope((ID4!=null?ID4.getText():null))!=null
																&& !enclosingRule.getLocalAttributeScope((ID4!=null?ID4.getText():null)).isPredefinedLexerRuleScope)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "SET_LOCAL_ATTR", "enclosingRule!=null\n\t\t\t\t\t\t\t\t\t\t\t\t\t&& enclosingRule.getLocalAttributeScope($ID.text)!=null\n\t\t\t\t\t\t\t\t\t\t\t\t\t&& !enclosingRule.getLocalAttributeScope($ID.text).isPredefinedLexerRuleScope");
			}
			if ( state.backtracking==1 ) {
					ST st;
					AttributeScope scope = enclosingRule.getLocalAttributeScope((ID4!=null?ID4.getText():null));
					if ( scope.isPredefinedRuleScope ) {
						if ((ID4!=null?ID4.getText():null).equals("tree") || (ID4!=null?ID4.getText():null).equals("st")) {
							st = template("ruleSetPropertyRef_"+(ID4!=null?ID4.getText():null));
							grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
							st.add("scope", enclosingRule.name);
							st.add("attr", (ID4!=null?ID4.getText():null));
							st.add("expr", translateAction((expr!=null?expr.getText():null)));
						} else {
							ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
													 grammar,
													 actionToken,
													 (ID4!=null?ID4.getText():null),
													 "");
						}
					}
					else if ( scope.isParameterScope ) {
						st = template("parameterSetAttributeRef");
						st.add("attr", scope.getAttribute((ID4!=null?ID4.getText():null)));
						st.add("expr", translateAction((expr!=null?expr.getText():null)));
					}
					else {
						st = template("returnSetAttributeRef");
						st.add("ruleDescriptor", enclosingRule);
						st.add("attr", scope.getAttribute((ID4!=null?ID4.getText():null)));
						st.add("expr", translateAction((expr!=null?expr.getText():null)));
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
	// $ANTLR end "SET_LOCAL_ATTR"

	// $ANTLR start "LOCAL_ATTR"
	public final void mLOCAL_ATTR() throws RecognitionException {
		try {
			int _type = LOCAL_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken ID5=null;

			// org/antlr/grammar/v3/ActionTranslator.g:524:2: ( '$' ID {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:524:4: '$' ID {...}?
			{
			match('$'); if (state.failed) return;
			int ID5Start428 = getCharIndex();
			int ID5StartLine428 = getLine();
			int ID5StartCharPos428 = getCharPositionInLine();
			mID(); if (state.failed) return;
			ID5 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID5Start428, getCharIndex()-1);
			ID5.setLine(ID5StartLine428);
			ID5.setCharPositionInLine(ID5StartCharPos428);

			if ( !((enclosingRule!=null && enclosingRule.getLocalAttributeScope((ID5!=null?ID5.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "LOCAL_ATTR", "enclosingRule!=null && enclosingRule.getLocalAttributeScope($ID.text)!=null");
			}
			if ( state.backtracking==1 ) {
					ST st;
					AttributeScope scope = enclosingRule.getLocalAttributeScope((ID5!=null?ID5.getText():null));
					if ( scope.isPredefinedRuleScope ) {
						st = template("rulePropertyRef_"+(ID5!=null?ID5.getText():null));
						grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
						st.add("scope", enclosingRule.name);
						st.add("attr", (ID5!=null?ID5.getText():null));
					}
					else if ( scope.isPredefinedLexerRuleScope ) {
						st = template("lexerRulePropertyRef_"+(ID5!=null?ID5.getText():null));
						st.add("scope", enclosingRule.name);
						st.add("attr", (ID5!=null?ID5.getText():null));
					}
					else if ( scope.isParameterScope ) {
						st = template("parameterAttributeRef");
						st.add("attr", scope.getAttribute((ID5!=null?ID5.getText():null)));
					}
					else {
						st = template("returnAttributeRef");
						st.add("ruleDescriptor", enclosingRule);
						st.add("attr", scope.getAttribute((ID5!=null?ID5.getText():null)));
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
	// $ANTLR end "LOCAL_ATTR"

	// $ANTLR start "SET_DYNAMIC_SCOPE_ATTR"
	public final void mSET_DYNAMIC_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = SET_DYNAMIC_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;
			CommonToken expr=null;

			// org/antlr/grammar/v3/ActionTranslator.g:565:2: ( '$' x= ID '::' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:565:4: '$' x= ID '::' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
			{
			match('$'); if (state.failed) return;
			int xStart454 = getCharIndex();
			int xStartLine454 = getLine();
			int xStartCharPos454 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart454, getCharIndex()-1);
			x.setLine(xStartLine454);
			x.setCharPositionInLine(xStartCharPos454);

			match("::"); if (state.failed) return;

			int yStart460 = getCharIndex();
			int yStartLine460 = getLine();
			int yStartCharPos460 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart460, getCharIndex()-1);
			y.setLine(yStartLine460);
			y.setCharPositionInLine(yStartCharPos460);

			// org/antlr/grammar/v3/ActionTranslator.g:565:23: ( WS )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:565:23: WS
					{
					mWS(); if (state.failed) return;

					}
					break;

			}

			match('='); if (state.failed) return;
			int exprStart469 = getCharIndex();
			int exprStartLine469 = getLine();
			int exprStartCharPos469 = getCharPositionInLine();
			mATTR_VALUE_EXPR(); if (state.failed) return;
			expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart469, getCharIndex()-1);
			expr.setLine(exprStartLine469);
			expr.setCharPositionInLine(exprStartCharPos469);

			match(';'); if (state.failed) return;
			if ( !((resolveDynamicScope((x!=null?x.getText():null))!=null &&
									     resolveDynamicScope((x!=null?x.getText():null)).getAttribute((y!=null?y.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "SET_DYNAMIC_SCOPE_ATTR", "resolveDynamicScope($x.text)!=null &&\n\t\t\t\t\t\t     resolveDynamicScope($x.text).getAttribute($y.text)!=null");
			}
			if ( state.backtracking==1 ) {
					AttributeScope scope = resolveDynamicScope((x!=null?x.getText():null));
					if ( scope!=null ) {
						ST st = template("scopeSetAttributeRef");
						st.add("scope", (x!=null?x.getText():null));
						st.add("attr",  scope.getAttribute((y!=null?y.getText():null)));
						st.add("expr",  translateAction((expr!=null?expr.getText():null)));
					}
					else {
						// error: invalid dynamic attribute
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
	// $ANTLR end "SET_DYNAMIC_SCOPE_ATTR"

	// $ANTLR start "DYNAMIC_SCOPE_ATTR"
	public final void mDYNAMIC_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = DYNAMIC_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionTranslator.g:584:2: ( '$' x= ID '::' y= ID {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:584:4: '$' x= ID '::' y= ID {...}?
			{
			match('$'); if (state.failed) return;
			int xStart504 = getCharIndex();
			int xStartLine504 = getLine();
			int xStartCharPos504 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart504, getCharIndex()-1);
			x.setLine(xStartLine504);
			x.setCharPositionInLine(xStartCharPos504);

			match("::"); if (state.failed) return;

			int yStart510 = getCharIndex();
			int yStartLine510 = getLine();
			int yStartCharPos510 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart510, getCharIndex()-1);
			y.setLine(yStartLine510);
			y.setCharPositionInLine(yStartCharPos510);

			if ( !((resolveDynamicScope((x!=null?x.getText():null))!=null &&
									     resolveDynamicScope((x!=null?x.getText():null)).getAttribute((y!=null?y.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "DYNAMIC_SCOPE_ATTR", "resolveDynamicScope($x.text)!=null &&\n\t\t\t\t\t\t     resolveDynamicScope($x.text).getAttribute($y.text)!=null");
			}
			if ( state.backtracking==1 ) {
					AttributeScope scope = resolveDynamicScope((x!=null?x.getText():null));
					if ( scope!=null ) {
						ST st = template("scopeAttributeRef");
						st.add("scope", (x!=null?x.getText():null));
						st.add("attr",  scope.getAttribute((y!=null?y.getText():null)));
					}
					else {
						// error: invalid dynamic attribute
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
	// $ANTLR end "DYNAMIC_SCOPE_ATTR"

	// $ANTLR start "ERROR_SCOPED_XY"
	public final void mERROR_SCOPED_XY() throws RecognitionException {
		try {
			int _type = ERROR_SCOPED_XY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionTranslator.g:603:2: ( '$' x= ID '::' y= ID )
			// org/antlr/grammar/v3/ActionTranslator.g:603:4: '$' x= ID '::' y= ID
			{
			match('$'); if (state.failed) return;
			int xStart544 = getCharIndex();
			int xStartLine544 = getLine();
			int xStartCharPos544 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart544, getCharIndex()-1);
			x.setLine(xStartLine544);
			x.setCharPositionInLine(xStartCharPos544);

			match("::"); if (state.failed) return;

			int yStart550 = getCharIndex();
			int yStartLine550 = getLine();
			int yStartCharPos550 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart550, getCharIndex()-1);
			y.setLine(yStartLine550);
			y.setCharPositionInLine(yStartCharPos550);

			if ( state.backtracking==1 ) {
					chunks.add(getText());
					generator.issueInvalidScopeError((x!=null?x.getText():null),(y!=null?y.getText():null),
					                                 enclosingRule,actionToken,
					                                 outerAltNum);		
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ERROR_SCOPED_XY"

	// $ANTLR start "DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR"
	public final void mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken expr=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionTranslator.g:621:2: ( '$' x= ID '[' '-' expr= SCOPE_INDEX_EXPR ']' '::' y= ID )
			// org/antlr/grammar/v3/ActionTranslator.g:621:4: '$' x= ID '[' '-' expr= SCOPE_INDEX_EXPR ']' '::' y= ID
			{
			match('$'); if (state.failed) return;
			int xStart572 = getCharIndex();
			int xStartLine572 = getLine();
			int xStartCharPos572 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart572, getCharIndex()-1);
			x.setLine(xStartLine572);
			x.setCharPositionInLine(xStartCharPos572);

			match('['); if (state.failed) return;
			match('-'); if (state.failed) return;
			int exprStart580 = getCharIndex();
			int exprStartLine580 = getLine();
			int exprStartCharPos580 = getCharPositionInLine();
			mSCOPE_INDEX_EXPR(); if (state.failed) return;
			expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart580, getCharIndex()-1);
			expr.setLine(exprStartLine580);
			expr.setCharPositionInLine(exprStartCharPos580);

			match(']'); if (state.failed) return;
			match("::"); if (state.failed) return;

			int yStart588 = getCharIndex();
			int yStartLine588 = getLine();
			int yStartCharPos588 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart588, getCharIndex()-1);
			y.setLine(yStartLine588);
			y.setCharPositionInLine(yStartCharPos588);

			if ( state.backtracking==1 ) {
					ST st = template("scopeAttributeRef");
					st.add("scope",    (x!=null?x.getText():null));
					st.add("attr",     resolveDynamicScope((x!=null?x.getText():null)).getAttribute((y!=null?y.getText():null)));
					st.add("negIndex", (expr!=null?expr.getText():null));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR"

	// $ANTLR start "DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR"
	public final void mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR() throws RecognitionException {
		try {
			int _type = DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken expr=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionTranslator.g:632:2: ( '$' x= ID '[' expr= SCOPE_INDEX_EXPR ']' '::' y= ID )
			// org/antlr/grammar/v3/ActionTranslator.g:632:4: '$' x= ID '[' expr= SCOPE_INDEX_EXPR ']' '::' y= ID
			{
			match('$'); if (state.failed) return;
			int xStart612 = getCharIndex();
			int xStartLine612 = getLine();
			int xStartCharPos612 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart612, getCharIndex()-1);
			x.setLine(xStartLine612);
			x.setCharPositionInLine(xStartCharPos612);

			match('['); if (state.failed) return;
			int exprStart618 = getCharIndex();
			int exprStartLine618 = getLine();
			int exprStartCharPos618 = getCharPositionInLine();
			mSCOPE_INDEX_EXPR(); if (state.failed) return;
			expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart618, getCharIndex()-1);
			expr.setLine(exprStartLine618);
			expr.setCharPositionInLine(exprStartCharPos618);

			match(']'); if (state.failed) return;
			match("::"); if (state.failed) return;

			int yStart626 = getCharIndex();
			int yStartLine626 = getLine();
			int yStartCharPos626 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart626, getCharIndex()-1);
			y.setLine(yStartLine626);
			y.setCharPositionInLine(yStartCharPos626);

			if ( state.backtracking==1 ) {
					ST st = template("scopeAttributeRef");
					st.add("scope", (x!=null?x.getText():null));
					st.add("attr",  resolveDynamicScope((x!=null?x.getText():null)).getAttribute((y!=null?y.getText():null)));
					st.add("index", (expr!=null?expr.getText():null));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR"

	// $ANTLR start "SCOPE_INDEX_EXPR"
	public final void mSCOPE_INDEX_EXPR() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ActionTranslator.g:644:2: ( (~ ']' )+ )
			// org/antlr/grammar/v3/ActionTranslator.g:644:4: (~ ']' )+
			{
			// org/antlr/grammar/v3/ActionTranslator.g:644:4: (~ ']' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\\')||(LA6_0 >= '^' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:
					{
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
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCOPE_INDEX_EXPR"

	// $ANTLR start "ISOLATED_DYNAMIC_SCOPE"
	public final void mISOLATED_DYNAMIC_SCOPE() throws RecognitionException {
		try {
			int _type = ISOLATED_DYNAMIC_SCOPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken ID6=null;

			// org/antlr/grammar/v3/ActionTranslator.g:653:2: ( '$' ID {...}?)
			// org/antlr/grammar/v3/ActionTranslator.g:653:4: '$' ID {...}?
			{
			match('$'); if (state.failed) return;
			int ID6Start669 = getCharIndex();
			int ID6StartLine669 = getLine();
			int ID6StartCharPos669 = getCharPositionInLine();
			mID(); if (state.failed) return;
			ID6 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID6Start669, getCharIndex()-1);
			ID6.setLine(ID6StartLine669);
			ID6.setCharPositionInLine(ID6StartCharPos669);

			if ( !((resolveDynamicScope((ID6!=null?ID6.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "ISOLATED_DYNAMIC_SCOPE", "resolveDynamicScope($ID.text)!=null");
			}
			if ( state.backtracking==1 ) {
					ST st = template("isolatedDynamicScopeRef");
					st.add("scope", (ID6!=null?ID6.getText():null));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ISOLATED_DYNAMIC_SCOPE"

	// $ANTLR start "TEMPLATE_INSTANCE"
	public final void mTEMPLATE_INSTANCE() throws RecognitionException {
		try {
			int _type = TEMPLATE_INSTANCE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ActionTranslator.g:666:2: ( '%' ID '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')' )
			// org/antlr/grammar/v3/ActionTranslator.g:666:4: '%' ID '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')'
			{
			match('%'); if (state.failed) return;
			mID(); if (state.failed) return;

			match('('); if (state.failed) return;
			// org/antlr/grammar/v3/ActionTranslator.g:666:15: ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( ((LA11_0 >= '\t' && LA11_0 <= '\n')||LA11_0=='\r'||LA11_0==' '||(LA11_0 >= 'A' && LA11_0 <= 'Z')||LA11_0=='_'||(LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:666:17: ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )?
					{
					// org/antlr/grammar/v3/ActionTranslator.g:666:17: ( WS )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// org/antlr/grammar/v3/ActionTranslator.g:666:17: WS
							{
							mWS(); if (state.failed) return;

							}
							break;

					}

					mARG(); if (state.failed) return;

					// org/antlr/grammar/v3/ActionTranslator.g:666:25: ( ',' ( WS )? ARG )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==',') ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// org/antlr/grammar/v3/ActionTranslator.g:666:26: ',' ( WS )? ARG
							{
							match(','); if (state.failed) return;
							// org/antlr/grammar/v3/ActionTranslator.g:666:30: ( WS )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( ((LA8_0 >= '\t' && LA8_0 <= '\n')||LA8_0=='\r'||LA8_0==' ') ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// org/antlr/grammar/v3/ActionTranslator.g:666:30: WS
									{
									mWS(); if (state.failed) return;

									}
									break;

							}

							mARG(); if (state.failed) return;

							}
							break;

						default :
							break loop9;
						}
					}

					// org/antlr/grammar/v3/ActionTranslator.g:666:40: ( WS )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( ((LA10_0 >= '\t' && LA10_0 <= '\n')||LA10_0=='\r'||LA10_0==' ') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// org/antlr/grammar/v3/ActionTranslator.g:666:40: WS
							{
							mWS(); if (state.failed) return;

							}
							break;

					}

					}
					break;

			}

			match(')'); if (state.failed) return;
			if ( state.backtracking==1 ) {
					String action = getText().substring(1,getText().length());
					String ruleName = "<outside-of-rule>";
					if ( enclosingRule!=null ) {
						ruleName = enclosingRule.name;
					}
					ST st =
						generator.translateTemplateConstructor(ruleName,
															   outerAltNum,
															   actionToken,
															   action);
					if ( st!=null ) {
						chunks.add(st);
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
	// $ANTLR end "TEMPLATE_INSTANCE"

	// $ANTLR start "INDIRECT_TEMPLATE_INSTANCE"
	public final void mINDIRECT_TEMPLATE_INSTANCE() throws RecognitionException {
		try {
			int _type = INDIRECT_TEMPLATE_INSTANCE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ActionTranslator.g:687:2: ( '%' '(' ACTION ')' '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')' )
			// org/antlr/grammar/v3/ActionTranslator.g:687:4: '%' '(' ACTION ')' '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')'
			{
			match('%'); if (state.failed) return;
			match('('); if (state.failed) return;
			mACTION(); if (state.failed) return;

			match(')'); if (state.failed) return;
			match('('); if (state.failed) return;
			// org/antlr/grammar/v3/ActionTranslator.g:687:27: ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( ((LA16_0 >= '\t' && LA16_0 <= '\n')||LA16_0=='\r'||LA16_0==' '||(LA16_0 >= 'A' && LA16_0 <= 'Z')||LA16_0=='_'||(LA16_0 >= 'a' && LA16_0 <= 'z')) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:687:29: ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )?
					{
					// org/antlr/grammar/v3/ActionTranslator.g:687:29: ( WS )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||LA12_0=='\r'||LA12_0==' ') ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// org/antlr/grammar/v3/ActionTranslator.g:687:29: WS
							{
							mWS(); if (state.failed) return;

							}
							break;

					}

					mARG(); if (state.failed) return;

					// org/antlr/grammar/v3/ActionTranslator.g:687:37: ( ',' ( WS )? ARG )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==',') ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// org/antlr/grammar/v3/ActionTranslator.g:687:38: ',' ( WS )? ARG
							{
							match(','); if (state.failed) return;
							// org/antlr/grammar/v3/ActionTranslator.g:687:42: ( WS )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( ((LA13_0 >= '\t' && LA13_0 <= '\n')||LA13_0=='\r'||LA13_0==' ') ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// org/antlr/grammar/v3/ActionTranslator.g:687:42: WS
									{
									mWS(); if (state.failed) return;

									}
									break;

							}

							mARG(); if (state.failed) return;

							}
							break;

						default :
							break loop14;
						}
					}

					// org/antlr/grammar/v3/ActionTranslator.g:687:52: ( WS )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( ((LA15_0 >= '\t' && LA15_0 <= '\n')||LA15_0=='\r'||LA15_0==' ') ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// org/antlr/grammar/v3/ActionTranslator.g:687:52: WS
							{
							mWS(); if (state.failed) return;

							}
							break;

					}

					}
					break;

			}

			match(')'); if (state.failed) return;
			if ( state.backtracking==1 ) {
					String action = getText().substring(1,getText().length());
					ST st =
						generator.translateTemplateConstructor(enclosingRule.name,
															   outerAltNum,
															   actionToken,
															   action);
					chunks.add(st);
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INDIRECT_TEMPLATE_INSTANCE"

	// $ANTLR start "ARG"
	public final void mARG() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ActionTranslator.g:701:5: ( ID '=' ACTION )
			// org/antlr/grammar/v3/ActionTranslator.g:701:7: ID '=' ACTION
			{
			mID(); if (state.failed) return;

			match('='); if (state.failed) return;
			mACTION(); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARG"

	// $ANTLR start "SET_EXPR_ATTRIBUTE"
	public final void mSET_EXPR_ATTRIBUTE() throws RecognitionException {
		try {
			int _type = SET_EXPR_ATTRIBUTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken a=null;
			CommonToken expr=null;
			CommonToken ID7=null;

			// org/antlr/grammar/v3/ActionTranslator.g:706:2: ( '%' a= ACTION '.' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
			// org/antlr/grammar/v3/ActionTranslator.g:706:4: '%' a= ACTION '.' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
			{
			match('%'); if (state.failed) return;
			int aStart819 = getCharIndex();
			int aStartLine819 = getLine();
			int aStartCharPos819 = getCharPositionInLine();
			mACTION(); if (state.failed) return;
			a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart819, getCharIndex()-1);
			a.setLine(aStartLine819);
			a.setCharPositionInLine(aStartCharPos819);

			match('.'); if (state.failed) return;
			int ID7Start823 = getCharIndex();
			int ID7StartLine823 = getLine();
			int ID7StartCharPos823 = getCharPositionInLine();
			mID(); if (state.failed) return;
			ID7 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID7Start823, getCharIndex()-1);
			ID7.setLine(ID7StartLine823);
			ID7.setCharPositionInLine(ID7StartCharPos823);

			// org/antlr/grammar/v3/ActionTranslator.g:706:24: ( WS )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( ((LA17_0 >= '\t' && LA17_0 <= '\n')||LA17_0=='\r'||LA17_0==' ') ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:706:24: WS
					{
					mWS(); if (state.failed) return;

					}
					break;

			}

			match('='); if (state.failed) return;
			int exprStart832 = getCharIndex();
			int exprStartLine832 = getLine();
			int exprStartCharPos832 = getCharPositionInLine();
			mATTR_VALUE_EXPR(); if (state.failed) return;
			expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart832, getCharIndex()-1);
			expr.setLine(exprStartLine832);
			expr.setCharPositionInLine(exprStartCharPos832);

			match(';'); if (state.failed) return;
			if ( state.backtracking==1 ) {
					ST st = template("actionSetAttribute");
					String action = (a!=null?a.getText():null);
					action = action.substring(1,action.length()-1); // stuff inside {...}
					st.add("st", translateAction(action));
					st.add("attrName", (ID7!=null?ID7.getText():null));
					st.add("expr", translateAction((expr!=null?expr.getText():null)));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET_EXPR_ATTRIBUTE"

	// $ANTLR start "SET_ATTRIBUTE"
	public final void mSET_ATTRIBUTE() throws RecognitionException {
		try {
			int _type = SET_ATTRIBUTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;
			CommonToken expr=null;

			// org/antlr/grammar/v3/ActionTranslator.g:723:2: ( '%' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
			// org/antlr/grammar/v3/ActionTranslator.g:723:4: '%' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
			{
			match('%'); if (state.failed) return;
			int xStart859 = getCharIndex();
			int xStartLine859 = getLine();
			int xStartCharPos859 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart859, getCharIndex()-1);
			x.setLine(xStartLine859);
			x.setCharPositionInLine(xStartCharPos859);

			match('.'); if (state.failed) return;
			int yStart865 = getCharIndex();
			int yStartLine865 = getLine();
			int yStartCharPos865 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart865, getCharIndex()-1);
			y.setLine(yStartLine865);
			y.setCharPositionInLine(yStartCharPos865);

			// org/antlr/grammar/v3/ActionTranslator.g:723:22: ( WS )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( ((LA18_0 >= '\t' && LA18_0 <= '\n')||LA18_0=='\r'||LA18_0==' ') ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:723:22: WS
					{
					mWS(); if (state.failed) return;

					}
					break;

			}

			match('='); if (state.failed) return;
			int exprStart874 = getCharIndex();
			int exprStartLine874 = getLine();
			int exprStartCharPos874 = getCharPositionInLine();
			mATTR_VALUE_EXPR(); if (state.failed) return;
			expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart874, getCharIndex()-1);
			expr.setLine(exprStartLine874);
			expr.setCharPositionInLine(exprStartCharPos874);

			match(';'); if (state.failed) return;
			if ( state.backtracking==1 ) {
					ST st = template("actionSetAttribute");
					st.add("st", (x!=null?x.getText():null));
					st.add("attrName", (y!=null?y.getText():null));
					st.add("expr", translateAction((expr!=null?expr.getText():null)));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET_ATTRIBUTE"

	// $ANTLR start "ATTR_VALUE_EXPR"
	public final void mATTR_VALUE_EXPR() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ActionTranslator.g:736:2: (~ '=' (~ ';' )* )
			// org/antlr/grammar/v3/ActionTranslator.g:736:4: ~ '=' (~ ';' )*
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '<')||(input.LA(1) >= '>' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// org/antlr/grammar/v3/ActionTranslator.g:736:9: (~ ';' )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( ((LA19_0 >= '\u0000' && LA19_0 <= ':')||(LA19_0 >= '<' && LA19_0 <= '\uFFFF')) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= '\uFFFF') ) {
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

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ATTR_VALUE_EXPR"

	// $ANTLR start "TEMPLATE_EXPR"
	public final void mTEMPLATE_EXPR() throws RecognitionException {
		try {
			int _type = TEMPLATE_EXPR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken a=null;

			// org/antlr/grammar/v3/ActionTranslator.g:741:2: ( '%' a= ACTION )
			// org/antlr/grammar/v3/ActionTranslator.g:741:4: '%' a= ACTION
			{
			match('%'); if (state.failed) return;
			int aStart923 = getCharIndex();
			int aStartLine923 = getLine();
			int aStartCharPos923 = getCharPositionInLine();
			mACTION(); if (state.failed) return;
			a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart923, getCharIndex()-1);
			a.setLine(aStartLine923);
			a.setCharPositionInLine(aStartCharPos923);

			if ( state.backtracking==1 ) {
					ST st = template("actionStringConstructor");
					String action = (a!=null?a.getText():null);
					action = action.substring(1,action.length()-1); // stuff inside {...}
					st.add("stringExpr", translateAction(action));
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEMPLATE_EXPR"

	// $ANTLR start "ACTION"
	public final void mACTION() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ActionTranslator.g:753:2: ( '{' ( options {greedy=false; } : . )* '}' )
			// org/antlr/grammar/v3/ActionTranslator.g:753:4: '{' ( options {greedy=false; } : . )* '}'
			{
			match('{'); if (state.failed) return;
			// org/antlr/grammar/v3/ActionTranslator.g:753:8: ( options {greedy=false; } : . )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0=='}') ) {
					alt20=2;
				}
				else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '|')||(LA20_0 >= '~' && LA20_0 <= '\uFFFF')) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:753:33: .
					{
					matchAny(); if (state.failed) return;
					}
					break;

				default :
					break loop20;
				}
			}

			match('}'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTION"

	// $ANTLR start "ESC"
	public final void mESC() throws RecognitionException {
		try {
			int _type = ESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ActionTranslator.g:756:5: ( '\\\\' '$' | '\\\\' '%' | '\\\\' ~ ( '$' | '%' ) )
			int alt21=3;
			int LA21_0 = input.LA(1);
			if ( (LA21_0=='\\') ) {
				int LA21_1 = input.LA(2);
				if ( (LA21_1=='$') ) {
					alt21=1;
				}
				else if ( (LA21_1=='%') ) {
					alt21=2;
				}
				else if ( ((LA21_1 >= '\u0000' && LA21_1 <= '#')||(LA21_1 >= '&' && LA21_1 <= '\uFFFF')) ) {
					alt21=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:756:9: '\\\\' '$'
					{
					match('\\'); if (state.failed) return;
					match('$'); if (state.failed) return;
					if ( state.backtracking==1 ) {chunks.add("$");}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ActionTranslator.g:757:4: '\\\\' '%'
					{
					match('\\'); if (state.failed) return;
					match('%'); if (state.failed) return;
					if ( state.backtracking==1 ) {chunks.add("%");}
					}
					break;
				case 3 :
					// org/antlr/grammar/v3/ActionTranslator.g:758:4: '\\\\' ~ ( '$' | '%' )
					{
					match('\\'); if (state.failed) return;
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '#')||(input.LA(1) >= '&' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( state.backtracking==1 ) {chunks.add(getText());}
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC"

	// $ANTLR start "ERROR_XY"
	public final void mERROR_XY() throws RecognitionException {
		try {
			int _type = ERROR_XY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionTranslator.g:762:2: ( '$' x= ID '.' y= ID )
			// org/antlr/grammar/v3/ActionTranslator.g:762:4: '$' x= ID '.' y= ID
			{
			match('$'); if (state.failed) return;
			int xStart1023 = getCharIndex();
			int xStartLine1023 = getLine();
			int xStartCharPos1023 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart1023, getCharIndex()-1);
			x.setLine(xStartLine1023);
			x.setCharPositionInLine(xStartCharPos1023);

			match('.'); if (state.failed) return;
			int yStart1029 = getCharIndex();
			int yStartLine1029 = getLine();
			int yStartCharPos1029 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart1029, getCharIndex()-1);
			y.setLine(yStartLine1029);
			y.setCharPositionInLine(yStartCharPos1029);

			if ( state.backtracking==1 ) {
					chunks.add(getText());
					generator.issueInvalidAttributeError((x!=null?x.getText():null),(y!=null?y.getText():null),
					                                     enclosingRule,actionToken,
					                                     outerAltNum);
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ERROR_XY"

	// $ANTLR start "ERROR_X"
	public final void mERROR_X() throws RecognitionException {
		try {
			int _type = ERROR_X;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;

			// org/antlr/grammar/v3/ActionTranslator.g:772:2: ( '$' x= ID )
			// org/antlr/grammar/v3/ActionTranslator.g:772:4: '$' x= ID
			{
			match('$'); if (state.failed) return;
			int xStart1049 = getCharIndex();
			int xStartLine1049 = getLine();
			int xStartCharPos1049 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart1049, getCharIndex()-1);
			x.setLine(xStartLine1049);
			x.setCharPositionInLine(xStartCharPos1049);

			if ( state.backtracking==1 ) {
					chunks.add(getText());
					generator.issueInvalidAttributeError((x!=null?x.getText():null),
					                                     enclosingRule,actionToken,
					                                     outerAltNum);
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ERROR_X"

	// $ANTLR start "UNKNOWN_SYNTAX"
	public final void mUNKNOWN_SYNTAX() throws RecognitionException {
		try {
			int _type = UNKNOWN_SYNTAX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ActionTranslator.g:782:2: ( '$' | '%' ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )* )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0=='$') ) {
				alt23=1;
			}
			else if ( (LA23_0=='%') ) {
				alt23=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:782:4: '$'
					{
					match('$'); if (state.failed) return;
					if ( state.backtracking==1 ) {
							chunks.add(getText());
							// shouldn't need an error here.  Just accept $ if it doesn't look like anything
							}
					}
					break;
				case 2 :
					// org/antlr/grammar/v3/ActionTranslator.g:787:4: '%' ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )*
					{
					match('%'); if (state.failed) return;
					// org/antlr/grammar/v3/ActionTranslator.g:787:8: ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )*
					loop22:
					while (true) {
						int alt22=9;
						switch ( input.LA(1) ) {
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
						case 'G':
						case 'H':
						case 'I':
						case 'J':
						case 'K':
						case 'L':
						case 'M':
						case 'N':
						case 'O':
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
						case '_':
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
						case 'g':
						case 'h':
						case 'i':
						case 'j':
						case 'k':
						case 'l':
						case 'm':
						case 'n':
						case 'o':
						case 'p':
						case 'q':
						case 'r':
						case 's':
						case 't':
						case 'u':
						case 'v':
						case 'w':
						case 'x':
						case 'y':
						case 'z':
							{
							alt22=1;
							}
							break;
						case '.':
							{
							alt22=2;
							}
							break;
						case '(':
							{
							alt22=3;
							}
							break;
						case ')':
							{
							alt22=4;
							}
							break;
						case ',':
							{
							alt22=5;
							}
							break;
						case '{':
							{
							alt22=6;
							}
							break;
						case '}':
							{
							alt22=7;
							}
							break;
						case '\"':
							{
							alt22=8;
							}
							break;
						}
						switch (alt22) {
						case 1 :
							// org/antlr/grammar/v3/ActionTranslator.g:787:9: ID
							{
							mID(); if (state.failed) return;

							}
							break;
						case 2 :
							// org/antlr/grammar/v3/ActionTranslator.g:787:12: '.'
							{
							match('.'); if (state.failed) return;
							}
							break;
						case 3 :
							// org/antlr/grammar/v3/ActionTranslator.g:787:16: '('
							{
							match('('); if (state.failed) return;
							}
							break;
						case 4 :
							// org/antlr/grammar/v3/ActionTranslator.g:787:20: ')'
							{
							match(')'); if (state.failed) return;
							}
							break;
						case 5 :
							// org/antlr/grammar/v3/ActionTranslator.g:787:24: ','
							{
							match(','); if (state.failed) return;
							}
							break;
						case 6 :
							// org/antlr/grammar/v3/ActionTranslator.g:787:28: '{'
							{
							match('{'); if (state.failed) return;
							}
							break;
						case 7 :
							// org/antlr/grammar/v3/ActionTranslator.g:787:32: '}'
							{
							match('}'); if (state.failed) return;
							}
							break;
						case 8 :
							// org/antlr/grammar/v3/ActionTranslator.g:787:36: '\"'
							{
							match('\"'); if (state.failed) return;
							}
							break;

						default :
							break loop22;
						}
					}

					if ( state.backtracking==1 ) {
							chunks.add(getText());
							ErrorManager.grammarError(ErrorManager.MSG_INVALID_TEMPLATE_ACTION,
													  grammar,
													  actionToken,
													  getText());
							}
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNKNOWN_SYNTAX"

	// $ANTLR start "TEXT"
	public final void mTEXT() throws RecognitionException {
		try {
			int _type = TEXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/antlr/grammar/v3/ActionTranslator.g:797:5: ( (~ ( '$' | '%' | '\\\\' ) )+ )
			// org/antlr/grammar/v3/ActionTranslator.g:797:7: (~ ( '$' | '%' | '\\\\' ) )+
			{
			// org/antlr/grammar/v3/ActionTranslator.g:797:7: (~ ( '$' | '%' | '\\\\' ) )+
			int cnt24=0;
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( ((LA24_0 >= '\u0000' && LA24_0 <= '#')||(LA24_0 >= '&' && LA24_0 <= '[')||(LA24_0 >= ']' && LA24_0 <= '\uFFFF')) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '#')||(input.LA(1) >= '&' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
					if ( cnt24 >= 1 ) break loop24;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(24, input);
					throw eee;
				}
				cnt24++;
			}

			if ( state.backtracking==1 ) {chunks.add(getText());}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEXT"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ActionTranslator.g:801:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// org/antlr/grammar/v3/ActionTranslator.g:801:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// org/antlr/grammar/v3/ActionTranslator.g:801:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( ((LA25_0 >= '0' && LA25_0 <= '9')||(LA25_0 >= 'A' && LA25_0 <= 'Z')||LA25_0=='_'||(LA25_0 >= 'a' && LA25_0 <= 'z')) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:
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
					break loop25;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ActionTranslator.g:805:5: ( ( '0' .. '9' )+ )
			// org/antlr/grammar/v3/ActionTranslator.g:805:7: ( '0' .. '9' )+
			{
			// org/antlr/grammar/v3/ActionTranslator.g:805:7: ( '0' .. '9' )+
			int cnt26=0;
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( ((LA26_0 >= '0' && LA26_0 <= '9')) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:
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
					if ( cnt26 >= 1 ) break loop26;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(26, input);
					throw eee;
				}
				cnt26++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ActionTranslator.g:809:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// org/antlr/grammar/v3/ActionTranslator.g:809:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// org/antlr/grammar/v3/ActionTranslator.g:809:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt27=0;
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( ((LA27_0 >= '\t' && LA27_0 <= '\n')||LA27_0=='\r'||LA27_0==' ') ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// org/antlr/grammar/v3/ActionTranslator.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt27 >= 1 ) break loop27;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(27, input);
					throw eee;
				}
				cnt27++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:39: ( SET_ENCLOSING_RULE_SCOPE_ATTR | ENCLOSING_RULE_SCOPE_ATTR | SET_TOKEN_SCOPE_ATTR | TOKEN_SCOPE_ATTR | SET_RULE_SCOPE_ATTR | RULE_SCOPE_ATTR | LABEL_REF | ISOLATED_TOKEN_REF | ISOLATED_LEXER_RULE_REF | SET_LOCAL_ATTR | LOCAL_ATTR | SET_DYNAMIC_SCOPE_ATTR | DYNAMIC_SCOPE_ATTR | ERROR_SCOPED_XY | DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR | DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR | ISOLATED_DYNAMIC_SCOPE | TEMPLATE_INSTANCE | INDIRECT_TEMPLATE_INSTANCE | SET_EXPR_ATTRIBUTE | SET_ATTRIBUTE | TEMPLATE_EXPR | ESC | ERROR_XY | ERROR_X | UNKNOWN_SYNTAX | TEXT )
		int alt28=27;
		int LA28_0 = input.LA(1);
		if ( (LA28_0=='$') ) {
			int LA28_1 = input.LA(2);
			if ( (synpred1_ActionTranslator()) ) {
				alt28=1;
			}
			else if ( (synpred2_ActionTranslator()) ) {
				alt28=2;
			}
			else if ( (synpred3_ActionTranslator()) ) {
				alt28=3;
			}
			else if ( (synpred4_ActionTranslator()) ) {
				alt28=4;
			}
			else if ( (synpred5_ActionTranslator()) ) {
				alt28=5;
			}
			else if ( (synpred6_ActionTranslator()) ) {
				alt28=6;
			}
			else if ( (synpred7_ActionTranslator()) ) {
				alt28=7;
			}
			else if ( (synpred8_ActionTranslator()) ) {
				alt28=8;
			}
			else if ( (synpred9_ActionTranslator()) ) {
				alt28=9;
			}
			else if ( (synpred10_ActionTranslator()) ) {
				alt28=10;
			}
			else if ( (synpred11_ActionTranslator()) ) {
				alt28=11;
			}
			else if ( (synpred12_ActionTranslator()) ) {
				alt28=12;
			}
			else if ( (synpred13_ActionTranslator()) ) {
				alt28=13;
			}
			else if ( (synpred14_ActionTranslator()) ) {
				alt28=14;
			}
			else if ( (synpred15_ActionTranslator()) ) {
				alt28=15;
			}
			else if ( (synpred16_ActionTranslator()) ) {
				alt28=16;
			}
			else if ( (synpred17_ActionTranslator()) ) {
				alt28=17;
			}
			else if ( (synpred24_ActionTranslator()) ) {
				alt28=24;
			}
			else if ( (synpred25_ActionTranslator()) ) {
				alt28=25;
			}
			else if ( (synpred26_ActionTranslator()) ) {
				alt28=26;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
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
		else if ( (LA28_0=='%') ) {
			int LA28_22 = input.LA(2);
			if ( (synpred18_ActionTranslator()) ) {
				alt28=18;
			}
			else if ( (synpred19_ActionTranslator()) ) {
				alt28=19;
			}
			else if ( (synpred20_ActionTranslator()) ) {
				alt28=20;
			}
			else if ( (synpred21_ActionTranslator()) ) {
				alt28=21;
			}
			else if ( (synpred22_ActionTranslator()) ) {
				alt28=22;
			}
			else if ( (synpred26_ActionTranslator()) ) {
				alt28=26;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 28, 22, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

		}
		else if ( (LA28_0=='\\') ) {
			alt28=23;
		}
		else if ( ((LA28_0 >= '\u0000' && LA28_0 <= '#')||(LA28_0 >= '&' && LA28_0 <= '[')||(LA28_0 >= ']' && LA28_0 <= '\uFFFF')) ) {
			alt28=27;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 28, 0, input);
			throw nvae;
		}

		switch (alt28) {
			case 1 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:41: SET_ENCLOSING_RULE_SCOPE_ATTR
				{
				mSET_ENCLOSING_RULE_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 2 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:71: ENCLOSING_RULE_SCOPE_ATTR
				{
				mENCLOSING_RULE_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 3 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:97: SET_TOKEN_SCOPE_ATTR
				{
				mSET_TOKEN_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 4 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:118: TOKEN_SCOPE_ATTR
				{
				mTOKEN_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 5 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:135: SET_RULE_SCOPE_ATTR
				{
				mSET_RULE_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 6 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:155: RULE_SCOPE_ATTR
				{
				mRULE_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 7 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:171: LABEL_REF
				{
				mLABEL_REF(); if (state.failed) return;

				}
				break;
			case 8 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:181: ISOLATED_TOKEN_REF
				{
				mISOLATED_TOKEN_REF(); if (state.failed) return;

				}
				break;
			case 9 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:200: ISOLATED_LEXER_RULE_REF
				{
				mISOLATED_LEXER_RULE_REF(); if (state.failed) return;

				}
				break;
			case 10 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:224: SET_LOCAL_ATTR
				{
				mSET_LOCAL_ATTR(); if (state.failed) return;

				}
				break;
			case 11 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:239: LOCAL_ATTR
				{
				mLOCAL_ATTR(); if (state.failed) return;

				}
				break;
			case 12 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:250: SET_DYNAMIC_SCOPE_ATTR
				{
				mSET_DYNAMIC_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 13 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:273: DYNAMIC_SCOPE_ATTR
				{
				mDYNAMIC_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 14 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:292: ERROR_SCOPED_XY
				{
				mERROR_SCOPED_XY(); if (state.failed) return;

				}
				break;
			case 15 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:308: DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR
				{
				mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 16 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:344: DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR
				{
				mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR(); if (state.failed) return;

				}
				break;
			case 17 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:380: ISOLATED_DYNAMIC_SCOPE
				{
				mISOLATED_DYNAMIC_SCOPE(); if (state.failed) return;

				}
				break;
			case 18 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:403: TEMPLATE_INSTANCE
				{
				mTEMPLATE_INSTANCE(); if (state.failed) return;

				}
				break;
			case 19 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:421: INDIRECT_TEMPLATE_INSTANCE
				{
				mINDIRECT_TEMPLATE_INSTANCE(); if (state.failed) return;

				}
				break;
			case 20 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:448: SET_EXPR_ATTRIBUTE
				{
				mSET_EXPR_ATTRIBUTE(); if (state.failed) return;

				}
				break;
			case 21 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:467: SET_ATTRIBUTE
				{
				mSET_ATTRIBUTE(); if (state.failed) return;

				}
				break;
			case 22 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:481: TEMPLATE_EXPR
				{
				mTEMPLATE_EXPR(); if (state.failed) return;

				}
				break;
			case 23 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:495: ESC
				{
				mESC(); if (state.failed) return;

				}
				break;
			case 24 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:499: ERROR_XY
				{
				mERROR_XY(); if (state.failed) return;

				}
				break;
			case 25 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:508: ERROR_X
				{
				mERROR_X(); if (state.failed) return;

				}
				break;
			case 26 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:516: UNKNOWN_SYNTAX
				{
				mUNKNOWN_SYNTAX(); if (state.failed) return;

				}
				break;
			case 27 :
				// org/antlr/grammar/v3/ActionTranslator.g:1:531: TEXT
				{
				mTEXT(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_ActionTranslator
	public final void synpred1_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:41: ( SET_ENCLOSING_RULE_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:41: SET_ENCLOSING_RULE_SCOPE_ATTR
		{
		mSET_ENCLOSING_RULE_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_ActionTranslator

	// $ANTLR start synpred2_ActionTranslator
	public final void synpred2_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:71: ( ENCLOSING_RULE_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:71: ENCLOSING_RULE_SCOPE_ATTR
		{
		mENCLOSING_RULE_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_ActionTranslator

	// $ANTLR start synpred3_ActionTranslator
	public final void synpred3_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:97: ( SET_TOKEN_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:97: SET_TOKEN_SCOPE_ATTR
		{
		mSET_TOKEN_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_ActionTranslator

	// $ANTLR start synpred4_ActionTranslator
	public final void synpred4_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:118: ( TOKEN_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:118: TOKEN_SCOPE_ATTR
		{
		mTOKEN_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_ActionTranslator

	// $ANTLR start synpred5_ActionTranslator
	public final void synpred5_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:135: ( SET_RULE_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:135: SET_RULE_SCOPE_ATTR
		{
		mSET_RULE_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_ActionTranslator

	// $ANTLR start synpred6_ActionTranslator
	public final void synpred6_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:155: ( RULE_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:155: RULE_SCOPE_ATTR
		{
		mRULE_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred6_ActionTranslator

	// $ANTLR start synpred7_ActionTranslator
	public final void synpred7_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:171: ( LABEL_REF )
		// org/antlr/grammar/v3/ActionTranslator.g:1:171: LABEL_REF
		{
		mLABEL_REF(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred7_ActionTranslator

	// $ANTLR start synpred8_ActionTranslator
	public final void synpred8_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:181: ( ISOLATED_TOKEN_REF )
		// org/antlr/grammar/v3/ActionTranslator.g:1:181: ISOLATED_TOKEN_REF
		{
		mISOLATED_TOKEN_REF(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_ActionTranslator

	// $ANTLR start synpred9_ActionTranslator
	public final void synpred9_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:200: ( ISOLATED_LEXER_RULE_REF )
		// org/antlr/grammar/v3/ActionTranslator.g:1:200: ISOLATED_LEXER_RULE_REF
		{
		mISOLATED_LEXER_RULE_REF(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred9_ActionTranslator

	// $ANTLR start synpred10_ActionTranslator
	public final void synpred10_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:224: ( SET_LOCAL_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:224: SET_LOCAL_ATTR
		{
		mSET_LOCAL_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred10_ActionTranslator

	// $ANTLR start synpred11_ActionTranslator
	public final void synpred11_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:239: ( LOCAL_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:239: LOCAL_ATTR
		{
		mLOCAL_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred11_ActionTranslator

	// $ANTLR start synpred12_ActionTranslator
	public final void synpred12_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:250: ( SET_DYNAMIC_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:250: SET_DYNAMIC_SCOPE_ATTR
		{
		mSET_DYNAMIC_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred12_ActionTranslator

	// $ANTLR start synpred13_ActionTranslator
	public final void synpred13_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:273: ( DYNAMIC_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:273: DYNAMIC_SCOPE_ATTR
		{
		mDYNAMIC_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred13_ActionTranslator

	// $ANTLR start synpred14_ActionTranslator
	public final void synpred14_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:292: ( ERROR_SCOPED_XY )
		// org/antlr/grammar/v3/ActionTranslator.g:1:292: ERROR_SCOPED_XY
		{
		mERROR_SCOPED_XY(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred14_ActionTranslator

	// $ANTLR start synpred15_ActionTranslator
	public final void synpred15_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:308: ( DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:308: DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR
		{
		mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred15_ActionTranslator

	// $ANTLR start synpred16_ActionTranslator
	public final void synpred16_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:344: ( DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:344: DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR
		{
		mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred16_ActionTranslator

	// $ANTLR start synpred17_ActionTranslator
	public final void synpred17_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:380: ( ISOLATED_DYNAMIC_SCOPE )
		// org/antlr/grammar/v3/ActionTranslator.g:1:380: ISOLATED_DYNAMIC_SCOPE
		{
		mISOLATED_DYNAMIC_SCOPE(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred17_ActionTranslator

	// $ANTLR start synpred18_ActionTranslator
	public final void synpred18_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:403: ( TEMPLATE_INSTANCE )
		// org/antlr/grammar/v3/ActionTranslator.g:1:403: TEMPLATE_INSTANCE
		{
		mTEMPLATE_INSTANCE(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred18_ActionTranslator

	// $ANTLR start synpred19_ActionTranslator
	public final void synpred19_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:421: ( INDIRECT_TEMPLATE_INSTANCE )
		// org/antlr/grammar/v3/ActionTranslator.g:1:421: INDIRECT_TEMPLATE_INSTANCE
		{
		mINDIRECT_TEMPLATE_INSTANCE(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred19_ActionTranslator

	// $ANTLR start synpred20_ActionTranslator
	public final void synpred20_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:448: ( SET_EXPR_ATTRIBUTE )
		// org/antlr/grammar/v3/ActionTranslator.g:1:448: SET_EXPR_ATTRIBUTE
		{
		mSET_EXPR_ATTRIBUTE(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred20_ActionTranslator

	// $ANTLR start synpred21_ActionTranslator
	public final void synpred21_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:467: ( SET_ATTRIBUTE )
		// org/antlr/grammar/v3/ActionTranslator.g:1:467: SET_ATTRIBUTE
		{
		mSET_ATTRIBUTE(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred21_ActionTranslator

	// $ANTLR start synpred22_ActionTranslator
	public final void synpred22_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:481: ( TEMPLATE_EXPR )
		// org/antlr/grammar/v3/ActionTranslator.g:1:481: TEMPLATE_EXPR
		{
		mTEMPLATE_EXPR(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred22_ActionTranslator

	// $ANTLR start synpred24_ActionTranslator
	public final void synpred24_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:499: ( ERROR_XY )
		// org/antlr/grammar/v3/ActionTranslator.g:1:499: ERROR_XY
		{
		mERROR_XY(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred24_ActionTranslator

	// $ANTLR start synpred25_ActionTranslator
	public final void synpred25_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:508: ( ERROR_X )
		// org/antlr/grammar/v3/ActionTranslator.g:1:508: ERROR_X
		{
		mERROR_X(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred25_ActionTranslator

	// $ANTLR start synpred26_ActionTranslator
	public final void synpred26_ActionTranslator_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionTranslator.g:1:516: ( UNKNOWN_SYNTAX )
		// org/antlr/grammar/v3/ActionTranslator.g:1:516: UNKNOWN_SYNTAX
		{
		mUNKNOWN_SYNTAX(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred26_ActionTranslator

	public final boolean synpred7_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred26_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred26_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred18_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred18_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred13_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred13_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred17_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred17_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred6_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred21_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred21_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred25_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred25_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred19_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred19_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred12_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred12_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred16_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred16_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred11_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred11_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred9_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred24_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred24_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred20_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred20_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred15_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred15_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred10_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred10_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred14_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred14_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred22_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred22_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_ActionTranslator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_ActionTranslator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



}
