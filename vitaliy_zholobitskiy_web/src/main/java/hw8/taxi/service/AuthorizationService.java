package hw8.taxi.service;

import hw8.taxi.exception.AuthorizationException;

/**
 * Created by just1ce on 15.07.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass, String confirm) throws  AuthorizationException;
    Long getIdByLogin(String login);

}
