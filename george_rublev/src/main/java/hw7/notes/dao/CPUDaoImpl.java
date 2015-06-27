package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 27.06.15.
 */
public class CPUDaoImpl implements CPUDao {

    private static final int STEP_PORCED =10;
    private SessionFactory factory;

    public CPUDaoImpl(){

    }

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public Long create(CPU cpu) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(cpu);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
        return id;
    }

    @Override
    public CPU read(Long id) {
        Session session = factory.openSession();
        try{
            return (CPU)session.get(CPU.class,id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public List getCpuPorced(int start, int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select COUNT(c.id) from CPU c");
            return (List) query.uniqueResult();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List findAll() {
        List<CPU> cpus = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            cpus.addAll(getCpuPorced(i,STEP_PORCED));
        }
        return cpus;
    }

    public Long getCount(){
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select COUNT(c.id) from CPU c");
            return (Long) query.uniqueResult();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

}
