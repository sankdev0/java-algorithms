package com.sankdev.sort;

/**
 * Idea: pick the minimum element in the input list, then put it into the beginning of the sorted
 * list. O(N^2) efficiency, so only works for small arrays of less than 10_000 elements. Still good
 * choice for tiny arrays of about 10 elements.
 */
public class SelectionSort {

  public static void sort(int[] array) {

    for(int i = 0; i < array.length; i++) {
      int min = array[i];
      int minIndex = i;
      for(int j = i; j < array.length; j++) {
        if (array[j] < min) {
          min = array[j];
          minIndex = j;
        }
      }
      if (array[i] > min) {
        int temp = array[i];
        array[i] = min;
        array[minIndex] = temp;
      }
    }
  }

}
