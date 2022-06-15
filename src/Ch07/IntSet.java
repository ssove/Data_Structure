package Ch07;

import java.util.Arrays;

import static java.lang.Math;

public class IntSet {
    private int max;
    private int num;
    private int[] set;

    public IntSet(int capacity) {
        num = 0;
        max = capacity;
        try {
            set = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public int indexOf(int n) {
        for (int i = 0; i < num; i++)
            if (set[i] == n)
                return i;

        return -1;
    }

    public boolean contains(int n) {
        return indexOf(n) != -1;
    }

    public boolean add(int n) {
        if (num >= max || contains(n))
            return false;
        else {
            set[num++] = n;
            return true;
        }
    }

    public boolean add(IntSet s) {
        boolean isChanged = false;

        for (int i = 0; i < s.num; i++)
            if (add(s.set[i]))
                isChanged = true;

        return isChanged;
    }

    public int[] findIntersection(IntSet s) {
        int[] intersection = new int[Math.min(num, s.num) + 1];
        int idx = 0;

        if (num <= s.num) {
            for (int i = 0; i < num; i++)
                if (s.contains(set[i]))
                    intersection[idx++] = set[i];
        }
        else {
            for (int i = 0; i < s.num; i++)
                if (contains(s.set[i]))
                    intersection[idx++] = s.set[i];
        }

        if (intersection.length == 0)
            return new int[0];
        else
            return intersection;
    }

    public boolean leaveIntersection(IntSet s) {
        int[] intersection = findIntersection(s);

        if (intersection.length == 0)
            return false;

        set = Arrays.copyOfRange(intersection, 1, intersection.length);

        return true;
    }

    public boolean diff(IntSet s) {
        int[] intersection = findIntersection(s);

        if (intersection.length == 0)
            return false;


    }

    public boolean remove(int n) {
        int idx;

        if (num <= 0 || (idx = indexOf(n)) == -1)
            return false;
        else {
            set[idx] = set[--num];
            return true;
        }
    }

    public void copyTo(IntSet s) {
        int n = Math.min(s.max, num);
        System.arraycopy(set, 0, s.set, 0, n);
        s.num = n;
    }

    public void copyFrom(IntSet s) {
        int n = Math.min(s.max, num);
        System.arraycopy(s.set, 0, set, 0, n);
        num = n;
    }

    public boolean equalsTo(IntSet s) {
        if (num != s.num)
            return false;

        for (int i = 0; i < num; i++) {
            int j = 0;
            for (; j < s.num; j++)
                if (set[i] == s.set[j])
                    break;
            if (j == s.num)
                return false;
        }

        return true;
    }

    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for (int i = 0; i < s2.num; i++)
            add(s2.set[i]);
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public boolean isFull() {
        return max == num;
    }

    public void clear() {
        set = new int[max];
        num = 0;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder("{ ");
        for (int i = 0; i < num; i++)
            temp.append(set[i]).append(" ");
        temp.append("}");

        return temp.toString();
    }
}
