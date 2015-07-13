package session3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


/**
 * Created by Віктор on 5/25/2015.
 */
public class Task1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("class"));
            System.out.println(doc.getDocumentElement().getFirstChild().getNodeType());
        } catch (Exception exeption) {
            exeption.printStackTrace();
        }
    }
}
