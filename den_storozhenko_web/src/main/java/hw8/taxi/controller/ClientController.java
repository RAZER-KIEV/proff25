package hw8.taxi.controller;

import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"id","role"})
public class ClientController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/registerClient", method = RequestMethod.GET)
    public
    String registerCl() {
        log.info("/registerClient controller");
        return "registerClient";
    }

    /*@RequestMapping(value = "/submitRegisterClient", method = RequestMethod.POST)
    public
    String registerClient2(Model model) {
        log.info("/registerClient controller");
        return "dashboard";
    }*/

//    @RequestMapping(value = "/submitRegisterClient", method = RequestMethod.GET)
//    public
//    String registerClient1() {
//        log.info("/registerClient controller");
//        return "dashboard";
//    }

    @RequestMapping(value = "/submitRegisterClient", method = RequestMethod.POST)
    public
    @ResponseBody
    String registerClient(@RequestParam String name, @RequestParam String surname, @RequestParam String phone,
                 @RequestParam String address, Model model) {
        log.info("/submitRegisterClient controller");
        try {
            clientService.createClient(name, surname, phone, address);
            //model.addAttribute("info","Client was created.");
            return "<span><font color=\"BLUE\">"+"Client was created."+"</font></span>";
        } catch (ClientException e) {
            return "<span><font color=\"RED\">"+"Client wasn't created.<br>"+e.getMessage()+"</font></span>";
        } catch (HibernateException e){
            //model.addAttribute("error","Database error.");
            return "<span><font color=\"RED\">"+"Database error."+"</font></span>";
        }
    }

    @RequestMapping(value = "/showByPort", method = RequestMethod.GET)
    public
    String getByPortion(@RequestParam("size") Integer size, Model model) {
        log.info("/showByPort controller");
        try {
            model.addAttribute("clientList",clientService.showClientsByPortion(size));
            return "clients";
        } catch (HibernateException e) {
            model.addAttribute("error", "Database error.");
            return "dashboard";
        }
    }

    @RequestMapping(value = "/showGtSum", method = RequestMethod.GET)
    public
    String showGtSum(@RequestParam Integer sum, Model model) {
         log.info("/showGtSum controller");
        try {
            model.addAttribute("clientList",clientService.showClientsGtSum(sum));
            return "clients";
        } catch (HibernateException e) {
            model.addAttribute("error", "Database error.");
            return "dashboard";
        }
    }

    @RequestMapping(value = "/showClientsLastMonth", method = RequestMethod.GET)
    public
    String showClientsLastMonth(Model model) {
        log.info("/showClientsLastMonth controller");
        try {
            model.addAttribute("clientList",clientService.showClientsLastMonth());
            return "clients";
        } catch (HibernateException e) {
            model.addAttribute("error", "Database error.");
            return "dashboard";
        }
    }
}
