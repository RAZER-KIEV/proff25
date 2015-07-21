package hw8.taxi.dao;

import hw8.taxi.domain.Order;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vlad on 12.04.2015.
 */

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public void createOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order readOrder(Long id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public List showOrders(Long from, Long to) {

        return sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.between("orderSum", from.intValue(), to.intValue())).list();
    }

    @Override
    public List showOrdersByPortion() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).setMaxResults(5).list();
    }
}
