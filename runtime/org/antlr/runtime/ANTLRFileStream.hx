package org.antlr.runtime;

import flash.filesystem.File;
import flash.filesystem.FileMode;
import flash.filesystem.FileStream;
import flash.system.System;

class ANTLRFileStream extends ANTLRStringStream
{
    private var _file : File;
    
    public function new(file : File, encoding : String = null)
    {
        super();
        load(file, encoding);
    }
    
    public function load(file : File, encoding : String = null) : Void
    {
        _file = file;
        if (encoding == null)
        {
            encoding = File.systemCharset;
        }
        
        var stream : FileStream = new FileStream();
        
        try
        {
            stream.open(file, FileMode.READ);
            data = stream.readMultiByte(file.size, encoding);
            n = data.length;
        };
        finally;{
            stream.close();
        }
    }
    
    override private function get_sourceName() : String
    {
        return _file.name;
    }
}
