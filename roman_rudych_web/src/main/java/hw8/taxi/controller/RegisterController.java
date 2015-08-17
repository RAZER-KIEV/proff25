package hw8.taxi.controller;

import hw8.taxi.dao.UserDao;
import hw8.taxi.dao.UserDaoImpl;
import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

/**
 * Created by Роман on 13.07.2015.
 */
@Controller
@SessionAttributes("id")
public class RegisterController {

    public static final Logger log = Logger.getLogger(RegisterController.class);

    @Autowired
    private AuthorizationService service;

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register () {
        return "register";
    }

    @RequestMapping(value = "/registerAction.html", method = RequestMethod.POST)
    public String registerAct (@RequestParam("login") String login,
                               @RequestParam("id") String id,
                               @RequestParam("password") String password,
                               @RequestParam("passwordConfirm") String passConfirm,
                               Model model) {
        try {
            if(service.register(login, id, password, passConfirm)) {
                model.addAttribute("successRegistration", "Registration is successful");
                log.info("Registration is successful");
                return "dashboard";
            } else {
                model.addAttribute("warningReg", "Registration failed.");
                log.info("Registration failed");
            }
        } catch (AuthorizationException ex) {
            model.addAttribute("warningReg", ex.getMessage());
            log.info("Registration failed");
        }
        return "register";
    }
}
