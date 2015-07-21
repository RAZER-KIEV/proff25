package scrum.taxi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import scrum.taxi.domain.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory factory;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(User user) {
        return (Long)factory.getCurrentSession().save(user);
    }

    @Override
    public User read(Long id) {
        return (User)factory.getCurrentSession().get(User.class,id);
    }

    @Override
    public boolean auth(String login, String password) {
        Query query = factory.getCurrentSession().createQuery("from User u where u.login=:login and u.password=:pass");
        query.setParameter("login",login);
        query.setParameter("pass",password);
        return !query.list().isEmpty();
    }

    @Override
    public boolean update(User user) {
        factory.getCurrentSession().update(user);
        return true;
    }

    @Override
    public boolean delete(User user) {
        factory.getCurrentSession().delete(user);
        return true;
    }

    @Override
    public List<User> findAll() {
        return factory.getCurrentSession().createQuery("from User").list();
    }
}
