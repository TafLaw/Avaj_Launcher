package wethinkcode.program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class WriteFile {
    public static ArrayList<String> allMessages = new ArrayList<String>();
    public void writeToFile()
    {
        try {
            BufferedWriter writeMessage = new BufferedWriter(new FileWriter("simulation.txt"));
            for (String message: allMessages) {
                writeMessage.write(message);
                writeMessage.append('\n');
            }

            writeMessage.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

//        try {
//            File myObj = new File("Test.txt");
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }
}
