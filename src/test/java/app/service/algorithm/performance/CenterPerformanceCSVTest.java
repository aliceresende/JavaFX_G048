package app.service.algorithm.performance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CenterPerformanceCSVTest {


    @Test
    @DisplayName("Should return the sum of all elements in the array")
    public void testSumSublistShouldReturnTheSumOfAllElementsInTheArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int expected = 15;

        int actual = new CenterPerformanceCSV().sumSublist(arr);

        assertEquals(expected, actual);
    }
}
