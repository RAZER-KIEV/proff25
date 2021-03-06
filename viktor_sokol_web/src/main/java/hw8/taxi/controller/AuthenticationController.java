package hw8.taxi.controller;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@SessionAttributes("id")
public class AuthenticationController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Autowired
    private AuthenticationService authenticationService;

    @PostConstruct
    public void init(){
        Locale.setDefault(Locale.ENGLISH);
    }

    public boolean isAutorized(HttpSession session){
        return session.getAttribute("id")!=null;
    }

    @RequestMapping(value = "/dashboard.html", method = RequestMethod.GET)
    public
    String dashboard(Model model, HttpSession session) {
        log.info("/dashboard.html controller");
        if (isAutorized(session)){
            model.addAttribute("hello", "Hello, "+authenticationService.getOperator((Long)session.getAttribute("id")).getLogin()+"!");
            return "dashboard";
        }
        else {
            return "index";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public
    String login(Model model, HttpSession session) {
        log.info("/login.html controller");
        if (isAutorized(session)){
            model.addAttribute("hello", "Hello, "+authenticationService.getOperator((Long)session.getAttribute("id")).getLogin()+"!");
            return "dashboard";
        }
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    String login(@RequestParam("login") String login, @RequestParam("password") String password, Model model, HttpSession session) {
        log.info("/login.html controller");
        if (isAutorized(session)){
            model.addAttribute("hello", "Hello, "+authenticationService.getOperator((Long)session.getAttribute("id")).getLogin()+"!");
            return "dashboard";
        }
        try {
            authenticationService.authenticate(login, password);
            model.addAttribute("id", authenticationService.readByLoginPass(login, password));
            model.addAttribute("hello", "Hello, " + login + "!");
            return "dashboard";
        } catch (AuthenticationException e) {
            model.addAttribute("authenticateEx", e.getMessage());
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
    public String index(HttpSession session) {
        log.info("/index controller");
        if (isAutorized(session)){
            return "dashboard";
        }
        return "index";
    }
}