package com.yous.learningtwo.host.algorithm;

/**
 * @Author: syou
 * @Date: 2021/3/17 16:50
 */

public class SearchSequenceArrary {


    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左边数组有序
            if (nums[0] <= mid) {
                if (nums[0] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 右边数据有序
                if (nums[mid] <= target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

}
