package com.imokhonko.stax;

import com.imokhonko.Gem;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxExample {


    private static final String ITEM_NODE = "item";
    private static final String ITEM_NAME_NODE = "name";
    private static final String ITEM_PRECIOUSNESS_NODE = "preciousness";
    private static final String ITEM_ORIGIN_NODE = "origin";

    // visual parameters
    private static final String ITEM_VISUAL_PARAMETERS_COLOR_NODE = "color";
    private static final String ITEM_VISUAL_PARAMETERS_TRANSPARENCY_NODE = "transparency";
    private static final String ITEM_VISUAL_PARAMETERS_FACES_NODE = "faces";

    private static final String ITEM_VALUE_NODE = "value";


    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        String fileName = "gems.xml";
        List<Gem> gemItems = parseXML(fileName);
        for(Gem gem : gemItems){
            System.out.println(gem);
        }
    }

    private static List<Gem> parseXML(String fileName) throws XMLStreamException, FileNotFoundException {
        List<Gem> gemItems = new ArrayList<>();

        Gem currentGem = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));

        while(xmlEventReader.hasNext()) { // while not end of XML
            XMLEvent xmlEvent = xmlEventReader.nextEvent(); // read next event

            if (xmlEvent.isStartElement()){
                StartElement startElement = xmlEvent.asStartElement();

                String startNodeName = startElement.getName().getLocalPart();

                // if it is start element
                switch(startNodeName) {

                    case ITEM_NODE: {
                        int id = Integer.valueOf(startElement.getAttributeByName(new QName("id")).getValue());
                        currentGem = new Gem(id);
                        break;
                    }

                    case ITEM_NAME_NODE: {
                        xmlEvent = xmlEventReader.nextEvent();
                        currentGem.setName(xmlEvent.asCharacters().getData());
                        break;
                    }

                    case ITEM_PRECIOUSNESS_NODE: {
                        xmlEvent = xmlEventReader.nextEvent();
                        currentGem.setPreciousness(xmlEvent.asCharacters().getData());
                        break;
                    }

                    case ITEM_ORIGIN_NODE: {
                        xmlEvent = xmlEventReader.nextEvent();
                        currentGem.setOrigin(xmlEvent.asCharacters().getData());
                        break;
                    }

                    case ITEM_VISUAL_PARAMETERS_COLOR_NODE: {
                        xmlEvent = xmlEventReader.nextEvent();
                        currentGem.setColor(xmlEvent.asCharacters().getData());
                        break;
                    }

                    case ITEM_VISUAL_PARAMETERS_TRANSPARENCY_NODE: {
                        xmlEvent = xmlEventReader.nextEvent();
                        currentGem.setTransparency(Integer.valueOf(xmlEvent.asCharacters().getData()));
                        break;
                    }

                    case ITEM_VISUAL_PARAMETERS_FACES_NODE: {
                        xmlEvent = xmlEventReader.nextEvent();
                        currentGem.setFaces(Integer.valueOf(xmlEvent.asCharacters().getData()));
                        break;
                    }

                    case ITEM_VALUE_NODE: {
                        xmlEvent = xmlEventReader.nextEvent();
                        currentGem.setValue(Integer.valueOf(xmlEvent.asCharacters().getData()));
                        break;
                    }
                }

            }

            // if it is end element
            if(xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();

                String endNodeName = endElement.getName().getLocalPart();
                switch(endNodeName) {
                    case ITEM_NODE: {
                        gemItems.add(currentGem);
                        currentGem = null;
                    } break;
                }
            }
        }

        xmlEventReader.close();

        return gemItems;
    }

}
