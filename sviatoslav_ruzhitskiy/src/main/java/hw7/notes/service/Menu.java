package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.dao.NotebookDaoImpl;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by ПК on 25.06.2015.
 */
public class Menu {



    //public static Notebook getNotebook(){return notebook;}

    private Logger log = Logger.getLogger(Menu.class);
    private NotebookService notebookService;
    private SessionFactory factory;
    private NotebookDaoImpl notebookDao;
    private CPUDaoImpl cpuDao;
    private MemoryDaoImpl memoryDao;
    private VendorDaoImpl vendorDao;
    private StoreDaoImpl storeDao;
    private SalesDaoImpl salesDao;
    private static Menu instance;



    private Menu(){}

    public static Menu getMenuInstance(){
        if(instance ==null){
        instance = new Menu();
         return instance;
    }
        return instance;
    }

    public void init(){
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate2.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
        notebookService = new NotebookService();
        notebookDao= new NotebookDaoImpl(factory);
        cpuDao = new CPUDaoImpl(factory);
        memoryDao = new MemoryDaoImpl(factory);
        vendorDao = new VendorDaoImpl(factory);
        storeDao =new StoreDaoImpl(factory);
        salesDao = new SalesDaoImpl(factory);


    }
    public NotebookService getNotebookService() {
        return notebookService;
    }
    public SessionFactory getSessionFactory(){
        return  factory;
    }
    public NotebookDaoImpl getNotebookDao(){
        return notebookDao;
    }
    public CPUDaoImpl getCpuDao(){
        return cpuDao;
    }
    public MemoryDaoImpl getMemoryDao(){
        return  memoryDao;
    }
    public VendorDaoImpl getVendorDao() {
        return vendorDao;
    }
    public StoreDaoImpl getStoreDao(){
       return storeDao;
    }
    public SalesDaoImpl getSalesDao(){
        return salesDao;
    }
    }




