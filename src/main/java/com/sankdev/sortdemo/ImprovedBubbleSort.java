package com.sankdev.sortdemo;

/**
 * Improved Bubble Sort algorithm. First, do both downward and upward passes. Second, record the
 * last swap of a previous pass and stop after the last swap of the previous pass.
 */
public class ImprovedBubbleSort {

  public static void sort(int[] array) {
    // Bounds for the items that are not yet sorted.
    int iMin = 0;
    int iMax = array.length - 1;

    // Repeat until the array is soted.
    while (iMin < iMax) {

      // Record the index of the last swapped item.
      int iLastSwap = iMin;

      // Downward pass.
      for (int i = iMin; i < iMax; i++) {
        // See if items i and i + 1 are out of order.
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          // Update the last swapped element index.
          iLastSwap = i;
        }
      }

      // Update iMax.
      iMax = iLastSwap;

      // See if we're done.
      if (iMin >= iMax) {
        break;
      }

      // Upward pass.
      iLastSwap = iMax;
      for (int i = iMax; i > iMin; i--) {
        // See if items i and i - 1 are out of order.
        if (array[i] < array[i - 1]) {
          int temp = array[i];
          array[i] = array[i - 1];
          array[i - 1] = temp;
          // Update the last swapped element index.
          iLastSwap = i;
        }
      }

      // Update iMin.
      iMin = iLastSwap;
    }
  }
}


