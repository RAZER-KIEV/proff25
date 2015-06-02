package session3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.annotation.Documented;
import java.util.Map;

/**
 * Created by Роман on 25.05.2015.
 */
public class XmlParse {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false); // Для проверки нашего документа
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("/C:/ITC"));

            Element el1 = doc.getDocumentElement();
            printXmlTree(el1, "");

//            NodeList list = el1.getChildNodes();
//            Node el = list.item(1).getChildNodes().item(1).getChildNodes().item(1).getChildNodes().item(0);
//            System.out.println("Name: " + list.item(1).getNodeName() + ", size: " + list.item(1).getChildNodes().getLength());
//            System.out.println("Name: " + list.item(1).getChildNodes().item(1).getNodeName() + ", size: " + list.item(1).getChildNodes().item(1).getChildNodes().getLength());
//            System.out.println("Name: " + list.item(1).getChildNodes().item(1).getChildNodes().item(1).getNodeName() + ", size: " + list.item(1).getChildNodes().item(1).getChildNodes().item(1).getChildNodes().getLength());
//            System.out.println("SIze: " + list.getLength());
//            System.out.println("getNodeName(): " + el.getNodeName());
//            System.out.println("getLocalName(): " + el.getLocalName());
//            System.out.println("getTextContent(): " + el.getTextContent());
//            System.out.println("hasChildNodes(): " + el.hasChildNodes());
//            System.out.println("getNodeValue(): " + el.getNodeValue());
////            System.out.println("getAttribute(\"id\"): " + el.getAttribute("id"));
//            System.out.println("getBaseURI(): " + el.getBaseURI());
//            System.out.println("getNamespaceURI(): " + el.getNamespaceURI());
//            System.out.println("getPrefix(): " + el.getPrefix());
//            System.out.println("toString(): " + el.toString());
//            System.out.println("el.hasAttributes(): " + el.hasAttributes());
//            System.out.println(el.getAttributes().getNamedItem("id"));
//            System.out.println("hasAttribute(\"name\"): " + el.hasAttribute("name"));

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    private static void printXmlTree(Node node, String space) {
        space += "     ";
        if(!node.getNodeName().contains("#")) {
            if (node.getParentNode().getNodeName().equalsIgnoreCase("student")) {
                System.out.println(space + node.getNodeName() + " " + node.getTextContent());
            } else {
                System.out.println(space + node.getNodeName());
            }
        }
        if (node.hasChildNodes()) {
            NodeList list = node.getChildNodes();
            for(int i= 0; i < list.getLength(); i++) {
                printXmlTree(node.getChildNodes().item(i), space);
            }
        }
    }
}
