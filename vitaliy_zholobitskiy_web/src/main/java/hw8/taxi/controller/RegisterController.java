package hw8.taxi.controller;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.service.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by just1ce on 15.07.2015.
 */
@Controller
public class RegisterController {
    @Autowired
    private AuthorizationService authorizationService;
    public static final Logger log = Logger.getLogger(RegisterController.class);
    @RequestMapping(value = "/confirm_register", method = RequestMethod.POST)
    public
    String reg_op(@RequestParam("login") String login,
                 @RequestParam("password") String password,
                 @RequestParam("confirm_password") String confirm_password,
                 Model model) throws  AuthorizationException {
        try {
            if (authorizationService.register(login, "0", password, confirm_password)) {
                model.addAttribute("id", authorizationService.getIdByLogin(login));
                return "dashboard";
            }
        } catch (AuthorizationException ex){
            model.addAttribute("info", ex.toString());
            return "register";
        }
        return "register";

    }

}
