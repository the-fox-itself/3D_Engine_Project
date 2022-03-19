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

//        double Ln1 = (plane.length*plane.distance*Math.sqrt(2)*Math.sin(Math.abs(45-plane.rotation)))/(2*(plane.distance-(Math.sin(Math.abs(45-plane.rotation)))+Math.sin(Math.abs(90-Math.abs(45-plane.rotation)))*(plane.length*Math.sqrt(2))/2));
//        System.out.println(Ln1);
//        double Ln2 = (plane.length*plane.distance*Math.sqrt(2)*Math.sin(Math.abs(45-plane.rotation))+Math.sin(Math.abs(90-Math.abs(45-plane.rotation))))/(2*(plane.distance-Math.sin(Math.abs(45-plane.rotation))*(plane.length*Math.sqrt(2))/2));
//        double Ln3 = (plane.length*plane.distance*Math.sqrt(2)*(Math.sin(Math.abs(45-plane.rotation))+Math.sin(Math.abs(90-Math.abs(45-plane.rotation)))))/(2*(plane.distance+(plane.length*Math.sqrt(2))/2*Math.sin(Math.abs(45-plane.rotation))));

        double dLn1 = (plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/2;
        double dLn2 = (plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/(-2);
        double dLn3 = (plane.length*(Math.sin(Math.toRadians(90-plane.rotation))+Math.sin(Math.toRadians(plane.rotation))))/2;
//        double dLn4 = (plane.length*(Math.sin(Math.toRadians(90-plane.rotation))-Math.sin(Math.toRadians(plane.rotation))))/(-2);

        int Ln1 = (int) (dLn1*scalePixelsPerMeter);
        int Ln2 = (int) (dLn2*scalePixelsPerMeter);
        int Ln3 = (int) (dLn3*scalePixelsPerMeter);
//        int Ln4 = (int) (dLn4*scalePixelsPerMeter);

        System.out.println(Ln1 + " " + Ln2 + " " + Ln3);

        g.fillOval((frameSize.width/2)-5+(Ln1), frameSize.height/2-5, 10, 10);
        g.fillOval((frameSize.width/2)-5+(Ln2), frameSize.height/2-5, 10, 10);
        g.fillOval((frameSize.width/2)-5+(Ln3), frameSize.height/2-5, 10, 10);
//        g.fillOval((frameSize.width/2)-5+(Ln4), frameSize.height/2-5, 10, 10);

        g.drawLine(frameSize.width/2+Ln1, frameSize.height/2, frameSize.width/2+Ln2, frameSize.height/2);
        g.drawLine(frameSize.width/2+Ln1, frameSize.height/2, frameSize.width/2+Ln3, frameSize.height/2);

//        if (plane.rotation >= 45) {
//            g.fillOval(frameSize.width / 2 + (int) (Ln1 * scalePixelsPerMeter) - 5, frameSize.height / 2 - 5, 10, 10);
//            g.fillRect(frameSize.width / 2, frameSize.height / 2, (int) (Ln1 * scalePixelsPerMeter), 1);
//        } else {
//            g.fillOval(frameSize.width / 2 - (int) (Ln1 * scalePixelsPerMeter) - 5, frameSize.height / 2 - 5, 10, 10);
//            g.fillRect(frameSize.width / 2, frameSize.height / 2, -(int) (Ln1 * scalePixelsPerMeter), 1);
//        }

//        g.fillOval(frameSize.width/2+(int) (Ln2*scalePixelsPerMeter)-5, frameSize.height/2-5, 10, 10);
//        g.fillRect(frameSize.width/2, frameSize.height/2, (int) (Ln2*scalePixelsPerMeter), 1);
//
//        g.fillOval(frameSize.width/2+(int) (Ln3*scalePixelsPerMeter)-5, frameSize.height/2-5, 10, 10);
//        g.fillRect(frameSize.width/2, frameSize.height/2, (int) (Ln3*scalePixelsPerMeter), 1);
    }
}
