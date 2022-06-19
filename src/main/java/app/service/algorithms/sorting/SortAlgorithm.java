package app.service.algorithms.sorting;

import app.domain.model.PerformanceData;

import java.util.List;

/**
 * The interface Sorting algorithm.
 */
public interface SortAlgorithm {
    /**
     * Sort list.
     *
     * @param input the array
     * @return the list
     */
    public List<PerformanceData> sort(List<PerformanceData> input, String timeCriteria);
}
