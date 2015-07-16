package hw8.taxi.service;

import hw8.taxi.additional.RegistrationDataChecker;
import hw8.taxi.dao.OperatorDao;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * Created by just1ce on 11.07.2015.
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    OperatorDao operatorDao;
    public AuthenticationServiceImpl() {
    }
    public AuthenticationServiceImpl(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;

    }
    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }



    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
       return operatorDao.authenticate(login,pass);

    }

    @Override
    public Long getIdByLogin(String login) {
        return operatorDao.getByLogin(login);
    }


}
