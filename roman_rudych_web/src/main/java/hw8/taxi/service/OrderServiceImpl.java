package hw8.taxi.service;

import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 04.08.2015.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Transactional
    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        if(client==null) {
            throw new OrderException("Client is null");
        }
        Long newId = orderDao.create(new Order(new Date(System.currentTimeMillis()), client,
                Double.parseDouble(amount), addressFrom, addressTo));
        if(newId > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        Order updatedOrder = new Order(new Date(System.currentTimeMillis()), client, Double.parseDouble(amount),
                addressFrom, addressTo);
        updatedOrder.setId(id);
        orderDao.update(updatedOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public List showOrders(Long from, Long to) {
        return orderDao.showOrders(from, to);
    }

    @Override
    @Transactional(readOnly = true)
    public List showOrdersByPortion() {
        return orderDao.showOrdersByPortion(0, 5);
    }
}
