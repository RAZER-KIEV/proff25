package home.controller;


import com.google.gson.Gson;
import home.domain.Employee;
import home.service.AuthenticationService;
import home.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.management.counter.Units;

import javax.annotation.PostConstruct;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private EmployeeService employeeService;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    public static Gson gson = new Gson();

    AuthenticationController() {
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD})
    public String great() {
        log.info("/index controller works");

        return "start";
    }

    @RequestMapping(value = "/111", method = {RequestMethod.GET, RequestMethod.POST})
    public String great111() {
        log.info("/index controller111");
        return "cw2707";
    }


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(@RequestParam("login") String login, @RequestParam("password") String password, Model model, HttpSession session) throws AuthenticationException {
        if (authenticationService.authenticate(login, password)) {
            log.debug("Its Ok, Operator found");
            Employee employee = authenticationService.searchByLogin(login);
            session.setAttribute("employee", employee);
            session.setAttribute("empllogin", login);
            return "dashboard";
        } else {
            session.setAttribute("countAdd", 1);
            log.debug("Something wrong Operator not found");
            return "index";
        }
    }

    @RequestMapping(value = "/authAndroid", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String authAndroid(@RequestParam("login") String login, @RequestParam("password") String password, HttpSession session) throws AuthenticationException {
        try {
            if (authenticationService.authenticate(login, password)) {
                Employee employee = employeeService.searchByLogin(login);
                log.debug("Its Ok, Operator found");
                session.setAttribute("NMQCUID",employee.getId());
                return "Auth_Success "+gson.toJson(employee);
            } else {
                return "Auth_Error";
            }
        } catch (Exception e) {
            log.debug("Something wrong Operator not found");
            e.printStackTrace();
            return "Auth_Error";
        }

    }
}