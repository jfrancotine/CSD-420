//Jose Franco
//03/29/25
//M2:Programming Assignment 
//The purpose of this program is to generate and store arrays of random integers and double values in a file, 
//appending new data if the file already exists, and then read and display the stored data to verify its accuracy.


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        String filename = "jose_datafile.dat";

        Random rand = new Random();
        int[] randomInts = new int[5];
        double[] randomDoubles = new double[5];

        // Generate random values
        for (int i = 0; i < 5; i++) {
            randomInts[i] = rand.nextInt(100); // random int 
            randomDoubles[i] = rand.nextDouble() * 100; // random double
        }

        // Write to file
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Random Integers: ");
            for (int num : randomInts) {
                writer.write(num + " ");
            }
            writer.write("\n");

            writer.write("Random Doubles: ");
            for (double d : randomDoubles) {
                writer.write(String.format("%.2f ", d));// Two decimals only
            }
            writer.write("\n\n");
            System.out.println("\nWelcome to the Write-Read Data program.\n");
            System.out.println("Your Data is being written.......Please press any key to continue.");
            try {
                System.in.read(); // Waits for the user to press any key
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("The Data has been written to the file " + filename + ". Thank you.\n");
            System.out.println("To show the current Data of the file, please run the program ReadData from your terminal.\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file."); 
            e.printStackTrace();
        }
    }
}
