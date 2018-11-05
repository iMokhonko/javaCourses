package com.imokhonko;

import com.imokhonko.components.Sentence;

import java.io.*;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        InputStream in = new FileInputStream(new File("text.txt"));

        StringBuilder textFromFile = new StringBuilder();

        byte[] buffer = new byte[5];
        int count;

        while((count = in.read (buffer)) != -1) {
            textFromFile.append(new String(buffer, 0, count, "UTF8"));
        }

        String text = new String(textFromFile);

        List<Sentence> sentences = StringUtil.getOrderedSentences(text);

        for(Object s : sentences) {
            System.out.println(s);
        }


    }

}
