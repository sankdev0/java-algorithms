package com.sankdev.sortdemo;

/**
 * Idea: imply that the array is not sorted, so any two adjacent elements might require swapping. It
 * is a classy O(N^2) algorithm. Good: this algorithm can be improved in three ways: 1. pass both up
 * and down; 2. move elements several positions, not just one; 3. stop once get to the position of
 * the last swap. For improved implementation see another example.
 */
public class AlternativeClassicBubbleSort {

  public static void sort(int[] array) {
    // Repeat until the array is sorted.
    boolean notSorted = true;
    while (notSorted) {
      // Assume there will be no swap during this pass.
      notSorted = false;
      for (int i = 1; i < array.length; i++) {
        if (array[i] < array[i - 1]) {
          int temp = array[i - 1];
          array[i - 1] = array[i];
          array[i] = temp;
          // Once the swap is done, array cannot be considered sorted any more.
          notSorted = true;
        }
      }
    }
  }


}
