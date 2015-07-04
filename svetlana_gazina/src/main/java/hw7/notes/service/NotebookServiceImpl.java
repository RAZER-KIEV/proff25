package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Sveta on 6/26/2015.
 */
public class NotebookServiceImpl implements NotebookService {
    private SessionFactory factory;

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        StoreDaoImpl storeDao = new StoreDaoImpl();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl();
        Notebook note = notebookDao.read(noteId);
       return storeDao.create(new Store(note.getVendor(), new BigDecimal(price), amount));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        StoreDaoImpl storeDao = new StoreDaoImpl();
        SalesDaoImpl salesDao = new SalesDaoImpl();
        Store store = storeDao.read(storeId);
        Sales sales = new Sales(store, new Date(), amount);
        int am = store.getAmount();
        store.setAmount(am - amount);
        salesDao.create(sales);
        storeDao.update(store);
        return storeId;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        CPUDaoImpl cpuDao = new CPUDaoImpl();
        return cpuDao.update(cpu);

    }

    @Override
    public boolean updateMemory(Memory memory) {
        MemoryDaoImpl memoryDao = new MemoryDaoImpl();
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        VendorDaoImpl vendorDao = new VendorDaoImpl();
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl();
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        StoreDaoImpl storeDao = new StoreDaoImpl();
        int am = store.getAmount();
        store.setAmount(am - amount);
        return storeDao.update(store);

    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from hw7.notes.domain.Notebook");
        query.setFirstResult(1);
        query.setMaxResults(size);
        return (List<Notebook>)query.list();
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Notebook n group by n.vendor having count(n.id) > :amount ");
        query.setParameter("amount", amount);
        return query.list();
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Notebook n having n.cpu.vendor =:cpuVendor");
        query.setParameter("cpuVendor", cpuVendor);
        return query.list();
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Notebook n having n.cpu.vendor =:cpuVendor");
        return query.list();
    }

    @Override
    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select v from Store s, Notebook n, Vendor v where s.noteBook=n and n.vendor=v");
            List res = query.list();
            Set<Vendor> setVendor = new HashSet<>();
            for (Iterator iter = res.iterator(); iter.hasNext();) {
                setVendor.add((Vendor) iter.next());
            }
            Map<Vendor,List<Notebook>> longListMap = new HashMap<>();
            for (Vendor vendor:setVendor){
                Query query1 = session.createQuery("select n from Store s join s.noteBook n join n.vendor v where v.id=:id");
                query1.setParameter("id", vendor.getId());
                longListMap.put(vendor,query1.list());
            }
            return longListMap;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public Map<Date, Double> getSalesByDays() {
        Session session = factory.openSession();
        Map<Date, Double> map = new TreeMap<>();
        Query query = session.createQuery("select c.date, avg (c.amount) from Sales c join c.store p group by c.date");
        List list = query.list();
        for(int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) list.get(i);
            map.put((Date)obj[0], (Double)obj[1]);
        }
        return map;
    }
}
