package home.service;

import home.domain.Employee;

import java.util.List;

/**
 * Created by ПК on 11.07.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass);
    Long create(Employee operator);
    Employee read(Long ig);
    boolean update(Employee operator);
    boolean delete(Employee operator);
    Employee searchByLogin(String login);
    List findAll();
}
