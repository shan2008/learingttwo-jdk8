package com.yous.learningtwo.host;

import java.util.*;

/**
 * @author syou
 * @date 2018/7/27.
 */
public class AnonymousClass {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(AnonymousClass.this.value);
            }
        };
        r.run();
    }

    public static void main(String... args) {
        Collection<Integer> collection = new ArrayList<>();

        boolean flag = true;
        boolean aa =Collections.addAll(collection, 1, 2, 3, 4);
    }



    private static boolean test(Collection<Integer> list,Integer... datas){
        boolean result=false;
        for (int a : datas){
            result |= (a==3?false:list.add(a));
            System.out.println(result);
        }


        return result;
    }
}
