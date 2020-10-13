package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.*;

public class TwoSum {


    @Test
    public void app() {
        List<Integer> l1=new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(2);
        l1.add(3);

        List<Integer> l2=new ArrayList<>();
        l2.add(4);
        l2.add(2);
        l2.add(2);


        l1.retainAll(l2);

        System.out.println(l1);


        System.out.println(reverse(-1234));

    }


    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }

            map.put(nums[i], i);
        }


        return res;
    }


    public int reverse(int x) {
        boolean flag = x > 0;
        String re = flag ? new StringBuffer(Math.abs(x)+"").reverse().toString() :
                "-" + new StringBuffer(Math.abs(x)+"").reverse().toString();

        try {
            return Integer.valueOf(re);
        } catch (Exception e) {
            return 0;
        }

    }
}
