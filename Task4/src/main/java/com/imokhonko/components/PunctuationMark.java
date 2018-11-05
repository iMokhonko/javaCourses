package com.imokhonko.components;

public enum PunctuationMark {
    DOT('.'),
    COMMA(','),
    QUESTION('?'),
    EXCLAMATION('!'),
    COLON(':'),
    SEMICOLON(';'),
    DOUBLE_QUOTE('\"'),
    SINGLE_QUOTE('\''),
    OPEN_BRACKET('('),
    CLOSE_BRACKET(')'),
    SPACE(' ');

    private char character;

    PunctuationMark(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return "" + character;
    }
}
