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
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.springnotes.domain.Notebook");
        return query.list();
    }

    @Override
    public List<Notebook> finaAllAtStoresbyPortion(int portion) {
        Session session = factory.openSession();
        Query query = session.createQuery("select s.notebookType from hw7.springnotes.domain.Store s join s.notebookType n");
        Set<Notebook> notebookSet = new HashSet<>();
        for(int i =0; i < query.list().size(); i++) {
            notebookSet.add((Notebook)query.list().get(i));
        }
        List<Notebook> notebookList = new ArrayList<>();
        int count = 0;
        for(Notebook ntb : notebookSet) {
            if(count == portion) {
                break;
            } else {
                notebookList.add(ntb);
                count++;
            }
        }
        return notebookList;
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        Session session = factory.openSession();
        Query query = session.createQuery("select s.notebookType from hw7.springnotes.domain.Store s where s.notebooksQuantity > :amount");
        query.setParameter("amount", amount);
        Set<Notebook> notebookSet = new HashSet<>();
        for(int i =0; i < query.list().size(); i++) {
            notebookSet.add((Notebook)query.list().get(i));
        }
        List<Notebook> notebookList = new ArrayList<>();
        for(Notebook ntb : notebookSet) {
                notebookList.add(ntb);
        }
        return notebookList;
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        List<Notebook> notebooksAllinStores = getNotebooksGtAmount(0);
        List<Notebook> notebooksByCpuVendor = new ArrayList<>();
        for(Notebook ntb : notebooksAllinStores) {
            if(ntb.getCpu().getVendor().equals(cpuVendor)) {
                notebooksByCpuVendor.add(ntb);
            }
        }
        return notebooksByCpuVendor;
    }

    @Override
    public List getNotebooksStorePresent() {
        Session session = factory.openSession();
        Query query = session.createQuery("select s.notebookType from hw7.springnotes.domain.Store s");
        return query.list();
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
