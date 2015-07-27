package web.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.domain.Client;
import web.domain.Drivers;
import web.domain.Operator;
//import web.domain.Order;
import web.domain.Orders;
import web.service.ClientService;
import web.service.DriverService;
import web.service.OperatorService;
import web.service.OrdersService;

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

    @Autowired
    private OrdersService orderS;

    @RequestMapping(value = "/indexTaxi.html",method = RequestMethod.POST)
    public @ResponseBody
    String indexTaxi(@RequestParam("login") String login,@RequestParam("pass") String password, @RequestParam("status") String status,
                                          @RequestParam("buton") String butt ){
        log.info("controller");
        List<Operator> operator = operatorService.listOperator();
        String sb = null;
        Operator operator1 = checkOperator(login,password);

        if(status.equals("0")){
            if(operator1.getStatus().equals("0")){
            return "login or password error!|||||";
            }
//            return "ok|"+operator1.getLogin()+"|"+operator1.getPassword()+"|"+operator1.getStatus()+"|"
//                    +mneuOperator(operator1.getStatus())+"|"+checkSelectedButton(butt);
            return "ok|"+operator1.getLogin()+"|"+operator1.getPassword()+"|"+operator1.getStatus()+"|"
                    +mneuOperator(operator1.getStatus())+"| Welcom "+operator1.getStatus()+" "+ operator1.getLogin();
        }else{
            return "ok|"+operator1.getLogin()+"|"+operator1.getPassword()+"|"+operator1.getStatus()+"|"
                    +mneuOperator(operator1.getStatus())+"|"+checkSelectedButton(butt);
        }
    }

    private String mneuOperator(String status) {
        if(status.equals("admin")){
            return "<table border=\"0\">" +
                    "<tr><td><button class=\"button4\" onclick=\"menuButt('listDrivers')\">List Drivers</button></td></tr>" +
                    "<tr><td><button class=\"button4\" onclick=\"menuButt('listOperators')\">List Operators</button></td></tr>" +
                    "<tr><td><button class=\"button4\" onclick=\"menuButt('listClient')\">List Clients</button></td></tr>" +
                    "<tr><td><button class=\"button4\" onclick=\"menuButt('listOrders')\">List Orders</button></td></tr>" +
                    "</table>";
    }
        if(status.equals("operator")){
            return "<table border=\"0\">" +
                    "<tr><td><button class=\"button4\" onclick=\"menuButt('listDrivers')\">List Drivers</button></td></tr>" +
                    "<tr><td><button class=\"button4\" onclick=\"menuButt('listClient')\">List Clients</button></td></tr>" +
                    "<tr><td><button class=\"button4\" onclick=\"menuButt('listOrders')\">List Orders</button></td></tr>" +
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
                sb = "<table border=\"1\"><tr><td colspan=\"4\">Drivers</td></tr>" +
                        "<tr><td>Name</td><td>Phone</td><td>model</td><td>number</td></tr>";
                for (Drivers d : drivers){
                    sb = sb + "<tr><td>"+d.getName() + "</td><td>"+d.getPhone()+"</td><td>"+d.getCarModels()+"</td><td>"+d.getCarNumber()+"</td></tr>";
                }
                sb = sb+"</table>";
                return sb;
            case "listOperators":
                Operator operator;
                List<Operator> operators = operatorService.listOperator();
                sb="<table border=\"1\"><tr><td colspan=\"4\">Operators</td></tr>" +
                        "<tr><td>ID</td><td>login</td><td>password</td><td>status</td></tr>";
                for(Operator op:operators){
                    sb = sb+"<tr><td>"+op.getId()+"</td><td>"+op.getLogin()+"</td><td>"+op.getPassword()+"</td><td>"+op.getStatus()+"</td></tr>";
                }
                sb=sb+"</table>";
                return sb;
            case "listClient":
                List<Client> clients = clientS.listClient();
                sb = "<table border=\"1\"><tr><td colspan=\"3\">Clients</td></tr>" +
                        "<tr><td>ID</td><td>Name</td><td>phone</td></tr>";
                for (Client d : clients){
                    sb = sb + "<tr><td>"+d.getId()+"</td><td>"+d.getName()+"</td><td>"+d.getPhone()+"</td></tr>";
                }
                sb = sb+"</table>";
                return sb;
            case "listOrders":
                List<Orders> orders = orderS.listOrder();
                sb = "<table border=\"1\"><tr><td colspan=\"3\">Orders</td></tr>" +
                        "<tr><td>ID</td><td>from</td><td>to</td><td>Price</td></tr>";
                for (Orders d : orders){
                    sb = sb + "<tr><td>"+d.getId()+"</td><td>"+d.getMoveFrom()+"</td><td>"+d.getMoveTo()+"</td>" +
                            "<td>"+d.getPrice()+"</td></tr>";
                }
                sb = sb+"</table>";
                return sb;
            case "addClient":

                return sb = "";
            case "addOperator":
                return sb = "";
            case "removeOperator":
                return sb = "";
            case "removeClient":
                return sb = "";
            case "addDriver":
                return sb = "";
            case "removeDriver":
                return sb = "";
            case "createOrder":
                return sb = "";
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
