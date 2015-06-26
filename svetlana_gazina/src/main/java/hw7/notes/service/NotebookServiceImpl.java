package hw7.notes.service;

import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.dao.StoreDaoImpl;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

/**
 * Created by Sveta on 6/26/2015.
 */
public class NotebookServiceImpl implements NotebookService {
    private SessionFactory factory;

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        StoreDaoImpl storeDao = new StoreDaoImpl();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl();
        Notebook note = notebookDao.read(noteId);
       return storeDao.create(new Store(note.getVendor(), new BigDecimal(price), amount));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        StoreDaoImpl storeDao = new StoreDaoImpl();
        Store store = storeDao.read(storeId);
        int am = store.getAmount();
        store.setAmount(am - amount);
        storeDao.update(store);
        return storeId;
    }
}
