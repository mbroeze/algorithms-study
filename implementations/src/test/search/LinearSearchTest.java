package test.search;

import org.junit.jupiter.api.Test;
import search.LinearSearch;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {
    @Test
    void linearSearch_emptyArray() {
        int[] arr = {};
        int value = 1;
        assertEquals(-1, LinearSearch.linearSearch(arr, value));
    }

    @Test
    void linearSearch() {
        int[] arr = { 0, 0, 0, 1 };
        int value = 1;
        assertEquals(3, LinearSearch.linearSearch(arr, value));
    }
}