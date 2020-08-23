package com.yous.learningtwo.host.algorithm;

public class MaxProduct {


    public int maxProduct(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int max = 1, min = 1, result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
               int temp = max;
                max = min;
                min = max;
            }

            max=Math.max(max,max*nums[i]);
            min=Math.min(min,min*nums[i]);

            result=Math.max(result,max);
        }


        return result;
    }

}
