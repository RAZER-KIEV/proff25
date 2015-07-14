package hw8.taxi.controller;

import hw8.taxi.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Vlad on 05.04.2015.
 */

@Controller
@SessionAttributes("employee")
public class RegisterController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(value = "register.html", method = RequestMethod.POST)
    public String registration(@RequestParam("login") String login, @RequestParam("id") String id,
                               @RequestParam("pass") String password,
                               @RequestParam("confirmPass") String confirmPass, Model model) {
        if (authorizationService.getByLogin(login) != null) {
            model.addAttribute("loginError", "Пользователь с такми логином уже существует");
            return "register";
        } else if (login.length() > 4 && login.indexOf(' ') != -1) {
            model.addAttribute("loginError", "логин (должен быть не менее 4 символов, не должен содержать пробелы)");
            return "register";
        } else if (!id.matches("[1-9]+[0-9]*") && id.length() != 10) {
            model.addAttribute("idError", "идентификационный номер (10 цифр, без букв и других знаков)");
            return "register";
        } else if (password.length() < 8) {
            model.addAttribute("passError", "пароль (должен быть не менее 8 символов,\n" +
                    " включать большие и маленькие буквы, цифры, ");
            return "register";
        } else if (!password.equals(confirmPass)) {
            model.addAttribute("passConfirmError", "Пароли не совпадают");
            return "register";
        } else {
            authorizationService.register(login, id, password);
            model.addAttribute("message", "Registration was successful");
            return "index";
        }

    }

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String regIndex() {
        return "register";
    }

}
