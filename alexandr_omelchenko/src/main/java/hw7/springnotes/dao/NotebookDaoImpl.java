package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NotebookDaoImpl implements NotebookDao {
    @Autowired
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
    public Long create(Notebook notebook)
        {
            return (Long)factory.getCurrentSession().save(notebook);
        }

    @Override
    public Notebook read(Long id)  {
        return (Notebook)factory.getCurrentSession().get(Notebook.class, id);
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
        List<Notebook>list;
        list =factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Notebook").list();
        return list;
    }
}
