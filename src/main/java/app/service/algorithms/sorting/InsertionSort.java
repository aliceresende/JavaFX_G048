package app.service.algorithms.sorting;

public class InsertionSort implements SortAlgorithm {

    @Override
    public String[] sort(String[] input) {
        int i,j;
        String current;
        for (j = 1; j < input.length; j++) { //the condition has changed
            current = input[j];
            i = j - 1;
            while (i >= 0 && current.compareTo(input[i]) <= 0 ) {

                input[i + 1] = input[i];
                i--;
            }
            input[i + 1] = current;
            //System.out.println(Arrays.toString(input));
        }

        return input;
    }




}
