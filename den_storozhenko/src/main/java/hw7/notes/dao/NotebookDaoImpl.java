package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class NotebookDaoImpl implements NotebookDao {
    private static final int STEP_PORCED =10;
    private SessionFactory factory;

    public NotebookDaoImpl(){
    }

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try{
            return (Notebook)session.get(Notebook.class,id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    public Long getCount(){
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select COUNT(n.id) from Notebook n");
            return (Long) query.uniqueResult();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Notebook> getNotebooksPorced(int start, int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Notebook");
            query.setFirstResult(start);
            query.setMaxResults(size);
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Notebook> findAll() {
        List<Notebook> notebooks = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            notebooks.addAll(getNotebooksPorced(i,STEP_PORCED));
        }
        return notebooks;
    }
}
