package com.imokhonko;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validation {

    public static boolean validate(String xmlPath, String xsdPath) {
        return validate(new File(xmlPath), new File(xsdPath));
    }

    public static boolean validate(File xmlPath, File xsdPath) {
        Source xmlFile = new StreamSource(xmlPath);
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(xsdPath);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            return true;
        } catch (SAXException e) {} catch (IOException e) {}

        return false;
    }

}
