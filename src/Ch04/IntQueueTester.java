package Ch04;

import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue q = new IntQueue(64);

        while (true) {
            System.out.println("The number of current data: " + q.size() + " / " + q.capacity());
            System.out.print("(1)Enqueue (2)Dequeue (3)Peek (4)Dump (0)Exit: ");
            int choice = stdIn.nextInt();
            if (choice == 0)
                break;
            int x;

            switch (choice) {
                case 1:
                    System.out.print("Data: ");
                    x = stdIn.nextInt();
                    try {
                        q.enqueue(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("The queue is full.");
                    }
                    break;

                case 2:
                    try {
                        x = q.dequeue();
                        System.out.println("The dequeued data is " + x + ".");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("The queue is empty.");
                    }
                    break;

                case 3:
                    try {
                        x = q.peek();
                        System.out.println("The peeked data is " + x + ".");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("The queue is empty.");
                    }
                    break;

                case 4:
                    q.dump();
                    break;
            }
        }
    }
}
