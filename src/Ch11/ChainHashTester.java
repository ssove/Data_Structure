package Ch11;

import java.util.Scanner;

import static Ch11.ChainHashTester.Menu.selectMenu;

public class ChainHashTester {
    static Scanner stdIn = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        Integer keyCode() {
            return no;
        }

        public String toString() {
            return name;
        }

        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if ((sw & NO) == NO) {
                System.out.print("Number: ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("Name: ");
                name = stdIn.next();
            }
        }
    }

    enum Menu {
        ADD("Add"),
        REMOVE("Remove"),
        SEARCH("Search"),
        DUMP("Dump"),
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

        static Menu selectMenu() {
            int key;
            do {
                for (Menu m : Menu.values())
                    System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                System.out.print(" : ");
                key = stdIn.nextInt();
            } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

            return Menu.MenuAt(key);
        }

    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data temp = new Data();

        ChainHash<Integer, Data> hash = new ChainHash<>(13);

        do {
            switch (menu = selectMenu()) {
                case ADD -> {
                    data = new Data();
                    data.scanData("Add", Data.NO | Data.NAME);
                    hash.add(data.keyCode(), data);
                }
                case REMOVE -> {
                    temp.scanData("Remove", Data.NO);
                    hash.remove(temp.keyCode());
                }
                case SEARCH -> {
                    temp.scanData("Search", Data.NO);
                    Data t = hash.search(temp.keyCode());
                    if (t != null)
                        System.out.println("그 키를 갖는 데이터는 " + t + "입니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                }
                case DUMP -> hash.dump();
            }
        } while (menu != Menu.TERMINATE);
    }
}
