package misc;

/**
 * Adding two binary numbers.
 *
 * In this exercise, binary numbers are written as arrays of integers, where each integer is either zero or one. The value
 * at index k is the digit of the place-value for 2^k.
 *
 * Let carry_i be the value of carry at iteration i=0,1,...
 * Let arr = { arr1, arr2, ..., arr(n) }. Define arr[0:k] := { arr1, arr2, ...., arr(k-1)}, i.e. the array with the first k elements.
 * Define value(arr) := sum_{for all valid index k} arr[k]*2^k.
 *
 * Loop Invariant: value(firstArray[0:k]) + value(secondArray[0:k]) == value(sumArray[0:k]) + 2^k * carry_k.
 *
 * Initialization: Recall that the empty sum is defined to be additive identity. Carry is initialized to zero, so we
 * correctly have value(firstArray[0:0]) + value(firstArray[0:0]) == value(sumArray[0:0]) + 0.
 *
 * Lemma 1: value(arr[0:k]) + arr[k] * 2^k = value(arr[0:k+1])
 * - this proof is straightforward from the definitions above
 *
 * Lemma 2: Let sum_i = firstArray[i] + secondArray[i] + carry_i.
 * Then, value(firstArray[0:k+1]) + value(secondArray[0:k+1]) = value(firstArray[0:k]) + value(secondArray[0:k]) + 2^k * (sum_k % 2) + 2^(k+1) * (sum_k / 2)
 * - straightforward from definitions of arr[0:i], and lemma 1
 *
 * Maintenance: Suppose value(firstArray[0:k]) + value(secondArray[0:k]) == value(sumArray[0:k]) + 2^k * carry_.
 * Then by adding sum_k to both sides of the equation, and applying lemma 2, we can see that the loop invariant holds
 * after the next step of iteration,
 * i.e., value(firstArray[0:k+1]) + value(secondArray[0:k+1]) == value(sumArray[0:k+1]) + 2^(k+1) * carry_(k+1).
 *
 * Termination: Let n be the length of firstArray and secondArray. Then first(second)Array[0:n] = first(second)Array,
 * so that value(sumArray[0:n]) + carry * 2^n+1 = value(firstArray) + value(secondArray). Hence, once we assign sumArray[n] = carry,
 * we have value(sumArray) = value(firstArray) + value(secondArray), and we are done.
 */
public class BinaryNumberAdder {
    /**
     * Adds binary numbers. The numbers are represented as an array of ints, where the element of the array at index k
     * represents the place-value of 2^k. This method is intended for proof of concept, and supposes that you have not given it anything
     * except two equally-sized arrays whose contents are exclusively zeroes and ones.
     *
     * @param firstNumber An array of ints whose elements are zeroes or ones representing the digits of a binary number;
     *                   must be the same size as secondNumber
     * @param secondNumber An array of ints whose elements are zeroes or ones representing the digits of a binary number;
     *                    must be the same size as firstNumber
     * @return An array of ints whose elements are zeroes or ones representing the digits of the binary number that is the
     * sum of firstNumber and secondNumber.
     */
    public static int[] addBinaryNumbers(int[] firstNumber, int[] secondNumber) {
        // extra place-value in sum array for final carry
        int[] sumArray = new int[firstNumber.length + 1];

        // carry is used in each iteration; instantiated to zero for first calculation
        int carry = 0;

        // start at the element representing the 2^0 bit, and work our way up
        for (int idx = 0; idx < firstNumber.length; idx++) {
            int sum = firstNumber[idx] + secondNumber[idx] + carry; // possible values are 0,1,2,3
            sumArray[idx] = sum % 2; // 0 or 1 depending on if sum is even or odd
            carry = sum / 2; // 0 or 1 depending on if sum is in 0,1 or 2,3
        }
        // the last carry value is assigned to the "extra" place-value element
        sumArray[sumArray.length - 1] = carry;

        return sumArray;
    }
}
