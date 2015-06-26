package hw7.notes.service;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Vendor;

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
 */
public class Menu {

    public static void main(String[] args) {
        CPU cpu = new CPU("Intel", 3000, "super Core");
        Memory memory = new Memory("ScanDisk", 4);
        Vendor vendor = new Vendor("Sony");
        Notebook notebook = new Notebook(vendor,"AvaioNEW", new Date(System.currentTimeMillis()), cpu, memory);
        NotebookService service = new NotebookServiceImpl();
        System.out.println(service.receive(notebook, 1000, 1999.99));
        System.out.println(service.sale(1L, 500));
    }
}
