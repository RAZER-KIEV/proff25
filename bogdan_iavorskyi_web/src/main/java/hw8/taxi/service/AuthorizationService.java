package hw8.taxi.service;

import hw8.taxi.exception.AuthorizationException;

public interface AuthorizationService {
    boolean register(String login, String individualTaxpayerNumber, String password) throws AuthorizationException;
    boolean changePassword(String login, String password) throws AuthorizationException;
}
