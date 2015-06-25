package hw7.notes.Service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.Date;
/**
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)
 */
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

    public Long receive(Notebook note, int amount, double price) {
        StoreDaoImpl storDao = new StoreDaoImpl(factory);
        return storDao.create( new Store(note, amount, price));
    }
    @Override
    public Long sale(Long storeId, int amount) {
        StoreDaoImpl storDao = new StoreDaoImpl(factory);
        Store store=storDao.read(storeId);

        SalesDaoImpl saleDao = new SalesDaoImpl(factory);
        return saleDao.create(new Sales(new Date(), amount, store));
    }
}