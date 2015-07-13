package hw8.taxi.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.exception.ClientException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.AuthenticationServiceImpl;
import hw8.taxi.service.AuthorizationService;
import hw8.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@SessionAttributes("id")
public class Controller {

    private static final Logger log = Logger.getLogger(Controller.class);

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public
    String auth(@RequestParam String login, @RequestParam String password, Model model) {
        try {
            authenticationService.authenticate(login, password);
            model.addAttribute("login", login);
            return "dashboard";
        } catch (AuthenticationException exception) {
            if (exception.getMessage().equals(AuthenticationServiceImpl.getUnsuccessfulPasswordExpired())) {
                model.addAttribute("login", login);
                return "changePassword";
            }
            model.addAttribute("indexMessage", exception.getMessage());
            return "index";
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public
    String registerPost(@RequestParam String login,
                        @RequestParam String password,
                        @RequestParam String passwordConfirmation,
                        @RequestParam String individualTaxpayerNumber, Model model) {

        log.info("registerPost controller");
        if (!password.equals(passwordConfirmation)) {
            model.addAttribute("registerMessage", "Passwords not equals");
            return "register";
        }
        try {
            authorizationService.register(login, individualTaxpayerNumber, password);
        } catch (AuthorizationException exception) {
            model.addAttribute("registerMessage", exception.getMessage());
            return "register";
        } catch (DataIntegrityViolationException exception) {
            model.addAttribute("registerMessage", "Login not unique");
            return "register";
        } catch (Exception exception) {
            model.addAttribute("registerMessage", "Something bad: " + exception.getMessage());
            return "register";
        }
        model.addAttribute("indexMessage", "Registration successful. You can log in now.");
        return "index";
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public
    String changePassword(@RequestParam String login,
                          @RequestParam String password,
                          @RequestParam String passwordConfirmation,
                          Model model) {

        model.addAttribute("login", login);

        if (!password.equals(passwordConfirmation)) {
            model.addAttribute("changePasswordMessage", "Passwords not equals");
            return "changePassword";
        }

        try {
            authorizationService.changePassword(login, password);
            model.addAttribute("indexMessage", "Password change successful. You can log in now.");
            return "index";
        } catch (AuthorizationException exception) {
            model.addAttribute("changePasswordMessage", exception.getMessage());
            return "changePassword";
        }

    }

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public
    String register() {
        log.info("/register.html controller");
        return "register";
    }

    @RequestMapping(value = "timeMachine", method = RequestMethod.POST)
    public
    String timeMachine(@RequestParam String login) {
        log.info("/timeMachine.html controller");
        authenticationService.doBadWork(login, 90);
        return "index";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index() {
        log.info("/index controller");
        return "index";
    }

    @RequestMapping(value = "createClient", method = RequestMethod.POST)
    public
    String createClient(@RequestParam String login,
                        @RequestParam String name,
                        @RequestParam String surname,
                        @RequestParam String phone,
                        @RequestParam String address,
                        Model model) {

        model.addAttribute("login", login);
        try {
            clientService.createClientWithOperator(login, name, surname, phone, address);
            model.addAttribute("dashboardMessage", "Client successfully created.");
        } catch (ClientException e) {
        } catch (Exception e) {
            model.addAttribute("dashboardMessage", "Error: " + e.getMessage());
        } finally {
            return "dashboard";
        }
    }

    @RequestMapping(value = "listClients", method = RequestMethod.POST)
    public
    String listClients(@RequestParam String login,
                       @RequestParam String clientsMode,
                       @RequestParam String chunkSize,
                       @RequestParam String sum,
                       Model model) {

        model.addAttribute("login", login);
        List<Client> clients = null;
        switch (clientsMode) {
            case "all":
                clients = clientService.showClientsByPortion(Integer.parseInt(chunkSize));
                break;
            case "sum":
                clients = clientService.showClientsGtSum(Integer.parseInt(sum));
                break;
            case "date":
                clients = clientService.showClientsLastMonth();
                break;
            case "default":
                clients = clientService.showAllClients();
                break;
        }
        String clientsStringRepresentation = "";

        log.info("list size: " + clients.size());

        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i) == null) {
                clientsStringRepresentation = clientsStringRepresentation + "*" + "<br>";
            } else {
                clientsStringRepresentation = clientsStringRepresentation + clients.get(i).getName() + "<br>";
            }
        }

        model.addAttribute("clients", clientsStringRepresentation);
        return "dashboard";
    }

}
