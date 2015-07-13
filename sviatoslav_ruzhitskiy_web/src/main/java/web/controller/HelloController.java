package web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
@SessionAttributes("id")
public class HelloController extends HttpServlet{
    String superAdmin="RAZER";
    String superPass="RAZERPASS";

    //@Autowired
   // private  notebookService;
    public static final Logger log = Logger.getLogger(HelloController.class);
    private String name;

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public String hello(Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "Petro");

        return "index";
    }




    @RequestMapping(value = "/great.html", method = RequestMethod.GET)
    public String great(@RequestParam("login") String name, Model model, HttpSession session) {
        log.info("/great.html controller");
        Long sessId = (Long) session.getAttribute("id");
        if (sessId == null) {
            return "index"+name;
        }

        return "index";
    }

    @RequestMapping(value = "/form.html", method = RequestMethod.POST)
    @ResponseBody
    public String form(@RequestParam String login,
                @RequestParam String pass) {
        return login + "[" + pass + "]";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        model.addAttribute("name", "al1");
        return "index";
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login=request.getParameter("login");
        String pass = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if(superAdmin.equals(login)&superPass.equals(pass)){
            response.setStatus(HttpServletResponse.SC_OK);
            out.write("HELLO SUPERADMIN!!! YOU WELCOME!!!");
        }
        else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.write("Sorry but You not registered....");
        }
        out.flush();
        out.close();
    }

}
