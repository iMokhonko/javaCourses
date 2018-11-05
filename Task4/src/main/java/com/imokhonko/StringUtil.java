package com.imokhonko;

import com.imokhonko.components.*;
import com.imokhonko.components.punctuationMarks.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /* Default comparator that sorts sentences in natural order by number of words in it. */
    private static final Comparator<Sentence> DEFAULT_COMPARATOR = (str1, str2) -> str1.getWords().size() - str2.getWords().size();;

    /**
     * Sorts given text in natural order by number of words in the sentences.
     * @param text text that will be sorted by number of words in the sentences.
     * @return sorted list of sentences from text in natural order.
     */
    public static List<Sentence> getNaturalOrderingSentences(String text) {
        return getNaturalOrderingSentences(text, DEFAULT_COMPARATOR);
    }

    /**
     * Sorts given text using given comparator.
     * @param text text that will be sorted using given comparator.
     * @return sorted list of sentences by given comparator.
     */
    public static List<Sentence> getNaturalOrderingSentences(String text, Comparator<? super Sentence> comparator) {
        Pattern sentencePattern = Pattern.compile("([A-Z0-9]).*?\\.", Pattern.MULTILINE);
        Matcher sentenceMatcher = sentencePattern.matcher(text);

        List<Sentence> sentences = new LinkedList<>();

        while(sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group().trim()
                    .replaceAll("(\\s{2,})|(\\t+)", " "); // replace double or more spacing and tabulation.

            // split sentence to a words and punctuation marks
            List<String> splittedWords = getSentenceSplittedByPunctuationMarksAndChars(sentence);

            List<Word> words = getWordsSplittedByChars(splittedWords); // split words to a characters

            sentences.add(new Sentence(words)); // add sentence to a list
        }

        return sortByWordsNumber(sentences, comparator);
    }

    /**
     * Splits sentence to a words.
     * @param sentence sentence that will be splitted to a words.
     * @return list of words that represent given sentence.
     */
    private static List<String> getSentenceSplittedByPunctuationMarksAndChars(String sentence) {
        Pattern sentencePattern = Pattern.compile("\\b[^\\s]+?\\b|[?.,!)(;:]+?");
        Matcher sentenceMatcher = sentencePattern.matcher(sentence);

        List<String> words = new LinkedList<>();
        while(sentenceMatcher.find()) { words.add(sentenceMatcher.group()); }

        return words;
    }

    /**
     * Transforms words to a list of chars that represent this word.
     * @param words list of words to be transformed.
     * @return list of words splitted by chars.
     */
    private static List<Word> getWordsSplittedByChars(List<String> words) {
        List<Word> splittedWords = new LinkedList<>();

        for(String word : words) {
            List<Char> wordChars = new LinkedList<>();
            for(int i = 0; i < word.length(); i++) {
                wordChars.add(getChar(word.charAt(i)));
            }
            splittedWords.add(new Word(wordChars));
        }
        return splittedWords;
    }

    private static Char getChar(char c) {
        switch(c) {
            case '.':  { return Dot.getInstance(); }
            case ',':  { return Comma.getInstance(); }
            case '\'': { return SingleQuote.getInstance(); }
            case '"':  { return DoubleQuote.getInstance(); }
            case '!':  { return Exclamation.getInstance(); }
            case '?':  { return Question.getInstance(); }
            case ':':  { return Colon.getInstance(); }
            case ';':  { return Semicolon.getInstance(); }
            case '(':  { return OpenBracket.getInstance(); }
            case ')':  { return CloseBracket.getInstance(); }
            default:   { return new Char(c); } // if it is not a punctuation mark, return it as a character
        }
    }

    /**
     * Sort list of sentences by given comparator.
     * @param list list of sentences.
     * @return sorted list of sentences.
     */
    private static List<Sentence> sortByWordsNumber(List<Sentence> list, Comparator<? super Sentence> comparator) {
        list.sort(comparator);
        return list;
    }

}
