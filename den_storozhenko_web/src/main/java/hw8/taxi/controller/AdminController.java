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
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    @ResponseBody
    String submitEditOperator(@RequestParam String login, @RequestParam String newLogin, @RequestParam String password, @RequestParam String newRole,
                              @RequestParam String ident, @RequestParam Integer countAttempts, @RequestParam String isBlocked) {
        log.info("/submitEditOperator controller");
        try{
            adminService.update(login, newLogin, password, newRole, ident, countAttempts, isBlocked);
            return "edited";
        } catch (OperatorEditingException e) {
            return e.getMessage();
        } catch (HibernateException e) {
        return "Database error.";
    }
    }

    @RequestMapping(value = "/unlockClear", method = RequestMethod.GET)
    public
    String unlockClear(Model model, HttpSession session) {
        log.info("/unlockClear controller");
        if (session.getAttribute("role")!=null) {
            if (session.getAttribute("role").equals("SUPERADMIN")) {
                model.addAttribute("operators", adminService.getUsersAndAdmins());
            } else if (session.getAttribute("role").equals("ADMIN")) {
                model.addAttribute("operators", adminService.getUsers());
            }
            return "unlockClear";
        }
        return "/";
    }

    @RequestMapping(value = "/submitUnlockClear", method = RequestMethod.POST)
    public
    @ResponseBody
    String submitUnlockClear(@RequestParam String login, Model model) {
        log.info("/submitUnlockClear controller");
        try {
            adminService.unlockClear(login);
            return "<font color=\"BLUE\">Attempts to enter wrong password for user \"" + login + "\" were cleared.<br>User \"" + login + "\" was unlocked.<br></font>";
        }catch (Throwable e){
            return "<font color=\"RED\""+"Error!"+"</font>";
        }
    }
}
