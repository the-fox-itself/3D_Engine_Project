package Mechanic;

import Objects.Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainVariables {
    public static int targetFPS = 144;
    public static double nanosecondsPerFrame = (1000d / targetFPS) * Math.pow(10, 6);
    public static boolean stopGameLoop = false;

    public static JFrame frame = new JFrame();
    public static Dimension frameSize = new Dimension(800, 800);

    public static Space space;

    public static int scalePixelsPerMeter = 150;

    public static boolean w;
    public static boolean a;
    public static boolean s;
    public static boolean d;
    public static boolean t;
    public static boolean spacePressed;
    public static boolean shift;

    public static Point mouseLocation;

    public static class FrameKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case 'w':
                case 'W':
                case 'ц':
                case 'Ц':
                    if (!w)
                        w = true;
                    break;
                case 'a':
                case 'A':
                case 'ф':
                case 'Ф':
                    if (!a)
                        a = true;
                    break;
                case 's':
                case 'S':
                case 'ы':
                case 'Ы':
                    if (!s)
                        s = true;
                    break;
                case 'd':
                case 'D':
                case 'в':
                case 'В':
                    if (!d)
                        d = true;
                    break;
                case 'n':
                case 'N':
                case 'т':
                case 'Т':
                    if (!t)
                        t = true;
                    break;
                case ' ':
                    if (!spacePressed)
                        spacePressed = true;
                    break;
                case 0x10:
                    if (!shift)
                        shift = true;
                    break;
                default:
                    System.out.println(e.getKeyChar());
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case 'w':
                case 'W':
                case 'ц':
                case 'Ц':
                    if (w)
                        w = false;
                    break;
                case 'a':
                case 'A':
                case 'ф':
                case 'Ф':
                    if (a)
                        a = false;
                    break;
                case 's':
                case 'S':
                case 'ы':
                case 'Ы':
                    if (s)
                        s = false;
                    break;
                case 'd':
                case 'D':
                case 'в':
                case 'В':
                    if (d)
                        d = false;
                    break;
                case 'n':
                case 'N':
                case 'т':
                case 'Т':
                    if (t)
                        t = false;
                    break;
                case ' ':
                    if (spacePressed)
                        spacePressed = false;
                    break;
                case 0x10:
                    if (shift)
                        shift = false;
                    break;
                default:
                    System.out.println(e.getKeyChar());
                    break;
            }
        }
    }

    public static class FrameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static class FrameMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            double dx = e.getX() - mouseLocation.x;
            double dy = e.getY() - mouseLocation.y;
            mouseLocation = e.getPoint();

            space.camera.rz += dx/100;
            space.camera.rx += dy/100;
            System.out.println(space.camera.rz + " " + space.camera.rx);
            if (space.camera.rz > 2*Math.PI) {
                space.camera.rz -= 2*Math.PI;
            }
            if (space.camera.rx > 2*Math.PI) {
                space.camera.rx -= 2*Math.PI;
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseLocation = e.getPoint();
        }
    }

    public static class FrameMouseWheelListener implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }
    }
}
