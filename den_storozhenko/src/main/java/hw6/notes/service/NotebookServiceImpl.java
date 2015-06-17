package hw6.notes.service;


import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class NotebookServiceImpl implements NotebookService {
    private static Logger log = Logger.getLogger(NotebookServiceImpl.class);
    private static final int STEP_PORCED =2;
    private SessionFactory factory;

    public NotebookServiceImpl(){

    }

    public NotebookServiceImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    @Override
    public Long add(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
        return id;
    }

    private Long getCount(){
        Session session = factory.openSession();
        Query query = session.createQuery("select COUNT(n.id) from Notebook n");
        return (Long)query.uniqueResult();
    }

    private List<Notebook> getAllNotebooksPorced(int start, int size) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Notebook> findAll() {
        List<Notebook> notebooks = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            notebooks.addAll(getAllNotebooksPorced(i,STEP_PORCED));
        }
        return notebooks;
    }
}
