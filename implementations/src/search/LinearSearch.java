package search;

/**
 * Linear Search: Given an array of ints, and a value to find, determine the index of the first occurrence of that value
 * in the array, or -1 if no such value exists.
 *
 * Loop Invariant: Before the kth element is processed, none of the previous k-1 elements contain the desired value, and
 * the original array is unchanged.
 *
 * Initialization: Before the first element is processed, no elements have been processed so this empty sequnece of elements
 * does not contain the desired  value. The original array remains unchanged.
 * Maintenance: Suppose the first k elements have been processed. Then none of the first k-1 elements are a match. If the element
 * at k is a match, then the algorithm terminates. Otherwise, the element at k is not a match, so that the first k elements are not
 * a match. The elements of the array remain unchanged.
 * Termination: The algorithm terminates if all of the array elements have been processed, or if a matching value is found.
 * In the first case, the loop invariant tells us that the array has remained unchanged and that no matching values were found,
 * so that -1 is returned. In the second case, let the index of the matching element be k. By the loop invariant,
 * the elements at indices 0,...,k-1 are not matching, and the contents of the array remain unchanged, so that the element
 * at k is the first matching element in the array.
 */
public class LinearSearch {
    /**
     * Searches an int array for a matching value.
     * @param inputArray the int array in which to find a matching value
     * @param value the matching value to search for
     * @return the index of the first matching value, or -1 if no matching value is found
     */
    public static int linearSearch(int[] inputArray, int value) {
        // iterate through the array until the value is found
        for (int idx = 0; idx < inputArray.length; idx++) {
            // if the value is found
            if (inputArray[idx] == value) {
                // return the index of that value
                return idx;
            }
        }

        // if no such value is found
        return -1;
    }
}
