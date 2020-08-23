package com.yous.learningtwo.host.algorithm.tree;

import com.yous.learningtwo.host.algorithm.tree.TreeNode;

import java.util.*;

public class LevelOrder {

    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }

}
