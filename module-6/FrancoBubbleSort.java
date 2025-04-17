//Jose Franco
//04/16/25
//M6 Programming Assignment
//Program with using Bubble Sort with the the generic methods Comparable and Comparator.

import java.util.Comparator;

public class FrancoBubbleSort {

    // bubble sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    // bubble sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    // swap utility method
    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    // print array utility
    public static <E> void printArray(E[] array) {
        System.out.print("{ ");
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println("}\n");
    }

    // testing
    public static void main(String[] args) {
       
        System.out.println("\nWELCOME TO THE PROGRAM!\n");
       
        // comparable
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9, 0, 8, 5};
        System.out.println("Showing numbers before 'Comparable' sort:");
        printArray(nums);
        bubbleSort(nums);
        System.out.println("\nShowing numbers after 'Comparable' sort:");
        printArray(nums);

        // comparator
        String[] cities = {"Caracas", "Dallas", "Santiago", "Buenos Aires", "Roma", "Madrid", "Paris"};
        System.out.println("\nShowing cities before 'Comparator' sort:");
        printArray(cities);
        bubbleSort(cities, Comparator.naturalOrder());  
        System.out.println("\nShowing cities after 'Comparator' sort:");
        printArray(cities);

        System.out.println("Thank you for using the Bubble Sort Program!\n");
    }
}
