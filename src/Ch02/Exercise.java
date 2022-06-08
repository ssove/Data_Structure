package Ch02;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

import static Ch02.PhysicalData.VMAX;

public class Exercise {
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }
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

    static int dayOfYear(int y, int m, int d) {
        while (m > 1) {
            d += mdays[isLeap(y)][m - 2];
            m--;
        }

        return d;
    }

    static double getAvgHeight(PhysicalData[] data) {
        double sum = 0;

        for (int i = 0; i < data.length; i++)
            sum += data[i].height();

        return sum / data.length;
    }

    static void getDistVision(PhysicalData[] data, int[] dist) {
        int i = 0;

        dist[i] = 0;
        for (i = 0; i < data.length; i++)
            if (data[i].vision() >= 0.0 && data[i].vision() <= VMAX / 10.0)
                dist[(int)(data[i].vision() * 10)]++;
    }

    static void Q8() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("그 해 경과 일수를 구합니다.");
        System.out.print("년: ");
        int year = stdIn.nextInt();
        System.out.print("월: ");
        int month = stdIn.nextInt();
        System.out.print("일: ");
        int day = stdIn.nextInt();

        System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
    }

    static int leftDayOfYear(int y, int m, int d) {
        int days = mdays[isLeap(y)][m - 1] - d;
        for (int i = m + 1; i < 12; i++)
            days += mdays[isLeap(y)][i - 1];

        return days;
    }

    static void Q9() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("그 해 경과 일수를 구합니다.");
        System.out.print("년: ");
        int year = stdIn.nextInt();
        System.out.print("월: ");
        int month = stdIn.nextInt();
        System.out.print("일: ");
        int day = stdIn.nextInt();

        System.out.printf("%d일 남았습니다.\n", leftDayOfYear(year, month, day));
    }

    static void Q10() {
        PhysicalData[] data = {
                new PhysicalData("박현규", 162, 0.3),
                new PhysicalData("함진아", 173, 0.7),
                new PhysicalData("최윤미", 175, 2.0),
                new PhysicalData("홍연의", 171, 1.5),
                new PhysicalData("이수진", 168, 0.4),
                new PhysicalData("김영준", 174, 1.2),
                new PhysicalData("박용규", 169, 0.8),
        };

        int[] vDist = new int[VMAX];
        getDistVision(data, vDist);

        for (int i = 0; i < vDist.length; i++) {
            System.out.printf("%.1f ~ : ", (double) i / 10);
            for (int j = 0; j < vDist[i]; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void Q11() {
        class YMD {
            int y;
            int m;
            int d;

            YMD(int y, int m, int d) {
                this.y = y;
                this.m = m;
                this.d = d;
            }

            YMD after(int n) {
                int year = y;
                int month = m;
                int day = d;

                while (day + n > mdays[isLeap(y)][month - 1]) {
                    n = n - (mdays[isLeap(y)][month - 1] - day);
                    day = 0;
                    month += 1;
                    if (month > 12) {
                        year += 1;
                        month = 1;
                    }
                }
                if (day == 0 && n == 0)
                    day = 1;
                day += n;

                return new YMD(year, month, day);
            }
        }

        YMD ymd = new YMD(2020, 12, 14);
        YMD temp = ymd.after(17);
        System.out.printf("%d %d %d\n", temp.y, temp.m, temp.d);
        temp = ymd.after(18);
        System.out.printf("%d %d %d\n", temp.y, temp.m, temp.d);

    }

    public static void main(String[] args) {
//        Q1();
//        Q2();
//        Q6();
//        Q7();
//        Q8();
//        Q9();
//        Q10();
//        Q11();
    }
}
