package com.yous.learningtwo.host.algorithm.StringAlg;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubStr {

    /**
     * 无重复子串最大长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
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


    /**
     * 无重复子串最大长度
     *
     * @param str
     * @return
     */
    public String maxOfLongestSubstring(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }

        String[] sArray = str.split("");
        StringBuffer temp = new StringBuffer("");
        String result = "";
        for (String s : sArray) {
            if (temp.indexOf(s) != -1) {
                if (temp.length() > result.length()) {
                    result = temp.toString();
                }
                String newTemp = temp.substring(temp.indexOf(s) + 1);
                temp.setLength(0);
                temp.append(newTemp).append(s);

            } else {
                temp = temp.append(s);
            }
        }

        if (temp.length() > result.length()) {
            result = temp.toString();
        }

        return result;
    }
}
