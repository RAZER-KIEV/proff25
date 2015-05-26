package session03;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Jeckgehor on 25.05.2015.
 * Работа с XML (парсер файла). Вывод структуры файла xml в консоль.
 */
public class GroupParser {
    public  static void main (String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // создание BuilderFactory
            DocumentBuilder builder = factory.newDocumentBuilder(); // создание DocumentBuilder
            File file = new File("group.xml"); // инкапсуляция источника данных
            Document doc = builder.parse(file); // получение парсера документа
            Element root = doc.getDocumentElement(); // получение корневого элемента
            System.out.println(root.getTagName()); // тэг элемента
            System.out.println(root.getNodeType()); // тип элемента
            visit(root,0);
        } catch (Exception exceptions) {
            exceptions.printStackTrace();
        }
    }

    public static void visit(Node node, int level) {
        NodeList list = node.getChildNodes(); // получение набора элементов, дочерних данному
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i); // получение элемента с заданным индексом из набора NodeList
            process(childNode, level + 1); // обработка элемента
            visit(childNode, level + 1); // вход в рекурсию для получения следующих элементов из дерева
        }
    }

    public static void process(Node node, int level) {
        for (int i =0; i < level; i++) {
            System.out.print('\t');
        }
        if (node instanceof Element) { // фильтр для обработки только элементов, игнорируя разделители
            Element el = (Element) node; // приведение элемента к типу Element
            Text textNode = (Text) el.getFirstChild(); // получение дочернего узла типа Text из элемента
            String str = textNode.getData().trim(); // извлечение строки из узла типа Text
            System.out.print(el.getTagName() + " ");
            System.out.println(str);
        }
    }
}
