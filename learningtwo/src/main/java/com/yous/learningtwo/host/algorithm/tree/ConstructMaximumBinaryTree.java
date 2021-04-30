package com.yous.learningtwo.host.algorithm.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: syou
 * @Date: 2021/4/26 14:54
 */

public class ConstructMaximumBinaryTree {


    @Test
    public void test() {
        int[] a = {3, 2, 1, 6, 0, 5};
        TreeNode node = constructMaximumBinaryTree(a);
        System.out.println(node);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        return construct(nums, 0, nums.length);
    }


    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        // 最大值的索引
        int index = maxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[index]);
        root.left = construct(nums, l, index);
        root.right = construct(nums, index + 1, r);

        return root;

    }

    private int maxIndex(int[] nums, int l, int r) {
        int maxIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }


}
