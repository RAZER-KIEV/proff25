package hw8.taxi.controller;

import hw8.taxi.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("id")
public class AuthenticationController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/auth.html", method = RequestMethod.GET)
    //public @ResponseBody String hello(Model model) {
    public String hello(Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "Enter login and password please!");
        return "index";
    }

    @RequestMapping(value = "/welcome.html", method = RequestMethod.GET)
    public String great(@RequestParam("login") String name, @RequestParam("password") String pass, Model model) {
        log.info("/auth.html controller");

        boolean parol = authenticationService.authorization(name, pass);
        if (parol==true){
        model.addAttribute("name", name);
        model.addAttribute("id", 5);
            return "dashboard";
        }
        else
            model.addAttribute("name", "Name "+name+" wrong or wrong password");
            return "index";
    }

    @RequestMapping(value = "/ShowOperators.html", method = RequestMethod.GET)
    public String form(Model model) {
        String l =authenticationService.showAll().toString();
        model.addAttribute("operators", l);
        return "operators";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        model.addAttribute("name", "head");
        return "index";
    }

}