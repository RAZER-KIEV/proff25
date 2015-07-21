package hw8.taxi.dao;


import hw8.taxi.domain.Order;

import java.util.List;

/**
 * Created by Vlad on 12.04.2015.
 */
public interface OrderDAO {

    public void createOrder(Order order);

    public Order readOrder(Long id);

    public void deleteOrder(Order order);

    public void updateOrder(Order order);

    public List showOrders(Long from, Long to);

    public List showOrdersByPortion();
}
