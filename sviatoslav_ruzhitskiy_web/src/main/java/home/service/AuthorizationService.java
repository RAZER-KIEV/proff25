package home.service;

import home.exception.AuthenticationException;
import home.exception.AuthorizationException;

/**
 * Created by ПК on 12.07.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass) throws AuthenticationException, AuthorizationException;
}
