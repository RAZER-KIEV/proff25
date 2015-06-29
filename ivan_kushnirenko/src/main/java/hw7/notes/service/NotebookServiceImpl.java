package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.HibernateException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan on 24.06.15.
 */
public class NotebookServiceImpl implements NotebookService {

    @Override
    public Long receive(Long id, int amount, double price) {
        if (id == null || amount == 0 || price == 0) {
            System.out.println("ERROR: can not receive notebooks, input parameters must be non null.");
            return null;
        }
        StoreDaoImpl storeDao = new StoreDaoImpl();
        Notebook tmp = null;
        try {
            tmp = new NotebookDaoImpl().read(id);
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("ERROR: there is no such notebooks with id: " + id + ".");
        }
        return storeDao.create(new Store(tmp, amount, price));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        if (storeId == null || amount == 0) {
            System.out.println("ERROR: Invalid input parameters, storeId must be non null and positive, " +
                    "amount must be positive.");
            return null;
        }
        Store store = new StoreDaoImpl().read(storeId);
        if (store.getCount() < amount) {
            System.out.println("ERROR: there are only " + store.getCount() + " notebooks here.");
            return null;
        }
        store.setCount(store.getCount() - amount);
        new StoreDaoImpl().update(store);
        return new SalesDaoImpl().create(new Sales(store, new Date(), amount));
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return new CPUDaoImpl().update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return new MemoryDaoImpl().update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return new VendorDaoImpl().update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return new NotebookDaoImpl().update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        StoreDaoImpl storeDao = new StoreDaoImpl();
        store = storeDao.read(store.getId());
        if (store.getCount() < amount) {
            System.out.println("ERROR: there are only " + store.getCount() + " notebooks.");
            return false;
        }
        store.setCount(store.getCount() - amount);
        return storeDao.update(store);
    }

    @Override
    public List getNotebooksByPortion(int size) {
        return new NotebookDaoImpl().getPortionOfNotebooks(size);
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        return new StoreDaoImpl().getNotebooksGtAmount(amount);
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return new NotebookDaoImpl().getNotebooksByCpuVendor(cpuVendor);
    }

    @Override
    public List getNotebooksFromStore() {
        return new StoreDaoImpl().getNotebooksFromStore();
    }

    @Override
    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        return new NotebookDaoImpl().getNotebooksStorePresent();
    }

    @Override
    public Map getSalesByDays() {
        return null;
    }

    public static void main(String[] args) {

    }
}
