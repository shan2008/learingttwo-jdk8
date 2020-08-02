package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    Map<Integer, Integer> map = new HashMap<>();


    @Test
    public void test() {
        int result = climbStairs(45);
        int result2 = climbStairs2(45);

        System.out.println(result == result2);
    }


    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (!map.containsKey(n)) {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, result);
        }

        return map.get(n);
    }


    /**
     * 遍历实现
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;

        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }

        return result;
    }
}
