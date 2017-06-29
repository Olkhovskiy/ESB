import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class Transform {
    // static String[] xsltTransform = {"ServerToJupiter.xsl","JupiterToServer.xsl"};
    static String[] xsdChema = {"JupiterRequest.xml", "JupiterResponse.xml", "ServerRequest.xml", "ServerResponse.xml"};

    public void xsltTransform(String path) {
        try {

//установка используемого XSL-преобразования

            Transformer transformerr = TransformerFactory.newInstance().newTransformer(new StreamSource(path));

//установка исходного XML-документа и конечного XML-файла

            transformerr.transform(new StreamSource("request.xml"), new StreamResult("newrequest.xml"));

            System.out.print("complete");

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public String selectXSLT(String filePath) {
        int xsd;
        int i = 0;
        while ((!this.validateXSD(xsdChema[i], filePath) || (i < xsdChema.length+1))) {
            i++;
        }
        xsd = i;
        if(xsd==0)return "JupiterToServer";
        if(xsd==2)return "ServerToJupiter";
        else return "Error";
    }

    public boolean validateXSD(String xsdPath, String xmlPath) {
        try {

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (Exception e) {
            System.out.println("Exception in validate ");
            return false;
        }
        return true;
    }
}
