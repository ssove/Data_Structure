package Ch06;

import java.util.Scanner;

public class Exercise {
    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void Q1() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("The number of elements: ");
        int n = stdIn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d]: ", i);
            arr[i] = stdIn.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
        }

        System.out.println("Sorting complete in ascending order.");
        for (int i = 0; i < n; i++)
            System.out.printf("%d  ", arr[i]);
    }

    public static void main(String[] args) {
        Q1();
    }
}
