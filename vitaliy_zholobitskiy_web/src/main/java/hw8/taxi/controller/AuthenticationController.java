package hw8.taxi.controller;


import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * Created by just1ce on 11.07.2015.
 */
@Controller
@SessionAttributes("id")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @RequestMapping(value = "/auth.html", method = RequestMethod.POST)
    public
    String great(@RequestParam("login") String login,
                 @RequestParam("password") String password,
                 Model model) throws AuthenticationException {
        log.info("/auth.html controller");
        if(authenticationService.authenticate(login, password)){
            model.addAttribute("id",authenticationService.getIdByLogin(login));
            return "dashboard";
        }

        model.addAttribute("info","Incorrect login/password.");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    String index(HttpSession session) {
        Long id = (Long)(session.getAttribute("id"));
        if ((id!=null)){
            return "dashboard";
        }
        return "index";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public
    String register() {
        return "register";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public
    String logout(HttpSession session,SessionStatus status) {
        Long id = (Long)(session.getAttribute("id"));
        if (id!=null){
            status.setComplete();
        }
        return "index";
    }



}
