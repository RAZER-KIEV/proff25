package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sveta on 8/17/2015.
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {

    }

    @Override
    public List showOrders(Long from, Long to) {
        return null;
    }

    @Override
    public List showOrdersByPortion() {
        return null;
    }
}
