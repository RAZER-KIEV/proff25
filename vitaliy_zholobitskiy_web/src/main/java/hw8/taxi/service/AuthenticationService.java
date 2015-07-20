package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;

/**
 * Created by just1ce on 11.07.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
    Long getIdByLogin(String login);

}
