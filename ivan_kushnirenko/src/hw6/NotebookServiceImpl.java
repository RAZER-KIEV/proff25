package hw6;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import java.util.Date;
import org.apache.log4j.Logger;

/**
 * Created by ivan on 17.06.15.
 */
public class NotebookServiceImpl {

    private static  Logger log = Logger.getLogger(NotebookServiceImpl.class);
    private SessionFactory factory;

    public boolean addNotebook(Long serial, String vendor, String model, Date manufactureDate, Integer price) {
        if(factory==null){
            factory = new HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(new Notebook(serial,vendor,model,manufactureDate,price));
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            log.error("ADDING FAILED.",e);
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return false;
        } finally {
            if (session!=null){
                session.close();
            }
        }
    }

    private void printNotebooks(List<Notebook> notebooks){
        for (Notebook ntb : notebooks) {
            System.out.println(ntb);
        }
    }

    public void showAllNotebooks(){
        if(factory==null){
            factory = new HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from hw6.Notebook");
            for (int i = 0; i<2; i++) {
                query.setFirstResult(i*2);
                query.setMaxResults(2);
                printNotebooks(query.list());
            }

        } catch (HibernateException e){
            log.error("OPERATION: showAllNotebooks FAILED.",e);
            e.printStackTrace();
            session.close();
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }

    public static void main(String[] args) {
        NotebookServiceImpl notebookService = new NotebookServiceImpl();
        notebookService.showAllNotebooks();
        notebookService.factory.close();
    }
}
