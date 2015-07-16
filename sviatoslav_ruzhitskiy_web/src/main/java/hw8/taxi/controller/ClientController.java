package hw8.taxi.controller;

import hw8.taxi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;
import java.util.Locale;
import org.apache.log4j.Logger;

/**
 * Created by ПК on 15.07.2015.
 */
@Controller
@SessionAttributes("id")
public class ClientController {

    public static final Logger log = Logger.getLogger(ClientController.class);

    @Autowired
    private ClientService authenticationService;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    ClientController() {
    }
























   /* @RequestMapping(value = "/createClientsBD", method = RequestMethod.POST)
    public String */


}
