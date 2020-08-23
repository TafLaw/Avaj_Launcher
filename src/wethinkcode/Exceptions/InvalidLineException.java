package wethinkcode.Exceptions;

public class InvalidLineException extends Exception {
    public InvalidLineException(String message)
    {
        super(message);
    }

    public InvalidLineException()
    {
        super();
    }
}