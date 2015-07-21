package web.controller;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.domain.Client;
import web.domain.Operator;
import web.service.ClientService;
import web.service.DriverService;
import web.service.OperatorService;
import web.domain.Drivers;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by george on 07.07.15.
 */
@Controller
@SessionAttributes("id")
public class DashboardController {
    public static final Logger log = Logger.getLogger(DashboardController.class);

    @Autowired
    private ClientService clientS;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/indexTaxi.html",method = RequestMethod.GET)
    public String index(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            Model model,
            HttpSession session){
        List<Operator> operator;
        operator = operatorService.listOperator();
        for(Operator op1 : operator){
            if(op1.getLogin().equals(login)&&op1.getPassword().equals(password)){
                List<Drivers> drivers = driverService.listDrivers();
                StringBuilder sb = new StringBuilder();
                for (Drivers d : drivers){
                    sb.append(d.getName()).append("|");
                }
                model.addAttribute("driversList",driverService.listDrivers());
                return new String(sb);
            }
        }
        return "false";
    }


    @RequestMapping(value = "/dashboard.html", method = RequestMethod.GET)
    public String great(@RequestParam("login") String name,@RequestParam("paswwd") String paswd, Model model, HttpSession session) {
        log.info("/dashboard.html controller");
        List<Client> client;
        client = clientS.listClient();
        for(Client c: client){
            if(c.getName().equals(name) && c.getPhone().equals(paswd)){
                try{
                    model.addAttribute("clientList",clientS.listClient());
                    return "dashboard";
                }catch (HibernateException e){

                }

            }
        }
        return "clients";
    }

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public @ResponseBody String ajax(Model model){
        return "Yes";
    }

}
