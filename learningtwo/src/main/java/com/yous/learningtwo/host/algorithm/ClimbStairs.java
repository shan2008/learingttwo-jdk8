package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClimbStairs {
    Map<Integer, Integer> map = new HashMap<>();


    @Test
    public void test() {
        Pattern p = Pattern.compile("[0-9a-zA-Z]{1,}");
        Matcher m = p.matcher("");

        int result = climbStairs(45);
        int result2 = climbStairs2(45);
        System.out.println(result);
        System.out.println(result2);

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
        for (int i = 3; i < n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }

        return result;
    }
}
