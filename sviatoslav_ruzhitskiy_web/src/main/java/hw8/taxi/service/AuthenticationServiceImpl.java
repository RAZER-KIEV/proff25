package hw8.taxi.service;

import hw8.taxi.controller.AuthenticationController;
import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServlet;

/**
 * Created by ПК on 11.07.2015.
 */

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
   // @Autowired
   // AuthenticationController authenticationController;
   @Autowired
   private OperatorDao operatorDao;

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {

        Operator opr = operatorDao.searchByLogin(login);
        if (!opr.getIsBlocked() & opr.getPassword().equals(pass)) {
            return true;
        }else
            return false;
    }

}
