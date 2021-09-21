package com.sankdev.sort;

/**
 * Idea: break the array into two parts with a dividing item. Group items less than the dividing
 * item to the left of it and items larger than the dividing value to the right of it. Then
 * recursively call it for the both parts. Good: usually O(N*logN) time efficiency and slightly
 * faster than Heap Sort. Bad: O(N^2) time efficiency in the worst case and might have deteriorating
 * space efficiency when stacks are used.
 */
public class QuickSort {

  /**
   * Use Quick Sort to sort the array.
   *
   * @param array - the array to sort.
   */
  public static void sort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  /**
   * Sort the indicated part of the array.
   *
   * @param array - the array to sort.
   * @param start - start index.
   * @param end   - end index.
   */
  public static void quickSort(int[] array, int start, int end) {

    // If the list has no more than 1 element, it's sorted.
    if (start >= end) {
      return;
    }

    // Use the first item as the dividing item.
    // Changing strategy for picking the divider is an improvement.
    int divider = array[start];

    // Move items < divider to the front of the array and
    // items >= divider to the end of the array.
    int low = start;
    int high = end;
    for (; ; ) {
      // Look down from high for a value < divider.
      while (array[high] >= divider) {
        high--;
        if (high <= low) {
          break;
        }
      }
      if (high <= low) {
        // Put the divider here and break out of the outer While loop.
        array[low] = divider;
        break;
      }

      // Move the value we found to the lower half.
      array[low] = array[high];

      // Look up from lo for a value >= divider.
      low++;
      while (array[low] < divider) {
        low++;
        if (low >= high) {
          break;
        }
      }
      if (low >= high) {
        // Put the divider here and break out of the outer While loop.
        low = high;
        array[high] = divider;
        break;
      }

      // Move the value we found to the upper half.
      array[high] = array[low];
    }

    // Recursively sort the two halves.
    quickSort(array, start, low - 1);
    quickSort(array, low + 1, end);
  }

}
