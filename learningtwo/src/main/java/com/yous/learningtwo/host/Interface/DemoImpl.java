package com.yous.learningtwo.host.Interface;

/**
 * @author syou
 * @date 2019/6/21.
 */
public class DemoImpl implements DefaultDemo ,DefaultDemo2{

    @Override
    public void say() {

    }

    @Override
    public void out() {
        System.out.println("DemoImpl...");
    }


}
