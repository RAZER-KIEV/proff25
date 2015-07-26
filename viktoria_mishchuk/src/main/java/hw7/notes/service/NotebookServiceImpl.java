package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Store;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by viktoria
 * Project:.hw7.notes.service
 */
public class NotebookServiceImpl implements NotebookService {

    private SessionFactory factory;
    private NotebookDao notebookDao;
    private VendorDao vendorDao;
    private MemoryDao memoryDao;
    private CPUDao cpuDao;
    private StoreDao storeDao;
    private SalesDao salesDao;


    public NotebookServiceImpl(){

    }

    public NotebookServiceImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long receive(Notebook note, int amount, double price){

        return new StoreDaoImpl().create(new Store(note,amount,price));
    }

    @Override
    public Long sale(Long storeId, int amount){

//        return new SalesDaoImpl().create(new Sales(storeId, new GregorianCalendar(), amount));
return null;
    }
}
