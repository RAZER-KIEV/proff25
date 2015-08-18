package hw8.taxi.service;

import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sveta on 8/17/2015.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        return orderDao.createOrder(id, client, amount, addressFrom, addressTo);
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        orderDao.editOrder(id, client, amount, addressFrom, addressTo);

    }

    @Override
    public List showOrders(Long from, Long to) {
        return orderDao.showOrders(from, to);
    }

    @Override
    public List showOrdersByPortion() {
        return orderDao.showOrdersByPortion();
    }
}
