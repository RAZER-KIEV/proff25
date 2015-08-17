package request;

import request.exceptions.BadRequestException;

/**
 * Created by george on 17.08.15.
 */
public interface RequestParts {
    String requestParst(String request) throws BadRequestException;
}
