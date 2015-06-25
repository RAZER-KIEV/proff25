package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by oleg on 24.06.15.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookDaoImpl notebookDao;
    private VendorDaoImpl vendorDao;
    private CPUDaoImpl cpuDao;
    private MemoryDaoImpl memoryDao;
    private StoreDaoImpl storeDao;
    private SalesDaoImpl salesDao;

    public NotebookServiceImpl(NotebookDaoImpl notebookDao, VendorDaoImpl vendorDao, CPUDaoImpl cpuDao, MemoryDaoImpl memoryDao, StoreDaoImpl storeDao, SalesDaoImpl salesDao) {
        this.notebookDao = notebookDao;
        this.vendorDao = vendorDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }

    public NotebookServiceImpl() {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        notebookDao = new NotebookDaoImpl(factory);
        vendorDao = new VendorDaoImpl(factory);
        cpuDao = new CPUDaoImpl(factory);
        memoryDao = new MemoryDaoImpl(factory);
        storeDao = new StoreDaoImpl(factory);
        salesDao = new SalesDaoImpl(factory);
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

    @Override
    public Long receive(Notebook note, int amount, double price) {
        return storeDao.create(new Store(note, new Long(amount), new Long((int)price)));
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
}
