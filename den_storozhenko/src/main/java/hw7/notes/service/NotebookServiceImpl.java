package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.*;


public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl notebookDao;
    private VendorDaoImpl vendorDao;
    private CPUDaoImpl cpuDao;
    private MemoryDaoImpl memoryDao;
    private StoreDaoImpl storeDao;
    private SalesDaoImpl salesDao;

    public NotebookServiceImpl(){

    }

    public NotebookServiceImpl(NotebookDaoImpl notebookDao, VendorDaoImpl vendorDao, CPUDaoImpl cpuDao, MemoryDaoImpl memoryDao, StoreDaoImpl storeDao, SalesDaoImpl salesDao) {
        this.notebookDao = notebookDao;
        this.vendorDao = vendorDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }

    public void deleteAll(){
        for (Notebook notebook:notebookDao.findAll())
            notebookDao.delete(notebook);
        for (Vendor vendor:vendorDao.findAll())
            vendorDao.delete(vendor);
        for (CPU cpu:cpuDao.findAll())
            cpuDao.delete(cpu);
        for (Memory memory:memoryDao.findAll())
            memoryDao.delete(memory);
        for (Store store:storeDao.findAll())
            storeDao.delete(store);
        for (Sales sales:salesDao.findAll())
            salesDao.delete(sales);
    }

    @Override
    public Long receive(Long id, int amount, double price) {
        Notebook note = notebookDao.read(id);
        return storeDao.create(new Store(note, (long) amount,price));
    }

    public Vendor getVendorById(Long id){
        return vendorDao.read(id);
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        if (store.getCount()<amount) {
            return -1L;
        }
        store.setCount(store.getCount()-amount);
        storeDao.update(store);
        return salesDao.create(new Sales(store, new Date(Calendar.getInstance().getTimeInMillis()),(long)amount));
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
        store.setCount(store.getCount() - amount);
        return storeDao.update(store);
    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return storeDao.getNotebooksByPortion(size);
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return storeDao.getNotebooksGtAmount(amount);
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return storeDao.getNotebooksByCpuVendor(cpuVendor);
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return storeDao.getNotebooksFromStore();
    }

    @Override
    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        return storeDao.getNotebooksStorePresent();
     }

    @Override
    public Map<Date, Double> getSalesByDays() {
        return salesDao.getSalesByDays();
    }

}
