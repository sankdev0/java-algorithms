package com.sankdev.search;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SearchDemo {

  private int[] fillRandomIntArray(int arraySize) {

    Random random = ThreadLocalRandom.current();

    int[] array = new int[arraySize];

    for (int i = 0; i < arraySize; i++) {
      array[i] = random.nextInt(1_000);
    }

    return array;
  }

  public static void main(String[] args) {

    SearchDemo demo = new SearchDemo();

    //1. Get arrays ready.
    int arraySize = 100;
    int[] array = demo.fillRandomIntArray(arraySize);
    System.out.println("Generated array:");
    System.out.println(Arrays.toString(array));

    int target = 10;

    boolean targetFound = LinearSearch.search(array, target);
    System.out.println(
        "1. Linear search result: target " + target + " " + (targetFound ? "found" : "not found"));

  }
}
