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



        for (String point : listOfPoints) {
            String[] coordinates = point.split(":");
            double px = Double.parseDouble(coordinates[0]);
            double py = Double.parseDouble(coordinates[1]);
            double pz = Double.parseDouble(coordinates[2]);

            int pxScreen = (int) (Math.toDegrees(Math.atan((px-camera.x)/(py-camera.y))-camera.rz)*frameSize.width/90);     //30 for human eye
            int pyScreen = (int) (Math.toDegrees(Math.atan((pz-camera.z)/(py-camera.y))-camera.rx)*frameSize.height/90);

            if (py-camera.y > 0)
                g.fillOval(frame.getWidth()/2-2+pxScreen, frame.getHeight()/2-2+pyScreen, 4, 4);
        }
    }
}
