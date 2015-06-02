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
import java.io.IOException;import java.lang.String;import java.lang.System;

/**
 * Created by Sveta on 5/25/2015.
 *
 *
 */
public class task1 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("Group.xml");

        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                NodeList subList = node.getChildNodes();
                for (int j = 0; j < subList.getLength(); j++) {
                    Node subNode = subList.item(j);
                    if (subNode instanceof Element) {
                        System.out.println(subNode.getNodeName() + " : " + subNode.getTextContent());
                    }
                }
            }
        }

    }


}
