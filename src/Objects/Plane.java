package Objects;

public class Plane extends GameObject {
    public Plane(double d, double l, double r) {
        distance = d;
        length = l;
        rotation = r;
        while (rotation >= 90) {
            rotation -= 90;
        }
    }

    public void rotate(double degrees) {
        rotation += degrees;
        while (rotation >= 90) {
            rotation -= 90;
        }
    }

    public double distance;     //m
    public double length;       //m
    public double rotation;     //degrees
}
