package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Mechanic.MainVariables.*;

public class Space extends JPanel {
    public Space(Plane p) {
        plane = p;
    }

    public Space(Camera c) {
        camera = c;
    }

    public Plane plane;
    public Camera camera;
    public ArrayList<String> listOfPoints = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        int Xn1 = (int) (Math.toDegrees(Math.atan((0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/(plane.distance-(0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation)))))))*frame.getWidth()/90);
//        int Xn2 = (int) (Math.toDegrees(Math.atan(((-0.5)*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/(plane.distance-(0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation)))))))*frame.getWidth()/90);
//        int Xn3 = (int) (Math.toDegrees(Math.atan((0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/(plane.distance+(0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation)))))))*frame.getWidth()/90);
//        int Xn4 = (int) (Math.toDegrees(Math.atan(((-0.5)*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/(plane.distance+(0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation)))))))*frame.getWidth()/90);
//
//        int Xn1Old = (int) ((plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/2*scalePixelsPerMeter);
//        int Xn2Old = (int) ((plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/(-2)*scalePixelsPerMeter);
//        int Xn3Old = (int) ((plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/2*scalePixelsPerMeter);
//        int Xn4Old = (int) ((plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/(-2)*scalePixelsPerMeter);
//
//        g.fillOval((frameSize.width/2)-5+(Xn1), frameSize.height/2-5, 10, 10);
//        if (Xn2 < Xn1)
//            g.fillOval((frameSize.width/2)-5+(Xn2), frameSize.height/2-5, 10, 10);
//        if (Xn3 > Xn1)
//            g.fillOval((frameSize.width/2)-5+(Xn3), frameSize.height/2-5, 10, 10);
////        if (Xn4 < Xn2)
////            g.fillOval((frameSize.width/2)-5+(Xn4), frameSize.height/2-5, 10, 10);
//
//        if (Xn2 < Xn1)
//            g.fillRect(frameSize.width/2+Xn2, frameSize.height/2-1, Xn1-Xn2, 2);
//        if (Xn3 > Xn1)
//            g.fillRect(frameSize.width/2+Xn1, frameSize.height/2-1, Xn3-Xn1, 2);
//
//
//        g.fillOval((frameSize.width/2)-5+(Xn1Old), frameSize.height/2-5+100, 10, 10);
//        if (Xn2Old < Xn1Old)
//            g.fillOval((frameSize.width/2)-5+(Xn2Old), frameSize.height/2-5+100, 10, 10);
//        if (Xn3Old > Xn1Old)
//            g.fillOval((frameSize.width/2)-5+(Xn3Old), frameSize.height/2-5+100, 10, 10);
////        if (Xn4Old < Xn2Old)
////            g.fillOval((frameSize.width/2)-5+(Xn4Old), frameSize.height/2-5+100, 10, 10);
//
//        if (Xn2Old < Xn1Old)
//            g.fillRect(frameSize.width/2+Xn2Old, frameSize.height/2-1+100, Xn1Old-Xn2Old, 2);
//        if (Xn3Old > Xn1Old)
//            g.fillRect(frameSize.width/2+Xn1Old, frameSize.height/2-1+100, Xn3Old-Xn1Old, 2);


        Camera camera = space.camera;
        double cx = camera.x;
        double cy = camera.y;
        double cz = camera.z;
        double rx = camera.rx;
        double ry = camera.ry;
        double rz = camera.rz;

        int screenWidth = frame.getWidth();
        int screenHeight = frame.getHeight();
        double sensorWidth = 1;
        double sensorHeight = 1;

        double focalLength = 1;
        int skew = 1;

        for (String point : listOfPoints) {
            String[] coordinates = point.split(":");
            double px = Double.parseDouble(coordinates[0]);
            double py = Double.parseDouble(coordinates[1]);
            double pz = Double.parseDouble(coordinates[2]);

            double px1 = px - cx;
            double py1 = py - cy;
            double pz1 = pz - cz;

            double px2 = px1*Math.cos(rz) + py1*(-Math.sin(rz));
            double py2 = px1*Math.sin(rz) + py1*Math.cos(rz);
            double pz2 = pz1;

            double px3 = px2*Math.cos(ry) + py2*Math.sin(ry);
            double py3 = py2;
            double pz3 = px2*(-Math.sin(ry)) + py2*Math.cos(ry) + pz2;

            double px4 = px3;
            double py4 = py3*Math.cos(rx) + pz3*(-Math.sin(rx));
            double pz4 = py3*Math.sin(rx) + pz3*Math.cos(rx);

            double px5 = px4*((focalLength*screenWidth)/(2*sensorWidth)) + py4*skew;
            double py5 = py4*((focalLength*screenHeight)/(2*sensorHeight));
            double pz5 = -py4 + pz4;

            double finalX = px5/pz5;
            double finalY = py5/pz5;

            if (pz5 > 0)
                g.fillOval(frame.getWidth() / 2 + (int)(finalX)-4, frame.getHeight() / 2 + (int)(finalY)-4, 8, 8);

//            if (py-cy > 0) {
//                double a = Math.atan((px - cx) / (py - cy));
//                boolean a1Initialize = false;
//                double a1 = 0;
//
//                if (rz >= a - R(90) && rz <= a + R(90)) {
//                    a1Initialize = true;
//                    a1 = rz - a;
//                } else if (rz >= a - R(450) && rz <= a - R(270)) {
//                    a1Initialize = true;
//                    a1 = rz + R(360) - a;
//                } else if (rz >= a + R(270) && rz <= a + R(360)) {
//                    a1Initialize = true;
//                    a1 = rz - R(360) - a;
//                }
//
//                double b = Math.atan((pz - cz) / (Math.sqrt(Math.pow(px - cx, 2) + Math.pow(py - cy, 2))));
//                boolean b1Initialize = false;
//                double b1 = 0;
//
////            if () {
////
////            }
//
//
//                int pyScreen = (int) ((Math.atan((pz - cz) / (py - cy))) * frame.getHeight() / R(90));
//                if (a1Initialize) {
//                    int pxScreen = (int) (a1 * frame.getWidth() / R(90));     //30 for human eye
//                    g.fillOval(frame.getWidth() / 2 - 4 + pxScreen, frame.getHeight() / 2 - 4 + pyScreen, 8, 8);
//                }
//            }
        }
    }
}
