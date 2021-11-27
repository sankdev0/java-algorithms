package com.sankdev.sortImpl;

import com.sankdev.sort.SortService;

/**
 * Idea: pick the minimum element in the input list, then put it into the beginning of the sorted
 * list. O(N^2) efficiency, so only works for small arrays of less than 10_000 elements. Still good
 * choice for tiny arrays of about 10 elements.
 */
public class SelectionSortServiceImpl implements SortService {

  @Override
  public void sort(final int[] input) {

    for (int i = 0; i < input.length - 1; i++) {

      int minElementIndex = i;

      for (int j = i + 1; j < input.length; j++) {
        if (input[j] < input[minElementIndex]) {
          minElementIndex = j;
        }
      }

      if (minElementIndex != i) {
        int temp = input[i];
        input[i] = input[minElementIndex];
        input[minElementIndex] = temp;
      }
    }
  }
}
