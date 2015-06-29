package session3;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.*;

/**
 * Created by ivan on 25.05.15.
 */
public class XmlParse {

    public static void main(String[] args) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(new File("Students"));

            Element root = doc.getDocumentElement();
            System.out.println(root.getNodeName());
            NodeList lst = root.getChildNodes();
            for(int i=0; i<lst.getLength();i++){
                if (lst.item(i).getNodeType()!=Node.TEXT_NODE){
                    Node el = lst.item(1);
                    do{
                        System.out.println(el.getNodeName()+": "+ el.getTextContent());
                        el=el.getNextSibling();
                    }while(el!=null);
                }
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
