package ch.hslu.oop.sw06;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this(point.getX(), point.getY());
    }

    /**
     * Generates a new Point with the given polar coordinates
     * @param magnitude Distance from the origin
     * @param angle Angle in degrees
     * @return New Point with the given polar coordinates
     */
    public static Point fromPolarCoordinates(double magnitude, double angle) {
        double flippedAngle = Math.toRadians(angle);
        return new Point((int) (magnitude * Math.cos(flippedAngle)),
                (int) (magnitude * Math.sin(flippedAngle)));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Verschiebt den Punkt zu den angegebenen Koordinaten
     * @param newX Neuer X-Wert des Punktes
     * @param newY Neuer Y-Wert des Punktes
     */
    public void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Verschiebt den Punkt um die angegebenen X und Y Werte
     * @param deltaX Wert, um welchen der Punkt in der X Achse verschoben werden soll
     * @param deltaY Wert, um welchen der Punkt in der Y Achse verschoben werden soll
     */
    public void moveRelative(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Verschiebt den Punkt um die Werte des angegebenen Delta-Punktes
     * @param delta Punkt mit Werten, um welche der aktuelle Punkt verschoben werden soll
     */
    public void moveRelative(Point delta) {
        this.moveRelative(delta.getX(), delta.getY());
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
