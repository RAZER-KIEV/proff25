package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by Well on 03.07.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl ndi;
    private CPUDaoImpl cdi;
    private MemoryDaoImpl mdi;
    private VendorDaoImpl vdi;
    private StoreDaoImpl strdi;
    private SalesDaoImpl slsdi;

    public NotebookServiceImpl() {}

         public NotebookServiceImpl(SessionFactory factory) {
             ndi = new NotebookDaoImpl(factory);
             cdi = new CPUDaoImpl();
             mdi = new MemoryDaoImpl();
             vdi = new VendorDaoImpl();
             strdi = new StoreDaoImpl(factory);
             slsdi = new SalesDaoImpl(factory);
    }


    @Override
    public Long receive(Long ntbId, int amount, double price) {
            Notebook notebook = ndi.read(ntbId);
            return strdi.create(new Store(price, amount, notebook));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = strdi.read(storeId);
        if (store.getQuantity()<amount) {
            return -1L;
        }
        store.setQuantity(store.getQuantity()-amount);
        strdi.update(store);

        Sales sale = new Sales( LocalDate.now(), amount, store);

        return sale.getSalesId();
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        if (cdi.update(cpu)) {return true;}
        return false;
    }

    @Override
    public boolean updateMemory(Memory memory) {
        if (mdi.update(memory)) {return true;}
        return false;
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        if (vdi.update(vendor)) {return true;}
        return false;
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        if (ndi.update(notebook)) {return true;}
        return false;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        store.setQuantity(store.getQuantity() - amount);
        return strdi.update(store);
    }

    @Override
    public List getNotebooksByPortion(int size) {
        return null;
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }


    @Override
    public List getNotebooksFromStore() {
        return null;
    }

    @Override
    public Map getNotebooksStorePresent() {
        return null;
    }

    @Override
    public Map getSalesByDays() {
        return null;
    }


}
