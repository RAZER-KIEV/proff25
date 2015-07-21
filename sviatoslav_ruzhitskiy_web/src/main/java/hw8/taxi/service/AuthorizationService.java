package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;

/**
 * Created by ПК on 12.07.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass) throws AuthenticationException, AuthorizationException;
}
