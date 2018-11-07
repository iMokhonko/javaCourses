package com.imokhonko.dom;

import com.imokhonko.Gem;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomExample {

    public static void main(String[] args) throws IOException, ParserConfigurationException, org.xml.sax.SAXException {
        List<Gem> gemItems = new ArrayList<>();
        DomParser.parseDoc(gemItems, DomParser.getDoc(new File("gems.xml")));

        for(Gem gemItem : gemItems) {
            System.out.println(gemItem);
        }
    }

}
