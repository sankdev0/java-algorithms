package com.sankdev.sortImpl;

import com.sankdev.sort.SortService;

public class InsertionSortServiceRecursiveImpl implements SortService {

  // the recursive function
  private void recursiveSort(int[] input, int i) {

    // base case
    if (i <= 1) {
      return;
    }

    // sort the first i - 1 elements of the array.
    recursiveSort(input, i - 1);

    // find the position for the key value at position i
    int key = input[i - 1];
    int j = i - 2;

    // shift elements to the right by 1 IF input[j] > key
    while (j >= 0 && input[j] > key) {
      input[j + 1] = input[j];
      j = j - 1;
    }

    // insert the key at the appropriate position
    input[j + 1] = key;
  }

  // the wrapper for the recursive function
  @Override
  public void sort(int[] input) {
    recursiveSort(input, input.length);
  }
}
