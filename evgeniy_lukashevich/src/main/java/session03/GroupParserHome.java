package session03;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Jeckgehor on 25.05.2015.
 * Работа с XML (парсер файла). Вывод структуры файла xml в консоль. Используется DTD
 */
public class GroupParserHome {
    public  static void main (String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // создание BuilderFactory
            factory.setValidating(true); // включение в фабрике необходимости проверки DTD
            factory.setIgnoringElementContentWhitespace(true); // установка игнорирования разделителей
            DocumentBuilder builder = factory.newDocumentBuilder(); // создание DocumentBuilder
            File file = new File("group.xml"); // инкапсуляция источника данных
            Document doc = builder.parse(file); // получение парсера документа
            Element root = doc.getDocumentElement(); // получение корневого элемента
            visit(root, 0);
        } catch (Exception exceptions) {
            exceptions.printStackTrace();
        }
    }

    public static void visit(Node node, int level) {
        NodeList list = node.getChildNodes(); // получение набора элементов, дочерних данному
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i); // получение элемента с заданным индексом из набора NodeList
            Element element = (Element) childNode;
            process(element, level + 1); // обработка элемента
            visit(childNode, level + 1); // вход в рекурсию для получения следующих элементов из дерева
        }
    }

    public static void process(Element element, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print('\t');
        }
        Text textNode = (Text) element; // получение дочернего узла типа Text из элемента
        String str = textNode.getData().trim(); // извлечение строки из узла типа Text
        System.out.print(element.getTagName() + " ");
        System.out.println(str);

    }
}
