package com.yous.learningtwo.host.AbstractClass;

/**
 * @author syou
 * @date 2019/8/20.
 */
public class Dog extends Animal {

    @Override
    public String getName() {
        return "dog name";
    }

    public int getLegs(){
        return 4;
    }
}
