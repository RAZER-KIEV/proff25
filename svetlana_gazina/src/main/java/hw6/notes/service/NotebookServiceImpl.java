package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Sveta on 6/21/2015.
 * - Добавить новый ноутбук
 - Показать список ноутбуков (включая порядковый номер id)
 *
 */
public class NotebookServiceImpl implements NotebookService{
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long add(Notebook notebook) {
        NotebookDaoImpl ndDao = new NotebookDaoImpl(factory);

        return ndDao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        NotebookDaoImpl ndDao = new NotebookDaoImpl();
        List<Notebook> notebooks = ndDao.findAll();
        return notebooks;
    }
}
