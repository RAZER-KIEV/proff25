package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;

public interface AuthenticationService {
    Long createOperator(Operator operator);
    Operator getOperator(Long id);
    boolean authenticate(String login, String pass) throws AuthenticationException;
    boolean changePassword(String login, String password, String newpass, String confirm) throws AuthenticationException;
}
