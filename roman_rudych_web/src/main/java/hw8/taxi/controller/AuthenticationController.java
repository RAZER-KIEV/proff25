package hw8.taxi.controller;

import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Роман on 11.07.2015.
 */
@Controller
@SessionAttributes("id")
public class AuthenticationController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService service;

    @Autowired
    private ClientService serv;

    private Map<String, Integer> attemptsMap = new TreeMap<>();

//    @Value("${conf.property.attempts}")
    private Integer attemptsMaxValue=3;

    private String currentLogin;

    @RequestMapping(value = "/dashboard.html", method = RequestMethod.POST)
    public String dashboard (@RequestParam("login") String login,
                             @RequestParam("password") String pass,
                             Model model) {

        log.info("/dashboard.html controller");

        if(service.isExistingName(login)) {
            if(service.getUser(login).isBlocked()) {
                model.addAttribute("warning", "User is blocked.");
                log.info("/dashboard.html User is blocked");
                return "index";
            }
        } else {
            model.addAttribute("warning", "Such user: \"" + login + "\" does not exist");
            log.info("/dashboard.html  User does not exist");
            return "index";
        }

        /**
         * Attempts of each user count
         */
        if(attemptsMap.containsKey(login)) {
            Integer attempts = attemptsMap.get(login);
            if(attempts + 1 > attemptsMaxValue) {
                User user = service.getUser(login);
                user.setBlocked(true);
                service.update(user);
                model.addAttribute("warning", "User is blocked. Too many attempts to log in");
                return "index";
            }
            attemptsMap.put(login, attempts+1);
        } else {
            attemptsMap.put(login, 1);
        }

        try {
            if(service.authenticate(login, pass)) {
                log.info("/dashboard.html authenticate is ok");
                if(service.getUser(login).getPassSetDate().getTime() + service.getUser(login).getExpiredTimeMillis() > System.currentTimeMillis()) {
                    model.addAttribute("name", login + ", log in is successful");

                    return "dashboard";
                } else {
                    currentLogin = login;
                    log.info("/dashboard.html pass expired");
                    return "dashboardChangePass";
                }
            } else {
                log.info("/dashboard.html authenticate failed");
                model.addAttribute("warning", "Wrong password for " + login);
                return "index";
            }
        } catch (AuthenticationException ex) {
            model.addAttribute("warning", ex.getMessage() + " " + (attemptsMaxValue-attemptsMap.get(login)) + " attempt(s)remaining");
            log.error("Authenticate error while checking user");
        }
        return "";
    }

    @RequestMapping(value = "/dashboardChangePass.html", method = RequestMethod.POST)
    public String dashboardChangePass (@RequestParam("password") String pass,
                             @RequestParam("passwordConfirmed") String passConf,
                             Model model) {
        Locale.setDefault(Locale.ENGLISH);

        if(pass.equals(passConf)) {
            service.getUser(currentLogin).setPassword(pass);
            model.addAttribute("passChanged", currentLogin + ", password has changed successful");
            return "dashboard";
        } else {
            model.addAttribute("warning", "Confirmation of password is wrong");
            return "dashboardChangePass";
        }
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        Locale.setDefault(Locale.ENGLISH);
        log.info("/index controller");
        return "index";
    }

//    @RequestMapping(value = "/ajaxTest", method = {RequestMethod.POST})
//    public
//    @ResponseBody
//    String ajaxTest( @RequestParam("login") String login,
//                                         @RequestParam("password") String pass, Model model) {
//        String aaaa =login +" "+ pass;
//        System.out.println(aaaa);
//        return aaaa;
//    }
}
