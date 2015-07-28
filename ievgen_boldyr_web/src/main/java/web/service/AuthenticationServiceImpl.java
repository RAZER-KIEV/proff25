package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.OperatorDao;
import web.domain.Operator;
import web.exception.AuthenticationException;

/**
 * Created by george on 13.07.15.
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    OperatorDao operatorDao;

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        Operator operator = operatorDao.findOperatorByName(login);
        if (operator != null && operator.getPassword().equals(pass)) {
            return true;
        } else {
            throw new AuthenticationException();
        }
    }
}
