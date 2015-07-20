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
import java.util.Locale;

/**
 * Created by ПК on 14.07.2015.
 */

@Controller
@SessionAttributes("id")
public class RegisterController {
    @Autowired
    private OperatorDao operatorDao;

    @Autowired
    private AuthorizationService authorizationService;

    //public static final Logger log = Logger.getLogger(RegisterController.class);

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

}
