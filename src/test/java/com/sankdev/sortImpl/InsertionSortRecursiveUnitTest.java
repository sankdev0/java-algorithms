package com.sankdev.sortImpl;

import com.sankdev.sort.SortService;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortRecursiveUnitTest {

  @Test
  public void givenUnsortedArray_whenSort_thenSortedArrayAsc() {
    int[] input = {6, 3, 5, 2, 1, 7, 2, 4};
    SortService sortService = new InsertionSortRecursive();
    sortService.sort(input);
    int[] expected = {1, 2, 2, 3, 4, 5, 6, 7};
    Assert.assertArrayEquals("The two arrays sre not equal", expected, input);

  }

}
