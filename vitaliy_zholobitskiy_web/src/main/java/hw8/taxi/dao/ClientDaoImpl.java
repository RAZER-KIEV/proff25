package hw8.taxi.dao;

import hw8.taxi.domain.Client;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by just1ce on 16.07.2015.
 */
@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private SessionFactory sessionFactory;

    public ClientDaoImpl() {
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Client client) {
        return (Long) sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public Client read(Long id) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
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
    public List showClientsGtSum(int sum) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Client c where c.sum>:sum");
        query.setParameter("sum",sum);
        return query.list();
    }

    @Override
    public List showClientsLastMonth() {
        Date now = new Date();
        Date date;
        if(now.getMonth()==0){
            date = new Date(now.getYear()-1, 12, now.getDay());
        }
        else {
            date = new Date(now.getYear(), now.getMonth()-1, now.getDay());
        }
        Query query = sessionFactory.getCurrentSession().createQuery("from Client c where c.dateLastOrder>:date");
        query.setParameter("date",date);
        return query.list();
    }

    private List<Client> getPortion(int begin, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Client");
        query.setFirstResult(begin);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Client> showClientsByPortion(int portionSize) {
        List<Client> clients = new ArrayList<>();
        Long count = (Long)sessionFactory.getCurrentSession().createQuery("select COUNT(cl.id) from Client cl").uniqueResult();
        for (int i=0;i<count;i+=portionSize){
            clients.addAll(getPortion(i, portionSize));
        }
        return clients;
    }

}
