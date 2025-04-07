//Jose Franco
//04/01/25
//M4-Programming Assignment
//Test program that stores 50,000 integers in LinkedList and test the time to traverse the list using an iterator vs. using the get(index) method

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the Test Program!");
        System.out.println("\nTesting with 50,000 elements:");
        testPerformance(50_000);
        System.out.println("\nTesting with 500,000 elements:");
        testPerformance(500_000);
        System.out.println("\nThank you for using the Test Program. Have a nice day!\n");
    }

    public static void testPerformance(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // LinkedList with numbers from 1 to size
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Taking time using iterator
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long iteratorTime = System.nanoTime() - startTime;

        // Taking time using get(index) method
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long getTime = System.nanoTime() - startTime;

        System.out.println("Size: " + size);
        System.out.println("Iterator Time: " + (iteratorTime / 1_000_000.0) + " ms");
        System.out.println("get(index) Time: " + (getTime / 1_000_000.0) + " ms");
        System.out.println("Difference: " + (getTime / (double) iteratorTime) + "x slower using get(index) method.");
    }
}

/*
For the purpose of explaining the diference of both methods I ran the program with the following results:

Test 1: 50,000 elements
Iterator Time:  aprox. 1.62 ms
get(index) Time: aprox. 995.89 ms
get(index) was approximately 613x slower than using an Iterator.

Test 2: 500,000 elements
Iterator Time: aprox. 4.96 ms
get(index) Time: aprox. 109,403.32 ms (over 1 minute)
get(index) was approximately 22,036x slower than using an Iterator.

Analysis of results:

The massive difference in performance is due to how LinkedLists work internally:
- A LinkedList does not support efficient random access. The get(index) method must traverse the list from the beginning each time, 
resulting in O(n²) time for a full traversal.

- The Iterator, on the other hand, walks through the list sequentially in O(n) time.

As the size of the list increases, the performance gap between the two methods grows exponentially. This makes the get(index) method extremely 
inefficient for large LinkedLists when used in a loop.


From this exercise I learned that, when working with LinkedLists, always use an Iterator or a for-each loop for traversal and avoid get(index) in loops unless
absolutely necessary, especially with large data sizes.

*/
