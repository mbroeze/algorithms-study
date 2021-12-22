package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {
    @Test
    void emptyArrayInsertionSort() {
        int[] arr = {};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[0], arr);
    }

    @Test
    void insertionSort() {
        int[] arr = { 1, 0, 5, 2, 4, 3 };
        InsertionSort.insertionSort(arr);
        int[] sorted = { 0, 1, 2, 3, 4, 5 };
        assertArrayEquals(sorted, arr);
    }
}