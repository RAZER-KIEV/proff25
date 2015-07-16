package web.service;

import web.exception.AuthenticationException;

/**
 * Created by george on 13.07.15.
 */
public class AuthenticationServiceImpl implements AuthenticationService{
    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        return false;
    }
}
