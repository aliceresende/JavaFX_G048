package app.service.algorithm.subsequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BruteForceAlgorithmTest {

    @Test
    @DisplayName("Should return the subsequence with the maximum sum")
    public void testGetSubsequenceShouldReturnTheSubsequenceWithTheMaximumSum() {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] expected = {4, -1, 2, 1};
        Subsequence subsequence = new BruteForceAlgorithm();

        int[] actual = subsequence.getSubsequence(array);

        assertArrayEquals(expected, actual);
    }

}