package web.controller;

import dao.Dao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
@SessionAttributes({"id", "name"})
public class HelloController {
    public static final Logger log = Logger.getLogger(HelloController.class);
    Dao dao = new Dao();

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public
//    @ResponseBody
    String hello(Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "Petro");
        return "hello";
    }


    @RequestMapping(value = "/medium.html", method = RequestMethod.GET)
    public String medium(@RequestParam("login") String login, String password, Model model) {
        log.info("/medium.html controller");
        if (login.equals("aaa")) {
            String taxists = new String();
//            for (Dom dom : Dao.listt){
//                taxists = taxists + dom + "<br/>";
//            }
            model.addAttribute("taxists", taxists);
            return "dashboard";
        }
        else {
            model.addAttribute("message", "несуществующий пароль или неверный пароль, попробуйте еще разок");
            return "dashboard";
        }

    }
//    @RequestMapping(value = "/form.html", method = RequestMethod.POST)
//    public
//    @ResponseBody
//    String form(@RequestParam String login,
//                @RequestParam String pass) {
//        return login + "[" + pass + "]";
//    }

    @RequestMapping(value = "/form.html", method = RequestMethod.GET)
    public
    String form(){
        return "form";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        model.addAttribute("name", "default");
        return "index";
    }
}
