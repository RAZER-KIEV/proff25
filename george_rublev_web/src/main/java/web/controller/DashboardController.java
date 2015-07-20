package web.controller;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import scala.collection.immutable.List;
import web.domain.Client;
import web.domain.Operator;
import web.service.ClientService;
import web.service.OperatorService;

import java.util.*;
import javax.servlet.http.HttpSession;

/**
 * Created by george on 07.07.15.
 */
@Controller
@SessionAttributes("id")
public class DashboardController {
    public static final Logger log = Logger.getLogger(DashboardController.class);

    @Autowired
    private ClientService clientS;

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


}
