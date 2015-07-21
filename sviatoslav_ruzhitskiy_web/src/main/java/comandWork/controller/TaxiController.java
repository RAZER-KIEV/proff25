package comandWork.controller;

import comandWork.domain.Taxi;
import comandWork.service.TaxiService;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Locale;

/**
 * Created by Роман on 14.07.2015.
 */
@Controller
@SessionAttributes("id")
public class TaxiController {
    @Autowired
private TaxiService service;

        public static final Logger log = Logger.getLogger(TaxiController.class);

        @RequestMapping(value = "/dashboard.html", method = RequestMethod.POST)
        public String dashboard(@RequestParam("login") String login,
                                @RequestParam("password") String pass, Model model) {

            log.info("/dashboard.html controller");
            Locale.setDefault(Locale.ENGLISH);

//            ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/context.xml");
//            TaxiService service = context.getBean("service", TaxiService.class);

            if (service.authenticate(login, pass)) {
                model.addAttribute("name", login);
                model.addAttribute("list", service.findAll());
                return "dashboardCommand";

            }
            return "index";
        }


    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        return "index";
    }

}
