package com.yous.learningtwo.host.AbstractClass;

/**
 * @author syou
 * @date 2019/5/13.
 */
public class Man extends AbstractPerson {
    public Man(){
        System.out.println("man...");
    }
    @Override
    public String getName() {
        return "Man name";
    }


    @Override
    public int getId() {
        return 456;
    }
}
