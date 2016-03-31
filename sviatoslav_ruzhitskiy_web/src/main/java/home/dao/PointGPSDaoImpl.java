package home.dao;

import home.domain.PointGPS;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Repository
public class PointGPSDaoImpl implements PointGPSDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long create(PointGPS pointGPS) {
        return (Long)sessionFactory.getCurrentSession().save(pointGPS);
    }

    @Override
    public PointGPS read(Long id) {
        return (PointGPS)sessionFactory.getCurrentSession().get(PointGPS.class, id);
    }

    @Override
    public boolean update(PointGPS pointGPS) {
        sessionFactory.getCurrentSession().update(pointGPS);
        return true;
    }

    @Override
    public boolean delete(PointGPS pointGPS) {
        sessionFactory.getCurrentSession().delete(pointGPS);
        return true;
    }

    @Override
    public List findAll() {
        List<PointGPS> pointGPSList;
        Query query = sessionFactory.getCurrentSession().createQuery("from PointGPS");
        pointGPSList = query.list();
        return pointGPSList;
    }
}
