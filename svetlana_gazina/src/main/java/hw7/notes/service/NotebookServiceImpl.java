package hw7.notes.service;

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
    public Long receive(Notebook note, int amount, double price) {
        StoreDaoImpl storeDao = new StoreDaoImpl();
       return storeDao.create(new Store(note.getVendor(), new BigDecimal(price), amount));
    }

    @Override
    public boolean sale(Long storeId, int amount) {
        StoreDaoImpl storeDao = new StoreDaoImpl();
        Store store = storeDao.read(storeId);
        int am = store.getAmount();
        store.setAmount(am - amount);
        return storeDao.update(store);
    }
}
