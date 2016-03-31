package home.dao;

import home.domain.Office;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RAZER on 11-Mar-16.
 */

@Repository
public class OfficeDaoImpl implements OfficeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long create(Office office) {
        return (Long) sessionFactory.getCurrentSession().save(office);
    }

    @Override
    public Office read(Long id) {
        return (Office) sessionFactory.getCurrentSession().get(Office.class, id);
    }

    @Override
    public boolean update(Office office) {
        sessionFactory.getCurrentSession().update(office);
        return true;
    }

    @Override
    public boolean delete(Office office) {
        sessionFactory.getCurrentSession().delete(office);
        return true;
    }

    @Override
    public List findAll(Long networkId) {
        List<Office> officesList;
        Query query = sessionFactory.getCurrentSession().createQuery("from Office o where o.networkId=:id");
        query.setParameter("id",networkId);
        officesList = query.list();
        return officesList;
    }
}
