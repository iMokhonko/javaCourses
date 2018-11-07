package com.imokhonko.dom;

import com.imokhonko.Gem;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DomParser {

    private static final String ITEM_NODE = "item";
    private static final String ITEM_NAME_NODE = "name";
    private static final String ITEM_PRECIOUSNESS_NODE = "preciousness";
    private static final String ITEM_ORIGIN_NODE = "origin";

    // visual parameters
    private static final String ITEM_VISUAL_PARAMETERS_NODE = "visualParameters";
    private static final String ITEM_VISUAL_PARAMETERS_COLOR_NODE = "color";
    private static final String ITEM_VISUAL_PARAMETERS_TRANSPARENCY_NODE = "transparency";
    private static final String ITEM_VISUAL_PARAMETERS_FACES_NODE = "faces";

    private static final String ITEM_VALUE_NODE = "value";

    private static Gem currentGem;

    public static Document getDoc(File file) throws ParserConfigurationException, IOException, SAXException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
    }

    public static void parseDoc(List<Gem> list, Document doc) {
        NodeList gemItems = doc.getElementsByTagName(ITEM_NODE);

        for(int i = 0; i < gemItems.getLength(); i++) {
            Node itemNode = gemItems.item(i);

            int gemId = Integer.valueOf(itemNode.getAttributes().getNamedItem("id").getTextContent());
            currentGem = new Gem(gemId);

            if(itemNode.getNodeType() == Node.ELEMENT_NODE) {
                NodeList gemInfoNodes = itemNode.getChildNodes();

                for(int j = 0; j < gemInfoNodes.getLength(); j++) {
                    Node infoNode = gemInfoNodes.item(j);

                    if(infoNode.getNodeType() == Node.ELEMENT_NODE) {
                        switch(infoNode.getNodeName()) {
                            case ITEM_NAME_NODE:  {
                                currentGem.setName(infoNode.getTextContent());
                                break;
                            }

                            case ITEM_PRECIOUSNESS_NODE:  {
                                currentGem.setPreciousness(infoNode.getTextContent());
                                break;
                            }

                            case ITEM_ORIGIN_NODE:  {
                                currentGem.setOrigin(infoNode.getTextContent());
                                break;
                            }

                            case ITEM_VALUE_NODE: {
                                currentGem.setValue(Integer.valueOf(infoNode.getTextContent()));
                                break;
                            }

                            case ITEM_VISUAL_PARAMETERS_NODE:  {
                                NodeList visualParameters = infoNode.getChildNodes();

                                for(int k = 0; k < visualParameters.getLength(); k++) {
                                    Node visualParameterNode = visualParameters.item(k);

                                    if(visualParameterNode.getNodeType() == Node.ELEMENT_NODE) {
                                        switch(visualParameterNode.getNodeName()) {
                                            case ITEM_VISUAL_PARAMETERS_COLOR_NODE: {
                                                currentGem.setColor(visualParameterNode.getTextContent());
                                                break;
                                            }

                                            case ITEM_VISUAL_PARAMETERS_TRANSPARENCY_NODE: {
                                                currentGem.setTransparency(Integer.valueOf(visualParameterNode.getTextContent()));
                                                break;
                                            }

                                            case ITEM_VISUAL_PARAMETERS_FACES_NODE: {
                                                currentGem.setFaces(Integer.valueOf(visualParameterNode.getTextContent()));
                                                break;
                                            }
                                        }
                                    }
                                }

                                break;
                            }
                        }
                    }
                }
            }
            list.add(currentGem);
            currentGem = null;
        }
    }

}
