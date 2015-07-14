package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Vlad on 02.04.2015.
 */
public interface AuthenticationService {
    public boolean authenticate(String login, String pass) throws AuthenticationException;

    public void setBlock(String login);

}
