package home.controller;


import home.domain.Admin;
import home.service.AuthenticationService;
import home.service.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by ПК on 14.07.2015.
 */

@Controller
@SessionAttributes("id")
public class RegisterController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthorizationService authorizationService;

    public static final Logger log = Logger.getLogger(AuthorizationService.class);

    @PostConstruct
    public void init(){
        Locale.setDefault(Locale.ENGLISH);
    }

    public RegisterController(){}

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(){
        return "register";
    }


    @RequestMapping(value = "/goToRegisterClient", method = {RequestMethod.POST, RequestMethod.GET})
    public String goToRegisterClient(){
          return "registerClient";
    }

    @RequestMapping(value = "/backToDashboard", method = RequestMethod.POST)
    public String backToDashboard(){
        return "dashboard";
    }

    @RequestMapping(value = "/showOperators", method = RequestMethod.POST)
    public String showOperators(Model model){
        model.addAttribute("list",authenticationService.findAll());
         return "operators";
    }

    @RequestMapping(value = "/createEditOperator", method = RequestMethod.POST)
    public String createEditOperator(@RequestParam("id")String id,@RequestParam("login") String login, @RequestParam("inn") String inn, @RequestParam("password") String password,
                                     @RequestParam("isBlocked")String isBlocked, @RequestParam("isSuperAdmin") String isSuperAdmin, @RequestParam("wrongPass") String wrongPass, Model model ){
        Admin opr = authenticationService.read(Long.parseLong(id));
         if(opr!=null){
            log.info("Operator exist. Updating...");
             model.addAttribute("message","Operator already exist. Updated");
         }else {
             log.info("Operator not exist. Creating...");
             model.addAttribute("message", "Operator was not exist. Created new one!");
         }
            if(login!=null) opr.setLogin(login);
            if(inn!=null) opr.setInn(inn);
            if(password!=null)opr.setPassword(password);
            if(isBlocked!=null)opr.setIsBlocked(false);
            if(isSuperAdmin!=null)opr.setIsSuperAdmin(false);
            if(wrongPass!=null)opr.setWrongPass(Integer.parseInt(wrongPass));
        authenticationService.update(opr);

        return "operator";
    }

    @RequestMapping(value = "/goToCreateUpdateOperator", method = RequestMethod.POST)
    public String goToCreateUpdateOperator(){
        return "operator";
    }

    @RequestMapping(value = "/registerOper", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String addUser(@RequestParam("login")String login, @RequestParam("password")String password, @RequestParam("passwordConfirm")String passwordConfirm,
                          @RequestParam("inn")String inn, HttpSession session){
        if(authenticationService.searchByLogin(login)==(null)&password.equals(passwordConfirm)){
            Admin opr = new Admin(login,password,inn);
            authenticationService.create(opr);
            session.setAttribute("login", login);
            session.setAttribute("operator", opr);
            return "Success! Operator registered!";

        }else
            session.setAttribute("message","Error! Admin already exist");
            return "register";

    }
}
