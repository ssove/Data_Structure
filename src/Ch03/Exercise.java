package Ch03;

import java.util.Scanner;
import java.util.Arrays;

public class Exercise {
    static int seqSearchSentinel(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;
        for (;;) {
            if (a[i] == key)
                break;
            i++;
        }

        return i == n ? -1 : i;
    }

    static void Q2() {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("검색할 값을 입력하세요: ");
        int key = stdIn.nextInt();

        System.out.print("   |");
        int[] arr = {
                6, 4, 3, 2, 1, 9, 8
        };
        for (int i = 0; i < arr.length; i++)
            System.out.print("  " + i);
        System.out.println("\n-----------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("   |");
            for (int j = 0; j <= i; j++)
                System.out.print("   ");
            System.out.println("*");
            System.out.print("  " + i + " |");
            for (int e : arr)
                System.out.print("  " + e);
            System.out.println();

            if (arr[i] == key) {
                System.out.println(key + "은(는) x[" + i + "]에 있습니다.");
                break;
            }
        }
    }

    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int j = 0;
        for (int i = 0; i < n; i++)
            if (a[i] == key)
                idx[j++] = i;

        return idx.length;
    }

    static void Q3() {
        int[] a = {
                1, 9, 2, 9, 4, 6, 7, 9
        };
        int[] idx = new int[8];
        int l = searchIdx(a, a.length, 9, idx);

        System.out.println(Arrays.toString(idx));
    }

    static int binSearchX(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                int i;
                for (i = pc - 1; i >= 0; i--)
                    if (a[i] != key)
                        return i + 1;
            }
            else if (a[pc] > key)
                pr = pc - 1;
            else
                pl = pc + 1;
        } while (pl <= pr);

        return -1;
    }

    static void Q5() {
        int[] a = {
                1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9,
        };
        int idx = binSearchX(a, a.length, 7);
        System.out.println("idx: " + idx);
    }

    static void Q7() {

    }

    public static void main(String[] args) {
//        Q2();
//        Q3();
//        Q5();
    }
}
