package org.antlr.runtime.tree;

import org.antlr.runtime.TokenConstants;

class TreeConstants
{
    public static var INVALID_NODE : CommonTree = CommonTree.createFromToken(TokenConstants.INVALID_TOKEN);

    public function new()
    {
    }
}
