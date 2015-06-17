package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by oleg on 17.06.15.
 */
public class NotebookServiceImpl implements NotebookService {

    private SessionFactory factory;
    NotebookDaoImpl dao;

    public NotebookServiceImpl() {
        dao = new NotebookDaoImpl();
        factory = dao.getFactory();
    }

    @Override
    public Long add(Notebook notebook) {
        return dao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return dao.findAll();
    }
}
