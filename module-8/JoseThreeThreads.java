//Jose Franco
//04/24/2025
//M8-Programming Assignment
//Using Threads to output three types of random characters to a text area for display.

import java.util.Random;

public class JoseThreeThreads {

    //StringBuilders to collect the results
    private static StringBuilder lettersOutput = new StringBuilder();
    private static StringBuilder numbersOutput = new StringBuilder();
    private static StringBuilder symbolsOutput = new StringBuilder();

    private static final int COUNT = 10000;

    public static void main(String[] args) {

        //Welcome message
        System.out.println("\nWELCOME TO THE THREADS PROGRAM!\n");

        // Thread letters
        Thread letterThread = new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char c = (char) ('a' + rand.nextInt(26));
                synchronized (lettersOutput) {
                    lettersOutput.append(c).append(" ");
                }
            }
        });

        // Thread for random digits
        Thread numberThread = new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char digit = (char) ('0' + rand.nextInt(10));
                synchronized (numbersOutput) {
                    numbersOutput.append(digit).append(" ");
                }
            }
        });

        // Thread for random symbols
        Thread symbolThread = new Thread(() -> {
            char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char symbol = symbols[rand.nextInt(symbols.length)];
                synchronized (symbolsOutput) {
                    symbolsOutput.append(symbol).append(" ");
                }
            }
        });

        // start all threads
        letterThread.start();
        numberThread.start();
        symbolThread.start();

        // wait for all threads to finish
        try {
            letterThread.join();
            numberThread.join();
            symbolThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test
        System.out.println("First Thread - Random letters: " + lettersOutput.substring(0, 10000));
        System.out.println("Letters generated: " + lettersOutput.toString().replace(" ", "").length());
        
        System.out.println("\nSecond Thread - Random numbers: " + numbersOutput.substring(0, 10000));
        System.out.println("Numbers generated: " + numbersOutput.toString().replace(" ", "").length());

        System.out.println("\nThird Thread - Random characters: " + symbolsOutput.substring(0, 10000));
        System.out.println("Characters generated: " + symbolsOutput.toString().replace(" ", "").length() + "\n");

        //Goodbye message
        System.out.println("Thank you for using the Threads Program. Have a good day!\n");

    }
}
