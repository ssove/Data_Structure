package Ch04;
import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("The number of current data: " + s.size() + " / " + s.capacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (0) 종료: ");
            int choice = stdIn.nextInt();
            if (choice == 0)
                break;

            int x;
            switch (choice) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("The stack is full.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("The popped data is " + x + ".");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("The stack is empty.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("The peeked data is " + x + ".");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("The stack is empty.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
