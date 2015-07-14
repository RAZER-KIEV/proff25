package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ClientDaoHibernateImpl implements ClientDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Client client) {
        return (Long) factory.getCurrentSession().save(client);
    }

    @Override
    public Client read(Long id) {
        return (Client) factory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public void update(Client client) {
        factory.getCurrentSession().update(client);
    }

    @Override
    public void delete(Client client) {
        factory.getCurrentSession().delete(client);
    }

    @Override
    public List listAll() {
        return factory.getCurrentSession().createQuery("from Client as c").list();
    }

    @Override
    public List listClientsGtSum(int sum) {
        Query query = factory.getCurrentSession().createQuery("from Client as c where c.totalMoneyAmount>:amount");
        query.setParameter("amount", (long) sum);
        return query.list();
    }

    @Override
    public List listClientsLastMonth() {
        LocalDateTime oneMonthBeforeTimeStamp = LocalDateTime.now().minusMonths(1);
        Query query = factory.getCurrentSession().createQuery("from Client as c where c.lastOrderDate>:time");
        query.setParameter("time", oneMonthBeforeTimeStamp);
        return query.list();
    }

    @Override
    public List listChunkOfClients(int startPoint, int chunkSize) {
        Query query = factory.getCurrentSession().createQuery("from Client as c");
        query.setFirstResult(startPoint);
        query.setMaxResults(chunkSize);
        return query.list();
    }

    @Override
    public long getListSize() {
        return (long) factory.getCurrentSession().createQuery("select count(*) from Client as c").uniqueResult();
    }
}
