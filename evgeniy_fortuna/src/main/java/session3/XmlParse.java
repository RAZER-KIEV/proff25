package session3;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import java.io.File;

/**
 * Created by jul on 28.06.2015.
 */
public class XmlParse {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  // создали фабрику
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();     // создаем объект у фабрики, который и будет создавать наши объекты

            // передаем тот ХМЛ-файл, на основании которого и нужно создать эту доменную структуру (DOM-модель)

            Document doc = builder.parse(new File("persons.xml"));
//            System.out.println(doc.getElementById("first"));
            System.out.println(doc.getDocumentElement().getFirstChild().getNodeType() == Node.TEXT_NODE);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
