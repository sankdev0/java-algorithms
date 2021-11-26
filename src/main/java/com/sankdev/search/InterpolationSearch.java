package com.sankdev.search;

/**
 * Might be slightly more efficient than binary search. It is similar to binary search, It tries to
 * narrow search regions by guessing the region of the target based on its value. E.g.: in an array
 * of 1000 elements ov values 1-100, element value 300 is possibly somewhere around index 300, or in
 * the first 1/3 region of the array.
 * <p>
 * Good: O(log(logN)), i.e. slightly more efficient than binary search on arrays with distributions
 * close to normal and a small number of identical elements.
 * <p>
 * Bad: O(N) time efficiency when data is distributed very unevenly (worst case).
 */
public class InterpolationSearch {

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

      // Prevent division by zero when there is one element!
      if (array[min] == array[max]) {
        if (array[min] == target) {
          return min;
        }
        return -1;
      }

      // scale region by expected target location
      int mid = min + (max - min) * (target - array[min]) / (array[max] - array[min]);

      // If mid is out of bounds then the target isn't in the array.
      if (mid < min || mid > max) {
        return -1;
      }

      // Decide where to search, left or right region.
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
