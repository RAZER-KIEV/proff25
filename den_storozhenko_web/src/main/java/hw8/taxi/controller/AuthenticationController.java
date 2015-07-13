package hw8.taxi.controller;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Controller
@SessionAttributes("id")
public class AuthenticationController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Autowired
    private AuthenticationService authenticationService;

    @PostConstruct
    public void init(){
        Locale.setDefault(Locale.ENGLISH);;
    }

    @RequestMapping(value = "/dashboard.html", method = RequestMethod.POST)
    public
    String login(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {

        log.info("/dashboard.html controller");
        model.addAttribute("hello", "Hello, "+login+"!");
        try{
            authenticationService.authenticate(login,password);
            return "dashboard";
        } catch (AuthenticationException e){
            model.addAttribute("authenticateEx",e.getMessage());
            return "index";
        } catch (HibernateException e) {
            model.addAttribute("error", "Database error.");
            return "index";
        }
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
    public String changePass(@RequestParam("login") String login, Model model){
        log.info("changepassword.html controller");
        model.addAttribute("login",login);
        return "changepass";
    }

    @RequestMapping(value = "/changepass.html", method = RequestMethod.POST)
    public String changePassword(@RequestParam String login, @RequestParam String password, @RequestParam String newPassword,
                               @RequestParam String confirmPassword, Model model){
        log.info("changepass.html controller");
        model.addAttribute("login",login);
        try {
            authenticationService.changePassword(login, password, newPassword, confirmPassword);
            model.addAttribute("info","Password for the user "+login+" has been changed successfully.<br>");
            return "index";
        } catch (AuthenticationException e) {
            model.addAttribute("authenticateEx",e.getMessage());
            return "changepass";
        } catch (HibernateException e){
            model.addAttribute("error","Database error.");
            return "changepass";
        }

    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        return "index";
    }
}