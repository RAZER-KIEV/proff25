package hw8.taxi.service;

import javax.naming.AuthenticationException;

/**
 * Created by ПК on 11.07.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
}
