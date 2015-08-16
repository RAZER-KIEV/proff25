package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
public interface OrderService {
    Order read(Long ig);
    boolean updateOrder(Order order);
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    List showOrders(Long from, Long to);
    List showOrdersByPortion();
    Long createOrdersInDB(int quantity);
    List findInCompleteOrders();

}
