package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseLeftWords {

    @Test
    public void test() {

        String s = "abcdef";
        System.out.println(reverseLeftWords(s, 6));

        String word = "how are you im fine ";


    }

    /**
     * 字符串反转
     * abcd 2
     * cdab
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() <= 0 || s.length() % n == 0) {
            return s;
        }

        return s.substring(n).concat(s.substring(0, n));
    }

    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }

        String[] array = s.trim().split(" ");
        String temp ;
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }

        return Arrays.stream(array).filter(x->x.equals("")).collect(Collectors.joining(" "));
    }


}
