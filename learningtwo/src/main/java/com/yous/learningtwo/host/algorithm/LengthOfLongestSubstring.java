package com.yous.learningtwo.host.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int max = 0;
        int left = 0;
        // 记录字符串和它出现的位置
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                left = Math.max(left,map.get(c[i]) + 1);
            }

            map.put(c[i], i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

}
