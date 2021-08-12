package listsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * @author 30038637 Takuya Hasama 08/08/2021
 */
public class ListSort {

    // The static object to store the random number
    public static final Random generator = new Random();

    // generating random number in range (1 -100000) using java.util.Random
    public static int getRandomInRange(int start, int end) {
        return start + generator.nextInt(end - start + 1);
    }

    // Driver code
    public static void main(String args[]) {

        ArrayList<Integer> sortSalaries = new ArrayList<>();

        ArrayList<Staff> staffSalaries = new ArrayList<>();

        StopWatch sw = new StopWatch();

        for (int i = 0; i < 10; i++) {
            int random = getRandomInRange(1, 100);
            sortSalaries.add(random);
            staffSalaries.add(new Staff(random));
        }

        sw.start(); //start method 

        MergeSort ms = new MergeSort(sortSalaries);
        ms.sortGivenArray();

        System.out.println("\n------------Merge Sorted Array------------");
        for (int salary : ms.getSalaryArray()) {
            System.out.print(salary + " ");
        }

        sw.stop(); //stop method 
        System.out.println("");
        System.out.println("Merge sort took " + sw.getElapsedTime() + " milliseconds. (" + ((sw.getElapsedTime()) / 1000) + " second.)");

//        sw.start(); //start method 
//        InsertionSort is = new InsertionSort(sortSalaries);
//        is.sortGivenArray();
//
//        System.out.println("\n\n------------Insertion Sorted Array------------");
//        for (int salary : InsertionSort.getSalaryArray()) {
//            System.out.print(salary + " ");
//        }
//        sw.stop(); //stop method 
//        System.out.println("");
//        System.out.println("Insertion sort took " + sw.getElapsedTime() + " milliseconds. (" + ((sw.getElapsedTime()) / 1000) + " second.)");

        sw.start(); //start method 

        // Sorting elements on the basis of salary  
        Comparator<Staff> cm1 = Comparator.comparing(Staff::getSalary);
        Collections.sort(staffSalaries, cm1);

        System.out.println("\n\n---------Collection sorted Array---------");
        for (Staff sr : staffSalaries) {
            System.out.print(sr.getSalary() + " ");
        }

        sw.stop(); //stop method 
        System.out.println("");
        System.out.println("Collection sort took " + sw.getElapsedTime() + " milliseconds. (" + ((sw.getElapsedTime()) / 1000) + " second.)");

    }
}
