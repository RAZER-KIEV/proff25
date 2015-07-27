package web.dao;

import web.domain.Orders;

import java.util.List;

/**
 * Created by george on 26.07.15.
 */
public interface OrdersDao {
    List<Orders> listOrder();
    Long create(Orders order);
    Orders read(Integer id);
    boolean update(Orders order);
//    boolean delete(Orders order);
    void delete(Integer id);
}
