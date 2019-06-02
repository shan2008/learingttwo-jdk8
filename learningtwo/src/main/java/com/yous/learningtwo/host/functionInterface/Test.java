package com.yous.learningtwo.host.functionInterface;

import com.yous.learningtwo.host.dto.Student;

import java.rmi.Remote;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by syou on 2018/4/3.
 */
public class Test {

    public static void main(String[] args) {


    }


    public static String getPrefix(String[] strings) {
        List<String> list = Arrays.asList(strings);
        String min = list.stream().max(Comparator.comparing(o -> o.length())).get();
        for (int i = min.length(); i > 0; i--) {
            String temp = min.substring(0, i);
            if (list.stream().allMatch(o -> o.contains(temp) && o.charAt(0) == temp.charAt(0))) {
                return temp;
            }
        }

        return "";
    }


    /**
     * 最长回文数
     *
     * @param str
     * @return
     */
    public static int getHuiWen(String str) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (Character c : str.toCharArray()) {
            if (set.contains(c)) {
                count++;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }


}
