package hw8.taxi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HP on 21.07.2015.
 */
@Controller
@SessionAttributes("idd")
public class AjaxControll {

        @RequestMapping(value = "/ajax", method = RequestMethod.GET)
        public @ResponseBody String hey(@RequestParam("login") String login, Model model) {
            if (login.equals("man")) {
                // model.addAttribute("answer", "да");
                return "YES";
            } else return "NO";
        }
}