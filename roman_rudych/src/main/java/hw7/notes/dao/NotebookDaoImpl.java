package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

/**
 * Created by Роман on 25.06.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

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
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            log.error("Saving error", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        Notebook notebook = null;
        notebook = (Notebook)session.get(Notebook.class, id);
        session.close();
        log.info(session);
        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException ex) {
            log.error("Updating error", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return result;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException ex) {
            log.error("Deleting fail", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return result;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Notebook");
        return query.list();
    }

    public List getNotebooksByPortion(int portion) {
        Session session = factory.openSession();
        Query query = session.createQuery("select s.notebookType from hw7.notes.domain.Store s, hw7.notes.domain.Notebook n where s.notebookType=n");
        query.setFirstResult(0);
        query.setMaxResults(portion);
        return query.list();
    }

    public List getNotebooksGtAmount(int amount) {
        Session session = factory.openSession();
        Query query = session.createQuery("select s.notebookType from hw7.notes.domain.Store s, hw7.notes.domain.Notebook n" +
                "  where s.notebookType=n and s.notebooksQuantity > :amount");
        query.setParameter("amount", amount);
        return query.list();

    }

    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("select n from hw7.notes.domain.Notebook n, " +
                "hw7.notes.domain.CPU cpu, hw7.notes.domain.Vendor v" +
                "  where n.cpu=cpu and cpu.vendor=v and n.cpu.vendor=:cpuVendor");
        query.setParameter("cpuVendor", cpuVendor);
        return query.list();
    }

//    public List getNotebooksStorePresent() {
//        Session session = factory.openSession();
//        Query query = session.createQuery("select s.notebookType from hw7.notes.domain.Store s");
//        return query.list();
//    }

    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Session session = factory.openSession();
        Query query = session.createQuery("select n.vendor, s.notebookType from hw7.notes.domain.Store s," +
                "hw7.notes.domain.Notebook n, hw7.notes.domain.Vendor v where s.notebookType=n and " +
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

    public Map<Date, Double> getSalesByDays() {
        Session session = factory.openSession();
        Query query = session.createQuery("select sale.salesDate, avg(sale.salesQuantity) " +
                "from hw7.notes.domain.Sales sale, hw7.notes.domain.Store s, " +
                "hw7.notes.domain.Notebook n where sale.store = s and s.notebookType = n group by sale.salesDate");
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
