package com.yous.learningtwo.host.algorithm.tree;

/**
 * @Author: syou
 * @Date: 2021/4/23 11:55
 */

public class Flatten {

    public void flatten(TreeNode root) {
        if(root==null){
            return ;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left=root.left;
        TreeNode right=root.right;

        root.left=null;
        root.right=left;

        TreeNode p=root;
        while (p.right!=null){
            p=p.right;
        }

        p.right=right;
    }
}
