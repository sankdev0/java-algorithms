package com.sankdev.university.philosophers;

// В пансионе пять философов (пронумерованы от 1 до 5) обедают за круглым
// столом, где есть 5 стульев (пронумерованы от 1 до 5) и 5 вилок.
// Философ может есть только двумя вилками, т.е. одновременно
// могут обедать только два философа (заняты четыре вилки из пяти).
// Процесс бесконечный.
// Нужно реализовать это в программе с применением способа синхронизации
// "критическая секция", показать, как могут обедать философы по номерам.

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SolutionSynchronizedMethod {

    public static final int TASKS = 5; // количество философов

    public static final int SLOTS = 5; // количество стульев

    public static final Random random = ThreadLocalRandom.current();

    public static void main(String[] args) {

        Philosopher[] philosophers = new Philosopher[TASKS];
        Seat[] seats = new Seat[SLOTS];

        // заполним номера философов и стульев
        for (int i = 0; i < TASKS; i++) {
            philosophers[i] = new Philosopher(i + 1);
        }
        for (int i = 0; i < SLOTS; i++) {
            seats[i] = new Seat(i + 1);
        }



    }

}

class Seat {

    public int id;

    public boolean occupied = false;

    public boolean leftForkTaken = false;

    public boolean rightForkTaken = false;

    public Seat(int id) {
        this.id = id;
    }
}

class Philosopher {

    public int id;

    public Philosopher(int id) {
        this.id = id;
    }

    public synchronized void takeSeat(Seat theSeat) throws InterruptedException {
        theSeat.occupied = true;
        System.out.println("---> Philosopher " + this.id + " taken the seat " + theSeat.id);
        Thread.sleep(1_000);
    }

    public synchronized void takeForks(Seat theSeat) throws InterruptedException {
        theSeat.leftForkTaken = true;
        theSeat.rightForkTaken = true;
        System.out.println("--> Philosopher " + this.id + " taken the forks at the seat " + theSeat.id);
    }

    public synchronized void eat(Seat theSeat) throws InterruptedException {
        System.out.println("-> Philosopher " + this.id + " is eating at the seat " + theSeat.id);
        Thread.sleep(5_000);
        theSeat.occupied = false;
        theSeat.rightForkTaken = false;
        theSeat.leftForkTaken = false;
        System.out.println("-> Philosopher " + this.id + " finished eating at the seat " + theSeat.id);
    }
}