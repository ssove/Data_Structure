package Ch02;

class PhysicalData {
    static final int VMAX = 21;
    private String name;
    private int height;
    private double vision;

    PhysicalData(String name, int height, double vision) {
        this.name = name;
        this.height = height;
        this.vision = vision;
    }

    public String name() {
        return name;
    }

    public int height() {
        return height;
    }

    public double vision() {
        return vision;
    }
}
