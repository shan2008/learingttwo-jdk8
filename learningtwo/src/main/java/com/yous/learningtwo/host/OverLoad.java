package com.yous.learningtwo.host;

import java.util.Arrays;
import java.util.List;

/**
 * Created by syou on 2018/3/2.
 */
public class OverLoad {


    // private static int f(String  x){return 1; };
    //private static int f(int s){return 1;}

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c=3;
        Integer f=4;
        Long d=4L;
        System.out.println(a==b); //不会自动拆箱
        System.out.println(c==(a+b));




    }


}
