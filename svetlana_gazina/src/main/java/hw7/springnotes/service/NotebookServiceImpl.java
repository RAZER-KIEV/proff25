package hw7.springnotes.service;

import hw7.notes.domain.Vendor;
import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Sveta on 7/5/2015.
 */
@Service
@Transactional
public class NotebookServiceImpl implements NotebookService {
    @Autowired(required = true)
    private SessionFactory factory;
    @Autowired(required = true)
    public NotebookDaoImpl notebookDao;
    @Autowired(required = true)
    public VendorDaoImpl vendorDao;
    @Autowired(required = true)
    public CPUDaoImpl cpuDao;
    @Autowired(required = true)
    public MemoryDaoImpl memoryDao;
    @Autowired(required = true)
    public StoreDaoImpl storeDao;
    @Autowired(required = true)
    public SalesDaoImpl salesDao;

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {

        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public NotebookDaoImpl getNotebookDao() {
        return notebookDao;
    }

    public void setNotebookDao(NotebookDaoImpl notebookDao) {
        this.notebookDao = notebookDao;
    }

    public VendorDaoImpl getVendorDao() {
        return vendorDao;
    }

    public void setVendorDao(VendorDaoImpl vendorDao) {
        this.vendorDao = vendorDao;
    }

    public CPUDaoImpl getCpuDao() {
        return cpuDao;
    }

    public void setCpuDao(CPUDaoImpl cpuDao) {
        this.cpuDao = cpuDao;
    }

    public MemoryDaoImpl getMemoryDao() {
        return memoryDao;
    }

    public void setMemoryDao(MemoryDaoImpl memoryDao) {
        this.memoryDao = memoryDao;
    }

    public StoreDaoImpl getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(StoreDaoImpl storeDao) {
        this.storeDao = storeDao;
    }

    public SalesDaoImpl getSalesDao() {
        return salesDao;
    }

    public void setSalesDao(SalesDaoImpl salesDao) {
        this.salesDao = salesDao;
    }

    @Override
    public List getNotebooksByPortion(int size) {
        Query query = (Query)factory.getCurrentSession().createQuery("from Notebook");
        query.setFirstResult(1);
        query.setMaxResults(size);
        return (List<Notebook>)query.list();
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        Query query = factory.getCurrentSession().createQuery("from Notebook n group by n.vendor having count(n.id) > :amount ");
        query.setParameter("amount", amount);
        return query.list();
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        Query query = factory.getCurrentSession().createQuery("from Notebook n having n.cpu.vendor =:cpuVendor");
        query.setParameter("cpuVendor", cpuVendor);
        return query.list();
    }

    @Override
    public List getNotebooksFromStore() {
        Query query = factory.getCurrentSession().createQuery("from Notebook n having n.cpu.vendor =:cpuVendor");
        return query.list();
    }

    @Override
    public List getNotebooksStorePresent() {

            Query query = factory.getCurrentSession().createQuery("select v from Store s, Notebook n, Vendor v where s.noteBook=n and n.vendor=v");
            List res = query.list();
            Set<Vendor> setVendor = new HashSet<>();
            for (Iterator iter = res.iterator(); iter.hasNext();) {
                setVendor.add((Vendor) iter.next());
            }
            List<List> result = new LinkedList<>();
            for (Vendor vendor:setVendor) {
                Query query1 = factory.getCurrentSession().createQuery("select n from Store s join s.noteBook n join n.vendor v where v.id=:id");
                query1.setParameter("id", vendor.getId());
                result.add(query1.list());
            }
            return result;

    }

    @Override
    public Map getSalesByDays() {
        Map<Date, Double> result = new TreeMap<>();

        Query query = factory.getCurrentSession().createQuery("select c.date, avg (c.amount) from Sales c join c.store p group by c.date");
        List list = query.list();

        for(int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) list.get(i);
            result.put((Date) obj[0], (Double) obj[1]);
        }
        return result;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        store.setAmount(store.getAmount() - amount);
        return storeDao.update(store);
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        Notebook note = notebookDao.read(noteId);
        return storeDao.create(new Store(note.getVendor(), new BigDecimal(price), amount));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        int am = store.getAmount();
        store.setAmount(am - amount);
        salesDao.create(new Sales(store, new Date(), amount));
        storeDao.update(store);
        return storeId;
    }
}
