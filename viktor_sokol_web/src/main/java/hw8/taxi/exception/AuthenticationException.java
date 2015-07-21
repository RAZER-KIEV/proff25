package hw8.taxi.exception;

/**
 * Created by storo_000 on 09.07.2015.
 */
public class AuthenticationException extends Exception {
    public AuthenticationException() {

    }

    public AuthenticationException(String message) {
        super(message);
    }
}
