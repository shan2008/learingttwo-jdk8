package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Common {

    @Test
    public void test() {
        int[] num1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersect(num1, nums2);
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }


        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (countMap.containsKey(nums1[i])) {
                countMap.put(nums1[i], countMap.getOrDefault(nums1[i], 0) + 1);
            } else {
                countMap.put(nums1[i], 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (countMap.containsKey(nums2[i])) {
                result.add(nums2[i]);
                countMap.put(nums2[i], countMap.getOrDefault(nums1[i], 0) - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
