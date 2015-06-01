package session3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by bosyi on 25.05.15.
 */
public class Task1 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("bogdan_iavorskyi/group.xml"));
            Element element = doc.getDocumentElement();

            printStructure(element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printStructure(Node node) {
        if (node.getChildNodes().getLength() == 0 || node.getChildNodes() == null) {
            System.out.println("test");
            System.out.println(node.getTextContent());
            return;
        } else {

//            System.out.println("test");
            NodeList list = node.getChildNodes();
            for(int i = 0; i < list.getLength(); i++) {

                    if (list.item(i).getChildNodes() == null || list.item(i).getChildNodes().getLength() ==0) {
                        /*System.out.println("Test");
                        if (list.item(i).getNodeType() != )

                        Element element = (Element) list.item(i);
                        System.out.println(element.getTextContent());*/
                    } else {
                        System.out.println(list.item(i).getNodeName());
                        printStructure(list.item(i));

                        /*Element element = (Element) list.item(i);
                        System.out.println(element.getTextContent());*/
                    }

            }
        }
    }

}
