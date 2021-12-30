package test.sort;

import org.junit.jupiter.api.Test;
import sort.SelectionSort;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    @Test
    void selectionSort_emptyArray() {
        int[] arr = {};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[0], arr);
    }

    @Test
    void selectionSort() {
        int[] arr = { 1, 0, 5, 2, 4, 3 };
        SelectionSort.selectionSort(arr);
        int[] sorted = { 0, 1, 2, 3, 4, 5 };
        assertArrayEquals(sorted, arr);
    }
}