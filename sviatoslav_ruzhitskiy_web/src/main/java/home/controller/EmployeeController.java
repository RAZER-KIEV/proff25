package home.controller;

import home.domain.Employee;
import home.domain.MyEvent;
import home.service.AuthenticationService;
import home.service.EmployeeService;
import home.service.NetworkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static home.controller.AuthenticationController.gson;

/**
 * Created by ПК on 05.12.2015.
 */

@Controller
@SessionAttributes("id")
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    AuthenticationService authenticationService;
    private Long uId;

    @Autowired
    NetworkService networkService;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @RequestMapping(value = "/addEmpl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String addEmpl(@RequestParam("login") String login, @RequestParam("password") String password, HttpSession httpSession)  {
        Long newEmployeeId;
        uId= (Long) httpSession.getAttribute("NMQCUID");
        try {
            if (authenticationService.authenticate(login, password)) {
                log.debug("User already exist");
                return "User already exist";
            } else {
                Employee newEmpl = new Employee(login, password);
                if(uId!=null){
                    Long myNetworkId = networkService.read(employeeService.read(uId).getNetworkId()).getNetworkId();
                    newEmpl.setNetworkId(myNetworkId);
                }
                newEmployeeId = employeeService.create(newEmpl);
            }
        } catch (Exception e) {
            log.debug("Something wrong Admin not found");
            e.printStackTrace();
            return "Catch.Auth_Error";
        }
        return newEmployeeId.toString();
    }

    @RequestMapping(value = "/getEmpl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String getEmpl(@RequestParam("id") String id, HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        Long idL = Long.valueOf(id);

        Employee employee = employeeService.read(idL);
        String gsonEmpl = gson.toJson(employee);
        return gsonEmpl;
    }


    @RequestMapping(value = "/updateEmpl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String updateEmpl(@RequestParam("employee") String adminGson, HttpSession httpSession) {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        Employee employee = gson.fromJson(adminGson, Employee.class);
        employee.setLastOnline(new Date());
        log.info("eployee = "+employee);
        return "updated: "+employeeService.update(employee);
    }

    @RequestMapping(value = "/updateLocation", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String updateLocation(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude, HttpSession httpSession) {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        Employee employee = employeeService.read(uId);
        employee.setLastOnline(new Date());
        employee.setLastLat(Double.valueOf(latitude));
        employee.setLastLong(Double.valueOf(longitude));
        if(employeeService.update(employee))
            return gson.toJson(employeeService.read(uId));
        else return "updated: false!";
    }


    @RequestMapping(value = "/deleteEmpl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String deleteEmpl(@RequestParam("emlpId") String emlpId, HttpSession httpSession) {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        Employee empl = employeeService.read(Long.parseLong(emlpId));
        return "deleted: "+employeeService.delete(empl);
    }

    @RequestMapping(value = "/getAll", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String getAll(HttpSession httpSession) {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        List<Employee> emplList = employeeService.findAllwithNetwork(employeeService.read(uId).getNetworkId());
        return gson.toJson(emplList);
    }

    @RequestMapping(value = "/getAdmins", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String getAdmins( HttpSession httpSession) {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        List<Employee> emplList = employeeService.findAll();
        return gson.toJson(emplList);
    }


}
