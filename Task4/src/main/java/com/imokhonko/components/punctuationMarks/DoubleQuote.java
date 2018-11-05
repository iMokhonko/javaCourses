package com.imokhonko.components.punctuationMarks;

import com.imokhonko.components.Char;
import com.imokhonko.components.SyntaxUnit;

public class DoubleQuote extends SyntaxUnit {

    private final static char character = '"';

    private DoubleQuote() {}

    public static Char getInstance() {
        return new Char(character);
    }

    @Override
    public String toString() {
        return "" + character;
    }

}
