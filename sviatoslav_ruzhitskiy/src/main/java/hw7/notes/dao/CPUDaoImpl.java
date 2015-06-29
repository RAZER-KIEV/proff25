package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ПК on 25.06.2015.
 */
public class CPUDaoImpl implements CPUDao{
    private SessionFactory sessionFactory;

    public CPUDaoImpl(){}

    public CPUDaoImpl(SessionFactory sf) {
        sessionFactory = sf;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(cpu);
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
    public CPU read(Long id) {
        Session session = sessionFactory.openSession();
        CPU cpu = null;
        try {
            cpu = (CPU) session.get(CPU.class,id);
        }catch (HibernateException hEx){
            System.out.println("Exception: Not readed!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return cpu;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = sessionFactory.openSession();
        boolean upres = false;
        try {
            session.beginTransaction();
            session.update(cpu);
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
    public boolean delete(CPU cpu) {
        Session session = sessionFactory.openSession();
        boolean res;
        try {
            session.beginTransaction();
            session.delete(cpu);
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
        Query query = session.createQuery("FROM CPU");
        return query.list();
    }
}
