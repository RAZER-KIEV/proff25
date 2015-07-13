package hw8.taxi.exception;

/**
 * Created by storo_000 on 10.07.2015.
 */
public class AuthorizationException extends Exception{
    public AuthorizationException() {

    }

    public AuthorizationException(String message) {
        super(message);
    }
}
