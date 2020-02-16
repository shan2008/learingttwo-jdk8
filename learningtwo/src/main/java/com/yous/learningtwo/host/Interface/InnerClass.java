package com.yous.learningtwo.host.Interface;

/**
 * @author syou
 * @date 2019/6/21.
 */
public class InnerClass {
    private int anInt = 1;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }


    class Inner1 {

    }


   public static class Inner2{

    }
}
