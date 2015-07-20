package hw8.taxi.controller;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.OperatorEditingException;
import hw8.taxi.service.AdminService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@Controller
@SessionAttributes({"id","role"})
public class AdminController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @Autowired
    private AdminService adminService;
    @PostConstruct
    public void init(){
        Locale.setDefault(Locale.ENGLISH);
    }

    @RequestMapping(value = "/editOperator", method = RequestMethod.GET)
    public
    String editOperator(Model model, HttpSession session) {
        log.info("/editOperator.html controller");
        if (session.getAttribute("role").equals("SUPERADMIN")){
            model.addAttribute("operators", adminService.getUsersAndAdmins());
            model.addAttribute("roles", new ArrayList<>(Arrays.asList("USER","ADMIN","SUPERADMIN")));
        }else
        if (session.getAttribute("role").equals("ADMIN")){
            model.addAttribute("operators", adminService.getUsers());
            model.addAttribute("roles", new ArrayList<>(Arrays.asList("USER")));
        }
        return "editOperator";
    }

    @RequestMapping(value = "/submitEditOperator", method = RequestMethod.POST)
    public
    String submitEditOperator(@RequestParam String login, @RequestParam String newLogin, @RequestParam String password, @RequestParam String newRole,
                              @RequestParam String ident, @RequestParam Integer countAttempts, @RequestParam String isBlocked,
                              Model model, HttpSession session) {
        log.info("/submitEditOperator controller");
        try{
            adminService.update(login, newLogin, password, newRole, ident, countAttempts, isBlocked);
            model.addAttribute("info","Operator was edited.");
            return "dashboard";
        } catch (OperatorEditingException e) {
            model.addAttribute("error", e.getMessage());
            return editOperator(model,session);
        } catch (HibernateException e) {
        model.addAttribute("error", "Database error.");
        return "dashboard";
    }
    }

    @RequestMapping(value = "/unlockClear", method = RequestMethod.GET)
    public
    String unlockClear(Model model, HttpSession session) {
        log.info("/unlockClear controller");
        if (session.getAttribute("role").equals("SUPERADMIN")){
            model.addAttribute("operators", adminService.getUsersAndAdmins());
        }else
        if (session.getAttribute("role").equals("ADMIN")){
            model.addAttribute("operators", adminService.getUsers());
        }
        return "unlockClear";
    }

    @RequestMapping(value = "/submitUnlockClear", method = RequestMethod.POST)
    public
    String submitUnlockClear(@RequestParam String login, @RequestParam(value = "params[]") String[] params, Model model) {
        log.info("/submitUnlockClear controller");
        String inf="";
        for (String param : params) {
            if (param.equals("clearAttempts")) {
                adminService.clearAttempts(login);
                inf += "Attempts to enter wrong password for user \"" + login + "\" were cleared.<br>";
            } else if (param.equals("unlock")) {
                adminService.unlock(login);
                inf += "User \"" + login + "\" was unlocked.<br>";
            }
        }
        model.addAttribute("info",inf);
        return "dashboard";
    }
}
