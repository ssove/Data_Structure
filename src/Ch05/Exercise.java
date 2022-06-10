package Ch05;

import Ch04.IntStack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise {
    static void Q1() {
        int result = 1;
        int n = 10;

        for (int i = 1; i <= 10; i++)
            result *= i;

        System.out.println("10! = " + result);
    }

    static void Q2() {
        int x = 22;
        int y = 11;
        int t;

        while (x % y != 0) {
            t = x;
            x = y;
            y = t % y;
        }

        System.out.println("GCD(22, 8) = " + y);
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static void Q3() {
        Random rand = new Random();
        int[] a = new int[10];
        int result;

        while (true) {
            for (int i = 0; i < a.length; i++)
                a[i] = 2 + rand.nextInt(50);

            result = a[0];
            for (int i = 1; i < a.length; i++)
                result = gcd(result, a[i]);

            if (result >= 2)
                break;
        }

        System.out.println("GCD of " + Arrays.toString(a) + " is " + result);
    }

    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            recur(n - 2);
            System.out.print(n + " ");
        }
    }

    static void iterativeRecur(int n) {
        int[]
    }

    static void Q5() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = stdIn.nextInt();

        System.out.println("Using recursion:");
        recur(n);
        System.out.println();
        System.out.println("Using iteration:");

    }

    public static void main(String[] args) {
//        Q1();
//        Q2();
//        Q3();
        Q5();
    }
}
