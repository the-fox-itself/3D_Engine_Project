package Mechanic;

import Objects.Plane;
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

        space = new Space(new Plane(3, 1, 0));

        frame.add(space);
        space.setBounds(0, 0, (int) Math.pow(10, 6), (int) Math.pow(10, 6));

        new GameLoop().start();
    }
}
