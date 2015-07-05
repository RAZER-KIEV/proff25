package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sveta on 7/5/2015.
 */
@Repository
@Transactional
public class NotebookDaoImpl implements NotebookDao {
    @Autowired(required = true)
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }

    public NotebookDaoImpl(SessionFactory factory) {
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
        return (Long) factory.getCurrentSession().save(notebook);
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
        Query query = factory.getCurrentSession().createQuery("from Notebook ");
        return query.list();
    }
}
