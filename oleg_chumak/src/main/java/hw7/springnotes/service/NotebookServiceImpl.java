package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by oleg on 24.06.15.
 */

@Component
@Transactional
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    public NotebookDaoImpl notebookDao;
    @Autowired
    public VendorDaoImpl vendorDao;
    @Autowired
    public CPUDaoImpl cpuDao;
    @Autowired
    public MemoryDaoImpl memoryDao;
    @Autowired
    public StoreDaoImpl storeDao;
    @Autowired
    public SalesDaoImpl salesDao;

    public NotebookServiceImpl(NotebookDaoImpl notebookDao, VendorDaoImpl vendorDao, CPUDaoImpl cpuDao, MemoryDaoImpl memoryDao, StoreDaoImpl storeDao, SalesDaoImpl salesDao) {
        this.notebookDao = notebookDao;
        this.vendorDao = vendorDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }

    public NotebookServiceImpl() {
        notebookDao = new NotebookDaoImpl();
        vendorDao = new VendorDaoImpl();
        cpuDao = new CPUDaoImpl();
        memoryDao = new MemoryDaoImpl();
        storeDao = new StoreDaoImpl();
        salesDao = new SalesDaoImpl();
    }

    @Override
    public List getNotebooksByPortion(int size) {
        return storeDao.getNotesPorced(0,size);
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        return storeDao.getNotebooksGtAmount(amount);
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return storeDao.getNotebooksByCpuVendor(cpuVendor);
    }

    @Override
    public List getNotebooksFromStore() {
        return storeDao.getNotebooksFromStore();
    }

    @Override
    public Map getNotebooksStorePresent() {
        return storeDao.getNotebooksStorePresent();
    }


    @Override
    public Map getSalesByDays() {
        return salesDao.getSalesByDays();
    }

    @Override
    public Long receive(Notebook note, int amount, double price) {
        return storeDao.create(new Store(note, new Long(amount), new Long((int)price)));
    }

    @Override
    public Long receive(Long id, int amount, double price) {
        return storeDao.create(new Store(notebookDao.read(id), new Long(amount), new Long((int)price)));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store currentStore = storeDao.read(storeId);
        Long tmp;
        if (currentStore.getAmount() < new Long(amount)){
            System.out.println("not enough such notes");
            tmp =  new Long(-1);
        } else if (currentStore.getAmount() == new Long(amount) ) {
            tmp = salesDao.create(new Sales(currentStore, new Date(114,10,5), new Long(amount)));
            currentStore.setAmount(new Long(0));
            storeDao.update(currentStore);
        } else {
            tmp = salesDao.create(new Sales(currentStore, new Date(114,10,5), new Long(amount)));
            currentStore.setAmount((currentStore.getAmount() - new Long(amount)));
            storeDao.update(currentStore);
        }
        return tmp;
    }

    @Override
    public Long createCPU(CPU cpu) {
        return cpuDao.create(cpu);
    }

    @Override
    public Long createMemory(Memory memory) {
        return memoryDao.create(memory);
    }

    @Override
    public Long createVendor(Vendor vendor) {
        return vendorDao.create(vendor);
    }

    @Override
    public Long createNote(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        store.setAmount(store.getAmount() - new Long(amount));
        return storeDao.update(store);
    }
}
