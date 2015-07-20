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
import web.service.ClientService;

import javax.servlet.http.HttpSession;

/**
 * Created by george on 07.07.15.
 */
@Controller
@SessionAttributes("id")
public class Serv {
    public static final Logger log = Logger.getLogger(Serv.class);

    @Autowired
    private ClientService clientS;

    @RequestMapping(value = "/dashboard.html", method = RequestMethod.GET)
    public String great(@RequestParam("login") String name, Model model, HttpSession session) {
        log.info("/dashboard.html controller");
        String result = "";
        try {
            model.addAttribute("clientList",clientS.listClient());
            return "dashboard";
        } catch (HibernateException e) {
            model.addAttribute("error", "Database error.");
            return "dashboard";
        }
    }


}
