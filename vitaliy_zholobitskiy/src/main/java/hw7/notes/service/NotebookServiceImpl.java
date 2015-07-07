package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by just1ce on 29.06.2015.
 */
public class NotebookServiceImpl implements NotebookService{
    private SessionFactory factory;


    private NotebookDaoImpl notebook;
    private VendorDaoImpl vendor;
    private CPUDaoImpl cpu;
    private MemoryDaoImpl memory;
    private StoreDaoImpl store;
    private SalesDaoImpl sales;


    public NotebookServiceImpl(){
    }
    public NotebookServiceImpl(SessionFactory sessionFactory){
        this.factory = sessionFactory;
        notebook = new NotebookDaoImpl(factory);
        vendor = new VendorDaoImpl(factory);
        cpu = new CPUDaoImpl(factory);
        memory = new MemoryDaoImpl(factory);
        store = new StoreDaoImpl(factory);
        sales = new SalesDaoImpl(factory);
    }
    @Override
    public Long receive(Long id, int amount, double price) {
        Notebook ntbk = notebook.read(id);
        return store.create(new Store(ntbk, (long) amount,price));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = this.store.read(storeId);
        store.setCount(store.getCount() - amount);
        this.store.update(store);
        return sales.create(new Sales(store, new Date(Calendar.getInstance().getTimeInMillis()),(long)amount));
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return this.cpu.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return this.memory.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return this.vendor.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return this.notebook.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        long new_count = store.getCount();
        store.setCount(new_count);
        return this.store.update(store);
    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return store.getNotesByPorces(size);
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksStorePresent() {
        return null;
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        return null;
    }
}
