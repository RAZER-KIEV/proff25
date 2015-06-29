package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 */
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    private void checkFactory(){
        if (factory==null){
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
    public Long create(CPU cpu) {
        checkFactory();
        Session session = factory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(cpu);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            log.error("ERROR: Cannot create new cpu - TRANSACTION FAILED.",e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return id;
    }
    @Override
    public CPU read(Long ig) {
        checkFactory();
        Session session = factory.openSession();
        try {
            return (CPU)session.get(CPU.class,ig);
        } catch (HibernateException e){
            log.error("ERROR: Cannot read cpu by id: "+ig+". READ FAILED.",e);
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return null;
    }
    @Override
    public boolean update(CPU cpu) {
        checkFactory();
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            log.info(session);
            return true;
        }catch (HibernateException e){
            log.error("ERROR: Cannot update cpu: "+cpu+". UPDATE FAILED.",e);
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }
    @Override
    public boolean delete(CPU cpu) {
        checkFactory();
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("ERROR: Cannot delete cpu: "+cpu+". DELETE FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if (session!=null){
                session.close();
            }
        }
    }
    @Override
    public List<CPU> findAll() {
        checkFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.CPU");
        return query.list();
    }

    public static void main(String[] args) {

    }
}
