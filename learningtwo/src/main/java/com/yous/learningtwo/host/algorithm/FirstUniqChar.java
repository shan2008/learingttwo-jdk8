package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {


    @Test
    public void test() {
        String s = "";
        System.out.println(firstUniqChar(s));

    }

    public char firstUniqChar(String s) {
        if (s == null) {
            return Character.MIN_VALUE;
        }

        if (s.length() == 0) {
            return " ".charAt(0);
        }


        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return s.charAt(i);
            }
        }

        return Character.MIN_VALUE;
    }


    public char firstUniqChar2(String s) {
        if (s == null) {
            return Character.MIN_VALUE;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }


        for (int i = 0; i < s.length(); i++) {
            if (map.getOrDefault(s.charAt(i), 0) == 1) {
                return s.charAt(i);
            }
        }

        return " ".charAt(0);
    }
}
