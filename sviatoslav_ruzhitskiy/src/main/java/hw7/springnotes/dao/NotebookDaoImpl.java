package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ПК on 25.06.2015.
 */

@Repository
@Transactional
public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory sessionFactory;
    Notebook notebook;

    public NotebookDaoImpl(){}

    public NotebookDaoImpl(SessionFactory sf){
        sessionFactory = sf;
    }


    @Override
    public Long create(Notebook notebook) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(notebook);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }
    @Override
    public Notebook read(Long id) {
        Session session = sessionFactory.openSession();
        Notebook nbk = null;
        try {
            nbk = (Notebook) session.get(Notebook.class,id);
        }catch (HibernateException hEx){
            System.out.println("Exception: Not readed!");
             hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        return nbk;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = sessionFactory.openSession();
        boolean upres = false;
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            upres = true;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return upres;

    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = sessionFactory.openSession();
        boolean res;
        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            res = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not deleted!");
            hEx.printStackTrace();
            res = false;
        }finally {
            if (session !=null)
                session.close();
        }
        return res;
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook");
        return query.list();
    }
}
