package com.yous.learningtwo.host.algorithm.tree;

public class KthSmallest {
    private Integer rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }

        return midRraverse(root, k);
    }


    /**
     * 中序遍历就是升序
     *
     * @param root
     * @param k
     * @return
     */
    private int midRraverse(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        midRraverse(root.left, k);
        rank++;
        if (k == rank) {
            return root.val;
        }

        midRraverse(root.right, k);
        return -1;
    }

}
