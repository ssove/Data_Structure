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

    static void Q10() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 값: ");
        int a = stdIn.nextInt();
        int b;
        do {
            System.out.print("b의 값: ");
            b = stdIn.nextInt();
            if (b <= a)
                System.out.println("a보다 큰 값을 입력하세요.");
        } while (b <= a);

        System.out.println("b - a는 " + (b - a) + "입니다.");
    }

    static void Q11() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("양의 정수를 입력하세요: ");
        int n = stdIn.nextInt();
        int digit = 1;

        while (n / 10 != 0) {
            digit++;
            n /= 10;
        }

        System.out.println("그 수는 " + digit + "자리입니다.");
    }

    static void Q12(int n) {
        System.out.print("   |");
        for (int i = 1; i <= n; i++)
            System.out.print("  " + i);

        System.out.println();
        System.out.print("---+-");
        System.out.print("---".repeat(n - 1));
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.print(" " + i + " |");
            for (int j = 1; j<= n; j++)
                System.out.print("  " + i * j);
            System.out.println();
        }
    }

    static void Q14(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void triangleLB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void triangleLU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(" ");
            for (int j = n - i; j > 0; j--)
                System.out.print("*");
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++)
                System.out.print(" ");
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++)
                System.out.print(" ");
            for (int j = 0; j < i * 2 - 1; j++)
                System.out.print("*");
            for (int j = i; j < n; j++)
                System.out.print(" ");
            System.out.println();
        }
    }

    static void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++)
                System.out.print(" ");
            for (int j = 0; j < i * 2 - 1; j++)
                System.out.print(i);
            for (int j = i; j < n; j++)
                System.out.print(" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        System.out.println(Q1(1, 2, 3, 4));
//        System.out.println(Q2(1, 2, 3));
//        System.out.println(Q3(1, 2, 3, 4));
//        Q7(10);
//        System.out.println(Q8(10));
//        System.out.println(Q9(1, 10));
//        Q10();
//        Q11();
//        Q12(9);
//        Q14(5);
//        triangleLB(5);
//        triangleLU(5);
//        triangleRU(5);
//        triangleRB(5);
//        spira(4);
//        npira(4);
    }
}
