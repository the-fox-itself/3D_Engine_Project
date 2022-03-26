package Mechanic;

import Objects.Space;

import javax.swing.*;
import java.awt.*;

public class MainVariables {
    public static int targetFPS = 144;
    public static double nanosecondsPerFrame = (1000d / targetFPS) * Math.pow(10, 6);
    public static boolean stopGameLoop = false;

    public static JFrame frame = new JFrame();
    public static Dimension frameSize = new Dimension(800, 800);

    public static Space space;

    public static int scalePixelsPerMeter = 150;
}
