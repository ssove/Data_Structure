package Ch04;

public class IntAryQueue {
    private int max;
    private int num;
    private int[] queue;
    private int rear;

    public static class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() {}
    }

    public static class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() {}
    }

    public IntAryQueue(int capacity) {
        max = capacity;
        num  = rear = 0;
        try {
            queue = new int[capacity];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueue(int val) throws OverflowIntAryQueueException {
        if (num >= max)
            throw new OverflowIntAryQueueException();
        queue[rear++] = val;
        num++;

        return val;
    }

    public int dequeue() throws EmptyIntAryQueueException {
        if (num <= 0)
            throw new EmptyIntAryQueueException();
        int val = queue[0];
        if (rear - 1 > 0)
            System.arraycopy(queue, 1, queue, 0, rear - 1);

        return val;
    }

    public int peek() throws EmptyIntAryQueueException {
        if (num <= 0)
            throw new EmptyIntAryQueueException();

        return queue[0];
    }

    public int indexOf(int val) {
        for (int i = 0; i < rear; i++)
            if (queue[i] == val)
                return i;

        return -1;
    }
}
