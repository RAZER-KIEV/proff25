package taxi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.Client;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by oleg on 16.07.15.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Client> clientsPortinedByTen(Long numberOfPortion) {
        Query query = factory.getCurrentSession().createQuery("from Client");
        query.setFirstResult((int) ((numberOfPortion - 1)*10 + 1));
        query.setMaxResults(10);
        return query.list();
    }

    @Override
    public List<Client> clientsMadeOrdersDuringLastMonth() {

        LocalDateTime oneMonthBeforeTimeStamp = LocalDateTime.now().minusMonths(1);
        Query query = factory.getCurrentSession().createQuery("from Client as c where c.lastOrderDate>:time");
        query.setParameter("time", oneMonthBeforeTimeStamp);
        return query.list();
    }

    @Override
    public List<Client> clientswithOrderAmountMoreThen(Long amount) {
        Query query = factory.getCurrentSession().createQuery("from Client as o where o.money>=:frompoint");
        query.setParameter("frompoint", amount);
        return query.list();
    }

    @Override
    public Long create(Client client) {
        return (Long)factory.getCurrentSession().save(client);
    }

    @Override
    public Client read(Long Id) {
        return (Client)factory.getCurrentSession().get(Client.class, Id);
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
    public List<Client> findAll() {
        Query query = factory.getCurrentSession().createQuery("from Client");
        return query.list();
    }
}
