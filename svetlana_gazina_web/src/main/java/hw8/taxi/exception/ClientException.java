package hw8.taxi.exception;

/**
 * Created by Sveta on 8/11/2015.
 */
public class ClientException extends Throwable {
    public ClientException() {

    }

    public ClientException(String message) {
        super(message);
    }
}
