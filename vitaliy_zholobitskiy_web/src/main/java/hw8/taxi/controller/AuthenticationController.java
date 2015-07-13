package hw8.taxi.controller;


import hw8.taxi.exeption.AuthenticationException;
import hw8.taxi.service.AuthenticationServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by just1ce on 11.07.2015.
 */
@Controller
@SessionAttributes("id")
public class AuthenticationController {
    @Autowired
    private AuthenticationServiceImpl authenticationService;
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public
    String great(@RequestParam("login") String login,
                 @RequestParam("password") String password) throws AuthenticationException {
        log.info("/great.html controller");
        if(authenticationService.authenticate(login, password))
            return "dashboard";

        return "/WEB-INF/qw/index.jsp";
    }



}
