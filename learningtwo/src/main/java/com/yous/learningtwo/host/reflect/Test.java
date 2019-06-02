package com.yous.learningtwo.host.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author syou
 * @date 2019/5/13.
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("com.yous.learningtwo.host.reflect.Friend");

        for (Constructor c : clazz.getDeclaredConstructors()) {
            System.out.println(c);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>");


        Constructor constructor = clazz.getDeclaredConstructor(int.class, String.class);

        constructor.setAccessible(true);
        Friend friend = (Friend) constructor.newInstance(1, "shan");
        System.out.println(friend.getId() + " " + friend.getName());
    }
}
