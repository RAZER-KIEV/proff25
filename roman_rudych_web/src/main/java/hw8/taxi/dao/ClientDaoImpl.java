package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.ref.ReferenceQueue;
import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 16.07.2015.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    public ClientDaoImpl(){}

    @Autowired(required = true)
    private SessionFactory factory;

    @Override
    public Long create(Client client) {
        return (Long)factory.getCurrentSession().save(client);
    }

    @Override
    public Client read(Long id) {
        return (Client)factory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        boolean result;
        factory.getCurrentSession().update(client);
        result = true;
        return result;
    }

    @Override
    public boolean delete(Client client) {
        boolean result;
        factory.getCurrentSession().delete(client);
        result = true;
        return result;
    }

    @Override
    public List findAll() {
        return factory.getCurrentSession().createQuery("from hw8.taxi.domain.Client").list();
    }

    @Override
    public List findAll(int from, int portion) {
        Query query = factory.getCurrentSession().createQuery("from hw8.taxi.domain.Client");
        query.setFirstResult(from);
        query.setMaxResults(portion);
        return query.list();
    }

    @Override
    public List showClientsGtSum(int sum) {
        return factory.getCurrentSession().createQuery("select c from hw8.taxi.domain.Client c where" +
                " c.sum>"+sum).list();
    }

    @Override
    public List showClientsLastMonth() {
        return factory.getCurrentSession().createQuery("select c from hw8.taxi.domain.Client c where " +
                "c.lastOrderDate > (sysdate - 30)").list();
    }

    @Override
    public Client findByPhoneNum(String phoneNum) {

        Query query = factory.getCurrentSession().createQuery("select c from hw8.taxi.domain.Client c where " +
                "c.phoneNum=:phoneNum");
        query.setParameter("phoneNum", phoneNum);
        return (Client)query.uniqueResult();
    }
}