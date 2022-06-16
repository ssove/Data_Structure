package Ch09;

import java.util.Scanner;
import java.util.Comparator;

public class LinkedListTester {
    static Scanner stdIn = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        public String toString() {
            return "(" + no + ") " + name;
        }

        void scanData(String guide, int sw) {
            System.out.println("Input data to " + guide);

            if (((sw & NO) == NO)) {
                System.out.print("Number: ");
                no = stdIn.nextInt();
            }
            if (((sw & NAME) == NAME)) {
                System.out.print("Name: ");
                name = stdIn.next();
            }
        }

        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return d1.no.compareTo(d2.no);
            }
        }

        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return d1.name.compareTo(d2.name);
            }
        }
    }

    enum Menu {
        ADD_FIRST("Insert the node into head"),
        ADD_LAST("Insert the node into tail"),
        RMV_FIRST("Remove head"),
        RMV_LAST("Remove tail"),
        RMV_CRNT("Remove the selected node"),
        CLEAR("Remove all nodes"),
        SEARCH_NO("Search by the number"),
        SEARCH_NAME("Search by the name"),
        NEXT("Move to the selected node"),
        PRINT_CRNT("Print the selected node"),
        DUMP("Print all nodes"),
        TERMINATE("Terminate");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;

            return null;
        }
        Menu(String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }

    }

    static Menu selectMenu() {
        int key;

        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s   ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
                    System.out.println();
            }
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data ptr;
        Data temp = new Data();

        LinkedList<Data> list = new LinkedList<>();

        do {
            switch (menu = selectMenu()) {
                case ADD_FIRST -> {
                    data = new Data();
                    data.scanData("Insert into head", Data.NO | Data.NAME);
                    list.addFirst(data);
                }
                case ADD_LAST -> {
                    data = new Data();
                    data.scanData("Insert into tail", Data.NO | Data.NAME);
                    list.addLast(data);
                }
                case RMV_FIRST -> list.removeFirst();
                case RMV_CRNT -> list.removeCurrentNode();
                case SEARCH_NO -> {
                    temp.scanData("Searching", Data.NO);
                    ptr = list.search(temp, Data.NO_ORDER);
                    if (ptr == null)
                        System.out.println("There's no data with that number.");
                    else
                        System.out.println("Searching complete: " + ptr);
                }
                case SEARCH_NAME -> {
                    temp.scanData("Searching", Data.NAME);
                    ptr = list.search(temp, Data.NAME_ORDER);
                    if (ptr == null)
                        System.out.println("There's no data with that name.");
                    else
                        System.out.println("Searching complete: " + ptr);
                }
                case NEXT -> list.next();
                case PRINT_CRNT -> list.printCurrentNode();
                case DUMP -> list.dump();
                case RMV_LAST -> list.removeLast();
                case CLEAR -> list.clear();
            }
        } while (menu != Menu.TERMINATE);
    }
}
