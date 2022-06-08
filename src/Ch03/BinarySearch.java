package Ch03;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    static int binarySearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key)
                return pc;
            else if (a[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++)
            x[i] = rand.nextInt(10);

        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        System.out.print("검색할 값: ");
        int key = stdIn.nextInt();
        int idx = binarySearch(x, num, key);

        if (idx == -1)
            System.out.println("해당 값을 찾을 수 없습니다.");
        else
            System.out.println(key + "는 x[" + idx + "]에 있습니다.");
    }
}
