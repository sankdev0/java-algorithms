package com.sankdev.sortdemo;

/**
 * Idea: imply that the array is not sorted, so any two adjacent elements might require swapping. It
 * is a classy O(N^2) algorithm. Good: this algorithm can be improved in three ways: 1. pass both up
 * and down; 2. move elements several positions, not just one; 3. stop once get to the position of
 * the last swap. For improved implementation see another example.
 */
public class ClassicBubbleSort {

  public static void sort(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j + 1];
          array[j + 1] = array[j];
          array[j] = temp;
        }
      }
    }
  }
}
