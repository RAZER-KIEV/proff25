package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.List;

public interface OrderService {
    Order getOrder(Long id);
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    boolean createOrder(Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    List findAll();
    List showOrders(Long from, Long to);
    List showOrdersByPortion();
}
