package wethinkcode.Exceptions;

public class InvalidAircraftException extends Exception {
    public InvalidAircraftException(String message)
    {
        super(message);
    }

    public InvalidAircraftException()
    {
        super();
    }
}