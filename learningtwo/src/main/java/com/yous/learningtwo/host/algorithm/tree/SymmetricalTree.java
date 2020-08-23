package com.yous.learningtwo.host.algorithm.tree;

public class SymmetricalTree {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode pNode1, TreeNode pNode2) {
        if (pNode1 == null && pNode2 == null) {
            return true;
        }
        if (pNode2 == null || pNode1 == null) {
            return false;
        }

        // 两个都不为null;
        return pNode1.val == pNode2.val
                && isSymmetric(pNode1.left, pNode2.right)
                && isSymmetric(pNode1.right, pNode2.left);

    }


}
