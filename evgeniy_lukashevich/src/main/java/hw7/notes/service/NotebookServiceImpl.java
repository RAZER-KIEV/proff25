package hw7.notes.service;

import hw6.notes.util.HibernateUtil;
import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    @Override
    public Long receive(Notebook note, int amount, double price) {
        Store store = new Store(note, amount, price);
        SessionFactory factory = HibernateUtil.connect();
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        Long id = storeDao.create(store);
        HibernateUtil.closeFactory();
        return id;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Date date = Calendar.getInstance().getTime();
        SessionFactory factory = HibernateUtil.connect();
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        SalesDaoImpl salesDao = new SalesDaoImpl(factory);
        Store store = storeDao.read(storeId);
        Sales sales = new Sales(date, amount, store);
        Long id = salesDao.create(sales);
        store.setQuantity(store.getQuantity() - amount);
        storeDao.update(store);
        HibernateUtil.closeFactory();
        return id;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        SessionFactory factory = HibernateUtil.connect();
        CPUDaoImpl cpuDao = new CPUDaoImpl(factory);
        boolean result = cpuDao.update(cpu);
        HibernateUtil.closeFactory();
        return result;
    }

    @Override
    public boolean updateMemory(Memory memory) {
        SessionFactory factory = HibernateUtil.connect();
        MemoryDaoImpl memoryDao = new MemoryDaoImpl(factory);
        boolean result = memoryDao.update(memory);
        HibernateUtil.closeFactory();
        return result;
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        SessionFactory factory = HibernateUtil.connect();
        VendorDaoImpl venorDao = new VendorDaoImpl(factory);
        boolean result = venorDao.update(vendor);
        HibernateUtil.closeFactory();
        return result;
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        SessionFactory factory = HibernateUtil.connect();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        boolean result = notebookDao.update(notebook);
        HibernateUtil.closeFactory();
        return result;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        SessionFactory factory = HibernateUtil.connect();
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        store.setQuantity(store.getQuantity() - amount);
        boolean result = storeDao.update(store);
        HibernateUtil.closeFactory();
        return result;
    }

    @Override
    public List getNotebooksByPortion(int size) {
        return null;
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Override
    public List getNotebooksFromStore() {
        return null;
    }

    @Override
    public List getNotebooksStorePresent() {
        return null;
    }

    @Override
    public Map getSalesByDays() {
        return null;
    }
}
