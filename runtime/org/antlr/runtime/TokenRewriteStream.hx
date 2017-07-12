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
package org.antlr.runtime;

import flash.errors.Error;
import org.antlr.runtime.Token;

/** Useful for dumping out the input stream after doing some
	 *  augmentation or other manipulations.
	 *
	 *  You can insert stuff, replace, and delete chunks.  Note that the
	 *  operations are done lazily--only if you convert the buffer to a
	 *  String.  This is very efficient because you are not moving data around
	 *  all the time.  As the buffer of tokens is converted to strings, the
	 *  toString() method(s) check to see if there is an operation at the
	 *  current index.  If so, the operation is done and then normal String
	 *  rendering continues on the buffer.  This is like having multiple Turing
	 *  machine instruction streams (programs) operating on a single input tape. :)
	 *
	 *  Since the operations are done lazily at toString-time, operations do not
	 *  screw up the token index values.  That is, an insert operation at token
	 *  index i does not change the index values for tokens i+1..n-1.
	 *
	 *  Because operations never actually alter the buffer, you may always get
	 *  the original token stream back without undoing anything.  Since
	 *  the instructions are queued up, you can easily simulate transactions and
	 *  roll back any changes if there is an error just by removing instructions.
	 *  For example,
	 *
	 *   var input:CharStream = new ANTLRFileStream("input");
	 *   var lex:TLexer = new TLexer(input);
	 *   var tokens:TokenRewriteStream = new TokenRewriteStream(lex);
	 *   var parser:T = new T(tokens);
	 *   parser.startRule();
	 *
	 * 	 Then in the rules, you can execute
	 *      var t:Token t, u:Token;
	 *      ...
	 *      input.insertAfter(t, "text to put after t");}
	 * 		input.insertAfter(u, "text after u");}
	 * 		trace(tokens.toString());
	 *
	 *  Actually, you have to cast the 'input' to a TokenRewriteStream. :(
	 *
	 *  You can also have multiple "instruction streams" and get multiple
	 *  rewrites from a single pass over the input.  Just name the instruction
	 *  streams and use that name again when printing the buffer.  This could be
	 *  useful for generating a C file and also its header file--all from the
	 *  same buffer:
	 *
	 *      tokens.insertAfter("pass1", t, "text to put after t");}
	 * 		tokens.insertAfter("pass2", u, "text after u");}
	 * 		trace(tokens.toString("pass1"));
	 * 		trace(tokens.toString("pass2"));
	 *
	 *  If you don't use named rewrite streams, a "default" stream is used as
	 *  the first example shows.
	 */
class TokenRewriteStream extends CommonTokenStream
{
    public static inline var DEFAULT_PROGRAM_NAME : String = "default";
    public static inline var MIN_TOKEN_INDEX : Int = 0;
    
    /** You may have multiple, named streams of rewrite operations.
		 *  I'm calling these things "programs."
		 *  Maps String (name) -> rewrite (List)
		 */
    private var programs : Dynamic = {};
    
    /** Map String (program name) -> Integer index */
    private var lastRewriteTokenIndexes : Dynamic = {};
    
    public function new(tokenSource : TokenSource = null, channel : Int = TokenConstants.DEFAULT_CHANNEL)
    {
        super(tokenSource, channel);
        Reflect.setField(programs, DEFAULT_PROGRAM_NAME, new Array<Dynamic>());
    }
    
    /** Rollback the instruction stream for a program so that
		 *  the indicated instruction (via instructionIndex) is no
		 *  longer in the stream.  UNTESTED!
		 */
    public function rollback(instructionIndex : Int, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        var isn : Array<Dynamic> = try cast(Reflect.field(programs, programName), Array</*AS3HX WARNING no type*/>) catch(e:Dynamic) null;
        if (isn != null)
        {
            Reflect.setField(programs, programName, isn.slice(MIN_TOKEN_INDEX, instructionIndex));
        }
    }
    
    /** Reset the program so that no instructions exist */
    public function deleteProgram(programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        rollback(MIN_TOKEN_INDEX, programName);
    }
    
    public function insertAfterToken(t : Token, text : Dynamic, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        insertAfter(t.tokenIndex, text, programName);
    }
    
    public function insertAfter(index : Int, text : Dynamic, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        // to insert after, just insert before next index (even if past end)
        insertBefore(index + 1, text, programName);
    }
    
    public function insertBeforeToken(t : Token, text : Dynamic, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        insertBefore(t.tokenIndex, text, programName);
    }
    
    public function insertBefore(index : Int, text : Dynamic, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        var op : RewriteOperation = new InsertBeforeOp(index, text);
        var rewrites : Array<Dynamic> = getProgram(programName);
        op.instructionIndex = rewrites.length;
        rewrites.push(op);
    }
    
    public function replace(index : Int, text : Dynamic, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        replaceRange(index, index, text, programName);
    }
    
    public function replaceRange(fromIndex : Int, toIndex : Int, text : Dynamic, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        if (fromIndex > toIndex || fromIndex < 0 || toIndex < 0 || toIndex >= tokens.length)
        {
            throw ("replace: range invalid: " + fromIndex + ".." + toIndex + "(size=" + tokens.length + ")");
        }
        var op : RewriteOperation = new ReplaceOp(fromIndex, toIndex, text);
        var rewrites : Array<Dynamic> = getProgram(programName);
        op.instructionIndex = rewrites.length;
        rewrites.push(op);
    }
    
    public function replaceToken(indexT : Token, text : Dynamic, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        replaceTokenRange(indexT, indexT, text, programName);
    }
    
    public function replaceTokenRange(fromToken : Token, toToken : Token, text : Dynamic, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        replaceRange(fromToken.tokenIndex, toToken.tokenIndex, text, programName);
    }
    
    public function remove(index : Int, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        removeRange(index, index, programName);
    }
    
    public function removeRange(fromIndex : Int, toIndex : Int, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        replaceRange(fromIndex, toIndex, null, programName);
    }
    
    public function removeToken(token : Token, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        removeTokenRange(token, token, programName);
    }
    
    public function removeTokenRange(fromToken : Token, toToken : Token, programName : String = DEFAULT_PROGRAM_NAME) : Void
    {
        replaceTokenRange(fromToken, toToken, null, programName);
    }
    
    public function getLastRewriteTokenIndex(programName : String = DEFAULT_PROGRAM_NAME) : Int
    {
        var i : Dynamic = Reflect.field(lastRewriteTokenIndexes, programName);
        if (i == null)
        {
            return -1;
        }
        return as3hx.Compat.parseInt(i);
    }
    
    private function setLastRewriteTokenIndex(programName : String, i : Int) : Void
    {
        Reflect.setField(lastRewriteTokenIndexes, programName, i);
    }
    
    private function getProgram(name : String) : Array<Dynamic>
    {
        var isn : Array<Dynamic> = try cast(Reflect.field(programs, name), Array</*AS3HX WARNING no type*/>) catch(e:Dynamic) null;
        if (isn == null)
        {
            isn = initializeProgram(name);
        }
        return isn;
    }
    
    private function initializeProgram(name : String) : Array<Dynamic>
    {
        var isn : Array<Dynamic> = new Array<Dynamic>();
        Reflect.setField(programs, name, isn);
        return isn;
    }
    
    public function toOriginalString() : String
    {
        return toOriginalStringWithRange(MIN_TOKEN_INDEX, size - 1);
    }
    
    public function toOriginalStringWithRange(start : Int, end : Int) : String
    {
        var buf : String = new String();
        var i : Int = start;
        while (i >= MIN_TOKEN_INDEX && i <= end && i < tokens.length)
        {
            buf += getToken(i).text;
            i++;
        }
        return Std.string(buf);
    }
    
    override public function toString() : String
    {
        return toStringWithRange(MIN_TOKEN_INDEX, size - 1);
    }
    
    override public function toStringWithRange(start : Int, end : Int) : String
    {
        return toStringWithRangeAndProgram(start, end, DEFAULT_PROGRAM_NAME);
    }
    
    public function toStringWithRangeAndProgram(start : Int, end : Int, programName : String) : String
    {
        var rewrites : Array<Dynamic> = try cast(Reflect.field(programs, programName), Array</*AS3HX WARNING no type*/>) catch(e:Dynamic) null;
        
        // ensure start/end are in range
        if (end > tokens.length - 1)
        {
            end = as3hx.Compat.parseInt(tokens.length - 1);
        }
        if (start < 0)
        {
            start = 0;
        }
        
        if (rewrites == null || rewrites.length == 0)
        {
            return toOriginalStringWithRange(start, end);
        }
        var state : RewriteState = new RewriteState();
        state.tokens = tokens;
        
        // First, optimize instruction stream
        var indexToOp : Array<Dynamic> = reduceToSingleOperationPerIndex(rewrites);
        
        // Walk buffer, executing instructions and emitting tokens
        var i : Int = start;
        while (i <= end && i < tokens.length)
        {
            var op : RewriteOperation = cast((indexToOp[i]), RewriteOperation);
            indexToOp[i] = null;  // remove so any left have index size-1  
            var t : Token = cast((tokens[i]), Token);
            if (op == null)
            {
                // no operation at that index, just dump token
                state.buf += t.text;
                i++;
            }
            else
            {
                i = op.execute(state);
            }
        }
        
        // include stuff after end if it's last index in buffer
        // So, if they did an insertAfter(lastValidIndex, "foo"), include
        // foo if end==lastValidIndex.
        if (end == tokens.length - 1)
        {
            // Scan any remaining operations after last token
            // should be included (they will be inserts).
            for (op in indexToOp)
            {
                if (op == null)
                {
                    continue;
                }
                if (op.index >= tokens.length - 1)
                {
                    state.buf += op.text;
                }
            }
        }
        
        return state.buf;
    }
    
    /** We need to combine operations and report invalid operations (like
	     *  overlapping replaces that are not completed nested).  Inserts to
	     *  same index need to be combined etc...   Here are the cases:
	     *
	     *  I.i.u I.j.v                             leave alone, nonoverlapping
	     *  I.i.u I.i.v                             combine: Iivu
	     *
	     *  R.i-j.u R.x-y.v | i-j in x-y            delete first R
	     *  R.i-j.u R.i-j.v                         delete first R
	     *  R.i-j.u R.x-y.v | x-y in i-j            ERROR
	     *  R.i-j.u R.x-y.v | boundaries overlap    ERROR
	     *
	     *  I.i.u R.x-y.v | i in x-y                delete I
	     *  I.i.u R.x-y.v | i not in x-y            leave alone, nonoverlapping
	     *  R.x-y.v I.i.u | i in x-y                ERROR
	     *  R.x-y.v I.x.u                           R.x-y.uv (combine, delete I)
	     *  R.x-y.v I.i.u | i not in x-y            leave alone, nonoverlapping
	     *
	     *  I.i.u = insert u before op @ index i
	     *  R.x-y.u = replace x-y indexed tokens with u
	     *
	     *  First we need to examine replaces.  For any replace op:
	     *
	     *      1. wipe out any insertions before op within that range.
	     *      2. Drop any replace op before that is contained completely within
	     *         that range.
	     *      3. Throw exception upon boundary overlap with any previous replace.
	     *
	     *  Then we can deal with inserts:
	     *
	     *      1. for any inserts to same index, combine even if not adjacent.
	     *      2. for any prior replace with same left boundary, combine this
	     *         insert with replace and delete this replace.
	     *      3. throw exception if index in same range as previous replace
	     *
	     *  Don't actually delete; make op null in list. Easier to walk list.
	     *  Later we can throw as we add to index -> op map.
	     *
	     *  Note that I.2 R.2-2 will wipe out I.2 even though, technically, the
	     *  inserted stuff would be before the replace range.  But, if you
	     *  add tokens in front of a method body '{' and then delete the method
	     *  body, I think the stuff before the '{' you added should disappear too.
	     *
	     *  Return a map from token index to operation.
	     */
    private function reduceToSingleOperationPerIndex(rewrites : Array<Dynamic>) : Array<Dynamic>
    {
        //System.out.println("rewrites="+rewrites);
        
        // WALK REPLACES
        for (i in 0...rewrites.length)
        {
            var op : RewriteOperation = cast((rewrites[i]), RewriteOperation);
            if (op == null)
            {
                continue;
            }
            if (!(Std.is(op, ReplaceOp)))
            {
                continue;
            }
            var rop : ReplaceOp = cast((rewrites[i]), ReplaceOp);
            // Wipe prior inserts within range
            var inserts : Array<Dynamic> = getKindOfOps(rewrites, InsertBeforeOp, i);
            for (j in 0...inserts.length)
            {
                var iop : InsertBeforeOp = cast((inserts[j]), InsertBeforeOp);
                if (iop.index >= rop.index && iop.index <= rop.lastIndex)
                {
                    rewrites[iop.instructionIndex] = null;
                }
            }
            // Drop any prior replaces contained within
            var prevReplaces : Array<Dynamic> = getKindOfOps(rewrites, ReplaceOp, i);
            for (j in 0...prevReplaces.length)
            {
                var prevRop : ReplaceOp = cast((prevReplaces[j]), ReplaceOp);
                if (prevRop.index >= rop.index && prevRop.lastIndex <= rop.lastIndex)
                {
                    rewrites[prevRop.instructionIndex] = null;  // delete replace as it's a no-op.  
                    continue;
                }
                // throw exception unless disjoint or identical
                var disjoint : Bool = 
                prevRop.lastIndex < rop.index || prevRop.index > rop.lastIndex;
                var same : Bool = 
                prevRop.index == rop.index && prevRop.lastIndex == rop.lastIndex;
                if (!disjoint && !same)
                {
                    throw ("replace op boundaries of " + rop +
                    " overlap with previous " + prevRop);
                }
            }
        }
        
        // WALK INSERTS
        for (i in 0...rewrites.length)
        {
            op = cast((rewrites[i]), RewriteOperation);
            if (op == null)
            {
                continue;
            }
            if (!(Std.is(op, InsertBeforeOp)))
            {
                continue;
            }
            iop = cast((rewrites[i]), InsertBeforeOp);
            // combine current insert with prior if any at same index
            var prevInserts : Array<Dynamic> = getKindOfOps(rewrites, InsertBeforeOp, i);
            for (j in 0...prevInserts.length)
            {
                var prevIop : InsertBeforeOp = cast((prevInserts[j]), InsertBeforeOp);
                if (prevIop.index == iop.index)
                {
                    // combine objects
                    // convert to strings...we're in process of toString'ing
                    // whole token buffer so no lazy eval issue with any templates
                    iop.text = catOpText(iop.text, prevIop.text);
                    rewrites[prevIop.instructionIndex] = null;
                }
            }
            // look for replaces where iop.index is in range; error
            prevReplaces = getKindOfOps(rewrites, ReplaceOp, i);
            for (j in 0...prevReplaces.length)
            {
                rop = cast((prevReplaces[j]), ReplaceOp);
                if (iop.index == rop.index)
                {
                    rop.text = catOpText(iop.text, rop.text);
                    rewrites[i] = null;  // delete current insert  
                    continue;
                }
                if (iop.index >= rop.index && iop.index <= rop.lastIndex)
                {
                    throw ("insert op " + iop +
                    " within boundaries of previous " + rop);
                }
            }
        }
        // System.out.println("rewrites after="+rewrites);
        var m : Array<Dynamic> = new Array<Dynamic>();
        for (i in 0...rewrites.length)
        {
            op = cast((rewrites[i]), RewriteOperation);
            if (op == null)
            {
                continue;
            }  // ignore deleted ops  
            if (m[op.index] != null)
            {
                throw ("should only be one op per index");
            }
            m[op.index] = op;
        }
        //System.out.println("index to op: "+m);
        return m;
    }
    
    private function catOpText(a : Dynamic, b : Dynamic) : String
    {
        var x : String = "";
        var y : String = "";
        if (a != null)
        {
            x = Std.string(a);
        }
        if (b != null)
        {
            y = Std.string(b);
        }
        return x + y;
    }
    
    /** Get all operations before an index of a particular kind */
    private function getKindOfOps(rewrites : Array<Dynamic>, kind : Class<Dynamic>, before : Int = -1) : Array<Dynamic>
    {
        if (before == -1)
        {
            before = rewrites.length;
        }
        var ops : Array<Dynamic> = new Array<Dynamic>();
        var i : Int = 0;
        while (i < before && i < rewrites.length)
        {
            var op : RewriteOperation = cast((rewrites[i]), RewriteOperation);
            if (op == null)
            {
                {i++;continue;
                }
            }  // ignore deleted  
            if (Type.getClassName(op) == Type.getClassName(kind))
            {
                ops.push(op);
            }
            i++;
        }
        return ops;
    }
    
    
    public function toDebugString() : String
    {
        return toDebugStringWithRange(MIN_TOKEN_INDEX, size - 1);
    }
    
    public function toDebugStringWithRange(start : Int, end : Int) : String
    {
        var buf : String = new String();
        var i : Int = start;
        while (i >= MIN_TOKEN_INDEX && i <= end && i < tokens.length)
        {
            buf += getToken(i);
            i++;
        }
        return buf;
    }
}



// Define the rewrite operation hierarchy

class RewriteState
{
    public var buf : String = new String();
    public var tokens : Array<Dynamic>;

    public function new()
    {
    }
}

class RewriteOperation
{
    /** What index into rewrites List are we? */
    @:allow(org.antlr.runtime)
    private var instructionIndex : Int;
    /** Token buffer index. */
    public var index : Int;
    @:allow(org.antlr.runtime)
    private var text : Dynamic;
    public function new(index : Int, text : Dynamic)
    {
        this.index = index;
        this.text = text;
    }
    /** Execute the rewrite operation by possibly adding to the buffer.
	 *  Return the index of the next token to operate on.
	 */
    public function execute(state : RewriteState) : Int
    {
        return index;
    }
}

class InsertBeforeOp extends RewriteOperation
{
    public function new(index : Int, text : Dynamic)
    {
        super(index, text);
    }
    
    override public function execute(state : RewriteState) : Int
    {
        state.buf += text;
        state.buf += cast((state.tokens[index]), Token).text;
        return as3hx.Compat.parseInt(index + 1);
    }
    
    public function toString() : String
    {
        return "<InsertBeforeOp@" + index + ":\"" + text + "\">";
    }
}

/** I'm going to try replacing range from x..y with (y-x)+1 ReplaceOp
 *  instructions.
 */
class ReplaceOp extends RewriteOperation
{
    public var lastIndex : Int;
    
    public function new(fromIndex : Int, toIndex : Int, text : Dynamic)
    {
        super(fromIndex, text);
        lastIndex = toIndex;
    }
    
    override public function execute(state : RewriteState) : Int
    {
        if (text != null)
        {
            state.buf += text;
        }
        return as3hx.Compat.parseInt(lastIndex + 1);
    }
    
    public function toString() : String
    {
        return "<ReplaceOp@" + index + ".." + lastIndex + ":\"" + text + "\">";
    }
}

class DeleteOp extends ReplaceOp
{
    public function new(fromIndex : Int, toIndex : Int)
    {
        super(fromIndex, toIndex, null);
    }
    
    override public function toString() : String
    {
        return "<DeleteOp@" + index + ".." + lastIndex + ">";
    }
}
