package wethinkcode.Exceptions;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(String message)
    {
        super(message);
    }

    public InvalidNumberException()
    {
        super();
    }
}