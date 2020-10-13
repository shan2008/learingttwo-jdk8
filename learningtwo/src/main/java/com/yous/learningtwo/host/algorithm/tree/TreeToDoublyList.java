package com.yous.learningtwo.host.algorithm.tree;

import com.yous.learningtwo.host.algorithm.LinkedNode.Node;
import sun.reflect.generics.tree.Tree;

import java.util.List;

public class TreeToDoublyList {

    TreeNode head;
    TreeNode pre;
    TreeNode tail;


    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return root;
        }
        process(root);
        tail.right = head;
        head.left = tail;

        return head;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private void process(TreeNode root) {
        if (root == null) {
            return;
        }

        process(root.left);
        if (pre == null) {
            // 第一次保存头节点
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        tail = root;
        process(root.right);
    }

}
