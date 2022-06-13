package Ch05;

public class EightQueen {
    static boolean[] flagRow = new boolean[8];
    static boolean[] flagRightUpperDiagonal = new boolean[15];
    static boolean[] flagLeftUpperDiagonal = new boolean[15];
    static int[] pos = new int[8];

    static void printBox() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pos[i] == j)
                    System.out.print("■ ");
                else
                    System.out.print("□ ");
            }
            System.out.println();
        }

        System.out.println();
    }

    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    static void clearFlag() {
        flagRow = new boolean[8];
        flagRightUpperDiagonal = new boolean[15];
        flagLeftUpperDiagonal = new boolean[15];
        pos = new int[8];
    }

    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (!flagRow[j] && !flagRightUpperDiagonal[i + j] && !flagLeftUpperDiagonal[i - j + 7]) {
                pos[i] = j;
                if (i == 7)
                    print();
                else {
                    flagRow[j] = flagRightUpperDiagonal[i + j] = flagLeftUpperDiagonal[i - j + 7] = true;
                    set(i + 1);
                    flagRow[j] = flagRightUpperDiagonal[i + j] = flagLeftUpperDiagonal[i - j + 7] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        set(0);
        clearFlag();
    }
}
