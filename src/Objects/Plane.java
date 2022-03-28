package Objects;

import static Mechanic.MainVariables.*;

public class Plane extends GameObject {
    public Plane(double d, double l, double r) {
        distance = d;
        length = l;
        rotation = r;
        while (rotation > R(90)) {
            rotation -= R(90);
        }
    }

    public void rotate(double degrees) {
        rotation += degrees;
        while (rotation > R(90)) {
            rotation -= R(90);
        }
    }

    public void further(double meters) {
        distance += meters;
    }

    public double distance;     //m
    public double length;       //m
    public double rotation;     //radians
}
