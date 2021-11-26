package com.sankdev.sortImpl;

import com.sankdev.sort.SortService;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortServiceUnitTest {

  @Test
  public void givenUnsortedArray_whenSort_thenSortedAsc() {
    int[] input = {6, 3, 5, 2, 1, 7, 2, 4};
    SortService sortService = new BubbleSortServiceImpl();
    sortService.sort(input);
    int[] expected = {1, 2, 2, 3, 4, 5, 6, 7};
    Assert.assertArrayEquals("The two arrays are not equal", expected, input);
  }

}
