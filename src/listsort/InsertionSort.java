package listsort;

import java.util.ArrayList;

/**
 * @author 30038637 Takuya Hasama 08/08/2021
 */
public class InsertionSort {

    private static ArrayList<Integer> salaries = new ArrayList<Integer>();

    public static ArrayList<Integer> getSalaryArray() {
        return salaries;
    }

    public InsertionSort(ArrayList<Integer> inputArray) {
        InsertionSort.salaries = inputArray;
    }

    public void sortGivenArray() {
        for (int i = 1; i < salaries.size(); i++) {

            int key = salaries.get(i);

            for (int j = i - 1; j >= 0; j--) {
                if (key < salaries.get(j)) {
                    // Shifting Each Element to its right as key is less than the existing element at current index
                    salaries.set(j + 1, salaries.get(j));

                    // Special case scenario when all elements are less than key, so placing key value at 0th Position
                    if (j == 0) {
                        salaries.set(0, key);
                    }
                } else {
                    // Putting Key value after element at current index as Key value is no more less than the existing element at current index
                    salaries.set(j + 1, key);
                    break; // You need to break the loop to save un necessary iteration
                }
            }
        }
    }
}
