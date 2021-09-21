package com.sankdev.sort;

import com.sankdev.util.ArrayUtils;
import java.util.Arrays;

public class SortDemo {

  public static void main(String[] args) {
    int[] array = ArrayUtils.fillRandomIntArray(100);

    int[] arrayCopy1 = Arrays.copyOf(array, array.length);
    int[] arrayCopy2 = Arrays.copyOf(array, array.length);
    int[] arrayCopy3 = Arrays.copyOf(array, array.length);
    int[] arrayCopy4 = Arrays.copyOf(array, array.length);
    int[] arrayCopy5 = Arrays.copyOf(array, array.length);
    int[] arrayCopy6 = Arrays.copyOf(array, array.length);

    System.out.println("Generated array: " + System.identityHashCode(array));
    System.out.println(ArrayUtils.getArrayString(array));

    //1. Use Bubble Sort
    System.out.println();
    System.out.println("1. Unsorted array: " + System.identityHashCode(arrayCopy1));
    System.out.println(ArrayUtils.getArrayString(arrayCopy1));

    ImprovedBubbleSort.sort(arrayCopy1);

    System.out.println("1. Sorted array with Bubble Sort: " + System.identityHashCode(arrayCopy1));
    System.out.println(ArrayUtils.getArrayString(arrayCopy1));

    // 2. Use Insertion Sort
    System.out.println();
    System.out.println("2. Unsorted array: " + System.identityHashCode(arrayCopy2));
    System.out.println(ArrayUtils.getArrayString(arrayCopy2));

    InsertionSort.sort(arrayCopy2);

    System.out.println("2. Sorted array with Insertion Sort: " + System.identityHashCode(arrayCopy2));
    System.out.println(ArrayUtils.getArrayString(arrayCopy2));

    // 3. Use Selection Sort
    System.out.println();
    System.out.println("3. Unsorted array: " + System.identityHashCode(arrayCopy3));
    System.out.println(ArrayUtils.getArrayString(arrayCopy3));

    SelectionSort.sort(arrayCopy3);

    System.out.println("3. Sorted array with Selection Sort: " + System.identityHashCode(arrayCopy3));
    System.out.println(ArrayUtils.getArrayString(arrayCopy3));

    // 4. Use Heap Sort
    System.out.println();
    System.out.println("4. Unsorted array: " + System.identityHashCode(arrayCopy4));
    System.out.println(ArrayUtils.getArrayString(arrayCopy4));

    HeapSort.sort(arrayCopy4);

    System.out.println("4. Sorted array with Heap Sort: " + System.identityHashCode(arrayCopy4));
    System.out.println(ArrayUtils.getArrayString(arrayCopy4));

    // 5. Use Heap Sort
    System.out.println();
    System.out.println("5. Unsorted array: " + System.identityHashCode(arrayCopy5));
    System.out.println(ArrayUtils.getArrayString(arrayCopy5));

    QuickSort.sort(arrayCopy5);

    System.out.println("5. Sorted array with Quick Sort: " + System.identityHashCode(arrayCopy5));
    System.out.println(ArrayUtils.getArrayString(arrayCopy5));

    // 6. Use Merge Sort
    System.out.println();
    System.out.println("6. Unsorted array: " + System.identityHashCode(arrayCopy6));
    System.out.println(ArrayUtils.getArrayString(arrayCopy6));

    MergeSort.sort(arrayCopy6);

    System.out.println("6. Sorted array with Merge Sort: " + System.identityHashCode(arrayCopy6));
    System.out.println(ArrayUtils.getArrayString(arrayCopy6));

    // Check result
    System.out.println();
    int arraysTheSame = Arrays.compare(arrayCopy1, arrayCopy2)
        + Arrays.compare(arrayCopy2, arrayCopy3)
        + Arrays.compare(arrayCopy3, arrayCopy4)
        + Arrays.compare(arrayCopy4, arrayCopy5)
        + Arrays.compare(arrayCopy5, arrayCopy6);
    System.out.println("Sorted arrays are the same: " + (arraysTheSame == 0 ? "YES." : "FALSE!"));

  }

}
