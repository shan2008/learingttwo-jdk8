package com.yous.learningtwo.host.algorithm.Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SotrTwoArray {


    @Test
    public void test() {
        int[][] a = {{1, 3}, {4, 7}, {2, 9}};
       // sort(a);

        eraseOverlapIntervals(a);

        System.out.println(a);
    }


    public void sort(int[][] a) {
        Arrays.sort(a, (b1, b2) -> {
            return b1[1] - b2[1];
        });
    }


    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return -1;
        }
        // end排序
        Arrays.sort(intervals, (a1, a2) -> a1[1] - a2[1]);
        //最多不重叠的子区间的个数
        int count = 1;
        int x_end = intervals[0][1];
        for (int[] t : intervals) {
            if (t[0] >= x_end) {
                count++;
                x_end = t[1];
            }
        }
        return intervals.length-count;
    }

}
