package com.yous.learningtwo.host.Demo;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author syou
 * @date 2018/9/18.
 */
public class ThreadDemo {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    static String[] d = new String[]{"ds1", "ds2", "ds3"};

    public static void main(String[] args) {
      int a=  Math.abs(Integer.MIN_VALUE);

        System.out.println(a);
        System.out.println(run("123czxczx"));


    }


    public static String run(String key) {
        return d[Math.abs(key.hashCode()) % d.length];

    }

    ;
}
