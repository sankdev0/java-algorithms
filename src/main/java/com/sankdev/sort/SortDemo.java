package com.sankdev.sort;

import com.sankdev.util.ArrayUtils;
import java.util.Arrays;

public class SortDemo {

  public static void main(String[] args) {
    int[] array = ArrayUtils.fillRandomIntArray(100);

    int[] arrayCopyOne = Arrays.copyOf(array, array.length);
    int[] arrayCopyTwo = Arrays.copyOf(array, array.length);

    System.out.println("Generated array: " + array);
    System.out.println(ArrayUtils.getArrayString(array));

    //1. Use Bubble Sort
    System.out.println("1. Unsorted array: " + arrayCopyOne);
    System.out.println(ArrayUtils.getArrayString(arrayCopyOne));

    BubbleSort.sort(arrayCopyOne);

    System.out.println("1. Sorted array with Bubble Sort: " + arrayCopyOne);
    System.out.println(ArrayUtils.getArrayString(arrayCopyOne));

    // 2. Use Insertion Sort
    System.out.println("2. Unsorted array: " + arrayCopyTwo);
    System.out.println(ArrayUtils.getArrayString(arrayCopyTwo));

    InsertionSort.sort(arrayCopyTwo);

    System.out.println("2. Sorted array with Insertion Sort: " + arrayCopyTwo);
    System.out.println(ArrayUtils.getArrayString(arrayCopyTwo));

  }

}
