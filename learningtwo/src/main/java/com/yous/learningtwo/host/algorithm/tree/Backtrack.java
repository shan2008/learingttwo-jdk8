package com.yous.learningtwo.host.algorithm.tree;

import org.junit.Test;
import org.mvel2.util.Make;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Backtrack {
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
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }


}
