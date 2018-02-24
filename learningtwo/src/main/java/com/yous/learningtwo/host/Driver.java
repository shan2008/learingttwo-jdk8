package com.yous.learningtwo.host;

/**
 * Created by syou on 2018/2/3.
 */
public class Driver {

    public Driver(){
        System.out.println("构造函数执行了...");
    }

    static {
        System.out.println("加载静态代码块...");
    }

    public static void print (){
        System.out.println("print ....");
    }
}
