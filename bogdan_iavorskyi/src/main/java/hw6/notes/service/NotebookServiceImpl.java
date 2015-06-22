package hw6.notes.service;

//Created on 18.06.15.

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class NotebookServiceImpl implements NotebookService {

    private NotebookDao dao;
    private SessionFactory factory;

    public NotebookServiceImpl() {
        factory = HibernateUtil.getSessionFactory();
        dao = new NotebookDaoImpl(factory);
    }

    @Override
    public Long add(Notebook notebook) {
        return dao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return dao.findAll();
    }

    @Override
    public void closeFactory() {
        if (factory != null && !factory.isClosed()) {
            factory.close();
        }
    }
}
