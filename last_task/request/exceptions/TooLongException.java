package exceptions;

/**
 * Created by viktoria
 * Project:.exceptions
 */
public class TooLongException extends Exception {
    public  TooLongException (String msg){
        super("Sorry your request too long! Try again");
    }
}
