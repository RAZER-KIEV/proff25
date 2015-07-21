package hw8.taxi.controller;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.annotation.PostConstruct;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Created by ПК on 11.07.2015.
 */

@Controller
@SessionAttributes("id")
public class AuthenticationController {

    public static final Logger log = Logger.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    AuthenticationController() {
    }


    @RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST, RequestMethod.HEAD})
    public String great() {
        log.info("/index controller");
        return "index";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(@RequestParam("login") String login, @RequestParam("password") String password, Model model, HttpSession session) throws AuthenticationException {
       if(authenticationService.authenticate(login, password)){
           log.debug("Its Ok Operator found");
           Operator operator = authenticationService.searchByLogin(login);
           session.setAttribute("operator",operator);
           session.setAttribute("operlogin", login);
           return "dashboard";
       }else{
           session.setAttribute("countAdd", 1);
           log.debug("Something wrong Operator not found");
           return "index";
       }
    }
}