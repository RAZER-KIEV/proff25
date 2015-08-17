package hw8.taxi.service;

import hw8.taxi.dao.UserDao;
import hw8.taxi.dao.UserDaoImpl;
import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Роман on 11.07.2015.
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired(required = true)
    UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        if(!userDao.authenticate(login, pass)) {
            throw new AuthenticationException("Wrong login or password");
        }
        return true;
    }

    @Override
    public void addUser(User user) {
        userDao.create(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(String name) {
        return userDao.getByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDao.read(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void setExpiredTimeForPassword(User user, Long millis) {
        user.setExpiredTimeMillis(millis);
        userDao.update(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExistingName(String name) {
        return userDao.isExistingName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return userDao.findAll();
    }


}
