package web.service;

import web.exception.AuthenticationException;

/**
 * Created by george on 13.07.15.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
}
