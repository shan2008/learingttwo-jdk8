package com.yous.learningtwo.host.proxy;

/**
 * @author syou
 * @date 2018/9/13.
 */
public class SuperCar implements Car {
    @Override
    public void brand() {
        System.out.println("超级跑车...");
    }

    @Override
    public void price() {
        System.out.println("价值500万...");
    }
}
