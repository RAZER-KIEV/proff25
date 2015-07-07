package hw7.springnotes;

import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.service.NotebookService;
import hw7.springnotes.service.NotebookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Роман on 05.07.2015.
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
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        //Creating some Notebooks with components
        Vendor vendor = new Vendor("Dellissimo");
        Vendor vendor2 = new Vendor("Intel");
        Vendor vendor3 = new Vendor("AMD");
        Vendor vendor4 = new Vendor("IBM");
        Vendor vendor5 = new Vendor("Qux");
        CPU cpu = new CPU(vendor2, 3000, "super quatroCore");
        CPU cpu2 = new CPU(vendor2, 3000, "super Core");
        CPU cpu3 = new CPU(vendor2, 3000, "super Core");
        CPU cpu4 = new CPU(vendor5, 3000, "super Core");
        Memory memory = new Memory("ScanDisk", 4);

        Notebook notebook = new Notebook(vendor,"DellissimoModel", new Date(6666666666L), cpu, memory);
        Notebook notebook2 = new Notebook(new Vendor("Dell"),"DelloOne", new Date(System.currentTimeMillis()), cpu2, memory);
        Notebook notebook3 = new Notebook(new Vendor("HP"),"HP universe", new Date(66777776666L), cpu3, memory);
        Notebook notebook4 = new Notebook(new Vendor("Acer"),"MarsOne", new Date(6666666666L), cpu4, memory);
        Notebook notebook5 = new Notebook(new Vendor("Lenovo"),"LevOn", new Date(6666666666L), cpu4, memory);
        Notebook notebook6 = new Notebook(new Vendor("Mac"),"Pro", new Date(6666666666L), cpu4, memory);



        ApplicationContext context = new ClassPathXmlApplicationContext("hw7.springnotes/context-springnotes.xml");
        NotebookService service = context.getBean("notebookService", NotebookService.class);

        service.add(notebook);
        service.add(notebook2);
        service.add(notebook3);
        service.add(notebook4);
        service.add(notebook5);
        service.add(notebook6);
        System.out.println(service.receive(1L, 1000, 1999.99));
        service.receive(2L, 200, 222.22);
        service.receive(3L, 300, 333.22);
        service.receive(4L, 400, 444.22);
        service.receive(4L, 100, 445.22);
        service.receive(4L, 4000, 333.22);
        service.receive(4L, 40, 222.22);
        System.out.println(service.sale(1L, 100));
        System.out.println(service.sale(1L, 100));
        System.out.println(service.sale(1L, 100));
        System.out.println(service.sale(2L, 200));
        System.out.println(service.sale(3L, 300));
        System.out.println(service.sale(6L, 700));

        //Task3
        cpu.setModel("Double Core II");
        service.updateCPU(cpu);

        memory.setSize(8);
        service.updateMemory(memory);

        vendor.setName("Dell");
        service.updateVendor(vendor);

        notebook.setVendor(new Vendor("ASUS"));
        service.updateNotebook(notebook);

        service.removeFromStore(service.getStore(1L), 10000);

        //Task4
        System.out.println("getNotebooksByPortion:");

        List<Notebook> ntbList = service.getNotebooksByPortion(10);
        for(Notebook ntb : ntbList) {
            System.out.println(ntb);
        }

        System.out.println("getNotebooksGreateAmount:");

        List<Notebook> ntbList2 = service.getNotebooksGtAmount(10);
        for(Notebook ntb : ntbList2) {
            System.out.println(ntb);
        }

        System.out.println("getNotebooksByCPUVendor:" + vendor2);

        List<Notebook> ntbList3 = service.getNotebooksByCpuVendor(vendor2);
        for(Notebook ntb : ntbList3) {
            System.out.println(ntb);
        }

        System.out.println("getNotebooksFromStore:");

        List<Notebook> ntbList4 = service.getNotebooksFromStore();
        for(Notebook ntb : ntbList4) {
            System.out.println(ntb);
        }

        System.out.println("getNotebooksStorePresent:");

        Map<Vendor, List<Notebook>> map1 = service.getNotebooksStorePresent();
        System.out.println(map1);

        System.out.println("getSalesByDays:");

        Map<Date, Integer> map = service.getSalesByDays();
        System.out.println(map);

    }
}
