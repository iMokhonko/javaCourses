package com.imokhonko.components.punctuationMarks;

import com.imokhonko.components.Char;
import com.imokhonko.components.SyntaxUnit;

public class SingleQuote extends SyntaxUnit {

    private final static char character = '\'';

    private SingleQuote() {}

    public static Char getInstance() {
        return new Char(character);
    }

    @Override
    public String toString() {
        return "" + character;
    }

}
