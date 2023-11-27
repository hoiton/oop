package ch.hslu.oop.sw06;

public class Main {
    public static void main(String[] args) {
        var point = new Point(1, 1);
        System.out.println("point " + point);

        var point2 = Point.fromPolarCoordinates(10, 20);
        System.out.println("Point from Polar: " + point2);

        point.moveRelative(point2);
        System.out.println("Moved point1: " + point);

        Shape shape1 = new Rectangle(1,1, 20, 20);
        Shape shape2 = new Circle(20, 1,1);

        shape2.move(10, 10);
        System.out.println(((Circle) shape2).getRadius());
    }

    /**
     * Returns the maximum of two integers
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Returns the maximum of three integers
     */
    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}