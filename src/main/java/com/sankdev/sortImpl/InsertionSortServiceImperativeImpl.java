package com.sankdev.sortImpl;

import com.sankdev.sort.SortService;

/**
 * Idea: pick element from the input list, and put it into appropriate position in the sorted list.
 * But applied to an array. O(N^2) efficiency, so only works for small arrays of less than 10_000
 * elements. Still good choice for tiny arrays of about 10 elements.
 */
public class InsertionSortServiceImperativeImpl implements SortService {

  @Override
  public void sort(int[] input) {

    // iterate through the input left to right
    for (int i = 0; i < input.length; i++) {
      // save the key value to compare against
      int key = input[i];
      // iterate the [0; i - 1) part of the input right to left
      // shift elements in the [0; i - 1] part to the right IF input[j] > key
      int j = i - 1;
      while (j >= 0 && input[j] > key) {
        input[j + 1] = input[j];
        j = j - 1;
      }
      // insert the key value to the emptied position
      input[j + 1] = key;
    }
  }
}
