package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
    void doBadWork(String login, int days);
}
