package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ПК on 14.07.2015.
 */
@Service
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService{

    @Autowired
    OperatorDao operatorDao;


    @Override
    public boolean register(String login, String inn, String pass) throws  AuthorizationException {
        boolean regDataValid=false;
        String confirm = pass;
        regDataValid = analizeRegData(login, inn, pass, confirm);
        if(regDataValid) {
            if (operatorDao.searchByLogin(login) == (null)) {
                Operator opr = new Operator(login, pass, inn);
                operatorDao.create(opr);
                return true;
            }
        }
        return false;
    }
    private boolean analizeRegData(String login, String inn, String pass, String confirm) throws AuthorizationException {
        boolean passIsValid = false;
        boolean passContainsLowerCase = false;
        boolean passContainsUpperCase = false;
        boolean passContainsDigit = false;
        if ((login.length() < 4)) {
            throw new AuthorizationException("Login too short!");
        }else if (login.contains(" ")) {
            throw new AuthorizationException("Login contains space!");
        }else if (!(pass.equals(confirm))) {
            throw new AuthorizationException("Password not equals with confirm!");
        }else if(inn.length()<10) {
            throw new AuthorizationException("INN too short!");
        }else {
            for(int j=0; j<inn.length();j++){
                if(!(Character.isDigit(inn.charAt(j)))){
                    throw new AuthorizationException("INN contains not only digits!");
                }
            }
        }
        if ((pass.length() < 8)) {
                    throw new AuthorizationException("Password too short");
        }else {
            for (int i = 0; i < pass.length(); i++) {
                if (Character.isDigit(pass.charAt(i))) {
                    passContainsDigit = true;
                }
                if (Character.isUpperCase(pass.charAt(i))) {
                    passContainsUpperCase = true;
                }
                if (Character.isLowerCase(pass.charAt(i))) {
                    passContainsLowerCase = true;
                }
                if (passContainsLowerCase & passContainsUpperCase & passContainsDigit) {
                    passIsValid = true;
                    break;
                }
            }
        } if (!passIsValid) {
            throw new AuthorizationException("Password is invalid!");
        } else if (!(operatorDao.searchByLogin(login) == (null))) {
            throw new AuthorizationException("User is already exist");
        } else {
            return true;
        }
    }
}




