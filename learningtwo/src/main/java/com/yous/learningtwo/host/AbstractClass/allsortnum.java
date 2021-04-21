package com.yous.learningtwo.host.AbstractClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: syou
 * @Date: 2021/3/18 13:07
 */
public class allsortnum {

    List<List<Integer>> result = new ArrayList<>();


    public void permute(int[] nums) {
        LinkedList linkedList = new LinkedList<Integer>();
        backtrack(nums, linkedList);
    }

    public void backtrack(int[] nums, LinkedList linkedList) {
        if (linkedList.size() == nums.length) {
            result.addAll(linkedList);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (linkedList.contains(nums[i])) {
                continue;
            }

            linkedList.add(nums[i]);
            backtrack(nums, linkedList);
            linkedList.removeLast();
        }
    }

}
