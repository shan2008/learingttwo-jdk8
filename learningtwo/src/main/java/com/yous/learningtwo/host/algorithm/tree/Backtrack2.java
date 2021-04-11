package com.yous.learningtwo.host.algorithm.tree;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
public class Backtrack2 {
    List<List<Integer>> res = new ArrayList<>();


    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        permute(nums);
        res.forEach(x -> {
            System.out.println(x.stream().map(g -> g + "")
                    .collect(Collectors.joining(",", "[", "]")));
        });

    }

    List<List<Integer>> permute(int[] nums) {
        backtrack2(nums, 0);
        return res;
    }


    public void backtrack2(int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(collect);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, i, index);
            backtrack2(nums, index + 1);
            swap(nums, i, index);
        }
    }


    public void swap(int[] nums, int i, int j) {
        int target = nums[i];
        nums[i] = nums[j];
        nums[j] = target;
    }
}
