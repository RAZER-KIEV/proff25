package hw8.taxi.service;

import hw8.taxi.IsValid;
import hw8.taxi.Properties;
import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * Created by storo_000 on 09.07.2015.
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    private OperatorDao operatorDao;
    @Autowired
    private Properties properties;

    public AuthenticationServiceImpl() {
    }

    public AuthenticationServiceImpl(OperatorDao operatorDao, Properties properties) {
        this.operatorDao = operatorDao;
        this.properties = properties;
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Long createOperator(Operator operator) {
        return operatorDao.create(operator);
    }

    @Override
    public Operator readByLogin(String login) {
        return operatorDao.getByLogin(login);
    }

    @Override
    public Long readByLoginPass(String login, String pass) {
        return operatorDao.getLoginPass(login,pass);
    }

    @Override
    public Operator getOperator(Long id) {
        return operatorDao.read(id);
    }



    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException{
        Operator operator = operatorDao.getByLogin(login);
        if (operator==null){
            throw  new AuthenticationException("Operator with login \""+login+"\" does not exist.");
        }
        if (operator.getIsBlocked()){
            throw new AuthenticationException("Operator \""+login+"\" is blocked.");
        }
        if ((new Date().getTime()-operator.getPassDate().getTime())>=properties.getTimeOfAction()*3600000){ //время действия
            throw new AuthenticationException("Time of action password for user \""+ login+"\" expires. Follow <a onclick=\"changePassword()\" >link</a> to change password.");
        }
        if (!operator.getPassword().equals(pass)){ //количество попыток
            Integer attemps = operator.getCountWrongPass();
            attemps++;
            operator.setCountWrongPass(attemps);
            if (Objects.equals(attemps, properties.getCountAttempts())){
                operator.setIsBlocked(true);
            }
            operatorDao.update(operator);
            throw new AuthenticationException("Password is incorrect.");
        }
        return operatorDao.authenticate(login,pass);
    }

    @Override
    public boolean changePassword(String login, String password, String newpass, String confirm) throws AuthenticationException{
        Operator operator = operatorDao.getByLogin(login);
        if (operator==null){
            throw  new AuthenticationException("Operator with login \""+login+"\" does not exist.");
        }
        if (operator.getIsBlocked()){
            throw new AuthenticationException("Operator \""+login+"\" is blocked.");
        }
        if (!operator.getPassword().equals(password)){ //количество попыток
            Integer attemps = operator.getCountWrongPass();
            attemps++;
            operator.setCountWrongPass(attemps);
            if (Objects.equals(attemps, properties.getCountAttempts())){
                operator.setIsBlocked(true);
            }
            operatorDao.update(operator);
            throw new AuthenticationException("Old password is incorrect.");
        }
        if (!newpass.equals(confirm)){
            throw  new AuthenticationException("New password and confirm does not match.");
        }
        if (password.equals(newpass)){
            throw new AuthenticationException("The old and the new password must be different.");
        }
        if (!IsValid.isValidPassword(newpass)){
            throw new AuthenticationException("Password must be at least 8 characters, include upper and lowercase letters, numbers.");
        }
        operator.setPassword(newpass);
        operator.setCountWrongPass(0);
        operator.setPassDate(new Date());
        operatorDao.update(operator);
        return true;
    }
}
//href="/changepassword?login="+login+""