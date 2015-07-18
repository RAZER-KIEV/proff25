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
 * Created by HP on 17.07.2015.
 */
@org.springframework.stereotype.Controller
@SessionAttributes("id")
public class TaxiDriverController {
    private static final Logger log = Logger.getLogger(TaxiDriverController.class);
    @Autowired
    TService service;

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
    @RequestMapping(value = "/dash.html", method = {RequestMethod.GET})
    public String resend() {
        log.info("/dash controller");
        return "dashboard";
    }
}
