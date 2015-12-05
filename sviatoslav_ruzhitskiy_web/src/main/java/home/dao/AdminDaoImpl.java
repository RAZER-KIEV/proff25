package home.dao;

import home.domain.Admin;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Admin admin) {
        return (Long)sessionFactory.getCurrentSession().save(admin);
    }

    @Override
    public Admin read(Long id) {
        return (Admin)sessionFactory.getCurrentSession().get(Admin.class, id);
    }

    @Override
    public boolean update(Admin admin) {
        sessionFactory.getCurrentSession().update(admin);
        return true;
    }

    @Override
    public boolean delete(Admin admin) {
        sessionFactory.getCurrentSession().delete(admin);
        return true;
    }

    @Override
    public Admin searchByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Admin c where c.login=:login");
        query.setParameter("login",login);
        return (Admin)query.uniqueResult();
    }

    @Override
    public Long getDBSize() {
        Long size = (Long) sessionFactory.getCurrentSession().createQuery("select COUNT(c.id) from Admin c").uniqueResult();
        System.out.println("getDBSize: "+size);
        return size;
    }

    @Override
    public List findAll() {
        List<Admin> admins;
        Query query = sessionFactory.getCurrentSession().createQuery("from Admin");
        admins = query.list();
        return admins;
    }
}
