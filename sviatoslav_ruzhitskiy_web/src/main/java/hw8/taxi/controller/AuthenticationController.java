package hw8.taxi.controller;

import hw8.taxi.domain.Operator;
import hw8.taxi.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.annotation.PostConstruct;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by ПК on 11.07.2015.
 */

@Controller
@SessionAttributes("id")
public class AuthenticationController {

    public static final Logger log = Logger.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @PostConstruct
    public void init(){
        Locale.setDefault(Locale.ENGLISH);
    }

    AuthenticationController(){}


    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String great(){
        log.info("/index controller");
        return "index";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(@RequestParam("login") String login,@RequestParam("password")String password, Model model, HttpSession session) throws AuthenticationException {
        authenticationService.authenticate(login, password);

        return "index";
    }










   /* public static final Logger log = Logger.getLogger(AuthenticationController.class);

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
        if(request.getParameter("enter")!=null){
        if(superAdmin.equals(login)&superPass.equals(pass)){
            this.forvard("/WEB-INF/jsps/dashboard.jsp", request,response);
            /*response.setStatus(HttpServletResponse.SC_OK);
            out.write("HELLO SUPERADMIN!!! YOU WELCOME!!!");
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
            forvard("/WEB-INF/jsps/index.jsp", request, response);

        }
        out.flush();
        out.close();
        }else if(request.getParameter("register")!=null){
            this.forvard("/WEB-INF/jsps/dashboard.jsp", request,response);
        }

    }

    public void forvard (String torget, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(torget);
        dispatcher.forward(request,response);

    }

*/
}