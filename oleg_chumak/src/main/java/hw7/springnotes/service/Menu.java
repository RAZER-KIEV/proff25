package hw7.springnotes.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by oleg on 24.06.15.
 */
public class Menu {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("hw7/context_db.xml");
        NotebookServiceImpl service = context.getBean("notebookServiceImpl", NotebookServiceImpl.class);

//        NotebookServiceImpl service = new NotebookServiceImpl();
//        System.out.println(service.getNotebooksStorePresent());
//        service.vendorDao.create(new Vendor("bbb"));
//        Vendor vendor = service.vendorDao.read(new Long(10));
//        service.notebookDao.create(new Notebook(vendor, "aaza", "20, 12, 2014" , service.cpuDao.read(new Long(7)), service.memoryDao.read(new Long(8))));
//        service.sale(new Long(3), 20);
//        System.out.println(service.getNotebooksStorePresent());
//        Notebook notebook = service.notebookDao.read()
//        Notebook note = service.notebookDao.read(new Long(2));
//        service.storeDao.create(new Store(service.notebookDao.read(new Long(9)),new Long(0), new Long(2254)));
//        service.receive(new Long(8), 20, new Long(750));
//        service.receive(new Long(8), 15, new Long(750));
//        service.receive(new Long(7), 50, new Long(750));
//        service.receive(new Long(7), 20, new Long(750));
//        System.out.println(
//        System.out.println(
        System.out.println(service.getSalesByDays());
//        service.sale(new Long(2), 15);
//        System.out.println(service.getSalesByDays());
    }
}
