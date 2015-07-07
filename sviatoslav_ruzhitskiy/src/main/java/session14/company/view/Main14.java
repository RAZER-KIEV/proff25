package session14.company.view;

import hw6.notes.dao.NotebookDaoImpl;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by RAZER on 30.06.2015.
 */
public class Main14 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-anno.xml");
       // NotebookDaoImpl notebookDao = context.getBean("notebookDaoImpl", NotebookDaoImpl.class);


    }
}
