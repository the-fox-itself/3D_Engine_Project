package Mechanic;

import static Mechanic.MainVariables.*;

public class GameLoop extends Thread {
    public long lastGameStatsUpdate = System.nanoTime(); //nanoseconds

    public void run() {
        long previous = System.nanoTime(); //nanoseconds
        long steps = 0; //nanoseconds
        while (true) {
            long loopStartTime = System.nanoTime(); //nanoseconds
            long elapsed = loopStartTime - previous; //nanoseconds
            previous = System.nanoTime();
            steps += elapsed;

            handleInput();

            while (steps >= nanosecondsPerFrame) {
                updateGameStats();
                steps -= nanosecondsPerFrame;
            }

            frame.repaint();

            double loopSlot = nanosecondsPerFrame; //nanoseconds
            double endTime = loopStartTime + loopSlot; //nanoseconds
            while (System.nanoTime() < endTime) {
                try {
                    sleep(1);
                } catch (InterruptedException ignored) {}
            }
            if (stopGameLoop) {
                stopGameLoop = false;
                break;
            }
        }
    }

    public void handleInput() {
        if (a && !d) {
            space.camera.x -= 0.1;
        } else if (d && !a) {
            space.camera.x += 0.1;
        }
        if (w && !s) {
            space.camera.y += 0.1;
        } else if (s && !w) {
            space.camera.y -= 0.1;
        }
    }
    public void updateGameStats() {
//        if (System.nanoTime() - lastGameStatsUpdate > 1000000) {
//            space.plane.rotate(0.6);
//
//            lastGameStatsUpdate = System.nanoTime();
//        }
    }
}
