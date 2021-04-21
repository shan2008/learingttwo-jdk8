package com.yous.learningtwo.host.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: syou
 * @Date: 2021/4/15 14:31
 */

public class SumSolution {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new LinkedList<>();
        dp(candidates,0,0,target,result,combine);

        return result;
    }


    public void dp(int[] condidates, int begin, int nowSum, int target,
                   List<List<Integer>> result,
                   List<Integer> combine) {
        if (nowSum == target) {
            result.add(new ArrayList<>(combine));
            return;
        }

        for (int i =begin; i < condidates.length; i++) {
            if (nowSum + condidates[i] > target) {
                break;
            }
            combine.add(condidates[i]);
            dp(condidates,i,nowSum+condidates[i],target,result,combine);
            combine.remove(combine.size()-1);
        }
    }
}
