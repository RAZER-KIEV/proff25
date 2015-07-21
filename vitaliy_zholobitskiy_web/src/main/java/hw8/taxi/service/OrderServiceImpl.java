package hw8.taxi.service;

import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by just1ce on 16.07.2015.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        return orderDao.create(new Order(id,addressFrom,addressTo,new Date(),Long.parseLong(amount),client))!=null;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {

            Order order = orderDao.readById(id);
            order.setAddressEnd(addressTo);
            order.setAddressStart(addressFrom);
            order.setClient(client);
            order.setDate(new Date());
            order.setSum(Long.parseLong(amount));
        orderDao.update(order);

    }

    @Override
    public List showOrders(Long from, Long to) {
        return orderDao.showOrders(from,to);
    }

    @Override
    public List showOrdersByPortion() {
        return orderDao.showOrdersByPortion();
    }
}
