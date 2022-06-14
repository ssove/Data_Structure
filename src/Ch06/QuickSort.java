package Ch06;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(pl + pr) / 2];

        do {
            while (arr[pl] < pivot) pl++;
            while (arr[pr] > pivot) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

        if (left < pr)
            quickSort(arr, left, pr);
        if (pl < right)
            quickSort(arr, pl, right);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Quick Sort");
        System.out.print("The number of elements: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d]: ", i);
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx - 1);

        System.out.println("Sorting complete in ascending order.");
        System.out.println(Arrays.toString(x));
    }
}
