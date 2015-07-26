package web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.domain.Drivers;
import web.domain.Operator;
import web.service.ClientService;
import web.service.DriverService;
import web.service.OperatorService;

import java.util.List;


/**
 * Created by george on 07.07.15.
 */
@Controller
@SessionAttributes("id")
public class DashboardController {
    public static final Logger log = Logger.getLogger(DashboardController.class);

    @Autowired
    private ClientService clientS;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/indexTaxi.html",method = RequestMethod.POST)
    public @ResponseBody String indexTaxi(@RequestParam("login") String login,@RequestParam("pass") String password, @RequestParam("status") String status,
                                          @RequestParam("buton") String butt ){
        log.info("controller");
        List<Operator> operator = operatorService.listOperator();
        String sb = null;
        Operator operator1 = checkOperator(login,password);

        if(status.equals("0")){
            if(operator1.getStatus().equals("0")){
            return "login or password error!|||||";
            }
            return "ok|"+operator1.getLogin()+"|"+operator1.getPassword()+"|"+operator1.getStatus()+"|"
                    +mneuOperator(operator1.getStatus())+"|"+checkSelectedButton(butt);
        }else{
            return "ok|"+operator1.getLogin()+"|"+operator1.getPassword()+"|"+operator1.getStatus()+"|"
                    +mneuOperator(operator1.getStatus())+"|"+checkSelectedButton(butt);
        }
        
        
        
//        return "error";
    }

    private String mneuOperator(String status) {
        if(status.equals("admin")){
            return "<table border=\"0\">" +
                    "<tr>" +
                    "<td><button onclick=\"menuButt('listDrivers')\">List Drivers</button></td>" +
                    "</tr><tr>" +
                    "<td><button onclick=\"menuButt('listOperators')\">List Operators</button></td>" +
                    "<tr>" +
                    "</table>";
    }
        if(status.equals("operator")){
            return "<table border=\"0\">" +
                    "<tr>" +
                    "<td><button onclick=\"menuButt('listDrivers')\">List Drivers</button></td>" +
                    "<tr>" +
                    "</table>";
        }
        return null;
    }

    private Operator checkOperator(String login, String password){
        List<Operator> operator = operatorService.listOperator();
        for(Operator op : operator){
            if(op.getLogin().equals(login)&&op.getPassword().equals(password)){
                return op;
            }
        }
        return new Operator(null,null,null,"0");
    }

    private String stusChec(String stat){
        return "t";
    }

    private String checkSelectedButton(String butt) {
        String sb;
        
        switch (butt){
            case "listDrivers":
                List<Drivers> drivers = driverService.listDrivers();
                sb = "<table border=\"1\"><tr><td>Name</td><td>Phone</td><td>model</td><td>number</td></tr>";
                for (Drivers d : drivers){
                    sb = sb + "<tr><td>"+d.getName()+"</td><td>"+d.getPhone()+"</td><td>"+d.getCarNum()+"</td><td>"+d.getCarNumber()+"</td></tr>";
                }
                sb = sb+"</table>";
                return sb;
            case "listOperators":
                Operator operator;
                List<Operator> operators = operatorService.listOperator();
                sb="<table border=\"1\"><tr><td>ID</td><td>login</td><td>password</td><td>status</td></tr>";
                for(Operator op:operators){
                    sb = sb+"<tr><td>"+op.getId()+"</td><td>"+op.getLogin()+"</td><td>"+op.getPassword()+"</td><td>"+op.getStatus()+"</td></tr>";
                }
                sb=sb+"</table>";
                return sb;
            default:
                sb = "";
        }
        return sb;
    }
    
//    @RequestMapping(value = "/dashboard.html", method = RequestMethod.GET)
//    public String great(@RequestParam("login") String name,@RequestParam("paswwd") String paswd, Model model, HttpSession session) {
//        log.info("/dashboard.html controller");
//        List<Client> client;
//        client = clientS.listClient();
//        for(Client c: client){
//            if(c.getName().equals(name) && c.getPhone().equals(paswd)){
//                try{
//                    model.addAttribute("clientList",clientS.listClient());
//                    return "dashboard";
//                }catch (HibernateException e){
//
//                }
//
//            }
//        }
//        return "clients";
//    }

//    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
//    public @ResponseBody String ajax(Model model){
//        return "Yes";
//    }

}
