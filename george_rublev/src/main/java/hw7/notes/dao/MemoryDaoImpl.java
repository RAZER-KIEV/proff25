package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 27.06.15.
 */

public class MemoryDaoImpl implements MemoryDao {
    private static final int STEP_PORCED =10;
    private SessionFactory factory;

    public MemoryDaoImpl(){

    }

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(memory);
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
    public Memory read(Long id) {
        Session session = factory.openSession();
        try{
            return (Memory)session.get(Memory.class,id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(memory);
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

    public Long getCount(){
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select COUNT(m.id) from Memory m");
            return (Long) query.uniqueResult();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Memory> getMemoriesPorced(int start, int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Memory");
            query.setFirstResult(start);
            query.setMaxResults(size);
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Memory> findAll() {
        List<Memory> memories = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            memories.addAll(getMemoriesPorced(i, STEP_PORCED));
        }
        return memories;
    }
}
