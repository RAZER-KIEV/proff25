package web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("id")
public class HelloController {
    public static final Logger log = Logger.getLogger(HelloController.class);


    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public
    //@ResponseBody
    String hello(Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "Petro");
        //model.addAttribute("id", 123);
        return "index";
    }

    @RequestMapping(value = "/great.html", method = RequestMethod.POST)
    public
    String great(@RequestParam("login") String name,@RequestParam("password") String password, Model model, HttpSession session, SessionStatus status) {
        log.info("/great.html controller");
        model.addAttribute("name", name);
        model.addAttribute("password",password);
        Long sessId = (Long) session.getAttribute("id");
        //session.invalidate(); //в спринге не желательно
        status.setComplete(); //очищение сессии
        if (sessId == null) {
            return "index";
        }
        return "great";
    }

    @RequestMapping(value = "/form.html", method = RequestMethod.POST)
    public
    @ResponseBody
    String form(@RequestParam String login,
                @RequestParam String pass) {
        return login + "[" + pass + "]";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index() {
        log.info("/index controller");
        return "index";
    }
}
