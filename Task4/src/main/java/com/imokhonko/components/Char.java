package com.imokhonko.components;

import java.util.Objects;

public class Char extends SyntaxUnit {

    final char character;

    public Char(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return character + "";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Char aChar = (Char) o;
        return character == aChar.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}
