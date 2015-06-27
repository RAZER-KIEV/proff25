package hw7.notes.service;

import hw7.notes.dao.NotebookDao;
import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Vendor;
import hw7.notes.util.HibernateUtil;

import java.util.Date;

/**
 * Created by Роман on 25.06.2015.
 *  * Создать приложение магазин ноутбуков со следующими функциями:
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
 */
public class Menu {

    public static void main(String[] args) {

        //Task1
        CPU cpu = new CPU("Intel", 3000, "super Core");
        Memory memory = new Memory("ScanDisk", 4);
        Vendor vendor = new Vendor("Sony");
        Notebook notebook = new Notebook(vendor,"AvaioNEW", new Date(System.currentTimeMillis()), cpu, memory);
        NotebookServiceImpl service = new NotebookServiceImpl();
        service.add(notebook);
        System.out.println(service.receive(1L, 1000, 1999.99));
        System.out.println(service.sale(1L, 500));

        //Task2
        cpu.setModel("Double Core II");
        service.updateCPU(cpu);

        memory.setSize(8);
        service.updateMemory(memory);

        vendor.setName("Dell");
        service.updateVendor(vendor);

        notebook.setVendor(new Vendor("ASUS"));
        service.updateNotebook(notebook);

        service.removeFromStore(service.getStore(1L), 10000);

        service.endSession();


    }
}
