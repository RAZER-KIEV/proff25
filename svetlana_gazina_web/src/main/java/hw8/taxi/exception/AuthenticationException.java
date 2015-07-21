package hw8.taxi.exception;

/**
 * Created by Sveta on 7/16/2015.
 */
public class AuthenticationException extends Throwable {
    public AuthenticationException() {

    }

    public AuthenticationException(String message) {
        super(message);
    }
}
