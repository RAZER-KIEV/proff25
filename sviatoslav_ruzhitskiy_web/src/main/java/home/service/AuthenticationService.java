package home.service;

import home.domain.Admin;

import javax.naming.AuthenticationException;
import java.util.List;

/**
 * Created by ПК on 11.07.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
    Long create(Admin operator);
    Admin read(Long ig);
    boolean update(Admin operator);
    boolean delete(Admin operator);
    Admin searchByLogin(String login);
    List findAll();
}
