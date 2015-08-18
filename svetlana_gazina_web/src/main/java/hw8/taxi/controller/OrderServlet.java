package hw8.taxi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Sveta on 8/17/2015.
 */
@Controller
@SessionAttributes("id")
public class OrderServlet {
    @RequestMapping(value = "/orders", method = {RequestMethod.GET, RequestMethod.POST})
    public String register(){
        return "orders";
    }
}
