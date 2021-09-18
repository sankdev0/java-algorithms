package com.sankdev.search;

import com.sankdev.sort.BubbleSort;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SearchDemo {

  private int[] fillRandomIntArray(int arraySize) {

    Random random = ThreadLocalRandom.current();

    int[] array = new int[arraySize];

    for (int i = 0; i < arraySize; i++) {
      array[i] = random.nextInt(100);
    }

    return array;
  }

  private void printArray(int[] array) {
    String line = "";
    for (int i = 0; i < array.length; i++) {
      line = line.concat(i + " -> " + array[i] + "; ");
      line.substring(0, line.length() - 1);
    }
    System.out.print(line);
    System.out.println();

  }

  public static void main(String[] args) {

    SearchDemo demo = new SearchDemo();

    //1. Get arrays ready.
    int arraySize = 100;
    int[] array = demo.fillRandomIntArray(arraySize);
    System.out.println("Generated array:");
    demo.printArray(array);

    int target = 12;

    // 1. Use Linear Search.

    int targetIndex = -1;
    targetIndex = LinearSearch.search(array, target);
    System.out.println("1. Linear search result: target " + target + " "
        + (targetIndex != -1 ? "found at index " + targetIndex + "." : "not found."));

    // 2. Use Binary Search, but array MUST be sorted.

    BubbleSort.sort(array); // (!) this mutates the array.

    System.out.println("Sorted array: ");
    demo.printArray(array);

    targetIndex = BinarySearch.search(array, target);

    System.out.println("2. Binary search result: target " + target + " "
        + (targetIndex != -1 ? "found at index " + targetIndex + "." : "not found."));


    // 3. Use Interpolation Search, the array MUST be sorted.
    targetIndex = InterpolationSearch.search(array, target);

    System.out.println("3. Interpolation Search result: target " + target + " "
      + (targetIndex != -1 ? "found at index " + targetIndex + "." : "not found."));
  }
}
