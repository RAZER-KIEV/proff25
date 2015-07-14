package comandWork.dao;

import comandWork.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by julia on 7/14/15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory factory;

    public UserDaoImpl() {

    }

    public UserDaoImpl (SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public Long create(User user) {
        return (Long)factory.getCurrentSession().save(user);
    }

    @Override
    public User read(Long id) {
        return (User)factory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User readByName(String login) {
        return (User)factory.getCurrentSession().get(User.class, login);
    }

    @Override
    public boolean update(User user) {
        boolean result;
        factory.getCurrentSession().update(user);
        result = true;
        return result;
    }

    @Override
    public boolean delete(User user) {
        boolean result;
        factory.getCurrentSession().delete(user);
        result = true;
        return result;
    }

    @Override
    public List findAll() {
        return factory.getCurrentSession().createQuery("from comandWork.domain.User").list();
    }
}
