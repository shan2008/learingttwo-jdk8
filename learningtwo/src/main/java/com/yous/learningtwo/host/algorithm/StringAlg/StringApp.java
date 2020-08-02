package com.yous.learningtwo.host.algorithm.StringAlg;

import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class StringApp {
    private static final SimpleDateFormat simple = new SimpleDateFormat();


    @Test
    public void testStringBuilder() {
        Map<String, String> map = new ConcurrentHashMap<>(2);
        map.put("1", "11");
        map.put("2", "22");

        map.put("1", "22");




    }


    /**
     * 最长不重复儿子串
     */
    @Test
    public void NoRepeatSubStr() {
        int max = new NoRepeatSubStr().lengthOfLongestSubstring("abba");
        System.out.println(max);

        String maxSub = new NoRepeatSubStr().maxOfLongestSubstring(" ");
        System.out.println(maxSub + ":" + maxSub.length());

        lengthOfLongestSubstring(" ");
    }


    /**
     * 2
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s == "") {
            return 1;
        }

        String result = "";
        String temp = "";
        for (String c : Arrays.asList(s.split(""))) {
            if (!temp.contains(c)) {
                temp = temp.concat(c);
            } else {
                if (temp.length() >= result.length()) {
                    result = temp;
                }
                temp = temp.substring(temp.indexOf(c) + 1).concat(c);
            }
        }


        if (temp.length() > result.length()) {
            System.out.println(temp);
            return temp.length();
        }

        System.out.println(result);

        return result.length();

    }
}
