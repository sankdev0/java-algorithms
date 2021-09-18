package com.sankdev.search;

/**
 * Half the SORTED search array on each iteration and continue searching either half based on
 * checking the middle element.
 * <p>
 * Good: O(log n) time efficiency.
 * <p>
 * Bad: only works on sorted data.
 */
public class BinarySearch {

  /**
   * Searches target in an array sorted by ascending order.
   *
   * @param array  - array sorted by ascending order.
   * @param target - target value to search for.
   * @return - index of target value or -1 if target not found.
   */
  public static int search(int[] array, int target) {

    int min = 0;
    int max = array.length - 1;

    while (min <= max) {
      int mid = (min + max) / 2;
      if (target < array[mid]) {
        max = mid - 1;
      } else if (target > array[mid]) {
        min = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

}
