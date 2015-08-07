package hw8.taxi.dao;

import hw8.taxi.domain.Order;

import java.util.List;

/**
 * Created by just1ce on 16.07.2015.
 */
public interface OrderDao {
    Long create(Order order);
    Order read(Long id);
    Order readById(Long id);
    boolean update(Order order);
    boolean delete(Order order);
    List showOrders(Long from, Long to);
    List showOrdersByPortion();
    List getAll();
}
