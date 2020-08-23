package wethinkcode.program;

import wethinkcode.Exceptions.InvalidAircraftException;
import wethinkcode.Exceptions.InvalidLineException;
import wethinkcode.Exceptions.InvalidNumberException;
import wethinkcode.aircrafts.AircraftFactory;
import wethinkcode.aircrafts.Flyable;
import wethinkcode.validations.ValidateFile;

import java.io.*;
import java.util.*;

public class ReadFile {
    public static ArrayList<Flyable> flyables;

    int lineNumber = 1;

    private void addNewAircraft(String line, int lineNumber)
    {
        try {
            String[] data = line.split(" ", 5);
            String type = data[0];
            String name = data[1];
            int longitude = Integer.parseInt(data[2]);
            int latitude = Integer.parseInt(data[3]);
            int height = Integer.parseInt(data[4]);
            flyables.add(AircraftFactory.newAircraft(type, name, longitude, latitude, height));

        } catch (NumberFormatException e) {
            System.out.println("Invalid coordinates or height on line " + lineNumber + " of the scenario file.");
            System.exit(1);
        }

    }

    public void readFromFile(String filename)
    {
        String line;

        try {
            flyables = new ArrayList<Flyable>();
            ValidateFile validateFile = new ValidateFile();
            File file = new File(filename);;
            Scanner scanFile = new Scanner(file);
            validateFile.validFirstLine(scanFile.nextLine());

            while(scanFile.hasNextLine())
            {
                lineNumber++;
                line = scanFile.nextLine();
                if(!line.isEmpty() && validateFile.isValidLine(line) && validateFile.validAircraftType(line))
                    addNewAircraft(line, lineNumber);
                else
                {
                    throw new InvalidLineException("Invalid Line");
                }
            }
            scanFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: File not found");
            System.exit(1);
        } catch (InvalidLineException e) {
            System.out.println("error: The Scenario on line " + lineNumber + " is invalid");
            System.exit(1);
        } catch (InvalidNumberException e) {
            System.out.println("error: The first line must be a positive integer");
            System.exit(1);
        } catch (InvalidAircraftException e) {
            System.out.println("error: Unknown Aircraft type on line " + lineNumber + ", try Baloon, JetPlane or Helicopter!");
            System.exit(1);
        }
    }
}