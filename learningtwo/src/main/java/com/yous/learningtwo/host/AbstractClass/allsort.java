package com.yous.learningtwo.host.AbstractClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: syou
 * @Date: 2021/3/18 12:58
 */
public class allsort {


    List<String> result = new ArrayList<>();
    private char[] c;


    public String[] permutation(String s) {
        if (s == null || s.length() <= 0) {
            return new String[0];
        }
        c = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }

    public void dfs(int x) {
        if (x == c.length - 1) {
            result.add(String.valueOf(c));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length - 1; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, x);
            dfs(i + 1);
            swap(i, x);
        }

    }


    public void swap(int i, int x) {
        Character tmp = c[i];
        c[i] = c[x];
        c[x] = tmp;
    }






}
