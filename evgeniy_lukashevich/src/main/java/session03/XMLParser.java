package session03;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Jeckgehor on 25.05.2015.
 * Работа с XML (парсер файла)
 */
public class XMLParser {
    public  static void main (String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("purchase_order.xml"));
            System.out.println(doc.getDocumentElement().getFirstChild().getNodeType());
        } catch (Exception exceptions) {
            exceptions.printStackTrace();
        }
    }
}
