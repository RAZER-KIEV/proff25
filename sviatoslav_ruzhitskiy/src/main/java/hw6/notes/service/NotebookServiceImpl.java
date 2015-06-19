package hw6.notes.service;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ПК on 18.06.2015.
 */
public class NotebookServiceImpl implements NotebookService{

    private static Logger log = Logger.getLogger(NotebookServiceImpl.class);
    private SessionFactory sessionFactory;

    public NotebookServiceImpl(){}
    public NotebookServiceImpl(SessionFactory sf){
        sessionFactory=sf;
    }

    @Override
    public Long add(Notebook notebook) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(notebook);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            log.error("Exception: Not saved!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from NOTEBOOKS");
        return query.list();
    }

    @Override
    public void changePrice(Long id, double price) {
        Session session = sessionFactory.openSession();
        //Long id = null;
        try {
            session.beginTransaction();
            Notebook tmp  = (Notebook) session.load(Notebook.class, id);
            tmp.setPrice(price);
            session.flush();
            session.getTransaction().commit();
        }catch (HibernateException hEx){
            System.out.println("Exception: Not changed!");
            log.error("Exception: Not changed!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Session session = sessionFactory.openSession();
        //Long id = null;
        try {
            session.beginTransaction();
            Notebook tmp  = (Notebook) session.load(Notebook.class, id);
            tmp.setSerial(serial);
            tmp.setVendor(vendor);
            session.flush();
            session.getTransaction().commit();
        }catch (HibernateException hEx){
            System.out.println("Exception: Not changed!");
            log.error("Exception: Not changed!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public boolean delete(Long id) {
        Session session = sessionFactory.openSession();
        boolean dlres = false;
        try {
            session.beginTransaction();
            Notebook tmp = (Notebook)session.load(Notebook.class, id);
            session.delete(tmp);
            session.getTransaction().commit();
            dlres = true;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not deleted!");
            log.error("Exception: Not deleted!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return dlres;
    }
}
