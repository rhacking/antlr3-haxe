package org.antlr.runtime.tree;


/** What does a tree look like?  ANTLR has a number of support classes
	 *  such as CommonTreeNodeStream that work on these kinds of trees.  You
	 *  don't have to make your trees implement this interface, but if you do,
	 *  you'll be able to use more support code.
	 *
	 *  NOTE: When constructing trees, ANTLR can build any kind of tree; it can
	 *  even use Token objects as trees if you add a child list to your tokens.
	 *
	 *  This is a tree node without any payload; just navigation and factory stuff.
	 */
interface Tree
{
    
    
    var childCount(get, never) : Int;    
    
    
    
    // Tree tracks parent and child index now > 3.0
    
    var parent(get, set) : Tree;    
    
    /** Return a list of all ancestors of this node.  The first node of
     *  list is the root and the last is the parent of this node.
     */
    var ancestors(get, never) : Array<Dynamic>;    
    
    
    
    
    /** This node is what child index? 0..n-1 */
    var childIndex(get, set) : Int;    
    
    /** Indicates the node is a nil node but may still have children, meaning
		 *  the tree is a flat list.
		 */
    var isNil(get, never) : Bool;    
    
    
    
    /**  What is the smallest token index (indexing from 0) for this node
		 *   and its children?
		 */
    var tokenStartIndex(get, set) : Int;    
    
    
    
    /**  What is the largest token index (indexing from 0) for this node
		 *   and its children?
		 */
    var tokenStopIndex(get, set) : Int;    
    
    /** Return a token type; needed for tree parsing */
    var type(get, never) : Int;    
    
    var text(get, never) : String;    
    
    /** In case we don't have a token payload, what is the line for errors? */
    var line(get, never) : Int;    
    
    var charPositionInLine(get, never) : Int;

    
    function getChild(i : Int) : Tree
    ;
    
    /** Is there is a node above with token type ttype? */
    function hasAncestor(ttype : Int) : Bool
    ;
    
    /** Walk upwards and get first ancestor with this token type. */
    function getAncestor(ttype : Int) : Tree
    ;
    
    /** Set the parent and child index values for all children */
    function freshenParentAndChildIndexes() : Void
    ;
    
    /** Add t as a child to this node.  If t is null, do nothing.  If t
		 *  is nil, add all children of t to this' children.
		 */
    function addChild(t : Tree) : Void
    ;
    
    /** Set ith child (0..n-1) to t; t must be non-null and non-nil node */
    function setChild(i : Int, t : Tree) : Void
    ;
    
    function deleteChild(i : Int) : Dynamic
    ;
    
    /** Delete children from start to stop and replace with t even if t is
		 *  a list (nil-root tree).  num of children can increase or decrease.
		 *  For huge child lists, inserting children can force walking rest of
		 *  children to set their childindex; could be slow.
		 */
    function replaceChildren(startChildIndex : Int, stopChildIndex : Int, t : Dynamic) : Void
    ;
    
    function dupNode() : Tree
    ;
    
    function toStringTree() : String
    ;
}

