package Ch05;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n) {
        if (n > 0)
            return n * factorial(n - 1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Input a natural number: ");
        int num = stdIn.nextInt();

        System.out.println("The factorial of " + num + " is " + factorial(num));
    }
}
