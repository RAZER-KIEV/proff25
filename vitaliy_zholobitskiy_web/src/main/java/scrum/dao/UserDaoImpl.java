package scrum.dao;

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
    public User readUser(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User readByName(String name) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("clientName", name)).uniqueResult();
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
    public User auth(String name, String password) {
        User user = null;
        try {
            user = (User) readByName(name);

        } catch (Exception ex) {
            if (user.getUserPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }
        return user;
    }
}
