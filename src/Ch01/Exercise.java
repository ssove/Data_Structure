package Ch01;
import java.util.Scanner;

public class Exercise {
    static int Q1(int a, int b, int c, int d) {
        int max = a;
        if (max < b) max = b;
        if (max < c) max = c;
        if (max < d) max = d;

        return max;
    }

    static int Q2(int a, int b, int c) {
        int min = a;
        if (min > b) min = b;
        if (min > c) min = c;

        return min;
    }

    static int Q3(int a, int b, int c, int d) {
        int min = Q2(a, b, c);
        if (min > d) min = d;

        return min;
    }

    static void Q7(int n) {
        StringBuilder str = new StringBuilder();
        int sum = 0;

        for (int i = 1; i < n; i++) {
            sum += i;
            str.append(i).append(" + ");
        }
        sum += n;
        str.append(n).append(" = ").append(sum);
        System.out.println(str);
    }

    static int Q8(int n) {
        if (n % 2 == 0)
            return (1 + n) * (n / 2);
        else
            return (1 + n) * (n / 2) + (n / 2 + 1);
    }

    static int Q9(int a, int b) {
        int sum = 0;
        while (a <= b) {
            sum += a;
            a++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Q1(1, 2, 3, 4));
        System.out.println(Q2(1, 2, 3));
        System.out.println(Q3(1, 2, 3, 4));
        Q7(10);
        System.out.println(Q8(10));
        System.out.println(Q9(1, 10));
    }
}
