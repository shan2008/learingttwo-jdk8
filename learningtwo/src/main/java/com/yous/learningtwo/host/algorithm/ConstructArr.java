package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class ConstructArr {


    @Test
    public void test() {
        int[] a = {1, 2, 3, 4, 5};
        int[] res = constructArr(a);

        Arrays.stream(res).forEach(x -> System.out.println(x));

    }

    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 0) {
            return new int[0];
        }

        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }

        int temp =1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i]=res[i]*temp;
        }

        return res;
    }
}
