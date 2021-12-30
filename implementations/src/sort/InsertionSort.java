package sort;

/**
 * The insertion sort algorithm says that if the first k elements of a sequence are ordered from least to greatest,
 * then we can order the first k+1 elements by shifting all elements greater than the k+1th element up one place
 * in the sequence, and inserting the previous k+1th element at the previous place of the last element that was shifted.
 *
 * We can formalize this rough mathematical induction with loop invariants. A loop invariant for an algorithm must satisfy three
 * properties:
 * - initialization: the loop invariant is true prior to the first iteration of the loop
 * - maintenance: if the loop invariant is true before the iteration of the loop, then it is true after
 * - termination: upon loop termination, the loop invariant gives us a useful property to demonstrate correctness
 *
 * The insertion sort iterates over each element from the second to the last. The loop invariant for each
 * index idx is that the elements at indices 0,1,...,idx-1
 *  i) are the same elements as were originally in the array
 *  ii) are in sorted order
 * Considering the insertion sort algorithm...
 * - initialization: the element at index 0 is not changed, and a single element is in sorted order.
 * - termination: the algorithm terminates when idx is greater than the length of the array; the loop invariant
 *   guarantees that all elements with index less than idx are those that were originally in the array, and that
 *   these elements are in sorted order.
 *
 * Maintenance is a little more tricky as it requires considering a loop invariant for the algorithm that shifts each
 * element up by one. This algorithm considers an element E at idx, and begins at jdx=idx.
 * I *suspect* the loop invariant for this algorithm is something along the lines of:
 * - the elements at [0,jdx) (possibly empty when jdx=0) are sorted and consist of the elements originally at [0,jdx),
 * - the elements at (jdx, idx] (possibly empty when jdx=idx) are sorted, and consists of the elements originally at [jdx, idx)
 * - E is less or equal to the element at jdx+1.
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
            // compare the current element against each previous element until they are no longer greater than the current element
            int currentElement = inputArray[idx];

            // consider elements of inputArray at indexes less than idx
            int jdx = idx;

            // while jdx-1 is a valid index, and the element at jdx-1 is greater than the current element
            while (jdx > 0 && inputArray[jdx - 1] > currentElement) {
                // decrement here; prev index of last shifted element used to insert currentElement into the array
                jdx--;

                // shift the element at jdx ahead by one place
                inputArray[jdx + 1] = inputArray[jdx];
            }

            // insert the current element in the place where the previous element was shifted from (possibly unchanged)
            inputArray[jdx] = currentElement;
        }
    }
}
