/**
 * Created by george on 17.08.15.
 */
public interface RequestParst {
    public String parsRequest(String request) throws BadRequestException, TooLongHeaderException;
}
