package hw6.notes.service;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Well on 17.06.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    private static Logger log = Logger.getLogger(NotebookService.class);
    private SessionFactory factory;

    public NotebookServiceImpl(){
        HibernateUtil hu = new HibernateUtil();
        this.factory = hu.connect();
    }

    @Override
    public Long add(Notebook notebook) {
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return null;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        return session.createQuery("from Notebook t").list();
    }
}
