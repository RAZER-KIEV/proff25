package hw7.springnotes.dao;


import hw7.springnotes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by oleg on 24.06.15.
 */
@Repository
public class NotebookDaoImpl implements NotebookDao {
    @Autowired(required = true)
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook notebook) {
        return (Long)factory.getCurrentSession().save(notebook);
    }

    @Override
    public Notebook read(Long ig) {
        return (Notebook)factory.getCurrentSession().get(Notebook.class, ig);
    }

    @Override
    public boolean update(Notebook notebook) {
        factory.getCurrentSession().update(notebook);
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        factory.getCurrentSession().delete(notebook);
        return true;
    }

    @Override
    public List findAll() {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Notebook ");
        return query.list();
    }
}
