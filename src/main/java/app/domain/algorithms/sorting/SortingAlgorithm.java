package app.domain.algorithms.sorting;

import java.util.List;

/**
 * The interface Sorting algorithm.
 */
public interface SortingAlgorithm {
    /**
     * Sort list.
     *
     * @param array the array
     * @return the list
     */
    public List<List<String>> sort(String[] array);
}
