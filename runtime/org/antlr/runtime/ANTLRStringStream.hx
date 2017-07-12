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

class ANTLRStringStream implements CharStream
{
    public var index(get, never) : Int;
    public var size(get, never) : Int;
    public var line(get, set) : Int;
    public var charPositionInLine(get, set) : Int;
    public var sourceName(get, set) : String;

    /** The data being scanned */
    private var data : String;
    
    /** How many characters are actually in the buffer */
    private var n : Int;
    
    /** 0..n-1 index into string of next char */
    private var p : Int = 0;
    
    /** line number 1..n within the input */
    private var _line : Int = 1;
    
    /** The index of the character relative to the beginning of the line 0..n-1 */
    private var _charPositionInLine : Int = 0;
    
    /** tracks how deep mark() calls are nested */
    private var markDepth : Int = 0;
    
    /** A list of CharStreamState objects that tracks the stream state
		 *  values line, charPositionInLine, and p that can change as you
		 *  move through the input stream.  Indexed from 1..markDepth.
	     *  A null is kept @ index 0.  Create upon first call to mark().
		 */
    private var markers : Array<Dynamic>;
    
    /** Track the last mark() call result value for use in rewind(). */
    private var lastMarker : Int;
    
    private var _sourceName : String;
    
    private var _lineDelimiter : String;
    
    /** Copy data in string to a local char array */
    public function new(input : String = null, lineDelimiter : String = "\n")
    {
        this._lineDelimiter = lineDelimiter;
        if (input != null)
        {
            this.data = input;
            this.n = input.length;
        }
    }
    
    /** Reset the stream so that it's in the same state it was
		 *  when the object was created *except* the data array is not
		 *  touched.
		 */
    public function reset() : Void
    {
        p = 0;
        _line = 1;
        _charPositionInLine = 0;
        markDepth = 0;
    }
    
    public function consume() : Void
    {
        if (p < n)
        {
            _charPositionInLine++;
            if (data.charAt(p) == _lineDelimiter)
            {
                _line++;
                _charPositionInLine = 0;
            }
            p++;
        }
    }
    
    public function LA(i : Int) : Int
    {
        if (i == 0)
        {
            return 0;
        }
        if (i < 0)
        {
            i++;  // e.g., translate LA(-1) to use offset i=0; then data[p+0-1]  
            if ((p + i - 1) < 0)
            {
                return CharStreamConstants.EOF;
            }
        }
        
        if ((p + i - 1) >= n)
        {
            return CharStreamConstants.EOF;
        }
        return data.charCodeAt(p + i - 1);
    }
    
    public function LT(i : Int) : Int
    {
        return LA(i);
    }
    
    /** Return the current input symbol index 0..n where n indicates the
	     *  last symbol has been read.  The index is the index of char to
		 *  be returned from LA(1).
	     */
    private function get_index() : Int
    {
        return p;
    }
    
    private function get_size() : Int
    {
        return n;
    }
    
    public function mark() : Int
    {
        if (markers == null)
        {
            markers = new Array<Dynamic>();
            markers.push(null);
        }
        markDepth++;
        var state : CharStreamState = null;
        if (markDepth >= markers.length)
        {
            state = new CharStreamState();
            markers.push(state);
        }
        else
        {
            state = cast((markers[markDepth]), CharStreamState);
        }
        state.p = p;
        state.line = _line;
        state.charPositionInLine = _charPositionInLine;
        lastMarker = markDepth;
        return markDepth;
    }
    
    public function rewindTo(m : Int) : Void
    {
        var state : CharStreamState = cast((markers[m]), CharStreamState);
        // restore stream state
        seek(state.p);
        _line = state.line;
        _charPositionInLine = state.charPositionInLine;
        release(m);
    }
    
    public function rewind() : Void
    {
        rewindTo(lastMarker);
    }
    
    public function release(marker : Int) : Void
    {
        // unwind any other markers made after m and release m
        markDepth = marker;
        // release this marker
        markDepth--;
    }
    
    /** consume() ahead until p==index; can't just set p=index as we must
		 *  update line and charPositionInLine.
		 */
    public function seek(index : Int) : Void
    {
        if (index <= p)
        {
            p = index;  // just jump; don't update stream state (line, ...)  
            return;
        }
        // seek forward, consume until p hits index
        while (p < index)
        {
            consume();
        }
    }
    
    public function substring(start : Int, stop : Int) : String
    {
        return data.substring(start, stop + 1);
    }
    
    private function get_line() : Int
    {
        return _line;
    }
    
    private function get_charPositionInLine() : Int
    {
        return _charPositionInLine;
    }
    
    private function set_line(line : Int) : Int
    {
        this._line = line;
        return line;
    }
    
    private function set_charPositionInLine(pos : Int) : Int
    {
        this._charPositionInLine = pos;
        return pos;
    }
    
    private function get_sourceName() : String
    {
        return _sourceName;
    }
    
    private function set_sourceName(sourceName : String) : String
    {
        _sourceName = sourceName;
        return sourceName;
    }
}

