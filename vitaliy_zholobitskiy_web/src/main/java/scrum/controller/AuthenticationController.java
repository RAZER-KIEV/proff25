package scrum.controller;


import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import scrum.service.DriverService;
import scrum.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by just1ce on 11.07.2015.
 */
@Controller
@SessionAttributes("id")
public class AuthenticationController {
    @Autowired
    private DriverService driverService;
    @Autowired
    private UserService userService;
    public static final Logger log = Logger.getLogger(AuthenticationController.class);
    @RequestMapping(value = "/auth.html", method = RequestMethod.POST)
    public
    String great(@RequestParam("login") String login,
                 @RequestParam("password") String password,
                 Model model) throws AuthenticationException {

        if(userService.authenticate(login, password)){
            model.addAttribute("id",1L);
            model.addAttribute("drivers",driverService.findAll());
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
