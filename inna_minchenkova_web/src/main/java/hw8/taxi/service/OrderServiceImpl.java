package hw8.taxi.service;

import hw8.taxi.dao.ClientDAO;
import hw8.taxi.dao.OrderDAO;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Vlad on 12.04.2015.
 */

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        if (orderDAO.readOrder(id) != null) {
            throw new OrderException("This ID already exists");
        }
        Integer am = 0;

        try {
            am = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new OrderException("Error amount");
        }
        Calendar date = new GregorianCalendar();
        Order order = new Order(id, client, date, am, addressFrom, addressTo);
        client.setClientOrderDate(date);
        client.setClientAmount(client.getClientAmount() + am);
        client.addOrder(order);
        orderDAO.createOrder(order);
        clientDAO.updateClient(client);
        return true;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        Order order = orderDAO.readOrder(id);

        if (client != null) {
            order.setClient(client);
        }

        if (amount != null || !amount.equals("")) {
            Integer newAmount = 0;
            try {
                newAmount = Integer.parseInt(amount);
            } catch (NumberFormatException e) {
                throw new OrderException(e.getMessage());
            }
            order.setOrderSum(newAmount);
            Client tmpClient = clientDAO.readClient(client.getClientID());
            tmpClient.setClientAmount(newAmount);
            clientDAO.updateClient(tmpClient);

            if (!addressFrom.equals("")) {
                order.setAddressFrom(addressFrom);
            }
            if (!addressTo.equals("")) {
                order.setAddressTo(addressTo);
            }
            orderDAO.updateOrder(order);
        }
    }

    @Override
    public Order read(Long id) {
        return orderDAO.readOrder(id);
    }

    @Override
    public List showOrders(Long from, Long to) {
        return orderDAO.showOrders(from, to);
    }

    @Override
    public List showOrdersByPortion() {
        return orderDAO.showOrdersByPortion();
    }
}
