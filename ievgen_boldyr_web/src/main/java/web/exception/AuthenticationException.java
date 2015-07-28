package web.exception;

/**
 * Created by george on 13.07.15.
 */
public class AuthenticationException extends Throwable {

    public AuthenticationException() {
        super("ERROR: Cannot authenticate.");
    }

}
