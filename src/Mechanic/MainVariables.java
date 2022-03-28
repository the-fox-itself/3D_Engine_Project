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

    public static class FrameKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyChar()) {
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
                default:
                    System.out.println(e.getKeyChar());
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyChar()) {
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

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public static class FrameMouseWheelListener implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }
    }
}
