package com.imokhonko;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /**
     * Split the given string to a sentences and sort it by number of words in it in natural ordering.
     * @param string text with sentences which will be sorted.
     * @return list of sorted in natural ordering sentences by number of word in it.
     */
    public static List<String> getNaturalOrderingSentences(String string) {
        List<String> list = new LinkedList<>();

        Pattern sentencePattern = Pattern.compile("([A-Z0-9]).*?\\.", Pattern.MULTILINE);
        Matcher sentenceMatcher = sentencePattern.matcher(string);

        while(sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group().trim()
                    .replaceAll("(\\s{2,})|(\\t+)", " "); // replace double or more spacing and tabulation.
            list.add(sentence);
        }

        return sortByWordsNumber(list);
    }

    /**
     * Sort list of string by number of words in it.
     * @param list list of sentences.
     * @return sorted list of sentences by number of words in it.
     */
    private static List<String> sortByWordsNumber(List<String> list) {
        list.sort((str1, str2) -> {
            int str1Length = getWords(str1).size();
            int str2Length = getWords(str2).size();
            return str1Length - str2Length;
        });
        return list;
    }

    /**
     * Split word in sentence.
     * @param sentence string with words to be splitted.
     * @return list of word in given sentence.
     */
    private static List<String> getWords(String sentence) {
        Pattern sentencePattern = Pattern.compile("((\\b[^\\s]+\\b)((?<=\\.\\w).)?)");
        Matcher sentenceMatcher = sentencePattern.matcher(sentence);

        List<String> list = new LinkedList<>();

        while(sentenceMatcher.find()) {
            list.add(sentenceMatcher.group());
        }

        return list;
    }

}
