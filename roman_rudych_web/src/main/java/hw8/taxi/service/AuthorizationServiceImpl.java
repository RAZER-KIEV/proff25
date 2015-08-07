package hw8.taxi.service;

import hw8.taxi.dao.UserDao;
import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Роман on 13.07.2015.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired(required = true)
    UserDao userDao;

    @Transactional
    @Override
    public boolean register(String login, String id, String pass, String confirm) throws AuthorizationException {
        if(!pass.equals(confirm)) {
            throw new AuthorizationException("confirmation of password failed");

        } else if (userDao.isExistingSpecId(id)){
            throw new AuthorizationException("ID already exists");

        } else if(userDao.isExistingName(login)) {
            throw new AuthorizationException("login already exists");

        } else if(!CheckStrings.loginCheck(login)) {
            throw new AuthorizationException("Login must be at least 4 symbols and does not exist empty symbols");

        } else if(!CheckStrings.idCheck(id)) {
            throw new AuthorizationException("ID must be at least 10 numbers without letters and other symbols");

        } else if(!CheckStrings.passCheck(pass)) {
            throw new AuthorizationException("password must be at least 8 characters, " +
                    "includes upper and lowercase letters ans numbers");
        }
        Long test;
        if((test = userDao.create(new User(id, login, pass)))>0) {
            System.out.println(test);
            return true;
        }
        return false;
    }

    @Transactional
    public Long addUser(User user) {
        return userDao.create(user);
    }
}
