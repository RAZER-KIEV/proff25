package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.OrderException;

import java.util.List;

public interface OrderService {
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    boolean createOrderWithOperator(Operator operator, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);
    void editOrderWithOperator(Operator operator, Long id, Client client, String amount, String addressFrom, String addressTo);
    List showOrders(Long from, Long to);
    List showOrdersByPortion();
}
