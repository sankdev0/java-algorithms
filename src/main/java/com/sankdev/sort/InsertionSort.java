package com.sankdev.sort;

/**
 * Idea: pick element from the input list, and put it into appropriate position in the sorted list.
 * But applied to an array.
 * O(N^2) efficiency, so only works for small arrays of less than 10_000 elements.
 * Still good choice for tiny arrays of about 10 elements.
 */
public class InsertionSort {

  public static void sort(int[] array) {

    for (int i = 1; i < array.length; i++) {
      int j = i;
      while (j > 0 && array[j - 1] > array[j]) {
        // swap
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;

        j = j - 1;
      }
    }
  }
}
