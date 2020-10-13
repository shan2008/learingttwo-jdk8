package com.yous.learningtwo.host.algorithm;

import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MakeSquare {

    @Test
    public void testApp() {

        int[] nums = {1, 1, 2, 2, 2};
        System.out.println(makeSquare(nums));
    }

    public boolean makeSquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) {
            return false;
        }
        // 从大到小
        Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(nums2,Comparator.reverseOrder());
        int[] bucket = new int[4];
        return makeOk(0, nums2, sum / 4, bucket);
    }


    /**
     * @param i      第几根火柴
     * @param nums
     * @param edge   正方形的边长
     * @param bucket
     */
    public boolean makeOk(int i, Integer[] nums, int edge, int[] bucket) {
        // 火柴放完了
        if (i >= nums.length) {
            return true;
        }
        for (int j = 0; j < bucket.length; j++) {
            if (nums[i] + bucket[j] > edge) {
                continue;
            }
            // 放入火柴
            bucket[j] += nums[i];
            // 放下一根火柴
            if (makeOk(i + 1, nums, edge, bucket)) {
                return true;
            }
            // 退回重放
            bucket[j] -= nums[i];
        }

        return false;
    }


}
