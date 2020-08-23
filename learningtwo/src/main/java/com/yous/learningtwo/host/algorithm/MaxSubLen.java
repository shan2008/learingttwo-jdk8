package com.yous.learningtwo.host.algorithm;

import sun.security.util.Length;

import java.util.*;

/**
 * @author syou
 * @date 2020/7/9.
 */
public class MaxSubLen {

    /**
     * 输入【10,9,2,5,3,7,101,18】
     * 输出：4
     * 解释：最长上升子序列[2,3,7,101]
     * <p>
     * dp[i]表示以num[i]结尾的最长子序列
     * 如何求dp[n]? 只需要求出比以num[n]小的的最长递增子串加1就可以了
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // dp里面保存是以num[i]结尾的最长子序列
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 遍历找到最大

        int result = 0;
        for (int k = 0; k < dp.length; k++) {
            result = Math.max(result, dp[k]);
        }

        return result;
    }


    /**
     * 给定一个未排序的整数数组，找到最长递增子序列的个数。
     * 输入: [1,3,5,4,7]
     * 输出: 2
     * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
     * [1,2,4,3,5,4,7,2]
     *
     * @param nums
     * @return
     */
    public int findAllNumberOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        // dp里面保存是以num[i]结尾的最长子序列
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
        }

        // 升序
        Arrays.sort(dp);
        int count = 1;
        for (int k = dp.length - 1; k > 0; k--) {
            if (dp[k] < dp[k - 1]) {
                break;
            }
            if (dp[k] == dp[k - 1]) {
                count++;
            }
        }

        return count;
    }


    /**
     * 最长子序列的个数
     *
     * @param nums
     * @return
     */
    public int findAllNumberOfLIS2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        Arrays.sort(dp);
        int count = 0;
        for (int k = dp.length - 1; k > 0; k--) {
            if (dp[k] < dp[k - 1]) {
                break;
            }
            if (dp[k] == dp[k - 1]) {
                count++;
            }
        }

        return count;
    }


}
