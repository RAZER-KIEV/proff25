package hw8.taxi.dao;

import hw8.taxi.domain.Order;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private static final int STEP_PORCED =5;
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
        return (Long)factory.getCurrentSession().save(order);
    }

    @Override
    public Order read(Long id) {
        return (Order)factory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public boolean update(Order order) {
        factory.getCurrentSession().update(order);
        return true;
    }

    @Override
    public boolean delete(Order order) {
        factory.getCurrentSession().delete(order);
        return true;
    }

    public Long getCount(){
        return (Long)factory.getCurrentSession().createQuery("select COUNT(o.id) from Order o").uniqueResult();
    }

    @Override
    public List<Order> getOrdersBySum(Long from, Long to) {
        Query query = factory.getCurrentSession().createQuery("from Order o where o.amount>:fromA and o.amount<:toA");
        query.setParameter("fromA",from);
        query.setParameter("toA",to);
        return query.list();
    }

    @Override
    public List<Order> getOrdersByPortion() {
        return findAll();
    }

    @Override
    public List<Order> getOrdersPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("from Order");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            orders.addAll(getOrdersPorced(i, STEP_PORCED));
        }
        return orders;
    }
}
