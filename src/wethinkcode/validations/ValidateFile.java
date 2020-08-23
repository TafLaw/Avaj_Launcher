package wethinkcode.validations;

import wethinkcode.Exceptions.*;

public class ValidateFile {
    public static int simulationsNo;
    public boolean isValidLine(String line) throws InvalidLineException
    {
        String[] planeInfo = line.split(" ");

        if(planeInfo.length != 5)
            throw new InvalidLineException("Invalid Line");
        return true;
    }

    public void validFirstLine(String line) throws InvalidNumberException
    {
        try {
            simulationsNo = Integer.parseInt(line);
            if(simulationsNo <= 0)
                throw new InvalidNumberException("The first line is invalid");
        } catch (NumberFormatException e) {
            System.out.println("error: The first line must be a positive integer");
            System.exit(1);
        }
    }

    public boolean validAircraftType(String type) throws InvalidAircraftException
    {
        String[] planeInfo = type.split(" ", 5);
        type = planeInfo[0];
        if(type.equals("Baloon") || type.equals("JetPlane") || type.equals("Helicopter"))
            return  true;

        throw new InvalidAircraftException("Unknown Aircraft type, try Baloon, JetPlane or Helicopter!");
    }
}
