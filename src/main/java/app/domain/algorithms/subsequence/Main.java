package app.domain.algorithms.subsequence;

import com.isep.mdis.Sum;

import java.util.Arrays;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] example = new int[]{29, -32, -9, -25, 44, 12, -61, 51, -9, 44, 74, 4};
        int[] result = Sum.Max(example);
        System.out.println(Arrays.toString(result)); // should print [51, -9, 44, 74, 4]
    }
}
