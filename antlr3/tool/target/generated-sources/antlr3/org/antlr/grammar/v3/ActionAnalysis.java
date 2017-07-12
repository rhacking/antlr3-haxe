// $ANTLR 3.5 org/antlr/grammar/v3/ActionAnalysis.g 2017-06-11 18:42:19

package org.antlr.grammar.v3;
import org.antlr.runtime.*;
import org.antlr.tool.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/** We need to set Rule.referencedPredefinedRuleAttributes before
 *  code generation.  This filter looks at an action in context of
 *  its rule and outer alternative number and figures out which
 *  rules have predefined prefs referenced.  I need this so I can
 *  remove unusued labels.  This also tracks, for labeled rules,
 *  which are referenced by actions.
 */
@SuppressWarnings("all")
public class ActionAnalysis extends Lexer {
	public static final int EOF=-1;
	public static final int ID=4;
	public static final int X=5;
	public static final int X_Y=6;
	public static final int Y=7;

	Rule enclosingRule;
	Grammar grammar;
	Token actionToken;
	int outerAltNum = 0;

		public ActionAnalysis(Grammar grammar, String ruleName, GrammarAST actionAST)
		{
			this(new ANTLRStringStream(actionAST.token.getText()));
			this.grammar = grammar;
		    this.enclosingRule = grammar.getLocallyDefinedRule(ruleName);
		    this.actionToken = actionAST.token;
		    this.outerAltNum = actionAST.outerAltNum;
		}

	public void analyze() {
		// System.out.println("###\naction="+actionToken);
		Token t;
		do {
			t = nextToken();
		} while ( t.getType()!= Token.EOF );
	}


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ActionAnalysis() {} 
	public ActionAnalysis(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ActionAnalysis(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "org/antlr/grammar/v3/ActionAnalysis.g"; }

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
	// $ANTLR start "X_Y"
	public final void mX_Y() throws RecognitionException {
		try {
			int _type = X_Y;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;
			CommonToken y=null;

			// org/antlr/grammar/v3/ActionAnalysis.g:75:5: ( '$' x= ID '.' y= ID {...}?)
			// org/antlr/grammar/v3/ActionAnalysis.g:75:7: '$' x= ID '.' y= ID {...}?
			{
			match('$'); if (state.failed) return;
			int xStart55 = getCharIndex();
			int xStartLine55 = getLine();
			int xStartCharPos55 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart55, getCharIndex()-1);
			x.setLine(xStartLine55);
			x.setCharPositionInLine(xStartCharPos55);

			match('.'); if (state.failed) return;
			int yStart61 = getCharIndex();
			int yStartLine61 = getLine();
			int yStartCharPos61 = getCharPositionInLine();
			mID(); if (state.failed) return;
			y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart61, getCharIndex()-1);
			y.setLine(yStartLine61);
			y.setCharPositionInLine(yStartCharPos61);

			if ( !((enclosingRule!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "X_Y", "enclosingRule!=null");
			}
			if ( state.backtracking==1 ) {
					AttributeScope scope = null;
					String refdRuleName = null;
					if ( (x!=null?x.getText():null).equals(enclosingRule.name) ) {
						// ref to enclosing rule.
						refdRuleName = (x!=null?x.getText():null);
						scope = enclosingRule.getLocalAttributeScope((y!=null?y.getText():null));
					}
					else if ( enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null ) {
						// ref to rule label
						Grammar.LabelElementPair pair = enclosingRule.getRuleLabel((x!=null?x.getText():null));
						pair.actionReferencesLabel = true;
						refdRuleName = pair.referencedRuleName;
						Rule refdRule = grammar.getRule(refdRuleName);
						if ( refdRule!=null ) {
							scope = refdRule.getLocalAttributeScope((y!=null?y.getText():null));
						}
					}
					else if ( enclosingRule.getRuleRefsInAlt(x.getText(), outerAltNum)!=null ) {
						// ref to rule referenced in this alt
						refdRuleName = (x!=null?x.getText():null);
						Rule refdRule = grammar.getRule(refdRuleName);
						if ( refdRule!=null ) {
							scope = refdRule.getLocalAttributeScope((y!=null?y.getText():null));
						}
					}
					if ( scope!=null &&
						 (scope.isPredefinedRuleScope||scope.isPredefinedLexerRuleScope) )
					{
						grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
						//System.out.println("referenceRuleLabelPredefinedAttribute for "+refdRuleName);
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
	// $ANTLR end "X_Y"

	// $ANTLR start "X"
	public final void mX() throws RecognitionException {
		try {
			int _type = X;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken x=null;

			// org/antlr/grammar/v3/ActionAnalysis.g:112:3: ( '$' x= ID {...}?)
			// org/antlr/grammar/v3/ActionAnalysis.g:112:5: '$' x= ID {...}?
			{
			match('$'); if (state.failed) return;
			int xStart83 = getCharIndex();
			int xStartLine83 = getLine();
			int xStartCharPos83 = getCharPositionInLine();
			mID(); if (state.failed) return;
			x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart83, getCharIndex()-1);
			x.setLine(xStartLine83);
			x.setCharPositionInLine(xStartCharPos83);

			if ( !((enclosingRule!=null && enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "X", "enclosingRule!=null && enclosingRule.getRuleLabel($x.text)!=null");
			}
			if ( state.backtracking==1 ) {
						Grammar.LabelElementPair pair = enclosingRule.getRuleLabel((x!=null?x.getText():null));
						pair.actionReferencesLabel = true;
					}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "X"

	// $ANTLR start "Y"
	public final void mY() throws RecognitionException {
		try {
			int _type = Y;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken ID1=null;

			// org/antlr/grammar/v3/ActionAnalysis.g:120:3: ( '$' ID {...}?)
			// org/antlr/grammar/v3/ActionAnalysis.g:120:5: '$' ID {...}?
			{
			match('$'); if (state.failed) return;
			int ID1Start104 = getCharIndex();
			int ID1StartLine104 = getLine();
			int ID1StartCharPos104 = getCharPositionInLine();
			mID(); if (state.failed) return;
			ID1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID1Start104, getCharIndex()-1);
			ID1.setLine(ID1StartLine104);
			ID1.setCharPositionInLine(ID1StartCharPos104);

			if ( !((enclosingRule!=null && enclosingRule.getLocalAttributeScope((ID1!=null?ID1.getText():null))!=null)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "Y", "enclosingRule!=null && enclosingRule.getLocalAttributeScope($ID.text)!=null");
			}
			if ( state.backtracking==1 ) {
						AttributeScope scope = enclosingRule.getLocalAttributeScope((ID1!=null?ID1.getText():null));
						if ( scope!=null &&
							 (scope.isPredefinedRuleScope||scope.isPredefinedLexerRuleScope) )
						{
							grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
							//System.out.println("referenceRuleLabelPredefinedAttribute for "+(ID1!=null?ID1.getText():null));
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
	// $ANTLR end "Y"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			// org/antlr/grammar/v3/ActionAnalysis.g:133:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// org/antlr/grammar/v3/ActionAnalysis.g:133:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
			// org/antlr/grammar/v3/ActionAnalysis.g:133:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// org/antlr/grammar/v3/ActionAnalysis.g:
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
					break loop1;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	@Override
	public void mTokens() throws RecognitionException {
		// org/antlr/grammar/v3/ActionAnalysis.g:1:39: ( X_Y | X | Y )
		int alt2=3;
		int LA2_0 = input.LA(1);
		if ( (LA2_0=='$') ) {
			int LA2_1 = input.LA(2);
			if ( (synpred1_ActionAnalysis()) ) {
				alt2=1;
			}
			else if ( (synpred2_ActionAnalysis()) ) {
				alt2=2;
			}
			else if ( (true) ) {
				alt2=3;
			}

		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 2, 0, input);
			throw nvae;
		}

		switch (alt2) {
			case 1 :
				// org/antlr/grammar/v3/ActionAnalysis.g:1:41: X_Y
				{
				mX_Y(); if (state.failed) return;

				}
				break;
			case 2 :
				// org/antlr/grammar/v3/ActionAnalysis.g:1:45: X
				{
				mX(); if (state.failed) return;

				}
				break;
			case 3 :
				// org/antlr/grammar/v3/ActionAnalysis.g:1:47: Y
				{
				mY(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_ActionAnalysis
	public final void synpred1_ActionAnalysis_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionAnalysis.g:1:41: ( X_Y )
		// org/antlr/grammar/v3/ActionAnalysis.g:1:41: X_Y
		{
		mX_Y(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_ActionAnalysis

	// $ANTLR start synpred2_ActionAnalysis
	public final void synpred2_ActionAnalysis_fragment() throws RecognitionException {
		// org/antlr/grammar/v3/ActionAnalysis.g:1:45: ( X )
		// org/antlr/grammar/v3/ActionAnalysis.g:1:45: X
		{
		mX(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_ActionAnalysis

	public final boolean synpred2_ActionAnalysis() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_ActionAnalysis_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_ActionAnalysis() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_ActionAnalysis_fragment(); // can never throw exception
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
