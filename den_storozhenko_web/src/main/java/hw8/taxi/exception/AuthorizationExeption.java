package hw8.taxi.exception;

/**
 * Created by storo_000 on 10.07.2015.
 */
public class AuthorizationExeption extends Exception{
    public AuthorizationExeption() {

    }

    public AuthorizationExeption(String message) {
        super(message);
    }
}
