package com.sankdev.sortImpl;

import com.sankdev.sort.SortService;

/**
 * Idea: imply that the array is not sorted, so any two adjacent elements might require swapping. It
 * is a classy O(N^2) algorithm. Good: this algorithm can be improved in three ways: 1. pass both up
 * and down; 2. move elements several positions, not just one; 3. stop once get to the position of
 * the last swap. For improved implementation see another example.
 */
public class BubbleSortServiceImpl implements SortService {

  @Override
  public void sort(int[] input) {
    for (int i = 0; i < input.length - 1; i++) {
      for (int j = i + 1; j < input.length; j++) {
        if (input[i] > input[j]) {
          int temp = input[j];
          input[j] = input[i];
          input[i] = temp;
        }
      }
    }
  }
}
