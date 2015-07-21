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
import java.util.List;

/**
 * Created by ПК on 11.07.2015.
 */

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {


   private Integer maxWrongPasses=5;

   @Autowired
   private OperatorDao operatorDao;

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {

        Operator opr = operatorDao.searchByLogin(login);
        if (!opr.getIsBlocked() & opr.getPassword().equals(pass)) {
            return true;
        } else {
            opr.setWrongPass(opr.getWrongPass() + 1);
            if(opr.getWrongPass()>= maxWrongPasses) {
                opr.setIsBlocked(true);
                operatorDao.update(opr);
            }
            return false;
        }
    }
    @Override
    public Long create(Operator operator) {
        return operatorDao.create(operator);
    }

    @Override
    public Operator read(Long id) {
        return operatorDao.read(id);
    }

    @Override
    public boolean update(Operator operator) {
        return operatorDao.update(operator);
    }

    @Override
    public boolean delete(Operator operator) {
        return operatorDao.delete(operator);
    }

    @Override
    public Operator searchByLogin(String login) {
        return operatorDao.searchByLogin(login);
    }

    @Override
    public List findAll() {
        return operatorDao.findAll();
    }


}
