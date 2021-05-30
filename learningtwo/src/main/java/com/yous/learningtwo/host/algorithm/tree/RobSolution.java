package com.yous.learningtwo.host.algorithm.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RobSolution {

    private Map<TreeNode, Integer> map = new HashMap<>();
    int[] dp;

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int robIt = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int notRob = rob(root.left) + rob(root.right);
        int res = Math.max(robIt, notRob);
        map.put(root, res);
        return res;
    }


    public int rub2(int[] nums) {


        if (nums == null) {
            return 0;
        }
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return doDub(nums, 0);
    }


    public int doDub(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }

        int res = Math.max(doDub(nums, start + 1),
                nums[start] + doDub(nums, start + 2));
        dp[start] = res;
        return res;
    }


}
