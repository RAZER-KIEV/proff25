package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by ПК on 12.07.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass, String confirm) throws AuthenticationException;
}
