package com.yous.learningtwo.host.algorithm.Array;

import java.util.Arrays;

public class RemoveCoveredIntervals {


    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a2[1] - a1[1];
            }
            return a1[0] - a2[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (left <= intervals[i][0] && right >= intervals[i][1]) {
                res++;
            }

            if (intervals[i][0] <= right && right <= intervals[i][1]) {
                right = intervals[i][1];
            }

            if (intervals[i][0] > right) {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        return intervals.length - res;
    }
}

