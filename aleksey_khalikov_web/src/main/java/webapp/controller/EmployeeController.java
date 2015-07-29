package main.java.webapp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import webapp.domain.Employee;
import webapp.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
public class EmployeeController {
    public static final Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees.html", method = RequestMethod.GET)
    public String hello(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @RequestMapping(value = "/success.html", method = RequestMethod.GET)
    public String success(Model model) {
        log.info("/success.html controller");
        return "dashboard";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Employee> employee(Model model) {
        log.info("/employee controller");
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("John", "Lover"));
        return list;
    }
}
