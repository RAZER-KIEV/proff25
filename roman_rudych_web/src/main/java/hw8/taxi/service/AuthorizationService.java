package hw8.taxi.service;

import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthorizationException;

/**
 * Created by Роман on 13.07.2015.
 */
public interface AuthorizationService {


    boolean register(String login, String id, String pass, String confirm) throws AuthorizationException;
    Long addUser(User user);
}
