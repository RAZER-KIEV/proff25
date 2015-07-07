package hw7.springnotes.service;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by just1ce on 29.06.2015.
 */
@Component
@Transactional
public class NotebookServiceImpl implements hw7.springnotes.service.NotebookService {
    @Autowired(required = true)
    public hw7.springnotes.dao.NotebookDaoImpl notebook;
    @Autowired(required = true)
    public hw7.springnotes.dao.VendorDaoImpl vendor;
    @Autowired(required = true)
    public hw7.springnotes.dao.CPUDaoImpl cpu;
    @Autowired(required = true)
    public hw7.springnotes.dao.MemoryDaoImpl memory;
    @Autowired(required = true)
    public hw7.springnotes.dao.StoreDaoImpl store;
    @Autowired(required = true)
    public hw7.springnotes.dao.SalesDaoImpl sales;


    public NotebookServiceImpl(){
    }
    public NotebookServiceImpl(SessionFactory sessionFactory){
        notebook = new hw7.springnotes.dao.NotebookDaoImpl();
        vendor = new hw7.springnotes.dao.VendorDaoImpl();
        cpu = new hw7.springnotes.dao.CPUDaoImpl();
        memory = new hw7.springnotes.dao.MemoryDaoImpl();
        store = new hw7.springnotes.dao.StoreDaoImpl();
        sales = new hw7.springnotes.dao.SalesDaoImpl();
    }
    @Transactional
    @Override
    public Long receive(Long id, int amount, double price) {
        hw7.springnotes.domain.Notebook ntbk = notebook.read(id);
        return store.create(new hw7.springnotes.domain.Store(ntbk, (long) amount,price));
    }
    @Transactional
    @Override
    public Long sale(Long storeId, int amount) {
        hw7.springnotes.domain.Store store = this.store.read(storeId);
        store.setCount(store.getCount() - amount);
        this.store.update(store);
        return sales.create(new hw7.springnotes.domain.Sales(store, new Date(Calendar.getInstance().getTimeInMillis()),(long)amount));
    }
    @Transactional
    @Override
    public boolean updateCPU(hw7.springnotes.domain.CPU cpu) {
        return this.cpu.update(cpu);
    }
    @Transactional
    @Override
    public boolean updateMemory(hw7.springnotes.domain.Memory memory) {
        return this.memory.update(memory);
    }
    @Transactional
    @Override
    public boolean updateVendor(hw7.springnotes.domain.Vendor vendor) {
        return this.vendor.update(vendor);
    }
    @Transactional
    @Override
    public boolean updateNotebook(hw7.springnotes.domain.Notebook notebook) {
        return this.notebook.update(notebook);
    }
    @Transactional
    @Override
    public boolean removeFromStore(hw7.springnotes.domain.Store store, int amount) {
        long new_count = store.getCount();
        store.setCount(new_count);
        return this.store.update(store);
    }
    @Transactional(readOnly = true)
    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksByPortion(int size) {
        return store.getNotesByPorces(size);
    }
    @Transactional(readOnly = true)
    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksGtAmount(int amount) {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksByCpuVendor(hw7.springnotes.domain.Vendor cpuVendor) {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksFromStore() {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public List<hw7.springnotes.domain.Notebook> getNotebooksStorePresent() {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public Map<hw7.springnotes.domain.Notebook, Integer> getSalesByDays() {
        return null;
    }
}
