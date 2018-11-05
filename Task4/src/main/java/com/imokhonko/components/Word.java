package com.imokhonko.components;

import java.util.List;
import java.util.Objects;

public class Word extends SyntaxUnit {

    List<Char> chars;

    public Word(List<Char> chars) {
        this.chars = chars;
    }

    public List<Char> getChars() {
        return chars;
    }

    @Override
    public String toString() {
        return "" + chars;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Word word = (Word) o;
        return Objects.equals(chars, word.chars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chars);
    }
}
