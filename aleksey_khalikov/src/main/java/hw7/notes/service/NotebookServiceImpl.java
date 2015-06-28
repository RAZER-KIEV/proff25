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
    private HibernateUtil hibernateUtil;
    private SessionFactory factory;

    public NotebookServiceImpl(){
        hibernateUtil = new HibernateUtil();
    }

    public Long createCPU(CPU cpu){
        factory = hibernateUtil.create();
        CPUDaoImpl cpuDao = new CPUDaoImpl(factory);
        Long id = cpuDao.create(cpu);
        hibernateUtil.close(factory);
        return id;
    }

    public Long createMemory(Memory memory){
        factory = hibernateUtil.create();
        MemoryDaoImpl memoryDao = new MemoryDaoImpl(factory);
        Long id = memoryDao.create(memory);
        hibernateUtil.close(factory);
        return id;
    }

    public Long createVendor(Vendor vendor){
        factory = hibernateUtil.create();
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        Long id = vendorDao.create(vendor);
        hibernateUtil.close(factory);
        return id;
    }

    public Long createNotebook(Notebook notebook){
        factory = hibernateUtil.create();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        Long id = notebookDao.create(notebook);
        hibernateUtil.close(factory);
        return id;
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        factory = hibernateUtil.create();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        Notebook note = notebookDao.read(noteId);
        Store receipt = new Store(note, amount, price);
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        Long id = storeDao.create(receipt);
        hibernateUtil.close(factory);
        return id;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        factory = hibernateUtil.create();
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
        hibernateUtil.close(factory);
        return id;
    }

    public List<Vendor> getVendorsList(){
        factory = hibernateUtil.create();
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        List<Vendor> vendors = vendorDao.findAll();
        hibernateUtil.close(factory);
        return vendors;
    }
}
