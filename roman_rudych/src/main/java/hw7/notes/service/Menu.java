package hw7.notes.service;

import hw7.notes.dao.NotebookDao;
import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Vendor;
import hw7.notes.util.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Роман on 25.06.2015.
 * * Создать приложение магазин ноутбуков со следующими функциями:
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
public class Menu {

    public static void main(String[] args) throws ParseException{

        //Task2
//        Vendor vendor2 = new Vendor("Intel");
//        Vendor vendor3 = new Vendor("AMD");
//        Vendor vendor4 = new Vendor("IBM");
//        Vendor vendor5 = new Vendor("Qux");
//        CPU cpu = new CPU(vendor2, 3000, "super Core");
//        CPU cpu2 = new CPU(vendor2, 3000, "super Core");
//        CPU cpu3 = new CPU(vendor2, 3000, "super Core");
//        CPU cpu4 = new CPU(vendor5, 3000, "super Core");
//        Memory memory = new Memory("ScanDisk", 4);
//        Vendor vendor = new Vendor("Sony");
//        Notebook notebook = new Notebook(vendor,"AvaioNEW", new SimpleDateFormat("dd.MM.yyyy").parse("10.12.2014"), cpu, memory);
//        Notebook notebook2 = new Notebook(new Vendor("Dell"),"DelloOne", new Date(System.currentTimeMillis()), cpu2, memory);
//        Notebook notebook3 = new Notebook(new Vendor("HP"),"HP universe", new Date(66777776666L), cpu3, memory);
//        Notebook notebook4 = new Notebook(new Vendor("Acer"),"MarsOne", new Date(6666666666L), cpu4, memory);
//        Notebook notebook5 = new Notebook(new Vendor("Lenovo"),"LevOn", new Date(6666666666L), cpu4, memory);
//        Notebook notebook6 = new Notebook(new Vendor("Mac"),"Pro", new Date(6666666666L), cpu4, memory);
        NotebookServiceImpl service = new NotebookServiceImpl();
//        service.add(notebook);
//        service.add(notebook2);
//        service.add(notebook3);
//        service.add(notebook4);
//        service.add(notebook5);
//        service.add(notebook6);
//        System.out.println(service.receive(1L, 1000, 1999.99));
//        service.receive(2L, 200, 222.22);
//        service.receive(3L, 300, 333.22);
//        service.receive(4L, 400, 444.22);
//        service.receive(4L, 100, 445.22);
//        service.receive(4L, 4000, 333.22);
//        service.receive(4L, 40, 222.22);
//        System.out.println(service.sale(1L, 100));
//        System.out.println(service.sale(1L, 100));
//        System.out.println(service.sale(1L, 100));
//        System.out.println(service.sale(2L, 200));
//        System.out.println(service.sale(3L, 300));
//        System.out.println(service.sale(6L, 700));

        //Task3
//        cpu.setModel("Double Core II");
//        service.updateCPU(cpu);
//
//        memory.setSize(8);
//        service.updateMemory(memory);
//
//        vendor.setName("Dell");
//        service.updateVendor(vendor);
//
//        notebook.setVendor(new Vendor("ASUS"));
//        service.updateNotebook(notebook);
//
//        service.removeFromStore(service.getStore(1L), 10000);

        //Task4
//        List<Notebook> ntbList = service.getNotebooksByPortion(10);
//        for(Notebook ntb : ntbList) {
//            System.out.println(ntb);
//        }

//        List<Notebook> ntbList2 = service.getNotebooksGtAmount(10);
//        for(Notebook ntb : ntbList2) {
//            System.out.println(ntb);
//        }

//        List<Notebook> ntbList3 = service.getNotebooksByCpuVendor(vendor2);
//        for(Notebook ntb : ntbList3) {
//            System.out.println(ntb);
//        }

//        List<Notebook> ntbList4 = service.getNotebooksFromStore();
//        for(Notebook ntb : ntbList4) {
//            System.out.println(ntb);
//        }
//
//        List<Notebook> ntbList5 = service.getNotebooksStorePresent();
//        System.out.println(ntbList5);
//        for(Notebook ntb : ntbList5) {
//            System.out.println(ntb);
//        }
        Map<Date, Integer> map = service.getSalesByDays();
        System.out.println(map);
        service.endSession();


    }
}
