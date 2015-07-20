package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vlad on 12.04.2015.
 */
@Controller
@SessionAttributes("employee")
public class OrderServlet {


    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "registerOrder", method = RequestMethod.POST)
    private String createOrder(@RequestParam("orderId") String orderId,
                               @RequestParam("clientName") String clientName,
                               @RequestParam("orderPrice") String orderPrice,
                               @RequestParam("addressFrom") String addressFrom,
                               @RequestParam("addressTo") String addressTo,
                               Model model) {
        if (orderId != null && !orderId.equals("")) {
            Long longId = Long.parseLong(orderId);
            Order order = orderService.read(longId);
            if (order == null) {
                Client client = clientService.readByName(clientName);
                orderService.createOrder(longId, client, orderPrice, addressFrom, addressTo);
            } else {
                Client client = clientService.readByName(clientName);
                try {
                    orderService.editOrder(longId, client, orderPrice, addressFrom, addressTo);
                } catch (OrderException e) {
                    e.printStackTrace();
                }

            }
        }
        return "dashboard";
    }


//    @RequestMapping(value = "/showallorders", method = RequestMethod.GET)
//    private String showAllOrders(Model model) {
//        List<Order> listorder = orderService.showOrdersByPortion();
//        model.addAttribute("listorder", listorder);
//        return "dashboard";
//    }

    @RequestMapping(value = "/showallorders", method = RequestMethod.GET)
    public @ResponseBody List<Order> listorder (Model model){

        List<Order> listorder = orderService.showOrdersByPortion();

        return listorder;
    }




    @RequestMapping(value = "/fromto", method = RequestMethod.GET)
    public String clientsMoreThen(@RequestParam("from") String from, @RequestParam("to") String to, Model model) {
        if (from != null && !from.equals("") && to != null && !to.equals("")) {
            Long fromLong = Long.parseLong(from);
            Long toLong = Long.parseLong(to);
            List<Order> listorder = null;
            try {
                listorder = orderService.showOrders(fromLong, toLong);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
            model.addAttribute("listorder", listorder);
        }
        return "dashboard";
    }
}
