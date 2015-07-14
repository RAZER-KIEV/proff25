package hw6.notes.service;

import hw6.notes.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.Locale;

/**
 * Created by jax on 21.06.15.
 */
public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory factory =hibernateUtil.createHiber();
        Date date = new Date();
        java.sql.Date dataTime = new java.sql.Date(date.getTime());
      //  Notebook asus = new Notebook("122","Asus","q12",dataTime,200);
        Notebook acer = new Notebook("9876543","Acer","qwerty",dataTime,150.2);
        NotebookDaoImpl ntb = new NotebookDaoImpl(factory);
        NotebookServiceImpl nsi=new NotebookServiceImpl();
        hibernateUtil.openeSession(factory);
      //  ntb.create(acer);
      //  nsi.deleteByModel("acer");

        hibernateUtil.sessionClose();
    }
}
