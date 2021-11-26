package com.sankdev.sortdemo;

import com.sankdev.util.ArrayUtils;

public class HeapDemo {

  public static void main(String[] args) {
    int[] array = ArrayUtils.fillRandomIntArray(12);

    // 1. Turn array into a heap.
    System.out.println("Generated array: ");
    System.out.println(ArrayUtils.getArrayString(array));

    HeapSort.makeHeap(array);

    System.out.println("Array representation of a heap: ");
    System.out.println(ArrayUtils.getArrayString(array));

    System.out.println("Removed item: " + HeapSort.removeTopItem(array, array.length));

    System.out.println("Array after the root removed: ");
    System.out.println(ArrayUtils.getArrayString(array));
  }

}
