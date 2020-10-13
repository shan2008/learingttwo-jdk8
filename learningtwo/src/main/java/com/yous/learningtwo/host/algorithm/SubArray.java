package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubArray {


    @Test
    public void test() {


        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArray1(nums);

        String res = Arrays.stream(result).boxed().map(String::valueOf).
                collect(Collectors.joining(","));
        System.out.println(res);

    }


    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current + nums[i] < nums[i]) {
                current = nums[i];
            } else {
                current = current + nums[i];
            }

            if (current > res) {
                res = current;
            }

        }
        return res;
    }


    /**
     * 和最长子序列的长度
     *
     * @param nums
     * @return
     */
    public int[] maxSubArray1(int[] nums) {
        int res = nums[0];
        int current = nums[0];
        int start = 0;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (current + nums[i] < nums[i]) {
                current = nums[i];
                start = i;
                len = 1;
            } else {
                current = current + nums[i];
            }


            if (current > res) {
                res = current;
                len++;
            }
        }

        return Arrays.copyOfRange(nums, start, start+len);
    }
}
