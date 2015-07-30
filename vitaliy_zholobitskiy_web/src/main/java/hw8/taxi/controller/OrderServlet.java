package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by just1ce on 16.07.2015.
 */
@Controller
public class OrderServlet {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    String order(Model model){
        model.addAttribute("clients",clientService.findAll());
        return "order";
    }
    @RequestMapping(value = "/editOrderPage", method = RequestMethod.GET)
    String editOrderPage(Model model){
        model.addAttribute("clients",clientService.findAll());
        model.addAttribute("orders",orderService.getAll());
        return "editOrder";
    }

    @RequestMapping(value = "/showOrdersByPortion", method = RequestMethod.GET)
    public
    String showOrdersByPortion(Model model){
        List<Order> list = orderService.showOrdersByPortion();
        model.addAttribute("orders",list);
        model.addAttribute("def","Заказы порциями по 5");
        return "orders";
    }
    @RequestMapping(value = "/showOrders", method = RequestMethod.POST)
    public
    String showOrders(@RequestParam("from") String from,
                      @RequestParam("to") String to,
                                Model model){
        List<Order> list = orderService.showOrders(Long.parseLong(from), Long.parseLong(to));
        model.addAttribute("orders",list);
        model.addAttribute("def","Заказы на суму в диазоне от " + from + " до " + to);
        return "orders";
    }
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public
    String createOrder(@RequestParam("id") String id,
                      @RequestParam("client_id") String client_id,
                       @RequestParam("amount") String amount,
                       @RequestParam("addressFrom") String addressFrom,
                       @RequestParam("addressTo") String addressTo,
                      Model model) throws OrderException {
        try {
            Client client = clientService.getClientByID(Long.parseLong(client_id));
            orderService.createOrder(Long.parseLong(id),client,amount,addressFrom,addressTo);
            return "dashboard";
        }
       catch (OrderException ex){
           model.addAttribute("info",ex.toString());
           return null;
       }

    }
    @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
    public
    String  editOrder(@RequestParam("order_id1") String order_id1,
                      @RequestParam("client_id1") String client_id1,
                       @RequestParam("amount1") String amount1,
                       @RequestParam("addressFrom1") String addressFrom1,
                       @RequestParam("addressTo1") String addressTo1,
                       Model model){
        try {
            Client client = clientService.getClientByID(Long.parseLong(client_id1));
            orderService.editOrder(Long.parseLong(order_id1),client,amount1,addressFrom1,addressTo1);
            return "dashboard";
        }
        catch (OrderException ex){
            model.addAttribute("info",ex.toString());
            return null;
        }
    }
}
