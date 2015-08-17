package request;

//import exception.*;
import request.exceptions.*;

/**
 * Created by george on 17.08.15.
 */
public interface RequestParts {
    public String requestParst(String request) throws BadRequestException, TooLongException;
}
