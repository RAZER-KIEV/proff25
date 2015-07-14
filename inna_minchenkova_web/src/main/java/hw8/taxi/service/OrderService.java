package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Vlad on 12.04.2015.
 */
public interface OrderService {

    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;

    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);

    public Order read(Long id);

    public List showOrders(Long from, Long to);

    public List showOrdersByPortion();
}
