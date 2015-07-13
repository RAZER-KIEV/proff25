package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import hw7.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Роман on 26.06.2015.
 * Создать приложение магазин ноутбуков со следующими функциями:
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)
 3. Добавить в приложение ноутбуков следующие функции
 Изменить процессор
 Изменить память
 Изменить имя производителя
 Изменить тип ноутбука
 Списать со склад ноутбуки (ключ, количество)
 4. Добавить в приложение ноутбуков следующие функции:
 Показать все ноутбуки на складе (пользователь указывает размер порции)
 Показать все ноутбуки которых больше указанного количества
 Показать все ноутбуки по указанному имени производителя процессора
 Показать все ноутбуки на складе
 Показать типы ноутбуков, оставшиеся на складе по каждому производителю
 Получить объем продаж ноутбуков в среднем за день
 */
public class NotebookServiceImpl implements NotebookService {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    @Override
    public Long receive(Long id, int amount, double price) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        Notebook note = notebookDao.read(id);
        Store store = new Store(note, amount, price);
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        Long result = storeDao.create(store);
        return result;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        Store store = storeDao.read(storeId);
        int balance = store.getNotebooksQuantity() - amount;
        if(balance <= 0) {
            store.setNotebooksQuantity(0);
        } else {
            store.setNotebooksQuantity(balance);
        }
        storeDao.update(store);
        SalesDaoImpl salesDao = new SalesDaoImpl(factory);
        Long result = salesDao.create(new Sales(store, new Date(System.currentTimeMillis()), amount));
        return result;
    }

    @Override
    public Long add(Notebook notebook) {
        NotebookDao notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.create(notebook);
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        CPUDaoImpl cpuDao = new CPUDaoImpl(factory);
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        MemoryDaoImpl memoryDao = new MemoryDaoImpl(factory);
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        int balance = store.getNotebooksQuantity() - amount;
        if(balance <=0) {
            store.setNotebooksQuantity(0);
        } else {
            store.setNotebooksQuantity(balance);
        }
        return storeDao.update(store);
    }

    @Override
    public Store getStore(Long id) {
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        return storeDao.read(id);
    }

    @Override
    public List getNotebooksByPortion(int size) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.getNotebooksByPortion(size);
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.getNotebooksGtAmount(amount);
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.getNotebooksByCpuVendor(cpuVendor);
    }

    @Override
    public List getNotebooksFromStore() {

        return getNotebooksGtAmount(0);
    }

    @Override
    public Map getNotebooksStorePresent() {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.getNotebooksStorePresent();
    }

    @Override
    public Map getSalesByDays() {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.getSalesByDays();
    }

    public void endSession() {
        factory.close();
    }
}
