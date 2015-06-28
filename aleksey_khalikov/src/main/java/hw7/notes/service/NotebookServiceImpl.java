package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import hw7.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by GFalcon on 25.06.15.
 *
 * Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)
 */
public class NotebookServiceImpl implements NotebookService {
    private HibernateUtil hibernateSessionFactory;
    private SessionFactory factory;

    public NotebookServiceImpl(){
        hibernateSessionFactory = new HibernateUtil();
    }

    public Long createCPU(CPU cpu){
        factory = hibernateSessionFactory.create();
        CPUDaoImpl cpuDao = new CPUDaoImpl(factory);
        Long id = cpuDao.create(cpu);
        hibernateSessionFactory.close(factory);
        return id;
    }

    public Long createMemory(Memory memory){
        factory = hibernateSessionFactory.create();
        MemoryDaoImpl memoryDao = new MemoryDaoImpl(factory);
        Long id = memoryDao.create(memory);
        hibernateSessionFactory.close(factory);
        return id;
    }

    public Long createVendor(Vendor vendor){
        factory = hibernateSessionFactory.create();
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        Long id = vendorDao.create(vendor);
        hibernateSessionFactory.close(factory);
        return id;
    }

    public Long createNotebook(Notebook notebook){
        factory = hibernateSessionFactory.create();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        Long id = notebookDao.create(notebook);
        hibernateSessionFactory.close(factory);
        return id;
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        factory = hibernateSessionFactory.create();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        Notebook note = notebookDao.read(noteId);
        Store receipt = new Store(note, amount, price);
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        Long id = storeDao.create(receipt);
        hibernateSessionFactory.close(factory);
        return id;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        factory = hibernateSessionFactory.create();
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        Store store = storeDao.read(storeId);

        if (store.getAmount() < amount){
            amount = store.getAmount();
        }

        store.setAmount(store.getAmount() - amount);
        storeDao.update(store);

        Sales sale = new Sales(store, amount);
        SalesDaoImpl salesDao = new SalesDaoImpl(factory);
        Long id = salesDao.create(sale);
        hibernateSessionFactory.close(factory);
        return id;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        boolean result;
        factory = hibernateSessionFactory.create();
        CPUDaoImpl cpuDao = new CPUDaoImpl(factory);
        result = cpuDao.update(cpu);
        hibernateSessionFactory.close(factory);
        return result;
    }

    @Override
    public boolean updateMemory(Memory memory) {
        boolean result;
        factory = hibernateSessionFactory.create();
        MemoryDaoImpl memoryDao = new MemoryDaoImpl(factory);
        result = memoryDao.update(memory);
        hibernateSessionFactory.close(factory);
        return result;
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        boolean result;
        factory = hibernateSessionFactory.create();
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        result = vendorDao.update(vendor);
        hibernateSessionFactory.close(factory);
        return result;
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        boolean result;
        factory = hibernateSessionFactory.create();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        result = notebookDao.update(notebook);
        hibernateSessionFactory.close(factory);
        return result;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        boolean result = false;
        store.setAmount(store.getAmount() - amount);
        factory = hibernateSessionFactory.create();
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        result = storeDao.update(store);
        hibernateSessionFactory.close(factory);
        return result;
    }

    public List<Vendor> getVendorsList(){
        factory = hibernateSessionFactory.create();
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        List<Vendor> vendors = vendorDao.findAll();
        hibernateSessionFactory.close(factory);
        return vendors;
    }
}
