package web.controller;

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
@SessionAttributes("id")
public class ControllerTest {
    public static final Logger log = Logger.getLogger(ControllerTest.class);

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public
    @ResponseBody
    String hello(Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "Petro");
        return "hello";
    }

    @RequestMapping(value = "/form.html", method = RequestMethod.POST)
    public
    @ResponseBody
    String form(@RequestParam String login,
                @RequestParam String pass) {
        return login + "[" + pass + "]";
    }


    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        model.addAttribute("name", "al1");
        return "index";
    }
}
