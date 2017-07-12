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


class CommonToken implements Token
{
    public var type(get, set) : Int;
    public var line(get, set) : Int;
    public var text(get, set) : String;
    public var charPositionInLine(get, set) : Int;
    public var channel(get, set) : Int;
    public var startIndex(get, set) : Int;
    public var stopIndex(get, set) : Int;
    public var tokenIndex(get, set) : Int;
    public var inputStream(get, set) : CharStream;

    private var _type : Int;
    private var _line : Int;
    private var _charPositionInLine : Int = -1;  // set to invalid position  
    private var _channel : Int = TokenConstants.DEFAULT_CHANNEL;
    private var _input : CharStream;
    
    /** We need to be able to change the text once in a while.  If
	 *  this is non-null, then getText should return this.  Note that
	 *  start/stop are not affected by changing this.
	 */
    private var _text : String;
    
    /** What token number is this from 0..n-1 tokens; < 0 implies invalid index */
    private var _index : Int = -1;
    
    /** The char position into the input buffer where this token starts */
    private var _start : Int;
    
    /** The char position into the input buffer where this token stops */
    private var _stop : Int;
    
    public function new(type : Int, text : String = null)
    {
        this._type = type;
        this._text = text;
    }
    
    public static function createFromStream(input : CharStream, type : Int, channel : Int, start : Int, stop : Int) : CommonToken
    {
        var token : CommonToken = new CommonToken(type);
        token._input = input;
        token._channel = channel;
        token._start = start;
        token._stop = stop;
        return token;
    }
    
    public static function cloneToken(oldToken : Token) : CommonToken
    {
        var token : CommonToken = new CommonToken(oldToken.type, oldToken.text);
        token._line = oldToken.line;
        token._index = oldToken.tokenIndex;
        token._charPositionInLine = oldToken.charPositionInLine;
        token._channel = oldToken.channel;
        if (Std.is(oldToken, CommonToken))
        {
            token._start = cast((oldToken), CommonToken).startIndex;
            token._stop = cast((oldToken), CommonToken).stopIndex;
        }
        return token;
    }
    
    private function get_type() : Int
    {
        return _type;
    }
    
    private function set_line(line : Int) : Int
    {
        _line = line;
        return line;
    }
    
    private function get_text() : String
    {
        if (_text != null)
        {
            return _text;
        }
        if (_input == null)
        {
            return null;
        }
        _text = _input.substring(_start, _stop);
        return _text;
    }
    
    /** Override the text for this token.  getText() will return this text
	 *  rather than pulling from the buffer.  Note that this does not mean
	 *  that start/stop indexes are not valid.  It means that that input
	 *  was converted to a new string in the token object.
	 */
    private function set_text(text : String) : String
    {
        _text = text;
        return text;
    }
    
    private function get_line() : Int
    {
        return _line;
    }
    
    private function get_charPositionInLine() : Int
    {
        return _charPositionInLine;
    }
    
    private function set_charPositionInLine(charPositionInLine : Int) : Int
    {
        _charPositionInLine = charPositionInLine;
        return charPositionInLine;
    }
    
    private function get_channel() : Int
    {
        return _channel;
    }
    
    private function set_channel(channel : Int) : Int
    {
        _channel = channel;
        return channel;
    }
    
    private function set_type(type : Int) : Int
    {
        _type = type;
        return type;
    }
    
    private function get_startIndex() : Int
    {
        return _start;
    }
    
    private function set_startIndex(start : Int) : Int
    {
        _start = start;
        return start;
    }
    
    private function get_stopIndex() : Int
    {
        return _stop;
    }
    
    private function set_stopIndex(stop : Int) : Int
    {
        _stop = stop;
        return stop;
    }
    
    private function get_tokenIndex() : Int
    {
        return _index;
    }
    
    private function set_tokenIndex(index : Int) : Int
    {
        _index = index;
        return index;
    }
    
    private function get_inputStream() : CharStream
    {
        return _input;
    }
    
    private function set_inputStream(input : CharStream) : CharStream
    {
        _input = input;
        return input;
    }
    
    public function toString() : String
    {
        var channelStr : String = "";
        if (channel > 0)
        {
            channelStr = ",channel=" + channel;
        }
        var txt : String = text;
        if (txt != null)
        {
            txt = StringTools.replace(txt, "\n", "\\\\n");
            txt = StringTools.replace(txt, "\r", "\\\\r");
            txt = StringTools.replace(txt, "\t", "\\\\t");
        }
        else
        {
            txt = "<no text>";
        }
        return "[@" + tokenIndex + "," + startIndex + ":" + stopIndex + "='" + txt + "',<" + type + ">" + channelStr + "," + line + ":" + charPositionInLine + "]";
    }
}

