package hw7.notes.service;


import hw7.notes.HibernateUtil;
import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Menu {
    public static void main(String[] args) throws ParseException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();
        SessionFactory sessionFactory = hibernateUtil.getFactory();

        NotebookDaoImpl notebookDao = new NotebookDaoImpl(sessionFactory);
        VendorDaoImpl vendorDao = new VendorDaoImpl(sessionFactory);
        CPUDaoImpl cpuDao = new CPUDaoImpl(sessionFactory);
        MemoryDaoImpl memoryDao = new MemoryDaoImpl(sessionFactory);
        StoreDaoImpl storeDao = new StoreDaoImpl(sessionFactory);
        SalesDaoImpl salesDao = new SalesDaoImpl(sessionFactory);

        NotebookServiceImpl notebookService = new NotebookServiceImpl(notebookDao, vendorDao, cpuDao, memoryDao, storeDao, salesDao);

        for (Map.Entry entry:notebookService.getNotebooksStorePresent().entrySet()){
            Vendor vendor1 = (Vendor) entry.getKey();
            if (vendor1==null) continue;
            List<Notebook> notebookList = (List) entry.getValue();
            vendor1.print();
            for (Notebook notebook1:notebookList){
                notebook1.print();
            }
            System.out.println();
            System.out.println();
        }

        for (Map.Entry entry:notebookService.getSalesByDays().entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        sessionFactory.close();
    }
}
