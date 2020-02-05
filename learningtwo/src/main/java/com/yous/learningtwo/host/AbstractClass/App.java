package com.yous.learningtwo.host.AbstractClass;

/**
 * @author syou
 * @date 2019/8/20.
 */
public class App {

    public static void main(String[] args) {


        Animal animal=new Animal();
        Dog dog=(Dog)animal;
        System.out.println(dog.getName());
    }
}
