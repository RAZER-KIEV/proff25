package session14.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by RAZER on 30.06.2015.
 */
public class MainDaoNote {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-anno.xml");
        NotebookDaoImpl notebookDao = context.getBean("notebookDaoImpl", NotebookDaoImpl.class);
        Notebook notebook1=      notebookDao.read(Long.parseLong("1"));
        Notebook notebook = context.getBean("notebook", Notebook.class);
        System.out.println(notebook1);
    }
}
