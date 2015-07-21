package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("id")
public class ClientController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/regCl", method = RequestMethod.POST)
    public
    String registerClient(Model model) {
        log.info("/regCl controller");
        return "registerClient";
    }

    @RequestMapping(value = "/registerClient", method = RequestMethod.POST)
    public
    String regCl(@RequestParam String name, @RequestParam String surname, @RequestParam String phone,
                 @RequestParam String address, Model model) {
        log.info("/registerClient controller");
        try {
            clientService.createClient(name,surname,phone,address);
            model.addAttribute("info","Client was created.");
            return "dashboard";
        } catch (ClientException e) {
            model.addAttribute("info", "Client wasn't created");
            return "registerClient";
        } catch (HibernateException e){
            model.addAttribute("error","Database error.");
            return "registerClient";
        }
    }

    @RequestMapping(value = "/showByPort", method = RequestMethod.GET)
    public
    String getByPortion(@RequestParam("size") Integer size, Model model) {
        log.info("/showByPort controller");
        String result = "";
        try {
            for (Client client : (List<Client>) clientService.showClientsByPortion(size)) {
                result = result + client + "<br>";
            }
            model.addAttribute("clientList",result);
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
        String result = "";
        try {
            for (Client client : (List<Client>) clientService.showClientsGtSum(sum)) {
                result = result + client + "<br>";
            }
            model.addAttribute("clientList",result);
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
        String result = "";
        try {
            for (Client client : (List<Client>) clientService.showClientsLastMonth()) {
                result = result + client + "<br>";
            }
            model.addAttribute("clientList",result);
            return "clients";
        } catch (HibernateException e) {
            model.addAttribute("error", "Database error.");
            return "dashboard";
        }
    }
}
