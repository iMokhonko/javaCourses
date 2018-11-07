package com.imokhonko.sax;

import com.imokhonko.Gem;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class ParserHandler extends DefaultHandler {

    private static final String ITEM_NODE = "item";
    private static final String ITEM_NAME_NODE = "name";
    private static final String ITEM_PRECIOUSNESS_NODE = "preciousness";
    private static final String ITEM_ORIGIN_NODE = "origin";

    // visual parameters
    private static final String ITEM_VISUAL_PARAMETERS_COLOR_NODE = "color";
    private static final String ITEM_VISUAL_PARAMETERS_TRANSPARENCY_NODE = "transparency";
    private static final String ITEM_VISUAL_PARAMETERS_FACES_NODE = "faces";

    private static final String ITEM_VALUE_NODE = "value";

    private Gem currentGem;

    // current node
    private String currentNode;

    private List<Gem> gemItems;

    public ParserHandler(List<Gem> gemItems) {
        this.gemItems = gemItems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentNode = qName;

        switch(currentNode) {
            case ITEM_NODE: {
                int id = Integer.valueOf(attributes.getValue("id"));
                currentGem = new Gem(id);
            } break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length).trim();

        if(value.length() < 1) {
            return;
        }

        switch(currentNode) {
            case ITEM_NAME_NODE: {
                currentGem.setName(value);
                break;
            }

            case ITEM_PRECIOUSNESS_NODE: {
                currentGem.setPreciousness(value);
                break;
            }

            case ITEM_ORIGIN_NODE: {
                currentGem.setOrigin(value);
                break;
            }

            case ITEM_VISUAL_PARAMETERS_COLOR_NODE: {
                currentGem.setColor(value);
                break;
            }

            case ITEM_VISUAL_PARAMETERS_TRANSPARENCY_NODE: {
                currentGem.setTransparency(Integer.valueOf(value));
                break;
            }

            case ITEM_VISUAL_PARAMETERS_FACES_NODE: {
                currentGem.setFaces(Integer.valueOf(value));
                break;
            }

            case ITEM_VALUE_NODE: {
                currentGem.setValue(Integer.valueOf(value));
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch(qName) {
            case ITEM_NODE: {
                gemItems.add(currentGem);
                currentGem = null;
            } break;
        }
    }

}
