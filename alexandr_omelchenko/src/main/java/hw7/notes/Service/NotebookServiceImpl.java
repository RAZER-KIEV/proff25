package hw7.notes.Service;

import hw7.notes.dao.CPUDaoImpl;
import hw7.notes.dao.MemoryDaoImpl;
import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.dao.VendorDaoImpl;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.hibernate.SessionFactory;
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
        return null;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        return null;
    }
}