package Ch05;

import java.util.Scanner;

public class Hanoi {
    static void move(int no, int start, int dest) {
        if (no > 1)
            move(no - 1, start, 6 - start - dest);
        System.out.println("Moving disc[" + no + "] from " + start + " to " + dest);
        if (no > 1)
            move(no - 1, 6 - start - dest, dest);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Input the number of discs: ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}
