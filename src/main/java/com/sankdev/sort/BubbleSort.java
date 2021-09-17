package com.sankdev.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arrayToSort = new int[100];

    fillArray(arrayToSort);

    System.out.println("Array before: " + Arrays.toString(arrayToSort));

    sort(arrayToSort);

    System.out.println("Array after: " + Arrays.toString(arrayToSort));

  }

  public static void fillArray(int[] array) {

    Random random = ThreadLocalRandom.current();

    for (int i = 0; i < 100; i++) {
      array[i] = random.nextInt(100);
    }
  }

  public static void sort(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {
      // checking for swapped ONLY improves time when the array has a lot of repeating elements
      boolean swapped = false;
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) {
          swapped = true;
          int temp = array[j + 1];
          array[j + 1] = array[j];
          array[j] = temp;
        }
      }
      if (!swapped) {
        break;
      }
    }
  }
}
