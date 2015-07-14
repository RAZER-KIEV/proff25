package hw8.taxi.controller;


import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by just1ce on 11.07.2015.
 */
@Controller
@SessionAttributes("id")
public class AuthenticationController {
    @Autowired
    private AuthenticationServiceImpl authenticationService;
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @RequestMapping(value = "/auth.html", method = RequestMethod.POST)
    public
    String great(@RequestParam("login") String login,
                 @RequestParam("password") String password,
                 Model model) throws AuthenticationException {

        if(authenticationService.authenticate(login, password)){
            model.addAttribute("id",1L);
            return "dashboard";
        }


        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    String index(HttpSession session) {
        Long id = (Long)(session.getAttribute("id"));
        if ((id!=null)&&(id<5L)&&(id>0L)){
            return "dashboard";
        }
        return "index";
    }




}
