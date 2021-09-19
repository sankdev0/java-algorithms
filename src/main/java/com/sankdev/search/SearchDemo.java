package com.sankdev.search;

import com.sankdev.sort.ClassicBubbleSort;
import com.sankdev.util.ArrayUtils;

public class SearchDemo {

  public static void main(String[] args) {

    //1. Get arrays ready.
    int arraySize = 100;
    int[] array = ArrayUtils.fillRandomIntArray(arraySize);
    System.out.println("Generated array:");
    System.out.println(ArrayUtils.getArrayString(array));

    int target = 12;

    // 1. Use Linear Search.

    int targetIndex = -1;
    targetIndex = LinearSearch.search(array, target);
    System.out.println("1. Linear search result: target " + target + " "
        + (targetIndex != -1 ? "found at index " + targetIndex + "." : "not found."));

    // 2. Use Binary Search, but array MUST be sorted.

    ClassicBubbleSort.sort(array); // (!) this mutates the array.

    System.out.println("Sorted array: ");
    System.out.println(ArrayUtils.getArrayString(array));

    targetIndex = BinarySearch.search(array, target);

    System.out.println("2. Binary search result: target " + target + " "
        + (targetIndex != -1 ? "found at index " + targetIndex + "." : "not found."));


    // 3. Use Interpolation Search, the array MUST be sorted.
    targetIndex = InterpolationSearch.search(array, target);

    System.out.println("3. Interpolation Search result: target " + target + " "
      + (targetIndex != -1 ? "found at index " + targetIndex + "." : "not found."));
  }
}
