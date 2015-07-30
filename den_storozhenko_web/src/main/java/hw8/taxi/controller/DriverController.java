package hw8.taxi.controller;

import hw8.taxi.domain.Driver;
import hw8.taxi.domain.Order;
import hw8.taxi.service.DriverService;
import hw8.taxi.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"idDriver"})
public class DriverController {
    public static final Logger log = Logger.getLogger(DriverController.class);
    @Autowired
    private DriverService driverService;
    @Autowired
    private OrderService orderService;

    @PostConstruct
    public void init(){
        Locale.setDefault(Locale.ENGLISH);
    }

    public boolean isAuthorized(HttpSession session){
        return session.getAttribute("idDriver")!=null;
    }

    @RequestMapping(value = "/driver.html", method = RequestMethod.GET)
    public
    String driver(HttpSession session, Model model){
        /*driverService.create(new Driver("Driver2","380992222222","1111"));
        driverService.create(new Driver("vasya","380992222223","1111"));*/
        if (isAuthorized(session)){
            model.addAttribute("isLogined",true);
        }
        else{
            model.addAttribute("isLogined",false);
        }
        return "driverLogin";
    }

    @RequestMapping(value = "/showFreeOrders", method = RequestMethod.POST)
    public
    @ResponseBody
    List showOrders(@RequestParam String phone, @RequestParam String password, Model model) {
        log.info("/driverLogin.html controller");
        if (driverService.authenticate(phone, password)){
            model.addAttribute("idDriver",driverService.getDriverByPhone(phone).getId());
            return orderService.showFreeOrders();
        }
        else {
            return null;
        }
    }
    @RequestMapping(value = "/loginDriver", method = RequestMethod.POST)
    public
    @ResponseBody
    String loginDriver(@RequestParam String phone, @RequestParam String password, Model model) {
        log.info("/loginDriver controller");
        if (driverService.authenticate(phone, password)){
            model.addAttribute("idDriver",driverService.getDriverByPhone(phone).getId());
            return "OK";
        }
        else {
            return "FALSE";
        }
    }

    @RequestMapping(value = "/getFreeOrders", method = RequestMethod.POST)
    public
    @ResponseBody
    String showOrders() {
        String response="";
        List<Order> list = orderService.showFreeOrders();
        for(Order order:list){
            response+=order.getId().toString()+"p11p"+order.getAddressFrom()+"p11p"+order.getAddressTo()+"p11p"+order.getAmount()+"break";
        }
        return response;
    }

    /**
     *
     * @param order amount|from|to|id
     */
    @RequestMapping(value = "/takeOrder", method = RequestMethod.POST)
    public
    @ResponseBody
    String takeOrder(@RequestParam String order, HttpSession session) {
        log.info("/takeOrder.html controller");
        try {
            /*String idStr = "";
            for (int i=order.length()-1;i>=0;i--){
                if (order.charAt(i)!='|') {
                    idStr = order.charAt(i) + idStr;
                }
                else{
                    break;
                }
            }*/
            System.out.println(Long.parseLong(order)+" "+session.getAttribute("idDriver"));
            Driver driver = driverService.getDriverById((Long) session.getAttribute("idDriver"));
            orderService.giveOrderToDriver(Long.parseLong(order), driver);
            return "+";
        } catch (Throwable e){
            return "-";
        }
    }
}
