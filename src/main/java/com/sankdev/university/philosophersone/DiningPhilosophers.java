package com.sankdev.university.philosophersone;

// В пансионе пять философов (пронумерованы от 1 до 5) обедают за круглым
// столом, где есть 5 стульев (пронумерованы от 1 до 5) и 5 вилок.
// Философ может есть только двумя вилками, т.е. одновременно
// могут обедать только два философа (заняты четыре вилки из пяти).
// Процесс бесконечный.
// Нужно реализовать это в программе с применением способа синхронизации
// "критическая секция", показать, как могут обедать философы по номерам.

import java.util.concurrent.ThreadLocalRandom;

public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {
    Philosopher[] philosophers = new Philosopher[5];
    Object[] forks = new Object[philosophers.length];

    for (int i = 0; i < forks.length; i++) {
      forks[i] = new Object();
    }

    for (int i = 0; i < philosophers.length; i++) {
      Object leftFork = forks[i];
      Object rightFork = forks[(i + 1) % forks.length];

      if (i == philosophers.length - 1) {
        // The last philosopher picks up the right fork first
        // to avoid deadlock when all philosophers puck their left forks
        philosophers[i] = new Philosopher(rightFork, leftFork);
      } else {
        philosophers[i] = new Philosopher(leftFork, rightFork);
      }
    }

    int counter = 0;
    final int stopCount = 20;
    while (true) {
      counter++;

      int i = ThreadLocalRandom.current().nextInt(philosophers.length) % philosophers.length;

      Thread thread = new Thread(philosophers[i], "Philosopher " + (i + 1));
      thread.start();
      Thread.sleep(1_000);
      if (counter == stopCount) {
        break;
      }
    }
  }
}