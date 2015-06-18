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
}
