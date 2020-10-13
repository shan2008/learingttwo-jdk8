package com.yous.learningtwo.host;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Test {


    @org.junit.Test
    public void test() {
        int[] a = {1, 1, 2, 2, 3, 3, 4};
        System.out.println(find(a));

        Queue queue=new LinkedList();
    }


    public int find2(int[] a) {
        if (a == null || a.length <= 0) {
            return -1;
        }

        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            res ^= a[i];
        }

        return res;
    }

    public String find(int[] a) {
        if (a == null || a.length <= 0) {
            return "";
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        StringBuilder builder = new StringBuilder();
        map.forEach((k, v) -> {
            if (v == 2) {
                builder.append(k).append(" ");
            }
        });
        return map.entrySet().stream().filter(x -> x.getValue() == 2)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

    }
}
