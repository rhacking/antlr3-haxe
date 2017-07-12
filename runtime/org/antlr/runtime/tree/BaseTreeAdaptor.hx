package org.antlr.runtime.tree;

import org.antlr.runtime.*;

/** A TreeAdaptor that works with any Tree implementation. */
class BaseTreeAdaptor implements TreeAdaptor
{
    /** System.identityHashCode() is not always unique; we have to
		 track ourselves.  That's ok, it's only for debugging, though it's
		 expensive: we have to create a hashtable with all tree nodes in it.
		 */
    private var treeToUniqueIDMap : Map<Any, Int>;
    private var uniqueNodeID : Int = 1;
    
    public function nil() : Dynamic
    {
        return createWithPayload(null);
    }
    
    /** create tree node that holds the start and stop tokens associated
    	 *  with an error.
    	 *
    	 *  If you specify your own kind of tree nodes, you will likely have to
    	 *  override this method. CommonTree returns Token.INVALID_TOKEN_TYPE
    	 *  if no token payload but you might have to set token type for diff
    	 *  node type.
    	 * 
     *  You don't have to subclass CommonErrorNode; you will likely need to
     *  subclass your own tree node class to avoid class cast exception.
    	 */
    public function errorNode(input : TokenStream, start : Token, stop : Token,
            e : RecognitionException) : Dynamic{
        var t : CommonErrorNode = new CommonErrorNode(input, start, stop, e);
        //System.out.println("returning error node '"+t+"' @index="+input.index());
        return t;
    }
    
    public function isNil(tree : Dynamic) : Bool
    {
        return cast((tree), Tree).isNil;
    }
    
    public function dupTree(tree : Dynamic) : Dynamic
    {
        return dupTreeWithParent(tree, null);
    }
    
    /** This is generic in the sense that it will work with any kind of
		 *  tree (not just Tree interface).  It invokes the adaptor routines
		 *  not the tree node routines to do the construction.  
		 */
    public function dupTreeWithParent(t : Dynamic, parent : Dynamic) : Dynamic
    {
        if (t == null)
        {
            return null;
        }
        var newTree : Dynamic = dupNode(t);
        // ensure new subtree root has parent/child index set
        setChildIndex(newTree, getChildIndex(t));  // same index in new tree  
        setParent(newTree, parent);
        var n : Int = getChildCount(t);
        for (i in 0...n)
        {
            var child : Dynamic = getChild(t, i);
            var newSubTree : Dynamic = dupTreeWithParent(child, t);
            addChild(newTree, newSubTree);
        }
        return newTree;
    }
    
    /** Add a child to the tree t.  If child is a flat tree (a list), make all
		 *  in list children of t.  Warning: if t has no children, but child does
		 *  and child isNil then you can decide it is ok to move children to t via
		 *  t.children = child.children; i.e., without copying the array.  Just
		 *  make sure that this is consistent with have the user will build
		 *  ASTs.
		 */
    public function addChild(t : Dynamic, child : Dynamic) : Void
    {
        if (t != null && child != null)
        {
            cast((t), Tree).addChild(cast((child), Tree));
        }
    }
    
    /** If oldRoot is a nil root, just copy or move the children to newRoot.
		 *  If not a nil root, make oldRoot a child of newRoot.
		 *
		 *    old=^(nil a b c), new=r yields ^(r a b c)
		 *    old=^(a b c), new=r yields ^(r ^(a b c))
		 *
		 *  If newRoot is a nil-rooted single child tree, use the single
		 *  child as the new root node.
		 *
		 *    old=^(nil a b c), new=^(nil r) yields ^(r a b c)
		 *    old=^(a b c), new=^(nil r) yields ^(r ^(a b c))
		 *
		 *  If oldRoot was null, it's ok, just return newRoot (even if isNil).
		 *
		 *    old=null, new=r yields r
		 *    old=null, new=^(nil r) yields ^(nil r)
		 *
		 *  Return newRoot.  Throw an exception if newRoot is not a
		 *  simple node or nil root with a single child node--it must be a root
		 *  node.  If newRoot is ^(nil x) return x as newRoot.
		 *
		 *  Be advised that it's ok for newRoot to point at oldRoot's
		 *  children; i.e., you don't have to copy the list.  We are
		 *  constructing these nodes so we should have this control for
		 *  efficiency.
		 */
    public function becomeRoot(newRoot : Dynamic, oldRoot : Dynamic) : Dynamic
    {
        // If new Root is token, then create a Tree.
        if (Std.is(newRoot, Token))
        {
            newRoot = createWithPayload(cast((newRoot), Token));
        }
        
        var newRootTree : Tree = cast((newRoot), Tree);
        var oldRootTree : Tree = cast((oldRoot), Tree);
        if (oldRoot == null)
        {
            return newRoot;
        }
        // handle ^(nil real-node)
        if (newRootTree.isNil)
        {
            var nc : Int = newRootTree.childCount;
            if (nc == 1)
            {
                newRootTree = cast((newRootTree.getChild(0)), Tree);
            }
            else
            {
                if (nc > 1)
                {
                    // TODO: make tree run time exceptions hierarchy
                    throw ("more than one node as root (TODO: make exception hierarchy)");
                }
            }
        }
        // add oldRoot to newRoot; addChild takes care of case where oldRoot
        // is a flat list (i.e., nil-rooted tree).  All children of oldRoot
        // are added to newRoot.
        newRootTree.addChild(oldRootTree);
        return newRootTree;
    }
    
    /** Transform ^(nil x) to x and nil to null */
    public function rulePostProcessing(root : Dynamic) : Dynamic
    {
        var r : Tree = cast((root), Tree);
        if (r != null && r.isNil)
        {
            if (r.childCount == 0)
            {
                r = null;
            }
            else
            {
                if (r.childCount == 1)
                {
                    r = cast((r.getChild(0)), Tree);
                    // whoever invokes rule will set parent and child index
                    r.parent = null;
                    r.childIndex = -1;
                }
            }
        }
        return r;
    }
    
    public function createFromToken(tokenType : Int, fromToken : Token, text : String = null) : Dynamic
    {
        fromToken = createToken(fromToken);
        fromToken.type = tokenType;
        if (text != null)
        {
            fromToken.text = text;
        }
        return createWithPayload(fromToken);
    }
    
    public function createFromType(tokenType : Int, text : String) : Dynamic
    {
        var fromToken : Token = createTokenFromType(tokenType, text);
        return createWithPayload(fromToken);
    }
    
    public function getType(t : Dynamic) : Int
    {
        return cast((t), Tree).type;
    }
    
    public function setType(t : Dynamic, type : Int) : Void
    {
        throw ("don't know enough about Tree node");
    }
    
    public function getText(t : Dynamic) : String
    {
        return cast((t), Tree).text;
    }
    
    public function setText(t : Dynamic, text : String) : Void
    {
        throw ("don't know enough about Tree node");
    }
    
    public function getChild(t : Dynamic, i : Int) : Dynamic
    {
        return cast((t), Tree).getChild(i);
    }
    
    public function setChild(t : Dynamic, i : Int, child : Dynamic) : Void
    {
        cast((t), Tree).setChild(i, cast((child), Tree));
    }
    
    public function deleteChild(t : Dynamic, i : Int) : Dynamic
    {
        return cast((t), Tree).deleteChild(i);
    }
    
    public function getChildCount(t : Dynamic) : Int
    {
        return cast((t), Tree).childCount;
    }
    
    public function getUniqueID(node : Dynamic) : Int
    {
        if (treeToUniqueIDMap == null)
        {
            //treeToUniqueIDMap = new Map<Any, Int>();
        }
        if (treeToUniqueIDMap.exists(node))
        {
            return treeToUniqueIDMap[node];
        }
        
        var ID : Int = uniqueNodeID;
        treeToUniqueIDMap[node] = ID;
        uniqueNodeID++;
        return ID;
    }
    
    /** Tell me how to create a token for use with imaginary token nodes.
		 *  For example, there is probably no input symbol associated with imaginary
		 *  token DECL, but you need to create it as a payload or whatever for
		 *  the DECL node as in ^(DECL type ID).
		 *
		 *  If you care what the token payload objects' type is, you should
		 *  override this method and any other createToken variant.
		 */
    public function createTokenFromType(tokenType : Int, text : String) : Token
    {
        throw ("Not implemented - abstract function");
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
		 * 
		 */
    public function createToken(fromToken : Token) : Token
    {
        throw ("Not implemented - abstract function");
    }
    
    public function createWithPayload(payload : Token) : Dynamic
    {
        throw ("Not implemented - abstract function");
    }
    
    public function dupNode(t : Dynamic) : Dynamic
    {
        throw ("Not implemented - abstract function");
    }
    
    public function getToken(t : Dynamic) : Token
    {
        throw ("Not implemented - abstract function");
    }
    
    public function setTokenBoundaries(t : Dynamic, startToken : Token, stopToken : Token) : Void
    {
        throw ("Not implemented - abstract function");
    }
    
    public function getTokenStartIndex(t : Dynamic) : Int
    {
        throw ("Not implemented - abstract function");
    }
    
    public function getTokenStopIndex(t : Dynamic) : Int
    {
        throw ("Not implemented - abstract function");
    }
    
    public function getParent(t : Dynamic) : Dynamic
    {
        throw ("Not implemented - abstract function");
    }
    
    public function setParent(t : Dynamic, parent : Dynamic) : Void
    {
        throw ("Not implemented - abstract function");
    }
    
    public function getChildIndex(t : Dynamic) : Int
    {
        throw ("Not implemented - abstract function");
    }
    
    public function setChildIndex(t : Dynamic, index : Int) : Void
    {
        throw ("Not implemented - abstract function");
    }
    
    public function replaceChildren(parent : Dynamic, startChildIndex : Int, stopChildIndex : Int, t : Dynamic) : Void
    {
        throw ("Not implemented - abstract function");
    }
    
    public function create(args : Array<Dynamic> = null) : Dynamic
    {
        if (args.length == 1 && Std.is(args[0], Token))
        {
            return createWithPayload(args[0]);
        }
        else
        {
            if (args.length == 2 &&
                Std.is(args[0], Int) &&
                Std.is(args[1], Token))
            {
                return createFromToken(args[0], args[1]);
            }
            else
            {
                if (args.length == 3 &&
                    Std.is(args[0], Int) &&
                    Std.is(args[1], Token) &&
                    Std.is(args[2], String))
                {
                    return createFromToken(args[0], args[1], args[2]);
                }
                else
                {
                    if (args.length == 2 &&
                        Std.is(args[0], Int) &&
                        Std.is(args[1], String))
                    {
                        return createFromType(args[0], args[1]);
                    }
                }
            }
        }
        throw ("No methods signature for arguments : " + Std.string("TODO"));
    }

    public function new()
    {
    }
}


