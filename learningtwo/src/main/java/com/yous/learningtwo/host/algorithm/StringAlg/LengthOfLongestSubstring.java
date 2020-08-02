package com.yous.learningtwo.host.algorithm.StringAlg;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {


    @Test
    public void test() {
        String s = "abcabcdbb";
        System.out.println(lengthOfLongestSubstringStr(s));
    }

    /**
     * 最长子序列
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = -1;
        while (right < s.length()) {
            Character c1 = s.charAt(right);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            right++;

            // 如果含有，left右移动
            while (map.getOrDefault(c1, 0) > 1) {
                Character c2 = s.charAt(left);
                map.put(c2, map.get(c2) - 1);
                left++;
            }
            result = Math.max(result, right - left);
        }

        return result;
    }


    public int lengthOfLongestSubstringStr(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = -1;
        int start = 0;
        while (right < s.length()) {
            Character c1 = s.charAt(right);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            right++;

            // 如果含有，left右移动
            while (map.getOrDefault(c1, 0) > 1) {
                Character c2 = s.charAt(left);
                map.put(c2, map.get(c2) - 1);
                left++;
            }
            if (result < right - left) {
                start = left;
                result = right - left;
            }
        }

        System.out.println(s.substring(start,result+start));
        return result;
    }


    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                left = Math.max(left, map.get(array[i]) + 1);
            }
            map.put(array[i], i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

}
