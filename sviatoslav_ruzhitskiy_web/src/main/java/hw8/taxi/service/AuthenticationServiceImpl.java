package hw8.taxi.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServlet;

/**
 * Created by ПК on 11.07.2015.
 */

@Controller
@SessionAttributes("id")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {



        return false;
    }
}
