package ch.hslu.oop.sw06;

public class Circle extends Shape {
    private final int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public int getPerimeter() {
        return (int) (2d * Math.PI * (double) radius);
    }

    @Override
    public int getArea() {
        return (int) (Math.PI * Math.pow(this.radius, 2));
    }

    public int getRadius() {
        return radius;
    }
}
