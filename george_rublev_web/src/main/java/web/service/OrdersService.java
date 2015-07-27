package web.service;

import web.domain.Operator;
import web.domain.Orders;

import java.util.List;

/**
 * Created by george on 26.07.15.
 */
public interface OrdersService {
    public void addOrder(Orders order);
    public List<Orders> listOrder();
    public void removeOrder(Integer id);
    public Orders findOrder(Integer id);
}
