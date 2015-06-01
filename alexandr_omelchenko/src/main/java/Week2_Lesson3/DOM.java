package Week2_Lesson3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOM {
    public static void structReader(Element element) {
        try {
            NodeList children = element.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child instanceof Element) {
                   // Element childElement = (Element) child;
                    System.out.println(child.getNodeName()+" - "+child.getTextContent());
                }
                NodeList list = child.getChildNodes();
                if (list.getLength() > 0) {
                    structReader((Element) list);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("Task1.xml"));
            // System.out.println(doc.getDocumentElement().getFirstChild().getNodeType() == Node.TEXT_NODE);
            Element korn = doc.getDocumentElement();
            NodeList students = korn.getChildNodes();
            int j=0;
            for (int i = 0; i < students.getLength(); i++) {
                Node child = students.item(i);
                if (child instanceof Element) {
                    j++;
                    // Element childElement = (Element) child;
                    System.out.println("Student"+j);
                    structReader((Element) child);
                }
                //System.out.println(korn.getNodeName());
                // structReader(korn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*NamedNodeMap attributes = childElement.getAttributes();
            for (int j=0; j<attributes.getLength();j++){
                Node attribute =attributes.item(j);
                String name =attribute.getNodeName();
                String value = attribute.getNodeValue();
                System.out.println("attribute.getNodeName()= "+name +" attribute.getNodeValue()= "+ value);
           }*/