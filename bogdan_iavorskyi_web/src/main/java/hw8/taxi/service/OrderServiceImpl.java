package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.dao.OperatorDao;
import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Value("5")
    private static int CHUNK_SIZE;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ClientDao clientDao;

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public boolean createOrderWithOperator(Operator operator, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        LocalDateTime now = LocalDateTime.now();
        Long amountL = 0L;
        try {
            amountL = Long.parseLong(amount);
        } catch (NumberFormatException exception) {
            throw new OrderException();
        }

        client.setTotalMoneyAmount(client.getTotalMoneyAmount() + amountL);
        client.setLastOrderDate(now);
        client.setOperatorLastChanges(operator);

        Order order = new Order(client, operator, null, now, amountL, addressFrom, addressTo);

        clientDao.update(client);
        orderDao.create(order);

        return true;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {

    }

    @Override
    public void editOrderWithOperator(Operator operator, Long id, Client client, String amount, String addressFrom, String addressTo) {

    }

    @Transactional(readOnly = true)
    @Override
    public List showOrders(Long from, Long to) {
        return orderDao.listInRangeOfAmount(from, to);
    }

    @Transactional(readOnly = true)
    @Override
    public List showOrdersByPortion() {
        int size = (int) orderDao.getListSize();
        List orders = new LinkedList<>();
        for (int i = 0; i < size; i+=CHUNK_SIZE) {
            orders.addAll(orderDao.listChunk(i, CHUNK_SIZE));
            orders.add(null);
        }
        return orders;
    }
}
