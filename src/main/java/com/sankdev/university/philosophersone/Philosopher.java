package com.sankdev.university.philosophersone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {

    // Forks work as objects for syncing
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    /**
     * Helper method for simulating action
     * @param actionName
     * @throws InterruptedException
     */
    private void doAction(String actionName) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + actionName);
        Thread.sleep(ThreadLocalRandom.current().nextInt(10) * 1_00);
    }

    // General layout of a philosopher's actions
    //while(true) {
    //        think();
    //        // * DEADLOCK danger here when picking up the forks!
    //        pick_up_left_fork();
    //        pick_up_right_fork();
    //        eat();
    //        put_down_right_fork();
    //        put_down_left_fork();
    //        }

    @Override
    public void run() {

        try {
            doAction(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + " :thinking");

            synchronized(leftFork) {
                    doAction(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) +
                            " :picked up the left fork");
                // DEADLOCK danger: when all philosophers block the left fork
                synchronized(rightFork) {
                    doAction(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) +
                            " :picked up the right fork");

                    doAction(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) +
                            " :eating");

                    doAction(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) +
                            " :put down the right fork");

                }
                    doAction(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) +
                            " :putting down the left fork. Back to thinking");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
