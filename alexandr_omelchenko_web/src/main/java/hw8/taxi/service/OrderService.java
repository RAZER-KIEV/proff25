package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import java.util.Date;

/*
- оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
- отредактировать заказ (поменять свойства заказа)
- вывести список заказов на сумму в указанном диапазоне
- вывести список всех заказов порциями по 5 штук
 */
public interface OrderService {
    boolean createOrder(Double price, String adressCl, String adressDest, Date date, Client client) throws OrderException;
    Order getOrder(Long id);
    void update(Order order);
}
