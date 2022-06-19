package app.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PerformanceAnalysisControllerTest {

    @Test
    @DisplayName("Should return the max sublist when the subsequence is not empty")
    public void testGetMaxSublistWhenSubsequenceIsNotEmpty() {
        PerformanceAnalysisController controller = new PerformanceAnalysisController();
        int[] subsequence = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        try {
            int[] actual = controller.getMaxSublist(subsequence);
            assertArrayEquals(expected, actual);
        } catch (IOException
                 | ClassNotFoundException
                 | InstantiationException
                 | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should return an empty array when the subsequence is empty")
    public void testGetMaxSublistWhenSubsequenceIsEmpty() {
        PerformanceAnalysisController controller = new PerformanceAnalysisController();
        int[] subsequence = {};
        int[] expected = {};
        try {
            int[] actual = controller.getMaxSublist(subsequence);
            assertArrayEquals(expected, actual);
        } catch (IOException
                 | ClassNotFoundException
                 | InstantiationException
                 | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}