package comandWork.dao;

import comandWork.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by julia on 7/14/15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static Logger log = Logger.getLogger(UserDao.class);
    private SessionFactory factory;

    public UserDaoImpl() {

    }

    public UserDaoImpl (SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(User user) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public User read(Long id) {
        Session session = factory.openSession();
        return (User)session.get(User.class, id);
    }

    @Override
    public User readByName(String login) {
        Session session = factory.openSession();
        return (User)session.get(User.class, login);
    }

    @Override
    public boolean update(User user) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            e.printStackTrace();
            session.getTransaction().rollback();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(User user) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            e.printStackTrace();
            session.getTransaction().rollback();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        return session.createQuery("from comandWork.domain.User").list();
    }


}
