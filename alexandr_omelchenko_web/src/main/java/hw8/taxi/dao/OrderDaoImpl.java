package hw8.taxi.dao;

import hw8.taxi.domain.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private SessionFactory factory;

    public OrderDaoImpl() {
    }
    public OrderDaoImpl(SessionFactory sessionFactory){
        this.factory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return factory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    @Override
    public Long create(Order order) {
        return (Long)factory.getCurrentSession().save(order);
    }
    @Override
    public Order read(Long id)  {
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
    @Override
    public List findAll() {
        List<Order>list;
        list =factory.getCurrentSession().createQuery("from Order").list();
        return list;
    }
}