package com.yous.learningtwo.host;

import com.yous.learningtwo.host.extend.*;

/**
 * @author syou
 * @date 2019/5/3.
 */
public class BigCar extends Car {

    @Override
    public void  getCar(){

        System.out.println("bigcar......");
    }

    @Override
    public String getColor() {
        return "red";
    }

    @Override
    public int getWeel() {
        return 4;
    }
}
