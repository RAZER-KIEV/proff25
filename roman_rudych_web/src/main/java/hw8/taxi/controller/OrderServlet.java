package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by Роман on 04.08.2015.
 */
@Controller
@SessionAttributes("id")
public class OrderServlet {

    public static final Logger log = Logger.getLogger(OrderServlet.class);

    @Autowired
    ClientService clientService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order.html", method ={RequestMethod.GET})
    public String gotoOrder (Model model) {
        log.info("order.html");
        model.addAttribute("addAction", "<form action=\"/createOrder.html\" method=\"get\">");
        model.addAttribute("buttonName", "Create");
        return "order";
    }

    @RequestMapping(value = "/changeOrder.html", method ={RequestMethod.GET})
    public String gotoChangeOrder (Model model) {
        log.info("changeOrder.html");
        model.addAttribute("addAction", "<form action=\"/changeOrd.html\" method=\"get\">");
        model.addAttribute("additionId", "<tr>\n" +
                "      <th align=\"right\"><strong>ID: </strong></th>\n" +
                "      <th align=\"left\"><input type=\"text\" name=\"id\"/></th>\n" +
                "    </tr>");
        model.addAttribute("buttonName", "Change");
        return "order";
    }

    @RequestMapping(value = "/createOrder.html", method = RequestMethod.GET)
    public String createOrder(Model model,
                              @RequestParam("clientPhoneNum") String phoneNum,
                              @RequestParam("sum") String sum,
                              @RequestParam("addressFrom") String addressFrom,
                              @RequestParam("addressTo") String addressTo) {
        Client client = clientService.findByPhoneNum(phoneNum);
        if(client != null) {
            try {
                log.info("Client is not null");
                boolean res = orderService.createOrder(0L, client, sum, addressFrom, addressTo);
                if(res == true) {
                    model.addAttribute("successRegistration", "Order has created");
                    log.info("Order creation is true");
                    return "dashboard";
                } else {
                    log.info("orderService.createOrder returns false");
                    model.addAttribute("warning", "Client has not created. Try again");
                }
            } catch (OrderException ex) {
                log.error("OrderException" + ex.getMessage());
                model.addAttribute("warning", ex.getMessage());
            }
        } else {
            log.error("Client is null");
            model.addAttribute("warning", "Order has not created. Try again");
        }
        log.error("Last return");
        return "dashboard";
    }

    @RequestMapping(value = "/changeOrd.html", method = RequestMethod.GET)
    public String changeOrder(Model model,
                              @RequestParam("id") String id,
                              @RequestParam("clientPhoneNum") String phoneNum,
                              @RequestParam("sum") String sum,
                              @RequestParam("addressFrom") String addressFrom,
                              @RequestParam("addressTo") String addressTo) {
        Client client = clientService.findByPhoneNum(phoneNum);
        if(client != null) {
            log.info("Client is not null");
            orderService.editOrder(Long.parseLong(id), client, sum, addressFrom, addressTo);
            model.addAttribute("successRegistration", "Order has changed");
            log.info("Order creation is true");
            return "dashboard";
        } else {
            log.error("Client is null");
            model.addAttribute("warning", "Order has not created(Wrong phone number?). Try again");
            return "order";
        }
    }

    @RequestMapping(value = "/ordersSum.html", method = RequestMethod.GET)
    public String changeOrder(Model model,
                              @RequestParam("sumFrom") String sumFrom,
                              @RequestParam("sumTo") String sumTo) {
        List<Order> ordersList = orderService.showOrders(Long.parseLong(sumFrom), Long.parseLong(sumTo));
        if(ordersList.size()!=0 && ordersList != null) {
            model.addAttribute("title", "Orders from " + sumFrom + " to " + sumTo);
            model.addAttribute("list", ordersList);
            return "orders";
        } else {
            model.addAttribute("warning", "There is no orders");
            return "order";
        }
    }

    @RequestMapping(value = "/showAllOrders.html", method = RequestMethod.GET)
    public String changeOrder(Model model) {
        List<Order> ordersList = orderService.showOrdersByPortion();
        if(ordersList.size()!=0 && ordersList != null) {
            model.addAttribute("title", "All orders by portion of 5");
            model.addAttribute("list", ordersList);
            return "orders";
        } else {
            model.addAttribute("warning", "There is no orders");
            return "order";
        }
    }
}
