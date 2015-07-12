package hw8.taxi.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ПК on 11.07.2015.
 */

@Controller
@SessionAttributes("id")
public class AuthenticationController extends HttpServlet{
    String superAdmin="R";
    String superPass="1";

    public static final Logger log = Logger.getLogger(AuthenticationController.class);

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index AuthenticationController");
        return "index";
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
            String login=request.getParameter("login");
            String pass = request.getParameter("password");
            PrintWriter out = response.getWriter();
        if(superAdmin.equals(login)&superPass.equals(pass)){
            forvard("/dashboard.jsp",request,response);
            /*response.setStatus(HttpServletResponse.SC_OK);
            out.write("HELLO SUPERADMIN!!! YOU WELCOME!!!");*/
        }
        else {

           response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.write("Sorry but You not registered....");
            out.flush();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            forvard("/index.jsp", request, response);
        }
        out.flush();
        out.close();
    }
    public void forvard (String torget, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(torget);
        dispatcher.forward(request,response);

    }


}