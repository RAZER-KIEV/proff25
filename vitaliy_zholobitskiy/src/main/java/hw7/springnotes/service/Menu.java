package hw7.springnotes.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by just1ce on 29.06.2015.
 */
public class Menu {


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("hw7/springnotes/context-anno.xml");
        NotebookService service = context.getBean("notebookServiceImpl", NotebookService.class);
        // = context.getBean("companyDaoImpl",CompanyDaoImpl.class);// new CompanyDaoImpl(context.getBean("sf", SessionFactory.class));

        /*Vendor vendor =  new Vendor("ASUS");
        VendorDaoImpl vendorDao = new VendorDaoImpl(util.getFactory());
        vendorDao.create(vendor);

        CPU cpu = new CPU(vendor,"3.3","i7");
        CPUDaoImpl cpuDao = new CPUDaoImpl(util.getFactory());
        cpuDao.create(cpu);

        Memory memory = new Memory(2048L,vendor);
        MemoryDaoImpl memoryDao = new MemoryDaoImpl(util.getFactory());
        memoryDao.create(memory);

        Notebook notebook = new Notebook(vendor,"ultrabook",new Date(2008,8,26),cpu,memory);
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(util.getFactory());
        notebookDao.create(notebook);

        Store store = new Store(notebook,11L,1000);
        StoreDaoImpl storeDao = new StoreDaoImpl(util.getFactory());
        storeDao.create(store);

        Sales sales = new Sales(store,new Date(2010,8,26),15L);
        SalesDaoImpl salesDao =  new SalesDaoImpl(util.getFactory());
        salesDao.create(sales);*/
        System.out.println(service.getNotebooksByPortion(2).toString());
    }
}
