package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import scrum.dao.UserDao;
import scrum.dao.UserDaoImpl;
import scrum.domain.User;

import javax.servlet.http.HttpSession;

/**
 * Created by Липский on 14.07.2015.
 */


@Controller
@SessionAttributes("id")

public class TaxiServiceController {


    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {



        return "login";

    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String login(Model model) {



        return "login";

    }





    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String dashboard(@RequestParam String login,
                            @RequestParam String password, Model model, HttpSession session, SessionStatus sessionStatus) {

        UserDaoImpl userManager = new UserDaoImpl();



      //  User autorizedUser = userManager.auth(login, password);//


     //   if (autorizedUser == null) {

            model.addAttribute("errorMassage", "Ошибка авторизации");
            return "login";
        }

      //  model.addAttribute("user", autorizedUser);
        //return "dashboard";

    }

//}