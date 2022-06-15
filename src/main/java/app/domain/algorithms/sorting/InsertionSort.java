package app.domain.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] array) {
        return new int[0];
    }

    public static void main(String[] args) {
        int i,j;
        String key;
        String[] inputArray = {"2021/06/16 08:20", "2020/06/16 10:20", "2020/06/16 01:20", "2020/05/28 08:20" ,"2021/06/16 18:20"};
        System.out.println(Arrays.toString(inputArray));
        for (j = 1; j < inputArray.length; j++) { //the condition has changed
            key = inputArray[j];
            i = j - 1;
            while (i >= 0) {
                if (key.compareTo(inputArray[i]) > 0) {//here too
                    break;
                }
                inputArray[i + 1] = inputArray[i];
                i--;
            }
            inputArray[i + 1] = key;
            //System.out.println(Arrays.toString(inputArray));
        }
        System.out.println(Arrays.toString(inputArray));
    }


}
