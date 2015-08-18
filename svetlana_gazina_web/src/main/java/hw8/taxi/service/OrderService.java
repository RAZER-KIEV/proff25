package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Sveta on 8/17/2015.
 */
public interface OrderService {
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);
    List showOrders(Long from, Long to);
    List showOrdersByPortion();
}
