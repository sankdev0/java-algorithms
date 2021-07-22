package com.sankdev.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] array = new int[100];
		
		fillArray(array);
		
		System.out.println("Unsorted array:");
		System.out.println(Arrays.toString(array));
		
		sortArray(array);
		
		System.out.println("Sorted array");
		System.out.println(Arrays.toString(array));

	}

	private static void sortArray(int[] array) {
		
	}

	private static void fillArray(int[] array) {

		Random random = ThreadLocalRandom.current();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
	}
	

}
