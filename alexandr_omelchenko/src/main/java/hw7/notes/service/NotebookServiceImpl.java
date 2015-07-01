package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.Date;

public class NotebookServiceImpl implements NotebookService {
    private SessionFactory factory;
    public SessionFactory getFactory() {
        return factory;
    }
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public NotebookServiceImpl() {
    }
    public NotebookServiceImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU processor) {
        CPUDaoImpl cpuDao = new CPUDaoImpl(factory);
        return cpuDao.create(processor);
    }
    @Override
    public Long create(Memory memory) {
        MemoryDaoImpl memDao = new MemoryDaoImpl(factory);
        return memDao.create(memory);
    }
    @Override
    public Long create(Vendor vendor) {
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        return vendorDao.create(vendor);
    }
    @Override
    public Long create(Notebook notebook) {
        NotebookDaoImpl nbDao = new NotebookDaoImpl(factory);
        return nbDao.create(notebook);
    }
    @Override
    public Long create(Store store) {
        StoreDaoImpl nbDao = new StoreDaoImpl(factory);
        return nbDao.create(store);
    }
    @Override
    public Long create(Sales sale) {
        SalesDaoImpl nbDao = new SalesDaoImpl(factory);
        return nbDao.create(sale);
    }
    @Override
    public Long receive(Long id, int amount, double price) {
        NotebookDaoImpl nbDao = new NotebookDaoImpl(factory);
        Notebook note = nbDao.read(id);
        StoreDaoImpl storDao = new StoreDaoImpl(factory);
        return storDao.create( new Store(amount, price, note));
    }
    @Override
    public Long sale(Long storeId, int amount) {
        StoreDaoImpl storDao = new StoreDaoImpl(factory);
        Store store=storDao.read(storeId);
        store.setCount(store.getCount()-amount);
        storDao.update(store);
        SalesDaoImpl saleDao = new SalesDaoImpl(factory);
        return saleDao.create(new Sales(new Date(), amount, store));
    }
    @Override
    public boolean updateCPU(CPU cpu) {
        CPUDaoImpl cpuDao= new CPUDaoImpl(factory);
        return cpuDao.update(cpu);
    }
    @Override
    public boolean updateMemory(Memory memory) {
        MemoryDaoImpl ramDao= new MemoryDaoImpl(factory);
        return ramDao.update(memory);
    }
    @Override
    public boolean updateVendor(Vendor vendor) {
        VendorDaoImpl ramDao= new VendorDaoImpl(factory);
        return ramDao.update(vendor);
    }
    @Override
    public boolean updateNotebook(Notebook notebook) {
        NotebookDaoImpl nbDao= new NotebookDaoImpl(factory);
        return nbDao.update(notebook);
    }
    @Override
    public boolean removeFromStore(Store store, int amount) {
        StoreDaoImpl storeDao= new StoreDaoImpl(factory);
        store.setCount(store.getCount()-amount);
        return storeDao.update(store);
    }
}
