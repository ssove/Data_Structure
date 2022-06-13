package Ch06;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int [] a, int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = n - 1; j > i; j--)
                if (a[j - 1] > a[j])
                    swap(a, j - 1, j);
    }

    static void bubbleSortWithStop(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    exchg++;
                }
            }
            if (exchg == 0)
                break;
        }
    }

    static void bubbleSortWithCut(int[] arr, int n) {
        int k = 0;
        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > k; j--)
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            k = last;
        }
    }

    static void cocktailSort(int[] arr, int n) {
        int cnt = 1;
        int leftBound = 0;
        int rightBound = n - 1;

        while (leftBound < rightBound) {
            if (cnt % 2 != 0) {
                for (int i = rightBound; i > leftBound; i--)
                    if (arr[i] < arr[i - 1]) {
                        swap(arr, i, i - 1);
                        leftBound = i;
                    }
            }
            else {
                for (int i = leftBound; i < rightBound; i++)
                    if (arr[i] < arr[i + 1]) {
                        swap(arr, i, i + 1);
                        rightBound = i;
                    }
            }
            cnt++;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Bubble sort(Version 1)");
        System.out.print("The number of elements: ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        cocktailSort(x, n);

        System.out.println("Sorting complete in ascending order.");
        for (int i = 0; i < n; i++)
            System.out.println("x[" + i + "] = " + x[i]);

    }
}
