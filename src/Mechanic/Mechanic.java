package Mechanic;

import Objects.Camera;
import Objects.Space;

import javax.swing.*;

import static Mechanic.MainVariables.*;

public class Mechanic {
    void preparation() {
        frame.setSize(frameSize.width, frameSize.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addKeyListener(new FrameKeyListener());
        frame.addMouseListener(new FrameMouseListener());
        frame.addMouseMotionListener(new FrameMouseMotionListener());
        frame.addMouseWheelListener(new FrameMouseWheelListener());

//        space = new Space(new Plane(3.5, 1, 0));
        space = new Space(new Camera(0, 0, 0));
        space.listOfPoints.add("2:2:-2");
        space.listOfPoints.add("-2:2:-2");
        space.listOfPoints.add("2:2:2");
        space.listOfPoints.add("-2:2:2");
        space.listOfPoints.add("2:4:-2");
        space.listOfPoints.add("-2:4:-2");
        space.listOfPoints.add("2:4:2");
        space.listOfPoints.add("-2:4:2");

        frame.add(space);
        space.setBounds(0, 0, (int) Math.pow(10, 6), (int) Math.pow(10, 6));

        new GameLoop().start();
    }
}
