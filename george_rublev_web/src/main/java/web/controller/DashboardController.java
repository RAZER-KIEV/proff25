package web.controller;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.domain.Client;
import web.service.ClientService;

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
//
//    @Qualifier("client")
//    @Autowired
//    private Client client;


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
