package Ch06;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    static void countingSort(int[] arr, int n, int max) {
        int[] cumulativeFrequency = new int[max + 1];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            cumulativeFrequency[arr[i]]++;
        for (int i = 1; i <= max; i++)
            cumulativeFrequency[i] += cumulativeFrequency[i - 1];
        for (int i = n - 1; i >= 0; i--)
            b[--cumulativeFrequency[arr[i]]] = arr[i];
        System.arraycopy(b, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Counting Sort");
        System.out.print("The number of elements: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.printf("x[%d]: ", i);
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for (int i = 1; i < nx; i++)
            if (x[i] > max)
                max = x[i];

        countingSort(x, nx, max);

        System.out.println("Sorting complete in ascending order.");
        for (int i = 0; i < nx; i++)
            System.out.printf("x[%d]= %d%n", i, x[i]);
    }
}
