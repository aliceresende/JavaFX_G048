package app.service.algorithm.subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BenchmarkTest {

    private Subsequence benchmark;

    @BeforeEach
    public void setUp() {
        benchmark = new Benchmark();
    }

    @Test
    @DisplayName("Should return empty array when the input array is empty")
    public void testGetSubsequenceWhenInputArrayIsEmptyThenReturnEmptyArray() {
        int[] inputArray = new int[0];
        int[] expectedArray = new int[0];

        int[] actualArray = benchmark.getSubsequence(inputArray);

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Should return empty array when the input array contains only negative numbers")
    public void testGetSubsequenceWhenInputArrayContainsOnlyNegativeNumbersThenReturnEmptyArray() {
        int[] inputArray = {-1, -2, -3, -4, -5};
        int[] expectedArray = {};

        int[] actualArray = benchmark.getSubsequence(inputArray);

        assertArrayEquals(expectedArray, actualArray);
    }
}