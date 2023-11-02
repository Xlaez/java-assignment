public class Point3D {
    private int x;
    private int y;
    private int z;

    public static void main(String[] args) {
        Point3D point1 = new Point3D(1, 2, 3);
        Point3D point2 = new Point3D(4, 5, 6);

        System.out.println("Point 1: " + point1);
        System.out.println("Point 2: " + point2);

        System.out.println("Distance to Origin (Point 1): " + point1.distanceToOrigin());
        System.out.println("Distance to Origin (Point 2): " + point2.distanceToOrigin());

        System.out.println("Distance between Point 1 and Point 2: " + point1.distanceToPoint(point2));

        point1.move(7, 8, 9);
        System.out.println("After moving Point 1: " + point1);

        point2.translate(1, 1, 1);
        System.out.println("After translating Point 2: " + point2);

        System.out.println("Point 1 equals Point 2: " + point1.equals(point2));
    }

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double distanceToPoint(Point3D p) {
        int deltaX = x - p.x;
        int deltaY = y - p.y;
        int deltaZ = z - p.z;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    public void move(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void translate(int dx, int dy, int dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public boolean equals(Point3D p) {
        return x == p.x && y == p.y && z == p.z;
    }
}
