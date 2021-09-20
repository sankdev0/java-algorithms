package com.sankdev.sort;

public class HeapSort {

  /**
   * Make the array into a heap (data structure).
   */
  public static void makeHeap(int[] array) {
    // Add each item to the heap one at a time.
    for (int i = 0; i < array.length; i++) {
      // Start at the new item and work up to the root.
      int index = i;
      while (index != 0) {
        // Find parent.
        int parent = (index - 1) / 2;
        // If child <= parent, it is a heap, so break out of the while loop.
        if (array[index] <= array[parent]) {
          break;
        }
        // Swap parent and child.
        int temp = array[index];
        array[index] = array[parent];
        array[parent] = temp;

        // Move to the parent.
        index = parent;
      }
    }
  }

  /**
   * Remove top item of a heap with count items and restore its heap property.
   * @param array - the heap
   * @param count - the heap size.
   * @return the removed top item of the heap array.
   */
  public static int removeTopItem(int[] array, int count) {

    // Save the top item.
    int result = array[0];

    // Move the last item to the root.
    array[0] = array[count - 1];

    // Restore the heap property down the tree.
    int index = 0;
    for( ; ; ) {
      // Get child items.
      int child1 = 2 * index + 1;
      int child2 = 2 * index + 2;

      // If a child index is off the end of the tree, use the parent's index.
      if (child1 >= count) {
        child1 = index;
      }
      if (child2 >= count) {
        child2 = index;
      }

      // If the heap property is satisfied, we're done.
      if (array[index] >= array[child1] && array[index] >= array[child2]) {
        break;
      }

      // Swap with child holding the larger value.
      int swapChild;

      if (array[child1] > array[child2]) {
        swapChild = child1;
      } else {
        swapChild = child2;
      }

      int temp = array[index];
      array[index] = array[swapChild];
      array[swapChild] = temp;

      // Move to the child node.
      index = swapChild;
    }

    // Return the removed top item (i.e. root).
    return result;
  }

  /**
   * Use Heap Sort to sort the array. O(N*logN) time efficiency.
   * @param array - the array to sort.
   */
  public static void sort(int[] array) {

    // Make the array into a heap.
    makeHeap(array);

    // Pop items from the root to the end of the array.
    for (int i = array.length - 1; i > 0; i--) {

      // Remove the top item and restore the heap property.
      int tempValue = removeTopItem(array, i + 1);

      // Save the top item past the end of the tree.
      array[i] = tempValue;
    }
  }
}
