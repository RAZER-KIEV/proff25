package hw8.taxi.controller;

import hw8.taxi.domain.Operator;
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
 * Created by Sveta on 8/10/2015.
 */
@Controller
@SessionAttributes("id")
public class RegisterController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AuthorizationService authorizationService;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    RegisterController() {
    }


    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/createEditOperator", method = RequestMethod.POST)
    public String createEditOperator(@RequestParam("id")String id,@RequestParam("login") String login, @RequestParam("inn") String inn, @RequestParam("password") String password,
                                     @RequestParam("confirm")String confirm, @RequestParam("wrongPass") String wrongPass, Model model ) throws AuthorizationException {

        authorizationService.register(login, inn, password, confirm);

        return "tutorial";
    }

}
