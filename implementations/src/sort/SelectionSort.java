package sort;

import search.LinearSearch;

/**
 * Selection Sort Algorithm
 * For each index idx in [0, inputArray.length - 1)
 * 1. Find the element E that is less than or equal to inputArray.length - idx elements
 * 2. Swap the element at index idx with the element E
 *
 * Loop invariant: For an index of iteration k < n = inputArray.length
 * Each element (possibly none of them) preceding the kth element is in sorted order, and if the k-1th
 * element exists, it is less than or equal to the remaining elements. The elements in the array are those that were in
 * the array before the algorithm started.
 *
 * Initialization: The loop invariant is trivially true for no elements. The array has not been changed.
 * Maintenance: Suppose the first k elements have been processed, so that the first k elements are in sorted order,
 * the remaining elements in the array are greater than ore equal to the kth element, and the elements in the array have
 * not changed. The next iteration of the algorithm swaps the k+1th element with the smallest element of those remaining.
 * The new k+1th element is g.e. than the previous k sorted elements, so the first k+1 elements are sorted. The remaining
 * elements are g.e. the k+1th element, and as two values have been swapped the original elements are still in the array.
 * Termination: The algorithm terminates after processing the second last element of the array. It guarantees that all elements
 * except the last are in sorted order, and that the second last element is less than or equal to the remaining element.
 */
public class SelectionSort {
    /**
     * Uses selection sort to sort an int array in place from least to greatest.
     * @param inputArray the int array to be sorted in place
     */
    public static void selectionSort(int[] inputArray) {
        // for each element of the array except the last
        for (int idx = 0; idx < inputArray.length - 1; idx++) {

            // determine the smallest element in the array from idx onwards
            int smallestIdx = idx;
            for (int jdx = idx + 1; jdx < inputArray.length; jdx++) {
                // if the element at idx is less than the smallest element found so far
                if (inputArray[jdx] < inputArray[smallestIdx]) {
                    smallestIdx = jdx;
                }
            }

            // store values for swapping
            int idxValue = inputArray[idx];
            int smallestIdxValue = inputArray[smallestIdx];

            // swap the value of the current index with that of the index containing the smallest value
            inputArray[idx] = smallestIdxValue;
            inputArray[smallestIdx] = idxValue;
        }
    }
}
