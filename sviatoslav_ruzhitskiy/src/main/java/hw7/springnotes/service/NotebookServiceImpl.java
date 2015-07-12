package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ПК on 25.06.2015.
 */
@Service
@Transactional
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private SessionFactory factory;
    @Autowired
    private NotebookDaoImpl notebookDao;
    @Autowired
    private CPUDaoImpl cpuDao;
    @Autowired
    private MemoryDaoImpl memoryDao;
    @Autowired
    private VendorDaoImpl vendorDao;
    @Autowired
    private StoreDaoImpl storeDao;
    @Autowired
    private SalesDaoImpl salesDao;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public NotebookDaoImpl getNotebookDao() {
        return notebookDao;
    }

    public void setNotebookDao(NotebookDaoImpl notebookDao) {
        this.notebookDao = notebookDao;
    }

    public CPUDaoImpl getCpuDao() {
        return cpuDao;
    }

    public void setCpuDao(CPUDaoImpl cpuDao) {
        this.cpuDao = cpuDao;
    }

    public MemoryDaoImpl getMemoryDao() {
        return memoryDao;
    }

    public void setMemoryDao(MemoryDaoImpl memoryDao) {
        this.memoryDao = memoryDao;
    }

    public VendorDaoImpl getVendorDao() {
        return vendorDao;
    }

    public void setVendorDao(VendorDaoImpl vendorDao) {
        this.vendorDao = vendorDao;
    }

    public StoreDaoImpl getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(StoreDaoImpl storeDao) {
        this.storeDao = storeDao;
    }

    public SalesDaoImpl getSalesDao() {
        return salesDao;
    }

    public void setSalesDao(SalesDaoImpl salesDao) {
        this.salesDao = salesDao;
    }

    public NotebookServiceImpl(){


     }

     public Date dateSet(int year, int month, int day) {
         Calendar cal = Calendar.getInstance();
         cal.set(year, month, day);
         Date date = cal.getTime();
         return date;
     }
    @Override
    public Long receive(Long id, int amount, double price){
        Notebook notebook = notebookDao.read(id);
        Store store = new Store(notebook,amount,price);
        Long id2 = storeDao.create(store);
        return id2;
    }
    @Override
    public Long sale(Long storeId, int amount){
        Store store = storeDao.read(storeId);
        Integer curAmount = store.getQuantity();
        Integer newAmount = curAmount-amount;
        store.setQuantity(newAmount);

        Sales nwSale= new Sales(store,new Date(),amount);
        Long id = salesDao.create(nwSale);

        return id;
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

        Integer newQuant = store.getQuantity()-amount;
        store.setQuantity(newQuant);
        return storeDao.update(store);
    }

    @Override
    public List getNotebooksByPortion(int size) {
        return storeDao.getNotebooksByPortion(size);
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
    public List getNotebooksStorePresent() {
        return storeDao.getNotebooksStorePresent();
    }

    @Override
    public Map getSalesByDays() { return salesDao.getSalesByDays(); }


}
