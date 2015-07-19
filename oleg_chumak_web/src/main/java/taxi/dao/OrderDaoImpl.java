package taxi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.Order;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory factory;

    public OrderDaoImpl() {
    }

    public OrderDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Order order) {
        return (Long) factory.getCurrentSession().save(order);
    }

    @Override
    public Order read(Long id) {
        return (Order) factory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public void update(Order order) {
        factory.getCurrentSession().update(order);
    }

    @Override
    public void delete(Order order) {
        factory.getCurrentSession().delete(order);
    }

    @Override
    public List listInRangeOfAmount(Long from, Long to) {
        Query query = factory.getCurrentSession().createQuery("from Order as o where o.amount>=:frompoint and o.amount<=:topoint");
        query.setParameter("frompoint", from);
        query.setParameter("topoint", to);
        return query.list();
    }

    @Override
    public List listChunk(int startPoint, int chunkSize) {
        Query query = factory.getCurrentSession().createQuery("from Order as o");
        query.setFirstResult(startPoint);
        query.setMaxResults(chunkSize);
        return query.list();
    }

    @Override
    public long getListSize() {
        return (long) factory.getCurrentSession().createQuery("select count (*) from Order as o").uniqueResult();
    }
}
