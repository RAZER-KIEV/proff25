package web.controller;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import web.domain.Client;
import web.domain.Operator;
import web.service.OperatorService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by george on 16.07.15.
 */
@Controller
@SessionAttributes("id")
public class OperatorControler {
    public static final Logger log = Logger.getLogger(OperatorControler.class);

    @Autowired
    private OperatorService serviceO;

//    @RequestMapping(value = "/dashboard.html", method = RequestMethod.GET)
//    public String great(@RequestParam("login") String name,@RequestParam("paswwd") String paswd, Model model, HttpSession session) {
//        log.info("/dashboard.html controller");
//
//        List<Operator> client;
//
//        client = serviceO.listOperator();
//        for(Operator c: client){
//            if(c.getLogin().equals(name) && c.getPassword().equals(paswd)){
//                try{
//                    model.addAttribute("operatorList",serviceO.listOperator());
//                    return "dashboard";
//                }catch (HibernateException e){
//
//                }
//
//            }
//        }
//        return "clients";
//    }

}
