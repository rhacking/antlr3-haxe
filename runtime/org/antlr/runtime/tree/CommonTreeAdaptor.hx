package org.antlr.runtime.tree;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenConstants;

/** A TreeAdaptor that works with any Tree implementation.  It provides
	 *  really just factory methods; all the work is done by BaseTreeAdaptor.
	 *  If you would like to have different tokens created than ClassicToken
	 *  objects, you need to override this and then set the parser tree adaptor to
	 *  use your subclass.
	 *
	 *  To get your parser to build nodes of a different type, override
 *  create(Token), errorNode(), and to be safe, YourTreeClass.dupNode().
 *  dupNode is called to duplicate nodes during rewrite operations.
	 */
class CommonTreeAdaptor extends BaseTreeAdaptor
{
    /** Duplicate a node.  This is part of the factory;
		 *	override if you want another kind of node to be built.
		 *
		 *  I could use reflection to prevent having to override this
		 *  but reflection is slow.
		 */
    override public function dupNode(t : Dynamic) : Dynamic
    {
        if (t == null)
        {
            return null;
        }
        return (cast((t), Tree)).dupNode();
    }
    
    override public function createWithPayload(payload : Token) : Dynamic
    {
        return CommonTree.createFromToken(payload);
    }
    
    /** Tell me how to create a token for use with imaginary token nodes.
		 *  For example, there is probably no input symbol associated with imaginary
		 *  token DECL, but you need to create it as a payload or whatever for
		 *  the DECL node as in ^(DECL type ID).
		 *
		 *  If you care what the token payload objects' type is, you should
		 *  override this method and any other createToken variant.
		 */
    override public function createTokenFromType(tokenType : Int, text : String) : Token
    {
        return new CommonToken(tokenType, text);
    }
    
    /** Tell me how to create a token for use with imaginary token nodes.
		 *  For example, there is probably no input symbol associated with imaginary
		 *  token DECL, but you need to create it as a payload or whatever for
		 *  the DECL node as in ^(DECL type ID).
		 *
		 *  This is a variant of createToken where the new token is derived from
		 *  an actual real input token.  Typically this is for converting '{'
		 *  tokens to BLOCK etc...  You'll see
		 *
		 *    r : lc='{' ID+ '}' -> ^(BLOCK[$lc] ID+) ;
		 *
		 *  If you care what the token payload objects' type is, you should
		 *  override this method and any other createToken variant.
		 */
    override public function createToken(fromToken : Token) : Token
    {
        return CommonToken.cloneToken(fromToken);
    }
    
    /** Track start/stop token for subtree root created for a rule.
		 *  Only works with Tree nodes.  For rules that match nothing,
		 *  seems like this will yield start=i and stop=i-1 in a nil node.
		 *  Might be useful info so I'll not force to be i..i.
		 */
    override public function setTokenBoundaries(t : Dynamic, startToken : Token, stopToken : Token) : Void
    {
        if (t == null)
        {
            return;
        }
        var start : Int = 0;
        var stop : Int = 0;
        if (startToken != null)
        {
            start = startToken.tokenIndex;
        }
        if (stopToken != null)
        {
            stop = stopToken.tokenIndex;
        }
        cast((t), Tree).tokenStartIndex = start;
        cast((t), Tree).tokenStopIndex = stop;
    }
    
    override public function getTokenStartIndex(t : Dynamic) : Int
    {
        if (t == null)
        {
            return -1;
        }
        return cast((t), Tree).tokenStartIndex;
    }
    
    override public function getTokenStopIndex(t : Dynamic) : Int
    {
        if (t == null)
        {
            return -1;
        }
        return cast((t), Tree).tokenStopIndex;
    }
    
    override public function getText(t : Dynamic) : String
    {
        if (t == null)
        {
            return null;
        }
        return cast((t), Tree).text;
    }
    
    override public function getType(t : Dynamic) : Int
    {
        if (t == null)
        {
            return TokenConstants.INVALID_TOKEN_TYPE;
        }
        return cast((t), Tree).type;
    }
    
    /** What is the Token associated with this node?  If
		 *  you are not using CommonTree, then you must
		 *  override this in your own adaptor.
		 */
    override public function getToken(t : Dynamic) : Token
    {
        if (Std.is(t, CommonTree))
        {
            return cast((t), CommonTree).token;
        }
        return null;
    }
    
    override public function getChild(t : Dynamic, i : Int) : Dynamic
    {
        if (t == null)
        {
            return null;
        }
        return cast((t), Tree).getChild(i);
    }
    
    override public function getChildCount(t : Dynamic) : Int
    {
        if (t == null)
        {
            return 0;
        }
        return cast((t), Tree).childCount;
    }
    
    override public function getParent(t : Dynamic) : Dynamic
    {
        if (t == null)
        {
            return null;
        }
        return cast((t), Tree).parent;
    }
    
    override public function setParent(t : Dynamic, parent : Dynamic) : Void
    {
        if (t != null)
        {
            cast((t), Tree).parent = cast((parent), Tree);
        }
    }
    
    override public function getChildIndex(t : Dynamic) : Int
    {
        if (t == null)
        {
            return 0;
        }
        return cast((t), Tree).childIndex;
    }
    
    override public function setChildIndex(t : Dynamic, index : Int) : Void
    {
        if (t != null)
        {
            cast((t), Tree).childIndex = index;
        }
    }
    
    override public function replaceChildren(parent : Dynamic, startChildIndex : Int, stopChildIndex : Int, t : Dynamic) : Void
    {
        if (parent != null)
        {
            cast((parent), Tree).replaceChildren(startChildIndex, stopChildIndex, t);
        }
    }

    public function new()
    {
        super();
    }
}

