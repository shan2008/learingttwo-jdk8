package com.yous.learningtwo.host.algorithm;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author syou
 * @date 2019/6/24.
 */
public class Algorithm2 {


    @Test
    public void TestfirstUniqChar() {
        List<String>list=new ArrayList<>(5);

        System.out.println(list.stream().anyMatch(o->o.equals("a")));

}

    /**
     * 首次出现一次的字符串
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() <= 0) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) == i && s.indexOf(s.charAt(i)) == i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * 输入:tree
     * 输出:"eert
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, List<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(s.charAt(i));
            } else {
                List<Character> list = new ArrayList<>();
                list.add(s.charAt(i));
                map.put(s.charAt(i), list);
            }
        }

       return map.entrySet().stream().sorted(Map.Entry.comparingByValue((l1, l2) -> {
            if (l1.size() > l2.size()) {
                return -1;
            } else if (l1.size() < l2.size()) {
                return 1;
            } else {
                return 0;
            }
        })).map(o -> o.getValue().stream().map(String::valueOf).collect(Collectors.joining()))
                .reduce((s1, s2) -> s1.concat(s2)).get();
    }
}
