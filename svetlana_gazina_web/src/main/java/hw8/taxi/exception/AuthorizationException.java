package hw8.taxi.exception;

/**
 * Created by Sveta on 8/10/2015.
 */
public class AuthorizationException extends Throwable {
    public AuthorizationException() {

    }

    public AuthorizationException(String message) {
        super(message);
    }
}