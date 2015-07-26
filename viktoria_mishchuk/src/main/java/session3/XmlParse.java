package session3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by viktoria on 25.05.15.
 */
public class XmlParse {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);//проверяет если тру
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("Group.xml"));

            Element elem = (Element) doc.getDocumentElement();

//            System.out.println(doc.getDocumentElement().getFirstChild().getNodeType()== Node.TEXT_NODE);
//            System.out.println(doc.getDocumentElement().getElementsByTagName("first").item(1));
            System.out.println(doc.getDocumentElement().getTextContent());
//            System.out.println(doc.getDocumentElement().getNodeName());
//            System.out.println(doc.getDocumentElement().getElementsByTagName("student").toString().);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXml(Node el, String n){


    }

}
