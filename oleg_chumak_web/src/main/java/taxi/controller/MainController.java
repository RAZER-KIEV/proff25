package taxi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import taxi.domain.TaxiDriver;
import taxi.service.TService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@org.springframework.stereotype.Controller
@SessionAttributes("id")
public class MainController {
    private static final Logger log = Logger.getLogger(MainController.class);
    @Autowired
    TService service;

    @RequestMapping(value = "/request.html", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        model.addAttribute("name", "default");
        return "test";
    }
    @RequestMapping(value = "/dash.html", method = {RequestMethod.GET})
    public String resend() {
        log.info("/dash controller");
        return "dashboard";
    }
    //МЕТОДЫ TaxiDrivers
    @RequestMapping(value = "/drivers.html", method = {RequestMethod.GET})
    public String showDrivers(Model model) {
        List<TaxiDriver> list = service.findAllTaxists();
        log.info("/drivers controller");
        model.addAttribute("driversList", list);
        return "drivers";
    }
    @RequestMapping(value = "/create.html", method = {RequestMethod.GET})
    public String re() {
        log.info("/create controller");
        return "registerDriver";
    }
    @RequestMapping(value = "/newDriver.html", method = {RequestMethod.GET})
    public String createDriver
            (@RequestParam("name") String name, @RequestParam("model") String carModel,
             @RequestParam("number") String carNumber, @RequestParam("phone") String phone,  Model model) {
        service.createTaxist(new TaxiDriver(name, carModel, carNumber, phone));
        log.info("/newDriver controller");
        model.addAttribute("driversList", service.findAllTaxists());
        return "drivers";
    }
    //КОНЕЦ методов TaxiDrivers

}
