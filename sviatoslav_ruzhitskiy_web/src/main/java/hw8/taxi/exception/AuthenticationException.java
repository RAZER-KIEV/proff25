package hw8.taxi.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by ПК on 11.07.2015.
 */
public class AuthenticationException extends Exception {
    public AuthenticationException () {}

    public AuthenticationException(String message) {
        super(message);
    }
}
