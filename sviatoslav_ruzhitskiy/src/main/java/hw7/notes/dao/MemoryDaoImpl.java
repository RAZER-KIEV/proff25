package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ПК on 25.06.2015.
 */

@Repository
public class MemoryDaoImpl implements MemoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public MemoryDaoImpl(){}

    public MemoryDaoImpl(SessionFactory sf) {
        sessionFactory = sf;
    }


    @Override
    public Long create(Memory memory) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(memory);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not saved!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }
    @Override
    public Memory read(Long id) {
        Session session = sessionFactory.openSession();
        Memory memory = null;
        try {
            memory = (Memory) session.get(Memory.class,id);
        }catch (HibernateException hEx){
            System.out.println("Exception: Not readed!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return memory;
    }
    @Override
    public boolean update(Memory memory) {
        Session session = sessionFactory.openSession();
        boolean upres = false;
        try {
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
            upres = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not updated!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return upres;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = sessionFactory.openSession();
        boolean res;
        try {
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
            res = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not deleted!");
            hEx.printStackTrace();
            res = false;
        }finally {
            if (session !=null)
                session.close();
        }
        return res;
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Memory");
        return query.list();
    }
}
