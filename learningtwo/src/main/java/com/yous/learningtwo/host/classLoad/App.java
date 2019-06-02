package com.yous.learningtwo.host.classLoad;

import java.util.LinkedList;

/**
 * @author syou
 * @date 2018/9/13.
 */
public class App {

    public static void main(String[] args) throws Exception {

        Animal animal = new Dog();
        System.out.println(animal.getClass().getName());

        Animal animal1 = (Animal) animal;
        System.out.println(animal1.getClass().getName());


        Dog dog = new Dog();

        System.out.println(dog instanceof Animal);
        System.out.println(dog instanceof Dog);



    }
}
