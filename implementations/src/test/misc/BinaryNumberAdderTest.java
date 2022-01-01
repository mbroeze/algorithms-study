package test.misc;

import misc.BinaryNumberAdder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryNumberAdderTest {
    @Test
    void addBinaryNumbers_emptyArrays() {
        int[] firstNumber = new int[0];
        int[] secondNumber = new int[0];
        int[] expectedSum = { 0 };
        assertArrayEquals(expectedSum, BinaryNumberAdder.addBinaryNumbers(firstNumber, secondNumber));
    }

    @Test
    void addBinaryNumbers() {
        int[] firstNumber = { 1, 1, 1, 1 };
        int[] secondNumber = { 1, 1, 1, 1 };
        int[] expectedSum = { 0, 1, 1, 1, 1 };
        assertArrayEquals(expectedSum, BinaryNumberAdder.addBinaryNumbers(firstNumber, secondNumber));
    }
}