package hw7.springnotes.view;


import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.service.NotebookServiceImpl;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by ПК on 26.06.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("hw7/context.xml");
        NotebookServiceImpl ntbService= context.getBean("notebookServiceImpl",NotebookServiceImpl.class);


        Vendor vendor = new Vendor("ASUS");
        CPU cpu = context.getBean("cPU", CPU.class);
        cpu.setCpuVendor(vendor);
        cpu.setCpuModel("i5");
        cpu.setFrequency(3500);
        Memory memory = new Memory("CoolRam4",4096);
        String model = "INSPIRON";
        Date manuf_date = ntbService.dateSet(2014, 4, 1);



       Notebook notebook = new Notebook(vendor, cpu,memory, model, manuf_date);

        ntbService.getVendorDao().create(vendor);
        ntbService.getCpuDao().create(cpu);
        ntbService.getMemoryDao().create(memory);

        ntbService.getNotebookDao().create(notebook);


        System.out.println(ntbService.getNotebookDao().read(Long.parseLong("1")));
        List<Notebook> res = (List) ntbService.getNotebookDao().findAll();
        for(Notebook ntb:res) {
            System.out.println("------------------------------------------result--------------");
            System.out.println(ntb);
        }
    }
}
