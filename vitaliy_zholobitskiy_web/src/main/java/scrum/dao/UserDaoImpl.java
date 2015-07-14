package scrum.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import scrum.domain.User;

/**
 * Created by Inna on 14.07.2015.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public Long readIdByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.userLogin=:login");
        query.setParameter("login",name);
        return  ((User)query.uniqueResult()).getId();

    }


    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);

    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);

    }

    @Override
    public boolean auth(String login, String pass) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User a where a.login=:login and a.pass=:pass");
        query.setParameter("login",login);
        query.setParameter("pass",pass);
        if (!query.list().isEmpty())
            return true;
        return false;
    }
}
