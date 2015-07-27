package hw8.taxi.service;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by viktoria
 * Project:.hw8.taxi
 */
public interface AuthenticationService {
   boolean authenticate(String login, String pass) throws AuthenticationException;
}
