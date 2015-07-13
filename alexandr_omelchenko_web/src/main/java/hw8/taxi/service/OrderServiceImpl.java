package hw8.taxi.service;

import hw8.taxi.dao.OrderDaoImpl;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDaoImpl orderDao;

    public OrderServiceImpl() {
    }
    public OrderServiceImpl(OrderDaoImpl orderDao) {
        this.orderDao = orderDao;
    }

    public OrderDaoImpl getOrderDao() {
        return orderDao;
    }
    public void setOrderDao(OrderDaoImpl orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public boolean createOrder(Double price, String adressCl, String adressDest, Date date, Client client) throws OrderException {
       orderDao.create(new Order(price, adressCl, adressDest, date, client));
        return true;
    }
    @Override
    @Transactional(readOnly = true)
    public Order getOrder(Long id) {
        return orderDao.read(id);
    }
    @Override
    public void update(Order order) {
        orderDao.update(order);
    }
}
