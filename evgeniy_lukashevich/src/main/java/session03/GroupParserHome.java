package session03;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Jeckgehor on 25.05.2015.
 * ������ � XML (������ �����). ����� ��������� ����� xml � �������. ������������ DTD
 */
public class GroupParserHome {
    public  static void main (String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // �������� BuilderFactory
            factory.setValidating(true); // ��������� � ������� ������������� �������� DTD
            factory.setIgnoringElementContentWhitespace(true); // ��������� ������������� ������������
            DocumentBuilder builder = factory.newDocumentBuilder(); // �������� DocumentBuilder
            File file = new File("group.xml"); // ������������ ��������� ������
            Document doc = builder.parse(file); // ��������� ������� ���������
            Element root = doc.getDocumentElement(); // ��������� ��������� ��������
            visit(root, 0);
        } catch (Exception exceptions) {
            exceptions.printStackTrace();
        }
    }

    public static void visit(Node node, int level) {
        NodeList list = node.getChildNodes(); // ��������� ������ ���������, �������� �������
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i); // ��������� �������� � �������� �������� �� ������ NodeList
            Element element = (Element) childNode;
            process(element, level + 1); // ��������� ��������
            visit(childNode, level + 1); // ���� � �������� ��� ��������� ��������� ��������� �� ������
        }
    }

    public static void process(Element element, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print('\t');
        }
        Text textNode = (Text) element; // ��������� ��������� ���� ���� Text �� ��������
        String str = textNode.getData().trim(); // ���������� ������ �� ���� ���� Text
        System.out.print(element.getTagName() + " ");
        System.out.println(str);

    }
}
