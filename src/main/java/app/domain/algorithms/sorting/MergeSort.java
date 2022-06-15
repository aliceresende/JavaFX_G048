package app.domain.algorithms.sorting;

public class MergeSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {
        return new int[0];
    }

    //=================================================================================

    public static void main(String[] args) {
        String[] values = {"2021/06/16 08:20", "2020/06/16 10:20", "2020/05/28 08:20" };
        mergeSort(values, 0, values.length - 1);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

    public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }

    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;
        String[] b = new String[n];
        int i1 = from;
        int i2 = mid + 1;
        int j = 0;


        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;

        }

        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;

        }

        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;

        }

        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }

    //==================================================================================================



    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, m, r);
        }
    }

    // Merge two subarrays L and M into arr
    void merge(int arr[], int left, int middle, int right) {

        // Create Left ← A[left..middle] and Right ← A[middle+1..right]
        int n1 = middle - left + 1;
        int n2 = right - middle;


        int Left[] = new int[n1];
        int Right[] = new int[n2];


        for (int i = 0; i < n1; i++)
            Left[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            Right[j] = arr[middle + 1 + j];


        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = left;


        // Until we reach either end of either Left or Right, pick larger among
        // elements Left and Right and place them in the correct position at A[left..right]
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            } else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either Left or Right,
        // pick up the remaining elements and put in A[left..right]
        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }

}
