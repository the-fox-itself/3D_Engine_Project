package Objects;

import javax.swing.*;
import java.awt.*;

import static Mechanic.MainVariables.*;

public class Space extends JPanel {
    public Space(Plane p) {
        plane = p;
    }

    public Plane plane;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        double dLn1 = (plane.length*plane.distance*Math.sqrt(2)*Math.sin(Math.toRadians(Math.abs(45-plane.rotation))))/(2*(plane.distance-(Math.sin(Math.toRadians(Math.abs(45-plane.rotation))))+Math.sin(Math.toRadians(Math.abs(90-Math.abs(45-plane.rotation))))*(plane.length*Math.sqrt(2))/2));
//        double dLn2 = (plane.length*plane.distance*Math.sqrt(2)*Math.sin(Math.toRadians(Math.abs(45-plane.rotation)))+Math.sin(Math.toRadians(Math.abs(90-Math.abs(45-plane.rotation)))))/(2*(plane.distance-Math.sin(Math.toRadians(Math.abs(45-plane.rotation)))*(plane.length*Math.sqrt(2))/2));
//        double dLn3 = (plane.length*plane.distance*Math.sqrt(2)*(Math.sin(Math.toRadians(Math.abs(45-plane.rotation)))+Math.sin(Math.toRadians(Math.abs(90-Math.abs(45-plane.rotation))))))/(2*(plane.distance+(plane.length*Math.sqrt(2))/2*Math.sin(Math.toRadians(Math.abs(45-plane.rotation)))));

        int Xn1 = (int) (Math.toDegrees(Math.atan((0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/(plane.distance-(0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation)))))))*frame.getWidth()/90);
        int Xn2 = (int) (Math.toDegrees(Math.atan(((-0.5)*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/(plane.distance-(0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation)))))))*frame.getWidth()/90);
        int Xn3 = (int) (Math.toDegrees(Math.atan((0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/(plane.distance+(0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation)))))))*frame.getWidth()/90);
//        int Xn4 = (int) (Math.toDegrees(Math.atan(((-0.5)*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/(plane.distance+(0.5*plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation)))))))*frame.getWidth()/90);

        int Xn1Old = (int) ((plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/2*scalePixelsPerMeter);
        int Xn2Old = (int) ((plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/(-2)*scalePixelsPerMeter);
        int Xn3Old = (int) ((plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/2*scalePixelsPerMeter);
//        int Xn4Old = (int) ((plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/(-2)*scalePixelsPerMeter);

        System.out.println(Xn1 + " " + Xn2 + " " + Xn3);

        g.fillOval((frameSize.width/2)-5+(Xn1), frameSize.height/2-5, 10, 10);
        if (Xn2 < Xn1)
            g.fillOval((frameSize.width/2)-5+(Xn2), frameSize.height/2-5, 10, 10);
        if (Xn3 > Xn1)
            g.fillOval((frameSize.width/2)-5+(Xn3), frameSize.height/2-5, 10, 10);
//        if (Xn4 < Xn2)
//            g.fillOval((frameSize.width/2)-5+(Xn4), frameSize.height/2-5, 10, 10);

        if (Xn2 < Xn1)
            g.fillRect(frameSize.width/2+Xn2, frameSize.height/2-1, Xn1-Xn2, 2);
        if (Xn3 > Xn1)
            g.fillRect(frameSize.width/2+Xn1, frameSize.height/2-1, Xn3-Xn1, 2);


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
    }
}
