package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Store;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Well on 03.07.2015.
 */
public class NotebookServiceImpl implements NotebookService {

         public NotebookServiceImpl() {
             NotebookDao ntbd = new NotebookDaoImpl();
             CPUDao cpud = new CPUDaoImpl();
             MemoryDao memd = new MemoryDaoImpl();
             VendorDao vend = new VendorDaoImpl();
//             StoreDao strd = new StoreDaoImpl(factory);
//             SalesDao slsd = new SalesDaoImpl(factory);
    }


    @Override
    public Long receive(Long ntbId, int amount, double price) {

            StoreDaoImpl sdi = new StoreDaoImpl();
            NotebookDaoImpl ndi = new NotebookDaoImpl();
            Notebook notebook = ndi.read(ntbId);
            return sdi.create(new Store(price, amount, notebook));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        StoreDao strd = new StoreDaoImpl();
        Store store = strd.read(storeId);
        if (store.getQuantity()<amount) {
            return -1L;
        }
        store.setQuantity(store.getQuantity()-amount);
        strd.update(store);

        Sales sale = new Sales( LocalDate.now(), amount, store);

        return sale.getSalesId();
    }
}
