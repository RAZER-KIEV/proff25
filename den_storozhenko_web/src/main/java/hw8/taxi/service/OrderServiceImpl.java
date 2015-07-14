package hw8.taxi.service;

import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    public OrderServiceImpl() {
    }

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order getOrder(Long id) {
        return orderDao.read(id);
    }

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        try {
            if (orderDao.read(id)!=null){
                throw new OrderException("Order with id "+id+" exist.");
            }
            return orderDao.create(new Order(id, new Date(), client, Long.parseLong(amount), addressFrom, addressTo)) > 0;
        }
        catch (NumberFormatException e){
            throw new OrderException("Amount has been number.");
        }
        catch (HibernateException e){
            throw new OrderException("Database error.");
        }
    }

    @Override
    public boolean createOrder(Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        try {
            return orderDao.create(new Order(new Date(), client, Long.parseLong(amount), addressFrom, addressTo)) > 0;
        }
        catch (NumberFormatException e){
            throw new OrderException("Amount has been number.");
        }
        catch (HibernateException e){
            throw new OrderException("Database error.");
        }
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        try {

            Order order = orderDao.read(id);
            if (order==null){
                throw new OrderException("Order with id "+id+" does not exist.");
            }
            order.setClient(client);
            order.setAmount(Long.parseLong(amount));
            order.setAddressFrom(addressFrom);
            order.setAddressTo(addressTo);
            orderDao.update(order);
        }
        catch (NumberFormatException e){
            throw new OrderException("Amount has been number.");
        }
        catch (HibernateException e){
            throw new OrderException("Database error.");
        }
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> showOrders(Long from, Long to) {
        return orderDao.getOrdersBySum(from,to);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> showOrdersByPortion() {
        return orderDao.getOrdersByPortion();
    }
}
