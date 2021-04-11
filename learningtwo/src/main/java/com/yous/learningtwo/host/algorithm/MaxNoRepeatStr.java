package com.yous.learningtwo.host.algorithm;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxNoRepeatStr {

    @Test
    public void test() {
        String s = "bbaa", t = "aba";

        System.out.println(minWindow(s, t));
    }


    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0, match = 0;
        while (right < s.length()) {
            Character x = s.charAt(right);
            if (targetMap.containsKey(x)) {
                window.put(x, window.getOrDefault(x, 0) + 1);
                if (window.get(x) == targetMap.get(x)) {
                    match++;
                }
            }
            right++;
            while (targetMap.size() == match) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                Character xx = s.charAt(left);
                if (targetMap.containsKey(xx)) {
                    window.put(xx, window.get(xx) - 1);
                    if (window.get(xx) < targetMap.get(xx)) {
                        match--;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(start, start + minLen);
    }

}
