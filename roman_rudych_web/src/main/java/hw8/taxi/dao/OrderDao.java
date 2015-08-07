package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Роман on 04.08.2015.
 */
public interface OrderDao {
    Long create(Order order);
    Order read(Long id);
    boolean update(Order order);
    boolean delete(Order order);
    List showOrders(Long from, Long to);
    List showOrdersByPortion(int from, int portion);
}
