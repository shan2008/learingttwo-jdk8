package com.yous.learningtwo.host.algorithm.tree;

import org.junit.Test;

import java.util.*;

/**
 * @author syou
 * @date 2019/6/28.
 */
public class TreeTraversal {


    @Test
    public void Test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        result.forEach(o -> System.out.print(o + ","));
        result.clear();
        System.out.println("**********************");
        midOrder(root, result);
        result.forEach(o -> System.out.print(o + ","));
        result.clear();
        System.out.println("**********************");
        postOrder(root, result);
        result.forEach(o -> System.out.print(o + ","));
        result.clear();

    }

    @Test
    public void Test2() {
        int[] nums = {2, 2, 2, 0, 2};

        System.out.println(findNumberOfLIS(nums));
    }


    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        if (nums.length == 2) {
            if (nums[0] < nums[1]) {
                return 1;
            } else {
                return 2;
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                continue;
            } else {
                count++;
            }
        }

        if (nums[nums.length - 2] >= nums[nums.length - 1]) {
            return count + 1;
        }

        return count;
    }


    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length < 0) {
            return A;
        }
        int[] result = new int[A.length];

        int start = 0;
        int end = A.length;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[start++] = A[i];
            } else {
                result[--end] = A[i];
            }
        }
        return result;
    }


    /**
     * 中序遍历
     *
     * @param node
     * @param result
     * @return
     */
    public List<Integer> postOrder(TreeNode node, List<Integer> result) {
        if (node != null) {
            if (node.left != null) {
                postOrder(node.left, result);
            }
            if (node.right != null) {
                postOrder(node.right, result);
            }
            result.add(node.val);
        }

        return result;
    }


    /**
     * 中序遍历
     *
     * @param node
     * @param result
     * @return
     */
    public List<Integer> midOrder(TreeNode node, List<Integer> result) {
        if (node != null) {
            if (node.left != null) {
                midOrder(node.left, result);
            }
            result.add(node.val);
            if (node.right != null) {
                midOrder(node.right, result);
            }
        }

        return result;
    }


    /**
     * 先序遍历
     *
     * @param root
     * @param result
     * @return
     */
    public List<Integer> preOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
        }

        if (root.left != null) {
            preOrder(root.left, result);
        }
        if (root.right != null) {
            preOrder(root.right, result);
        }

        return result;
    }


    /**
     * @param node
     * @param dep
     * @return
     */

    private Integer maxXDep(TreeNode node, Integer dep) {
        if (node == null) {
            return dep;
        }

        if (node.left != null || node.right != null) {
            dep++;
            if (node.left != null) {
                maxXDep(node.left, dep);
            }
            if (node.right != null) {
                maxXDep(node.right, dep);

            }
        }

        return dep;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            if (!stack.isEmpty() && stack.peek() == root) {
                root = root.right;
            } else {
                result.add(root.val);
                root = null;
            }
        }

        return result;

    }

}


