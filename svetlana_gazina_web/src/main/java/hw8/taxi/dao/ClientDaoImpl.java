package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sveta on 8/13/2015.
 */
@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Client client) {
        return (Long)sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public List showClientsByPortion(int portionSize) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Client");
        query.setFirstResult(1);
        query.setMaxResults(portionSize);

        return query.list();

    }

    @Override
    public Client read(Long id) {
        return (Client)sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        sessionFactory.getCurrentSession().update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        sessionFactory.getCurrentSession().delete(client);
        return true;


    }

    @Override
    public Client searchByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Client c where c.login = :login");
        query.setParameter("login",login);
        return (Client)query.uniqueResult();
    }

    @Override
    public List findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Client");
        return query.list();
    }

    @Override
    public List showClientsGtSum(int sums) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Client c where c.sum > :sums");
        query.setParameter("sums", sums);
        return query.list();
    }

    @Override
    public List showClientsLastMonth() {
        Date dat = new Date();
        Query query = sessionFactory.getCurrentSession().createQuery("from Client c where :dat - 31 < c.lastOrderDay");
        query.setDate("dat", dat);
        return query.list();
    }
}
