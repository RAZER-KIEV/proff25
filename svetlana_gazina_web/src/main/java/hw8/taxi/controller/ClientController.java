package hw8.taxi.controller;

import hw8.taxi.exception.ClientException;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by Sveta on 8/11/2015.
 */

@Controller
@SessionAttributes("id")
public class ClientController {

    public static final Logger log = Logger.getLogger(ClientController.class);
    private Integer portionSize=5;
    @Autowired
    private ClientService clientService;
    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    ClientController() {
    }
    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String dashboard(Model model){
        return "dashboard";
    }

    @RequestMapping(value = "/registerClient", method = {RequestMethod.GET, RequestMethod.POST})
    public String registerClient(Model model){
        return "registerClient";
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
    public String createClient(@RequestParam("name")String name,@RequestParam("surname")String surname, @RequestParam("phone") String phone, @RequestParam("adress")String adress, Model model) throws ClientException, OrderException {
        if(clientService.createClient(name,surname,phone,adress)){
            model.addAttribute("createStatus","success");
        }else {
            model.addAttribute("createStatus", "Error!");
        }
        return "registerClient";
    }

    @RequestMapping(value = "/showClientsByPortion", method = RequestMethod.POST)
    public String showClientsByPortion(Model model){
        model.addAttribute("list", clientService.showClientsByPortion(portionSize));
        return "clients";
    }

    @RequestMapping(value = "/showClientsGtSum", method = RequestMethod.POST)
    public String showClientsGtSum(@RequestParam("sum")String sum, Model model){
        model.addAttribute("list", clientService.showClientsGtSum(Integer.parseInt(sum)));
        return "clients";
    }

    @RequestMapping(value = "/showClientsLastMonth", method = RequestMethod.POST)
    public String showClientsLastMonth(Model model){
        model.addAttribute("list", clientService.showClientsLastMonth());
        return "clients";
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public String clients(Model model){
        return "clients";
    }

}
