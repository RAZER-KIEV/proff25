package hw8.taxi.service;


import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Sveta on 7/16/2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException, javax.naming.AuthenticationException;
}
