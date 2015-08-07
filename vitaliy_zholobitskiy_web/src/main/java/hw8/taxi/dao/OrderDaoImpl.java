package hw8.taxi.dao;

import hw8.taxi.domain.Order;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by just1ce on 16.07.2015.
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public OrderDaoImpl(){}

    @Override
    public Long create(Order order) {
        return (Long) sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order read(Long id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public Order readById(Long id) {
        Order order = (Order) sessionFactory.getCurrentSession().createQuery("from Order ord where ord.orderId="+id.toString()).uniqueResult();
        if (order!=null)
            return order;
        return null;
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
        Query query = sessionFactory.getCurrentSession().createQuery("from Order ord where ord.sum>:from and ord.sum<:to");
        query.setParameter("from",from);
        query.setParameter("to", to);
        return query.list();
    }

    private List<Order> getPortion(int begin, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Order");
        query.setFirstResult(begin);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List showOrdersByPortion() {
        List<Order> orders = new ArrayList<>();
        Long count = (Long)sessionFactory.getCurrentSession().createQuery("select COUNT(ord.orderId) from Order ord").uniqueResult();
        for (int i=0;i<count;i+=5){
            orders.addAll(getPortion(i, 5));
        }
        return orders;
    }

    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Order").list();
    }
}
