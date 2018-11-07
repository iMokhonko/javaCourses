package com.imokhonko.sax;

import com.imokhonko.Gem;
import com.imokhonko.Validation;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SaxParserExample {

    private static final Comparator<Gem> SORT_BY_ID_ASCENDING = (o1, o2) -> o1.getId() - o2.getId();
    private static final Comparator<Gem> SORT_BY_ID_DESCENDING = (o1, o2) -> o2.getId() - o1.getId();
    private static final Comparator<Gem> SORT_BY_VALUE_ASCENDING = (o1, o2) -> o1.getValue() - o2.getValue();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("validating xml: " + Validation.validate("gems.xml", "gem.xsd"));

        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        List<Gem> gemItems = new ArrayList<>();

        ParserHandler parserHandler = new ParserHandler(gemItems);
        saxParser.parse(new File("gems.xml"), parserHandler);

        gemItems.sort(SORT_BY_VALUE_ASCENDING);

        for(Gem gemItem : gemItems) {
            System.out.println(gemItem);
        }

    }

}
