package hw8.taxi.exception;

/**
 * Created by HP on 12.07.2015.
 */
public class AuthenticationException extends Exception {
    public AuthenticationException() {

    }

    public AuthenticationException(String message) {
        super(message);
    }
}