package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by just1ce on 16.07.2015.
 */
@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    public static final Logger log = Logger.getLogger(ClientController.class);
    @RequestMapping(value = "/client_reg_page", method = RequestMethod.GET)
    String reg_page(){
        return "registerClient";
    }

    @RequestMapping(value = "/client_register", method = RequestMethod.POST)
    public
    String reg(@RequestParam("name") String name,
                 @RequestParam("surname") String surname,
                 @RequestParam("address") String address,
                 @RequestParam("phone") String phone,
                 Model model) throws ClientException {

        try {
            if (clientService.createClient(name,surname,phone,address)) {
                return "dashboard";
            }
        }
        catch (ClientException ex) {
            model.addAttribute("info", ex.toString());
            return "registerClient";
        }
        finally {
            return "dashboard";
        }
    }
    @RequestMapping(value = "/showClientsByPortion", method = RequestMethod.GET)
    public
    String showClientsByPortion(@RequestParam("portion") String portion,
                                Model model){
        List<Client> list = clientService.showClientsByPortion(Integer.parseInt(portion));
        model.addAttribute("clients",list);
        model.addAttribute("def","Клиенты порциями по " + portion);
        return "clients";
    }
    @RequestMapping(value = "/showClientsGtSum", method = RequestMethod.GET)
    public
    String showClientsGtSum(@RequestParam("sum") String sum,
                                Model model){
        List<Client> list = clientService.showClientsGtSum(Integer.parseInt(sum));
        model.addAttribute("clients",list);
        model.addAttribute("def","Клиенты наездившие на сумму больше " + sum);
        return "clients";
    }
    @RequestMapping(value = "/showClientsLastMonth", method = RequestMethod.GET)
    public
    String showClientsLastMonth(Model model){
        List<Client> list = clientService.showClientsLastMonth();
        model.addAttribute("clients",list);
        model.addAttribute("def","Все клиенты, делавшие заказы за последний месяц");
        return "clients";
    }
}
