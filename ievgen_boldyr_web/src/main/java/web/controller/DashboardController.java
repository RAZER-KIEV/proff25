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

    @RequestMapping(value = "/indexTaxi.html",method = RequestMethod.POST)
    public @ResponseBody String indexTaxi(@RequestParam("login") String login,@RequestParam("pass") String password){
        log.info("controller");
        List<Operator> operator = operatorService.listOperator();
        for(Operator op1 : operator){
            if(op1.getLogin().equals(login)&&op1.getPassword().equals(password)){
                List<Drivers> drivers = driverService.listDrivers();
                String sb = "<table border=\"1\"><tr><td>Name</td><td>Phone</td><td>model</td><td>number</td></tr>";
                for (Drivers d : drivers){
                    sb = sb + "<tr><td>"+d.getName()+"</td><td>"+d.getPhone()+"</td><td>"+d.getCarNum()+"</td><td>"+d.getCarNumber()+"</td></tr>";
                }
                    sb = sb+"</table>";
                return sb;
            }else{
                return "error else";
            }
        }
        return "error";
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
