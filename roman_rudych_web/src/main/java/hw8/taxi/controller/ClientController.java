package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.AuthorizationService;
import hw8.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Роман on 16.07.2015.
 */
@Controller
@SessionAttributes("id")
public class ClientController {

    public static final Logger log = Logger.getLogger(ClientController.class);

    @Autowired
    private ClientService service;

    private int portion = 10;
    private int from = 0;

    @RequestMapping(value = "/registerClientForm.html", method = RequestMethod.GET)
    public String registerClientForm () {
        return "registerClient";
    }

    @RequestMapping(value = "/createClientForm.html", method = RequestMethod.GET)
    public String createClientForm () {
        return "createClient";
    }


    @RequestMapping(value = "/registerClient.html", method = RequestMethod.POST)
    public String registerClient (Model model,
                                  @RequestParam("name") String name,
                                  @RequestParam("surname") String surname,
                                  @RequestParam("phoneNum") String phoneNum,
                                  @RequestParam("address") String address,
                                  @RequestParam("sum") double sum,
                                  @RequestParam("dateOrder") String dateOrder) {

        try {
            Date date = new SimpleDateFormat("dd.MM.yy").parse(dateOrder);
            boolean isSuccess = service.registerClient(name, surname, phoneNum, address, sum, date);
            if(isSuccess) {
                model.addAttribute("successRegistration", "Client registration is successful");
                return "dashboard";
            }
        } catch (ParseException ex) {
            model.addAttribute("warning", "Wrong date format.(Try: dd.mm.yy)");
        } catch (OrderException exc) {
            model.addAttribute("warning", "Client creation failed. Try again");
        }

        return "registerClient";
    }

    @RequestMapping(value = "/createClient.html", method = RequestMethod.POST)
    public String createClient (Model model,
                                  @RequestParam("name") String name,
                                  @RequestParam("surname") String surname,
                                  @RequestParam("phoneNum") String phoneNum,
                                  @RequestParam("address") String address) {

        try {
            boolean isSuccess = service.createClient(name, surname, phoneNum, address);
            if(isSuccess) {
                model.addAttribute("successRegistration", "Client registration is successful");
                return "dashboard";
            } else {
                model.addAttribute("warning", "Client creation failed. Try again");
                return "registerClient";
            }
        } catch (OrderException exc) {
            model.addAttribute("warning", "Client creation failed. Try again");
        }
        return "";
    }

    @RequestMapping(value = "/clients.html", method = RequestMethod.GET)
    public String clients (Model model) {

        List<Client> list = service.showClientsByPortion(from, portion);
        if(list.size() != 0) {
            model.addAttribute("list", list);
            if(list.size()<10) {
                portion = 10;
                from = 0;
                return "clients";
            }
            model.addAttribute("next", "<a href=\"clients.html\">NEXT</a>");
            portion+=10;
            from+=10;
            return "clients";
        } else {
            model.addAttribute("massage", "List of clients has ended");
            return "clients";
        }
    }

    @RequestMapping(value = "/clientsSum.html", method = RequestMethod.GET)
    public String getListOfClientsGtSum (Model model, @RequestParam("sum") int sum) {
        Locale.setDefault(Locale.ENGLISH);
        List<Client> list = service.showClientsGtSum(sum);
        if(list.size() != 0) {
            model.addAttribute("list", list);
            return "clients";
        } else {
            model.addAttribute("massage", "List of clients has ended");
            return "clients";
        }
    }

    @RequestMapping(value = "/clientsLastMonth.html", method = RequestMethod.GET)
    public String clientsInMonth (Model model) {

        Locale.setDefault(Locale.ENGLISH);
        List<Client> list = service.showClientsLastMonth();
        if(list.size() != 0) {
            model.addAttribute("list", list);
            return "clients";
        } else {
            model.addAttribute("massage", "List of clients has ended");
            return "clients";
        }
    }

}
