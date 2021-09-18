package com.sankdev.sort;

public class BubbleSort {

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
