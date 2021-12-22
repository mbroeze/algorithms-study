package sort;

/**
 * The insertion sort algorithm says that if the first k elements of a sequence are ordered from least to greatest,
 * then we can order the first k+1 elements by shifting all elements greater than the k+1th element up one place
 * in the sequence, and inserting the previous k+tth element at the previous place of the last element that was shifted.
 *
 * Insertion sort is in O(n^2), and is efficient for a small number of elements.
 */
public class InsertionSort {

    /**
     * Implements the insertion sort algorithm on an array of integers. Modifies the array in place.
     * @param inputArray the array to be sorted in place
     */
    public static void insertionSort(int[] inputArray) {
        // begin at the second element of the list, and proceed to each element thereafter
        for (int idx = 1; idx < inputArray.length; idx++) {
            // we compare the current element against each previous element until they are no longer greater than the current element
            int currentElement = inputArray[idx];

            // consider elements of inputArray at indexes less than idx
            int jdx = idx - 1;

            // while jdx is a valid index, and the element at jdx is greater than the current element
            while (jdx >= 0 && inputArray[jdx] > currentElement) {
                // shift the element at jdx ahead by one place
                inputArray[jdx + 1] = inputArray[jdx];
                jdx--;
            }
            // insert the current element; add one to jdx to account for decrement in last while loop (or initialization of jdx)
            inputArray[jdx + 1] = currentElement;
        }
    }
}
