package session3;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by GFalcon on 25.05.15.
 */
public class XmlParse {
    public static void main(String[] args){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("group.xml"));
            System.out.println(doc.getDocumentElement().getFirstChild().getTextContent());
           // Node nod = doc.getDocumentElement().getFirstChild();
           // System.out.println(nod.getTextContent());
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            /*
            nodeList.getLength();
            System.out.println(nodeList.getLength());
            for(int i=0; i < nodeList.getLength(); i++){
                System.out.println(nodeList.item(i).getTextContent());
            }
            */
            nodeList.item(0).getNodeName();
            System.out.println(nodeList.item(0).getNodeName());
            System.out.println(nodeList.item(0).getNodeValue());
            System.out.println(nodeList.item(0).getTextContent());
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
