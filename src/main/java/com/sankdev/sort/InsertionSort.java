package com.sankdev.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InsertionSort {

	public static void main(String[] args) {

		int[] array = new int[100];

		fillArray(array);

		System.out.println("Unsorted array: \n" + Arrays.toString(array));

		sortArray(array);

		System.out.println("Sorted array: \n" + Arrays.toString(array));
	}

	private static void sortArray(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j - 1] > array[j]) {
				// swap
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				
				j = j - 1;
			}
		}
	}

	private static void fillArray(int[] array) {

		Random random = ThreadLocalRandom.current();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(200);
		}
	}

}
