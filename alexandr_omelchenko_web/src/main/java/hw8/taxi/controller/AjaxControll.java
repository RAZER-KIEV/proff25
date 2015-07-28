package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@SessionAttributes("id")
public class AjaxControll {
    @Autowired
    private ClientService service;

    @RequestMapping(value = "/ajax", method = RequestMethod.POST) public
    @ResponseBody String ajax(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {
        if(!login.equals(password)){
            Client client1 = service.getClient(2L);
            Client client2 = service.getClient(4L);
            String result = client1.toString()+client2.toString();
            return result;
        }
        else {
            return "0";
        }
    }
    }
