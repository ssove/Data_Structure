package Ch02;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Exercise {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void swap(char[] a, int idx1, int idx2) {
        char t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static int sumOf(int[] a) {
        int sum = 0;
        for (int i : a) sum += i;

        return sum;
    }

    static void copy(int[] a, int[] b) {
        if (a.length != b.length) {
            System.out.println("배열들의 크기가 같지 않아 요소를 복사할 수 없습니다.");
            return;
        }

        for (int i = 0; i < b.length; i++)
            a[i] = b[i];
    }

    static void rcopy(int[] a, int[] b) {
        if (a.length != b.length) {
            System.out.println("배열들의 크기가 같지 않아 요소를 복사할 수 없습니다.");
            return;
        }

        for (int i = 0; i < b.length; i++)
            a[i] = b[b.length - i - 1];
    }

    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dChar.charAt(x % r);
            x /= r;
        } while (x > 0);
        for (int i = 0; i < digits / 2; i++)
            swap(d, i, digits - i - 1);

        return digits;
    }

    static void Q1() {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        int numOfPeople = 1 + rand.nextInt(20);
        int[] height = new int[numOfPeople];

        System.out.println("사람 수: " + numOfPeople);
        System.out.println("키 값은 아래와 같습니다.");
        for (int i = 0; i < numOfPeople; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }

    static void Q2() {
        Random rand = new Random();
        int randLength = 4 + rand.nextInt(10);
        int[] array = new int[randLength];

        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100);

        for (int i = 0; i < randLength / 2; i++) {
            System.out.println(Arrays.toString(array));
            System.out.println("a[" + i + "]과(와) a[" + (randLength - i - 1) + "]를 교환합니다.");
            swap(array, i, randLength - i - 1);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    static void Q6() {
        char[] d = new char[32];
        int digits = cardConv(59, 2, d);
        System.out.println(Arrays.toString(d));
    }

    static void Q7() {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("10진수를 기수 변환합니다.");
        int num = 1 + rand.nextInt(100);
        System.out.println("변환하는 음이 아닌 정수: " + num);
        int cd = 2 + rand.nextInt(35);
        System.out.println("어떤 진수로 변환할까요? (2~36): " + cd);
        System.out.println();

        int digits = 0;
        String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] d = new char[50];

        do {
            System.out.print(cd + " |       " + num);
            d[digits] = dChar.charAt(num % cd);
            if (digits != 0) System.out.print("   ..." + d[digits - 1]);
            System.out.println("\n  + ----------");
            digits++;
            num /= cd;
        } while (num > 0);
        System.out.println("           " + num + "   ..." + d[digits - 1]);
        for (int i = 0; i < digits / 2; i++)
            swap(d, i, digits - i - 1);

        System.out.print(cd + "진수로 ");
        for (int i = 0; i < digits; i++)
            System.out.print(d[i]);
        System.out.println("입니다.");
    }

    public static void main(String[] args) {
//        Q1();
//        Q2();
//        Q6();
        Q7();
    }
}
