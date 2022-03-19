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

    }
    public void updateGameStats() {
        if (System.nanoTime() - lastGameStatsUpdate > 1000000) {
            space.plane.rotate(1);

            lastGameStatsUpdate = System.nanoTime();
        }
    }
}
