package com.yous.learningtwo.host.algorithm;

/**
 * @Author: syou
 * @Date: 2021/3/16 12:54
 */

public class MaxArea {

    public int maxArea(int[] height) {
        if (height == null || height.length <= 0) {
            return 0;
        }
        int res = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            res = height[i] > height[j]
                    ? Math.max(res, (j - i) * height[i++])
                    : Math.max(res, (j - i) * height[j--]);

        }

        return res;
    }
}
