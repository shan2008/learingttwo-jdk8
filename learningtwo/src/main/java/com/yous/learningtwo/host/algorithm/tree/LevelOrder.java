package com.yous.learningtwo.host.algorithm.tree;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LevelOrder {


    @Test
    public void test(){

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(7);
        root.right.left=new TreeNode(8);
        root.right.right=new TreeNode(9);
        List<Integer> result=levelRightOrder(root);

        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }




    public List<Integer> levelRightOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            result.add(list);
        }

        // 每一层取最后一个
      return result.stream().filter(x->x!=null && x.size()>0)
                .map(x->x.get(x.size()-1))
                .collect(Collectors.toList());
    }

}




