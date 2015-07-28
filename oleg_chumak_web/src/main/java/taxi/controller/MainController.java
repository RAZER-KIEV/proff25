package taxi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    private  AuthenticationService authenticationService;
    @Autowired
    private AuthorizationService authorizationService;

    /*
    Autor: Алексей
    точка входа
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String main(HttpSession session) {
//        addOperators();
        if (!isAuth(session))
            return "index";
        return "dashboard";
    }

    /*
    Autor: Aleksey Khalikov
    Dashboard
     */
    @RequestMapping(value = "/dashboard.html", method = {RequestMethod.GET})
    public String resend(HttpSession session) {
        log.info("/dash controller");
        if (!isAuth(session))
            return "index";
        return "dashboard";
    }
    @RequestMapping(value = "/lists.html", method = {RequestMethod.GET})
    public String lists(HttpSession session) {
        log.info("/dash controller");
        if (!isAuth(session))
            return "index";
        return "lists";
    }
    @RequestMapping(value = "/test.html", method = {RequestMethod.GET})
    public String test(HttpSession session) {
        return "test";
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
        model.addAttribute("style", operator.getStyle());
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
        return "lists";
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
            operator.setStyle(prevpass);
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
//            identifyStyle(session);
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

    private void addOperators(){
        Role user =
//                new Role("User", false, true);
                service.readRole("User");
        Role admin =
//                new Role("Administrator", true, true);
                service.readRole("Administrator");
        Operator oper1 = new Operator("bosyi", "111", 8765465487662L);
        oper1.setRole(admin);
        Operator oper2 = new Operator("oleg", "222", 657682313L);
        oper2.setRole(user);
//        service.createRole(user);
//        service.createRole(admin);
        service.createOperator(oper1);
        service.createOperator(oper2);
        Client cl1 = new Client("Anya", "Borisova", "6548886224", "gde-to");
        Client cl2 = new Client("Lena", "Stadnik", "097225354", "TYalta");
        Client cl3 = new Client("Olya", "Novikova", "975222546","Foros");
        service.createClient(cl1);
        service.createClient(cl2);
        service.createClient(cl3);
        TaxiDriver t1 = new TaxiDriver("Vasya", "Gazel'", "22547", "098886543");
        TaxiDriver t2 = new TaxiDriver("Petya", "Oka", "22546K", "063555477");
        TaxiDriver t3 = new TaxiDriver("Kolya", "Kopye", "aa-2333-AK", "0509795542");
        service.createTaxist(t1);
        service.createTaxist(t2);
        service.createTaxist(t3);
    }

    // Bogdan Iavorskyi
    @RequestMapping(value = "auth2", method = RequestMethod.POST)
    public @ResponseBody String auth2(@RequestParam String login, @RequestParam String password,
                                      Model model) {
        try {
            authenticationService.authenticate(login, password);
            model.addAttribute("loginId", login);
            return "1";
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "0";
        }
    }

    @RequestMapping(value = "register2", method = RequestMethod.POST)
    public @ResponseBody String register2(@RequestParam String login, @RequestParam String password,
                                          @RequestParam String itn,
                                      Model model) {
        System.out.println("in Register 2");
        try {
            authorizationService.register(login, itn, password);
            System.out.println("no exception");
            return "1";
        } catch (Exception exception) {
            System.out.println("exception");
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            return "0";
        }
    }

    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public @ResponseBody String checkLogin(@RequestParam String login) {
        System.out.println("inCheckLogin");
        return authenticationService.isLoginUnique(login) ? "1" : "0";
    }


    @RequestMapping(value = "/ajaxDrivers", method = RequestMethod.POST)
    public
    @ResponseBody
    String ajaxDrivers(Model model) {
        List<TaxiDriver> taxiDrivers = service.findAllTaxists();
        if (taxiDrivers == null){
            return "Table of drivers is empty";

        }
        else {
            String drivResult = taxiDrivers.toString();
            String result = "Table of taxi-drivers, Driver's name | Car model | Car number | Driver phone," + drivResult;
            result = result.replace(']', ' ').replace('[', ' ').trim();
            return result;
        }
    }



    @RequestMapping(value = "/ajaxOrders", method = RequestMethod.POST)
    public
    @ResponseBody
    String ajaxOrders(Model model) {
        System.out.println("in");
        List<Order> orders = (List<Order>)service.listAllOrders();
        System.out.println("medium");
        try{
        System.out.println(orders);
        } catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("after");
        if (orders == null){
            return "Table of orders is empty";
        }
        else {
            System.out.println("not empty");
            String orderResult = orders.toString();
            System.out.println(orderResult);
            String result = "Table of orders, Operator | Driver's name | Order Date | Amount in cents | Start point | Point of destination," + orderResult;
            result = result.replace(']', ' ').replace('[', ' ').trim();
            System.out.println(result);
            return result;
        }
    }



    @RequestMapping(value = "/ajaxOrdersPortioned", method = RequestMethod.POST)
    public
    @ResponseBody
    String ajaxOrdersPortioned(@RequestParam("numberOfPortion") String numberOfPortion, Model model) {
        List<Order> orders = service.listOfOrdersChunk(Integer.valueOf(numberOfPortion), 5);
        if (orders == null){
            return "portion of orders № "+numberOfPortion+" is empty";
        }
        else {
            String orderResult = orders.toString();
            String result = "portion of orders № "+numberOfPortion+" , Operator | Driver's name | Order Date | Amount in cents | Start point | Point of destination," + orderResult;
            result = result.replace(']', ' ').replace('[', ' ').trim();
            return result;
        }
    }



    @RequestMapping(value = "/ajaxAmount", method = RequestMethod.POST)
    public
    @ResponseBody
    String ajaxAmount(@RequestParam("amountFrom") String amountFrom, @RequestParam("amountTo") String amountTo, Model model) {
        List<Order> orders = service.listOfOrdersInRangeOfAmount(Long.valueOf(amountFrom), Long.valueOf(amountTo));
        if (orders == null){
            return "There are no orders with amount between "+amountFrom+ " and "+amountTo;
        }
        else {
            String orderResult = orders.toString();
            String result = "orders with amount between "+amountFrom+ " and "+amountTo+ ", Operator | Driver's name | Order Date | Amount in cents | Start point | Point of destination," + orderResult;
            result = result.replace(']', ' ').replace('[', ' ').trim();
            return result;
        }
    }



    @RequestMapping(value = "/ajaxClients", method = RequestMethod.POST)
    public
    @ResponseBody
    String ajaxClients(Model model) {
        List<Client> clients = service.findAllClients();
        if (clients == null){
            return "Table of clients is empty";
        }
        else {
            String clientResult = clients.toString();
            String result = "Clients,Name | Surname | Phone number | Address | Total money spent | Date of last change," + clientResult;
            result = result.replace(']', ' ').replace('[', ' ').trim();
            return result;
        }
    }


    @RequestMapping(value = "/newajax", method = RequestMethod.GET)
    public
    @ResponseBody
    String newajax(Model model) {
        List<TaxiDriver> taxists = service.findAllTaxists();
        if (taxists == null){
            return "Table of clients is empty";
        }
        else {
            String result = new String();
            for(TaxiDriver tax : taxists){
                result = result + tax.getName()+",";
            }
            System.out.println(result);
            return result;
        }
    }



    @RequestMapping(value = "/ajaxClientsPortioned", method = RequestMethod.POST)
    public
    @ResponseBody
    String ajaxClientsPortioned(@RequestParam("numberOfPortion") String numberOfPortion, Model model) {
        List<Client> clients = service.clientsPortinedByTen(Long.valueOf(numberOfPortion));
        if (clients == null){
            return "portion of clients № "+numberOfPortion+" is empty";
        }
        else {
            String clientResult = clients.toString();
            String result = "Portion № "+numberOfPortion+"of clients , Name | Surname | Phone number | Address | Total money spent | Date of last change," + clientResult;
            result = result.replace(']', ' ').replace('[', ' ').trim();
            return result;
        }
    }



    @RequestMapping(value = "/ajaxClientsMonth", method = RequestMethod.POST)
    public
    @ResponseBody
    String ajaxClientsMonth(Model model) {
        List<Client> clients = service.clientsMadeOrdersDuringLastMonth();
        if (clients == null){
            return "There were no clients making orders during last month";
        }
        else {
            String clientResult = clients.toString();
            String result = "Clients made orders last month, Name | Surname | Phone number | Address | Total money spent | Date of last change," + clientResult;
            result = result.replace(']', ' ').replace('[', ' ').trim();
            return result;
        }
    }



    @RequestMapping(value = "/ajaxClientsAmount", method = RequestMethod.POST)
    public
    @ResponseBody
    String ajaxClientsAmount(@RequestParam("amount") String amount, Model model) {
        List<Client> clients = service.clientswithOrderAmountMoreThen(Long.valueOf(amount));
        if (clients == null){
            return "There were no clients made orders with amount  more "+amount+ " cents ";
        }
        else {
            String clientResult = clients.toString();
            String result = "CLients made orders in amount more then "+amount+", Name | Surname | Phone number | Address | Total money spent | Date of last change," + clientResult;
            result = result.replace(']', ' ').replace('[', ' ').trim();
            return result;
        }
    }
}
