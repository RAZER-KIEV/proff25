package hw6.notes.service;

import hw6.notes.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by GFalcon on 18.06.15.
 */
public class NotebookServiceImpl implements NotebookService {
    private HibernateUtil hibUtil;
    private SessionFactory session;

    public NotebookServiceImpl(){
        hibUtil = new HibernateUtil();
    }

    @Override
    public Long add(Notebook notebook) {
        session = hibUtil.create();
        Long id = new NotebookDaoImpl(session).create(notebook);
        hibUtil.close(session);
        return id;
    }

    @Override
    public List findAll() {
        session = hibUtil.create();
        List<Notebook> notebookList = new NotebookDaoImpl(session).findAll();
        hibUtil.close(session);
        return notebookList;
    }
}
