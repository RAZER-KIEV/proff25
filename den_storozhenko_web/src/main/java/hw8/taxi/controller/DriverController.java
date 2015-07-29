package hw8.taxi.controller;

import hw8.taxi.domain.Driver;
import hw8.taxi.service.DriverService;
import hw8.taxi.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"idDriver"})
public class DriverController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Autowired
    private DriverService driverService;
    @Autowired
    private OrderService orderService;

    @PostConstruct
    public void init(){
        Locale.setDefault(Locale.ENGLISH);
    }

    public boolean isAutorized(HttpSession session){
        return session.getAttribute("idDriver")!=null;
    }

    @RequestMapping(value = "/driver.html", method = RequestMethod.GET)
    public String driver(HttpSession session){
        //driverService.create(new Driver("Driver2","380992222222","1111"));
//        if (isAutorized(session)){
//            return
//        }
        return "driverLogin";
    }

    @RequestMapping(value = "/showFreeOrders", method = RequestMethod.GET)
    public
    @ResponseBody
    List showOrders(@RequestParam String phone, @RequestParam String password, Model model) {
        log.info("/driverLogin.html controller");
        if (driverService.authenticate(phone, password)){
            model.addAttribute("idDriver",driverService.getDriverByPhone(phone).getId());
            return orderService.showOrdersByPortion();
        }
        else {
            return null;
        }
    }

    /**
     *
     * @param order amount||from||to||id
     */
    @RequestMapping(value = "/takeOrder", method = RequestMethod.GET)
    public
    @ResponseBody
    String takeOrder(@RequestParam String order, HttpSession session) {
        log.info("/takeOrder.html controller");
        try {
            String[] params = order.split("||");
            Long id = Long.parseLong(params[params.length - 1]);
            System.out.println(id);
            Driver driver = driverService.getDriverById((Long) session.getAttribute("idDriver"));
            orderService.giveOrderToDriver(id, driver);
            return "+";
        } catch (Throwable e){
            return "-";
        }
    }
}
