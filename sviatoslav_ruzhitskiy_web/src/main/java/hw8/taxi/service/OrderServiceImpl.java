package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {

    }

    @Override
    public List showOrders(Long from, Long to) {
        return null;
    }

    @Override
    public List showOrdersByPortion() {
        return null;
    }
}
