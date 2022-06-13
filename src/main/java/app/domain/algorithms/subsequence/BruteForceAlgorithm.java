package app.domain.algorithms.subsequence;

import java.util.Arrays;

public class BruteForceAlgorithm implements Subsequence{

    public BruteForceAlgorithm(){}
    @Override
    public int[] getSubsequence(int[] array) { return Subsequence(array);}
    public static int[] Subsequence(int[] array){
        int n = array.length;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0; left < n; left++) {

            int currentSum = 0;

            for (int right = left; right < n; right++) {
                currentSum += array[right];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = left;
                    end = right;
                }
            }
        }
        return Arrays.copyOfRange(array, start, end+1);

    }
}
