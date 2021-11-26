package com.sankdev.sortdemo;

public class MergeSort {

  // Use mergesort to sort the array.
  public static void sort(int[] array) {
    // Make a scratch array.
    int[] scratch = new int[array.length];

    // Sort.
    mergeSort(array, scratch, 0, array.length - 1);
  }

  // Use mergesort to sort the array.
  private static void mergeSort(int[] array, int[] scratch, int start, int end) {
    // If the array contains only 1 item, it is already sorted.
    if (start == end) {
      return;
    }

    // Break the array into left and right halves.
    int midpoint = (start + end) / 2;

    // Call Mergesort to sort the two halves.
    mergeSort(array, scratch, start, midpoint);
    mergeSort(array, scratch, midpoint + 1, end);

    // Merge the two sorted halves together.
    int leftIndex = start;
    int rightIndex = midpoint + 1;
    int scratchIndex = leftIndex;
    while ((leftIndex <= midpoint) && (rightIndex <= end)) {
      if (array[leftIndex] <= array[rightIndex]) {
        scratch[scratchIndex] = array[leftIndex];
        leftIndex++;
      } else {
        scratch[scratchIndex] = array[rightIndex];
        rightIndex++;
      }
      scratchIndex++;
    }

    // Finish copying whichever half is not empty.
    for (int i = leftIndex; i <= midpoint; i++) {
      scratch[scratchIndex] = array[i];
      scratchIndex++;
    }
    for (int i = rightIndex; i <= end; i++) {
      scratch[scratchIndex] = array[i];
      scratchIndex++;
    }

    // Copy the values back into the values array.
    if (end + 1 - start >= 0)
      System.arraycopy(scratch, start, array, start, end + 1 - start);
  }

}
