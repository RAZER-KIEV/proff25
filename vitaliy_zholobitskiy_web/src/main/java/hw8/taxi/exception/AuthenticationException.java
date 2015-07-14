package hw8.taxi.exception;

/**
 * Created by just1ce on 11.07.2015.
 */
public class AuthenticationException extends Exception {
    @Override
    public String toString(){
        return "Incorrect login or password";
    }
}
