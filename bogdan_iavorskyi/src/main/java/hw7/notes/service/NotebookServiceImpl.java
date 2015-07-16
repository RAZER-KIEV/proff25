package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import java.util.List;

public class NotebookServiceImpl implements NotebookService {

    private static Logger log = Logger.getLogger(NotebookServiceImpl.class);
    
    private VendorDao vendorDao;
    private CPUDao cpuDao;
    private MemoryDao memoryDao;
    private NotebookDao notebookDao;
    private StoreDao storeDao;
    private SalesDao salesDao;

    public NotebookServiceImpl() {

    }

    public NotebookServiceImpl(VendorDao vendorDao, CPUDao cpuDao, MemoryDao memoryDao,
                               NotebookDao notebookDao, StoreDao storeDao, SalesDao salesDao) {
        this.vendorDao = vendorDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.notebookDao = notebookDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
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
    public Long createNotebook(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public CPU getCPU(Long id) {
        return cpuDao.read(id);
    }

    @Override
    public Memory getMemory(Long id) {
        return memoryDao.read(id);
    }

    @Override
    public Vendor getVendor(Long id) {
        return vendorDao.read(id);
    }

    @Override
    public Notebook getNotebook(Long id) {
        return notebookDao.read(id);
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
    public Long receive(Notebook note, int amount, int price) {
        Store lot = new Store(note, price, amount);
        return storeDao.create(lot);
    }

    @Override
    public Long sale(Long storeId, int amount) {
        return null;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        return false;
    }

    @Override
    public List getAllVendorNames() {
        return vendorDao.findAllNames();
    }

    @Override
    public List listAllVendors() {
        return vendorDao.findAll();
    }

    @Override
    public List listAllCPUs() {
        return cpuDao.findAll();
    }

    @Override
    public List listAllMemories() {
        return memoryDao.findAll();
    }

    @Override
    public List listAllNotebooks() {
        return notebookDao.findAll();
    }

    @Override
    public List listAllStores() {
        return storeDao.findAll();
    }

    @Override
    public List listAllSales() {
        return salesDao.findAll();
    }

}
