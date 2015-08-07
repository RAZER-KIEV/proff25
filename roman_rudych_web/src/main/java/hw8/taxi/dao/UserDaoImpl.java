package hw8.taxi.dao;

import hw8.taxi.domain.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Роман on 11.07.2015.
 */
@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {}

    @Autowired
    SessionFactory factory;

    @Override
    public Long create(User user) {
        return (Long)factory.getCurrentSession().save(user);
    }

    @Override
    public User read(Long id) {
        return (User)factory.getCurrentSession().get(User.class, id);
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

    public User getByName(String name) {
        Query query = factory.getCurrentSession().createQuery("select u from hw8.taxi.domain.User u " +
                "where u.name =:name");
        query.setParameter("name", name);
        return (User)query.uniqueResult();
    }

    @Override
    public List findAll() {

        return factory.getCurrentSession().createQuery("select u from hw8.taxi.domain.User u").list();
    }

    @Override
    public boolean isExistingSpecId(String id) {
        Query query = factory.getCurrentSession().createQuery("select u from hw8.taxi.domain.User u " +
                "where u.specId = :id");
        query.setParameter("id", id);
        int size = query.list().size();
        if(size != 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean isExistingName(String name) {
        Query query = factory.getCurrentSession().createQuery("select u from hw8.taxi.domain.User u " +
                "where u.name = :name");
        query.setParameter("name", name);
        int size = query.list().size();
        if(size != 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean authenticate(String login, String pass) {
        Query query = factory.getCurrentSession().createQuery("select u from hw8.taxi.domain.User u " +
                "where u.name=:name and u.password=:pass");
        query.setParameter("name", login);
        query.setParameter("pass", pass);
        if(query.list().size() == 1) {
            return true;
        } else{
            return false;
        }
    }
}
