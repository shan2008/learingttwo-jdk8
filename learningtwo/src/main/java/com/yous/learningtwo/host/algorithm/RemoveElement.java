package com.yous.learningtwo.host.algorithm;

import java.util.Arrays;

/**
 * @Author: syou
 * @Date: 2021/4/13 14:42
 */

public class RemoveElement {


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3};
        System.out.println( removeElement(nums, 2));;

        System.out.println(Arrays.toString(nums));
    }

    public  static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
