package session3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by bosyi on 28.05.15.
 */
public class Task2 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("bogdan_iavorskyi/group.xml"));
//            play(document);
            print(document.getDocumentElement());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void play(Document doc) {
        Node node = doc.getDocumentElement();
        System.out.println("Node name: " + node.getNodeName());
//        System.out.println("Node text contents: " + node.getTextContent());
//        System.out.println(node.hasChildNodes());
//        NodeList list = node.getChildNodes();
//        System.out.println(list.getLength());
//        System.out.println(list.item(0).getNodeName());
//        System.out.println(list.item(0).getNodeType());
//        System.out.println(list.item(0).hasChildNodes());

    }

    public static void print(Node node) {
        if (!node.hasChildNodes()) {
            System.out.println(node.getTextContent());
            return;
        }
//        System.out.println("test");
//        System.out.println(node.getLocalName());
//        System.out.println(node.getNodeValue());
        System.out.println(node.getNodeName());
        NodeList list = node.getChildNodes();
        for(int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                print(list.item(i));
            } else if (list.item(i).getNodeType() == Node.TEXT_NODE && list.getLength() == 1) {
                print(list.item(i));
            }
        }
    }
}
