package wethinkcode.validations;

import wethinkcode.Exceptions.InvalidArgsException;

public class ValidateArguments {

    public boolean numberOfArgs(String[] args) throws InvalidArgsException
    {
        if (args.length != 1){
            throw new InvalidArgsException("Expected only one argument");}
        else
            return true;
    }
}
