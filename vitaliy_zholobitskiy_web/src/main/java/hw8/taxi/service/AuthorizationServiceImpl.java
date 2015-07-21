package hw8.taxi.service;

import hw8.taxi.additional.RegistrationDataChecker;
import hw8.taxi.dao.OperatorDao;
import hw8.taxi.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by just1ce on 15.07.2015.
 */
@Service
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    OperatorDao operatorDao;

    public AuthorizationServiceImpl() {
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public boolean register(String login, String id, String pass, String confirm) throws AuthorizationException {
        RegistrationDataChecker registrationDataChecker = new RegistrationDataChecker();
        if(!registrationDataChecker.isValid(login,pass,confirm))
            throw new AuthorizationException();
        if(!operatorDao.register(login,pass,new Date())){
            throw new AuthorizationException();
        }
        return true;
    }
    @Override
    public Long getIdByLogin(String login) {
        return operatorDao.getByLogin(login);
    }
}
