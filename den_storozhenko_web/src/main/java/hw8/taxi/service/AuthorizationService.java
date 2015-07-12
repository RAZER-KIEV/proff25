package hw8.taxi.service;

import hw8.taxi.exception.AuthorizationExeption;

/**
 * Created by storo_000 on 09.07.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String pass, String confirmPass, String id) throws AuthorizationExeption;
}
