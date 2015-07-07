package hw7.springnotes.view;

import hw7.springnotes.dao.NotebookDao;
import hw7.springnotes.dao.NotebookDaoImpl;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.service.*;
import hw7.springnotes.service.NotebookServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Роман on 25.06.2015.
 * Написать приложение "Магазин ноутбуков" с использованием Spring:
 Тип ноутбука(производитель, модель, дата производства, процессор, память)
 Производители(имя)
 Процессоры(производитель, частота, модель)
 Память(производитель, размер)
 Склад ноутбуков(тип ноутбука, количество, цена)
 Продажи(склад ноутбуков, дата продажи, количество)

 Добавить следующие функции:
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)
 Изменить процессор
 Изменить память
 Изменить имя производителя
 Изменить тип ноутбука
 Списать со склад ноутбуки (ключ, количество)
 Показать все ноутбуки на складе (пользователь указывает размер порции)
 Показать все ноутбуки которых больше указанного количества
 Показать все ноутбуки по указанному имени производителя процессора
 Показать все ноутбуки на складе
 Показать типы ноутбуков, оставшиеся на складе по каждому производителю
 Получить объем продаж ноутбуков по каждому дню

 domain
 hw7.springnotes.domain.Notebook
 hw7.springnotes.domain.Vendor
 hw7.springnotes.domain.CPU
 hw7.springnotes.domain.Memory
 hw7.springnotes.domain.Store
 hw7.springnotes.domain.Sales
 dao
 hw7.springnotes.dao.NotebookDao
 Long create(Notebook notebook)
 Notebook read(Long ig)
 boolean update(Notebook notebook)
 boolean delete(Notebook notebook)
 List<Notebook> findAll()
 hw7.springnotes.dao.VendorDao
 Long create(Vendor vendor)
 Vendor read(Long ig)
 boolean update(Vendor vendor)
 boolean delete(Vendor vendor)
 List<Vendor> findAll()
 hw7.springnotes.dao.CPUDao
 Long create(CPU cpu)
 CPU read(Long ig)
 boolean update(CPU cpu)
 boolean delete(CPU cpu)
 List<CPU> findAll()
 hw7.springnotes.dao.MemoryDao
 Long create(Memory memory)
 Memory read(Long ig)
 boolean update(Memory memory)
 boolean delete(Memory memory)
 List<Memory> findAll()
 hw7.springnotes.dao.StoreDao
 Long create(Store store)
 Store read(Long ig)
 boolean update(Store store)
 boolean delete(Store store)
 List<Store> findAll()
 hw7.springnotes.dao.SalesDao
 Long create(Sales store)
 Sales read(Long ig)
 boolean update(Sales store)
 boolean delete(Sales store)
 List<Sales> findAll()

 hw7.springnotes.dao.NotebookDaoImpl
 hw7.springnotes.dao.VendorDaoImpl
 hw7.springnotes.dao.CPUDaoImpl
 hw7.springnotes.dao.MemoryDaoImpl
 hw7.springnotes.dao.StoreDaoImpl
 hw7.springnotes.dao.SalesDaoImpl
 service
 hw7.springnotes.service.NotebookService
 List<Notebook> getNotebooksByPortion(int size)
 List<Notebook> getNotebooksGtAmount(int amount)
 List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor)
 List<Notebook> getNotebooksFromStore()
 List<Notebook> getNotebooksStorePresent()
 Map<Notebook, int> getSalesByDays()
 boolean updateCPU(CPU cpu)
 boolean updateMemory(Memory memory)
 boolean updateVendor(Vendor vendor)
 boolean updateNotebook(Notebook notebook)
 boolean removeFromStore(Store store, int amount)
 hw7.springnotes.service.NotebookServiceImpl
 view
 hw7.springnotes.view.Menu
 hw7.springnotes/context.xml
 hw7.springnotes.Main
 */
public class Menu {

    public static void main(String[] args) throws ParseException{

    }
}
