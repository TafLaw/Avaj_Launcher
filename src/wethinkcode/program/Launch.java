package wethinkcode.program;


import wethinkcode.Exceptions.InvalidArgsException;
import wethinkcode.validations.ValidateArguments;
import wethinkcode.weather.Simulator;

public class Launch {
    public static void main(String[] args) {

        ReadFile read = new ReadFile();
        WriteFile write =new WriteFile();
        ValidateArguments validateArguments = new ValidateArguments();
        Simulator simulate = new Simulator();

        try {
            validateArguments.numberOfArgs(args);
            read.readFromFile(args[0]);
            simulate.simulate();
            write.writeToFile();

        } catch (InvalidArgsException e) {
            System.out.println("Expected only one argument");
        }



    }
}
