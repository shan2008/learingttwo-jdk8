package com.yous.learningtwo.host.algorithm.tree;

import org.junit.Test;

public class ImageTree {

    @Test
    public void Test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        mirrorTree(root);
    }


    /**
     * 二叉树镜像
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode head = root;
        swap(root);
        return head;
    }


    public void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        // 交换左右；
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        swap(root.right);
        swap(root.left);
    }

}
