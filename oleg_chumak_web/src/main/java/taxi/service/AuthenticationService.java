package taxi.service;

import taxi.exception.AuthenticationException;

public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
    void doBadWork(String login, int days);
}
