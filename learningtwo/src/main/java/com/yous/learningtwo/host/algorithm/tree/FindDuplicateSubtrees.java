package com.yous.learningtwo.host.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: syou
 * @Date: 2021/4/30 10:13
 */

public class FindDuplicateSubtrees {

    //      1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        findDuplicateSubtrees(root);



        result.stream().forEach(x-> System.out.println(x.val));
        System.out.println(result);
        System.out.println("");


    }


    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return result;
        }
        subResult(root);
        return result;
    }

    private String subResult(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = subResult(root.left);
        String right = subResult(root.right);
        String subStr = left + "," + right + "," + root.val;

        int count = map.getOrDefault(subStr, 0);
        if (count == 1) {
            result.add(root);
        }

        map.put(subStr, count + 1);
        return subStr;
    }


}
