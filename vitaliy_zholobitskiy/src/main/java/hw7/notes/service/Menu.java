package hw7.notes.service;


import hw7.notes.*;
import hw7.notes.dao.*;
import hw7.notes.domain.*;


import java.util.Date;
import java.util.Locale;

/**
 * Created by just1ce on 29.06.2015.
 */
public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        HibernateUtil util = new HibernateUtil();
        util.createSessionFactory();
        NotebookServiceImpl service = new NotebookServiceImpl(util.getFactory());

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
