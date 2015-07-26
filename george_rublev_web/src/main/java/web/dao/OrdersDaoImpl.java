package web.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.domain.Orders;

import java.util.List;

//import web.domain.Orders;

/**
 * Created by george on 26.07.15.
 */
@Repository
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public OrdersDaoImpl() {
    }

    public OrdersDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Orders order) {
        return (Long) sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Orders read(Integer id) {
        return (Orders) sessionFactory.getCurrentSession().get(Orders.class, id);
    }

    @Override
    public List<Orders> listOrder() {
        Query query = sessionFactory.getCurrentSession().createQuery("from web.domain.Orders");
        return query.list();
    }
    @Override
    public boolean update(Orders order) {
        sessionFactory.getCurrentSession().update(order);
        return true;
    }

//    @Override
//    public boolean delete(Orders order) {
//        sessionFactory.getCurrentSession().delete(order);
//        return true;
//
//    }

    @Override
    public void delete(Integer id) {
        sessionFactory.getCurrentSession().delete(id);
    }
}
