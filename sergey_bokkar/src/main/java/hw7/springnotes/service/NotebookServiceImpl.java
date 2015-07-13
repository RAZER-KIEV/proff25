package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by Well on 03.07.2015.
 */
@Service
@Transactional
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private NotebookDaoImpl ndi;
    @Autowired
    private CPUDaoImpl cdi;
    @Autowired
    private MemoryDaoImpl mdi;
    @Autowired
    private VendorDaoImpl vdi;
    @Autowired
    private StoreDaoImpl strdi;
    @Autowired
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
    @Transactional(readOnly = true)
    public List getNotebooksByPortion(int size) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksFromStore() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksStorePresent() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Map getSalesByDays() {
        return null;
    }


}
