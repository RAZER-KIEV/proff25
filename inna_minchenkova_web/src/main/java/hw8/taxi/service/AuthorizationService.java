package hw8.taxi.service;

import hw8.taxi.domain.Employee;
import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Vlad on 06.04.2015.
 */
public interface AuthorizationService {

    boolean register(String login, String id, String pass) throws AuthenticationException;

    public Employee getByLogin(String login);
}
