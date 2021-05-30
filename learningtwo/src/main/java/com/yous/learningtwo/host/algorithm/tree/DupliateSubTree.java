package com.yous.learningtwo.host.algorithm.tree;

import java.util.*;

public class DupliateSubTree {


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
