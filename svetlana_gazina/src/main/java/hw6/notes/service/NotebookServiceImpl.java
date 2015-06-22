package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
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

    @Override
    public void changePrice(Long id, double price) {
        NotebookDaoImpl ndDao = new NotebookDaoImpl(factory);
        Notebook notebook = ndDao.read(id);
        notebook.setPrice(BigDecimal.valueOf(price));
        ndDao.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        NotebookDaoImpl ndDao = new NotebookDaoImpl(factory);
        Notebook notebook = ndDao.read(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        ndDao.update(notebook);

    }

    @Override
    public boolean delete(Long id) {
        NotebookDaoImpl ndDao = new NotebookDaoImpl(factory);
        return ndDao.delete(ndDao.read(id));
    }
}
