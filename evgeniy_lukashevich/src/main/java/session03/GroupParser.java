package session03;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Jeckgehor on 25.05.2015.
 * ������ � XML (������ �����). ����� ��������� ����� xml � �������.
 */
public class GroupParser {
    public  static void main (String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // �������� BuilderFactory
            DocumentBuilder builder = factory.newDocumentBuilder(); // �������� DocumentBuilder
            File file = new File("group.xml"); // ������������ ��������� ������
            Document doc = builder.parse(file); // ��������� ������� ���������
            Element root = doc.getDocumentElement(); // ��������� ��������� ��������
            System.out.println(root.getTagName()); // ��� ��������
            System.out.println(root.getNodeType()); // ��� ��������
            visit(root,0);
        } catch (Exception exceptions) {
            exceptions.printStackTrace();
        }
    }

    public static void visit(Node node, int level) {
        NodeList list = node.getChildNodes(); // ��������� ������ ���������, �������� �������
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i); // ��������� �������� � �������� �������� �� ������ NodeList
            process(childNode, level + 1); // ��������� ��������
            visit(childNode, level + 1); // ���� � �������� ��� ��������� ��������� ��������� �� ������
        }
    }

    public static void process(Node node, int level) {
        for (int i =0; i < level; i++) {
            System.out.print('\t');
        }
        if (node instanceof Element) { // ������ ��� ��������� ������ ���������, ��������� �����������
            Element el = (Element) node; // ���������� �������� � ���� Element
            Text textNode = (Text) el.getFirstChild(); // ��������� ��������� ���� ���� Text �� ��������
            String str = textNode.getData().trim(); // ���������� ������ �� ���� ���� Text
            System.out.print(el.getTagName() + " ");
            System.out.println(str);
        }
    }
}
