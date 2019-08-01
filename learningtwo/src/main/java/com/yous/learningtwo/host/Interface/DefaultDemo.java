package com.yous.learningtwo.host.Interface;

/**
 * @author syou
 * @date 2019/6/21.
 */
public interface DefaultDemo {

    default void say(){
        System.out.println("DefaultDemo...");
    }

    static String getDemoName(){
        return "DefaultDemo";
    }

    void out();
}
