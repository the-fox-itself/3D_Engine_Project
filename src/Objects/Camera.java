package Objects;

public class Camera extends GameObject {
    public Camera(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.rx = 0;
        this.ry = 0;
        this.rz = 0;
    }

    public Camera(double x, double y, double z, double rx, double ry, double rz) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
    }

    public double x;    //m
    public double y;    //m
    public double z;    //m

    public double rx;   //degrees
    public double ry;   //degrees
    public double rz;   //degrees
}
