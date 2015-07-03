package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class NotebookDaoImpl implements NotebookDao {
    private static final int STEP_PORCED =10;
    @Autowired
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
        return (Long)factory.getCurrentSession().save(notebook);
    }

    @Override
    public Notebook read(Long id) {
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

    public Long getCount(){
        return (Long)factory.getCurrentSession().createQuery("select COUNT(n.id) from Notebook n").uniqueResult();
    }

    @Override
    public List<Notebook> getNotebooksPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("from Notebook");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
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
