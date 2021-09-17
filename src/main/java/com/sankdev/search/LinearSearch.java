package com.sankdev.search;

/**
 * No information about the data (sorted or not, etc.), so read os an element does not give any info
 * about other elements. Good: - can search on any data set, sorted or not, even on streams. Bad: -
 * O(n) time efficiency.
 */
public class LinearSearch {

  public static boolean search(int[] array, int target) {

    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return true;
      }
    }

    return false;
  }

}
