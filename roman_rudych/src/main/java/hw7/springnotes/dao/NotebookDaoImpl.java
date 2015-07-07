package hw7.springnotes.dao;

import hw7.springnotes.dao.NotebookDao;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Роман on 25.06.2015.
 */
@Repository
public class NotebookDaoImpl implements NotebookDao {

    @Autowired
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        return (Long)factory.getCurrentSession().save(notebook);
    }

    @Override
    public Notebook read(Long id) {
        return (Notebook)factory.getCurrentSession().get(Notebook.class, id);
    }

    @Override
    public boolean update(Notebook notebook) {
        boolean result;
        factory.getCurrentSession().update(notebook);
        result = true;
        return result;
    }

    @Override
    public boolean delete(Notebook notebook) {
        boolean result;
        factory.getCurrentSession().delete(notebook);
        result = true;
        return result;
    }

    @Override
    public List<Notebook> findAll() {
        return factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Notebook").list();
    }

    @Override
    public List getNotebooksByPortion(int portion) {
        Query query = factory.getCurrentSession().createQuery("select s.notebookType from hw7.springnotes.domain.Store s," +
                " hw7.springnotes.domain.Notebook n where s.notebookType=n");
        query.setFirstResult(0);
        query.setMaxResults(portion);
        return query.list();
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        Query query = factory.getCurrentSession().createQuery("select s.notebookType from hw7.springnotes.domain.Store s, " +
                "hw7.springnotes.domain.Notebook n" +
                "  where s.notebookType=n and s.notebooksQuantity > :amount");
        query.setParameter("amount", amount);
        return query.list();
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        Query query = factory.getCurrentSession().createQuery("select n from hw7.springnotes.domain.Notebook n, " +
                "hw7.springnotes.domain.CPU cpu, hw7.springnotes.domain.Vendor v" +
                "  where n.cpu=cpu and cpu.vendor=v and n.cpu.vendor=:cpuVendor");
        query.setParameter("cpuVendor", cpuVendor);
        return query.list();
    }

    @Override
//    public List getNotebooksStorePresent() {
//        Query query = factory.getCurrentSession().createQuery("select s.notebookType from hw7.springnotes.domain.Store s");
//        return query.list();
//    }

    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Query query = factory.getCurrentSession().createQuery("select n.vendor, s.notebookType from hw7.springnotes.domain.Store s," +
                "hw7.springnotes.domain.Notebook n, hw7.springnotes.domain.Vendor v where s.notebookType=n and " +
                "n.vendor=v and s.notebooksQuantity>0");
        Iterator iter = query.list().iterator();
        Map<Vendor, List<Notebook>> resultMap = new HashMap<>();
        Object[] array;
        while(iter.hasNext()) {
            array = (Object[])iter.next();
            if(!resultMap.containsKey((Vendor)array[0])) {
                List<Notebook> list = new ArrayList<>();
                list.add((Notebook)array[1]);
                resultMap.put((Vendor)array[0], list);
            } else {
                List<Notebook> existingList = resultMap.get((Vendor) array[0]);
                existingList.add((Notebook)array[1]);
                resultMap.put((Vendor) array[0], existingList);
            }
        }
        return resultMap;
    }

    @Override
    public Map<Date, Double> getSalesByDays() {
        Session session = factory.openSession();
        Query query = session.createQuery("select sale.salesDate, avg(sale.salesQuantity) " +
                "from hw7.springnotes.domain.Sales sale, hw7.springnotes.domain.Store s, " +
                "hw7.springnotes.domain.Notebook n where sale.store = s and s.notebookType = n group by sale.salesDate");
        Iterator iter = query.list().iterator();
        Map<Date, Double> resultMap = new HashMap<>();
        Object[] array;
        while(iter.hasNext()) {
            array = (Object[])iter.next();

            resultMap.put((Date)array[0], (Double)array[1]);
        }
        return resultMap;
    }
}
