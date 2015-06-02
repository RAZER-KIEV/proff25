package session3;

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
 * Created by george on 25.05.15.
 */
public class xmlParse {

    public static void main (String[] args) throws IOException, SAXException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(new File("Students"));
            System.out.println(doc.getXmlVersion());
            System.out.println(doc.getNodeName());

            Element root=doc.getDocumentElement();
            System.out.println(root);
            NodeList children = root.getChildNodes();
            for(int i =0; i<children.getLength();i++){
                Node child = children.item(i);
                System.out.println(child.getTextContent());
            }
//            System.out.println(children.hashCode()));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        }
    }
