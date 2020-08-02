package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindRepeatNumber {


    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            // 不等
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return -1;
    }


    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x-1] > 0) {
                nums[x-1] = -nums[x - 1];
            } else {
                result.add(x);
            }
        }

        return result;
    }


}
