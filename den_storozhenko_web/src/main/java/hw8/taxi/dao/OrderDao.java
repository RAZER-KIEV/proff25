package hw8.taxi.dao;

import hw8.taxi.domain.Order;

import java.util.List;

public interface OrderDao {
    Long create(Order order);
    Order read(Long id);
    boolean update(Order order);
    boolean delete(Order order);
    List getOrdersBySum(Long from, Long to);
    List getFreeOrders();
    List getOrdersByPortion();
    List getOrdersPorced(int start, int size);
    List findAll();
}
