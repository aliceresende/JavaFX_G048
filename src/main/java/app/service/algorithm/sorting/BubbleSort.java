package app.service.algorithm.sorting;

import app.domain.model.PerformanceData;

import java.util.List;

public class BubbleSort implements SortAlgorithm {


    @Override
    public List<PerformanceData> sort(List<PerformanceData> input, String timeCriteria) {

        if (timeCriteria == "Arrival Time"){
            bubbleSortArrayListArrival(input);
        }else if(timeCriteria == "Leaving Time"){
            bubbleSortArrayListLeaving(input);
        }
        return null;
    }

    public void bubbleSortArrayListArrival(List<PerformanceData> list) {
        PerformanceData temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).compareToByArrivalTime(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }

    public void bubbleSortArrayListLeaving(List<PerformanceData> list) {
        PerformanceData temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).compareToByLeavingTime(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }
}
