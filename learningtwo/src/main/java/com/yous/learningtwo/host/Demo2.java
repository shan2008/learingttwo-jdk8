package com.yous.learningtwo.host;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

/**
 * Created by syou on 2017/8/7.
 */
public class Demo2 {

    public static void main(String[] args) {
/*
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        list.add("you");
        list.add("shan");
        List<String>  a= list.subList(0, 3);
        list.forEach(System.out::println);
        a.remove(0);
        list.forEach(System.out::println);*/

        //subList 修改元素，会修改原list ,截取subList 之后，修改原list则子串失效
        //subList 转ArraryList

        List<String> list=null;
        init(list);

        System.out.println(list != null);

        Function<String,Integer> a=new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };


    }


    private  static void  init(List<String> list){
        list=new ArrayList<>();
    }
}
