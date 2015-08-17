package hw8.taxi.exception;

import java.io.IOException;

/**
 * Created by Роман on 13.07.2015.
 */
public class AuthorizationException extends IOException {

    public AuthorizationException() {

    }

    public AuthorizationException(String gripe) {
        super(gripe);
    }
}
