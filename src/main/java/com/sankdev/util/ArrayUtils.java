package com.sankdev.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayUtils {

  public static int[] fillRandomIntArray(int arraySize) {

    Random random = ThreadLocalRandom.current();

    int[] array = new int[arraySize];

    for (int i = 0; i < arraySize; i++) {
      array[i] = random.nextInt(100);
    }

    return array;
  }

  public static String getArrayString(int[] array) {
    String tempString = "";
    for (int i = 0; i < array.length; i++) {
      tempString = tempString.concat(i + " -> " + array[i] + "; ");
      tempString.substring(0, tempString.length() - 1);
    }
    return tempString;
  }

}
