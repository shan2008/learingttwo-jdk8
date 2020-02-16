package com.yous.learningtwo.host.algorithm.ArraySort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author syou
 * @date 2020/2/16.
 */
public class ArrayApp {
    int[] array = ArrayUtils.generateArray(10);

    @Test
    public void testSortSelect() {
        ArrayUtils.print(array);
        new SortArray().selectSort(array);
        ArrayUtils.print(array);
    }

    @Test
    public void testSortSelect2() {
        ArrayUtils.print(array);
        new SortArray().bubSort(array);
        ArrayUtils.print(array);
    }
}
