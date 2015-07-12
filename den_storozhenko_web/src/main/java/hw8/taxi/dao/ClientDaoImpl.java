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
 * Created by storo_000 on 10.07.2015.
 */
@Repository
public class ClientDaoImpl implements ClientDao {
    private static final int STEP_PORCED =10;
    @Autowired
    private SessionFactory factory;

    public ClientDaoImpl() {
    }

    public ClientDaoImpl(SessionFactory sessionFactory){
        this.factory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return factory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

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
        factory.getCurrentSession().update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        factory.getCurrentSession().delete(client);
        return true;
    }

    @Override
    public List<Client> showClientsGtSum(int sum) {
        return factory.getCurrentSession().createQuery("from Client c where c.cash>'"+sum+"'").list();
    }

    @Override
    public List<Client> showClientsLastMonth() {
        long weekTime = 30 * 24 * 60 * 60 * 1000;
        Date date = new Date(System.currentTimeMillis()+weekTime);
        Query query = factory.getCurrentSession().createQuery("from Client c where c.dateLastOrder<>null and c.dateLastOrder>:date");
        query.setParameter("date",date);
        return query.list();
    }

    public Long getCount(){
        return (Long)factory.getCurrentSession().createQuery("select COUNT(c.id) from Client c").uniqueResult();
    }

    @Override
    public List<Client> getClientsPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("from Client");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Client> showClientsByPortion(int portionSize) {
        List<Client> clients = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=portionSize){
            clients.addAll(getClientsPorced(i, portionSize));
        }
        return clients;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            clients.addAll(getClientsPorced(i, STEP_PORCED));
        }
        return clients;
    }
}
