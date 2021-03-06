package hw8.taxi.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Created by ПК on 15.07.2015.
 */
@Controller
@SessionAttributes("id")
public class OrderServlet {

    @Autowired
    OrderService orderService;

    @Autowired
    ClientService clientService;

    public OrderServlet() {
    }

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @RequestMapping(value = "/goToCreateOrder", method = RequestMethod.POST)
    public String goToCreateOrder() {
        return "order";
    }

    @RequestMapping(value = "/createEditOrder", method = RequestMethod.POST)
    public String createEditOrder(@RequestParam("orderId") Long id, @RequestParam("clientId") String clientId, @RequestParam("amount") String amount,
                                  @RequestParam("addressFrom") String addressFrom, @RequestParam("addressTo") String addressTo, Model model) throws OrderException {
        Client client = clientService.findClientById(id);
        if (client == null) {
            model.addAttribute("message", "Client not exist!");
            return "order";
        }
        if (orderService.createOrder(id, client, amount, addressFrom, addressTo)) {
            model.addAttribute("message", "Order created!");
        } else {
            model.addAttribute("message", "Order updated!");
        }
        return "order";
    }

    @RequestMapping(value = "/showOrders", method = RequestMethod.POST)
    public String showOrders(@RequestParam("from") String fromS, @RequestParam("to") String toS, Model model) {
        Long from = Long.parseLong(fromS);
        Long to = Long.parseLong(toS);

        model.addAttribute("list", orderService.showOrders(from, to));
        return "orders";
    }

    @RequestMapping(value = "/showOrdersByPortion", method = RequestMethod.POST)
    public String showOrdersByPortion(Model model) {
        model.addAttribute("list", orderService.showOrdersByPortion());
        return "orders";
    }

    @RequestMapping(value = "/findInCompleteOrders", method = RequestMethod.POST)
    public
    @ResponseBody
    String findInCompleteOrders(Model model) {
        Gson gsonPretty = new Gson(); //new GsonBuilder().setPrettyPrinting().create();
        String gsonS = gsonPretty.toJson(orderService.findInCompleteOrders());
        System.out.println("GSON STRING: " + gsonS);

        return gsonS;
    }

    @RequestMapping(value = "/createOrdersInDB", method = RequestMethod.POST)
    public String createOrdersInDB(HttpSession session) {
        Long id;
        id = orderService.createOrdersInDB(50); //.createClientsInDB(50);
        if (id != null) {
            session.setAttribute("sysMessage", "Orders Created! Id of last Order is: " + id + " !");
        }
        return "dashboard";

    }

    @RequestMapping(value = "/acceptOrderAndroid", method = RequestMethod.POST)
    public
    @ResponseBody
    String acceptOrderAndroid(@RequestParam("orderId") String orderId ){
        //Gson gsonPretty = new Gson(); //new GsonBuilder().setPrettyPrinting().create();
        Order or = orderService.read(Long.parseLong(orderId));
        or.setIsComplite(true);
        if(orderService.updateOrder(or)){
            return "OrderACCEPTED";
        }
        return "false";

    }
}
