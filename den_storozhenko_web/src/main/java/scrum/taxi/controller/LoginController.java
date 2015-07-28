package scrum.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import scrum.taxi.domain.Driver;
import scrum.taxi.service.DriverService;
import scrum.taxi.service.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes("id")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private DriverService driverService;

    @PostConstruct
    public void init(){
        Locale.setDefault(Locale.ENGLISH);
    }

    @RequestMapping(value = "/",method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index1(){
        return "index1";
    }

    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public String index(){
        return "index1";
    }

    /*@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password, Model model){
        if (userService.authenticate(login,password)){
            System.out.println("AUTH!");
            model.addAttribute("drivers", driverService.findAll());
            return "drivers";
        }
        else {
            System.out.println("NOT AUTH!");
            model.addAttribute("info", "Login or password incorrect.");
            return "index";
        }
    }*/

    @RequestMapping(value = "/ajaxlogin",method = RequestMethod.POST)
    public
    @ResponseBody
    List login(@RequestParam String login, @RequestParam String password){
        if (userService.authenticate(login,password)){
            String res = "";
//            for (Driver driver:(List<Driver>)driverService.findAll()){
//                res+=driver.getSurname()+"|";
//            }
            return driverService.findAll();
        }
        else{
            return null;
        }

    }
}