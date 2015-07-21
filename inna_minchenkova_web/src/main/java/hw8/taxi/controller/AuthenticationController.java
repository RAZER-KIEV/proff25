package hw8.taxi.controller;

import hw8.taxi.domain.Employee;
import hw8.taxi.domain.SessionProperties;
import hw8.taxi.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Vlad on 02.04.2015.
 */
@Controller
@SessionAttributes({"sessionProperties", "employee"})
public class AuthenticationController {
    @Value("${attempts}")
    private int attempts;


    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "index.html", method = RequestMethod.POST)
    public String login(@RequestParam("login") String login,
                        @RequestParam("pass") String password,
                        Model model, @ModelAttribute Employee employee,
                        @ModelAttribute SessionProperties sessionProperties) {

        System.out.println(login + " ______ " + password);
        System.out.println(sessionProperties.getName() + "___" + "Колиество попыток ввода пароля " + sessionProperties.getAttempt());

        if (employee.isEmployeeBlock()) {
            model.addAttribute("message", "This Operator is blocked");
            return "index";
        }

        if (login == null || login.equals("") || password == null || password.equals("")) {
            sessionProperties.setAttempt(sessionProperties.getAttempt() - 1);
            return "index";
        } else if (authenticationService.authenticate(login, password)) {
            employee.setEmployeeLogin(login);
            sessionProperties.setAttempt(attempts);
            return "dashboard";
        } else {
            sessionProperties.setAttempt(sessionProperties.getAttempt() - 1);
        }

        if (sessionProperties.getAttempt() <= 0) {
            authenticationService.setBlock(login);
            sessionProperties.setSessionUserName(login);
            model.addAttribute("message", "5 attempts to enter your password exhausted, please change password");
            return "index";
        }
        return "index";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String start(Model model, HttpSession session) {
        model.addAttribute("sessionProperties", new SessionProperties("session id_" + session.getId()));
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @RequestMapping(value = "index.html", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String start() {
        return "index";
    }


    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String start(Model model, @ModelAttribute Employee employee) {
        employee.setEmployeeLogin(null);
        return "index";
    }

    @RequestMapping(value = "jquery.html", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String jquery() {

        return "jquery";
    }


    @RequestMapping(value = "/ajax", method = {RequestMethod.GET, RequestMethod.HEAD})
    public
    @ResponseBody
    String ajax(@RequestParam String name) {
        return "hello" + name;
    }
}
