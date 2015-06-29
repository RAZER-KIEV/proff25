package hw7.notes.dao;

import android.provider.ContactsContract;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.*;

/**
 * Created by ivan on 24.06.15.
 */
public class NotebookDaoImpl implements NotebookDao {

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    private void checkFactory() {
        if (factory == null) {
            Configuration cfg = new Configuration()
                    .addAnnotatedClass(hw7.notes.domain.Notebook.class)
                    .addAnnotatedClass(hw7.notes.domain.Vendor.class)
                    .addAnnotatedClass(hw7.notes.domain.CPU.class)
                    .addAnnotatedClass(hw7.notes.domain.Memory.class)
                    .addAnnotatedClass(hw7.notes.domain.Store.class)
                    .addAnnotatedClass(hw7.notes.domain.Sales.class)
                    .configure("hw7/hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            factory = cfg.buildSessionFactory(standardServiceRegistry);
        }
    }

    @Override
    public Long create(Notebook notebook) {
        checkFactory();
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(notebook);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("ERROR: Cannot create new notebook - TRANSACTION FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return id;
    }

    @Override
    public Notebook read(Long ig) {
        checkFactory();
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, ig);
        } catch (HibernateException e) {
            log.error("ERROR: Cannot read notebook by id: " + ig + ". READ FAILED.", e);
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return null;
    }

    @Override
    public boolean update(Notebook notebook) {
        checkFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            log.info(session);
            return true;
        } catch (HibernateException e) {
            log.error("ERROR: Cannot update notebook: " + notebook + ". UPDATE FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(Notebook notebook) {
        checkFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("ERROR: Cannot delete notebook: " + notebook + ". DELETE FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Notebook> findAll() {
        checkFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Notebook");
        return query.list();
    }

    public List<Notebook> getPortionOfNotebooks(int i) {
        checkFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from hw7.notes.domain.Notebook");
            query.setFirstResult(0);
            query.setMaxResults(i);
            return query.list();
        } catch (HibernateException e) {
            log.error("ERROR: cannot get portion of notebooks.");
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        checkFactory();
        Session session = factory.openSession();
        List<Notebook> notebooks = null;
        try {
            Query query = session.createQuery("select n from Store s, Notebook n, Vendor v where s.notebook=n and n.vendor=v and v.name=:name");
            query.setParameter("name", cpuVendor);
            notebooks = query.list();
        } catch (HibernateException e) {
            log.error("ERROR: Cannot get notebooks by CPU vendor.");
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return notebooks;
    }

    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select v from Store s, Notebook n, Vendor v where s.notebook=n and n.vendor=v");
            List res = query.list();
            Set<Vendor> setVendor = new HashSet<>();
            for (Iterator iter = res.iterator(); iter.hasNext(); ) {
                setVendor.add((Vendor) iter.next());
            }
            Map<Vendor, List<Notebook>> resultMap = new HashMap<>();
            for (Vendor vendor : setVendor) {
                Query query1 = session.createQuery("select n from Store s join s.notebook n join n.vendor v where v.id=:id");
                query1.setParameter("id", vendor.getId());
                resultMap.put(vendor, query1.list());
            }
            return resultMap;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) {

    }
}
