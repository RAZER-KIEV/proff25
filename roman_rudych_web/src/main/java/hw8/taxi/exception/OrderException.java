package hw8.taxi.exception;

import java.io.IOException;

/**
 * Created by Роман on 16.07.2015.
 */
public class OrderException extends IOException {

    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}
