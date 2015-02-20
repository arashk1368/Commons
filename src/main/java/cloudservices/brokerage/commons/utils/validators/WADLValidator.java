/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.commons.utils.validators;

import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
public class WADLValidator {

    private final static Logger LOGGER = Logger.getLogger(WADLValidator.class
            .getName());

    public static boolean validateXMLSchema(InputStream stream) throws Exception {

        try {
            String xsdPath = "http://www.w3.org/Submission/wadl/wadl.xsd";
            URL schemaFile = new URL(xsdPath);
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(stream));
        } catch (Exception ex) {
            LOGGER.log(Level.FINEST, ex.getMessage(), ex);
            return false;
        }
        return true;
    }
}
