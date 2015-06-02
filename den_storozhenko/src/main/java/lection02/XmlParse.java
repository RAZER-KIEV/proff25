package lection02;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlParse {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(false);
        DocumentBuilder builder = null;
        try {
            builder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = builder.parse(new File("src\\lection02\\xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = document.getDocumentElement(); // �������� �������
        recursDom(node);
    }

    public static void recursDom(Node root){
        if (root.getNodeType()!=Node.TEXT_NODE) {
            System.out.print(root.getNodeName());
        }
        NodeList nodeList = root.getChildNodes();
        if (nodeList.getLength()==0){
            System.out.print(" " + root.getTextContent());
        }
        else
            for(int i=0;i<nodeList.getLength();i++){
                recursDom(nodeList.item(i));
            }
    }
}
//вывести в консоль структуру хмл-документа