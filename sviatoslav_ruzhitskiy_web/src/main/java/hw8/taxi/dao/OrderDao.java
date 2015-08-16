package hw8.taxi.dao;

import hw8.taxi.domain.Order;

import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
public interface OrderDao {
    Long create(Order order);
    Order read(Long ig);
    boolean update(Order order);
    boolean delete(Order order);
    List showOrders(Long from, Long to);;
    List findAllbyPortion(int start, int end);
    List findInCompleteOrders();

}
