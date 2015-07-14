package scrum.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import scrum.domain.User;
import scrum.service.TaxiService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by oleg on 14.07.15.
 */@org.springframework.stereotype.Controller
   @SessionAttributes("id")
public class Controller {

    @Autowired
    private TaxiService service;
    public static final Logger log = Logger.getLogger(Controller.class);

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        model.addAttribute("name", "default");
        return "index";
    }


    @RequestMapping(value = "/request.html", method = RequestMethod.POST)
    public String medium(@RequestParam("login") String login, String password, Model model) {
        log.info("/request.html controller");

//        if (authenticate(login,password, service.getUserList())) {
        if(login.equals("aaa")){
            model.addAttribute("taxists", /*service.getTaxiList()*/ login + password);
            return "dashboard";
        }
        else {
            model.addAttribute("message", "несуществующий аккаунт или неверный пароль, попробуйте еще разок");
            return "dashboard";
        }
    }

    private static boolean authenticate(String login, String password, List<User> users){
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                if (user.getPass().equals(password)) {
                    return true;
                }
            }
        }
            return false;
    }
}


