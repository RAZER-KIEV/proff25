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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"id","role"})
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

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public String createOrder(Model model) {
        log.info("/createOrder.html controller");
        return "order";
    }

    @RequestMapping(value = "/editOrder", method = RequestMethod.GET)
    public String editOrder(Model model) {
        log.info("/editOrder.html controller");
        return "order";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@RequestParam Long id, @RequestParam Long clientId, @RequestParam String amount, @RequestParam String from,
                         @RequestParam String to, Model model) {
        log.info("/create.html controller");
        try {
            Client client = clientService.getClient(clientId);
            if (orderService.createOrder(id, client, amount, from, to)) {
                clientService.updateClient(client, Long.parseLong(amount));

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

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
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

    @RequestMapping(value = "/editOrder1", method = RequestMethod.GET)
    public String editOrder1(Model model) {
        log.info("/editOrder1.html controller");
        List<String> ids = new ArrayList<>();
        for (Order order:(List<Order>)orderService.findAll()){
            ids.add(order.getId()+" |"+order.getClient().getFirstname()+" "+order.getClient().getLastname()+"|"+order.getAmount()+"|"+
            order.getAddressFrom()+"|"+order.getAddressTo());
        }
        model.addAttribute("ids", ids);
        List<String> names = new ArrayList<>();
        for (Client client:(List<Client>)clientService.findAll()){
            names.add(client.getFirstname()+" "+client.getLastname()+" |"+client.getAdress());
        }
        model.addAttribute("names",names);
        return "order1";
    }

    @RequestMapping(value = "/create1", method = RequestMethod.GET)
    public String create1(@RequestParam String names, @RequestParam String amount, @RequestParam String from,
                         @RequestParam String to, Model model) {
        log.info("/create1.html controller");
        try {
            String clientFirstName = names.split(" ")[0];
            String clientLastName = names.split(" ")[1];
            Client client = clientService.getClientByName(clientFirstName,clientLastName);
            if (client!=null && orderService.createOrder(client, amount, from, to)) {
                clientService.updateClient(client, Long.parseLong(amount));
                model.addAttribute("info", "Order was created.");
            } else {
                model.addAttribute("error", "Order wasn't created.");
            }
            return "dashboard";
        } catch (OrderException e) {
            model.addAttribute("orderEx", e.getMessage());
            editOrder1(model);
            return "order1";
        }
    }

    @RequestMapping(value = "/edit1", method = RequestMethod.GET)
    public String edit1(@RequestParam String id, @RequestParam String names1, @RequestParam String amount1, @RequestParam String from1,
                       @RequestParam String to1, Model model) {
        log.info("/edit1.html controller");

        try {
            Long idOrder = Long.parseLong(id.split(" ")[0]);
            String clientFirstName = names1.split(" ")[0];
            String clientLastName = names1.split(" ")[1];
            Client client = clientService.getClientByName(clientFirstName,clientLastName);
            if (client!=null) {
                clientService.updateClient(client, Long.parseLong(amount1)-orderService.getOrder(idOrder).getAmount());
                orderService.editOrder(idOrder, client, amount1, from1, to1);
                model.addAttribute("info", "Order was edited.");
            }
            else{
                model.addAttribute("error", "Order wasn't edited.");
            }
            return "dashboard";
        } catch (OrderException e) {
            model.addAttribute("orderEx", e.getMessage());
            editOrder1(model);
            return "order1";
        }
    }

    @RequestMapping(value = "/showOrdersBySum", method = RequestMethod.GET)
    public String showBySum(@RequestParam Long from, @RequestParam Long to, Model model) {
        log.info("/showOrdersBySum.html controller");
        model.addAttribute("ordersList", orderService.showOrders(from, to));
        return "orders";
    }

    @RequestMapping(value = "/showOrders", method = RequestMethod.GET)
    public String showByPorc(Model model) {
        log.info("/showOrders.html controller");
        model.addAttribute("ordersList", orderService.showOrdersByPortion());
        return "orders";
    }
}
