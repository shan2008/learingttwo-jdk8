package com.yous.learningtwo.host.algorithm.tree;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dep(root.left) - dep(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    /**
     * 树的深度
     *
     * @param root
     * @return
     */
    private int dep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dep(root.left), dep(root.right)) + 1;
    }


}
