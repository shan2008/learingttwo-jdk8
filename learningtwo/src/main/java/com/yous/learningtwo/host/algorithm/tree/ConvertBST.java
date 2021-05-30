package com.yous.learningtwo.host.algorithm.tree;

public class ConvertBST {
    private int sum;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }


    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }


    /**
     * 插入BST
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }


    /**
     * 是否在BST二叉树红字
     *
     * @param root
     * @param target
     * @return
     */
    boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target)
            return true;
        if (root.val < target)
            return isInBST(root.right, target);
        if (root.val > target)
            return isInBST(root.left, target);
        return false;
    }


    TreeNode deleteBstNode(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 左右都不为null
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteBstNode(root.right, minNode.val);
        } else if (root.val > target) {
            root.left = deleteBstNode(root.left, target);
        } else if (root.val < target) {
            root.right = deleteBstNode(root.right, target);
        }

        return root;
    }


    TreeNode getMin(TreeNode root) {
        if (root == null) return null;
        while (root.left != null)
            root = root.left;
        return root;
    }


}
