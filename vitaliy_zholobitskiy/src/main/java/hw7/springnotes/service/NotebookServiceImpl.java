package hw7.springnotes.service;


import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by just1ce on 29.06.2015.
 */
public class NotebookServiceImpl implements hw7.springnotes.service.NotebookService {
    private SessionFactory factory;


    private hw7.springnotes.dao.NotebookDaoImpl notebook;
    private hw7.springnotes.dao.VendorDaoImpl vendor;
    private hw7.springnotes.dao.CPUDaoImpl cpu;
    private hw7.springnotes.dao.MemoryDaoImpl memory;
    private hw7.springnotes.dao.StoreDaoImpl store;
    private hw7.springnotes.dao.SalesDaoImpl sales;


    public NotebookServiceImpl(){
    }
    public NotebookServiceImpl(SessionFactory sessionFactory){
        this.factory = sessionFactory;
        notebook = new hw7.springnotes.dao.NotebookDaoImpl(factory);
        vendor = new hw7.springnotes.dao.VendorDaoImpl(factory);
        cpu = new hw7.springnotes.dao.CPUDaoImpl(factory);
        memory = new hw7.springnotes.dao.MemoryDaoImpl(factory);
        store = new hw7.springnotes.dao.StoreDaoImpl(factory);
        sales = new hw7.springnotes.dao.SalesDaoImpl(factory);
    }
    @Override
    public Long receive(Long id, int amount, double price) {
        hw7.springnotes.domain.Notebook ntbk = notebook.read(id);
        return store.create(new hw7.springnotes.domain.Store(ntbk, (long) amount,price));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        hw7.springnotes.domain.Store store = this.store.read(storeId);
        store.setCount(store.getCount() - amount);
        this.store.update(store);
        return sales.create(new hw7.springnotes.domain.Sales(store, new Date(Calendar.getInstance().getTimeInMillis()),(long)amount));
    }

    @Override
    public boolean updateCPU(hw7.springnotes.domain.CPU cpu) {
        return this.cpu.update(cpu);
    }

    @Override
    public boolean updateMemory(hw7.springnotes.domain.Memory memory) {
        return this.memory.update(memory);
    }

    @Override
    public boolean updateVendor(hw7.springnotes.domain.Vendor vendor) {
        return this.vendor.update(vendor);
    }

    @Override
    public boolean updateNotebook(hw7.springnotes.domain.Notebook notebook) {
        return this.notebook.update(notebook);
    }

    @Override
    public boolean removeFromStore(hw7.springnotes.domain.Store store, int amount) {
        long new_count = store.getCount();
        store.setCount(new_count);
        return this.store.update(store);
    }

    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksByPortion(int size) {
        return store.getNotesByPorces(size);
    }

    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksByCpuVendor(hw7.springnotes.domain.Vendor cpuVendor) {
        return null;
    }

    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksFromStore() {
        return null;
    }

    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksStorePresent() {
        return null;
    }

    @Override
    public Map<hw7.springnotes.domain.Notebook, Integer> getSalesByDays() {
        return null;
    }
}
