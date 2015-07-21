package hw8.taxi.service;

/**
 * Created by ivan on 21.07.15.
 */
import hw8.taxi.exception.AuthenticationException;

public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
}
