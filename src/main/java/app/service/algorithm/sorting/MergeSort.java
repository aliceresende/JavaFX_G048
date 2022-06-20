package app.service.algorithm.sorting;


import app.domain.model.PerformanceData;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortAlgorithm {
    private String index;

    @Override
    public List<PerformanceData> sort(List<PerformanceData> input, String timeCriteria) {
        this.index = timeCriteria;
        mergeSort(input);
        return null;
    }

    public List<PerformanceData> mergeSort(List<PerformanceData> original) {
        List<PerformanceData> left = new ArrayList<>();
        List<PerformanceData> right = new ArrayList<>();
        int center;
        if (original.size() == 1) {
            return original;
        } else {
            center = original.size() / 2;
            for (int i = 0; i < center; i++) {
                left.add(original.get(i));
            }
            for (int i = center; i < original.size(); i++) {
                right.add(original.get(i));
            }
            left = mergeSort(left);
            right = mergeSort(right);
            if(index=="Arrival Time"){
                mergeArrival(left,right,original);
            }else if(index == "Leaving Time") {
                mergeLeaving(left, right, original);
            }
        }
        return original;
    }

    private void mergeArrival(List<PerformanceData>left, List<PerformanceData>right, List<PerformanceData>original) {
        int leftIndex=0;
        int rightIndex=0;
        int originalIndex=0;

        while(leftIndex<left.size()&& rightIndex<right.size()) {

            if(left.get(leftIndex).compareToByArrivalTime(right.get(rightIndex))<0) {
                original.set(originalIndex, left.get(leftIndex));
                leftIndex++;
            }else {
                original.set(originalIndex, right.get(rightIndex));
                rightIndex++;
            }
            originalIndex++;
        }

        while(leftIndex<left.size()) {
            original.set(originalIndex, left.get(leftIndex));
            originalIndex++;
            leftIndex++;
        }
        while(rightIndex<right.size()) {
            original.set(originalIndex, right.get(rightIndex));
            originalIndex++;
            rightIndex++;
        }
    }

    private void mergeLeaving(List<PerformanceData>left, List<PerformanceData>right, List<PerformanceData>original) {
        int leftIndex=0;
        int rightIndex=0;
        int originalIndex=0;

        while(leftIndex<left.size()&& rightIndex<right.size()) {

            if(left.get(leftIndex).compareToByLeavingTime(right.get(rightIndex))<0) {
                original.set(originalIndex, left.get(leftIndex));
                leftIndex++;
            }else {
                original.set(originalIndex, right.get(rightIndex));
                rightIndex++;
            }
            originalIndex++;
        }

        while(leftIndex<left.size()) {
            original.set(originalIndex, left.get(leftIndex));
            originalIndex++;
            leftIndex++;
        }
        while(rightIndex<right.size()) {
            original.set(originalIndex, right.get(rightIndex));
            originalIndex++;
            rightIndex++;
        }
    }

}