package hw8.taxi.service;

import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthenticationException;

import java.util.List;

/**
 * Created by Роман on 11.07.2015.
 */
public interface AuthenticationService {

    boolean authenticate(String login, String pass) throws AuthenticationException;
    void addUser(User user);
    User getUser(String name);
    User getUser(Long id);
    void update(User user);
    void setExpiredTimeForPassword(User user, Long millis);
    boolean isExistingName(String name);
    List findAll();
}
