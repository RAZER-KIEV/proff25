package request;

import request.exceptions.BadRequestException;
import request.exceptions.TooLongException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by george on 17.08.15.
 */
public class RequestParst implements RequestParts {


    @Override
    public String requestParst(String request) throws BadRequestException, NullPointerException {
        if (request == null) {
            throw new NullPointerException("Illegal input argument request.");
        }
        String[] arrayRequest = request.split("\\s");
        if (!arrayRequest[0].equals("GET")) {
            throw new BadRequestException("Illegal http method.");
        }
        String path = arrayRequest[1];

        return path;
    }

    public static void main(String[] args) {

    }

}
