//Jose Franco
//04/03/25
//M4-Programming Assignment
//Test program that contains a static method that returns a new ArrayList removing duplicates from an original list.

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();
        
        // fill the original list with 50 random values from 1 to 20
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }
        
        System.out.println("\nWelcome to the Removing Duplicates Program!\n");
        System.out.println("Showing Original List with 50 random values from 1 to 20:");
        System.out.println(originalList);
        
        // remove duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);
        
        System.out.println("\nShowing List After Removing Duplicates:");
        System.out.println(uniqueList);
        
        // just added this to see how many duplicates were being removed each time
        int duplicatesRemoved = originalList.size() - uniqueList.size();
        System.out.println("\nThe total number of duplicates removed was: " + duplicatesRemoved + "\n");
        System.out.println("Thank you for using the Program. Have a nice day!\n");
    }
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return new ArrayList<>(new LinkedHashSet<>(list)); // keeps insertion order while removing duplicates
    }
}
