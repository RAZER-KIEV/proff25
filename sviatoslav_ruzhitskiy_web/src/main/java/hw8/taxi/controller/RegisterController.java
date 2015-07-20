package hw8.taxi.controller;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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


    @RequestMapping(value = "/goToRegisterClient", method = RequestMethod.POST)
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
        Operator opr = authenticationService.read(Long.parseLong(id));
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

    @RequestMapping(value = "/registerOper", method = RequestMethod.POST)
    public String addUser(@RequestParam("login")String login, @RequestParam("password")String password, @RequestParam("passwordConfirm")String passwordConfirm,
                          @RequestParam("inn")String inn, HttpSession session){
        if(authenticationService.searchByLogin(login)==(null)&password.equals(passwordConfirm)){
            Operator opr = new Operator(login,password,inn);
            authenticationService.create(opr);
            session.setAttribute("login", login);
            session.setAttribute("operator", opr);
            return "dashboard";

        }else
            return "index";

    }
}
