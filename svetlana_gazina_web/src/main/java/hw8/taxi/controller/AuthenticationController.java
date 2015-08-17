package hw8.taxi.controller;

import hw8.taxi.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by Sveta on 7/16/2015.
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


    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String great() {
        log.info("/index controller");
        return "index";
    }

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String indexDirect(){
        return "index";
    }

    @RequestMapping(value = "/index_two", method = {RequestMethod.GET, RequestMethod.POST})
    public String index2Direct(){
        return "index2";
    }
    @RequestMapping(value = "/tutorial", method = {RequestMethod.GET, RequestMethod.POST})
    public String tutorialDirect(){
        return "tutorial";
    }



    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(@RequestParam("login") String login, @RequestParam("password") String password, Model model, HttpSession session) throws AuthenticationException, hw8.taxi.exception.AuthenticationException {
        if(authenticationService.authenticate(login, password)){
            session.setAttribute("name", login);
            return "dashboard";
        }
        return "index";
    }
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public
    @ResponseBody
    String ajax(@RequestParam("login") String login, @RequestParam("pass") String pass, Model model) {
        return "hello " + login;
    }
}
