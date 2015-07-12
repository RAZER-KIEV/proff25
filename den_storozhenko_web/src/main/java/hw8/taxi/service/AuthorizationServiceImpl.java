package hw8.taxi.service;

import hw8.taxi.IsValid;
import hw8.taxi.dao.OperatorDao;
import hw8.taxi.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by storo_000 on 09.07.2015.
 */
@Service
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private OperatorDao operatorDao;

    public AuthorizationServiceImpl() {
    }

    public AuthorizationServiceImpl(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }


    @Override
    public boolean register(String login, String pass, String id) throws AuthorizationException {
        return false;//for jon
    }

    @Override
    public boolean register(String login, String pass, String confirmPass, String id) throws AuthorizationException {
        String error = "";
        if (!IsValid.isValidLogin(login)){
            error+="Login must be at least 4 characters, must not contain spaces.<br>";
            //throw  new AuthorizationException();
        }
        if (!pass.equals(confirmPass)){
            error+="Passwords do not match.<br>";
            //throw  new AuthorizationException("Passwords do not match.");
        }
        if (!IsValid.isValidPassword(pass)){
            error+="Password must be at least 8 characters, include upper and lowercase letters, numbers.<br>";
            //throw new AuthorizationException("Password must be at least 8 characters, include upper and lowercase letters, numbers.");
        }
        if (!IsValid.isValidId(id)){
            error+="Id was going to consist of 10 digits, must not contain letters and other characters.<br>";
            //throw  new AuthorizationException("Id was going to consist of 10 digits, must not contain letters and other characters.");
        }
        if (!error.isEmpty()){
            throw new AuthorizationException(error);
        }
        return operatorDao.register(login,pass,id);
    }
}
