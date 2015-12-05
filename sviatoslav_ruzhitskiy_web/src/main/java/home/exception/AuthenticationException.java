package home.exception;

/**
 * Created by ПК on 11.07.2015.
 */
public class AuthenticationException extends Exception {
    public AuthenticationException () {}

    public AuthenticationException(String message) {
        super(message);
    }
}
