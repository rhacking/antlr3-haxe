/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in the
documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.runtime.tree;

/** A generic tree implementation with no payload.  You must subclass to
	 *  actually have any user data.  ANTLR v3 uses a list of children approach
	 *  instead of the child-sibling approach in v2.  A flat tree (a list) is
	 *  an empty node whose children represent the list.  An empty, but
	 *  non-null node is called "nil".
	 */
class BaseTree implements Tree
{
    public var children(get, never) : Array<Dynamic>;
    public var childCount(get, never) : Int;
    public var isNil(get, never) : Bool;
    public var childIndex(get, set) : Int;
    public var parent(get, set) : Tree;
    public var ancestors(get, never) : Array<Dynamic>;
    public var line(get, never) : Int;
    public var charPositionInLine(get, never) : Int;
    public var type(get, never) : Int;
    public var text(get, never) : String;
    public var tokenStartIndex(get, set) : Int;
    public var tokenStopIndex(get, set) : Int;

    private var _children : Array<Dynamic>;
    
    /** Create a new node from an existing node does nothing for BaseTree
		 *  as there are no fields other than the children list, which cannot
		 *  be copied as the children are not considered part of this node. 
		 */
    public function new(node : Tree = null)
    {
    }
    
    public function getChild(i : Int) : Tree
    {
        if (_children == null || i >= _children.length)
        {
            return null;
        }
        return cast((_children[i]), BaseTree);
    }
    
    /** Get the children internal List; note that if you directly mess with
		 *  the list, do so at your own risk.
		 */
    private function get_children() : Array<Dynamic>
    {
        return _children;
    }
    
    public function getFirstChildWithType(type : Int) : Tree
    {
        var i : Int = 0;
        while (_children != null && i < _children.length)
        {
            var t : Tree = cast((_children[i]), Tree);
            if (t.type == type)
            {
                return t;
            }
            i++;
        }
        return null;
    }
    
    private function get_childCount() : Int
    {
        if (_children == null)
        {
            return 0;
        }
        return _children.length;
    }
    
    /** Add t as child of this node.
		 *
		 *  Warning: if t has no children, but child does
		 *  and child isNil then this routine moves children to t via
		 *  t.children = child.children; i.e., without copying the array.
		 */
    public function addChild(t : Tree) : Void
    {
        if (t == null)
        {
            return;
        }
        var childTree : BaseTree = cast((t), BaseTree);
        if (childTree.isNil)
        {
            // t is an empty node possibly with children
            if (this._children != null && this._children == childTree._children)
            {
                throw ("attempt to add child list to itself");
            }
            // just add all of childTree's children to this
            if (childTree._children != null)
            {
                if (this._children != null)
                {
                    // must copy, this has children already
                    var n : Int = childTree._children.length;
                    for (i in 0...n)
                    {
                        var c : Tree = cast((childTree._children[i]), Tree);
                        this.children.push(c);
                        // handle double-link stuff for each child of nil root
                        c.parent = this;
                        c.childIndex = children.length - 1;
                    }
                }
                else
                {
                    // no children for this but t has children; just set pointer
                    // call general freshener routine
                    this._children = childTree.children;
                    this.freshenParentAndChildIndexes();
                }
            }
        }
        else
        {
            // child is not nil (don't care about children)
            if (_children == null)
            {
                _children = new Array<Dynamic>();
            }
            _children.push(t);
            childTree.parent = this;
            childTree.childIndex = children.length - 1;
        }
    }
    
    /** Add all elements of kids list as children of this node */
    public function addChildren(kids : Array<Dynamic>) : Void
    {
        for (i in 0...kids.length)
        {
            var t : Tree = cast((kids[i]), Tree);
            addChild(t);
        }
    }
    
    public function setChild(i : Int, t : Tree) : Void
    {
        if (t == null)
        {
            return;
        }
        if (t.isNil)
        {
            throw ("Can't set single child to a list");
        }
        if (_children == null)
        {
            _children = new Array<Dynamic>();
        }
        _children[i] = t;
        t.parent = this;
        t.childIndex = i;
    }
    
    public function deleteChild(i : Int) : Dynamic
    {
        if (_children == null)
        {
            return null;
        }
        var killed : BaseTree = cast((children.remove(i)), BaseTree);
        // walk rest and decrement their child indexes
        this.freshenParentAndChildIndexesFrom(i);
        return killed;
    }
    
    /** Delete children from start to stop and replace with t even if t is
		 *  a list (nil-root tree).  num of children can increase or decrease.
		 *  For huge child lists, inserting children can force walking rest of
		 *  children to set their childindex; could be slow.
		 */
    public function replaceChildren(startChildIndex : Int, stopChildIndex : Int, t : Dynamic) : Void
    {
        if (children == null)
        {
            throw ("indexes invalid; no children in list");
        }
        var replacingHowMany : Int = as3hx.Compat.parseInt(stopChildIndex - startChildIndex + 1);
        var replacingWithHowMany : Int;
        var newTree : BaseTree = cast((t), BaseTree);
        var newChildren : Array<Dynamic> = null;
        // normalize to a list of children to add: newChildren
        if (newTree.isNil)
        {
            newChildren = newTree.children;
        }
        else
        {
            newChildren = new Array<Dynamic>();
            newChildren.push(newTree);
        }
        replacingWithHowMany = newChildren.length;
        var numNewChildren : Int = newChildren.length;
        var delta : Int = as3hx.Compat.parseInt(replacingHowMany - replacingWithHowMany);
        // if same number of nodes, do direct replace
        if (delta == 0)
        {
            var j : Int = 0;  // index into new children  
            for (i in startChildIndex...stopChildIndex + 1)
            {
                var child : BaseTree = cast((newChildren[j]), BaseTree);
                children[i] = child;
                child.parent = this;
                child.childIndex = i;
                j++;
            }
        }
        else
        {
            if (delta > 0)
            {
                // fewer new nodes than there were
                // set children and then delete extra
                for (j in 0...numNewChildren)
                {
                    children[startChildIndex + j] = newChildren[j];
                }
                var indexToDelete : Int = as3hx.Compat.parseInt(startChildIndex + numNewChildren);
                for (c in indexToDelete...stopChildIndex + 1)
                {
                    // delete same index, shifting everybody down each time
                    var killed : BaseTree = cast((children.remove(indexToDelete)), BaseTree);
                }
                freshenParentAndChildIndexesFrom(startChildIndex);
            }
            else
            {
                // more new nodes than were there before
                // fill in as many children as we can (replacingHowMany) w/o moving data
                for (j in 0...replacingHowMany)
                {
                    children[startChildIndex + j] = newChildren[j];
                }
                var numToInsert : Int = as3hx.Compat.parseInt(replacingWithHowMany - replacingHowMany);
                for (j in replacingHowMany...replacingWithHowMany)
                {
                    as3hx.Compat.arraySplice(children, startChildIndex + j, 0, [newChildren[j]]);
                }
                freshenParentAndChildIndexesFrom(startChildIndex);
            }
        }
    }
    
    private function get_isNil() : Bool
    {
        return false;
    }
    
    /** Set the parent and child index values for all child of t */
    public function freshenParentAndChildIndexes() : Void
    {
        freshenParentAndChildIndexesFrom(0);
    }
    
    public function freshenParentAndChildIndexesFrom(offset : Int) : Void
    {
        var n : Int = childCount;
        for (c in offset...n)
        {
            var child : Tree = cast((getChild(c)), Tree);
            child.childIndex = c;
            child.parent = this;
        }
    }
    
    public function sanityCheckParentAndChildIndexes() : Void
    {
        sanityCheckParentAndChildIndexesFrom(null, -1);
    }
    
    public function sanityCheckParentAndChildIndexesFrom(parent : Tree, i : Int) : Void
    {
        if (parent != this.parent)
        {
            throw ("parents don't match; expected " + parent + " found " + this.parent);
        }
        if (i != this.childIndex)
        {
            throw ("child indexes don't match; expected " + i + " found " + this.childIndex);
        }
        var n : Int = this.childCount;
        for (c in 0...n)
        {
            var child : CommonTree = cast((this.getChild(c)), CommonTree);
            child.sanityCheckParentAndChildIndexesFrom(this, c);
        }
    }
    
    /** BaseTree doesn't track child indexes. */
    private function get_childIndex() : Int
    {
        return 0;
    }
    
    private function set_childIndex(index : Int) : Int
    {
        return index;
    }
    
    /** BaseTree doesn't track parent pointers. */
    private function get_parent() : Tree
    {
        return null;
    }
    private function set_parent(t : Tree) : Tree
    {
        return t;
    }
    
    /** Walk upwards looking for ancestor with this token type. */
    public function hasAncestor(ttype : Int) : Bool
    {
        return getAncestor(ttype) != null;
    }
    
    /** Walk upwards and get first ancestor with this token type. */
    public function getAncestor(ttype : Int) : Tree
    {
        var t : Tree = this;
        t = t.parent;
        while (t != null)
        {
            if (t.type == ttype)
            {
                return t;
            }
            t = t.parent;
        }
        return null;
    }
    
    /** Return a list of all ancestors of this node.  The first node of
     *  list is the root and the last is the parent of this node.
     */
    private function get_ancestors() : Array<Dynamic>
    {
        if (parent == null)
        {
            return null;
        }
        var ancestors : Array<Dynamic> = new Array<Dynamic>();
        var t : Tree = this;
        t = t.parent;
        while (t != null)
        {
            ancestors.unshift(t);  // insert at start  
            t = t.parent;
        }
        return ancestors;
    }
    
    /** Print out a whole tree not just a node */
    public function toStringTree() : String
    {
        if (_children == null || _children.length == 0)
        {
            return Std.string(this);
        }
        var buf : String = "";
        if (!isNil)
        {
            buf += "(";
            buf += Std.string(this);
            buf += " ";
        }
        var i : Int = 0;
        while (_children != null && i < _children.length)
        {
            var t : BaseTree = cast((_children[i]), BaseTree);
            if (i > 0)
            {
                buf += " ";
            }
            buf += t.toStringTree();
            i++;
        }
        if (!isNil)
        {
            buf += ")";
        }
        return buf;
    }
    
    private function get_line() : Int
    {
        return 0;
    }
    
    private function get_charPositionInLine() : Int
    {
        return 0;
    }
    
    // "Abstract" functions since there are no abstract classes in actionscript
    
    public function dupNode() : Tree
    {
        throw ("Not implemented");
    }
    
    private function get_type() : Int
    {
        throw ("Not implemented");
    }
    
    private function get_text() : String
    {
        throw ("Not implemented");
    }
    
    private function get_tokenStartIndex() : Int
    {
        throw ("Not implemented");
    }
    
    private function set_tokenStartIndex(index : Int) : Int
    {
        throw ("Not implemented");
        return index;
    }
    
    private function get_tokenStopIndex() : Int
    {
        throw ("Not implemented");
    }
    
    private function set_tokenStopIndex(index : Int) : Int
    {
        throw ("Not implemented");
        return index;
    }
}
