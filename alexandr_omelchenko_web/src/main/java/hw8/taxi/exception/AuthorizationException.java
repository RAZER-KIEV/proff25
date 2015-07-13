package hw8.taxi.exception;

/**
 * Created by HP on 12.07.2015.
 */
public class AuthorizationException extends Exception{
    public AuthorizationException() {

    }

    public AuthorizationException(String message) {
        super(message);
    }
}
