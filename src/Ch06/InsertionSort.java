package Ch06;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    static void insertionSortSentinel(int[] arr, int n) {
        for (int i = 2; i <= n; i++) {
            int j;
            arr[0] = arr[i];
            for (j = i; arr[j - 1] > arr[0]; j--)
                arr[j] = arr[j - 1];
            arr[j] = arr[0];
        }
    }

    static void binaryInsertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int[] sorted = Arrays.copyOfRange(arr, 0, i);

            // Perform a binary search to get the index into which key should be inserted
            int idx = Arrays.binarySearch(sorted, key);

            if (sorted.length == (idx * (-1)) - 1)
                continue;
            else if (idx < 0)
                idx = idx * (-1) - 1;

            // Shift from idx to i
            for (int j = i; j > idx; j--)
                arr[j] = arr[j - 1];
            arr[idx] = key;
        }
    }

    public static void main(String[] args) {
        System.out.println("Straight insertion sort");
        int[] x = {
                22, 5 ,11, 32, 120, 68, 70,
        };

        binaryInsertionSort(x, x.length);

        System.out.println("Sorting complete in ascending order.");
        for (int i = 0; i < x.length; i++)
            System.out.printf("x[%d]= %d%n", i, x[i]);
    }
}
