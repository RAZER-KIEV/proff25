package hw7.notes.service;

import hw7.notes.dao.SalesDao;
import hw7.notes.dao.SalesDaoImpl;
import hw7.notes.dao.StoreDaoImpl;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Store;
import hw7.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * Created by Роман on 26.06.2015.
 * Создать приложение магазин ноутбуков со следующими функциями:
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)
 */
public class NotebookServiceImpl implements NotebookService {

    @Override
    public Long receive(Notebook note, int amount, double price) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Store store = new Store(note, amount, price);
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        Long result = storeDao.create(store);
        return result;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        Store store = storeDao.read(storeId);
        int balance = store.getNotebooksQuantity() - amount;
        if(balance <= 0) {
            store.setNotebooksQuantity(0);
        } else {
            store.setNotebooksQuantity(balance);
        }
        storeDao.update(store);
        SalesDaoImpl salesDao = new SalesDaoImpl(factory);
        Long result = salesDao.create(new Sales(store, new Date(System.currentTimeMillis()), amount));
        return result;
    }
}
