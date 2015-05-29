package Session3;

import org.w3c.dom.Document;
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
 * Created by oleg on 25.05.15.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("Group"));
            Element rootEl = doc.getDocumentElement();
//            System.out.println(rootEl.getTextContent());
            print(rootEl);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void print(Node st){
        NodeList stl = st.getChildNodes();
        if (stl.getLength() != 0){
            for(int i = 0; i < stl.getLength(); i++){
                Node tmp = stl.item(i);
                if(tmp.getNodeType() == Node.TEXT_NODE){
                    System.out.print(tmp.getTextContent());
                }
                else {
                    System.out.print(tmp.getNodeName()+ " ");
                    print(tmp);
                }
            }
        }
    }
}
