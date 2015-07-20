package hw8.taxi.service;

import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private int portionsize=1;

    @Autowired
    OrderDao orderDao;


    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        if(orderDao.read(id)!=null) {
            editOrder(id,client,amount,addressFrom,addressTo);
            return false;

        } else {
        Order order = new Order(id, new Date(),client,Double.parseDouble(amount),addressFrom,addressTo);
        orderDao.create(order);}
         return true;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        Order order = orderDao.read(id);
        if(order==null) {
            throw new OrderException("Order with current id not exist!");
        }
        order.setClient(client);
        order.setOrderSum(Double.parseDouble(amount));
        order.setDepartureAddress(addressFrom);
        order.setDestinationAddress(addressTo);
        orderDao.update(order);
    }

    @Override
    public List showOrders(Long from, Long to) {
        return orderDao.showOrders(from, to);
    }

    @Override
    public List showOrdersByPortion() {
        List<Order> orderList = new ArrayList<>();
        boolean flag=true;
        for (int i=0; flag==true; i+=portionsize ){
            List<Order> orderListBuff=new ArrayList<>();
            orderListBuff=orderDao.findAllbyPortion(i, i + portionsize);
            if(orderListBuff.isEmpty()){flag=false;}
           else orderList.addAll(orderListBuff);
        }

        return orderList;
    }
}
