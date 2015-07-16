package hw8.taxi.exception;

/**
 * Created by just1ce on 15.07.2015.
 */
public class AuthorizationException extends Exception {
    @Override
    public String toString(){
        return "Incorrect register data";
    }
}
