package wethinkcode.Exceptions;

public class InvalidArgsException extends Exception {
    public InvalidArgsException(String message)
    {
        super(message);
    }

    public InvalidArgsException()
    {
        super();
    }
}
