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
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/editOrder", method = RequestMethod.GET)
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
            names.add(client.getPhone());
        }
        model.addAttribute("phones",names);
        return "order1";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public
    @ResponseBody
    String create1(@RequestParam String phone, @RequestParam String amount, @RequestParam String from,
                         @RequestParam String to) {
        log.info("/create1.html controller");
        try {
            Client client = clientService.getClientByPhone(phone);
            if (client!=null && orderService.createOrder(client, amount, from, to)) {
                clientService.updateClient(client, Long.parseLong(amount));
                return "created";
            } else {
                return "Ncreated";
            }
        } catch (OrderException e) {
            return "C"+e.getMessage();
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public
    @ResponseBody
    String edit1(@RequestParam String id, @RequestParam String phone, @RequestParam String amount, @RequestParam String from,
                       @RequestParam String to) {
        log.info("/edit1.html controller");
        try {
            Long idOrder = Long.parseLong(id.split(" ")[0]);
            Client client = clientService.getClientByPhone(phone);
            if (client!=null) {
                clientService.updateClient(client, Long.parseLong(amount) - orderService.getOrder(idOrder).getAmount());
                orderService.editOrder(idOrder, client, amount, from, to);
                return "edited";}
            else{
                return "Nedited";
            }
        } catch (OrderException e) {
            return "E"+e.getMessage();
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
