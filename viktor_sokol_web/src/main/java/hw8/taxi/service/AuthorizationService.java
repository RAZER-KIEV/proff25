package hw8.taxi.service;

import hw8.taxi.exception.AuthorizationException;

/**
 * Created by storo_000 on 09.07.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String pass, String id) throws AuthorizationException;//for jon
    boolean register(String login, String pass, String confirmPass, String id) throws AuthorizationException;
}
