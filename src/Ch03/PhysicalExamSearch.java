package Ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysicalExamSearch {
    static class PhysicalData {
        private String name;
        private int height;
        private double vision;

        public PhysicalData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhysicalData> HEIGHT_ORDER
                = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysicalData> {
            public int compare(PhysicalData d1, PhysicalData d2) {
                return Integer.compare(d1.height, d2.height);
            }
        }

        public static final Comparator<PhysicalData> VISION_ORDER
                = new VisionOrderComparator();

        private static class VisionOrderComparator implements  Comparator<PhysicalData> {
            public int compare(PhysicalData d1, PhysicalData d2) {
                return Double.compare(d1.vision, d2.vision);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhysicalData[] x = {
                new PhysicalData("이나령", 162, 0.3),
                new PhysicalData("유지훈", 168, 0.4),
                new PhysicalData("김한결", 169, 0.8),
                new PhysicalData("홍준기", 171, 1.5),
                new PhysicalData("전서현", 173, 0.7),
                new PhysicalData("이호연", 174, 1.2),
                new PhysicalData("이수민", 175, 2.0),
        };
        System.out.print("몇 cm인 사람을 찾고 있나요?: ");
        int height = stdIn.nextInt();
        int idx = Arrays.binarySearch(
                x,
                new PhysicalData("", height, 0.0),
                PhysicalData.HEIGHT_ORDER
        );

        if (idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }

        System.out.print("시력이 몇인 사람을 찾고 있나요?: ");
        double vision = stdIn.nextDouble();
        idx = Arrays.binarySearch(
                x,
                new PhysicalData("", 0, vision),
                PhysicalData.VISION_ORDER
        );

        if (idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }
    }
}
