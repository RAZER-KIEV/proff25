package hw7.notes.view;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import hw7.notes.service.Menu;

import java.util.Date;
import java.util.List;

/**
 * Created by ПК on 26.06.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        Menu menu= Menu.getMenuInstance();
        menu.init();
        Vendor vendor = new Vendor("ASUS");
        CPU cpu = new CPU("INTEL",3200,"i5");
        Memory memory = new Memory("CoolRam4",4096);
        String model = "INSPIRON";
        Date manuf_date = menu.getNotebookService().dateSet(2014, 4, 1);



       Notebook notebook = new Notebook(vendor, cpu,memory, model, manuf_date);


        //menu.cpuDao.create(cpu);
        //menu.vendorDao.create(vendor);
        // menu.memoryDao.create(memory);


        // Long id=menu.notebookDao.create(nbk);
        System.out.println(menu.getNotebookDao().read(Long.parseLong("1")));
        List<Notebook> res = (List) menu.getNotebookDao().findAll();
        for(Notebook ntb:res) {
            System.out.println("------------------------------------------result--------------");
            System.out.println(ntb);
        }
    }
}
