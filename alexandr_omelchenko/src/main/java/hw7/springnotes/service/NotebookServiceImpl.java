package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private VendorDaoImpl vendorDao;
    @Autowired
    private MemoryDaoImpl ramDao;
    @Autowired
    private CPUDaoImpl cpuDao;
    @Autowired
    private NotebookDaoImpl noteDao;
    @Autowired
    private StoreDaoImpl storeDao;
    @Autowired
    private SalesDaoImpl salesDao;

    public NotebookServiceImpl() {
    }
    public NotebookServiceImpl(VendorDaoImpl vendorDao, MemoryDaoImpl ramDao, CPUDaoImpl cpuDao, NotebookDaoImpl noteDao, StoreDaoImpl storeDao, SalesDaoImpl salesDao) {
        this.vendorDao = vendorDao;
        this.ramDao = ramDao;
        this.cpuDao = cpuDao;
        this.noteDao = noteDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }
    @Override
    public boolean updateMemory(Memory memory) {
        return ramDao.update(memory);
    }
    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }
    @Override
    public boolean updateNotebook(Notebook notebook) {
        return noteDao.update(notebook);
    }
    @Override
    public boolean removeFromStore(Store store, int amount) {
        store.setCount(store.getCount()-amount);
        return true;
    }
    @Transactional(readOnly = true)
    @Override
    public List getNotebooksByPortion(int size) {
        return storeDao.getNotebooksByPortion(size);
    }
    @Transactional(readOnly = true)
    @Override
    public List getNotebooksGtAmount(int amount) {
        return storeDao.getNotebooksGtAmount(amount);
    }
    @Transactional(readOnly = true)
    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return storeDao.getNotebooksByCpuVendor(cpuVendor);
    }
    @Transactional(readOnly = true)
    @Override
    public List getNotebooksFromStore() {
        return storeDao.getNotebooksFromStore();
    }
    @Transactional(readOnly = true)
    @Override
    public Map getNotebooksStorePresent() {
        return storeDao.getNotebooksStorePresent();
    }
    @Transactional(readOnly = true)
    @Override
    public Map getSalesByDays() {
        return salesDao.getSalesByDays();
    }
    //@Transactional(readOnly = true)
    @Override
    public Long receive(Long id, int amount, double price) {
        Notebook nb =noteDao.read(id);
        return storeDao.create(new Store(amount, price, nb));
    }
    @Override
    public Long sale(Long storeId, int amount) {
        Store store=storeDao.read(storeId);
        store.setCount(store.getCount()-amount);
        storeDao.update(store);
        return salesDao.create(new Sales(new Date(), amount, store));
    }
}