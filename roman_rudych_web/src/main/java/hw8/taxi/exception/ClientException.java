package hw8.taxi.exception;

import java.io.IOException;

/**
 * Created by Роман on 04.08.2015.
 */
public class ClientException extends IOException {

    public ClientException() {
    }

    public ClientException(String message) {
        super(message);
    }
}
