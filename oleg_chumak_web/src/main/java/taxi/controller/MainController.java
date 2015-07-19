package taxi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import taxi.domain.Client;
import taxi.domain.Operator;
import taxi.domain.TaxiDriver;
import taxi.service.TService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */

@org.springframework.stereotype.Controller
@SessionAttributes("id")
public class MainController {
    private static final Logger log = Logger.getLogger(MainController.class);
    @Autowired
    private TService service;

    /*
    Autor: Алексей
    для теста Дешбоарда
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String main() {
        return "dashboard";
    }

    /*
    Autor: Aleksey Khalikov
    Dashboard
     */
    @RequestMapping(value = "/dash.html", method = {RequestMethod.GET})
    public String resend() {
        log.info("/dash controller");
        return "dashboard";
    }

    /*
    Autor: Aleksey Khalikov
    Загружает титульную строку в Dashboard
    */
    @RequestMapping(value = "/title.html", method = {RequestMethod.GET})
    public String getTitlePage() {
        return "title";
    }

    /*
    Autor: Aleksey Khalikov
    Загружает страницу меню в Dashboard
     */
    @RequestMapping(value = "/menu.html", method = {RequestMethod.GET})
    public String getMenuPage() {
        return "menu";
    }

    /*
    Autor: Aleksey Khalikov
    Загружает страницу приветствия в Dashboard
    */
    @RequestMapping(value = "/main.html", method = {RequestMethod.GET})
    public String getWelcomePage() {
        return "welcome";
    }

    /*
    Autor: Aleksey Khalikov
    загружает страницу отчетов по клиентам
    */
    @RequestMapping(value = "/clientReport.html", method = {RequestMethod.GET})
    public String getClientReportPage() {
        return "clientReport";
    }

    /*
        Autor: Aleksey Khalikov
    Загружает страницу со списком клиентов списком по 10
     */
    @RequestMapping(value = "/clientsPortinedByTen.html", method = {RequestMethod.GET})
    public String showClients(Model model){
        List<Client> list = service.clientsPortinedByTen(new Long(10));
        log.info("/clients controller");
        model.addAttribute("clientList", list);
        return "clients";
    }

    /*
        Autor: Aleksey Khalikov
    Загружает страницу со списком клиентов делавших заказы за последний месяц
     */
    @RequestMapping(value = "/ClientsMadeOrdersDuringLastMonth.html", method = {RequestMethod.GET})
    public String showClientsMadeOrdersDuringLastMonth(Model model){
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
    public String showClientswithOrderAmountMoreThen(@RequestParam("value") Long value, Model model){
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
    public String showDrivers(Model model) {
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
    public String re() {
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
     @RequestParam("number") String carNumber, @RequestParam("phone") String phone, Model model) {
        service.createTaxist(new TaxiDriver(name, carModel, carNumber, phone));
        log.info("/newDriver controller");
        model.addAttribute("driversList", service.findAllTaxists());
        return "drivers";
    }

    /* Autor: Alexandr Omelchenko
     Driver List
     */
    @RequestMapping(value = "/operators.html", method = {RequestMethod.GET})
    public String showOperators(Model model) {
        List<Operator> list = service.findAllOperators();
        log.info("/operators controller");
        model.addAttribute("operatorsList", list);
        return "operators";
    }

    @RequestMapping(value = "/readOperator.html", method = {RequestMethod.GET})
    public String readOperator
            (@RequestParam("operator") String operName, Model model) {
        Operator operator = service.readOperator(operName);
        if (operator == null) {
            return "dashboard";
        }
        log.info("/readOperator controller");
        model.addAttribute("operator", operator);
        return "redactorOperator";
    }

}
