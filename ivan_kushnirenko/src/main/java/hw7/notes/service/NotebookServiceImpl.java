package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.HibernateException;

import java.util.Date;

/**
 * Created by ivan on 24.06.15.
 */
public class NotebookServiceImpl implements NotebookService {

    @Override
    public Long receive(Notebook note, int amount, double price) {
        if (note == null || amount == 0 || price == 0) {
            System.out.println("ERROR: can not receive notebooks, input parameters must be non null.");
            return null;
        }
        StoreDaoImpl storeDao = new StoreDaoImpl();
        Notebook tmp = null;
        try {
            tmp = new NotebookDaoImpl().read(note.getId());
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("ERROR: there is no such notebooks: " + note + ".");
        }
        return storeDao.create(new Store(tmp, amount, price));
    }

/*
Store store = storeDao.read(storeId);
        if (store.getCount()<amount) {
            return -1L;
        }
        store.setCount(store.getCount()-amount);
        storeDao.update(store);
        return salesDao.create(new Sales(store, new Date(Calendar.getInstance().getTimeInMillis()),(long)amount));
 */


    @Override
    public Long sale(Long storeId, int amount) {
        if (storeId == null || amount == 0) {
            System.out.println("ERROR: Invalid input parameters, storeId must be non null and positive, " +
                    "amount must be positive.");
            return null;
        }
        Store store = new StoreDaoImpl().read(storeId);
        if (store.getCount() < amount) {
            System.out.println("ERROR: there are only "+store.getCount()+" notebooks here.");
            return null;
        }
        store.setCount(store.getCount()-amount);
        new StoreDaoImpl().update(store);
        return new SalesDaoImpl().create(new Sales(store,new Date(),amount));
    }

    public static void main(String[] args) {
//        Vendor vr = new Vendor("HP_shop");
//        VendorDaoImpl vendorDao = new VendorDaoImpl();
//        vendorDao.create(vr);

//        CPU cpu = new CPU("Intell", 2.46, "i5");
//        CPUDaoImpl cpuDao = new CPUDaoImpl();
//        cpuDao.create(cpu);

//        Memory memory = new Memory("Kingston", 8196);
//        MemoryDaoImpl memoryDao = new MemoryDaoImpl();
//        memoryDao.create(memory);

//        Notebook ntb = new Notebook(new VendorDaoImpl().read(2L), "hp", new Date(115, 6, 24), new CPUDaoImpl().read(3L), new MemoryDaoImpl().read(4L));
//        NotebookDaoImpl notebookDaoImpl = new NotebookDaoImpl();
//        notebookDaoImpl.create(ntb);

//        Notebook ntb = new Notebook();
//        ntb.setId(6L);
//        new NotebookServiceImpl().receive(ntb, 10, 674.12);

//        new NotebookServiceImpl().sale(7L,3);
    }
}
