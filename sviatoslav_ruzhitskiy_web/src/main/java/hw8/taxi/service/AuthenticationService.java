package hw8.taxi.service;

import hw8.taxi.domain.Operator;

import javax.naming.AuthenticationException;
import java.util.List;

/**
 * Created by ПК on 11.07.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
    Long create(Operator operator);
    Operator read(Long ig);
    boolean update(Operator operator);
    boolean delete(Operator operator);
    Operator searchByLogin(String login);
    List findAll();
}
