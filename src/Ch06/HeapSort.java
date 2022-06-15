package Ch06;

import java.util.Scanner;

public class HeapSort {
    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void downHeap(int[] arr, int left, int right) {
        int root = arr[left];
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int leftChild = parent * 2 + 1;
            int rightChild = leftChild + 1;

            child = (rightChild <= right && arr[rightChild] > arr[leftChild]) ? rightChild : leftChild;
            if (root >= arr[child])
                break;
            arr[parent] = arr[child];
        }
        arr[parent] = root;
    }

    static void heapSort(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)
            downHeap(arr, i, n - 1);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            downHeap(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Heap Sort");
        System.out.print("The number of elementes: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        heapSort(x, nx);

        System.out.println("Sorting complete in ascending order.");
        for (int i = 0; i < nx; i++)
            System.out.printf("x[%d] = %d%n", i, x[i]);
    }
}
