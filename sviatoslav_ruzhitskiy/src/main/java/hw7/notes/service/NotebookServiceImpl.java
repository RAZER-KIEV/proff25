package hw7.notes.service;

import hw7.notes.dao.SalesDaoImpl;
import hw7.notes.dao.StoreDaoImpl;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ПК on 25.06.2015.
 */
public class NotebookServiceImpl implements NotebookService{
    Menu menu = Menu.getMenuInstance();
    private SalesDaoImpl salesDao;

    private StoreDaoImpl storeDao;

     public NotebookServiceImpl(){
         salesDao = menu.getSalesDao();
         storeDao = menu.getStoreDao();

     }

     public Date dateSet(int year, int month, int day) {
         Calendar cal = Calendar.getInstance();
         cal.set(year, month, day);
         Date date = cal.getTime();
         return date;
     }
    @Override
    public Long receive(Long id, int amount, double price){
        Notebook notebook = menu.getNotebookDao().read(id);
        Store store = new Store(notebook,amount,price);
        Long id2 = storeDao.create(store);
        return id2;
    }
    @Override
    public Long sale(Long storeId, int amount){
        Store store = menu.getStoreDao().read(storeId);
        Integer curAmount = store.getQuantity();
        Integer newAmount = curAmount-amount;
        store.setQuantity(newAmount);

        Sales nwSale= new Sales(store,new java.util.Date(),amount);
        Long id = salesDao.create(nwSale);

        return id;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return menu.getCpuDao().update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return menu.getMemoryDao().update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return menu.getVendorDao().update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return menu.getNotebookDao().update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {

        Integer newQuant = store.getQuantity()-amount;
        store.setQuantity(newQuant);
        return menu.getStoreDao().update(store);
    }


}
