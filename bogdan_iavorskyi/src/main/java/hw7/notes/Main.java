package hw7.notes;

import hw7.notes.dao.*;
import hw7.notes.service.NotebookService;
import hw7.notes.service.NotebookServiceImpl;
import hw7.notes.util.HibernateUtil;
import hw7.notes.view.NSMenu;
import org.hibernate.SessionFactory;

public class Main {

    private static NotebookService service;

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        service = generateService(factory);
        NSMenu.main(args);
        factory.close();
    }

    public static NotebookService getService() {
        return service;
    }

    public static NotebookService generateService(SessionFactory factory) {
        VendorDao vendorDao = new VendorDaoImpl(factory);
        CPUDao cpuDao = new CPUDaoImpl(factory);
        MemoryDao memoryDao = new MemoryDaoImpl(factory);
        NotebookDao notebookDao = new NotebookDaoImpl(factory);
        StoreDao storeDao = new StoreDaoImpl(factory);
        SalesDao salesDao = new SalesDaoImpl(factory);
        NotebookService service =
                new NotebookServiceImpl(vendorDao, cpuDao, memoryDao, notebookDao, storeDao, salesDao);
        return service;
    }

}
