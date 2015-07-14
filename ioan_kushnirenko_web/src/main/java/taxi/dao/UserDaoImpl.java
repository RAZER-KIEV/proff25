package taxi.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw8.taxi.dao
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(User user) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public User read(Long ig) {
        Session session = factory.openSession();
        try {
            return (User)session.get(User.class,ig);
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(User user) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(User user) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from USER");
        return query.list();
    }
}