package app.service.algorithm.sorting;


import app.domain.model.PerformanceData;

import java.util.List;

public interface SortAlgorithm {
    /**
     * Sort list.
     *
     * @param input the array
     * @return the list
     */
    public List<PerformanceData> sort(List<PerformanceData> input, String timeCriteria);
}
