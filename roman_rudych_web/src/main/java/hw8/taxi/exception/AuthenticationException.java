package hw8.taxi.exception;

import java.io.IOException;

/**
 * Created by Роман on 11.07.2015.
 */
public class AuthenticationException extends IOException {

    public AuthenticationException() {
    }

    public AuthenticationException(String gripe) {
        super(gripe);
    }
}
