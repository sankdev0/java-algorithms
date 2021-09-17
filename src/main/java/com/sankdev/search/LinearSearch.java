package com.sankdev.search;

/**
 * No information about the data (sorted or not, etc.), so read os an element does not give any info
 * about other elements. Good: - can search on any data set, sorted or not, even on streams. Bad: -
 * O(n) time efficiency.
 */
public class LinearSearch {

  /**
   * Searches target in a sorted or unsorted array.
   * @param array - sorted or unsorted array.
   * @param target - target value to search for.
   * @return - index of target value or -1 if target not found.
   */
  public static int search(int[] array, int target) {

    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return i;
      }
    }

    return -1;
  }

}
