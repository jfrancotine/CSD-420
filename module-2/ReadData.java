//Jose Franco
//03/29/25
//M2:Programming Assignment 
//The purpose of this program is to generate and store arrays of random integers and double values in a file, 
//appending new data if the file already exists, and then read and display the stored data to verify its accuracy.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static void main(String[] args) {
        String filename = "jose_datafile.dat";

        //Read file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\nWelcome to the Write-Read Data program.\n");
            System.out.println("The contents of the file " + filename + " are:\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-----End of Data-----\n");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
