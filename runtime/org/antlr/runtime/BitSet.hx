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


/**A stripped-down version of org.antlr.misc.BitSet that is just
	 * good enough to handle runtime requirements such as FOLLOW sets
	 * for automatic error recovery.
	 */
class BitSet
{
    public var size(get, set) : Int;
    public var isNil(get, never) : Bool;
    public var numBits(get, never) : Int;
    public var lengthInLongWords(get, never) : Int;

    private static inline var BITS : Int = 32;  // number of bits / int  
    private static inline var LOG_BITS : Int = 5;  // 2^5 == 32  
    
    /* We will often need to do a mod operator (i mod nbits).  Its
	     * turns out that, for powers of two, this mod operation is
	     * same as (i & (nbits-1)).  Since mod is slow, we use a
	     * precomputed mod mask to do the mod instead.
	     */
    private static var MOD_MASK : Int = BITS - 1;
    
    /** The actual data bits */
    private var bits : Array<Dynamic>;
    
    /** Construction from a static array of longs */
    public function new(bits : Array<Dynamic> = null)
    {
        if (bits == null)
        {
            this.bits = new Array<Dynamic>();
        }
        else
        {
            this.bits = new Array<Dynamic>();
            for (i in 0...bits.length)
            {
                this.bits[i] = bits[i];
            }
        }
    }
    
    public static function of(args : Array<Dynamic> = null) : BitSet
    {
        var s : BitSet = new BitSet();
        for (i in 0...args.length)
        {
            s.add(args[i]);
        }
        return s;
    }
    
    /** return this | a in a new set */
    public function or(a : BitSet) : BitSet
    {
        if (a == null)
        {
            return this;
        }
        var s : BitSet = this.clone();
        s.orInPlace(a);
        return s;
    }
    
    /** or this element into this set (grow as necessary to accommodate) */
    public function add(el : Int) : Void
    {
        var n : Int = wordNumber(el);
        if (n >= bits.length)
        {
            growToInclude(el);
        }
        bits[n] = bits[n] | bitMask(el);
    }
    
    /**
		 * Grows the set to a larger number of bits.
		 * @param bit element that must fit in set
		 */
    public function growToInclude(bit : Int) : Void
    {
        var newSize : Int = Std.int(Math.max(bits.length << 1, numWordsToHold(bit)));
        as3hx.Compat.setArrayLength(bits, newSize);
    }
    
    public function orInPlace(a : BitSet) : Void
    {
        if (a == null)
        {
            return;
        }
        // If this is smaller than a, grow this first
        if (a.bits.length > bits.length)
        {
            // Not necessary?
            //this.bits.length = a.bits.length;
        }
        var min : Int = Std.int(Math.min(bits.length, a.bits.length));
        var i : Int = as3hx.Compat.parseInt(min - 1);
        while (i >= 0)
        {
            bits[i] = bits[i] | a.bits[i];
            i--;
        }
    }
    
    /**
		 * Sets the size of a set.
		 * @param nwords how many words the new set should be
		 */
    private function set_size(nwords : Int) : Int
    {
        as3hx.Compat.setArrayLength(bits, nwords);
        return nwords;
    }
    
    private static function bitMask(bitNumber : Int) : Int
    {
        var bitPosition : Int = bitNumber & MOD_MASK;  // bitNumber mod BITS  
        return as3hx.Compat.parseInt(1 << bitPosition);
    }
    
    public function clone() : BitSet
    {
        var s : BitSet = new BitSet(bits);
        return s;
    }
    
    private function get_size() : Int
    {
        var deg : Int = 0;
        var i : Int = as3hx.Compat.parseInt(bits.length - 1);
        while (i >= 0)
        {
            var word : Int = bits[i];
            if (word != 0)
            {
                var bit : Int = as3hx.Compat.parseInt(BITS - 1);
                while (bit >= 0)
                {
                    if ((word & as3hx.Compat.parseInt(1 << bit)) != 0)
                    {
                        deg++;
                    }
                    bit--;
                }
            }
            i--;
        }
        return deg;
    }
    
    public function equals(other : Dynamic) : Bool
    {
        if (other == null || !(Std.is(other, BitSet)))
        {
            return false;
        }
        
        var otherSet : BitSet = cast((other), BitSet);
        
        var n : Int = Std.int(Math.min(this.bits.length, otherSet.bits.length));
        
        // for any bits in common, compare
        for (i in 0...n)
        {
            if (this.bits[i] != otherSet.bits[i])
            {
                return false;
            }
        }
        
        // make sure any extra bits are off
        
        if (this.bits.length > n)
        {
            for (i in n + 1...this.bits.length)
            {
                if (this.bits[i] != 0)
                {
                    return false;
                }
            }
        }
        else
        {
            if (otherSet.bits.length > n)
            {
                for (i in n + 1...otherSet.bits.length)
                {
                    if (otherSet.bits[i] != 0)
                    {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public function member(el : Int) : Bool
    {
        if (el < 0)
        {
            return false;
        }
        var n : Int = wordNumber(el);
        if (n >= bits.length)
        {
            return false;
        }
        return (bits[n] & bitMask(el)) != 0;
    }
    
    // remove this element from this set
    public function remove(el : Int) : Void
    {
        var n : Int = wordNumber(el);
        if (n < bits.length)
        {
            bits[n] = bits[n] & as3hx.Compat.parseInt(~bitMask(el));
        }
    }
    
    private function get_isNil() : Bool
    {
        var i : Int = as3hx.Compat.parseInt(bits.length - 1);
        while (i >= 0)
        {
            if (bits[i] != 0)
            {
                return false;
            }
            i--;
        }
        return true;
    }
    
    @:final private function numWordsToHold(el : Int) : Int
    {
        return as3hx.Compat.parseInt((el >> LOG_BITS) + 1);
    }
    
    private function get_numBits() : Int
    {
        return as3hx.Compat.parseInt(bits.length << LOG_BITS);
    }
    
    /** return how much space is being used by the bits array not
	     *  how many actually have member bits on.
	     */
    private function get_lengthInLongWords() : Int
    {
        return bits.length;
    }
    
    public function toArray() : Array<Dynamic>
    {
        var elems : Array<Dynamic> = new Array<Dynamic>()[this.bits.length];
        var en : Int = 0;
        for (i in 0...(bits.length << LOG_BITS))
        {
            if (member(i))
            {
                elems[en++] = i;
            }
        }
        return elems;
    }
    
    public function toPackedArray() : Array<Dynamic>
    {
        return bits;
    }
    
    private static function wordNumber(bit : Int) : Int
    {
        return as3hx.Compat.parseInt(bit >> LOG_BITS);
    }
    
    public function toString() : String
    {
        return toStringFromTokens(null);
    }
    
    public function toStringFromTokens(tokenNames : Array<Dynamic>) : String
    {
        var buf : String = "";
        var separator : String = ",";
        var havePrintedAnElement : Bool = false;
        buf = buf + "{";
        
        for (i in 0...(bits.length << LOG_BITS))
        {
            if (member(i))
            {
                if (i > 0 && havePrintedAnElement)
                {
                    buf += separator;
                }
                if (tokenNames != null)
                {
                    buf += tokenNames[i];
                }
                else
                {
                    buf += i;
                }
                havePrintedAnElement = true;
            }
        }
        buf += "}";
        return buf;
    }
}
