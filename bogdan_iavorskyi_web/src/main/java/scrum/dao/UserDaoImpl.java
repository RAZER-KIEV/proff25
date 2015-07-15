package scrum.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import scrum.domain.User;

import java.util.List;

/**
 * Created by GFalcon on 14.07.15.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(User user) {
        return (Long) factory.getCurrentSession().save(user);
    }

    @Override
    public User read(Long id) {
        return (User) factory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void update(User user) {
        factory.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        factory.getCurrentSession().delete(user);

    }

    @Override
    public List listAll() {
        return factory.getCurrentSession().createQuery("from User as us").list();
    }
}
