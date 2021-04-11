package com.yous.learningtwo.host.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {


    public int minDept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDept = Integer.MAX_VALUE;
        if (root.left != null) {
            minDept = Math.min(minDept(root.left), minDept);
        }

        if (root.right != null) {
            minDept = Math.min(minDept(root.right), minDept);
        }

        return minDept + 1;
    }


    int minDep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depLen;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depLen++;
        }

        return depLen;
    }

}
