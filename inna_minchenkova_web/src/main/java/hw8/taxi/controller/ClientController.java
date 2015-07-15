package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Employee;
import hw8.taxi.service.ClientService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vlad on 06.04.2015.
 */
@Controller
@SessionAttributes("employee")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "registerClient", method = RequestMethod.POST)
    public String regClient(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("phone") String phone,
                            @RequestParam("address") String address,
                            Model model) {

        clientService.createClient(name, surname, phone, address);
        model.addAttribute("message", "Register new client was successful");
        return "dashboard";
    }


    @RequestMapping(value = "registerClient.html", method = RequestMethod.GET)
    public String registerClient(@ModelAttribute Employee employee) {
        if (employee.getEmployeeLogin() == null) {
            return "index";
        }
        return "registerClient";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String clients(Model model) {
        List<Client> clientList = clientService.showClientsByPortion(10);
        model.addAttribute("clientList", clientList);
        return "dashboard";
    }

    @RequestMapping(value = "/lastMonth", method = RequestMethod.GET)
    public String clientsLostMonth(Model model) {
        List<Client> clientList = clientService.showClientsLastMonth();
        model.addAttribute("clientList", clientList);
        return "dashboard";
    }

    @RequestMapping(value = "/moreThan", method = RequestMethod.GET)
    public String clientsMoreThen(@RequestParam("sum") String sumStr, Model model) {
        if (sumStr != null && !sumStr.equals("")) {
            int sum = Integer.parseInt(sumStr);
            List<Client> clientList = null;
            try {
                clientList = clientService.showClientsGtSum(sum);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
            model.addAttribute("clientList", clientList);
        }
        return "dashboard";
    }

    @RequestMapping(value = "/dashboard.html", method = RequestMethod.GET)
    public String auth(@ModelAttribute Employee employee) {
        if (employee.getEmployeeLogin() != null) {
            return "dashboard";
        }
        return "index";
    }


}
