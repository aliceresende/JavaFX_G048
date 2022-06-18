package app.services.algorithms.subsequence;

import java.util.Arrays;

/**
 * The type Benchmark.
 */
public class Benchmark implements Subsequence{
    /**
     * Instantiates a new Benchmark.
     */
    public Benchmark() {}

    @Override
    public int[] getSubsequence(int[] array) { return Max(array);}

    /**
     * Max int [ ].
     *
     * @param seq the seq
     * @return the int [ ]
     */
    public static int[] Max(int[] seq) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int startMaxSoFar = 0;
        int endMaxSoFar = 0;
        int startMaxEndingHere = 0;

        for(int i = 0; i < seq.length; ++i) {
            int elem = seq[i];
            int endMaxEndingHere = i + 1;
            if (maxEndingHere + elem < 0) {
                maxEndingHere = 0;
                startMaxEndingHere = i + 1;
            } else {
                maxEndingHere += elem;
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                startMaxSoFar = startMaxEndingHere;
                endMaxSoFar = endMaxEndingHere;
            }
        }

        return Arrays.copyOfRange(seq, startMaxSoFar, endMaxSoFar);
    }
}
