package com.yous.learningtwo.host;

/**
 * @author syou
 * @date 2019/5/3.
 */
public abstract class Car {

    public void getCar() {
        System.out.println("car......");
    }

    public abstract String getColor();


    public int getWeel() {
        getWeels();

        return 0;
    }


    private void getWeels() {
        throw new RuntimeException("没有实现");
    }

}
