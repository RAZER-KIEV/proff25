package hw8.taxi.service;

import comandWork.dao.TaxiDao;
import comandWork.dao.UserDao;
import comandWork.domain.Taxi;
import comandWork.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    //@Autowired
    private TaxiDao taxiDao;

    //@Autowired
    private UserDao userDao;

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
       // User user = userDao.readByName(login);
        //if()



        return false;
    }
}
