package Ch05;

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

    static void Q3() {

    }

    public static void main(String[] args) {
//        Q1();
//        Q2();
    }
}
