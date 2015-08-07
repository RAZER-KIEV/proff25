package hw8.taxi.dao;

import hw8.taxi.domain.Order;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Роман on 04.08.2015.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    public OrderDaoImpl() {
    }

    @Autowired(required = true)
    SessionFactory sessionFactory;

    @Override
    public Long create(Order order) {
        return (Long)sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order read(Long id) {
        return (Order)sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public boolean update(Order order) {
        boolean result;
        sessionFactory.getCurrentSession().update(order);
        result = true;
        return result;
    }

    @Override
    public boolean delete(Order order) {
        boolean result;
        sessionFactory.getCurrentSession().delete(order);
        result = true;
        return result;
    }

    @Override
    public List showOrders(Long from, Long to) {

        Query query = sessionFactory.getCurrentSession().createQuery("from hw8.taxi.domain.Order o " +
                "where o.sum>:from and o.sum<:to");
        query.setParameter("from", Long.valueOf(from).doubleValue());
        query.setParameter("to", Long.valueOf(to).doubleValue());
        return query.list();
    }

    @Override
    public List showOrdersByPortion(int from, int portion) {
        Query query = sessionFactory.getCurrentSession().createQuery("from hw8.taxi.domain.Order o");
        query.setFirstResult(from);
        query.setMaxResults(portion);
        return query.list();
    }
}
