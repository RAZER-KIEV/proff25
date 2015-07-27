package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.OrdersDao;
import web.domain.Orders;

import java.util.List;

/**
 * Created by george on 26.07.15.
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersDao ordersDao;

    public OrdersServiceImpl() {
    }

    public OrdersServiceImpl(OrdersDao orderDao) {
        this.ordersDao = orderDao;
    }
    @Autowired
    public OrdersDao getOrderDao() {
        return ordersDao;
    }

    public void setOrderDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    @Override
    public void addOrder(Orders order) {
        ordersDao.create(order);
    }

    @Transactional
    public List<Orders> listOrder() {
        return ordersDao.listOrder();
    }

    @Override
    public void removeOrder(Integer id) {
        ordersDao.delete(id);
    }

    @Override
    public Orders findOrder(Integer id) {
        return ordersDao.read(id);
    }

    //    @Transactional
//    public Long create(Orders order) {
//        return ordersDao.create(order);
//    }
//
//    @Transactional
//    public Orders read(Long id) {
//        return ordersDao.read(id);
//    }
//
//    @Transactional
//    public boolean update(Orders order) {
//        return ordersDao.update(order);
//    }
//
//    @Transactional
//    public boolean delete(Orders order) {
//        return ordersDao.delete(order);
//    }
}
