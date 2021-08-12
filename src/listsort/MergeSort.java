
package listsort;

import java.util.ArrayList;

/**
 * @author 30038637 Takuya Hasama 08/08/2021
 */
public class MergeSort {

    private final ArrayList<Integer> salaries;

    public ArrayList<Integer> getSalaryArray() {
        return salaries;
    }

    public MergeSort(ArrayList<Integer> inputArray) {
        this.salaries = inputArray;
    }

    public void sortGivenArray() {
        divide(0, this.salaries.size() - 1);
    }

    public void divide(int start, int end) {

        //Divide till you breakdown your list to single element
        if (start < end && (end - start) >= 1) {
            int mid = (end + start) / 2;
            divide(start, mid);
            divide(mid + 1, end);

            //merging Sorted array produce above into one sorted array
            merger(start, mid, end);
        }
    }

    public void merger(int start, int mid, int end) {

        //Below is the mergedarray that will be sorted array Array[i-mid] , Array[(mid+1)-end]
        ArrayList<Integer> mergedSortedArray = new ArrayList<>();

        int leftIndex = start;
        int rightIndex = mid + 1;

        while (leftIndex <= mid && rightIndex <= end) {
            if (salaries.get(leftIndex) <= salaries.get(rightIndex)) {
                mergedSortedArray.add(salaries.get(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.add(salaries.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while (leftIndex <= mid) {
            mergedSortedArray.add(salaries.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= end) {
            mergedSortedArray.add(salaries.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = start;
        //Setting sorted array to original one
        while (i < mergedSortedArray.size()) {
            salaries.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
}
