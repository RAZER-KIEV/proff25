package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;

/**
 * Created by Sveta on 8/10/2015.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass, String confirm) throws AuthorizationException;
}
