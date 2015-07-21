package taxi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import taxi.domain.*;
import taxi.exception.AuthenticationException;
import taxi.exception.AuthorizationException;
import taxi.service.AuthenticationService;
import taxi.service.AuthenticationServiceImpl;
import taxi.service.AuthorizationService;
import taxi.domain.Client;
import taxi.domain.Operator;
import taxi.domain.Role;
import taxi.domain.TaxiDriver;
import taxi.service.TService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */

@org.springframework.stereotype.Controller
@SessionAttributes("loginId")
public class MainController {
    private static final Logger log = Logger.getLogger(MainController.class);
    @Autowired
    private TService service;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    AuthorizationService authorizationService;

    /*
    Autor: Алексей
    точка входа
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String main(HttpSession session) {
        addOperators();
        if (!isAuth(session))
            return "index";
        return "dashboard";
    }

    /*
    Autor: Aleksey Khalikov
    Dashboard
     */
    @RequestMapping(value = "/dash.html", method = {RequestMethod.GET})
    public String resend(HttpSession session) {
        log.info("/dash controller");
        if (!isAuth(session))
            return "index";
        return "dashboard";
    }

    /*
    Autor: Aleksey Khalikov
    Загружает титульную строку в Dashboard
    */
    @RequestMapping(value = "/title.html", method = {RequestMethod.GET})
    public String getTitlePage(HttpSession session) {
        if (!isAuth(session))
            return "index";
        return "title";
    }

    /*
    Autor: Aleksey Khalikov
    Загружает страницу меню в Dashboard
     */
    @RequestMapping(value = "/menu.html", method = {RequestMethod.GET})
    public String getMenuPage(Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        Operator operator = service.readOperator((String) session.getAttribute("loginId"));
        Boolean isAdmin = operator.getRole().isAdminPanelVisible();
        model.addAttribute("isAdmin", isAdmin);
        return "menu";
    }

    /*
    Autor: Aleksey Khalikov
    Загружает страницу приветствия в Dashboard
    */
    @RequestMapping(value = "/main.html", method = {RequestMethod.GET})
    public String getWelcomePage(HttpSession session) {
        if (!isAuth(session))
            return "index";
        return "welcome";
    }

    /*
           Autor: Aleksey Khalikov
   загружает страницу регистрации клиентов
     */
    @RequestMapping(value = "/startRegisterClient.html", method = {RequestMethod.GET})
    public String startRegisterClient(HttpSession session) {
        if (!isAuth(session))
            return "index";
        return "registerClient";
    }

    /*
               Autor: Aleksey Khalikov
   регистрируем нового клиента
     */
    @RequestMapping(value = "/createClient", method = {RequestMethod.GET})
    public String createClient(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("phone_number") String phone, @RequestParam("address") String address, Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        service.createClient(new Client(name, surname, phone, address));
        List<Client> list = service.findAllClients();
        model.addAttribute("clientList", list);
        return "clients";
    }

    /*
    Autor: Aleksey Khalikov
    загружает страницу отчетов по клиентам
    */
    @RequestMapping(value = "/clientReport.html", method = {RequestMethod.GET})
    public String getClientReportPage(HttpSession session) {
        if (!isAuth(session))
            return "index";
        return "clientReport";
    }

/*
    Autor: Aleksey Khalikov
    выводит список всех клиентов
*/
    @RequestMapping(value = "/clientslistAll.html", method = {RequestMethod.GET})
    public String showClientslist(Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        List<Client> list = service.findAllClients();
        log.info("/clients controller");
        model.addAttribute("clientList", list);
        return "clients";
    }

    /*
        Autor: Aleksey Khalikov
    Загружает страницу со списком клиентов списком по 10
     */
    @RequestMapping(value = "/clientsPortinedByTen.html", method = {RequestMethod.GET})
    public String showClients(@RequestParam("portion") Long portion,Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        List<Client> list = service.clientsPortinedByTen(portion);
        log.info("/clients controller");
        model.addAttribute("clientList", list);
        return "clients";
    }

    /*
        Autor: Aleksey Khalikov
    Загружает страницу со списком клиентов делавших заказы за последний месяц
     */
    @RequestMapping(value = "/ClientsMadeOrdersDuringLastMonth.html", method = {RequestMethod.GET})
    public String showClientsMadeOrdersDuringLastMonth(Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        List<Client> list = service.clientsMadeOrdersDuringLastMonth();
        log.info("/clients controller");
        model.addAttribute("clientList", list);
        return "clients";
    }

    /*
    Autor: Aleksey Khalikov
    вывести всех клиентов наездивших на сумму больше указанной
     */
    @RequestMapping(value = "/ClientsWithOrderAmountMoreThen.html", method = {RequestMethod.GET})
    public String showClientswithOrderAmountMoreThen(@RequestParam("value") Long value, Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        List<Client> list = service.clientswithOrderAmountMoreThen(value);
        log.info("/clients controller");
        model.addAttribute("clientList", list);
        return "clients";
    }

    /*
    Autor: Alexandr Omelchenko
    Driver List
     */
    @RequestMapping(value = "/drivers.html", method = {RequestMethod.GET})
    public String showDrivers(Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        List<TaxiDriver> list = service.findAllTaxists();
        log.info("/drivers controller");
        model.addAttribute("driversList", list);
        return "drivers";
    }

    /*
    Autor: Alexandr Omelchenko
    Create Driver
     */
    @RequestMapping(value = "/createDriver.html", method = {RequestMethod.GET})
    public String startRegisterDriver(HttpSession session) {
        if (!isAuth(session))
            return "index";
        log.info("/create controller");
        return "registerDriver";
    }

    /*
    Autor: Alexandr Omelchenko
    Create Driver
     */
    @RequestMapping(value = "/newDriver.html", method = {RequestMethod.GET})
    public String createDriver
    (@RequestParam("name") String name, @RequestParam("model") String carModel,
     @RequestParam("number") String carNumber, @RequestParam("phone") String phone, Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        service.createTaxist(new TaxiDriver(name, carModel, carNumber, phone));
        log.info("/newDriver controller");
        model.addAttribute("driversList", service.findAllTaxists());
        return "drivers";
    }

    /* Autor: Alexandr Omelchenko
     Driver List
     */
    @RequestMapping(value = "/operators.html", method = {RequestMethod.GET})
    public String showOperators(Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        List<Operator> list = service.findAllOperators();
        log.info("/operators controller");
        model.addAttribute("operatorsList", list);
        return "operators";
    }
    /* Autor: Alexandr Omelchenko
     Operator Redactor
     */
    @RequestMapping(value = "/changeOperator.html", method = {RequestMethod.GET})
    public String toredactOper(Model model, HttpSession session){
        if (!isAuth(session))
            return "index";
        model.addAttribute("message", "Введите данные для редактирования.");
        log.info("/changeOperator controller");
        return "redactorOperator";
    }
    @RequestMapping(value = "/redactOperator.html", method = {RequestMethod.GET})
    public String redactorOper
            (@RequestParam("oldLogin") String oldLogin,
             @RequestParam("newLogin") String newLogin,
             @RequestParam("pass") String pass,
             @RequestParam("indNum") Long indNum,
             @RequestParam("prevpass") String prevpass,
             @RequestParam("lastChangeDate") LocalDateTime lastChangeDate,
             @RequestParam("isblocked") Boolean isblocked,
             @RequestParam("unsuccTries") Long unsuccTries,
             Model model,
             HttpSession session) {
        if (!isAuth(session))
            return "index";
        Operator operator = service.readOperator(oldLogin);
        if (operator == null) {
            log.info("/redactOperator controller");
            model.addAttribute("message", "Неверное имя оператора! Повторите попытку.");
            return "redactorOperator";
        }
        else {
            operator.setLogin(newLogin);
            operator.setPassword(pass);
            operator.setIndividualTaxpayerNumber(indNum);
            operator.setPreviousPassword(prevpass);
            operator.setLastPasswordChangeDate(lastChangeDate);
                operator.setIsBlocked(isblocked);

            operator.setUnsuccessfulLoginTries(unsuccTries);
            service.updateOperator(operator);
            log.info("/redactOperator controller");
            model.addAttribute("message", "Редактирование прошло успешно!");
            return "redactorOperator";
        }
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "/createOrder.html", method = RequestMethod.GET)
    public
    String createOrder(Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        model.addAttribute("clients", service.findAllClients());
        model.addAttribute("taxiDrivers", service.findAllTaxists());
        return "registerOrder";
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "newOrder", method = RequestMethod.POST)
    public
    String newOrder(@RequestParam String client,
                    @RequestParam String taxiDriver,
                    @RequestParam String moneyAmount,
                    @RequestParam String addressFrom,
                    @RequestParam String addressTo,
                    Model model,
                    HttpSession session) {

        if (!isAuth(session))
            return "index";
        LocalDateTime now = LocalDateTime.now();
        Long moneyAmount1 = Long.parseLong(moneyAmount);

        Client client1 = service.readClient(Long.parseLong(client));
        client1.setLastOrderDate(now);
        Long oldNewMoneyAmount = client1.getTotalMoneyAmount();
        if (oldNewMoneyAmount == null) {
            oldNewMoneyAmount = 0L;
        }
        client1.setTotalMoneyAmount(oldNewMoneyAmount + moneyAmount1);
        service.updateClient(client1);

        TaxiDriver taxiDriver1 = service.readTaxist(Long.parseLong(taxiDriver));

        Order order = new Order(client1, null, taxiDriver1, now,
                moneyAmount1, addressFrom, addressTo);
        service.createOrder(order);

        model.addAttribute("clients", service.findAllClients());
        model.addAttribute("taxiDrivers", service.findAllTaxists());
        return "registerOrder";
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "/orderReport.html", method = {RequestMethod.GET})
    public String orderReport(HttpSession session) {
        if (!isAuth(session))
            return "index";
        return "orderReport";
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "listAllOrders", method = RequestMethod.POST)
    public
    String listAllOrders(Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        model.addAttribute("orders", service.listAllOrders());
        return "orders";
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "listOrdersByPortion", method = RequestMethod.POST)
    public
    String listOrdersByPortion(Model model, HttpSession session) {
        if (!isAuth(session))
            return "index";
        model.addAttribute("orders", service.listAllOrders());
        return "orders";
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "listOrdersByMoney", method = RequestMethod.POST)
    public
    String listOrdersByMoney(@RequestParam String from,
                             @RequestParam String to,
                             Model model,
                             HttpSession session) {
        if (!isAuth(session))
            return "index";
        model.addAttribute("orders", service.listOfOrdersInRangeOfAmount(Long.parseLong(from), Long.parseLong(to)));
        return "orders";
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public
    String auth(@RequestParam String login, @RequestParam String password, Model model, HttpSession session) {
        if (isAuth(session))
            return "dashboard";
        try {
            authenticationService.authenticate(login, password);
            model.addAttribute("loginId", login);
            identifyStyle(session);
            return "dashboard";
        } catch (AuthenticationException exception) {
            if (exception.getMessage().equals(AuthenticationServiceImpl.getUnsuccessfulPasswordExpired())) {
                return "changePassword";
            }
            model.addAttribute("message", exception.getMessage());
            return "index";
        }
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public
    String registerPost(@RequestParam String login,
                        @RequestParam String password,
                        @RequestParam String passwordConfirmation,
                        @RequestParam String individualTaxpayerNumber, Model model, HttpSession session) {
        if (isAuth(session))
            return "dashboard";

        log.info("registerPost controller");
        if (!password.equals(passwordConfirmation)) {
            model.addAttribute("message", "Passwords not equals");
            return "register";
        }
        try {
            authorizationService.register(login, individualTaxpayerNumber, password);
        } catch (AuthorizationException exception) {
            model.addAttribute("message", exception.getMessage());
            return "register";
        } catch (DataIntegrityViolationException exception) {
            model.addAttribute("message", "Login not unique");
            return "register";
        } catch (Exception exception) {
            model.addAttribute("message", "Something bad: " + exception.getMessage());
            return "register";
        }
        model.addAttribute("message", "Registration successful. You can log in now.");
        return "index";
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public
    String changePassword(@RequestParam String login,
                          @RequestParam String password,
                          @RequestParam String passwordConfirmation,
                          Model model,
                          HttpSession session) {

        if (isAuth(session))
            return "dashboard";

        if (!password.equals(passwordConfirmation)) {
            model.addAttribute("message", "Passwords not equals");
            return "changePassword";
        }

        try {
            authorizationService.changePassword(login, password);
            model.addAttribute("message", "Password change successful. You can log in now.");
            return "index";
        } catch (AuthorizationException exception) {
            model.addAttribute("message", exception.getMessage());
            return "changePassword";
        }

    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public
    String register(HttpSession session) {
        if (isAuth(session))
            return "dashboard";
        log.info("/register.html controller");
        return "register";
    }

    @RequestMapping(value = "session.html", method = RequestMethod.GET)
    public   String registerPost(){
            return "session";
    }

    private boolean isAuth(HttpSession session) {
        if (session.getAttribute("loginId") == null) {
            return false;
        }
        return true;
    }

    private void identifyStyle(HttpSession session){
        String oper = (String)session.getAttribute("loginId");
        if (oper.equals("admin")){
            session.setAttribute("style", "style.css");
        }
        else if (oper.equals("bosyi")){
            session.setAttribute("style", "style2.css");
        }
    }

    private void addOperators(){
        Role user = service.readRole("User");
        Role admin = service.readRole("Administrator");
        System.out.println(user);
//        Operator oper1 = new Operator("bosyi", "111", 8765465487662L);
    }
}
