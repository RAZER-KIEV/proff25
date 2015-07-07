package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

@Service("notebookService")
@Transactional
public class NotebookServiceImpl implements NotebookService {

    @Autowired(required = true)
    NotebookDaoImpl notebookDao;
    @Autowired(required = true)
    StoreDaoImpl storeDao;
    @Autowired(required = true)
    SalesDaoImpl salesDao;
    @Autowired(required = true)
    CPUDaoImpl cpuDao;
    @Autowired(required = true)
    MemoryDaoImpl memoryDao;
    @Autowired(required = true)
    VendorDaoImpl vendorDao;

    @Override
    public Long receive(Long id, int amount, double price) {
        Notebook note = notebookDao.read(id);
        Store store = new Store(note, amount, price);
        Long result = storeDao.create(store);
        return result;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        int balance = store.getNotebooksQuantity() - amount;
        if(balance <= 0) {
            store.setNotebooksQuantity(0);
        } else {
            store.setNotebooksQuantity(balance);
        }
        storeDao.update(store);
        Long result = salesDao.create(new Sales(store, new Date(System.currentTimeMillis()), amount));
        return result;
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        int balance = store.getNotebooksQuantity() - amount;
        if(balance <=0) {
            store.setNotebooksQuantity(0);
        } else {
            store.setNotebooksQuantity(balance);
        }
        return storeDao.update(store);
    }

    @Override
    @Transactional(readOnly = true)
    public Store getStore(Long id) {
        return storeDao.read(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksByPortion(int size) {
        return notebookDao.getNotebooksByPortion(size);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksGtAmount(int amount) {
        return notebookDao.getNotebooksGtAmount(amount);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return notebookDao.getNotebooksByCpuVendor(cpuVendor);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksFromStore() {
        return notebookDao.getNotebooksGtAmount(0);
    }

    @Override
    @Transactional(readOnly = true)
    public Map getNotebooksStorePresent() {
        return notebookDao.getNotebooksStorePresent();
    }

    @Override
    @Transactional(readOnly = true)
    public Map getSalesByDays() {
        return notebookDao.getSalesByDays();
    }
}
