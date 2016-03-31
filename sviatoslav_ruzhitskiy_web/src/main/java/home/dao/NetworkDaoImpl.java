package home.dao;

import home.domain.Network;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RAZER on 2/8/2016.
 */

@Repository
public class NetworkDaoImpl implements NetworkDao{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public Long create(Network network) {
        return (Long) sessionFactory.getCurrentSession().save(network);
    }

    @Override
    public Network read(Long id) {
        return (Network) sessionFactory.getCurrentSession().get(Network.class, id);
    }

    @Override
    public boolean update(Network network) {
        sessionFactory.getCurrentSession().update(network);
        return true;
    }

    @Override
    public boolean delete(Network network) {
        sessionFactory.getCurrentSession().delete(network);
        return true;
    }

    @Override
    public List findAll() {
        List<Network> networkList;
        Query query = sessionFactory.getCurrentSession().createQuery("from Network");
        networkList = query.list();
        return networkList;
    }
}
