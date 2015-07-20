package hw8.taxi.dao;

import hw8.taxi.domain.Order;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
@Repository
public class OrderDaoImpl implements OrderDao{

    @Autowired
    SessionFactory sessionFactory;

    public OrderDaoImpl() {
    }

    @Override
    public Long create(Order order) {
        return (Long) sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order read(Long id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public boolean update(Order order) {
        sessionFactory.getCurrentSession().update(order);
        return true;
    }

    @Override
    public boolean delete(Order order) {
        sessionFactory.getCurrentSession().delete(order);
        return true;
    }

    @Override
    public List showOrders(Long from, Long to) {
        Double fromD = Double.parseDouble(String.valueOf(from));
        Double toD = Double.parseDouble(String.valueOf(to));
        Query query = sessionFactory.getCurrentSession().createQuery("from Order o where o.orderSum>:from and o.orderSum<:to");
        query.setParameter("from", fromD);
        query.setParameter("to", toD);
        return query.list();
    }

    @Override
    public List findAllbyPortion(int start, int quantity) {
        //List<Order> ordersList;
        Query query = sessionFactory.getCurrentSession().createQuery("from Order");
        query.setFirstResult(start);
        query.setMaxResults(quantity);
        return query.list();
    }


}
