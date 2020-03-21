package com.yous.learningtwo.host.algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author syou
 * @date 2020/2/16.
 */
public class ArrayUtils {


    public static int[] generateArray(int size) {
        int[] array = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }

        return array;
    }


    public static void print(int[] array) {
        if (array == null) {
            return;
        }
        String string = Arrays.stream(array).boxed()
                .map(x -> String.valueOf(x))
                .collect(Collectors.joining(","));

        System.out.println(string);
    }
}
