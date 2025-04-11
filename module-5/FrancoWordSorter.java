//Jose Franco
//04/10/2025
//M5-Programming Assignment
//Test program that reads words from a text file and displays all non-duplicate words in ascending order and then in descending order.

import java.io.*;
import java.util.*;

public class FrancoWordSorter {
    public static void main(String[] args) {
    
        System.out.println("\nWELCOME TO THE PROGRAM!\n");
        
        String fileName = "collection_of_words.txt";

        // set to store non duplicate words
        Set<String> wordSet = new HashSet<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z]", "").toUpperCase();
                if (!word.isEmpty()) {
                    wordSet.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        // convert to list for sorting
        List<String> wordList = new ArrayList<>(wordSet);

        // ascending order
        Collections.sort(wordList);
        System.out.println("Showing words from file in ascending order:");
        System.out.println(wordList);

        // descending order
        Collections.sort(wordList, Collections.reverseOrder());
        System.out.println("\nShowing words from file in descending order:");
        System.out.println(wordList);

        // simple test to make sure collection_of_words.txt has values in it
        if (!wordList.isEmpty()) {
            System.out.println("\nWords were successfully read from file 'collection_of_words.txt' and sorted.\n");
        } else {
            System.out.println("\nTest failed: No words found in the file.\n");
        }
        
        System.out.println("Thank you for using the word sorter program. Have a nice day!\n");
    }
}
