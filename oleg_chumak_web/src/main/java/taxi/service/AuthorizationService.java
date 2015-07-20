package taxi.service;

import taxi.exception.AuthorizationException;

public interface AuthorizationService {
    boolean register(String login, String individualTaxpayerNumber, String password) throws AuthorizationException;
    boolean changePassword(String login, String password) throws AuthorizationException;
}
