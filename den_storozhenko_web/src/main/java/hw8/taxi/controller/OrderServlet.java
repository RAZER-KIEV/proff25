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

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes("id")
public class OrderServlet {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String createOrder(Model model) {
        log.info("/createOrder.html controller");
        return "order";
    }

    @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
    public String editOrder(Model model) {
        log.info("/editOrder.html controller");
        return "order";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam Long id, @RequestParam Long clientId, @RequestParam String amount, @RequestParam String from,
                         @RequestParam String to, Model model) {
        log.info("/create.html controller");
        try {
            Client client = clientService.getClient(clientId);
            if (orderService.createOrder(id, client, amount, from, to)) {
                clientService.updateDate(client);
                model.addAttribute("info", "Order was created.");
            } else {
                model.addAttribute("error", "Order wasn't created.");
            }
            return "dashboard";
        } catch (OrderException e) {
            model.addAttribute("orderEx", e.getMessage());
            return "order";
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam Long id, @RequestParam Long clientId, @RequestParam String amount, @RequestParam String from,
                       @RequestParam String to, Model model) {
        log.info("/edit.html controller");
        try {
            orderService.editOrder(id, clientService.getClient(clientId), amount, from, to);
            model.addAttribute("info", "Order was edited.");
            return "dashboard";
        } catch (OrderException e) {
            model.addAttribute("orderEx", e.getMessage());
            return "order";
        }
    }

    @RequestMapping(value = "/showOrdersBySum", method = RequestMethod.POST)
    public String showBySum(@RequestParam Long from, @RequestParam Long to, Model model) {
        log.info("/showOrdersBySum.html controller");
        String res = "";
        for (Order order : (List<Order>) orderService.showOrders(from, to)) {
            res=res+order+"<br>";
        }
        model.addAttribute("ordersList", res);
        return "orders";
    }

    @RequestMapping(value = "/showOrders", method = RequestMethod.POST)
    public String showByPorc(Model model) {
        log.info("/showOrders.html controller");
        String res = "";
        for (Order order : (List<Order>) orderService.showOrdersByPortion()) {
            res=res+order+"<br>";
        }
        model.addAttribute("ordersList", res);
        return "orders";
    }
}
