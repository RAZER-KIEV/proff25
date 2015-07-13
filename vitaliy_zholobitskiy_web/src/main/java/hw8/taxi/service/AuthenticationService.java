package hw8.taxi.service;

import hw8.taxi.exeption.AuthenticationException;

/**
 * Created by just1ce on 11.07.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
}
