package Ch04;

public class IntQueue {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] queue;

    public static class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public static class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            queue = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueue(int val) throws OverflowIntQueueException {
        if (num >= max)
            throw new OverflowIntQueueException();
        queue[rear++] = val;
        num++;
        if (rear == max)
            rear = 0;

        return val;
    }

    public int dequeue() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        int val = queue[front++];
        num--;
        if (front == max)
            front = 0;

        return val;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return queue[front];
    }

    public int indexOf(int val) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (queue[idx] == val)
                return idx;
        }

        return -1;
    }

    public int search(int val) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (queue[idx] == val)
                return i + 1;
        }

        return 0;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("The queue is empty.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(queue[(i + front) % max] + " ");
            System.out.println();
        }
    }
}
