package web.controller;

import cache.dao.Dao;
import cache.domain.Dom;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

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

    @RequestMapping(value = "/great.html", method = RequestMethod.GET)
    public String great(Model model, HttpSession session) {
        log.info("/great.html controller");
        try {
            model.addAttribute("name", session.getAttribute("name"));
            model.addAttribute("us1", dao.listt.get(0));
            model.addAttribute("us1", dao.listt.get(0));
            model.addAttribute("us2", dao.listt.get(1));
            model.addAttribute("us3", dao.listt.get(2));
            model.addAttribute("us4", dao.listt.get(3));
            model.addAttribute("us5", dao.listt.get(4));
            model.addAttribute("us6", dao.listt.get(25));
            model.addAttribute("us7", dao.listt.get(26));
            model.addAttribute("us8", dao.listt.get(27));
            model.addAttribute("us9", dao.listt.get(28));
            model.addAttribute("us10", dao.listt.get(25));
        }catch (IndexOutOfBoundsException e){}
        return "index";
    }


    @RequestMapping(value = "/medium.html", method = RequestMethod.GET)
    public String medium(@RequestParam("login") String login, String password, Model model) {
        log.info("/medium.html controller");
        if (login.equals("aaa")) {
            String taxists = new String();
            for (Dom dom : Dao.listt){
                taxists = taxists + dom + "<br/>";
            }
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
