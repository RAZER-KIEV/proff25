package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
/*4. Добавить в приложение ноутбуков следующие функции:
Показать все ноутбуки на складе (пользователь указывает размер порции)
Показать все ноутбуки которых больше указанного количества
Показать все ноутбуки по указанному имени производителя процессора
Показать все ноутбуки на складе
Показать типы ноутбуков, оставшиеся на складе по каждому производителю
Получить объем продаж ноутбуков в среднем за день (в штуках)*/
    @Override
    public List getNotebooksByPortion(int size) {
        StoreDaoImpl storeDao= new StoreDaoImpl(factory);
        return storeDao.getNotebooksByPortion(size);
    }
    @Override
    public List getNotebooksGtAmount(int amount) {
        StoreDaoImpl storeDao= new StoreDaoImpl(factory);
        return storeDao.getNotebooksGtAmount(amount);
    }
    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        StoreDaoImpl storeDao= new StoreDaoImpl(factory);
        return storeDao.getNotebooksByCpuVendor(cpuVendor);
    }
    @Override
    public List getNotebooksFromStore() {
        StoreDaoImpl storeDao= new StoreDaoImpl(factory);
        return storeDao.getNotebooksFromStore();
    }
    @Override
    public Map getNotebooksStorePresent() {
        StoreDaoImpl storeDao= new StoreDaoImpl(factory);
        return storeDao.getNotebooksStorePresent();
    }
    @Override
    public Map getSalesByDays() {
        SalesDaoImpl saleDao= new SalesDaoImpl(factory);
        return saleDao.getSalesByDays();
    }
}
