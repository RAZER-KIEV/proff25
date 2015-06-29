package hw7.notes.service;


import hw7.notes.HibernateUtil;
import hw7.notes.dao.*;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.hibernate.SessionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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



        sessionFactory.close();
    }
}
