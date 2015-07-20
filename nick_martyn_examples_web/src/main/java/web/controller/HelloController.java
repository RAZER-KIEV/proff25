package web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.bind.SchemaOutputResolver;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
@SessionAttributes("id")
public class HelloController {
    public static final Logger log = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public

        String hello(Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "Petro");
        return "index";
    }

    @RequestMapping(value = "/great.html", method = RequestMethod.GET)
    public String great(@RequestParam("login") String name   ) {
        log.info("/great.html controller");
        //Long sessId = (Long) session.getAttribute("id");
        //if (sessId == null) {
          //  return "index";
       // }

        return "index" ;
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
