# Haxe backend for ANTLR3
This repo implements a Haxe backend for antlr3. The runtime can be found in the `runtime` folder (this contains all the code required for the generated lexer/parser). The binaries To generate the lexer/parser use: 
```
java -jar path/to/antlr-complete-3.5.3-SNAPSHOT.jar -o <output_dir> <grammar_file>
```

The binaries can be found in `antlr3/antlr-complete/`.